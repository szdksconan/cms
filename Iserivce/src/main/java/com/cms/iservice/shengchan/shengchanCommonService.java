package com.cms.iservice.shengchan;

import com.cms.model.dict.AreaCity;
import com.cms.model.dict.AreaProvince;
import com.cms.model.dict.BaseIndustry;
import com.cms.model.dict.BaseProduct;

import java.util.List;
import java.util.Map;

/**
 * Created by liuxin on 2016/4/14.
 */
public interface shengchanCommonService {
    public List<BaseProduct> getBaseProductList(BaseProduct baseProduct);

    public List<BaseIndustry> getBaseIndustryList();

    public Map getProvinceCityAreaList();

}
