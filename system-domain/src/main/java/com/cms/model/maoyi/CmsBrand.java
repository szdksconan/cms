/**
 * @Title: Brand.java
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
 * @ClassName: Brand
 * @Description: Description of this class
 * @author <a href="stevenyubo@163.com">余波</a>于 2016年4月28日 上午11:24:47
 */

public class CmsBrand implements Serializable {

	/**
	 * @Fields serialVersionUID : Description
	 */

	private static final long serialVersionUID = 4618493189665681153L;

	private int id;
	private String brandCode;
	private int brandLogo;
	private String brandNameCn;
	private String brandNameEn;
	private Date brandCreateTime;
	private int brandCreator;
	private String brandIntroduction;
	private List<CmsProduct> products;

	public CmsBrand() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBrandCode() {
		return brandCode;
	}

	public void setBrandCode(String brandCode) {
		this.brandCode = brandCode;
	}

	public int getBrandLogo() {
		return brandLogo;
	}

	public void setBrandLogo(int brandLogo) {
		this.brandLogo = brandLogo;
	}

	public String getBrandNameCn() {
		return brandNameCn;
	}

	public void setBrandNameCn(String brandNameCn) {
		this.brandNameCn = brandNameCn;
	}

	public String getBrandNameEn() {
		return brandNameEn;
	}

	public void setBrandNameEn(String brandNameEn) {
		this.brandNameEn = brandNameEn;
	}

	public Date getBrandCreateTime() {
		return brandCreateTime;
	}

	public void setBrandCreateTime(Date brandCreateTime) {
		this.brandCreateTime = brandCreateTime;
	}

	public int getBrandCreator() {
		return brandCreator;
	}

	public void setBrandCreator(int brandCreator) {
		this.brandCreator = brandCreator;
	}

	public String getBrandIntroduction() {
		return brandIntroduction;
	}

	public void setBrandIntroduction(String brandIntroduction) {
		this.brandIntroduction = brandIntroduction;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<CmsProduct> getProducts() {
		return products;
	}

	public void setProducts(List<CmsProduct> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "CmsBrand [id=" + id + ", brandCode=" + brandCode + ", brandLogo=" + brandLogo + ", brandNameCn="
				+ brandNameCn + ", brandNameEn=" + brandNameEn + ", brandCreateTime=" + brandCreateTime
				+ ", brandCreator=" + brandCreator + ", brandIntroduction=" + brandIntroduction + ", products="
				+ products + "]";
	}

}
