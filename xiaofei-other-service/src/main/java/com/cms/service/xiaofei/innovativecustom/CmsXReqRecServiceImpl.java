package com.cms.service.xiaofei.innovativecustom;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;

import com.cms.dao.xiaofei.CmsXAttachmentDao;
import com.cms.dao.xiaofei.CmsXReqRecDao;
import com.cms.iservice.xiaofei.CmsXReqRecService;
import com.cms.mapper.xiaofei.CmsXReqRecMapper;
import com.cms.model.xiaofei.CmsXAttachment;
import com.cms.model.xiaofei.CmsXReqRec;
import com.cms.model.xiaofei.DataList;

public class CmsXReqRecServiceImpl implements CmsXReqRecService {
	
	@Autowired
	private CmsXReqRecDao cmsXReqRecDao;
	@Autowired
	private CmsXAttachmentDao cmsXAttachmentDao;

	/**
	 * 添加用户发布的创新定制信息
	 */
	public void addUserReleaseAndInnovationCustomGetInfo(CmsXReqRec cmsXReqRec) {
		
		this.cmsXReqRecDao.addUserReleaseAndInnovationCustomGetInfo(cmsXReqRec);
	}

	/**
	 * 查看全部创新定制信息
	 * 作者： 郑泽
	 * 日期：2016年6月2日
	 * @param loclCode
	 * @param typeCode
	 * @param page
	 * @param pageSize
	 * @return
	 */
	public DataList selectAllCmsXReqRecGetInfo(@Param("loclCode")String loclCode,@Param("typeCode")String typeCode,
			@Param("page")Integer page,@Param("pageSize")Integer pageSize) {
		DataList data = new DataList();
		List<CmsXReqRec> list = new ArrayList<CmsXReqRec>();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> map_s = new HashMap<String, Object>();
		if(loclCode!=null&&loclCode!=""){
			loclCode = "%"+loclCode+"%";
		}
		if(typeCode!=null&&typeCode!=""){
			typeCode = "%"+typeCode+"%";
		}
		map.put("loclCode", loclCode);
		map.put("typeCode", typeCode);
		map.put("page", page);
		map.put("pageSize", pageSize);
		map_s.put("loclCode", loclCode);
		map_s.put("typeCode", typeCode);
		List<CmsXReqRec> listMap = this.cmsXReqRecDao.selectAllCmsXReqRecGetInfo(map);
		for (CmsXReqRec cmsXReqRec : listMap) {
			List<CmsXAttachment> list_Map=this.cmsXAttachmentDao.selectGetByIdAndmentInfo(cmsXReqRec.getCustomId());
			cmsXReqRec.setAttachments(list_Map);
			list.add(cmsXReqRec);
		}
		data.setListData(list);
		data.setSize(this.cmsXReqRecDao.selectAllCountGetSize(map_s));
		return data;
	}

	/**
	 * 根据不同的条件显示创新定制列表信息
	 */
	public DataList selectGetListContInfo(String opTime,String key,Integer page,Integer pageSize) {
		DataList data = new DataList();
		Map<String, Object> map = new HashMap<String, Object>();
		if(key!=null&&key!=""){
			key = "%"+key+"%";
		}
		map.put("opTime", opTime);
		map.put("key", key);
		map.put("page", page);
		map.put("pageSize", pageSize);
		List<CmsXReqRec> list = new ArrayList<CmsXReqRec>();
		List<CmsXReqRec> listMap = this.cmsXReqRecDao.selectGetListContInfo(map);
		for (CmsXReqRec cmsXReqRec : listMap) {
			List<CmsXAttachment> list_Map=this.cmsXAttachmentDao.selectGetCodeAndAttachment(cmsXReqRec.getCustomId());
			cmsXReqRec.setAttachments(list_Map);
			list.add(cmsXReqRec);
		}
		data.setListData(list);
		data.setSize(this.cmsXReqRecDao.selectAllGetConditions(map));
		return data;
	}

	/**
	 * 根据Id查询详情
	 */
	public List<CmsXReqRec> selectGetCmsXReqRecByDetails(@Param("Id")String Id) {
		List<CmsXReqRec> list = new ArrayList<CmsXReqRec>();
		CmsXReqRec crr = this.cmsXReqRecDao.selectGetCmsXReqRecByDetails(Id);
		List<CmsXAttachment> list_Map=this.cmsXAttachmentDao.selectGetByIdAndmentInfo(crr.getCustomId());
		crr.setAttachments(list_Map);
		list.add(crr);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("number", crr.getViewNum()+1);
		map.put("Id", Id);
		this.cmsXReqRecDao.updateReqRecAndViews(map);
		return list;
	}

	/**
	 * 根据用户ID查询用户自己的创新定制信息
	 * 作者： 郑泽
	 * 日期：2016年6月2日
	 * @param uId
	 * @return
	 */
	public DataList selectUserByIdAndReqRecGetInfo(String uId,String key,Integer page,Integer pageSize) {
		DataList data = new DataList();
		Map<String, Object> map = new HashMap<String, Object>();
		if(key!=null&&key!=""){
			key = "%"+key+"%";
		}
		map.put("uId", uId);
		map.put("key", key);
		map.put("page", page);
		map.put("pageSize", pageSize);
		data.setListData(this.cmsXReqRecDao.selectUserByIdAndReqRecGetInfo(map));
		data.setSize(this.cmsXReqRecDao.selectUserByIdGetCountSize(map));
		return data;
	}

}
