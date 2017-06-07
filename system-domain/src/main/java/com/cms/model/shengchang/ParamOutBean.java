package com.cms.model.shengchang;

import java.io.Serializable;

/**
 * 产品属性
 * @author weitianyu
 *
 */
public class ParamOutBean implements Serializable{

	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 246796402462090293L;
	

	
	private String parameterName; //属性名
	
	private String parameterValue; //属性值

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
	
	
	
	
}
