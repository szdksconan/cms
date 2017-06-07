package com.cms.mapper.xiaofei;

import com.cms.model.xiaofei.CmsXProduceCollect;
import java.math.BigDecimal;

public interface CmsXProduceCollectMapper {
    
	/**
	 * 添加商品到收藏
	 * 作者： 郑泽
	 * 日期：2016年5月13日
	 * @param cmsXProduceCollect
	 */
    public void addGoodsToCollect(CmsXProduceCollect cmsXProduceCollect);

}