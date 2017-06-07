package com.cms.mapper.wuliu;

import java.util.List;
import java.util.Map;

import com.cms.model.wuliu.AreaBean;
import com.cms.model.wuliu.CityBean;
import com.cms.model.wuliu.ProvinceBean;


public interface CommonMapper {
	/**
	 * 获取省份
	 * @return
	 */
	public List<ProvinceBean> getProvince(ProvinceBean bean);
	
	/**
	 * 获取区域
	 * @return
	 */
	public List<Map> getArea(AreaBean bean);
	
	/**
	 * 获取县市
	 * @return
	 */
	public List<Map> getCity(CityBean bean);
	
	/**
	 * 获取字典list
	 * @return
	 */
	public List<Map> getGoodsDicInfoList(String id);
	
	/**
	 * 获取车辆
	 * @return
	 */
	public List<Map> getCarList(Map map);

    public void update_taskhuoyuan();

    public void update_taskcheyuan();

    public List<Map> getQuoteList();

    public List<Map> getWeightList();
}
