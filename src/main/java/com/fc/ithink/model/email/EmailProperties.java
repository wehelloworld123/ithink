package com.fc.ithink.model.email;



import lombok.Data;

import java.io.File;
import java.util.Map;

/**
 * @author: brbaipoiData
 * @create: 2020-11-03 10:42:50
 * @description:
 */
@Data
public class EmailProperties {

    //收件邮箱地址数组
    private String[] emailArrays;

    //抄送邮箱地址数组
    private String[] ccArrays;

    //邮件主题
    private String subject;

    //模板路径
    private String template;

    //模板填充参数
    private Map<String,Object> params;

    // 附件
    private File file;

    // 附件名称
    private String attachmentName;

    public EmailProperties(){};

    public EmailProperties(String[] emailArrays, String[] ccArrays, String subject, String template, Map<String,Object> params){
        this.emailArrays = emailArrays;
        this.ccArrays = ccArrays;
        this.subject = subject;
        this.template = template;
        this.params = params;
    }

    public EmailProperties(String[] emailArrays, String subject, String template, Map<String,Object> params){
        this.emailArrays = emailArrays;
        this.subject = subject;
        this.template = template;
        this.params = params;
    }

    public EmailProperties(String[] emailArrays, String subject, String template, Map<String,Object> params, File file, String attachmentName){
        this.emailArrays = emailArrays;
        this.subject = subject;
        this.template = template;
        this.params = params;
        this.file = file;
        this.attachmentName = attachmentName;
    }
}