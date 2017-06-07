package com.cms.iservice.maoyi;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cms.model.maoyi.CmsProduct;
import com.cms.model.maoyi.CmsProductPoint;
import com.cms.model.maoyi.CmsSellRule;
import com.cms.model.shengchang.MainProductOutBean;

/**
 * 商品中心接口
 * 
 * @author My
 *
 */
public interface ProductCenterService {
	/**
	 * 对生产方推送过来的产品入库
	 * 
	 * @param mp
	 * @return
	 */
	public int insert(HashMap<String,MainProductOutBean> map);

	/**
	 *  ****此方法已废弃****
	 * 根据产品id获取产品的详情
	 * 
	 * @param id
	 * @return
	 */
	public CmsProduct selectByPrimaryKey(String id);

	/**
	 * 根据贸易商id获取旗下所有商品,如果传入贸易商id为null，则获取所有的商品列表
	 * 
	 * @param enterpriceId
	 * @return
	 */
	public List<CmsProduct> selectEntProduct(HashMap<String,String> map);

	/**
	 * 查询产品id获取产品详细信息，包括产品图片和产品属性
	 * 
	 * @param productId
	 * @return
	 */
	public CmsProduct selectProductInfoById(String productId);
	/**
	 * 更新产品的上架下架删除操作。
	 * 
	 * @param map
	 *            map("record_state",int) map("productIds",List<productId>)
	 */
	public void updateSellStatus(HashMap<String, Object> map);

	/**
	 * 根据贸易商id返回产品列表，传入为空时返回所有产品列表
	 * @param cp :productId or enterpriceId
	 * @return
	 * HashMap<String,CmsProduct> cmsProduct= new HashMap<String,CmsProduct>();
	 * CmsProduct cp = new CmsProduct();
	 * cp.setEnterpriceId("你要查询的id");
	 * cmsProduct.put("cmsProduct",cp);
	 */
	public List<CmsProduct> selectProductList(HashMap<String,CmsProduct> cmsProduct);
	/**
	 * 根据产品id查询库存数量，价格等
	 * @param productId
	 * @return
	 */
	public List<CmsProductPoint> getStockPriceBypid(List<String> productIds);
	/**
	 * 设置世界名品
	 * @param map
	 * @return 1表示成功；0表示失败
	 * @throws Exception
	 * List<String> list = new ArrayList<String>();
	 * map.put("list",list);list存产品id
	 * map.put("isFamousBrand","0/1");0:不是世界名品；1：是世界名品  *必填字段
	 * map.put("brandId",brandId);按品牌设置所有商品
	 * map.put("enterpriceId",enterpriceId);贸易商id，*必填字段
	 */
	public int updateIsFamousBrand(HashMap<String,Object> map) throws Exception;
	/**
	 * 获取贸易商名下名品数量
	 * @param enterpriceId
	 * @return
	 * @throws Exception
	 * map.put("enterpriceId",enterpriceId);贸易商id，*必填字段
	 */
	public int getFamousBrandCount(HashMap<String,Object> map) throws Exception;
	/**
	 * 根据goodsId获取商品在不同销售规则下的销售价格
	 * @param map
	 * @return
	 * @throws Exception
	 * map.put("goodsId",goodsId);
	 */
	public List<CmsSellRule> getSellRuleByGoodsId(HashMap<String,Object> map) throws Exception;
	/**
	 * 更新库存信息
	 * @param map
	 * @throws Exception
	 * map.put("entId",entId);
	 * map.put("productId",productId);
	 * map.put("pointId",pointId);
	 * map.put("total",total);
	 */
	public void updateStock(HashMap<String,Object> map) throws Exception;
}
