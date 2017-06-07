package com.cms.dao.shengchan;


import com.cms.model.shengchang.MainProductBean;
import com.cms.model.shengchang.ProductPriceBean;
import com.cms.model.shengchang.ProductSellRuleBean;

import java.util.List;
import java.util.Map;

public interface ProductSellRuleDao {
    public void saveProductSellRule(List<ProductSellRuleBean> productSellRuleBeanList);

    public void saveProductSellRulePrice(List<ProductPriceBean> productPriceBeanList);

    public List<ProductSellRuleBean> getProductSellRule(MainProductBean mainProductBean);

    public void delProductSellRulePrice(Map map);

    public void delProductSellRuleList(List<ProductSellRuleBean> productSellRuleBeanList);
}
