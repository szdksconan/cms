package com.cms.model.xiaofei.type;/******************************************************************************* * javaBeans * t_cms_base_product --> TCmsBaseProduct  * <table explanation> * @author 2016-04-29 09:46:10 *  */	public class TCmsBaseProduct implements java.io.Serializable {	/**	 *	 */	private static final long serialVersionUID = 1L;	//field	/**  **/	private String id;	/**  **/	private String code;	/**  **/	private String name;	/**  **/	private String superid;	/**  **/	private int level;	/**  **/	private String keywords;	/**  **/	private String spell;	/**  **/	private String status;	/**  **/	private String remark;		/*方便拿参数*/	//private String iftype;	//method	public String getId() {		return id;	}	public void setId(String id) {		this.id = id;	}	public String getCode() {		return code;	}	public void setCode(String code) {		this.code = code;	}	public String getName() {		return name;	}	public void setName(String name) {		this.name = name;	}	public String getSuperid() {		return superid;	}	public void setSuperid(String superid) {		this.superid = superid;	}	public int getLevel() {		return level;	}	public void setLevel(int level) {		this.level = level;	}	public String getKeywords() {		return keywords;	}	public void setKeywords(String keywords) {		this.keywords = keywords;	}	public String getSpell() {		return spell;	}	public void setSpell(String spell) {		this.spell = spell;	}	public String getStatus() {		return status;	}	public void setStatus(String status) {		this.status = status;	}	public String getRemark() {		return remark;	}	public void setRemark(String remark) {		this.remark = remark;	}}