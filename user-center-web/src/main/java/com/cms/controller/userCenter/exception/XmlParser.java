package com.cms.controller.userCenter.exception;


import java.io.IOException;
import java.io.InputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.jdom.input.SAXBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;


public class XmlParser {
	private final static Logger logger = Logger.getLogger(XmlParser.class
			.getName());

	public static Document parse(String fileName) throws Exception {
		InputStream is = Thread.currentThread().getContextClassLoader()
				.getResourceAsStream(fileName);
		return parse(is);
	}

	public static Document parse(InputStream is) throws Exception {
		DocumentBuilder builder = DocumentBuilderFactory.newInstance()
				.newDocumentBuilder();
		Document doc = (Document) builder.parse(is);
		return doc;
	}

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

	public static String getNodeAttribute(Node n, String name) throws Exception {
		logger.log(Level.INFO, "node name:" + n.getNodeName()
				+ " attribute name:" + name);
		NamedNodeMap attr = n.getAttributes();
		Node tmp = attr.getNamedItem(name);
		if (tmp == null) {
			return "";
		}
		String value = tmp.getNodeValue();

		return value;
	}
}
