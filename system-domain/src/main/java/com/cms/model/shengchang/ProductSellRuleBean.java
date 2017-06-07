package com.cms.model.shengchang;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * 产品销售规则
 * @author liuxin
 *
 */

public class ProductSellRuleBean implements Serializable{

	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 1L;
	private String id; //id
    private String mainProductId;//主营产品id
	private String productId; //产品ID
    private String applyProductType;//适用物资类别
    private String createTime;//创建时间
	private String updateTime; //编制时间
    private String updator;//编制人
    private Integer sellType;//销售类型
    private Integer payType;//支付方式
    private BigDecimal deposit;//保证金
    private String produceDutyExplain;//生产企业义务说明
    private String traderDutyExplain;//贸易义务说明
    private String aftermarketExplain;//售后服务说明
    private List<ProductSellRuleAreaBean> productSellRuleAreaBeanList;
    private List<ProductPriceBean> productPriceBeanList;
    private String rulePrice;
    private String ruleArea;
    private String ruleAreaCode;//销售区域
    private String ruleId;
    private String ruleName;

    public String getCreateTime() {
        return createTime;
    }
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
    public String getRuleId() {
        return ruleId;
    }
    public void setRuleId(String ruleId) {
        this.ruleId = ruleId;
    }
    public String getRuleName() {
        return ruleName;
    }
    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }
    public String getApplyProductType() {
        return applyProductType;
    }
    public void setApplyProductType(String applyProductType) {
        this.applyProductType = applyProductType;
    }
    public List<ProductPriceBean> getProductPriceBeanList() {
        return productPriceBeanList;
    }
    public void setProductPriceBeanList(List<ProductPriceBean> productPriceBeanList) {
        this.productPriceBeanList = productPriceBeanList;
    }
    public String getRuleAreaCode() {
        return ruleAreaCode;
    }
    public void setRuleAreaCode(String ruleAreaCode) {
        this.ruleAreaCode = ruleAreaCode;
    }
    public String getRuleArea() {
        return ruleArea;
    }
    public void setRuleArea(String ruleArea) {
        this.ruleArea = ruleArea;
    }
    public String getRulePrice() {
        return rulePrice;
    }
    public void setRulePrice(String rulePrice) {
        this.rulePrice = rulePrice;
    }
    public String getMainProductId() {
        return mainProductId;
    }
    public void setMainProductId(String mainProductId) {
        this.mainProductId = mainProductId;
    }
    public List<ProductSellRuleAreaBean> getProductSellRuleAreaBeanList() {
        return productSellRuleAreaBeanList;
    }
    public void setProductSellRuleAreaBeanList(List<ProductSellRuleAreaBean> productSellRuleAreaBeanList) {
        this.productSellRuleAreaBeanList = productSellRuleAreaBeanList;
    }
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
    public String getUpdateTime() {
        return updateTime;
    }
    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
    public String getUpdator() {
        return updator;
    }
    public void setUpdator(String updator) {
        this.updator = updator;
    }
    public Integer getSellType() {
        return sellType;
    }
    public void setSellType(Integer sellType) {
        this.sellType = sellType;
    }
    public Integer getPayType() {
        return payType;
    }
    public void setPayType(Integer payType) {
        this.payType = payType;
    }
    public BigDecimal getDeposit() {
        return deposit;
    }
    public void setDeposit(BigDecimal deposit) {
        this.deposit = deposit;
    }
    public String getProduceDutyExplain() {
        return produceDutyExplain;
    }
    public void setProduceDutyExplain(String produceDutyExplain) {
        this.produceDutyExplain = produceDutyExplain;
    }
    public String getTraderDutyExplain() {
        return traderDutyExplain;
    }
    public void setTraderDutyExplain(String traderDutyExplain) {
        this.traderDutyExplain = traderDutyExplain;
    }
    public String getAftermarketExplain() {
        return aftermarketExplain;
    }
    public void setAftermarketExplain(String aftermarketExplain) {
        this.aftermarketExplain = aftermarketExplain;
    }
}
