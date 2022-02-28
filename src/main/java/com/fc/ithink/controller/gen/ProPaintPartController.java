package com.fc.ithink.controller.gen;

import cn.hutool.core.util.StrUtil;
import com.fc.ithink.common.base.BaseController;
import com.fc.ithink.common.domain.AjaxResult;
import com.fc.ithink.common.enums.ProStatus;
import com.fc.ithink.model.auto.ProPaint;
import com.fc.ithink.model.custom.Tablepar;
import com.fc.ithink.model.auto.ProPaintPart;
import com.fc.ithink.service.ProPaintPartService;
import com.fc.ithink.service.ProPaintService;
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

import java.util.*;

/**
 * 绘画作品分集Controller
 * @ClassName: ProPaintPartController
 * @author xy
 * @date 2021-06-07 14:26:54
 */
@Api(value = "绘画作品分集")
@Controller
@RequestMapping("/ProPaintPartController")
public class ProPaintPartController extends BaseController{
	
	private String prefix = "gen/proPaintPart";
	@Autowired
	private ProPaintPartService proPaintPartService;
	@Autowired
	private ProPaintService proPaintService;
	/**
	 * 分页跳转
	 */
	@ApiOperation(value = "分页跳转", notes = "分页跳转")
	@GetMapping("/view2")
	@RequiresPermissions("gen:proPaint:view")
	public String view2(ModelMap model,String uid)
	{
		model.addAttribute("paintId",uid);
		String str="绘画作品分集";
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
	@RequiresPermissions("gen:proPaintPart:list2")
	@ResponseBody
	public Object list2(Tablepar tablepar,ProPaintPart record,String paintId){

		record.setPaintId(paintId);
		record.setIsDel(0);
		//搜索
		if(StrUtil.isNotEmpty(tablepar.getSearchText())) {//小窗体
			record.setSubject(tablepar.getSearchText());
		}
		PageInfo<ProPaintPart> page=proPaintPartService.list(tablepar,record,true) ;
		return  pageTable(page.getList(),page.getTotal());
	}

	/**
	 * 分页跳转
	 */
	@ApiOperation(value = "分页跳转", notes = "分页跳转")
	@GetMapping("/view")
	@RequiresPermissions("gen:proPaintPart:view")
	public String view(ModelMap model)
	{
		String str="绘画作品未完成分集";
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
	@RequiresPermissions("gen:proPaintPart:list")
	@ResponseBody
	public Object list(Tablepar tablepar,ProPaintPart record){
		record.setCreateBy(ShiroUtils.getUserId());
		record.setIsDel(0);
		record.setRoot(0);
		record.setFinish(0);
		record.setIsLock(0);
		PageInfo<ProPaintPart> page=proPaintPartService.listByCreateBy(tablepar,record) ;
		return  pageTable(page.getList(),page.getTotal());
	}


	/**
	 * 新增跳转
	 */
	@ApiOperation(value = "新增跳转", notes = "新增跳转")
	@GetMapping("/add")
	public String add(ModelMap modelMap,String paintId)
	{

		ProPaint data = proPaintService.selectByPrimaryKey(paintId);

		modelMap.addAttribute("paintId", paintId);
		modelMap.addAttribute("rootmaxIndex",data.getParts());
		modelMap.addAttribute("maxIndex",data.getSection());
		ProPaintPart set = new ProPaintPart();
		set.setRoot(1);
		set.setPaintId(paintId);
		List<Map<String,Object>> list= proPaintPartService.queryNoRootChaptInfo(set);
		if(list!=null&&list.size()>0){

			for (Map<String,Object> map : list){
				map.put("title",map.get("rootOrd")+"."+map.get("subject"));
			}
		}
		modelMap.addAttribute("parts",list);
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

		ProPaint data = proPaintService.selectByPrimaryKey(proPaintPart.getPaintId());

		if(data.getFinish()== ProStatus.finish.getValue()||
				data.getFinish()==ProStatus.apply.getValue()||
				data.getFinish()==ProStatus.noFinish.getValue()){
			return error("作品不能新增分篇信息");
		}
		Map<String,Object> map = proPaintPartService.selectPartCountByPaintId(proPaintPart);

		Date now = DateUtils.getNowDate();//当前时间
		proPaintPart.setFinish(ProStatus.edit.getValue());
		proPaintPart.setCreateBy(ShiroUtils.getUserId());
		proPaintPart.setCreateDat(now);
		proPaintPart.setLUpdateDat(now);
		if(proPaintPart.getRoot()==1){//根节点
			if (map.get("parts") == map.get("count")) {
				return AjaxResult.error("分篇已满");
			}
			proPaintPart.setRootId(null);
			proPaintPart.setOrd(null);
			proPaintPart.setPoemId(null);
			proPaintPart.setLiterId(null);

		}else if(proPaintPart.getRoot()==0){//非根节点
			if (map.get("section") == map.get("count")) {
				return AjaxResult.error("章节已满");
			}
			proPaintPart.setRootOrd(null);
		}
		if(proPaintPart.getPoemId()!=null&&proPaintPart.getPoemId()==0){
			proPaintPart.setPoemId(null);
		}
		if (proPaintPart.getLiterId()!=null&&proPaintPart.getLiterId()==0){
			proPaintPart.setLiterId(null);
		}
		int b=proPaintPartService.insertSelective(proPaintPart);
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
	@PostMapping("/remove")
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
	 * @param paintId
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
	 * @param proPaintPart
	 * @return
	 */
	/*@ApiOperation(value = "检查Name唯一", notes = "检查Name唯一")
	@PostMapping("/checkNameUnique")
	@ResponseBody
	public int checkNameUnique(ProPaintPart proPaintPart){
		int b=proPaintPartService.checkNameUnique(proPaintPart);
		if(b>0){
			return 1;
		}else{
			return 0;
		}
	}
*/

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
		if(StringUtils.isEmpty(record.getPic())){
			record.setPic(null);
		}
		if(record.getPoemId()!=null&&record.getPoemId()==0){
			record.setPoemId(null);
		}
		if (record.getLiterId()!=null&&record.getLiterId()==0){
			record.setLiterId(null);
		}
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
