package com.cms.mapper.maoyi;

import java.io.Serializable;

public class StorageService implements Serializable{
    private Long id;

    private Long enterpriseId;

    private String name;

    private String type;

    private String area;

    private String capacity;

    private String storAddCode;

    private String storAddAn;

    private String storAddAl;

    private String storageDetail;

    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(Long enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getStorAddCode() {
        return storAddCode;
    }

    public void setStorAddCode(String storAddCode) {
        this.storAddCode = storAddCode;
    }

    public String getStorAddAn() {
        return storAddAn;
    }

    public void setStorAddAn(String storAddAn) {
        this.storAddAn = storAddAn;
    }

    public String getStorAddAl() {
        return storAddAl;
    }

    public void setStorAddAl(String storAddAl) {
        this.storAddAl = storAddAl;
    }

    public String getStorageDetail() {
        return storageDetail;
    }

    public void setStorageDetail(String storageDetail) {
        this.storageDetail = storageDetail;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}