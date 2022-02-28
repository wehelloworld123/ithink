package com.fc.ithink.controller.custmanage;

import com.fc.ithink.common.base.BaseController;
import com.fc.ithink.common.domain.AjaxResult;
import com.fc.ithink.model.auto.ProPaintContent;
import com.fc.ithink.model.custom.Tablepar;
import com.fc.ithink.service.ProPaintContentService;
import com.fc.ithink.util.DateUtils;
import com.fc.ithink.util.StringUtils;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Api(value = "绘画创作内容")
@Controller
@RequestMapping("/ProPaintContentManageController")
public class ProPaintContentManageController extends BaseController{
	
	private String prefix = "manage/proPaintContent";
	@Autowired
	private ProPaintContentService proPaintContentService;

	/**
	 * 分页跳转
	 */
	@ApiOperation(value = "分页跳转", notes = "分页跳转")
	@GetMapping("/view")
	@RequiresPermissions("gen:proPaintContentManage:view")
	public String view(ModelMap model)
	{
		String str="绘画创作内容管理";
		return prefix + "/list";
	}

	/**
	 * 分页查询
	 */
	//@Log(title = "绘画创作内容集合查询", action = "111")
	@ApiOperation(value = "分页查询", notes = "分页查询")
	@GetMapping("/list")
	@RequiresPermissions("gen:proPaintContentManage:list")
	@ResponseBody
	public Object list(Tablepar tablepar,ProPaintContent record){
		record.setIsDel(0);
		if(StringUtils.isNotEmpty(tablepar.getSearchText())){
			record.setTitle(tablepar.getSearchText());
		}
		PageInfo<ProPaintContent> page=proPaintContentService.queryContentList(tablepar,record) ;
		return  pageTable(page.getList(),page.getTotal());
	}



	@ApiOperation(value = "分页跳转", notes = "分页跳转")
	@GetMapping("/view3")
	@RequiresPermissions("gen:proPaintContentManage:view")
	public String view3(ModelMap model,Long no)
	{
		model.addAttribute("partId",no);
		String str="诗歌创作内容";
		return prefix + "/list3";
	}

	/**
	 * 分页查询
	 */
	//@Log(title = "诗歌作品分集集合查询", action = "111")
	@ApiOperation(value = "分页查询", notes = "分页查询")
	@GetMapping("/list3")
	@RequiresPermissions("gen:proPaintContentManage:look")
	@ResponseBody
	public Object list3(Tablepar tablepar, ProPaintContent record,Long partId){
		record.setPartId(partId);
		record.setIsDel(0);
		PageInfo<ProPaintContent> page=proPaintContentService.queryContentList(tablepar,record) ;
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
	//@Log(title = "绘画创作内容新增", action = "111")
	@ApiOperation(value = "新增", notes = "新增")
	@PostMapping("/add")
	@RequiresPermissions("gen:proPaintContent:add")
	@ResponseBody
	public AjaxResult add(ProPaintContent proPaintContent){
		int b=proPaintContentService.insertSelective(proPaintContent);
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
	//@Log(title = "绘画创作内容删除", action = "111")
	@ApiOperation(value = "删除", notes = "删除")
	@DeleteMapping("/remove")
	@RequiresPermissions("gen:proPaintContentManage:remove")
	@ResponseBody
	public AjaxResult remove(String ids){
	/*	ProPaintContent data = new ProPaintContent();
		data.setNo(ids);
		data.setIsDel(1);*/
		int b=proPaintContentService.deleteBatchByPrimaryKey(ids);
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
	public int checkNameUnique(ProPaintContent proPaintContent){
		int b=proPaintContentService.checkNameUnique(proPaintContent);
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
		mmap.put("ProPaintContent", proPaintContentService.selectUserContentByPrimaryKey(id));

		return prefix + "/edit";
	}

	/**
	 * 修改保存
	 */
	//@Log(title = "绘画创作内容修改", action = "111")
	@ApiOperation(value = "修改保存", notes = "修改保存")
	@RequiresPermissions("gen:proPaintContent:edit")
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(ProPaintContent record)
	{
		return toAjax(proPaintContentService.updateByPrimaryKeySelective(record));
	}

	/**
	 * 采纳
	 */
	//@Log(title = "采纳", action = "111")
	@ApiOperation(value = "采纳", notes = "采纳")
	@RequiresPermissions("gen:proPaintContent:list2")
	@PostMapping("/adopt")
	@ResponseBody
	public AjaxResult adopt(String no,Long partId)
	{
		if(!StringUtils.isEmpty(no)&&partId!=null) {
			ProPaintContent record = new ProPaintContent();
			record.setNo(no);
			record.setAdopt(1);
			record.setPartId(partId);
			int i = proPaintContentService.selectAdoptCount(record);
			if (i == 0) {
				record.setLUpdateDat(DateUtils.getNowDate());
				return toAjax(proPaintContentService.updateByPrimaryKeySelective(record));
			} else {
				return toAjax(0);
			}
		}else {
			return toAjax(0);
		}
	}


	/**
	 * 根据主键查询
	 *
	 * @param id
	 * @param mmap
	 * @return
	 */
	@ApiOperation(value = "根据id查询唯一", notes = "根据id查询唯一")
	@PostMapping("/get/{id}")
	public ProPaintContent edit(@PathVariable("id") String id) {
		return proPaintContentService.selectByPrimaryKey(id);
	}



}
