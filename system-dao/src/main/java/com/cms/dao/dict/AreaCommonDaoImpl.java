package com.cms.dao.dict;

import com.alibaba.fastjson.JSONObject;
import com.cms.mapper.dict.AreaCommonMapper;
import com.cms.model.dict.AreaCity;
import com.cms.model.dict.AreaProvince;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by liuxin on 2016/5/5.
 */
@Component
public class AreaCommonDaoImpl implements AreaCommonDao{
    @Autowired
    private AreaCommonMapper areaCommonMapper;

    public List<AreaProvince> getProvinceList() {
        return this.areaCommonMapper.getProvinceList();
    }

    public List<AreaCity> getCityList(AreaCity areaCity) {
        return this.areaCommonMapper.getCityList(areaCity);
    }
    
    public AreaCity getCityById(String id){
    	
    	return this.areaCommonMapper.getCityById(id);
    }
    
    public List<AreaCity> getCityByProvinceId(List l){
    	
    	JSONObject json = new JSONObject();
    	
    	json.put("filter", l);
    	
    	return this.areaCommonMapper.getCityByProvinceId(json);
    }
}
