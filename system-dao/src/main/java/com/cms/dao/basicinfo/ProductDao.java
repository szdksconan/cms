package com.cms.dao.basicinfo;

import java.util.List;
import java.util.Map;

import com.cms.model.basicinfo.ProductEntity;

/**
 * 产品接口
 * @author zby
 */
public interface ProductDao {
	
	/**
	 * 保存产品实体对象(包括更新)
	 * @param map
	 * @return
	 */
    public String saveProduct(Map<String,Object> map);


    /**
     * 根据ID删除对象
     * @param ids
     * @return
     */
    public String deleteProduct(String[] ids);
    
    /**
     * 根据条件获取实体对象集合
     * @param map
     * @return
     */
    public List<ProductEntity> getProducts(Map<String,Object> map);
    
    /**
     * 获取单个实体对象
     * @param map
     * @return
     */
    public ProductEntity getProductByID(Map<String,Object> map);
}
