package com.cms.dao.manager.driver;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.cms.mapper.manager.driver.driverMapper;
import com.cms.model.manager.driverBean;

@Component

public class driverDaoImp implements driverDao{
	
	@Autowired
	private driverMapper driverMapper;

	public driverBean getInfo(driverBean bean) {
	
		return this.driverMapper.getInfo(bean);
	}

	public List<driverBean> dataGrid(JSONObject obj) {
		
		return this.driverMapper.dataGrid(obj);
	}

	public int dataGridCot(JSONObject obj) {
		
		return this.driverMapper.dataGridCot(obj);
	}

	public void add(JSONObject obj) {
		
		this.driverMapper.add(obj);
		
	}

	public void delete(JSONObject obj) {
		
		this.driverMapper.delete(obj);
		
	}

	public driverBean get(JSONObject obj) {
		
		return this.driverMapper.get(obj);
	}

	public void edit(driverBean driverBean) {
		
		this.driverMapper.edit(driverBean);
		
	}

	public void editpassword(driverBean driverBean) {
		
		this.driverMapper.editpassword(driverBean);
		
	}

}
