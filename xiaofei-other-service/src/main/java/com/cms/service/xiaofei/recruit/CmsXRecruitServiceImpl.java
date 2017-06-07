package com.cms.service.xiaofei.recruit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.cms.dao.xiaofei.CmsXRecruitAreaDao;
import com.cms.dao.xiaofei.CmsXRecruitDao;
import com.cms.dao.xiaofei.CmsXRecruitIndustryDao;
import com.cms.dao.xiaofei.CmsXRecruitProductDao;
import com.cms.iservice.xiaofei.CmsXRecruitService;
import com.cms.model.xiaofei.CmsXRecruit;
import com.cms.model.xiaofei.CmsXRecruitArea;
import com.cms.model.xiaofei.CmsXRecruitIndustry;
import com.cms.model.xiaofei.CmsXRecruitProduct;
import com.cms.model.xiaofei.DataList;

public class CmsXRecruitServiceImpl implements CmsXRecruitService {
	@Autowired
	private CmsXRecruitDao cmsXRecruitDao;
	@Autowired
	private CmsXRecruitAreaDao cmsXRecruitAreaDao;
	@Autowired
	private CmsXRecruitIndustryDao cmsXRecruitIndustryDao;
	@Autowired
	private CmsXRecruitProductDao cmsXRecruitProductDao;

	/**
	 * 添加生产贸易招募信息
	 */
	public Boolean addCmsXRecruit(CmsXRecruit recruit,ArrayList<CmsXRecruitArea> cmsXRecruitAreas,ArrayList<CmsXRecruitIndustry> cmsXRecruitIndustrys,
			ArrayList<CmsXRecruitProduct> cmsXRecruitProducts) {
		if(recruit!=null){
			//招募地区
			if(cmsXRecruitAreas.size()!=0){
				for (CmsXRecruitProduct cmsXRecruitProduct : cmsXRecruitProducts) {
					cmsXRecruitProduct.setRecruitId(recruit.getId());//set  招募Id
					this.cmsXRecruitProductDao.addCmsXRecruitProduct(cmsXRecruitProduct);
				}
			}
			if(cmsXRecruitIndustrys.size()!=0){
				//招募行业
				for (CmsXRecruitIndustry cmsXRecruitIndustry : cmsXRecruitIndustrys) {
					cmsXRecruitIndustry.setRecruitId(recruit.getId());//set  招募Id
					this.cmsXRecruitIndustryDao.addCmsXRecruitIndustry(cmsXRecruitIndustry);
				}
			}
			if(cmsXRecruitAreas.size()!=0){
				//招募商品信息
				for (CmsXRecruitArea cmsXRecruitArea : cmsXRecruitAreas) {
					cmsXRecruitArea.setRecruitId(recruit.getId());//set  招募Id
					this.cmsXRecruitAreaDao.addCmsXRecruitArea(cmsXRecruitArea);
				}
			}
			Boolean b = this.cmsXRecruitDao.addCmsXRecruit(recruit);
			return b;
		}else{
			return false;
		}

	}

	/**
	 * 查询全部招募信息
	 */
	public DataList selectAllCmsXRecruitGetInfo(String type,String typeId,String title,
			String code,Integer page,Integer pageSize) {
		DataList data = new DataList();
		Map<String, Object> map = new HashMap<String, Object>();
		if(typeId!=null&&typeId!=""){
			typeId = "%"+typeId+"%";
		}
		if(title!=null&&title!=""){
			title = "%"+title+"%";
		}
		if(code!=null&&code!=""){
			code = "%"+code+"%";
		}
		map.put("type", type);
		map.put("typeId", typeId);
		map.put("title", title);
		map.put("code", code);
		map.put("page", page);
		map.put("pageSize", pageSize);
		List<Map<String, Object>> list_Map = this.cmsXRecruitDao.selectAllCmsXRecruitGetInfo(map);
		data.setListData(list_Map);
		data.setSize(this.cmsXRecruitDao.selectAllCmsXRecruitByGetSize(map));
		return data;
	}

	/**
	 * 根据Id查询对应的招募信息
	 */
	public CmsXRecruit selectCmsXRecruitByIdAndInfo(String id) {
		CmsXRecruit recruit = this.cmsXRecruitDao.selectCmsXRecruitByIdAndInfo(id);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("vis", recruit.getVisitTime()+1);
		map.put("id", id);
		this.cmsXRecruitDao.updateGetUserByVisit(map);
		recruit.setCmsXRecruitAreas(this.cmsXRecruitAreaDao.selectCmsXRecruitAreaInfo(id));
		recruit.setCmsXRecruitIndustrys(this.cmsXRecruitIndustryDao.selectCmsXRecruitInduseryInfo(id));
		recruit.setCmsXRecruitProducts(this.cmsXRecruitProductDao.selectCmsXRecruitProductInfo(id));
		return recruit;
	}

	/**
	 * 最新商机
	 */
	public List<Map<String, Object>> selectLatestAndBusinessInfo() {
		// TODO Auto-generated method stub
		return this.cmsXRecruitDao.selectLatestAndBusinessInfo();
	}

	/**
	 * 推荐商机
	 */
	public List<Map<String, Object>> selectGetRecommendedAndBusinessInfo() {
		// TODO Auto-generated method stub
		return this.cmsXRecruitDao.selectGetRecommendedAndBusinessInfo();
	}

}
