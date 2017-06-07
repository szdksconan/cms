package com.cms.dao.maoyi.enterprise.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cms.dao.maoyi.enterprise.TradeImageDao;
import com.cms.mapper.maoyi.TradeImageMapper;
import com.cms.model.maoyi.TradeImage;

@Repository
public class TradeImageDaoImpl implements TradeImageDao {
	
	@Autowired
	private TradeImageMapper tradeImageMapper;

	public void addImage(TradeImage image) {
         tradeImageMapper.addImage(image);
	}
	public void deleteImage(Long id) {
		tradeImageMapper.deleteImage(id);
	}

}
