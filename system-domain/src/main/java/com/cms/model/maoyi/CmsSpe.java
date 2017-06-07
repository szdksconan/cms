/**
 * @Title: CmsSpe.java
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
 * @ClassName: CmsSpe
 * @Description: Description of this class
 * @author <a href="stevenyubo@163.com">余波</a>于 2016年4月28日 上午11:27:54
 */

public class CmsSpe implements Serializable {

	/**
	 * @Fields serialVersionUID : Description
	 */

	private static final long serialVersionUID = -6482070196336135629L;

	private int id;
	private String speNameCn;
	private String speNameEn;
	private int speCreator;
	private Date speCreateTime;
	private CmsGoods goods;
	private List<CmsSpeVal> speVals;

	public CmsSpe() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSpeNameCn() {
		return speNameCn;
	}

	public void setSpeNameCn(String speNameCn) {
		this.speNameCn = speNameCn;
	}

	public String getSpeNameEn() {
		return speNameEn;
	}

	public void setSpeNameEn(String speNameEn) {
		this.speNameEn = speNameEn;
	}

	public int getSpeCreator() {
		return speCreator;
	}

	public void setSpeCreator(int speCreator) {
		this.speCreator = speCreator;
	}

	public Date getSpeCreateTime() {
		return speCreateTime;
	}

	public void setSpeCreateTime(Date speCreateTime) {
		this.speCreateTime = speCreateTime;
	}

	public CmsGoods getGoods() {
		return goods;
	}

	public void setGoods(CmsGoods goods) {
		this.goods = goods;
	}

	public List<CmsSpeVal> getSpeVals() {
		return speVals;
	}

	public void setSpeVals(List<CmsSpeVal> speVals) {
		this.speVals = speVals;
	}

	@Override
	public String toString() {
		return "CmsSpe [id=" + id + ", speNameCn=" + speNameCn + ", speNameEn=" + speNameEn + ", speCreator="
				+ speCreator + ", speCreateTime=" + speCreateTime + ", goods=" + goods + ", speVals=" + speVals + "]";
	}

}
