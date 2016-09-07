package com.lvmama.lvf.common.adapter.ws;

import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import com.lvmama.lvf.common.convert.exception.ResourceNotExistException;

public abstract class AbstractServiceHandlerFactory implements ServiceHandler {
	
	private ConcurrentMap<String,ServiceHandler>
		handlers= new ConcurrentHashMap<String,ServiceHandler>();
	
	public static String getHandlerKey(Method method){
		return method.getDeclaringClass().getName()+"."+method.toString();
	}
	
	public void putHandler(String key,ServiceHandler handler){
		handlers.put(key,handler);
	}
	
	public ServiceHandler getHandler(Method method) throws Exception{
		String key = getHandlerKey(method);
		ServiceHandler handler = handlers.get(key);
		if(null==handler){
			synchronized (this) {
				if(null==handler){
					registerService(method);
				}
			}
			handler = handlers.get(key);		
		}
		if(null==handler){
			throw new ResourceNotExistException("Need register "+key+" Handler!");
		}
		return handler;
	}
	
	private ServiceHandler handlerValidator;

	public Object execute(Method method, Object[] args) throws Exception {
		if(null!=handlerValidator){
			handlerValidator.execute(method,args);
		}
		return trueExecute(method, args);
	}

	public Object trueExecute(Method method, Object[] args) throws Exception {
		return getHandler(method).execute(method,args);
	}	

	public void setHandlerValidator(ServiceHandler handlerValidator) {
		this.handlerValidator = handlerValidator;
	}

	public abstract void registerService(Method method) throws Exception;
	
}
