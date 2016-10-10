package com.lvmama.lvf.cat.utils;

import com.lvmama.lvf.cat.constants.CatComConstants;
import com.lvmama.lvf.common.utils.CustomizedPropertyPlaceholderConfigurer;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.container.ContainerRequestContext;
import java.net.URI;
import java.util.Date;
import java.util.List;

/**
 * Created by leizhengwei
 * 2016/9/23
 * 16:29
 */
public class LoggerNameUtil {

    public static String getLoggerName(ClientRequestContext requestContext){
        URI uri = requestContext.getUri();
        String method = requestContext.getMethod();
        String resourcePath = uri.getPath();
        String loggerName = "["+method+"]"+"["+resourcePath+"]";
        String visitIp = NetUtils.getLocalHost();
        loggerName = traceLoggerName(loggerName,visitIp);
        return loggerName;
    }

    public static String getLoggerName(ContainerRequestContext arg0){
        String method = arg0.getMethod();
        List<Object> matchedResources = arg0.getUriInfo().getMatchedResources();
        String resourceName = "";
        if(CollectionUtils.isNotEmpty(matchedResources)){
            resourceName = matchedResources.get(0).getClass().getName();
        }
        String loggerName = "["+method+"]"+"["+resourceName+"]";
        String visitIp = NetUtils.getLocalHost();
        loggerName = traceLoggerName(loggerName,visitIp);
        return loggerName;
    }

    public static String getLoggerName(HttpServletRequest request){
        String requestURI = request.getRequestURI();
        String visitIp = IpUtils.getIpAddr(request);
        String loggerName = "["+requestURI+"]";
        loggerName = traceLoggerName(loggerName,visitIp);
        return loggerName;
    }




    private static String traceLoggerName(String loggerName,String visitIp) {
        CustomizedPropertyPlaceholderConfigurer configurer = SpringContextUtil.getBean(CustomizedPropertyPlaceholderConfigurer.class);
        String traceIpStr = configurer.getContextProperty(CatComConstants.CAT_TRACE_IP);
        if(StringUtils.isNotBlank(traceIpStr)&&traceIpStr.contains(visitIp)){
            loggerName = loggerName+"["+visitIp+"]"+"["+ DateFormatUtils.format(new Date(),DateFormatUtils.ISO_DATETIME_FORMAT.getPattern())+"]";
        }
        return loggerName;
    }

}
