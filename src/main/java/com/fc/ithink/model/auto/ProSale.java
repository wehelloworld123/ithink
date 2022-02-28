package com.fc.ithink.model.auto;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import cn.hutool.core.date.DateUtil;

import java.math.BigDecimal;
import java.util.Date;

public class ProSale implements Serializable {
    private static final long serialVersionUID = 1L;

	
	@ApiModelProperty(value = "主键")
	private Long id;
	
	@ApiModelProperty(value = "作品编号")
	private String proNo;
	
	@ApiModelProperty(value = "作品类型")
	private Integer typ;
	
	@ApiModelProperty(value = "创作类型")
	private String createTyp;
	
	@ApiModelProperty(value = "标题")
	private String title;
	
	@ApiModelProperty(value = "集")
	private String seter;
	
	@ApiModelProperty(value = "封面")
	private String cover;
	
	@ApiModelProperty(value = "展示")
	private String exhibition;
	
	@ApiModelProperty(value = "标签")
	private String label;
	
	@ApiModelProperty(value = "描述")
	private String description;
	
	@ApiModelProperty(value = "售价")
	private BigDecimal saleAmt;
	
	@ApiModelProperty(value = "状态")
	private String saleStatus;
	
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
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	@ApiModelProperty(value = "")
	private Date deadline;
	
	@JsonProperty("id")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id =  id;
	}
	@JsonProperty("proNo")
	public String getProNo() {
		return proNo;
	}

	public void setProNo(String proNo) {
		this.proNo =  proNo;
	}
	@JsonProperty("typ")
	public Integer getTyp() {
		return typ;
	}

	public void setTyp(Integer typ) {
		this.typ =  typ;
	}
	@JsonProperty("createTyp")
	public String getCreateTyp() {
		return createTyp;
	}

	public void setCreateTyp(String createTyp) {
		this.createTyp =  createTyp;
	}
	@JsonProperty("title")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title =  title;
	}
	@JsonProperty("seter")
	public String getSeter() {
		return seter;
	}

	public void setSeter(String seter) {
		this.seter =  seter;
	}
	@JsonProperty("cover")
	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover =  cover;
	}
	@JsonProperty("exhibition")
	public String getExhibition() {
		return exhibition;
	}

	public void setExhibition(String exhibition) {
		this.exhibition =  exhibition;
	}
	@JsonProperty("label")
	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label =  label;
	}
	@JsonProperty("description")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description =  description;
	}
	@JsonProperty("saleAmt")
	public BigDecimal getSaleAmt() {
		return saleAmt;
	}

	public void setSaleAmt(BigDecimal saleAmt) {
		this.saleAmt =  saleAmt;
	}
	@JsonProperty("saleStatus")
	public String getSaleStatus() {
		return saleStatus;
	}

	public void setSaleStatus(String saleStatus) {
		this.saleStatus =  saleStatus;
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
	@JsonProperty("deadline")
	public Date getDeadline() {
		return deadline;
	}

	public void setDeadline(Date deadline) {
		this.deadline =  deadline;
	}

																																		
	public ProSale(Long id,String proNo,Integer typ,String createTyp,String title,String seter,String cover,String exhibition,String label,String description,BigDecimal saleAmt,String saleStatus,String createBy,Date createDat,Date lUpdateDat,Integer isDel,Date deadline) {
				
		this.id = id;
				
		this.proNo = proNo;
				
		this.typ = typ;
				
		this.createTyp = createTyp;
				
		this.title = title;
				
		this.seter = seter;
				
		this.cover = cover;
				
		this.exhibition = exhibition;
				
		this.label = label;
				
		this.description = description;
				
		this.saleAmt = saleAmt;
				
		this.saleStatus = saleStatus;
				
		this.createBy = createBy;
				
		this.createDat = createDat;
				
		this.lUpdateDat = lUpdateDat;
				
		this.isDel = isDel;
				
		this.deadline = deadline;
				
	}

	public ProSale() {
	    super();
	}

	public String dateToStringConvert(Date date) {
		if(date!=null) {
			return DateUtil.format(date, "yyyy-MM-dd HH:mm:ss");
		}
		return "";
	}
	

}