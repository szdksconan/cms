package com.cms.model.shengchang;

import java.io.Serializable;
import java.util.Date;

/**
 * 产品属性
 * @author weitianyu
 *
 */
public class ParamBean implements Serializable{

	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 246796402462090293L;
	
	private Long id;
	
	private Long productId; //产品ID
	
	private String parameterName; //属性名
	
	private String parameterValue; //属性值
	
	private Date createTime; //生成时间

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getParameterName() {
		return parameterName;
	}

	public void setParameterName(String parameterName) {
		this.parameterName = parameterName;
	}

	public String getParameterValue() {
		return parameterValue;
	}

	public void setParameterValue(String parameterValue) {
		this.parameterValue = parameterValue;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	
}
