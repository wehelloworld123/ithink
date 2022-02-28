package com.fc.ithink.controller.custmanage;

import com.fc.ithink.common.base.BaseController;
import com.fc.ithink.common.domain.AjaxResult;
import com.fc.ithink.model.auto.ProContent;
import com.fc.ithink.model.custom.Tablepar;
import com.fc.ithink.service.ProContentService;
import com.fc.ithink.util.StringUtils;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Api(value = "文学创作内容")
@Controller
@RequestMapping("/ProContentManageController")
public class ProContentManageController extends BaseController{
	
	private String prefix = "manage/proContent";

	@Autowired
	private ProContentService proContentService;

	/**
	 * 分页跳转
	 */
	@ApiOperation(value = "分页跳转", notes = "分页跳转")
	@GetMapping("/view")
	@RequiresPermissions("gen:proContentManage:view")
	public String view(ModelMap model)
	{
		String str="文学创作内容";
		return prefix + "/list";
	}

	/**
	 * 分页查询
	 */
	//@Log(title = "文学创作内容集合查询", action = "111")
	@ApiOperation(value = "分页查询", notes = "分页查询")
	@GetMapping("/list")
	@RequiresPermissions("gen:proLiterContentManage:list")
	@ResponseBody
	public Object list(Tablepar tablepar,ProContent record){
		//record.setCreateBy(ShiroUtils.getUserId());
		record.setIsDel(0);
		if(StringUtils.isNotEmpty(tablepar.getSearchText())){
			record.setTitle(tablepar.getSearchText());
		}
		//record.setTyp(RecomType.LITERATURE.getValue());
		PageInfo<ProContent> page=proContentService.queryContentList(tablepar,record) ;
		return  pageTable(page.getList(),page.getTotal());
	}




	/**
	 * 分页跳转
	 */
	@ApiOperation(value = "分页跳转", notes = "分页跳转")
	@GetMapping("/view3")
	@RequiresPermissions("gen:proCharptManage:look")
	public String view3(ModelMap model,Long no)
	{
		model.addAttribute("charpId",no);
		String str="文章创作内容";
		return prefix + "/list3";
	}

	/**
	 * 分页查询
	 */
	//@Log(title = "诗歌作品分集集合查询", action = "111")
	@ApiOperation(value = "分页查询", notes = "分页查询")
	@GetMapping("/list3")
	@RequiresPermissions("gen:proLiterContentManage:look")
	@ResponseBody
	public Object list3(Tablepar tablepar,ProContent record,Long charpId){
		record.setCharpId(charpId);
		record.setIsDel(0);
		PageInfo<ProContent> page=proContentService.queryContentList(tablepar,record) ;
		return   pageTable(page.getList(),page.getTotal());
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
	//@Log(title = "文学创作内容新增", action = "111")
	@ApiOperation(value = "新增", notes = "新增")
	@PostMapping("/add")
	@RequiresPermissions("gen:proContentManage:add")
	@ResponseBody
	public AjaxResult add(ProContent proContent){
		int b=proContentService.insertSelective(proContent);
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
	//@Log(title = "文学创作内容删除", action = "111")
	@ApiOperation(value = "删除", notes = "删除")
	@DeleteMapping("/remove")
	@RequiresPermissions("gen:proLiterContentManage:remove")
	@ResponseBody
	public AjaxResult remove(String ids){
		int b=proContentService.deleteBatchByPrimaryKey(ids);
		if(b>0){
			return success();
		}else{
			return error();
		}
	}

	/**
	 * 检查Name
	 * @param proContent
	 * @return
	 */
/*	@ApiOperation(value = "检查Name唯一", notes = "检查Name唯一")
	@PostMapping("/checkNameUnique")
	@ResponseBody
	public int checkNameUnique(ProContent proContent){
		int b=proContentService.checkNameUnique(proContent);
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
	public String edit(@PathVariable("id") String id, String adopt,ModelMap mmap)
	{
		mmap.put("ProContent", proContentService.selectUserContentByPrimaryKey(id));
		if(adopt!=null&&"1".equals(adopt)){
			mmap.put("adopt","1");
		}else {
			mmap.put("adopt","0");
		}
		return prefix + "/edit";
	}

	/**
	 * 修改保存
	 */
	//@Log(title = "文学创作内容修改", action = "111")
	@ApiOperation(value = "修改保存", notes = "修改保存")
	@RequiresPermissions("gen:proContentManage:edit")
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(ProContent record)
	{
		return toAjax(proContentService.updateByPrimaryKeySelective(record));
	}


	/**
	 * 根据主键查询
	 *
	 * @param id
	 * @return
	 */
	@ApiOperation(value = "根据id查询唯一", notes = "根据id查询唯一")
	@PostMapping("/get/{id}")
	public ProContent edit(@PathVariable("id") String id) {
		return proContentService.selectByPrimaryKey(id);
	}




}
