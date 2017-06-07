package com.cms.controller.xiaofei;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.dubbo.common.json.JSON;
import com.cms.iservice.common.GlobalIdService;
import com.cms.iservice.maoyi.EnterpriseToOutService;
import com.cms.iservice.maoyi.OrderService;
import com.cms.iservice.maoyi.ProductCenterService;
import com.cms.iservice.xiaofei.CmsXGoodsAddressService;
import com.cms.iservice.xiaofei.CmsXShoppingcartService;
import com.cms.model.maoyi.CmsOrder;
import com.cms.model.maoyi.CmsOrderItem;
import com.cms.model.maoyi.CmsProduct;
import com.cms.model.maoyi.EnterpriseToOutBean;
import com.cms.model.xiaofei.CmsXGoodsAddress;
import com.cms.model.xiaofei.CmsXOrderEvaluation;
import com.cms.model.xiaofei.CmsXProductEvaluation;
import com.cms.model.xiaofei.CmsXShoppingcart;
import com.cms.model.xiaofei.DataList;
import com.cms.util.CmsUtil;
@Controller
@RequestMapping("/ShoppingData")
public class CmsShopIndentDataController {
	
	@Autowired
	private GlobalIdService gis;
	
	@Autowired
	private OrderService os;
	
	@Autowired
	private EnterpriseToOutService etos;
	
	@Autowired
	private CmsXShoppingcartService xshops;
	
	@Autowired
	private ProductCenterService pcs;
	
	@Autowired
	private CmsXGoodsAddressService cmsXGoodsAddressService;
	
	/**
	 * 获取时间
	 * 作者： 李俊霖
	 * 日期：2016年5月26日
	 * @return
	 */
	private Date dateTime(){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date=new Date();
		String dateStr = sdf.format(date);
		
		return date;
	}
	private String getTime(){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date=new Date();
		String dateStr = sdf.format(date);
		
		return dateStr;
	}
	
