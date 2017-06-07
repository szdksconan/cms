package com.cms.mapper.maoyi;

import java.util.HashMap;
import java.util.List;

import com.cms.model.maoyi.CmsOrderItem;

public interface OrderItemMapper {
	public int insertOrderItem(List<CmsOrderItem> coi) throws Exception;
	public int updateOrderItemPrice(HashMap<String,Object> map) throws Exception;
	public int updateOrderItemRefund(HashMap<String,Object> map) throws Exception;
	public int updateOrderItemReviews(HashMap<String,Object> map) throws Exception;
	public int deleteOrderItem(HashMap<String,Object> map) throws Exception;
}
