package com.cms.controller.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.cms.iservice.maoyi.EnterpriseToOutService;
import com.cms.iservice.maoyi.ProductCenterService;
import com.cms.iservice.shengchan.CompanyService;
import com.cms.iservice.shengchan.MainProductService;
import com.cms.model.maoyi.CmsProduct;
import com.cms.model.maoyi.EnterpriseInfo;
import com.cms.model.maoyi.EnterpriseToOutBean;
import com.cms.model.shengchang.CompAttachRel;
import com.cms.model.shengchang.CompBaseInfo;
import com.cms.model.shengchang.CompSuppliers;
import com.cms.model.shengchang.CompanyAreaProvince;
import com.cms.model.shengchang.MainDocBean;
import com.cms.model.shengchang.MainProductBean;
import com.cms.model.util.Addresses;
import com.cms.model.util.CompanyAddress;
import com.cms.model.util.GlobalTypeEnum;
import com.cms.model.util.Grid;
import com.cms.model.util.PageFilter;
import com.cms.model.util.SupplierTypeEnum;

@Controller
@RequestMapping("supplier")
public class SupplierController {
	@Autowired
	private CompanyService companyService;
	@Autowired
	private MainProductService mainProductService;
	@Autowired
	private EnterpriseToOutService enterpriseToOutService;
	@Autowired
	private ProductCenterService productCenterService;

	@RequestMapping("list")
	@ResponseBody
	public JSONObject getSupplier(PageFilter pageFileter, CompBaseInfo compBaseInfo) {
		compBaseInfo.setCompid("1312312313");
		JSONObject obj = new JSONObject();
		Grid grid = new Grid();
		// 使用 companyservice中的方法获得所有的 企业信息
		List<CompBaseInfo> list = companyService.pageAllSupliers(pageFileter, compBaseInfo,
				SupplierTypeEnum.hezuo.getCode().toString(), SupplierTypeEnum.shengchanshang.getCode().toString());
		Map<String, Object> infoMap = getEnterInfoByMaoyi(list, pageFileter, compBaseInfo,
				SupplierTypeEnum.hezuo.getCode().toString(), SupplierTypeEnum.maoyishang.getCode().toString());
		List<CompBaseInfo> enterInfoByMaoyi = (List<CompBaseInfo>) infoMap.get("compbaseInfo");
		Map<String, List<CompanyAddress>> address = (Map<String, List<CompanyAddress>>) infoMap.get("address");
		// 对得到的map进行取值处理
		List<Addresses> info = getAdress(address);
		int total = companyService.getSupplierTotal(compBaseInfo, SupplierTypeEnum.hezuo.getCode().toString(),
				SupplierTypeEnum.shengchanshang.toString());
		int totalMaoyi = companyService.getTotalSupplierMaoyi(SupplierTypeEnum.hezuo.getCode().toString(),
				SupplierTypeEnum.maoyishang.getCode().toString(), compBaseInfo);
		obj.put("rows", enterInfoByMaoyi);
		obj.put("total", total + totalMaoyi);
		obj.put("address", info);
		return obj;
	}

	private List<Addresses> getAdress(Map<String, List<CompanyAddress>> address) {
		Set keySet = address.keySet();// 返回键的集合
		List<Addresses> info = new ArrayList<>();
		Iterator it = keySet.iterator();
		while (it.hasNext()) // 第一种迭代方式取键值
		{
			String key = (String) it.next();
			Addresses addr = new Addresses();
			addr.setProvince(key);
			addr.setAddr(address.get(key));
			info.add(addr);
		}
		return info;
	}

