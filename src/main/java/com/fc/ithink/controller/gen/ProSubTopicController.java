package com.fc.ithink.controller.gen;

import com.fc.ithink.common.base.BaseController;
import com.fc.ithink.common.domain.AjaxResult;
import com.fc.ithink.common.domain.ResultTable;
import com.fc.ithink.model.custom.Tablepar;
import com.fc.ithink.model.auto.ProSubTopic;
import com.fc.ithink.service.ProSubTopicService;
import com.fc.ithink.shiro.util.ShiroUtils;
import com.fc.ithink.util.DateUtils;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * 专题表Controller
 * @ClassName: ProSubTopicController
 * @author xy
 * @date 2021-05-27 14:57:53
 */
@Api(value = "专题表")
@Controller
@RequestMapping("/ProSubTopicController")
public class ProSubTopicController extends BaseController{
	
	private String prefix = "gen/proSubTopic";
	
	@Autowired
	private ProSubTopicService proSubTopicService;
	
	
	/**
	 * 专题表页面展示
	 * @param model
	 * @return String
	 * @author xy
	 */
	@ApiOperation(value = "分页跳转", notes = "分页跳转")
	@GetMapping("/view")
	@RequiresPermissions("gen:proSubTopic:view")
    public String view(ModelMap model)
    {
        return prefix + "/list";
    }
	
	/**
	 * list集合
	 * @param tablepar
	 * @param proSubTopic
	 * @return
	 */
	//@Log(title = "专题表", action = "111")
	@ApiOperation(value = "分页跳转", notes = "分页跳转")
	@GetMapping("/list")
	@RequiresPermissions("gen:proSubTopic:list")
	@ResponseBody
	public ResultTable list(Tablepar tablepar,ProSubTopic proSubTopic){
		PageInfo<ProSubTopic> page=proSubTopicService.list(tablepar,proSubTopic) ; 
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
	//@Log(title = "专题表新增", action = "111")
	@ApiOperation(value = "新增", notes = "新增")
	@PostMapping("/add")
	@RequiresPermissions("gen:proSubTopic:add")
	@ResponseBody
	public AjaxResult add(ProSubTopic proSubTopic) throws Exception {
		Date now = DateUtils.getNowDate();//当前时间
		proSubTopic.setCreateBy(ShiroUtils.getUserId());
		proSubTopic.setCreateDat(now);
		proSubTopic.setLUpdateDat(now);
		proSubTopic.setIsDel(0);
		try {
			int b = proSubTopicService.insertSelective(proSubTopic);
			if (b > 0) {
				return success();
			} else {
				return error();
			}
		}catch (Exception e){
			if(e instanceof DuplicateKeyException){
				return error("简称重复");
			}else{
				throw e;
			}
		}
	}
	
	/**
	 * 专题表删除
	 * @param ids
	 * @return
	 */
	//@Log(title = "专题表删除", action = "111")
	@ApiOperation(value = "删除", notes = "删除")
	@DeleteMapping("/remove")
	@RequiresPermissions("gen:proSubTopic:remove")
	@ResponseBody
	public AjaxResult remove(String ids){
		int b=proSubTopicService.deleteByPrimaryKey(ids);
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
        map.put("ProSubTopic", proSubTopicService.selectByPrimaryKey(id));

        return prefix + "/edit";
    }
	
	/**
     * 修改保存
     */
    //@Log(title = "专题表修改", action = "111")
	@ApiOperation(value = "修改保存", notes = "修改保存")
    @RequiresPermissions("gen:proSubTopic:edit")
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ProSubTopic proSubTopic)
    {
        return toAjax(proSubTopicService.updateByPrimaryKeySelective(proSubTopic));
    }

    
    

	
}
