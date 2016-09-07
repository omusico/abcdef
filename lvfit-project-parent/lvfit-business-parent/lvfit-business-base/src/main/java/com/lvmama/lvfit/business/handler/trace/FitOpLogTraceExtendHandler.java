package com.lvmama.lvfit.business.handler.trace;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lvmama.lvf.common.trace.TraceExtendHandler;
import com.lvmama.lvfit.common.dto.FitOpLog;
import com.lvmama.lvfit.common.dto.trace.FitOpLogTraceContext;
import com.lvmama.lvfit.common.oplog.FitOpLogUtils;

/**
 * 机+酒操作日志监控Trace Handler
 * @author lizongze
 *
 */

@Component
public class FitOpLogTraceExtendHandler implements TraceExtendHandler {

    private static Logger logger = LoggerFactory.getLogger(FitOpLogTraceExtendHandler.class);
    
    @Autowired
    private FitOpLogUtils fitOpLogUtils;
    
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        //将ThreadLocal中保存的错误日志信息保存到数据库中
        try {
            List<FitOpLog> fitOpLogs = FitOpLogTraceContext.getFitOpLogs();
            if (!CollectionUtils.isEmpty(fitOpLogs)) {
                for (FitOpLog fitOpLog : fitOpLogs) {
                    fitOpLogUtils.save(fitOpLog);
                }
            }
        } catch (Exception e) {
            logger.error("~~机酒操作日志保存失败~~，错误信息: " + e.getMessage());
        } finally {
            FitOpLogTraceContext.clear();
        }
    }
}
