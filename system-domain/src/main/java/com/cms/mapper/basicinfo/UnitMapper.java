package com.cms.mapper.basicinfo;

import java.util.List;
import java.util.Map;

import com.cms.model.basicinfo.UnitEntity;


public interface UnitMapper {
    
	public int addUnit(Map<String,Object> map);
	
	public int updateUnit(Map<String,Object> map);
	
	public int deleteUnitByIds(String[] array);
	
	public List<UnitEntity> getUnits(Map<String,Object> map);
	
	public UnitEntity getUnitByID(Map<String,Object> map);
}