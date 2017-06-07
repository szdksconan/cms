package com.cms.dao.manager.orderDic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.cms.mapper.manager.orderDic.orderDicMapper;
import com.cms.model.manager.OrderDicBean;

@Component
public class orderDicDaoImp implements orderDicDao {
	@Autowired
	private orderDicMapper orderDicMapper;

	public OrderDicBean getInfo(OrderDicBean bean) {
		return this.orderDicMapper.getInfo(bean);
	}

	public List<OrderDicBean> dataGrid(JSONObject obj) {
		return this.orderDicMapper.dataGrid(obj);
	}

	public int dataGridCot(JSONObject obj) {
		return this.orderDicMapper.dataGridCot(obj);
	}

	public void add(OrderDicBean orderDicBean) {
		this.orderDicMapper.add(orderDicBean);
	}

	public void delete(JSONObject obj) {
		this.orderDicMapper.delete(obj);
	}

	public OrderDicBean get(Long obj) {
		return this.orderDicMapper.get(obj);
	}

	public void edit(OrderDicBean orderDicBean) {
		this.orderDicMapper.edit(orderDicBean);
	}

	public List<OrderDicBean> getAllDic(JSONObject obj) {
		return this.orderDicMapper.getAllDic(obj);
	}

}
