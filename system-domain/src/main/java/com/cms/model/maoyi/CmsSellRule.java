/**
 * @Title: CmsGoods.java
 * @Copyright (C) 2016 产贸送网络
 * @Description:
 * @Revision History:
 * @Revision 1.0 2016年4月28日  余波
 */

package com.cms.model.maoyi;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
/**
 * 銷售規則
 * @author My
 *
 */
public class CmsSellRule implements Serializable {
	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 1L;
	private String id; //销售规则id
	private String mainProductId; //主营产品ID
	private String updateTime; //编制时间
    private String updator;//编制人
    private Integer sellType;//销售类型
    private Integer payType;//支付方式
    private BigDecimal deposit;//保证金
    private String produceDutyExplain;//生产企业义务说明
    private String traderDutyExplain;//贸易义务说明
    private String aftermarketExplain;//售后服务说明
    private List<CmsSellRuleArea> productSellArea;//销售区域
    private List<CmsPrice> productPrice;//销售价格

	public CmsSellRule() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMainProductId() {
		return mainProductId;
	}

	public void setMainProductId(String mainProductId) {
		this.mainProductId = mainProductId;
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

	public List<CmsSellRuleArea> getProductSellArea() {
		return productSellArea;
	}

	public void setProductSellArea(List<CmsSellRuleArea> productSellArea) {
		this.productSellArea = productSellArea;
	}

	public List<CmsPrice> getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(List<CmsPrice> productPrice) {
		this.productPrice = productPrice;
	}

}
