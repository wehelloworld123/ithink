package com.fc.ithink.controller;

import com.fc.ithink.common.base.BaseController;

import com.fc.ithink.service.EmailService;
import com.fc.ithink.util.StringUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 如果有前台这儿写前台访问方法
 * @ClassName: IndexController
 * @author fuce
 * @date 2019-10-21 00:15
 */
@Api(tags = "首页模块")
@Controller
public class IndexController extends BaseController{


	@Autowired
	private EmailService emailService;
	
	/**
	 * 前台访问 域名:端口 例如:localhost:80的get请求
	 * @param map
	 * @return
	 * @author fuce
	 * @Date 2019年11月20日 下午10:55:13
	 */
	@ApiOperation(value="前台",notes="前台")
	@GetMapping("/")
	public String index(ModelMap map) {
		
		//直接访问后台用
		//return "redirect:/admin/login"
    	return "index";
	}
	/**
	 * 前台访问/index的get请求
	 * @param map
	 * @return
	 * @author fuce
	 * @Date 2019年11月20日 下午10:54:56
	 */
	@ApiOperation(value="前台",notes="前台")
	@GetMapping("/index")
	public String index2(ModelMap map) {
		//直接访问后台用
		//return "redirect:/admin/login"
		return "index";
	}




	/**
	 * 前台访问 域名:端口 例如:localhost:80的get请求
	 * @param map
	 * @return
	 * @author fuce
	 * @Date 2019年11月20日 下午10:55:13
	 */
	@ApiOperation(value="agree",notes="agree")
	@GetMapping("/agree")
	public String agree(ModelMap map) {
		return "agree";
	}

	/**
	 * 前台访问 域名:端口 例如:localhost:80的get请求
	 * @param map
	 * @return
	 * @author fuce
	 * @Date 2019年11月20日 下午10:55:13
	 */
	@ApiOperation(value="contract",notes="contract")
	@GetMapping("/contract")
	public String contract(ModelMap map) {
		return "contract";
	}


	/**
	 * 前台访问 域名:端口 例如:localhost:80的get请求
	 * @param map
	 * @return
	 * @author fuce
	 * @Date 2019年11月20日 下午10:55:13
	 */
	@ApiOperation(value="appagree",notes="appagree")
	@GetMapping("/appagree")
	public String appagree(ModelMap map) {
		return "appagree";
	}

	/**
	 * 前台访问 域名:端口 例如:localhost:80的get请求
	 * @param map
	 * @return
	 * @author fuce
	 * @Date 2019年11月20日 下午10:55:13
	 */
	@ApiOperation(value="appcontract",notes="appcontract")
	@GetMapping("/appcontract")
	public String appcontract(ModelMap map) {
		return "appcontract";
	}

	/**
	 * 前台访问/index的get请求
	 * @param map
	 * @return
	 * @author fuce
	 * @Date 2019年11月20日 下午10:54:56
	 */
	@ApiOperation(value="前台",notes="前台")
	@GetMapping("/test")
	public String testEmail(ModelMap map) throws Exception {
		emailService.sendEmail("yyycan_can@163.com","我思 |  作品上架审核通知",true,"纯粹世界","TLITER20201220001",null);
		emailService.sendEmail("1131095930@qq.com","我思 |  作品上架审核通知",true,"纯粹世界","TLITER20201220001",null);
		return "guanwang/index";
	}
	/**
	 * 前台访问 域名:端口 例如:localhost:80的get请求
	 * @param map
	 * @return
	 * @author fuce
	 * @Date 2019年11月20日 下午10:55:13
	 */
	@ApiOperation(value="前台",notes="前台")
	@GetMapping("/index3")
	public String index3(ModelMap map) {
		String str="前台";

		return "test2";
	}


	/**
	 * 前台访问 域名:端口 例如:localhost:80的get请求
	 * @param map
	 * @return
	 * @author fuce
	 * @Date 2019年11月20日 下午10:55:13
	 */
	@ApiOperation(value="app",notes="app")
	@GetMapping("/app/download")
	public String download(ModelMap map) {
		String str="app";
		map.addAttribute("third", "0");
		map.addAttribute("appType", "2");
		return "app/index-1";
	}

	@GetMapping("/qq_conn/1111733487/{uid}")
	public String qqConnect(ModelMap map,String pageType,String uid,String appType) {
		String str="qq";
		if(StringUtils.isNotEmpty(pageType)&&StringUtils.isNotEmpty(uid)) {
			map.addAttribute("third", "1");//第三方应用跳转
			map.addAttribute("appType", appType);
			map.addAttribute("href","ithink://"+pageType+"?pageType="+pageType+"&uid="+uid);
		}
		return "app/index-1";
	}
	@GetMapping("/app/{uid}")
	public String appConnect(ModelMap map,String pageType,String uid,String appType) {
		String str="app";
		if(StringUtils.isNotEmpty(pageType)&&StringUtils.isNotEmpty(uid)) {
			map.addAttribute("third", "1");//第三方应用跳转
			map.addAttribute("appType", appType);
			if (StringUtils.isNotEmpty(appType) && "1".equals(appType)) {
				map.addAttribute("href", "ithink://"+pageType+"?pageType="+pageType+"&uid="+uid);
			} else {
				map.addAttribute("href", "https://wjy.vvvpure.com/think/app?pageType=" + pageType + "&uid=" + uid);
			}
		}
		return "app/index-1";
	}
}
