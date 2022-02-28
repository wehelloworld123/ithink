package com.fc.ithink.controller;

import com.fc.ithink.common.base.BaseController;
import com.fc.ithink.common.constant.ProjectConstant;
import com.fc.ithink.common.domain.AjaxResult;
import com.fc.ithink.common.enums.CodeEnum;
import com.fc.ithink.common.enums.LoginType;
import com.fc.ithink.common.enums.RoleEnum;
import com.fc.ithink.model.auto.*;
import com.fc.ithink.model.custom.SysMenu;
import com.fc.ithink.model.custom.email.MailSenderInfo;
import com.fc.ithink.service.UserTnkcoinInfoService;
import com.fc.ithink.shiro.util.ShiroUtils;
import com.fc.ithink.util.CaculateUtils;
import com.fc.ithink.util.DateUtils;
import com.fc.ithink.util.SimpleEmailUtil;
import com.fc.ithink.util.StringUtils;
import com.wf.captcha.utils.CaptchaUtil;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 后台方法
 * 
 * @ClassName: HomeController
 * @author fuce
 * @date 2019-10-21 00:10
 *
 */
@Controller
@RequestMapping("/admin")
public class AdminController extends BaseController {
	private static Logger logger = LoggerFactory.getLogger(AdminController.class);

	@Autowired
	private UserTnkcoinInfoService userTnkcoinInfoService;
	private String prefix = "admin";

	@ApiOperation(value = "首页", notes = "首页")
	@GetMapping("/index")
	public String index(HttpServletRequest request) {
		request.getSession().setAttribute("sessionUserName", ShiroUtils.getUser().getNickname());
		// 获取公告信息
		List<SysNotice> notices = sysNoticeService.getuserNoticeNotRead(ShiroUtils.getUser(), 0);
		request.getSession().setAttribute("notices", notices);
		//获取菜单栏
		request.getSession().setAttribute("sessionUserAvatar",ShiroUtils.getUser().getAvatar());

		return prefix + "/index";
	}




	@ApiOperation(value = "获取登录用户菜单栏", notes = "获取登录用户菜单栏")
	@GetMapping("/getUserMenu")
	@ResponseBody
	public List<SysMenu> getUserMenu(){
		List<SysMenu> sysMenus=sysPermissionService.getSysMenus(ShiroUtils.getUserId());
		return sysMenus;
	}




