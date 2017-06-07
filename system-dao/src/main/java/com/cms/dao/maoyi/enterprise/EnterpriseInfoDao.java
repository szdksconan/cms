package com.cms.dao.maoyi.enterprise;

import java.util.List;
import java.util.Map;

import com.cms.model.maoyi.EnterpriseInfo;

/**
 * @author penglei
 *
 * 2016年4月18日
 */
public interface EnterpriseInfoDao {
   
	public void addInfo(EnterpriseInfo enterpriseInfo);
	
	public void deleteInfo(Long id);
	
	public void  updateInfo(EnterpriseInfo enterpriseInfo);
	
	public EnterpriseInfo getInfo(Long id);
	
	//保存发展意向
	public void addDevelopWill(Map<String, Object> map);
	//保存合作意向
	public void addJoinWill(Map<String, Object> map);	
	
	List<Map> getEntByName(String name);

	/**
	 * 
	 * @param enterId 贸易商id
	 * @param isFamousBrand  是否为名品贸易店
	 */
	public void setFamousBrand(Map<String, Object> map);
	
	/**
	 * 找到相应条件的企业列表
	 */
	public List<EnterpriseInfo> findEnterInfoBy();
	
}
