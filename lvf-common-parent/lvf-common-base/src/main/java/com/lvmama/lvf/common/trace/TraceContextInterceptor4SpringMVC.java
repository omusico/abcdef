package com.lvmama.lvf.common.trace;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.lvmama.lvf.common.utils.CustomizedPropertyPlaceholderConfigurer;


@Component
public class TraceContextInterceptor4SpringMVC implements HandlerInterceptor {

	private static Logger logger = LoggerFactory.getLogger(TraceContextInterceptor4SpringMVC.class); 
	
	@Autowired(required=false)
	private TraceExtendHandler executeHandler;
	
	@Value("offline.index.enabled")
	private String offlineIndexEnabled;
	/** 验证是否要添加拦截器**/
	private Boolean offlineFlag = false;
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
//		logger.warn("startTrace"+request.getRequestURI()+":"+request.getQueryString());
		TraceContext.startTrace(request);
		TraceContext.setCustomer(String.valueOf(request.getSession().getAttribute("userMemberName")));
		if(null!=executeHandler){
			executeHandler.execute(request,response);
		}

		if(!this.isOfflineIndexEnabled() && offlineFlag){
			if(null==TraceContext.getOperObject()
					&& !request.getRequestURI().contains("userLogin")){
			    response.sendRedirect("http://super.lvmama.com/pet_back/login.do");  
				return false;
			}
		}
		
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
		TraceContext.clear();
	}

	public boolean isOfflineIndexEnabled() {
		boolean isOfflineIndexEnabled = Boolean.valueOf(CustomizedPropertyPlaceholderConfigurer.getContextProperty(offlineIndexEnabled) + "");
		return isOfflineIndexEnabled;
	}

	public Boolean getOfflineFlag() {
		return offlineFlag;
	}

	public void setOfflineFlag(Boolean offlineFlag) {
		this.offlineFlag = offlineFlag;
	}


	
}
