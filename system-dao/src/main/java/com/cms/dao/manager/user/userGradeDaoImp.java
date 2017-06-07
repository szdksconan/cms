package com.cms.dao.manager.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.cms.mapper.manager.user.userGradeMapper;
import com.cms.model.manager.userGradeBean;

@Component

public class userGradeDaoImp implements userGradeDao{
	
	@Autowired
	private userGradeMapper userGradeMapper;

	public List<userGradeBean> dataGrid(JSONObject obj) {
	
		return this.userGradeMapper.dataGrid(obj);
	}

	public int dataGridCot(JSONObject obj) {
		
		return this.userGradeMapper.dataGridCot(obj);
	}

	public void add(userGradeBean bean) {
		
		this.userGradeMapper.add(bean);
		
	}

	public void edit(userGradeBean bean) {
		
		this.userGradeMapper.edit(bean);
		
	}

	public void delete(Long id) {
		
		this.userGradeMapper.delete(id);
		
	}

	public userGradeBean get(Long id) {
		
		return this.userGradeMapper.get(id);
	}



}
