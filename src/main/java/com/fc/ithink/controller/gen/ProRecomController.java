package com.fc.ithink.controller.gen;

import com.fc.ithink.common.base.BaseController;
import com.fc.ithink.common.domain.AjaxResult;
import com.fc.ithink.common.domain.ResultTable;
import com.fc.ithink.model.custom.Tablepar;
import com.fc.ithink.model.auto.ProRecom;
import com.fc.ithink.service.ProRecomService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 创作推荐表Controller
 * @ClassName: ProRecomController
 * @author xy
 * @date 2021-06-11 13:14:26
 */
@Api(value = "创作推荐表")
@Controller
@RequestMapping("/ProRecomController")
public class ProRecomController extends BaseController{
	
	private String prefix = "gen/proRecom";
	
	@Autowired
	private ProRecomService proRecomService;
	
	
	/**
	 * 创作推荐表页面展示
	 * @param model
	 * @return String
	 * @author xy
	 */
	@ApiOperation(value = "分页跳转", notes = "分页跳转")
	@GetMapping("/view")
	@RequiresPermissions("gen:proRecom:view")
    public String view(ModelMap model)
    {
        return prefix + "/list";
    }
	
	/**
	 * list集合
	 * @param tablepar
	 * @param proRecom
	 * @return
	 */
	//@Log(title = "创作推荐表", action = "111")
	@ApiOperation(value = "分页跳转", notes = "分页跳转")
	@GetMapping("/list")
	@RequiresPermissions("gen:proRecom:list")
	@ResponseBody
	public ResultTable list(Tablepar tablepar,ProRecom proRecom){
		proRecom.setIsDel(0);
		PageInfo<ProRecom> page=proRecomService.list(tablepar,proRecom) ; 
		return pageTable(page.getList(),page.getTotal());
	}


	/**
	 * 完成
	 * @param startIndex
	 * @param pageSize
	 * @param no
	 * @return
	 */
	//@Log(title = "创作作品推荐", action = "111")
	@ApiOperation(value = "查询", notes = "查询")
	@GetMapping("/queryRecom")
	@RequiresPermissions("gen:proRecom:list2")
	@ResponseBody
	public AjaxResult queryRecom(int startIndex,int pageSize,String no){
		List<ProRecom> list = new ArrayList<>();
		if(startIndex<100) {
			list = proRecomService.queryRecomList(no, startIndex, pageSize);
		}
		return AjaxResult.successData(200,list);
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
	//@Log(title = "创作推荐表新增", action = "111")
	@ApiOperation(value = "新增", notes = "新增")
	@PostMapping("/add")
	@RequiresPermissions("gen:proRecom:add")
	@ResponseBody
	public AjaxResult add(ProRecom proRecom){
		int b=proRecomService.insertSelective(proRecom);
		if(b>0){
			return success();
		}else{
			return error();
		}
	}
	
	/**
	 * 创作推荐表删除
	 * @param ids
	 * @return
	 */
	//@Log(title = "创作推荐表删除", action = "111")
	@ApiOperation(value = "删除", notes = "删除")
	@DeleteMapping("/remove")
	@RequiresPermissions("gen:proRecom:remove")
	@ResponseBody
	public AjaxResult remove(String ids){
		int b=proRecomService.deleteBatchByPrimaryKey(ids);
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
        map.put("ProRecom", proRecomService.selectByPrimaryKey(id));

        return prefix + "/edit";
    }
	
	/**
     * 修改保存
     */
    //@Log(title = "创作推荐表修改", action = "111")
	@ApiOperation(value = "修改保存", notes = "修改保存")
    @RequiresPermissions("gen:proRecom:edit")
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ProRecom proRecom)
    {
        return toAjax(proRecomService.updateByPrimaryKeySelective(proRecom));
    }

    
    

	
}
