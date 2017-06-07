package com.cms.dao.dict;

import com.cms.model.dict.BaseIndustry;
import com.cms.model.dict.BaseProduct;

import java.util.List;

/**
 * Created by liuxin on 2016/4/14.
 */
public interface BaseProductDao {
    public List<BaseProduct> getBaseProductList(BaseProduct baseProduct);

    public List<BaseIndustry> getBaseIndustryList();
}
