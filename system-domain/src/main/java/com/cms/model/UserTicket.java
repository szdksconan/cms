package com.cms.model;

import java.io.Serializable;
import java.sql.Date;

public class UserTicket implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String loginName;
	private String ticketValue;
	private Date createTime;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getTicketValue() {
		return ticketValue;
	}
	public void setTicketValue(String ticketValue) {
		this.ticketValue = ticketValue;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	
	
}
