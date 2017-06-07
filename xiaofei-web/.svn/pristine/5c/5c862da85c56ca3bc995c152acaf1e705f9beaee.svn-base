package com.cms.controller.xiaofei;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.dubbo.common.json.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cms.controller.test.DataTime;
import com.cms.controller.test.HttpRequest;
import com.cms.iservice.common.GlobalIdService;
import com.cms.iservice.xiaofei.LogisticalXiaofeiService;
import com.cms.model.xiaofei.CmsXLogisticsDetail;
import com.cms.model.xiaofei.CmsXLogisticsReq;
import com.cms.model.xiaofei.DataList;
import com.cms.util.CmsUtil;

@Controller
@RequestMapping("/logistical")
public class CmsWlLogistcalControll {

	@Autowired
	private LogisticalXiaofeiService logisticalXiaofeiService;
	
	@Autowired
	private GlobalIdService globalIdService;
	
	/**
	 * 生成 货/订单号
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("/getId")
	@ResponseBody
	private String getId() throws IOException{
		String id = Long.toString(globalIdService.getGlobalId());
		return id;
	}
	/**
	 * 发布物流需求
	 * @param cmsXLogisticsReq
	 * @param goodsName 商品名称
	 * @param goodsNum 总件数
	 * @param weight 体重
	 * @param volume 体积
	 * @param price 价格
	 * @param request
	 * @param response
	 * @throws Exception 
	 */
	@RequestMapping("/insertorUpdateLogistical")
	//@ResponseBody
	public ModelAndView insertorUpdateLogistical(CmsXLogisticsReq cmsXLogisticsReq,String goodsName,String goodsNum,String weight,String volume,String price,
			HttpServletRequest request,HttpServletResponse response) throws Exception{
		
		cmsXLogisticsReq.setReqDate(DataTime.getTime());
		System.out.println("添加时的时间"+DataTime.getTime());
		System.out.println(cmsXLogisticsReq.getNeedReceipt()+"--"+cmsXLogisticsReq.getNeedDelivery()+"--"+cmsXLogisticsReq.getNeedCashDelivery());
		//当前用户id
		cmsXLogisticsReq.setUserId(CmsUtil.CheckLogin(request).toString());
		String[] strArrg=goodsName.split(",");
		String[] strArrn=goodsNum.split(",");
		String[] strArrw=weight.split(",");
		String[] strArrv=volume.split(",");
		String[] strArrp=price.split(",");
		ModelAndView view=new ModelAndView();
		Map<String, Object> Goodss = new HashMap<String, Object>();
		String sr=null;
		if(cmsXLogisticsReq.getUserId()!=null){
			List<Map<String, Object>> Goods = new ArrayList<Map<String, Object>>();
			//添加需求
			Integer count = logisticalXiaofeiService.insertorUpdateLogistical(cmsXLogisticsReq);
			for (int i = 0; i < strArrg.length; i++) {
				CmsXLogisticsDetail cmsXLogisticsDetail = new CmsXLogisticsDetail();
				//Map<String, Object> Goodss = new HashMap<String, Object>();
				//明细id
				cmsXLogisticsDetail.setDetailId(Long.toString(globalIdService.getGlobalId()));
				Goodss.put("Name", strArrg[i]);
				Goodss.put("Qty", strArrn[i]);
				Goodss.put("Weight", strArrw[i]);
				Goodss.put("Volume",strArrv[i]);
				Goodss.put("Price",strArrp[i]);
				Goods.add(i, Goodss);
				System.out.println(Goods);
				cmsXLogisticsDetail.setReqId(cmsXLogisticsReq.getId());
				cmsXLogisticsDetail.setGoodsName(strArrg[i]);
				cmsXLogisticsDetail.setGoodsNum(Integer.parseInt(strArrn[i]));
				cmsXLogisticsDetail.setGoodsWeight(Double.parseDouble(strArrw[i]));
				cmsXLogisticsDetail.setGoodsVolume(Double.parseDouble(strArrv[i]));
				cmsXLogisticsDetail.setGoodsValues(Double.parseDouble(strArrp[i]));
				//同步添加物流商品信息
				logisticalXiaofeiService.insertorUpdateDetail(cmsXLogisticsDetail);
				//添加订单
				String IPc = HttpRequest.readAddress(request, "wuliuapi");
				/*String getURL="?OrderId=1&OriginCityId=2&DestinationCityId=3&TransitDate=4&Consigner=5&ConsignerTel=6&ConsignerMobile=7&Receiver=8&ReceiverTel=9&ReceiverMobile=10&"
					+ "PickupAddress=11&DeliveryAddress=12&IsReceipt=13&IsInsured=14&IsUrgent=15&IsTax=16&IsPersist=17&IsCollect=18&CollectMoney=19&CollectBank=20&CollectBankCardOwner=21&"
					+ "CollectBankCarNo=22&Remarks=23&IsReceiptGoods=24&ReceiptDistance=25&IsDeliveryGoods=26&DeliveryDistance=27&"
					+ "Goods="+JSON.json(Goods)+"";*/
				
				boolean IsReceiptGoods;			//是否需要接货
				Double ReceiptDistance=0.0;		//始发地城市距离接货地距离（单位：km）
				if(cmsXLogisticsReq.getNeedReceipt()!=null&&cmsXLogisticsReq.getNeedReceipt().equals("0"))
					IsReceiptGoods=false;
				else {
					IsReceiptGoods=true;
					 ReceiptDistance= 10.00;			
					}
				
				boolean IsDeliveryGoods;		//是否需要送货
				Double DeliveryDistance=0.0;		//始发地城市距离接货地距离（单位：km）
				if(cmsXLogisticsReq.getNeedDelivery().equals("0"))
					IsDeliveryGoods=false;
				else {
					IsDeliveryGoods=true;
					DeliveryDistance= 10.00;			
					}
				boolean IsInsured;			//是否需要保险
				boolean IsNeedTax;			//是否含税
				boolean IsNeedReceipt;		//是否回单
				if(cmsXLogisticsReq.getNeedInsured().equals("1"))
					IsInsured=true;
				else 
					IsInsured=false;
				
				if(cmsXLogisticsReq.getNeedPlusDuty()!=null&&cmsXLogisticsReq.getNeedPlusDuty().equals("1"))
					IsNeedTax=true;
				else
					IsNeedTax=false;
				if(cmsXLogisticsReq.getNeedAcknowledgement()!=null&&cmsXLogisticsReq.getNeedAcknowledgement().equals("1"))
					IsNeedReceipt=true;
				else
					IsNeedReceipt=false;
				
				JSONObject obj = new JSONObject();
				String getURL="OriginCityId=001023001004"+"&DestinationCityId=001022001010"+
				"&IsReceiptGoods="+IsReceiptGoods+"&ReceiptDistance="+ReceiptDistance+"&IsDeliveryGoods="+IsDeliveryGoods+"&DeliveryDistance="+DeliveryDistance+"&IsInsured="+IsInsured+"&IsNeedTax"+IsNeedTax+"&IsNeedReceipt"+IsNeedReceipt+
				"&Goods="+JSON.json(Goods);
				
				System.out.println("-----------------------------------"+getURL);
				
				System.out.println(getURL);
				sr=HttpRequest.sendPost(IPc+"/api/platform/offer",getURL);//返回成功或失败
			}
			if(count > 0){
				System.out.println("需求发布成功！");
				//调用平台报价接口
				
				String IP = HttpRequest.readAddress(request, "wuliuapi");
				String getURL="?OriginCityId=1&DestinationCityId=2&IsReceiptGoods=true&ReceiptDistance=10&IsDeliveryGoods=true&DeliveryDistance=20&IsInsured=false&IsNeedTax=false&Goods=Goods";
				System.out.println(getURL);
				//sr=HttpRequest.sendHPost("http://"+IP+":8887/api/platform/offer"+getURL, "key=123&v=456");//返回报价信息
				view.addObject("priceList", sr);
				view.addObject("cmsXLogisticsReq", cmsXLogisticsReq);
				view.setViewName("f_w/wuliu_3");
				return view;
			}
		}
		return view;		
	}
	
