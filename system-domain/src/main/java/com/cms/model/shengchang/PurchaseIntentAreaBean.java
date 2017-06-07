package com.cms.model.shengchang;

import java.io.Serializable;

/**
 * Created by liuxin on 2016/5/13.
 */
public class PurchaseIntentAreaBean implements Serializable{
    private static final long serialVersionUID = 1L;

    private String id;
    private String purchaseIntentId;//意向id
    private String provinceId;
    private String cityId;
    private String areaId;
    private String provinceName;
    private String cityName;
    private String areaName;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getPurchaseIntentId() {
        return purchaseIntentId;
    }
    public void setPurchaseIntentId(String purchaseIntentId) {
        this.purchaseIntentId = purchaseIntentId;
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
}
