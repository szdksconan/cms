package com.cms.dao.manager.baseInfo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.cms.mapper.manager.baseInfo.premiumMapper;
import com.cms.model.manager.premiumBean;

@Component

public class premiumDaoImp implements premiumDao{
	
	@Autowired
	private premiumMapper premiumMapper;

	public premiumBean getInfo(premiumBean bean) {
	
		return this.premiumMapper.getInfo(bean);
	}

	public List<premiumBean> dataGrid(JSONObject obj) {
		
		return this.premiumMapper.dataGrid(obj);
	}

	public int dataGridCot(JSONObject obj) {
		return this.premiumMapper.dataGridCot(obj);
	}

	public void add(premiumBean premiumBean) {
		
		this.premiumMapper.add(premiumBean);
		
	}

	public void delete(JSONObject obj) {
		
		this.premiumMapper.delete(obj);
		
	}

	public premiumBean get(Long obj) {
		
		return this.premiumMapper.get(obj);
	}

	public void edit(premiumBean premiumBean) {
		
		this.premiumMapper.edit(premiumBean);
		
	}

	




}
