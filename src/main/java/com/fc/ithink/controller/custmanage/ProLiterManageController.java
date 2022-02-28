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
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.util.*;

@Api(value = "文学创作信息表")
@Controller
@RequestMapping("/ProLiterManageController")
@Slf4j
public class ProLiterManageController extends BaseController {
	
	private String prefix = "manage/proLiter";
	@Autowired
	private ProLiterService proLiterService;
	@Autowired
	private ProCharptService proCharptService;
	@Autowired
	private ProSubTopicService proSubTopicService;
	@Autowired
	private ProCertificateService proCertificateService;
	@Autowired
	private SysUserService sysUserService;
	@Autowired
	private EmailService emailService;
	@Autowired
	private UserTnkcoinInfoService userTnkcoinInfoService;
	/**
	 * 分页跳转
	 */
	@ApiOperation(value = "分页跳转", notes = "分页跳转")
	@GetMapping("/view")
	@RequiresPermissions("gen:proLiterManage:view")
    public String view(ModelMap model)
    {	
		String str="文学创作信息表";
		 return prefix + "/list";
    }
	
	/**
	 * 分页查询
	 */
	//@Log(title = "文学创作信息表集合查询", action = "111")
	@ApiOperation(value = "分页查询", notes = "分页查询")
	@GetMapping("/list2")
	@RequiresPermissions("gen:proLiterManage:list2")
	@ResponseBody
	public Object list2(Tablepar tablepar, ProLiter record){
		record.setFinish(ProStatus.apply.getValue());
		record.setIsDel(0);
		PageInfo<ProLiter> page=proLiterService.list(tablepar,record) ;
		List<ProSubTopic> list = proSubTopicService.selectAllProSubTopic(new ProSubTopicExample());
		Map<String,Object> map = new HashMap<>();
		for (ProSubTopic proSubTopic : list){
			map.put(proSubTopic.getDn(),proSubTopic.getTopic());
		}
		for(ProLiter proLiter: page.getList()){
			proLiter.setSource((String)map.get(proLiter.getSource()));
		}
		return  pageTable(page.getList(),page.getTotal());
	}


