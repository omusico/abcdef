package com.lvmama.lvf.cat.hessian;


import java.util.HashMap;
import java.util.Map;


public class CatHessianCache {

    private static Map<Thread,Map<String,String>> map = new HashMap<Thread,Map<String,String>>();

    public static Map<String,String> getCacheValue(Thread t){
        return map.get(t);
    }
    public static Map<String,String> putCacheValue(Thread t,Map<String,String> val){
        return map.put(t,val);
    }

    public static void cleanValue(Thread t){
        map.remove(t);
    }
}
