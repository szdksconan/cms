package com.cms.dao.maoyi;

import java.util.List;

import com.cms.model.maoyi.OrderIncoming;

public interface GoodsIncomingDao {
List<OrderIncoming> getGoodsIncoming(OrderIncoming orderIncoming);
}
