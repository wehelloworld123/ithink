package com.fc.ithink.controller.gen;

import com.fc.ithink.common.base.BaseController;
import com.fc.ithink.common.constant.ProjectConstant;
import com.fc.ithink.common.domain.AjaxResult;
import com.fc.ithink.common.enums.RecomType;
import com.fc.ithink.model.auto.*;
import com.fc.ithink.model.custom.Tablepar;
import com.fc.ithink.model.custom.messagePush.messagePush.PushMessage;
import com.fc.ithink.service.ProPoemsetService;
import com.fc.ithink.service.ProPoetryContentService;
import com.fc.ithink.service.ProUserAdoptService;
import com.fc.ithink.service.UserClientService;
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
import java.util.Map;

/**
 * 诗歌创作内容Controller
 * @ClassName: ProPoetryContentController
 * @author xy
 * @date 2021-06-07 14:25:00
 */
@Api(value = "诗歌创作内容")
@Controller
@RequestMapping("/ProPoetryContentController")
public class ProPoetryContentController extends BaseController{
	
	private String prefix = "gen/proPoetryContent";
	@Autowired
	private ProPoetryContentService proPoetryContentService;
	@Autowired
	private ProPoemsetService proPoemsetService;
	@Autowired
	private UserClientService userClientService;
	@Autowired
	private ProUserAdoptService proUserAdoptService;


	/**
	 * 分页跳转
	 */
	@ApiOperation(value = "分页跳转", notes = "分页跳转")
	@GetMapping("/view")
	@RequiresPermissions("gen:proPoetryContent:view")
	public String view(ModelMap model)
	{
		String str="诗歌创作内容";
		return prefix + "/list";
	}

	/**
	 * 分页查询
	 */
	//@Log(title = "诗歌创作内容集合查询", action = "111")
	@ApiOperation(value = "分页查询", notes = "分页查询")
	@GetMapping("/list")
	@RequiresPermissions("gen:proPoetryContent:list")
	@ResponseBody
	public Object list(Tablepar tablepar,ProPoetryContent record){
		record.setCreateBy(ShiroUtils.getUserId());
		record.setAdopt(1);
		record.setTyp(RecomType.POEMTY.getValue());
		PageInfo<ProPoetryContent> page=proPoetryContentService.queryAdoptContentListByUserId(tablepar,record) ;
		return  pageTable(page.getList(),page.getTotal());
	}



	/**
	 * 分页跳转
	 */
	@ApiOperation(value = "分页跳转", notes = "分页跳转")
	@GetMapping("/view3")
	@RequiresPermissions("gen:proPoetryContent:view")
	public String view3(ModelMap model,Long no)
	{
		model.addAttribute("charpId",no);
		String str="诗歌创作内容";
		return prefix + "/list3";
	}

	/**
	 * 分页查询
	 */
	//@Log(title = "诗歌作品分集集合查询", action = "111")
	@ApiOperation(value = "分页查询", notes = "分页查询")
	@GetMapping("/list3")
	@RequiresPermissions("gen:proPoetryContent:list3")
	@ResponseBody
	public Object list3(Tablepar tablepar,ProPoetryContent record,Long charpId){
		record.setCharpId(charpId);
		PageInfo<ProPoetryContent> page=proPoetryContentService.queryAdoptContentList(tablepar,record) ;
		return  pageTable(page.getList(),page.getTotal());
	}