	@RequestMapping("getBeixuan")
	@ResponseBody
	public JSONObject getBeixuan(PageFilter pageFileter, CompBaseInfo compBaseInfo) {
		compBaseInfo.setCompid("1312312313");
		JSONObject obj = new JSONObject();
		try {
			int total = companyService.getSupplierTotal(compBaseInfo, SupplierTypeEnum.guanzhu.getCode().toString(),
					SupplierTypeEnum.shengchanshang.getCode().toString());
			List<CompBaseInfo> list = companyService.pageAllSupliers(pageFileter, compBaseInfo,
					SupplierTypeEnum.guanzhu.getCode().toString(),
					SupplierTypeEnum.shengchanshang.getCode().toString());
			List<CompBaseInfo> lists = new ArrayList();
			for (CompBaseInfo compBaseInfo2 : list) {
				MainProductBean main = new MainProductBean();
				main.setCompanyId(compBaseInfo2.getCompid());
				main.setState(GlobalTypeEnum.NORMALSELL.getCode());
				List<MainProductBean> mainproduct = mainProductService.getMainProductById(main);
				for (MainProductBean mainProductBean : mainproduct) {
					compBaseInfo2.setMainDocList(mainProductBean.getMainDocList());
				}
				lists.add(compBaseInfo2);

			}
			Map<String, Object> infoMap = getEnterInfoByMaoyi(lists, pageFileter, compBaseInfo,
					SupplierTypeEnum.guanzhu.getCode().toString(), SupplierTypeEnum.maoyishang.getCode().toString());
			List<CompBaseInfo> enterInfoByMaoyi = (List<CompBaseInfo>) infoMap.get("compbaseInfo");
			Map<String, List<CompanyAddress>> address = (Map<String, List<CompanyAddress>>) infoMap.get("address");
			List<Addresses> info = getAdress(address);
			int totalMaoyi = companyService.getTotalSupplierMaoyi(SupplierTypeEnum.guanzhu.getCode().toString(),
					SupplierTypeEnum.maoyishang.getCode().toString(), compBaseInfo);
			// //获取主营产品
			obj.put("rows", enterInfoByMaoyi);
			obj.put("address", info);
			obj.put("total", total + totalMaoyi);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}

	@RequestMapping("deleteSupplier")
	@ResponseBody
	public JSONObject deleteSupplier(String id) {
		JSONObject obj = new JSONObject();
		try {
			companyService.deleteSupplier(id);
			obj.put("success", true);
		} catch (Exception e) {
			e.printStackTrace();
			obj.put("success", false);
		}
		return obj;
	}

	private Map<String, Object> getEnterInfoByMaoyi(List<CompBaseInfo> rows, PageFilter pageFileter,
			CompBaseInfo compBaseInfo, String supplierRelationship, String applyType) {
		String compId = "1312312313";
		compBaseInfo.setCompid(compId);
		List<CompSuppliers> allSupplierIdByCompId = companyService.getEnterpriseInfo(supplierRelationship, applyType,
				pageFileter, compBaseInfo);
		List<CompBaseInfo> rows1 = new ArrayList<>();
		// 创建一个set 用来存放数据
		Map<String, List<CompanyAddress>> address = new HashMap<>();
		for (CompBaseInfo compbaseinfo1 : rows) {
			List<CompAttachRel> attachInfoById = companyService.getAttachInfoById(compbaseinfo1.getCompid());
			for (CompAttachRel compAttachRel : attachInfoById) {
				if (compAttachRel.getRelType().equals("6")) {
					compbaseinfo1.setLogoPath(compAttachRel.getAttaUrl());
				}
			}
			rows1.add(compbaseinfo1);
		}

		for (CompSuppliers compSuppliers : allSupplierIdByCompId) {
			 EnterpriseInfo enterpriseInfo = enterpriseToOutService
			 .getEnterpriseOutInfo(
			 Long.parseLong(compSuppliers.getSupplierId().toString())).getEnterpriseInfo();
			 CompBaseInfo obj2toComBaseInfo =
			 obj2toComBaseInfo(enterpriseInfo, compSuppliers);
			 rows1.add(obj2toComBaseInfo);
		}
		
		for (CompBaseInfo compBaseInfo2 : rows1) {
			String shengId = compBaseInfo2.getShengId();
			// 根据省份id 获得 所需要的省份名字
			CompanyAreaProvince province = companyService.getProvince(shengId);
			String key = province.getProvinceName();
			List<CompanyAddress> list = address.get(key);
			if (list == null) {
				address.put(key, new ArrayList<CompanyAddress>());
				CompanyAddress addre = new CompanyAddress();
				addre.setCompId(compBaseInfo2.getCompid());
				addre.setCompanyName(compBaseInfo2.getCompanyName());
				addre.setSupplierType(compBaseInfo2.getCompSuppliers().getSupplierType().toString());
				address.get(key).add(addre);
			} else {
				CompanyAddress addre = new CompanyAddress();
				addre.setCompId(compBaseInfo2.getCompid());
				addre.setCompanyName(compBaseInfo2.getCompanyName());
				addre.setSupplierType(compBaseInfo2.getCompSuppliers().getSupplierType().toString());
				address.get(key).add(addre);
			}
		}
		Map<String, Object> infoMap = new HashMap();
		infoMap.put("compbaseInfo", rows1);
		infoMap.put("address", address);
		return infoMap;
	}

	private CompBaseInfo obj2toComBaseInfo(EnterpriseInfo enterpriseInfo, CompSuppliers compSuppliers) {
		CompBaseInfo compbaseInfo = new CompBaseInfo();
		compbaseInfo.setCompid(enterpriseInfo.getId().toString());
		compbaseInfo.setCompanyName(enterpriseInfo.getName());
		compbaseInfo.setCompType(enterpriseInfo.getEnterpriseType());
		compbaseInfo.setMainIndustry(enterpriseInfo.getBusinessIndustry());
		compbaseInfo.setAddress(enterpriseInfo.getManaAddAn());
		compbaseInfo.setOwners(enterpriseInfo.getManageScale());
		compbaseInfo.setTel(enterpriseInfo.getContactTel());
		if (compSuppliers != null) {
			compbaseInfo.setCompSuppliers(compSuppliers);
		}
		compbaseInfo.setCompZuobiao(enterpriseInfo.getManaAddAl());
		compbaseInfo.setLogoPath(enterpriseInfo.getLogoPath());
		compbaseInfo.setShengId("001023");
		compbaseInfo.setMainProductDesc(enterpriseInfo.getProduct());
		 HashMap<String, CmsProduct> cmsProduct = new HashMap();
		 CmsProduct cp = new CmsProduct();
		 cp.setEnterpriceId(compSuppliers.getSupplierId().toString());
		 cmsProduct.put("cmsProduct", cp);
		 List<CmsProduct> selectProductList =
		 productCenterService.selectProductList(cmsProduct);
		 List<MainDocBean> beans = new ArrayList<MainDocBean>();
		 for (CmsProduct cmsProduct2 : selectProductList) {
		 CmsProduct selectProductInfoById =
		 productCenterService.selectProductInfoById(cmsProduct2.getProductId());
		 MainDocBean bean = new MainDocBean();
		 bean.setFileUrl(selectProductInfoById.getProductMainImg());
		 beans.add(bean);
		 compbaseInfo.setMainDocList(beans);
		 }

		return compbaseInfo;
	}

	@RequestMapping("getCompbaseInfo")
	@ResponseBody
	public JSONObject getCompbaseInfo(Long compids, String supplierType) {
		JSONObject obj = new JSONObject();
		CompBaseInfo obj2toComBaseInfo = new CompBaseInfo();
		if (supplierType.equals(SupplierTypeEnum.maoyishang.getCode().toString())) {
			// 调用贸易商的接
			compids=952719890107511324L;
			  EnterpriseToOutBean enterpriseOutInfo = enterpriseToOutService .getEnterpriseOutInfo(compids);
			  EnterpriseInfo enterpriseInfo = new EnterpriseInfo();
			 if(enterpriseOutInfo!=null){
				 enterpriseInfo = enterpriseOutInfo.getEnterpriseInfo();
			 }
			 System.out.println(compids);
			 CompSuppliers compSuppliers =
			 companyService.getCompSuppliers(compids.toString(),
			 SupplierTypeEnum.hezuo.getCode().toString(), supplierType);
			 obj2toComBaseInfo =
			 obj2toComBaseInfo(enterpriseInfo,compSuppliers);
		} else {
			CompSuppliers compSuppliers = companyService.getCompSuppliers(compids.toString(),
					SupplierTypeEnum.hezuo.getCode().toString(), supplierType);
			obj2toComBaseInfo = companyService.getCompanyInfoById(compids.toString());
			obj2toComBaseInfo.setCompSuppliers(compSuppliers);
			List<CompAttachRel> attachInfoById = companyService.getAttachInfoById(compids.toString());
			for (CompAttachRel compAttachRel : attachInfoById) {
				if (compAttachRel.getRelType().equals("6")) {
					obj2toComBaseInfo.setLogoPath(compAttachRel.getAttaUrl());
				}
			}
		}
		obj.put("rows", obj2toComBaseInfo);
		return obj;
	}
}
