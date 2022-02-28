package com.fc.ithink.model.auto;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import cn.hutool.core.date.DateUtil;
import java.util.Date;

public class DebTopic implements Serializable {
    private static final long serialVersionUID = 1L;

	
	@ApiModelProperty(value = "主键")
	private String uid;
	
	@ApiModelProperty(value = "专栏名")
	private String subject;
	
	@ApiModelProperty(value = "专栏id")
	private String subjectId;
	
	@ApiModelProperty(value = "立题")
	private String title;
	
	@ApiModelProperty(value = "内容")
	private String content;
	
	@ApiModelProperty(value = "标签1")
	private String label1;
	
	@ApiModelProperty(value = "标签2")
	private String label2;
	
	@ApiModelProperty(value = "标签3")
	private String label3;
	
	@ApiModelProperty(value = "思维度")
	private Integer thinking;
	
	@ApiModelProperty(value = "灵活性")
	private Integer flexibility;
	
	@ApiModelProperty(value = "逻辑性")
	private Integer logicality;
	
	@ApiModelProperty(value = "总难度")
	private Integer totalDiff;
	
	@ApiModelProperty(value = "关键字")
	private String keyword;
	
	@ApiModelProperty(value = "浏览量")
	private Integer views;
	
	@ApiModelProperty(value = "回答数")
	private Integer answers;
	
	@ApiModelProperty(value = "收录书架")
	private String belongNm;
	
	@ApiModelProperty(value = "书架Id")
	private String belongId;
	
	@ApiModelProperty(value = "最低喜欢数")
	private Integer minLike;
	
	@ApiModelProperty(value = "最低推荐数")
	private Integer minRecom;
	
	@ApiModelProperty(value = "已完成")
	private Integer finish;
	
	@ApiModelProperty(value = "期数")
	private Integer period;
	
	@ApiModelProperty(value = "年度")
	private String year;
	
	@ApiModelProperty(value = "状态")
	private Integer status;
	
	@ApiModelProperty(value = "创建人")
	private String createBy;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	@ApiModelProperty(value = "创建时间")
	private Date createDat;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	@ApiModelProperty(value = "最后更新时间")
	private Date lUpdateDat;
	
	@ApiModelProperty(value = "是否删除")
	private Integer isDel;
	
	@JsonProperty("uid")
	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid =  uid;
	}
	@JsonProperty("subject")
	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject =  subject;
	}
	@JsonProperty("subjectId")
	public String getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(String subjectId) {
		this.subjectId =  subjectId;
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
	@JsonProperty("label1")
	public String getLabel1() {
		return label1;
	}

	public void setLabel1(String label1) {
		this.label1 =  label1;
	}
	@JsonProperty("label2")
	public String getLabel2() {
		return label2;
	}

	public void setLabel2(String label2) {
		this.label2 =  label2;
	}
	@JsonProperty("label3")
	public String getLabel3() {
		return label3;
	}

	public void setLabel3(String label3) {
		this.label3 =  label3;
	}
	@JsonProperty("thinking")
	public Integer getThinking() {
		return thinking;
	}

	public void setThinking(Integer thinking) {
		this.thinking =  thinking;
	}
	@JsonProperty("flexibility")
	public Integer getFlexibility() {
		return flexibility;
	}

	public void setFlexibility(Integer flexibility) {
		this.flexibility =  flexibility;
	}
	@JsonProperty("logicality")
	public Integer getLogicality() {
		return logicality;
	}

	public void setLogicality(Integer logicality) {
		this.logicality =  logicality;
	}
	@JsonProperty("totalDiff")
	public Integer getTotalDiff() {
		return totalDiff;
	}

	public void setTotalDiff(Integer totalDiff) {
		this.totalDiff =  totalDiff;
	}
	@JsonProperty("keyword")
	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword =  keyword;
	}
	@JsonProperty("views")
	public Integer getViews() {
		return views;
	}

	public void setViews(Integer views) {
		this.views =  views;
	}
	@JsonProperty("answers")
	public Integer getAnswers() {
		return answers;
	}

	public void setAnswers(Integer answers) {
		this.answers =  answers;
	}
	@JsonProperty("belongNm")
	public String getBelongNm() {
		return belongNm;
	}

	public void setBelongNm(String belongNm) {
		this.belongNm =  belongNm;
	}
	@JsonProperty("belongId")
	public String getBelongId() {
		return belongId;
	}

	public void setBelongId(String belongId) {
		this.belongId =  belongId;
	}
	@JsonProperty("minLike")
	public Integer getMinLike() {
		return minLike;
	}

	public void setMinLike(Integer minLike) {
		this.minLike =  minLike;
	}
	@JsonProperty("minRecom")
	public Integer getMinRecom() {
		return minRecom;
	}

	public void setMinRecom(Integer minRecom) {
		this.minRecom =  minRecom;
	}
	@JsonProperty("finish")
	public Integer getFinish() {
		return finish;
	}

	public void setFinish(Integer finish) {
		this.finish =  finish;
	}
	@JsonProperty("period")
	public Integer getPeriod() {
		return period;
	}

	public void setPeriod(Integer period) {
		this.period =  period;
	}
	@JsonProperty("year")
	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year =  year;
	}
	@JsonProperty("status")
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status =  status;
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

																																																						
	public DebTopic(String uid,String subject,String subjectId,String title,String content,String label1,String label2,String label3,Integer thinking,Integer flexibility,Integer logicality,Integer totalDiff,String keyword,Integer views,Integer answers,String belongNm,String belongId,Integer minLike,Integer minRecom,Integer finish,Integer period,String year,Integer status,String createBy,Date createDat,Date lUpdateDat,Integer isDel) {
				
		this.uid = uid;
				
		this.subject = subject;
				
		this.subjectId = subjectId;
				
		this.title = title;
				
		this.content = content;
				
		this.label1 = label1;
				
		this.label2 = label2;
				
		this.label3 = label3;
				
		this.thinking = thinking;
				
		this.flexibility = flexibility;
				
		this.logicality = logicality;
				
		this.totalDiff = totalDiff;
				
		this.keyword = keyword;
				
		this.views = views;
				
		this.answers = answers;
				
		this.belongNm = belongNm;
				
		this.belongId = belongId;
				
		this.minLike = minLike;
				
		this.minRecom = minRecom;
				
		this.finish = finish;
				
		this.period = period;
				
		this.year = year;
				
		this.status = status;
				
		this.createBy = createBy;
				
		this.createDat = createDat;
				
		this.lUpdateDat = lUpdateDat;
				
		this.isDel = isDel;
				
	}

	public DebTopic() {
	    super();
	}

	public String dateToStringConvert(Date date) {
		if(date!=null) {
			return DateUtil.format(date, "yyyy-MM-dd HH:mm:ss");
		}
		return "";
	}
	

}