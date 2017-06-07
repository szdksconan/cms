package com.cms.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.alibaba.dubbo.common.logger.Logger;
import com.alibaba.dubbo.common.logger.LoggerFactory;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.cms.iservice.common.GlobalIdService;
import com.cms.iservice.wuliu.CarOnlineService;
import com.cms.iservice.wuliu.VaServiceService;
import com.cms.model.User;
import com.cms.model.util.GlobalConstant;
import com.cms.model.util.PageFilter;
import com.cms.model.util.SessionInfo;
import com.cms.model.wuliu.MyCarBean;


@Controller
@RequestMapping("caronline")
public class CarOnlineController {
    private static Logger logger = LoggerFactory.getLogger(InfoPublishController.class);

	@Autowired
	private CarOnlineService carOnlineService;
	
	@Autowired
	private GlobalIdService globalIdService;
	
	@Autowired
	private VaServiceService vaServiceService;
	
	@RequestMapping("caronlineList")
	public ModelAndView caronlineList(HttpServletRequest request){
		ModelAndView model = new ModelAndView("caronline/caronline_list");
		return model;
	}
	
	
	/**
	 * 根据经纬度，半径，显示条数在地图上锚点
	 * @param 经度，纬度，搜索半径，返回结果数量
	 * @return
	 */
	@RequestMapping("/searchMap")
	@ResponseBody
	public String searchMap(Double lgr,Double lat,int round,int num) {
		JSONObject obj = new JSONObject();
		List<MyCarBean> list = this.carOnlineService.searchMap(lgr,lat,round,num);
		return JSONObject.toJSON(list).toString();
	}
	/**
	 * 添加或删除关注记录
	 * @return
	 */
	@RequestMapping("/changeFocus")
	@ResponseBody
	public String changeFocus(String id,String state,HttpServletRequest request) {
		// SessionInfo sessionInfo = (SessionInfo) request.getSession().getAttribute(GlobalConstant.SESSION_INFO);
		User loginUser = (User)request.getSession().getAttribute("sso:loginUser");
		JSONObject obj = new JSONObject();
		try {
			this.carOnlineService.changeFocus(Long.valueOf(id) ,Long.valueOf(loginUser.getId()),state);
			obj.put("msg", "success");
		} catch (Exception e) {
			obj.put("msg", e.getMessage());
		}
	return obj.toString();
	}
	
	/**
	 * 短信列表
	 */
	@RequestMapping("/getMsgData")
	@ResponseBody
	public JSONObject getMsgData(String createDate,String carNo,int page,HttpServletRequest request)
    {
	  //SessionInfo sessionInfo = (SessionInfo) request.getSession().getAttribute(GlobalConstant.SESSION_INFO);
	  User loginUser = (User)request.getSession().getAttribute("sso:loginUser");
	  JSONObject json = new JSONObject();
      int pageIndex = page > 1 ? page:1;//当前页
      int pageSize = 10;//这里用来设置每页要展示的数据数量，建议把这个写到web.config中来全局控制
      PageFilter ph= new PageFilter();
      ph.setOrder("desc");
      ph.setSort("create_date");
      ph.setRows(pageSize);
      ph.setPage(page);
      //获取分页数据
  	  List carOnlineList = carOnlineService.getMsgListByPh(loginUser.getId().toString(),createDate,carNo,ph);
  	  //得到数据的总条数
  	  int count = carOnlineService.getMsgListCount(loginUser.getId().toString(),createDate,carNo);

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
      json.put("list", carOnlineList);
      return json;
    }
	
	/**
	 * 删除短信记录
	 * @return
	 */
	@RequestMapping("/delMsg")
	@ResponseBody
	public String delMsg(String id) {
		JSONObject obj = new JSONObject();
		try {
			this.carOnlineService.delMsg(Long.valueOf(id));
			obj.put("msg", "success");
		} catch (Exception e) {
			obj.put("msg", e.getMessage());
		}
	return obj.toString();
	}
	
	@RequestMapping("mycarList")
	public ModelAndView mycarList(HttpServletRequest request){
		ModelAndView model = new ModelAndView("caronline/mycar_list");
		return model;
	}
	@RequestMapping("myfocusList")
	public ModelAndView myfocusList(HttpServletRequest request){
		ModelAndView model = new ModelAndView("caronline/myfocus_list");
		return model;
	}
	@RequestMapping("allcarList")
	public ModelAndView allcarList(HttpServletRequest request){
		ModelAndView model = new ModelAndView("caronline/allcar_list");
		return model;
	}
	
