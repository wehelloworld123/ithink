package com.fc.ithink.controller.gen;

import com.fc.ithink.common.base.BaseController;
import com.fc.ithink.common.constant.ProjectConstant;
import com.fc.ithink.common.domain.AjaxResult;
import com.fc.ithink.common.domain.ResultTable;
import com.fc.ithink.common.enums.RecomType;
import com.fc.ithink.model.auto.ProLiter;
import com.fc.ithink.model.auto.TsysUser;
import com.fc.ithink.model.custom.Tablepar;
import com.fc.ithink.model.auto.UserNoticeInvite;
import com.fc.ithink.service.ProLiterService;
import com.fc.ithink.service.SysUserService;
import com.fc.ithink.service.UserNoticeInviteService;
import com.fc.ithink.shiro.util.ShiroUtils;
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

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 用户邀请通知Controller
 * @ClassName: UserNoticeInviteController
 * @author xy
 * @date 2021-06-04 09:49:12
 */
@Api(value = "用户邀请通知")
@Controller
@RequestMapping("/UserNoticeInviteController")
public class UserNoticeInviteController extends BaseController{
	
	private String prefix = "gen/userNoticeInvite";
	
	@Autowired
	private UserNoticeInviteService userNoticeInviteService;

	//系统用户
	@Autowired
	private SysUserService sysUserService;

	@Autowired
	private ProLiterService proLiterService;
	/**
	 * 用户邀请通知页面展示
	 * @param model
	 * @return String
	 * @author xy
	 */
	@ApiOperation(value = "分页跳转", notes = "分页跳转")
	@RequestMapping("/view/{id}")
	@RequiresPermissions("gen:userNoticeInvite:view")
    public String view(@PathVariable("id") String id,ModelMap model)
    {
    	if(StringUtils.isNotEmpty(id)) {
			model.put("id", id);
			if(id.indexOf(ProjectConstant.LITERPREFIX)!=-1){
				model.put("proType", RecomType.LITERATURE.getValue());
			}else if(id.indexOf(ProjectConstant.PAINTINGPREFIX)!=-1){
				model.put("proType", RecomType.PAINTING.getValue());
			}else if(id.indexOf(ProjectConstant.POETRYPREFIX)!=-1){
				model.put("proType", RecomType.POEMTY.getValue());
			}else{

			}
		}
        return prefix + "/list";
    }
	
	/**
	 * list集合
	 * @param tablepar
	 * @param userNoticeInvite
	 * @return
	 */
	//@Log(title = "用户邀请通知", action = "111")
	@ApiOperation(value = "分页跳转", notes = "分页跳转")
	@GetMapping("/list")
	@RequiresPermissions("gen:userNoticeInvite:list")
	@ResponseBody
	public ResultTable list(Tablepar tablepar,UserNoticeInvite userNoticeInvite){
		PageInfo<Map<String,Object>> page;
		if(StringUtils.isNotEmpty(tablepar.getSearchText())) {
			page = sysUserService.getUserInfoByIdOrName(tablepar.getSearchText(),tablepar.getPage(), tablepar.getLimit());
		}else{
			page = new PageInfo<>();

		}
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
	//@Log(title = "用户邀请通知新增", action = "111")
	@ApiOperation(value = "新增", notes = "新增")
	@PostMapping("/add")
	@RequiresPermissions("gen:userNoticeInvite:add")
	@ResponseBody
	public AjaxResult add(UserNoticeInvite userNoticeInvite){
		TsysUser user = ShiroUtils.getUser();
		if(user.getId().equals(userNoticeInvite.getInviteeId())){
			return AjaxResult.error("不能邀请自己");
		}
		userNoticeInvite.setInvitorId(user.getId());
		userNoticeInvite.setInvitorNm(user.getNickname());
		if("1".equals(userNoticeInvite.getProType())){
			ProLiter proLiter =  proLiterService.selectByPrimaryKey(userNoticeInvite.getProNo());
			if(proLiter!=null){
				userNoticeInvite.setProNm(proLiter.getName());
			}
		}

		Date currentDate = DateUtils.getNowDate();
		userNoticeInvite.setStatus("0");
		userNoticeInvite.setCreateBy(user.getId());
		userNoticeInvite.setCreateDat(currentDate);
		userNoticeInvite.setLUpdateDat(currentDate);
		userNoticeInvite.setIsDel(0);
		try {

			List<UserNoticeInvite> list = userNoticeInviteService.
					selectNoticeInviteByCondition(userNoticeInvite);

			if(list!=null&&list.size()>0){
				return AjaxResult.error("不可重复邀请");
			}

			int b = userNoticeInviteService.insertSelective(userNoticeInvite);
			if(b>0){
				return AjaxResult.success("已发送邀请!");
			}else{
				return AjaxResult.error("发送邀请失败");
			}
		}catch (Exception e){
			throw e;
		}

	}
	
	/**
	 * 用户邀请通知删除
	 * @param ids
	 * @return
	 */
	//@Log(title = "用户邀请通知删除", action = "111")
	@ApiOperation(value = "删除", notes = "删除")
	@DeleteMapping("/remove")
	@RequiresPermissions("gen:userNoticeInvite:remove")
	@ResponseBody
	public AjaxResult remove(String ids){
		int b=userNoticeInviteService.deleteByPrimaryKey(ids);
		if(b>0){
			return success();
		}else{
			return error();
		}
	}
	
	
	/**
	 * 修改跳转
	 * @param id
	 * @param map
	 * @return
	 */
	@ApiOperation(value = "修改跳转", notes = "修改跳转")
	@GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap map)
    {
        map.put("UserNoticeInvite", userNoticeInviteService.selectByPrimaryKey(id));

        return prefix + "/edit";
    }
	
	/**
     * 修改保存
     */
    //@Log(title = "用户邀请通知修改", action = "111")
	@ApiOperation(value = "修改保存", notes = "修改保存")
    @RequiresPermissions("gen:userNoticeInvite:edit")
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(UserNoticeInvite userNoticeInvite)
    {
        return toAjax(userNoticeInviteService.updateByPrimaryKeySelective(userNoticeInvite));
    }

	/**
	 * 邀请
	 */

/*
	@ApiOperation(value = "修改保存", notes = "修改保存")
	@RequiresPermissions("gen:userNoticeInvite:invite")
	@GetMapping("/invite")
	@ResponseBody
	public AjaxResult Invite(String username)
	{

		return AjaxResult.success("操作成功",sysUserService.getUserInfoByIdOrName(username));
	}
*/




}
