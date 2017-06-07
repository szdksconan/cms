package com.cms.dao.maoyi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.cms.mapper.maoyi.OrderIncomingMapper;
import com.cms.model.maoyi.OrderIncoming;

@Component
public class GoodsIncomingDaoImpl implements GoodsIncomingDao {
	@Autowired
	private OrderIncomingMapper orderIncomingMapper;

	public List<OrderIncoming> getGoodsIncoming(OrderIncoming orderIncoming) {
		// TODO Auto-generated method stub
	return orderIncomingMapper.getGoodsIncoming(orderIncoming);
	}



	

	


}
