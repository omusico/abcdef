package com.lvmama.lvf.common.log;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.commons.lang.StringUtils;

public class LogConfigContextListener implements ServletContextListener{
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		String logHome= null;
		logHome = System.getProperty("LOG_HOME");
		if(StringUtils.isBlank(logHome)){
			logHome = System.getenv("LOG_HOME");
			if(StringUtils.isNotBlank(logHome)){
				System.setProperty("LOG_HOME",logHome);
			}
		}
		//这个out是在logger加载之前的
		System.out.println("logHome:"+logHome);
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}

}
