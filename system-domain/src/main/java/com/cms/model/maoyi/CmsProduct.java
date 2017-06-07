/**
 * @Title: Product.java
 * @Copyright (C) 2016 产贸送网络
 * @Description:
 * @Revision History:
 * @Revision 1.0 2016年4月28日  余波
 */

package com.cms.model.maoyi;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 贸易商品中心商品bean
 * 
 * @author My
 *
 */
public class CmsProduct implements Serializable{

	private static final long serialVersionUID = 7317522870084262515L;
	/** 商品主键ID, sku id **/
	private String productId;
	/** 貿易商ID **/
	private String enterpriceId;
	private String enterpriceName;//贸易商名称
	private String oemId;//生产厂家id
	private String oemName;//生产厂家
	/** 货品ID spu id **/
	private String goodsId;	
	/** 分类ID **/
	private String kindId;
	private String kindName;//类别名称
	/** 品牌ID **/
	private String brandId;
	private String brandName;//品牌
	/** 产品编码 **/
	private String productCode;
	/** 产品中文名称 **/
	private String productNameCn;
	/** 产品英文名称 **/
	private String productNameEn;
	/** 产品产地 **/
	private String productPlace;
	/** 产品介绍 **/
	private String productIntroduction;
	/** 产品价格 **/
	private BigDecimal productPrice;
	/** 产品销量 **/
	private int productSales;
	/** 产品状态 **/
	private int productStatus;//产品状态;0:未发布（草稿）；1：上架；2：下架
	/** 产品点击量 **/
	private int productClicks;
	/** 产品主图 **/
	private String productMainImg;
	/** 产品发布时间 **/
	private Date productReleaseTime;
	/** 产品创建时间 **/
	private Date productCreateTime;
	/** 产品发布者 **/
	private String productPromulgator;
	/** 产品创建者 **/
	private String productCreator;
	/** 产品明细 **/
	private String productDetail;
	/** 产品包装大小 **/
	private String productPackageSize;
	/** 产品毛重 **/
	private int productGW;
	/** 产品条码 **/
	private String productBarCode;
	private int productTotalStock;//库存（废弃）
    private String stockAddress;//库存所在地（废弃）
    private String unit;//产品数量单位
    private String recordState;//记录数据本身的状态(0:删除;1正常)
    private Date listedTime;//上市时间
    private int comeFrom;//标记产品来源（1：生产厂家；2：贸易商自有）
    private int isFamousBrand;//名品 0：否；1：是
    
    private List<CmsProductPoint> cmsProductPoint;//产品仓库
    private List<CmsImages> cmsImages;//产品附件：包括图片或者txt等。
    private List<CmsAttrVal>   cmsAttrVal;//产品属性
    
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getEnterpriceId() {
		return enterpriceId;
	}
	public void setEnterpriceId(String enterpriceId) {
		this.enterpriceId = enterpriceId;
	}
	public String getEnterpriceName() {
		return enterpriceName;
	}
	public void setEnterpriceName(String enterpriceName) {
		this.enterpriceName = enterpriceName;
	}
	public String getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
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
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public String getProductNameCn() {
		return productNameCn;
	}
	public void setProductNameCn(String productNameCn) {
		this.productNameCn = productNameCn;
	}
	public String getProductNameEn() {
		return productNameEn;
	}
	public void setProductNameEn(String productNameEn) {
		this.productNameEn = productNameEn;
	}
	public String getProductPlace() {
		return productPlace;
	}
	public void setProductPlace(String productPlace) {
		this.productPlace = productPlace;
	}
	public String getProductIntroduction() {
		return productIntroduction;
	}
	public void setProductIntroduction(String productIntroduction) {
		this.productIntroduction = productIntroduction;
	}
	
	public BigDecimal getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(BigDecimal productPrice) {
		this.productPrice = productPrice;
	}
	public int getProductSales() {
		return productSales;
	}
	public void setProductSales(int productSales) {
		this.productSales = productSales;
	}
	public int getProductStatus() {
		return productStatus;
	}
	public void setProductStatus(int productStatus) {
		this.productStatus = productStatus;
	}
	public int getProductClicks() {
		return productClicks;
	}
	public void setProductClicks(int productClicks) {
		this.productClicks = productClicks;
	}
	public String getProductMainImg() {
		return productMainImg;
	}
	public void setProductMainImg(String productMainImg) {
		this.productMainImg = productMainImg;
	}
	public Date getProductReleaseTime() {
		return productReleaseTime;
	}
	public void setProductReleaseTime(Date productReleaseTime) {
		this.productReleaseTime = productReleaseTime;
	}
	public Date getProductCreateTime() {
		return productCreateTime;
	}
	public void setProductCreateTime(Date productCreateTime) {
		this.productCreateTime = productCreateTime;
	}
	public String getProductPromulgator() {
		return productPromulgator;
	}
	public void setProductPromulgator(String productPromulgator) {
		this.productPromulgator = productPromulgator;
	}
	public String getProductCreator() {
		return productCreator;
	}
	public void setProductCreator(String productCreator) {
		this.productCreator = productCreator;
	}
	public String getProductDetail() {
		return productDetail;
	}
	public void setProductDetail(String productDetail) {
		this.productDetail = productDetail;
	}
	public String getProductPackageSize() {
		return productPackageSize;
	}
	public void setProductPackageSize(String productPackageSize) {
		this.productPackageSize = productPackageSize;
	}
	public int getProductGW() {
		return productGW;
	}
	public void setProductGW(int productGW) {
		this.productGW = productGW;
	}
	public String getProductBarCode() {
		return productBarCode;
	}
	public void setProductBarCode(String productBarCode) {
		this.productBarCode = productBarCode;
	}
	public int getProductTotalStock() {
		return productTotalStock;
	}
	public void setProductTotalStock(int productTotalStock) {
		this.productTotalStock = productTotalStock;
	}
	public String getStockAddress() {
		return stockAddress;
	}
	public void setStockAddress(String stockAddress) {
		this.stockAddress = stockAddress;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getRecordState() {
		return recordState;
	}
	public void setRecordState(String recordState) {
		this.recordState = recordState;
	}
	
	public Date getListedTime() {
		return listedTime;
	}
	public void setListedTime(Date listedTime) {
		this.listedTime = listedTime;
	}
	public List<CmsImages> getCmsImages() {
		return cmsImages;
	}
	public void setCmsImages(List<CmsImages> cmsImages) {
		this.cmsImages = cmsImages;
	}
	public List<CmsAttrVal> getCmsAttrVal() {
		return cmsAttrVal;
	}
	public void setCmsAttrVal(List<CmsAttrVal> cmsAttrVal) {
		this.cmsAttrVal = cmsAttrVal;
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
	public List<CmsProductPoint> getCmsProductPoint() {
		return cmsProductPoint;
	}
	public void setCmsProductPoint(List<CmsProductPoint> cmsProductPoint) {
		this.cmsProductPoint = cmsProductPoint;
	}
	public int getComeFrom() {
		return comeFrom;
	}
	public void setComeFrom(int comeFrom) {
		this.comeFrom = comeFrom;
	}
	public int getIsFamousBrand() {
		return isFamousBrand;
	}
	public void setIsFamousBrand(int isFamousBrand) {
		this.isFamousBrand = isFamousBrand;
	}
	
}
