package com.cms.dao.manager.department;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.cms.model.manager.departmentBean;

public interface departmentDao {
	public List<departmentBean> dataGrid(JSONObject obj);
	
	public void delete(Long id);
	
	public departmentBean get(Long id);
	
	public void update(departmentBean bean);
	
	public void add(departmentBean bean);
}
