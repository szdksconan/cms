package com.cms.service.caigou;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.cms.dao.dict.AreaCommonDao;
import com.cms.dao.shengchan.ProductSellRuleDao;
import com.cms.dao.shengchan.PurchaseNeedDao;
import com.cms.iservice.shengchan.PurchaseNeedService;
import com.cms.model.dict.AreaCity;
import com.cms.model.shengchang.MainProductBean;
import com.cms.model.shengchang.ProductPriceBean;
import com.cms.model.shengchang.ProductSellRuleBean;
import com.cms.model.shengchang.PurchaseNeedBean;
import com.cms.model.shengchang.PurchaseNeedDetailBean;
import com.cms.model.shengchang.PurchaseNeedDetailDocBean;
import com.cms.model.shengchang.PurchaseNeedLinkman;
import com.cms.model.shengchang.PurchaseNeedRuleAreaBean;
import com.cms.model.shengchang.PurchaseNeedRuleBean;
import com.cms.model.util.Grid;

/**
 * Created by liuxin on 2016/4/5.
 */
public class PurchaseNeedServiceImpl implements PurchaseNeedService {
	
	@Autowired
    private PurchaseNeedDao purchaseNeedDao;
	
	
	@Autowired
	private ProductSellRuleDao productSellRuleDao;
	
	@Autowired
	private AreaCommonDao areaCommonDao;


    public Grid getPurchaseIntentList() {
        return this.purchaseNeedDao.getPurchaseIntentList();
    }



	public List getPurchaseNeedList(PurchaseNeedBean purchaseNeedBean) {
		
		return this.purchaseNeedDao.getPurchaseNeedList(purchaseNeedBean);
	}

	public void delPurchaseNeedById(String id) {
		
		PurchaseNeedBean purchaseNeedBean = this.purchaseNeedDao.getPurchaseNeedById(id);
		
		id = purchaseNeedBean.getId();
		
	    String ruleId = purchaseNeedBean.getPurchaseRuleId();
	    
		List<PurchaseNeedDetailBean> l = this.purchaseNeedDao.getPurchaseNeedDetailBeanByPid(id);
		
		for(PurchaseNeedDetailBean purchaseNeedDetailBean : l){
			
			String pid = purchaseNeedDetailBean.getId();
			
			this.purchaseNeedDao.delPurchaseNeedDetailDocBeanByPid(pid);
		}
	
		
		this.purchaseNeedDao.delAllPurchaseNeedDetailBean(id);
		
		this.purchaseNeedDao.delAllPurchaseNeedLinkman(id);
		
		this.purchaseNeedDao.delPurchaseNeedRuleBean(ruleId);
		
		this.purchaseNeedDao.delPurchaseNeedById(id);
	}

	public int getPurchaseNeedListNum(PurchaseNeedBean purchaseNeedBean) {
		return this.purchaseNeedDao.getPurchaseNeedListNum(purchaseNeedBean);
	}



	public PurchaseNeedBean getPurchaseNeedById(String id) {
		
		return this.purchaseNeedDao.getPurchaseNeedById(id);
	}



	public void savePurchaseNeed(HashMap map) {
		
		PurchaseNeedBean purchaseNeedBean = (PurchaseNeedBean)map.get("purchaseNeedBean");
		
		List<PurchaseNeedLinkman> addLinklist = (List<PurchaseNeedLinkman>)map.get("addLinklist");
		
		List<PurchaseNeedDetailBean> addDetaillist=(List<PurchaseNeedDetailBean>)map.get("addDetaillist");
		
		PurchaseNeedRuleBean purchaseNeedRuleBean =(PurchaseNeedRuleBean)map.get("purchaseNeedRuleBean");
		
		this.purchaseNeedDao.addPurchaseNeedMain(purchaseNeedBean);
		
		for(PurchaseNeedLinkman purchaseNeedLinkman : addLinklist){
			
			this.purchaseNeedDao.addPurchaseNeedLinkman(purchaseNeedLinkman);
			
		}
		
		for(PurchaseNeedDetailBean purchaseNeedDetailBean : addDetaillist){
			
			this.purchaseNeedDao.addPurchaseNeedDetailBean(purchaseNeedDetailBean);
			
			List<PurchaseNeedDetailDocBean> addDoclist= purchaseNeedDetailBean.getNeedDetailDoc();
			
			for(PurchaseNeedDetailDocBean purchaseNeedDetailDocBean : addDoclist){
				
				this.purchaseNeedDao.addPurchaseNeedDetailDocBean(purchaseNeedDetailDocBean);
				
			}
			
		}
		
		this.purchaseNeedDao.addPurchaseNeedRuleBean(purchaseNeedRuleBean);
		List<PurchaseNeedRuleAreaBean> addRuleAreaList = purchaseNeedRuleBean.getAreaList();
		for(PurchaseNeedRuleAreaBean purchaseNeedRuleAreaBean :addRuleAreaList){
			this.purchaseNeedDao.addPurchaseNeedRuleArea(purchaseNeedRuleAreaBean);
		}
	}



