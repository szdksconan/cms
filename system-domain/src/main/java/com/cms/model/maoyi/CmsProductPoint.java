/**
 * @Title: CmsGoods.java
 * @Copyright (C) 2016 产贸送网络
 * @Description:
 * @Revision History:
 * @Revision 1.0 2016年4月28日  余波
 */

package com.cms.model.maoyi;

import java.io.Serializable;

public class CmsProductPoint implements Serializable {

	/**
	 * @Fields serialVersionUID : Description
	 */

	private static final long serialVersionUID = 1L;
	private String id;
	private String productId;//产品id
	private String entId;//贸易商id
	private String pointId;//仓库id
	private String pointName;//仓库名称
	private Integer total;//产品库存
	private CmsProduct cmsProduct;
	private CmsPrice cmsPrice;//价格
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getEntId() {
		return entId;
	}
	public void setEntId(String entId) {
		this.entId = entId;
	}
	public String getPointId() {
		return pointId;
	}
	public void setPointId(String pointId) {
		this.pointId = pointId;
	}
	public String getPointName() {
		return pointName;
	}
	public void setPointName(String pointName) {
		this.pointName = pointName;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public CmsProduct getCmsProduct() {
		return cmsProduct;
	}
	public void setCmsProduct(CmsProduct cmsProduct) {
		this.cmsProduct = cmsProduct;
	}
	public CmsPrice getCmsPrice() {
		return cmsPrice;
	}
	public void setCmsPrice(CmsPrice cmsPrice) {
		this.cmsPrice = cmsPrice;
	}

}
