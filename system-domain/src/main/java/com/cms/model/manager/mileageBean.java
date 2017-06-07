package com.cms.model.manager;

import java.io.Serializable;

public class mileageBean implements Serializable{
    /**
	 * 
	 */
    private static final long serialVersionUID = 1L;

	private String startid;

    private String startcid;

    private String endid;

    private String endcid;

    private String mileage;

    public String getStartid() {
        return startid;
    }

    public void setStartid(String startid) {
        this.startid = startid == null ? null : startid.trim();
    }

    public String getStartcid() {
        return startcid;
    }

    public void setStartcid(String startcid) {
        this.startcid = startcid == null ? null : startcid.trim();
    }

    public String getEndid() {
        return endid;
    }

    public void setEndid(String endid) {
        this.endid = endid == null ? null : endid.trim();
    }

    public String getEndcid() {
        return endcid;
    }

    public void setEndcid(String endcid) {
        this.endcid = endcid == null ? null : endcid.trim();
    }

    public String getMileage() {
        return mileage;
    }

    public void setMileage(String mileage) {
        this.mileage = mileage == null ? null : mileage.trim();
    }
}