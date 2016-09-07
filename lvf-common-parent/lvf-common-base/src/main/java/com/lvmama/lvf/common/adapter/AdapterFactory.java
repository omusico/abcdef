package com.lvmama.lvf.common.adapter;

import java.lang.reflect.Proxy;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.util.Assert;

public class AdapterFactory<T> implements FactoryBean<T> {
	
	private Class<T> adapterInterface;
	
	private AdapterProxyHandler handler;
	
	public void setHandler(AdapterProxyHandler handler) {
		this.handler = handler;
	}

	public Class<T> getAdapterInterface() {
		return adapterInterface;
	}

	public void setAdapterInterface(Class<T> adapterInterface) {
		this.adapterInterface = adapterInterface;
	}

	public void afterPropertiesSet() throws Exception {
        Assert.notNull(this.adapterInterface, "Property 'adapterInterface' is required");
    }

	public T getObject() throws Exception{
	    ClassLoader classLoader = adapterInterface.getClassLoader();
	    Class<?>[] interfaces = new Class[]{adapterInterface};
	    return (T) Proxy.newProxyInstance(classLoader,interfaces,handler);
	}

	public Class<?> getObjectType() {
		return this.adapterInterface;
	}

	public boolean isSingleton() {
		return true;
	}

}
