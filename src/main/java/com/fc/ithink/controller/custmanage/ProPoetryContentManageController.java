package com.fc.ithink.controller.custmanage;

import com.fc.ithink.common.base.BaseController;
import com.fc.ithink.common.domain.AjaxResult;
import com.fc.ithink.model.auto.ProPoetryContent;
import com.fc.ithink.model.custom.Tablepar;
import com.fc.ithink.service.ProPoetryContentService;
import com.fc.ithink.util.StringUtils;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Api(value = "诗歌创作内容")
@Controller
@RequestMapping("/ProPoetryContentManageController")
public class ProPoetryContentManageController extends BaseController{
	
	private String prefix = "manage/proPoetryContent";
	@Autowired
	private ProPoetryContentService proPoetryContentService;

	/**
	 * 分页跳转
	 */
	@ApiOperation(value = "分页跳转", notes = "分页跳转")
	@GetMapping("/view")
	@RequiresPermissions("gen:proPoetryContentManage:view")
	public String view(ModelMap model)
	{
		String str="诗歌创作内容";
		return prefix + "/list";
	}

	/**
	 * 分页查询
	 */
	//@Log(title = "诗歌创作内容集合查询", action = "111")
	@ApiOperation(value = "分页查询", notes = "分页查询")
	@GetMapping("/list")
	@RequiresPermissions("gen:proPoetryContentManage:list")
	@ResponseBody
	public Object list(Tablepar tablepar,ProPoetryContent record){
		if(!StringUtils.isEmpty(tablepar.getSearchText())){
			record.setTitle(tablepar.getSearchText());
		}
		record.setIsDel(0);
		PageInfo<ProPoetryContent> page=proPoetryContentService.queryContentList(tablepar,record) ;
		return  pageTable(page.getList(),page.getTotal());
	}





	/**
	 * 分页跳转
	 */
	@ApiOperation(value = "分页跳转", notes = "分页跳转")
	@GetMapping("/view3")
	@RequiresPermissions("gen:proPoetryContentManage:view")
	public String view3(ModelMap model,Long no)
	{
		model.addAttribute("charpId",no);
		String str="诗歌创作内容";
		return prefix + "/list3";
	}

	/**
	 * 分页查询
	 */
	//@Log(title = "诗歌作品分集集合查询", action = "111")
	@ApiOperation(value = "分页查询", notes = "分页查询")
	@GetMapping("/list3")
	@RequiresPermissions("gen:proPoetryContentManage:look")
	@ResponseBody
	public Object list3(Tablepar tablepar,ProPoetryContent record,Long charpId){
		record.setCharpId(charpId);
		record.setIsDel(0);
		if(!StringUtils.isEmpty(tablepar.getSearchText())){
			record.setTitle(tablepar.getSearchText());
		}
		PageInfo<ProPoetryContent> page=proPoetryContentService.queryContentList(tablepar,record) ;
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
	 * 新增
	 */
	//@Log(title = "诗歌创作内容新增", action = "111")
	@ApiOperation(value = "新增", notes = "新增")
	@PostMapping("/add")
	@RequiresPermissions("gen:proPoetryContentManage:add")
	@ResponseBody
	public AjaxResult add(ProPoetryContent proPoetryContent){
		int b=proPoetryContentService.insertSelective(proPoetryContent);
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
	//@Log(title = "诗歌创作内容删除", action = "111")
	@ApiOperation(value = "删除", notes = "删除")
	@DeleteMapping("/remove")
	@RequiresPermissions("gen:proPoetryContentManage:remove")
	@ResponseBody
	public AjaxResult remove(String ids){

		int b=proPoetryContentService.deleteBatchByPrimaryKey(ids);
		if(b>0){
			return success();
		}else{
			return error();
		}
	}

	/**
	 * 检查Name
	 * @param tsysUser
	 * @return
	 */
/*	@ApiOperation(value = "检查Name唯一", notes = "检查Name唯一")
	@PostMapping("/checkNameUnique")
	@ResponseBody
	public int checkNameUnique(ProPoetryContent proPoetryContent){
		int b=proPoetryContentService.checkNameUnique(proPoetryContent);
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

		mmap.put("ProPoetryContent", proPoetryContentService.selectUserContentByPrimaryKey(id));

		return prefix + "/edit";
	}

	/**
	 * 修改保存
	 */
	//@Log(title = "诗歌创作内容修改", action = "111")
	@ApiOperation(value = "修改保存", notes = "修改保存")
	@RequiresPermissions("gen:proPoetryContentManage:edit")
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(ProPoetryContent record)
	{
		return toAjax(proPoetryContentService.updateByPrimaryKeySelective(record));
	}


	/**
	 * 根据主键查询
	 *
	 * @param id
	 * @return
	 */
	@ApiOperation(value = "根据id查询唯一", notes = "根据id查询唯一")
	@PostMapping("/get/{id}")
	public ProPoetryContent edit(@PathVariable("id") String id) {
		return proPoetryContentService.selectByPrimaryKey(id);
	}



}
