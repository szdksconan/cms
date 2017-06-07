package com.cms.dao.dict;

import com.cms.mapper.dict.BaseProductMapper;
import com.cms.model.dict.BaseIndustry;
import com.cms.model.dict.BaseProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by liuxin on 2016/4/14.
 */
@Component
public class BaseProductDaoImpl implements BaseProductDao {
    @Autowired
    private BaseProductMapper baseProductMapper;

    public List<BaseProduct> getBaseProductList(BaseProduct baseProduct) {
        return this.baseProductMapper.getBaseProductList(baseProduct);
    }

    public List<BaseIndustry> getBaseIndustryList() {
        return this.baseProductMapper.getBaseIndustryList();
    }
}
