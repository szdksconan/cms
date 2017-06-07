package com.cms.mapper.basicinfo;

import java.util.List;
import java.util.Map;

import com.cms.model.basicinfo.IndustryEntity;

public interface IndustryMapper {
    
	public int addIndustry(Map<String,Object> map);
	
	public int updateIndustry(Map<String,Object> map);
	
	public int deleteIndustryByIds(String[] array);
	
	public List<IndustryEntity> getIndustrys(Map<String,Object> map);
	
	public IndustryEntity getIndustryByID(Map<String,Object> map);
}