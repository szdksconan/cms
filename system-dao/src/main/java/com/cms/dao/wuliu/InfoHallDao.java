package com.cms.dao.wuliu;

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.cms.model.wuliu.CheyuanBean;
import com.cms.model.wuliu.HuoyuanBean;

public interface InfoHallDao {
    /**
     * 获取车源
     * @param json
     * @return
     */
	public List<CheyuanBean> cheyuanList(JSONObject json);

    /**
     * 获取货源
     * @param json
     * @return
     */
	public List<HuoyuanBean> huoyuanList(JSONObject json);

    /**
     * 统计车源
     * @param json
     * @return
     */
	public int cheyuanListCot(JSONObject json);

    /**
     * 统计货源
     * @param json
     * @return
     */
	public int huoyuanListCot(JSONObject json);

    /**
     * 获取推荐货源
     * @param json
     * @return
     */
	public List<HuoyuanBean> getHuoyuanRecommondList(JSONObject json);

    /**
     * 获取推荐车源
     * @param json
     * @return
     */
	public List<CheyuanBean> getCheyuanRecommondList(JSONObject json);

    /**
     * 获取车源信息
     * @param map
     * @return
     */
    public CheyuanBean getCheyuanInfo(Map map);

    /**
     * 货源信息
     * @param map
     * @return
     */
    public HuoyuanBean getHuoyuanInfo(Map map);

    public List getMarryList(Map map);

    /**
     * 匹配货源
     * @param obj
     * @return
     */
    public List<CheyuanBean> marryListForHuoyuan(JSONObject obj);

    /**
     * 匹配车源
     * @param obj
     * @return
     */
    public List<HuoyuanBean> marryListForCheyuan(JSONObject obj);
}
