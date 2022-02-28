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
 * 诗歌创作集Controller
 * @ClassName: ProPoetryController
 * @author xy
 * @date 2021-06-07 14:22:57
 */
@Api(value = "诗歌创作集")
@Controller
@RequestMapping("/ProPoetryController")
public class ProPoetryController extends BaseController{
	private String prefix = "gen/proPoetry";
	@Autowired
	private ProPoetryService proPoetryService;
	@Autowired
	private ProPoemsetService proPoemsetService;
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
	@RequiresPermissions("gen:proPoetry:view")
	public String view(ModelMap model)
	{
		String str="诗歌创作集";
		List<ProSubTopic> list = proSubTopicService.selectAllProSubTopic(new ProSubTopicExample());
		model.put("list", list);
		return prefix + "/list";
	}

	/**
	 * 分页查询
	 */
	//@Log(title = "诗歌创作集集合查询", action = "111")
	@ApiOperation(value = "分页查询", notes = "分页查询")
	@GetMapping("/list")
	@RequiresPermissions("gen:proPoetry:list")
	@ResponseBody
	public Object list(Tablepar tablepar,ProPoetry record){
		record.setCreateBy(ShiroUtils.getUserId());
		record.setIsDel(0);
		//搜索
		if(StrUtil.isNotEmpty(tablepar.getSearchText())) {//小窗体
			record.setName(tablepar.getSearchText());
		}
		PageInfo<ProPoetry> page=proPoetryService.list(tablepar,record) ;
		List<ProSubTopic> list = proSubTopicService.selectAllProSubTopic(new ProSubTopicExample());
		Map<String,Object> map = new HashMap<>();
		for (ProSubTopic proSubTopic : list){
			map.put(proSubTopic.getDn(),proSubTopic.getTopic());
		}
		for(ProPoetry proPoetry: page.getList()){
			proPoetry.setSource((String)map.get(proPoetry.getSource()));
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
	//@Log(title = "诗歌创作集新增", action = "111")
	@ApiOperation(value = "新增", notes = "新增")
	@PostMapping("/add")
	@RequiresPermissions("gen:proPoetry:add")
	@ResponseBody
	@Transactional
	public AjaxResult add(ProPoetry proPoetry) throws Exception {


		//添加雪花主键id
		String uid = SnowflakeIdWorker.getUUID();

		Date now = DateUtils.getNowDate();//当前时间

		String userId = ShiroUtils.getUserId();

		proPoetry.setUid(ProjectConstant.POETRYPREFIX+ uid);

		String url ="?id="+uid+"&type=0";//生成二维码内容
		String qrFileName = "E"+DateUtils.dateTimeNow()+"code.jpg";//生成二维码文件名

		QRCodeUtil.encode(url, null, V2Config.getDefaultBaseDir(),qrFileName,false);

		String fileUrl = CosClientUtil.uploadFile("/"+ FileEnum.valueOfString("6")+"/"+userId+"/"+qrFileName,new File(V2Config.getDefaultBaseDir()+qrFileName));
		//String fileUrl = V2Config.getDefaultBaseDir()+qrFileName;//二维码请求路径

		proPoetry.setQrCode(fileUrl);
		proPoetry.setCreateBy(userId);
		proPoetry.setCreateDat(now);
		proPoetry.setLUpdateDat(now);
		proPoetry.setIsDel(0);

		proPoetry.setFinish(ProStatus.edit.getValue());
		int b=proPoetryService.insertSelective(proPoetry);

		List<ProPoemset> list = new ArrayList<>();

		for(int i = 0;i<proPoetry.getCharpter();i++){
			ProPoemset data = new ProPoemset();
			//	data.setPartType(proPaint.getKind());
			data.setPoetryId(ProjectConstant.POETRYPREFIX+ uid);
			data.setCharpter("主篇"+(i+1));
			data.setRoot(1);//根目录
			data.setRootOrd(i+1);
			data.setChapType(proPoetry.getKind());
			data.setIsLock(0);
			data.setRootId(new Long(0));
			data.setFinish(ProStatus.edit.getValue());//未编辑
			data.setCreateBy(ShiroUtils.getUserId());
			data.setIsDel(0);
			data.setCreateDat(now);
			data.setLUpdateDat(now);
			list.add(data);
		}
		proPoemsetService.inserBathcSelective(list);

		if(b>0){
			return success();
		}else{
			return error();
		}
	}


	/**
	 * 完成
	 * @param ids
	 * @return
	 */
	//@Log(title = "诗歌作品集完成", action = "111")
	@ApiOperation(value = "完成", notes = "完成")
	@PostMapping("/finish")
	@RequiresPermissions("gen:proPoetry:finish")
	@ResponseBody
	@Transactional
	public AjaxResult finish(String ids){
		ProPoetry data = new ProPoetry();
		data.setUid(ids);

		Map<String,Object> map = proPoetryService.selectFinChaptCount(data);
		if(map!=null&&map.get("count")==map.get("section")) {
			data.setFinish(ProStatus.finish.getValue());
			int b = proPoetryService.updateByPrimaryKeySelective(data);
			if (b > 0) {
				ProPoetry proPoetry = proPoetryService.selectByPrimaryKey(ids);
				ProSale proSale = new ProSale();
				proSale.setProNo(proPoetry.getUid());
				proSale.setCreateTyp(proPoetry.getKind());
				proSale.setTyp(RecomType.POEMTY.getValue());
				proSale.setTitle(proPoetry.getName());
				proSale.setSeter(proPoetry.getSeter());
				proSale.setCover(proPoetry.getCover());
				proSale.setLabel(proPoetry.getPurpose());
				proSale.setDescription(proPoetry.getDescription());
				proSale.setSaleStatus("0");
				proSaleService.insertSelective(proSale);
				return success();
			} else {
				return error();
			}
		}else{
			return error("作品章节未完成");
		}
	}

	/**
	 * 上线
	 * @param id
	 * @return
	 */
	//@Log(title = "诗歌作品集上线", action = "111")
	@ApiOperation(value = "上线", notes = "上线")
	@PostMapping("/apply")
	@RequiresPermissions("gen:proPoetry:apply")
	@ResponseBody
	@Transactional
	public AjaxResult apply(HttpServletRequest request, HttpServletResponse response, String id, String data){
		ProPoetry proPoetry = new ProPoetry();
		if(!proPoetry.getFinish().equals(ProStatus.edit.getValue())) {
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
		ProPoetry poetry = new ProPoetry();
		poetry.setUid(id);
		poetry.setFinish(ProStatus.apply.getValue());//
		int b = proPoetryService.updateByPrimaryKeySelective(poetry);
		if(b>0){
			return success();

		}else{
			return error();
		}
	}

	/**
	 * 删除
	 * @param ids
	 * @return
	 */
	//@Log(title = "诗歌创作集删除", action = "111")
	@ApiOperation(value = "删除", notes = "删除")
	@DeleteMapping("/remove")
	@RequiresPermissions("gen:proPoetry:remove")
	@ResponseBody
	public AjaxResult remove(String ids){
		int b=proPoetryService.deleteBatchByPrimaryKey(ids);
		if(b>0){
			return success();
		}else{
			return error();
		}
	}

	/**
	 * 检查Name
	 * @param proPoetry
	 * @return
	 */
/*	@ApiOperation(value = "检查Name唯一", notes = "检查Name唯一")
	@PostMapping("/checkNameUnique")
	@ResponseBody
	public int checkNameUnique(ProPoetry proPoetry){
		int b=proPoetryService.checkNameUnique(proPoetry);
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
		mmap.put("ProPoetry", proPoetryService.selectByPrimaryKey(id));
		List<ProSubTopic> list = proSubTopicService.selectAllProSubTopic(new ProSubTopicExample());
		mmap.put("list", list);
		return prefix + "/edit";
	}

	/**
	 * 修改保存
	 */
	//@Log(title = "诗歌创作集修改", action = "111")
	@ApiOperation(value = "修改保存", notes = "修改保存")
	@RequiresPermissions("gen:proPoetry:edit")
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(ProPoetry record)
	{
		if(StringUtils.isEmpty(record.getCover())){
			record.setCover(null);
		}
		if(StringUtils.isEmpty(record.getExhibition())){
			record.setExhibition(null);
		}
		return toAjax(proPoetryService.updateByPrimaryKeySelective(record));
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
		mmap.put("product", proPoetryService.selectByPrimaryKey(id));

		return prefix + "/edit2";
	}

	/**
	 * 根据主键查询
	 *
	 * @param id
	 * @return
	 */
	@ApiOperation(value = "根据id查询唯一", notes = "根据id查询唯一")
	@PostMapping("/get/{id}")
	public ProPoetry edit(@PathVariable("id") String id) {
		return proPoetryService.selectByPrimaryKey(id);
	}


}
