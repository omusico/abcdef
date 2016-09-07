package com.lvmama.lvf.common.trace;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TraceAspect {
	
	@Around("@annotation(com.lvmama.lvf.common.trace.TraceWithBaseTraceInfo)")
	public Object eventTrigger(ProceedingJoinPoint pjp) throws Throwable {
		try{
			
			try{
				for(Object object:pjp.getArgs()){
					if(null!=object && object instanceof BaseTraceInfo){
						TraceContext.startTrace((BaseTraceInfo)object);
						break;
					}
				}
			}catch(Exception ex){
			}
			Object obj = pjp.proceed();
			return obj;
			
		}finally{
			TraceContext.clear();
		}
	}
	
}
