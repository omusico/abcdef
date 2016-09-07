package com.lvmama.lvf.common.trace;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.lvmama.lvf.common.exception.CommonExceptionHandler;

@Provider
public class TraceContextInterceptor4Resteasy implements ContainerRequestFilter,ContainerResponseFilter{
	
	private static Logger logger = LoggerFactory.getLogger(TraceContextInterceptor4Resteasy.class); 
	
	@Autowired(required=false)
	private TraceExtendHandler executeHandler;
	
	@Override
	public void filter(ContainerRequestContext arg0) throws IOException {
//		logger.warn("startTrace"+arg0.getUriInfo().getPath()+":"+arg0.getRequest().getMethod());
		TraceContext.startTrace(arg0.getHeaders());
		CommonExceptionHandler.clearExceptionWrapper();
		
	}

	@Override
	public void filter(ContainerRequestContext arg0,
			ContainerResponseContext arg1) throws IOException {
		
		if(null!=executeHandler){
			executeHandler.execute(null,null);
		}
		
		TraceContext.clear();
		CommonExceptionHandler.clearExceptionWrapper();
	}

}
