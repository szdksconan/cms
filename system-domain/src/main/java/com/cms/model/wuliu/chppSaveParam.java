package com.cms.model.wuliu;

import java.io.Serializable;

/**
 * Created by 刘鑫 on 2016/3/3.
 */
public class chppSaveParam implements Serializable{
    private static final long serialVersionUID = 1L;
    private String type;
    private Integer provinceAreaId;
    private Integer beginProvinceId;
    private Integer beginAreaId;
    private Integer beginCityId;
    private Integer endProvinceId;
    private Integer endAreaId;
    private Integer endCityId;
    private String beginProvinceName;
    private String beginAreaName;
    private String beginCityName;
    private String endProvinceName;
    private String endAreaName;
    private String endCityName;
    private String carId;

    public String getCarId() {
        return carId;
    }
    public void setCarId(String carId) {
        this.carId = carId;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public Integer getProvinceAreaId() {
        return provinceAreaId;
    }
    public void setProvinceAreaId(Integer provinceAreaId) {
        this.provinceAreaId = provinceAreaId;
    }
    public Integer getBeginProvinceId() {
        return beginProvinceId;
    }
    public void setBeginProvinceId(Integer beginProvinceId) {
        this.beginProvinceId = beginProvinceId;
    }
    public Integer getBeginAreaId() {
        return beginAreaId;
    }
    public void setBeginAreaId(Integer beginAreaId) {
        this.beginAreaId = beginAreaId;
    }
    public Integer getBeginCityId() {
        return beginCityId;
    }
    public void setBeginCityId(Integer beginCityId) {
        this.beginCityId = beginCityId;
    }
    public Integer getEndProvinceId() {
        return endProvinceId;
    }
    public void setEndProvinceId(Integer endProvinceId) {
        this.endProvinceId = endProvinceId;
    }
    public Integer getEndAreaId() {
        return endAreaId;
    }
    public void setEndAreaId(Integer endAreaId) {
        this.endAreaId = endAreaId;
    }
    public Integer getEndCityId() {
        return endCityId;
    }
    public void setEndCityId(Integer endCityId) {
        this.endCityId = endCityId;
    }
    public String getBeginProvinceName() {
        return beginProvinceName;
    }
    public void setBeginProvinceName(String beginProvinceName) {
        this.beginProvinceName = beginProvinceName;
    }
    public String getBeginAreaName() {
        return beginAreaName;
    }
    public void setBeginAreaName(String beginAreaName) {
        this.beginAreaName = beginAreaName;
    }
    public String getBeginCityName() {
        return beginCityName;
    }
    public void setBeginCityName(String beginCityName) {
        this.beginCityName = beginCityName;
    }
    public String getEndProvinceName() {
        return endProvinceName;
    }
    public void setEndProvinceName(String endProvinceName) {
        this.endProvinceName = endProvinceName;
    }
    public String getEndAreaName() {
        return endAreaName;
    }
    public void setEndAreaName(String endAreaName) {
        this.endAreaName = endAreaName;
    }
    public String getEndCityName() {
        return endCityName;
    }
    public void setEndCityName(String endCityName) {
        this.endCityName = endCityName;
    }
}
