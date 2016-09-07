package com.lvmama.lvfit.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.lvmama.lvf.common.adapter.LoggerHandler;
import com.lvmama.lvf.common.trace.TraceContext;
import com.lvmama.lvf.common.utils.JSONMapper;
import com.lvmama.lvf.common.utils.LoggerFormatUtils;

@Component
public class FitLoggerHandler  implements LoggerHandler {

	  private static final Logger logger = LoggerFactory.getLogger(FitLoggerHandler.class);

	    public void addFitLog(String target, String code, Object message,String errorMessage, String gid){
	   		try {
	            String json = JSONMapper.getInstance().writeValueAsString(message);
	            log(target, code, json, errorMessage,null, gid);
	   		} catch (Exception e) {
	            logger.error("addFitLog" + target + code + "error!", e);
	   		}
	   	}

	    @Override
	    public void log(String target, String code, String message, String errorMessage, Boolean result, String gid) {
	        try {
	            if (logger.isInfoEnabled()) {
	                logger.info(LoggerFormatUtils.buildLogger(TraceContext.getTraceId(),gid,code,target,message));
	            }

	        } catch (Exception ex) {
	            logger.warn(ex.getMessage(), ex);
	        }
	    }
	
}
