package com.lvmama.lvfit.common.client.path;

import com.lvmama.lvf.common.utils.CustomizedPropertyPlaceholderConfigurer;
import com.lvmama.lvfit.common.client.path.BatchClientPath.Path;

public enum BussinessClientPath {	
	SAVE_SHOPPING(Path.SAVE_SHOPPING,"保存购物车信息"),
	GET_SHOPPING(Path.GET_SHOPPING,"获取购物车信息"),
	GETDP_SHOPPING(Path.GETDP_SHOPPING,"获取持久化购物车信息"),
	CHANGE_SHOPPING(Path.CHANGE_SHOPPING, "修改购物车信息"),
	QUERY_SHOPPING(Path.QUERY_SHOPPING, "查询购物车列表信息"),
	QUERY_SHOPPING_EXPROT(Path.QUERY_SHOPPING_EXPROT, "查询购物车列表信息"),
	TO_BOOKING(Path.TO_BOOKING, "去预订"),
	BOOKING(Path.BOOKING, "预订"),
	VALIDATE_PASSENGERS(Path.VALIDATE_PASSENGERS, "校验乘客信息"),
	FLIGHT_CALLBACK_BOOKING(Path.FLIGHT_CALLBACK_BOOKING, " VST测回调机票下单"),
	GET_FLIGHT_CALL_BACK_BY_VST_NO(Path.GET_FLIGHT_CALL_BACK_BY_VST_NO,"根据VST主订单获取机票回调信息"),
	GET_RECOMMEND_HOTELS_ALL(Path.GET_RECOMMEND_HOTELS_ALL,"查询所有推荐酒店信息分页"),
	BATCH_RECOMMEND_HOTELS_ALL(Path.BATCH_RECOMMEND_HOTELS_ALL,"导入所有推荐酒店信息"),
	SAVE_RECOMMEND_HOTEL(Path.SAVE_RECOMMEND_HOTEL,"新增默认推荐酒店信息"),
	UPDATE_RECOMMEND_HOTEL(Path.UPDATE_RECOMMEND_HOTEL,"修改默认推荐酒店信息"),
	DELETE_RECOMMEND_HOTEL(Path.DELETE_RECOMMEND_HOTEL,"删除默认推荐酒店信息"),
	GET_ALL_RECOM_HOTEL(Path.GET_ALL_RECOM_HOTEL,"查询默认推荐酒店信息不带分页"),
	//SAVE_UPDATE_RECOMMEND_HOTEL(Path.SAVE_UPDATE_RECOMMEND_HOTEL,"新增或修改默认推荐酒店信息"),
	GET_RECOMMEND_HOTEL(Path.GET_RECOMMEND_HOTEL,"获取默认推荐酒店信息"),
	/**  订单查询相关 **/
	BACK_ORDER_QUERY_LIST(Path.BACK_ORDER_QUERY_LIST, "后台订单查询"),
	BACK_ORDER_QUERY_LOG_LIST(Path.BACK_ORDER_QUERY_LOG_LIST, "后台订单查询"),
    VIEW_OP_LOG(Path.VIEW_OP_LOG, "查询操作日志"),
    GET_SHOPPING_INFO_BY_UUID(Path.GET_SHOPPING_INFO_BY_UUID, "根据UUID获取购物车信息"),
    UPD_SHOPPING_INFO(Path.UPD_SHOPPING_INFO, "更新或保存购物车信息"),
    QUERY_ORDER_MAIN_BY_VST_ORDER_MAIN_NO(Path.QUERY_ORDER_MAIN_BY_VST_ORDER_MAIN_NO,"根据机酒主单号查询订单详情"),
   
    QUERY_FLIGHT_ORDER_BY_VST_ORDER_MAIN_NO(Path.QUERY_ORDER_FLIGHT_ORDER_BY_VST_ORDER_MAIN_NO,"根据机酒主单号查询机票订单详情"),
    
    // TODO 迁移完成后删除
    OLD_ORDER_DATA_TRANSFER(Path.OLD_ORDER_DATA_TRANSFER, "旧订单数据迁移"),
    
    OLD_SINGLE_ORDER_DATA_TRANSFER(Path.OLD_SINGLE_ORDER_DATA_TRANSFER, "单个旧订单数据迁移"),
	
	AUTO_SYNC_SUPPMAINORDER_STATUS(Path.AUTO_SYNC_SUPPMAINORDER_STATUS,"同步订单状态"),
	
