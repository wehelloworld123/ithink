package com.fc.ithink.controller.admin;

import com.fc.ithink.common.conf.oss.OssTemplate;
import com.fc.ithink.common.domain.AjaxResult;
import com.fc.ithink.common.enums.FileEnum;
import com.fc.ithink.model.auto.SysFile;
import com.fc.ithink.service.SysDatasService;
import com.fc.ithink.shiro.util.ShiroUtils;
import com.fc.ithink.util.SnowflakeIdWorker;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.fc.ithink.common.base.BaseController;
import com.fc.ithink.model.custom.Tablepar;
import com.github.pagehelper.PageInfo;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.Iterator;
import java.util.Map;

/**
 * 文件上传controller
 * @author fuce 
 * @date: 2018年9月16日 下午4:23:50
 */
@Api(value = "文件上传")
@Controller
@RequestMapping("/FileController")
public class FileController extends BaseController{

	//跳转页面参数
	private final String prefix = "admin/file";

	@Autowired
	private  OssTemplate template;

	@Autowired
	private SysDatasService sysDatasService;
	
	/**
	 * 分页展示页面
	 * @param model
	 * @return
	 * @author fuce
	 * @Date 2019年11月20日 下午10:18:32
	 */
	@ApiOperation(value = "分页跳转", notes = "分页跳转")
	@GetMapping("/view")
	@RequiresPermissions("system:file:view")
    public String view(ModelMap model)
    {
    	model.put("bucketURL",template.getOssProperties().getEndpoint()+"/"+template.getOssProperties().getBucketName());
        return prefix + "/list";
    }


	/**
	 * 文件上传
	 * @param request
	 * @return
	 * @author fuce
	 * @Date 2019年11月20日 下午10:18:49
	 */
	//@Log(title = "文件上传", action = "1")
	@ApiOperation(value = "文件上传", notes = "文件上传")
	@PostMapping("/uploadImage")
	@ResponseBody
	public AjaxResult uploadImage(HttpServletRequest request)
	{

		try
		{
			request.setCharacterEncoding("UTF-8");

			String fileType  = request.getParameter("fileType");
			MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

			/** 页面控件的文件流* */
			MultipartFile file = null;
			Map map =multipartRequest.getFileMap();
			for (Iterator i = map.keySet().iterator(); i.hasNext();) {
				Object obj = i.next();
				file=(MultipartFile) map.get(obj);
				if (!file.isEmpty())
				{
					//保存文件
					String fileUrl=sysDatasService.uploadImage2Cos(file, "/"+ FileEnum.valueOfString(fileType)+"/"+ ShiroUtils.getUserId()+"/"+ SnowflakeIdWorker.getUUID()+".jpg");
					if(fileUrl!=null){
						return AjaxResult.successData(200, fileUrl);
					}
				}else {
					return error();
				}
			}
			return error();
		}
		catch (Exception e)
		{
			return error(e.getMessage());
		}
	}
	
	/**
	 * 文件列表
	 * @param tablepar
	 * @param searchText 搜索字符
	 * @return
	 */
	@ApiOperation(value = "分页查询", notes = "分页查询")
	@GetMapping("/list")
	@RequiresPermissions("system:file:list")
	@ResponseBody
	public Object list(Tablepar tablepar,String searchText){
		PageInfo<SysFile> page=sysFileService.list(tablepar,searchText) ;
		return pageTable(page.getList(),page.getTotal());
	}
	
	/**
	 * 新增文件跳转页面
	 * @return
	 * @author fuce
	 * @Date 2019年11月20日 下午10:19:03
	 */
	@ApiOperation(value = "新增跳转", notes = "新增跳转")
    @GetMapping("/add")
    public String add(ModelMap map)
    {
    	map.put("BucketName",template.getOssProperties().getBucketName());
        return prefix + "/add";
    }

	
	/**
	 * 检查文件名字
	 * @param tsysFile
	 * @return
	 */
	@ApiOperation(value = "检查Name唯一", notes = "检查Name唯一")
	@PostMapping("/checkNameUnique")
	@ResponseBody
	public int checkNameUnique(SysFile tsysFile){
		int b=sysFileService.checkNameUnique(tsysFile);
		if(b>0){
			return 1;
		}else{
			return 0;
		}
	}
	
	
	/**
	 * 修改文件
	 * @param id
	 * @param mmap
	 * @return
	 */
	@ApiOperation(value = "修改跳转", notes = "修改跳转")
	@GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap map)
    {
    	map.put("BucketName",template.getOssProperties().getBucketName());
        map.put("sysFile", sysFileService.selectByPrimaryKey(id));
        return prefix + "/edit";
    }
	
	
	/**
	 * 删除文件
	 * @param ids
	 * @return
	 */
	//@Log(title = "删除日志", action = "1")
	@ApiOperation(value = "删除", notes = "删除")
	@DeleteMapping("/remove")
	@RequiresPermissions("system:file:remove")
	@ResponseBody
	public AjaxResult remove(String ids){
		int b=sysFileService.deleteByPrimaryKey(ids);
		if(b>0){
			return success();
		}else{
			return error();
		}
	}
	


    
    
}
