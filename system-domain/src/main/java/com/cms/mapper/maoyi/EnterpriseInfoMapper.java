package com.cms.mapper.maoyi;


import java.util.List;
import java.util.Map;


import com.cms.model.maoyi.EnterpriseInfo;

/**
 * @author penglei
 *
 * 2016年4月18日
 */
public interface EnterpriseInfoMapper {

	public void addInfo(EnterpriseInfo enterpriseInfo);
    
	public void deleteInfo(Long id);

	public void  updateInfo(EnterpriseInfo enterpriseInfo);

	EnterpriseInfo getInfo(Long id) ;
	 //保存发展意向
	public void addDevelopWill(Map<String, Object> map);
	//保存合作意向
	public void addJoinWill(Map<String, Object> map);
	
	List<Map> getEntByName(String name);
	
	public void setFamousBrand(Map<String, Object> map);
    /**
     * 
     * @return 拿到相应条件的贸易商列表
     */
	public List<EnterpriseInfo> findEnterInfoBy();

}