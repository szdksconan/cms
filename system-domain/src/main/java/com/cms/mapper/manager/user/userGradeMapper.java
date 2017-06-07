package com.cms.mapper.manager.user;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.cms.model.manager.userGradeBean;

public interface userGradeMapper {
	public List<userGradeBean> dataGrid(JSONObject obj);
	
	public int dataGridCot(JSONObject obj);
	
	public void add(userGradeBean bean);
	
	public void edit(userGradeBean bean);
	
	public void delete(Long id);
	
	public userGradeBean get(Long id);
}
