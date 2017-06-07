package com.cms.iservice.maoyi;

import java.util.List;

import com.cms.model.maoyi.OrderIncoming;

/**
 * @author wangjian
 *
 * 2016年4月26日
 */
public interface GoodsIncomingService {
	List<OrderIncoming> getGoodsIncoming(OrderIncoming orderIncoming);

}
