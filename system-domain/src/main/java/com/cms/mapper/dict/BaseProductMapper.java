package com.cms.mapper.dict;

import com.cms.model.dict.BaseIndustry;
import com.cms.model.dict.BaseProduct;

import java.util.List;

/**
 * Created by Administrator on 2016/4/14.
 */
public interface BaseProductMapper {
    public List<BaseProduct> getBaseProductList(BaseProduct baseProduct);

    public List<BaseIndustry> getBaseIndustryList();
}
