package com.cms.model.shengchang;

import java.io.Serializable;
import java.util.List;

public class MainProductOutBean implements Serializable{

	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;//主营产品ID
	private Long companyId; //公司ID
	private String companyName;//公司名称
	private String mainProductName ;//主营产品名称
	private String industry;//物资类别
	private Long industryId;//物资类别ID
	private String brandName; //产品品牌
	private List<ProductOutBean> productOutList;//产品具体信息
	private String setIntroduce; //主营产品介绍
	private List<DocOutBean> docList;//主营产品附件
    private List<ProductSellRuleOutBean> productSellRuleOutBeanList;//销售规则

    public List<ProductSellRuleOutBean> getProductSellRuleOutBeanList() {
        return productSellRuleOutBeanList;
    }
    public void setProductSellRuleOutBeanList(List<ProductSellRuleOutBean> productSellRuleOutBeanList) {
        this.productSellRuleOutBeanList = productSellRuleOutBeanList;
    }
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getIndustry() {
		return industry;
	}
	public void setIndustry(String industry) {
		this.industry = industry;
	}
	public Long getIndustryId() {
		return industryId;
	}
	public void setIndustryId(Long industryId) {
		this.industryId = industryId;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public List<ProductOutBean> getProductOutList() {
		return productOutList;
	}
	public void setProductOutList(List<ProductOutBean> productOutList) {
		this.productOutList = productOutList;
	}
	public String getSetIntroduce() {
		return setIntroduce;
	}
	public void setSetIntroduce(String setIntroduce) {
		this.setIntroduce = setIntroduce;
	}
	public List<DocOutBean> getDocList() {
		return docList;
	}
	public void setDocList(List<DocOutBean> docList) {
		this.docList = docList;
	}
	public String getMainProductName() {
		return mainProductName;
	}
	public void setMainProductName(String mainProductName) {
		this.mainProductName = mainProductName;
	}

}
