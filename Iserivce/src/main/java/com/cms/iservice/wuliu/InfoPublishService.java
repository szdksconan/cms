package com.cms.iservice.wuliu;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.cms.model.util.Grid;
import com.cms.model.wuliu.CheyuanBean;
import com.cms.model.wuliu.HuoyuanBean;

public interface InfoPublishService {
    /**
     * 新增货源
     * @param bean
     * @throws Exception
     */
	public String addHuoyuan(HuoyuanBean bean)throws Exception;

    /**
     * 新增车源
     * @param bean
     * @throws Exception
     */
	public String addCheyuan(CheyuanBean bean);

    /**
     * 获取历史记录
     * @return
     */
	public Grid getHistoryList(HashMap map);

    /**
     * 重新发布
     * @throws Exception
     */
	public void updateRePublish(HashMap map)throws Exception;

    /**
     * 车源货源关系操作
     * @throws Exception
     */
    public void updateconfirm(HashMap map)throws Exception;

    /**
     * 获取确认信息列
     * @return
     */
    public List<Map> showRelationList(HashMap map);

    /**
     * 车货源关系确认
     */
    public void updateRelation(HashMap map)throws Exception;

    /**
     * 删除信息
     */
    public void delInfo(HashMap map)throws Exception;

    /**
     * 保存常用地址
     */
    public void saveAddress(JSONObject obj)throws Exception;

    /**
     * 获取地址
     * @return
     */
    public List<Map> getUserAddress(JSONObject obj);

    /**
     * 删除地址
     * @throws Exception
     */
    public void deleteAdd(JSONObject obj)throws Exception;

    /**
     * 货源推送到物流平台
     * @throws Exception
     */
    public void updatePlatformLogistics(String id)throws Exception;

    /**
     * 获取主要路线
     * @return
     */
    public Map getMainLine(HashMap map);

    /**
     * 获取最近车辆所属车源
     * @param map
     * @return
     */
    public Integer getLastCheyuanCot(HashMap map);
    /**
     * 得到用户发布车源信息的记录条数
     */
    public Integer getLastCheyuanCot2(HashMap map);
}
