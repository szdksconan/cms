package com.cms.service.sms;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jdom.Document;
import org.jdom.Element;

public class CodeDefine {
	private static Map errMsg=new HashMap();
	public static Map getFlowNodeMap(){
		if(errMsg.size()==0)
			initErrMsg();
		return errMsg;
	}
	
	public  static void initErrMsg(){
		try{
			Document doc=XmlParser.getXmlDoc("codemsg.xml");
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
	
	
	
}
