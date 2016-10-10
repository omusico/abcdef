package com.lvmama.lvf.cat.hessian;


import com.caucho.hessian.client.HessianConnection;
import com.caucho.hessian.client.HessianProxy;
import com.caucho.hessian.client.HessianProxyFactory;

import java.net.URL;
import java.util.Map;

public class CatHessianProxy extends HessianProxy {

    protected CatHessianProxy(URL url, HessianProxyFactory factory) {
        super(url, factory);
    }

    protected void addRequestHeaders(HessianConnection conn) {
        conn.addHeader("Content-Type", "x-application/hessian");
        conn.addHeader("Accept-Encoding", "deflate");

        String basicAuth = this._factory.getBasicAuth();
        if(basicAuth != null) {
            conn.addHeader("Authorization", basicAuth);
        }

        Map<String,String> map =  CatHessianCache.getCacheValue(Thread.currentThread());
        if(map != null&& !map.isEmpty()){
            for( String key: map.keySet()){
                conn.addHeader(key, map.get(key));
            }
            CatHessianCache.cleanValue(Thread.currentThread());
        }

    }
}
