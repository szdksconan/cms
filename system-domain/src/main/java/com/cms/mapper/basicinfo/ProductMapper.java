package com.cms.mapper.basicinfo;

import java.util.List;
import java.util.Map;

import com.cms.model.basicinfo.ProductEntity;


public interface ProductMapper {
    
	public int addProduct(Map<String,Object> map);
	
	public int updateProduct(Map<String,Object> map);
	
	public int deleteProductByIds(String[] array);
	
	public List<ProductEntity> getProducts(Map<String,Object> map);
	
	public ProductEntity getProductByID(Map<String,Object> map);
}