package com.cms.model.shengchang;

import java.io.Serializable;
import java.util.Date;

public class PurchaseNeedBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6458894301104829939L;
	
	private String id;
	private String purchaseNeedNo;
	private String purchaseNeedName;
	private String purchaseNeedState;
	private String purchaseNeedType;
	private String companyId;
	private String purchaseNeedLinkstate;
	private String orderStr;
	private String createUser;
	private String createTime;
   	private String needDetailJson;
   	private String needRuleJson;
   	private String needLinkJson;
   	private String purchaseRuleId;
   	private String createTimeByString;
   	private Date failTime;
	
	public String getPurchaseNeedNo() {
		return purchaseNeedNo;
	}
	public String getCreateTimeByString() {
		return createTimeByString;
	}
	public void setCreateTimeByString(String createTimeByString) {
		this.createTimeByString = createTimeByString;
	}
	public void setPurchaseNeedNo(String purchaseNeedNo) {
		this.purchaseNeedNo = purchaseNeedNo;
	}
	public String getPurchaseNeedName() {
		return purchaseNeedName;
	}
	public void setPurchaseNeedName(String purchaseNeedName) {
		this.purchaseNeedName = purchaseNeedName;
	}
	public String getPurchaseNeedState() {
		return purchaseNeedState;
	}
	public void setPurchaseNeedState(String purchaseNeedState) {
		this.purchaseNeedState = purchaseNeedState;
	}
	public String getPurchaseNeedType() {
		return purchaseNeedType;
	}
	public void setPurchaseNeedType(String purchaseNeedType) {
		this.purchaseNeedType = purchaseNeedType;
	}
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPurchaseNeedLinkstate() {
		return purchaseNeedLinkstate;
	}
	public void setPurchaseNeedLinkstate(String purchaseNeedLinkstate) {
		this.purchaseNeedLinkstate = purchaseNeedLinkstate;
	}
	public String getOrderStr() {
		return orderStr;
	}
	public void setOrderStr(String orderStr) {
		this.orderStr = orderStr;
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
	public String getNeedDetailJson() {
		return needDetailJson;
	}
	public void setNeedDetailJson(String needDetailJson) {
		this.needDetailJson = needDetailJson;
	}
	public String getNeedRuleJson() {
		return needRuleJson;
	}
	public void setNeedRuleJson(String needRuleJson) {
		this.needRuleJson = needRuleJson;
	}
	public String getNeedLinkJson() {
		return needLinkJson;
	}
	public void setNeedLinkJson(String needLinkJson) {
		this.needLinkJson = needLinkJson;
	}
	public String getPurchaseRuleId() {
		return purchaseRuleId;
	}
	public void setPurchaseRuleId(String purchaseRuleId) {
		this.purchaseRuleId = purchaseRuleId;
	}
	public Date getFailTime() {
		return failTime;
	}
	public void setFailTime(Date failTime) {
		this.failTime = failTime;
	}
	
	
	
}
