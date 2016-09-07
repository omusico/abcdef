package com.lvmama.lvf.common.trace.profile;

public enum Profile {

	SYNC_FLIGHT_INFO_FROM_ADPATER("从adapter获取航班信息"),
	GET_POLICY_ADPATER("adapter接口：全取政策"),
	SYN_POLICY_ADPATER("adapter接口：同步政策"),
	GET_POLICY_BY_ID_ADPATER("adapter接口：根据政策ID获取政策（校验政策）"),
	SYNC_FLIGHT_INFO_TO_DB("航班同步至DB"),
	SYNC_FLIGHT_INFO_TO_SOLR("航班同步至SOLR"),
	SEARCH_FLIGHT_INFO_FROM_SOLR("从SOLR获取航班信息"),
	SELECT_WITH_PAGE_FROM_SOLR_CLIENT("从SELECT_WITH_PAGE获取航班信息"),
	SELECT_WITH_FACET_FROM_SOLR_CLIENT("从SELECT_WITH_FACET聚合过滤项"),
	SELECT_WITH_GROUP_FROM_SOLR_CLIENT("从SELECT_WITH_GROUP查总数"),
	SEARCH_FLIGHT_INFO_FROM_CLIENT("从client获取航班信息"),
	GET_DAILYMINPRICE_FROM_CLIENT("从client低价日历"),

	/** Ctrip同步 --start */
	FLIGHT_PRICE_INFO_CTRIP_SYNC("Ctrip航班运价基本信息同步"),
	FLIGHT_PRICE_POLICY_CTRIP_SYNC("Ctrip航班运价政策信息同步"),
	FLIGHT_INFO_CTRIP_SYNC("Ctrip航班基本信息同步"),
	FLIGHT_SEAT_CTRIP_SYNC("Ctrip航班舱位同步"),
	FLIGHT_DAILY_CTRIP_SYNC("Ctrip每日航班同步"),
	FLIGHT_PRICE_TICKET_RULE_CTRIP_SYNC("Ctrip运价客规同步"),
	/** Ctrip同步 --end */
	
	/** 51Book同步 --start */
	FLIGHT_PRICE_INFO_51BOOK_SYNC("51Book航班运价基本信息同步"),
	FLIGHT_PRICE_POLICY_51BOOK_SYNC("51Book航班运价政策信息同步"),
	FLIGHT_INFO_51BOOK_SYNC("51Book航班基本信息同步"),
	FLIGHT_SEAT_51BOOK_SYNC("51Book航班舱位同步"),
	FLIGHT_DAILY_51BOOK_SYNC("51Book每日航班同步"),
	/** 51Book同步 --end */
	
	/** Lvmama同步 --start */
	FLIGHT_PRICE_INFO_LVMAMA_SYNC("Lvmama航班运价基本信息同步"),
	FLIGHT_PRICE_POLICY_LVMAMA_SYNC("Lvmama航班运价政策信息同步"),
	FLIGHT_INFO_LVMAMA_SYNC("Lvmama航班基本信息同步"),
	FLIGHT_SEAT_LVMAMA_SYNC("Lvmama航班舱位同步"),
	FLIGHT_DAILY_LVMAMA_SYNC("Lvmama每日航班同步"),
	/** Lvmama同步 --end */
	/** Lvmama_domestic同步 --start */
	FLIGHT_PRICE_INFO_LVMAMA_DOMESTIC_SYNC("Lvmama_domestic航班运价基本信息同步"),
	FLIGHT_PRICE_POLICY_LVMAMA_DOMESTIC_SYNC("Lvmama_domestic航班运价政策信息同步"),
	FLIGHT_INFO_LVMAMA_DOMESTIC_SYNC("Lvmama_domestic航班基本信息同步"),
	FLIGHT_SEAT_LVMAMA_DOMESTIC_SYNC("Lvmama_domestic航班舱位同步"),
	FLIGHT_DAILY_LVMAMA_DOMESTIC_SYNC("Lvmama_domestic每日航班同步"),
	/** Lvmama_domestic同步 --end */
	/** 517Na同步 --start */
	Flight_Policy_517Na_FULL_SYNC("517Na政策全量同步"),
	Flight_Policy_517Na_ADD_SYNC("517Na政策增同步"),
	/** 517Na同步 --end */
	FLIGHT_PRICE_INVENTORY_SYNC("运价库存信息同步"),
	FLIGHT_SYNC("原子化航班信息同步"),
	FLIGHT_BASE_INFO_SYNC_FOR_TASK("通过51同步航班基本信息与每日航班信息(定时任务的方式缓存信息)"),
	FLIGHT_CTRIP_INFO_SYNC_FOR_TASK("调用通过携程同步航班信息（定时任务的方式缓存信息）"),
	
	GET_FLIGHT_QUERY_COST_PRICE_FROM_CLIENT("LVFR-AGG-航班查询"),
	GET_FLIGHT_INFO_FROM_CLIENT("LVFR-AGG-每日航班信息查询"),
	GET_FLIGHT_SEAT_FROM_CLIENT("LVFR-AGG-航班舱位信息查询"),
	LVFR_AGG_QUERY_POLICY("LVFR-AGG-政策实时询价"),
	LVFR_AGG_QUERY_POLICY_BY_PAR_PRICE("LVFR-AGG-政策实时询价，根据已有票面价"),
	LVFR_AGG_AVH_ROUTE("LVFR-AGG-聚合avh查询航班可销售信息"),
	LVFR_POLICY_FLIGHT_QUERY_POLICY("LVFR-POLICY-航班查询，查询政策"),
	LVFR_POLICY_INQUIRY_POLICY("LVFR-POLICY-政策询价"),
	LVFR_FARE_QUERY_FARE("LVFR-FARE-查询运价信息"),
	

