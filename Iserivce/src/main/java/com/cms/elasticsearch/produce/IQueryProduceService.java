package com.cms.elasticsearch.produce;

import com.cms.model.elasticsearch.cm.PageProduce;

public interface IQueryProduceService {

	/**
	 * 根据查询条件搜索商品(父子关联查询)
	 * @param param
	 * @param geoPoint 用户所在经纬度（"19.021,128.328"）("经度","纬度")
	 * @param distanceLimit 查询距离参考值
	 * @param areaId 区域ID数组
	 * @param industryId 行业ID，可为前缀
	 * @param start 开始行数(从0开始)
	 * @param pageSize 每页记录数
	 * @return PageProduce
	 * @throws RuntimeException
	 */
	public PageProduce queryProducesByPC(String param, String geoPoint, Double distanceLimit,
			String[] areaId,String industryId, Integer start, Integer pageSize)
			throws RuntimeException;
}
