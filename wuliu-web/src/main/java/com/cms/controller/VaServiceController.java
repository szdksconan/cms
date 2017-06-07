package com.cms.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.cms.iservice.wuliu.CarOnlineService;
import com.cms.iservice.wuliu.VaServiceService;
import com.cms.model.User;
import com.cms.model.util.GlobalConstant;
import com.cms.model.util.Grid;
import com.cms.model.util.PageFilter;
import com.cms.model.util.SessionInfo;
import com.cms.model.wuliu.VaServiceBean;

@Controller
@RequestMapping("vaservice")

public class VaServiceController {
	
	@Autowired
	private VaServiceService vaServiceService;
	
	@Autowired
	private CarOnlineService carOnlineService;
	
	@RequestMapping("/vaserviceList")
	public ModelAndView vaserviceList(HttpServletRequest request) {
		ModelAndView model = new ModelAndView("/vaservice/vaservice_list");
		//SessionInfo sessionInfo = (SessionInfo) request.getSession().getAttribute(GlobalConstant.SESSION_INFO);
		 User loginUser = (User)request.getSession().getAttribute("sso:loginUser");
		List userVaServiceList = vaServiceService.getUserVaService(loginUser.getId());
		List vaServiceList = vaServiceService.getAllUserVaService();
		model.addObject("userVaServiceList",userVaServiceList);
		model.addObject("vaServiceList",vaServiceList);
		return model;
	}
	
