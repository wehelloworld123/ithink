package com.fc.ithink.model.auto;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import cn.hutool.core.date.DateUtil;
import java.util.Date;

public class ProCharpt implements Serializable {
    private static final long serialVersionUID = 1L;

	
	@ApiModelProperty(value = "主键")
	private Long id;
	
	@ApiModelProperty(value = "标题")
	private String title;
	
	@ApiModelProperty(value = "介绍")
	private String introduce;
	
	@ApiModelProperty(value = "图片")
	private String pic;
	
	@ApiModelProperty(value = "创作要求")
	private String requirement;
	
	@ApiModelProperty(value = "类型")
	private String chapType;
	
	@ApiModelProperty(value = "标签")
	private String label;
	
	@ApiModelProperty(value = "创作人员数")
	private Integer creators;
	
	@ApiModelProperty(value = "章")
	private Integer root;
	
	@ApiModelProperty(value = "主编号")
	private Long rootId;
	
	@ApiModelProperty(value = "作品编号")
	private String bookId;
	
	@ApiModelProperty(value = "关联绘画编号")
	private Long paintId;
	
	@ApiModelProperty(value = "关联诗歌编号")
	private Long poemId;
	
	@ApiModelProperty(value = "主序号")
	private Integer rootOrd;
	
	@ApiModelProperty(value = "序号")
	private Integer ord;
	
	@ApiModelProperty(value = "上锁")
	private Integer isLock;
	
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
	private Integer number;
	
	@JsonProperty("id")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id =  id;
	}
	@JsonProperty("title")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title =  title;
	}
	@JsonProperty("introduce")
	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce =  introduce;
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
	@JsonProperty("chapType")
	public String getChapType() {
		return chapType;
	}

	public void setChapType(String chapType) {
		this.chapType =  chapType;
	}
	@JsonProperty("label")
	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label =  label;
	}
	@JsonProperty("creators")
	public Integer getCreators() {
		return creators;
	}

	public void setCreators(Integer creators) {
		this.creators =  creators;
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
	@JsonProperty("bookId")
	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId =  bookId;
	}
	@JsonProperty("paintId")
	public Long getPaintId() {
		return paintId;
	}

	public void setPaintId(Long paintId) {
		this.paintId =  paintId;
	}
	@JsonProperty("poemId")
	public Long getPoemId() {
		return poemId;
	}

	public void setPoemId(Long poemId) {
		this.poemId =  poemId;
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
	@JsonProperty("isLock")
	public Integer getIsLock() {
		return isLock;
	}

	public void setIsLock(Integer isLock) {
		this.isLock =  isLock;
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
	@JsonProperty("number")
	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number =  number;
	}

	public ProCharpt(Long id) {
		this.id = id;
	}
	public ProCharpt(Long id,String title,String introduce,String pic,String requirement,String chapType,String label,Integer creators,Integer root,Long rootId,String bookId,Long paintId,Long poemId,Integer rootOrd,Integer ord,Integer isLock,Integer finish,String createBy,Date createDat,Date lUpdateDat,Integer isDel,Integer number) {
				
		this.id = id;
				
		this.title = title;
				
		this.introduce = introduce;
				
		this.pic = pic;
				
		this.requirement = requirement;
				
		this.chapType = chapType;
				
		this.label = label;
				
		this.creators = creators;
				
		this.root = root;
				
		this.rootId = rootId;
				
		this.bookId = bookId;
				
		this.paintId = paintId;
				
		this.poemId = poemId;
				
		this.rootOrd = rootOrd;
				
		this.ord = ord;
				
		this.isLock = isLock;
				
		this.finish = finish;
				
		this.createBy = createBy;
				
		this.createDat = createDat;
				
		this.lUpdateDat = lUpdateDat;
				
		this.isDel = isDel;
				
		this.number = number;
				
	}

	public ProCharpt() {
	    super();
	}

	public String dateToStringConvert(Date date) {
		if(date!=null) {
			return DateUtil.format(date, "yyyy-MM-dd HH:mm:ss");
		}
		return "";
	}
	

}