package com.cms.mapper.maoyi;

import com.cms.model.maoyi.OrderIncomingDetail;

public interface OrderIncomingDetailMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_incoming_detail
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_incoming_detail
     *
     * @mbggenerated
     */
    int insert(OrderIncomingDetail record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_incoming_detail
     *
     * @mbggenerated
     */
    int insertSelective(OrderIncomingDetail record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_incoming_detail
     *
     * @mbggenerated
     */
    OrderIncomingDetail selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_incoming_detail
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(OrderIncomingDetail record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_incoming_detail
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(OrderIncomingDetail record);
}