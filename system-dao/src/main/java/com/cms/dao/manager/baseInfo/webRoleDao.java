package com.cms.dao.manager.baseInfo;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.cms.model.manager.webRoleBean;

public interface webRoleDao {
	public List<webRoleBean> dataGrid(JSONObject obj);
	
	public int dataGridCot(JSONObject obj);
	
	public webRoleBean get(Long id);
	
	public void update(webRoleBean bean);
	
	public void add(webRoleBean bean);
	
	public void delete(Long id);
	
	public void delGrant(JSONObject obj);
	
	public void addGrant(JSONObject obj);
}
