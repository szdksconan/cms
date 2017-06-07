package com.cms.model.shengchang;

import java.io.Serializable;

/**
 * 产品销售规则适用地区
 * @author liuxin
 *
 */

public class ProductSellRuleAreaBean implements Serializable{

	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 1L;
	private String id; //id
    private String productSellRuleId;//销售规则id
    private String provinceId;//省份id
    private String provinceName;
    private String cityId;//城市id
    private String cityName;
    private String areaId;//区域id
    private String areaName;
    private String companyId;//

    public String getCompanyId() {
        return companyId;
    }
    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }
    public String getProvinceName() {
        return provinceName;
    }
    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }
    public String getCityName() {
        return cityName;
    }
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
    public String getAreaName() {
        return areaName;
    }
    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getProductSellRuleId() {
        return productSellRuleId;
    }
    public void setProductSellRuleId(String productSellRuleId) {
        this.productSellRuleId = productSellRuleId;
    }
    public String getProvinceId() {
        return provinceId;
    }
    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId;
    }
    public String getCityId() {
        return cityId;
    }
    public void setCityId(String cityId) {
        this.cityId = cityId;
    }
    public String getAreaId() {
        return areaId;
    }
    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }
}
