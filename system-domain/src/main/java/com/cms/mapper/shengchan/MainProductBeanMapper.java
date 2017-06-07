package com.cms.mapper.shengchan;

import com.alibaba.fastjson.JSONObject;
import com.cms.model.shengchang.CompBrandBean;
import com.cms.model.shengchang.MainDocBean;
import com.cms.model.shengchang.MainProductBean;
import com.cms.model.shengchang.ProductDocBean;

import java.util.List;
import java.util.Map;

public interface MainProductBeanMapper {
	
	public List<MainProductBean> getMainProductList(MainProductBean mainProductBean);
	
	public List<MainDocBean> getMainProductDocList(MainProductBean mainProductBea) ;
	
	public void addMainProduct(MainProductBean mainProductBean);

    public void delMainProductById(MainProductBean mainProductBean);

    /**
     * 新增主营产品附件
     * @param mainDocBeanList
     */
    public void addMainProductDoc(List<MainDocBean> mainDocBeanList);

    public void updateMainProduct(MainProductBean mainProductBean);

    /**
     * 删除主营附件
     * @param mainDocBeanList
     */
    public void delMainProductDoc(List<MainDocBean> mainDocBeanList);
    
    /**
     * 品牌操作
     */
    
	public void addBrand(CompBrandBean compBrandBean);
	
	public  void updateBrand(JSONObject obj);
	
	public void  delAllBrand(Long companyId);
	
	public List getBrandList(Long companyId);
	
	public void delBrand(CompBrandBean compBrandBean);

    /**
     * 获取主营产品数量
     * @param mainProductBean
     * @return
     */
    public Integer getMainProductCot(MainProductBean mainProductBean);

	public List<MainDocBean> getMainProductDocListByFilter(JSONObject obj);
	
	
	public List<ProductDocBean> getProductDocListByFilter(JSONObject obj);
	
	public List<Map> getProductPricListByRuleId(Long ruleId) ;
}
