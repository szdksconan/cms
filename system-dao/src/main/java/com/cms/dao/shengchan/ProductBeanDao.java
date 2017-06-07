package com.cms.dao.shengchan;


import com.cms.model.shengchang.ProductBean;

import java.util.List;

public interface ProductBeanDao {
    public void delProductById(ProductBean productBean);

    public void saveProduct(List<ProductBean> productBeanList);

    public List<ProductBean> getProductById(ProductBean productBean);

    public void delProductList(List<ProductBean> productBeanList);
}
