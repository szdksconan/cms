package com.cms.iservice.basicinfo;

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.cms.model.basicinfo.IndustryEntity;

/**
 * 行业接口
 * @author zby
 */
public interface IndustryService {
	/**
	 * 保存行业实体对象(包括更新)
	 * @param map
	 * @return
	 */
    public String saveIndustry(Map<String,Object> map);

    /**
     * 根据ID删除对象
     * @param ids
     * @return
     */
    public String deleteIndustry(String[] ids);
    
    /**
     * 根据条件获取实体对象集合
     * @param map
     * @return
     */
    public JSONObject getIndustrys(Map<String,Object> map);
    
    /**
     * 获取单个实体对象
     * @param map
     * @return
     */
    public IndustryEntity getIndustryByID(Map<String,Object> map);
}
