package com.cms.model.maoyi;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class FactoryDispatchOrder implements Serializable{
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column factory_dispatch_order.service_order_no
     *
     * @mbggenerated
     */
    private String serviceOrderNo;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column factory_dispatch_order.CustUid
     *
     * @mbggenerated
     */
    private String custuid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column factory_dispatch_order.CustName
     *
     * @mbggenerated
     */
    private String custname;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column factory_dispatch_order.SupplierId
     *
     * @mbggenerated
     */
    private String supplierid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column factory_dispatch_order.Supplier_name
     *
     * @mbggenerated
     */
    private String supplierName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column factory_dispatch_order.Supplier_type
     *
     * @mbggenerated
     */
    private Integer supplierType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column factory_dispatch_order.Service_breif
     *
     * @mbggenerated
     */
    private String serviceBreif;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column factory_dispatch_order.service_detail
     *
     * @mbggenerated
     */
    private String serviceDetail;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column factory_dispatch_order.dispatch_time
     *
     * @mbggenerated
     */
    private Date dispatchTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column factory_dispatch_order.demand_time
     *
     * @mbggenerated
     */
    private Date demandTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column factory_dispatch_order.real_time
     *
     * @mbggenerated
     */
    private Date realTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column factory_dispatch_order.EntId
     *
     * @mbggenerated
     */
    private String entid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column factory_dispatch_order.ServiceDesc
     *
     * @mbggenerated
     */
    private String servicedesc;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column factory_dispatch_order.service_money
     *
     * @mbggenerated
     */
    private BigDecimal serviceMoney;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column factory_dispatch_order.Executor
     *
     * @mbggenerated
     */
    private String executor;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column factory_dispatch_order.state
     *
     * @mbggenerated
     */
    private Integer state;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column factory_dispatch_order.service_order_no
     *
     * @return the value of factory_dispatch_order.service_order_no
     *
     * @mbggenerated
     */
    public String getServiceOrderNo() {
        return serviceOrderNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column factory_dispatch_order.service_order_no
     *
     * @param serviceOrderNo the value for factory_dispatch_order.service_order_no
     *
     * @mbggenerated
     */
    public void setServiceOrderNo(String serviceOrderNo) {
        this.serviceOrderNo = serviceOrderNo == null ? null : serviceOrderNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column factory_dispatch_order.CustUid
     *
     * @return the value of factory_dispatch_order.CustUid
     *
     * @mbggenerated
     */
    public String getCustuid() {
        return custuid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column factory_dispatch_order.CustUid
     *
     * @param custuid the value for factory_dispatch_order.CustUid
     *
     * @mbggenerated
     */
    public void setCustuid(String custuid) {
        this.custuid = custuid == null ? null : custuid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column factory_dispatch_order.CustName
     *
     * @return the value of factory_dispatch_order.CustName
     *
     * @mbggenerated
     */
    public String getCustname() {
        return custname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column factory_dispatch_order.CustName
     *
     * @param custname the value for factory_dispatch_order.CustName
     *
     * @mbggenerated
     */
    public void setCustname(String custname) {
        this.custname = custname == null ? null : custname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column factory_dispatch_order.SupplierId
     *
     * @return the value of factory_dispatch_order.SupplierId
     *
     * @mbggenerated
     */
    public String getSupplierid() {
        return supplierid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column factory_dispatch_order.SupplierId
     *
     * @param supplierid the value for factory_dispatch_order.SupplierId
     *
     * @mbggenerated
     */
    public void setSupplierid(String supplierid) {
        this.supplierid = supplierid == null ? null : supplierid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column factory_dispatch_order.Supplier_name
     *
     * @return the value of factory_dispatch_order.Supplier_name
     *
     * @mbggenerated
     */
    public String getSupplierName() {
        return supplierName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column factory_dispatch_order.Supplier_name
     *
     * @param supplierName the value for factory_dispatch_order.Supplier_name
     *
     * @mbggenerated
     */
    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName == null ? null : supplierName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column factory_dispatch_order.Supplier_type
     *
     * @return the value of factory_dispatch_order.Supplier_type
     *
     * @mbggenerated
     */
    public Integer getSupplierType() {
        return supplierType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column factory_dispatch_order.Supplier_type
     *
     * @param supplierType the value for factory_dispatch_order.Supplier_type
     *
     * @mbggenerated
     */
    public void setSupplierType(Integer supplierType) {
        this.supplierType = supplierType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column factory_dispatch_order.Service_breif
     *
     * @return the value of factory_dispatch_order.Service_breif
     *
     * @mbggenerated
     */
    public String getServiceBreif() {
        return serviceBreif;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column factory_dispatch_order.Service_breif
     *
     * @param serviceBreif the value for factory_dispatch_order.Service_breif
     *
     * @mbggenerated
     */
    public void setServiceBreif(String serviceBreif) {
        this.serviceBreif = serviceBreif == null ? null : serviceBreif.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column factory_dispatch_order.service_detail
     *
     * @return the value of factory_dispatch_order.service_detail
     *
     * @mbggenerated
     */
    public String getServiceDetail() {
        return serviceDetail;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column factory_dispatch_order.service_detail
     *
     * @param serviceDetail the value for factory_dispatch_order.service_detail
     *
     * @mbggenerated
     */
    public void setServiceDetail(String serviceDetail) {
        this.serviceDetail = serviceDetail == null ? null : serviceDetail.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column factory_dispatch_order.dispatch_time
     *
     * @return the value of factory_dispatch_order.dispatch_time
     *
     * @mbggenerated
     */
    public Date getDispatchTime() {
        return dispatchTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column factory_dispatch_order.dispatch_time
     *
     * @param dispatchTime the value for factory_dispatch_order.dispatch_time
     *
     * @mbggenerated
     */
    public void setDispatchTime(Date dispatchTime) {
        this.dispatchTime = dispatchTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column factory_dispatch_order.demand_time
     *
     * @return the value of factory_dispatch_order.demand_time
     *
     * @mbggenerated
     */
    public Date getDemandTime() {
        return demandTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column factory_dispatch_order.demand_time
     *
     * @param demandTime the value for factory_dispatch_order.demand_time
     *
     * @mbggenerated
     */
    public void setDemandTime(Date demandTime) {
        this.demandTime = demandTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column factory_dispatch_order.real_time
     *
     * @return the value of factory_dispatch_order.real_time
     *
     * @mbggenerated
     */
    public Date getRealTime() {
        return realTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column factory_dispatch_order.real_time
     *
     * @param realTime the value for factory_dispatch_order.real_time
     *
     * @mbggenerated
     */
    public void setRealTime(Date realTime) {
        this.realTime = realTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column factory_dispatch_order.EntId
     *
     * @return the value of factory_dispatch_order.EntId
     *
     * @mbggenerated
     */
    public String getEntid() {
        return entid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column factory_dispatch_order.EntId
     *
     * @param entid the value for factory_dispatch_order.EntId
     *
     * @mbggenerated
     */
    public void setEntid(String entid) {
        this.entid = entid == null ? null : entid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column factory_dispatch_order.ServiceDesc
     *
     * @return the value of factory_dispatch_order.ServiceDesc
     *
     * @mbggenerated
     */
    public String getServicedesc() {
        return servicedesc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column factory_dispatch_order.ServiceDesc
     *
     * @param servicedesc the value for factory_dispatch_order.ServiceDesc
     *
     * @mbggenerated
     */
    public void setServicedesc(String servicedesc) {
        this.servicedesc = servicedesc == null ? null : servicedesc.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column factory_dispatch_order.service_money
     *
     * @return the value of factory_dispatch_order.service_money
     *
     * @mbggenerated
     */
    public BigDecimal getServiceMoney() {
        return serviceMoney;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column factory_dispatch_order.service_money
     *
     * @param serviceMoney the value for factory_dispatch_order.service_money
     *
     * @mbggenerated
     */
    public void setServiceMoney(BigDecimal serviceMoney) {
        this.serviceMoney = serviceMoney;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column factory_dispatch_order.Executor
     *
     * @return the value of factory_dispatch_order.Executor
     *
     * @mbggenerated
     */
    public String getExecutor() {
        return executor;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column factory_dispatch_order.Executor
     *
     * @param executor the value for factory_dispatch_order.Executor
     *
     * @mbggenerated
     */
    public void setExecutor(String executor) {
        this.executor = executor == null ? null : executor.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column factory_dispatch_order.state
     *
     * @return the value of factory_dispatch_order.state
     *
     * @mbggenerated
     */
    public Integer getState() {
        return state;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column factory_dispatch_order.state
     *
     * @param state the value for factory_dispatch_order.state
     *
     * @mbggenerated
     */
    public void setState(Integer state) {
        this.state = state;
    }
}