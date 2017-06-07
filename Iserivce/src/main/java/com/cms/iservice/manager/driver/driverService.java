package com.cms.iservice.manager.driver;


import com.alibaba.fastjson.JSONObject;
import com.cms.model.manager.driverBean;
import com.cms.model.util.Grid;
import com.cms.model.util.PageFilter;

public interface driverService {
	public driverBean getInfo(driverBean bean);
	
	public Grid dataGrid(driverBean driverBean, PageFilter ph);

	public void add(JSONObject obj)throws Exception;

	public void delete(Long id);

	public driverBean get(Long id);
	
	public void edit(driverBean driverBean)throws Exception;
	
	public void editpassword(driverBean driverBean)throws Exception;
}
