package com.cms.dao.manager.baseInfo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.cms.mapper.manager.baseInfo.messageLogMapper;
import com.cms.model.manager.messageLogBean;


@Component
public class messageLogDaoImp implements messageLogDao{

	@Autowired
	private messageLogMapper messageLogMapper;
	
	public messageLogBean getInfo(messageLogBean bean) {
		
		return this.messageLogMapper.getInfo(bean);
	}

	public List<messageLogBean> dataGrid(JSONObject obj) {
		
		return this.messageLogMapper.dataGrid(obj);
	}

	public int dataGridCot(JSONObject obj) {
		
		return this.messageLogMapper.dataGridCot(obj);
	}

	public void add(messageLogBean messageLogBean) {
		
		this.messageLogMapper.add(messageLogBean);
		
	}

	public void delete(JSONObject obj) {
		
		this.messageLogMapper.delete(obj);
		
	}

	public messageLogBean get(Long obj) {
		
		return this.messageLogMapper.get(obj);
	}

	public void edit(messageLogBean messageLogBean) {
		
		this.messageLogMapper.edit(messageLogBean);
		
	}

	





}
