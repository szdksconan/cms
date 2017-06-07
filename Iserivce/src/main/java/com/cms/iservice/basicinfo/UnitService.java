package com.cms.iservice.basicinfo;

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.cms.model.basicinfo.UnitEntity;

/**
 * 计量单位接口
 * @author zby
 */
public interface UnitService {
	
	/**
	 * 保存单位实体对象(包括更新)
	 * @param map
	 * @return
	 */
    public String saveUnit(Map<String,Object> map);

    /**
     * 根据ID删除对象
     * @param ids
     * @return
     */
    public String deleteUnit(String[] ids);
    
    /**
     * 根据条件获取实体对象集合
     * @param map
     * @return
     */
    public JSONObject getUnits(Map<String,Object> map);
    
    /**
     * 获取单个实体对象
     * @param map
     * @return
     */
    public UnitEntity getUnitByID(Map<String,Object> map);
}
