package com.cms.service.wuliu;


import java.util.*;

import com.alibaba.dubbo.common.logger.Logger;
import com.alibaba.dubbo.common.logger.LoggerFactory;
import com.cms.model.User;
import com.cms.model.wuliu.ChppQueryParam;
import com.cms.service.common.redis.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSONObject;
import com.cms.dao.wuliu.InfoHallDao;
import com.cms.iservice.wuliu.InfoHallService;
import com.cms.model.util.Grid;
import com.cms.model.util.PageFilter;
import com.cms.model.util.SessionInfo;
import com.cms.model.wuliu.CheyuanBean;
import com.cms.model.wuliu.HuoyuanBean;

import javax.servlet.http.HttpSession;

public class InfoHallServiceImpl implements InfoHallService {
    private static Logger logger = LoggerFactory.getLogger(InfoHallServiceImpl.class);

	@Autowired
	private InfoHallDao infoHallDao;

    /**
     * 获取车源
     * @param ph
     * @return
     */
	public Grid cheyuanList(ChppQueryParam queryParam,PageFilter ph, User loginUser) {
        CheyuanBean bean = new CheyuanBean();
        if (queryParam!=null){
            bean = (CheyuanBean) this.buildBean(new CheyuanBean(), (JSONObject) JSONObject.toJSON(queryParam));
            if (queryParam.isFirstQuery()){
                bean.setProvinceAreaId(loginUser.getBelongAreaId());
            }
            if (queryParam.getProvinceAreaId()!=null){
                bean.setProvinceAreaId(queryParam.getProvinceAreaId());
            }
            if (queryParam.getCarAxleId()!=null&&queryParam.getCarAxleId()!=0){
                bean.setCar_axle_id(queryParam.getCarAxleId()+"");
            }
            if (queryParam.getCarContainerId()!=null&&queryParam.getCarContainerId()!=0){
                bean.setCar_container_id(queryParam.getCarContainerId()+"");
            }
            if (queryParam.getCarTrafficType()!=null&&queryParam.getCarTrafficType()!=0){
                bean.setCarTrafficTypeId(queryParam.getCarTrafficType()+"");
            }
            if (queryParam.getCarTypeId()!=null&&queryParam.getCarTypeId()!=0){
                bean.setCarTypeId(queryParam.getCarTypeId()+"");
            }
            if (queryParam.getTrafficType()!=null){
                bean.setTrafficType(queryParam.getTrafficType());
            }
            if (queryParam.getQuoteRegion()!=null&&queryParam.getQuoteRegion()!=0){
                bean.setQuoteRegionId(queryParam.getQuoteRegion());
            }
            if (queryParam.getWeight()!=null&&queryParam.getWeight()!=0){
                bean.setWeightRegionId(queryParam.getWeight());
            }
        }
        if (loginUser!=null){
            bean.setUserId(loginUser.getId() + "");
        }

		JSONObject json = new JSONObject();
		if (bean != null){
			json = (JSONObject) JSONObject.toJSON(bean);
		}
		if (ph!=null){
			json.put("order", ph.getOrderString());
		}
		Grid grid = new Grid();
        int total = this.infoHallDao.cheyuanListCot(json);
        if (ph.getPage()==1){
//            List<CheyuanBean> commend = this.infoHallDao.getCheyuanRecommondList(json);
            List<CheyuanBean> commend = new ArrayList<CheyuanBean>();
            if (commend.size() != 0){
                ph.setRows(ph.getRows()-commend.size());
                json.put("order",ph.getOrderString());
                Set<CheyuanBean> set = new TreeSet<CheyuanBean>();
                commend.addAll(this.infoHallDao.cheyuanList(json));
                for (int i=0;i<commend.size();i++){
                    CheyuanBean cy = commend.get(i);
                    cy.setOrderNum(i);
                    set.add(cy);
                }
//                List list = new ArrayList(set);
                ///////
//                List<CheyuanBean> list = new ArrayList<CheyuanBean>();
//                for (CheyuanBean cheyuan:set){
//                    list.add((CheyuanBean) RedisUtil.get("cheyuan-"+cheyuan.getId()));
//                }
                grid.setRows(this.getCheYuanList(new ArrayList<CheyuanBean>(),set));
                ///////
//                grid.setRows(list);
            }else {
                grid.setRows(this.getCheYuanList(this.infoHallDao.cheyuanList(json),new TreeSet<CheyuanBean>()));
            }
        }else {
            grid.setRows(this.getCheYuanList(this.infoHallDao.cheyuanList(json),new TreeSet<CheyuanBean>()));
        }
		grid.setTotal(total);
		return grid;
	}

