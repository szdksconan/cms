package com.cms.service.xiaofei.openShop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;

import com.cms.dao.xiaofei.CmsXAttachmentDao;
import com.cms.dao.xiaofei.CmsXRecruitDao;
import com.cms.dao.xiaofei.CmsXShopApplyDao;
import com.cms.iservice.xiaofei.CmsXShopApplyService;
import com.cms.model.xiaofei.CmsXAttachment;
import com.cms.model.xiaofei.CmsXRecruit;
import com.cms.model.xiaofei.CmsXShopApply;
import com.cms.model.xiaofei.DataList;

public class CmsXShopApplyServiceImpl implements CmsXShopApplyService {

	@Autowired
	private CmsXShopApplyDao cmsXShopApplyDao;
	@Autowired
	private CmsXRecruitDao cmsXRecruitDao;

	public Integer addCmsXShopApplyInfo(CmsXShopApply cmsXShopApply) {
		Map<String, Object> map = new HashMap<String, Object>();
		CmsXRecruit c = cmsXRecruitDao.selectCmsXRecruitByIdAndInfo(cmsXShopApply.getInvestmentOrderId());
		map.put("id", cmsXShopApply.getProductRecruitId());
		map.put("re", c.getReqTime()+1);
		cmsXRecruitDao.updateGetUserByapply(map);
		return this.cmsXShopApplyDao.addCmsXShopApplyInfo(cmsXShopApply);
	}

	/**
	 * 查询全部创业申请推送给贸易平台
	 */
	public DataList selectAllUserAndShopAndAttachmentGetInfo(String loclCode, String typeCode,
			Integer page,Integer pageSize) {
		if(loclCode!=null&&loclCode!=""){
			loclCode = "%"+loclCode+"%";
		}
		if(typeCode!=null&&typeCode!=""){
			typeCode = "%"+typeCode+"%";
		}
		DataList data_List = new DataList();
		Map<String, Object> map = new  HashMap<String, Object>();
		map.put("loclCode", loclCode);
		map.put("typeCode", typeCode);
		map.put("page", page);
		map.put("pageSize", pageSize);
		List<CmsXShopApply> list = this.cmsXShopApplyDao.selectAllUserAndShopAndAttachmentGetInfo(map);
		data_List.setListData(list);
		data_List.setSize(this.cmsXShopApplyDao.selectAllCmsXShopApplyCountGetSize(map));
		return data_List;
	}

	/**
	 * 根据用户查询自己的创业信息
	 */
	public DataList selectUserByIdAndShopApplyGetInfo(String key,String uId, Integer page,Integer pageSize) {
		DataList data_List = new DataList();
		Map<String, Object> map = new HashMap<String, Object>();
		if(key!=null&&key!=""){
			key = "%"+key+"%";
		}
		map.put("key", key);
		map.put("uId", uId);
		map.put("page", page);
		map.put("pageSize", pageSize);
		data_List.setListData(this.cmsXShopApplyDao.selectUserByIdAndShopApplyGetInfo(map));
		data_List.setSize(this.cmsXShopApplyDao.selectUserByIdAndShopApplyGetInfoSize(map));
		return data_List;
	}

	/**
	 * 根据创业申请Id查询详情信息
	 */
	public CmsXShopApply selectGetCmsXShopApplyByIdAndInfo(String id) {
		// TODO Auto-generated method stub
		return this.cmsXShopApplyDao.selectGetCmsXShopApplyByIdAndInfo(id);
	}
	

}
