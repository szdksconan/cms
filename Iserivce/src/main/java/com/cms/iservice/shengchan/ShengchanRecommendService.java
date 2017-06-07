package com.cms.iservice.shengchan;

import java.util.List;

/**
 * Created by divelfang on 2016/5/23.
 */
public interface ShengchanRecommendService {

    public List<String> getGoodsRequireRecommend(String companyId, Integer countStart, Integer countEnd);

    public List<String> getZhaobiaoRecommend(String companyId, Integer countStart, Integer countEnd);

    public List<String> getGoodsRecommend(String companyId, Integer countStart, Integer countEnd);

    public List<String> getSupplierRecommend(String companyId, Integer countStart, Integer countEnd);

    public List<String> getDistributorRecommend(String companyId, Integer countStart, Integer countEnd);

    public List<String> getMyAreas(String companyId);
}
