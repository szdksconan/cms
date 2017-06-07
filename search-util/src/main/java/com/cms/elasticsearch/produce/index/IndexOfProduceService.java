package com.cms.elasticsearch.produce.index;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.elasticsearch.action.ShardOperationFailedException;
import org.elasticsearch.action.bulk.BulkItemResponse;
import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.count.CountRequestBuilder;
import org.elasticsearch.action.count.CountResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.deletebyquery.DeleteByQueryAction;
import org.elasticsearch.action.deletebyquery.DeleteByQueryRequestBuilder;
import org.elasticsearch.action.deletebyquery.DeleteByQueryResponse;
import org.elasticsearch.action.index.IndexRequestBuilder;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.client.Client;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.cms.model.elasticsearch.cm.CmsProduceEs;
import com.cms.model.elasticsearch.cm.EnterpriseInfoEs;
import com.cms.model.maoyi.CmsImages;
import com.cms.model.maoyi.CmsProduct;
import com.cms.model.maoyi.EnterpriseInfo;

@Service("indexOfProduceService")
public class IndexOfProduceService implements IIndexOfProduceService {
	final static Logger logger = LoggerFactory.getLogger(IndexOfProduceService.class);
	
	@Autowired
	private Client esClient;
	private final String PRODUCE_INDEX = "cmsproduces";
	private final String PRODUCE_TYPE = "cmsproduct";
	private final String ENTERPRISE_TYPE = "enterpriseinfo";
	
	private static String JDBC_URL = "jdbc:mysql://192.168.2.214:3306/cms_maoyi";
	private static String USERNAME = "root";
	private static String PASSWORD = "cms1505";
	
