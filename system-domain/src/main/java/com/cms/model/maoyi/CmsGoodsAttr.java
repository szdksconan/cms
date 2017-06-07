package com.cms.model.maoyi;

import java.io.Serializable;

public class CmsGoodsAttr implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String goodsId;//spu id
	private String productId;//sku id
	private String attrId;//属性id
	private String attrNameCn;//属性名
	private String valId;//属性值id
	private String valNameCn;//属性值名
	
	public CmsGoodsAttr() {
		super();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getAttrId() {
		return attrId;
	}
	public void setAttrId(String attrId) {
		this.attrId = attrId;
	}
	public String getAttrNameCn() {
		return attrNameCn;
	}
	public void setAttrNameCn(String attrNameCn) {
		this.attrNameCn = attrNameCn;
	}
	public String getValId() {
		return valId;
	}
	public void setValId(String valId) {
		this.valId = valId;
	}
	public String getValNameCn() {
		return valNameCn;
	}
	public void setValNameCn(String valNameCn) {
		this.valNameCn = valNameCn;
	}
	

}
