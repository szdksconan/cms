package com.cms.iservice.wuliu;

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.cms.model.wuliu.AreaBean;
import com.cms.model.wuliu.CityBean;
import com.cms.model.wuliu.ProvinceBean;

public interface CommonService {
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
	 * @param pid
	 * @return
	 */
	public List<Map> getGoodsDicInfoList(String pid);
	/**
	 * 获取车辆
	 * @return
	 */
	public List<Map> getCarList(JSONObject obj);

    /**
     * 定时任务：更新信息过期状态
     */
    public void update_task();

    /**
     * 获取价格区间
     * @return
     */
    public List<Map> getQuoteList();

    /**
     * 获取重量区间
     * @return
     */
    public List<Map> getWeightList();
}
