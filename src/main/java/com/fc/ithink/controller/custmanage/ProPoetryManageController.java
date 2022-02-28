package com.fc.ithink.controller.custmanage;

import com.deepoove.poi.data.TextRenderData;
import com.fc.ithink.common.base.BaseController;
import com.fc.ithink.common.domain.AjaxResult;
import com.fc.ithink.common.enums.ProStatus;
import com.fc.ithink.model.auto.*;
import com.fc.ithink.model.custom.Tablepar;
import com.fc.ithink.service.*;
import com.fc.ithink.shiro.util.ShiroUtils;
import com.fc.ithink.util.DateUtils;
import com.fc.ithink.util.PdfUtil;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.util.*;

@Api(value = "诗歌创作集")
@Controller
@RequestMapping("/ProPoetryManageController")
public class ProPoetryManageController extends BaseController{
	
	private String prefix = "manage/proPoetry";
	@Autowired
	private ProPoetryService proPoetryService;
	@Autowired
	private ProPoemsetService proPoemsetService;
	@Autowired
	private ProSubTopicService proSubTopicService;
	@Autowired
	private SysUserService sysUserService;
	@Autowired
	private EmailService emailService;

	@Autowired
	private ProCertificateService proCertificateService;

	@Autowired
	private UserTnkcoinInfoService userTnkcoinInfoService;
	/**
	 * 分页跳转
	 */
	@ApiOperation(value = "分页跳转", notes = "分页跳转")
	@GetMapping("/view")
	@RequiresPermissions("gen:proPoetryManage:view")
    public String view(ModelMap model)
    {	
		String str="诗歌创作集";
		return prefix + "/list";
    }
	
