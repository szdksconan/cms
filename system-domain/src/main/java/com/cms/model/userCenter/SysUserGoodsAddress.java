package com.cms.model.userCenter;/******************************************************************************* * javaBeans * sys_user_goods_address --> SysUserGoodsAddress  * <table explanation> * @author 2016-02-15 13:47:17 *  */	public class SysUserGoodsAddress implements java.io.Serializable {	/**	 * 	 */	private static final long serialVersionUID = 1L;	//field	/** 主键 **/	private long id;	/** 外键，关联user表主键 **/	private long uid;	/** 联系人姓名 **/	private String username;	/** 地址-省 **/	private String addressProvince;	/** 地址-市 **/	private String addressCity;	/** 地址-县 **/	private String addressCounty;	/** 详细地址 **/	private String addressDetail;	/** 邮编 **/	private String postCode;	/** 手机 **/	private String phone;	/** 固话 **/	private String tel;	/** 1收货地址2发货地址 **/	private String type;	/** 是否默认地址1是0否 **/	private String isDefault;	//method	public long getId() {		return id;	}	public void setId(long id) {		this.id = id;	}	public long getUid() {		return uid;	}	public void setUid(long uid) {		this.uid = uid;	}	public String getUsername() {		return username;	}	public void setUsername(String username) {		this.username = username;	}	public String getAddressProvince() {		return addressProvince;	}	public void setAddressProvince(String addressProvince) {		this.addressProvince = addressProvince;	}	public String getAddressCity() {		return addressCity;	}	public void setAddressCity(String addressCity) {		this.addressCity = addressCity;	}	public String getAddressCounty() {		return addressCounty;	}	public void setAddressCounty(String addressCounty) {		this.addressCounty = addressCounty;	}	public String getAddressDetail() {		return addressDetail;	}	public void setAddressDetail(String addressDetail) {		this.addressDetail = addressDetail;	}	public String getPostCode() {		return postCode;	}	public void setPostCode(String postCode) {		this.postCode = postCode;	}	public String getPhone() {		return phone;	}	public void setPhone(String phone) {		this.phone = phone;	}	public String getTel() {		return tel;	}	public void setTel(String tel) {		this.tel = tel;	}	public String getType() {		return type;	}	public void setType(String type) {		this.type = type;	}	public String getIsDefault() {		return isDefault;	}	public void setIsDefault(String isDefault) {		this.isDefault = isDefault;	}	//override toString Method 	public String toString() {		StringBuffer sb=new StringBuffer();		sb.append("{");		sb.append("'id':'"+this.getId()+"',");		sb.append("'uid':'"+this.getUid()+"',");		sb.append("'username':'"+this.getUsername()+"',");		sb.append("'addressProvince':'"+this.getAddressProvince()+"',");		sb.append("'addressCity':'"+this.getAddressCity()+"',");		sb.append("'addressCounty':'"+this.getAddressCounty()+"',");		sb.append("'addressDetail':'"+this.getAddressDetail()+"',");		sb.append("'postCode':'"+this.getPostCode()+"',");		sb.append("'phone':'"+this.getPhone()+"',");		sb.append("'tel':'"+this.getTel()+"',");		sb.append("'type':'"+this.getType()+"',");		sb.append("'isDefault':'"+this.getIsDefault()+"'");		sb.append("}");		return sb.toString();	}}