package com.cms.service.manager.basicinfo;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSONObject;
import com.cms.dao.basicinfo.UnitDao;
import com.cms.iservice.basicinfo.UnitService;
import com.cms.model.basicinfo.UnitEntity;



public class UnitServiceImp implements UnitService{
	@Autowired
	private UnitDao unitDao;
    @Override
    public String saveUnit(Map<String, Object> map) {
        return unitDao.saveUnit(map);
    }


    @Override
    public String deleteUnit(String[] ids) {
    	return unitDao.deleteUnit(ids);
    }

	@Override
	public JSONObject getUnits(Map<String, Object> map) {
		JSONObject json = new JSONObject();
		json.put("result", unitDao.getUnits(map));
		return json;
	}

    @Override
    public UnitEntity getUnitByID(Map<String, Object> map) {
        return unitDao.getUnitByID(map);
    }

}
