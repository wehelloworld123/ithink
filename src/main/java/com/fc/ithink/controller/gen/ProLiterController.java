package com.fc.ithink.controller.gen;

import cn.hutool.core.util.StrUtil;
import com.fc.ithink.common.base.BaseController;
import com.fc.ithink.common.conf.V2Config;
import com.fc.ithink.common.constant.ProjectConstant;
import com.fc.ithink.common.domain.AjaxResult;
import com.fc.ithink.common.domain.ResultTable;
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
 * 文学创作信息表Controller
 * @ClassName: ProLiterController
 * @author xy
 * @date 2021-05-27 16:40:31
 */
@Api(value = "文学创作信息表")
@Controller
@RequestMapping("/ProLiterController")
public class ProLiterController extends BaseController{

	private String prefix = "gen/proLiter";

	@Autowired
	private ProLiterService proLiterService;
	@Autowired
	private ProSubTopicService proSubTopicService;
	@Autowired
	private ProCharptService proCharptService;
	@Autowired
	private V2Config v2Config;
	@Autowired
	private ProSaleService proSaleService;
	@Autowired
	private ProCertificateService proCertificateService;

	/**
	 * 文学创作信息表页面展示
	 * @param model
	 * @return String
	 * @author xy
	 */
	@ApiOperation(value = "分页跳转", notes = "分页跳转")
	@GetMapping("/view")
	@RequiresPermissions("gen:proLiter:view")
    public String view(ModelMap model)
    {
        return prefix + "/list";
    }

