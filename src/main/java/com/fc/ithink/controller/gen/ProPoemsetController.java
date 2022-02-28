package com.fc.ithink.controller.gen;

import cn.hutool.core.util.StrUtil;
import com.fc.ithink.common.base.BaseController;
import com.fc.ithink.common.domain.AjaxResult;
import com.fc.ithink.common.enums.ProStatus;
import com.fc.ithink.model.auto.ProPoetry;
import com.fc.ithink.model.custom.Tablepar;
import com.fc.ithink.model.auto.ProPoemset;
import com.fc.ithink.service.ProPoemsetService;
import com.fc.ithink.service.ProPoetryService;
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
 * 诗歌作品分集Controller
 * @ClassName: ProPoemsetController
 * @author xy
 * @date 2021-06-07 14:24:22
 */
@Api(value = "诗歌作品分集")
@Controller
@RequestMapping("/ProPoemsetController")
public class ProPoemsetController extends BaseController{
	
	private String prefix = "gen/proPoemset";

	@Autowired
	private ProPoemsetService proPoemsetService;
	@Autowired
	private ProPoetryService proPoetryService;
	/**
	 * 分页跳转
	 */
	@ApiOperation(value = "分页跳转", notes = "分页跳转")
	@GetMapping("/view")
	@RequiresPermissions("gen:proPoemset:view")
	public String view(ModelMap model)
	{
		String str="诗歌作品分集";
		return prefix + "/list";
	}

	/**
	 * 分页查询
	 */
	//@Log(title = "诗歌作品分集集合查询", action = "111")
	@ApiOperation(value = "分页查询", notes = "分页查询")
	@GetMapping("/list")
	@RequiresPermissions("gen:proPoemset:list")
	@ResponseBody
	public Object list(Tablepar tablepar,ProPoemset record){
		record.setCreateBy(ShiroUtils.getUserId());
		record.setIsDel(0);
		record.setRoot(0);
		record.setFinish(0);
		record.setIsLock(0);
		PageInfo<ProPoemset> page=proPoemsetService.listByCreateBy(tablepar,record) ;
		return  pageTable(page.getList(),page.getTotal());
	}

	/**
	 * 分页跳转
	 */
	@ApiOperation(value = "分页跳转", notes = "分页跳转")
	@GetMapping("/view2")
	@RequiresPermissions("gen:proPoemset:view")
	public String view2(ModelMap model,String uid)
	{
		model.addAttribute("poetryId",uid);
		String str="诗歌作品分集";
		return prefix + "/list2";
	}

	/**
	 * 完成
	 * @param ids
	 * @return
	 */
	//@Log(title = "绘画作品分集完成", action = "111")
	@ApiOperation(value = "完成", notes = "完成")
	@PostMapping("/finish")
	@RequiresPermissions("gen:proPoemset:finish")
	@ResponseBody
	public AjaxResult finish(Integer ids){
		ProPoemset data = new ProPoemset();
		data.setId(new Long(ids));
		data.setFinish(ProStatus.finish.getValue());
		int b = proPoemsetService.updateByPrimaryKeySelective(data);
		if(b>0){
			return success();
		}else{
			return error();
		}
	}

	/**
	 * 分页查询
	 */
	//@Log(title = "绘画作品分集集合查询", action = "111")
	@ApiOperation(value = "分页查询", notes = "分页查询")
	@GetMapping("/list2")
	@RequiresPermissions("gen:proPoemset:list2")
	@ResponseBody
	public Object list2(Tablepar tablepar,ProPoemset record,String poetryId){

		record.setPoetryId(poetryId);
		record.setIsDel(0);
		//搜索
		if(StrUtil.isNotEmpty(tablepar.getSearchText())) {//小窗体
			record.setCharpter(tablepar.getSearchText());
		}
		PageInfo<ProPoemset> page=proPoemsetService.list(tablepar,record,true) ;
		return  pageTable(page.getList(),page.getTotal());
	}

