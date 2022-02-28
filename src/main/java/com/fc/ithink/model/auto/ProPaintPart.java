package com.fc.ithink.model.auto;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import cn.hutool.core.date.DateUtil;
import java.util.Date;

public class ProPaintPart implements Serializable {
    private static final long serialVersionUID = 1L;

	
	@ApiModelProperty(value = "主键")
	private Long id;
	
	@ApiModelProperty(value = "主题")
	private String subject;
	
	@ApiModelProperty(value = "章节介绍")
	private String introduce;
	
	@ApiModelProperty(value = "")
	private String pic;
	
	@ApiModelProperty(value = "创作要求")
	private String requirement;
	
	@ApiModelProperty(value = "类型")
	private String partType;
	
	@ApiModelProperty(value = "创作者")
	private Integer creators;
	
	@ApiModelProperty(value = "父节点")
	private Integer root;
	
	@ApiModelProperty(value = "分集编号")
	private Long rootId;
	
	@ApiModelProperty(value = "关联文章编号")
	private Long literId;
	
	@ApiModelProperty(value = "关联诗歌编号")
	private Long poemId;
	
	@ApiModelProperty(value = "数量")
	private Integer number;
	
	@ApiModelProperty(value = "主序号")
	private Integer rootOrd;
	
	@ApiModelProperty(value = "序号")
	private Integer ord;
	
	@ApiModelProperty(value = "画集编号")
	private String paintId;
	
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
	
	@JsonProperty("id")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id =  id;
	}
	@JsonProperty("subject")
	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject =  subject;
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
	@JsonProperty("partType")
	public String getPartType() {
		return partType;
	}

	public void setPartType(String partType) {
		this.partType =  partType;
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
	@JsonProperty("literId")
	public Long getLiterId() {
		return literId;
	}

	public void setLiterId(Long literId) {
		this.literId =  literId;
	}
	@JsonProperty("poemId")
	public Long getPoemId() {
		return poemId;
	}

	public void setPoemId(Long poemId) {
		this.poemId =  poemId;
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
	@JsonProperty("paintId")
	public String getPaintId() {
		return paintId;
	}

	public void setPaintId(String paintId) {
		this.paintId =  paintId;
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

																																										
	public ProPaintPart(Long id,String subject,String introduce,String pic,String requirement,String partType,Integer creators,Integer root,Long rootId,Long literId,Long poemId,Integer number,Integer rootOrd,Integer ord,String paintId,Integer finish,String createBy,Date createDat,Date lUpdateDat,Integer isDel,Integer isLock) {
				
		this.id = id;
				
		this.subject = subject;
				
		this.introduce = introduce;
				
		this.pic = pic;
				
		this.requirement = requirement;
				
		this.partType = partType;
				
		this.creators = creators;
				
		this.root = root;
				
		this.rootId = rootId;
				
		this.literId = literId;
				
		this.poemId = poemId;
				
		this.number = number;
				
		this.rootOrd = rootOrd;
				
		this.ord = ord;
				
		this.paintId = paintId;
				
		this.finish = finish;
				
		this.createBy = createBy;
				
		this.createDat = createDat;
				
		this.lUpdateDat = lUpdateDat;
				
		this.isDel = isDel;
				
		this.isLock = isLock;
				
	}

	public ProPaintPart() {
	    super();
	}

	public ProPaintPart(Long id) {

		this.id = id;
	}

	public String dateToStringConvert(Date date) {
		if(date!=null) {
			return DateUtil.format(date, "yyyy-MM-dd HH:mm:ss");
		}
		return "";
	}
	

}