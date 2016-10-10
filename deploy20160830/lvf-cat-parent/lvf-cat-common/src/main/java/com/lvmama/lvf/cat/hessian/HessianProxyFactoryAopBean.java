package com.lvmama.lvf.cat.hessian;


import com.caucho.hessian.client.HessianProxyFactory;
import com.dianping.cat.Cat;
import com.dianping.cat.message.Transaction;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.remoting.caucho.HessianClientInterceptor;
import org.springframework.util.Assert;

import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

public class HessianProxyFactoryAopBean  extends HessianClientInterceptor implements FactoryBean<Object> {

    private final static Log log = LogFactory.getLog(HessianProxyFactoryAopBean.class);
    private Object serviceProxy;
    Map<String, String> maps = new HashMap<String, String>();


    @Override
    public void afterPropertiesSet() {
        super.afterPropertiesSet();
        this.serviceProxy = new ProxyFactory(getServiceInterface(), this).getProxy(getBeanClassLoader());
    }

    @Override
    protected Object createHessianProxy(HessianProxyFactory proxyFactory) throws MalformedURLException {
        Assert.notNull(getServiceInterface(), "'serviceInterface' is required");
        CatHessianProxyFactory catProxyFactory = new CatHessianProxyFactory();
        catProxyFactory.setConnectionFactory(proxyFactory.getConnectionFactory());
        catProxyFactory.setConnectTimeout(proxyFactory.getConnectTimeout());
        catProxyFactory.setReadTimeout(proxyFactory.getReadTimeout());
        catProxyFactory.setSerializerFactory(proxyFactory.getSerializerFactory());
        catProxyFactory.setOverloadEnabled(true);
        return catProxyFactory.create(getServiceInterface(), getServiceUrl());
    }

    public Object invoke(MethodInvocation invocation) throws Throwable {

        Cat.Context context = new Cat.Context() {
            public void addProperty(String key, String value) {
                maps.put(key,value);
            }

            public String getProperty(String key) {
                return maps.get(key);
            }
        };
        Object obj = null;
        invocation.getMethod();
        String service = invocation.getMethod().getDeclaringClass().getSimpleName();
        String method = invocation.getMethod().getName();
        Transaction t = Cat.newTransaction("RemoteCall", service+"."+method);
        Cat.logRemoteCallClient(context);


        //封装CAT头协议
        Map<String, String> headerParamMap = new HashMap<String, String>();
        headerParamMap.put("X-CAT-TRACE-MODE","true");
        headerParamMap.put("X-CAT-ID",context.getProperty(context.CHILD));
        headerParamMap.put("X-CAT-PARENT-ID",context.getProperty(context.PARENT));
        headerParamMap.put("X-CAT-ROOT-ID", context.getProperty(context.ROOT));
        CatHessianCache.putCacheValue(Thread.currentThread(), headerParamMap);

        try {
            obj =  super.invoke(invocation);
            t.setStatus(t.SUCCESS);
        } catch (Throwable e) {
            t.setStatus(e);
            Cat.logError(e.getMessage(),e);
            throw e;
        }finally {
            t.complete();
        }

        return obj;
    }

    private String genChildId(Cat.Context context) {
        String childId = context.getProperty(context.CHILD);
        String rootId =  context.getProperty(context.ROOT);
        String parentId =  context.getProperty(context.PARENT);

        if(isNull(rootId) ||isNull(parentId)){
            return  childId + "-1";
        }
        if(parentId.equals(rootId)){
           return  parentId + "-1";
        }else{
            if(parentId.length() > rootId.length()){
                String str;
                    try {
                        str= parentId.substring(rootId.length()+1);
                    }catch (Exception e){
                        return  childId + "-1";
                    }

                    if(isNull(str)){
                        return  childId + "-1";
                    }else{
                        int i = Integer.parseInt(str);
                        i++;
                        return parentId +"-"+ i;
                    }
            }else{
                return  childId + "-1";
            }
        }
    }

    public static  boolean isNull(String str){
        if(str == null || str.equals("")){
            return true;
        }
        return false;
    }

    public Object getObject() {
        return this.serviceProxy;
    }

    public Class<?> getObjectType() {
        return getServiceInterface();
    }

    public boolean isSingleton() {
        return true;
    }

}
