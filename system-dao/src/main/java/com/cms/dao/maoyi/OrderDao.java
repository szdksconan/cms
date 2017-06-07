package com.cms.dao.maoyi;

import java.util.HashMap;
import java.util.List;

import com.cms.model.maoyi.CmsOrder;


public interface OrderDao{
	public int insertOrder(CmsOrder co) throws Exception;
	public List<CmsOrder> getOrderInfoList(HashMap<String,Object> map) throws Exception;
	public int updateOrderStatus(HashMap<String, Object> map) throws Exception;
	public int updatePayInfo(HashMap<String, Object> map) throws Exception;
	public int updateEmsInfo(HashMap<String, Object> map) throws Exception;
	public int updateEndInfo(HashMap<String, Object> map) throws Exception;
	public int updateTotalPrice(HashMap<String, Object> map) throws Exception;
	public int updateRefund(HashMap<String, Object> map) throws Exception;
	public int updateReviews(HashMap<String, Object> map) throws Exception;
}
