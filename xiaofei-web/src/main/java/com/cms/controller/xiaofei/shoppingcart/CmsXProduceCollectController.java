package com.cms.controller.xiaofei.shoppingcart;

import java.io.IOException;

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
import com.cms.iservice.xiaofei.CmsXProduceCollectService;
import com.cms.iservice.xiaofei.CmsXStoreCollectionService;
import com.cms.model.xiaofei.CmsXProduceCollect;
import com.cms.model.xiaofei.CmsXStoreCollection;
import com.cms.model.xiaofei.DataList;

@Controller
@RequestMapping("/cpcc")
public class CmsXProduceCollectController {
	@Autowired
	private GlobalIdService globalIdService;
	@Autowired
	private CmsXProduceCollectService cmsXProduceCollectService;
	@Autowired
	private CmsXStoreCollectionService cmsXStoreCollectionService;
	
	/**
	 * 添加商品到收藏
	 * 作者： 郑泽
	 * 日期：2016年6月3日
	 * @param collect
	 * @param request
	 * @param response
	 */
	@RequestMapping("/addGoodsToCollect")
	@ResponseBody
	public void addGoodsToCollect(CmsXProduceCollect collect,HttpServletRequest request,HttpServletResponse response){
		collect.setProCollectId(Long.toString(globalIdService.getGlobalId()));
		collect.setCollectDate(DataTime.getTime());
		collect.setCollectState(1);
		cmsXProduceCollectService.addGoodsToCollect(collect);
	}
	
	/**
	 * 添加店铺收藏 
	 * 作者： 郑泽
	 * 日期：2016年6月3日
	 * @param collect
	 * @param request
	 * @param response
	 */
	@RequestMapping("/addCmsXStoreCollection")
	@ResponseBody
	public void addCmsXStoreCollection(CmsXStoreCollection collect,HttpServletRequest request,HttpServletResponse response){
		collect.setStoreCollectionCode(Long.toString(globalIdService.getGlobalId()));
		collect.setCollectionDate(DataTime.getTime());
		collect.setCollectionState(1);
		this.cmsXStoreCollectionService.addCmsXStoreCollection(collect);
	}
	
