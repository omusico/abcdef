package com.lvmama.lvf.common.client.path;

import com.lvmama.lvf.common.utils.CustomizedPropertyPlaceholderConfigurer;



public enum SearchClientPath {
	
	GET_DAILY_MIN_PRICE(Path.GET_DAILY_MIN_PRICE,"获得航班最低价"),

	FLIGHT_INFO_SEARCH(Path.FLIGHT_INFO_SEARCH,"搜索航班信息"),
	
	FLIGHT_LIST_SEARCH(Path.FLIGHT_LIST_SEARCH,"搜索航班列表"),

	FLIGHT_VERIFY(Path.FLIGHT_VERIFY,"航班信息验舱验价"),
	
	FLIGHT_TICKET_RULE_SEARCH(Path.FLIGHT_TICKET_RULE_SEARCH_BY_CON,"根据条件查询客规"),
	
	FLIGHT_TICKET_RULE_SIMPLE_SEARCH(Path.FLIGHT_TICKET_RULE_SIMPLE_SEARCH_BY_CON,"根据条件查询简单客规"),
	
	
	SEARCHF_ROM_SOLR(Path.SEARCHF_FROM_SOLR,"从Solr获取航班数据"),
	
	SYNC_TO_SOLR_FROM_DB(Path.SYNC_TO_SOLR_FROM_DB,"从数据库获取数据同步到Solr"),
	
	CALCULATOR_FLIGHT_PRICE_FROM_SOLR(Path.CALCULATOR_FLIGHT_PRICE_FROM_SOLR,"从solr计算舱位价格");
	
	
	public String path;
	
	public String cnName;

	private SearchClientPath(String path, String cnName) {
		this.path = path;
		this.cnName = cnName;
	}


	public static class Path{
		public final static String flightPath = "flight/";
		
	    public final static String forAggregatePath = "forAggregate/";
		
        /** 获得航班每日最低价  */
        public static final String GET_DAILY_MIN_PRICE = flightPath + "getDailyMinPrice"; 
		
		/** 航班搜索 */
        public static final String FLIGHT_INFO_SEARCH = flightPath+"search";
        
		/** 搜索航班列表 */
        public static final String FLIGHT_LIST_SEARCH = flightPath+"search/searchFlights";

		/** 航班搜索 */
        public static final String FLIGHT_VERIFY = flightPath+"verify";
        
    	/** 查询客规 */
        public static final String FLIGHT_TICKET_RULE_SEARCH_BY_CON = flightPath+"search/searchTicketRuleByCon";
        
        /** 查询客规 */
        public static final String FLIGHT_TICKET_RULE_SIMPLE_SEARCH_BY_CON = flightPath+"search/searchTicketRuleSimpleByCon";
        
        
        /** ------------------------------------Add------------------------------------------------------*/
        /** 从Solr获取航班数据  */
        public static final String SEARCHF_FROM_SOLR = forAggregatePath + "searchFromSolr"; 
		
		/** 从数据库获取数据同步到Solr */
        public static final String SYNC_TO_SOLR_FROM_DB = forAggregatePath+"syncToSolrFromDB";
        
        /** 从Solr获取舱位价格  */
        public static final String CALCULATOR_FLIGHT_PRICE_FROM_SOLR = forAggregatePath + "calculatorFlightPriceFromSolr"; 

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
