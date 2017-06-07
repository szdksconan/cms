package com.cms.dao.maoyi;

import java.util.HashMap;
import java.util.List;

import com.cms.model.maoyi.CmsProduct;


public interface ProductCenterDao{
	public int insert(CmsProduct cp);
	public CmsProduct selectByPrimaryKey(String id);
	public List<CmsProduct> selectEntProduct(HashMap<String,String> map);
	public CmsProduct selectProductInfoById(String productId);
	public void updateSellStatus(HashMap<String,Object> map);
	public List<CmsProduct> selectProductList(CmsProduct cp);
	public int updateIsFamousBrand(HashMap<String,Object> map) throws Exception;
	public List<CmsProduct> getFamousBrandCount(String enterpriceId) throws Exception;
}