    private List<CheyuanBean> getCheYuanList(List<CheyuanBean> list,Set<CheyuanBean> set){
        List<CheyuanBean> list2 = new ArrayList<CheyuanBean>();
        if (list.size()==0){
            list = new ArrayList<CheyuanBean>(set);
        }
        for (CheyuanBean cheyuan:list){
            try{
                CheyuanBean cheyuan2 = (CheyuanBean) RedisUtil.hget("chpp", "chpp:cyxx:" + cheyuan.getId());
                if (cheyuan2 != null){
                    cheyuan2.setCreateTime(cheyuan.getCreateTime());
                    cheyuan2.setInvalidTime(cheyuan.getInvalidTime());
                    cheyuan2.setStartWay(cheyuan.getStartWay());
                    cheyuan2.setEndWay(cheyuan.getEndWay());
                    cheyuan2.setWay(cheyuan.getWay());
                    cheyuan2.setTrafficTypeName(cheyuan.getTrafficTypeName());
                    cheyuan2.setCompanyName(cheyuan.getCompanyName());
                    list2.add(cheyuan2);
                }else {
                    list2.add(cheyuan);
                }
            }catch (Exception e){
                logger.debug("获取车源缓存错误\n"+cheyuan.getId());
            }
        }
        return list2;
    }

    /**
     * 获取货源
     * @param ph
     * @return
     */
	public Grid huoyuanList(ChppQueryParam queryParam,PageFilter ph, User loginUser) {
        HuoyuanBean bean = new HuoyuanBean();
        if (queryParam!=null){
            bean = (HuoyuanBean) this.buildBean(new HuoyuanBean(), (JSONObject) JSONObject.toJSON(queryParam));
            if (queryParam.isFirstQuery()){
                bean.setProvinceAreaId(loginUser.getBelongAreaId());
            }
            if (queryParam.getProvinceAreaId()!=null){
                bean.setProvinceAreaId(queryParam.getProvinceAreaId());
            }
            if (queryParam.getPackageType()!=null&&queryParam.getPackageType()!=0){
                bean.setPackageType(queryParam.getPackageType()+"");
            }
            if (queryParam.getQuoteRegion()!=null){
                bean.setQuoteRegionId(queryParam.getQuoteRegion());
            }
            if (queryParam.getWeight()!=null){
                bean.setWeightRegionId(queryParam.getWeight());
            }
        }
        if (loginUser!=null){
            bean.setUserId(loginUser.getId()+"");
        }

		JSONObject json = new JSONObject();
		if (bean!=null){
			json = (JSONObject) JSONObject.toJSON(bean);
		}
		if (ph!=null){
			json.put("order", ph.getOrderString());
		}
		Grid grid = new Grid();
        int total = this.infoHallDao.huoyuanListCot(json);
        if (ph.getPage()==1){
//            List<HuoyuanBean> commend = this.infoHallDao.getHuoyuanRecommondList(json);
            List<HuoyuanBean> commend = new ArrayList<HuoyuanBean>();
            if (commend.size()!=0){
                ph.setRows(ph.getRows()-commend.size());
                json.put("order",ph.getOrderString());
                Set<HuoyuanBean> set = new TreeSet<HuoyuanBean>();
                commend.addAll(this.infoHallDao.huoyuanList(json));
                for (int i=0;i<commend.size();i++){
                    HuoyuanBean hy = commend.get(i);
                    hy.setOrderNum(i);
                    set.add(hy);
                }
//                List<HuoyuanBean> list = new ArrayList<HuoyuanBean>(set);
                /////////
                grid.setRows(this.getHuoYuanList(new ArrayList<HuoyuanBean>(),set));
                ////////
//                grid.setRows(list);
            }else {
//                grid.setRows(this.infoHallDao.huoyuanList(json));
                grid.setRows(this.getHuoYuanList(this.infoHallDao.huoyuanList(json),new TreeSet<HuoyuanBean>()));
            }
        }else {
//            grid.setRows(this.infoHallDao.huoyuanList(json));
            grid.setRows(this.getHuoYuanList(this.infoHallDao.huoyuanList(json),new TreeSet<HuoyuanBean>()));
        }
        grid.setTotal(total);
		return grid;
	}

    private List<HuoyuanBean> getHuoYuanList(List<HuoyuanBean> list,Set<HuoyuanBean> set){
        List<HuoyuanBean> list2 = new ArrayList<HuoyuanBean>();
        if (list.size()==0){
            list = new ArrayList<HuoyuanBean>(set);
        }
        for (HuoyuanBean huoyuan:list){
            try {
                HuoyuanBean huoyuan2 = (HuoyuanBean) RedisUtil.hget("chpp", "chpp:hyxx:" + huoyuan.getId());
                if (huoyuan2 != null){
                    huoyuan2.setStartWay(huoyuan.getStartWay());
                    huoyuan2.setEndWay(huoyuan.getEndWay());
                    huoyuan2.setCreateTime(huoyuan.getCreateTime());
                    huoyuan2.setInvalidTime(huoyuan.getInvalidTime());
                    huoyuan2.setWay(huoyuan.getWay());
                    huoyuan2.setPackageTypeName(huoyuan.getPackageTypeName());
                    list2.add(huoyuan2);
                }else {
                    list2.add(huoyuan);
                }
            }catch (Exception e){
                logger.debug("获取货源缓存错误\n"+huoyuan.getId());
            }
        }
        return list2;
    }

