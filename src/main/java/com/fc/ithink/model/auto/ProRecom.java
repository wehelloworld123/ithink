package com.fc.ithink.model.auto;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import cn.hutool.core.date.DateUtil;
import java.util.Date;

public class ProRecom implements Serializable {
    private static final long serialVersionUID = 1L;

	
	@ApiModelProperty(value = "主键")
	private Integer id;
	
	@ApiModelProperty(value = "内容")
	private String content;
	
	@ApiModelProperty(value = "章节Id")
	private String contentId;
	
	@ApiModelProperty(value = "标题")
	private String title;
	
	@ApiModelProperty(value = "摘要")
	private String summary;
	
	@ApiModelProperty(value = "类型")
	private Integer typ;
	
	@ApiModelProperty(value = "点赞")
	private Integer likes;
	
	@ApiModelProperty(value = "点赞用户字串")
	private String favorer;
	
	@ApiModelProperty(value = "推荐人")
	private String creator;
	
	@ApiModelProperty(value = "推荐人头像")
	private String createAvat;
	
	@ApiModelProperty(value = "性别")
	private Integer createSex;
	
	@ApiModelProperty(value = "采纳")
	private Integer adopt;
	
	@ApiModelProperty(value = "创建人Id")
	private String createBy;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	@ApiModelProperty(value = "创建时间")
	private Date createDat;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	@ApiModelProperty(value = "最后更新时间")
	private Date lUpdateDat;
	
	@ApiModelProperty(value = "删除")
	private Integer isDel;
	
	@JsonProperty("id")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id =  id;
	}
	@JsonProperty("content")
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content =  content;
	}
	@JsonProperty("contentId")
	public String getContentId() {
		return contentId;
	}

	public void setContentId(String contentId) {
		this.contentId =  contentId;
	}
	@JsonProperty("title")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title =  title;
	}
	@JsonProperty("summary")
	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary =  summary;
	}
	@JsonProperty("typ")
	public Integer getTyp() {
		return typ;
	}

	public void setTyp(Integer typ) {
		this.typ =  typ;
	}
	@JsonProperty("likes")
	public Integer getLikes() {
		return likes;
	}

	public void setLikes(Integer likes) {
		this.likes =  likes;
	}
	@JsonProperty("favorer")
	public String getFavorer() {
		return favorer;
	}

	public void setFavorer(String favorer) {
		this.favorer =  favorer;
	}
	@JsonProperty("creator")
	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator =  creator;
	}
	@JsonProperty("createAvat")
	public String getCreateAvat() {
		return createAvat;
	}

	public void setCreateAvat(String createAvat) {
		this.createAvat =  createAvat;
	}
	@JsonProperty("createSex")
	public Integer getCreateSex() {
		return createSex;
	}

	public void setCreateSex(Integer createSex) {
		this.createSex =  createSex;
	}
	@JsonProperty("adopt")
	public Integer getAdopt() {
		return adopt;
	}

	public void setAdopt(Integer adopt) {
		this.adopt =  adopt;
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

																																
	public ProRecom(Integer id,String content,String contentId,String title,String summary,Integer typ,Integer likes,String favorer,String creator,String createAvat,Integer createSex,Integer adopt,String createBy,Date createDat,Date lUpdateDat,Integer isDel) {
				
		this.id = id;
				
		this.content = content;
				
		this.contentId = contentId;
				
		this.title = title;
				
		this.summary = summary;
				
		this.typ = typ;
				
		this.likes = likes;
				
		this.favorer = favorer;
				
		this.creator = creator;
				
		this.createAvat = createAvat;
				
		this.createSex = createSex;
				
		this.adopt = adopt;
				
		this.createBy = createBy;
				
		this.createDat = createDat;
				
		this.lUpdateDat = lUpdateDat;
				
		this.isDel = isDel;
				
	}

	public ProRecom() {
	    super();
	}

	public String dateToStringConvert(Date date) {
		if(date!=null) {
			return DateUtil.format(date, "yyyy-MM-dd HH:mm:ss");
		}
		return "";
	}
	

}