package com.cms.iservice.shengchan;

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.cms.model.shengchang.CompBrandBean;
import com.cms.model.shengchang.MainDocBean;
import com.cms.model.shengchang.MainProductBean;
import com.cms.model.shengchang.ProductBean;
import com.cms.model.util.Grid;
import com.cms.model.shengchang.ProductDocBean;

public interface MainProductService {
	
	//新增主营产品
	public void saveMainProduct(MainProductBean mainProductBean);
	
	//删除主营产品
	public void delMainProductById(MainProductBean mainProductBean);
	
	//查询主营产品
	public Grid getMainProductList(MainProductBean mainProductBean);

    /**
     * 查询主营产品 by id
     * @param mainProductBean
     * @return
     */
    public List<MainProductBean> getMainProductById(MainProductBean mainProductBean);
	
	//删除物资明细
    public void delProductById(MainProductBean mainProductBean);

	//查询关联物资明细
	public List<ProductBean> getProductList(MainProductBean mainProductBean);

    /**
     * 更新主营产品
     * @param mainProductBean
     */
    public void updateMainProduct(MainProductBean mainProductBean);
    
    /**
     * 新增品牌
     */
    public void addBrand(CompBrandBean compBrandBean);
    
    
    /**
     *更新品牌
     */
    public void updateBrand(Long id,String brandName);
    
    
    /**
     * 删除品牌
     */
    public void delAllBrand(Long companyId);
    
    
    /**
     *查询品牌
     */
    public List<CompBrandBean> getBrandList(Long companyId);
    
    
    /**
     * 根據ID刪除品牌
     */
    public void delBrand(CompBrandBean compBrandBean);
   
    
    /**
     * 获取主营产品附件信息（对外）
     */
    public List<MainDocBean> getMainProductDocListByFilter(Long mainProductId,String fileType,String isMain);
    
    
    /**
     * 获取产品附件信息（对外）
     */
    public List<ProductDocBean> getProductDocListByFilter(Long ProductId,String fileType,String isMain);
    
	/**
	 * 根据ruleid查询产品价格
	 */
    public List<Map> getProductPricListByRuleId(Long ruleId);
    
    /**
     * 获得物资大厅展现数据
     * @param mainProductBean
     */
    public JSONObject getPurchaseHall(MainProductBean mainProductBean,String areaId,String cityId,String provinceId,Integer rows);
}
