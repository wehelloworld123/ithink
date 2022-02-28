package com.fc.ithink.model.auto;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import cn.hutool.core.date.DateUtil;
import java.util.Date;

public class ProCertificate implements Serializable {
    private static final long serialVersionUID = 1L;

	
	@ApiModelProperty(value = "主键")
	private String certid;
	
	@ApiModelProperty(value = "appid")
	private String appid;
	
	@ApiModelProperty(value = "作品编号")
	private String proNo;
	
	@ApiModelProperty(value = "用户设备")
	private String clientInfo;
	
	@ApiModelProperty(value = "ip地址")
	private String ipaddress;
	
	@ApiModelProperty(value = "用户签名")
	private String signature;
	
	@ApiModelProperty(value = "状态")
	private String signStatus;
	
	@ApiModelProperty(value = "声明路径")
	private String filepath;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	@ApiModelProperty(value = "声明时间")
	private Date signTim;
	
	@ApiModelProperty(value = "创建人Id")
	private String createBy;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	@ApiModelProperty(value = "创建日期")
	private Date createDat;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	@ApiModelProperty(value = "创建时间")
	private Date createTim;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	@ApiModelProperty(value = "最后更新时间")
	private Date lUpdateDat;
	
	@ApiModelProperty(value = "是否删除")
	private Integer isDel;
	
	@JsonProperty("certid")
	public String getCertid() {
		return certid;
	}

	public void setCertid(String certid) {
		this.certid =  certid;
	}
	@JsonProperty("appid")
	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid =  appid;
	}
	@JsonProperty("proNo")
	public String getProNo() {
		return proNo;
	}

	public void setProNo(String proNo) {
		this.proNo =  proNo;
	}
	@JsonProperty("clientInfo")
	public String getClientInfo() {
		return clientInfo;
	}

	public void setClientInfo(String clientInfo) {
		this.clientInfo =  clientInfo;
	}
	@JsonProperty("ipaddress")
	public String getIpaddress() {
		return ipaddress;
	}

	public void setIpaddress(String ipaddress) {
		this.ipaddress =  ipaddress;
	}
	@JsonProperty("signature")
	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature =  signature;
	}
	@JsonProperty("signStatus")
	public String getSignStatus() {
		return signStatus;
	}

	public void setSignStatus(String signStatus) {
		this.signStatus =  signStatus;
	}
	@JsonProperty("filepath")
	public String getFilepath() {
		return filepath;
	}

	public void setFilepath(String filepath) {
		this.filepath =  filepath;
	}
	@JsonProperty("signTim")
	public Date getSignTim() {
		return signTim;
	}

	public void setSignTim(Date signTim) {
		this.signTim =  signTim;
	}
	@JsonProperty("createBy")
	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy =  createBy;
	}
	@JsonProperty("createDat")
	public Date getCreateDat() {
		return createDat;
	}

	public void setCreateDat(Date createDat) {
		this.createDat =  createDat;
	}
	@JsonProperty("createTim")
	public Date getCreateTim() {
		return createTim;
	}

	public void setCreateTim(Date createTim) {
		this.createTim =  createTim;
	}
	@JsonProperty("lUpdateDat")
	public Date getLUpdateDat() {
		return lUpdateDat;
	}

	public void setLUpdateDat(Date lUpdateDat) {
		this.lUpdateDat =  lUpdateDat;
	}
	@JsonProperty("isDel")
	public Integer getIsDel() {
		return isDel;
	}

	public void setIsDel(Integer isDel) {
		this.isDel =  isDel;
	}

																												
	public ProCertificate(String certid,String appid,String proNo,String clientInfo,String ipaddress,String signature,String signStatus,String filepath,Date signTim,String createBy,Date createDat,Date createTim,Date lUpdateDat,Integer isDel) {
				
		this.certid = certid;
				
		this.appid = appid;
				
		this.proNo = proNo;
				
		this.clientInfo = clientInfo;
				
		this.ipaddress = ipaddress;
				
		this.signature = signature;
				
		this.signStatus = signStatus;
				
		this.filepath = filepath;
				
		this.signTim = signTim;
				
		this.createBy = createBy;
				
		this.createDat = createDat;
				
		this.createTim = createTim;
				
		this.lUpdateDat = lUpdateDat;
				
		this.isDel = isDel;
				
	}

	public ProCertificate() {
	    super();
	}

	public String dateToStringConvert(Date date) {
		if(date!=null) {
			return DateUtil.format(date, "yyyy-MM-dd HH:mm:ss");
		}
		return "";
	}
	

}