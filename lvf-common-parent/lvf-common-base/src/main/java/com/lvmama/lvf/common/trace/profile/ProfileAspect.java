package com.lvmama.lvf.common.trace.profile;

import java.lang.reflect.Method;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.lvmama.lvf.common.event.Event;
import com.lvmama.lvf.common.event.EventPoint;
import com.lvmama.lvf.common.trace.TraceContext;
import com.lvmama.lvf.common.utils.JSONMapper;

@Aspect
@Component
public class ProfileAspect {
	
	public static Logger logger = LoggerFactory.getLogger(ProfileAspect.class);
	
	private String getProfilePoint(ProceedingJoinPoint pjp){
		
		Signature signature = pjp.getSignature();
		MethodSignature methodSignature = (MethodSignature) signature;
		Method method = methodSignature.getMethod();
		ProfilePoint point = method.getAnnotation(ProfilePoint.class);
		String pointstr = point.value().name()+" "+point.value().getCnName();
		return pointstr;
		
	}
	
	@Around("@annotation(com.lvmama.lvf.common.trace.profile.ProfilePoint)")
	public Object profile(ProceedingJoinPoint pjp) throws Throwable {
		
		String point=null;
		long start=0;
		if(logger.isInfoEnabled()){
			point = getProfilePoint(pjp);
			Object[] args=pjp.getArgs();
			StringBuilder json = new StringBuilder("");
			for(Object arg:args){
				try{
					json.append(JSONMapper.getInstance().writeValueAsString(arg));
				}catch(Exception ex){
				}
			}
//			logger.info(TraceContext.getTraceId()+" request:"+json.toString());
			start = System.currentTimeMillis();
			logger.info(TraceContext.getTraceId()+" "+point+" start! ");
		}
		
		try{
			Object obj = pjp.proceed();
			return obj;
		}finally{
			if(logger.isInfoEnabled()){
				logger.info(TraceContext.getTraceId()+" "+point+" end! "+(System.currentTimeMillis()-start));
			}
		}
	}
	
}
