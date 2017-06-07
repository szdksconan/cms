package com.cms.dao.manager.baseInfo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.cms.mapper.manager.baseInfo.carDicMapper;
import com.cms.model.manager.carDicBean;

@Component
public class carDicDaoImp implements carDicDao{

	@Autowired
	private carDicMapper carDicMapper;
	
	public List<carDicBean> dataGrid(JSONObject obj) {
		
		return this.carDicMapper.dataGrid(obj);
	}

	public void add(carDicBean bean) {
		
		this.carDicMapper.add(bean);
	}

	public carDicBean get(JSONObject obj) {
		
		return this.carDicMapper.get(obj);
	
	}

	public void update(JSONObject obj) {
		
		this.carDicMapper.update(obj);
		
	}

}
