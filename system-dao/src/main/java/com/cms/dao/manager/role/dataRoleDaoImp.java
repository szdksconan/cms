package com.cms.dao.manager.role;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.cms.mapper.manager.role.dataRoleMapper;
import com.cms.model.manager.dataRoleBean;

@Component

public class dataRoleDaoImp implements dataRoleDao{
	
	@Autowired
	private dataRoleMapper dataRoleMapper;

	public dataRoleBean getInfo(JSONObject obj) {
		
		return this.dataRoleMapper.getInfo(obj);
	}

	public List<dataRoleBean> dataGrid(JSONObject obj) {
		
		return this.dataRoleMapper.dataGrid(obj);
	}

	public int dataGridCot(JSONObject obj) {
		
		return this.dataRoleMapper.dataGridCot(obj);
	}

	public void add(dataRoleBean dataRoleBean) {
		this.dataRoleMapper.add(dataRoleBean);
		
	}

	public void delete(JSONObject obj) {
		
		this.dataRoleMapper.delete(obj);
		
	}

	public dataRoleBean get(Long obj) {
	
		return this.dataRoleMapper.get(obj);
	}

	public void update(dataRoleBean dataRoleBean) {
		
		this.dataRoleMapper.update(dataRoleBean);
		
	}

	public void delGrant(JSONObject obj) {
		
		this.dataRoleMapper.delGrant(obj);
		
	}

	public void addGrant(JSONObject obj) {
		
		this.dataRoleMapper.addGrant(obj);
		
	}





}