	/**
	 * 批量索引一个店铺的商品信息
	 * @param ps 商品信息列表
	 * @param e 商品所属店铺信息
	 * @return SUCCESS 成功，否则返回错误消息
	 * @throws RuntimeException
	 */
	public String bulkIndexProduces(List<CmsProduct> ps, EnterpriseInfo e) throws RuntimeException {
		
		//1、得到实体对象(从数据库查询)		
		ps = this.getProducesFromDB();
		List<EnterpriseInfo> es = this.getCompanysFromDB("952719890107511324"); //"952719890107511324"
		if (es!=null && es.size()>0)
			e = es.get(0);
		
		if (ps==null || ps.size()==0)
			return "没有找到相关产品信息";
		if (e==null)
			return "商品所属店铺信息为空";
		List<CmsProduceEs> pse = new ArrayList<CmsProduceEs>();
		for(CmsProduct p: ps){
			CmsProduceEs pe = new CmsProduceEs();
			pe.setBrandId(p.getBrandId());
			pe.setBrandName(p.getBrandName());
			pe.setEnterpriceId(p.getEnterpriceId());
			pe.setEnterpriceName(p.getEnterpriceName());
			//得到企业信息
			//getEnterpriceById(id);
			EnterpriseInfoEs ee = new EnterpriseInfoEs();
			ee.setId(e.getId().toString());
			ee.setName(e.getName());
			ee.setRegAddAc(e.getRegAddAc());
			ee.setRegAddAn(e.getRegAddAn());
			try {
				if (e.getRegAddAl()!=null && "".equals(e.getRegAddAl()))
					ee.setRegAddAl(e.getRegAddAl());
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				logger.info(e1.getMessage());
			}
			ee.setWebSite(e.getWebSite());
			ee.setLogoPath(e.getLogoPath());
			ee.setEnterpriseType(e.getEnterpriseType());
			ee.setLegalPerson(e.getLegalPerson());
			ee.setPartner(e.getPartner());
			try {
				if (e.getSetTime()!=null && "".equals(e.getSetTime())){
					SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					ee.setSetTime(format.parse(e.getSetTime()));
				}
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				logger.info(e1.getMessage());
			}
			ee.setRegisterCapital(e.getRegisterCapital());
			ee.setManageScale(e.getManageScale());
			ee.setContactPerson(e.getContactPerson());
			ee.setContactTel(e.getContactTel());
			ee.setContactPhone(e.getContactPhone());
			ee.setPostcode(e.getPostcode());
			ee.setEmail(e.getEmail());
			ee.setPlatformCode(e.getPlatformCode());
			ee.setQq(e.getQq());
			ee.setBriefIntroduction(e.getBriefIntroduction());
			ee.setBusinessScope(e.getBusinessScope());
			ee.setBusinessIndustry(e.getBusinessIndustry());
			ee.setProduct(e.getProduct());
			ee.setRecordState(e.getRecordState());
			ee.setCheckState(e.getCheckState());
			ee.setFromType(e.getFromType());
			ee.setRegisterDetail(e.getRegisterDetail());
			ee.setManaAddAc(e.getManaAddAc());
			ee.setManaAddAn(e.getManaAddAn());
			ee.setManageDetail(e.getManageDetail());
			try {
				if (e.getManaAddAl()!=null && "".equals(e.getManaAddAl()))
					ee.setManaAddAl(e.getManaAddAl());
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				logger.info(e1.getMessage());
			}
			ee.setBarcodePath(e.getBarcodePath());
			ee.setDevelopWill(e.getDevelopWill());
			ee.setJoinWill(e.getJoinWill());
			
			pe.setEnterpriseinfo(ee);
			pe.setGoodsId(p.getGoodsId());
			pe.setKindId(p.getKindId());
			pe.setKindName(p.getKindName());
			if (p.getListedTime()!=null){
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");				
				pe.setListedTime(format.format(p.getListedTime()));
			}
			pe.setOemId(p.getOemId());
			pe.setOemName(p.getOemName());
			pe.setProductBarCode(p.getProductBarCode());
			pe.setProductCode(p.getProductCode());
			if (p.getProductCreateTime()!=null){
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				//String d = format.format(p.getProductCreateTime());
				pe.setProductCreateTime(format.format(p.getProductCreateTime()));
			}
			pe.setProductCreator(p.getProductCreator());
			pe.setProductDetail(p.getProductDetail());
			pe.setProductGW(new Double(p.getProductGW()));
			pe.setProductId(p.getProductId());
			pe.setProductIntroduction(p.getProductIntroduction());
			/*String logo = getProduceLogoPath(p); //得到图片缩略图
			if (logo!=null)
				pe.setProductMainImg(logo);*/
			pe.setProductMainImg(p.getProductMainImg());
			pe.setProductNameCn(p.getProductNameCn());
			pe.setProductNameEn(p.getProductNameEn());
			pe.setProductPackageSize(p.getProductPackageSize());
			pe.setProductPlace(p.getProductPlace());
			if (p.getProductPrice()!=null)
				pe.setProductPrice(p.getProductPrice().doubleValue());
			pe.setProductPromulgator(p.getProductPromulgator());
			
			if (p.getProductReleaseTime()!=null){
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				//String d = format.format(p.getProductReleaseTime());
				pe.setProductReleaseTime(format.format(p.getProductReleaseTime()));
			}
			pe.setProductSales(new Double(p.getProductSales()));
			pe.setProductStatus(p.getProductStatus());
			pe.setProductTotalStock(new Double(p.getProductTotalStock()));
			pe.setRecordState(p.getRecordState());
			pe.setStockAddress(p.getStockAddress());
			pe.setUnit(p.getUnit());
			
			pse.add(pe);
		}
		//批量插入
		BulkRequestBuilder br = esClient.prepareBulk();
		for (CmsProduceEs pes: pse){
			br.add(esClient.prepareIndex(this.PRODUCE_INDEX, this.PRODUCE_TYPE)
					.setId(pes.getProductId().toString())
					.setParent(pes.getEnterpriceId()+"")
					.setSource(JSONObject.toJSONString(pes)));
		}
		
		/**---------------同步处理--------------------------------**/
		/**/
		BulkResponse bres;
		try {
			bres = br.get();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			logger.info(e1.getMessage());
			throw new RuntimeException(e1);
		}
		
		//异常处理
		if (bres.hasFailures()){
			BulkItemResponse[] itmRes = bres.getItems();
			for (BulkItemResponse itm: itmRes){
				logger.info(itm.getFailureMessage());
			}
			throw new RuntimeException(bres.buildFailureMessage());
		}else{
			return "SUCCESS";
		}
		
		/**---------------同步处理end--------------------------------**/
		
		/**---------------异步处理--------------------------------**/
		/*
		ListenableActionFuture<BulkResponse> future = br.execute();
		future.addListener(new ActionListener<BulkResponse>(){
			//@Override
			public void onResponse(BulkResponse response){
				for(BulkItemResponse resItm :response.getItems()){
					if (!resItm.isFailed()){
						logger.info("index={},type={},id={} index success!"
								,resItm.getIndex()
								,resItm.getType()
								,resItm.getId());
					}else{
						logger.info("index={},type={},id={} index failure, failure message:{}"
								,resItm.getIndex()
								,resItm.getType()
								,resItm.getId()
								,resItm.getFailureMessage());
					}
				}
			}
			
			//@Override
			public void onFailure(Throwable e){
				throw new RuntimeException(e);
			}
		});
		*/
		/**---------------异步处理end--------------------------------**/
	}
	
