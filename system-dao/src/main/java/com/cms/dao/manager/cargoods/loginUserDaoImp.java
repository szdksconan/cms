package com.cms.dao.manager.cargoods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.cms.mapper.manager.cargoods.loginUserMapper;
import com.cms.model.manager.loginUserBean;

@Component

public class loginUserDaoImp implements loginUserDao{
	
	@Autowired
	private loginUserMapper loginUserMapper;

	public loginUserBean getInfo(JSONObject obj) {
		
		return this.loginUserMapper.getInfo(obj);
	}

	public void insert(loginUserBean bean) {
		
		this.loginUserMapper.insert(bean);
		
	}

	public void updateInfo(JSONObject obj) {
		
		this.loginUserMapper.updateInfo(obj);
		
	}

	public JSONObject get(JSONObject obj) {
		
		return this.loginUserMapper.get(obj);
	}

	public void updateAudit(JSONObject obj) {
		
		this.loginUserMapper.updateAudit(obj);
		
	}

	public void update(JSONObject obj) throws Exception {
		
		this.loginUserMapper.update(obj);
		
	}

	public void updateTel(JSONObject obj) throws Exception {
		
		this.loginUserMapper.updateTel(obj);
		
	}

	public void updateLoginPwd(JSONObject obj) throws Exception {
		
		this.loginUserMapper.updateLoginPwd(obj);
		
	}

	public void updatePayPwd(JSONObject obj) throws Exception {
		
		this.loginUserMapper.updatePayPwd(obj);
		
	}



}
