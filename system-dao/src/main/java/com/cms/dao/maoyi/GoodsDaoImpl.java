package com.cms.dao.maoyi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cms.mapper.maoyi.GoodsMapper;
import com.cms.model.maoyi.CmsGoods;

@Component
public class GoodsDaoImpl implements GoodsDao {
	@Autowired
	private GoodsMapper goodsMapper;

	public int insert(CmsGoods cg) throws Exception{
		// TODO Auto-generated method stub
		return goodsMapper.insert(cg);
	}

	public List<CmsGoods> getGoodsList(CmsGoods cg) throws Exception{
		// TODO Auto-generated method stub
		return goodsMapper.getGoodsList(cg);
	}

	public CmsGoods selectGoodsInfoById(String id) throws Exception{
		// TODO Auto-generated method stub
		return goodsMapper.selectGoodsInfoById(id);
	}	
	

}
