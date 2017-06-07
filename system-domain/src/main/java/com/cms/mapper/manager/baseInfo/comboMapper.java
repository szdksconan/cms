package com.cms.mapper.manager.baseInfo;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.cms.model.manager.comboBean;

public interface comboMapper {
	public comboBean getInfo(comboBean bean);
	
	public List<comboBean> dataGrid(JSONObject obj);
	
	public int dataGridCot(JSONObject obj);
	
	public void add(comboBean comboBean);
	
	public void delete(JSONObject obj);
	
	public comboBean get(Long obj);
	
	public void edit(comboBean comboBean);
	
	public void state(JSONObject obj);
	
	public void addpackage(comboBean comboBean);
	
	public void addservicepackage(JSONObject obj);
}
