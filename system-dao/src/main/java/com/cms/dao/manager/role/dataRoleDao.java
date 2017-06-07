package com.cms.dao.manager.role;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.cms.model.manager.dataRoleBean;

public interface dataRoleDao {
	public dataRoleBean getInfo(JSONObject obj);
	
	public List<dataRoleBean> dataGrid(JSONObject obj);
	
	public int dataGridCot(JSONObject obj);
	
	public void add(dataRoleBean dataRoleBean);
	
	public void delete(JSONObject obj);
	
	public dataRoleBean get(Long obj);
	
	public void update(dataRoleBean dataRoleBean);
	
	public void delGrant(JSONObject obj);
	
	public void addGrant(JSONObject obj);
}