	/**
	 * 根据产品Id查询收藏数量
	 * 作者： 郑泽
	 * 日期：2016年6月3日
	 * @param pId
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	@RequestMapping("/selectAllCollectionNumber")
	@ResponseBody
	public void selectAllCollectionNumber(String t,@RequestParam("pId")String pId,HttpServletRequest request,HttpServletResponse response) throws IOException{
		JSONObject obj = new JSONObject();
		response.setContentType("text/plain;charset=utf-8");
		String callbackFunName =request.getParameter("callbackparam");//得到js函数名称
		DataList data=new DataList();
		if(t!=null&&t.equals("App"))
		{
			data.setListData(cmsXProduceCollectService.selectAllCollectionNumber(pId));
			response.getWriter().write(obj.toJSONString(data));
		}else
			response.getWriter().write(callbackFunName + "("+obj.toJSONString(cmsXProduceCollectService.selectAllCollectionNumber(pId))+")"); //返回jsonp数据  
	}
	
	/**
	 * 根据用户ID查看收藏的产品 
	 * 作者： 郑泽
	 * 日期：2016年6月17日
	 * @param t
	 * @param uId
	 * @param page
	 * @param pageSize
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/selectAllCollectionUserGetById")
	@ResponseBody
	public void selectAllCollectionUserGetById(String t,@RequestParam("uId")String uId,@RequestParam("page")Integer page,
			@RequestParam("pageSize")Integer pageSize,HttpServletRequest request,HttpServletResponse response) throws IOException{
		JSONObject obj = new JSONObject();
		response.setContentType("text/plain;charset=utf-8");
		String callbackFunName =request.getParameter("callbackparam");//得到js函数名称
		if(t!=null&&t.equals("App"))
		{
			response.getWriter().write(obj.toJSONString(cmsXProduceCollectService.selectAllCollectionUserGetById(uId, (page -1) *pageSize , pageSize)));
		}else
			response.getWriter().write(callbackFunName + "("+obj.toJSONString(cmsXProduceCollectService.selectAllCollectionUserGetById(uId, (page -1) *pageSize , pageSize))+")"); //返回jsonp数据  
	}
	
	/**
	 * 根据收藏Id删除对应的记录
	 * 作者： 郑泽
	 * 日期：2016年6月17日
	 * @param t
	 * @param id
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	@RequestMapping("/deleteUserAndCollectionAProduce")
	@ResponseBody
	public void deleteUserAndCollectionAProduce(String t,@RequestParam("id")String id,HttpServletRequest request,HttpServletResponse response) throws IOException{
		JSONObject obj = new JSONObject();
		response.setContentType("text/plain;charset=utf-8");
		String callbackFunName =request.getParameter("callbackparam");//得到js函数名称
		if(t!=null&&t.equals("App"))
		{
			response.getWriter().write(obj.toJSONString(cmsXProduceCollectService.deleteUserAndCollectionAProduce(id)));
		}else
			response.getWriter().write(callbackFunName + "("+obj.toJSONString(cmsXProduceCollectService.deleteUserAndCollectionAProduce(id))+")"); //返回jsonp数据  
	}
	
	/**
	 * 根据收藏Id取消对应的收藏记录
	 * 作者： 郑泽
	 * 日期：2016年6月17日
	 * @param t
	 * @param id
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/updateUserAndCollectionAProduce")
	@ResponseBody
	public void updateUserAndCollectionAProduce(String t,@RequestParam("id")String id,HttpServletRequest request,HttpServletResponse response) throws IOException{
		JSONObject obj = new JSONObject();
		response.setContentType("text/plain;charset=utf-8");
		String callbackFunName =request.getParameter("callbackparam");//得到js函数名称
		if(t!=null&&t.equals("App"))
		{
			response.getWriter().write(obj.toJSONString(cmsXProduceCollectService.updateUserAndCollectionAProduce(id)));
		}else
			response.getWriter().write(callbackFunName + "("+obj.toJSONString(cmsXProduceCollectService.updateUserAndCollectionAProduce(id))+")"); //返回jsonp数据  
	}
	
	/**
	 * 根据用户Id查询用户收藏的店铺信息
	 * 作者： 郑泽
	 * 日期：2016年6月18日
	 * @param t
	 * @param uId 用户Id
	 * @param page 页码
	 * @param pageSize 每页显示多少条数据
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/selectUserAndGetByIdStoreCollection")
	@ResponseBody
	public void selectUserAndGetByIdStoreCollection(String t,@RequestParam("uId")String uId,@RequestParam("page")Integer page,
			@RequestParam("pageSize")Integer pageSize,HttpServletRequest request,HttpServletResponse response) throws IOException{
		JSONObject obj = new JSONObject();
		response.setContentType("text/plain;charset=utf-8");
		String callbackFunName =request.getParameter("callbackparam");//得到js函数名称
		if(t!=null&&t.equals("App"))
		{
			response.getWriter().write(obj.toJSONString(cmsXStoreCollectionService.selectUserAndGetByIdStoreCollection(uId, (page -1) *pageSize , pageSize)));
		}else
			response.getWriter().write(callbackFunName + "("+obj.toJSONString(cmsXStoreCollectionService.selectUserAndGetByIdStoreCollection(uId, (page -1) *pageSize , pageSize))+")"); //返回jsonp数据  
	}
	/**
	 * 根据收藏Id删除对应的记录
	 * 作者： 郑泽
	 * 日期：2016年6月18日
	 * @param t
	 * @param id
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	@RequestMapping("/deleteUserStoreAndCollectionAProduce")
	@ResponseBody
	public void deleteUserStoreAndCollectionAProduce(String t,@RequestParam("id")String id,HttpServletRequest request,HttpServletResponse response) throws IOException{
		JSONObject obj = new JSONObject();
		response.setContentType("text/plain;charset=utf-8");
		String callbackFunName =request.getParameter("callbackparam");//得到js函数名称
		if(t!=null&&t.equals("App"))
		{
			response.getWriter().write(obj.toJSONString(cmsXStoreCollectionService.deleteUserStoreAndCollectionAProduce(id)));
		}else
			response.getWriter().write(callbackFunName + "("+obj.toJSONString(cmsXStoreCollectionService.deleteUserStoreAndCollectionAProduce(id))+")"); //返回jsonp数据  
	}
	/**
	 * 根据收藏Id取消对应的收藏记录
	 * 作者： 郑泽
	 * 日期：2016年6月18日
	 * @param t
	 * @param id
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/updateUserStoreAndCollectionAProduce")
	@ResponseBody
	public void updateUserStoreAndCollectionAProduce(String t,@RequestParam("id")String id,HttpServletRequest request,HttpServletResponse response) throws IOException{
		JSONObject obj = new JSONObject();
		response.setContentType("text/plain;charset=utf-8");
		String callbackFunName =request.getParameter("callbackparam");//得到js函数名称
		if(t!=null&&t.equals("App"))
		{
			response.getWriter().write(obj.toJSONString(cmsXStoreCollectionService.updateUserStoreAndCollectionAProduce(id)));
		}else
			response.getWriter().write(callbackFunName + "("+obj.toJSONString(cmsXStoreCollectionService.updateUserStoreAndCollectionAProduce(id))+")"); //返回jsonp数据  
	}

}
