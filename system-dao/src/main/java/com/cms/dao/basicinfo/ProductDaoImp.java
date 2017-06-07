package com.cms.dao.basicinfo;

import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cms.mapper.basicinfo.ProductMapper;
import com.cms.model.basicinfo.ProductEntity;



@Component
public class ProductDaoImp implements ProductDao{
	@Autowired
	ProductMapper productMapper;

	@Override
	public String saveProduct(Map<String, Object> map) {
		if ("add".equals(map.get("type"))) {
			productMapper.addProduct(map);
		} else {
			productMapper.updateProduct(map);
		}
		return "success";
	}

	@Override
	public String deleteProduct(String[] ids) {
		productMapper.deleteProductByIds(ids);
		return "success";
	}

	@Override
	public List<ProductEntity> getProducts(Map<String, Object> map) {
		return productMapper.getProducts(map);
	}

	@Override
	public ProductEntity getProductByID(Map<String, Object> map) {
		return productMapper.getProductByID(map);
	}

}
