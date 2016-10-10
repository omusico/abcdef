package com.lvmama.lvf.cat.utils;

import com.dianping.cat.Cat;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Tifancy
 * @version V1.0
 * @Title: ${file_name}
 * @Package: com.lvmama.cat.transaction
 * @Description: CAT消息上下文, 实现分布式消息树需要逐级传递
 * @date 2016/3/17  17:02
 */
public class CatContext implements Cat.Context {

    /**
     * 存储跟踪标识[current, parent, root]
     */
    public Map<String, String> maps = new ConcurrentHashMap<String, String>();

    public void addProperty(String key, String value) {
        maps.put(key, value);
    }

    public String getProperty(String key) {
        return maps.get(key);
    }

}
