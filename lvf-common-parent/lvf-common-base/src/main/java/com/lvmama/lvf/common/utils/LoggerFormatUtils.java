package com.lvmama.lvf.common.utils;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * 报文日志格式化,解析工具
 */
public class LoggerFormatUtils {

    private static final String LOG_SPLIT = "~~";
    private static final String LOG_SPLIT_COLON =":~~";
    private static final String[] keys=new String[]{"traceNo","gid","code","target","message"};
    
    
    /**
	 * LoggerFormatUtils.buildLogger参数规则 顺序： "traceNo","gid","code","target","message"。  
	 */
    public static String buildLogger(Object... strs) {
        StringBuilder logmsg = new StringBuilder(LOG_SPLIT_COLON);
        for (int j = 0; j < strs.length; j++) {
        	logmsg.append(keys[j]+LOG_SPLIT+strs[j]+LOG_SPLIT_COLON);
		}
        return StringUtils.substringBeforeLast(logmsg.toString(),LOG_SPLIT_COLON);
    }


    public static Map<String, String> extractMessage(String eventMsg) {
        Map<String, String> kvs = new HashMap<String, String>();
        String[] index = StringUtils.splitByWholeSeparator(eventMsg, LOG_SPLIT_COLON);
        for (String str : index) {
            String[] kv = StringUtils.splitByWholeSeparator(str, LOG_SPLIT);
            kvs.put(kv[0], kv[1]);
        }
        return kvs;
    }
}
