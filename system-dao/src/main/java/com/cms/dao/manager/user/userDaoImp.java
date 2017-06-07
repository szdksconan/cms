package com.cms.dao.manager.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.cms.mapper.manager.user.userdMapper;

import com.cms.model.manager.userBean;

@Component

public class userDaoImp implements userDao{
	
	@Autowired

	private userdMapper userdMapper;

	public userBean getUserInfo(userBean bean) {

	
		return this.userdMapper.getUserInfo(bean);

	}

	public List<userBean> dataGrid(JSONObject obj) {

		
		return this.userdMapper.dataGrid(obj);

	}

	public int dataGridCot(JSONObject obj) {

		
		return this.userdMapper.dataGridCot(obj);

	}

	public void add(userBean userBean) {

		this.userdMapper.add(userBean);
		

	}

	public void delete(JSONObject obj) {

		
		this.userdMapper.delete(obj);
		

	}

	public userBean get(Long obj) {

		
		return this.userdMapper.get(obj);

	}

	public void update(userBean userBean) {

		
		this.userdMapper.update(userBean);
		

	}

}
