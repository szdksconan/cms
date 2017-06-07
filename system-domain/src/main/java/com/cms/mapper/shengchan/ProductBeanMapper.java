package com.cms.mapper.shengchan;


import com.cms.model.shengchang.ProductBean;
import com.cms.model.shengchang.ProductDocBean;
import com.cms.model.shengchang.ProductParameterBean;

import java.util.List;

public interface ProductBeanMapper {
    /**
     * 删除产品
     * @param productBean
     */
    public void delProductById(ProductBean productBean);

    /**
     * 批量保存产品
     * @param productBeanList
     */
    public void saveProduct(List<ProductBean> productBeanList);

    /**
     * 获取产品列表
     * @param productBean
     * @return
     */
    public List<ProductBean> getProductById(ProductBean productBean);


    /**
     * 批量保存产品附件
     * @param productDocBeanList
     */
    public void saveProductDoc(List<ProductDocBean> productDocBeanList);

    /**
     * 批量保存产品参数
     * @param productParameterBeanList
     */
    public void saveProductParameter(List<ProductParameterBean> productParameterBeanList);

    /**
     * 获取产品附件列表
     * @param productDocBean
     * @return
     */
    public List<ProductDocBean> getProductDocListByProductId(ProductDocBean productDocBean);

    /**
     *获取产品参数
     * @param parameterBean
     * @return
     */
    public List<ProductParameterBean> getProductParameter(ProductParameterBean parameterBean);

    /**
     * 删除产品属性
     * @param productBean
     */
    public void delProductParameter(ProductBean productBean);

    /**
     * 删除产品附件
     * @param productDocBeanList
     */
    public void delProductDoc(List<ProductDocBean> productDocBeanList);

    /**
     * 删除产品list
     * @param productBeanList
     */
    public void delProductList(List<ProductBean> productBeanList);
    
}
