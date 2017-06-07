package com.cms.dao.basicinfo;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cms.mapper.basicinfo.IndustryMapper;
import com.cms.model.basicinfo.IndustryEntity;



@Component
public class IndustryDaoImp implements IndustryDao{
	
	@Autowired
	IndustryMapper industryMapper;

	@Override
	public String saveIndustry(Map<String, Object> map) {
		if ("add".equals(map.get("type"))) {
			industryMapper.addIndustry(map);
		} else {
			industryMapper.updateIndustry(map);
		}
		return "success";
	}

	@Override
	public String deleteIndustry(String[] ids) {
		industryMapper.deleteIndustryByIds(ids);
		return "success";
	}

	@Override
	public List<IndustryEntity> getIndustrys(Map<String, Object> map) {
		return industryMapper.getIndustrys(map);
	}

	@Override
	public IndustryEntity getIndustryByID(Map<String, Object> map) {
		return industryMapper.getIndustryByID(map);
	}

}
