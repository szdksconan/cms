package com.cms.dao.maoyi;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cms.mapper.maoyi.OrderItemMapper;
import com.cms.model.maoyi.CmsOrderItem;

@Component
public class OrderItemDaoImpl implements OrderItemDao {
	@Autowired
	private OrderItemMapper orderItemMapper;

	public int insertOrderItem(List<CmsOrderItem> coi) throws Exception {
		// TODO Auto-generated method stub
		return orderItemMapper.insertOrderItem(coi);
	}

	public int updateOrderItemPrice(HashMap<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return orderItemMapper.updateOrderItemPrice(map);
	}

	public int updateOrderItemRefund(HashMap<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return orderItemMapper.updateOrderItemRefund(map);
	}

	public int updateOrderItemReviews(HashMap<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return orderItemMapper.updateOrderItemReviews(map);
	}

	public int deleteOrderItem(HashMap<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return orderItemMapper.deleteOrderItem(map);
	}

}
