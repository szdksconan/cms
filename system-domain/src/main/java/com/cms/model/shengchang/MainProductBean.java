package com.cms.model.shengchang;

import com.cms.model.util.GlobalTypeEnum;

import java.io.Serializable;
import java.util.List;

/**
 * 主营产品
 * @author weitianyu
 *
 */
public class MainProductBean implements Serializable{
	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 1L;
	
	private String id;
    private String companyId; //公司ID
    private String brandId; //品牌
    private String brandName; //品牌
    private String ruleId;//销售规则ID
    private String productSetId; //系列
    private String productSetName; //系列
    private String productName;//产品名称
    private String setIntroduce; //介绍
    private String createTime; //生成时间
    private String updateTime;//更新时间
    private List<MainDocBean> mainDocList;//附件列表
    private List<MainDocBean> mainDocListTrue;//系列附件主图
    private List<ProductBean> productBeanList;//产品列表
    private List<ProductSellRuleBean> productSellRuleBeanList;//销售规则列表
    private List<ProductPriceBean> productPriceBeanList;//产品价格列表
    private String productBeanStr;//产品
    private String productSellRuleStr;//销售规则
    private String mainProductPicName;
    private String mainProductPicNameTrue;
    private Integer state;//状态
    private Integer statebak;
    private String stateName;
    private String delMainFileKeys;//删除的fileKeys
    private List<MainDocBean> delMainDocList;//删除附件列表
    private String delProductIds;//删除的product ids
    private String delProductRuleIds;//删除的productSellRule ids
    private List<ProductBean> delProductBeanList;//删除产品列表
    private List<ProductSellRuleBean> delProductSellRuleBeanList;//删除产品规则列表
    private String orderStr;
    private String productTypeId;//物资类别
    private String productTypeName;//物资类别
    private Integer productStyleId;//物资类型
    private String productStyleName;

    public Integer getProductStyleId() {
        return productStyleId;
    }
    public void setProductStyleId(Integer productStyleId) {
        this.productStyleId = productStyleId;
    }
    public String getProductStyleName() {
        return productStyleName;
    }
    public void setProductStyleName(String productStyleName) {
        this.productStyleName = productStyleName;
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
    public String getUpdateTime() {
        return updateTime;
    }
    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
    public String getOrderStr() {
        return orderStr;
    }
    public void setOrderStr(String orderStr) {
        this.orderStr = orderStr;
    }
    public List<MainDocBean> getMainDocListTrue() {
        return mainDocListTrue;
    }
    public void setMainDocListTrue(List<MainDocBean> mainDocListTrue) {
        this.mainDocListTrue = mainDocListTrue;
    }
    public String getMainProductPicNameTrue() {
        return mainProductPicNameTrue;
    }
    public void setMainProductPicNameTrue(String mainProductPicNameTrue) {
        this.mainProductPicNameTrue = mainProductPicNameTrue;
    }
    public List<ProductBean> getDelProductBeanList() {
        return delProductBeanList;
    }
    public void setDelProductBeanList(List<ProductBean> delProductBeanList) {
        this.delProductBeanList = delProductBeanList;
    }
    public List<ProductSellRuleBean> getDelProductSellRuleBeanList() {
        return delProductSellRuleBeanList;
    }
    public void setDelProductSellRuleBeanList(List<ProductSellRuleBean> delProductSellRuleBeanList) {
        this.delProductSellRuleBeanList = delProductSellRuleBeanList;
    }
    public String getDelProductIds() {
        return delProductIds;
    }
    public void setDelProductIds(String delProductIds) {
        this.delProductIds = delProductIds;
    }
    public String getDelProductRuleIds() {
        return delProductRuleIds;
    }
    public void setDelProductRuleIds(String delProductRuleIds) {
        this.delProductRuleIds = delProductRuleIds;
    }
    public String getDelMainFileKeys() {
        return delMainFileKeys;
    }
    public void setDelMainFileKeys(String delMainFileKeys) {
        this.delMainFileKeys = delMainFileKeys;
    }
    public List<MainDocBean> getDelMainDocList() {
        return delMainDocList;
    }
    public void setDelMainDocList(List<MainDocBean> delMainDocList) {
        this.delMainDocList = delMainDocList;
    }
    public Integer getStatebak() {
        return statebak;
    }
    public void setStatebak(Integer statebak) {
        this.statebak = statebak;
    }
    public String getBrandName() {
        return brandName;
    }
    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public String getStateName() {
        return GlobalTypeEnum.getName(this.getState());
    }
    public void setStateName(String stateName) {
        this.stateName = stateName;
    }
    public String getBrandId() {
        return brandId;
    }
    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }
    public String getProductSetId() {
        return productSetId;
    }
    public void setProductSetId(String productSetId) {
        this.productSetId = productSetId;
    }
    public String getProductSetName() {
        return productSetName;
    }
    public void setProductSetName(String productSetName) {
        this.productSetName = productSetName;
    }
    public Integer getState() {
        return state;
    }
    public void setState(Integer state) {
        this.state = state;
    }
    public List<ProductPriceBean> getProductPriceBeanList() {
        return productPriceBeanList;
    }
    public void setProductPriceBeanList(List<ProductPriceBean> productPriceBeanList) {
        this.productPriceBeanList = productPriceBeanList;
    }
    public String getProductBeanStr() {
        return productBeanStr;
    }
    public void setProductBeanStr(String productBeanStr) {
        this.productBeanStr = productBeanStr;
    }
    public String getProductSellRuleStr() {
        return productSellRuleStr;
    }
    public void setProductSellRuleStr(String productSellRuleStr) {
        this.productSellRuleStr = productSellRuleStr;
    }
    public List<ProductSellRuleBean> getProductSellRuleBeanList() {
        return productSellRuleBeanList;
    }
    public void setProductSellRuleBeanList(List<ProductSellRuleBean> productSellRuleBeanList) {
        this.productSellRuleBeanList = productSellRuleBeanList;
    }
    public List<MainDocBean> getMainDocList() {
        return mainDocList;
    }
    public void setMainDocList(List<MainDocBean> mainDocList) {
        this.mainDocList = mainDocList;
    }
    public List<ProductBean> getProductBeanList() {
        return productBeanList;
    }
    public void setProductBeanList(List<ProductBean> productBeanList) {
        this.productBeanList = productBeanList;
    }
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	public String getRuleId() {
		return ruleId;
	}
	public void setRuleId(String ruleId) {
		this.ruleId = ruleId;
	}
	public String getSetIntroduce() {
		return setIntroduce;
	}
	public void setSetIntroduce(String setIntroduce) {
		this.setIntroduce = setIntroduce;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getMainProductPicName() {
		return mainProductPicName;
	}
	public void setMainProductPicName(String mainProductPicName) {
		this.mainProductPicName = mainProductPicName;
	}
	
}
