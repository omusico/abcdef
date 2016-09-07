package com.lvmama.lvf.common.security.antirefresh;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.lvmama.lvf.common.utils.CustomizedPropertyPlaceholderConfigurer;

public class AntiRefreshFilter implements Filter {

	private static Logger logger = Logger.getLogger(AntiRefreshFilter.class);
	
	private static String denialUrl;
	private static String defaultDenialUrl;
	private static String[] urls;
	
	private static final AntiRefreshUtils antiRefreshUtils = AntiRefreshUtils.getInstances();

	public void destroy() {
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
	}

}
