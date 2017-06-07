package com.cms.service.manager.basicinfo;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSONObject;
import com.cms.dao.basicinfo.ProductDao;
import com.cms.iservice.basicinfo.ProductService;
import com.cms.model.basicinfo.ProductEntity;

/**
 * 获取数据调用getProducts方法,然后转成json传到前台，其他方法请自行维护
 * @author zby
 */
public class ProductServiceImp implements ProductService{
	@Autowired
	private ProductDao productDao;

	@Override
	public String saveProduct(Map<String, Object> map) {
		return productDao.saveProduct(map);
	}

	@Override
	public String deleteProduct(String[] ids) {
		return productDao.deleteProduct(ids);
	}

	@Override
	public JSONObject getProducts(Map<String, Object> map) {
		JSONObject json = new JSONObject();
		json.put("result", productDao.getProducts(map));
		return json;
	}

	@Override
	public ProductEntity getProductByID(Map<String, Object> map) {
		return productDao.getProductByID(map);
	}

}
