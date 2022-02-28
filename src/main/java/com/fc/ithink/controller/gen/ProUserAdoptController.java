package com.fc.ithink.controller.gen;

import com.fc.ithink.common.base.BaseController;
import com.fc.ithink.common.domain.AjaxResult;
import com.fc.ithink.common.domain.ResultTable;
import com.fc.ithink.model.custom.Tablepar;
import com.fc.ithink.model.auto.ProUserAdopt;
import com.fc.ithink.service.ProUserAdoptService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

/**
 * 用户创作采纳表Controller
 * @ClassName: ProUserAdoptController
 * @author xy
 * @date 2021-06-12 16:48:09
 */
@Api(value = "用户创作采纳表")
@Controller
@RequestMapping("/ProUserAdoptController")
public class ProUserAdoptController extends BaseController{
	
	private String prefix = "gen/proUserAdopt";
	
	@Autowired
	private ProUserAdoptService proUserAdoptService;
	
	
	/**
	 * 用户创作采纳表页面展示
	 * @param model
	 * @return String
	 * @author xy
	 */
	@ApiOperation(value = "分页跳转", notes = "分页跳转")
	@GetMapping("/view")
	@RequiresPermissions("gen:proUserAdopt:view")
    public String view(ModelMap model)
    {
        return prefix + "/list";
    }
	
	/**
	 * list集合
	 * @param tablepar
	 * @param searchText
	 * @return
	 */
	//@Log(title = "用户创作采纳表", action = "111")
	@ApiOperation(value = "分页跳转", notes = "分页跳转")
	@GetMapping("/list")
	@RequiresPermissions("gen:proUserAdopt:list")
	@ResponseBody
	public ResultTable list(Tablepar tablepar,ProUserAdopt proUserAdopt){
		PageInfo<ProUserAdopt> page=proUserAdoptService.list(tablepar,proUserAdopt) ; 
		return pageTable(page.getList(),page.getTotal());
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
     * 新增保存
     * @param 
     * @return
     */
	//@Log(title = "用户创作采纳表新增", action = "111")
	@ApiOperation(value = "新增", notes = "新增")
	@PostMapping("/add")
	@RequiresPermissions("gen:proUserAdopt:add")
	@ResponseBody
	public AjaxResult add(ProUserAdopt proUserAdopt){
		int b=proUserAdoptService.insertSelective(proUserAdopt);
		if(b>0){
			return success();
		}else{
			return error();
		}
	}
	
	/**
	 * 用户创作采纳表删除
	 * @param ids
	 * @return
	 */
	//@Log(title = "用户创作采纳表删除", action = "111")
	@ApiOperation(value = "删除", notes = "删除")
	@DeleteMapping("/remove")
	@RequiresPermissions("gen:proUserAdopt:remove")
	@ResponseBody
	public AjaxResult remove(String ids){
		int b=proUserAdoptService.deleteByPrimaryKey(ids);
		if(b>0){
			return success();
		}else{
			return error();
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
    public String edit(@PathVariable("id") String id, ModelMap map)
    {
        map.put("ProUserAdopt", proUserAdoptService.selectByPrimaryKey(id));

        return prefix + "/edit";
    }
	
	/**
     * 修改保存
     */
    //@Log(title = "用户创作采纳表修改", action = "111")
	@ApiOperation(value = "修改保存", notes = "修改保存")
    @RequiresPermissions("gen:proUserAdopt:edit")
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ProUserAdopt proUserAdopt)
    {
        return toAjax(proUserAdoptService.updateByPrimaryKeySelective(proUserAdopt));
    }

    
    

	
}
