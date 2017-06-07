package com.cms.dao.dict;

import com.cms.model.dict.AreaCity;
import com.cms.model.dict.AreaProvince;

import java.util.List;

/**
 * Created by liuxin on 2016/5/5.
 */
public interface AreaCommonDao {
    public List<AreaProvince> getProvinceList();

    public List<AreaCity> getCityList(AreaCity areaCity);
    
    public AreaCity getCityById(String id);
    
    public List<AreaCity> getCityByProvinceId(List l);
}
