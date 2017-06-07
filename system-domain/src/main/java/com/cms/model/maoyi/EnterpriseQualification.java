package com.cms.model.maoyi;

import java.io.Serializable;
import java.util.List;


public class EnterpriseQualification implements Serializable {
    private Long id;

    private Long enterpriseId;

    private String name;

    private Integer imageType;

    private String number;

    private String validTime;

    private String liceAgency;
    
    private List<TradeImage> images;
    

    public List<TradeImage> getImages() {
		return images;
	}

	public void setImages(List<TradeImage> images) {
		this.images = images;
	}

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


    public Integer getImageType() {
		return imageType;
	}

	public void setImageType(Integer imageType) {
		this.imageType = imageType;
	}

	public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getValidTime() {
        return validTime;
    }

    public void setValidTime(String validTime) {
        this.validTime = validTime;
    }

    public String getLiceAgency() {
        return liceAgency;
    }

    public void setLiceAgency(String liceAgency) {
        this.liceAgency = liceAgency;
    }

	@Override
	public String toString() {
		return "EnterpriseQualification [id=" + id + ", enterpriseId=" + enterpriseId + ", name=" + name
				+ ", imageType=" + imageType + ", number=" + number + ", validTime=" + validTime + ", liceAgency="
				+ liceAgency + ", images=" + images + "]";
	}
    
}