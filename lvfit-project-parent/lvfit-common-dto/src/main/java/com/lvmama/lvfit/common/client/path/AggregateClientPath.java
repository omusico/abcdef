package com.lvmama.lvfit.common.client.path;

import com.lvmama.lvf.common.utils.CustomizedPropertyPlaceholderConfigurer;

public enum AggregateClientPath {

	HOTEL_SEARCH(Path.HOTEL_SEARCH,"搜索酒店信息"),
	FLIGHT_INFO_SEARCH(Path.FLIGHT_INFO_SEARCH,"搜索航班信息"),
	INSURANCE_SEARCH(Path.INSURANCE_SEARCH, "获取可用保险"),
	COMMENT_QUERY(Path.COMMENT_QUERY, "获取点评分页查询信息"),
	HOTEL_DETAIL(Path.HOTEL_DETAIL,"获得酒店信息详情"),
	SPOT_SEARCH(Path.SPOT_SEARCH,"搜索景点信息"),
	FLIGHT_INSURANCE_SEARCH(Path.FLIGHT_INSURANCE_SEARCH, "搜索机票保险信息"),
	PRODUCT_CALENDAR_SEARCH(Path.PRODUCT_CALENDAR_SEARCH,"获取被打包产品的价格日历信息"),
	PACKAGE_PRODUCT_BASIC_INFO_SEARCH(Path.PACKAGE_PRODUCT_BASIC_INFO_SEARCH, "获取打包产品基本信息"),
	PACKAGE_PRODUCT_INFO_ONLY_SEARCH(Path.PACKAGE_PRODUCT_INFO_ONLY_SEARCH, "仅仅获取打包产品信息不含附加城市信息等"),
    PACKAGE_GOODS_INFO_SEARCH(Path.PACKAGE_GOODS_INFO_SEARCH, "获取打包商品信息"),
    CONTRACTS(Path.CONTRACTS,"获取合同信息");
    
    public String path;

    public String cnName;

    private AggregateClientPath(String path, String cnName) {
        this.path = path;
        this.cnName = cnName;
    }

    public static class Path {
        public static final String basePath = "agg/";
        public static final String flightPath = "flight/";
        public static final String hotelPath = "hotel/";
        public static final String insurancelPath = "insurance/";
        public static final String commentPath = "comment/";
        public static final String spotPath = "spot/";
        public static final String productGroupPath = "productGroup/";
        
        /** 酒店查询 */
        public static final String HOTEL_SEARCH = basePath+hotelPath + "search";
        
        /** 航班搜索 */
        public static final String FLIGHT_INFO_SEARCH = basePath+flightPath+"search";
        
        /** 保险搜索 */
        public static final String INSURANCE_SEARCH = basePath+insurancelPath+"search";
        
        /** 点评查询 */
        public static final String COMMENT_QUERY = basePath+commentPath+"query";
        
        /** 酒店详情 */
        public static final String HOTEL_DETAIL = basePath+hotelPath + "detail";
        
        /** 景点查询 */
        public static final String SPOT_SEARCH = basePath+spotPath + "search";

        public static final String FLIGHT_INSURANCE_SEARCH = basePath + flightPath + insurancelPath + "all";
        
        public static final String PRODUCT_CALENDAR_SEARCH = basePath + productGroupPath +"search";
        
        public static final String PACKAGE_PRODUCT_BASIC_INFO_SEARCH = basePath + "productBaseInfoSearch/{productId}";
        
        public static final String PACKAGE_PRODUCT_INFO_ONLY_SEARCH = basePath + "productBaseInfoOnlySearch/{productId}";
        
        public static final String PACKAGE_GOODS_INFO_SEARCH = basePath + "productGoodsInfoSearch";
        /** 获取合同信息*/
        public static final String CONTRACTS = basePath + "getContracts";
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
