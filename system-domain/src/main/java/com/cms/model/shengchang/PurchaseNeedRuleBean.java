package com.cms.model.shengchang;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class PurchaseNeedRuleBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1495358245541948899L;
	
	private String id;
	
	private String ruleId;
	
	private String createUser;
	
	private String createTime;
	
	private String needRuleName;
	
	private String needRuleApply;
	
	private String needRulePaytype;
	
	private String needRuleDesc;
	
	private List<PurchaseNeedRuleAreaBean> areaList;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRuleId() {
		return ruleId;
	}

	public void setRuleId(String ruleId) {
		this.ruleId = ruleId;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getNeedRuleName() {
		return needRuleName;
	}

	public void setNeedRuleName(String needRuleName) {
		this.needRuleName = needRuleName;
	}

	public String getNeedRuleApply() {
		return needRuleApply;
	}

	public void setNeedRuleApply(String needRuleApply) {
		this.needRuleApply = needRuleApply;
	}

	public String getNeedRulePaytype() {
		return needRulePaytype;
	}

	public void setNeedRulePaytype(String needRulePaytype) {
		this.needRulePaytype = needRulePaytype;
	}

	public String getNeedRuleDesc() {
		return needRuleDesc;
	}

	public void setNeedRuleDesc(String needRuleDesc) {
		this.needRuleDesc = needRuleDesc;
	}

	public List<PurchaseNeedRuleAreaBean> getAreaList() {
		return areaList;
	}

	public void setAreaList(List<PurchaseNeedRuleAreaBean> areaList) {
		this.areaList = areaList;
	}


	

}