	/**
	 * list集合
	 * @param tablepar
	 * @param proLiter
	 * @return
	 */
	//@Log(title = "文学创作信息表", action = "111")
	@ApiOperation(value = "分页跳转", notes = "分页跳转")
	@GetMapping("/list")
	@RequiresPermissions("gen:proLiter:list")
	@ResponseBody
	public ResultTable list(Tablepar tablepar,ProLiter proLiter){
		proLiter.setCreateBy(ShiroUtils.getUserId());
		proLiter.setIsDel(0);
		//搜索
		if(StrUtil.isNotEmpty(tablepar.getSearchText())) {//小窗体
			proLiter.setName(tablepar.getSearchText());
		}
		PageInfo<ProLiter> page=proLiterService.list(tablepar,proLiter) ;

		List<ProSubTopic> list = proSubTopicService.selectAllProSubTopic(new ProSubTopicExample());
		Map<String,Object> map = new HashMap<>();
		for (ProSubTopic proSubTopic : list){
			map.put(proSubTopic.getDn(),proSubTopic.getTopic());
		}
		for(ProLiter proLiter1: page.getList()){
			proLiter1.setSource((String)map.get(proLiter.getSource()));
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
		modelMap.put("list",list);
        return prefix + "/add";
    }

    /**
     * 新增保存
     * @param
     * @return
     */
	//@Log(title = "文学创作信息表新增", action = "111")
	@ApiOperation(value = "新增", notes = "新增")
	@PostMapping("/add")
	@RequiresPermissions("gen:proLiter:add")
	@Transactional
	@ResponseBody
	public AjaxResult add(ProLiter proLiter) throws Exception {
		//添加雪花主键id
		String uid = SnowflakeIdWorker.getUUID();

		Date now = DateUtils.getNowDate();//当前时间

		String userId = ShiroUtils.getUserId();

		proLiter.setUid(ProjectConstant.LITERPREFIX+ uid);

		String url ="?id="+uid+"&type="+ RecomType.LITERATURE.getValue();//生成二维码内容
		String qrFileName = "L"+DateUtils.dateTimeNow()+"code.jpg";//生成二维码文件名

		QRCodeUtil.encode(url, null, v2Config.getDefaultBaseDir(),qrFileName,false);

		String fileUrl = CosClientUtil.uploadFile("/"+ FileEnum.valueOfString("6")+"/"+userId+"/"+qrFileName,new File(v2Config.getDefaultBaseDir()+qrFileName));

		//String fileUrl = V2Config.getDefaultBaseDir()+qrFileName;//二维码请求路径

		proLiter.setQrCode(fileUrl);
		proLiter.setCreateBy(userId);
		proLiter.setCreateDat(now);
		proLiter.setLUpdateDat(now);
		proLiter.setIsDel(0);
		proLiter.setFinish(ProStatus.edit.getValue());
		int b=proLiterService.insertSelective(proLiter);

		List<ProCharpt> list = new ArrayList<>();

		for(int i = 0;i<proLiter.getCharpter();i++){
			ProCharpt data = new ProCharpt();
			data.setTitle("主章"+i+1);
			data.setChapType(proLiter.getTyp());
			data.setBookId(ProjectConstant.LITERPREFIX+ uid);
			data.setRoot(1);//根目录
			data.setRootId(new Long(0));
			data.setRootOrd(i+1);
			data.setFinish(ProStatus.edit.getValue());//未编辑
			data.setCreateBy(ShiroUtils.getUserId());
			data.setIsDel(0);
			data.setCreateDat(now);
			data.setLUpdateDat(now);
			list.add(data);
		}
		proCharptService.inserBathcSelective(list);

		if(b>0){
			return success();
		}else{
			return error();
		}
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
		mmap.put("product", proLiterService.selectByPrimaryKey(id));

		return prefix + "/edit2";
	}
	/**
	 * 上线
	 * @param id
	 * @return
	 */
	//@Log(title = "文学作品集上线", action = "111")
	@ApiOperation(value = "上线", notes = "上线")
	@RequestMapping("/apply")
	@RequiresPermissions("gen:proLiter:apply")
	@ResponseBody
	@Transactional
	public AjaxResult apply(HttpServletRequest request, HttpServletResponse response, String id, String data){

		ProLiter proLiter = proLiterService.selectByPrimaryKey(id);
		if(!proLiter.getFinish().equals(ProStatus.edit.getValue())) {
			return error("不符合上架条件");
		}
		List<ProCertificate> certificates = proCertificateService.selectByProNoAndSts(id,"0");
		if(certificates!=null&&certificates.size()>0){
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
		ProLiter liter = new ProLiter();
		liter.setUid(id);
		liter.setFinish(ProStatus.apply.getValue());//
		int b = proLiterService.updateByPrimaryKeySelective(liter);
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
	@RequiresPermissions("gen:proLiter:finish")
	@ResponseBody
	@Transactional
	public AjaxResult finish(String ids){
		ProLiter data = new ProLiter();
		data.setUid(ids);

		Map<String,Object> map = proLiterService.selectFinChapterCount(data);
		if(map!=null&&map.get("count")==map.get("charpter")) {
			data.setFinish(ProStatus.finish.getValue());
			int b = proLiterService.updateByPrimaryKeySelective(data);
			if (b > 0) {
				ProLiter proLiter = proLiterService.selectByPrimaryKey(ids);
				ProSale proSale = new ProSale();
				proSale.setProNo(proLiter.getUid());
				proSale.setTyp(RecomType.LITERATURE.getValue());
				proSale.setCreateTyp(proLiter.getKind()+"");
				proSale.setTitle(proLiter.getName());
				proSale.setCover(proLiter.getCover());
				proSale.setLabel(proLiter.getLabel());
				proSale.setDescription(proLiter.getDescription());
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
	 * 文学创作信息表删除
	 * @param ids
	 * @return
	 */
	//@Log(title = "文学创作信息表删除", action = "111")
	@ApiOperation(value = "删除", notes = "删除")
	@DeleteMapping("/remove")
	@RequiresPermissions("gen:proLiter:remove")
	@ResponseBody
	public AjaxResult remove(String ids){
		int b=proLiterService.deleteBatchByPrimaryKey(ids);
		if(b>0){
			return success();
		}else{
			return error();
		}

	}


	/**
	 * 修改跳转
	 * @param id
	 * @param map
	 * @return
	 */
	@ApiOperation(value = "修改跳转", notes = "修改跳转")
	@GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap map)
    {
        map.put("ProLiter", proLiterService.selectByPrimaryKey(id));
		List<ProSubTopic> list = proSubTopicService.selectAllProSubTopic(new ProSubTopicExample());
		map.put("list", list);
        return prefix + "/edit";
    }

	/**
     * 修改保存
     */
    //@Log(title = "文学创作信息表修改", action = "111")
	@ApiOperation(value = "修改保存", notes = "修改保存")
    @RequiresPermissions("gen:proLiter:edit")
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ProLiter proLiter)
    {
		if(StringUtils.isEmpty(proLiter.getCover())){
			proLiter.setCover(null);
		}
		if(StringUtils.isEmpty(proLiter.getExhibition())){
			proLiter.setExhibition(null);
		}
		return toAjax(proLiterService.updateByPrimaryKeySelective(proLiter));
    }




}
