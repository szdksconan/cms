package com.cms.company.out;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.cms.dao.shengchan.CompanyDao;
import com.cms.iservice.shengchan.CompanyOutService;
import com.cms.iservice.shengchan.MainProductService;
import com.cms.model.shengchang.CompBaseInfo;
import com.cms.model.shengchang.CompanyToOutBean;
import com.cms.model.shengchang.MainDocBean;
import com.cms.model.shengchang.MainProduct;
import com.cms.model.shengchang.MainProductBean;

public class CompanyOutServiceImpl implements CompanyOutService {
	@Autowired
	private CompanyDao companyDao;
	@Autowired
	private MainProductService mainProductService;
	
	public CompanyToOutBean getOutBeanById(String id) {
		
		List<MainProduct> mainp=new ArrayList<MainProduct>();
		
		MainProductBean main = new MainProductBean();
		main.setCompanyId(id);
		
		List<MainDocBean> maindocls = null;
		CompanyToOutBean out = new CompanyToOutBean();
		
		List<MainProductBean> mplist = mainProductService.getMainProductById(main);
		
		for(int i=0;i<mplist.size();i++){
			
			MainProductBean mpbean= mplist.get(i);
			maindocls = mainProductService.getMainProductDocListByFilter(Long.parseLong(mpbean.getId()), "2", "1");
			for(int k=0;k<maindocls.size();k++){
				MainDocBean mdb = maindocls.get(k);
				MainProduct mpt = new MainProduct();
				mpt.setSetIntroduce(mpbean.getSetIntroduce());
				mpt.setFileurl(mdb.getFileUrl());
				System.out.println(mpbean.getSetIntroduce());
				System.out.println(mdb.getFileUrl());
				System.out.println(mpt);
				mainp.add(mpt);
				System.out.println(mainp);
						
			}
		}
		CompBaseInfo base = companyDao.getById(id);
		List attach = companyDao.getCompAttachInfo(id);
		List contact = companyDao.getCompContactInfo(id);
		out.setBase(base);
		out.setAttach(attach);
		out.setContact(contact);
		out.setMainProduct(mainp);
		
		return out;
	}
	
	
	
	
}
