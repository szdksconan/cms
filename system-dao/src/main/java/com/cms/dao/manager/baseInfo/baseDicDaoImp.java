package com.cms.dao.manager.baseInfo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.cms.mapper.manager.baseInfo.baseDicMapper;
import com.cms.model.manager.baseDicBean;
import org.springframework.stereotype.Component;

@Component
public class baseDicDaoImp implements baseDicDao{
	
	@Autowired
	private baseDicMapper baseDicMapper;

	public baseDicBean getInfo(baseDicBean bean) {
		
		return baseDicMapper.getInfo(bean);
	}

	public List<baseDicBean> dataGrid(JSONObject obj) {
	
		return this.baseDicMapper.dataGrid(obj);
	}

	public int dataGridCot(JSONObject obj) {
		
		return this.baseDicMapper.dataGridCot(obj);
	}

	public void add(baseDicBean baseDicBean) {
		
		this.baseDicMapper.add(baseDicBean);
		
	}

	public void delete(JSONObject obj) {
		
		this.baseDicMapper.delete(obj);
		
	}

	public baseDicBean get(Long obj) {
	
		return this.baseDicMapper.get(obj);
		
	}

	public void edit(baseDicBean baseDicBean) {
		
		this.baseDicMapper.edit(baseDicBean);
		
	}

	public List<baseDicBean> getAllDic(JSONObject obj) {
		
		return this.baseDicMapper.getAllDic(obj);
	
	}

	public List<baseDicBean> getByPid(JSONObject obj) {
		
		return this.baseDicMapper.getByPid(obj);
	
	}

}
