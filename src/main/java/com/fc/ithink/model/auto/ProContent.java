package com.fc.ithink.model.auto;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import cn.hutool.core.date.DateUtil;
import java.util.Date;

public class ProContent implements Serializable {
    private static final long serialVersionUID = 1L;

	
	@ApiModelProperty(value = "主键")
	private String no;
	
	@ApiModelProperty(value = "标题")
	private String title;
	
	@ApiModelProperty(value = "")
	private String summary;
	
	@ApiModelProperty(value = "内容")
	private String content;
	
	@ApiModelProperty(value = "图片")
	private String pic;
	
	@ApiModelProperty(value = "章节编号")
	private Long charpId;
	
	@ApiModelProperty(value = "章节名称")
	private String charpName;
	
	@ApiModelProperty(value = "小节名称")
	private String secName;
	
	@ApiModelProperty(value = "书籍编号")
	private String bookId;
	
	@ApiModelProperty(value = "书籍名称")
	private String bookName;
	
	@ApiModelProperty(value = "点赞")
	private Integer likes;
	
	@ApiModelProperty(value = "推荐")
	private Integer recomNo;
	
	@ApiModelProperty(value = "展示")
	private Integer views;
	
	@ApiModelProperty(value = "采纳")
	private Integer adopt;
	
	@ApiModelProperty(value = "点赞人")
	private String favorer;
	
	@ApiModelProperty(value = "创建人")
	private String creator;
	
	@ApiModelProperty(value = "创建人Id")
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
	private String detail;


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
	@JsonProperty("summary")
	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary =  summary;
	}
	@JsonProperty("content")
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content =  content;
	}
	@JsonProperty("pic")
	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic =  pic;
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
	@JsonProperty("bookId")
	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId =  bookId;
	}
	@JsonProperty("bookName")
	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName =  bookName;
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
	@JsonProperty("views")
	public Integer getViews() {
		return views;
	}

	public void setViews(Integer views) {
		this.views =  views;
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
	@JsonProperty("creator")
	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator =  creator;
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
	@JsonProperty("detail")
	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail =  detail;
	}

	public int getTyp() {
		return typ;
	}

	public void setTyp(int typ) {
		this.typ =  typ;
	}
																																										
	public ProContent(String no,String title,String summary,String content,String pic,Long charpId,String charpName,String secName,String bookId,String bookName,Integer likes,Integer recomNo,Integer views,Integer adopt,String favorer,String creator,String createBy,Date createDat,Date lUpdateDat,Integer isDel,String detail) {
				
		this.no = no;
				
		this.title = title;
				
		this.summary = summary;
				
		this.content = content;
				
		this.pic = pic;
				
		this.charpId = charpId;
				
		this.charpName = charpName;
				
		this.secName = secName;
				
		this.bookId = bookId;
				
		this.bookName = bookName;
				
		this.likes = likes;
				
		this.recomNo = recomNo;
				
		this.views = views;
				
		this.adopt = adopt;
				
		this.favorer = favorer;
				
		this.creator = creator;
				
		this.createBy = createBy;
				
		this.createDat = createDat;
				
		this.lUpdateDat = lUpdateDat;
				
		this.isDel = isDel;
				
		this.detail = detail;
				
	}

	public ProContent() {
	    super();
	}

	public String dateToStringConvert(Date date) {
		if(date!=null) {
			return DateUtil.format(date, "yyyy-MM-dd HH:mm:ss");
		}
		return "";
	}
	

}