	/**
	 *跳转到购买页面
	 * @return
	 */
	@RequestMapping("/vaserviceAddPage")
	public ModelAndView vaserviceAddPage(Long id,String name,Double price,String salestag,String measurePeriod) {
		ModelAndView model = new ModelAndView("/vaservice/vaservice_add");
		try {
			name =new String(name.getBytes("ISO-8859-1"),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		VaServiceBean va = this.vaServiceService.getInfo(id);
		va.setId(id);
		va.setServicepackagename(name);
		va.setPrice(price);
		va.setSalestag(salestag);
		va.setMeasurePeriod(measurePeriod+"月");
		model.addObject("servicePackage",va);
		return model;
	}
	/**
	 *跳转到购买页面
	 * @return
	 */
	@RequestMapping("/vaserviceAddPage2")
	public ModelAndView vaserviceAddPage2(Long id) {
		ModelAndView model = new ModelAndView("/vaservice/vaservice_add");
		VaServiceBean va = this.vaServiceService.getInfo2(id);
		model.addObject("servicePackage",va);
		return model;
	}
	
	/**
	 *跳转到历史购买页面
	 * @return
	 */
	@RequestMapping("/vaserviceHisPage")
	public String vaserviceHisPage() {
		return "/vaservice/vaservice_his";
	}
	
	/**
	 * 废弃方法
	 * @param ph
	 * @param request
	 * @return
	 */
//	@RequestMapping("/hisDataGrid")
//	@ResponseBody
//	public Grid hisDataGrid(PageFilter ph,HttpServletRequest request) {
//		Grid grid = new Grid();
//		 SessionInfo sessionInfo = (SessionInfo) request.getSession().getAttribute(GlobalConstant.SESSION_INFO);	
//		List userVaServiceList = vaServiceService.getUserHisVaService(Long.valueOf(sessionInfo.getUserId()),ph);
//		List l = new ArrayList();
//		for(int i=0;i< userVaServiceList.size();i++){
//			VaServiceBean va =(VaServiceBean) userVaServiceList.get(i);
//			va.setEffectDate(va.getServiceperiodstart()+"至"+va.getServiceperiodend());
//			l.add(va);
//		}
//		grid.setRows(l);
//		grid.setTotal(this.vaServiceService.getUserHisVaService2(Long.valueOf(sessionInfo.getUserId())).size());
//		return grid;
//	}
	
	/**
	 * 订购列表
	 */
	@RequestMapping("/getHisData")
	@ResponseBody
	public JSONObject getHisData(String createDate,String comboName,int page,HttpServletRequest request)
    {
	  //SessionInfo sessionInfo = (SessionInfo) request.getSession().getAttribute(GlobalConstant.SESSION_INFO);
	  User loginUser = (User)request.getSession().getAttribute("sso:loginUser");
	  JSONObject json = new JSONObject();
      int pageIndex = page > 1 ? page:1;//当前页
      int pageSize = 10;//这里用来设置每页要展示的数据数量，建议把这个写到web.config中来全局控制
      PageFilter ph= new PageFilter();
      ph.setOrder("desc");
      ph.setSort("purchaseDate");
      ph.setRows(pageSize);
      ph.setPage(page);
      //获取分页数据
  	  List userVaServiceList = vaServiceService.getUserHisVaService(loginUser.getId(),createDate,comboName,ph);
  	  //得到数据的总条数
  	  int count = this.vaServiceService.getUserHisVaService2(loginUser.getId(),createDate,comboName).size();
      //通过计算，得到分页应该需要分几页，其中不满一页的数据按一页计算
      if(count%pageSize!=0)
      {
    	  count = count / pageSize + 1;
      }
      else
      {
    	  count = count / pageSize;
      }
      List l = new ArrayList();
		for(int i=0;i< userVaServiceList.size();i++){
			VaServiceBean va =(VaServiceBean) userVaServiceList.get(i);
			va.setEffectDate(va.getServiceperiodstart()+"至"+va.getServiceperiodend());
			l.add(va);
		}
      //转成Json格式
      json.put("pageCount", count);
      json.put("CurrentPage", pageIndex);
      json.put("list", l);
      return json;
    }
	
	@RequestMapping("/add")
	@ResponseBody
	public JSONObject add(Long id,HttpServletRequest request) {
		JSONObject obj = new JSONObject();
		User loginUser = (User)request.getSession().getAttribute("sso:loginUser");
		//SessionInfo sessionInfo = (SessionInfo) request.getSession().getAttribute(GlobalConstant.SESSION_INFO);
		try {
			vaServiceService.add(id,loginUser.getId());
			obj.put("success", true);
			obj.put("msg", "购买成功！");
		} catch (Exception e) {
			obj.put("msg", e.getMessage());
		}
		return obj;
	}
	/*
	 * north跳转
	 * */
	@RequestMapping("/dlgNorth")
	   public String dlgNorth()
	     {
			return "/layout/north";
	      }
	     
	 	/*
	 	 * north跳转
	 	 * */
	 	@RequestMapping("/dlgSouth")
	 	   public String dlgSouth()
	 	     {
	 			return "/layout/south";
	 	      }     
	 	
		/**
		 *加载上方导航栏
		 * @return
		 */
		@RequestMapping("/north")
		public ModelAndView north(Long id) {
			ModelAndView model = new ModelAndView("/layout/north");
			return model;
		}	
		
		/**
		 *跳转到历史短信页面
		 * @return
		 */
		@RequestMapping("/vaserviceHisMsgPage")
		public String vaserviceHisMsgPage() {
			return "/vaservice/vaservice_his_msg";
		}
		
		@RequestMapping("/hisMsgDataGrid")
		@ResponseBody
		public Grid hisMsgDataGrid(PageFilter ph,HttpServletRequest request) {
			Grid grid = new Grid();
			User loginUser = (User)request.getSession().getAttribute("sso:loginUser");
			// SessionInfo sessionInfo = (SessionInfo) request.getSession().getAttribute(GlobalConstant.SESSION_INFO);	
		     //获取分页数据
		  	  List carOnlineList = carOnlineService.getMsgListByPh(loginUser.getId().toString(),null,null,ph);
			grid.setRows(carOnlineList);
			grid.setTotal(carOnlineService.getMsgListCount(loginUser.getId().toString(),null,null));
			return grid;
		}
}
