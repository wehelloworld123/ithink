package com.fc.ithink.model.auto;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import cn.hutool.core.date.DateUtil;
import java.util.Date;

public class ProSubTopic implements Serializable {
    private static final long serialVersionUID = 1L;

	
	@ApiModelProperty(value = "主题id")
	private String topicId;
	
	@ApiModelProperty(value = "主题")
	private String topic;
	
	@ApiModelProperty(value = "创作者数量")
	private Integer creator;
	
	@ApiModelProperty(value = "用户id")
	private String productNm;
	
	@ApiModelProperty(value = "描述")
	private String description;
	
	@ApiModelProperty(value = "等级")
	private Integer rank;
	
	@ApiModelProperty(value = "分值")
	private Integer grade;
	
	@ApiModelProperty(value = "标签1")
	private String label1;
	
	@ApiModelProperty(value = "标签2")
	private String label2;
	
	@ApiModelProperty(value = "标签3")
	private String label3;
	
	@ApiModelProperty(value = "logo")
	private String logo;
	
	@ApiModelProperty(value = "简称")
	private String dn;
	
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
	private String introduce;
	
	@JsonProperty("topicId")
	public String getTopicId() {
		return topicId;
	}

	public void setTopicId(String topicId) {
		this.topicId =  topicId;
	}
	@JsonProperty("topic")
	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic =  topic;
	}
	@JsonProperty("creator")
	public Integer getCreator() {
		return creator;
	}

	public void setCreator(Integer creator) {
		this.creator =  creator;
	}
	@JsonProperty("productNm")
	public String getProductNm() {
		return productNm;
	}

	public void setProductNm(String productNm) {
		this.productNm =  productNm;
	}
	@JsonProperty("description")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description =  description;
	}
	@JsonProperty("rank")
	public Integer getRank() {
		return rank;
	}

	public void setRank(Integer rank) {
		this.rank =  rank;
	}
	@JsonProperty("grade")
	public Integer getGrade() {
		return grade;
	}

	public void setGrade(Integer grade) {
		this.grade =  grade;
	}
	@JsonProperty("label1")
	public String getLabel1() {
		return label1;
	}

	public void setLabel1(String label1) {
		this.label1 =  label1;
	}
	@JsonProperty("label2")
	public String getLabel2() {
		return label2;
	}

	public void setLabel2(String label2) {
		this.label2 =  label2;
	}
	@JsonProperty("label3")
	public String getLabel3() {
		return label3;
	}

	public void setLabel3(String label3) {
		this.label3 =  label3;
	}
	@JsonProperty("logo")
	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo =  logo;
	}
	@JsonProperty("dn")
	public String getDn() {
		return dn;
	}

	public void setDn(String dn) {
		this.dn =  dn;
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
	@JsonProperty("introduce")
	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce =  introduce;
	}

																																		
	public ProSubTopic(String topicId,String topic,Integer creator,String productNm,String description,Integer rank,Integer grade,String label1,String label2,String label3,String logo,String dn,String createBy,Date createDat,Date lUpdateDat,Integer isDel,String introduce) {
				
		this.topicId = topicId;
				
		this.topic = topic;
				
		this.creator = creator;
				
		this.productNm = productNm;
				
		this.description = description;
				
		this.rank = rank;
				
		this.grade = grade;
				
		this.label1 = label1;
				
		this.label2 = label2;
				
		this.label3 = label3;
				
		this.logo = logo;
				
		this.dn = dn;
				
		this.createBy = createBy;
				
		this.createDat = createDat;
				
		this.lUpdateDat = lUpdateDat;
				
		this.isDel = isDel;
				
		this.introduce = introduce;
				
	}

	public ProSubTopic() {
	    super();
	}

	public String dateToStringConvert(Date date) {
		if(date!=null) {
			return DateUtil.format(date, "yyyy-MM-dd HH:mm:ss");
		}
		return "";
	}
	

}