package com.fc.ithink.controller.custmanage;

import cn.hutool.core.util.StrUtil;
import com.fc.ithink.common.base.BaseController;
import com.fc.ithink.common.domain.AjaxResult;
import com.fc.ithink.common.enums.ProStatus;
import com.fc.ithink.model.auto.ProPaintPart;
import com.fc.ithink.model.custom.Tablepar;
import com.fc.ithink.service.ProPaintPartService;
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(value = "绘画作品分集")
@Controller
@RequestMapping("/ProPaintPartManageController")
public class ProPaintPartManageController extends BaseController{
	
	private String prefix = "manage/proPaintPart";
	@Autowired
	private ProPaintPartService proPaintPartService;
	
	/**
	 * 分页跳转
	 */
	@ApiOperation(value = "分页跳转", notes = "分页跳转")
	@GetMapping("/view2")
	@RequiresPermissions("gen:proPaintPartManage:view")
    public String view2(ModelMap model,String uid)
    {
		model.addAttribute("paintId",uid);
		String str="绘画作品分集摘录";
		 return prefix + "/list2";
    }
	/**
	 * 字典数据表集合查询
	 * @param tablepar
	 * @param searchText
	 * @param dictId
	 * @return
	 */
	//@Log(title = "字典数据表集合查询", action = "1")
/*	@ApiOperation(value = "分页查询", notes = "分页查询")
	@PostMapping("/list")
	@RequiresPermissions("system:dictData:list")
	@ResponseBody
	public Object list(Tablepar tablepar,String searchText,String dictId){
		PageInfo<ProPaintPart> page=proPaintPartService.list(tablepar,searchText,dictId) ;
		TableSplitResult<ProPaintPart> result=new TableSplitResult<ProPaintPart>(page.getPageNum(), page.getTotal(), page.getList());
		return  result;
	}*/
	/**
	 * 分页查询
	 */
	//@Log(title = "绘画作品分集集合查询", action = "111")
	@ApiOperation(value = "分页查询", notes = "分页查询")
	@GetMapping("/list2")
	@RequiresPermissions("gen:proPaintPartManage:list")
	@ResponseBody
	public Object list2(Tablepar tablepar,ProPaintPart record,String paintId){

		record.setPaintId(paintId);
		record.setIsDel(0);
		//搜索
		if(StrUtil.isNotEmpty(tablepar.getSearchText())) {//小窗体
			record.setSubject(tablepar.getSearchText());
		}
		PageInfo<ProPaintPart> page=proPaintPartService.list(tablepar,record,false) ;
		return  pageTable(page.getList(),page.getTotal());
	}

	/**
	 * 分页跳转
	 */
	@ApiOperation(value = "分页跳转", notes = "分页跳转")
	@GetMapping("/view")
	@RequiresPermissions("gen:proPaintPartManage:view")
	public String view(ModelMap model)
	{
		String str="绘画作品分集管理";
		return prefix + "/list";
	}
	/**
	 * 字典数据表集合查询
	 * @param tablepar
	 * @param searchText
	 * @param dictId
	 * @return
	 */
	//@Log(title = "字典数据表集合查询", action = "1")
/*	@ApiOperation(value = "分页查询", notes = "分页查询")
	@PostMapping("/list")
	@RequiresPermissions("system:dictData:list")
	@ResponseBody
	public Object list(Tablepar tablepar,String searchText,String dictId){
		PageInfo<ProPaintPart> page=proPaintPartService.list(tablepar,searchText,dictId) ;
		TableSplitResult<ProPaintPart> result=new TableSplitResult<ProPaintPart>(page.getPageNum(), page.getTotal(), page.getList());
		return  result;
	}*/
	/**
	 * 分页查询
	 */
	//@Log(title = "绘画作品分集集合查询", action = "111")
	@ApiOperation(value = "分页查询", notes = "分页查询")
	@GetMapping("/list")
	@RequiresPermissions("gen:proPaintPartManage:list")
	@ResponseBody
	public Object list(Tablepar tablepar,ProPaintPart record){
		record.setIsDel(0);
		record.setRoot(0);
		if(!StringUtils.isEmpty(tablepar.getSearchText())){
			record.setSubject(tablepar.getSearchText());
		}
		PageInfo<ProPaintPart> page=proPaintPartService.list(tablepar,record,true) ;
		return  pageTable(page.getList(),page.getTotal());
	}


	/**
     * 新增跳转
     */
    @ApiOperation(value = "新增跳转", notes = "新增跳转")
    @GetMapping("/add")
    public String add(ModelMap modelMap,String paintId)
    {
    	modelMap.addAttribute("paintId",paintId);
        return prefix + "/add";
    }
	
	/**
     * 新增
     */
	//@Log(title = "绘画作品分集新增", action = "111")
   	@ApiOperation(value = "新增", notes = "新增")
	@PostMapping("/add")
	@RequiresPermissions("gen:proPaintPart:add")
	@ResponseBody
	public AjaxResult add(ProPaintPart proPaintPart){
		proPaintPart.setCreateBy(ShiroUtils.getUserId());
		Map<String,Object> map = proPaintPartService.selectPartCountByPaintId(proPaintPart);
		if(map!=null) {
			if (proPaintPart.getRoot() == 1) {
				if (map.get("parts") == map.get("count")) {
					return AjaxResult.error("分篇已满");
				} else {
					int b = proPaintPartService.insertSelective(proPaintPart);
					if (b > 0) {
						return success();
					} else {
						return error("保存失败");
					}
				}
			} else {
				if (map.get("section") == map.get("count")) {
					return AjaxResult.error("章节已满");
				} else {
					int b = proPaintPartService.insertSelective(proPaintPart);
					if (b > 0) {
						return success();
					} else {
						return error("保存失败");
					}
				}
			}
		}else{
			return error("保存失败");
		}
	}

