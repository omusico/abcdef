package com.lvmama.lvfit.common.client.path;

import com.lvmama.lvf.common.utils.CustomizedPropertyPlaceholderConfigurer;
import com.lvmama.lvfit.common.client.path.AggregateClientPath.Path;



public enum DpClientPath {
	
	GET_FLIGHT_AND_HOTEL(Path.GET_FLIGHT_AND_HOTEL,"获取机票酒店信息"),
	QUERY_COMMENT_PAGE(Path.QUERY_COMMENT_PAGE,"获取点评列表"),
	GET_HOTEL_DETAIL(Path.GET_HOTEL_DETAIL,"获取酒店详情信息"),
	
	GET_HOTEL_LIST(Path.GET_HOTEL_LIST,"获取更换酒店列表"),
	GET_HOTEL_LIST_CACHE(Path.GET_HOTEL_LIST_CACHE,"获取更换酒店列表"),
	
	GET_FLIGHT_LIST(Path.GET_FLIGHT_LIST,"获取更换航班列表"),
	GET_FLIGHT_LIST_CACHE(Path.GET_FLIGHT_LIST_CACHE,"获取更换航班列表"),
	GET_FLIGHT_LIST_TO_BACK(Path.GET_FLIGHT_LIST_TO_BACK,"获取往返的航班列表"),
	
	CHANGE_SHOPPING_FLIGHT(Path.CHANGE_SHOPPING_FLIGHT,"更换航班重新加载购物车"),
	CHANGE_SHOPPING_HOTEL(Path.CHANGE_SHOPPING_HOTEL,"更换酒店重新加载购物车"),
	GET_SHOPPING_BY_UUID(Path.GET_SHOPPING_BY_UUID,"根据shoppingUUID加载购物车"),
	CALCULAT_SHOPPING_AMOUNT(Path.CALCULAT_SHOPPING_AMOUNT,"计算购物车总金额"),
	CALCULAT_SHOPPING_AMOUNT_BY_DETAIL(Path.CALCULAT_SHOPPING_AMOUNT_BY_DETAIL,"计算购物车总金额"),
	GET_CHANGED_HOTEL(Path.GET_CHANGED_HOTEL,"加载更换的酒店"),
	GET_CHANGED_FLIGHT(Path.GET_CHANGED_FLIGHT,"加载更换的航班"),
	REDUCTION_SHOPPINGINFO(Path.REDUCTION_SHOPPINGINFO,"根据shoppingUUID还原购物车"),
	TO_BOOKING(Path.TO_BOOKING, "去预定"),
	BOOKING(Path.BOOKING, "预定"),
	RECORD_BOOKING_LOG_NO_LOGIN(Path.RECORD_BOOKING_LOG_NO_LOGIN,"用户点击预订下一步前预定前记录用户请求信息"),
	REDUCTION_SEARCH_REQUEST(Path.REDUCTION_SEARCH_REQUEST, "还原搜索条件"),
	//public final static String RE_GET_SHOPPING_BY_UUID=basePath+shoppingPath+"reGetShoppingByUUID";
	RE_GET_SHOPPING_BY_UUID(Path.RE_GET_SHOPPING_BY_UUID,"第一次查不到再查一次"),
	GET_RECOM_HOTEL_BY_DISTRICT_ID(Path.GET_RECOM_HOTEL_BY_DISTRICT_ID,"根据城市id查找推荐酒店"),
	GET_SHOPPING_RESULT(Path.GET_SHOPPING_RESULT,"获取产品选择页默认加载的信息"),
	SEARCH_FIT_RECORD_FROM_SOLR(Path.SEARCH_FIT_RECORD_FROM_SOLR, "从solr中查询机+酒搜索记录"),
	
	UPD_SELECT_INSURANCE_INFO(Path.UPD_SELECT_INSURANCE_INFO, "更新缓存中选中的保险信息"),
    UPD_SELECT_TICKET_INFO(Path.UPD_SELECT_TICKET_INFO, "更新缓存中选中的门票信息"),
    UPD_SELECT_FLI_INS_INFO(Path.UPD_SELECT_FLI_INS_INFO, "更新缓存中选中的机票保险信息"),
    HOTEL_CONDITION(Path.HOTEL_CONDITION,"获取缓存中几点筛选条件"), 
	GET_FLIGHT_INFOS(Path.GET_FLIGHT_INFOS, "获取机票信息"),
    APP_UPDATE_GOODS_TO_CACHE(Path.APP_UPDATE_GOODS_TO_CACHE,"更新商品信息到缓存"),
	GET_HOTEL_INFOS(Path.GET_HOTEL_INFOS, "获取酒店信息");
    
	public String path;
	
	public String cnName;

	private DpClientPath(String path, String cnName) {
		this.path = path;
		this.cnName = cnName;
	}


