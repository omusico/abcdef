package com.lvmama.lvf.common.security.antirefresh;

import java.io.IOException;
import java.util.HashSet;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.lvmama.lvf.common.utils.CustomizedPropertyPlaceholderConfigurer;
import com.lvmama.lvf.common.utils.IpUtils;

public class AntiRefreshFilter implements Filter {

	private static Logger logger = Logger.getLogger(AntiRefreshFilter.class);
	
	private static String denialUrl;
	private static String defaultDenialUrl;
	private static String[] urls;
	private static String paramname;
	private static HashSet<String> paramset;
//	private static String ips = "222.66.66.82;222.66.131.98;180.168.128.250;";
	
	private static final AntiRefreshUtils antiRefreshUtils = AntiRefreshUtils.getInstances();

	public void destroy() {
	}
	
	private static String getIps(){
		try{
			String str = CustomizedPropertyPlaceholderConfigurer.getContextProperty("antiRefresh.config.notAnti.ip");
			if(null==str){
				return "";
			}
			return str;
		}catch(Exception ex){
			logger.error("load anti refresh config error",ex);
			return "";
		}
	}
	
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException{
		
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response=(HttpServletResponse) arg1;

		String path = request.getServletPath();
		if (!isInCheck(path)) {
			arg2.doFilter(arg0, arg1);
			return;
		}
		
		boolean dofilter = false;
		
//		logger.error("dofilter start!");
		if(null!=paramname){
//			logger.error(paramname);
			String paramvalue = request.getParameter(paramname);
//			logger.error(paramvalue);
			if(null!=paramvalue && null != paramset){
				if(!paramset.contains(paramvalue)){
					dofilter = true;
				}
			}
		}
		
//		logger.error("dofilter end!"+dofilter);
		if(dofilter){
			arg2.doFilter(arg0, arg1);
			return;
		}
		
		String ip = IpUtils.getIpAddr(request);
		if(isInternalIp(ip)){
			arg2.doFilter(arg0, arg1);
			return;
		}
		
		if(antiRefreshUtils.count(request,response)){
			arg2.doFilter(arg0, arg1);
			return;
		}else{
			response.sendRedirect(getDenialUrl());
			return;
		}
	}
	
	private String getDenialUrl(){
		
		if(null==denialUrl){
			return defaultDenialUrl;
		}
		
		if(denialUrl.startsWith("http")){
			return denialUrl; 
		}
		
		String url = CustomizedPropertyPlaceholderConfigurer.getContextProperty(denialUrl);
		if(null == url){
			return defaultDenialUrl;
		}
		
		return url;
	}
	
	/**
	 * 解析urlrewrite path.
	 * @param path.
	 * @return String 解析后的url.
	 */
	private boolean isInCheck(final String path) {
		if(checkUrl(path)){
			if (urls == null){
				return false;
			}
			if (urls.length == 0){
				return false;
			}
			return true;
		}
		return false;
	}
	
	/**
	 * 以下后缀的不需要过滤 
	 * @param str
	 * @return
	 */
	private boolean checkUrl(String str){
		String[] s = new String[]{".jpg",".js",".gif",".css"};
		for (int i = 0; i < s.length; i++) {
			if(str.toLowerCase().lastIndexOf(s[i])>0){
				return false;
			}
		}
		return true;
	}
	
	public void init(FilterConfig arg0) throws ServletException {
		
		denialUrl=arg0.getInitParameter("denialUrl");
		defaultDenialUrl=arg0.getInitParameter("defaultDenialUrl");
		String temp = arg0.getInitParameter("url");
		if (temp != null) {
			urls = temp.split(",");
		} 
		
		paramname = arg0.getInitParameter("paramname");
		
		if(null!=paramname){
			String param = arg0.getInitParameter("paramvalue");
			paramset = new HashSet<String>();
			if(null!=param){
				String[] params=param.split(",");
				for(String p:params){
					if(null!=p){
						paramset.add(p);
					}
				}
			}
		}
		
	}
	
	private boolean isInternalIp(String ip){
		if(StringUtils.isNotEmpty(ip)){
			if(getIps().contains(ip)){
				return true;
			}
		}
		return false;
	}

}