	/**
	 * 查询我的车辆
	 */
	@RequestMapping("/getPageDataMycar")
	@ResponseBody
	public JSONObject getPageDataMycar(String carNo,int page,HttpServletRequest request)
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
  	  List carOnlineList = carOnlineService.getListByPhMycar(loginUser.getId().toString(),carNo,ph);
  	  //获取Map所需点
  	  List mapList = carOnlineService.getListByMapMycar(loginUser.getId().toString(),carNo,ph);
  	  //得到数据的总条数
  	  int count = carOnlineService.getListCountMycar(loginUser.getId().toString(),carNo);

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
      json.put("list", carOnlineList);
      json.put("maplist", mapList);
      return json;
    }
    
	/**
	 * 查询我的关注
	 */
	@RequestMapping("/getPageDataMyfocus")
	@ResponseBody
	public JSONObject getPageDataMyfocus(String carNo,int page,HttpServletRequest request)
    {
	//  SessionInfo sessionInfo = (SessionInfo) request.getSession().getAttribute(GlobalConstant.SESSION_INFO);	
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
  	  List carOnlineList = carOnlineService.getListByPhMyfocus(loginUser.getId().toString(),carNo,ph);
  	  //获取Map所需数据
  	  List mapList = carOnlineService.getListByMapMyfocus(loginUser.getId().toString(),carNo,ph);
  	  //得到数据的总条数
  	  int count = carOnlineService.getListCountMyfocus(loginUser.getId().toString(),carNo);

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
      json.put("list", carOnlineList);
      json.put("maplist", mapList);
      return json;
    }
	 
		/**
		 * 查询在线车辆（不包含自有，关注）
		 */
		@RequestMapping("/getPageDataAllcar")
		@ResponseBody
		public JSONObject getPageDataAllcar(String carNo,int page,String city,HttpServletRequest request)
	    {
            try{
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
                List carOnlineList = carOnlineService.getListByPhAllcar(loginUser.getId().toString(),carNo,ph,city);
                //得到数据的总条数
                int count = carOnlineService.getListCountAllcar(loginUser.getId().toString(),carNo,city);
                //获取Map所需要的数据
                List mapList = carOnlineService.getListByMapAllcar(loginUser.getId().toString(),carNo,city);
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
                json.put("list", carOnlineList);
                json.put("maplist", mapList);
                return json;
            }catch (Exception e){
                logger.debug("在线车辆\n"+e.getMessage());
                e.printStackTrace();
                System.out.println(e.getMessage());
            }
            return null;
	    }
		
		/**
		 * 新增短信记录
		 * @return
		 */
		@RequestMapping("/sendMsg")
		@ResponseBody
		public String sendMsg(String sendcarno,String sendtel,String msginfo,String type,HttpServletRequest request) {
			 //SessionInfo sessionInfo = (SessionInfo) request.getSession().getAttribute(GlobalConstant.SESSION_INFO);
			 User loginUser = (User)request.getSession().getAttribute("sso:loginUser");
			JSONObject obj = new JSONObject();
			// 创建HttpClient实例     
	        HttpClient httpclient = new DefaultHttpClient();
	       
	        try{
//	        	  String str1 = "这是一个字符串aaa111";
//	              byte[] before = msginfo.getBytes("UTF-8");
//	              String data = new String(before,"UTF-8");
//	              byte[] result = data.getBytes("GBK");
//	              String d = new String(result, "GBK");
//	              System.out.println("=====>"+d);
//	            HttpGet httpgets = new HttpGet("http://gateway.iems.net.cn/GsmsHttp?username=69722:admin&password=50887727&from=001&to=18782935261&content="+d+"&expandPrefix=113&presendTim=");  
//	            HttpResponse response = httpclient.execute(httpgets);    
//	            HttpEntity entity = response.getEntity();  
//	     
//	        if (entity != null) {    
//	            InputStream instreams = entity.getContent();    
//	            String str =UploadUtil.convertStreamToString(instreams);  
//	            System.out.println("Do something");   
//	            System.out.println(str);  
//	            // Do not need the rest    
//	            httpgets.abort();    
//	        }
				Long  id = globalIdService.getGlobalId();
				this.vaServiceService.updateMsgSum(loginUser.getId().toString(), type, 1);
				this.carOnlineService.addMSg(sendcarno,sendtel,msginfo,loginUser.getId().toString(),id);
				obj.put("msg", "success");
	        
			} catch (Exception e) {
				obj.put("msg", e.getMessage());
			}
		return obj.toString();
		}
		
		/**
		 * 删除短信记录
		 * @return
		 */
		@RequestMapping("/getMsgSum")
		@ResponseBody
		public String getMsgSum(String vaServiceType,HttpServletRequest request) {
			 //SessionInfo sessionInfo = (SessionInfo) request.getSession().getAttribute(GlobalConstant.SESSION_INFO);
			 User loginUser = (User)request.getSession().getAttribute("sso:loginUser");
			JSONObject obj = new JSONObject();
			int msgSum = this.vaServiceService.getMsgSum(loginUser.getId().toString(), vaServiceType);
			obj.put("msgSum", msgSum);
			return obj.toString();
		}
		
		/**
		 * 删除短信记录
		 * @return
		 */
		@RequestMapping("/getCodeByName")
		@ResponseBody
		public JSONObject getCodeByName(String province,String city,HttpServletRequest request) {
			JSONObject obj = new JSONObject();
//			int msgSum = this.vaServiceService.getMsgSum(sessionInfo.getUserId(), vaServiceType);
//			obj.put("msgSum", msgSum);
//			return obj.toString();
			System.out.println(province+","+city);
			return obj;
		}
}
