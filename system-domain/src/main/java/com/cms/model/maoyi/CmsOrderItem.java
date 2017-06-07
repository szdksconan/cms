package com.cms.model.maoyi;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 订单明细表
 * @author My
 *
 */
public class CmsOrderItem implements Serializable{
	private static final long serialVersionUID = 1L;
	public String itemId;//明细id
	public String orderId;//订单id
	public String productId;//商品id
	public String productTitle;//商品名称
	public String productAttrVal;//商品属性
	public String productImage;//图片
	public int quantity;//数量
	public int realQuantity;//实际成交数量
	public String unit;//单位
	public BigDecimal unitPrice;//单价
	public BigDecimal total;//金额
	public BigDecimal realTotal;//实际成交金额
	public BigDecimal discount;//优惠金额
	public int status;//商品状态
	public String memo;//备注
	public int refundStatus;//退货状态：1未退货；2部分退货；3全部退货
	public int refundQuantity;//退货数量
	public BigDecimal refundPrice;//退货金额
	public int reviewsStatus;//是否评价0：默认 1已评价
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
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
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getRealQuantity() {
		return realQuantity;
	}
	public void setRealQuantity(int realQuantity) {
		this.realQuantity = realQuantity;
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
	public BigDecimal getTotal() {
		return total;
	}
	public void setTotal(BigDecimal total) {
		this.total = total;
	}
	public BigDecimal getRealTotal() {
		return realTotal;
	}
	public void setRealTotal(BigDecimal realTotal) {
		this.realTotal = realTotal;
	}
	public BigDecimal getDiscount() {
		return discount;
	}
	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public String getProductImage() {
		return productImage;
	}
	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}
	public int getRefundStatus() {
		return refundStatus;
	}
	public void setRefundStatus(int refundStatus) {
		this.refundStatus = refundStatus;
	}
	public int getRefundQuantity() {
		return refundQuantity;
	}
	public void setRefundQuantity(int refundQuantity) {
		this.refundQuantity = refundQuantity;
	}
	public BigDecimal getRefundPrice() {
		return refundPrice;
	}
	public void setRefundPrice(BigDecimal refundPrice) {
		this.refundPrice = refundPrice;
	}
	public int getReviewsStatus() {
		return reviewsStatus;
	}
	public void setReviewsStatus(int reviewsStatus) {
		this.reviewsStatus = reviewsStatus;
	}
}
