package com.lvmama.lvf.common.event;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class EventAspect {
	
	@Autowired
	private EventSupport eventSupport;
	
	@Around("@annotation(com.lvmama.lvf.common.event.EventPoint)")
	public Object eventTrigger(ProceedingJoinPoint pjp) throws Throwable {
		Object obj = pjp.proceed();
//		try{
		eventSupport.execute(pjp,obj);
//		}catch(Exception ex){
//			ex.printStackTrace();
//		}
		return obj;
	}
	
}
