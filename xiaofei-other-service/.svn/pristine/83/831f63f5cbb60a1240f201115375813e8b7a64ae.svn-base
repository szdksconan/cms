package com.cms.service.xiaofei.wuliu;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.cms.dao.xiaofei.CmsWlLogistcalDao;
import com.cms.iservice.xiaofei.LogisticalXiaofeiService;
import com.cms.model.xiaofei.CmsXLogisticsDetail;
import com.cms.model.xiaofei.CmsXLogisticsReq;
import com.cms.model.xiaofei.DataList;

public class CmsLogistcalServiceImpl implements LogisticalXiaofeiService{
	
	@Autowired
	private CmsWlLogistcalDao cmsWlLogistcalDao;
	
	public Integer insertorUpdateLogistical(CmsXLogisticsReq cmsXLogisticsReq) {
		// TODO Auto-generated method stub
		return cmsWlLogistcalDao.insertorUpdateLogistical(cmsXLogisticsReq);
	}
	public Integer insertorUpdateDetail(CmsXLogisticsDetail cmsXLogisticsDetail) {
		// TODO Auto-generated method stub
		return cmsWlLogistcalDao.insertorUpdateDetail(cmsXLogisticsDetail);
	}

	public CmsXLogisticsReq getReqlInfo(String id) {
		// TODO Auto-generated method stub
		System.out.println("impl的id="+id);
		return this.cmsWlLogistcalDao.getReqlInfo(id);
	}
	
	public List<CmsXLogisticsDetail> getReqDetaillInfo(String reqId) {
		// TODO Auto-generated method stub
		System.out.println("impl的reqid="+reqId);
		return this.cmsWlLogistcalDao.getReqDetaillInfo(reqId);
	}

	public DataList getLogistical(Integer page, Integer pageSize) {
		System.out.println(page+"----------"+pageSize);
		DataList data = new DataList();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("page", page);
		map.put("pageSize", pageSize);
		data.setListData(cmsWlLogistcalDao.getLogistical(map));
		data.setSize(this.cmsWlLogistcalDao.getLogisticalSize());
		return data;
	}
	public Integer insertOrUpdateLPrice(String DistanceFee, String ReceiptGoodsFee, String DeliveryGoodsFee,
			String InsuredFee, String TaxFee, String AmountFee, Integer state, String id) {
		// TODO Auto-generated method stub
		return cmsWlLogistcalDao.insertOrUpdateLPrice(DistanceFee, ReceiptGoodsFee, DeliveryGoodsFee, InsuredFee, TaxFee, AmountFee, state, id);
	}
	public void setSeeCount(String id) {
		// TODO Auto-generated method stub
		cmsWlLogistcalDao.setSeeCount(id);
	}

}
