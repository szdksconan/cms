package com.cms.dao.manager.cargoods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.cms.mapper.manager.cargoods.accountMapper;
import com.cms.model.manager.accountBean;

@Component

public class accountDaoImp implements accountDao{
	
	@Autowired
	private accountMapper accountMapper;

	public accountBean getInfo(JSONObject obj) {
	
		return this.accountMapper.getInfo(obj);
	}

	public void insert(accountBean bean) {
		
		this.accountMapper.insert(bean);
		
	}

	public void update(accountBean bean) {
	
		this.accountMapper.update(bean);
		
	}

}
