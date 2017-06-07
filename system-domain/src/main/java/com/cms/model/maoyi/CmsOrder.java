package com.cms.model.maoyi;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
/**
 * 订单表
 * @author My
 *
 */
public class CmsOrder implements Serializable{
	private static final long serialVersionUID = 1L;
	public String orderId;//订单编号
	public String entId;//商家、贸易商id
	public String entName;//商家名
	public String entLogo;//商家logo
	public String entPerson;//商家联系人
	public String entTel;//电话
	public String entMail;
	public String entGPS;//商家经纬度
	public String entArea;//商家省市县
	public String entAdress;
	public String customerId;//顾客id
	public String customerName;//顾客姓名
	public String customerTel;//顾客联系电话
	public String customerMail;
	public String customerGPS;//收货经纬度
	public String customerArea;//省市县
	public String customerAdress;//顾客收货地址（详细地址）
	public Date orderTime;//下单时间
	public int payType;//支付方式：1在线支付；2货到付款；3自身账户；4公司转账；5邮局汇款；6信用额度；7微信支付。。。
	public Date payTime;//支付时间
	public String payId;//支付id
	public String discountRemark;//优惠备注
	public BigDecimal totalPrice;//订单总金额
	public Date endTime;//确认时间
	public String createdId;//下单用户id
	public String createdUser;//下单用户名
	public String createdOrgId;//组织id
	public Date modifyTime;
	public int status;//订单状态：(0)草稿状态，默认（10）等待买家付款；（20）买家已付款，等待卖家发货；（30）卖家已发货，等待买家确认；（31）卖家已部分发货；（40）交易成功；（41）部分收货，交易部分成功（50）交易关闭（60）交易取消，未支付（70）交易取消，已支付
	public int type;//客户类型：1：消费者；2：下级；3：厂家
	public int emsType;//快递方式:1快递；2物流；3上门自提
	public String emsId;//快递单号
	public BigDecimal emsPrice;//快递费用
	public String memo;
	public int recordState;//记录本身的状态：0：删除；1：正常
	public int refundStatus;//退货状态：1未退货；2部分退货；3全部退货
	public int reviewsStatus;//是否评价0：默认 1已评价
	public int billStatus;//发票状态
	public List<CmsOrderItem> cmsOrderItem;//订单明细
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
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
	public String getEntPerson() {
		return entPerson;
	}
	public void setEntPerson(String entPerson) {
		this.entPerson = entPerson;
	}
	public String getEntTel() {
		return entTel;
	}
	public void setEntTel(String entTel) {
		this.entTel = entTel;
	}
	public String getEntMail() {
		return entMail;
	}
	public void setEntMail(String entMail) {
		this.entMail = entMail;
	}
	public String getEntAdress() {
		return entAdress;
	}
	public void setEntAdress(String entAdress) {
		this.entAdress = entAdress;
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
	public String getCustomerTel() {
		return customerTel;
	}
	public void setCustomerTel(String customerTel) {
		this.customerTel = customerTel;
	}
	public String getCustomerMail() {
		return customerMail;
	}
	public void setCustomerMail(String customerMail) {
		this.customerMail = customerMail;
	}
	public String getCustomerAdress() {
		return customerAdress;
	}
	public void setCustomerAdress(String customerAdress) {
		this.customerAdress = customerAdress;
	}
	public Date getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}
	public Date getPayTime() {
		return payTime;
	}
	public void setPayTime(Date payTime) {
		this.payTime = payTime;
	}
	public String getPayId() {
		return payId;
	}
	public void setPayId(String payId) {
		this.payId = payId;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public String getCreatedId() {
		return createdId;
	}
	public void setCreatedId(String createdId) {
		this.createdId = createdId;
	}
	public String getCreatedUser() {
		return createdUser;
	}
	public void setCreatedUser(String createdUser) {
		this.createdUser = createdUser;
	}
	public Date getModifyTime() {
		return modifyTime;
	}
	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	
	public List<CmsOrderItem> getCmsOrderItem() {
		return cmsOrderItem;
	}
	public void setCmsOrderItem(List<CmsOrderItem> cmsOrderItem) {
		this.cmsOrderItem = cmsOrderItem;
	}
	public int getPayType() {
		return payType;
	}
	public void setPayType(int payType) {
		this.payType = payType;
	}
	public int getEmsType() {
		return emsType;
	}
	public void setEmsType(int emsType) {
		this.emsType = emsType;
	}
	public String getEmsId() {
		return emsId;
	}
	public void setEmsId(String emsId) {
		this.emsId = emsId;
	}
	public BigDecimal getEmsPrice() {
		return emsPrice;
	}
	public void setEmsPrice(BigDecimal emsPrice) {
		this.emsPrice = emsPrice;
	}
	public CmsOrder() {
		super();
	}
	public int getRecordState() {
		return recordState;
	}
	public void setRecordState(int recordState) {
		this.recordState = recordState;
	}
	public String getEntLogo() {
		return entLogo;
	}
	public void setEntLogo(String entLogo) {
		this.entLogo = entLogo;
	}
	public String getEntGPS() {
		return entGPS;
	}
	public void setEntGPS(String entGPS) {
		this.entGPS = entGPS;
	}
	public String getEntArea() {
		return entArea;
	}
	public void setEntArea(String entArea) {
		this.entArea = entArea;
	}
	public String getCustomerGPS() {
		return customerGPS;
	}
	public void setCustomerGPS(String customerGPS) {
		this.customerGPS = customerGPS;
	}
	public String getCustomerArea() {
		return customerArea;
	}
	public void setCustomerArea(String customerArea) {
		this.customerArea = customerArea;
	}
	public String getDiscountRemark() {
		return discountRemark;
	}
	public void setDiscountRemark(String discountRemark) {
		this.discountRemark = discountRemark;
	}
	public BigDecimal getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}
	public int getRefundStatus() {
		return refundStatus;
	}
	public void setRefundStatus(int refundStatus) {
		this.refundStatus = refundStatus;
	}
	public int getReviewsStatus() {
		return reviewsStatus;
	}
	public void setReviewsStatus(int reviewsStatus) {
		this.reviewsStatus = reviewsStatus;
	}
	public String getCreatedOrgId() {
		return createdOrgId;
	}
	public void setCreatedOrgId(String createdOrgId) {
		this.createdOrgId = createdOrgId;
	}
	public int getBillStatus() {
		return billStatus;
	}
	public void setBillStatus(int billStatus) {
		this.billStatus = billStatus;
	}
	
}
