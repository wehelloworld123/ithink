package com.fc.ithink.model.auto;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import cn.hutool.core.date.DateUtil;
import java.util.Date;

public class UserClient implements Serializable {
    private static final long serialVersionUID = 1L;

	
	@ApiModelProperty(value = "主键")
	private String id;
	
	@ApiModelProperty(value = "appid")
	private String appid;
	
	@ApiModelProperty(value = "appkey")
	private String appkey;
	
	@ApiModelProperty(value = "设备号")
	private String clientid;
	
	@ApiModelProperty(value = "用户id")
	private String userId;
	
	@ApiModelProperty(value = "角色")
	private String role;
	
	@ApiModelProperty(value = "创建人Id")
	private String createBy;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	@ApiModelProperty(value = "创建时间")
	private Date createDat;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	@ApiModelProperty(value = "最后更新时间")
	private Date lUpdateDat;
	
	@ApiModelProperty(value = "是否删除")
	private Integer isDel;
	
	@ApiModelProperty(value = "")
	private String dev;
	
	@JsonProperty("id")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id =  id;
	}
	@JsonProperty("appid")
	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid =  appid;
	}
	@JsonProperty("appkey")
	public String getAppkey() {
		return appkey;
	}

	public void setAppkey(String appkey) {
		this.appkey =  appkey;
	}
	@JsonProperty("clientid")
	public String getClientid() {
		return clientid;
	}

	public void setClientid(String clientid) {
		this.clientid =  clientid;
	}
	@JsonProperty("userId")
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId =  userId;
	}
	@JsonProperty("role")
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role =  role;
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
	@JsonProperty("dev")
	public String getDev() {
		return dev;
	}

	public void setDev(String dev) {
		this.dev =  dev;
	}

																						
	public UserClient(String id,String appid,String appkey,String clientid,String userId,String role,String createBy,Date createDat,Date lUpdateDat,Integer isDel,String dev) {
				
		this.id = id;
				
		this.appid = appid;
				
		this.appkey = appkey;
				
		this.clientid = clientid;
				
		this.userId = userId;
				
		this.role = role;
				
		this.createBy = createBy;
				
		this.createDat = createDat;
				
		this.lUpdateDat = lUpdateDat;
				
		this.isDel = isDel;
				
		this.dev = dev;
				
	}

	public UserClient() {
	    super();
	}

	public String dateToStringConvert(Date date) {
		if(date!=null) {
			return DateUtil.format(date, "yyyy-MM-dd HH:mm:ss");
		}
		return "";
	}
	

}