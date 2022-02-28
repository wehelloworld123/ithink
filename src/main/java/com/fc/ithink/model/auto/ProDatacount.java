package com.fc.ithink.model.auto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

public class ProDatacount implements Serializable {
    private static final long serialVersionUID = 1L;

	
	@ApiModelProperty(value = "??")
	private String id;
	
	@ApiModelProperty(value = "??")
	private Integer dataCount;
	
	@ApiModelProperty(value = "??")
	private String dataType;
	
	@JsonProperty("id")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id =  id;
	}
	@JsonProperty("dataCount")
	public Integer getDataCount() {
		return dataCount;
	}

	public void setDataCount(Integer dataCount) {
		this.dataCount =  dataCount;
	}
	@JsonProperty("dataType")
	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType =  dataType;
	}

						
	public ProDatacount(String id,Integer dataCount,String dataType) {
				
		this.id = id;
				
		this.dataCount = dataCount;
				
		this.dataType = dataType;
				
	}

	public ProDatacount() {
	    super();
	}

	

}