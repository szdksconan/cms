package com.cms.dao.manager.department;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.cms.mapper.manager.department.departmentMapper;
import com.cms.model.manager.departmentBean;

@Component

public class departmentDaoImp implements departmentDao{
	
	@Autowired
	private departmentMapper departmentMapper;

	public List<departmentBean> dataGrid(JSONObject obj) {
		
		return this.departmentMapper.dataGrid(obj);
	}

	public void delete(Long id) {
		
		this.departmentMapper.delete(id);
		
	}

	public departmentBean get(Long id) {
		
		return this.departmentMapper.get(id);
	}

	public void update(departmentBean bean) {
		
		this.departmentMapper.update(bean);
		
	}

	public void add(departmentBean bean) {
		
		this.departmentMapper.add(bean);
		
	}

}
