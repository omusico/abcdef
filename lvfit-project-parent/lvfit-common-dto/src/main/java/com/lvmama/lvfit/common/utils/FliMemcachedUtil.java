package com.lvmama.lvfit.common.utils;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.danga.MemCached.MemCachedClient;
import com.danga.MemCached.SockIOPool;
import com.lvmama.lvf.common.utils.CustomizedPropertyPlaceholderConfigurer;

public class FliMemcachedUtil {
	
	private static Object LOCK = new Object();
	private final static  Log log = LogFactory.getLog(FliMemcachedUtil.class);
	private MemCachedClient memCachedClient;
	public final static int ONE_HOUR=3600;
	public final static int TWO_HOUR=7200;
	public final static String memcacheMapKey="MEMACACHE_MAP_KEY";
	
	private static FliMemcachedUtil instance;
	
	private String getProperty(String key){
		return CustomizedPropertyPlaceholderConfigurer.getContextProperty(key);
	}
	
	private void init() {
		try {
			
			//数据缓存服务器，“,”表示配置多个memcached服务
			String[] servers = getProperty("fli.cache.server").replaceAll(" ", "").split(",");
			SockIOPool pool = SockIOPool.getInstance("fliDataServer");
			pool.setServers(servers);
			pool.setFailover(true);
			pool.setInitConn(10);
			pool.setMinConn(5);
			pool.setMaxConn(50);
			pool.setMaintSleep(30);
			pool.setNagle(false);
			pool.setSocketTO(30000);
			pool.setBufferSize(1024*1024*10);
			pool.setAliveCheck(true);
			pool.initialize(); /* 建立MemcachedClient实例 */
			memCachedClient = new MemCachedClient("fliDataServer");
		}catch (Exception ex) {
			log.error(ex.getMessage(),ex);
		}
	}
	
	
	private FliMemcachedUtil(){
		init();
	}
	
	private boolean isCacheEnabled() {
		boolean useCache = false;
		try {
			useCache = Boolean.valueOf(getProperty("fli.cache.enable"));
		} catch (Exception e) {
			useCache = false;
			log.error("Please enable memcached");
		}
		return useCache;
	}
	
	/**
	 * 改用嵌套类静态实始化
	 * @return
	 */
	public static FliMemcachedUtil getInstance() {
		if(instance == null){
			synchronized(LOCK) {
				if (instance==null) {
					instance=new FliMemcachedUtil();
				}
			}
		}
		return instance;
	}

	private MemCachedClient getMemCachedClient() {
			return memCachedClient;
	}
	
	/**
	 * 替换
	 * @param key
	 * @param seconds 过期秒数
	 * @param obj
	 * @return
	 */
	public boolean replace(String key, int seconds, Object obj) {
		if(StringUtils.isEmpty(key)){
			return false;
		}
		if(obj==null){
			return true;
		}
		try{
			if (isCacheEnabled()) {
				Date  expDate = getDateAfter(seconds);
				boolean result = getMemCachedClient().replace(key, obj, expDate);
				if(log.isDebugEnabled()) {
					log.debug("SET A OBJECT: KEY:" + key + ", OBJ:" + obj + ", exp:" + expDate  + ", result:" + result);
				}
				return result;
			}
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			log.error(e, e);
		}
		return false;
	}

	/**
	 * 放
	 * @param key
	 * @param seconds 过期秒数
	 * @param obj
	 * @return
	 */
	public boolean set(String key, int seconds, Object obj) {
		return set(key, getDateAfter(seconds), obj);
	}
	

	
	/**
	 * 将KEY保存到memcache中
	 * 
	 * @param key
	 * @param exp
	 * @param obj
	 * @return
	 */
	public boolean set(String key,Date exp,Object obj){
		if(StringUtils.isEmpty(key)){
			return false;
		}
		if(obj==null){
			return true;
		}
		try{
			if (isCacheEnabled()) {
				boolean result = getMemCachedClient().set(key, obj, exp);
				if(log.isDebugEnabled()) {
					log.debug("SET A OBJECT: KEY:" + key + ", OBJ:" + obj + ", exp:" + exp + ", result:" + result);
				}
				return result;
			}
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			log.error(e, e);
		}
		return false;
	}
	
	
	
	/**
	 * 把相应的Key值和描述存到此方法中；
	 * 
	 * @param key
	 * @param discript
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public boolean putKeyDisMap(String key,String discript) {
		Map<String,String> memMap ;
		Object obj = memCachedClient.get(memcacheMapKey);
		if(obj == null) {
			memMap = new HashMap<String, String>();
		} else {
			memMap = (HashMap<String, String>) obj;
		}
		memMap.put(key, discript);
		memCachedClient.set(memcacheMapKey,memMap,getDateAfter(60*60*48));
		
		return true;
	}
	
	/**
	 * 放
	 * @param key
	 * @param obj
	 * @return
	 */
	public boolean set(String key, Object obj) {
		return set(key,ONE_HOUR,obj);
	}
	
	/**
	 * 取
	 * @param key
	 * @return
	 */
	public <T> T  get(String key) {
		try{
			if (isCacheEnabled()) {
				T obj = (T) getMemCachedClient().get(key);
				if(log.isDebugEnabled()) {
					log.debug("GET A OBJECT: KEY:" + key + " OBJ:" + obj) ;
				}
				return obj;
			}
		}catch(Exception e) {
			e.printStackTrace();
			log.error(e, e);
		}
		return null;
	}
	
	
	/**
	 * 取
	 * @param key
	 * @return
	 */
	public boolean remove(String key) {
		if(StringUtils.isEmpty(key)){
			return false;
		}
		try{
			if (isCacheEnabled()) {
				if(log.isDebugEnabled()) {
					log.debug("delete memcached key: " + key);
				}
				return getMemCachedClient().delete(key);
			}
		}catch(Exception e) {
			e.printStackTrace();
			log.error(e, e);
		}
		return true;
	}
	
    /**
     * 获得当前开始活参数秒的时间日期
    * @Title: getDateAfter
    * @Description:
    * @param
    * @return Date    返回类型
    * @throws
     */
    public static Date getDateAfter(int second) {
        Calendar cal = Calendar.getInstance();
 		cal.add(Calendar.SECOND, second);
 		return cal.getTime();
 	}
	
}
