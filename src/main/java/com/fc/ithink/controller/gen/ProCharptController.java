package com.fc.ithink.controller.gen;

import cn.hutool.core.util.StrUtil;
import com.fc.ithink.common.base.BaseController;
import com.fc.ithink.common.domain.AjaxResult;
import com.fc.ithink.common.enums.ProStatus;
import com.fc.ithink.model.auto.ProContent;
import com.fc.ithink.model.auto.ProLiter;
import com.fc.ithink.model.custom.Tablepar;
import com.fc.ithink.model.auto.ProCharpt;
import com.fc.ithink.service.ProCharptService;
import com.fc.ithink.service.ProContentService;
import com.fc.ithink.service.ProLiterService;
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
 * 文学作品章节Controller
 * @ClassName: ProCharptController
 * @author xy
 * @date 2021-05-27 16:41:56
 */
@Api(value = "文学作品章节")
@Controller
@RequestMapping("/ProCharptController")
public class ProCharptController extends BaseController{
	
	private String prefix = "gen/proCharpt";
	
	@Autowired
	private ProCharptService proCharptService;

	@Autowired
	private ProLiterService proLiterService;

	@Autowired
	private ProContentService proContentService;

	/**
	 * 分页跳转
	 */
	@ApiOperation(value = "分页跳转", notes = "分页跳转")
	@GetMapping("/view")
	@RequiresPermissions("gen:proCharpt:view")
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
	@RequiresPermissions("gen:proCharpt:list")
	@ResponseBody
	public Object list(Tablepar tablepar,ProCharpt record){
		record.setCreateBy(ShiroUtils.getUserId());
		record.setIsDel(0);
		record.setRoot(0);
		record.setFinish(0);
		record.setIsLock(0);
		PageInfo<ProCharpt> page=proCharptService.list(tablepar,record,true) ;
		return  pageTable(page.getList(),page.getTotal());
	}


