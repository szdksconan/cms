package com.cms.dao.wuliu;

import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.cms.mapper.wuliu.InfoHallMapper;
import com.cms.model.wuliu.CheyuanBean;
import com.cms.model.wuliu.HuoyuanBean;

@Component
public class InfoHallDaoImp implements InfoHallDao {
	private static Logger logger = LoggerFactory.getLogger(InfoHallDaoImp.class);
	@Autowired
	private InfoHallMapper infoHallMapper;

    /**
     * 获取车源
     * @param json
     * @return
     */
	public List<CheyuanBean> cheyuanList(JSONObject json) {
		return this.infoHallMapper.cheyuanList(json);
	}

    /**
     * 获取货源
     * @param json
     * @return
     */
	public List<HuoyuanBean> huoyuanList(JSONObject json) {
		return this.infoHallMapper.huoyuanList(json);
	}

    /**
     * 统计车源
     * @param json
     * @return
     */
	public int cheyuanListCot(JSONObject json) {
		return this.infoHallMapper.cheyuanListCot(json);
	}

    /**
     * 统计车源
     * @param json
     * @return
     */
	public int huoyuanListCot(JSONObject json) {
		return this.infoHallMapper.huoyuanListCot(json);
	}

    /**
     * 获取推荐货源
     * @param json
     * @return
     */
	public List<HuoyuanBean> getHuoyuanRecommondList(JSONObject json) {
//        return this.infoHallMapper.getHuoyuanRecommondList(json);
        List<CheyuanBean> cheyuanList = this.infoHallMapper.getHuoyuanRecommond_cheyuanList(json);
        Set<HuoyuanBean> set = new HashSet<HuoyuanBean>();
        JSONObject obj = (JSONObject) json.clone();
        for (CheyuanBean cheyuanBean:cheyuanList){
            obj.put("begin_province_id",cheyuanBean.getBeginProvinceId());
            obj.put("begin_area_id",cheyuanBean.getBeginAreaId());
            obj.put("end_province_id",cheyuanBean.getEndProvinceId());
            obj.put("end_area_id",cheyuanBean.getEndAreaId());
            obj.put("weight",cheyuanBean.getWeight());
            List<HuoyuanBean> list = this.infoHallMapper.getHuoyuanRecommondList(obj);
            if (list.size()>0){
                set.addAll(list);
            }
        }
        Set<HuoyuanBean> huoyuanSet = new TreeSet<HuoyuanBean>();
        for (HuoyuanBean huoyuanBean:set){
            obj.put("userId",huoyuanBean.getUserId());
            Long id = this.infoHallMapper.getRecommond_vaseId(obj);
            if (id!=null){
            	huoyuanBean.setOrderNum(Integer.valueOf(id+""));
                huoyuanBean.setVaServiceID(id);
            }
            huoyuanSet.add(huoyuanBean);
        }
        List<HuoyuanBean> huoyuanList = new ArrayList<HuoyuanBean>(huoyuanSet);
		return huoyuanList;
	}

    /**
     * 获取推荐车源
     * @param json
     * @return
     */
	public List<CheyuanBean> getCheyuanRecommondList(JSONObject json) {
//        return this.infoHallMapper.getCheyuanRecommondList(json);
        List<HuoyuanBean> huoyuanList = this.infoHallMapper.getCheyuanRecommond_huoyuanList(json);
        Set<CheyuanBean> set = new HashSet<CheyuanBean>();
        JSONObject obj = (JSONObject) json.clone();
        for (HuoyuanBean huoyuanBean:huoyuanList){
            obj.put("begin_province_id",huoyuanBean.getBeginProvinceId());
            obj.put("begin_area_id",huoyuanBean.getBeginAreaId());
            obj.put("end_province_id",huoyuanBean.getEndProvinceId());
            obj.put("end_area_id",huoyuanBean.getEndAreaId());
            obj.put("weight",huoyuanBean.getWeight());
            List<CheyuanBean> list = this.infoHallMapper.getCheyuanRecommondList(obj);
            if (list.size()>0){
                set.addAll(list);
            }
        }
        Set<CheyuanBean> cheyuanBeanSet = new TreeSet<CheyuanBean>();
        for (CheyuanBean cheyuanBean:set){
            obj.put("userId",cheyuanBean.getUserId());
            Long id = this.infoHallMapper.getRecommond_vaseId(obj);
            if (id!=null){
            	cheyuanBean.setOrderNum(Integer.valueOf(id+""));
                cheyuanBean.setVaServiceID(id);
            }
            cheyuanBeanSet.add(cheyuanBean);
        }
        List<CheyuanBean> cheyuanBeanList = new ArrayList<CheyuanBean>(cheyuanBeanSet);
		return cheyuanBeanList;
	}

