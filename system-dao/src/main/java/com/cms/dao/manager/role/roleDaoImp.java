package com.cms.dao.manager.role;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.cms.mapper.manager.role.roleMapper;
import com.cms.model.manager.roleBean;

@Component
public class roleDaoImp implements roleDao{

	@Autowired
	private roleMapper roleMapper;
	
	public List<roleBean> dataGrid(JSONObject obj) {
		
		return this.roleMapper.dataGrid(obj);
	}

	public int dataGridCot(JSONObject obj) {
	
		return this.roleMapper.dataGridCot(obj);
	}

	public roleBean get(Long id) {
		
		return this.roleMapper.get(id);
	}

	public void update(roleBean bean) {
		
		this.roleMapper.update(bean);
		
	}

	public void add(roleBean bean) {
		
		this.roleMapper.add(bean);
		
	}

	public void delete(Long id) {
		
		this.roleMapper.delete(id);
		
	}

	public void delGrant(JSONObject obj) {
		
		this.roleMapper.delGrant(obj);
		
	}

	public void addGrant(JSONObject obj) {
		
		this.roleMapper.addGrant(obj);
		
	}





}
