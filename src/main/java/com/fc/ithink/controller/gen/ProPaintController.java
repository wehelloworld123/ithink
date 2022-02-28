package com.fc.ithink.controller.gen;

import cn.hutool.core.util.StrUtil;
import com.fc.ithink.common.base.BaseController;
import com.fc.ithink.common.conf.V2Config;
import com.fc.ithink.common.constant.ProjectConstant;
import com.fc.ithink.common.domain.AjaxResult;
import com.fc.ithink.common.enums.FileEnum;
import com.fc.ithink.common.enums.ProStatus;
import com.fc.ithink.common.enums.RecomType;
import com.fc.ithink.model.auto.*;
import com.fc.ithink.model.custom.Tablepar;
import com.fc.ithink.service.*;
import com.fc.ithink.shiro.util.ShiroUtils;
import com.fc.ithink.util.*;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.*;

/**
 * 绘画创作集Controller
 * @ClassName: ProPaintController
 * @author xy
 * @date 2021-06-07 14:26:23
 */
@Api(value = "绘画创作集")
@Controller
@RequestMapping("/ProPaintController")
public class ProPaintController extends BaseController{
	
	private String prefix = "gen/proPaint";

	@Autowired
	private ProPaintService proPaintService;

	@Autowired
	private ProPaintPartService proPaintPartService;
	@Autowired
	private ProSaleService proSaleService;

	@Autowired
	private ProSubTopicService proSubTopicService;

	@Autowired
	private ProCertificateService proCertificateService;
	/**
	 * 分页跳转
	 */
	@ApiOperation(value = "分页跳转", notes = "分页跳转")
	@GetMapping("/view")
	@RequiresPermissions("gen:proPaint:view")
	public String view(ModelMap model)
	{
		String str="绘画创作集";
		List<ProSubTopic> list = proSubTopicService.selectAllProSubTopic(new ProSubTopicExample());
		model.put("list", list);
		return prefix + "/list";
	}

	/**
	 * 完成
	 * @param ids
	 * @return
	 */
	//@Log(title = "绘画作品集完成", action = "111")
	@ApiOperation(value = "完成", notes = "完成")
	@PostMapping("/finish")
	@RequiresPermissions("gen:proPaint:finish")
	@ResponseBody
	@Transactional
	public AjaxResult finish(String ids){
		ProPaint data = new ProPaint();
		data.setUid(ids);

		Map<String,Object> map = proPaintService.selectFinPartCount(data);
		if(map!=null&&map.get("count")==map.get("section")) {
			data.setFinish(ProStatus.finish.getValue());
			int b = proPaintService.updateByPrimaryKeySelective(data);
			if (b > 0) {
				ProPaint proPaint = proPaintService.selectByPrimaryKey(ids);
				ProSale proSale = new ProSale();
				proSale.setProNo(proPaint.getUid());
				proSale.setCreateTyp(proPaint.getKind());
				proSale.setTyp(RecomType.PAINTING.getValue());
				proSale.setTitle(proPaint.getName());
				proSale.setSeter(proPaint.getSeter());
				proSale.setCover(proPaint.getCover());
				proSale.setLabel(proPaint.getPurpose());
				proSale.setDescription(proPaint.getDescription());
				proSale.setSaleStatus("0");
				proSaleService.insertSelective(proSale);
				return success();
			} else {
				return error();
			}
		}else{
			return error();
		}
	}

	/**
	 * 上线
	 * @param id
	 * @return
	 */
	//@Log(title = "绘画作品集上线", action = "111")
	@ApiOperation(value = "上线", notes = "上线")
	@RequestMapping("/apply")
	@RequiresPermissions("gen:proPaint:apply")
	@ResponseBody
	@Transactional
	public AjaxResult apply(HttpServletRequest request, HttpServletResponse response, String id, String data){

		ProPaint proPaint = proPaintService.selectByPrimaryKey(id);
		if(!proPaint.getFinish().equals(ProStatus.edit.getValue())) {
			return error("不符合上架条件");
		}
		List<ProCertificate> certificates = proCertificateService.selectByProNoAndSts(id,"0");
		if(certificates==null||certificates.size()>1){
			return error("作品已提交申请");
		}
		String deviceInfo = AgentUserKit.getDeviceInfo(request);

		Date curDate = DateUtils.getNowDate();
		ProCertificate proc = new ProCertificate();
		proc.setSignature(data);
		proc.setProNo(id);
		proc.setCertid(ProjectConstant.CONTRACT_PREFIX+ SnowflakeIdWorker.getUUID());
		proc.setIpaddress(IpAddressUtils.getInternetIp());
		proc.setClientInfo(deviceInfo);
		proc.setSignStatus("0");
		proc.setCreateBy(ShiroUtils.getUserId());
		proc.setCreateTim(curDate);
		proc.setLUpdateDat(curDate);
		proc.setCreateDat(new Date());
		proc.setIsDel(0);

		proCertificateService.insertSelective(proc);
		ProPaint paint = new ProPaint();
		paint.setUid(id);
		paint.setFinish(ProStatus.apply.getValue());//
		int b = proPaintService.updateByPrimaryKeySelective(paint);
		if(b>0){
			return success();
		}else{
			return error();
		}
	}


