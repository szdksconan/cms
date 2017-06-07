package com.cms.elasticsearch.produce.index;

import java.util.List;

import com.cms.model.maoyi.CmsProduct;
import com.cms.model.maoyi.EnterpriseInfo;

public interface IIndexOfProduceService {
	
	/**
	 * 索引单个商品信息
	 * @param p 商品信息
	 * @param e 商品所属店铺信息
	 * @return SUCCESS 成功，否则返回错误消息
	 * @throws RuntimeException
	 */
	public String indexProduce(CmsProduct p, EnterpriseInfo e) throws RuntimeException;
	
	/**
	 * 批量索引一个店铺的商品信息
	 * @param ps 商品信息列表
	 * @param e 商品所属店铺信息
	 * @return SUCCESS 成功，否则返回错误消息
	 * @throws RuntimeException
	 */
	public String bulkIndexProduces(List<CmsProduct> ps, EnterpriseInfo e) throws RuntimeException;
	
	/**
	 * 索引单个公司信息
	 * @param p 公司信息
	 * @return SUCCESS 成功，否则返回错误消息
	 * @throws RuntimeException
	 */
	public String indexEnterprise(EnterpriseInfo p) throws RuntimeException;
	
	/**
	 * 批量索引公司信息
	 * @param ps 公司信息列表
	 * @return SUCCESS 成功，否则返回错误消息
	 * @throws RuntimeException
	 */
	public String bulkIndexEnterprises(List<EnterpriseInfo> ps) throws RuntimeException;
	
	/**
	 * 删除商铺信息记录
	 * @param prodId 商品ID
	 * @param enterpiseId 所属店铺ID
	 * @return -1:enterpiseId为空；-2：商铺下还有商品信息；1：成功；0：删除失败
	 * @throws RuntimeException
	 */
	public int deleteDocOfEnterprise(String enterpiseId) throws RuntimeException;
	
	/**
	 * 删除商品信息记录
	 * @param prodId 商品ID
	 * @param enterpiseId 所属店铺ID
	 * @throws RuntimeException
	 */
	public void deleteDocOfProduce(String prodId, String enterpiseId) throws RuntimeException;
	
}
