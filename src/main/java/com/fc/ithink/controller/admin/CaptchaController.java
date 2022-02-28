package com.fc.ithink.controller.admin;

import com.fc.ithink.common.base.BaseController;
import com.fc.ithink.common.conf.redis.RedisService;
import com.fc.ithink.common.domain.AjaxResult;
import com.fc.ithink.common.enums.QrCodeEnum;
import com.fc.ithink.shiro.util.ShiroUtils;
import com.wf.captcha.GifCaptcha;
import com.wf.captcha.utils.CaptchaUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Api(value = "验证码")
@RestController
@RequestMapping("/captcha")
public class CaptchaController extends BaseController {

    @Autowired
    private RedisService redisService;
    /**
     * 验证码生成
     * @param request 请求报文
     * @param response 响应报文
     * */
    @RequestMapping("/captchaImage")
    public void generate(HttpServletRequest request, HttpServletResponse response) throws Exception {
        GifCaptcha gifCaptcha = new GifCaptcha(130,48,4);
        CaptchaUtil.out(gifCaptcha, request, response);
    }

    /**
     * 异步验证
     * @param request 请求报文
     * @param captcha 验证码
     * @return 验证结果
     * */
    @RequestMapping("verify")
    public AjaxResult verify(HttpServletRequest request, String captcha){
        if(CaptchaUtil.ver(captcha,request)){
            return success();
        }
        return error();
    }
    /**
     * 请求到登陆界面
     * @param request
     * @return
     */
    @ApiOperation(value="请求到注册界面",notes="请求到注册界面")
    @GetMapping("/catchQrCode")
    @ResponseBody
    @Transactional
    public AjaxResult catchQrCode(HttpServletRequest request) {
        // 获取session中的验证码
        final String sessionId = request.getSession().getId();
        Long currentDate = System.currentTimeMillis();


        //参数的有效性校验在拦截器里实现
        int expirationTime=60; //时效3分钟

        String loginCode = ShiroUtils.md5(sessionId,currentDate+"",1);

        redisService.setCacheObject(loginCode,sessionId,new Long(expirationTime), TimeUnit.SECONDS);
        Map<String,Object> map=new HashMap<>();
        map.put("loginCode", QrCodeEnum.LOGINAPPLY.getValue() +loginCode);
        map.put("expirationTime", expirationTime);
        return AjaxResult.successData(200,map);

    }

}
