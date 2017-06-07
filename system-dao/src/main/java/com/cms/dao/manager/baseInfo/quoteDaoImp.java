package com.cms.dao.manager.baseInfo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.cms.mapper.manager.baseInfo.quoteMapper;
import com.cms.model.manager.quoteBean;

@Component

public class quoteDaoImp implements quoteDao{

	@Autowired
	private quoteMapper quoteMapper;
	
	public quoteBean getInfo(quoteBean bean) {
	
		return this.quoteMapper.getInfo(bean);
	}

	public List<quoteBean> dataGrid(JSONObject obj) {
	
		return this.quoteMapper.dataGrid(obj);
	}

	public int dataGridCot(JSONObject obj) {
		
		return this.quoteMapper.dataGridCot(obj);
	}

	public void add(quoteBean quoteBean) {
		
		this.quoteMapper.add(quoteBean);
		
	}

	public void delete(JSONObject obj) {
		
		this.quoteMapper.delete(obj);
		
	}

	public quoteBean get(JSONObject obj) {
		
		return this.quoteMapper.get(obj);
	}

	public void edit(quoteBean quoteBean) {

			this.quoteMapper.edit(quoteBean);
		
	}









}
