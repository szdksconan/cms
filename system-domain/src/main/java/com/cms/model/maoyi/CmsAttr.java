/**
 * @Title: CmsAttr.java
 * @Copyright (C) 2016 产贸送网络
 * @Description:
 * @Revision History:
 * @Revision 1.0 2016年4月28日  余波
 */

package com.cms.model.maoyi;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


public class CmsAttr implements Serializable {

	/**
	 * @Fields serialVersionUID : Description
	 */

	private static final long serialVersionUID = 5074540291485088398L;

	private String id;
	private String kindsId;
	private String attrNameCn;
	private String attrNameEn;
	private String attrCreator;
	private Date attrCreateTime;
	private List<CmsAttrVal> vals;

	public CmsAttr() {
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getKindsId() {
		return kindsId;
	}


	public void setKindsId(String kindsId) {
		this.kindsId = kindsId;
	}


	public String getAttrNameCn() {
		return attrNameCn;
	}


	public void setAttrNameCn(String attrNameCn) {
		this.attrNameCn = attrNameCn;
	}


	public String getAttrNameEn() {
		return attrNameEn;
	}


	public void setAttrNameEn(String attrNameEn) {
		this.attrNameEn = attrNameEn;
	}


	public String getAttrCreator() {
		return attrCreator;
	}


	public void setAttrCreator(String attrCreator) {
		this.attrCreator = attrCreator;
	}


	public Date getAttrCreateTime() {
		return attrCreateTime;
	}


	public void setAttrCreateTime(Date attrCreateTime) {
		this.attrCreateTime = attrCreateTime;
	}


	public List<CmsAttrVal> getVals() {
		return vals;
	}


	public void setVals(List<CmsAttrVal> vals) {
		this.vals = vals;
	}


	@Override
	public String toString() {
		return "CmsAttr [id=" + id + ", kindsId=" + kindsId + ", attrNameCn=" + attrNameCn + ", attrNameEn="
				+ attrNameEn + ", attrCreator=" + attrCreator + ", attrCreateTime=" + attrCreateTime + ", vals=" + vals
				+ "]";
	}

}