	/**
	 * 分页查询
	 */
	//@Log(title = "绘画创作集集合查询", action = "111")
	@ApiOperation(value = "分页查询", notes = "分页查询")
	@GetMapping("/list")
	@RequiresPermissions("gen:proPaint:list")
	@ResponseBody
	public Object list(Tablepar tablepar,ProPaint record){
		record.setCreateBy(ShiroUtils.getUserId());
		record.setIsDel(0);
		//搜索
		if(StrUtil.isNotEmpty(tablepar.getSearchText())) {//小窗体
			record.setName(tablepar.getSearchText());
		}
		PageInfo<ProPaint> page=proPaintService.list(tablepar,record) ;
		List<ProSubTopic> list = proSubTopicService.selectAllProSubTopic(new ProSubTopicExample());
		Map<String,Object> map = new HashMap<>();
		for (ProSubTopic proSubTopic : list){
			map.put(proSubTopic.getDn(),proSubTopic.getTopic());
		}
		for(ProPaint proPaint: page.getList()){
			proPaint.setSource((String)map.get(proPaint.getSource()));
		}
		return  pageTable(page.getList(),page.getTotal());
	}

	/**
	 * 新增跳转
	 */
	@ApiOperation(value = "新增跳转", notes = "新增跳转")
	@GetMapping("/add")
	public String add(ModelMap modelMap)
	{
		List<ProSubTopic> list = proSubTopicService.selectAllProSubTopic(new ProSubTopicExample());
		modelMap.put("list", list);
		return prefix + "/add";
	}

