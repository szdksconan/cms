package com.cms.dao.xiaofei;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cms.mapper.xiaofei.CmsXProduceCollectMapper;
import com.cms.model.xiaofei.CmsXProduceCollect;
@Component
public class CmsXProduceCollectDaoImpl implements CmsXProduceCollectDao {
	@Autowired
	private CmsXProduceCollectMapper cmsXProduceCollectMapper;

	/**
	 * 添加商品到收藏
	 */
	public void addGoodsToCollect(CmsXProduceCollect cmsXProduceCollect) {
		// TODO Auto-generated method stub
		this.cmsXProduceCollectMapper.addGoodsToCollect(cmsXProduceCollect);
	}

}
