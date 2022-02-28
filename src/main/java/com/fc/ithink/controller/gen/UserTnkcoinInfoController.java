package com.fc.ithink.controller.gen;

import com.fc.ithink.common.base.BaseController;
import com.fc.ithink.common.domain.AjaxResult;
import com.fc.ithink.common.domain.ResultTable;
import com.fc.ithink.model.custom.Tablepar;
import com.fc.ithink.model.auto.UserTnkcoinInfo;
import com.fc.ithink.service.UserTnkcoinInfoService;
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
 * 用户充值信息Controller
 * @ClassName: UserTnkcoinInfoController
 * @author xy
 * @date 2021-05-27 13:07:35
 */
@Api(value = "用户充值信息")
@Controller
@RequestMapping("/UserTnkcoinInfoController")
public class UserTnkcoinInfoController extends BaseController{
	
	private String prefix = "gen/userTnkcoinInfo";
	
	@Autowired
	private UserTnkcoinInfoService userTnkcoinInfoService;
	
	
	/**
	 * 用户充值信息页面展示
	 * @param model
	 * @return String
	 * @author xy
	 */
	@ApiOperation(value = "分页跳转", notes = "分页跳转")
	@GetMapping("/view")
	@RequiresPermissions("gen:userTnkcoinInfo:view")
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
	//@Log(title = "用户充值信息", action = "111")
	@ApiOperation(value = "分页跳转", notes = "分页跳转")
	@GetMapping("/list")
	@RequiresPermissions("gen:userTnkcoinInfo:list")
	@ResponseBody
	public ResultTable list(Tablepar tablepar,UserTnkcoinInfo userTnkcoinInfo){
		userTnkcoinInfo.setIsDel(null);
		PageInfo<UserTnkcoinInfo> page=userTnkcoinInfoService.list(tablepar,userTnkcoinInfo) ; 
		return pageTable(page.getList(),page.getTotal());
	}

	/**
	 * 用户充值信息页面展示
	 * @param model
	 * @return String
	 * @author xy
	 */
	@ApiOperation(value = "分页跳转", notes = "分页跳转")
	@GetMapping("/view2")
	@RequiresPermissions("gen:userTnkcoinInfo:view2")
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
	//@Log(title = "用户充值信息", action = "111")
	@ApiOperation(value = "分页跳转", notes = "分页跳转")
	@GetMapping("/list2")
	@RequiresPermissions("gen:userTnkcoinInfo:list2")
	@ResponseBody
	public ResultTable listByUser(Tablepar tablepar,UserTnkcoinInfo userTnkcoinInfo){
		userTnkcoinInfo.setCreateBy(ShiroUtils.getUserId());
		userTnkcoinInfo.setIsDel(0);
		PageInfo<UserTnkcoinInfo> page=userTnkcoinInfoService.list(tablepar,userTnkcoinInfo) ;
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
	//@Log(title = "用户充值信息新增", action = "111")
	@ApiOperation(value = "新增", notes = "新增")
	@PostMapping("/add")
	@RequiresPermissions("gen:userTnkcoinInfo:add")
	@ResponseBody
	public AjaxResult add(UserTnkcoinInfo userTnkcoinInfo){
		int b=userTnkcoinInfoService.insertSelective(userTnkcoinInfo);
		if(b>0){
			return success();
		}else{
			return error();
		}
	}
	
	/**
	 * 用户充值信息删除
	 * @param ids
	 * @return
	 */
	//@Log(title = "用户充值信息删除", action = "111")
	@ApiOperation(value = "删除", notes = "删除")
	@DeleteMapping("/remove")
	@RequiresPermissions("gen:userTnkcoinInfo:remove")
	@ResponseBody
	public AjaxResult remove(String ids){
		int b=userTnkcoinInfoService.deleteByPrimaryKey(ids);
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
        map.put("UserTnkcoinInfo", userTnkcoinInfoService.selectByPrimaryKey(id));

        return prefix + "/edit";
    }
	
	/**
     * 修改保存
     */
    //@Log(title = "用户充值信息修改", action = "111")
	@ApiOperation(value = "修改保存", notes = "修改保存")
    @RequiresPermissions("gen:userTnkcoinInfo:edit")
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(UserTnkcoinInfo userTnkcoinInfo)
    {
        return toAjax(userTnkcoinInfoService.updateByPrimaryKeySelective(userTnkcoinInfo));
    }

    
    

	
}
