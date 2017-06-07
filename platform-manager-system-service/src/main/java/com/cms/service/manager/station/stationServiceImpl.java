package com.cms.service.manager.station;

import com.alibaba.fastjson.JSONObject;
import com.cms.iservice.manager.station.stationService;
import com.cms.model.manager.stationBean;
import com.cms.model.util.PageFilter;
import com.cms.dao.manager.station.stationDao;
import com.cms.model.manager.userBean;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class stationServiceImpl implements stationService {
	@Autowired
	private stationDao stationDao;

	public stationBean getInfo(stationBean bean) {
		return this.stationDao.getInfo(bean);
	}

	public List<stationBean> dataGrid(stationBean stationBean, PageFilter ph) {
		JSONObject obj = new JSONObject();
		if (stationBean != null){
			obj = (JSONObject) JSONObject.toJSON(stationBean);
		}
		if (ph != null){
			obj.put("order", ph.getOrderString());
		}
		return this.stationDao.dataGrid(obj);
	}

	public void add(stationBean stationBean) {
		this.stationDao.add(stationBean);

	}

	public void delete(Long id) {
		JSONObject obj = new JSONObject();
		obj.put("id", id);
		this.stationDao.delete(obj);
	}

	public stationBean get(Long id) {
		JSONObject obj = new JSONObject();
		obj.put("id", id);
		return	this.stationDao.get(obj);
	}

	public void update(stationBean stationBean) {
		this.stationDao.update(stationBean);
	}

	public void updateGrant(userBean bean) {
		this.stationDao.updateGrant(bean);
	}
}