	/**
	 * 分页查询
	 */
	//@Log(title = "诗歌创作集集合查询", action = "111")
	@ApiOperation(value = "分页查询", notes = "分页查询")
	@GetMapping("/list2")
	@RequiresPermissions("gen:proPoetryManage:list2")
	@ResponseBody
	public Object list2(Tablepar tablepar,ProPoetry record){
		record.setFinish(ProStatus.apply.getValue());
		record.setIsDel(0);
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
	 * 分页跳转
	 */
	@ApiOperation(value = "分页跳转", notes = "分页跳转")
	@GetMapping("/view2")
	@RequiresPermissions("gen:proPoetryManage:view")
	public String view2(ModelMap model)
	{
		String str="诗歌创作集";
		return prefix + "/list2";
	}

	/**
	 * 分页查询
	 */
	//@Log(title = "诗歌创作集集合查询", action = "111")
	@ApiOperation(value = "分页查询", notes = "分页查询")
	@GetMapping("/list")
	@RequiresPermissions("gen:proPoetryManage:list")
	@ResponseBody
	public Object list(Tablepar tablepar,ProPoetry record){
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
	 * 打回
	 * @param ids
	 * @return
	 */
	//@Log(title = "诗歌作品集打回", action = "111")
	@ApiOperation(value = "打回", notes = "打回")
	@PostMapping("/lose")
	@RequiresPermissions("gen:proPoetryManage:lose")
	@ResponseBody
	public AjaxResult lose(String ids) throws Exception {
		/**
		 * Step 1 查询作品上线审核表
		 */
		List<ProCertificate> certificates = proCertificateService.selectByProNoAndSts(ids,"0");
		if(certificates==null||certificates.size()>1){
			return error("作品存在多次申请情况");
		}
		String userId = certificates.get(0).getCreateBy();
		/**
		 * Step 2 查询作品信息
		 */
		ProPoetry proPoetry = proPoetryService.selectByPrimaryKey(ids);
		//保存签名打回状态
		ProPoetry data = new ProPoetry();
		data.setUid(ids);
		data.setFinish(ProStatus.edit.getValue());//

		int b = proPoetryService.updateByPrimaryKeySelective(data);
		if(b>0){
			TsysUser tsysUser = sysUserService.selectUserInfoByUserId(userId);
			if(tsysUser==null){
				return error("用户不存在");
			}
			emailService.sendEmail(tsysUser.getEmail(),"我思 |  作品上架审核通知",false,proPoetry.getName(),ids,null);

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
	@RequiresPermissions("gen:proPoetryManage:finish")
	@ResponseBody
	@Transactional
	public AjaxResult finish(String ids) throws Exception {
/**
 * Step 1 查询作品详情
 */
		ProPoetry proPoetry = proPoetryService.selectByPrimaryKey(ids);
		/**
		 * Step 2 查询作品申请详情
		 */
		List<ProCertificate> certificates = proCertificateService.selectByProNoAndSts(ids,"0");
		if(certificates==null||certificates.size()>1){
			return error("作品存在多次申请情况");
		}
		int reward = 0;

		int tnkcoin =0;

		Map<String,Object> rewardMap = proPoetryService.selectRewardSum(proPoetry.getCreateBy());

		if(rewardMap!=null&&rewardMap.get("reward")!=null){
			reward = Integer.parseInt(rewardMap.get("reward").toString());
		}
		UserTnkcoinInfo tnkcoinInfo = userTnkcoinInfoService.selectUserTnkcoinByuserid(proPoetry.getCreateBy());

		if(tnkcoinInfo!=null){
			tnkcoin = tnkcoinInfo.getTnkcoin();
		}
		if(tnkcoin<reward){
			return error("作品奖励Tnk币不足");
		}
		String userId = proPoetry.getCreateBy();
		Map<String, Object> map = new HashMap<>();
		map.put("ids", ids);
		map.put("no", new TextRenderData("000000", proPoetry.getUid()));
		map.put("name", new TextRenderData("000000", proPoetry.getName()));
		map.put("copyright", new TextRenderData("000000", proPoetry.getCopyright()+""));
		map.put("reward", new TextRenderData("000000", proPoetry.getReward()+""));
		map.put("date", new TextRenderData("000000", DateUtils.dateTimeNow("yyyy/MM/dd")));

		map.put("data", certificates.get(0).getSignature());

		String pdfFilePath = userId+"-"+ids+".pdf";
		pdfFilePath = PdfUtil.genContractPdf(map,pdfFilePath);
		Date curDate = DateUtils.getNowDate();
		//保存签名成功状态
		ProCertificate proc = new ProCertificate();
		proc.setCertid(certificates.get(0).getCertid());
		proc.setFilepath(pdfFilePath);
		proc.setSignStatus("1");
		proc.setSignTim(curDate);
		proc.setCreateBy(ShiroUtils.getUserId());
		proc.setLUpdateDat(curDate);
		proCertificateService.updateByPrimaryKeySelective(proc);
		/**
		 * Step 2 查询作品信息
		 */
		List<File> files = new ArrayList<>();
		files.add(new File(pdfFilePath));

		ProPoetry data = new ProPoetry();
		data.setUid(ids);
		data.setFinish(ProStatus.noFinish.getValue());//
		int b = proPoetryService.updateByPrimaryKeySelective(data);
		if(b>0){
			TsysUser tsysUser = sysUserService.selectUserInfoByUserId(userId);

			ProPoemset proPoemset = new ProPoemset();
			proPoemset.setFinish(0);
			//proPoemset.setPoetryId(ids);
			ProPoemsetExample example = new ProPoemsetExample();
			example.createCriteria().andPoetryIdEqualTo(ids);
			example.createCriteria().andIsDelEqualTo(0);
			proPoemsetService.updateByExampleSelective(proPoemset,example);

			emailService.sendEmail(tsysUser.getEmail(),"我思 |  作品上架审核通知",true,proPoetry.getName(),ids,files);

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
	@RequiresPermissions("gen:proPoetryManage:remove")
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
		mmap.put("list",list);
        return prefix + "/edit";
    }
	


	/**
	 * 修改保存
	 */
	//@Log(title = "文学创作信息表修改", action = "111")
	@ApiOperation(value = "修改保存", notes = "修改保存")
	@RequiresPermissions("gen:proPaintManage:edit")
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(ProPoetry record)
	{

		ProPoetry data = new ProPoetry();

		data.setUid(record.getUid());
		data.setIsDel(record.getIsDel());
		data.setIsTop(record.getIsTop()==0?1:0);
		return toAjax(proPoetryService.updateByPrimaryKeySelective(data));
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
