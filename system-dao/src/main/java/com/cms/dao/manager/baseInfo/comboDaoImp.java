package com.cms.dao.manager.baseInfo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.cms.mapper.manager.baseInfo.comboMapper;
import com.cms.model.manager.comboBean;

@Component
public class comboDaoImp implements comboDao{
	
	@Autowired
	private comboMapper comboMapper;

	public comboBean getInfo(comboBean bean) {
	
		return this.comboMapper.getInfo(bean);
	}

	public List<comboBean> dataGrid(JSONObject obj) {
	
		return this.comboMapper.dataGrid(obj);
	}

	public int dataGridCot(JSONObject obj) {
		
		return this.comboMapper.dataGridCot(obj);
	}

	public void add(comboBean comboBean) {
		
		this.comboMapper.add(comboBean);
		
	}

	public void delete(JSONObject obj) {
		
		this.comboMapper.dataGrid(obj);
		
	}

	public comboBean get(Long obj) {
		
		return this.comboMapper.get(obj);
	}

	public void edit(comboBean comboBean) {
		
		this.comboMapper.edit(comboBean);
		
	}

	public void state(JSONObject obj) {
		
		this.comboMapper.state(obj);
		
	}

	public void addpackage(comboBean comboBean) {
	
		this.comboMapper.addpackage(comboBean);
		
	}

	public void addservicepackage(JSONObject obj) {
		
		this.comboMapper.addservicepackage(obj);
		
	}


}
