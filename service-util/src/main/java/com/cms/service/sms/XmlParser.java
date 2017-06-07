package com.cms.service.sms;


import java.io.IOException;
import java.io.InputStream;


public class XmlParser {

	public static org.jdom.Document getXmlDoc(String fileName) throws Exception {
		org.jdom.Document doc = null;
		org.jdom.input.SAXBuilder sb = new org.jdom.input.SAXBuilder();
		InputStream is = null;
		try {
			is = XmlParser.class.getClassLoader().getResourceAsStream(fileName);
			doc = sb.build(is);
		} catch (IOException e) {
			throw e;
		} finally {
			if (is != null) {
				is.close();
			}
		}
		return doc;
	}

}
