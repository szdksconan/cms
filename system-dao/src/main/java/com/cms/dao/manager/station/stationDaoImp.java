package com.cms.dao.manager.station;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.cms.mapper.manager.station.stationMapper;
import com.cms.model.manager.stationBean;
import com.cms.model.manager.userBean;

@Component
public class stationDaoImp implements stationDao{

	@Autowired
	private stationMapper stationMapper;
	
	public stationBean getInfo(stationBean bean) {
		
		return this.stationMapper.getInfo(bean);
	}

	public List<stationBean> dataGrid(JSONObject obj) {
		
		return this.stationMapper.dataGrid(obj);
	}

	public void add(stationBean stationBean) {
		
		this.stationMapper.add(stationBean);
		
	}

	public void delete(JSONObject obj) {
		
		this.stationMapper.delete(obj);
		
	}

	public stationBean get(JSONObject obj) {
		
		return this.stationMapper.get(obj);
	}

	public void update(stationBean stationBean) {
		
		this.stationMapper.update(stationBean);
		
	}

	public void updateGrant(userBean bean) {
		
		this.stationMapper.updateGrant(bean);
		
	}

}
