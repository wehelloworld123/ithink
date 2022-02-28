package com.fc.ithink.model.auto;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import cn.hutool.core.date.DateUtil;
import java.util.Date;

public class UserCashoutAcc implements Serializable {
    private static final long serialVersionUID = 1L;

	
	@ApiModelProperty(value = "主键")
	private String no;
	
	@ApiModelProperty(value = "提现方式")
	private String payeeWay;
	
	@ApiModelProperty(value = "银行名称")
	private String bankNm;
	
	@ApiModelProperty(value = "银行代码")
	private String bankCode;
	
	@ApiModelProperty(value = "付款名称")
	private String payeeNm;
	
	@ApiModelProperty(value = "付款账号")
	private String payeeAcc;
	
	@ApiModelProperty(value = "手机号码")
	private String phoneNo;
	
	@ApiModelProperty(value = "默认方法")
	private String defaultWay;
	
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
	private String bankIcon;
	
	@JsonProperty("no")
	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no =  no;
	}
	@JsonProperty("payeeWay")
	public String getPayeeWay() {
		return payeeWay;
	}

	public void setPayeeWay(String payeeWay) {
		this.payeeWay =  payeeWay;
	}
	@JsonProperty("bankNm")
	public String getBankNm() {
		return bankNm;
	}

	public void setBankNm(String bankNm) {
		this.bankNm =  bankNm;
	}
	@JsonProperty("bankCode")
	public String getBankCode() {
		return bankCode;
	}

	public void setBankCode(String bankCode) {
		this.bankCode =  bankCode;
	}
	@JsonProperty("payeeNm")
	public String getPayeeNm() {
		return payeeNm;
	}

	public void setPayeeNm(String payeeNm) {
		this.payeeNm =  payeeNm;
	}
	@JsonProperty("payeeAcc")
	public String getPayeeAcc() {
		return payeeAcc;
	}

	public void setPayeeAcc(String payeeAcc) {
		this.payeeAcc =  payeeAcc;
	}
	@JsonProperty("phoneNo")
	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo =  phoneNo;
	}
	@JsonProperty("defaultWay")
	public String getDefaultWay() {
		return defaultWay;
	}

	public void setDefaultWay(String defaultWay) {
		this.defaultWay =  defaultWay;
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
	@JsonProperty("bankIcon")
	public String getBankIcon() {
		return bankIcon;
	}

	public void setBankIcon(String bankIcon) {
		this.bankIcon =  bankIcon;
	}

																										
	public UserCashoutAcc(String no,String payeeWay,String bankNm,String bankCode,String payeeNm,String payeeAcc,String phoneNo,String defaultWay,String createBy,Date createDat,Date lUpdateDat,Integer isDel,String bankIcon) {
				
		this.no = no;
				
		this.payeeWay = payeeWay;
				
		this.bankNm = bankNm;
				
		this.bankCode = bankCode;
				
		this.payeeNm = payeeNm;
				
		this.payeeAcc = payeeAcc;
				
		this.phoneNo = phoneNo;
				
		this.defaultWay = defaultWay;
				
		this.createBy = createBy;
				
		this.createDat = createDat;
				
		this.lUpdateDat = lUpdateDat;
				
		this.isDel = isDel;
				
		this.bankIcon = bankIcon;
				
	}

	public UserCashoutAcc() {
	    super();
	}

	public String dateToStringConvert(Date date) {
		if(date!=null) {
			return DateUtil.format(date, "yyyy-MM-dd HH:mm:ss");
		}
		return "";
	}
	

}