package com.cms.model.manager;

import java.io.Serializable;

public class accountBean implements Serializable{
	/**
	 * 
	 */
    private static final long serialVersionUID = 1L;
	private String id;
	private int accountType;
	private String registerDate;
	private String serverBeginDate;
	private String serverEndDate;
	private int accountGrade;
	private int addType;
	private int identifyType;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getAccountType() {
		return accountType;
	}
	public void setAccountType(int accountType) {
		this.accountType = accountType;
	}
	public String getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}
	public String getServerBeginDate() {
		return serverBeginDate;
	}
	public void setServerBeginDate(String serverBeginDate) {
		this.serverBeginDate = serverBeginDate;
	}
	public String getServerEndDate() {
		return serverEndDate;
	}
	public void setServerEndDate(String serverEndDate) {
		this.serverEndDate = serverEndDate;
	}
	public int getAccountGrade() {
		return accountGrade;
	}
	public void setAccountGrade(int accountGrade) {
		this.accountGrade = accountGrade;
	}
	public int getAddType() {
		return addType;
	}
	public void setAddType(int addType) {
		this.addType = addType;
	}
	public int getIdentifyType() {
		return identifyType;
	}
	public void setIdentifyType(int identifyType) {
		this.identifyType = identifyType;
	}
	
}
