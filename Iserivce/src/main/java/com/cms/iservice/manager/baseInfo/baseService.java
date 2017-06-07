package com.cms.iservice.manager.baseInfo;

import com.alibaba.fastjson.JSONObject;
import com.cms.model.manager.*;
import com.cms.model.util.Grid;
import com.cms.model.util.PageFilter;
import com.cms.model.util.SessionInfo;
import com.cms.model.wuliu.AreaBean;
import com.cms.model.wuliu.CarBean;
import com.cms.model.wuliu.CityBean;

import java.util.List;
import java.util.Map;


public interface baseService {
	public AreaBean getInfoArea(AreaBean bean);
	
	public Grid dataGridArea(AreaBean areaBean, PageFilter ph);

	public void addArea(AreaBean areaBean);

	public void deleteArea(String id);

	public AreaBean getArea(String id);
	
	public void editArea(AreaBean areaBean);
	
	public List<AreaBean> selectAreaJsonArea(String q, String pid);
	
	public List<AreaBean> getAllArea();

    public baseDicBean getInfoBaseDic(baseDicBean bean);

    public Grid dataGridBaseDic(baseDicBean baseDicBean, PageFilter ph);

    public void addBaseDic(baseDicBean baseDicBean);

    public void deleteBaseDic(Long id);

    public baseDicBean getBaseDic(Long id);

    public void updateBaseDic(baseDicBean baseDicBean);

    public List<baseDicBean> treeGridBaseDic();

    public List<Tree> allTreeBaseDic(boolean flag);

    public List<baseDicBean> getByPidBaseDic(String pid);

    public CarBean getInfoCar(CarBean bean);

    public Grid dataGridCar(CarBean carBean, PageFilter ph);

    public void addCar(CarBean carBean);

    public void deleteCar(Long id);

    public CarBean getCar(Long id);

    public void editCar(CarBean carBean);

    public List<CarBean> dataGrid3Car();

    public List<carDicBean> dataGridCarStyle();

    public void addCarStyle(carDicBean bean)throws Exception;

    public carDicBean getCarStyle(JSONObject obj);

    public void updateCarStyle(carDicBean bean)throws Exception;

    public List<Tree> allTreeCarStyle();

    public CityBean getInfoCity(CityBean bean);

    public Grid dataGridCity(CityBean cityBean, PageFilter ph);

    public void addCity(CityBean cityBean);

    public void deleteCity(String id);

    public CityBean getCity(String id);

    public void editCity(CityBean cityBean);

    public List<CityBean> selectCityJsonCity(String p);

    public List<CityBean> selectCityJson2City(String p, String pid, String pid2);

    public comboBean getInfoCombo(comboBean bean);

    public Grid dataGridCombo(comboBean comboBean, PageFilter ph);

    public void addCombo(comboBean comboBean);

    public void deleteCombo(Long id);

    public comboBean getCombo(Long id);

    public void editCombo(comboBean comboBean);

    public void stateCombo(JSONObject obj);

    public lineBean getInfoLine(lineBean bean);

    public Grid dataGridLine(lineBean lineBean, PageFilter ph);

    public void addLine(lineBean lineBean);

    public void deleteLine(String id);

    public lineBean getLine(String id);

    public void editLine(lineBean lineBean);

    public List<lineBean> selectLineJsonLine(String q, String pid);

    public List<menuBean> treeGridMenu();

    public void addMenu(menuBean bean)throws Exception;

    public void deleteMenu(Long id)throws Exception;

    public void updateMenu(menuBean bean)throws Exception;

    public menuBean getMenu(Long id);

    public List<Tree> treeMenu(SessionInfo sessionInfo);

    public List<Tree> allTreeMenu(Boolean flag);

    public List<String> accessListMenu(String userId);

    public List<String> getAllAccessListMenu();

    public messageLogBean getInfoMessageLog(messageLogBean bean);

    public Grid dataGridMessageLog(messageLogBean messageLogBean, PageFilter ph);

    public void addMessageLog(messageLogBean messageLogBean);

    public void deleteMessageLog(Long id);

    public messageLogBean getMessageLog(Long id);

    public void editMessageLog(messageLogBean messageLogBean);

    public mileageBean getInfoMileage(mileageBean bean);

    public Grid dataGridMileage(mileageBean mileageBean, PageFilter ph);

    public void addMileage(mileageBean mileageBean);

    public void deleteMileage(String startid, String endid);

    public mileageBean getMileage(String startid, String endid);

    public void editMileage(mileageBean mileageBean);

    public premiumBean getInfoPremium(premiumBean bean);

    public Grid dataGridPremium(premiumBean premiumBean, PageFilter ph);

    public void addPremium(premiumBean premiumBean);

    public void deletePremium(Long id);

    public premiumBean getPremium(Long id);

    public void editPremium(premiumBean premiumBean);

    public quoteBean getInfoQuote(quoteBean bean);

    public Grid dataGridQuote(quoteBean quoteBean, PageFilter ph);

    public void addQuote(quoteBean quoteBean);

    public void deleteQuote(String bid, String eid);

    public quoteBean getQuote(String bid, String eid);

    public void editQuote(quoteBean quoteBean);

    public Grid dataGridWebRole(webRoleBean role, PageFilter ph);

    public webRoleBean getWebRole(Long id);

    public void updateWebRole(webRoleBean bean)throws Exception;

    public void addWebRole(webRoleBean bean)throws Exception;

    public void deleteWebRole(Long id)throws Exception;

    public void addGrantWebRole(webRoleBean role)throws Exception;
}
