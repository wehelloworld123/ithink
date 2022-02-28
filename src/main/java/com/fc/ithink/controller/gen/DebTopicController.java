package com.fc.ithink.controller.gen;

import com.fc.ithink.common.base.BaseController;
import com.fc.ithink.common.domain.AjaxResult;
import com.fc.ithink.common.domain.ResultTable;
import com.fc.ithink.model.custom.Tablepar;
import com.fc.ithink.model.auto.DebTopic;
import com.fc.ithink.service.DebTopicService;
import com.fc.ithink.shiro.util.ShiroUtils;
import com.fc.ithink.util.DateUtils;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * 论题信息Controller
 * @ClassName: DebTopicController
 * @author xy
 * @date 2021-05-27 15:14:38
 */
@Api(value = "论题信息")
@Controller
@RequestMapping("/DebTopicController")
public class DebTopicController extends BaseController{
	
	private String prefix = "gen/debTopic";
	
	@Autowired
	private DebTopicService debTopicService;
	

	/**
	 * 论题信息页面展示
	 * @param model
	 * @return String
	 * @author xy
	 */
	@ApiOperation(value = "分页跳转", notes = "分页跳转")
	@GetMapping("/view")
	@RequiresPermissions("gen:debTopic:view")
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
	//@Log(title = "论题信息", action = "111")
	@ApiOperation(value = "分页跳转", notes = "分页跳转")
	@GetMapping("/list")
	@RequiresPermissions("gen:debTopic:list")
	@ResponseBody
	public ResultTable list(Tablepar tablepar,DebTopic debTopic){
		PageInfo<DebTopic> page=debTopicService.list(tablepar,debTopic) ; 
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
	//@Log(title = "论题信息新增", action = "111")
	@ApiOperation(value = "新增", notes = "新增")
	@PostMapping("/add")
	@RequiresPermissions("gen:debTopic:add")
	@ResponseBody
	public AjaxResult add(DebTopic debTopic){

		Date now = DateUtils.getNowDate();//当前时间
		debTopic.setCreateBy(ShiroUtils.getUserId());
		debTopic.setCreateDat(now);
		debTopic.setLUpdateDat(now);
		debTopic.setIsDel(0);
		int b=debTopicService.insertSelective(debTopic);
		if(b>0){
			return success();
		}else{
			return error();
		}
	}
	
	/**
	 * 论题信息删除
	 * @param ids
	 * @return
	 */
	//@Log(title = "论题信息删除", action = "111")
	@ApiOperation(value = "删除", notes = "删除")
	@DeleteMapping("/remove")
	@RequiresPermissions("gen:debTopic:remove")
	@ResponseBody
	public AjaxResult remove(String ids){
		int b=debTopicService.deleteByPrimaryKey(ids);
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
        map.put("DebTopic", debTopicService.selectByPrimaryKey(id));

        return prefix + "/edit";
    }
	
	/**
     * 修改保存
     */
    //@Log(title = "论题信息修改", action = "111")
	@ApiOperation(value = "修改保存", notes = "修改保存")
    @RequiresPermissions("gen:debTopic:edit")
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(DebTopic debTopic)
    {
        return toAjax(debTopicService.updateByPrimaryKeySelective(debTopic));
    }

    
    

	
}
