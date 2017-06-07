package com.cms.model.wuliu;

import java.io.Serializable;

/**
 * Created by 刘鑫 on 2016/3/3.
 */
public class ChppQueryParam implements Serializable{
    private static final long serialVersionUID = 1L;
    private boolean firstQuery = false;
    private Integer provinceAreaId;
    private Integer packageType;
    private Long quoteRegion;
    private Long weight;
    private String start;
    private String end;
    private Integer carAxleId;
    private Integer carContainerId;
    private Integer carTrafficType;
    private Integer carTypeId;
    private Integer trafficType;
    private Integer infoType;
    private String carId;

    public Integer getInfoType() {
        return infoType;
    }
    public void setInfoType(Integer infoType) {
        this.infoType = infoType;
    }
    public String getCarId() {
        return carId;
    }
    public void setCarId(String carId) {
        this.carId = carId;
    }
    public Integer getCarAxleId() {
        return carAxleId;
    }
    public void setCarAxleId(Integer carAxleId) {
        this.carAxleId = carAxleId;
    }
    public Integer getCarContainerId() {
        return carContainerId;
    }
    public void setCarContainerId(Integer carContainerId) {
        this.carContainerId = carContainerId;
    }
    public Integer getCarTrafficType() {
        return carTrafficType;
    }
    public void setCarTrafficType(Integer carTrafficType) {
        this.carTrafficType = carTrafficType;
    }
    public Integer getCarTypeId() {
        return carTypeId;
    }
    public void setCarTypeId(Integer carTypeId) {
        this.carTypeId = carTypeId;
    }
    public Integer getTrafficType() {
        return trafficType;
    }
    public void setTrafficType(Integer trafficType) {
        this.trafficType = trafficType;
    }
    public String getStart() {
        return start;
    }
    public void setStart(String start) {
        this.start = start;
    }
    public String getEnd() {
        return end;
    }
    public void setEnd(String end) {
        this.end = end;
    }
    public boolean isFirstQuery() {
        return firstQuery;
    }
    public void setFirstQuery(boolean firstQuery) {
        this.firstQuery = firstQuery;
    }
    public Integer getProvinceAreaId() {
        return provinceAreaId;
    }
    public void setProvinceAreaId(Integer provinceAreaId) {
        this.provinceAreaId = provinceAreaId;
    }
    public Integer getPackageType() {
        return packageType;
    }
    public void setPackageType(Integer packageType) {
        this.packageType = packageType;
    }
    public Long getQuoteRegion() {
        return quoteRegion;
    }
    public void setQuoteRegion(Long quoteRegion) {
        this.quoteRegion = quoteRegion;
    }
    public Long getWeight() {
        return weight;
    }
    public void setWeight(Long weight) {
        this.weight = weight;
    }
}
