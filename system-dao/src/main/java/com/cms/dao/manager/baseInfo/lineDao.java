package com.cms.dao.manager.baseInfo;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.cms.model.manager.lineBean;

public interface lineDao {
	public lineBean getInfo(lineBean bean);
	
	public List<lineBean> dataGrid(JSONObject obj);
	
	public int dataGridCot(JSONObject obj);
	
	public void add(lineBean lineBean);
	
	public void delete(JSONObject obj);
	
	public lineBean get(String obj);
	
	public void edit(lineBean lineBean);
	
	public List<lineBean> selectLineJson(JSONObject obj);
}