	/**
	 * 索引单个商品信息
	 * @param p 商品信息
	 * @param e 商品所属店铺信息
	 * @return SUCCESS 成功，否则返回错误消息
	 * @throws RuntimeException
	 */
	public String indexProduce(CmsProduct p, EnterpriseInfo e) throws RuntimeException {
		if (p==null)
			return "产品信息为空";
		if (e==null)
			return "商品所属店铺信息为空";
		CmsProduceEs pe = new CmsProduceEs();
		pe.setBrandId(p.getBrandId());
		pe.setBrandName(p.getBrandName());
		pe.setEnterpriceId(p.getEnterpriceId());
		pe.setEnterpriceName(p.getEnterpriceName());
		//得到企业信息
		//getEnterpriceById(id);
		EnterpriseInfoEs ee = new EnterpriseInfoEs();
		ee.setId(e.getId().toString());
		ee.setName(e.getName());
		ee.setRegAddAc(e.getRegAddAc());
		ee.setRegAddAn(e.getRegAddAn());
		try {
			if (e.getRegAddAl()!=null && "".equals(e.getRegAddAl()))
				ee.setRegAddAl(e.getRegAddAl());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			logger.info(e1.getMessage());
		}
		ee.setWebSite(e.getWebSite());
		ee.setLogoPath(e.getLogoPath());
		ee.setEnterpriseType(e.getEnterpriseType());
		ee.setLegalPerson(e.getLegalPerson());
		ee.setPartner(e.getPartner());
		try {
			if (e.getSetTime()!=null && "".equals(e.getSetTime())){
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				ee.setSetTime(format.parse(e.getSetTime()));
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			logger.info(e1.getMessage());
		}
		ee.setRegisterCapital(e.getRegisterCapital());
		ee.setManageScale(e.getManageScale());
		ee.setContactPerson(e.getContactPerson());
		ee.setContactTel(e.getContactTel());
		ee.setContactPhone(e.getContactPhone());
		ee.setPostcode(e.getPostcode());
		ee.setEmail(e.getEmail());
		ee.setPlatformCode(e.getPlatformCode());
		ee.setQq(e.getQq());
		ee.setBriefIntroduction(e.getBriefIntroduction());
		ee.setBusinessScope(e.getBusinessScope());
		ee.setBusinessIndustry(e.getBusinessIndustry());
		ee.setProduct(e.getProduct());
		ee.setRecordState(e.getRecordState());
		ee.setCheckState(e.getCheckState());
		ee.setFromType(e.getFromType());
		ee.setRegisterDetail(e.getRegisterDetail());
		ee.setManaAddAc(e.getManaAddAc());
		ee.setManaAddAn(e.getManaAddAn());
		ee.setManageDetail(e.getManageDetail());
		try {
			if (e.getManaAddAl()!=null && "".equals(e.getManaAddAl()))
				ee.setManaAddAl(e.getManaAddAl());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			logger.info(e1.getMessage());
		}
		ee.setBarcodePath(e.getBarcodePath());
		ee.setDevelopWill(e.getDevelopWill());
		ee.setJoinWill(e.getJoinWill());
		
		pe.setEnterpriseinfo(ee);
		
		pe.setGoodsId(p.getGoodsId());
		pe.setKindId(p.getKindId());
		pe.setKindName(p.getKindName());
		if (p.getProductCreateTime()!=null){
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			//String d = format.format(p.getProductCreateTime());
			pe.setProductCreateTime(format.format(p.getProductCreateTime()));
		}
		pe.setOemId(p.getOemId());
		pe.setOemName(p.getOemName());
		pe.setProductBarCode(p.getProductBarCode());
		pe.setProductCode(p.getProductCode());
		if (p.getProductCreateTime()!=null){
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			//String d = format.format(p.getProductCreateTime());
			pe.setProductCreateTime(format.format(p.getProductCreateTime()));
		}
		pe.setProductCreator(p.getProductCreator());
		pe.setProductDetail(p.getProductDetail());
		pe.setProductGW(new Double(p.getProductGW()));
		pe.setProductId(p.getProductId());
		pe.setProductIntroduction(p.getProductIntroduction());
		/*String logo = getProduceLogoPath(p); //得到图片缩略图
		if (logo!=null)
			pe.setProductMainImg(logo);*/
		pe.setProductMainImg(p.getProductMainImg());
		pe.setProductNameCn(p.getProductNameCn());
		pe.setProductNameEn(p.getProductNameEn());
		pe.setProductPackageSize(p.getProductPackageSize());
		pe.setProductPlace(p.getProductPlace());
		if (p.getProductPrice()!=null)
			pe.setProductPrice(p.getProductPrice().doubleValue());
		pe.setProductPromulgator(p.getProductPromulgator());
		if (p.getProductReleaseTime()!=null){
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			//String d = format.format(p.getProductReleaseTime());
			pe.setProductReleaseTime(format.format(p.getProductReleaseTime()));
		}
		pe.setProductSales(new Double(p.getProductSales()));
		pe.setProductStatus(p.getProductStatus());
		pe.setProductTotalStock(new Double(p.getProductTotalStock()));
		pe.setRecordState(p.getRecordState());
		pe.setStockAddress(p.getStockAddress());
		pe.setUnit(p.getUnit());
		
		//索引
		IndexRequestBuilder br = esClient.prepareIndex(this.PRODUCE_INDEX, this.PRODUCE_TYPE)
				.setId(pe.getProductId().toString())
				.setParent(pe.getEnterpriceId()+"")
				.setSource(JSONObject.toJSONString(p));
		
		/**---------------同步处理--------------------------------**/
		IndexResponse bres;
		try {
			bres = br.get();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			logger.info(e1.getMessage());
			throw new RuntimeException(e1);
		}
		
		//异常处理
		if (! bres.isCreated()){
			return "FAIL";
		}else{
			return "SUCCESS";
		}
		
		/**---------------同步处理end--------------------------------**/
	}
	
	/**
	 * 得到图片缩略图路径
	 * @param p
	 * @return
	 */
	private String getProduceLogoPath(CmsProduct p){
		if (p==null || p.getCmsImages()==null || p.getCmsImages().size()==0)
			return null;
		String logo = null;
		for(CmsImages ci: p.getCmsImages()){
			if (ci.getImgType()!=1)
				continue;
			logo = ci.getImgUrl();
			break;
		}
		return logo;
	}
	
	/**
	 * 批量索引公司信息
	 * @param ps 公司信息列表
	 * @return SUCCESS 成功，否则返回错误消息
	 * @throws RuntimeException
	 */
	public String bulkIndexEnterprises(List<EnterpriseInfo> ps) throws RuntimeException {
		
		//1、得到实体对象(从数据库查询)
		ps = this.getCompanysFromDB(null);
		
		if (ps==null || ps.size()==0)
			return "没有找到相关公司信息";
		List<EnterpriseInfoEs> ees = new ArrayList<EnterpriseInfoEs>();
		for (EnterpriseInfo e: ps){
			EnterpriseInfoEs ee = new EnterpriseInfoEs();
			ee.setId(e.getId().toString());
			ee.setName(e.getName());
			ee.setRegAddAc(e.getRegAddAc());
			ee.setRegAddAn(e.getRegAddAn());
			try {
				if (e.getRegAddAl()!=null && "".equals(e.getRegAddAl()))
					ee.setRegAddAl(e.getRegAddAl());
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				logger.info(e1.getMessage());
			}
			ee.setWebSite(e.getWebSite());
			ee.setLogoPath(e.getLogoPath());
			ee.setEnterpriseType(e.getEnterpriseType());
			ee.setLegalPerson(e.getLegalPerson());
			ee.setPartner(e.getPartner());
			try {
				if (e.getSetTime()!=null && "".equals(e.getSetTime())){
					SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					ee.setSetTime(format.parse(e.getSetTime()));
				}
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				logger.info(e1.getMessage());
			}
			ee.setRegisterCapital(e.getRegisterCapital());
			ee.setManageScale(e.getManageScale());
			ee.setContactPerson(e.getContactPerson());
			ee.setContactTel(e.getContactTel());
			ee.setContactPhone(e.getContactPhone());
			ee.setPostcode(e.getPostcode());
			ee.setEmail(e.getEmail());
			ee.setPlatformCode(e.getPlatformCode());
			ee.setQq(e.getQq());
			ee.setBriefIntroduction(e.getBriefIntroduction());
			ee.setBusinessScope(e.getBusinessScope());
			ee.setBusinessIndustry(e.getBusinessIndustry());
			ee.setProduct(e.getProduct());
			ee.setRecordState(e.getRecordState());
			ee.setCheckState(e.getCheckState());
			ee.setFromType(e.getFromType());
			ee.setRegisterDetail(e.getRegisterDetail());
			ee.setManaAddAc(e.getManaAddAc());
			ee.setManaAddAn(e.getManaAddAn());
			ee.setManageDetail(e.getManageDetail());
			try {
				if (e.getManaAddAl()!=null && "".equals(e.getManaAddAl()))
					ee.setManaAddAl(e.getManaAddAl());
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				logger.info(e1.getMessage());
			}
			ee.setBarcodePath(e.getBarcodePath());
			ee.setDevelopWill(e.getDevelopWill());
			ee.setJoinWill(e.getJoinWill());
			
			ees.add(ee);
		}
		//批量插入
		BulkRequestBuilder br = esClient.prepareBulk();
		for (EnterpriseInfoEs pes: ees){
			br.add(esClient.prepareIndex(this.PRODUCE_INDEX, this.ENTERPRISE_TYPE)
					.setId(pes.getId().toString())
					.setSource(JSONObject.toJSONString(pes)));
		}
		
		/**---------------同步处理--------------------------------**/
		/**/
		BulkResponse bres;
		try {
			bres = br.get();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.info(e.getMessage());
			throw new RuntimeException(e);
		}
		
		//异常处理
		if (bres.hasFailures()){
			BulkItemResponse[] itmRes = bres.getItems();
			for (BulkItemResponse itm: itmRes){
				logger.info(itm.getFailureMessage());
			}
			throw new RuntimeException(bres.buildFailureMessage());
		}else{
			return "SUCCESS";
		}
		
		/**---------------同步处理end--------------------------------**/
		
		/**---------------异步处理--------------------------------**/
		/*
		ListenableActionFuture<BulkResponse> future = br.execute();
		future.addListener(new ActionListener<BulkResponse>(){
			//@Override
			public void onResponse(BulkResponse response){
				for(BulkItemResponse resItm :response.getItems()){
					if (!resItm.isFailed()){
						logger.info("index={},type={},id={} index success!"
								,resItm.getIndex()
								,resItm.getType()
								,resItm.getId());
					}else{
						logger.info("index={},type={},id={} index failure, failure message:{}"
								,resItm.getIndex()
								,resItm.getType()
								,resItm.getId()
								,resItm.getFailureMessage());
					}
				}
			}
			
			//@Override
			public void onFailure(Throwable e){
				throw new RuntimeException(e);
			}
		});
		*/
		/**---------------异步处理end--------------------------------**/
	}
	
	/**
	 * 索引单个公司信息
	 * @param p 公司信息
	 * @return SUCCESS 成功，否则返回错误消息
	 * @throws RuntimeException
	 */
	public String indexEnterprise(EnterpriseInfo e) throws RuntimeException {
		if (e==null)
			return "公司信息为空";
		EnterpriseInfoEs ee = new EnterpriseInfoEs();
		ee.setId(e.getId().toString());
		ee.setName(e.getName());
		ee.setRegAddAc(e.getRegAddAc());
		ee.setRegAddAn(e.getRegAddAn());
		try {
			if (e.getRegAddAl()!=null && "".equals(e.getRegAddAl()))
				ee.setRegAddAl(e.getRegAddAl());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			logger.info(e1.getMessage());
		}
		ee.setWebSite(e.getWebSite());
		ee.setLogoPath(e.getLogoPath());
		ee.setEnterpriseType(e.getEnterpriseType());
		ee.setLegalPerson(e.getLegalPerson());
		ee.setPartner(e.getPartner());
		try {
			if (e.getSetTime()!=null && "".equals(e.getSetTime())){
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				ee.setSetTime(format.parse(e.getSetTime()));
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			logger.info(e1.getMessage());
		}
		ee.setRegisterCapital(e.getRegisterCapital());
		ee.setManageScale(e.getManageScale());
		ee.setContactPerson(e.getContactPerson());
		ee.setContactTel(e.getContactTel());
		ee.setContactPhone(e.getContactPhone());
		ee.setPostcode(e.getPostcode());
		ee.setEmail(e.getEmail());
		ee.setPlatformCode(e.getPlatformCode());
		ee.setQq(e.getQq());
		ee.setBriefIntroduction(e.getBriefIntroduction());
		ee.setBusinessScope(e.getBusinessScope());
		ee.setBusinessIndustry(e.getBusinessIndustry());
		ee.setProduct(e.getProduct());
		ee.setRecordState(e.getRecordState());
		ee.setCheckState(e.getCheckState());
		ee.setFromType(e.getFromType());
		ee.setRegisterDetail(e.getRegisterDetail());
		ee.setManaAddAc(e.getManaAddAc());
		ee.setManaAddAn(e.getManaAddAn());
		ee.setManageDetail(e.getManageDetail());
		try {
			if (e.getManaAddAl()!=null && "".equals(e.getManaAddAl()))
				ee.setManaAddAl(e.getManaAddAl());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			logger.info(e1.getMessage());
		}
		ee.setBarcodePath(e.getBarcodePath());
		ee.setDevelopWill(e.getDevelopWill());
		ee.setJoinWill(e.getJoinWill());
		
		//批量插入
		IndexRequestBuilder br = esClient.prepareIndex(this.PRODUCE_INDEX, this.ENTERPRISE_TYPE)
				.setId(e.getId().toString())
				.setSource(JSONObject.toJSONString(e));
		
		/**---------------同步处理--------------------------------**/
		IndexResponse bres;
		try {
			bres = br.get();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			logger.info(e1.getMessage());
			throw new RuntimeException(e1);
		}
		
		//异常处理
		if (! bres.isCreated()){
			return "FAIL";
		}else{
			return "SUCCESS";
		}
		
		/**---------------同步处理end--------------------------------**/
	}
		
	/**
	 * 更新索引信息
	 * @param o
	 * @param index
	 * @param type
	 * @param id
	 * @throws RuntimeException
	 */
	private void updateDoc(Object o, String index, String type, String id) throws RuntimeException {
		UpdateRequest updateRequest = new UpdateRequest()
				.index(index)
				.type(type)
				.id(id);
		updateRequest.doc(JSONObject.toJSONString(o));
		
		try {
			esClient.update(updateRequest).get();
		} catch (InterruptedException e) {
			e.printStackTrace();
			logger.info(e.getMessage());
			throw new RuntimeException("更新索引出错：InterruptedException");
		} catch (ExecutionException e) {
			e.printStackTrace();
			logger.info(e.getMessage());
			throw new RuntimeException("更新索引出错：ExecutionException");
		}
	}

	/**
	 * 删除商品信息记录
	 * @param prodId 商品ID
	 * @param enterpiseId 所属店铺ID
	 * @throws RuntimeException
	 */
	public void deleteDocOfProduce(String prodId, String enterpiseId) throws RuntimeException {
		if (prodId==null || "".equals(prodId))
			throw new RuntimeException("商品ID为空！");
		if (enterpiseId==null || "".equals(enterpiseId))
			throw new RuntimeException("商铺ID为空！");
		DeleteRequest request = new DeleteRequest(this.PRODUCE_INDEX)
				.type(this.PRODUCE_TYPE)
				.id(prodId)
				.parent(enterpiseId);
		try {
			esClient.delete(request).get();
		} catch (InterruptedException e) {
			e.printStackTrace();
			e.printStackTrace();
			throw new RuntimeException(e);
		} catch (ExecutionException e) {
			e.printStackTrace();
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 批量清空店铺下的商品信息记录
	 * @param enterpiseId 所属店铺ID
	 * @return -1:删除时遇到错误；n：成功删除记录数
	 * @throws RuntimeException
	 */
	public Long deleteProduceInEnterprise(String enterpiseId) throws RuntimeException {
		if (enterpiseId==null || "".equals(enterpiseId))
			throw new RuntimeException("商铺ID为空！");
		
		try {
			DeleteByQueryResponse response = new DeleteByQueryRequestBuilder(esClient,DeleteByQueryAction.INSTANCE)
					.setIndices(this.PRODUCE_INDEX)
					.setTypes(this.PRODUCE_TYPE)
					.setQuery(QueryBuilders.termQuery("enterpriceId", enterpiseId))
					.setRouting(enterpiseId)
					.execute()
					.actionGet();
			if (response.getTotalFailed()<=0){
				return response.getTotalDeleted();
			}else{
				for(ShardOperationFailedException fe:response.getShardFailures())
					logger.info("deleteProduceInEnterprise:enterpiseId={},错误信息：{}",enterpiseId, fe.getCause().getMessage());
				return new Long(-1);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 删除商铺信息记录
	 * @param prodId 商品ID
	 * @param enterpiseId 所属店铺ID
	 * @return -1:enterpiseId为空；-2：商铺下还有商品信息；1：成功；0：删除失败
	 * @throws RuntimeException
	 */
	public int deleteDocOfEnterprise(String enterpiseId) throws RuntimeException {
		if (enterpiseId==null || "".equals(enterpiseId))
			return -1;
		Long prodCnt = getProduceCountInEnterprise(enterpiseId);
		if (prodCnt>0)
			return -2;
		DeleteRequest request = new DeleteRequest(this.PRODUCE_INDEX)
				.type(this.PRODUCE_TYPE)
				.id(enterpiseId);
		try {
			DeleteResponse dr = esClient.delete(request).get();
			if (dr.isFound())
				return 1;
			else 
				return 0;
		} catch (InterruptedException e) {
			e.printStackTrace();
			e.printStackTrace();
			throw new RuntimeException(e);
		} catch (ExecutionException e) {
			e.printStackTrace();
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	public Long getProduceCountInEnterprise(String enterpiseId) throws RuntimeException{
		if (enterpiseId==null || "".equals(enterpiseId))
			throw new RuntimeException("商铺ID为空！");
		QueryBuilder query = QueryBuilders.termQuery("enterpriceId", enterpiseId);
		CountRequestBuilder request = esClient.prepareCount(this.PRODUCE_INDEX)
				.setTypes(this.PRODUCE_TYPE)
				.setQuery(query);
		try {
			CountResponse response = (CountResponse)request.execute().actionGet();
			return response.getCount();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	/**/
	private List<CmsProduct> getProducesFromDB(){

		Connection conn = null;
		Statement statement = null;
		List<CmsProduct> ps = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(this.JDBC_URL,this.USERNAME,this.PASSWORD);
			statement = conn.createStatement();
			String sql = "select *"
					+" from cms_product_t_product p ";
			ResultSet rs = statement.executeQuery(sql);
			if (rs!=null){
				ps = new ArrayList<CmsProduct>();
				while(rs.next()){
					CmsProduct pe = new CmsProduct();
					pe.setBrandId(rs.getString("brandId"));
					pe.setBrandName(rs.getString("brandName"));
					pe.setEnterpriceId(rs.getString("enterpriceId"));
					pe.setEnterpriceName(rs.getString("enterpriceName"));
					pe.setGoodsId(rs.getString("goodsId"));
					pe.setKindId(rs.getString("kindId"));
					pe.setKindName(rs.getString("kindName"));
					if (rs.getDate("listedTime")!=null)
						pe.setListedTime(rs.getDate("listedTime"));
					pe.setOemId(rs.getString("oemId"));
					pe.setOemName(rs.getString("oemName"));
					pe.setProductBarCode(rs.getString("productBarCode"));
					pe.setProductCode(rs.getString("productCode"));
					if (rs.getDate("productCreateTime")!=null)
						pe.setProductCreateTime(rs.getDate("productCreateTime"));
					pe.setProductCreator(rs.getString("productCreator"));
					pe.setProductDetail(rs.getString("productDetail"));
					pe.setProductGW(rs.getInt("productGW"));
					pe.setProductId(rs.getString("productId"));
					pe.setProductIntroduction(rs.getString("productIntroduction"));
					pe.setProductMainImg(rs.getString("productMainImg"));
					pe.setProductNameCn(rs.getString("productNameCn"));
					pe.setProductNameEn(rs.getString("productNameEn"));
					pe.setProductPackageSize(rs.getString("productPackageSize"));
					pe.setProductPlace(rs.getString("productPlace"));
					pe.setProductPrice(rs.getBigDecimal("productPrice"));
					pe.setProductPromulgator(rs.getString("productPromulgator"));
					pe.setProductReleaseTime(rs.getDate("productReleaseTime"));
					pe.setProductSales(rs.getInt("productSales"));
					pe.setProductStatus(rs.getInt("productStatus"));
					pe.setProductTotalStock(rs.getInt("productTotalStock"));
					pe.setRecordState(rs.getString("record_State"));
					pe.setStockAddress(rs.getString("stockAddress"));
					pe.setUnit(rs.getString("unit"));
					
					ps.add(pe);
				}
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				if (conn!=null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return ps; 
	}
	
	private List<EnterpriseInfo> getCompanysFromDB(String id){

		Connection conn = null;
		Statement statement = null;
		List<EnterpriseInfo> companys = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(this.JDBC_URL,this.USERNAME,this.PASSWORD);
			statement = conn.createStatement();
			String sql = " select c.* "
					+" from Enterprise_Info c ";
			if (id!=null && !"".equals(id))
				sql +=" where id="+id;
			ResultSet rs = statement.executeQuery(sql);
			if (rs!=null){
				companys = new ArrayList<EnterpriseInfo>();
				while(rs.next()){
					EnterpriseInfo ee = new EnterpriseInfo();
					ee.setId(rs.getString("id"));
					ee.setName(rs.getString("name"));
					ee.setRegAddAc(rs.getString("reg_Add_Ac"));
					ee.setRegAddAn(rs.getString("reg_Add_An"));
					ee.setRegAddAl(rs.getString("reg_Add_Al"));
					ee.setWebSite(rs.getString("web_Site"));
					ee.setLogoPath(rs.getString("logo_Path"));
					ee.setEnterpriseType(rs.getString("enterprise_Type"));
					ee.setLegalPerson(rs.getString("legal_Person"));
					ee.setPartner(rs.getString("partner"));
					ee.setSetTime(rs.getString("set_Time"));
					ee.setRegisterCapital(rs.getString("register_Capital"));
					ee.setManageScale(rs.getString("manage_Scale"));
					ee.setContactPerson(rs.getString("contact_Person"));
					ee.setContactTel(rs.getString("contact_Tel"));
					ee.setContactPhone(rs.getString("contact_Phone"));
					ee.setPostcode(rs.getString("postcode"));
					ee.setEmail(rs.getString("email"));
					ee.setPlatformCode(rs.getString("platform_Code"));
					ee.setQq(rs.getString("qq"));
					ee.setBriefIntroduction(rs.getString("brief_Introduction"));
					ee.setBusinessScope(rs.getString("business_Scope"));
					ee.setBusinessIndustry(rs.getString("business_Industry"));
					ee.setProduct(rs.getString("product"));
					ee.setRecordState(rs.getInt("record_State"));
					ee.setCheckState(rs.getInt("check_State"));
					ee.setFromType(rs.getInt("from_Type"));
					ee.setRegisterDetail(rs.getString("register_Detail"));
					ee.setManaAddAc(rs.getString("mana_Add_Ac"));
					ee.setManaAddAn(rs.getString("mana_Add_An"));
					ee.setManageDetail(rs.getString("manage_Detail"));
					ee.setManaAddAl(rs.getString("mana_Add_Al"));
					ee.setBarcodePath(rs.getString("barcode_Path"));
					ee.setDevelopWill(rs.getString("develop_Will"));
					ee.setJoinWill(rs.getString("join_Will"));
					companys.add(ee);
				}
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				if (conn!=null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return companys; 
	}
	
	public static void main(String[] args){
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath*:META-INF/spring/elasticsearch-service-provider.xml");
		IIndexOfProduceService builder = (IIndexOfProduceService)context.getBean("indexOfProduceService");
		
		try {
			
			//builder.createIndexOfProduce();
			//builder.insertDocOfProduce();
			//builder.insertDocOfCompany();
			//builder.insertDocOfProduceHavNoCompany();
			
			builder.bulkIndexEnterprises(null);
			builder.bulkIndexProduces(null,null);
			//builder.deleteDocOfProduce("731034401760215041","952719890107511324");
			//builder.deleteDocOfProduce("731034401760215041","952719890107511324");
			//int r = builder.deleteDocOfEnterprise("952719890107511324");
			//long r = builder.deleteProduceInEnterprise("952719890107511324");
			
			
			/*
			Produce p = new Produce();
			p.setId(new Long(1));
			p.setMemo("修改测试");
			builder.updateDocOfProduce(p, "produces", "produce");;
			
			
			builder.deleteDocOfProduce("produces","produce","1");
			*/
			//System.out.println("OK!!!=="+r);
			System.out.println("OK!!!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
