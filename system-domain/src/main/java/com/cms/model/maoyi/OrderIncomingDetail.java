package com.cms.model.maoyi;

import java.io.Serializable;
import java.math.BigDecimal;

public class OrderIncomingDetail implements Serializable{
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_incoming_detail.id
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_incoming_detail.incoming_order_no
     *
     * @mbggenerated
     */
    private String incomingOrderNo;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_incoming_detail.productId
     *
     * @mbggenerated
     */
    private String productid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_incoming_detail.product_name
     *
     * @mbggenerated
     */
    private String productName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_incoming_detail.quantity
     *
     * @mbggenerated
     */
    private Integer quantity;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_incoming_detail.unit_price
     *
     * @mbggenerated
     */
    private BigDecimal unitPrice;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_incoming_detail.total
     *
     * @mbggenerated
     */
    private BigDecimal total;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_incoming_detail.id
     *
     * @return the value of order_incoming_detail.id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_incoming_detail.id
     *
     * @param id the value for order_incoming_detail.id
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_incoming_detail.incoming_order_no
     *
     * @return the value of order_incoming_detail.incoming_order_no
     *
     * @mbggenerated
     */
    public String getIncomingOrderNo() {
        return incomingOrderNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_incoming_detail.incoming_order_no
     *
     * @param incomingOrderNo the value for order_incoming_detail.incoming_order_no
     *
     * @mbggenerated
     */
    public void setIncomingOrderNo(String incomingOrderNo) {
        this.incomingOrderNo = incomingOrderNo == null ? null : incomingOrderNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_incoming_detail.productId
     *
     * @return the value of order_incoming_detail.productId
     *
     * @mbggenerated
     */
    public String getProductid() {
        return productid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_incoming_detail.productId
     *
     * @param productid the value for order_incoming_detail.productId
     *
     * @mbggenerated
     */
    public void setProductid(String productid) {
        this.productid = productid == null ? null : productid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_incoming_detail.product_name
     *
     * @return the value of order_incoming_detail.product_name
     *
     * @mbggenerated
     */
    public String getProductName() {
        return productName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_incoming_detail.product_name
     *
     * @param productName the value for order_incoming_detail.product_name
     *
     * @mbggenerated
     */
    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_incoming_detail.quantity
     *
     * @return the value of order_incoming_detail.quantity
     *
     * @mbggenerated
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_incoming_detail.quantity
     *
     * @param quantity the value for order_incoming_detail.quantity
     *
     * @mbggenerated
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_incoming_detail.unit_price
     *
     * @return the value of order_incoming_detail.unit_price
     *
     * @mbggenerated
     */
    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_incoming_detail.unit_price
     *
     * @param unitPrice the value for order_incoming_detail.unit_price
     *
     * @mbggenerated
     */
    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_incoming_detail.total
     *
     * @return the value of order_incoming_detail.total
     *
     * @mbggenerated
     */
    public BigDecimal getTotal() {
        return total;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_incoming_detail.total
     *
     * @param total the value for order_incoming_detail.total
     *
     * @mbggenerated
     */
    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}