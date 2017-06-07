package com.cms.dao.manager.baseInfo;


import com.alibaba.fastjson.JSONObject;
import com.cms.model.wuliu.CarBean;

import java.util.List;

public interface carDao {
	public CarBean getInfo(CarBean bean);
	
	public List<CarBean> dataGrid(JSONObject obj);
	
	public int dataGridCot(JSONObject obj);
	
	public List<CarBean> dataGrid2(JSONObject obj);
	
	public void add(CarBean carBean);
	
	public void delete(JSONObject obj);
	
	public CarBean get(Long obj);
	
	public void edit(CarBean carBean);
	
	public List<CarBean> dataGrid3(JSONObject obj);
}
