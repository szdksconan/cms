/**
 * @Title: CmsGoods.java
 * @Copyright (C) 2016 产贸送网络
 * @Description:
 * @Revision History:
 * @Revision 1.0 2016年4月28日  余波
 */

package com.cms.model.maoyi;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cms.model.shengchang.DocOutBean;
import com.cms.model.shengchang.ProductOutBean;
import com.cms.model.shengchang.ProductSellRuleOutBean;

public class CmsGoods implements Serializable {

	/**
	 * @Fields serialVersionUID : Description
	 */

	private static final long serialVersionUID = -7256583965534630163L;

	private String id;
	private String companyId;//公司ID
	private String companyName;//公司名称
	private String oemId;//生产厂家ID
	private String oemName;//生产厂家名称
	/** 分类ID **/
	private String kindId;
	private String kindName;//类别名称
	/** 品牌ID **/
	private String brandId;
	private String brandName;//品牌
	private String GoodsCode;
	private String GoodsNameCn;//主营产品名称
	private String GoodsNameEn;
	private String GoodsIntroduction;//主营产品介绍
	private int GoodPlace;//产地
	private int GoodsCreator;
	private Date GoodsCreateTime;
	
	private List<CmsImages> cmsImages;//产品附件：包括图片或者txt等。
	private List<CmsProduct> cmsProduct;//产品信息(sku list)
	private List<CmsGoodsAttr>   cmsGoodsAttr;//产品属性
	private List<CmsSellRule> cmsSellRule;//销售规则
	
	public CmsGoods() {
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCompanyId() {
		return companyId;
	}
	public String getOemId() {
		return oemId;
	}
	public void setOemId(String oemId) {
		this.oemId = oemId;
	}
	public String getOemName() {
		return oemName;
	}
	public void setOemName(String oemName) {
		this.oemName = oemName;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getKindId() {
		return kindId;
	}
	public void setKindId(String kindId) {
		this.kindId = kindId;
	}
	public String getKindName() {
		return kindName;
	}
	public void setKindName(String kindName) {
		this.kindName = kindName;
	}
	public String getBrandId() {
		return brandId;
	}
	public void setBrandId(String brandId) {
		this.brandId = brandId;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public String getGoodsCode() {
		return GoodsCode;
	}
	public void setGoodsCode(String goodsCode) {
		GoodsCode = goodsCode;
	}
	public String getGoodsNameCn() {
		return GoodsNameCn;
	}
	public void setGoodsNameCn(String goodsNameCn) {
		GoodsNameCn = goodsNameCn;
	}
	public String getGoodsNameEn() {
		return GoodsNameEn;
	}
	public void setGoodsNameEn(String goodsNameEn) {
		GoodsNameEn = goodsNameEn;
	}
	public String getGoodsIntroduction() {
		return GoodsIntroduction;
	}
	public void setGoodsIntroduction(String goodsIntroduction) {
		GoodsIntroduction = goodsIntroduction;
	}
	public int getGoodPlace() {
		return GoodPlace;
	}
	public void setGoodPlace(int goodPlace) {
		GoodPlace = goodPlace;
	}
	public int getGoodsCreator() {
		return GoodsCreator;
	}
	public void setGoodsCreator(int goodsCreator) {
		GoodsCreator = goodsCreator;
	}
	public Date getGoodsCreateTime() {
		return GoodsCreateTime;
	}
	public void setGoodsCreateTime(Date goodsCreateTime) {
		GoodsCreateTime = goodsCreateTime;
	}
	public List<CmsImages> getCmsImages() {
		return cmsImages;
	}
	public void setCmsImages(List<CmsImages> cmsImages) {
		this.cmsImages = cmsImages;
	}
	public List<CmsProduct> getCmsProduct() {
		return cmsProduct;
	}
	public void setCmsProduct(List<CmsProduct> cmsProduct) {
		this.cmsProduct = cmsProduct;
	}
	public List<CmsGoodsAttr> getCmsGoodsAttr() {
		return cmsGoodsAttr;
	}
	public void setCmsGoodsAttr(List<CmsGoodsAttr> cmsGoodsAttr) {
		this.cmsGoodsAttr = cmsGoodsAttr;
	}
	public List<CmsSellRule> getCmsSellRule() {
		return cmsSellRule;
	}
	public void setCmsSellRule(List<CmsSellRule> cmsSellRule) {
		this.cmsSellRule = cmsSellRule;
	}
}
