package com.cms.dao.manager.baseInfo;


import com.alibaba.fastjson.JSONObject;
import com.cms.model.wuliu.CityBean;

import java.util.List;

public interface cityDao {
	public CityBean getInfo(CityBean bean);
	
	public List<CityBean> dataGrid(JSONObject obj);
	
	public int dataGridCot(JSONObject obj);
	
	public void add(CityBean cityBean);
	
	public void delete(JSONObject obj);
	
	public CityBean get(String obj);
	
	public void edit(CityBean cityBean);
	
	public List<CityBean> selectCityJson(JSONObject obj);
	
	public List<CityBean> selectCityJson2(JSONObject obj);
}
