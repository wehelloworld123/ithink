package com.fc.ithink.model.auto;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import cn.hutool.core.date.DateUtil;
import java.util.Date;

public class ProPoetryContent implements Serializable {
    private static final long serialVersionUID = 1L;

	
	@ApiModelProperty(value = "主键")
	private String no;
	
	@ApiModelProperty(value = "词名")
	private String title;
	
	@ApiModelProperty(value = "牌名")
	private String brand;
	
	@ApiModelProperty(value = "内容")
	private String content;
	
	@ApiModelProperty(value = "")
	private Long charpId;
	
	@ApiModelProperty(value = "章名")
	private String charpName;


	
	@ApiModelProperty(value = "节名")
	private String secName;
	
	@ApiModelProperty(value = "作品编号")
	private String poetryId;
	
	@ApiModelProperty(value = "作品名称")
	private String poetryName;
	
	@ApiModelProperty(value = "喜欢")
	private Integer likes;
	
	@ApiModelProperty(value = "推荐")
	private Integer recomNo;
	
	@ApiModelProperty(value = "采纳")
	private Integer adopt;
	
	@ApiModelProperty(value = "点赞用户")
	private String favorer;
	
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
	
	@ApiModelProperty(value = "")
	private String creator;
	
	@ApiModelProperty(value = "")
	private Integer views;

	private int typ;
	
	@JsonProperty("no")
	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no =  no;
	}
	@JsonProperty("title")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title =  title;
	}
	@JsonProperty("brand")
	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand =  brand;
	}
	@JsonProperty("content")
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content =  content;
	}
	@JsonProperty("charpId")
	public Long getCharpId() {
		return charpId;
	}

	public void setCharpId(Long charpId) {
		this.charpId =  charpId;
	}
	@JsonProperty("charpName")
	public String getCharpName() {
		return charpName;
	}

	public void setCharpName(String charpName) {
		this.charpName =  charpName;
	}
	@JsonProperty("secName")
	public String getSecName() {
		return secName;
	}

	public void setSecName(String secName) {
		this.secName =  secName;
	}
	@JsonProperty("poetryId")
	public String getPoetryId() {
		return poetryId;
	}

	public void setPoetryId(String poetryId) {
		this.poetryId =  poetryId;
	}
	@JsonProperty("poetryName")
	public String getPoetryName() {
		return poetryName;
	}

	public void setPoetryName(String poetryName) {
		this.poetryName =  poetryName;
	}
	@JsonProperty("likes")
	public Integer getLikes() {
		return likes;
	}

	public void setLikes(Integer likes) {
		this.likes =  likes;
	}
	@JsonProperty("recomNo")
	public Integer getRecomNo() {
		return recomNo;
	}

	public void setRecomNo(Integer recomNo) {
		this.recomNo =  recomNo;
	}
	@JsonProperty("adopt")
	public Integer getAdopt() {
		return adopt;
	}

	public void setAdopt(Integer adopt) {
		this.adopt =  adopt;
	}
	@JsonProperty("favorer")
	public String getFavorer() {
		return favorer;
	}

	public void setFavorer(String favorer) {
		this.favorer =  favorer;
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
	@JsonProperty("creator")
	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator =  creator;
	}
	@JsonProperty("views")
	public Integer getViews() {
		return views;
	}

	public void setViews(Integer views) {
		this.views =  views;
	}


	public int getTyp() {
		return typ;
	}

	public void setTyp(int typ) {
		this.typ =  typ;
	}

																																						
	public ProPoetryContent(String no,String title,String brand,String content,Long charpId,String charpName,String secName,String poetryId,String poetryName,Integer likes,Integer recomNo,Integer adopt,String favorer,String createBy,Date createDat,Date lUpdateDat,Integer isDel,String creator,Integer views) {
				
		this.no = no;
				
		this.title = title;
				
		this.brand = brand;
				
		this.content = content;
				
		this.charpId = charpId;
				
		this.charpName = charpName;
				
		this.secName = secName;
				
		this.poetryId = poetryId;
				
		this.poetryName = poetryName;
				
		this.likes = likes;
				
		this.recomNo = recomNo;
				
		this.adopt = adopt;
				
		this.favorer = favorer;
				
		this.createBy = createBy;
				
		this.createDat = createDat;
				
		this.lUpdateDat = lUpdateDat;
				
		this.isDel = isDel;
				
		this.creator = creator;
				
		this.views = views;
				
	}

	public ProPoetryContent() {
	    super();
	}

	public String dateToStringConvert(Date date) {
		if(date!=null) {
			return DateUtil.format(date, "yyyy-MM-dd HH:mm:ss");
		}
		return "";
	}
	

}