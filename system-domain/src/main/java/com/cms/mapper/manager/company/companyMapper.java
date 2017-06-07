package com.cms.mapper.manager.company;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.cms.model.manager.companyBean;

public interface companyMapper {
	public companyBean getInfo(JSONObject obj);
	
	public List<companyBean> dataGrid(JSONObject obj);
	
	public int dataGridCot(JSONObject obj);
	
	public void add(JSONObject obj);
	
	public void updateFlag(JSONObject obj);
	
	public companyBean get(Long obj);
	
	public void update(JSONObject obj);
	
	public List<companyBean> dataGrid2(JSONObject obj);
	
	public void updateaudit(JSONObject obj);
}