    public CheyuanBean getCheyuanInfo(Map map) {
        return this.infoHallMapper.getCheyuanInfo(map);
    }

    public HuoyuanBean getHuoyuanInfo(Map map) {
        return this.infoHallMapper.getHuoyuanInfo(map);
    }

    public List getMarryList(Map map) {
//        return this.infoHallMapper.getMarryList(map);
        Set set = new TreeSet();
        if ("cheyuan".equals(map.get("type"))){
            List list = this.infoHallMapper.getMarryCheyuanList(map);
            JSONObject json = new JSONObject();
            for (int i=0;i<list.size();i++){
                HuoyuanBean bean = (HuoyuanBean) list.get(i);
                json.put("userId",bean.getUserId());
                Long id = this.infoHallMapper.getRecommond_vaseId(json);
                if (id!=null){
                    bean.setOrderNum(Integer.valueOf(id + ""));
                    bean.setVaServiceID(id);
                }
                set.add(bean);
            }
        }else {
            List list = this.infoHallMapper.getMarryHuoyuanList(map);
            JSONObject json = new JSONObject();
            for (int i=0;i<list.size();i++){
                CheyuanBean bean = (CheyuanBean) list.get(i);
                json.put("userId",bean.getUserId());
                Long id = this.infoHallMapper.getRecommond_vaseId(json);
                if (id!=null){
                    bean.setOrderNum(Integer.valueOf(id + ""));
                    bean.setVaServiceID(id);
                }
                set.add(bean);
            }
        }
        List list = new ArrayList(set);
        return list;
    }

    public List<CheyuanBean> marryListForHuoyuan(JSONObject obj) {
//        return this.infoHallMapper.marryListForHuoyuan(obj);
        List<CheyuanBean> list = this.infoHallMapper.marryListForHuoyuan(obj);
        Set<CheyuanBean> set = new TreeSet<CheyuanBean>();
        for (CheyuanBean bean : list){
            obj.put("userId",bean.getUserId());
            Long id = this.infoHallMapper.getRecommond_vaseId(obj);
            if (id!=null){
                bean.setOrderNum(Integer.valueOf(id + ""));
                bean.setVaServiceID(id);
            }
            set.add(bean);
        }
        return new ArrayList<CheyuanBean>(set);
    }

    public List<HuoyuanBean> marryListForCheyuan(JSONObject obj) {
//        return this.infoHallMapper.marryListForCheyuan(obj);
        List<HuoyuanBean> list = this.infoHallMapper.marryListForCheyuan(obj);
        Set<HuoyuanBean> set = new TreeSet<HuoyuanBean>();
        for (HuoyuanBean bean : list){
            obj.put("userId",bean.getUserId());
            Long id = this.infoHallMapper.getRecommond_vaseId(obj);
            if (id!=null){
                bean.setOrderNum(Integer.valueOf(id + ""));
                bean.setVaServiceID(id);
            }
            set.add(bean);
        }
        return new ArrayList<HuoyuanBean>(set);
    }

}