	/**
	 * 查看物流需求详细信息
	 * @param id
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/getReqlInfo")
	//@ResponseBody
	public ModelAndView getReqlInfo(HttpServletRequest request,String id) throws Exception {
		List<CmsXLogisticsReq> reqList =new ArrayList<>();
		//添加浏览次数
		logisticalXiaofeiService.setSeeCount(id);
		//物流信息
		CmsXLogisticsReq cmsXLogisticsReq = logisticalXiaofeiService.getReqlInfo(id);
		//物流商品信息
		List<CmsXLogisticsDetail> detailList = logisticalXiaofeiService.getReqDetaillInfo(id);
		System.out.println("cmsXLogisticsReq"+cmsXLogisticsReq);
		System.out.println("cmsXLogisticsDetail"+detailList);
		ModelAndView view=new ModelAndView();
		reqList.add(0, cmsXLogisticsReq);
		view.addObject("reqList", reqList);
		view.addObject("detailList", detailList);
		view.setViewName("f_w/wuliu_1");
		return view;
	}
	
	/**
	 * 查看物流需求信息列表
	 * @param page
	 * @param pageSize
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/getLogisticalist")
	@ResponseBody
	public void getLogistical(String t,Integer page, Integer pageSize,HttpServletRequest request,HttpServletResponse response) throws IOException  {
		JSONObject obj = new JSONObject();
		response.setContentType("text/plain;charset=utf-8");
		String callbackFunName =request.getParameter("callbackparam");//得到js函数名称 
		DataList data=new DataList();
		if(t!=null&&t.equals("App"))
		{
			data.setListData(logisticalXiaofeiService.getLogistical((page -1) *pageSize , pageSize));
			response.getWriter().write(data.toString());
		}else
			response.getWriter().write(callbackFunName + "("+
		obj.toJSONString(logisticalXiaofeiService.getLogistical((page -1) *pageSize , pageSize))+")"); //返回jsonp数据  
	}
	
	/**
	 * 物流价格信息插入
	 * @param DistanceFee
	 * @param ReceiptGoodsFee
	 * @param DeliveryGoodsFee
	 * @param InsuredFee
	 * @param TaxFee
	 * @param AmountFee
	 * @param state
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/updatePrice")
	@ResponseBody
	public void updatePrice(String DistanceFee,String ReceiptGoodsFee,String DeliveryGoodsFee,String InsuredFee,String TaxFee,String AmountFee,Integer state,String id,
			HttpServletRequest request,HttpServletResponse response) throws Exception{
		
		System.out.println(DistanceFee+"----------"+state+"---------"+id);
		
		/*String OriginCityId;		//		是	起始地编号
		String DestinationCityId;		//否	到达地编号
		boolean IsReceiptGoods;		//	Bool	是	是否需要接货
		Double ReceiptDistance;		//	是	始发地城市距离接货地距离（单位：km）
		boolean IsDeliveryGoods;	//	Bool	//是	是否需要送货
		Double DeliveryDistance;	//	是	目的地城市距离送货地距离（单位：km）
		boolean IsInsured;			//	Bool	是	是否需要保险
		boolean IsNeedTax;			//	Bool	是	是否含税
		//Goods	Json	是	货物列表（格式如下）
*/		
		String OrderId;				//	String	是	货号/订单号
		String OriginCityId;		//	是	货物始发城市编号
		String DestinationCityId;	//	是	货物到达城市编号
		Date TransitDate;			//否(如空为当前时间)	托运日期
		String Consigner;			//	是	发货人
		String ConsignerTel;		//		与发货人手机二者必填一项	发货人座机
		String ConsignerMobile;		//	与发货人座机二者必填一项	发货人手机
		String Receiver;			//	是	收货人	
		String ReceiverTel;			//	与收货人手机二者必填一项	收货人座机
		String ReceiverMobile;		//	与收货人座机二者必填一项	收货人手机
		String PickupAddress;		//	否	接货地址
		String DeliveryAddress;		//	否	送货地址
		boolean IsReceipt;			//	是	是否需要回单
		boolean IsInsured;			//	是	是否需要保险
		boolean IsUrgent;			//	是	是否加急
		boolean IsNeedTax;			//	是	是否含税(开票)
		boolean IsPersist;			//	是	是否要求控货
		boolean IsCollect;			//	是	是否要代收款
		String CollectMoney;		//	否（有代收款则必填） 代收金额	
		String CollectBank;			//	否（有代收款则必填）	代收银行
		String CollectBankCardOwner;//	String	否（有代收款则必填）	银行持卡人
		String CollectBankCarNo;	//	否（有代收款则必填）	代收款银行卡号
		String Remarks;				//	否	备注信息
		boolean IsReceiptGoods;		//	是	是否需要接货
		Double ReceiptDistance;		//	是	始发地城市距离接货地距离（单位：km）
		boolean IsDeliveryGoods;	//	是	是否需要送货
		Double DeliveryDistance;	//	是	目的地城市距离送货地距离（单位：km）
		/*String DistanceFee;	string	是	运输费(报价验证)
		String ReceiptGoodsFee;	string	是	接货费(报价验证)
		String DeliveryGoodsFee;	string	是	送货费(报价验证)
		String InsuredFee;	string	是	保险费(报价验证)
		String TaxFee;	string	是	税费(报价验证)
		String AmountFee;	string	是	总费用(报价验证)*/
		//Goods	Json	是	货物列表
		
		
		CmsXLogisticsReq list=logisticalXiaofeiService.getReqlInfo( id);		
		
		
		Integer count = logisticalXiaofeiService.insertOrUpdateLPrice(DistanceFee, ReceiptGoodsFee, DeliveryGoodsFee, InsuredFee, TaxFee, AmountFee, state, id);
		if(count>0){
			
			
			
			
			System.out.println("报价插入成功");
		}
	}
	
	/**
	 * 身份认证
	 * @return access_token
	 */
	@RequestMapping("/shenFenRenZhen")
	@ResponseBody
	public String  shenFenRenZhen() {
		HttpServletRequest request=null;
		String sr=null;
		 try {
			 String IP = HttpRequest.readAddress(request, "wuliuapi");
			 String getURL="?grant_type=client_credentials&client_id=Platform&client_secret=eyJ0eXAiOiJKV1QiLCJhbGciOiJIU";
			 System.out.println(getURL);
			 //发送 POST 请求
			  sr=HttpRequest.sendHPost("http://"+IP+":8880/oauth/token"+getURL, "key=123&v=456");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		 return "{\"access_token\": \"eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1bmlxdWVfbmFtZSI6IlBsYXRmb3JtIiwicm9sZSI6IlBsYXRmb3JtIiwiaXNzIjoiY21zLmxvZ2lzdGljcy5pZGVudGl0eSIsImF1ZCI6IjQxNGUxOTI3YTM4ODRmNjhhYmM3OWY3MjgzODM3ZmQxIiwiZXhwIjoxNDYzNTUzNzA5LCJuYmYiOjE0NjM0NjczMDl9.g2vfQ8MYUCec219j7BOi1JiNVTS1XrtFRIv_fw1CqbM\",\"token_type\": \"bearer\",\"expires_in\": 86399}";
	}

	/**
	 * 厂商计划
	 * @return 
	 * @throws IOException
	 */
	@RequestMapping("/changShangJiHua")
	@ResponseBody
	public String  changShangJiHua() throws IOException {
		HttpServletRequest request=null;
		String sr=null;
		 try {
			 String IP = HttpRequest.readAddress(request, "wuliuapi");
			 //String getURL="?grant_type=client_credentials&client_id=Platform&client_secret=eyJ0eXAiOiJKV1QiLCJhbGciOiJIU";
			// System.out.println(getURL);
			 //发送 POST 请求
			  sr=HttpRequest.sendHPost("http://"+IP+":8887/api/platform/plan", "key=123&v=456");//+getURL
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		 return JSON.json(sr);
	}
	
}
