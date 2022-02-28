package com.fc.ithink.model.auto;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import cn.hutool.core.date.DateUtil;
import java.util.Date;

public class ProLiter implements Serializable {
    private static final long serialVersionUID = 1L;

	
	@ApiModelProperty(value = "主键")
	private String uid;
	
	@ApiModelProperty(value = "书名")
	private String name;
	
	@ApiModelProperty(value = "封面")
	private String cover;
	
	@ApiModelProperty(value = "二维码")
	private String qrCode;
	
	@ApiModelProperty(value = "展示图")
	private String exhibition;
	
	@ApiModelProperty(value = "类型")
	private String typ;
	
	@ApiModelProperty(value = "标签")
	private String label;
	
	@ApiModelProperty(value = "介绍")
	private String introduce;
	
	@ApiModelProperty(value = "描述")
	private String description;
	
	@ApiModelProperty(value = "评分")
	private Float rate;
	
	@ApiModelProperty(value = "类别")
	private String kind;
	
	@ApiModelProperty(value = "章节")
	private Integer charpter;
	
	@ApiModelProperty(value = "小节")
	private Integer section;
	
	@ApiModelProperty(value = "完成章节")
	private Integer finCharp;
	
	@ApiModelProperty(value = "完成小节")
	private Integer finSection;
	
	@ApiModelProperty(value = "创作形式")
	private Integer form;
	
	@ApiModelProperty(value = "版权")
	private Integer copyright;
	
	@ApiModelProperty(value = "")
	private Integer reward;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	@ApiModelProperty(value = "期限")
	private Date deadline;
	
	@ApiModelProperty(value = "出版方")
	private String publisher;
	
	@ApiModelProperty(value = "置顶")
	private Integer isTop;
	
	@ApiModelProperty(value = "创作者")
	private Integer partner;
	
	@ApiModelProperty(value = "浏览量")
	private Long views;
	
	@ApiModelProperty(value = "完成")
	private Integer finish;
	
	@ApiModelProperty(value = "创建人")
	private String createBy;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	@ApiModelProperty(value = "创建时间")
	private Date createDat;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	@ApiModelProperty(value = "更新时间")
	private Date lUpdateDat;
	
	@ApiModelProperty(value = "删除")
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
	@JsonProperty("name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name =  name;
	}
	@JsonProperty("cover")
	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover =  cover;
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
	@JsonProperty("typ")
	public String getTyp() {
		return typ;
	}

	public void setTyp(String typ) {
		this.typ =  typ;
	}
	@JsonProperty("label")
	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label =  label;
	}
	@JsonProperty("introduce")
	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce =  introduce;
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
	@JsonProperty("charpter")
	public Integer getCharpter() {
		return charpter;
	}

	public void setCharpter(Integer charpter) {
		this.charpter =  charpter;
	}
	@JsonProperty("section")
	public Integer getSection() {
		return section;
	}

	public void setSection(Integer section) {
		this.section =  section;
	}
	@JsonProperty("finCharp")
	public Integer getFinCharp() {
		return finCharp;
	}

	public void setFinCharp(Integer finCharp) {
		this.finCharp =  finCharp;
	}
	@JsonProperty("finSection")
	public Integer getFinSection() {
		return finSection;
	}

	public void setFinSection(Integer finSection) {
		this.finSection =  finSection;
	}
	@JsonProperty("form")
	public Integer getForm() {
		return form;
	}

	public void setForm(Integer form) {
		this.form =  form;
	}
	@JsonProperty("copyright")
	public Integer getCopyright() {
		return copyright;
	}

	public void setCopyright(Integer copyright) {
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
	@JsonProperty("partner")
	public Integer getPartner() {
		return partner;
	}

	public void setPartner(Integer partner) {
		this.partner =  partner;
	}
	@JsonProperty("views")
	public Long getViews() {
		return views;
	}

	public void setViews(Long views) {
		this.views =  views;
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

																																																												
	public ProLiter(String uid,String name,String cover,String qrCode,String exhibition,String typ,String label,String introduce,String description,Float rate,String kind,Integer charpter,Integer section,Integer finCharp,Integer finSection,Integer form,Integer copyright,Integer reward,Date deadline,String publisher,Integer isTop,Integer partner,Long views,Integer finish,String createBy,Date createDat,Date lUpdateDat,Integer isDel,String source,String contract) {
				
		this.uid = uid;
				
		this.name = name;
				
		this.cover = cover;
				
		this.qrCode = qrCode;
				
		this.exhibition = exhibition;
				
		this.typ = typ;
				
		this.label = label;
				
		this.introduce = introduce;
				
		this.description = description;
				
		this.rate = rate;
				
		this.kind = kind;
				
		this.charpter = charpter;
				
		this.section = section;
				
		this.finCharp = finCharp;
				
		this.finSection = finSection;
				
		this.form = form;
				
		this.copyright = copyright;
				
		this.reward = reward;
				
		this.deadline = deadline;
				
		this.publisher = publisher;
				
		this.isTop = isTop;
				
		this.partner = partner;
				
		this.views = views;
				
		this.finish = finish;
				
		this.createBy = createBy;
				
		this.createDat = createDat;
				
		this.lUpdateDat = lUpdateDat;
				
		this.isDel = isDel;
				
		this.source = source;
				
		this.contract = contract;
				
	}

	public ProLiter() {
	    super();
	}

	public String dateToStringConvert(Date date) {
		if(date!=null) {
			return DateUtil.format(date, "yyyy-MM-dd HH:mm:ss");
		}
		return "";
	}
	

}