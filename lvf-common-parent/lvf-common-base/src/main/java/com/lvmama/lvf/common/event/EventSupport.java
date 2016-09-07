package com.lvmama.lvf.common.event;

import java.lang.reflect.Method;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Component
public class EventSupport {
	
	public void execute(ProceedingJoinPoint pjp,Object obj){
		Event event = getEvent(pjp);
		for(EventListener listener:event.getListeners()){
//			try{
			listener.handler(event,obj);
//			}catch(Exception ex){
//				ex.printStackTrace();
//			}
		}
	}
	
	private Event getEvent(ProceedingJoinPoint pjp){
		Signature signature = pjp.getSignature();
		MethodSignature methodSignature = (MethodSignature) signature;
		Method method = methodSignature.getMethod();
		EventPoint point = method.getAnnotation(EventPoint.class);
		Event event = point.value();
		return event;
	}
	


}
