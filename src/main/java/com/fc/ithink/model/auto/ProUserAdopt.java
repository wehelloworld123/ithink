package com.fc.ithink.model.auto;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import cn.hutool.core.date.DateUtil;
import java.util.Date;

public class ProUserAdopt implements Serializable {
    private static final long serialVersionUID = 1L;

	
	@ApiModelProperty(value = "主键")
	private Long id;
	
	@ApiModelProperty(value = "创作编号")
	private String proNo;
	
	@ApiModelProperty(value = "标题")
	private String title;
	
	@ApiModelProperty(value = "内容")
	private String content;
	
	@ApiModelProperty(value = "图片")
	private String picture;
	
	@ApiModelProperty(value = "文章")
	private String literText;
	
	@ApiModelProperty(value = "创作id")
	private String creationId;
	
	@ApiModelProperty(value = "创作名称")
	private String creationNm;
	
	@ApiModelProperty(value = "章节名称")
	private String charpNm;
	
	@ApiModelProperty(value = "章节id")
	private Long charpId;
	
	@ApiModelProperty(value = "内容id")
	private String contentId;
	
	@ApiModelProperty(value = "类型")
	private Integer typ;
	
	@ApiModelProperty(value = "用户id")
	private String userId;
	
	@ApiModelProperty(value = "用户名")
	private String nickname;
	
	@ApiModelProperty(value = "头像url")
	private String avatar;
	
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
	
	@ApiModelProperty(value = "是否删除")
	private Integer isDel;
	
	@ApiModelProperty(value = "")
	private String seter;
	
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
	@JsonProperty("title")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title =  title;
	}
	@JsonProperty("content")
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content =  content;
	}
	@JsonProperty("picture")
	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture =  picture;
	}
	@JsonProperty("literText")
	public String getLiterText() {
		return literText;
	}

	public void setLiterText(String literText) {
		this.literText =  literText;
	}
	@JsonProperty("creationId")
	public String getCreationId() {
		return creationId;
	}

	public void setCreationId(String creationId) {
		this.creationId =  creationId;
	}
	@JsonProperty("creationNm")
	public String getCreationNm() {
		return creationNm;
	}

	public void setCreationNm(String creationNm) {
		this.creationNm =  creationNm;
	}
	@JsonProperty("charpNm")
	public String getCharpNm() {
		return charpNm;
	}

	public void setCharpNm(String charpNm) {
		this.charpNm =  charpNm;
	}
	@JsonProperty("charpId")
	public Long getCharpId() {
		return charpId;
	}

	public void setCharpId(Long charpId) {
		this.charpId =  charpId;
	}
	@JsonProperty("contentId")
	public String getContentId() {
		return contentId;
	}

	public void setContentId(String contentId) {
		this.contentId =  contentId;
	}
	@JsonProperty("typ")
	public Integer getTyp() {
		return typ;
	}

	public void setTyp(Integer typ) {
		this.typ =  typ;
	}
	@JsonProperty("userId")
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId =  userId;
	}
	@JsonProperty("nickname")
	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname =  nickname;
	}
	@JsonProperty("avatar")
	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar =  avatar;
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
	@JsonProperty("seter")
	public String getSeter() {
		return seter;
	}

	public void setSeter(String seter) {
		this.seter =  seter;
	}

																																										
	public ProUserAdopt(Long id,String proNo,String title,String content,String picture,String literText,String creationId,String creationNm,String charpNm,Long charpId,String contentId,Integer typ,String userId,String nickname,String avatar,Integer adopt,String createBy,Date createDat,Date lUpdateDat,Integer isDel,String seter) {
				
		this.id = id;
				
		this.proNo = proNo;
				
		this.title = title;
				
		this.content = content;
				
		this.picture = picture;
				
		this.literText = literText;
				
		this.creationId = creationId;
				
		this.creationNm = creationNm;
				
		this.charpNm = charpNm;
				
		this.charpId = charpId;
				
		this.contentId = contentId;
				
		this.typ = typ;
				
		this.userId = userId;
				
		this.nickname = nickname;
				
		this.avatar = avatar;
				
		this.adopt = adopt;
				
		this.createBy = createBy;
				
		this.createDat = createDat;
				
		this.lUpdateDat = lUpdateDat;
				
		this.isDel = isDel;
				
		this.seter = seter;
				
	}

	public ProUserAdopt() {
	    super();
	}

	public String dateToStringConvert(Date date) {
		if(date!=null) {
			return DateUtil.format(date, "yyyy-MM-dd HH:mm:ss");
		}
		return "";
	}
	

}