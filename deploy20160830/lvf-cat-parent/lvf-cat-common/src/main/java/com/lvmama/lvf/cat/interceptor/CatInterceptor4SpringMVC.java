package com.lvmama.lvf.cat.interceptor;


import com.dianping.cat.Cat;
import com.dianping.cat.message.Message;
import com.dianping.cat.message.Transaction;
import com.lvmama.lvf.cat.constants.CatComConstants;
import com.lvmama.lvf.cat.utils.IpUtils;
import com.lvmama.lvf.cat.utils.LoggerNameUtil;
import org.apache.commons.lang.time.DateFormatUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@Component
public class CatInterceptor4SpringMVC implements HandlerInterceptor {


	private ThreadLocal<Transaction> tranLocal = new ThreadLocal<Transaction>();

	private ThreadLocal<Transaction> pageLocal = new ThreadLocal<Transaction>();


	public boolean preHandle(HttpServletRequest request,HttpServletResponse response, Object handler) throws Exception {

		String loggerName = LoggerNameUtil.getLoggerName(request);
		Transaction t = Cat.newTransaction(CatComConstants.WEB_URL, loggerName);
		Cat.logEvent(CatComConstants.WEB_METHOD, request.getRequestURL().toString(),Message.SUCCESS,request.getMethod());
		Cat.logEvent(CatComConstants.WEB_HOST, IpUtils.getIpAddr(request),Message.SUCCESS,request.getRemoteHost());
		tranLocal.set(t);
		return true;
	}

	public void postHandle(HttpServletRequest request,HttpServletResponse response,
		Object handler,ModelAndView modelAndView) throws Exception {
		String viewName = modelAndView != null?modelAndView.getViewName():"no view name";
		String loggerName = "["+viewName+"]";
		Transaction t = Cat.newTransaction(CatComConstants.WEB_VIEW, loggerName);
		pageLocal.set(t);
	}

	public void afterCompletion(HttpServletRequest request,
		HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

		//请求-页面渲染前
		Transaction pt = pageLocal.get();

		if(null != pt){
			pt.setStatus(Transaction.SUCCESS);
			pt.complete();
		}

		//总计
		Transaction t = tranLocal.get();
		if(null != t){
			t.setStatus(Transaction.SUCCESS);
			t.complete();
		}

	}

}
