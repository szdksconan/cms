package com.cms.model.shengchang;

import java.io.Serializable;

public class PurchaseNeedLinkman implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3448260923124043198L;
	
	  
	  private String id;
	
	  private String needLinkmanName;
	  
	  private String needLinkmanPhone;
	  
	  private String needLinkmanFax;
	  
	  private String needLinkmanEmail;
	  
	  private String pid;
	  
	  private String purchaseNeedId;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNeedLinkmanName() {
		return needLinkmanName;
	}

	public void setNeedLinkmanName(String needLinkmanName) {
		this.needLinkmanName = needLinkmanName;
	}

	public String getNeedLinkmanPhone() {
		return needLinkmanPhone;
	}

	public void setNeedLinkmanPhone(String needLinkmanPhone) {
		this.needLinkmanPhone = needLinkmanPhone;
	}

	public String getNeedLinkmanFax() {
		return needLinkmanFax;
	}

	public void setNeedLinkmanFax(String needLinkmanFax) {
		this.needLinkmanFax = needLinkmanFax;
	}

	public String getNeedLinkmanEmail() {
		return needLinkmanEmail;
	}

	public void setNeedLinkmanEmail(String needLinkmanEmail) {
		this.needLinkmanEmail = needLinkmanEmail;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getPurchaseNeedId() {
		return purchaseNeedId;
	}

	public void setPurchaseNeedId(String purchaseNeedId) {
		this.purchaseNeedId = purchaseNeedId;
	}
	  
	  

}
