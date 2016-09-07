package com.lvmama.lvf.common.client.path;

import com.lvmama.lvf.common.utils.CustomizedPropertyPlaceholderConfigurer;

public enum AggregateClientPath {

    VERIFY_SEAT_AND_PRICE(Path.VERIFY_SEAT_AND_PRICE, "验舱验价"),
    SEARCH_RECORD_FROM_SOLR(Path.SEARCH_RECORD_FROM_SOLR,"从Solr获取机票查询记录"),
    EXPORT_RECORD_FROM_SOLR(Path.EXPORT_RECORD_FROM_SOLR,"从Solr导出机票查询记录"),
    AGG_AVETIME(Path.AGG_AVETIME,"聚合avetime查询航班可销售信息");
    

    public String path;

    public String cnName;

    private AggregateClientPath(String path, String cnName) {
        this.path = path;
        this.cnName = cnName;
    }

    public static class Path {

        public static final String aggregatePath = "aggregate/";
        public static final String flightPath = "flight/";

        /** 验舱验价 */
        public static final String VERIFY_SEAT_AND_PRICE = aggregatePath + flightPath + "verifySeatAndPrice";
        		
		/** 从Solr获取机票查询记录 */
        public static final String SEARCH_RECORD_FROM_SOLR = aggregatePath+flightPath +"searchRecordFromSolr";
        
        /** 从Solr获取机票查询记录 */
        public static final String EXPORT_RECORD_FROM_SOLR = aggregatePath+flightPath +"exportRecordFromSolr";
        
        public final static String seatPath="seat/";
		public final static String AGG_AVETIME = aggregatePath + seatPath+ "avetime";

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
