package com.cms.controller.userCenter.sysUserSingelInfo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cms.iservice.common.GlobalIdService;
import com.cms.iservice.userCenter.SysUserGoodsAddressService;
import com.cms.iservice.userCenter.com.IAccountComInfoService;
import com.cms.model.userCenter.SysUserGoodsAddress;

@Controller
@RequestMapping("/sysUserAddressPer")
public class SysUserAddressPerController {
	//注入地址服务
	@Autowired
	private IAccountComInfoService accountComInfoService;
	@Autowired
	private GlobalIdService globalIdService;
	//收货地址页面跳转
	@RequestMapping("/comeAds")
	public ModelAndView comeAds(){
		ModelAndView mView = new ModelAndView("/account-mana-child/acc-address-per");
		//拿到收货地址列表
		List<SysUserGoodsAddress> adsLists= accountComInfoService.findAllComeAds();
		mView.addObject("adsLists", adsLists);
		return mView;
	}
	
	//添加收货地址
	@RequestMapping("/saveComeAds")
	@ResponseBody
	public Map<String, Object> saveComeAds(SysUserGoodsAddress address){
		address.setId(globalIdService.getGlobalId());
		//设为收货地址
		//设置为企业用户的id；
		address.setType("2");
		//从session中拿到系统联系人的uid
		address.setUid(Long.parseLong("695597107440123904"));
		Map<String, Object> map = new HashMap<String, Object>();
		//调用保持service服务
		try {
			accountComInfoService.addComeAds(address);
			map.put("success", "成功保存收货地址");
		} catch (Exception e) {
			map.put("success", "新增收货地址失败");
			e.printStackTrace();
		}
		//返回json数据
		return map;
	}
	
	//ajax删除
	@RequestMapping("/deleteAds")
	@ResponseBody
	public Map<String, Object> deleteAds(String id){
		Map<String, Object> map =new HashMap<String, Object>();
		try {
			accountComInfoService.deleteAds(id);
			map.put("success", "删除成功");
		} catch (Exception e) {
			map.put("success", "系统异常，删除失败");
			e.printStackTrace();
		}
		return map;
	}
	
}
