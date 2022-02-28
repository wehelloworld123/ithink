package com.fc.ithink.model.auto;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import cn.hutool.core.date.DateUtil;
import java.util.Date;

public class ProPaintContent implements Serializable {
    private static final long serialVersionUID = 1L;

	
	@ApiModelProperty(value = "主键")
	private String no;
	
	@ApiModelProperty(value = "标题")
	private String title;
	
	@ApiModelProperty(value = "作品链接")
	private String image;
	
	@ApiModelProperty(value = "作品链接1")
	private String pic1;
	
	@ApiModelProperty(value = "作品链接2")
	private String pic2;
	
	@ApiModelProperty(value = "作品链接3")
	private String pic3;
	
	@ApiModelProperty(value = "作品链接4")
	private String pic4;
	
	@ApiModelProperty(value = "介绍")
	private String content;
	
	@ApiModelProperty(value = "")
	private Long partId;
	
	@ApiModelProperty(value = "画集编号")
	private String paintId;
	
	@ApiModelProperty(value = "画集名称")
	private String paintName;
	
	@ApiModelProperty(value = "分集名称")
	private String partName;
	
	@ApiModelProperty(value = "画作名称")
	private String secName;
	
	@ApiModelProperty(value = "点赞")
	private Integer likes;
	
	@ApiModelProperty(value = "推荐")
	private Integer recomNo;
	
	@ApiModelProperty(value = "采纳")
	private Integer adopt;
	
	@ApiModelProperty(value = "点赞用户")
	private String favorer;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	@ApiModelProperty(value = "日期")
	private Date dat;
	
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
	
	@ApiModelProperty(value = "")
	private String proType;
	
	@ApiModelProperty(value = "")
	private String label;



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
	@JsonProperty("image")
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image =  image;
	}
	@JsonProperty("pic1")
	public String getPic1() {
		return pic1;
	}

	public void setPic1(String pic1) {
		this.pic1 =  pic1;
	}
	@JsonProperty("pic2")
	public String getPic2() {
		return pic2;
	}

	public void setPic2(String pic2) {
		this.pic2 =  pic2;
	}
	@JsonProperty("pic3")
	public String getPic3() {
		return pic3;
	}

	public void setPic3(String pic3) {
		this.pic3 =  pic3;
	}
	@JsonProperty("pic4")
	public String getPic4() {
		return pic4;
	}

	public void setPic4(String pic4) {
		this.pic4 =  pic4;
	}
	@JsonProperty("content")
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content =  content;
	}
	@JsonProperty("partId")
	public Long getPartId() {
		return partId;
	}

	public void setPartId(Long partId) {
		this.partId =  partId;
	}
	@JsonProperty("paintId")
	public String getPaintId() {
		return paintId;
	}

	public void setPaintId(String paintId) {
		this.paintId =  paintId;
	}
	@JsonProperty("paintName")
	public String getPaintName() {
		return paintName;
	}

	public void setPaintName(String paintName) {
		this.paintName =  paintName;
	}
	@JsonProperty("partName")
	public String getPartName() {
		return partName;
	}

	public void setPartName(String partName) {
		this.partName =  partName;
	}
	@JsonProperty("secName")
	public String getSecName() {
		return secName;
	}

	public void setSecName(String secName) {
		this.secName =  secName;
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
	@JsonProperty("dat")
	public Date getDat() {
		return dat;
	}

	public void setDat(Date dat) {
		this.dat =  dat;
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
	@JsonProperty("proType")
	public String getProType() {
		return proType;
	}

	public void setProType(String proType) {
		this.proType =  proType;
	}
	@JsonProperty("label")
	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label =  label;
	}



	public int getTyp() {
		return typ;
	}

	public void setTyp(int typ) {
		this.typ =  typ;
	}
																																																				
	public ProPaintContent(String no,String title,String image,String pic1,String pic2,String pic3,String pic4,String content,Long partId,String paintId,String paintName,String partName,String secName,Integer likes,Integer recomNo,Integer adopt,String favorer,Date dat,String createBy,Date createDat,Date lUpdateDat,Integer isDel,String creator,Integer views,String proType,String label) {
				
		this.no = no;
				
		this.title = title;
				
		this.image = image;
				
		this.pic1 = pic1;
				
		this.pic2 = pic2;
				
		this.pic3 = pic3;
				
		this.pic4 = pic4;
				
		this.content = content;
				
		this.partId = partId;
				
		this.paintId = paintId;
				
		this.paintName = paintName;
				
		this.partName = partName;
				
		this.secName = secName;
				
		this.likes = likes;
				
		this.recomNo = recomNo;
				
		this.adopt = adopt;
				
		this.favorer = favorer;
				
		this.dat = dat;
				
		this.createBy = createBy;
				
		this.createDat = createDat;
				
		this.lUpdateDat = lUpdateDat;
				
		this.isDel = isDel;
				
		this.creator = creator;
				
		this.views = views;
				
		this.proType = proType;
				
		this.label = label;
				
	}

	public ProPaintContent() {
	    super();
	}

	public String dateToStringConvert(Date date) {
		if(date!=null) {
			return DateUtil.format(date, "yyyy-MM-dd HH:mm:ss");
		}
		return "";
	}
	

}