	GET_SDP_PRODUCT_BASICI_NFO_BY_ID(Path.GET_SDP_PRODUCT_BASICI_NFO_BY_PRODUCT_ID,"根据产品Id获取自主打包产品"),
	
	SAVE_OR_UPDATE_PRODUCTBASICINFO(Path.SAVE_OR_UPDATE_SDP_PRODUCT_BASICI_NFO,"新增或者修改自主打包产品信息"),
	
	DELETE_SDP_PRODUCT_INFO_BY_PRODUCT_ID(Path.DELETE_SDP_PRODUCT_INFO_BY_PRODUCT_ID,"根据产品Id删除自主打包产品"),
	
	BACK_SDP_PRODUCT_BASIC_INFO_QUERY_LIST(Path.BACK_SDP_PRODUCT_BASIC_INFO_QUERY_LIST,"自主打包产品查询列表"),
	
	BACK_SDP_PRODUCT_SEARCH_INDEX_QUERY_LIST(Path.BACK_SDP_PRODUCT_SEARCH_INDEX_QUERY_LIST,"产品ID索引查询列表"),
	
	GET_SDP_PRODUCT_CITY_GROUP_BY_PRODUCT_ID(Path.GET_SDP_PRODUCT_CITY_GROUP_BY_PRODUCT_ID,"根据产品Id获取自主打包产品城市组"),
	
	GET_SDP_PRODUCT_CITY_GROUP_BY_ID(Path.GET_SDP_PRODUCT_CITY_GROUP_BY_ID,"根据Id获取自主打包产品城市组"),
	
	GET_SDP_PRODUCT_SELECT_CITY_GROUP_BY_PRODUCT_ID(Path.GET_SDP_PRODUCT_SELECT_CITY_GROUP_BY_PRODUCT_ID,"根据产品Id获取已选择的自主打包产品城市组"),
	
	SAVE_OR_UPDATE_SDP_PRODUCT_CITY_GROUP(Path.SAVE_OR_UPDATE_SDP_PRODUCT_CITY_GROUP,"新增或者修改自主打包产品城市组"),
	
	UPDATE_CITY_USE_FLAG_BATCH(Path.UPDATE_CITY_USE_FLAG_BATCH,"修改自主打包产品城市组使用标志"),
	
	GET_SDP_PRODUCT_TRAFFIC_RULES_BY_PRODUCT_ID(Path.GET_SDP_PRODUCT_TRAFFIC_RULES_BY_PRODUCT_ID,"根据产品Id获取自主打包产品交通规则"),
	
	SAVE_OR_UPDATE_SDP_PRODUCT_TRAFFIC_RULES(Path.SAVE_OR_UPDATE_SDP_PRODUCT_TRAFFIC_RULES,"新增或者修改自主打包产品交通规则"),
	
	GET_SDP_PRODUCT_FEE_RULES_BY_PRODUCT_ID(Path.GET_SDP_PRODUCT_FEE_RULES_BY_PRODUCT_ID,"根据产品Id获取自主打包产品费用规则"),
	
	SAVE_OR_UPDATE_SDP_PRODUCT_FEE_RULES(Path.SAVE_OR_UPDATE_SDP_PRODUCT_FEE_RULES,"新增或者修改自主打包产品费用规则"),
	SET_DEFAULT_HOTEL(Path.SET_DEFAULT_HOTEL,"将酒店配置为默认推荐的酒店"),
	/** 动态打包产品相关报表**/
	QUERY_SDP_PRODUCT_REPORT(Path.QUERY_SDP_PRODUCT_REPORT,"动态打包产品报表导出"),
	
	BACK_SDP_PRODUCT_INDEX_TRAFFIC(Path.BACK_SDP_PRODUCT_INDEX_TRAFFIC,"查询产品索引交通"),
	
	BACK_SDP_PRODUCT_DEPART_CITY(Path.BACK_SDP_PRODUCT_DEPART_CITY,"出发城市查询"),
	
	UPDATE_ONE_CITY_GROUP(Path.UPDATE_ONE_CITY_GROUP,"更新单条城市组信息"),
	
	GET_SDP_PRODUCT_TRAFFIC_INDEX_BY_ID(Path.GET_SDP_PRODUCT_TRAFFIC_INDEX_BY_ID,"根据id查询交通索引"),
	
