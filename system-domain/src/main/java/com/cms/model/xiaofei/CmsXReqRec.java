package com.cms.model.xiaofei;import java.util.List;/******************************************************************************* * javaBeans * cms_x_req_rec --> CmsXReqRec  * <table explanation> * @author 2016-04-23 10:14:56 *  */	public class CmsXReqRec implements java.io.Serializable {	/**	 *	 */	private static final long serialVersionUID = 1L;	//field	/** ID **/	private String customId;	/** 需求标题 **/	private String reqTitle;	/** 行业类型代码 **/	private String busiCode;	/** 需求描述 **/	private String reqBrief;	/** 位置代码 **/	private String loclCode;	/** 用户ID **/	private String userId;	/** 真实姓名 **/	private String realName;	/** 联系电话 **/	private String tel;	/** 需求类型 **/	private String reqType;	/** 预算金额 **/	private String cash;	/** 是否有附件 **/	private String attYn;	/** 原料分类 **/	private String srcCode;	/** 发布时间 **/	private String opTime;	/** 浏览量 **/	private String viewNum;	/** 店铺地址-省 **/	private String hcity;	/** 店铺地址-市 **/	private String hproper;	/** 店铺地址-县 **/	private String harea;	//开店附件信息	private List<CmsXAttachment> attachments;		public List<CmsXAttachment> getAttachments() {		return attachments;	}	public void setAttachments(List<CmsXAttachment> attachments) {		this.attachments = attachments;	}	//method	public String getCustomId() {		return customId;	}	public void setCustomId(String customId) {		this.customId = customId;	}	public String getReqTitle() {		return reqTitle;	}	public void setReqTitle(String reqTitle) {		this.reqTitle = reqTitle;	}	public String getBusiCode() {		return busiCode;	}	public void setBusiCode(String busiCode) {		this.busiCode = busiCode;	}	public String getReqBrief() {		return reqBrief;	}	public void setReqBrief(String reqBrief) {		this.reqBrief = reqBrief;	}	public String getLoclCode() {		return loclCode;	}	public void setLoclCode(String loclCode) {		this.loclCode = loclCode;	}	public String getUserId() {		return userId;	}	public void setUserId(String userId) {		this.userId = userId;	}	public String getRealName() {		return realName;	}	public void setRealName(String realName) {		this.realName = realName;	}	public String getTel() {		return tel;	}	public void setTel(String tel) {		this.tel = tel;	}	public String getReqType() {		return reqType;	}	public void setReqType(String reqType) {		this.reqType = reqType;	}	public String getCash() {		return cash;	}	public void setCash(String cash) {		this.cash = cash;	}	public String getAttYn() {		return attYn;	}	public void setAttYn(String attYn) {		this.attYn = attYn;	}	public String getSrcCode() {		return srcCode;	}	public void setSrcCode(String srcCode) {		this.srcCode = srcCode;	}	public String getOpTime() {		return opTime;	}	public void setOpTime(String opTime) {		this.opTime = opTime;	}	public String getViewNum() {		return viewNum;	}	public void setViewNum(String viewNum) {		this.viewNum = viewNum;	}	public String getHcity() {		return hcity;	}	public void setHcity(String hcity) {		this.hcity = hcity;	}	public String getHproper() {		return hproper;	}	public void setHproper(String hproper) {		this.hproper = hproper;	}	public String getHarea() {		return harea;	}	public void setHarea(String harea) {		this.harea = harea;	}}