	/**
	 * 新增
	 */
	//@Log(title = "绘画创作集新增", action = "111")
	@ApiOperation(value = "新增", notes = "新增")
	@PostMapping("/add")
	@RequiresPermissions("gen:proPaint:add")
	@ResponseBody
	@Transactional
	public AjaxResult add(ProPaint proPaint) throws Exception {
		//添加雪花主键id
		String uid = SnowflakeIdWorker.getUUID();

		Date now = DateUtils.getNowDate();//当前时间


		String userId = ShiroUtils.getUserId();
		proPaint.setUid(ProjectConstant.PAINTINGPREFIX+ uid);

		String url ="?id="+uid+"&type=0";//生成二维码内容
		String qrFileName = "P"+DateUtils.dateTimeNow()+"code.jpg";//生成二维码文件名

		QRCodeUtil.encode(url, null, V2Config.getDefaultBaseDir(),qrFileName,false);
		String fileUrl = CosClientUtil.uploadFile("/"+ FileEnum.valueOfString("6")+"/"+userId+"/"+qrFileName,new File(V2Config.getDefaultBaseDir()+qrFileName));

		//String fileUrl = V2Config.getDefaultBaseDir()+qrFileName;//二维码请求路径

		proPaint.setQrCode(fileUrl);
		proPaint.setCreateBy(userId);
		proPaint.setCreateDat(now);
		proPaint.setLUpdateDat(now);
		proPaint.setIsDel(0);
		proPaint.setFinish(ProStatus.edit.getValue());
		int b=proPaintService.insertSelective(proPaint);

		List<ProPaintPart> list = new ArrayList<>();

		for(int i = 0;i<proPaint.getParts();i++){
			ProPaintPart data = new ProPaintPart();
			data.setSubject("主卷"+i+1);
			data.setPartType(proPaint.getKind());
			data.setPaintId(ProjectConstant.PAINTINGPREFIX+ uid);
			data.setRoot(1);//根目录
			data.setRootId(new Long(0));
			data.setRootOrd(i+1);
			data.setFinish(-1);//未编辑
			data.setCreateBy(ShiroUtils.getUserId());
			data.setIsDel(0);
			data.setCreateDat(now);
			data.setLUpdateDat(now);
			list.add(data);
		}
		proPaintPartService.insertSelective(list);

		if(b>0){
			return success();
		}else{
			return error();
		}
	}
	/**
	 * 文件上传
	 * @param file
	 * @return
	 * @author fuce
	 * @Date 2019年11月20日 下午10:18:49
	 */
	//@Log(title = "文件上传", action = "1")
	/*@ApiOperation(value = "文件上传", notes = "文件上传")
	@PostMapping("/upload")
	@ResponseBody
	public AjaxResult updateAvatar(HttpServletRequest request, HttpServletResponse response)
	{

		try
		{
			request.setCharacterEncoding("UTF-8");

			Map<String, Object> json = new HashMap<String, Object>();
			MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

			*//** 页面控件的文件流* *//*
			MultipartFile file = null;
			Map map =multipartRequest.getFileMap();
			for (Iterator i = map.keySet().iterator(); i.hasNext();) {
				Object obj = i.next();
				file=(MultipartFile) map.get(obj);
				if (!file.isEmpty())
				{
					//保存文件
					String fileUrl=sysDatasService.saveImage(file);
					if(fileUrl!=null){
						return AjaxResult.successData(200, fileUrl);
					}
				}else {
					return error();
				}
			}
			return error();
		}
		catch (Exception e)
		{
			return error(e.getMessage());
		}
	}*/
	/**
	 * 删除
	 * @param ids
	 * @return
	 */
	//@Log(title = "绘画创作集删除", action = "111")
	@ApiOperation(value = "删除", notes = "删除")
	@DeleteMapping("/remove")
	@RequiresPermissions("gen:proPaint:remove")
	@ResponseBody
	public AjaxResult remove(String ids){
		int b=proPaintService.deleteBatchByPrimaryKey(ids);
		if(b>0){
			return success();
		}else{
			return error();
		}
	}

	/**
	 * 检查Name
	 * @param proPaint
	 * @return
	 */
/*	@ApiOperation(value = "检查Name唯一", notes = "检查Name唯一")
	@PostMapping("/checkNameUnique")
	@ResponseBody
	public int checkNameUnique(ProPaint proPaint){
		int b=proPaintService.checkNameUnique(proPaint);
		if(b>0){
			return 1;
		}else{
			return 0;
		}
	}*/


	/**
	 * 修改跳转
	 * @param id
	 * @param mmap
	 * @return
	 */
	@ApiOperation(value = "修改跳转", notes = "修改跳转")
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") String id, ModelMap mmap)
	{
		mmap.put("ProPaint", proPaintService.selectByPrimaryKey(id));
		List<ProSubTopic> list = proSubTopicService.selectAllProSubTopic(new ProSubTopicExample());
		mmap.put("list", list);
		return prefix + "/edit";
	}

	/**
	 * 授权
	 * @param id
	 * @param mmap
	 * @return
	 */
	@ApiOperation(value = "修改跳转", notes = "修改跳转")
	@RequestMapping("/auth/{id}")
	public String auth(@PathVariable("id") String id, ModelMap mmap)
	{
		mmap.put("product", proPaintService.selectByPrimaryKey(id));

		return prefix + "/edit2";
	}


	/**
	 * 修改保存
	 */
	//@Log(title = "绘画创作集修改", action = "111")
	@ApiOperation(value = "修改保存", notes = "修改保存")
	@RequiresPermissions("gen:proPaint:edit")
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(ProPaint record)
	{
		if(StringUtils.isEmpty(record.getCover())){
			record.setCover(null);
		}
		if(StringUtils.isEmpty(record.getExhibition())){
			record.setExhibition(null);
		}
		return toAjax(proPaintService.updateByPrimaryKeySelective(record));
	}


	/**
	 * 根据主键查询
	 *
	 * @param id
	 * @return
	 */
	@ApiOperation(value = "根据id查询唯一", notes = "根据id查询唯一")
	@PostMapping("/get/{id}")
	public ProPaint edit(@PathVariable("id") String id) {
		return proPaintService.selectByPrimaryKey(id);
	}

}
