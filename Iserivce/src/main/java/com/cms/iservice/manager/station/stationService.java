package com.cms.iservice.manager.station;


import com.cms.model.manager.stationBean;
import com.cms.model.manager.userBean;
import com.cms.model.util.PageFilter;

import java.util.List;

public interface stationService {
	public stationBean getInfo(stationBean bean);
	
	public List<stationBean> dataGrid(stationBean stationBean, PageFilter ph);

	public void add(stationBean stationBean);

	public void delete(Long id);

	public stationBean get(Long id);
	
	public void update(stationBean stationBean);
	
	public void updateGrant(userBean bean);
}
