/**
 * Project Name:lvfit-common-dto
 * File Name:ReportClientPath.java
 * Package Name:com.lvmama.lvfit.common.client.path
 * Date:2016-1-5下午3:35:53
 * Copyright (c) 2016, www.lvmama.com All Rights Reserved.
 *
*/

package com.lvmama.lvfit.common.client.path;

import com.lvmama.lvf.common.utils.CustomizedPropertyPlaceholderConfigurer;

/**
 * ClassName:ReportClientPath <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Date:     2016-1-5 下午3:35:53 <br/>
 * @author   liuweiguo
 * @version  
 * @since    JDK 1.6
 * @see 	 
 */
public enum ReportClientPath {
    QUERY_REVENUE_REPORT(Path.QUERY_REVENUE_REPORT, "营收报表"),
    QUERY_REVENUE_REPORT_FOR_EXPORT(Path.QUERY_REVENUE_REPORT_FOR_EXPORT, "营收报表导出"),
    
    /**  订单查询相关报表 **/
    QUERY_ORDER_ALL_REPORT(Path.QUERY_ORDER_ALL_REPORT, "订单机酒报表导出"),
    QUERY_ORDER_FLIGHT_REPORT(Path.QUERY_ORDER_FLIGHT_REPORT, "订单机票报表导出"),
    QUERY_ORDER_HOTEL_REPORT(Path.QUERY_ORDER_HOTEL_REPORT, "订单酒店报表导出");
    
    
    public String path;

    public String cnName;

    private ReportClientPath(String path, String cnName) {
        this.path = path;
        this.cnName = cnName;
    }
    
    public static class Path {
        public final static String reportPath = "report/";
        /**
         * 营收报表服务path
         */
        public static final String QUERY_REVENUE_REPORT = reportPath + "queryRevenueReport";
        /**
         * 营收报表导出服务path
         */
        public static final String QUERY_REVENUE_REPORT_FOR_EXPORT = reportPath + "queryRevenueReportForExport";
        
        /**  订单相关  **/
        public static final String QUERY_ORDER_ALL_REPORT = reportPath + "queryOrderAll";
        public static final String QUERY_ORDER_FLIGHT_REPORT = reportPath + "queryOrderFlight";
        public static final String QUERY_ORDER_HOTEL_REPORT = reportPath + "queryOrderHotel";
        
    }

    public String getPath() {
        return path;
    }

    public String getCnName() {
        return cnName;
    }

    public String url(String baseUrl) {
        if (!baseUrl.contains("http")) {
            baseUrl = CustomizedPropertyPlaceholderConfigurer.getContextProperty(baseUrl);
        }

        if (baseUrl.endsWith("/")) {
            return baseUrl + this.path;
        }
        return baseUrl + "/" + this.path;
    }

    public String url(String baseUrl, Object... args) {
        String url = url(baseUrl);
        String pat = "\\{\\w*\\}";
        return String.format(url.replaceAll(pat, "%s"), args);
    }
}

