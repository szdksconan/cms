package com.cms.dao.manager.baseInfo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.cms.mapper.manager.baseInfo.webRoleMapper;
import com.cms.model.manager.webRoleBean;

@Component

public class webRoleDaoImp implements webRoleDao{


	@Autowired
	private webRoleMapper webRoleMapper;
	
	public List<webRoleBean> dataGrid(JSONObject obj) {
		
		return this.webRoleMapper.dataGrid(obj);
	}

	public int dataGridCot(JSONObject obj) {
		
		return this.webRoleMapper.dataGridCot(obj);
	}

	public webRoleBean get(Long id) {
		
		return this.webRoleMapper.get(id);
	}

	public void update(webRoleBean bean) {
		
		this.webRoleMapper.update(bean);
		
	}

	public void add(webRoleBean bean) {
		
		this.webRoleMapper.add(bean);
		
	}

	public void delete(Long id) {
		
		this.webRoleMapper.delete(id);
		
	}

	public void delGrant(JSONObject obj) {
		
		this.webRoleMapper.delGrant(obj);
		
	}

	public void addGrant(JSONObject obj) {
		
		this.webRoleMapper.addGrant(obj);
		
	}




}
