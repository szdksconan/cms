package com.cms.model.maoyi;

import java.io.Serializable;

public class GoodsService implements Serializable {
    private Long id;

    private Long enterpriseId;

    private Integer type;

    private String region;

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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

	@Override
	public String toString() {
		return "GoodsService [id=" + id + ", enterpriseId=" + enterpriseId + ", type=" + type + ", region=" + region
				+ ", description=" + description + "]";
	}
    
    
}