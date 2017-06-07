package com.cms.model.elasticsearch.cm;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class CmsProduceEs implements Serializable {

    private static final long serialVersionUID = 1L;
	/** 商品主键ID **/
	private String productId;
	/** 貿易商ID **/
	private String enterpriceId;
	private String enterpriceName;//贸易商名称
	private String oemId;//生产厂家id
	private String oemName;//生产厂家
	/** 货品ID **/
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
	private Double productPrice;
	/** 产品销量 **/
	private Double productSales;
	/** 产品状态 **/
	private Integer productStatus;
	/** 产品缩略图 **/
	private String productMainImg;
	/** 产品发布时间 **/
	private String productReleaseTime;
	/** 产品创建时间 **/
	private String productCreateTime;
	/** 产品发布者 **/
	private String productPromulgator;
	/** 产品创建者 **/
	private String productCreator;
	/** 产品明细 **/
	private String productDetail;
	/** 产品包装大小 **/
	private String productPackageSize;
	/** 产品毛重 **/
	private Double productGW;
	/** 产品条码 **/
	private String productBarCode;
	/** 产品总库存 **/
	private Double productTotalStock;
    private String stockAddress;//库存所在地
    private String unit;//产品数量单位
    private String recordState;//记录数据本身的状态(0已发布,1下架,2删除)
    private String listedTime;//上市时间
    private EnterpriseInfoEs enterpriseinfo; //贸易商信息
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
	public Double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}
	public Double getProductSales() {
		return productSales;
	}
	public void setProductSales(Double productSales) {
		this.productSales = productSales;
	}
	public Integer getProductStatus() {
		return productStatus;
	}
	public void setProductStatus(Integer productStatus) {
		this.productStatus = productStatus;
	}
	public String getProductMainImg() {
		return productMainImg;
	}
	public void setProductMainImg(String productMainImg) {
		this.productMainImg = productMainImg;
	}
	public String getProductReleaseTime() {
		return productReleaseTime;
	}
	public void setProductReleaseTime(String productReleaseTime) {
		this.productReleaseTime = productReleaseTime;
	}
	public String getProductCreateTime() {
		return productCreateTime;
	}
	public void setProductCreateTime(String productCreateTime) {
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
	public Double getProductGW() {
		return productGW;
	}
	public void setProductGW(Double productGW) {
		this.productGW = productGW;
	}
	public String getProductBarCode() {
		return productBarCode;
	}
	public void setProductBarCode(String productBarCode) {
		this.productBarCode = productBarCode;
	}
	public Double getProductTotalStock() {
		return productTotalStock;
	}
	public void setProductTotalStock(Double productTotalStock) {
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
	public String getListedTime() {
		return listedTime;
	}
	public void setListedTime(String listedTime) {
		this.listedTime = listedTime;
	}
	public EnterpriseInfoEs getEnterpriseinfo() {
		return enterpriseinfo;
	}
	public void setEnterpriseinfo(EnterpriseInfoEs enterpriseinfo) {
		this.enterpriseinfo = enterpriseinfo;
	}
	    
    
}
