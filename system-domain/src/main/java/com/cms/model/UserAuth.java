package com.cms.model;

import java.io.Serializable;

public class UserAuth implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private Long userId;
	private Integer systemId;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Integer getSystemId() {
		return systemId;
	}
	public void setSystemId(Integer systemId) {
		this.systemId = systemId;
	}
	
	
}
