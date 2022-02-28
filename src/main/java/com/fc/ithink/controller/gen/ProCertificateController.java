package com.fc.ithink.controller.gen;

import com.fc.ithink.common.base.BaseController;
import com.fc.ithink.common.domain.AjaxResult;
import com.fc.ithink.common.domain.ResultTable;
import com.fc.ithink.model.custom.Tablepar;
import com.fc.ithink.model.auto.ProCertificate;
import com.fc.ithink.service.ProCertificateService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

/**
 * 作品证明表Controller
 * @ClassName: ProCertificateController
 * @author xy
 * @date 2021-05-28 12:01:21
 */
@Api(value = "作品证明表")
@Controller
@RequestMapping("/ProCertificateController")
public class ProCertificateController extends BaseController{
	
	private String prefix = "gen/proCertificate";
	
	@Autowired
	private ProCertificateService proCertificateService;
	
	
	/**
	 * 作品证明表页面展示
	 * @param model
	 * @return String
	 * @author xy
	 */
	@ApiOperation(value = "分页跳转", notes = "分页跳转")
	@GetMapping("/view")
	@RequiresPermissions("gen:proCertificate:view")
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
	//@Log(title = "作品证明表", action = "111")
	@ApiOperation(value = "分页跳转", notes = "分页跳转")
	@GetMapping("/list")
	@RequiresPermissions("gen:proCertificate:list")
	@ResponseBody
	public ResultTable list(Tablepar tablepar,ProCertificate proCertificate){
		PageInfo<ProCertificate> page=proCertificateService.list(tablepar,proCertificate) ; 
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
	//@Log(title = "作品证明表新增", action = "111")
	@ApiOperation(value = "新增", notes = "新增")
	@PostMapping("/add")
	@RequiresPermissions("gen:proCertificate:add")
	@ResponseBody
	public AjaxResult add(ProCertificate proCertificate){
		int b=proCertificateService.insertSelective(proCertificate);
		if(b>0){
			return success();
		}else{
			return error();
		}
	}
	
	/**
	 * 作品证明表删除
	 * @param ids
	 * @return
	 */
	//@Log(title = "作品证明表删除", action = "111")
	@ApiOperation(value = "删除", notes = "删除")
	@DeleteMapping("/remove")
	@RequiresPermissions("gen:proCertificate:remove")
	@ResponseBody
	public AjaxResult remove(String ids){
		int b=proCertificateService.deleteByPrimaryKey(ids);
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
        map.put("ProCertificate", proCertificateService.selectByPrimaryKey(id));

        return prefix + "/edit";
    }
	
	/**
     * 修改保存
     */
    //@Log(title = "作品证明表修改", action = "111")
	@ApiOperation(value = "修改保存", notes = "修改保存")
    @RequiresPermissions("gen:proCertificate:edit")
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ProCertificate proCertificate)
    {
        return toAjax(proCertificateService.updateByPrimaryKeySelective(proCertificate));
    }

    
    

	
}
