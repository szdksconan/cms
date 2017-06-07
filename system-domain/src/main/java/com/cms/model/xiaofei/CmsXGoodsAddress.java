package com.cms.model.xiaofei;/******************************************************************************* * javaBeans * cms_x_goods_address --> CmsXGoodsAddress  * <table explanation> * @author 2016-05-25 17:17:49 *  */	public class CmsXGoodsAddress implements java.io.Serializable {	/**	 * 	 */	private static final long serialVersionUID = 1L;	//field	/** 主键ID **/	private String addrId;	/** 用户ID **/	private String userId;	/** 用户名 **/	private String userName;	/** 联系人姓名 **/	private String contactName;	/** 地址-省 **/	private String addressProvince;	/** 地址-市 **/	private String addressCity;	/** 地址-县/区 **/	private String addressCounty;	/** 详细地址 **/	private String addressDetail;	/** 邮编 **/	private String postCode;	/** 联系电话 **/	private String aPhone;	/** 状态：0-不默认/1-默认 **/	private int aStates;	/** 添加时间 **/	private String addTime;	//method	public String getAddrId() {		return addrId;	}	public void setAddrId(String addrId) {		this.addrId = addrId;	}	public String getUserId() {		return userId;	}	public void setUserId(String userId) {		this.userId = userId;	}	public String getUserName() {		return userName;	}	public void setUserName(String userName) {		this.userName = userName;	}	public String getContactName() {		return contactName;	}	public void setContactName(String contactName) {		this.contactName = contactName;	}	public String getAddressProvince() {		return addressProvince;	}	public void setAddressProvince(String addressProvince) {		this.addressProvince = addressProvince;	}	public String getAddressCity() {		return addressCity;	}	public void setAddressCity(String addressCity) {		this.addressCity = addressCity;	}	public String getAddressCounty() {		return addressCounty;	}	public void setAddressCounty(String addressCounty) {		this.addressCounty = addressCounty;	}	public String getAddressDetail() {		return addressDetail;	}	public void setAddressDetail(String addressDetail) {		this.addressDetail = addressDetail;	}	public String getPostCode() {		return postCode;	}	public void setPostCode(String postCode) {		this.postCode = postCode;	}	public String getAPhone() {		return aPhone;	}	public void setAPhone(String aPhone) {		this.aPhone = aPhone;	}	public int getAStates() {		return aStates;	}	public void setAStates(int aStates) {		this.aStates = aStates;	}	public String getAddTime() {		return addTime;	}	public void setAddTime(String addTime) {		this.addTime = addTime;	}	//override toString Method 	public String toString() {		StringBuffer sb=new StringBuffer();		sb.append("{");		sb.append("'addrId':'"+this.getAddrId()+"',");		sb.append("'userId':'"+this.getUserId()+"',");		sb.append("'userName':'"+this.getUserName()+"',");		sb.append("'contactName':'"+this.getContactName()+"',");		sb.append("'addressProvince':'"+this.getAddressProvince()+"',");		sb.append("'addressCity':'"+this.getAddressCity()+"',");		sb.append("'addressCounty':'"+this.getAddressCounty()+"',");		sb.append("'addressDetail':'"+this.getAddressDetail()+"',");		sb.append("'postCode':'"+this.getPostCode()+"',");		sb.append("'aPhone':'"+this.getAPhone()+"',");		sb.append("'aStates':'"+this.getAStates()+"',");		sb.append("'addTime':'"+this.getAddTime()+"'");		sb.append("}");		return sb.toString();	}}