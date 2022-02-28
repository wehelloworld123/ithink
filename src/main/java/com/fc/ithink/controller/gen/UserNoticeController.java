package com.fc.ithink.controller.gen;

import com.fc.ithink.common.base.BaseController;
import com.fc.ithink.common.domain.AjaxResult;
import com.fc.ithink.common.domain.ResultTable;
import com.fc.ithink.common.support.ConvertUtil;
import com.fc.ithink.model.auto.SysNotice;
import com.fc.ithink.model.auto.SysNoticeUser;
import com.fc.ithink.model.custom.Tablepar;
import com.fc.ithink.service.SysNoticeService;
import com.fc.ithink.service.SysNoticeUserService;
import com.fc.ithink.shiro.util.ShiroUtils;
import com.fc.ithink.util.SnowflakeIdWorker;
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
import java.util.List;

/**
 * 公告Controller
 * @ClassName: SysNoticeController
 * @author fuce
 * @date 2019-11-20 22:31
 */
@Api(value = "公告")
@Controller
@RequestMapping("/UserNoticeController")
public class UserNoticeController extends BaseController{

    private final String prefix = "gen/userNotice";
    @Autowired
    private SysNoticeService sysNoticeService;

    @Autowired
    private SysNoticeUserService sysNoticeUserService;
    /**
     * 展示页面跳转
     * @param model
     * @return
     * @author fuce
     * @Date 2019年11月11日 下午4:09:24
     */
    @ApiOperation(value = "分页跳转", notes = "分页跳转")
    @GetMapping("/view")
    @RequiresPermissions("gen:userNotice:view")
    public String view(ModelMap model)
    {
        return prefix + "/list";
    }
    /**
     * list页面
     * @param tablepar
     * @param searchText
     * @return
     * @author fuce
     * @Date 2019年11月11日 下午4:09:35
     */
    //@Log(title = "公告集合查询", action = "111")
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/list")
    @RequiresPermissions("gen:userNotice:list")
    @ResponseBody
    public ResultTable list(Tablepar tablepar, String searchText){

        PageInfo<SysNotice> page=sysNoticeService.listByUserId(tablepar, StringUtils.isEmpty(searchText)?null:searchText,ShiroUtils.getUserId()) ;
        return pageTable(page.getList(),page.getTotal());
    }


    /**
     * 对应的用户的展示页面
     * @param model
     * @return
     * @author fuce
     * @Date 2019年11月11日 下午4:09:42
     */
    @ApiOperation(value = "对应的用户的展示页面", notes = "对应的用户的展示页面")
    @GetMapping("/viewUser")
    public String viewUser(ModelMap model)
    {
        return prefix + "/list";
    }
    /**
     * 根据公告id查询跳转到公告详情页面
     * @param tablepar
     * @param searchText
     * @return
     */
    @ApiOperation(value = "table根据公告id查询跳转到公告详情页面", notes = "table根据公告id查询跳转到公告详情页面")
    @PostMapping("/viewUserlist")
    @ResponseBody
    public ResultTable viewUserlist(Tablepar tablepar,String searchText)
    {
        PageInfo<SysNotice> page=sysNoticeService.list(ShiroUtils.getUser(), tablepar, searchText);
        return pageTable(page.getList(),page.getTotal());
    }

    /**
     * 新增跳转
     * @param modelMap
     * @return
     */
    @ApiOperation(value = "新增跳转", notes = "新增跳转")
    @GetMapping("/add")
    public String add(ModelMap modelMap)
    {
        return prefix + "/add";
    }
    /**
     * 新增保存
     * @param sysNotice
     * @return
     * @author fuce
     * @Date 2019年11月11日 下午4:07:09
     */
    //@Log(title = "公告新增", action = "111")
    @ApiOperation(value = "新增", notes = "新增")
    @PostMapping("/add")
    @RequiresPermissions("gen:userNotice:add")
    @ResponseBody
    public AjaxResult add(SysNotice sysNotice){
        int b=sysNoticeService.insertSelective(sysNotice);
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
     **/
    //@Log(title = "公告删除", action = "111")
    @ApiOperation(value = "删除", notes = "删除")
    @DeleteMapping("/remove")
    @RequiresPermissions("gen:userNotice:remove")
    @ResponseBody
    public AjaxResult remove(String ids){
        if(StringUtils.isEmpty(ids)){
            return error("没有选择数据");
        }
        List<String> lista= ConvertUtil.toListStrArray(ids);
        List<SysNoticeUser> noticeUsers = new ArrayList<>();
        for (String s :lista){
            SysNoticeUser noticeUser=new SysNoticeUser(SnowflakeIdWorker.getUUID(), s, ShiroUtils.getUserId(), 3);
            noticeUsers.add(noticeUser);
        }
        int b = sysNoticeUserService.insertBatch(noticeUsers);

        if(b>0){
            return success();
        }else{
            return error();
        }
    }



    /**
     * 检查
     * @param sysNotice
     * @return
     */
    @ApiOperation(value = "检查Name唯一", notes = "检查Name唯一")
    @PostMapping("/checkNameUnique")
    @ResponseBody
    public int checkNameUnique(SysNotice sysNotice){
        int b=sysNoticeService.checkNameUnique(sysNotice);
        if(b>0){
            return 1;
        }else{
            return 0;
        }
    }

    /**
     * 根据公告id查询跳转到公告详情页面
     * @param id
     * @param mmap
     * @return
     */
    //@Log(title = "字典数据表删除", action = "1")
    @ApiOperation(value = "根据公告id查询跳转到公告详情页面", notes = " 根据公告id查询跳转到公告详情页面")
    @GetMapping("/viewinfo/{id}")
    public String viewinfo(@PathVariable("id") String id,ModelMap mmap)
    {
        SysNotice notice= sysNoticeService.selectByPrimaryKey(id);
        mmap.addAttribute("notice", notice);
        //把推送给该用户的公告设置为已读
        sysNoticeService.editUserState(id);
        return prefix + "/view";
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
        mmap.put("SysNotice", sysNoticeService.selectByPrimaryKey(id));

        return prefix + "/edit";
    }

    /**
     * 修改保存
     */
    //@Log(title = "公告修改", action = "111")
    @ApiOperation(value = "修改保存", notes = "修改保存")
    @RequiresPermissions("gen:userNotice:edit")
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SysNotice record)
    {
        return toAjax(sysNoticeService.updateByPrimaryKeySelective(record));
    }




}
