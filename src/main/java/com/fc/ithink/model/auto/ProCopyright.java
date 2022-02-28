package com.fc.ithink.model.auto;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import cn.hutool.core.date.DateUtil;

import java.math.BigDecimal;
import java.util.Date;

public class ProCopyright implements Serializable {
    private static final long serialVersionUID = 1L;

	
	@ApiModelProperty(value = "主键")
	private Long id;
	
	@ApiModelProperty(value = "创作编号")
	private String proNo;
	
	@ApiModelProperty(value = "作品编号")
	private String creationId;
	
	@ApiModelProperty(value = "作品类型")
	private Integer createTyp;
	
	@ApiModelProperty(value = "版权")
	private BigDecimal copyright;
	
	@ApiModelProperty(value = "作者")
	private String author;
	
	@ApiModelProperty(value = "作者id")
	private String authorId;
	
	@ApiModelProperty(value = "材料文件")
	private String fileStr;
	
	@ApiModelProperty(value = "分配方式")
	private String allotType;
	
	@ApiModelProperty(value = "作品角色")
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
	private String proNm;
	
	@ApiModelProperty(value = "")
	private String creationNm;
	
	@ApiModelProperty(value = "")
	private Integer reward;
	
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
	@JsonProperty("creationId")
	public String getCreationId() {
		return creationId;
	}

	public void setCreationId(String creationId) {
		this.creationId =  creationId;
	}
	@JsonProperty("createTyp")
	public Integer getCreateTyp() {
		return createTyp;
	}

	public void setCreateTyp(Integer createTyp) {
		this.createTyp =  createTyp;
	}
	@JsonProperty("copyright")
	public BigDecimal getCopyright() {
		return copyright;
	}

	public void setCopyright(BigDecimal copyright) {
		this.copyright =  copyright;
	}
	@JsonProperty("author")
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author =  author;
	}
	@JsonProperty("authorId")
	public String getAuthorId() {
		return authorId;
	}

	public void setAuthorId(String authorId) {
		this.authorId =  authorId;
	}
	@JsonProperty("fileStr")
	public String getFileStr() {
		return fileStr;
	}

	public void setFileStr(String fileStr) {
		this.fileStr =  fileStr;
	}
	@JsonProperty("allotType")
	public String getAllotType() {
		return allotType;
	}

	public void setAllotType(String allotType) {
		this.allotType =  allotType;
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
	@JsonProperty("proNm")
	public String getProNm() {
		return proNm;
	}

	public void setProNm(String proNm) {
		this.proNm =  proNm;
	}
	@JsonProperty("creationNm")
	public String getCreationNm() {
		return creationNm;
	}

	public void setCreationNm(String creationNm) {
		this.creationNm =  creationNm;
	}
	@JsonProperty("reward")
	public Integer getReward() {
		return reward;
	}

	public void setReward(Integer reward) {
		this.reward =  reward;
	}

																																		
	public ProCopyright(Long id,String proNo,String creationId,Integer createTyp,BigDecimal copyright,String author,String authorId,String fileStr,String allotType,String role,String createBy,Date createDat,Date lUpdateDat,Integer isDel,String proNm,String creationNm,Integer reward) {
				
		this.id = id;
				
		this.proNo = proNo;
				
		this.creationId = creationId;
				
		this.createTyp = createTyp;
				
		this.copyright = copyright;
				
		this.author = author;
				
		this.authorId = authorId;
				
		this.fileStr = fileStr;
				
		this.allotType = allotType;
				
		this.role = role;
				
		this.createBy = createBy;
				
		this.createDat = createDat;
				
		this.lUpdateDat = lUpdateDat;
				
		this.isDel = isDel;
				
		this.proNm = proNm;
				
		this.creationNm = creationNm;
				
		this.reward = reward;
				
	}

	public ProCopyright() {
	    super();
	}

	public String dateToStringConvert(Date date) {
		if(date!=null) {
			return DateUtil.format(date, "yyyy-MM-dd HH:mm:ss");
		}
		return "";
	}
	

}