	SYNC_VST_ADD_BIZ_FLIGHT("同步新增VST基础航班"),
	SYNC_VST_UPDATE_BIZ_FLIGHT("同步更新VST基础航班"),
	SYNC_VST_ADD_GOODS("同步新增VST商品"),
	SYNC_VST_UPDATE_GOODS("同步更新VST商品"),
	SYNC_VST_GOODS_TIME_PRICE("同步更新VST商品时间价格"),
	SYNC_VST_ADD_PRODUCT("同步新增VST产品"),
	SYNC_VST_UPDATE_PRODUCT("同步更新VST产品"),
	SYNC_VST_ADD_PRODUCT_BRANCH("同步新增VST产品规格"),
	SYNC_VST_UPDATE_PRODUCT_BRANCH("同步更新VST产品规格"),
	SYNC_VST_ADD_PRODUCT_FLIGHT("同步新增VST产品航班"),
	SYNC_VST_UPDATE_PRODUCT_FLIGHT("同步更新VST产品航班"),


	FLIGHT_APPLY_CHANGE("Ctrip申请改签"),
	FLIGHT_TO_BOOKING("航班预订填写"),
	FLIGHT_BOOKING("航班预订"),
	ORDER_BOOKING("订单基本信息落地"),
	SUPPORDER_BOOKING("调用供应商接口创建供应商订单"),
	SUPPORDER_BOOKING_FROM_ADPATER("调用供应商接口创建供应商订单ADPATER"),
	CANCEL_SUPPORDER_FROM_ADPATER("调用供应商接口取消供应商订单ADPATER"),
	ORDER_BOOKING_FINISH("回填订单信息"),
	BOOKING_REBUILD("重新组装订单信息"),
	FLIGHT_TO_BOOKING_CONTROLLER("航班预订填写控制层"),
	FLIGHT_BOOKING_CONTROLLER("航班预订控制层"),
	FLIGHT_SEARCH_CONTROLLER("航班查询控制层"),
	VST_BOOKING_ORDER("VST锁舱预订"),
	VST_BOOKING_ORDERS("VST锁舱预订多单"),
	VST_PAY_ORDER("VST支付通知"),
	VST_CANCEL_ORDER("VST取消通知"),
	VST_SEARCH_FLIGHT("VST查询航班是否可售"),
	VST_GET_FLIGHT_BY_GOODS_ID("VST根据商品ID获取航班号"),

    VST_QUERY_GROUPLOWERSALEPRICE("VST查询低价日历-优化"),
    VST_QUERY_FLIGHTMSG("VST查询请求的所有商品-优化"),
    VST_CONVERT_FLIGHT_GOODS("VST查询商品转换-优化"),
    VST_GET_SALESPRICE("VST销售价格计算"),
    VST_GET_CHILD_SALESPRICE("VST计算儿童价"),
    VST_GET_FLIGHTVSTGOOD_BY_FLIGHTNO("VST根据航班号查询商品"),
    VST_ASYNC_SEARCH_FLIGHTS("VST异步查询航班信息-优化"),
	VST_ASYNC_SEARCH_LOWEST_PRICE("VST异步查询低价接口"),
	
	OPENAPI_QUERY_BOOKING_ORDER_LIST("Openapi查询预订订单列表"),
	OPENAPI_PAY("Openapi支付"),

    ROUTE_GET_REFUND_DETAIL("路由根据退废票单号查询退废票详情"),
    ROUTE_QUERY_FLIGHT_INFO("路由查询航班信息"),
    ROUTE_VERIFY_SEAT_AND_PRICE("路由验舱验价"),
    ROUTE_CREATE_ORDER("路由创建订单"),
    ROUTE_FLIGHT_SUPP_ORDER_PAY("路由供应商支付"),
    ROUTE_GET_FLIGHT_TICKET_RULE("路由获取客规"),
    ROUTE_APPLY_SUPP_ORDER_REFUND("路由提交退废票申请"),
    ROUTE_GET_SUPPORDER_BY_ORDER_NO("路由根据订单号查询供应商订单"),
    ROUTE_CANCEL_ORDER("路由取消订单"),
    ROUTE_RESCHEDULE_SEARCH("国内机票可改航班查询"),
    
    /**机酒相关Profile */
 	FIT_SELECT_HOTEL_FROM_VST("从VST获取酒店信息"),
 	FIT_QUERY_VST_GOODS_PRICE_LIST("从VST查询时间价格表"),
 	FIT_VST_ORDER_CREATE("请求VST下单"),
 	FIT_FLIGHT_ORDER_CREATE("请求机票下单"),
 	FIT_SELECT_FLIGHT_AND_HOTEL("获取机票和酒店聚合信息"),
 	FIT_CALCULAT_SHOPPING_AMOUNT("购物车计算金额"),
 	FIT_BOOKING("调用dpclient下机酒店订单"),
 	FIT_SELECT_SPOT_FROM_VST("从VST获取景点信息");
	
	private String cnName;
	
	private Profile(String cnName) {
		this.cnName = cnName;
	}

	public String getCnName() {
		return cnName;
	}

	public void setCnName(String cnName) {
		this.cnName = cnName;
	}
	
}
