package com.cms.mapper.shengchan;


import com.cms.model.shengchang.MainProductBean;
import com.cms.model.shengchang.ProductPriceBean;
import com.cms.model.shengchang.ProductSellRuleAreaBean;
import com.cms.model.shengchang.ProductSellRuleBean;

import java.util.List;
import java.util.Map;

public interface ProductSellRuleMapper {

    /**
     * 批量保存销售规则
     * @param productSellRuleBeanList
     */
    public void saveProductSellRule(List<ProductSellRuleBean> productSellRuleBeanList);

    /**
     * 批量保存销售规则适用区域
     * @param productSellRuleAreaBeanList
     */
    public void saveProductSellRuleArea(List<ProductSellRuleAreaBean> productSellRuleAreaBeanList);

    /**
     * 批量保存产品价格
     * @param productPriceBeanList
     */
    public void saveProductSellRulePrice(List<ProductPriceBean> productPriceBeanList);

    /**
     * 获取销售规则
     * @param mainProductBean
     * @return
     */
    public List<ProductSellRuleBean> getProductSellRuleList(MainProductBean mainProductBean);

    /**
     * 获取适用区域
     * @param productSellRuleBean
     * @return
     */
    public List<ProductSellRuleAreaBean> getProductSellRuleArealist(ProductSellRuleBean productSellRuleBean);

    /**
     * 获取产品价格
     * @param productSellRuleBean
     * @return
     */
    public List<ProductPriceBean> getProductPriveList(ProductSellRuleBean productSellRuleBean);

    /**
     * 删除适用区域
     * @param productSellRuleBean
     */
    public void delProductSellRuleArea(ProductSellRuleBean productSellRuleBean);

    /**
     * 删除产品价格
     * @param map
     */
    public void delProductSellRulePrice(Map map);

    /**
     * 删除销售规则list
     * @param productSellRuleBeanList
     */
    public void delProductSellRuleList(List<ProductSellRuleBean> productSellRuleBeanList);
}