	public void editPurchaseNeed(HashMap map) {
		
		PurchaseNeedBean purchaseNeedBean = (PurchaseNeedBean)map.get("purchaseNeedBean");
		
		List<PurchaseNeedLinkman> editLinklist = (List<PurchaseNeedLinkman>)map.get("editLinklist");
		
		List<PurchaseNeedDetailBean> editDetaillist=(List<PurchaseNeedDetailBean>)map.get("editDetaillist");
		
		PurchaseNeedRuleBean purchaseNeedRuleBean =(PurchaseNeedRuleBean)map.get("purchaseNeedRuleBean");
		
		this.purchaseNeedDao.delAllPurchaseNeedDetailBean(purchaseNeedBean.getId());
		
		this.purchaseNeedDao.delAllPurchaseNeedLinkman(purchaseNeedBean.getId());
		
		this.purchaseNeedDao.editPurchaseNeedMain(purchaseNeedBean);
		
		for(PurchaseNeedLinkman purchaseNeedLinkman : editLinklist){
			this.purchaseNeedDao.addPurchaseNeedLinkman(purchaseNeedLinkman);
		}
		
		for(PurchaseNeedDetailBean purchaseNeedDetailBean : editDetaillist){
			
			this.purchaseNeedDao.addPurchaseNeedDetailBean(purchaseNeedDetailBean);
			
			//删除相关文档信息
			this.purchaseNeedDao.delPurchaseNeedDetailDocBeanByPid(purchaseNeedDetailBean.getId());
			
			List<PurchaseNeedDetailDocBean> editDoclist= purchaseNeedDetailBean.getNeedDetailDoc();
			
			
			for(PurchaseNeedDetailDocBean purchaseNeedDetailDocBean : editDoclist){
					
					this.purchaseNeedDao.addPurchaseNeedDetailDocBean(purchaseNeedDetailDocBean);
					
				}
			}
		
		this.purchaseNeedDao.editPurchaseNeedRuleBean(purchaseNeedRuleBean);
		
		this.purchaseNeedDao.delPurchaseNeedRuleArea(purchaseNeedRuleBean.getId());
		
		List<PurchaseNeedRuleAreaBean> editRuleAreaList = purchaseNeedRuleBean.getAreaList();
		
		for(PurchaseNeedRuleAreaBean purchaseNeedRuleAreaBean :editRuleAreaList){
			
			this.purchaseNeedDao.addPurchaseNeedRuleArea(purchaseNeedRuleAreaBean);
		
		}
		
	}



	public PurchaseNeedRuleBean getPurchaseNeedRuleBeanById(String id) {
		
		PurchaseNeedRuleBean purchaseNeedRuleBean = this.purchaseNeedDao.getPurchaseNeedRuleBeanById(id);
		
		PurchaseNeedRuleAreaBean areaBean = new PurchaseNeedRuleAreaBean();
		
		areaBean.setRuleId(purchaseNeedRuleBean.getId());
		
		purchaseNeedRuleBean.setAreaList(this.purchaseNeedDao.getPurchaseNeedRuleAreaBeanBy(areaBean)); 
		
		return purchaseNeedRuleBean;
				
	}



	public List<PurchaseNeedDetailBean> getPurchaseNeedDetailBeanByPid(String pid) {
		
		List<PurchaseNeedDetailBean> detailist =  this.purchaseNeedDao.getPurchaseNeedDetailBeanByPid(pid);
		
		List list = new ArrayList();
		
		for(PurchaseNeedDetailBean purchaseNeedDetailBean : detailist){
			
			List<PurchaseNeedDetailDocBean> doclist = this.purchaseNeedDao.getPurchaseNeedDetailDocBeanByPid(purchaseNeedDetailBean.getId());
			
			purchaseNeedDetailBean.setNeedDetailDoc(doclist);
			
			list.add(purchaseNeedDetailBean);
			
		}
		
		return list;
		
	}



	public List<PurchaseNeedLinkman> getPurchaseNeedLinkmanByPurchaseNeedId(String purchaseNeedId) {
		
		return this.purchaseNeedDao.getPurchaseNeedLinkmanByPurchaseNeedId(purchaseNeedId);
		
	}

    public Grid getPurchaseNeedDetail(PurchaseNeedDetailBean purchaseNeedDetailBean) {
        return this.purchaseNeedDao.getPurchaseNeedDetail(purchaseNeedDetailBean);
    }

    public List getProductTypeCot() {
        return this.purchaseNeedDao.getProductTypeCot();
    }



	public List getProductByIds(List l) {
		
		return null;
	}



	public List<AreaCity> getCityByProvinceId(HashMap map) {
		
		List areaList = (List) map.get("areaList");
	
		return this.areaCommonDao.getCityByProvinceId(areaList);
	}



	public List<ProductPriceBean> getProductPriceByProductIdAndAreaId(String  productId,String area) {
		this.purchaseNeedDao.getProductPriceByProductIdAndAreaId(productId,area);
		return null;
	}







//	public List getProductByIds(List l) {
//		String area = "四川"
//		for(int i=0;i<l.size();i++){
//			MainProductBean mainProductBean = new MainProductBean();
//			mainProductBean.setId(l.get(i).toString());
//			List<ProductSellRuleBean> ruleList = this.productSellRuleDao.getProductSellRule(mainProductBean);
//			return null;
//		}
//	}

    
}
