package com.fc.ithink.controller.gen;

import cn.hutool.core.util.StrUtil;
import com.fc.ithink.common.base.BaseController;
import com.fc.ithink.common.domain.AjaxResult;
import com.fc.ithink.common.domain.ResultTable;
import com.fc.ithink.common.support.ConvertUtil;
import com.fc.ithink.model.auto.UserCashoutApplyExample;
import com.fc.ithink.model.custom.Tablepar;
import com.fc.ithink.model.auto.UserCashoutApply;
import com.fc.ithink.service.UserCashoutApplyService;
import com.fc.ithink.shiro.util.ShiroUtils;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * 提现申请管理Controller
 * @ClassName: UserCashoutApplyController
 * @author xy
 * @date 2021-05-27 14:41:23
 */
@Api(value = "提现申请管理")
@Controller
@RequestMapping("/UserCashoutApplyController")
public class UserCashoutApplyController extends BaseController{
	
	private String prefix = "gen/userCashoutApply";
	
	@Autowired
	private UserCashoutApplyService userCashoutApplyService;
	
	
	/**
	 * 提现申请管理页面展示
	 * @param model
	 * @return String
	 * @author xy
	 */
	@ApiOperation(value = "分页跳转", notes = "分页跳转")
	@GetMapping("/view")
	@RequiresPermissions("gen:userCashoutApply:view")
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
	//@Log(title = "提现申请管理", action = "111")
	@ApiOperation(value = "分页跳转", notes = "分页跳转")
	@GetMapping("/list")
	@RequiresPermissions("gen:userCashoutApply:list")
	@ResponseBody
	public ResultTable list(Tablepar tablepar,UserCashoutApply userCashoutApply){
		userCashoutApply.setIsDel(null);
		PageInfo<UserCashoutApply> page=userCashoutApplyService.list(tablepar,userCashoutApply) ;
		return pageTable(page.getList(),page.getTotal());
	}

	/**
	 * 提现申请管理页面展示
	 * @param model
	 * @return String
	 * @author xy
	 */
	@ApiOperation(value = "分页跳转", notes = "分页跳转")
	@GetMapping("/view2")
	@RequiresPermissions("gen:userCashoutApply:view2")
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
	//@Log(title = "提现申请管理", action = "111")
	@ApiOperation(value = "分页跳转", notes = "分页跳转")
	@GetMapping("/list2")
	@RequiresPermissions("gen:userCashoutApply:list2")
	@ResponseBody
	public ResultTable listByUser(Tablepar tablepar,UserCashoutApply userCashoutApply){
		userCashoutApply.setCreateBy(ShiroUtils.getUserId());
		userCashoutApply.setIsDel(1);
		PageInfo<UserCashoutApply> page=userCashoutApplyService.list(tablepar,userCashoutApply) ;
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
	//@Log(title = "提现申请管理新增", action = "111")
	@ApiOperation(value = "新增", notes = "新增")
	@PostMapping("/add")
	@RequiresPermissions("gen:userCashoutApply:add")
	@ResponseBody
	public AjaxResult add(UserCashoutApply userCashoutApply){
		int b=userCashoutApplyService.insertSelective(userCashoutApply);
		if(b>0){
			return success();
		}else{
			return error();
		}
	}
	
	/**
	 * 提现申请管理删除
	 * @param ids
	 * @return
	 */
	//@Log(title = "提现申请管理删除", action = "111")
	@ApiOperation(value = "删除", notes = "删除")
	@DeleteMapping("/remove")
	@RequiresPermissions("gen:userCashoutApply:remove")
	@ResponseBody
	public AjaxResult remove(String ids){
		int b=userCashoutApplyService.deleteByPrimaryKey(ids);
		if(b>0){
			return success();
		}else{
			return error();
		}
	}

	/**
	 * 提现申请管理删除
	 * @param ids
	 * @return
	 */
	//@Log(title = "提现申请管理删除", action = "111")
	@ApiOperation(value = "退回", notes = "退回")
	@DeleteMapping("/remove2")
	@RequiresPermissions("gen:userCashoutApply:remove2")
	@ResponseBody
	@Transactional
	public AjaxResult removeByUser(String ids){
		Long[] integers = ConvertUtil.toLongArray(",", ids);
		List<Long> stringB = Arrays.asList(integers);

		UserCashoutApply data = userCashoutApplyService.selectByPrimaryKey(ids);
		if(data!=null){
			if(StrUtil.isNotEmpty(data.getFinish())&&data.getFinish().equals("0")){
				UserCashoutApplyExample example = new UserCashoutApplyExample();
				UserCashoutApplyExample.Criteria criteria = example.createCriteria();
				criteria.andIdEqualTo(stringB.get(0));
				criteria.andCreateByEqualTo(ShiroUtils.getUserId());
				UserCashoutApply record = new UserCashoutApply();
				record.setIsDel(1);
				int b=userCashoutApplyService.updateByExampleSelective(record,example);
				if(b>0){
					return success();
				}else{
					return error();
				}
			}else{
				return error("提现已完成，不能退回");
			}
		}else{
			return error("提现申请数据不存在");
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
        map.put("UserCashoutApply", userCashoutApplyService.selectByPrimaryKey(id));

        return prefix + "/edit";
    }
	
	/**
     * 修改保存
     */
    //@Log(title = "提现申请管理修改", action = "111")
	@ApiOperation(value = "修改保存", notes = "修改保存")
    @RequiresPermissions("gen:userCashoutApply:edit")
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(UserCashoutApply userCashoutApply)
    {
        return toAjax(userCashoutApplyService.updateByPrimaryKeySelective(userCashoutApply));
    }

    
    

	
}