	/**
	 * 分页跳转
	 */
	@ApiOperation(value = "分页跳转", notes = "分页跳转")
	@RequestMapping("/view2")
	@RequiresPermissions("gen:proLiter:view")
	public String view2(ModelMap model,String uid)
	{
		model.addAttribute("bookId",uid);
		String str="文学作品章节";
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
	@RequestMapping("/list2")
	@RequiresPermissions("gen:proCharpt:list2")
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


	@ApiOperation(value = "查询根信息", notes = "查询根信息")
	@PostMapping("/queryRootInfo")
	@ResponseBody
	public AjaxResult queryRootInfo(ProCharpt proCharpt,String bookId){
		proCharpt.setBookId(bookId);
		Map<String,Object> resultMap = new HashMap<>();
		List<Map<String,Object>> resList = new ArrayList<>();
		if(proCharpt.getRoot()==1){//根
			List<Map<String,Object>> list= proCharptService.queryRootInfo(proCharpt);
			if(list!=null&&list.size()>0){
				resultMap.put("minIndex",list.size());
				resultMap.put("maxIndex",list.get(0).get("parts"));
			}
			return AjaxResult.successData(200,resultMap);
		}else if(proCharpt.getRoot()==0){
			List<Map<String,Object>> list= proCharptService.queryNoRootChaptInfo(proCharpt);
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
	 * 新增跳转
	 */
	@ApiOperation(value = "新增跳转", notes = "新增跳转")
	@GetMapping("/add")
	public String add(ModelMap modelMap,String bookId)
	{

		ProLiter data = proLiterService.selectByPrimaryKey(bookId);

		modelMap.addAttribute("bookId", bookId);
		modelMap.addAttribute("rootmaxIndex",data.getCharpter());
		modelMap.addAttribute("maxIndex",data.getSection());
		ProCharpt set = new ProCharpt();
		set.setRoot(1);
		set.setBookId(bookId);
		List<Map<String,Object>> list= proCharptService.queryNoRootChaptInfo(set);
		if(list!=null&&list.size()>0){

			for (Map<String,Object> map : list){
				map.put("title",map.get("rootOrd")+"."+map.get("title"));
			}
		}
		modelMap.addAttribute("titles",list);
		return prefix + "/add";

	}

	/**
	 * 新增
	 */
	//@Log(title = "文学作品章节新增", action = "111")
	@ApiOperation(value = "新增", notes = "新增")
	@PostMapping("/add")
	@RequiresPermissions("gen:proCharpt:add")
	@ResponseBody
	public AjaxResult add(ProCharpt proCharpt){

		ProLiter data = proLiterService.selectByPrimaryKey(proCharpt.getBookId());

		if(data.getFinish()== ProStatus.finish.getValue()||
				data.getFinish()==ProStatus.apply.getValue()||
				data.getFinish()==ProStatus.noFinish.getValue()){
			return error("作品不能新增章节信息");
		}
		Map<String,Object> map = proCharptService.selectChaptCountByBookId(proCharpt);

		Date now = DateUtils.getNowDate();//当前时间
		proCharpt.setFinish(ProStatus.edit.getValue());
		proCharpt.setCreateBy(ShiroUtils.getUserId());
		proCharpt.setCreateDat(now);
		proCharpt.setChapType(data.getTyp());
		proCharpt.setLUpdateDat(now);
		if(proCharpt.getRoot()==1){//根节点
			if (map.get("parts") == map.get("count")) {
				return AjaxResult.error("分篇已满");
			}
			proCharpt.setRootId(null);
			proCharpt.setOrd(null);
			proCharpt.setPoemId(null);
			proCharpt.setPaintId(null);

		}else if(proCharpt.getRoot()==0){//非根节点
			if (map.get("section") == map.get("count")) {
				return AjaxResult.error("章节已满");
			}
			proCharpt.setRootOrd(null);
		}
		if(proCharpt.getPaintId()!=null&&proCharpt.getPaintId()==0){
			proCharpt.setPaintId(null);
		}
		if (proCharpt.getPoemId()!=null&&proCharpt.getPoemId()==0){
			proCharpt.setPoemId(null);
		}
		int b= proCharptService.insertSelective(proCharpt);
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
	//@Log(title = "文学作品章节删除", action = "111")
	@ApiOperation(value = "删除", notes = "删除")
	@PostMapping("/remove")
	@RequiresPermissions("gen:proCharpt:remove")
	@ResponseBody
	public AjaxResult remove(String ids,Integer root){


		ProCharpt data = new ProCharpt();

		data.setCreateBy(ShiroUtils.getUserId());
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
	 * 完成
	 * @param ids
	 * @return
	 */
	//@Log(title = "绘画作品分集完成", action = "111")
	@ApiOperation(value = "完成", notes = "完成")
	@PostMapping("/finish")
	@RequiresPermissions("gen:proCharpt:finish")
	@ResponseBody
	public AjaxResult finish(Integer ids){
		ProCharpt data = new ProCharpt();
		data.setId(new Long(ids));
		ProContent proContent = new ProContent();
		proContent.setCharpId(new Long(ids));
		Tablepar tablepar = new Tablepar();
		tablepar.setPage(0);
		tablepar.setLimit(10);
		PageInfo<ProContent> pageInfo = proContentService.queryAdoptContentList(tablepar,proContent);
		if(pageInfo.getList()==null||pageInfo.getList().size()==0){
			return error("该章节没有采纳什么创作,不能结束");
		}
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
	@RequiresPermissions("gen:proCharpt:edit")
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(ProCharpt record)
	{
		if(StringUtils.isEmpty(record.getPic())){
			record.setPic(null);
		}
		if(record.getPaintId()!=null&&record.getPaintId()==0){
			record.setPaintId(null);
		}
		if (record.getPoemId()!=null&&record.getPoemId()==0){
			record.setPoemId(null);
		}
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