	/**
	 * 用户查询全部订单
	 * 作者： 李俊霖
	 * 日期：2016年6月2日
	 * @param orderId 订单id
	 * @param customerId	用户id
	 * @param page
	 * @param pagesize
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getOrderInfoList")
	@ResponseBody
	public String  getOrderInfoList(String t,String orderId,String customerId,Integer page,Integer pagesize,HttpServletRequest request) throws Exception  {
		HashMap<String,Object> map=new HashMap<String,Object>();
		 customerId=CmsUtil.CheckLogin(request);
		 System.out.println(customerId+"--------------------");
		 if(page==null||page.equals(""))
			 page=1;
		 if(pagesize==null||pagesize.equals(""))
			 pagesize=8;
			map.put("customerId",customerId);
			map.put("page",(page-1)*pagesize);
			map.put("pagesize",page*pagesize);
		List<CmsOrder> list=os.getOrderInfoList(map);
		
		for(int i=0;i<list.size();i++)
		System.out.println("----------------------------------------------dateTime---"+list.get(i).getOrderTime());
		DataList data=new DataList();
		if(t!=null&&t.equals("App"))
		{
			data.setListData(list);
			return data.toString();
		}else
			return JSON.json(list);
	}
	
	/**
	 * 查看订单详情
	 * 作者： 李俊霖
	 * 日期：2016年6月2日
	 * @param request
	 * @param num
	 * @param pid
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/ordersIdData")
	//@ResponseBody
	public ModelAndView  ordersIdData(HttpServletRequest request,String orderId) throws Exception {
		System.out.println("--------------------------------"+orderId);
		HashMap<String,Object> map=new HashMap<String,Object>();
		 String customerId=CmsUtil.CheckLogin(request);
		 System.out.println(customerId);
			map.put("customerId",customerId);
			map.put("orderId",orderId);
		List<CmsOrder> list=os.getOrderInfoList(map);
		ModelAndView view=new ModelAndView();
		System.out.println(JSON.json(list));
			view.addObject("lista", list);
			view.setViewName("note_d");
			return view;
	}
	/**
	 * 订单跳转到支付页面
	 * 作者： 李俊霖
	 * 日期：2016年6月15日
	 * @param request
	 * @param orderId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getordersIdData")
	public ModelAndView  getordersId(HttpServletRequest request,String orderId) throws Exception {
		System.out.println("--------------------------------"+orderId);
		HashMap<String,Object> map=new HashMap<String,Object>();
		 String customerId=CmsUtil.CheckLogin(request);
		 System.out.println(customerId);
			map.put("customerId",customerId);
			map.put("orderId",orderId);
		List<CmsOrder> list=os.getOrderInfoList(map);
		ModelAndView view=new ModelAndView();
		System.out.println(JSON.json(list));
			view.addObject("lista", list);
			view.setViewName("gouc_main1");
			return view;
	}
	/**
	 * 跳转到评论页面
	 * 作者： 李俊霖
	 * 日期：2016年6月16日
	 * @param request
	 * @param orderId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/skipNotePin")
	public ModelAndView  skipNotePin(HttpServletRequest request,String orderId) throws Exception {
		System.out.println("--------------------------------"+orderId);
		HashMap<String,Object> map=new HashMap<String,Object>();
		 String customerId=CmsUtil.CheckLogin(request);
		 System.out.println(customerId);
			map.put("customerId",customerId);
			map.put("orderId",orderId);
		List<CmsOrder> list=os.getOrderInfoList(map);
		ModelAndView view=new ModelAndView();
		System.out.println(JSON.json(list));
			view.addObject("lista", list);
			view.setViewName("f_w/note_pin");
			return view;
	}
	
	/**
	 * 插入评论信息
	 * 作者： 李俊霖
	 * 日期：2016年6月16日
	 * @param request
	 * @param orderId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/setPin")
	@ResponseBody
	public String  setPin(HttpServletRequest request,String orderId, @RequestParam("Content[]")List<String> Content,@RequestParam("shopPin[]")List<String> shopPin) throws Exception {
		System.out.println("-----------**************************---------------------------");
		CmsXProductEvaluation cpe=new CmsXProductEvaluation();
		CmsXOrderEvaluation coe=new CmsXOrderEvaluation();
		
		String ID=gis.getGlobalId().toString();
		
		DataList data=new DataList();
		
		HashMap<String,Object> map=new HashMap<String,Object>();
		 String customerId=CmsUtil.CheckLogin(request);
		 System.out.println(customerId);
			map.put("orderId",orderId);
		List<CmsOrder> list=os.getOrderInfoList(map);
		System.out.println();
		cpe.setEvaluationId(gis.getGlobalId().toString());
		System.out.println("***************"+orderId);
		cpe.setOrderId(orderId);
		cpe.setStoreId(list.get(0).getEntId());
		cpe.setStoreName(list.get(0).getEntName());
		cpe.setEvaluationTime(getTime());
		cpe.setUserId(CmsUtil.CheckLogin(request));
		cpe.setOrderTime(getTime());
		
		for(int i=0;i<Content.size();i++){/*list.get(0).getCmsOrderItem().size()*/
			cpe.setEvaluationId(gis.getGlobalId().toString());
			cpe.setEvaluationContent(Content.get(i).toString());
			cpe.setEvaluationLevel(Integer.parseInt(shopPin.get(i)));
			cpe.setProductId(list.get(0).getCmsOrderItem().get(i).getProductId());
			cmsXGoodsAddressService.setPininsertSelective(cpe);
		}
		
		coe.setEvaluationId(gis.getGlobalId().toString());
		coe.setOrderId(orderId);
		coe.setStoreId(list.get(0).getEntId());
		coe.setStoreName(list.get(0).getEntName());
		coe.setEvaluationTime(getTime());
		coe.setUserId(CmsUtil.CheckLogin(request));
		for(int i=0;i<Content.size();i++){/*list.get(0).getCmsOrderItem().size()*/
			coe.setEvaluationContent(Content.get(i).toString());
			coe.setEvaluationLevel(Integer.parseInt(shopPin.get(i)));
			
		}
		
		//data.setListData();
		cmsXGoodsAddressService.setPinOrderinsertSelective(coe);
		
			return data.toString();
	}
	
	
	
	/**
	 * 插入订单信息
	 * 作者： 李俊霖
	 * 日期：2016年6月3日
	 * @param productId	
	 * @param addressId
	 * @param num
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/insertOrderOne")
	@ResponseBody
	public String  insertOrderOne(String productId,String addressId,String num) throws Exception {
		System.out.println("------------------------------------------"+productId);
		CmsOrderItem COI = new CmsOrderItem();    //订单详情
		List<CmsOrderItem> listCOI = new ArrayList<>();
		CmsOrder cod=new CmsOrder() ;   //订单
		Date date=new Date();
		CmsXShoppingcart cmsXShoppingcart=new CmsXShoppingcart();
		CmsProduct shopList=new CmsProduct();
		Integer totalPrice = 0;
		/*查询收货地址信息*/
		CmsXGoodsAddress address=cmsXGoodsAddressService.selectUserAndGoodsAndAddressId(addressId);
		
		/*查询商品信息*/
		String ID=gis.getGlobalId().toString();
		String EnterpriceId="";
		
		
		/*HashMap<String,CmsProduct> cmsProduct= new HashMap<String,CmsProduct>();
		  CmsProduct cp = new CmsProduct();
		if(!id.equals("")){
			cp.setEnterpriceId(id);
			System.out.println("id======="+cp.getEnterpriceId());
			  cp.setEnterpriceId(id);
			  cmsProduct.put("cmsProduct",cp);
			
			//map.
			List<CmsProduct> list=pcs.selectProductList(cmsProduct);*/
		
		
		String[] pIdArray = productId.split(",");
		String[] numArray = num.split(",");
        for (int i = 0; i < pIdArray.length; i++) {
        	
        	 shopList=pcs.selectProductInfoById(pIdArray[i]);
			//list.add(i, product);
            System.out.println(pIdArray[i]);
            listCOI.add(i,setCOI(shopList,ID,Integer.parseInt(numArray[i])));
            EnterpriceId=shopList.getEnterpriceId();
            totalPrice+=(Integer.parseInt(numArray[i])*shopList.getProductPrice().intValue());
        }
		
		
		
