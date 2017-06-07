package com.cms.mapper.maoyi;

import java.math.BigDecimal;

import com.cms.model.maoyi.UserEnter;

public interface UserEnterMapper {
	/**
	 * 
	 * @param 用户id
	 * @return 企业id
	 */
   Long getEnterId(Long id);   
}