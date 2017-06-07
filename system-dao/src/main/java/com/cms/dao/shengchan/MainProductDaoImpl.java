package com.cms.dao.shengchan;

import com.alibaba.fastjson.JSONObject;
import com.cms.mapper.shengchan.MainProductBeanMapper;
import com.cms.model.shengchang.CompBrandBean;
import com.cms.model.shengchang.MainDocBean;
import com.cms.model.shengchang.MainProductBean;
import com.cms.model.shengchang.ProductDocBean;
import com.cms.model.util.Grid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class MainProductDaoImpl implements MainProductDao {
	@Autowired
	private MainProductBeanMapper mainProductBeanMapper;

	public Grid getMainProductList(MainProductBean mainProductBean) {
        Grid grid = new Grid();
        grid.setRows(this.mainProductBeanMapper.getMainProductList(mainProductBean));
        grid.setTotal(this.mainProductBeanMapper.getMainProductCot(mainProductBean));
		return grid;
	}

	public List<MainDocBean> getMainProductDocList(MainProductBean mainProductBean) {
		return mainProductBeanMapper.getMainProductDocList(mainProductBean);
	}

	public void addMainProduct(MainProductBean mainProductBean) {
		this.mainProductBeanMapper.addMainProduct(mainProductBean);
        if (mainProductBean.getMainDocList().size()!=0){
            this.mainProductBeanMapper.addMainProductDoc(mainProductBean.getMainDocList());
        }
	}

    public void delMainProductById(MainProductBean mainProductBean) {
        this.mainProductBeanMapper.delMainProductById(mainProductBean);
    }

    public void updateMainProduct(MainProductBean mainProductBean) {
        this.mainProductBeanMapper.updateMainProduct(mainProductBean);
    }

    public void delMainProductDoc(List<MainDocBean> mainDocBeanList) {
        this.mainProductBeanMapper.delMainProductDoc(mainDocBeanList);
    }

	public void addBrand(CompBrandBean compBrandBean) {
		
		 this.mainProductBeanMapper.addBrand(compBrandBean);
		
	}

	public void updateBrand(JSONObject obj) {
		 this.mainProductBeanMapper.updateBrand(obj);
		
	}

	public void delAllBrand(Long companyId) {
		 this.mainProductBeanMapper.delAllBrand(companyId);
	}

	public List<CompBrandBean> getBrandList(Long companyId) {
		// TODO Auto-generated method stub
		 return this.mainProductBeanMapper.getBrandList(companyId);
	}

	public void delBrand(CompBrandBean compBrandBean) {
		 this.mainProductBeanMapper.delBrand(compBrandBean);
		
	}

	public List<MainDocBean> getMainProductDocListByFilter(JSONObject obj) {
		
		return  this.mainProductBeanMapper.getMainProductDocListByFilter(obj);
	}
	
	public List<ProductDocBean> getProductDocListByFilter(JSONObject obj) {
		
		return  this.mainProductBeanMapper.getProductDocListByFilter(obj);
	}

	public List<Map> getProductPricListByRuleId(Long ruleId) {
		return  this.mainProductBeanMapper.getProductPricListByRuleId(ruleId);
	}
}
