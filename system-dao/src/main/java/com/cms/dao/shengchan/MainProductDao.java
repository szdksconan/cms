package com.cms.dao.shengchan;

import com.alibaba.fastjson.JSONObject;
import com.cms.model.shengchang.CompBrandBean;
import com.cms.model.shengchang.MainDocBean;
import com.cms.model.shengchang.MainProductBean;
import com.cms.model.shengchang.ProductDocBean;
import com.cms.model.util.Grid;

import java.util.List;
import java.util.Map;

public interface MainProductDao {
	/**
	 * 获取主营产品信息
	 * @param mainProductBean
	 * @return
	 */
	
	public Grid getMainProductList(MainProductBean mainProductBean);
	
	/**
	 * 获取图片信息
	 * @param mainProductBean  主营信息ID
	 * @return
	 */
	public List<MainDocBean> getMainProductDocList(MainProductBean mainProductBean);
	
	/**
	 * 新增MainProduct
	 */
	public void addMainProduct(MainProductBean mainProductBean);
	
    /**
     * 删除主营产品
     * @param mainProductBean
     */
    public void delMainProductById(MainProductBean mainProductBean);

    /**
     * 更新主营产品
     * @param mainProductBean
     */
    public void updateMainProduct(MainProductBean mainProductBean);

    /**
     * 删除主营附件
     * @param mainDocBeanList
     */
    public void delMainProductDoc(List<MainDocBean> mainDocBeanList);
    
    
    //品牌操作
    
	public void addBrand(CompBrandBean compBrandBean);
	
	public  void updateBrand(JSONObject obj);
	
	public void  delAllBrand(Long companyId);
	
	public List<CompBrandBean> getBrandList(Long companyId);
	
	public void delBrand(CompBrandBean compBrandBean);
	
	public List<MainDocBean> getMainProductDocListByFilter(JSONObject obj);
	
	public List<ProductDocBean> getProductDocListByFilter(JSONObject obj);
	
	public List<Map> getProductPricListByRuleId(Long ruleId);
}
