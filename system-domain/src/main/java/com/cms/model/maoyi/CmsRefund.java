package com.cms.model.maoyi;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 商品退货单
 * @author My
 *
 */
public class CmsRefund implements Serializable{
	private static final long serialVersionUID = 1L;
	public String refundId;//退货单id
	public String orderId;//订单id
	public String productId;
	public String productTitle;//商品名称
	public String productAttrVal;//商品属性
	public String productImage;//商品图片
	public String unit;//单位
	public BigDecimal unitPrice;//单价
	public int refundQuantity;//退货数量
	public int realRefundQuantity;
	public BigDecimal refundTotal;//退货金额
	public BigDecimal realRefundTotal;
	public String refundDifference;//差额原因
	public int refundType;//退货原因类型
	public String refundReason;//退货原因说明
	public int refundStatus;//退货状态：0：草稿；10买家发起退货；20卖家同意；30买家已发货（卖家已取货）40确认收货50确认退款60退货取消，买家已发起过退货；70退货成功
	public Date refundPayTime;//退款时间
	public Date refundProductTime;//退货时间
	public int recordState;//该记录状态
	public String createdId;//制单人
	public String createdName;
	public String createdOrgId;//制单人组织
	public Date createdTime;//制单时间
	public String entId;//商家id
	public String entName;//商家名称
	public String customerId;//顾客id
	public String customerName;//顾客名称
	public String getRefundId() {
		return refundId;
	}
	public void setRefundId(String refundId) {
		this.refundId = refundId;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductTitle() {
		return productTitle;
	}
	public void setProductTitle(String productTitle) {
		this.productTitle = productTitle;
	}
	public String getProductAttrVal() {
		return productAttrVal;
	}
	public void setProductAttrVal(String productAttrVal) {
		this.productAttrVal = productAttrVal;
	}
	public String getProductImage() {
		return productImage;
	}
	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public BigDecimal getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}
	public int getRefundQuantity() {
		return refundQuantity;
	}
	public void setRefundQuantity(int refundQuantity) {
		this.refundQuantity = refundQuantity;
	}
	public int getRealRefundQuantity() {
		return realRefundQuantity;
	}
	public void setRealRefundQuantity(int realRefundQuantity) {
		this.realRefundQuantity = realRefundQuantity;
	}
	public BigDecimal getRefundTotal() {
		return refundTotal;
	}
	public void setRefundTotal(BigDecimal refundTotal) {
		this.refundTotal = refundTotal;
	}
	public BigDecimal getRealRefundTotal() {
		return realRefundTotal;
	}
	public void setRealRefundTotal(BigDecimal realRefundTotal) {
		this.realRefundTotal = realRefundTotal;
	}
	public int getRefundType() {
		return refundType;
	}
	public void setRefundType(int refundType) {
		this.refundType = refundType;
	}
	public String getRefundReason() {
		return refundReason;
	}
	public void setRefundReason(String refundReason) {
		this.refundReason = refundReason;
	}
	public int getRefundStatus() {
		return refundStatus;
	}
	public void setRefundStatus(int refundStatus) {
		this.refundStatus = refundStatus;
	}
	public Date getRefundPayTime() {
		return refundPayTime;
	}
	public void setRefundPayTime(Date refundPayTime) {
		this.refundPayTime = refundPayTime;
	}
	public Date getRefundProductTime() {
		return refundProductTime;
	}
	public void setRefundProductTime(Date refundProductTime) {
		this.refundProductTime = refundProductTime;
	}
	public int getRecordState() {
		return recordState;
	}
	public void setRecordState(int recordState) {
		this.recordState = recordState;
	}
	public String getCreatedId() {
		return createdId;
	}
	public void setCreatedId(String createdId) {
		this.createdId = createdId;
	}
	public String getCreatedName() {
		return createdName;
	}
	public void setCreatedName(String createdName) {
		this.createdName = createdName;
	}
	public String getCreatedOrgId() {
		return createdOrgId;
	}
	public void setCreatedOrgId(String createdOrgId) {
		this.createdOrgId = createdOrgId;
	}
	public Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	public String getEntId() {
		return entId;
	}
	public void setEntId(String entId) {
		this.entId = entId;
	}
	public String getEntName() {
		return entName;
	}
	public void setEntName(String entName) {
		this.entName = entName;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getRefundDifference() {
		return refundDifference;
	}
	public void setRefundDifference(String refundDifference) {
		this.refundDifference = refundDifference;
	}
	
	
}
