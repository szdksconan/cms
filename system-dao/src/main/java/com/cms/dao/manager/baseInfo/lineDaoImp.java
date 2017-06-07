package com.cms.dao.manager.baseInfo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.cms.mapper.manager.baseInfo.lineMapper;
import com.cms.model.manager.lineBean;

@Component

public class lineDaoImp implements lineDao{

	@Autowired
	private lineMapper lineMapper;
	
	public lineBean getInfo(lineBean bean) {
		
		return this.lineMapper.getInfo(bean);
	}

	public List<lineBean> dataGrid(JSONObject obj) {
		
		return this.lineMapper.dataGrid(obj);
	}

	public int dataGridCot(JSONObject obj) {
		
		return this.lineMapper.dataGridCot(obj);
	}

	public void add(lineBean lineBean) {
		this.lineMapper.add(lineBean);
		
	}

	public void delete(JSONObject obj) {
		this.lineMapper.delete(obj);
		
	}

	public lineBean get(String obj) {
		
		return this.lineMapper.get(obj);
	}

	public void edit(lineBean lineBean) {
		
		this.lineMapper.edit(lineBean);
		
	}

	public List<lineBean> selectLineJson(JSONObject obj) {
		
		return this.selectLineJson(obj);
	}



}
