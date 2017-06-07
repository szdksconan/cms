package com.cms.iservice.maoyi;

import java.util.List;
import java.util.Map;

import com.cms.model.maoyi.EnterpriseInfo;
import com.cms.model.maoyi.EnterpriseQualification;
import com.cms.model.maoyi.GoodsService;
import com.cms.model.maoyi.StorageService;

/**
 * @author penglei
 *
 * 2016年4月18日
 * 
 */
public interface EnterpriseInfoService {
	
	//基本信息相关业务
	public void addEnterpriseInfo(EnterpriseInfo enterpriseInfo);
	
	public void deleteEnterpriseInfo(Long id);
	
	public Map<String, Object> updateEnterpriseInfo(EnterpriseInfo enterpriseInfo);
	
	public EnterpriseInfo getEnterpriseInfo(Long id);
	
	//保存发展意向
	public void addDevelopWill(Long id,String  developWill);
	//保存合作意向
	public void addJoinWill(Long id,String joinWill);
	
	//资质信息相关业务
	public void deleteQualif(Long id);
	//拿到对应id的资质信息
	public EnterpriseQualification getQualif(Long id);

	public  void addQualif(EnterpriseQualification enterQualif);

	public  List<EnterpriseQualification> getAllQualif(Long id);

	public  void updateQualif(EnterpriseQualification enterQualif);
	
	//拿到所有的服务信息
    public List<GoodsService> getAllService(Long id);
    
    //保存服务信息
	public void addGoodsService(GoodsService goodsService);

	//修改某个商品服务
	public void updateGoodsService(GoodsService goodsService);
	
	//拿到某个商品服务
	public GoodsService getGoodsService(Long id);
	
	//删除某个商品服务
	public void deleteService(Long id);
	
	//拿到所有的仓库信息
	public List<StorageService> getAllStorage(Long id);
	
	//新增某一个仓库
	public void addStorage(StorageService storageService);
	
    //删除对应企业id的所有仓库信息
	public void deleteAllStorage(Long id);
	
    //删除某一个仓库信息
	public void deleteStorage(Long id);
	
	//修改某一个仓库
    public void updateStorage(StorageService storageService);
    
    //拿到某一个仓库信息	
    public StorageService getStorage(Long id);
	
	public List<Map> getEntByName(String name);
	
	/**
	 * 
	 * @param enterId  企业id
	 * @param isFamousBrand  是否设置为名牌贸易商
	 */
	public void setFamousBrand(Long enterId , Boolean isFamousBrand);

	/**
	 * 找到相应条件的企业列表
	 */
	public List<EnterpriseInfo> findEnterInfoBy();
	
     /**
      * @param 省市县信息
      * 根据地域查询相应的贸易商列表
      */
	public List<EnterpriseInfo> findEnterByArea(String area);
	
}


