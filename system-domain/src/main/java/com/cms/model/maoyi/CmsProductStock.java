/**
 * @Title: CmsProductStock.java
 * @Copyright (C) 2016 产贸送网络
 * @Description:
 * @Revision History:
 * @Revision 1.0 2016年4月28日  余波
 */

package com.cms.model.maoyi;

import java.io.Serializable;

/**
 * @ClassName: CmsProductStock
 * @Description: Description of this class
 * @author <a href="stevenyubo@163.com">余波</a>于 2016年4月28日 下午2:56:52
 */

public class CmsProductStock implements Serializable {

	/**
	 * @Fields serialVersionUID : Description
	 */

	private static final long serialVersionUID = 807989457082665000L;

	private int id;
	private CmsProduct product;
	private int productSpeValId;
	private int stockNum;
	private int productAddId;
	private int productPrice;

	public CmsProductStock() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public CmsProduct getProduct() {
		return product;
	}

	public void setProduct(CmsProduct product) {
		this.product = product;
	}

	public int getProductSpeValId() {
		return productSpeValId;
	}

	public void setProductSpeValId(int productSpeValId) {
		this.productSpeValId = productSpeValId;
	}

	public int getStockNum() {
		return stockNum;
	}

	public void setStockNum(int stockNum) {
		this.stockNum = stockNum;
	}

	public int getProductAddId() {
		return productAddId;
	}

	public void setProductAddId(int productAddId) {
		this.productAddId = productAddId;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	@Override
	public String toString() {
		return "CmsProductStock [id=" + id + ", product=" + product + ", productSpeValId=" + productSpeValId
				+ ", stockNum=" + stockNum + ", productAddId=" + productAddId + ", productPrice=" + productPrice + "]";
	}

}
