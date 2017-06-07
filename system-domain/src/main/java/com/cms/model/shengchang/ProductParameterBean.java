package com.cms.model.shengchang;

import java.io.Serializable;

/**
 * 产品属性参数
 * Created by liuxin on 2016/5/6.
 */
public class ProductParameterBean implements Serializable{
    private static final long serialVersionUID = 1L;

    private String id;
    private String productId;
    private String parameterName;
    private String parameterValue;
    private String createTime;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getProductId() {
        return productId;
    }
    public void setProductId(String productId) {
        this.productId = productId;
    }
    public String getParameterName() {
        return parameterName;
    }
    public void setParameterName(String parameterName) {
        this.parameterName = parameterName;
    }
    public String getParameterValue() {
        return parameterValue;
    }
    public void setParameterValue(String parameterValue) {
        this.parameterValue = parameterValue;
    }
    public String getCreateTime() {
        return createTime;
    }
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
