package com.cms.dao.manager.baseInfo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.cms.mapper.manager.baseInfo.cityMapper;
import com.cms.model.wuliu.CityBean;

@Component
public class cityDaoImp implements cityDao {
	@Autowired
	private cityMapper cityMapper;

	public CityBean getInfo(CityBean bean) {
		return this.cityMapper.getInfo(bean);
	}

	public List<CityBean> dataGrid(JSONObject obj) {
		return this.cityMapper.dataGrid(obj);
	}

	public int dataGridCot(JSONObject obj) {
		return this.cityMapper.dataGridCot(obj);
	}

	public void add(CityBean cityBean) {
		this.cityMapper.add(cityBean);
	}

	public void delete(JSONObject obj) {
		this.cityMapper.delete(obj);
	}

	public CityBean get(String obj) {
		return this.cityMapper.get(obj);
	}

	public void edit(CityBean cityBean) {
		this.cityMapper.edit(cityBean);
	}

	public List<CityBean> selectCityJson(JSONObject obj) {
		return this.cityMapper.selectCityJson(obj);
	}

	public List<CityBean> selectCityJson2(JSONObject obj) {
		return this.cityMapper.selectCityJson2(obj);
	}

}
