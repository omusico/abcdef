package com.lvmama.lvfit.common.aspect.exception;

import java.lang.reflect.Method;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lvmama.lvf.common.exception.ExceptionWrapper;
import com.lvmama.lvf.common.trace.TraceContext;
import com.lvmama.lvf.common.utils.JSONMapper;
import com.lvmama.lvfit.common.dto.enums.FitBusinessExceptionType;
import com.lvmama.lvfit.common.dto.trace.FitOpLogTraceContext;
import com.lvmama.lvfit.common.utils.FitLoggerHandler;

@Aspect
@Component
public class ExceptionAspect {
	
	public static Logger logger = LoggerFactory.getLogger(ExceptionAspect.class);
	
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
	
	@Around("@annotation(com.lvmama.lvfit.common.aspect.exception.ExceptionPoint)")
	public Object exception(ProceedingJoinPoint pjp) throws Throwable {
		
		    Method method = this.getMethod(pjp);
		    ExceptionPoint exceptionPoint = method.getAnnotation(ExceptionPoint.class);
		    FitBusinessExceptionType exceptionType = exceptionPoint.value(); 
			Object[] args=pjp.getArgs();
			StringBuilder requestJson = new StringBuilder();
			for(Object arg:args){
				try{
					requestJson.append(JSONMapper.getInstance().writeValueAsString(arg));
				}catch(Exception ex){
					logger.error(ex.getLocalizedMessage());
				}
		   }
		  Object returnObj = null;
		  try{
			  returnObj = pjp.proceed();
			  return returnObj;
		  }catch(Exception e){
			  FitOpLogTraceContext.setFitOpLog(requestJson,e,TraceContext.getTraceId(),exceptionType);
			  if(e instanceof ExceptionWrapper){
				  ExceptionWrapper ew = (ExceptionWrapper)e;
				  throw ew;
			  }else{
				 throw new RuntimeException(e);
			  }
		 }
	}
	
	
}
