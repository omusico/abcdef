package com.lvmama.lvfit.common.aspect.suppinterface;

import java.lang.reflect.Method;
import java.util.Date;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lvmama.lvf.common.dto.RequestResponse;
import com.lvmama.lvf.common.exception.ExceptionCode;
import com.lvmama.lvf.common.exception.ExceptionWrapper;
import com.lvmama.lvf.common.utils.DateUtils;
import com.lvmama.lvf.common.utils.JSONMapper;
import com.lvmama.lvfit.common.utils.FitLoggerHandler;

@Aspect
@Component
public class SuppInterfaceAspect {
	
	public static Logger logger = LoggerFactory.getLogger(SuppInterfaceAspect.class);
	
	@Autowired
	private FitLoggerHandler fitLoggerHandler; 
	
	/**
	 * 获取当前接口点的方法名称
	 * @param pjp
	 * @return
	 */
	private Method getMethod(ProceedingJoinPoint pjp){
		Signature signature = pjp.getSignature();
		MethodSignature methodSignature = (MethodSignature) signature;
		Method method = methodSignature.getMethod();
		return method;
	}
	
	@Around("@annotation(com.lvmama.lvfit.common.aspect.suppinterface.SuppInterfacePoint)")
	public Object suppInterface(ProceedingJoinPoint pjp) throws Throwable {
		
		    String gid= UUID.randomUUID().toString();
		    Method method = this.getMethod(pjp);
		    String methodName = method.getName();
		    SuppInterfacePoint interfacePoint = method.getAnnotation(SuppInterfacePoint.class);
			String interfacePointName = interfacePoint.value().name(); 
			Object[] args=pjp.getArgs();
			StringBuilder requestJson = new StringBuilder();
			for(Object arg:args){
				try{
					requestJson.append(JSONMapper.getInstance().writeValueAsString(arg));
				}catch(Exception ex){
					logger.error(ex.getLocalizedMessage());
				}
			}
		   fitLoggerHandler.addFitLog(RequestResponse.RE.toString(), interfacePointName, args, StringUtils.EMPTY , gid);
		   Object returnObj = null;
		   String errorMsg = null;
		   try{
			     returnObj = pjp.proceed();
				 return returnObj;
		  }catch(Exception e){
			  if(e instanceof ExceptionWrapper){
				  ExceptionWrapper ew = (ExceptionWrapper)e;
				  errorMsg = ew.getErrMessage();
			  }else{
				  errorMsg = ExceptionUtils.getFullStackTrace(e);
			  }
			  String curTime = DateUtils.formatDate(new Date(), DateUtils.YYYY_MM_DD_HH_MM_SS);
			  ExceptionWrapper throwEw = new ExceptionWrapper(ExceptionCode.CALL_INTERFACE_ERROR, curTime,methodName,errorMsg);
			  logger.error(throwEw.getErrMessage());
			  throw throwEw;
		  }finally{
			  if(returnObj==null){
				  returnObj = errorMsg;
			  }
			  fitLoggerHandler.addFitLog(RequestResponse.RS.toString(),interfacePointName,returnObj, StringUtils.EMPTY, gid);
		  }
	}
}
