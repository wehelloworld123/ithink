package com.fc.ithink.controller.gen;

import com.fc.ithink.common.base.BaseController;
import com.fc.ithink.common.domain.AjaxResult;
import com.fc.ithink.common.domain.ResultTable;
import com.fc.ithink.model.custom.Tablepar;
import com.fc.ithink.model.auto.ProCopyright;
import com.fc.ithink.service.ProCopyrightService;
import com.fc.ithink.shiro.util.ShiroUtils;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

/**
 * 作品版权分配Controller
 * @ClassName: ProCopyrightController
 * @author xy
 * @date 2021-05-27 15:53:57
 */
@Api(value = "作品版权分配")
@Controller
@RequestMapping("/ProCopyrightController")
public class ProCopyrightController extends BaseController{
	
	private String prefix = "gen/proCopyright";
	
	@Autowired
	private ProCopyrightService proCopyrightService;
	
	
	/**
	 * 作品版权分配页面展示
	 * @param model
	 * @return String
	 * @author xy
	 */
	@ApiOperation(value = "分页跳转", notes = "分页跳转")
	@GetMapping("/view")
	@RequiresPermissions("gen:proCopyright:view")
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
	//@Log(title = "作品版权分配", action = "111")
	@ApiOperation(value = "分页跳转", notes = "分页跳转")
	@GetMapping("/list")
	@RequiresPermissions("gen:proCopyright:list")
	@ResponseBody
	public ResultTable list(Tablepar tablepar,ProCopyright proCopyright){
		proCopyright.setCreateBy(ShiroUtils.getUserId());
		proCopyright.setIsDel(0);
		PageInfo<ProCopyright> page=proCopyrightService.listByCondition(tablepar,proCopyright) ;
		return pageTable(page.getList(),page.getTotal());
	}


	/**
	 * 作品版权分配页面展示
	 * @param model
	 * @return String
	 * @author xy
	 */
	@ApiOperation(value = "分页跳转", notes = "分页跳转")
	@GetMapping("/view2")
	@RequiresPermissions("gen:proCopyright:view2")
	public String view2(ModelMap model)
	{
		return prefix + "/list2";
	}

	/**
	 * list集合
	 * @param tablepar
	 * @param searchText
	 * @return
	 */
	//@Log(title = "作品版权分配", action = "111")
	@ApiOperation(value = "分页跳转", notes = "分页跳转")
	@GetMapping("/list2")
	@RequiresPermissions("gen:proCopyright:list")
	@ResponseBody
	public ResultTable list2(Tablepar tablepar,ProCopyright proCopyright){

		PageInfo<ProCopyright> page=proCopyrightService.listByCondition(tablepar,proCopyright) ;
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
	//@Log(title = "作品版权分配新增", action = "111")
	@ApiOperation(value = "新增", notes = "新增")
	@PostMapping("/add")
	@RequiresPermissions("gen:proCopyright:add")
	@ResponseBody
	public AjaxResult add(ProCopyright proCopyright){
		int b=proCopyrightService.insertSelective(proCopyright);
		if(b>0){
			return success();
		}else{
			return error();
		}
	}
	
	/**
	 * 作品版权分配删除
	 * @param ids
	 * @return
	 */
	//@Log(title = "作品版权分配删除", action = "111")
	@ApiOperation(value = "删除", notes = "删除")
	@DeleteMapping("/remove")
	@RequiresPermissions("gen:proCopyright:remove")
	@ResponseBody
	public AjaxResult remove(String ids){
		int b=proCopyrightService.deleteByPrimaryKey(ids);
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
        map.put("ProCopyright", proCopyrightService.selectByPrimaryKey(id));

        return prefix + "/edit";
    }
	
	/**
     * 修改保存
     */
    //@Log(title = "作品版权分配修改", action = "111")
	@ApiOperation(value = "修改保存", notes = "修改保存")
    @RequiresPermissions("gen:proCopyright:edit")
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ProCopyright proCopyright)
    {
        return toAjax(proCopyrightService.updateByPrimaryKeySelective(proCopyright));
    }

    
    

	
}
