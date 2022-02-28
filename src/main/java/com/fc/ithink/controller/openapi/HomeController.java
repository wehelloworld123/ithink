package com.fc.ithink.controller.openapi;


import com.alibaba.fastjson.JSONObject;
import com.fc.ithink.common.conf.redis.RedisService;
import com.fc.ithink.common.constant.RedisConstant;
import com.fc.ithink.common.constant.THINKConstant;
import com.fc.ithink.common.domain.AjaxResult;
import com.fc.ithink.common.enums.CodeEnum;
import com.fc.ithink.common.enums.LoginType;
import com.fc.ithink.component.HttpClient;

import com.fc.ithink.model.auto.TsysUser;
import com.fc.ithink.service.SysUserService;
import com.fc.ithink.shiro.util.ShiroUtils;
import com.fc.ithink.util.StringUtils;
import io.lettuce.core.RedisException;
import io.swagger.annotations.ApiOperation;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.TimeUnit;

/**
 * 后台方法
 *
 * @ClassName: HomeController
 * @author fuce
 * @date 2019-10-21 00:10
 *
 */
@RestController
@RequestMapping("/ApplyThird")
@Slf4j
public class HomeController {

    @Autowired
    private RedisService redisService;
    @Autowired
    private SysUserService sysUserService;
    /**
     * 扫码登录
     * @param request
     * @return
     * @author fuce
     * @Date 2020年12月7日 上午12:54:28
     */
    @ApiOperation(value = "手机登录", notes = "手机登录")
    @RequestMapping("/API/apply")
    public Object APIApply(HttpServletRequest request) {
        // 获取session中的验证码

        String loginCode = request.getHeader("loginCode");

        if(StringUtils.isNotEmpty(loginCode)&&loginCode.length()>3) {
            loginCode = loginCode.substring(3);
            String webSessionId = redisService.getCacheObject(loginCode);
            if (StringUtils.isEmpty(webSessionId)) {
                return AjaxResult.error("二维码已过期失效");
            }

            redisService.setCacheObject(RedisConstant.APPLY + request.getSession().getId(), webSessionId, new Long(60), TimeUnit.SECONDS);

            return AjaxResult.success();



        }else{
            return AjaxResult.error("非法二维码");

        }
    }

    /**
     * 扫码登录
     * @param request
     * @return
     * @author fuce
     * @Date 2020年12月7日 上午12:54:28
     */
    @ApiOperation(value = "手机登录", notes = "手机登录")
    @RequestMapping("/API/confirm")
    public AjaxResult APIApplyConfirm(HttpServletRequest request) {
        // 获取session中的验证码

        String webSessionId = redisService.getCacheObject(RedisConstant.APPLY + request.getSession().getId());



        if(StringUtils.isNotEmpty(webSessionId)) {


            String token = request.getHeader("x-header-token");

            Object obj = HttpClient.doGet(THINKConstant.ithinkUrl+"/user/readUserInfo",token);
            if(obj == null){
                return AjaxResult.error("授权设备已失效");
            }
            JSONObject json = JSONObject.parseObject((String)obj);
            try {
                if(json!=null&&
                        200==(Integer) json.get("code")){
                    JSONObject msgJson = (JSONObject) json.get("msg");
                    redisService.setCacheObject(RedisConstant.QRCONFIRM + webSessionId,msgJson.get("id") , new Long(60), TimeUnit.SECONDS);

                    return AjaxResult.success();
                }else{
                    return AjaxResult.error("授权设备已失效");
                }
            }catch (IllegalArgumentException e){

                log.error(e.getMessage());
                return AjaxResult.error("授权设备已失效");
            }catch (RedisException e){
                log.error(e.getMessage());
                return AjaxResult.error("授权设备已失效");
            }catch (Exception e){

                log.error(e.getMessage());
                return AjaxResult.error("授权设备已失效");
            }


        }else{
            return AjaxResult.error("授权已失效");

        }
    }


    /**
     * 扫码登录
     * @param request
     * @return
     * @author fuce
     * @Date 2020年12月7日 上午12:54:28
     */
    @ApiOperation(value = "手机登录", notes = "手机登录")
    @RequestMapping("/API/webLogin")
    public AjaxResult WebQrLogin(HttpServletRequest request,Boolean auth) {
        // 获取session中的验证码

        String userId = redisService.getCacheObject(RedisConstant.QRCONFIRM + request.getSession().getId());

        if(StringUtils.isEmpty(userId)){
            return AjaxResult.error(THINKConstant.QR_LOGIN_NOID,THINKConstant.QR_LOGIN_NOID_MSG);
        }

        TsysUser user = sysUserService.selectByPrimaryKey(userId);

        if(user!=null) {



            String userName = user.getUsername();
            Subject currentUser = SecurityUtils.getSubject();
            // 是否验证通过
            if (!currentUser.isAuthenticated()) {
                com.fc.ithink.shiro.authc.UsernamePasswordToken token = new com.fc.ithink.shiro.authc.UsernamePasswordToken(userName, "#");
                token.setType(LoginType.NOPASSWD);
                try {

                    token.setRememberMe(true);

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
                        redisService.deleteObject(RedisConstant.QRCONFIRM + request.getSession().getId());
                        return  AjaxResult.success(tsysUser.getAuthSts());
                    }else {
                        return  AjaxResult.error(500,"未知账户");
                    }
                } catch (UnknownAccountException uae) {
                    log.info("对用户[" + userName + "]进行登录验证..验证未通过,未知账户");
                    return AjaxResult.error(500, "未知账户");
                } catch (IncorrectCredentialsException ice) {
                    log.info("对用户[" + userName + "]进行登录验证..验证未通过,错误的凭证");
                    return AjaxResult.error(500, "用户名或密码不正确");
                } catch (LockedAccountException lae) {
                    log.info("对用户[" + userName + "]进行登录验证..验证未通过,账户已锁定");
                    return AjaxResult.error(500, "账户已锁定");
                } catch (ExcessiveAttemptsException eae) {
                    log.info("对用户[" + userName + "]进行登录验证..验证未通过,错误次数过多");
                    return AjaxResult.error(500, "用户名或密码错误次数过多");
                } catch (AuthenticationException ae) {
                    // 通过处理Shiro的运行时AuthenticationException就可以控制用户登录失败或密码错误时的情景
                    log.info("对用户[" + userName + "]进行登录验证..验证未通过,堆栈轨迹如下");
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



        }else{
            return AjaxResult.error(THINKConstant.QR_LOGIN_NOID,THINKConstant.QR_LOGIN_NOID_MSG);

        }
    }

}