	UPDATE_SDP_PRODUCT_TRAFFIC_INDEX(Path.UPDATE_SDP_PRODUCT_TRAFFIC_INDEX,"更新产品交通索引"),
	
	BACK_SDP_PRODUCT_ALL_SYN_INFO(Path.BACK_SDP_PRODUCT_ALL_SYN_INFO,"查询所有同步信息"),
	
	BACK_SUPP_ORDER_FLIGHT_CALL_BACK(Path.BACK_SUPP_ORDER_FLIGHT_CALL_BACK,"机票回调信息列表");
	
	public String path;
	public String cnName;
	
	public static class Path{
		
		public final static String basePath="bussiness/";
		public final static String orderPath ="order/";
		public final static String shopingPath = "shoping/";
		public final static String ticketPath ="booking/";
		public final static String configPath ="config/";
		public final static String reportPath ="report/";
		public final static String sdpproductPath ="sdpproduct/";

		public final static String SAVE_SHOPPING=basePath+orderPath+"shopping/save";
		public final static String CHANGE_SHOPPING=basePath+shopingPath+"shopping/change";
		public final static String GET_SHOPPING=basePath+shopingPath+"shopping/${shopingId}";
		public final static String GETDP_SHOPPING=basePath+shopingPath+"getDpShopping";
		public final static String QUERY_SHOPPING=basePath+shopingPath+"queryShoppingList";
		public final static String QUERY_SHOPPING_EXPROT=basePath+shopingPath+"queryShoppingListExprot";
		/** 去预订 */
		public final static String TO_BOOKING = basePath + "toBooking";
		/** 预订 */
		public final static String BOOKING = basePath + "booking";
		public final static String VALIDATE_PASSENGERS  = basePath+"validatePassenagers";
		public final static String FLIGHT_CALLBACK_BOOKING = basePath + "flightCallBackBooking";
		public final static String GET_FLIGHT_CALL_BACK_BY_VST_NO = basePath + "getFlightCallBackBookingByVstMainNo";
		/** 订单详情 */
		public final static String GET_RECOMMEND_HOTELS_ALL = basePath + configPath + "getRecomHotelsAll";
		public final static String BATCH_RECOMMEND_HOTELS_ALL = basePath + configPath + "importRecomAllHotels";
		public final static String SAVE_RECOMMEND_HOTEL = basePath + configPath + "saveRecomHotel";
		public final static String UPDATE_RECOMMEND_HOTEL = basePath + configPath + "updateRecomHotel";
		public final static String GET_RECOMMEND_HOTEL = basePath + configPath + "getRecomHotel";
		public final static String DELETE_RECOMMEND_HOTEL = basePath + configPath + "deleteRecomHotel";
		public final static String GET_ALL_RECOM_HOTEL = basePath + configPath + "getAllRecomHotel";
		
		//public final static String SAVE_UPDATE_RECOMMEND_HOTEL = basePath + configPath + "saveOrUpdateRecomHotel";
		/** 后台：订单查询 列表和详情 */
		public final static String BACK_ORDER_QUERY_LIST = basePath + orderPath + "orderQueryList";
		public final static String BACK_ORDER_QUERY_LOG_LIST = basePath + orderPath + "orderQueryLogList";
		public final static String BACK_ORDER_QUERY_DETAIL = basePath + orderPath + "orderQueryDetail/{vstOrderId}";
		
		
		public final static String QUERY_ORDER_MAIN_BY_VST_ORDER_MAIN_NO = basePath + orderPath + "queryOrderMainByVstOrderMainNo/{vstOrderMainNo}";
		
		public final static String QUERY_ORDER_FLIGHT_ORDER_BY_VST_ORDER_MAIN_NO = basePath + orderPath + "queryFlightOrderByVstOrderMainNo";
		
		
		public final static String VIEW_OP_LOG = basePath + reportPath + "viewFitOpLog";
	
		public final static String GET_SHOPPING_INFO_BY_UUID = basePath + shopingPath + "shoppingInfo/{uuid}";
        public final static String UPD_SHOPPING_INFO = basePath + shopingPath + "updShoppingInfo";
        
        public final static String OLD_ORDER_DATA_TRANSFER = basePath + orderPath + "oldOrderDataTransfer";
        
