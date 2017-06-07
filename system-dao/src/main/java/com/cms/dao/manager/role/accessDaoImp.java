package com.cms.dao.manager.role;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.cms.mapper.manager.role.accessMapper;
import com.cms.model.manager.accessBean;

@Component

public class accessDaoImp implements accessDao{
	
	@Autowired
	private accessMapper accessMapper;

	public List<accessBean> getAccessListForUser(JSONObject obj) {
		
		return this.accessMapper.getAccessListForUser(obj);
	}

	public List<accessBean> getAllAccess(JSONObject obj) {
		
		return this.accessMapper.getAllAccess(obj);
	}

	public List<String> accessList(Long userId) {
		
		return this.accessMapper.accessList(userId);
	}

	public void delete(Long id) {
		
		this.accessMapper.delete(id);
		
	}

	public accessBean getAccessById(Long id) {
		
		return this.accessMapper.getAccessById(id);
	}

	public void update(accessBean bean) {
		
		this.accessMapper.update(bean);
		
	}

	public void add(accessBean bean) {
		
		this.accessMapper.add(bean);
		
	}

	public List<accessBean> userAccessGrid(Long userId) {
		
		return this.accessMapper.userAccessGrid(userId);
	}

}
