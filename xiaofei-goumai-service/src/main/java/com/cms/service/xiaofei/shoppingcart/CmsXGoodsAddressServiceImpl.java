package com.cms.service.xiaofei.shoppingcart;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.cms.dao.xiaofei.CmsXGoodsAddressDao;
import com.cms.iservice.xiaofei.CmsXGoodsAddressService;
import com.cms.model.xiaofei.CmsXGoodsAddress;
import com.cms.model.xiaofei.CmsXOrderEvaluation;
import com.cms.model.xiaofei.CmsXProductEvaluation;
import com.cms.model.xiaofei.DataList;

public class CmsXGoodsAddressServiceImpl implements CmsXGoodsAddressService {
	@Autowired
	private CmsXGoodsAddressDao cmsXGoodsAddressDao;
	/**
	 * 用户添加收货地址
	 */
	public void addUserAndDeliveryAndAddress(CmsXGoodsAddress cmsXGoodsAddress) {
		if(this.cmsXGoodsAddressDao.selectUserAndGoodsAndAddressSize(cmsXGoodsAddress.getUserId())<4){
			this.cmsXGoodsAddressDao.addUserAndDeliveryAndAddress(cmsXGoodsAddress);
		}
	}
	/**
	 * 根据用户查询用户的收货地址
	 */
	public DataList selectUserAndGoodsAndAddress(String uId) {
		DataList data = new DataList();
		data.setListData(this.cmsXGoodsAddressDao.selectUserAndGoodsAndAddress(uId));
		data.setSize(this.cmsXGoodsAddressDao.selectUserAndGoodsAndAddressSize(uId));
		return data;
	}
	public CmsXGoodsAddress selectUserAndGoodsAndAddressId(String addressId)
	{
		return this.cmsXGoodsAddressDao.selectUserAndGoodsAndAddressId(addressId);
	}
	public Integer updateUserAndGoodsAndAddressId(CmsXGoodsAddress address) {
		// TODO Auto-generated method stub
		return cmsXGoodsAddressDao.updateUserAndGoodsAndAddressId( address);
	}
	public boolean deleteOderByIdGetUser(String id) {
		if(id!=null&&id!=""){
			return this.cmsXGoodsAddressDao.deleteOderByIdGetUser(id);
		}
		return false;
	}
	public Integer setPininsertSelective(CmsXProductEvaluation cpe){
		
		return cmsXGoodsAddressDao.setPininsertSelective(cpe);
	}
	public Integer setPinOrderinsertSelective(CmsXOrderEvaluation coe){
		return cmsXGoodsAddressDao.setPinOrderinsertSelective(coe);
	}
	public DataList selectAllCmsXOrderEvaluation(CmsXOrderEvaluation coe,Integer page,Integer pagesize) {
		// TODO Auto-generated method stub
		DataList dl=new DataList();
		System.out.println("--------------");
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("page", page);
		map.put("pagesize", pagesize);
		map.put("userId", coe.getUserId());
		map.put("orderId", coe.getOrderId());
		
		dl.setListData(cmsXGoodsAddressDao.selectAllCmsXOrderEvaluation(map));
		dl.setSize(cmsXGoodsAddressDao.selectAllCmsXOrderEvaluationCount(map));
		return dl;
	}
	
	public DataList selectAllCmsXProductEvaluation(String productId,String storeId,Integer page,Integer pagesize,String level){
		DataList dl=new DataList();
		System.out.println("level==================="+level);
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("productId", productId);
		map.put("storeId", storeId);
		map.put("page", page);
		map.put("pagesize", pagesize);
		map.put("level", level);
		dl.setListData(cmsXGoodsAddressDao.selectAllCmsXProductEvaluation(map));
		dl.setSize(cmsXGoodsAddressDao.selectAllCmsXProductEvaluationCount(map));
		return dl;
	}


}
