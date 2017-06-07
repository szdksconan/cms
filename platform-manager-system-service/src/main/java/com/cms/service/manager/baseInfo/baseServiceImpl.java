package com.cms.service.manager.baseInfo;


import com.alibaba.fastjson.JSONObject;
import com.cms.dao.manager.baseInfo.*;
import com.cms.dao.manager.role.roleDao;
import com.cms.iservice.common.GlobalIdService;
import com.cms.iservice.manager.baseInfo.baseService;
import com.cms.model.manager.*;
import com.cms.model.util.Grid;
import com.cms.model.util.PageFilter;
import com.cms.model.util.SessionInfo;
import com.cms.model.wuliu.AreaBean;
import com.cms.model.wuliu.CarBean;
import com.cms.model.wuliu.CityBean;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class baseServiceImpl implements baseService {
	@Autowired
	private areaDao areaDao;
    @Autowired
    private baseDicDao baseDicDao;
    @Autowired
    private carDicDao carDicDao;
    @Autowired
    private comboDao comboDao;
    @Autowired
    private lineDao lineDao;
    @Autowired
    private menuDao menuDao;
    @Autowired
    private roleDao roleDao;
    @Autowired
    private messageLogDao messageLogDao;
    @Autowired
    private mileageDao mileageDao;
    @Autowired
    private premiumDao premiumDao;
    @Autowired
    private quoteDao quoteDao;
    @Autowired
    private webRoleDao webRoleDao;
    @Autowired
    private carDao carDao;
    @Autowired
    private cityDao cityDao;
    
    @Autowired
    private GlobalIdService globalIdService;

	public AreaBean getInfoArea(AreaBean bean) {
		return this.areaDao.getInfo(bean);
	}


	public Grid dataGridArea(AreaBean areaBean, PageFilter ph) {

		Grid grid = new Grid();
		JSONObject obj = (JSONObject) JSONObject.toJSON(areaBean);
		obj.put("order", ph.getOrderString());
		grid.setRows(this.areaDao.dataGrid(obj));
		grid.setTotal(this.areaDao.dataGridCot(obj));
		return grid;
	}

	public void addArea(AreaBean areaBean) {
		this.areaDao.add(areaBean);

	}

	public void deleteArea(String id) {
		JSONObject obj = new JSONObject();
		obj.put("id", id);
		this.areaDao.delete(obj);
	}

	public AreaBean getArea(String id) {
		JSONObject obj = new JSONObject();
		obj.put("id", id);
		return	this.areaDao.get(id);
	}


	public void editArea(AreaBean areaBean) {
		this.areaDao.edit(areaBean);
	}

	public List<AreaBean> selectAreaJsonArea(String q,String pid){
		JSONObject obj = new JSONObject();
		obj.put("pid", pid);
		obj.put("q", q);
		return	this.areaDao.selectAreaJson(obj);
	}


	public List<AreaBean> getAllArea() {
		return this.areaDao.dataGrid(null);
	}

    
    public baseDicBean getInfoBaseDic(baseDicBean bean) {
        return this.baseDicDao.getInfo(bean);
    }

    
    public Grid dataGridBaseDic(baseDicBean baseDicBean, PageFilter ph) {
        JSONObject obj = (JSONObject) JSONObject.toJSON(baseDicBean);
        obj.put("order", ph.getOrderString());
        Grid grid = new Grid();
        grid.setRows(this.baseDicDao.dataGrid(obj));
        grid.setTotal(this.baseDicDao.dataGridCot(obj));
        return grid;
    }

    
    public void addBaseDic(baseDicBean baseDicBean) {
        this.baseDicDao.add(baseDicBean);
    }

    
    public void deleteBaseDic(Long id) {
        JSONObject obj = new JSONObject();
        obj.put("id", id);
        this.baseDicDao.delete(obj);
    }

    
    public baseDicBean getBaseDic(Long id) {
        JSONObject obj = new JSONObject();
        obj.put("id", id);
        return	this.baseDicDao.get(id);
    }

    
    public void updateBaseDic(baseDicBean baseDicBean) {
        this.baseDicDao.edit(baseDicBean);
    }

    
    public List<baseDicBean> treeGridBaseDic() {
        JSONObject obj = new JSONObject();
        return this.baseDicDao.getAllDic(obj);
    }

    
    public List<Tree> allTreeBaseDic(boolean flag) {
        JSONObject obj = new JSONObject();
        obj.put("flag", flag?1:0);
        return this.buildTree(this.baseDicDao.getAllDic(obj));
    }

    
    public List<baseDicBean> getByPidBaseDic(String pid) {
        JSONObject obj = new JSONObject();
        obj.put("pid", pid);
        return this.baseDicDao.getByPid(obj);
    }

    
    public CarBean getInfoCar(CarBean bean) {
        return this.carDao.getInfo(bean);
    }

    
    public Grid dataGridCar(CarBean carBean, PageFilter ph) {
        JSONObject obj = (JSONObject) JSONObject.toJSON(carBean);
        obj.put("order", ph.getOrderString());
        Grid grid = new Grid();
        grid.setRows(this.carDao.dataGrid(obj));
        grid.setTotal(this.carDao.dataGridCot(obj));
        return grid;
    }

    
    public void addCar(CarBean carBean) {
        this.carDao.add(carBean);
    }

    
    public void deleteCar(Long id) {
        JSONObject obj = new JSONObject();
        obj.put("id", id);
        this.carDao.delete(obj);
    }

    
    public CarBean getCar(Long id) {
        JSONObject obj = new JSONObject();
        obj.put("id", id);
        return	this.carDao.get(id);
    }

    
    public void editCar(CarBean carBean) {
        this.carDao.edit(carBean);
    }

    
    public List<CarBean> dataGrid3Car() {
        JSONObject obj = new JSONObject();
        return this.carDao.dataGrid3(obj);
    }

    
    public List<carDicBean> dataGridCarStyle() {
        return this.carDicDao.dataGrid(null);
    }

    
    public void addCarStyle(carDicBean bean) throws Exception {
        this.carDicDao.add(bean);
    }

    
    public carDicBean getCarStyle(JSONObject obj) {
        return	this.carDicDao.get(obj);
    }

    
    public void updateCarStyle(carDicBean bean) throws Exception {
        JSONObject obj = (JSONObject) JSONObject.toJSON(bean);
        this.carDicDao.update(obj);
    }

    
    public List<Tree> allTreeCarStyle() {
        return this.buildTree(this.carDicDao.dataGrid(null));
    }

    
    public CityBean getInfoCity(CityBean bean) {
        return this.cityDao.getInfo(bean);
    }

    
    public Grid dataGridCity(CityBean cityBean, PageFilter ph) {
        JSONObject obj = (JSONObject) JSONObject.toJSON(cityBean);
        obj.put("order", ph.getOrderString());
        Grid grid = new Grid();
        grid.setRows(this.cityDao.dataGrid(obj));
        grid.setTotal(this.cityDao.dataGridCot(obj));
        return grid;
    }

    
    public void addCity(CityBean cityBean) {
        this.cityDao.add(cityBean);
    }

    
    public void deleteCity(String id) {
        JSONObject obj = new JSONObject();
        obj.put("id", id);
        this.cityDao.delete(obj);
    }

    
    public CityBean getCity(String id) {
        JSONObject obj = new JSONObject();
        obj.put("id", id);
        return	this.cityDao.get(id);
    }

    
    public void editCity(CityBean cityBean) {
        this.cityDao.edit(cityBean);
    }

    
    public List<CityBean> selectCityJsonCity(String p) {
        JSONObject obj = new JSONObject();
        obj.put("p", p);
        return this.cityDao.selectCityJson(obj);
    }

    
    public List<CityBean> selectCityJson2City(String p, String pid, String pid2) {
        JSONObject obj = new JSONObject();
        obj.put("p", p);
        obj.put("pid", pid);
        obj.put("pid2", pid2);
        return this.cityDao.selectCityJson2(obj);
    }

    
    public comboBean getInfoCombo(comboBean bean) {
        return this.comboDao.getInfo(bean);
    }

    
    public Grid dataGridCombo(comboBean comboBean, PageFilter ph) {
        JSONObject obj = (JSONObject) JSONObject.toJSON(comboBean);
        obj.put("order", ph.getOrderString());
        Grid grid = new Grid();
        grid.setRows(this.comboDao.dataGrid(obj));
        grid.setTotal(this.comboDao.dataGridCot(obj));
        return grid;
    }

    
    public void addCombo(comboBean comboBean) {
        this.comboDao.add(comboBean);
    }

    
    public void deleteCombo(Long id) {
        JSONObject obj = new JSONObject();
        obj.put("id", id);
        this.comboDao.delete(obj);
    }

    
    public comboBean getCombo(Long id) {
        JSONObject obj = new JSONObject();
        obj.put("id", id);
        return	this.comboDao.get(id);
    }

    
    public void editCombo(comboBean comboBean) {
        this.comboDao.edit(comboBean);
    }

    
    public void stateCombo(JSONObject obj) {
        this.comboDao.state(obj);
    }

    
    public lineBean getInfoLine(lineBean bean) {
        return this.lineDao.getInfo(bean);
    }

    
    public Grid dataGridLine(lineBean lineBean, PageFilter ph) {
        JSONObject obj = (JSONObject) JSONObject.toJSON(lineBean);
        obj.put("order", ph.getOrderString());
        Grid grid = new Grid();
        grid.setRows(this.lineDao.dataGrid(obj));
        grid.setTotal(this.lineDao.dataGridCot(obj));
        return grid;
    }

    
    public void addLine(lineBean lineBean) {
        this.lineDao.add(lineBean);
    }

    
    public void deleteLine(String id) {
        JSONObject obj = new JSONObject();
        obj.put("id", id);
        this.lineDao.delete(obj);
    }

    
    public lineBean getLine(String id) {
        JSONObject obj = new JSONObject();
        obj.put("id", id);
        return	this.lineDao.get(id);
    }

    
    public void editLine(lineBean lineBean) {
        this.lineDao.edit(lineBean);
    }

    
    public List<lineBean> selectLineJsonLine(String q, String pid) {
        JSONObject obj = new JSONObject();
        obj.put("pid", pid);
        obj.put("q", q);
        return	this.lineDao.selectLineJson(obj);
    }

    
    public List<menuBean> treeGridMenu() {
        JSONObject obj = new JSONObject();
        obj.put("flag", 1);
        return this.menuDao.getAllAccess(obj);
    }

    
    public void addMenu(menuBean bean) throws Exception {
        this.menuDao.add(bean);
    }

    
    public void deleteMenu(Long id) throws Exception {
        JSONObject obj = new JSONObject();
        obj.put("type", "access");
        obj.put("id", id);
        //this.roleDao.delGrant(obj);
        this.menuDao.delete(id);
    }

    
    public void updateMenu(menuBean bean) throws Exception {
        this.menuDao.update(bean);
    }

    
    public menuBean getMenu(Long id) {
        return this.menuDao.getAccessById(id);
    }

    
    public List<Tree> treeMenu(SessionInfo sessionInfo) {
        List<menuBean> accessList = null;
        JSONObject obj = new JSONObject();
        obj.put("accessType", 0);
        obj.put("userId", sessionInfo.getUserId());
        obj.put("flag", 0);
        if ("1".equals(sessionInfo.getUserId())){
            accessList = this.menuDao.getAllAccess(obj);
        }else {
            accessList = this.menuDao.getAccessListForUser(obj);
        }
        return this.buildTree(accessList);
    }

    
    public List<Tree> allTreeMenu(Boolean flag) {
        JSONObject obj = new JSONObject();
        obj.put("flag", flag?1:0);
        return this.buildTree(this.menuDao.getAllAccess(obj));
    }

    
    public List<String> accessListMenu(String userId) {
        return this.menuDao.accessList(userId);
    }

    
    public List<String> getAllAccessListMenu() {
        return this.menuDao.accessList(null);
    }

    
    public messageLogBean getInfoMessageLog(messageLogBean bean) {
        return this.messageLogDao.getInfo(bean);
    }

    
    public Grid dataGridMessageLog(messageLogBean messageLogBean, PageFilter ph) {
        JSONObject obj = (JSONObject) JSONObject.toJSON(messageLogBean);
        obj.put("order", ph.getOrderString());
        Grid grid = new Grid();
        grid.setRows(this.messageLogDao.dataGrid(obj));
        grid.setTotal(this.messageLogDao.dataGridCot(obj));
        return grid;
    }

    
    public void addMessageLog(messageLogBean messageLogBean) {
        this.messageLogDao.add(messageLogBean);
    }

    
    public void deleteMessageLog(Long id) {
        JSONObject obj = new JSONObject();
        obj.put("id", id);
        this.messageLogDao.delete(obj);
    }

    
    public messageLogBean getMessageLog(Long id) {
        JSONObject obj = new JSONObject();
        obj.put("id", id);
        return	this.messageLogDao.get(id);
    }

    
    public void editMessageLog(messageLogBean messageLogBean) {
        this.messageLogDao.edit(messageLogBean);
    }

    
    public mileageBean getInfoMileage(mileageBean bean) {
        return this.mileageDao.getInfo(bean);
    }

    
    public Grid dataGridMileage(mileageBean mileageBean, PageFilter ph) {
        JSONObject obj = (JSONObject) JSONObject.toJSON(mileageBean);
        obj.put("order", ph.getOrderString());
        Grid grid = new Grid();
        grid.setRows(this.mileageDao.dataGrid(obj));
        grid.setTotal(this.mileageDao.dataGridCot(obj));
        return grid;
    }

    
    public void addMileage(mileageBean mileageBean) {
        this.mileageDao.add(mileageBean);
    }

    
    public void deleteMileage(String startid, String endid) {
        JSONObject obj = new JSONObject();
        obj.put("startid", startid);
        obj.put("endid", endid);
        this.mileageDao.delete(obj);
    }

    
    public mileageBean getMileage(String startid, String endid) {
        JSONObject obj = new JSONObject();
        obj.put("startid", startid);
        obj.put("endid", endid);
        return	this.mileageDao.get(obj);
    }

    
    public void editMileage(mileageBean mileageBean) {
        this.mileageDao.edit(mileageBean);
    }

    
    public premiumBean getInfoPremium(premiumBean bean) {
        return this.premiumDao.getInfo(bean);
    }

    
    public Grid dataGridPremium(premiumBean premiumBean, PageFilter ph) {
        JSONObject obj = (JSONObject) JSONObject.toJSON(premiumBean);
        obj.put("order", ph.getOrderString());
        Grid grid = new Grid();
        grid.setRows(this.premiumDao.dataGrid(obj));
        grid.setTotal(this.premiumDao.dataGridCot(obj));
        return grid;
    }

    
    public void addPremium(premiumBean premiumBean) {
        this.premiumDao.add(premiumBean);
    }

    
    public void deletePremium(Long id) {
        JSONObject obj = new JSONObject();
        obj.put("id", id);
        this.premiumDao.delete(obj);
    }

    
    public premiumBean getPremium(Long id) {
        JSONObject obj = new JSONObject();
        obj.put("id", id);
        return	this.premiumDao.get(id);
    }

    
    public void editPremium(premiumBean premiumBean) {
        this.premiumDao.edit(premiumBean);
    }

    
    public quoteBean getInfoQuote(quoteBean bean) {
        return this.quoteDao.getInfo(bean);
    }

    
    public Grid dataGridQuote(quoteBean quoteBean, PageFilter ph) {
        JSONObject obj = (JSONObject) JSONObject.toJSON(quoteBean);
        obj.put("order", ph.getOrderString());
        Grid grid = new Grid();
        grid.setRows(this.quoteDao.dataGrid(obj));
        grid.setTotal(this.quoteDao.dataGridCot(obj));
        return grid;
    }

    
    public void addQuote(quoteBean quoteBean) {
        this.quoteDao.add(quoteBean);
    }

    
    public void deleteQuote(String bid, String eid) {
        JSONObject obj = new JSONObject();
        obj.put("bid", bid);
        obj.put("eid", eid);
        this.quoteDao.delete(obj);
    }

    
    public quoteBean getQuote(String bid, String eid) {
        JSONObject obj = new JSONObject();
        obj.put("bid", bid);
        obj.put("eid", eid);
        return	this.quoteDao.get(obj);
    }

    
    public void editQuote(quoteBean quoteBean) {
        this.quoteDao.edit(quoteBean);
    }

    
    public Grid dataGridWebRole(webRoleBean role, PageFilter ph) {
        JSONObject obj = new JSONObject();
        obj.put("order", ph.getOrderString());
        Grid grid = new Grid();
        grid.setRows(this.webRoleDao.dataGrid(obj));
        grid.setTotal(this.webRoleDao.dataGridCot(obj));
        return grid;
    }

    
    public webRoleBean getWebRole(Long id) {
        return this.webRoleDao.get(id);
    }

    
    public void updateWebRole(webRoleBean bean) throws Exception {
        this.webRoleDao.update(bean);
    }

    
    public void addWebRole(webRoleBean bean) throws Exception {
        bean.setId(globalIdService.getGlobalId().toString());
        this.webRoleDao.add(bean);
    }

    
    public void deleteWebRole(Long id) throws Exception {
        JSONObject obj = new JSONObject();
        obj.put("type", "role");
        obj.put("id", id);
        this.webRoleDao.delGrant(obj);
        this.webRoleDao.delete(id);
    }

    
    public void addGrantWebRole(webRoleBean role) throws Exception {
        JSONObject obj = new JSONObject();
        obj.put("id", role.getId());
        obj.put("type", "role");
        this.webRoleDao.delGrant(obj);
        if (!"".equals(role.getAccessIds())){
            obj.put("array", role.getAccessIds().split(","));
            this.webRoleDao.addGrant(obj);
        }
    }

    private List<Tree> buildTree(List<? extends Object> list) {
        List<Tree> treeList = new ArrayList<Tree>();
        if ((list != null) && (list.size() > 0)) {
            for (Object obj : list){
                Tree tree = new Tree();
                if (obj instanceof baseDicBean){
                    baseDicBean bean = new baseDicBean();
                    BeanUtils.copyProperties(obj,bean);
                    tree.setId(bean.getId());
                    if (bean.getPid() != null&&!bean.getPid().equals("")) {
                        tree.setPid(bean.getPid());
                    }
                    tree.setText(bean.getName());
                }
                if (obj instanceof  carDicBean){
                    carDicBean bean = new carDicBean();
                    BeanUtils.copyProperties(obj,bean);
                    tree.setId(bean.getId());
                    if (bean.getPid() != null&&!bean.getPid().equals("")) {
                        tree.setPid(bean.getPid());
                    }
                    tree.setText(bean.getName());
                }
                if (obj instanceof  menuBean){
                    menuBean bean = new menuBean();
                    BeanUtils.copyProperties(obj,bean);
                    tree.setId(bean.getId());
                    if (bean.getPid() != null&&!bean.getPid().equals("")) {
                        tree.setPid(bean.getPid());
                    }
                    tree.setText(bean.getName());
                    tree.setIconCls(bean.getIcon());
                    Map<String, Object> attr = new HashMap<String, Object>();
                    attr.put("url", bean.getUrl());
                    tree.setAttributes(attr);
                }
                treeList.add(tree);
            }
        }
        return treeList;
    }
}
