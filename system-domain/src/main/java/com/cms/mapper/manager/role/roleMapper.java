package com.cms.mapper.manager.role;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.cms.model.manager.roleBean;

public interface roleMapper {
	public List<roleBean> dataGrid(JSONObject obj);
	
	public int dataGridCot(JSONObject obj);
	
	public roleBean get(Long id);
	
	public void update(roleBean bean);
	
	public void add(roleBean bean);
	
	public void delete(Long id);
	
	public void delGrant(JSONObject obj);
	
	public void addGrant(JSONObject obj);
}
