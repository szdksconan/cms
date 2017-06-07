package com.cms.model.manager;

import java.io.Serializable;

public class loginUserBean implements Serializable{
	/**
	 * 
	 */
    private static final long serialVersionUID = 1L;
	private String id;
	private String loginPwd;
	private String payPwd;
	private int canConsume;
	private String checkDate;
	private String registerDate;
	private int upateFlag;
	private String userCreater;
	private String sysCreater;
	private int status;
	private String remark;
	private String name;
	private int sex;
	private String tel1;
	private String tel2;
	private String oldloginPwd;
	private String newloginPwd;
	private String oldpayPwd;
	private String newpayPwd;
	
	public String getTel1() {
		return tel1;
	}
	public void setTel1(String tel1) {
		this.tel1 = tel1;
	}
	public String getTel2() {
		return tel2;
	}
	public void setTel2(String tel2) {
		this.tel2 = tel2;
	}
	public String getOldloginPwd() {
		return oldloginPwd;
	}
	public void setOldloginPwd(String oldloginPwd) {
		this.oldloginPwd = oldloginPwd;
	}
	public String getNewloginPwd() {
		return newloginPwd;
	}
	public void setNewloginPwd(String newloginPwd) {
		this.newloginPwd = newloginPwd;
	}
	public String getOldpayPwd() {
		return oldpayPwd;
	}
	public void setOldpayPwd(String oldpayPwd) {
		this.oldpayPwd = oldpayPwd;
	}
	public String getNewpayPwd() {
		return newpayPwd;
	}
	public void setNewpayPwd(String newpayPwd) {
		this.newpayPwd = newpayPwd;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLoginPwd() {
		return loginPwd;
	}
	public void setLoginPwd(String loginPwd) {
		this.loginPwd = loginPwd;
	}
	public String getPayPwd() {
		return payPwd;
	}
	public void setPayPwd(String payPwd) {
		this.payPwd = payPwd;
	}
	public int getCanConsume() {
		return canConsume;
	}
	public void setCanConsume(int canConsume) {
		this.canConsume = canConsume;
	}
	public String getCheckDate() {
		return checkDate;
	}
	public void setCheckDate(String checkDate) {
		this.checkDate = checkDate;
	}
	public String getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}
	public int getUpateFlag() {
		return upateFlag;
	}
	public void setUpateFlag(int upateFlag) {
		this.upateFlag = upateFlag;
	}
	public String getUserCreater() {
		return userCreater;
	}
	public void setUserCreater(String userCreater) {
		this.userCreater = userCreater;
	}
	public String getSysCreater() {
		return sysCreater;
	}
	public void setSysCreater(String sysCreater) {
		this.sysCreater = sysCreater;
	}
}
