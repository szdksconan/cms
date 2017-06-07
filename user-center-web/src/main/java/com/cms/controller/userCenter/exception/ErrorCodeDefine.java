package com.cms.controller.userCenter.exception;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jdom.Document;
import org.jdom.Element;

public class ErrorCodeDefine {
	private static Map errMsg=new HashMap();
	public static Map getFlowNodeMap(){
		if(errMsg.size()==0)
			initErrMsg();
		return errMsg;
	}
	
	public  static void initErrMsg(){
		try{
			Document doc=XmlParser.getXmlDoc("/spring/errmsg.xml");
			Element rootElement=doc.getRootElement();
			List defineList=rootElement.getChildren("errmsg");
			for(int i=0;i<defineList.size();i++){
				Element tempElement=(Element)defineList.get(i);
				String key=tempElement.getChildText("key");
				String msg=tempElement.getChildText("msg");
				errMsg.put(key, msg);
				
			}
		}catch(Exception e){
			
		}
	}
	
	public static String getMessage(String code){
		Map map=getFlowNodeMap();		
		String msg=(String)map.get(code);		
		return msg;
	}
	
	public static String getMessage(String code,String[] attrs){
		Map map=getFlowNodeMap();		
		String msg=(String)map.get(code);
		if(msg!=null){
			if(attrs!=null){
				for(int i=0;i<attrs.length;i++){
					String flag="{"+i+"}";
					int pos=msg.indexOf(flag);
					String str1=msg.substring(0, pos);			
					String str2=msg.substring(pos+3,msg.length());
					msg=str1+attrs[i]+str2;			
				}
			}
		}else{
			msg="";
		}
		
		return msg;
	}
	
	
	
}
