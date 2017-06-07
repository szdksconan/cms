package com.cms.dao.manager.baseInfo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.cms.mapper.manager.baseInfo.menuMapper;
import com.cms.model.manager.menuBean;

@Component
public class menuDaoImp implements menuDao{
	
	@Autowired
	private menuMapper menuMapper;

	public List<menuBean> getAccessListForUser(JSONObject obj) {
		
		return this.menuMapper.getAccessListForUser(obj);
	}

	public List<menuBean> getAllAccess(JSONObject obj) {
	
		return this.menuMapper.getAllAccess(obj);
	}

	public List<String> accessList(String userId) {
		
		return this.menuMapper.accessList(userId);
	}

	public void delete(Long id) {
		
		this.menuMapper.delete(id);
		
	}

	public menuBean getAccessById(Long id) {
	
		return this.menuMapper.getAccessById(id);
	}

	public void update(menuBean bean) {
		
		this.menuMapper.update(bean);
		
	}

	public void add(menuBean bean) {
	
		this.menuMapper.add(bean);
		
	}

	public List<menuBean> userAccessGrid(String userId) {
		
		return this.menuMapper.userAccessGrid(userId);
	}





}
