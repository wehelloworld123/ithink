package com.fc.ithink.model.auto;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import cn.hutool.core.date.DateUtil;
import java.util.Date;

public class ProPaint implements Serializable {
    private static final long serialVersionUID = 1L;

	
	@ApiModelProperty(value = "主键")
	private String uid;
	
	@ApiModelProperty(value = "集名")
	private String seter;
	
	@ApiModelProperty(value = "名称")
	private String name;
	
	@ApiModelProperty(value = "二维码")
	private String qrCode;
	
	@ApiModelProperty(value = "展示图")
	private String exhibition;
	
	@ApiModelProperty(value = "封面")
	private String cover;
	
	@ApiModelProperty(value = "主旨")
	private String topic;
	
	@ApiModelProperty(value = "用途")
	private String purpose;
	
	@ApiModelProperty(value = "描述")
	private String description;
	
	@ApiModelProperty(value = "评分")
	private Float rate;
	
	@ApiModelProperty(value = "类别")
	private String kind;
	
	@ApiModelProperty(value = "分集")
	private Integer parts;
	
	@ApiModelProperty(value = "画作")
	private Integer section;
	
	@ApiModelProperty(value = "完成分集")
	private Integer finPart;
	
	@ApiModelProperty(value = "完成画作")
	private Integer finSection;
	
	@ApiModelProperty(value = "形式")
	private String form;
	
	@ApiModelProperty(value = "创作者")
	private Long partner;
	
	@ApiModelProperty(value = "浏览量")
	private Long views;
	
	@ApiModelProperty(value = "版权")
	private Float copyright;
	
	@ApiModelProperty(value = "")
	private Integer reward;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	@ApiModelProperty(value = "期限")
	private Date deadline;
	
	@ApiModelProperty(value = "出品方")
	private String publisher;
	
	@ApiModelProperty(value = "置顶")
	private Integer isTop;
	
	@ApiModelProperty(value = "完成")
	private Integer finish;
	
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
	private String source;
	
	@ApiModelProperty(value = "")
	private String contract;
	
	@JsonProperty("uid")
	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid =  uid;
	}
	@JsonProperty("seter")
	public String getSeter() {
		return seter;
	}

	public void setSeter(String seter) {
		this.seter =  seter;
	}
	@JsonProperty("name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name =  name;
	}
	@JsonProperty("qrCode")
	public String getQrCode() {
		return qrCode;
	}

	public void setQrCode(String qrCode) {
		this.qrCode =  qrCode;
	}
	@JsonProperty("exhibition")
	public String getExhibition() {
		return exhibition;
	}

	public void setExhibition(String exhibition) {
		this.exhibition =  exhibition;
	}
	@JsonProperty("cover")
	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover =  cover;
	}
	@JsonProperty("topic")
	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic =  topic;
	}
	@JsonProperty("purpose")
	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose =  purpose;
	}
	@JsonProperty("description")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description =  description;
	}
	@JsonProperty("rate")
	public Float getRate() {
		return rate;
	}

	public void setRate(Float rate) {
		this.rate =  rate;
	}
	@JsonProperty("kind")
	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind =  kind;
	}
	@JsonProperty("parts")
	public Integer getParts() {
		return parts;
	}

	public void setParts(Integer parts) {
		this.parts =  parts;
	}
	@JsonProperty("section")
	public Integer getSection() {
		return section;
	}

	public void setSection(Integer section) {
		this.section =  section;
	}
	@JsonProperty("finPart")
	public Integer getFinPart() {
		return finPart;
	}

	public void setFinPart(Integer finPart) {
		this.finPart =  finPart;
	}
	@JsonProperty("finSection")
	public Integer getFinSection() {
		return finSection;
	}

	public void setFinSection(Integer finSection) {
		this.finSection =  finSection;
	}
	@JsonProperty("form")
	public String getForm() {
		return form;
	}

	public void setForm(String form) {
		this.form =  form;
	}
	@JsonProperty("partner")
	public Long getPartner() {
		return partner;
	}

	public void setPartner(Long partner) {
		this.partner =  partner;
	}
	@JsonProperty("views")
	public Long getViews() {
		return views;
	}

	public void setViews(Long views) {
		this.views =  views;
	}
	@JsonProperty("copyright")
	public Float getCopyright() {
		return copyright;
	}

	public void setCopyright(Float copyright) {
		this.copyright =  copyright;
	}
	@JsonProperty("reward")
	public Integer getReward() {
		return reward;
	}

	public void setReward(Integer reward) {
		this.reward =  reward;
	}
	@JsonProperty("deadline")
	public Date getDeadline() {
		return deadline;
	}

	public void setDeadline(Date deadline) {
		this.deadline =  deadline;
	}
	@JsonProperty("publisher")
	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher =  publisher;
	}
	@JsonProperty("isTop")
	public Integer getIsTop() {
		return isTop;
	}

	public void setIsTop(Integer isTop) {
		this.isTop =  isTop;
	}
	@JsonProperty("finish")
	public Integer getFinish() {
		return finish;
	}

	public void setFinish(Integer finish) {
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
	@JsonProperty("source")
	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source =  source;
	}
	@JsonProperty("contract")
	public String getContract() {
		return contract;
	}

	public void setContract(String contract) {
		this.contract =  contract;
	}

																																																												
	public ProPaint(String uid,String seter,String name,String qrCode,String exhibition,String cover,String topic,String purpose,String description,Float rate,String kind,Integer parts,Integer section,Integer finPart,Integer finSection,String form,Long partner,Long views,Float copyright,Integer reward,Date deadline,String publisher,Integer isTop,Integer finish,String createBy,Date createDat,Date lUpdateDat,Integer isDel,String source,String contract) {
				
		this.uid = uid;
				
		this.seter = seter;
				
		this.name = name;
				
		this.qrCode = qrCode;
				
		this.exhibition = exhibition;
				
		this.cover = cover;
				
		this.topic = topic;
				
		this.purpose = purpose;
				
		this.description = description;
				
		this.rate = rate;
				
		this.kind = kind;
				
		this.parts = parts;
				
		this.section = section;
				
		this.finPart = finPart;
				
		this.finSection = finSection;
				
		this.form = form;
				
		this.partner = partner;
				
		this.views = views;
				
		this.copyright = copyright;
				
		this.reward = reward;
				
		this.deadline = deadline;
				
		this.publisher = publisher;
				
		this.isTop = isTop;
				
		this.finish = finish;
				
		this.createBy = createBy;
				
		this.createDat = createDat;
				
		this.lUpdateDat = lUpdateDat;
				
		this.isDel = isDel;
				
		this.source = source;
				
		this.contract = contract;
				
	}

	public ProPaint() {
	    super();
	}

	public String dateToStringConvert(Date date) {
		if(date!=null) {
			return DateUtil.format(date, "yyyy-MM-dd HH:mm:ss");
		}
		return "";
	}
	

}