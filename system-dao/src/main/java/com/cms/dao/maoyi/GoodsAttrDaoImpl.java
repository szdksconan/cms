package com.cms.dao.maoyi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cms.mapper.maoyi.GoodsAttrMapper;
import com.cms.model.maoyi.CmsGoodsAttr;

@Component
public class GoodsAttrDaoImpl implements GoodsAttrDao {
	@Autowired
	private GoodsAttrMapper goodsAttrMapper;



	public List<CmsGoodsAttr> getGoodsAttrValByGoodsId(String id) {
		// TODO Auto-generated method stub
		return goodsAttrMapper.getGoodsAttrValByGoodsId(id);
	}

}
