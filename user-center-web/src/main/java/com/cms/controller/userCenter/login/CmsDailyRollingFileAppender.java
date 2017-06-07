package com.cms.controller.userCenter.login;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.DailyRollingFileAppender;

public class CmsDailyRollingFileAppender extends DailyRollingFileAppender{

	@Override
	public void setFile(String file){
		Properties prop  = new Properties();
		InputStream in  = null;
		try { 
			ClassLoader cl = CmsDailyRollingFileAppender.class.getClassLoader();
			
			in = cl.getResourceAsStream("spring/init.properties");
			prop.load(in);
		} catch (IOException e) {
			LogTool.log_exception("", e);
			try {
				throw e;
			} catch (IOException e1) {
				LogTool.log_exception("", e1);
			}
		}finally{
			IOUtils.closeQuietly(in);
		}
		String logPath = prop.getProperty("DIR.HOME")+prop.getProperty("DIR.LOCAL.LOG")+"/";
		super.setFile(logPath+file);
	}
}
