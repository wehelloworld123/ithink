package com.fc.ithink.model.auto;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import cn.hutool.core.date.DateUtil;

import java.math.BigDecimal;
import java.util.Date;

public class UserCashoutApply implements Serializable {
    private static final long serialVersionUID = 1L;

	
	@ApiModelProperty(value = "主键")
	private Long id;
	
	@ApiModelProperty(value = "提现方式")
	private String cashoutAccNo;
	
	@ApiModelProperty(value = "提现金额")
	private BigDecimal amt;
	
	@ApiModelProperty(value = "实际提现金额")
	private BigDecimal actAmt;
	
	@ApiModelProperty(value = "手续费")
	private BigDecimal poundage;
	
	@ApiModelProperty(value = "完成")
	private String finish;
	
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
	private String bankFlowNo;
	
	@JsonProperty("id")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id =  id;
	}
	@JsonProperty("cashoutAccNo")
	public String getCashoutAccNo() {
		return cashoutAccNo;
	}

	public void setCashoutAccNo(String cashoutAccNo) {
		this.cashoutAccNo =  cashoutAccNo;
	}
	@JsonProperty("amt")
	public BigDecimal getAmt() {
		return amt;
	}

	public void setAmt(BigDecimal amt) {
		this.amt =  amt;
	}
	@JsonProperty("actAmt")
	public BigDecimal getActAmt() {
		return actAmt;
	}

	public void setActAmt(BigDecimal actAmt) {
		this.actAmt =  actAmt;
	}
	@JsonProperty("poundage")
	public BigDecimal getPoundage() {
		return poundage;
	}

	public void setPoundage(BigDecimal poundage) {
		this.poundage =  poundage;
	}
	@JsonProperty("finish")
	public String getFinish() {
		return finish;
	}

	public void setFinish(String finish) {
		this.finish =  finish;
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
	@JsonProperty("bankFlowNo")
	public String getBankFlowNo() {
		return bankFlowNo;
	}

	public void setBankFlowNo(String bankFlowNo) {
		this.bankFlowNo =  bankFlowNo;
	}

																						
	public UserCashoutApply(Long id,String cashoutAccNo,BigDecimal amt,BigDecimal actAmt,BigDecimal poundage,String finish,String createBy,Date createDat,Date lUpdateDat,Integer isDel,String bankFlowNo) {
				
		this.id = id;
				
		this.cashoutAccNo = cashoutAccNo;
				
		this.amt = amt;
				
		this.actAmt = actAmt;
				
		this.poundage = poundage;
				
		this.finish = finish;
				
		this.createBy = createBy;
				
		this.createDat = createDat;
				
		this.lUpdateDat = lUpdateDat;
				
		this.isDel = isDel;
				
		this.bankFlowNo = bankFlowNo;
				
	}

	public UserCashoutApply() {
	    super();
	}

	public String dateToStringConvert(Date date) {
		if(date!=null) {
			return DateUtil.format(date, "yyyy-MM-dd HH:mm:ss");
		}
		return "";
	}
	

}