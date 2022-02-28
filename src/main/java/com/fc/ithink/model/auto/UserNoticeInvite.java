package com.fc.ithink.model.auto;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import cn.hutool.core.date.DateUtil;
import java.util.Date;

public class UserNoticeInvite implements Serializable {
    private static final long serialVersionUID = 1L;

	
	@ApiModelProperty(value = "主键")
	private Long id;
	
	@ApiModelProperty(value = "被邀请人Id")
	private String inviteeId;
	
	@ApiModelProperty(value = "被邀请人名称")
	private String inviteeNm;
	
	@ApiModelProperty(value = "邀请人Id")
	private String invitorId;
	
	@ApiModelProperty(value = "邀请人名称")
	private String invitorNm;
	
	@ApiModelProperty(value = "作品编号")
	private String proNo;
	
	@ApiModelProperty(value = "作品类型")
	private String proType;
	
	@ApiModelProperty(value = "作品名称")
	private String proNm;
	
	@ApiModelProperty(value = "备注")
	private String remark;
	
	@ApiModelProperty(value = "状态")
	private String status;
	
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
	
	@JsonProperty("id")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id =  id;
	}
	@JsonProperty("inviteeId")
	public String getInviteeId() {
		return inviteeId;
	}

	public void setInviteeId(String inviteeId) {
		this.inviteeId =  inviteeId;
	}
	@JsonProperty("inviteeNm")
	public String getInviteeNm() {
		return inviteeNm;
	}

	public void setInviteeNm(String inviteeNm) {
		this.inviteeNm =  inviteeNm;
	}
	@JsonProperty("invitorId")
	public String getInvitorId() {
		return invitorId;
	}

	public void setInvitorId(String invitorId) {
		this.invitorId =  invitorId;
	}
	@JsonProperty("invitorNm")
	public String getInvitorNm() {
		return invitorNm;
	}

	public void setInvitorNm(String invitorNm) {
		this.invitorNm =  invitorNm;
	}
	@JsonProperty("proNo")
	public String getProNo() {
		return proNo;
	}

	public void setProNo(String proNo) {
		this.proNo =  proNo;
	}
	@JsonProperty("proType")
	public String getProType() {
		return proType;
	}

	public void setProType(String proType) {
		this.proType =  proType;
	}
	@JsonProperty("proNm")
	public String getProNm() {
		return proNm;
	}

	public void setProNm(String proNm) {
		this.proNm =  proNm;
	}
	@JsonProperty("remark")
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark =  remark;
	}
	@JsonProperty("status")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status =  status;
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

																												
	public UserNoticeInvite(Long id,String inviteeId,String inviteeNm,String invitorId,String invitorNm,String proNo,String proType,String proNm,String remark,String status,String createBy,Date createDat,Date lUpdateDat,Integer isDel) {
				
		this.id = id;
				
		this.inviteeId = inviteeId;
				
		this.inviteeNm = inviteeNm;
				
		this.invitorId = invitorId;
				
		this.invitorNm = invitorNm;
				
		this.proNo = proNo;
				
		this.proType = proType;
				
		this.proNm = proNm;
				
		this.remark = remark;
				
		this.status = status;
				
		this.createBy = createBy;
				
		this.createDat = createDat;
				
		this.lUpdateDat = lUpdateDat;
				
		this.isDel = isDel;
				
	}

	public UserNoticeInvite() {
	    super();
	}

	public String dateToStringConvert(Date date) {
		if(date!=null) {
			return DateUtil.format(date, "yyyy-MM-dd HH:mm:ss");
		}
		return "";
	}
	

}