	/**
	 * 分页跳转
	 */
	@ApiOperation(value = "分页跳转", notes = "分页跳转")
	@GetMapping("/view2")
	@RequiresPermissions("gen:proLiterManage:view2")
	public String view2(ModelMap model)
	{
		String str="文学管理";
		return prefix + "/list2";
	}
	/**
	 * 分页查询
	 */
	//@Log(title = "文学创作集集合查询", action = "111")
	@ApiOperation(value = "分页查询", notes = "分页查询")
	@GetMapping("/list")
	@RequiresPermissions("gen:proLiterManage:list")
	@ResponseBody
	public Object list(Tablepar tablepar,ProLiter record){

		PageInfo<ProLiter> page=proLiterService.list(tablepar,record) ;
		List<ProSubTopic> list = proSubTopicService.selectAllProSubTopic(new ProSubTopicExample());
		Map<String,Object> map = new HashMap<>();
		for (ProSubTopic proSubTopic : list){
			map.put(proSubTopic.getDn(),proSubTopic.getTopic());
		}
		for(ProLiter proLiter: page.getList()){
			proLiter.setSource((String)map.get(proLiter.getSource()));
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
        return prefix + "/add";
    }
	


	/**
	 * 通过
	 * @param ids
	 * @return
	 */
	//@Log(title = "文学作品集完成", action = "111")
	@ApiOperation(value = "通过", notes = "通过")
	@PostMapping("/finish")
	@RequiresPermissions("gen:proLiterManage:finish")
	@ResponseBody
	@Transactional
	public AjaxResult finish(String ids) throws Exception {
		/**
		 * Step 1 查询作品详情
		 */
		ProLiter proLiter = proLiterService.selectByPrimaryKey(ids);
		/**
		 * Step 2 查询作品申请详情
		 */
		List<ProCertificate> certificates = proCertificateService.selectByProNoAndSts(ids,"0");
		if(certificates==null||certificates.size()>1){
			return error("作品存在多次申请情况");
		}

		int reward = 0;

		int tnkcoin =0;

		Map<String,Object> rewardMap = proLiterService.selectRewardSum(proLiter.getCreateBy());

		if(rewardMap!=null&&rewardMap.get("reward")!=null){
			reward = Integer.parseInt(rewardMap.get("reward").toString());
		}
		UserTnkcoinInfo tnkcoinInfo = userTnkcoinInfoService.selectUserTnkcoinByuserid(proLiter.getCreateBy());

		if(tnkcoinInfo!=null){
			tnkcoin = tnkcoinInfo.getTnkcoin();
		}
		if(tnkcoin<reward){
			return error("作品奖励Tnk币不足");
		}

		String userId = proLiter.getCreateBy();
		Map<String, Object> map = new HashMap<>();
		map.put("ids", ids);
		map.put("no", new TextRenderData("000000", proLiter.getUid()));
		map.put("name", new TextRenderData("000000", proLiter.getName()));
		map.put("copyright", new TextRenderData("000000", proLiter.getCopyright()+""));
		map.put("reward", new TextRenderData("000000", proLiter.getReward()+""));
		map.put("date", new TextRenderData("000000", DateUtils.dateTimeNow("yyyy/MM/dd")));

		map.put("data", certificates.get(0).getSignature());

		String pdfFilePath = userId+"-"+ids+".pdf";
		log.info("pdfFilePath1:"+pdfFilePath);
		pdfFilePath = PdfUtil.genContractPdf(map,pdfFilePath);
		log.info("pdfFilePathEnd:"+pdfFilePath);
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

		ProLiter data = new ProLiter();
		data.setUid(ids);
		data.setFinish(ProStatus.noFinish.getValue());//
		int b = proLiterService.updateByPrimaryKeySelective(data);
		if(b>0){
			TsysUser tsysUser = sysUserService.selectUserInfoByUserId(userId);
			ProCharpt proCharpt = new ProCharpt();
			proCharpt.setFinish(0);
			//proCharpt.setBookId(ids);
			ProCharptExample example = new ProCharptExample();
			ProCharptExample.Criteria criteria = example.createCriteria();

			criteria.andBookIdEqualTo(ids);
			criteria.andIsDelEqualTo(0);

			proCharptService.updateByExampleSelective(proCharpt,example);

			emailService.sendEmail(tsysUser.getEmail(),"我思 |  作品上架审核通知",true,proLiter.getName(),ids,files);

			return success();
		}else{
			return error();
		}
	}

	/**
	 * 打回
	 * @param ids
	 * @return
	 */
	//@Log(title = "绘画作品集上线", action = "111")
	@ApiOperation(value = "打回", notes = "打回")
	@PostMapping("/lose")
	@RequiresPermissions("gen:proPaintManage:lose")
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

		//保存签名打回状态
		ProCertificate proc = new ProCertificate();

		proc.setSignStatus("-1");
		proc.setCreateBy(ShiroUtils.getUserId());
		proc.setLUpdateDat(DateUtils.getNowDate());
		proCertificateService.updateSignStatusByProNo(ids,"0",proc);


		/**
		 * Step 2 查询作品信息
		 */
		ProLiter proLiter = proLiterService.selectByPrimaryKey(ids);

		ProLiter data = new ProLiter();
		data.setUid(ids);
		data.setFinish(ProStatus.edit.getValue());//
		int b = proLiterService.updateByPrimaryKeySelective(data);
		if(b>0){
			TsysUser tsysUser = sysUserService.selectUserInfoByUserId(userId);
			if(tsysUser==null){
				return error("用户不存在");
			}
			emailService.sendEmail(tsysUser.getEmail(),"我思 |  作品上架审核通知",false,proLiter.getName(),ids,null);

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
	//@Log(title = "文学创作信息表删除", action = "111")
	@ApiOperation(value = "删除", notes = "删除")
	@DeleteMapping("/remove")
	@RequiresPermissions("gen:proLiterManage:remove")
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
	 * 检查Name
	 * @param proLiter
	 * @return
	 */
	@ApiOperation(value = "检查Name唯一", notes = "检查Name唯一")
	@PostMapping("/checkNameUnique")
	@ResponseBody
	public int checkNameUnique(ProLiter proLiter){
		int b=proLiterService.checkNameUnique(proLiter);
		if(b>0){
			return 1;
		}else{
			return 0;
		}
	}
	
	
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

		mmap.put("ProLiter", proLiterService.selectByPrimaryKey(id));
		List<ProSubTopic> list = proSubTopicService.selectAllProSubTopic(new ProSubTopicExample());
		mmap.put("list", list);
		return prefix + "/edit";
    }
	
	/**
     * 置顶
     */
    //@Log(title = "文学创作信息表修改", action = "111")
    @ApiOperation(value = "修改保存", notes = "修改保存")
    @RequiresPermissions("gen:proLiterManage:edit")
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ProLiter record)
    {
		ProLiter data = new ProLiter();
		
		data.setUid(record.getUid());
		data.setIsDel(record.getIsDel());
		data.setIsTop(record.getIsTop()==0?1:0);
        return toAjax(proLiterService.updateByPrimaryKeySelective(data));
    }

    
    /**
   	 * 根据主键查询
   	 * 
   	 * @param id
   	 * @return
   	 */
   	@ApiOperation(value = "根据id查询唯一", notes = "根据id查询唯一")
   	@PostMapping("/get/{id}")
   	public ProLiter edit(@PathVariable("id") String id) {
   		return proLiterService.selectByPrimaryKey(id);
   	}



	
}
