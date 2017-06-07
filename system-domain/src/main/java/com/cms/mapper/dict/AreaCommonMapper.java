package com.cms.mapper.dict;

import com.alibaba.fastjson.JSONObject;
import com.cms.model.dict.AreaCity;
import com.cms.model.dict.AreaProvince;

import java.util.List;

/**
 * Created by liuxin on 2016/5/5.
 */
public interface AreaCommonMapper {
    public List<AreaProvince> getProvinceList();

    public List<AreaCity> getCityList(AreaCity areaCity);
    
    
    public AreaCity  getCityById(String aacid);
    
    public List<AreaCity> getCityByProvinceId(JSONObject json);
    
   
}
