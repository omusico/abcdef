package com.lvmama.lvfit.common.client.path;

import com.lvmama.lvf.common.utils.CustomizedPropertyPlaceholderConfigurer;



public enum FlightClientPath {

	FLIGHT_INFO_SEARCH(Path.FLIGHT_INFO_SEARCH,"搜索航班信息"),
	
	FLIGHT_LIST_SEARCH(Path.FLIGHT_LIST_SEARCH,"搜索航班列表"),
	
	QUERY_INSURANCE(Path.QUERY_INSURANCE, "获取可用保险"),
	
	AMOUNT_CALCULATE(Path.AMOUNT_CALCULATE,"订单相关金额计算"),
	
	GET_DAILY_MIN_PRICE(Path.GET_DAILY_MIN_PRICE," 获得航班每日最低价"),
	
	QUERY_AIRLINES_BY_CITY(Path.QUERY_AIRLINES_BY_CITY,"根据城市查询航线信息"),
	
	BOOKING_REBUILD_NEW(Path.BOOKING_REBUILD_NEW,"机票下单");
	
	public String path;
	
	public String cnName;

	private FlightClientPath(String path, String cnName) {
		this.path = path;
		this.cnName = cnName;
	}


	public static class Path{
		
		public final static String flightPath = "flight/";
	    
	    /**保险*/
        public final static String insurancePath = "insurance/";
        
        /**机票单品Business*/
        public final static String businessBasePath = "bussiness/";
        
        /**机票主主数据Path */
    	public final static String maindataPath = "maindata/";
        
		/** 航班搜索 */
        public static final String FLIGHT_INFO_SEARCH = flightPath+"search";
        
		/** 搜索航班列表 */
        public static final String FLIGHT_LIST_SEARCH = flightPath+"search/searchFlights";
        
        /**获取可用保险*/
        public static final String QUERY_INSURANCE = businessBasePath + insurancePath + "queryInsuranceInfo";
        
        /**
         * 计算金额
         */
        public static final String AMOUNT_CALCULATE = businessBasePath+"calculate/amountCalculate";
        
        /**航线查询 */
        public static final String FLIGHT_LINE_SEARCH = businessBasePath+"md/flightLineSearch/{arrivalCityCode}";
        
        /** 获得航班每日最低价  */
        public static final String GET_DAILY_MIN_PRICE = flightPath + "getDailyMinPrice"; 
        
        /**根据城市查询航线信息*/
		public static final String QUERY_AIRLINES_BY_CITY = maindataPath+"queryAirLinesByCity";
		
		public final static String BOOKING_REBUILD_NEW = businessBasePath + "bookingRebuildNew";
	}


	public String getPath() {
		return path;
	}


	public String getCnName() {
		return cnName;
	}
	
	public String url(String baseUrl){
		if(!baseUrl.contains("http")){
			baseUrl = CustomizedPropertyPlaceholderConfigurer.getContextProperty(baseUrl);
		}
		
		if(baseUrl.endsWith("/")){
			return baseUrl+this.path;
		}
		return baseUrl+"/" +this.path;
	}
	
	public String url(String baseUrl,Object... args){
		String url = url(baseUrl);
		String pat="\\{\\w*\\}";
		return String.format(url.replaceAll(pat,"%s"),args);
	}
	
}
