package com.cms.model.shengchang;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class PurchaseNeedDetailBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8555250527202991932L;
	
	private String id;
	private String needDetailName;
	private String needDetailNo;
	private int needDetailNum;
	private String needDetailUnit;
	private String needDetailType;
	private String needDetailIndustry;
	private String needDetailMantr;
	private String needDetailDeliveryTime;
	private String needDetailMantrName;
	private String needDetailUnitName;
	private String needDetailIndustryName;
	private String pid;
	private String companyId;
	private Date failTime;
	private List<PurchaseNeedDetailDocBean> needDetailDoc;
    private String orderStr;
    private String productName;
    private String productModelSize;
    private String unitId;
    private String unitName;
    private Integer count;
    private String productTypeId;
    private String productTypeName;
    private String failTimeBak;
    private List filterMantr;
    private String createTime;

    public String getFailTimeBak() {
        return failTimeBak;
    }
    public void setFailTimeBak(String failTimeBak) {
        this.failTimeBak = failTimeBak;
    }
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public String getProductModelSize() {
        return productModelSize;
    }
    public void setProductModelSize(String productModelSize) {
        this.productModelSize = productModelSize;
    }
    public String getUnitId() {
        return unitId;
    }
    public void setUnitId(String unitId) {
        this.unitId = unitId;
    }
    public String getUnitName() {
        return unitName;
    }
    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }
    public Integer getCount() {
        return count;
    }
    public void setCount(Integer count) {
        this.count = count;
    }
    public String getProductTypeId() {
        return productTypeId;
    }
    public void setProductTypeId(String productTypeId) {
        this.productTypeId = productTypeId;
    }
    public String getProductTypeName() {
        return productTypeName;
    }
    public void setProductTypeName(String productTypeName) {
        this.productTypeName = productTypeName;
    }
    public String getOrderStr() {
        return orderStr;
    }
    public void setOrderStr(String orderStr) {
        this.orderStr = orderStr;
    }
    public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNeedDetailName() {
		return needDetailName;
	}
	public void setNeedDetailName(String needDetailName) {
		this.needDetailName = needDetailName;
	}
	public String getNeedDetailNo() {
		return needDetailNo;
	}
	public void setNeedDetailNo(String needDetailNo) {
		this.needDetailNo = needDetailNo;
	}
	public int getNeedDetailNum() {
		return needDetailNum;
	}
	public void setNeedDetailNum(int needDetailNum) {
		this.needDetailNum = needDetailNum;
	}
	public String getNeedDetailUnit() {
		return needDetailUnit;
	}
	public void setNeedDetailUnit(String needDetailUnit) {
		this.needDetailUnit = needDetailUnit;
	}
	public String getNeedDetailType() {
		return needDetailType;
	}
	public void setNeedDetailType(String needDetailType) {
		this.needDetailType = needDetailType;
	}
	public String getNeedDetailIndustry() {
		return needDetailIndustry;
	}
	public void setNeedDetailIndustry(String needDetailIndustry) {
		this.needDetailIndustry = needDetailIndustry;
	}
	public String getNeedDetailMantr() {
		return needDetailMantr;
	}
	public void setNeedDetailMantr(String needDetailMantr) {
		this.needDetailMantr = needDetailMantr;
	}

	
	public String getNeedDetailDeliveryTime() {
		return needDetailDeliveryTime;
	}
	public void setNeedDetailDeliveryTime(String needDetailDeliveryTime) {
		this.needDetailDeliveryTime = needDetailDeliveryTime;
	}
	public String getNeedDetailMantrName() {
		return needDetailMantrName;
	}
	public void setNeedDetailMantrName(String needDetailMantrName) {
		this.needDetailMantrName = needDetailMantrName;
	}
	public String getNeedDetailUnitName() {
		return needDetailUnitName;
	}
	public void setNeedDetailUnitName(String needDetailUnitName) {
		this.needDetailUnitName = needDetailUnitName;
	}
	public String getNeedDetailIndustryName() {
		return needDetailIndustryName;
	}
	public void setNeedDetailIndustryName(String needDetailIndustryName) {
		this.needDetailIndustryName = needDetailIndustryName;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public List<PurchaseNeedDetailDocBean> getNeedDetailDoc() {
		return needDetailDoc;
	}
	public void setNeedDetailDoc(List<PurchaseNeedDetailDocBean> needDetailDoc) {
		this.needDetailDoc = needDetailDoc;
	}
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	public Date getFailTime() {
		return failTime;
	}
	public void setFailTime(Date failTime) {
		this.failTime = failTime;
	}
	public List getFilterMantr() {
		return filterMantr;
	}
	public void setFilterMantr(List filterMantr) {
		this.filterMantr = filterMantr;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	
}
