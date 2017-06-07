package com.cms.iservice.maoyi;

import java.util.List;

import com.cms.model.maoyi.CmsGoods;
/**
 * 商品中心接口
 * @author My
 *
 */
public interface GoodsCenterService {
	/**
	 * 根据id,公司id,品牌id，商品名称查询，
	 * @param cg
	 * @return 商品的list列表
	 */
	public  List<CmsGoods> getGoodsList(CmsGoods cg);
	/**
	 * 根据主营商品ID，查询主营商品详细信息
	 * @param id
	 * @return 主营商品；包括主营商品下的具体产品信息以及主营商品图片
	 */
	public CmsGoods selectGoodsInfoById(String id) throws Exception;
}
