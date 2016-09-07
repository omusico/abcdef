package com.lvmama.lvf.common.adapter;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import com.lvmama.lvf.common.adapter.ws.ServiceHandler;

public class AdapterProxyHandler implements InvocationHandler{
	
	private ServiceHandler handler;
	
	public void setHandler(ServiceHandler handler) {
		this.handler = handler;
	}

	public Object invoke(Object proxy,Method method,Object[] args)
			throws Throwable {
		return handler.execute(method,args);
	}
	
}
