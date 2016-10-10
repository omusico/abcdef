package com.lvmama.lvf.cat.hessian;


import com.caucho.hessian.client.HessianProxyFactory;
import com.caucho.hessian.io.HessianRemoteObject;

import java.lang.reflect.Proxy;
import java.net.MalformedURLException;
import java.net.URL;
public class CatHessianProxyFactory extends HessianProxyFactory {

    public Object create(Class api, String urlName)
            throws MalformedURLException
    {
        return create(api, urlName, Thread.currentThread().getContextClassLoader());
    }

    public Object create(Class api, String urlName, ClassLoader loader)
            throws MalformedURLException
    {
        URL url = new URL(urlName);
        CatHessianProxy handler = new CatHessianProxy(url,this);

        return Proxy.newProxyInstance(api.getClassLoader(),
                new Class[]{api, HessianRemoteObject.class}, handler);
    }
}
