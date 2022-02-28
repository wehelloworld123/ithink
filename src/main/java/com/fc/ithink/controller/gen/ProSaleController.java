package com.fc.ithink.controller.gen;

import com.fc.ithink.common.base.BaseController;
import com.fc.ithink.common.domain.AjaxResult;
import com.fc.ithink.common.domain.ResultTable;
import com.fc.ithink.model.custom.Tablepar;
import com.fc.ithink.model.auto.ProSale;
import com.fc.ithink.service.ProSaleService;
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
 * 作品上架表Controller
 * @ClassName: ProSaleController
 * @author xy
 * @date 2021-05-27 16:03:15
 */
@Api(value = "作品上架表")
@Controller
@RequestMapping("/ProSaleController")
public class ProSaleController extends BaseController{
	
	private String prefix = "gen/proSale";
	
	@Autowired
	private ProSaleService proSaleService;
	
	
	/**
	 * 作品上架表页面展示
	 * @param model
	 * @return String
	 * @author xy
	 */
	@ApiOperation(value = "分页跳转", notes = "分页跳转")
	@GetMapping("/view")
	@RequiresPermissions("gen:proSale:view")
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
	//@Log(title = "作品上架表", action = "111")
	@ApiOperation(value = "分页跳转", notes = "分页跳转")
	@GetMapping("/list")
	@RequiresPermissions("gen:proSale:list")
	@ResponseBody
	public ResultTable list(Tablepar tablepar,ProSale proSale){
		proSale.setCreateBy(ShiroUtils.getUserId());
		PageInfo<ProSale> page=proSaleService.list(tablepar,proSale) ; 
		return pageTable(page.getList(),page.getTotal());
	}


	/**
	 * 作品上架表页面展示
	 * @param model
	 * @return String
	 * @author xy
	 */
	@ApiOperation(value = "分页跳转", notes = "分页跳转")
	@GetMapping("/view2")
	@RequiresPermissions("gen:proSale:view2")
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
	//@Log(title = "作品上架表", action = "111")
	@ApiOperation(value = "分页跳转", notes = "分页跳转")
	@GetMapping("/list2")
	@RequiresPermissions("gen:proSale:list")
	@ResponseBody
	public ResultTable list2(Tablepar tablepar,ProSale proSale){
		PageInfo<ProSale> page=proSaleService.list(tablepar,proSale) ;
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
	//@Log(title = "作品上架表新增", action = "111")
	@ApiOperation(value = "新增", notes = "新增")
	@PostMapping("/add")
	@RequiresPermissions("gen:proSale:add")
	@ResponseBody
	public AjaxResult add(ProSale proSale){
		int b=proSaleService.insertSelective(proSale);
		if(b>0){
			return success();
		}else{
			return error();
		}
	}
	
	/**
	 * 作品上架表删除
	 * @param ids
	 * @return
	 */
	//@Log(title = "作品上架表删除", action = "111")
	@ApiOperation(value = "删除", notes = "删除")
	@PostMapping("/remove")
	@RequiresPermissions("gen:proSale:remove")
	@ResponseBody
	public AjaxResult remove(String ids){

		ProSale sale = new ProSale();
		sale.setId(new Long(ids));
		sale.setSaleStatus("0");
		return toAjax(proSaleService.updateByPrimaryKeySelective(sale));
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
        map.put("ProSale", proSaleService.selectByPrimaryKey(id));

        return prefix + "/edit";
    }
	
	/**
     * 修改保存
     */
    //@Log(title = "作品上架表修改", action = "111")
	@ApiOperation(value = "修改保存", notes = "修改保存")
    @RequiresPermissions("gen:proSale:edit")
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(String ids)
    {
    	ProSale sale = new ProSale();
    	sale.setId(new Long(ids));
		sale.setSaleStatus("1");
        return toAjax(proSaleService.updateByPrimaryKeySelective(sale));
    }

    
    

	
}
