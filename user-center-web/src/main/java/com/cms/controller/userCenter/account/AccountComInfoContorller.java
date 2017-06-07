package com.cms.controller.userCenter.account;

import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.cms.iservice.common.GlobalIdService;
import com.cms.iservice.userCenter.com.IAccountComInfoService;
import com.cms.model.userCenter.SysUser;
import com.cms.model.userCenter.SysUserEnterpriseInfo;
import com.cms.model.userCenter.SysUserGoodsAddress;
import com.cms.service.fastdfs.FastdfsClient;
import com.cms.service.fastdfs.FastdfsClientFactory;

/**
 * @author penglei
 *
 * 2016年2月18日
 */
@Controller
@RequestMapping("/accountCom")
public class AccountComInfoContorller {
	
	@Autowired
	private IAccountComInfoService accountComInfoService;
    
	@Autowired
	private GlobalIdService globalIdService;
	
	/**
	 * 跳转企业账户页面
	 * @param request
	 * @return
	 */
	@RequestMapping("/index")
	public String index(String uname) {
	
		return "/account-mana-com";
	}
	
    //企业账户基本信息展示
	@RequestMapping("/basicInfo")
	public ModelAndView basicInfo(){
		//从sesion中拿到登uid
		String uid="695597107440123905";
		//从session中拿到uid
		ModelAndView mView=new ModelAndView("/account-mana-child/com/accInfo/basicInfo");
		//调用服务层查到基本信息
		SysUser sysUser = accountComInfoService.getSysUser(uid);
		if(sysUser!=null){
			mView.addObject("sysUser",sysUser);
		}
		return mView;
	}
	
	//企业基本信息表单更新提交
	@RequestMapping("/saveBasicInfo")
	@ResponseBody
	public Map<String, Object> saveBasicInfo(SysUser sysUser){
		System.out.println("基本信息保存==》"+sysUser);
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			accountComInfoService.updateBasicInfo(sysUser);
			map.put("success", "添加修改成功！");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", "添加修改失败！");
		}
		//页面跳转
		return map;
	}
	
	//企业信息跳转
	@RequestMapping("/companyInfo")
	public ModelAndView companyInfo(){
		ModelAndView mView=new ModelAndView("/account-mana-child/com/accInfo/companyInfo");
		//从sesion中拿到登陆账户名或者uid
		String uid="695597107440123905";
		SysUserEnterpriseInfo enterpriseInfo =accountComInfoService.getEnterpriseInfo(uid);
		mView.addObject("enterpriseInfo",enterpriseInfo);
		//跳转到页面
		return mView;
	}
	
	//企业信息保存
	@RequestMapping("/saveCompanyInfo")
	@ResponseBody
	public Map<String, Object> saveCompanyInfo(SysUserEnterpriseInfo enterpriseInfo){
		System.out.println("企业信息保存传到后台的值--->"+enterpriseInfo);
		Map<String, Object> map = new HashMap<String, Object>();
		//判断修改或者保存企业信息
		if(0!=enterpriseInfo.getEid()){
		   //调用服务层修改企业信息数据
			System.out.println("更新");
			try {
				accountComInfoService.updateEnterpriseInfo(enterpriseInfo);
				map.put("success", "企业信息更新成功");
			} catch (Exception e) {
				map.put("success", "企业信息更新失败");
				e.printStackTrace();
			}
		}else{
			System.out.println("保存");
			enterpriseInfo.setEid(globalIdService.getGlobalId());
			try {
				accountComInfoService.saveEnterpriseInfo(enterpriseInfo);
				map.put("success", "企业信息保存成功");
			} catch (Exception e) {
				map.put("success", "企业信息保存失败");
				e.printStackTrace();
			}
		}
		//页面跳转
		return map;
	}
	
	
	//企业标志上传保存
	@RequestMapping("/saveImage")
	@ResponseBody
	public String saveImage(MultipartFile uploadImage){
		System.out.println("上传过来的图片"+uploadImage);
		 CommonsMultipartFile cf= (CommonsMultipartFile)uploadImage;
	        DiskFileItem f = (DiskFileItem)cf.getFileItem();
	        File file = f.getStoreLocation(); 
		FastdfsClient client = FastdfsClientFactory.getFastdfsClient();
		String uri="";
		try {
			System.out.println("88888888888888888888888"+file);
			 uri = client.upload(file);
			System.out.println("返回的路径--->"+uri);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	
	
	
	//账户安全页面跳转
	@RequestMapping("/accountSafety")
	public String accountSafaty(){
		System.out.println("账户安全页面跳转");
		return "/account-mana-child/acc-safety-com";
	}
	
	//账户管理页面跳转
	@RequestMapping("/accountManage")
	public String accountManage(){
		System.out.println("账户管理页面跳转");
		return "/account-mana-child/acc-mana-com";
	}
	
	
	//收货地址页面跳转
	@RequestMapping("/comeAds")
	public ModelAndView comeAds(){
		ModelAndView mView = new ModelAndView("/account-mana-child/com/adsmana/comeAds");
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
		address.setType("1");
		//从session中拿到系统联系人的uid
		address.setUid(Long.parseLong("95597107440123905"));
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
