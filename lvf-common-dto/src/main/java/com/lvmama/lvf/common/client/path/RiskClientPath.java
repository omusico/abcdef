package com.lvmama.lvf.common.client.path;

import com.lvmama.lvf.common.utils.CustomizedPropertyPlaceholderConfigurer;

public enum RiskClientPath {

    QUERY_BLACK_IDS(Path.QUERY_BLACK_IDS, "查询风控黑名单信息列表"),
    SAVE_BLACK_ID(Path.SAVE_BLACK_ID, "保存风控黑名单信息"),
    QUERY_BLACK_IDS_BY_CUSTOMER_ID(Path.QUERY_BLACK_IDS_BY_CUSTOMER_ID, "根据客户Id查询风控黑名单"),
    QUERY_FORBIDDEN_WORD(Path.QUERY_FORBIDDEN_WORD, "查询禁用词信息"),
    SAVE_OR_UPD_FORBIDDEN_WORD(Path.SAVE_OR_UPD_FORBIDDEN_WORD, "保存或更新禁用词信息"),
    DELETE_FORBIDDEN_WORD(Path.DELETE_FORBIDDEN_WORD, "删除禁用词信息"), 
    SAVE_RISK_LIMIT_BLACK(Path.SAVE_RISK_LIMIT_BLACK,"保存针对南航新规的风控规则优化实体"),
    QUERY_RISK_LIMIT_BLACK(Path.QUERY_RISK_LIMIT_BLACK,"查询针对南航新规的风控规则优化实体");
    
    public String path;
    public String cnName;

    public static class Path {

        public final static String basePath = "risk/";
        public final static String QUERY_BLACK_IDS = basePath + "management/queryBlackIds";
        public final static String SAVE_BLACK_ID = basePath + "management/saveBlackId";
        public final static String QUERY_BLACK_IDS_BY_CUSTOMER_ID = basePath + "management/queryBlackIdsByCustomerId/{customerId}";
        public final static String QUERY_FORBIDDEN_WORD = basePath + "management/queryFbdWord";
        public final static String SAVE_OR_UPD_FORBIDDEN_WORD = basePath + "management/saveOrUpdFbdWord";
        public final static String DELETE_FORBIDDEN_WORD = basePath + "management/delFbdWord";
        public static final String SAVE_RISK_LIMIT_BLACK = basePath + "management/saveRiskLimitBlack";
        public static final String QUERY_RISK_LIMIT_BLACK = basePath + "management/queryRiskLimitBlack";
    }

    private RiskClientPath(String path, String cnName) {
        this.path = path;
        this.cnName = cnName;
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
