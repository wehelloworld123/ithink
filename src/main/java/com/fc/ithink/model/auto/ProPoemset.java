package com.fc.ithink.model.auto;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import cn.hutool.core.date.DateUtil;
import java.util.Date;

public class ProPoemset implements Serializable {
    private static final long serialVersionUID = 1L;

	
	@ApiModelProperty(value = "编号")
	private Long id;
	
	@ApiModelProperty(value = "题")
	private String charpter;
	
	@ApiModelProperty(value = "章节介绍")
	private String description;
	
	@ApiModelProperty(value = "图片")
	private String pic;
	
	@ApiModelProperty(value = "创作要求")
	private String requirement;
	
	@ApiModelProperty(value = "根")
	private Integer root;
	
	@ApiModelProperty(value = "分集编号")
	private Long rootId;
	
	@ApiModelProperty(value = "关联文章编号")
	private Long literId;
	
	@ApiModelProperty(value = "关联绘画编号")
	private Long paintId;
	
	@ApiModelProperty(value = "创作人员数")
	private Integer creators;
	
	@ApiModelProperty(value = "数量")
	private Integer number;
	
	@ApiModelProperty(value = "根序号")
	private Integer rootOrd;
	
	@ApiModelProperty(value = "序号")
	private Integer ord;
	
	@ApiModelProperty(value = "诗歌集编号")
	private String poetryId;
	
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
	
	@ApiModelProperty(value = "删除")
	private Integer isDel;
	
	@ApiModelProperty(value = "")
	private Integer isLock;
	
	@ApiModelProperty(value = "")
	private Integer views;


	@ApiModelProperty(value = "诗词类型")
	private String chapType;

	@JsonProperty("chapType")
	public String getChapType() {
		return chapType;
	}

	public void setChapType(String chapType) {
		this.chapType =  chapType;
	}
	
	@JsonProperty("id")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id =  id;
	}
	@JsonProperty("charpter")
	public String getCharpter() {
		return charpter;
	}

	public void setCharpter(String charpter) {
		this.charpter =  charpter;
	}
	@JsonProperty("description")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description =  description;
	}
	@JsonProperty("pic")
	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic =  pic;
	}
	@JsonProperty("requirement")
	public String getRequirement() {
		return requirement;
	}

	public void setRequirement(String requirement) {
		this.requirement =  requirement;
	}
	@JsonProperty("root")
	public Integer getRoot() {
		return root;
	}

	public void setRoot(Integer root) {
		this.root =  root;
	}
	@JsonProperty("rootId")
	public Long getRootId() {
		return rootId;
	}

	public void setRootId(Long rootId) {
		this.rootId =  rootId;
	}
	@JsonProperty("literId")
	public Long getLiterId() {
		return literId;
	}

	public void setLiterId(Long literId) {
		this.literId =  literId;
	}
	@JsonProperty("paintId")
	public Long getPaintId() {
		return paintId;
	}

	public void setPaintId(Long paintId) {
		this.paintId =  paintId;
	}
	@JsonProperty("creators")
	public Integer getCreators() {
		return creators;
	}

	public void setCreators(Integer creators) {
		this.creators =  creators;
	}
	@JsonProperty("number")
	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number =  number;
	}
	@JsonProperty("rootOrd")
	public Integer getRootOrd() {
		return rootOrd;
	}

	public void setRootOrd(Integer rootOrd) {
		this.rootOrd =  rootOrd;
	}
	@JsonProperty("ord")
	public Integer getOrd() {
		return ord;
	}

	public void setOrd(Integer ord) {
		this.ord =  ord;
	}
	@JsonProperty("poetryId")
	public String getPoetryId() {
		return poetryId;
	}

	public void setPoetryId(String poetryId) {
		this.poetryId =  poetryId;
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
	@JsonProperty("isLock")
	public Integer getIsLock() {
		return isLock;
	}

	public void setIsLock(Integer isLock) {
		this.isLock =  isLock;
	}
	@JsonProperty("views")
	public Integer getViews() {
		return views;
	}

	public void setViews(Integer views) {
		this.views =  views;
	}

																																										
	public ProPoemset(Long id,String charpter,String description,String pic,String requirement,Integer root,Long rootId,Long literId,Long paintId,Integer creators,Integer number,Integer rootOrd,Integer ord,String poetryId,Integer finish,String createBy,Date createDat,Date lUpdateDat,Integer isDel,Integer isLock,Integer views) {
				
		this.id = id;
				
		this.charpter = charpter;
				
		this.description = description;
				
		this.pic = pic;
				
		this.requirement = requirement;
				
		this.root = root;
				
		this.rootId = rootId;
				
		this.literId = literId;
				
		this.paintId = paintId;
				
		this.creators = creators;
				
		this.number = number;
				
		this.rootOrd = rootOrd;
				
		this.ord = ord;
				
		this.poetryId = poetryId;
				
		this.finish = finish;
				
		this.createBy = createBy;
				
		this.createDat = createDat;
				
		this.lUpdateDat = lUpdateDat;
				
		this.isDel = isDel;
				
		this.isLock = isLock;
				
		this.views = views;
				
	}

	public ProPoemset() {
	    super();
	}
	public ProPoemset(Long id) {
		this.id = id;
	}
	public String dateToStringConvert(Date date) {
		if(date!=null) {
			return DateUtil.format(date, "yyyy-MM-dd HH:mm:ss");
		}
		return "";
	}
	

}