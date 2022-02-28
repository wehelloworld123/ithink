package com.fc.ithink.service;

import com.fc.ithink.common.constant.ProjectConstant;
import com.fc.ithink.model.custom.email.MailSenderInfo;
import com.fc.ithink.util.SimpleEmailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmailService {

    @Autowired
    @Qualifier("templateEngine")
    private TemplateEngine templateEngine;

    public void sendEmail(String email,String subject,boolean isPass,String name,String ids,List<File> files) throws Exception {
        MailSenderInfo mailSenderInfo = new MailSenderInfo(true);
        mailSenderInfo.setToAddress(email);
        mailSenderInfo.setSubject(subject);
        mailSenderInfo.setSsl(true);
        String content = null;
        if(isPass){
            content = ProjectConstant.NOTICE_CONTENT_1+ name+ ProjectConstant.NOTICE_CONTENT_2+ids+ProjectConstant.NOTICE_CONTENT_4;
        }else {
            content = ProjectConstant.NOTICE_CONTENT_1+ name+ProjectConstant.NOTICE_CONTENT_2+ids+ProjectConstant.NOTICE_CONTENT_3;
        }

        Map<String,Object> params = new HashMap<>();
        params.put("result",content);
        Context ctx = new Context();
        // 给模板的参数的上下文
        ctx.setVariable("params", params);
        params.put("companyName","武汉闻嘉瑜信息技术有限公司");
        // 执行模板引擎，执行模板引擎传入模板名、上下文对象,Thymeleaf的默认配置期望所有HTML文件都放在 **resources/templates ** 目录下，以.html扩展名结尾。
        String emailText = templateEngine.process("EmailTemplate.html", ctx);
        mailSenderInfo.setContent(emailText);
        SimpleEmailUtil sms = new SimpleEmailUtil();
        sms.sendHtmlMail(mailSenderInfo,files);
    }

}
