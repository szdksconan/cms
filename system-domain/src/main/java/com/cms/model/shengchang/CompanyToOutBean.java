package com.cms.model.shengchang;

import java.util.List;

public class CompanyToOutBean {
	/**
	 * 企业基本信息
	 */
	public CompBaseInfo base;
	/**
	 * 企业附件信息
	 */
	public List<CompAttachRel> attach;
	/**
	 * 主营产品-
	 * dubbo接口
	 */
	public List<MainProduct> mainProduct;
	/**
	 * 企业联系人信息
	 */
	public List<CompContactInfo> contact;
	/**
	 * 
	 * @return
	 */
	public CompSuppliers compSuppliers;
	
	public CompSuppliers getCompSuppliers() {
		return compSuppliers;
	}
	public void setCompSuppliers(CompSuppliers compSuppliers) {
		this.compSuppliers = compSuppliers;
	}
	public List<MainProduct> getMainProduct() {
		return mainProduct;
	}
	public void setMainProduct(List<MainProduct> mainProduct) {
		this.mainProduct = mainProduct;
	}
	public CompBaseInfo getBase() {
		return base;
	}
	public void setBase(CompBaseInfo base) {
		this.base = base;
	}
	public List<CompAttachRel> getAttach() {
		return attach;
	}
	public void setAttach(List<CompAttachRel> attach) {
		this.attach = attach;
	}
	public List<CompContactInfo> getContact() {
		return contact;
	}
	public void setContact(List<CompContactInfo> contact) {
		this.contact = contact;
	}


}
