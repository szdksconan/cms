package com.cms.service.caigou;

import com.cms.dao.dict.AreaCommonDao;
import com.cms.dao.dict.BaseProductDao;
import com.cms.iservice.shengchan.shengchanCommonService;
import com.cms.model.dict.AreaCity;
import com.cms.model.dict.AreaProvince;
import com.cms.model.dict.BaseIndustry;
import com.cms.model.dict.BaseProduct;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by liuxin on 2016/4/14.
 */
public class shengchanCommonServiceImpl implements shengchanCommonService {
    @Autowired
    private BaseProductDao baseProductDao;

    @Autowired
    private AreaCommonDao areaCommonDao;

    public List<BaseProduct> getBaseProductList(BaseProduct baseProduct) {
        return this.baseProductDao.getBaseProductList(baseProduct);
    }

    public List<BaseIndustry> getBaseIndustryList() {
        return this.baseProductDao.getBaseIndustryList();
    }

    public Map getProvinceCityAreaList() {
        List<AreaProvince> provinceList = this.areaCommonDao.getProvinceList();
        List<AreaCity> areaCityList = new ArrayList<AreaCity>();
        String[] cityType = new String[]{"3","4"};
        Map map = new HashMap();
        for (AreaProvince province : provinceList){
            AreaCity areaCity = new AreaCity();
            areaCity.setApid(province.getId());
            areaCity.setCityType(cityType);
            List<AreaCity> _list = this.areaCommonDao.getCityList(areaCity);
            province.setCity(_list);
            for (int j=0;j<_list.size();j++){
                areaCity = new AreaCity();
                areaCity.setAalcid(_list.get(j).getId());
                areaCityList.addAll(this.areaCommonDao.getCityList(areaCity));
            }
        }
        map.put("province",provinceList);
        map.put("area",areaCityList);
        return map;
    }
}
