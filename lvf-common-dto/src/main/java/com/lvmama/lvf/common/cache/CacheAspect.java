package com.lvmama.lvf.common.cache;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.lvmama.lvf.common.trace.TraceContext;
import com.lvmama.lvf.common.utils.CustomizedPropertyPlaceholderConfigurer;
import com.lvmama.lvf.common.utils.JSONMapper;
import com.lvmama.lvf.common.utils.MD5Utils;
import com.lvmama.lvf.common.utils.MemcachedUtil;

@Aspect
@Component
public class CacheAspect {
	
	public static Logger logger = LoggerFactory.getLogger(CacheAspect.class);
	
	@Value("flight.cacheExpireTime")
	private String cacheExpireTime;
	
	private boolean vaildExpire(CacheBox cacheBox){
		if(null==cacheBox){
			return false;
		}
		return new Date().getTime()<cacheBox.getExpireTime();
	}
	
	private Method method(ProceedingJoinPoint pjp){
		Signature signature = pjp.getSignature();
		MethodSignature methodSignature = (MethodSignature) signature;
		Method method = methodSignature.getMethod();
		return method;
	}
	
//	public static void main(String[] args){
//		
//		for(Method method:SearchClient.class.getDeclaredMethods()){
//			if(null!=method.getAnnotation(CachePoint.class)){
//				System.out.println(method.getName());
//				Annotation[][] annoss = method.getParameterAnnotations();
//				for(int i=0;i<annoss.length;i++){
//					Annotation[] annos = annoss[i];
//					for(Annotation anno:annos){
//						if(anno instanceof CacheKey){
//							System.out.println("&&&");
//						}
//					}
//				}
//			}
//		}
//		
//	}
	
	private String getCacheKey(Method method,Object[] args) throws Exception{
		
		Annotation[][] annoss = method.getParameterAnnotations();
		StringBuilder json = new StringBuilder("");
		for(int i=0;i<annoss.length;i++){
			Annotation[] annos = annoss[i];
			for(Annotation anno:annos){
				if(anno instanceof CacheKey){
					logger.error(TraceContext.getTraceId()+" "+method.getName()+" base obj:"+args[i]);
					json.append(JSONMapper.getInstance().writeValueAsString(args[i]));
				}
			}
		}
		logger.error(TraceContext.getTraceId()+" "+method.getClass().getName()+"."+method.getName()+" base key:"+json);
		if(StringUtils.isBlank(json.toString())){
			return null;
		}
		String key = MD5Utils.generatePassword(method.getClass().getName()+"."+method.getName()+":"+json.toString());
		return "_LVMAMA_LVF_"+key;
	}
	
	@Around("@annotation(com.lvmama.lvf.common.cache.CachePoint)")
	public Object cache(ProceedingJoinPoint pjp) throws Throwable {
		
		Method method = method(pjp);
		String cacheKey = null;
		
		try{
			cacheKey = getCacheKey(method,pjp.getArgs());
			logger.error(TraceContext.getTraceId()+" "+method.getName()+" cache key:"+cacheKey);
		}catch(Exception ex){
			logger.error(TraceContext.getTraceId()+" "+method.getName()+" get cache key error!",ex);
		}
		
		if(null==cacheKey){
			Object obj = pjp.proceed();
			return obj;
		}
		
		CachePoint cachePoint = method.getAnnotation(CachePoint.class);
		try {
			CacheBox cacheBox = MemcachedUtil.getInstance().get(cacheKey);
			
			if(vaildExpire(cacheBox)){
				String json = cacheBox.getJson();
				logger.error(TraceContext.getTraceId()+" "+method.getName()+" user cache:json size"+json.length());
				return cachePoint.value().convertTo(json);
			};
		} catch (Exception e) {
			logger.error(TraceContext.getTraceId()+" "+method.getName()+" get cache error!",e);
		}
		
		Object obj = pjp.proceed();
		
		try {
			CacheBox cacheBox = new CacheBox();
			cacheBox.setExpireTime(new Date().getTime()+getCacheExpireTime(cachePoint)); //FIXME:暂时写死8分钟过期,1级缓存8分钟过期,2级缓存10分钟过期
			cacheBox.setKey(cacheKey);
			String json = cachePoint.value().convertFrom(obj);
			if(json.length()<cachePoint.cacheSizeLimit()){
				return obj;
			}
			cacheBox.setJson(json);
			MemcachedUtil.getInstance().set(cacheKey,cacheBox);
			logger.error(TraceContext.getTraceId()+" "+method.getName()+" user proceed:json size"+json.length());
		} catch (Exception e) {
			logger.error(TraceContext.getTraceId()+" "+method.getName()+" set cache error!",e);
		}
		
		return obj;
	}
	
	private Long getCacheExpireTime(CachePoint cachePoint){
		try{
			if(StringUtils.isNotBlank(cachePoint.cacheExpireTimeKey())){
				return Long.valueOf((String)CustomizedPropertyPlaceholderConfigurer.getContextProperty(cachePoint.cacheExpireTimeKey()));
			}
			return Long.valueOf((String)CustomizedPropertyPlaceholderConfigurer.getContextProperty(cacheExpireTime));
		}catch(Exception ex){
			logger.error(TraceContext.getTraceId()+" get cache expiretime error!",ex);
			return 30000L;
		}
	}
}
