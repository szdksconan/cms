package com.cms.dao.maoyi;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cms.mapper.maoyi.ProductCenterMapper;
import com.cms.model.maoyi.CmsProduct;

@Component
public class ProductCenterDaoImpl implements ProductCenterDao {
	@Autowired
	private ProductCenterMapper productCenterMapper;	
	
	public int insert(CmsProduct cp) {
		// TODO Auto-generated method stub
		System.out.println("ProductCenterDaoImpl.insert running......");
		return productCenterMapper.insert(cp);
	}

	public CmsProduct selectByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		
		return productCenterMapper.selectByPrimaryKey(id);
	}

	public List<CmsProduct> selectEntProduct(HashMap<String,String> map) {
		// TODO Auto-generated method stub
		return productCenterMapper.selectEntProduct(map);
	}

	public CmsProduct selectProductInfoById(String productId) {
		// TODO Auto-generated method stub
		return productCenterMapper.selectProductInfoById(productId);
	}

	public void updateSellStatus(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		productCenterMapper.updateSellStatus(map);
	}

	public List<CmsProduct> selectProductList(CmsProduct cp) {
		// TODO Auto-generated method stub
		return productCenterMapper.selectProductList(cp);
	}

	public int updateIsFamousBrand(HashMap<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return productCenterMapper.updateIsFamousBrand(map);
	}

	public List<CmsProduct> getFamousBrandCount(String enterpriceId) throws Exception {
		// TODO Auto-generated method stub
		return productCenterMapper.getFamousBrandCount(enterpriceId);
	}

}
