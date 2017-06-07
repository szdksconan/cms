package com.cms.dao.basicinfo;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cms.mapper.basicinfo.UnitMapper;
import com.cms.model.basicinfo.UnitEntity;



@Component
public class UnitDaoImp implements UnitDao{
	@Autowired
	UnitMapper unitMapper;

	@Override
	public String saveUnit(Map<String, Object> map) {
		if ("add".equals(map.get("type"))) {
			unitMapper.addUnit(map);
		} else {
			unitMapper.updateUnit(map);
		}
		return "success";
	}

	@Override
	public String deleteUnit(String[] ids) {
		unitMapper.deleteUnitByIds(ids);
		return "success";
	}

	@Override
	public List<UnitEntity> getUnits(Map<String, Object> map) {
		return unitMapper.getUnits(map);
	}

	@Override
	public UnitEntity getUnitByID(Map<String, Object> map) {
		return unitMapper.getUnitByID(map);
	}

}
