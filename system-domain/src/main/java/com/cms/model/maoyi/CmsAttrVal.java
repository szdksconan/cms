/**
 * @Title: CmsAttrVal.java
 * @Copyright (C) 2016 产贸送网络
 * @Description:
 * @Revision History:
 * @Revision 1.0 2016年4月28日  余波
 */

package com.cms.model.maoyi;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


public class CmsAttrVal implements Serializable {

	/**
	 * @Fields serialVersionUID : Description
	 */

	private static final long serialVersionUID = -7600057640299891560L;

	private String id;
	private String attrKeyId;
	private String attrValueCn;
	private String attrValueEn;
	private String attrValueCreator;
	private Date attrValueCreateTime;
	private CmsAttr attr;
	private String productId;
	private List<CmsProduct> products;

	public CmsAttrVal() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAttrKeyId() {
		return attrKeyId;
	}

	public void setAttrKeyId(String attrKeyId) {
		this.attrKeyId = attrKeyId;
	}

	public String getAttrValueCn() {
		return attrValueCn;
	}

	public void setAttrValueCn(String attrValueCn) {
		this.attrValueCn = attrValueCn;
	}

	public String getAttrValueEn() {
		return attrValueEn;
	}

	public void setAttrValueEn(String attrValueEn) {
		this.attrValueEn = attrValueEn;
	}

	public String getAttrValueCreator() {
		return attrValueCreator;
	}

	public void setAttrValueCreator(String attrValueCreator) {
		this.attrValueCreator = attrValueCreator;
	}

	public Date getAttrValueCreateTime() {
		return attrValueCreateTime;
	}

	public void setAttrValueCreateTime(Date attrValueCreateTime) {
		this.attrValueCreateTime = attrValueCreateTime;
	}

	public CmsAttr getAttr() {
		return attr;
	}

	public void setAttr(CmsAttr attr) {
		this.attr = attr;
	}

	public List<CmsProduct> getProducts() {
		return products;
	}

	public void setProducts(List<CmsProduct> products) {
		this.products = products;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}


}
