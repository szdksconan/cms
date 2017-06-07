package com.cms.mapper.maoyi;


import com.cms.model.maoyi.TradeImage;

public interface TradeImageMapper {
	//添加图片信息
   public void addImage(TradeImage image);
		
	//删除资质图片信息
   public void deleteImage(Long id);
}