	/**
	 * 打回
	 * @param ids
	 * @return
	 */
	//@Log(title = "绘画作品分集打回", action = "111")
	@ApiOperation(value = "打回", notes = "打回")
	@PostMapping("/lose")
	@RequiresPermissions("gen:proPaintPartManage:lose")
	@ResponseBody
	public AjaxResult lose(String ids){
		ProPaintPart data = new ProPaintPart();
		data.setId(new Long(ids));
		data.setFinish(ProStatus.edit.getValue());//
		int b = proPaintPartService.updateByPrimaryKeySelective(data);
		if(b>0){
			return success();
		}else{
			return error();
		}
	}

	/**
	 * 删除
	 * @param ids
	 * @return
	 */
	//@Log(title = "绘画作品分集删除", action = "111")
	@ApiOperation(value = "删除", notes = "删除")
	@DeleteMapping("/remove")
	@RequiresPermissions("gen:proPaintPart:remove")
	@ResponseBody
	public AjaxResult remove(String ids,Integer root){


		ProPaintPart data = new ProPaintPart();

		data.setCreateBy(ShiroUtils.getUserId());
		if(root==1){
			Tablepar tablepar = new Tablepar();
			data.setRoot(0);
			data.setRootId(new Long(ids));
			tablepar.setPage(0);
			tablepar.setLimit(15);
			PageInfo<ProPaintPart> pageInfo= proPaintPartService.listByCreateBy(tablepar,data);
			if(pageInfo!=null&&pageInfo.getList()!=null&&pageInfo.getList().size()>0){
				return error("主节点还存在子节点");
			}
		}
		data.setId(new Long(ids));
		data.setRootId(null);
		data.setRoot(null);
		data.setIsDel(1);
		int b = proPaintPartService.updateByPrimaryKeySelective(data);

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
	@RequiresPermissions("gen:proPaintPart:finish")
	@ResponseBody
	public AjaxResult finish(Integer ids){
		ProPaintPart data = new ProPaintPart();
		data.setId(new Long(ids));
		data.setFinish(1);
		int b = proPaintPartService.updateByPrimaryKeySelective(data);
		if(b>0){
			return success();
		}else{
			return error();
		}
	}

	/**
	 * 检查Name
	 * @param proPaintPart
	 * @return
	 */
	@ApiOperation(value = "查询根信息", notes = "查询根信息")
	@PostMapping("/queryRootInfo")
	@ResponseBody
	public AjaxResult queryRootInfo(ProPaintPart proPaintPart,String paintId){
		proPaintPart.setPaintId(paintId);
		Map<String,Object> resultMap = new HashMap<>();
		List<Map<String,Object>> resList = new ArrayList<>();
		if(proPaintPart.getRoot()==1){//根
			List<Map<String,Object>> list= proPaintPartService.queryRootInfo(proPaintPart);
			if(list!=null&&list.size()>0){
				resultMap.put("minIndex",list.size());
				resultMap.put("maxIndex",list.get(0).get("parts"));
			}
			return AjaxResult.successData(200,resultMap);
		}else if(proPaintPart.getRoot()==0){
			List<Map<String,Object>> list= proPaintPartService.queryNoRootChaptInfo(proPaintPart);
			if(list!=null&&list.size()>0){

				for (Map<String,Object> map : list){

					if(!StringUtils.isEmpty((String) map.get("rootId"))){
						String title = map.get("rootOrd")+"."+map.get("subject");
						map.put("title",title);
						resList.add(map);
					}
				}
			}
		}
		return AjaxResult.successData(200,resList);
	}


	/**
	 * 检查Name
	 * @param tsysUser
	 * @return
	 */
/*	@ApiOperation(value = "检查Name唯一", notes = "检查Name唯一")
	@PostMapping("/checkNameUnique")
	@ResponseBody
	public int checkNameUnique(ProPaintPart proPaintPart){
		int b=proPaintPartService.checkNameUnique(proPaintPart);
		if(b>0){
			return 1;
		}else{
			return 0;
		}
	}*/


	/**
	 * 检查Name
	 * @param tsysUser
	 * @return
	 */
/*	@ApiOperation(value = "查询绘画分篇序号", notes = "查询绘画分篇序号")
	@PostMapping("/queryPaintPartRoot")
	@ResponseBody
	public AjaxResult queryPaintPartRoot(ProPaintPart proPaintPart){
		int b=proPaintPartService.checkNameUnique(proPaintPart);
		if(b>0){
			return 1;
		}else{
			return 0;
		}
	}*/

	
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
        mmap.put("ProPaintPart", proPaintPartService.selectByPrimaryKey(id));

        return prefix + "/edit";
    }
	
	/**
     * 修改保存
     */
    //@Log(title = "绘画作品分集修改", action = "111")
    @ApiOperation(value = "修改保存", notes = "修改保存")
    @RequiresPermissions("gen:proPaintPart:edit")
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ProPaintPart record)
    {
        return toAjax(proPaintPartService.updateByPrimaryKeySelective(record));
    }

    
    /**
   	 * 根据主键查询
   	 * 
   	 * @param id
   	 * @return
   	 */
   	@ApiOperation(value = "根据id查询唯一", notes = "根据id查询唯一")
   	@PostMapping("/get/{id}")
   	public ProPaintPart edit(@PathVariable("id") String id) {
   		return proPaintPartService.selectByPrimaryKey(id);
   	}
    

	
}
