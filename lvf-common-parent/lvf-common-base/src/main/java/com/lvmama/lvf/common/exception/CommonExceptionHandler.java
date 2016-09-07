package com.lvmama.lvf.common.exception;

import javax.ws.rs.NotAcceptableException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Provider
public class CommonExceptionHandler implements ExceptionMapper<Exception> {

	private static final Logger log = LoggerFactory.getLogger(CommonExceptionHandler.class);

	private static ThreadLocal<ExceptionWrapper> threadLocal = new ThreadLocal<ExceptionWrapper>();

	public Response toResponse(Exception exception)
	{
		try 
		{
			if(log.isWarnEnabled())
			{
				log.error(ExceptionUtils.getFullStackTrace(exception));
			}
			
			if (exception instanceof ExceptionWrapper || threadLocal.get() != null) 
			{
				ExceptionWrapper exceptionWrapper = null;
				if(threadLocal.get() != null)
				{
					exceptionWrapper = threadLocal.get();
				}
				else
				{
					exceptionWrapper = (ExceptionWrapper) exception;
				}
				if(log.isWarnEnabled())
				{
					log.error(exceptionWrapper.getErrMessage());
				}
				return Response.serverError().entity(exceptionWrapper).build();
			}

			if (exception instanceof NotAcceptableException) 
			{
				return Response.status(Response.Status.NOT_ACCEPTABLE)
					.entity(new ExceptionWrapper(ExceptionUtils.getFullStackTrace(exception))).build();
			}
			
			ExceptionWrapper exw = new ExceptionWrapper(ExceptionCode.UNDEF_ERROR);
			exw.setFullStackTrace(ExceptionUtils.getFullStackTrace(exception));
			return Response.serverError().entity(exw).build();
		} 
		finally
		{
			clearExceptionWrapper();
		}
	}

	public static void setExceptionWrapper(ExceptionWrapper exceptionWrapper) 
	{
		threadLocal.set(exceptionWrapper);	
	}
	
	public static ExceptionWrapper getExceptionWrapper() 
	{
		return threadLocal.get();	
	}

	
	public static void clearExceptionWrapper()
	{
		threadLocal.set(null);
		threadLocal.remove();
	}
}