	/**
	 * 请求到登陆界面
	 * 
	 * @param modelMap
	 * @return
	 */
	@ApiOperation(value = "请求到登陆界面", notes = "请求到登陆界面")
	@GetMapping("/login")
	public String login(ModelMap modelMap) {
		try {
			if ((null != SecurityUtils.getSubject() && SecurityUtils.getSubject().isAuthenticated()) || SecurityUtils.getSubject().isRemembered()) {
				return "redirect:/" + prefix + "/index";
			} else {
				System.out.println("--进行登录验证..验证开始");
				modelMap.put("RollVerification", v2Config.getRollVerification());
				System.out.println("V2Config.getRollVerification()>>>" + v2Config.getRollVerification());
				return "login";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "login";
	}

	/**
	 * 用户登陆验证
	 * 
	 * @param user
	 * @param captcha
	 * @param rememberMe
	 * @param request
	 * @return
	 */
	@ApiOperation(value = "用户登陆验证", notes = "用户登陆验证")
	@PostMapping("/login")
	@ResponseBody
	public AjaxResult login(TsysUser user, String captcha,Boolean auth, boolean rememberMe,
			HttpServletRequest request) {
		// ModelAndView view =new ModelAndView();
		Boolean yz = false;
		// 获取session中的验证码
		String verCode = (String) request.getSession().getAttribute("captcha");

		 // 判断验证码
		if ((auth!=null&&auth)||(captcha!=null &&verCode!=null && captcha.toLowerCase().equals(verCode.trim().toLowerCase()))) {
			//清除验证码
			CaptchaUtil.clear(request);  // 清除session中的验证码
			yz=true;
		}
		
		// 判断验证码
		if (yz) {
			String userName = user.getUsername();
			Subject currentUser = SecurityUtils.getSubject();
			// 是否验证通过
			if (!currentUser.isAuthenticated()) {
				com.fc.ithink.shiro.authc.UsernamePasswordToken token = new com.fc.ithink.shiro.authc.UsernamePasswordToken(userName, user.getPassword());
				token.setType(LoginType.PASSWORD);
				try {
					if (rememberMe) {
						token.setRememberMe(true);
					}
					// 存入用户
					currentUser.login(token);
					TsysUser tsysUser = ShiroUtils.getUser();
					if(StringUtils.isNotNull(tsysUser)) {
						//跳转到 get请求的登陆方法
						//view.setViewName("redirect:/"+prefix+"/index");
						if(tsysUser.getAuthSts()==null||!"1".equals(tsysUser.getAuthSts()))
						{
							if (auth!=null&&auth) {
								tsysUser.setAuthSts("1");
								sysUserService.updateUserAuthSts(tsysUser);
								return AjaxResult.success();
							} else {
								//在这里执行退出系统前需要清空的数据
								Subject subject = SecurityUtils.getSubject();
								//注销
								subject.logout();
								return AjaxResult.error(CodeEnum.LOGIN_FAIL_AUTH_STS.getCode(),
										CodeEnum.LOGIN_FAIL_AUTH_STS.getMessage());
							}
						}

						return  AjaxResult.success(tsysUser.getAuthSts());
					}else {
						return  AjaxResult.error(500,"未知账户");
					}
				} catch (UnknownAccountException uae) {
					logger.info("对用户[" + userName + "]进行登录验证..验证未通过,未知账户");
					return AjaxResult.error(500, "未知账户");
				} catch (IncorrectCredentialsException ice) {
					logger.info("对用户[" + userName + "]进行登录验证..验证未通过,错误的凭证");
					return AjaxResult.error(500, "用户名或密码不正确");
				} catch (LockedAccountException lae) {
					logger.info("对用户[" + userName + "]进行登录验证..验证未通过,账户已锁定");
					return AjaxResult.error(500, "账户已锁定");
				} catch (ExcessiveAttemptsException eae) {
					logger.info("对用户[" + userName + "]进行登录验证..验证未通过,错误次数过多");
					return AjaxResult.error(500, "用户名或密码错误次数过多");
				} catch (AuthenticationException ae) {
					// 通过处理Shiro的运行时AuthenticationException就可以控制用户登录失败或密码错误时的情景
					logger.info("对用户[" + userName + "]进行登录验证..验证未通过,堆栈轨迹如下");
					ae.printStackTrace();
					return AjaxResult.error(500, "用户名或密码不正确");
				}
			} else {
				if (StringUtils.isNotNull(ShiroUtils.getUser())) {
					// 跳转到 get请求的登陆方法
					// view.setViewName("redirect:/"+prefix+"/index");
					return AjaxResult.success();
				} else {
					return AjaxResult.error(500, "未知账户");
				}
			}
		} else {
			return AjaxResult.error(500, "验证码不正确!");
		}

	}

	/**
	 * 请求到登陆界面
	 * @param modelMap
	 * @return
	 */
	@ApiOperation(value="请求到注册界面",notes="请求到注册界面")
	@GetMapping("/enroll")
	public String enroll(ModelMap modelMap) {
		return "enroll";
	}


	/**
	 * 请求到登陆界面
	 * @param request
	 * @return
	 */
	@ApiOperation(value="请求到注册界面",notes="请求到注册界面")
	@PostMapping("/enroll")
	@ResponseBody
	@Transactional
	public AjaxResult enroll(TsysUser user,String captcha,RedirectAttributes redirectAttributes,HttpServletRequest request){
// ModelAndView view =new ModelAndView();
		Boolean yz = false;
		// 获取session中的验证码
		String scode = (String)request.getSession().getAttribute("captcha");
		// 判断验证码

		try {
			//判断验证码
			if(StringUtils.isNotEmpty(scode)&&StringUtils.isNotEmpty(captcha)&&scode.equals(captcha)){
				//清除验证码
				CaptchaUtil.clear(request);  // 清除session中的验证码
				TsysUser tsysUser  = sysUserService.selectByUserName(user.getUsername());
				if(tsysUser!=null){
					if(tsysUser.getIsDel()!=0){
						return AjaxResult.error(500,"用户已封禁");
					}else{
						return AjaxResult.error(500,"用户已注册");
					}
				}
				List<String> roles = new ArrayList<>();
				List<TsysRole> tsysRoles = sysRoleService.listByName(RoleEnum.USER.getValue());
				if(tsysRoles!=null&&tsysRoles.size()>0){
					for(TsysRole role : tsysRoles) {
						roles.add(role.getId());
					}
				}
				user.setAuthSts("1");
				user.setAvatar("https://ithink-1303188565.cos.ap-shanghai.myqcloud.com/common/avatar/icons8-anonymous-mask-500.png");
				Date now = DateUtils.getNowDate();//当前时间
				user.setCreateDat(now);
				user.setlUpdateDat(now);
				int b=sysUserService.insertUserRoles(user,roles);
				if(b>0){
					Date curdate = DateUtils.getNowDate();//当前时间
					UserTnkcoinInfo info = new UserTnkcoinInfo();
					info.setUserid(user.getId());
					info.setTnkcoin(0);
					info.setCreateBy(user.getId());
					info.setCreateDat(curdate);
					info.setLUpdateDat(curdate);
					info.setIsDel(0);
					int i = userTnkcoinInfoService.insertSelective(info);
					if(i>0){
						return AjaxResult.success();
					}else{
						return AjaxResult.error(500,"注册失败");
					}
				}else{
					return AjaxResult.error(500,"注册失败");
				}
			} else {
				System.out.println("V2Config.getRollVerification()>>>"+v2Config.getRollVerification());
				redirectAttributes.addFlashAttribute("message", "验证码不正确");
				return AjaxResult.error(500,"验证码有误");
			}
		} catch (Exception e) {
			throw e;
		}

	}

	/**
	 * 请求到忘记密码界面
	 * @param modelMap
	 * @return
	 */
	@ApiOperation(value="请求到忘记密码界面",notes="请求到忘记密码界面")
	@GetMapping("/forget")
	public String forget(ModelMap modelMap,Integer page) {
		if(page!=null) {
			modelMap.put("page", page);
		}else{
			modelMap.put("page", 0);
		}
		return "forget";
	}


	/**
	 * 确认账号
	 * @param request
	 * @return
	 */
	@ApiOperation(value="确认账号",notes="确认账号")
	@PostMapping("/confirm")
	@ResponseBody
	public AjaxResult confirm(TsysUser user,String captcha,RedirectAttributes redirectAttributes,HttpServletRequest request) throws Exception {
		ModelMap view =new ModelMap();
		view.put("page",1);
		String scode = (String)request.getSession().getAttribute("captcha");
		try {
			//判断验证码
			if(StringUtils.isNotEmpty(scode)&&StringUtils.isNotEmpty(captcha)&&scode.equals(captcha)){
				TsysUserExample tsysUserExample = new TsysUserExample();
				tsysUserExample.createCriteria().andUsernameEqualTo(user.getUsername());
				tsysUserExample.createCriteria().andEmailEqualTo(user.getEmail());
				List<TsysUser> tsysUsers = sysUserService.selectByExample(tsysUserExample);
				if(tsysUsers!=null&&tsysUsers.size()>0){
					MailSenderInfo mailSenderInfo = new MailSenderInfo(true);

					mailSenderInfo.setSsl(true);
					mailSenderInfo.setToAddress(tsysUsers.get(0).getEmail());
					mailSenderInfo.setSubject("我思 |  重置密码邮箱验证");
					String email_code = CaculateUtils.getNonce_str(6);

					HttpSession session = request.getSession();
					session.setAttribute(ProjectConstant.EMAIL_CODE,email_code);

					session.setAttribute(email_code,tsysUsers.get(0).getUsername());
					String content = ProjectConstant.EMAIL_TEXT1+ email_code+ProjectConstant.EMAIL_TEXT2;

					mailSenderInfo.setContent(content);
					SimpleEmailUtil sms = new SimpleEmailUtil();
					sms.sendHtmlMail(mailSenderInfo,null);
					return AjaxResult.success();
				}else{
					return AjaxResult.error(500,"账号或邮箱不存在");
				}
			} else {
				System.out.println("V2Config.getRollVerification()>>>"+v2Config.getRollVerification());
				redirectAttributes.addFlashAttribute("message", "验证码不正确");
				return AjaxResult.error(500,"验证码有误");
			}
		} catch (Exception e) {
			throw e;

	/*		return AjaxResult.error(500,e.getMessage().substring(500));*/
		}

	}

	/**
	 * 重置账号
	 * @param request
	 * @return
	 */
	@ApiOperation(value="重置账号",notes="重置账号")
	@PostMapping("/reset")
	@ResponseBody
	public AjaxResult reset(TsysUser user,String captcha,String emailCode,RedirectAttributes redirectAttributes,HttpServletRequest request){
		ModelAndView view =new ModelAndView();
		logger.info("emailCode:"+emailCode);
		String scode = (String)request.getSession().getAttribute("captcha");
		String email_code = (String)request.getSession().getAttribute(ProjectConstant.EMAIL_CODE);
		logger.info("email_code:"+email_code);
		try {
			//判断验证码
			if(StringUtils.isNotEmpty(scode)&&StringUtils.isNotEmpty(captcha)&&scode.equals(captcha)){
				if(StringUtils.isNotEmpty(email_code)&&StringUtils.isNotEmpty(emailCode)&&email_code.equals(emailCode)){
					String username = (String)request.getSession().getAttribute(email_code);
					user.setUsername(username);
					logger.info("user:"+user);
					TsysUserExample userExample = new TsysUserExample();
					userExample.createCriteria().andUsernameEqualTo(user.getUsername());
					userExample.createCriteria().andIsDelEqualTo(0);
					int b=sysUserService.updateByExampleSelective(user,userExample);
					if(b>0){
						logger.info("success");
						return AjaxResult.success();
					}else{
						logger.info("error");
						return AjaxResult.error(500,"重置失败");
					}

				}else{
					return AjaxResult.error(500,"邮箱确认码失效或不正确");
				}


			} else {
				System.out.println("V2Config.getRollVerification()>>>"+v2Config.getRollVerification());
				redirectAttributes.addFlashAttribute("message", "验证码不正确");
				return AjaxResult.error(500,"验证码有误");
			}
		} catch (Exception e) {
			throw e;
		}

	}
	/**
	 * 手机登录
	 * @param user
	 * @param rememberMe
	 * @param request
	 * @return
	 * @author fuce
	 * @Date 2020年12月7日 上午12:54:28
	 */
	@ApiOperation(value = "手机登录", notes = "手机登录")
	@PostMapping("/API/login")
	@ResponseBody
	public AjaxResult APIlogin(TsysUser user,boolean rememberMe,HttpServletRequest request) {
		// ModelAndView view =new ModelAndView();
		Boolean yz = true;
//		if (V2Config.getRollVerification()) {// 滚动验证
//			yz = true;
//		} else {// 图片验证
//			String scode = (String) request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
//			yz = StringUtils.isNotEmpty(scode) && StringUtils.isNotEmpty(code) && scode.equals(code);
//		}
		System.out.println("/API/login手机请求");
		// 判断验证码
		if (yz) {
			String userName = user.getUsername();
			Subject currentUser = SecurityUtils.getSubject();
			// 是否验证通过
			if (!currentUser.isAuthenticated()) {
				UsernamePasswordToken token = new UsernamePasswordToken(userName, user.getPassword());
				try {
					if (rememberMe) {
						token.setRememberMe(true);
					}
					// 存入用户
					currentUser.login(token);
					if (StringUtils.isNotNull(ShiroUtils.getUser())) {
						// 若为前后端分离版本，则可把sessionId返回，作为分离版本的请求头authToken
						 String authToken = ShiroUtils.getSessionId();
						 return AjaxResult.successData(200, authToken);
						//return AjaxResult.success();
					} else {
						return AjaxResult.error(500, "未知账户");
					}
				} catch (UnknownAccountException uae) {
					logger.info("对用户[" + userName + "]进行登录验证..验证未通过,未知账户");
					return AjaxResult.error(500, "未知账户");
				} catch (IncorrectCredentialsException ice) {
					logger.info("对用户[" + userName + "]进行登录验证..验证未通过,错误的凭证");
					return AjaxResult.error(500, "用户名或密码不正确");
				} catch (LockedAccountException lae) {
					logger.info("对用户[" + userName + "]进行登录验证..验证未通过,账户已锁定");
					return AjaxResult.error(500, "账户已锁定");
				} catch (ExcessiveAttemptsException eae) {
					logger.info("对用户[" + userName + "]进行登录验证..验证未通过,错误次数过多");
					return AjaxResult.error(500, "用户名或密码错误次数过多");
				} catch (AuthenticationException ae) {
					// 通过处理Shiro的运行时AuthenticationException就可以控制用户登录失败或密码错误时的情景
					logger.info("对用户[" + userName + "]进行登录验证..验证未通过,堆栈轨迹如下");
					ae.printStackTrace();
					return AjaxResult.error(500, "用户名或密码不正确");
				}
			} else {
				if (StringUtils.isNotNull(ShiroUtils.getUser())) {
					// 跳转到 get请求的登陆方法
					// view.setViewName("redirect:/"+prefix+"/index");
					 String authToken = ShiroUtils.getSessionId();
					 return AjaxResult.successData(200, authToken);
				} else {
					return AjaxResult.error(500, "未知账户");
				}
			}
		} else {
			return AjaxResult.error(500, "验证码不正确!");
		}

	}

	/**
	 * 退出登陆
	 * 
	 * @return
	 */
	@ApiOperation(value = "退出登陆", notes = "退出登陆")
	@GetMapping("/Loginout")
	@ResponseBody
	public AjaxResult LoginOut(HttpServletRequest request, HttpServletResponse response) {
		// 在这里执行退出系统前需要清空的数据
		Subject subject = SecurityUtils.getSubject();
		// 注销
		subject.logout();
		return success();
	}

	/**** 页面测试 ****/
	@ApiOperation(value = "404页面", notes = "404页面")
	@GetMapping("Out404")
	public String Out404(HttpServletRequest request, HttpServletResponse response) {

		return "redirect:/error/404";
	}

	@GetMapping("Out403")
	@ApiOperation(value = "403页面", notes = "403页面")
	public String Out403(HttpServletRequest request, HttpServletResponse response) {

		return "redirect:/error/403";
	}

	@ApiOperation(value = "500页面", notes = "500页面")
	@GetMapping("Out500")
	public String Out500(HttpServletRequest request, HttpServletResponse response) {

		return "redirect:/error/500";
	}




	/**
	 * 权限测试跳转页面
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@ApiOperation(value = "权限测试跳转页面", notes = "权限测试跳转页面")
	@GetMapping("Outqx")
	@RequiresPermissions("system:user:asd")
	public String Outqx(HttpServletRequest request, HttpServletResponse response) {

		return "redirect:/error/500";
	}
	/**** 页面测试EDN ****/
}
