package com.cms.dao.shengchan;

import com.cms.mapper.shengchan.ProductSellRuleMapper;
import com.cms.model.shengchang.MainProductBean;
import com.cms.model.shengchang.ProductPriceBean;
import com.cms.model.shengchang.ProductSellRuleBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * Created by liuxin on 2016/5/6.
 */
@Component
public class ProductSellRuleDaoImpl implements ProductSellRuleDao{
    @Autowired
    private ProductSellRuleMapper productSellRuleMapper;

    public void saveProductSellRule(List<ProductSellRuleBean> productSellRuleBeanList) {
        this.productSellRuleMapper.saveProductSellRule(productSellRuleBeanList);
        for (ProductSellRuleBean productSellRuleBean:productSellRuleBeanList){
            if (productSellRuleBean.getProductSellRuleAreaBeanList().size()!=0){
                this.productSellRuleMapper.delProductSellRuleArea(productSellRuleBean);
                this.productSellRuleMapper.saveProductSellRuleArea(productSellRuleBean.getProductSellRuleAreaBeanList());
            }
        }
    }

    public void saveProductSellRulePrice(List<ProductPriceBean> productPriceBeanList) {
        this.productSellRuleMapper.saveProductSellRulePrice(productPriceBeanList);
    }

    public List<ProductSellRuleBean> getProductSellRule(MainProductBean mainProductBean) {
        List<ProductSellRuleBean> productSellRuleBeanList = this.productSellRuleMapper.getProductSellRuleList(mainProductBean);
        for (ProductSellRuleBean productSellRuleBean:productSellRuleBeanList){
            productSellRuleBean.setProductSellRuleAreaBeanList(this.productSellRuleMapper.getProductSellRuleArealist(productSellRuleBean));
            productSellRuleBean.setProductPriceBeanList(this.productSellRuleMapper.getProductPriveList(productSellRuleBean));
        }
        return productSellRuleBeanList;
    }

    public void delProductSellRulePrice(Map map) {
        this.productSellRuleMapper.delProductSellRulePrice(map);
    }

    public void delProductSellRuleList(List<ProductSellRuleBean> productSellRuleBeanList) {
        this.productSellRuleMapper.delProductSellRuleList(productSellRuleBeanList);
    }
}
