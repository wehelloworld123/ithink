package com.fc.ithink.common.conf;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 读取项目相关配置
 * 
 * @author fuce
 */
@Component
@ConfigurationProperties(prefix = "fuce")
public class V2Config
{
    /** 项目名称 */
    private String name;
    /** 版本 */
    private String version;
    /** 版权年份 */
	/** 上传路径 */
	private static String defaultBaseDir;
	/** 是否开启 上传static **/
	private static String isstatic;
	/** 公司公章名称**/
	private static String default_company;
	/** 公章用途**/
	private String default_purpose;
	/** 头像路径**/
	private String avatDir;
	/** 作品文档s路径 */
	private String pro_dir;
	/** 生成完成作品模板目录static **/
	private String pro_template_dir;

	/** 开启存放静态文件夹后目录 **/
	private static String isroot_dir;
	/** 合约pdf路径 **/
	private static String contract_dir;
	/** 图片上传路径 **/
	private String picDir;
    private String copyrightYear;
    /** 邮箱发送smtp */
    private String emailSmtp;
    /** 发送邮箱端口 */
    private String emailPort;
    /** 发送邮箱登录账号 */
    private String emailAccount;
    /** 发送邮箱登录密码 */
    private String emailPassword;
    /** 演示模式 **/
    private String demoEnabled;
    /** 滚动验证码 **/
    private Boolean rollVerification;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getCopyrightYear() {
		return copyrightYear;
	}
	public void setCopyrightYear(String copyrightYear) {
		this.copyrightYear = copyrightYear;
	}
	public String getEmailSmtp() {
		return emailSmtp;
	}
	public void setEmailSmtp(String emailSmtp) {
		this.emailSmtp = emailSmtp;
	}
	public String getEmailPort() {
		return emailPort;
	}
	public void setEmailPort(String emailPort) {
		this.emailPort = emailPort;
	}
	public String getEmailAccount() {
		return emailAccount;
	}
	public void setEmailAccount(String emailAccount) {
		this.emailAccount = emailAccount;
	}
	public String getEmailPassword() {
		return emailPassword;
	}
	public void setEmailPassword(String emailPassword) {
		this.emailPassword = emailPassword;
	}
	public String getDemoEnabled() {
		return demoEnabled;
	}
	public void setDemoEnabled(String demoEnabled) {
		this.demoEnabled = demoEnabled;
	}
	public Boolean getRollVerification() {
		return rollVerification;
	}
	public void setRollVerification(Boolean rollVerification) {
		this.rollVerification = rollVerification;
	}

	public static String getDefaultBaseDir() {
		return defaultBaseDir;
	}

	public void setDefaultBaseDir(String defaultBaseDir) {
		this.defaultBaseDir = defaultBaseDir;
	}

	public static String getIsstatic() {
		return isstatic;
	}

	public void setIsstatic(String isstatic) {
		this.isstatic = isstatic;
	}

	public static String getDefault_company() {
		return default_company;
	}

	public void setDefault_company(String default_company) {
		this.default_company = default_company;
	}

	public String getDefault_purpose() {
		return default_purpose;
	}

	public void setDefault_purpose(String default_purpose) {
		this.default_purpose = default_purpose;
	}

	public String getAvatDir() {
		return avatDir;
	}

	public void setAvatDir(String avatDir) {
		this.avatDir = avatDir;
	}

	public String getPro_dir() {
		return pro_dir;
	}

	public void setPro_dir(String pro_dir) {
		this.pro_dir = pro_dir;
	}

	public String getPro_template_dir() {
		return pro_template_dir;
	}

	public void setPro_template_dir(String pro_template_dir) {
		this.pro_template_dir = pro_template_dir;
	}

	public static String getIsroot_dir() {
		return isroot_dir;
	}

	public void setIsroot_dir(String isroot_dir) {
		this.isroot_dir = isroot_dir;
	}

	public static String getContract_dir() {
		return contract_dir;
	}

	public void setContract_dir(String contract_dir) {
		this.contract_dir = contract_dir;
	}

	public String getPicDir() {
		return picDir;
	}

	public void setPicDir(String picDir) {
		this.picDir = picDir;
	}
}
