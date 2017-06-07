package com.cms.model.shengchang;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * 产品销售规则对外bean
 * @author liuxin
 *
 */

public class ProductSellRuleOutBean implements Serializable{

	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 1L;
	private Long id; //销售规则id
	private Long mainProductId; //主营产品ID
	private String updateTime; //编制时间
    private String updator;//编制人
    private Integer sellType;//销售类型
    private Integer payType;//支付方式
    private BigDecimal deposit;//保证金
    private String produceDutyExplain;//生产企业义务说明
    private String traderDutyExplain;//贸易义务说明
    private String aftermarketExplain;//售后服务说明
    private List<ProductSellRuleAreaBean> productSellRuleAreaBeanList;
    private List<Map> priceList;//产品对应销售价格

    

    public List<Map> getPriceList() {
		return priceList;
	}
	public void setPriceList(List<Map> priceList) {
		this.priceList = priceList;
	}
	public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
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
	public Long getMainProductId() {
		return mainProductId;
	}
	public void setMainProductId(Long mainProductId) {
		this.mainProductId = mainProductId;
	}
	public List<ProductSellRuleAreaBean> getProductSellRuleAreaBeanList() {
		return productSellRuleAreaBeanList;
	}
	public void setProductSellRuleAreaBeanList(List<ProductSellRuleAreaBean> productSellRuleAreaBeanList) {
		this.productSellRuleAreaBeanList = productSellRuleAreaBeanList;
	}
    
    
}
