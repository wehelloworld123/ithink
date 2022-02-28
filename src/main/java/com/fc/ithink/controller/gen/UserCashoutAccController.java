package com.fc.ithink.controller.gen;

import com.fc.ithink.common.base.BaseController;
import com.fc.ithink.common.domain.AjaxResult;
import com.fc.ithink.common.domain.ResultTable;
import com.fc.ithink.model.auto.UserCashoutAccExample;
import com.fc.ithink.model.custom.Tablepar;
import com.fc.ithink.model.auto.UserCashoutAcc;
import com.fc.ithink.service.UserCashoutAccService;
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
 * 用户提现账号Controller
 * @ClassName: UserCashoutAccController
 * @author xy
 * @date 2021-05-27 14:46:25
 */
@Api(value = "用户提现账号")
@Controller
@RequestMapping("/UserCashoutAccController")
public class UserCashoutAccController extends BaseController{
	
	private String prefix = "gen/userCashoutAcc";
	
	@Autowired
	private UserCashoutAccService userCashoutAccService;
	
	
	/**
	 * 用户提现账号页面展示
	 * @param model
	 * @return String
	 * @author xy
	 */
	@ApiOperation(value = "分页跳转", notes = "分页跳转")
	@GetMapping("/view")
	@RequiresPermissions("gen:userCashoutAcc:view")
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
	//@Log(title = "用户提现账号", action = "111")
	@ApiOperation(value = "分页跳转", notes = "分页跳转")
	@GetMapping("/list")
	@RequiresPermissions("gen:userCashoutAcc:list")
	@ResponseBody
	public ResultTable list(Tablepar tablepar,UserCashoutAcc userCashoutAcc){
		userCashoutAcc.setIsDel(null);
		PageInfo<UserCashoutAcc> page=userCashoutAccService.list(tablepar,userCashoutAcc) ;
		return pageTable(page.getList(),page.getTotal());
	}



	/**
	 * 用户提现账号页面展示
	 * @param model
	 * @return String
	 * @author xy
	 */
	@ApiOperation(value = "分页跳转", notes = "分页跳转")
	@GetMapping("/view2")
	@RequiresPermissions("gen:userCashoutAcc:view2")
	public String view2(ModelMap model)
	{
		return prefix + "/listByUser";
	}
	/**
	 * list集合
	 * @param tablepar
	 * @param searchText
	 * @return
	 */
	//@Log(title = "用户提现账号", action = "111")
	@ApiOperation(value = "分页跳转", notes = "分页跳转")
	@GetMapping("/list2")
	@RequiresPermissions("gen:userCashoutAcc:list2")
	@ResponseBody
	public ResultTable listByUser(Tablepar tablepar,UserCashoutAcc userCashoutAcc){
		userCashoutAcc.setCreateBy(ShiroUtils.getUserId());
		userCashoutAcc.setIsDel(0);
		PageInfo<UserCashoutAcc> page=userCashoutAccService.list(tablepar,userCashoutAcc) ;
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
	//@Log(title = "用户提现账号新增", action = "111")
	@ApiOperation(value = "新增", notes = "新增")
	@PostMapping("/add")
	@RequiresPermissions("gen:userCashoutAcc:add")
	@ResponseBody
	public AjaxResult add(UserCashoutAcc userCashoutAcc){
		int b=userCashoutAccService.insertSelective(userCashoutAcc);
		if(b>0){
			return success();
		}else{
			return error();
		}
	}
	
	/**
	 * 用户提现账号删除
	 * @param ids
	 * @return
	 */
	//@Log(title = "用户提现账号删除", action = "111")
	@ApiOperation(value = "删除", notes = "删除")
	@DeleteMapping("/remove")
	@RequiresPermissions("gen:userCashoutAcc:remove")
	@ResponseBody
	public AjaxResult remove(String ids){
		int b=userCashoutAccService.deleteByPrimaryKey(ids);
		if(b>0){
			return success();
		}else{
			return error();
		}
	}


	/**
	 * 用户提现账号删除
	 * @param ids
	 * @return
	 */
	//@Log(title = "用户提现账号删除", action = "111")
	@ApiOperation(value = "删除", notes = "删除")
	@DeleteMapping("/remove2")
	@RequiresPermissions("gen:userCashoutAcc:remove2")
	@ResponseBody
	public AjaxResult removeByUser(String ids){
		UserCashoutAccExample example = new UserCashoutAccExample();
		UserCashoutAccExample.Criteria criteria = example.createCriteria();
		criteria.andCreateByEqualTo(ShiroUtils.getUserId());
		criteria.andNoEqualTo(ids);
		int b=userCashoutAccService.deleteByExample(example);
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
        map.put("UserCashoutAcc", userCashoutAccService.selectByPrimaryKey(id));

        return prefix + "/edit";
    }
	
	/**
     * 修改保存
     */
    //@Log(title = "用户提现账号修改", action = "111")
	@ApiOperation(value = "修改保存", notes = "修改保存")
    @RequiresPermissions("gen:userCashoutAcc:edit")
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(UserCashoutAcc userCashoutAcc)
    {
        return toAjax(userCashoutAccService.updateByPrimaryKeySelective(userCashoutAcc));
    }

    
    

	
}
