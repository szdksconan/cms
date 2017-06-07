package com.cms.iservice.maoyi;

import java.util.HashMap;
import java.util.List;

import com.cms.model.maoyi.CmsOrder;
import com.cms.model.maoyi.CmsOrderItem;
/**
 * 订单接口
 * @author My
 *
 */
public interface OrderService {
	/**
	 * 生成订单（需包含明细CmsOrderItem）
	 * @param map
	 * @return 1表示成功，0表示失败
	 * @throws Exception
	 * HashMap.put("cmsOrder",CmsOrder)
	 */
	public int insertOrder(HashMap<String,CmsOrder> map) throws Exception;
	/**
	 * 根据orderId，productId，productTitle，entName，status，orderTime（startTime endTime）
	 * 查询订单list
	 * @param map
	 * @return
	 * @throws Exception
	 * map.put("orderId",orderId)
	 * map.put("productId",productId)
	 * map.put("productTitle",productTitle)
	 * map.put("entName",entName)
	 * map.put("status",status)
	 * map.put("startTime",startTime)
	 * map.put("endTime",endTime)
	 * map.put("createdOrgId",createdOrgId)
	 * map.put("createdId",createdId);
	 * map.put("entId",entId);
	 * map.put("customerId",customerId); 
	 */
	public List<CmsOrder> getOrderInfoList(HashMap<String,Object> map) throws Exception;
	/**
	 * 根据orderIds修改订单的状态
	 * @param map
	 * @return
	 * @throws Exception
	 * map.put("status",status)status参数取值详见CmsOrder
	 * map.put("recordState",recordState)
	 * List<String> list = new ArrayList<String>()
	 * list.add(orderId);
	 * map.put("orderIds",list);
	 */
	public int updateOrderStatus(HashMap<String, Object> map) throws Exception;
	/**
	 * 修改、保存 支付信息
	 * @param map
	 * @return
	 * @throws Exception
	 * map.put("payType",payType);type参数取值详见CmsOrder
	 * map.put("payTime",payTime);
	 * map.put("payId",payId);
	 * List<String> list = new ArrayList<String>()
	 * list.add(orderId);
	 * map.put("orderIds",list);
	 */
	public int updatePayInfo(HashMap<String, Object> map) throws Exception;
	/**
	 * 修改、保存快递物流信息
	 * @param map
	 * @return
	 * @throws Exception
	 * map.put("emsType",emsType);type参数取值详见CmsOrder
	 * map.put("emsId",emsId);
	 * map.put("emsPrice",emsPrice);
	 * List<String> list = new ArrayList<String>()
	 * list.add(orderId);
	 * map.put("orderIds",list);
	 */
	public int updateEmsInfo(HashMap<String, Object> map) throws Exception;
	/**
	 * 修改、保存订单完成时间
	 * @param map
	 * @return
	 * @throws Exception
	 * map.put("endTime",endTime);
	 * List<String> list = new ArrayList<String>()
	 * list.add(orderId);
	 * map.put("orderIds",list);
	 */
	public int updateEndInfo(HashMap<String, Object> map) throws Exception;
	
	/**
	 * 卖家修改订单总金额
	 * @param map
	 * @return
	 * @throws Exception
	 * map.put("discountRemark",discountRemark);
	 * map.put("totalPrice",totalPrice);
	 * map.put("orderId",orderId);
	 */
	public int updateTotalPrice(HashMap<String, Object> map) throws Exception;
	/**
	 * 更新订单退款状态
	 * @param map
	 * @return
	 * @throws Exception
	 * map.put("refundStatus",refundStatus);
	 * map.put("orderId",orderId);
	 */
	public int updateRefund(HashMap<String, Object> map) throws Exception;
	/**
	 * 更新订单评价状态
	 * @param map
	 * @return
	 * @throws Exception
	 * map.put("reviewsStatus",reviewsStatus);
	 * map.put("orderId",orderId);
	 */
	public int updateReviews(HashMap<String, Object> map) throws Exception;
	/**
	 * 更新订单详情退款信息
	 * @param map
	 * @return
	 * @throws Exception
	 * map.put("refundStatus",refundStatus);
	 * map.put("refundQuantity",refundQuantity);
	 * map.put("refundPrice",refundPrice);
	 * map.put("itemId",itemId);
	 */
	public int updateOrderItemRefund(HashMap<String,Object> map) throws Exception;
	/**
	 * 更新订单详细评价状态
	 * @param map
	 * @return
	 * @throws Exception
	 * map.put("reviewsStatus",reviewsStatus);
	 * map.put("itemId",itemId);
	 */
	public int updateOrderItemReviews(HashMap<String,Object> map) throws Exception;
	/**
	 * 修改，保存订单详情的价格
	 * @param map
	 * @return
	 * @throws Exception
	 * map.put("discount",discount);
	 * map.put("total",total);
	 * map.put("realTotal",realTotal);
	 * map.put("itemId",itemId);
	 */
	public int updateOrderItemPrice(HashMap<String,Object> map) throws Exception;
	/**
	 * 批量删除订单明细
	 * @param map
	 * @return
	 * @throws Exception
	 * List<String> list=new ArrayList<String>();
	 * HashMap<String,Object> map = new HashMap<String,Object>();
	 * map.put("list",list);
	 */
	public int deleteOrderItem(HashMap<String,Object> map) throws Exception;
	/**
	 * 批量保存订单明细信息
	 * @param map
	 * @return
	 * @throws Exception
	 * List<CmsOrderItem> list= new ArrayList<CmsOrderItem>();
	 * HashMap<String,Object> map = new HashMap<String,Object>();
	 * map.put("list",list);
	 */
	public int insertOrderItem(HashMap<String,Object> map) throws Exception;
}
