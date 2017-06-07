package com.cms.model.dict;

import java.io.Serializable;

/**
 * Created by liuxin on 2016/4/14.
 */
public class AreaCity implements Serializable {

    private static final long serialVersionUID = 1L;
    private String id;
    private String name;
    private String apid;
    private String aalcid;
    private String pid;
    private String[] cityType;

    public String[] getCityType() {
        return cityType;
    }
    public void setCityType(String[] cityType) {
        this.cityType = cityType;
    }
    public String getPid() {
        return pid;
    }
    public void setPid(String pid) {
        this.pid = pid;
    }
    public String getApid() {
        return apid;
    }
    public void setApid(String apid) {
        this.apid = apid;
    }
    public String getAalcid() {
        return aalcid;
    }
    public void setAalcid(String aalcid) {
        this.aalcid = aalcid;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
