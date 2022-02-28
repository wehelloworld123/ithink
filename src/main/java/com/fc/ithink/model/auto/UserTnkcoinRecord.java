package com.fc.ithink.model.auto;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import cn.hutool.core.date.DateUtil;
import java.util.Date;

public class UserTnkcoinRecord implements Serializable {
    private static final long serialVersionUID = 1L;

	
	@ApiModelProperty(value = "主键")
	private Long id;
	
	@ApiModelProperty(value = "tnk币")
	private Integer tnkcoin;
	
	@ApiModelProperty(value = "用户id")
	private String userid;
	
	@ApiModelProperty(value = "状态")
	private String status;
	
	@ApiModelProperty(value = "理由")
	private String reason;
	
	@ApiModelProperty(value = "备注")
	private String remark;
	
	@ApiModelProperty(value = "币种")
	private String binTyp;
	
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
	@JsonProperty("tnkcoin")
	public Integer getTnkcoin() {
		return tnkcoin;
	}

	public void setTnkcoin(Integer tnkcoin) {
		this.tnkcoin =  tnkcoin;
	}
	@JsonProperty("userid")
	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid =  userid;
	}
	@JsonProperty("status")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status =  status;
	}
	@JsonProperty("reason")
	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason =  reason;
	}
	@JsonProperty("remark")
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark =  remark;
	}
	@JsonProperty("binTyp")
	public String getBinTyp() {
		return binTyp;
	}

	public void setBinTyp(String binTyp) {
		this.binTyp =  binTyp;
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

																						
	public UserTnkcoinRecord(Long id,Integer tnkcoin,String userid,String status,String reason,String remark,String binTyp,String createBy,Date createDat,Date lUpdateDat,Integer isDel) {
				
		this.id = id;
				
		this.tnkcoin = tnkcoin;
				
		this.userid = userid;
				
		this.status = status;
				
		this.reason = reason;
				
		this.remark = remark;
				
		this.binTyp = binTyp;
				
		this.createBy = createBy;
				
		this.createDat = createDat;
				
		this.lUpdateDat = lUpdateDat;
				
		this.isDel = isDel;
				
	}

	public UserTnkcoinRecord() {
	    super();
	}

	public String dateToStringConvert(Date date) {
		if(date!=null) {
			return DateUtil.format(date, "yyyy-MM-dd HH:mm:ss");
		}
		return "";
	}
	

}