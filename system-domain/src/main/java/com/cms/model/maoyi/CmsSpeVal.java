/**
 * @Title: CmsSpeVal.java
 * @Copyright (C) 2016 产贸送网络
 * @Description:
 * @Revision History:
 * @Revision 1.0 2016年4月28日  余波
 */

package com.cms.model.maoyi;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @ClassName: CmsSpeVal
 * @Description: Description of this class
 * @author <a href="stevenyubo@163.com">余波</a>于 2016年4月28日 下午1:09:43
 */

public class CmsSpeVal implements Serializable {

	/**
	 * @Fields serialVersionUID : Description
	 */

	private static final long serialVersionUID = -7826207838058612773L;

	private int id;
	private String speVal;
	private Date speCreateTime;
	private int speCreator;
	private CmsSpe spe;
	private List<CmsProduct> products;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSpeVal() {
		return speVal;
	}

	public void setSpeVal(String speVal) {
		this.speVal = speVal;
	}

	public Date getSpeCreateTime() {
		return speCreateTime;
	}

	public void setSpeCreateTime(Date speCreateTime) {
		this.speCreateTime = speCreateTime;
	}

	public int getSpeCreator() {
		return speCreator;
	}

	public void setSpeCreator(int speCreator) {
		this.speCreator = speCreator;
	}

	public CmsSpe getSpe() {
		return spe;
	}

	public void setSpe(CmsSpe spe) {
		this.spe = spe;
	}

	public List<CmsProduct> getProducts() {
		return products;
	}

	public void setProducts(List<CmsProduct> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "CmsSpeVal [id=" + id + ", speVal=" + speVal + ", speCreateTime=" + speCreateTime + ", speCreator="
				+ speCreator + ", spe=" + spe + ", products=" + products + "]";
	}

}