        public final static String OLD_SINGLE_ORDER_DATA_TRANSFER = basePath + orderPath + "oldSingleOrderDataTransfer/{vstOrderMainNo}";
        
        
        public final static String AUTO_SYNC_SUPPMAINORDER_STATUS = basePath + orderPath + "autoSyncSuppMainOrderStatus";
        /*自主打包产品基本信息*/
        public final static String GET_SDP_PRODUCT_BASICI_NFO_BY_PRODUCT_ID = basePath + sdpproductPath + "getSdpProductBasicInfoByProductId/{productId}";
        
        public final static String SAVE_OR_UPDATE_SDP_PRODUCT_BASICI_NFO = basePath + sdpproductPath + "saveOrUpdateSdpProductBasicInfo";
        
        public final static String DELETE_SDP_PRODUCT_INFO_BY_PRODUCT_ID = basePath + sdpproductPath + "deleteSdpProductInfoByProductId/{productId}";
        /*自主打包产品交通规则*/
        public final static String GET_SDP_PRODUCT_TRAFFIC_RULES_BY_PRODUCT_ID = basePath + sdpproductPath + "getProductTrafficRulesByProductId/{productId}";
        
        public final static String SAVE_OR_UPDATE_SDP_PRODUCT_TRAFFIC_RULES = basePath + sdpproductPath + "saveOrUpdateProductTrafficRules";
        /*自主打包产品加价规则*/
        public final static String GET_SDP_PRODUCT_FEE_RULES_BY_PRODUCT_ID = basePath + sdpproductPath + "getProductFeeRulesByProductId/{productId}";
        
        public final static String SAVE_OR_UPDATE_SDP_PRODUCT_FEE_RULES = basePath + sdpproductPath + "saveOrUpdateProductFeeRules";
        /*自主打包产品城市组*/
        public final static String GET_SDP_PRODUCT_CITY_GROUP_BY_PRODUCT_ID = basePath + sdpproductPath + "getProductCityGroupByProductId/{productId}";
        /*已选择的自主打包产品城市组*/
        public final static String GET_SDP_PRODUCT_SELECT_CITY_GROUP_BY_PRODUCT_ID = basePath + sdpproductPath + "getSelectProductCityGroupByProductId/{productId}";
        
        public final static String SAVE_OR_UPDATE_SDP_PRODUCT_CITY_GROUP = basePath + sdpproductPath + "saveOrUpdateProductCityGroup";
        
        public final static String UPDATE_CITY_USE_FLAG_BATCH = basePath + sdpproductPath + "updateCityUseFlagBatch";
        
        /**后台：交通+X产品查询列表*/
        public final static String BACK_SDP_PRODUCT_BASIC_INFO_QUERY_LIST = basePath + sdpproductPath + "SdpProductBasicInfoQueryList";
	    
        public final static String SET_DEFAULT_HOTEL = basePath + configPath + "setDefaultHotel/{id}/{districtCityId}";
        
        public final static String QUERY_SDP_PRODUCT_REPORT = basePath + sdpproductPath + "querySdpProduct";
        
        public final static String BACK_SDP_PRODUCT_SEARCH_INDEX_QUERY_LIST = basePath + sdpproductPath + "querySdpProductSearchIndex";
        
        public final static String BACK_SDP_PRODUCT_INDEX_TRAFFIC = basePath + sdpproductPath + "querySdpProductIndexTraffic";
        /*自主打包产品城市组*/
        public final static String BACK_SDP_PRODUCT_DEPART_CITY = basePath + sdpproductPath + "querySdpProductCityGroupByDto";
        
        public final static String UPDATE_ONE_CITY_GROUP = basePath + sdpproductPath + "saveProductCityGroupByProductId";
        
        public final static String GET_SDP_PRODUCT_CITY_GROUP_BY_ID = basePath + sdpproductPath + "saveProductCityGroupById/{id}";
        
        public final static String BACK_SUPP_ORDER_FLIGHT_CALL_BACK = basePath + sdpproductPath + "querySuppFlightCallBack";
	
        public final static String GET_SDP_PRODUCT_TRAFFIC_INDEX_BY_ID = basePath + sdpproductPath + "querySdpTrafficIndexById/{id}";
	
        public final static String UPDATE_SDP_PRODUCT_TRAFFIC_INDEX = basePath + sdpproductPath + "updateOneTrafficIndex";
        
        public final static String BACK_SDP_PRODUCT_ALL_SYN_INFO= basePath  + sdpproductPath +"queryAllSynInfo";
        
	}
	
	private BussinessClientPath(String path, String cnName) {
		this.path = path;
		this.cnName = cnName;
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
