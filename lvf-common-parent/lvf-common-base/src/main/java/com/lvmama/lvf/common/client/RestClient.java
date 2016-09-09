package com.lvmama.lvf.common.client;

import java.util.Map;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.PoolingClientConnectionManager;
import org.apache.http.params.CoreConnectionPNames;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import org.jboss.resteasy.client.jaxrs.engines.ApacheHttpClient4Engine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.lvmama.lvf.common.exception.ExceptionCode;
import com.lvmama.lvf.common.exception.ExceptionWrapper;
import com.lvmama.lvf.common.trace.TraceContext;
import com.lvmama.lvf.common.utils.JSONMapper;

@Component
public class RestClient {

    private ResteasyClient client;

    private static Logger logger = LoggerFactory.getLogger(RestClient.class);

    private RestClient() {

        PoolingClientConnectionManager cm = new PoolingClientConnectionManager();
        cm.setDefaultMaxPerRoute(100);
        cm.setMaxTotal(300);
        HttpClient httpClient = new DefaultHttpClient(cm);
        httpClient.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT,1000 * 120);
        httpClient.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT,1000 * 120);

        ApacheHttpClient4Engine engine = new ApacheHttpClient4Engine(httpClient);
        client = new ResteasyClientBuilder().httpEngine(engine).build();
    }

    private ResteasyClient getClient(){
        return client;
    }

    //get,适配/user/{id}这类uri
    public <T> T get(String url, Class<T> responseType, Map<String, Object> urlVariables) {
    	
    	Response response = null;
    	try{
            ResteasyWebTarget target = getClient().target(url);
            response = target.resolveTemplates(urlVariables).request().headers(TraceContext.getContext2MultivaluedMap()).get();

            if(Status.OK.getStatusCode()==response.getStatus()){
                T entity = response.readEntity(responseType);
                return entity;
            }
            return checkExceptionWrapper(url,response);
    	}finally{
        	try{
	            if(null!=response){
	            	response.close();
	            }
        	}catch(Exception e){
        		logger.error("response close has error!",e);
        	}
    	}
    	
    }

    private <T> T checkExceptionWrapper(String url,Response response)  throws ExceptionWrapper {
        String str = response.readEntity(String.class);

        if(Status.NOT_FOUND.getStatusCode()==response.getStatus()){
        	logger.error(Status.NOT_FOUND.getStatusCode()+",找不到对应的地址："+url);
            throw new ExceptionWrapper(ExceptionCode.UNDEF_REMOTE_INVOKE,url,Status.NOT_FOUND.getStatusCode());
        }

        ExceptionWrapper wrapper = null;
        try {
            wrapper = JSONMapper.getInstance().readValue(str,ExceptionWrapper.class);
        } catch (Exception ex) {
            logger.error("解析rest返回结果出错！url:"+url+" 返回的字符串："+str);
            throw new ExceptionWrapper(ExceptionCode.UNDEF_REMOTE_INVOKE,url,str);
        }
        throw wrapper;

    }

    //支持rest方法调用或者无参方法
    public <T> T get(String url, Class<T> responseType) {
    	
    	Response response = null;
    	try{
	        ResteasyWebTarget target = getClient().target(url);
	        response = target.request().headers(TraceContext.getContext2MultivaluedMap()).get();
	
	        if(Status.OK.getStatusCode()==response.getStatus()){
	            T entity = response.readEntity(responseType);
	            return entity;
	        }
	        return  checkExceptionWrapper(url,response);
    	}finally{
    		try{
	            if(null!=response){
	            	response.close();
	            }
        	}catch(Exception e){
        		logger.error("response close has error!",e);
        	}
    	}
    }

    public static String toJsonStr(Object obj) {
		try {
			return JSONMapper.getInstance().writeValueAsString(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
    //post
    public <T> T post(String url, Class<T> responseType, Object formVariables) {
    	Response response = null;
    	try{
    		System.out.println(url+"---"+toJsonStr(formVariables));
	        ResteasyWebTarget target = getClient().target(url);
	        response = target.request().headers(TraceContext.getContext2MultivaluedMap()).post(Entity.entity(formVariables,MediaType.APPLICATION_JSON));
	        if(Status.OK.getStatusCode()==response.getStatus()){
	            T entity = response.readEntity(responseType);
	            return entity;
	        }
	        return  checkExceptionWrapper(url,response);
	    }finally{
	    	try{
	            if(null!=response){
	            	response.close();
	            }
        	}catch(Exception e){
        		logger.error("response close has error!",e);
        	}
		}
    }


    // form post
      public <T> T post(String url, Class<T> responseType, Object formVariables,String formContentType) {
	    	Response response = null;
	      	try{
	    	  ResteasyWebTarget target = getClient().target(url);
	          response = target.request().headers(TraceContext.getContext2MultivaluedMap()).post(Entity.entity(formVariables,formContentType));
	
	          if(Status.OK.getStatusCode()==response.getStatus()){
	              T entity = response.readEntity(responseType);
	              return entity;
	          }
	          return  checkExceptionWrapper(url,response);
	      	}finally{
	      		try{
		            if(null!=response){
		            	response.close();
		            }
	        	}catch(Exception e){
	        		logger.error("response close has error!",e);
	        	}
			}
      }
      
    //post
    public <T> T post(String url, Class<T> responseType) {
    	
    	Response response = null;
    	try{
	    	ResteasyWebTarget target = getClient().target(url);
	        response = target.request().headers(TraceContext.getContext2MultivaluedMap()).post(Entity.entity("",MediaType.APPLICATION_JSON));
	
	        if(Status.OK.getStatusCode()==response.getStatus()){
	            T entity = response.readEntity(responseType);
	            return entity;
	        }
	        return  checkExceptionWrapper(url,response);
    	}finally{
    		try{
	            if(null!=response){
	            	response.close();
	            }
        	}catch(Exception e){
        		logger.error("response close has error!",e);
        	}
		}
        
    }
    
}
