package com.cms.mapper.manager.station;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.cms.model.manager.stationBean;
import com.cms.model.manager.userBean;

public interface stationMapper {
	public stationBean getInfo(stationBean bean);
	
	public List<stationBean> dataGrid(JSONObject obj);
	
	public void add(stationBean stationBean);
	
	public void delete(JSONObject obj);
	
	public stationBean get(JSONObject obj);
	
	public void update(stationBean stationBean);
	
	public void updateGrant(userBean bean);
}
