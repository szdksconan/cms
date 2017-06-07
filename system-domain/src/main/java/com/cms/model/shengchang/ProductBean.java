package com.cms.model.shengchang;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * 产品
 * @author weitianyu
 *
 */

public class ProductBean implements Serializable{

	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 1L;
	private String id; //id
	private String productName; //产品名称
	private String mainProductId; //主营产品ID
	private String productModelSize; //规格型号
	private String companyId; //公司ID
	private String industryId; //产地ID
    private String industryName;//产地name
	private String createTime; //生成时间
    private String updateTime;//更新时间
    private String ipoTime;//上市时间
    private String productCode;//产品编码
    private List<ProductDocBean> productDocBeanList;
    private List<ProductSellRuleBean> productSellRuleBeanList;
    private String productConfigObj;//产品属性参数
    private List<ProductParameterBean> productParameterBeanList;
    private String delProductFileKeys;//产品附件删除keys
    private Integer warehouseBalance;//库存余量
    private String unitId;//单位id
    private String unitName;//
    private List<ProductDocBean> delProductDocList;
    private String price;

    public String getUpdateTime() {
        return updateTime;
    }
    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
    public List<ProductDocBean> getDelProductDocList() {
        return delProductDocList;
    }
    public void setDelProductDocList(List<ProductDocBean> delProductDocList) {
        this.delProductDocList = delProductDocList;
    }
    public Integer getWarehouseBalance() {
        return warehouseBalance;
    }
    public void setWarehouseBalance(Integer warehouseBalance) {
        this.warehouseBalance = warehouseBalance;
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
    public String getIpoTime() {
        return ipoTime;
    }
    public void setIpoTime(String ipoTime) {
        this.ipoTime = ipoTime;
    }
    public String getIndustryName() {
        return industryName;
    }
    public void setIndustryName(String industryName) {
        this.industryName = industryName;
    }
    public String getDelProductFileKeys() {
        return delProductFileKeys;
    }
    public void setDelProductFileKeys(String delProductFileKeys) {
        this.delProductFileKeys = delProductFileKeys;
    }
    public String getProductConfigObj() {
        return productConfigObj;
    }
    public void setProductConfigObj(String productConfigObj) {
        this.productConfigObj = productConfigObj;
    }
    public List<ProductParameterBean> getProductParameterBeanList() {
        return productParameterBeanList;
    }
    public void setProductParameterBeanList(List<ProductParameterBean> productParameterBeanList) {
        this.productParameterBeanList = productParameterBeanList;
    }
    public List<ProductSellRuleBean> getProductSellRuleBeanList() {
        return productSellRuleBeanList;
    }
    public void setProductSellRuleBeanList(List<ProductSellRuleBean> productSellRuleBeanList) {
        this.productSellRuleBeanList = productSellRuleBeanList;
    }
    public List<ProductDocBean> getProductDocBeanList() {
        return productDocBeanList;
    }
    public void setProductDocBeanList(List<ProductDocBean> productDocBeanList) {
        this.productDocBeanList = productDocBeanList;
    }
    public String getProductCode() {
        return productCode;
    }
    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }
    public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getMainProductId() {
		return mainProductId;
	}
	public void setMainProductId(String mainProductId) {
		this.mainProductId = mainProductId;
	}
	public String getProductModelSize() {
		return productModelSize;
	}
	public void setProductModelSize(String productModelSize) {
		this.productModelSize = productModelSize;
	}
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	public String getIndustryId() {
		return industryId;
	}
	public void setIndustryId(String industryId) {
		this.industryId = industryId;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
	
	
}
