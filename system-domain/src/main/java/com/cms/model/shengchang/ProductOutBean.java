package com.cms.model.shengchang;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 产品
 * @author weitianyu
 *
 */

public class ProductOutBean implements Serializable{

	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 1L;
	
	private String productId;
	
	private String productName; //产品名称
	
	private String productCode;//产品编码
	
	private String productModelSize; //尺寸规格？
	
	private String productPrice;//销售价格
	
	private String  listedTime;//上市时间

	private List<DocOutBean> docList; //产品附件
	
	private List<ParamOutBean> paraList; //产品规格参数
	
	private String industryName;
	
	private String kucun;

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductModelSize() {
		return productModelSize;
	}

	public void setProductModelSize(String productModelSize) {
		this.productModelSize = productModelSize;
	}

	public String getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}

	

	public String getListedTime() {
		return listedTime;
	}

	public void setListedTime(String listedTime) {
		this.listedTime = listedTime;
	}

	public List<DocOutBean> getDocList() {
		return docList;
	}

	public void setDocList(List<DocOutBean> docList) {
		this.docList = docList;
	}

	public List<ParamOutBean> getParaList() {
		return paraList;
	}

	public void setParaList(List<ParamOutBean> paraList) {
		this.paraList = paraList;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getIndustryName() {
		return industryName;
	}

	public void setIndustryName(String industryName) {
		this.industryName = industryName;
	}

	public String getKucun() {
		return kucun;
	}

	public void setKucun(String kucun) {
		this.kucun = kucun;
	}

	
	
	

}