	/**
	 * 采纳
	 */
	//@Log(title = "采纳", action = "111")
	@ApiOperation(value = "采纳", notes = "采纳")
	@RequiresPermissions("gen:proPoetryContent:adopt")
	@PostMapping("/adopt")
	@ResponseBody
	public AjaxResult adopt(String no,Long charpId)
	{
		if(!StringUtils.isEmpty(no)&&charpId!=null) {
			ProPoetryContent record = new ProPoetryContent();
			record.setNo(no);
			record.setAdopt(1);
			record.setCharpId(charpId);
			int i = proPoetryContentService.selectAdoptCount(record);
			if (i == 0) {
				ProPoetryContent proContent = proPoetryContentService.selectByPrimaryKey(no);
				Map<String,Object> map = proPoemsetService.queryProductInfoByChaptId(new ProPoemset(new Long(charpId)));
				if(!StringUtils.isEmpty(proContent.getCreateBy())) {
					UserClientExample example = new UserClientExample();
					example.createCriteria().andUserIdEqualTo(proContent.getCreateBy());
					example.createCriteria().andIsDelEqualTo(0);
					//List<UserClient> list = userClientService.selectByExample(example);
					PushMessage pushMessage = new PushMessage();
					pushMessage.setTitle(ProjectConstant.SYS_TITLE);
					String poetryName = map.get("seter")+"-"+ map.get("poetryName");
					String title = (String) map.get("charpter");
					String context = "您的作品 《" + proContent.getTitle() + "》被《" + poetryName + "》章节：" + title + "邀请采纳!";
					pushMessage.setContent(context);
					/*GeTuiUtil.sendMessageAndroid(pushMessage, list);
					GeTuiUtil.sendMessageIos(pushMessage, list);*/
					ProUserAdopt userAdopt = new ProUserAdopt();
					userAdopt.setTitle(proContent.getTitle());

					userAdopt.setContent(proContent.getContent());
					userAdopt.setProNo(proContent.getNo());
					userAdopt.setContentId(proContent.getNo());
					userAdopt.setCreationNm(proContent.getTitle());
					userAdopt.setCreationId(proContent.getPoetryId());
					userAdopt.setCreationNm(proContent.getPoetryName());
					userAdopt.setUserId(proContent.getCreateBy());
					userAdopt.setNickname(proContent.getCreator());
					userAdopt.setCharpId(proContent.getCharpId());
					userAdopt.setCharpNm(proContent.getCharpName());
					userAdopt.setTyp(RecomType.POEMTY.getValue());
					userAdopt.setAdopt(1);
					Date now = DateUtils.getNowDate();
					userAdopt.setCreateBy(ShiroUtils.getUserId());
					userAdopt.setCreateDat(now);
					userAdopt.setLUpdateDat(now);
					int b = proUserAdoptService.insertSelective(userAdopt);
					if(b>0) {
						record.setLUpdateDat(DateUtils.getNowDate());
						return toAjax(proPoetryContentService.updateByPrimaryKeySelective(record));
					}else{
						return error("采纳失败");
					}
				}else{
					return error("作者不存在");
				}

			} else {
				return error("不可重复采纳");
			}
		}else {
			return toAjax(0);
		}
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
	 * 新增
	 */
	//@Log(title = "诗歌创作内容新增", action = "111")
	@ApiOperation(value = "新增", notes = "新增")
	@PostMapping("/add")
	@RequiresPermissions("gen:proPoetryContent:add")
	@ResponseBody
	public AjaxResult add(ProPoetryContent proPoetryContent){
		int b=proPoetryContentService.insertSelective(proPoetryContent);
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
	//@Log(title = "诗歌创作内容删除", action = "111")
	@ApiOperation(value = "删除", notes = "删除")
	@PostMapping("/remove")
	@RequiresPermissions("gen:proPoetryContent:remove")
	@ResponseBody
	public AjaxResult remove(String ids){
		int b=proPoetryContentService.deleteBatchByPrimaryKey(ids);
		if(b>0){
			return success();
		}else{
			return error();
		}
	}

	/**
	 * 检查Name
	 * @param proPoetryContent
	 * @return
	 */
/*	@ApiOperation(value = "检查Name唯一", notes = "检查Name唯一")
	@PostMapping("/checkNameUnique")
	@ResponseBody
	public int checkNameUnique(ProPoetryContent proPoetryContent){
		int b=proPoetryContentService.checkNameUnique(proPoetryContent);
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
	public String edit(@PathVariable("id") String id, String adopt,ModelMap mmap)
	{
		mmap.put("ProPoetryContent", proPoetryContentService.selectUserContentByPrimaryKey(id));
		if(adopt!=null&&"1".equals(adopt)){
			mmap.put("adopt","1");
		}else {
			mmap.put("adopt","0");
		}
		return prefix + "/edit";
	}

	/**
	 * 修改保存
	 */
	//@Log(title = "诗歌创作内容修改", action = "111")
	@ApiOperation(value = "修改保存", notes = "修改保存")
	@RequiresPermissions("gen:proPoetryContent:edit")
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(ProPoetryContent record)
	{
		return toAjax(proPoetryContentService.updateByPrimaryKeySelective(record));
	}


	/**
	 * 根据主键查询
	 *
	 * @param id
	 * @return
	 */
	@ApiOperation(value = "根据id查询唯一", notes = "根据id查询唯一")
	@PostMapping("/get/{id}")
	public ProPoetryContent edit(@PathVariable("id") String id) {
		return proPoetryContentService.selectByPrimaryKey(id);
	}




}
