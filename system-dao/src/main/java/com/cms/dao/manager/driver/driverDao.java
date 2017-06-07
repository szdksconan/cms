package com.cms.dao.manager.driver;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.cms.model.manager.driverBean;

public interface driverDao {
	public driverBean getInfo(driverBean bean);
	
	public List<driverBean> dataGrid(JSONObject obj);
	
	public int dataGridCot(JSONObject obj);
	
	public void add(JSONObject obj);
	
	public void delete(JSONObject obj);
	
	public driverBean get(JSONObject obj);
	
	public void edit(driverBean driverBean);
	
	public void editpassword(driverBean driverBean);
}
