package com.cms.controller;

import com.alibaba.fastjson.JSONObject;
import com.cms.iservice.common.GlobalIdService;
import com.cms.iservice.wuliu.InfoPublishService;
import com.cms.iservice.wuliu.MyCarService;
import com.cms.model.User;
import com.cms.model.util.GlobalConstant;
import com.cms.model.util.PageFilter;
import com.cms.model.util.SessionInfo;
import com.cms.model.wuliu.MyCarBean;
import com.cms.util.UploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("mycar")
public class MyCarController {

	@Autowired
	private MyCarService myCarService;
	
	@Autowired
	private GlobalIdService globalIdService;
	
	@Autowired
	private InfoPublishService infoPublishService;
	

	
	@RequestMapping("mycarList")
	public ModelAndView mycarList(HttpSession httpSession){
		ModelAndView model = new ModelAndView("mycar/mycar_list");
		//SessionInfo session = (SessionInfo) httpSession.getAttribute(GlobalConstant.SESSION_INFO);
		 User loginUser = (User) httpSession.getAttribute("sso:loginUser");
   
		int different = 600 ;
		String userId = loginUser.getId().toString();
		if("1".equals(userId))
			different = 0;
		
		model.addObject("different", different);
		return model;
	}
	

	/**
	 *我的车辆列表
	 */
	@RequestMapping("/getMyCarData")
	@ResponseBody
	public JSONObject getMyCarData(String carNo,String city,int page,HttpServletRequest request)
    {
	 // SessionInfo sessionInfo = (SessionInfo) request.getSession().getAttribute(GlobalConstant.SESSION_INFO);
	  User loginUser = (User)request.getSession().getAttribute("sso:loginUser");
	  JSONObject json = new JSONObject();
      int pageIndex = page > 1 ? page:1;//当前页
      int pageSize = 10;//这里用来设置每页要展示的数据数量，建议把这个写到web.config中来全局控制
      PageFilter ph= new PageFilter();
      ph.setOrder("desc");
      ph.setSort("car_location_time");
      ph.setRows(pageSize);
      ph.setPage(page);
      //获取分页数据
  	  List myCarList = myCarService.getMyCarListByPh(loginUser.getId().toString(),city,carNo,ph);
  	  //得到数据的总条数
  	  int count = myCarService.getMyCarListCount(loginUser.getId().toString(),city,carNo);

      //通过计算，得到分页应该需要分几页，其中不满一页的数据按一页计算
      if(count%pageSize!=0)
      {
    	  count = count / pageSize + 1;
      }
      else
      {
    	  count = count / pageSize;
      }
      //转成Json格式
      json.put("pageCount", count);
      json.put("CurrentPage", pageIndex);
      json.put("list", myCarList);
      return json;
    }
	
	/**
	 * 添加车辆页面
	 * @param request
	 * @return
	 */
	@RequestMapping("add")
	public ModelAndView add(HttpServletRequest request){
		ModelAndView model = new ModelAndView("mycar/mycar_add");
		List dicList = this.myCarService.getCarDic(Long.valueOf("1"));
		List dicList2 = this.myCarService.getCarDic(Long.valueOf("5"));
		List dicList3 = this.myCarService.getCarDic(Long.valueOf("11"));
		List dicList4 = this.myCarService.getCarDic(Long.valueOf("17"));
		model.addObject("dicList", dicList);
		model.addObject("dicList2", dicList2);
		model.addObject("dicList3", dicList3);
		model.addObject("dicList4", dicList4);
		return model;
	}
	
	/**
	 *添加车辆的方法
	 */
	@RequestMapping("/addCar")
	@ResponseBody
	public JSONObject addCar(MyCarBean myCarBean,MultipartHttpServletRequest request)
    {
		//SessionInfo sessionInfo = (SessionInfo) request.getSession().getAttribute(GlobalConstant.SESSION_INFO);	
		 User loginUser = (User)request.getSession().getAttribute("sso:loginUser");
	  JSONObject json = new JSONObject();
	 // sessionInfo.setCompanyId(Long.valueOf(1));
	  int count = this.myCarService.getCarCount(loginUser.getId().toString(), myCarBean.getCarNo());
	  if(count == 0){
	  try {
			Map<String,String> map = UploadUtil.uploadImg(request,loginUser.getId().toString()+myCarBean.getCarNo(), new String[]{"carCard4Urld",
					"carCard3Urld","carCard2Urld","carCardUrld","carNoUrld"});
		
			if (map.get("carCard4Urld")!=null){
				myCarBean.setCarCard4Url(map.get("carCard4Urld"));
			}
			if (map.get("carCard3Urld")!=null){
				myCarBean.setCarCard3Url(map.get("carCard3Urld"));
			}
			if (map.get("carCard2Urld")!=null){
				myCarBean.setCarCard2Url(map.get("carCard2Urld"));
			}
			if (map.get("carCardUrld")!=null){
				myCarBean.setCarCardUrl(map.get("carCardUrld"));
			}
			if (map.get("carNoUrld")!=null){
				myCarBean.setCarNoUrl(map.get("carNoUrld"));
			}
			Long id = globalIdService.getGlobalId();
			myCarBean.setId(String.valueOf(id));
		  this.myCarService.addCarAndRelative(myCarBean,loginUser.getId().toString(),loginUser.getCompanyId().toString());
		  json.put("success", true);
		  json.put("msg", "添加成功！");
		}catch(Exception e){
			json.put("msg", e.getMessage());
		}
	  }
	  else{
		  json.put("msg", "该车牌号已存在!");
	  }
	  return json;
    }
	/**
	 *删除相关车辆的方法
	 */
	@RequestMapping("/delCarAndRelative")
	@ResponseBody
	public JSONObject delCarAndRelative(String id,String  carId)
    {
		
	  JSONObject json = new JSONObject();

	  try {
			this.myCarService.delCarAndRelative(id,carId);
		}catch(Exception e){
			json.put("msg", e.getMessage());
		}
	
	  return json;
    }
	
	
	/**
	 * 跳转到快捷发布
	 * @param request
	 * @return
	 */
	@RequestMapping("publish")
	public ModelAndView publish(HttpServletRequest request){
		ModelAndView model = new ModelAndView("mycar/publish");
		return model;
	}
	
	/**
	 *查询该用户对应该车的发布记录是否过期
	 */
	@RequestMapping("/getLastCheyuanCot")
	@ResponseBody
	public JSONObject getLastCheyuanCot(String  carId,HttpSession session)
    {
	  User loginUser = (User) session.getAttribute("sso:loginUser");
	  String userId =loginUser.getId().toString();
      HashMap map = new HashMap();
        map.put("carId", carId);
        map.put("userId", userId);
	  JSONObject json2 = new JSONObject();
	  try {
		  int count = infoPublishService.getLastCheyuanCot2(map);
		  if(count > 0){
			  int tag = infoPublishService.getLastCheyuanCot(map);
			  json2.put("tag", tag);
		  }
		  else{
			  json2.put("tag", 1); 
		  }
		}catch(Exception e){
			json2.put("msg", e.getMessage());
		}
	  return json2;
    }
}