	/**
	 * 检查Name
	 * @param proPoemset
	 * @return
	 */
	@ApiOperation(value = "查询根信息", notes = "查询根信息")
	@PostMapping("/queryRootInfo")
	@ResponseBody
	public AjaxResult queryRootInfo(ProPoemset proPoemset,String poetryId){
		proPoemset.setPoetryId(poetryId);
		Map<String,Object> resultMap = new HashMap<>();
		List<Map<String,Object>> resList = new ArrayList<>();
		if(proPoemset.getRoot()==1){//根
			/*List<Map<String,Object>> list= proPoemsetService.queryRootInfo(proPoemset);
			if(list!=null&&list.size()>0){
				resultMap.put("minIndex",list.size());
				resultMap.put("maxIndex",list.get(0).get("charpter"));
			}*/
			return AjaxResult.successData(200,resultMap);
		}else if(proPoemset.getRoot()==0){
			proPoemset.setRoot(1);
			List<Map<String,Object>> list= proPoemsetService.queryNoRootChaptInfo(proPoemset);
			if(list!=null&&list.size()>0){

				for (Map<String,Object> map : list){
					map.put("title",map.get("rootOrd")+"."+map.get("charpter"));
					resList.add(map);
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
	public String add(ModelMap modelMap,String poetryId)
	{
		ProPoetry data = proPoetryService.selectByPrimaryKey(poetryId);

		modelMap.addAttribute("poetryId", poetryId);
		modelMap.addAttribute("rootmaxIndex",data.getCharpter());
		modelMap.addAttribute("maxIndex",data.getSection());
		ProPoemset set = new ProPoemset();
		set.setRoot(1);
		set.setPoetryId(poetryId);
		List<Map<String,Object>> list= proPoemsetService.queryNoRootChaptInfo(set);
		if(list!=null&&list.size()>0){

			for (Map<String,Object> map : list){
				map.put("title",map.get("rootOrd")+"."+map.get("charpter"));
			}
		}
		modelMap.addAttribute("chapters",list);
		return prefix + "/add";
	}

	/**
	 * 新增
	 */
	//@Log(title = "诗歌作品分集新增", action = "111")
	@ApiOperation(value = "新增", notes = "新增")
	@PostMapping("/add")
	@RequiresPermissions("gen:proPoemset:add")
	@ResponseBody
	public AjaxResult add(ProPoemset proPoemset){

		ProPoetry data = proPoetryService.selectByPrimaryKey(proPoemset.getPoetryId());

		if(data.getFinish()==ProStatus.finish.getValue()||
				data.getFinish()==ProStatus.apply.getValue()||
				data.getFinish()==ProStatus.noFinish.getValue()){
			return error("作品不能新增分作信息");
		}
		proPoemset.setCreateBy(ShiroUtils.getUserId());
		Map<String,Object> map = proPoemsetService.queryChapterCountByPoetryId(proPoemset);

		Date now = DateUtils.getNowDate();//当前时间
		proPoemset.setFinish(ProStatus.edit.getValue());
		proPoemset.setChapType(data.getKind());
		proPoemset.setCreateDat(now);
		proPoemset.setLUpdateDat(now);
		if(proPoemset.getRoot()==1){//根节点


			int count1 = (int)map.get("charpter");
			Long count2 = (Long)map.get("count");
			int count3 = count2.intValue();
			if (count1==count3) {
				return AjaxResult.error("分作已满");
			}

			proPoemset.setRootId(null);
			proPoemset.setOrd(null);
			proPoemset.setPaintId(null);
			proPoemset.setLiterId(null);

		}else if(proPoemset.getRoot()==0){//非根节点
			int count1 = (int)map.get("section");
			Long count2 = (Long)map.get("count");
			int count3 = count2.intValue();
			if (count1==count3) {
				return AjaxResult.error("分作已满");
			}
			proPoemset.setRootOrd(null);
		}

		if(proPoemset.getPaintId()!=null&&proPoemset.getPaintId()==0){
			proPoemset.setPaintId(null);
		}
		if (proPoemset.getLiterId()!=null&&proPoemset.getLiterId()==0){
			proPoemset.setLiterId(null);
		}
		int b=proPoemsetService.insertSelective(proPoemset);
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
	//@Log(title = "诗歌作品分集删除", action = "111")
	@ApiOperation(value = "删除", notes = "删除")
	@PostMapping("/remove")
	@RequiresPermissions("gen:proPoemset:remove")
	@ResponseBody
	public AjaxResult remove(String ids,Integer root){
		ProPoemset data = new ProPoemset();

		data.setCreateBy(ShiroUtils.getUserId());
		if(root==1){
			Tablepar tablepar = new Tablepar();
			data.setRoot(0);
			data.setRootId(new Long(ids));
			tablepar.setPage(0);
			tablepar.setLimit(15);
			PageInfo<ProPoemset> pageInfo= proPoemsetService.listByCreateBy(tablepar,data);
			if(pageInfo!=null&&pageInfo.getList()!=null&&pageInfo.getList().size()>0){
				return error("主节点还存在子节点");
			}
		}
		data.setId(new Long(ids));
		data.setRootId(null);
		data.setRoot(null);
		data.setIsDel(1);
		int b = proPoemsetService.updateByPrimaryKeySelective(data);
		//int b=proPoemsetService.deleteByPrimaryKey(ids);
		if(b>0){
			return success();
		}else{
			return error();
		}
	}

	/**
	 * 检查Name
	 * @param proPoemset
	 * @return
	 */
/*	@ApiOperation(value = "检查Name唯一", notes = "检查Name唯一")
	@PostMapping("/checkNameUnique")
	@ResponseBody
	public int checkNameUnique(ProPoemset proPoemset){
		int b=proPoemsetService.checkNameUnique(proPoemset);
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

		mmap.put("ProPoemset", proPoemsetService.selectByPrimaryKey(id));

		return prefix + "/edit";
	}

	/**
	 * 修改保存
	 */
	//@Log(title = "诗歌作品分集修改", action = "111")
	@ApiOperation(value = "修改保存", notes = "修改保存")
	@RequiresPermissions("gen:proPoemset:edit")
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(ProPoemset record)
	{
		if(StringUtils.isEmpty(record.getPic())){
			record.setPic(null);
		}
		if(record.getPaintId()!=null&&record.getPaintId()==0){
			record.setPaintId(null);
		}
		if (record.getLiterId()!=null&&record.getLiterId()==0){
			record.setLiterId(null);
		}
		return toAjax(proPoemsetService.updateByPrimaryKeySelective(record));
	}


	/**
	 * 根据主键查询
	 *
	 * @param id
	 * @return
	 */
	@ApiOperation(value = "根据id查询唯一", notes = "根据id查询唯一")
	@PostMapping("/get/{id}")
	public ProPoemset edit(@PathVariable("id") String id) {
		return proPoemsetService.selectByPrimaryKey(id);
	}


}