	public static class Path{
		public final static String basePath = "dp/";
		public final static String flightandhoteltPath = "flightandhotel/";
		public final static String shoppingPath="shopping/";
		public final static String orderPath="order/";
		
        /** 获得航班每日最低价  */
        public static final String GET_FLIGHT_AND_HOTEL = basePath+flightandhoteltPath + "search"; 
        /**点评查询**/
        public final static String QUERY_COMMENT_PAGE = basePath+"comment/querypage";
        /** 酒店详情查询 **/
        public static final String GET_HOTEL_DETAIL = basePath+"hotel/detail";
        
        /**获取更换酒店列表*/
		public final static String GET_HOTEL_LIST = basePath+"hotel/search";
        /**获取更换酒店列表从缓存*/
		public final static String GET_HOTEL_LIST_CACHE = basePath+"hotel/search/cache";
		
		 /**获取更换航班列表*/
		public final static String GET_FLIGHT_LIST = basePath+"flight/search/{uuid}/{method}";
		 /**获取更换航班列表从缓存*/
		public final static String GET_FLIGHT_LIST_CACHE = basePath+"flight/search/cache";
				
		/**获取往返的航班信息*/
		public final static String GET_FLIGHT_LIST_TO_BACK = basePath+"flights/search/toBack";
		
		/**
		 * 选择航班
		 */
		public final static String CHANGE_SHOPPING_FLIGHT=basePath+shoppingPath+"changeFlight";
		/**
		 * 选择酒店
		 */
		public final static String CHANGE_SHOPPING_HOTEL=basePath+shoppingPath+"changeHotel";
		/**
		 * 加载购物车
		 */
		public final static String GET_SHOPPING_BY_UUID=basePath+shoppingPath+"getShoppingByUUID";
		/**
		 * 计算购物车价格
		 */
		public final static String CALCULAT_SHOPPING_AMOUNT=basePath+shoppingPath+"calculateAmount";
		
		/**
		 * App计算购物车价格
		 */
		public final static String CALCULAT_SHOPPING_AMOUNT_BY_DETAIL = basePath + shoppingPath + "calculateAmountByDetail";
		/**
		 * 加载更换的酒店
		 */
		public final static String GET_CHANGED_HOTEL=basePath+shoppingPath+"getChangedHotel";
		/**
		 * 加载更换的航班
		 */
		public final static String GET_CHANGED_FLIGHT=basePath+shoppingPath+"getChangedFlight";

		/** 去预定 */
		public final static String TO_BOOKING = basePath + "toBooking";
		/** 预定 */
		public final static String BOOKING = basePath + "booking";
		
		
		/** 用户点击预订下一步前预定前记录用户请求信息 */
		public final static String RECORD_BOOKING_LOG_NO_LOGIN = basePath + "recordBookingLogNoLogin";

        /**还原购物车**/
		
		public final static String REDUCTION_SHOPPINGINFO = basePath+shoppingPath+"reductionShoppingInfo";
		
		/**还原搜索条件***/
		public final static String REDUCTION_SEARCH_REQUEST = basePath+shoppingPath+"reductionShoppingrequest";
		
		/**
		 * 再次加载购物车
		 */
		public final static String RE_GET_SHOPPING_BY_UUID=basePath+shoppingPath+"reGetShoppingByUUID";
		/**根据城市id查找推荐酒店***/
		public final static String GET_RECOM_HOTEL_BY_DISTRICT_ID = basePath+"hotel/getRecommendHotelsByDistrictId";
		
		/**获取产品选择页默认加载的信息*/
		public static final String GET_SHOPPING_RESULT = basePath+shoppingPath + "search";
		
		/** 从Solr中搜索查询记录 */
	    public static final String SEARCH_FIT_RECORD_FROM_SOLR = basePath + "searchSolr/record";
	    /** 更新缓存中的门票信息 */
	    public static final String UPD_SELECT_TICKET_INFO = basePath + shoppingPath + "updSelectedTicketInfo";
	    /** 更新缓存中的保险信息 */
	    public static final String UPD_SELECT_INSURANCE_INFO = basePath + shoppingPath + "updSelectedInsuranceInfo";
	    /** 更新缓存中的机票保险信息 */
	    public static final String UPD_SELECT_FLI_INS_INFO = basePath + shoppingPath + "updSelectedFliInsInfo";
	    /** 酒店筛选条件*/
	    public static final String HOTEL_CONDITION = basePath + shoppingPath + "getHotelCondition";

		/**获取航班信息*/
		public final static String GET_FLIGHT_INFOS = basePath + "getFlightInfos";	    

		/** 更新商品缓存数据 */
        public static final String  APP_UPDATE_GOODS_TO_CACHE = basePath + "updateGoodsToCache";

		/** 更新商品缓存数据 */
		public static final String  GET_HOTEL_INFOS = basePath + "getHotelInfos";
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
