package com.lvmama.lvf.common.utils;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.Provider;

import org.codehaus.jackson.jaxrs.JacksonJsonProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Provider
@Consumes({MediaType.APPLICATION_JSON, "text/json"})
@Produces({MediaType.APPLICATION_JSON, "text/json"})
public class NotNullProvider extends JacksonJsonProvider{
	 
	private static Logger logger = LoggerFactory.getLogger(NotNullProvider.class);
	
	static {
		logger.error("load NotNullProvider!");
	}
	 
	 public NotNullProvider() {
	        setMapper(JSONMapper.getInstance());
	 }
}