//		listCOI.add(0, setCOI(shopList,ID));
			
			
		 //查询商家信息
		
		EnterpriseToOutBean etb=etos.getEnterpriseOutInfo(Long.parseLong(EnterpriceId));
		//etb.getEnterpriseInfo();
		cod.setCmsOrderItem(listCOI);
		System.out.println(listCOI.get(0).getItemId());
		
		HashMap<String, CmsOrder> map=new HashMap<String, CmsOrder>();
		map.put("cmsOrder", setCmsOrder(cod,etb,ID,address,BigDecimal.valueOf(totalPrice)));
		int list=os.insertOrder(map);
		System.out.println(list);
		
		return JSON.json(list);
	}
	
	
	/**
	 * 更具商品id获取信息
	 * 作者： 李俊霖
	 * 日期：2016年5月27日
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/Shopping")
	//@ResponseBody
	public ModelAndView  Shopping(HttpServletRequest request,String goodsId,String num,String pid,String shopId) throws Exception {
		HashMap<String,CmsProduct> cmsProduct= new HashMap<String,CmsProduct>();
		System.out.println("------------num="+num+"---------------pid="+pid+"----------------------shopId="+shopId);
		CmsProduct cp = new CmsProduct();
		cp.setEnterpriceId(shopId);
		cp.setProductId(pid);
		cmsProduct.put("cmsProduct",cp);
		List<CmsProduct> list=pcs.selectProductList(cmsProduct);
		System.out.println("---------------111--------"+JSON.json(list));
		if(list.size()>0)
			list.get(0).setUnit(num);
		
		
		
		
			
			//product.setUnit("999");//把添加的个数放在unit中
			
			ModelAndView view=new ModelAndView();
			view.addObject("list", list);
			view.setViewName("gouc_main");
			return view;
	}
	
	
	/**
	 * 购物车选择商品    到提交订单页面
	 * 作者： 李俊霖
	 * 日期：2016年6月3日
	 * @param request
	 * @param num
	 * @param pid
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/Shoppinglist")
	//@ResponseBody
	public ModelAndView  Shoppinglist(HttpServletRequest request,String num,String pid,String goodsId) throws Exception {
		
		System.out.println("------------num="+num+"---------------pid="+pid);
		
		List<CmsProduct> list =new ArrayList<>();
		
		String[] pIdArray = pid.split(",");
		String[] numArray = num.split(",");
		String[] goodsIdArray = goodsId.split(",");
        for (int i = 0; i < pIdArray.length; i++) {
        	
        	HashMap<String,CmsProduct> cmsProduct= new HashMap<String,CmsProduct>();
  		  CmsProduct cp = new CmsProduct();
  			System.out.println("id======="+cp.getEnterpriceId());
  			cp.setProductId(pIdArray[i]);
  			cp.setGoodsId(goodsIdArray[i]);
  			  cmsProduct.put("productId",cp);
  			  cmsProduct.put("goodsId",cp);
  			//map.
  			 list=pcs.selectProductList(cmsProduct);
        	
        	
        	//CmsProduct product=pcs.selectProductInfoById(pIdArray[i]);
  			 if(list!=null)
  				 list.get(i).setUnit(numArray[i]);/*product.setUnit(numArray[i]);*/
        	System.out.println("product--------------"+pIdArray[i]+"-----"+JSON.json(list.get(i).getUnit()));
			//list.add(i, product);
            System.out.println(pIdArray[i]);
        }
			ModelAndView view=new ModelAndView();
			
			view.addObject("list", list);
			view.setViewName("gouc_main");
			return view;
			
			
	}
	
	/**
	 * 用户更改收货信息
	 * 作者： 李俊霖
	 * 日期：2016年6月3日
	 * @param request
	 * @param address
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/updateAddressId")
	//@ResponseBody
	public String  updateUserAndGoodsAndAddressId(String t,HttpServletRequest request,CmsXGoodsAddress address) throws Exception {
		
			Integer list=cmsXGoodsAddressService.updateUserAndGoodsAndAddressId(address);
			DataList data=new DataList();
			if(t!=null&&t.equals("App"))
			{
				data.setListData(list);
				return data.toString();
			}else
				return JSON.json(list);
			
			
	}
	/**
	 * 用户修改订单信息
	 * 作者： 李俊霖
	 * 日期：2016年6月3日
	 * @param request
	 * @param ordersId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/updateshoppingstate")
	@ResponseBody
	public String  updateshoppingstate(HttpServletRequest request,String ordersId,String status) throws Exception {
		HashMap<String, Object> map=new HashMap<String, Object>();
		
		List<String> orderid = new ArrayList<String>();
				orderid.add(ordersId);
		map.put("orderIds",orderid);
		
		
		map.put("status","60");
			Integer list=os.updateOrderStatus(map);
			System.out.println(list+"-+---"+ordersId);
			return JSON.json(list);
			
			
	}
	/**
	 * 修改订单支付状态
	 * 作者： 李俊霖
	 * 日期：2016年6月15日
	 * @param request
	 * @param ordersId
	 * @param status
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/updateshoppingpaystate")
	@ResponseBody
	public String  updateshoppingpaystate(HttpServletRequest request,String ordersId,String status) throws Exception {
		HashMap<String, Object> map=new HashMap<String, Object>();
		
		List<String> orderid = new ArrayList<String>();
				orderid.add(ordersId);
		map.put("orderIds",orderid);
		
		
		map.put("status","60");
			Integer list=os.updateOrderStatus(map);
			System.out.println(list+"-+---"+ordersId);
			return JSON.json(list);
			
			
	}
	
	
	
	/**
	 * set订单明细 单个商品
	 * 作者： 李俊霖
	 * 日期：2016年5月26日
	 * @param shopList
	 * @return
	 */
	public CmsOrderItem setCOI(CmsProduct shopList,String ID,Integer num){
		CmsOrderItem cmsOrderItem = new CmsOrderItem();
		cmsOrderItem.setDiscount(BigDecimal.valueOf(0));//优惠金额
		cmsOrderItem.setItemId(gis.getGlobalId().toString());
		cmsOrderItem.setMemo(null);
		cmsOrderItem.setOrderId(ID);
		if(shopList.getCmsAttrVal().size()>0){
			cmsOrderItem.setProductAttrVal(shopList.getCmsAttrVal().get(0).getAttrValueCn());
		}
		cmsOrderItem.setProductId(shopList.getProductId());
		cmsOrderItem.setProductImage(shopList.getProductMainImg());
		cmsOrderItem.setProductTitle(shopList.getProductNameCn());
		cmsOrderItem.setQuantity(num);
		cmsOrderItem.setRealQuantity(num);
		cmsOrderItem.setRealTotal(BigDecimal.valueOf(num*shopList.getProductPrice().intValue()));//实际成交金额 BigDecimal.valueOf(num)    shopList.getProductPrice()
		cmsOrderItem.setRefundPrice(BigDecimal.valueOf(0));//退货金额
		cmsOrderItem.setRefundQuantity(0);//退货数量
		cmsOrderItem.setRefundStatus(1);//退货状态
		cmsOrderItem.setReviewsStatus(0);//是否评价0：默认 1已评价
		cmsOrderItem.setStatus(10);//商品状态
		cmsOrderItem.setTotal(shopList.getProductPrice());//金额
		cmsOrderItem.setUnit(null);//单位
		cmsOrderItem.setUnitPrice(shopList.getProductPrice());//单价
		
		return cmsOrderItem;
	}
	private BigDecimal BigDecimal(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * set订单明细 多个商品（购物车）
	 * 作者： 李俊霖
	 * 日期：2016年5月27日
	 * @param shopList
	 * @return
	 */
	/*public CmsOrderItem setCOI(CmsXShoppingcart shopList,String ID,String num){
		CmsOrderItem cmsOrderItem = new CmsOrderItem();
		cmsOrderItem.setDiscount(null);
		cmsOrderItem.setItemId(null);
		cmsOrderItem.setMemo(null);
		cmsOrderItem.setOrderId(null);
		cmsOrderItem.setProductAttrVal(null);
		cmsOrderItem.setProductId(null);
		cmsOrderItem.setProductImage(null);
		cmsOrderItem.setProductTitle(null);
		cmsOrderItem.setQuantity(111);
		cmsOrderItem.setRealQuantity(0);
		cmsOrderItem.setRealTotal(null);
		cmsOrderItem.setRefundPrice(null);
		cmsOrderItem.setRefundQuantity(0);
		cmsOrderItem.setRefundStatus(0);
		cmsOrderItem.setReviewsStatus(0);
		cmsOrderItem.setStatus(0);
		cmsOrderItem.setTotal(null);
		cmsOrderItem.setUnit(null);
		cmsOrderItem.setUnitPrice(null);
		
		return cmsOrderItem;
	}*/
	
	/**
	 * setCmsOrder单个
	 * 作者： 李俊霖
	 * 日期：2016年5月28日
	 * @param etb
	 * @param ID
	 * @return
	 */
	public CmsOrder setCmsOrder(CmsOrder cod,EnterpriseToOutBean etb,String ID,CmsXGoodsAddress address,BigDecimal totalPrice){
		//String ID=gis.getGlobalId().toString();
		cod.setEntName(etb.getEnterpriseInfo().getName());
		cod.setOrderId(ID);
		cod.setEntId(etb.getEnterpriseInfo().getId().toString());
		cod.setEntLogo(etb.getEnterpriseInfo().getLogoPath());
		cod.setEntTel(etb.getEnterpriseInfo().getContactPhone());
		cod.setEntMail(etb.getEnterpriseInfo().getEmail());
		cod.setEntGPS(etb.getEnterpriseInfo().getManaAddAl());	
		cod.setEntArea(etb.getEnterpriseInfo().getRegAddAn());
		cod.setEntAdress(etb.getEnterpriseInfo().getManageDetail());
		cod.setCustomerId(address.getUserId());//顾客ID
		cod.setCustomerPerson(address.getContactName());//顾客姓名
		cod.setCustomerTel(address.getAPhone());  //联系方式
		cod.setCustomerMail(null);//邮箱
		cod.setCustomerGPS(null);//收货经纬度
		cod.setCustomerArea(address.getAddressProvince()+address.getAddressCity()+address.getAddressCounty());//收获省市县
		cod.setCustomerAdress(address.getAddressDetail());//收货详细地址
		cod.setOrderTime(dateTime());
		/** 支付 **/
		cod.setPayType(0);
		cod.setPayId(null);
		cod.setDiscountRemark(null);
		
		System.out.println("--------------------totalPrice----------------"+totalPrice);
		cod.setTotalPrice(totalPrice);
		cod.setEndTime(dateTime());
		/** 支付 **/
		cod.setCreatedId(null);//用户id
		cod.setCreatedUser(null);//用户name
		
		cod.setStatus(0);//订单状态
		cod.setType(1);//客户类型
		cod.setEmsType(0);//快递方式:1快递；2物流；3上门自提
		cod.setEmsId(null);//快递单号
		cod.setEmsPrice(null);//快递费用
		
		cod.setOrderId(ID);
		return cod;
	}
	/**
	 * setCmsOrder One(多个)
	 * 作者： 李俊霖
	 * 日期：2016年5月27日
	 * @param etb
	 * @param ID
	 * @return
	 */
/*	public CmsOrder setCmsOrder(EnterpriseInfo ei,String ID){
		//String ID=gis.getGlobalId().toString();
		CmsOrder cod = null;
		cod.setEntName(etb.getEnterpriseInfo().getName());
		cod.setOrderId(ID);
		cod.setEntId(etb.getEnterpriseInfo().getId().toString());
		cod.setEntLogo(etb.getEnterpriseInfo().getLogoPath());
		cod.setEntTel(etb.getEnterpriseInfo().getContactPhone());
		cod.setEntMail(etb.getEnterpriseInfo().getEmail());
		cod.setEntGPS(etb.getEnterpriseInfo().getManaAddAl());	
		cod.setEntArea(etb.getEnterpriseInfo().getRegAddAn());
		cod.setEntAdress(etb.getEnterpriseInfo().getManageDetail());
		cod.setCustomerId(null);//顾客ID
		cod.setCustomerName(null);//顾客姓名
		cod.setCustomerTel(null);  //联系方式
		cod.setCustomerMail(null);//邮箱
		cod.setCustomerGPS(null);//收货经纬度
		cod.setCustomerArea(null);//收获省市县
		cod.setCustomerAdress(null);//收货详细地址
		cod.setOrderTime(dateTime());
		*//** 支付 **//*
		cod.setPayType(0);
		cod.setPayId(null);
		cod.setDiscountRemark(null);
		cod.setTotalPrice(null);
		cod.setEndTime(dateTime());
		*//** 支付 **//*
		cod.setCreatedId(null);//用户id
		cod.setCreatedUser(null);//用户name
		
		cod.setStatus(0);//订单状态
		cod.setType(0);//客户类型
		cod.setEmsType(0);//快递方式:1快递；2物流；3上门自提
		cod.setEmsId(null);//快递单号
		cod.setEmsPrice(null);//快递费用
		
		
		
		cod.setOrderId(ID);
		return cod;
	}*/

}
