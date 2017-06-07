package com.cms.dao.manager.orderDic;


import com.alibaba.fastjson.JSONObject;
import com.cms.model.manager.OrderDicBean;

import java.util.List;

public interface orderDicDao {
	public OrderDicBean getInfo(OrderDicBean bean);
	
	public List<OrderDicBean> dataGrid(JSONObject obj);
	
	public int dataGridCot(JSONObject obj);
	
	public void add(OrderDicBean orderDicBean);
	
	public void delete(JSONObject obj);
	
	public OrderDicBean get(Long obj);
	
	public void edit(OrderDicBean orderDicBean);
	
	public List<OrderDicBean> getAllDic(JSONObject obj);
}
