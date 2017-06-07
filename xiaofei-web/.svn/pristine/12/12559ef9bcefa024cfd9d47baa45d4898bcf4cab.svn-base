package com.cms.controller.xiaofei;

import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.cms.controller.test.DataTime;
import com.cms.iservice.common.GlobalIdService;
import com.cms.iservice.xiaofei.CmsXLocalDictService;
import com.cms.iservice.xiaofei.CmsXReqRecService;
import com.cms.model.xiaofei.CmsXLocalDict;
import com.cms.model.xiaofei.CmsXReqRec;
import com.cms.model.xiaofei.DataList;


@Controller
@RequestMapping("/innovation")
@SuppressWarnings("static-access")
public class CmsXReqRecController {
	
	@Autowired
	private CmsXReqRecService cmsXReqRecService;
	@Autowired
	private GlobalIdService globalIdService;
	@Autowired
	private CmsXLocalDictService cmsXLocalDictService;
	
	/**
	 * 添加创新定制信息
	 * 作者： 郑泽
	 * 日期：2016年4月23日
	 * @param cmsXReqRec
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException 
	 * @throws IllegalStateException 
	 */
	@RequestMapping("/addCmsXReqRec")
	public void addCmsXReqRec(CmsXReqRec cmsXReqRec,HttpServletRequest request,HttpServletResponse response) throws IllegalStateException, IOException{
		cmsXReqRec.setCustomId(Long.toString(globalIdService.getGlobalId()));//id
		//cmsXReqRec.setUserId(cmsXReqRec.getUserId());
		//获取全地址
		String address = cmsXReqRec.getHcity()+cmsXReqRec.getHproper()+cmsXReqRec.getHarea();
		System.out.println(address);
		//cmsXReqRec.setBusiCode("100101");
		//cmsXReqRec.setLoclCode("001001019012");
		//cmsXReqRec.setLoclName("四川省-成都市-高新区");
		//根据地理位置获取code
		CmsXLocalDict dict = cmsXLocalDictService.selectByLoclCodeGetLoclCode(address);
		if(dict!=null){
			cmsXReqRec.setLoclCode(dict.getLoclCode());
		}
		cmsXReqRec.setOpTime(DataTime.getTime());
		cmsXReqRecService.addUserReleaseAndInnovationCustomGetInfo(cmsXReqRec);
		request.getSession().setAttribute("ID", cmsXReqRec.getCustomId());
	}
	
	public String getPath(String filePath,HttpServletRequest request){
		String realPath = request.getSession().getServletContext().getRealPath("/");
		String path = realPath + filePath;
		return path;
	}
	
	@RequestMapping("/selectAllCmsXReqRecGetInfo")
	@ResponseBody
	public void selectAllCmsXReqRecGetInfo(String t,@RequestParam("loclCode")String loclCode,@RequestParam("typeCode")String typeCode,
			@RequestParam("page")Integer page,@RequestParam("pageSize")Integer pageSize,
			HttpServletRequest request,HttpServletResponse response) throws IOException{
		JSONObject obj = new JSONObject();
		response.setContentType("text/plain;charset=utf-8");
		String callbackFunName =request.getParameter("callbackparam");//得到js函数名称 
		DataList data=new DataList();
		if(t!=null&&t.equals("App"))
		{
			data.setListData(cmsXReqRecService.selectAllCmsXReqRecGetInfo(loclCode, typeCode, (page -1) *pageSize , pageSize));
			response.getWriter().write(data.toString());
		}else
			response.getWriter().write(callbackFunName + "("+obj.toJSONString(cmsXReqRecService.selectAllCmsXReqRecGetInfo(loclCode, typeCode, (page -1) *pageSize , pageSize))+")"); //返回jsonp数据  
	}
	/**
	 * 根据不同的条件显示创新定制列表信息
	 * 作者： 郑泽
	 * 日期：2016年5月30日
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	@RequestMapping("/selectGetListContInfo")
	@ResponseBody
	public void selectGetListContInfo(@RequestParam("opTime")String opTime,@RequestParam("key")String key,@RequestParam("page")Integer page,@RequestParam("pageSize")Integer pageSize,
			String t,HttpServletRequest request,HttpServletResponse response) throws IOException{
		JSONObject obj = new JSONObject();
		response.setContentType("text/plain;charset=utf-8");
		key = URLDecoder.decode(key, "UTF-8");
		String callbackFunName =request.getParameter("callbackparam");//得到js函数名称 
		DataList data=new DataList();
		if(t!=null&&t.equals("App"))
		{
			data.setListData(cmsXReqRecService.selectGetListContInfo(opTime,key,(page -1) *pageSize , pageSize));
			response.getWriter().write(data.toString());
		}else
			response.getWriter().write(callbackFunName + "("+
					obj.toJSONString(cmsXReqRecService.selectGetListContInfo(opTime,key,(page -1) *pageSize , pageSize))+")"); //返回jsonp数据  
	}
	
	/**
	 * 根据Id查询详情
	 * 作者： 郑泽
	 * 日期：2016年5月31日
	 * @param Id
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	@RequestMapping("/selectGetCmsXReqRecByDetails")
	@ResponseBody
	public void selectGetCmsXReqRecByDetails(String t,@RequestParam("Id")String Id,HttpServletRequest request,HttpServletResponse response) throws IOException{
		JSONObject obj = new JSONObject();
		response.setContentType("text/plain;charset=utf-8");
		String callbackFunName =request.getParameter("callbackparam");//得到js函数名称 
		DataList data=new DataList();
		if(t!=null&&t.equals("App"))
		{
			data.setListData(cmsXReqRecService.selectGetCmsXReqRecByDetails(Id));
			response.getWriter().write(data.toString());
		}else
			response.getWriter().write(callbackFunName + "("+
					obj.toJSONString(cmsXReqRecService.selectGetCmsXReqRecByDetails(Id))+")"); //返回jsonp数据  
	}
	
	/**
	 * 根据用户ID查询用户自己的创新定制信息
	 * 作者： 郑泽
	 * 日期：2016年6月2日
	 * @param uId
	 * @param page
	 * @param pageSize
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	@RequestMapping("/selectUserByIdAndReqRecGetInfo")
	@ResponseBody
	public void selectUserByIdAndReqRecGetInfo(String t,@RequestParam("uId")String uId,@RequestParam("key")String key,
			@RequestParam("page")Integer page,@RequestParam("pageSize")Integer pageSize,
			HttpServletRequest request,HttpServletResponse response) throws IOException{
		JSONObject obj = new JSONObject();
		response.setContentType("text/plain;charset=utf-8");
		key = URLDecoder.decode(key, "UTF-8");
		String callbackFunName =request.getParameter("callbackparam");//得到js函数名称 
		DataList data=new DataList();
		System.out.println(key+">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		if(t!=null&&t.equals("App"))
		{
			data.setListData(cmsXReqRecService.selectUserByIdAndReqRecGetInfo(uId,key, (page -1) *pageSize , pageSize));
			response.getWriter().write(data.toString());
		}else
			response.getWriter().write(callbackFunName + "("+
					obj.toJSONString(cmsXReqRecService.selectUserByIdAndReqRecGetInfo(uId,key, (page -1) *pageSize , pageSize))+")"); //返回jsonp数据  
	}


}
