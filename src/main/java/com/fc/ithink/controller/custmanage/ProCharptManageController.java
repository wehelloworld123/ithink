package com.fc.ithink.controller.custmanage;

import cn.hutool.core.util.StrUtil;
import com.fc.ithink.common.base.BaseController;
import com.fc.ithink.common.domain.AjaxResult;
import com.fc.ithink.common.enums.ProStatus;
import com.fc.ithink.model.auto.ProCharpt;
import com.fc.ithink.model.custom.Tablepar;
import com.fc.ithink.service.ProCharptService;
import com.fc.ithink.shiro.util.ShiroUtils;
import com.fc.ithink.util.StringUtils;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Api(value = "文学作品章节")
@Controller
@RequestMapping("/ProCharptManageController")
public class ProCharptManageController extends BaseController{
	
	private String prefix = "manage/proCharpt";
	@Autowired
	private ProCharptService proCharptService;
	
	/**
	 * 分页跳转
	 */
	@ApiOperation(value = "分页跳转", notes = "分页跳转")
	@GetMapping("/view")
	@RequiresPermissions("gen:proCharptManage:view")
    public String view(ModelMap model)
    {	
		String str="文学作品章节";
		return prefix + "/list";
    }
	
	/**
	 * 分页查询
	 */
	//@Log(title = "文学作品章节集合查询", action = "111")
	@ApiOperation(value = "分页查询", notes = "分页查询")
	@GetMapping("/list")
	@RequiresPermissions("gen:proCharptManage:list")
	@ResponseBody
	public Object list(Tablepar tablepar,ProCharpt record){
		record.setIsDel(0);
		record.setRoot(0);
		if(StringUtils.isNotEmpty(tablepar.getSearchText())){
			record.setTitle(tablepar.getSearchText());
		}
		PageInfo<ProCharpt> page=proCharptService.list(tablepar,record,true) ;
		return  pageTable(page.getList(),page.getTotal());
	}


	/**
	 * 分页跳转
	 */
	@ApiOperation(value = "分页跳转", notes = "分页跳转")
	@GetMapping("/view2")
	@RequiresPermissions("gen:proCharptManage:view")
	public String view2(ModelMap model,String uid)
	{
		model.addAttribute("bookId",uid);
		String str="文学作品分集";
		return prefix + "/list2";
	}

	/**
	 * 分页查询
	 */
	//@Log(title = "绘画作品分集集合查询", action = "111")
	@ApiOperation(value = "分页查询", notes = "分页查询")
	@GetMapping("/list2")
	@RequiresPermissions("gen:proCharptManage:list2")
	@ResponseBody
	public Object list2(Tablepar tablepar,ProCharpt record,String bookId){



		record.setBookId(bookId);
		record.setIsDel(0);
		//搜索
		if(StrUtil.isNotEmpty(tablepar.getSearchText())) {//小窗体
			record.setTitle(tablepar.getSearchText());
		}
		PageInfo<ProCharpt> page=proCharptService.list(tablepar,record,false) ;
		return  pageTable(page.getList(),page.getTotal());
	}


	/**
     * 新增跳转
     */
    @ApiOperation(value = "新增跳转", notes = "新增跳转")
    @GetMapping("/add")
    public String add(ModelMap modelMap,String bookId)
    {
		modelMap.addAttribute("bookId",bookId);
        return prefix + "/add";
    }


	/**
	 * 删除
	 * @param ids
	 * @return
	 */
	//@Log(title = "文学作品章节删除", action = "111")
	@ApiOperation(value = "删除", notes = "删除")
	@DeleteMapping("/remove")
	@RequiresPermissions("gen:proCharpt:remove")
	@ResponseBody
	public AjaxResult remove(String ids,Integer root){


		ProCharpt data = new ProCharpt();


		if(root==1){
			Tablepar tablepar = new Tablepar();
			data.setRoot(0);
			data.setRootId(new Long(ids));
			tablepar.setPage(0);
			tablepar.setLimit(15);
			PageInfo<ProCharpt> pageInfo= proCharptService.listByCreateBy(tablepar,data);
			if(pageInfo!=null&&pageInfo.getList()!=null&&pageInfo.getList().size()>0){
				return error("主节点还存在子节点");
			}
		}
		data.setCreateBy(ShiroUtils.getUserId());
		data.setId(new Long(ids));
		data.setRootId(null);
		data.setRoot(null);
		data.setIsDel(1);
		int b = proCharptService.updateByPrimaryKeySelective(data);

		if(b>0){
			return success();
		}else{
			return error();
		}

	}

	/**
	 * 打回
	 * @param ids
	 * @return
	 */
	//@Log(title = "文学作品分集打回", action = "111")
	@ApiOperation(value = "打回", notes = "打回")
	@PostMapping("/lose")
	@RequiresPermissions("gen:proCharptManage:lose")
	@ResponseBody
	public AjaxResult lose(String ids){
		ProCharpt data = new ProCharpt();
		data.setId(new Long(ids));
		data.setFinish(ProStatus.edit.getValue());//
		int b = proCharptService.updateByPrimaryKeySelective(data);
		if(b>0){
			return success();
		}else{
			return error();
		}
	}
	/**
	 * 完成
	 * @param ids
	 * @return
	 */
	//@Log(title = "绘画作品分集完成", action = "111")
	@ApiOperation(value = "完成", notes = "完成")
	@PostMapping("/finish")
	@RequiresPermissions("gen:proCharptManage:finish")
	@ResponseBody
	public AjaxResult finish(Integer ids){
		ProCharpt data = new ProCharpt();
		data.setId(new Long(ids));
		data.setFinish(1);
		int b = proCharptService.updateByPrimaryKeySelective(data);
		if(b>0){
			return success();
		}else{
			return error();
		}
	}
	
	/**
	 * 检查Name
	 * @param proCharpt
	 * @return
	 */
	@ApiOperation(value = "检查Name唯一", notes = "检查Name唯一")
	@PostMapping("/checkNameUnique")
	@ResponseBody
	public int checkNameUnique(ProCharpt proCharpt){
		int b=proCharptService.checkNameUnique(proCharpt);
		if(b>0){
			return 1;
		}else{
			return 0;
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
    public String edit(@PathVariable("id") String id, ModelMap mmap)
    {
        mmap.put("ProCharpt", proCharptService.selectByPrimaryKey(id));

        return prefix + "/edit";
    }
	
	/**
     * 修改保存
     */
    //@Log(title = "文学作品章节修改", action = "111")
    @ApiOperation(value = "修改保存", notes = "修改保存")
    @RequiresPermissions("gen:proCharptManage:edit")
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ProCharpt record)
    {
        return toAjax(proCharptService.updateByPrimaryKeySelective(record));
    }

    
    /**
   	 * 根据主键查询
   	 * 
   	 * @param id
   	 * @return
   	 */
   	@ApiOperation(value = "根据id查询唯一", notes = "根据id查询唯一")
   	@PostMapping("/get/{id}")
   	public ProCharpt edit(@PathVariable("id") String id) {
   		return proCharptService.selectByPrimaryKey(id);
   	}
    

	
}
