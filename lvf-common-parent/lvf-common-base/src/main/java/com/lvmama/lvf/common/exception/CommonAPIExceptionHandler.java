package com.lvmama.lvf.common.exception;

import javax.ws.rs.NotAcceptableException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Provider
public class CommonAPIExceptionHandler implements ExceptionMapper<Exception> {
	
    private static final Logger log = LoggerFactory.getLogger(CommonAPIExceptionHandler.class);

    public Response toResponse(Exception exception){
    	
    	log.error(ExceptionUtils.getFullStackTrace(exception));
    	
        if (exception instanceof NotAcceptableException){
			return Response.status(Response.Status.NOT_ACCEPTABLE).entity(ExceptionUtils.getFullStackTrace(exception)).build();
        }
		return Response.serverError().entity(ExceptionUtils.getFullStackTrace(exception)).build();
    }
}
