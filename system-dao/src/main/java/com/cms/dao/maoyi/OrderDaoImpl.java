package com.cms.dao.maoyi;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cms.mapper.maoyi.OrderMapper;
import com.cms.model.maoyi.CmsOrder;

@Component
public class OrderDaoImpl implements OrderDao {
	@Autowired
	private OrderMapper orderMapper;

	public int insertOrder(CmsOrder co) throws Exception {
		// TODO Auto-generated method stub
		return orderMapper.insertOrder(co);
	}

	public List<CmsOrder> getOrderInfoList(HashMap<String,Object> map) throws Exception {
		// TODO Auto-generated method stub
		return orderMapper.getOrderInfoList(map);
	}

	public int updateOrderStatus(HashMap<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return orderMapper.updateOrderStatus(map);
	}

	public int updatePayInfo(HashMap<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return orderMapper.updatePayInfo(map);
	}

	public int updateEmsInfo(HashMap<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return orderMapper.updateEmsInfo(map);
	}

	public int updateEndInfo(HashMap<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return orderMapper.updateEndInfo(map);
	}

	public int updateTotalPrice(HashMap<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return orderMapper.updateTotalPrice(map);
	}

	public int updateRefund(HashMap<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return orderMapper.updateRefund(map);
	}

	public int updateReviews(HashMap<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return orderMapper.updateReviews(map);
	}

}
