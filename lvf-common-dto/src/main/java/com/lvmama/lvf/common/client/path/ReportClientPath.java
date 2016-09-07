package com.lvmama.lvf.common.client.path;

import com.lvmama.lvf.common.utils.CustomizedPropertyPlaceholderConfigurer;

public enum ReportClientPath {

    QUERY_TICKET_REMIND_REPORT(Path.QUERY_TICKET_REMIND_REPORT, "未出票提醒查询"),
    QUERY_REVENUE_REPORT(Path.QUERY_REVENUE_REPORT, "营收报表"),
    QUERY_REVENUE_REPORT_LIST_OF_EXPORT(Path.QUERY_REVENUE_REPORT_LIST_OF_EXPORT, "营收报表导出"),
    QUERY_SUPPPAYMENT_REPORT(Path.QUERY_SUPPPAYMENT_REPORT,"对账单报表查询"),
    SUPPAYMENT_BATCH_SAVE(Path.SUPPAYMENT_BATCH_SAVE,"对账单数据Excel导入"),
    QUERY_FINANCIAL_REPORT(Path.QUERY_FINANCIAL_REPORT, "财务对账查询报表"),
    QUERY_FINANCIAL_REPORT_LIST_OF_EXPORT(Path.QUERY_FINANCIAL_REPORT_LIST_OF_EXPORT, "财务对账报表导出");

    public String path;

    public String cnName;

    private ReportClientPath(String path, String cnName) {
        this.path = path;
        this.cnName = cnName;
    }
    
    public static class Path {
        public final static String reportPath = "report/";

        public static final String QUERY_REVENUE_REPORT = reportPath + "queryRevenueReportList";
        public static final String QUERY_TICKET_REMIND_REPORT = reportPath + "queryTicketRemindReport";
        
        public static final String QUERY_REVENUE_REPORT_LIST_OF_EXPORT = reportPath + "queryRevenueReportListofExport";
        public static final String QUERY_SUPPPAYMENT_REPORT = reportPath + "querySuppPaymentList";
        public static final String SUPPAYMENT_BATCH_SAVE = reportPath + "batchSaveSupPayment";
        public static final String QUERY_FINANCIAL_REPORT = reportPath + "queryFinancialReportList";
        public static final String QUERY_FINANCIAL_REPORT_LIST_OF_EXPORT = reportPath + "queryFinancialReportListofExport";
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
