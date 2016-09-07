package com.lvmama.lvfit.common.dto.trace;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lvmama.lvf.common.exception.ExceptionWrapper;
import com.lvmama.lvf.common.utils.JSONMapper;
import com.lvmama.lvfit.common.dto.FitOpLog;
import com.lvmama.lvfit.common.dto.enums.FitBusinessExceptionType;

public class FitOpLogTraceContext {
	
    private static final Logger logger = LoggerFactory.getLogger(FitOpLogTraceContext.class);

    private static ThreadLocal<List<FitOpLog>> threadLocal = new ThreadLocal<List<FitOpLog>>();
    private static ThreadLocal<List<ExceptionWrapper>> exThreadLocal = new ThreadLocal<List<ExceptionWrapper>>();
    /**
     * 设置订单操作日志
     * 
     * @param fitOpLog 订单操作日志信息
     */
    public static void setFitOpLog(Object obj,Exception e, String traceId, FitBusinessExceptionType type) {
        
        FitOpLog fitOpLog = new FitOpLog();
        try {
			fitOpLog.setRequestStr(JSONMapper.getInstance().writeValueAsString(obj));
		} catch (Exception ep) {
			logger.error(ep.getMessage());
		}
        fitOpLog.setTraceId(traceId);
        fitOpLog.setFitBusinessExceptionType(type);
        if(e!=null){
        	  if (e instanceof ExceptionWrapper) {
                  ExceptionWrapper ew = (ExceptionWrapper)e;
                  String errMsg = StringUtils.isNotBlank(ew.getOriginErrMsg()) ? ew.getOriginErrMsg() : ew.getErrMessage();
                  fitOpLog.setDetail(errMsg);
                  fitOpLog.setRemark(ExceptionUtils.getStackTrace(ew));
              } else {
                  fitOpLog.setDetail(e.getMessage());
                  fitOpLog.setRemark(ExceptionUtils.getStackTrace(e));
              }
        }
        List<FitOpLog> fitOpLogs = threadLocal.get();
        if (CollectionUtils.isEmpty(fitOpLogs)) {
            fitOpLogs = new ArrayList<FitOpLog>();
        }
        fitOpLogs.add(fitOpLog);
        threadLocal.set(fitOpLogs);
    }

    /**
     * 获取订单操作日志List
     * 
     * @return
     */
    public static List<FitOpLog> getFitOpLogs() {
        return threadLocal.get();
    }

    /**
     * 清除ThreadLocal存储的订单操作日志
     */
    public static void clear() {
        threadLocal.set(null);
        threadLocal.remove();
    }
    
    /**
     * 将业务异常保存到ThreadLocal中
     * @param ew
     */
    public static void setExThreadLocal(ExceptionWrapper ew) {
        List<ExceptionWrapper> exList = exThreadLocal.get();
        if (CollectionUtils.isEmpty(exList)) {
            exList = new ArrayList<ExceptionWrapper>();
        }
        exList.add(ew);
        exThreadLocal.set(exList);
    }
    
    public static List<ExceptionWrapper> getExThreadLocal() {
        return exThreadLocal.get();
    }
    
    public static void clearExThreadLocal() {
        exThreadLocal.set(null);
        exThreadLocal.remove();
    }
}

