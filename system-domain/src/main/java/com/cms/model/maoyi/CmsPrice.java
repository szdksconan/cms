package com.cms.model.maoyi;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 产品价格
 * @author My
 *
 */

public class CmsPrice implements Serializable{

	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 1L;
	private String id; //id
	private String productId; //产品ID
	private String productCode;//产品编码
    private String productSellRuleId;//销售规则id
    private BigDecimal price;//产品价格
    private Integer type;//状态

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public String getProductId() {
        return productId;
    }
    public void setProductId(String productId) {
        this.productId = productId;
    }
    public String getProductSellRuleId() {
        return productSellRuleId;
    }
    public void setProductSellRuleId(String productSellRuleId) {
        this.productSellRuleId = productSellRuleId;
    }
    public BigDecimal getPrice() {
        return price;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    public Integer getType() {
        return type;
    }
    public void setType(Integer type) {
        this.type = type;
    }
}
