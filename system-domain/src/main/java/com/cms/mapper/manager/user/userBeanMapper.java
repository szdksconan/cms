package com.cms.mapper.manager.user;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.cms.model.manager.userBean;

public interface userBeanMapper {
	public userBean getUserInfo(userBean bean);
	
	public List<userBean> dataGrid(JSONObject obj);
	
	public int dataGridCot(JSONObject obj);
	
	public void add(userBean userBean);
	
	public void delete(JSONObject obj);
	
	public userBean get(Long obj);
	
	public void update(userBean userBean);
}
