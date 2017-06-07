package com.cms.dao.shengchan;

import com.cms.mapper.shengchan.ProductBeanMapper;
import com.cms.model.shengchang.ProductBean;
import com.cms.model.shengchang.ProductDocBean;
import com.cms.model.shengchang.ProductParameterBean;
import com.cms.model.util.GlobalUtil;
import com.cms.service.common.redis.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductBeanDaoImpl implements ProductBeanDao {
    @Autowired
    private ProductBeanMapper productBeanMapper;

    public void delProductById(ProductBean productBean) {
        this.productBeanMapper.delProductById(productBean);
    }

    public void saveProduct(List<ProductBean> productBeanList) {
        this.productBeanMapper.saveProduct(productBeanList);
        for (ProductBean productBean:productBeanList){
            if (productBean.getDelProductDocList().size()!=0){
                this.productBeanMapper.delProductDoc(productBean.getDelProductDocList());
            }
            if (productBean.getProductDocBeanList().size()!=0){
                this.productBeanMapper.saveProductDoc(productBean.getProductDocBeanList());
            }
            if (productBean.getProductParameterBeanList().size()!=0){
                this.productBeanMapper.delProductParameter(productBean);
                this.productBeanMapper.saveProductParameter(productBean.getProductParameterBeanList());
            }
        }
    }

    public List<ProductBean> getProductById(ProductBean productBean) {
        List<ProductBean> productBeanList = this.productBeanMapper.getProductById(productBean);
        for (ProductBean bean:productBeanList){
            ProductDocBean productDocBean = new ProductDocBean();
            productDocBean.setProductId(bean.getId());
            try {
                bean.setProductDocBeanList(GlobalUtil.MapToList(RedisUtil.hgetAll("produceProductDoc"+bean.getId()),productDocBean.getClass()));
            }catch (Exception e){}
            if (bean.getProductDocBeanList()==null){
                bean.setProductDocBeanList(this.productBeanMapper.getProductDocListByProductId(productDocBean));
            }
            ProductParameterBean parameterBean = new ProductParameterBean();
            parameterBean.setProductId(bean.getId());
            bean.setProductParameterBeanList(this.productBeanMapper.getProductParameter(parameterBean));
        }
        return productBeanList;
    }

    public void delProductList(List<ProductBean> productBeanList) {
        this.productBeanMapper.delProductList(productBeanList);
    }
}