    /**
	 * 推荐货源
	 */
	public Grid getHuoyuanRecommondList(User user) {
		JSONObject obj = new JSONObject();
		if (user != null){
			obj = (JSONObject) JSONObject.toJSON(user);
		}
		Grid grid = new Grid();
		List<HuoyuanBean> list = this.infoHallDao.getHuoyuanRecommondList(obj);
		grid.setRows(list);
		grid.setTotal(list.size());
		return grid;
	}

	/**
	 * 推荐车源
	 */
	public Grid getCheyuanRecommondList(User user) {
		JSONObject obj = new JSONObject();
		if (user != null){
			obj = (JSONObject) JSONObject.toJSON(user);
		}
		Grid grid = new Grid();
		List<CheyuanBean> list = this.infoHallDao.getCheyuanRecommondList(obj);
		grid.setRows(list);
		grid.setTotal(list.size());
		return grid;
	}

	/**
	 * 匹配货源
	 */
	public Grid marryListForHuoyuan(HuoyuanBean bean) {
		JSONObject obj = (JSONObject) JSONObject.toJSON(bean);
		Grid grid = new Grid();
        List<CheyuanBean> list = this.infoHallDao.marryListForHuoyuan(obj);
        grid.setRows(list);
        grid.setTotal(list.size());
//		grid.setRows(this.infoHallDao.cheyuanList(obj));
//		grid.setTotal(this.infoHallDao.cheyuanListCot(obj));
		return grid;
	}

	/**
	 * 匹配车源
	 */
	public Grid marryListForCheyuan(CheyuanBean bean) {
		JSONObject obj = (JSONObject) JSONObject.toJSON(bean);
		Grid grid = new Grid();
        List<HuoyuanBean> list = this.infoHallDao.marryListForCheyuan(obj);
        grid.setRows(list);
        grid.setTotal(list.size());
//		grid.setRows(this.infoHallDao.huoyuanList(obj));
//		grid.setTotal(this.infoHallDao.huoyuanListCot(obj));
		return grid;
	}

    public CheyuanBean getCheyuanInfo(HashMap map) {
        return this.infoHallDao.getCheyuanInfo(map);
    }

    public HuoyuanBean getHuoyuanInfo(HashMap map) {
        return this.infoHallDao.getHuoyuanInfo(map);
    }

    public List getMarryList(HashMap map) {
        return this.infoHallDao.getMarryList(map);
    }

    /**
     * 将起始终止地分别写入ben中
     * @param bean
     * @param obj
     * @return
     */
    private Object buildBean(Object bean,JSONObject obj){
        if (bean instanceof HuoyuanBean){
            if (obj.getString("start")!=null && !"".equals(obj.getString("start"))){
                String[] array = obj.getString("start").split("-");
                int len = array.length;
                ((HuoyuanBean) bean).setBeginProvinceId(len>0?Long.parseLong(array[0]):null);
                ((HuoyuanBean) bean).setBeginAreaId(len>1?Long.parseLong(array[1]):null);
                ((HuoyuanBean) bean).setBeginCityId(len>2?Long.parseLong(array[2]):null);
            }
            if (obj.getString("end")!=null && !"".equals(obj.getString("end"))){
                String[] array = obj.getString("end").split("-");
                int len = array.length;
                ((HuoyuanBean) bean).setEndProvinceId(len>0?Long.parseLong(array[0]):null);
                ((HuoyuanBean) bean).setEndAreaId(len>1?Long.parseLong(array[1]):null);
                ((HuoyuanBean) bean).setEndCityId(len>2?Long.parseLong(array[2]):null);
            }
        }
        if (bean instanceof CheyuanBean){
            if (obj.getString("start")!=null && !"".equals(obj.getString("start"))){
                String[] array = obj.getString("start").split("-");
                int len = array.length;
                ((CheyuanBean) bean).setBeginProvinceId(len>0?Long.parseLong(array[0]):null);
                ((CheyuanBean) bean).setBeginAreaId(len>1?Long.parseLong(array[1]):null);
                ((CheyuanBean) bean).setBeginCityId(len>2?Long.parseLong(array[2]):null);
            }
            if (obj.getString("end")!=null && !"".equals(obj.getString("end"))){
                String[] array = obj.getString("end").split("-");
                int len = array.length;
                ((CheyuanBean) bean).setEndProvinceId(len>0?Long.parseLong(array[0]):null);
                ((CheyuanBean) bean).setEndAreaId(len>1?Long.parseLong(array[1]):null);
                ((CheyuanBean) bean).setEndCityId(len>2?Long.parseLong(array[2]):null);
            }
        }
        return bean;
    }
}
