package com.lvmama.lvf.common.client.path;

import com.lvmama.lvf.common.utils.CustomizedPropertyPlaceholderConfigurer;

public enum AdapterClientPath {

	GET_FLIGHT_SEAT_BY_FLIGHT_NO(Path.GET_FLIGHT_SEAT_BY_FLIGHT_NO, "根据航班号查询座位情况"),
	GET_POLICY_AND_FARE_BY_FIIGHTS(Path.GET_POLICY_AND_FARE_BY_FIIGHTS, "根据航班列表舱位出发日期等查询政策及运价"),
	GET_CHILD_POLICY_AND_FIIGHT(Path.GET_CHILD_POLICY_AND_FIIGHT, "根据航班舱位出发日期实时匹配儿童政策"),
	GET_AVAILABLE_FLIGHT_WITH_PRICE_AND_COMMISION(Path.GET_AVAILABLE_FLIGHT_WITH_PRICE_AND_COMMISION,"航班查询（含票面价、返佣）AV3"),
	GET_AVAILABLE_FLIGHT_WITH_PRICE(Path.GET_AVAILABLE_FLIGHT_WITH_PRICE,"航班查询（含票面价）AV2"),
	GET_POLICY(Path.GET_POLICY,"全取政策"),
	SYNC_POLICY(Path.SYNC_POLICY,"同步政策"),
	GET_POLICY_BY_ID(Path.GET_POLICY_BY_ID,"根据政策ID获取政策（校验政策）"),
	GET_TICKET_RULE(Path.GET_TICKET_RULE,"获取所有退改签规定"),
	GET_TICKET_RULE_BY_CONDITION(Path.GET_TICKET_RULE_BY_CONDITION,"根据条件获取退改签规定"),
	CREATE_ORDER(Path.CREATE_ORDER, "根据旅客信息创建PNR及订单"),
	GET_SUPPORDER_BY_ORDER_NO(Path.GET_SUPPORDER_BY_ORDER_NO, "根据订单号查询供应商订单"),
	CANCELORDER(Path.CANCELORDER, "订单取消"),
	GET_REFUND_DETAIL(Path.GET_REFUND_DETAIL,"根据退废票单号查询退废票详情。"),
	APPLY_POLICY_ORDER_REFUND(Path.APPLY_POLICY_ORDER_REFUND,"向供应商申请退废票"),
	PAY(Path.PAY,"订单支付"),
	GET_DAILY_LOWEST_PRICE(Path.GET_DAILY_LOWEST_PRICE,"获取每日最低价"),
	APPLY_INSURANCE_SINGLE_INSURING(Path.APPLY_INSURANCE_SINGLE_INSURING,"投保"),
	APPLY_INSURANCE_HESITATE_CANCEL(Path.APPLY_INSURANCE_HESITATE_CANCEL,"退保"),
	QUERY_INSURANCE_SUPP(Path.QUERY_INSURANCE_SUPP,"供应商保单信息（状态）"),
	CTRIP_ORDER_PAY(Path.CTRIP_ORDER_PAY,"携程订单支付"),
	APPLY_CHANGE(Path.APPLY_CHANGE,"向供应商申请改签"),
	FIVE17NA_VERIFY_SEAT_AND_PRICE(Path.FIVE17NA_VERIFY_SEAT_AND_PRICE,"517Na供应商询价"),
	FIVE17NA_CANCEL_PNR(Path.FIVE17NA_CANCEL_PNR,"517Na取消旧的pnr"),
	FIVE17NA_SYNC_POLICY_PUSH_FULL(Path.FIVE17NA_SYNC_POLICY_PUSH_FULL,"517Na政策全量同步"),
	FIVE17NA_SYNC_POLICY_PUSH_ADD(Path.FIVE17NA_SYNC_POLICY_PUSH_ADD,"517Na政策增量同步"),
	/** Adapter路由Resource对应枚举(以ROUTE)START **/
	ROUTE_QUERY_FLIGHT_INFO(Path.ROUTE_QUERY_FLIGHT_INFO, "查询航班信息"),
	ROUTE_VERIFY_SEAT_AND_PRICE(Path.ROUTE_VERIFY_SEAT_AND_PRICE,"根据航班相关信息验舱验价"),
	ROUTE_CREATE_ORDER(Path.ROUTE_CREATE_ORDER,"根据旅客信息创建PNR及订单"),
	ROUTE_FLIGHT_SUPP_ORDER_PAY(Path.ROUTE_FLIGHT_SUPP_ORDER_PAY,"路由供应商订单支付"),
	ROUTE_GET_FLIGHT_TICKET_RULE(Path.ROUTE_GET_FLIGHT_TICKET_RULE,"获取客规信息"),
    ROUTE_CANCEL_ORDER(Path.ROUTE_CANCEL_ORDER,"路由订单取消"),
	ROUTE_GET_SUPPORDER_BY_ORDER_NO(Path.ROUTE_GET_SUPPORDER_BY_ORDER_NO,"路由根据订单号查询供应商订单"),
	ROUTE_APPLY_SUPP_ORDER_REFUND(Path.ROUTE_APPLY_SUPP_ORDER_REFUND,"路由向供应商申请退废票"),
    ROUTE_GET_REFUND_DETAIL(Path.ROUTE_GET_REFUND_DETAIL,"路由根据退废票单号查询退废票详情"),
    ROUTE_FLIGHT_REVISE_CONDITION(Path.ROUTE_FLIGHT_REVISE_CONDITION,"路由原生国内机票可退票/改签查询"),
    ROUTE_RESCHEDULE_SEARCH(Path.ROUTE_RESCHEDULE_SEARCH, "国内机票可改航班查询"),
    ROUTE_CREATE_PNR(Path.ROUTE_CREATE_PNR,"根据旅客信息创建PNR信息"),
    ROUTE_XE_PNR(Path.ROUTE_XE_PNR,"路由取消PNR"),
    ROUTE_AVH(Path.ROUTE_AVH,"查询航班可销售信息"),
    ROUTE_AVETIME(Path.ROUTE_AVETIME,"按时间查询航班可销售信息"),
    ROUTE_NFD(Path.ROUTE_NFD,"查询特殊运价信息"),
    ROUTE_NFDBATCH(Path.ROUTE_NFDBATCH, "ftp批量获取特殊运价信息"),
    ROUTE_PATA(Path.ROUTE_PATA,"路由PATA"),
    ROUTE_FD(Path.ROUTE_FD,"查询普通运价信息"),
    ROUTE_FDBATCH(Path.ROUTE_FDBATCH, "ftp批量获取普通运价信息"),
    ROUTE_AUTO_CHANGE_APPLY(Path.ROUTE_AUTO_CHANGE_APPLY,"向供应商申请改签"),
	ROUTE_RT_PNR(Path.ROUTE_RT_PNR, "路由解析PNR"),
	ROUTE_RT_PNR_BATCH(Path.ROUTE_RT_PNR_BATCH, "路由批量解析PNR");
 
	/** Adapter路由Resource对应枚举(以ROUTE开头)END **/
	
	public String path;
	public String cnName;
	
	public static class Path{
		
		public final static String basePath="adapter/";
		public final static String routePath = "route/";
		
		public final static String GET_FLIGHT_SEAT_BY_FLIGHT_NO=basePath+"flight/info/getFlightSeatByFlightNo";
		public final static String GET_POLICY_AND_FARE_BY_FIIGHTS=basePath+"flight/verify/getPolicyAndFareByFlights";
		public final static String GET_CHILD_POLICY_AND_FIIGHT=basePath+"flight/verify/getChildPolicyAndFlight";
		public final static String GET_AVAILABLE_FLIGHT_WITH_PRICE_AND_COMMISION=basePath+"flight/info/getAvailableFlightWithPriceAndCommision";
		public final static String GET_AVAILABLE_FLIGHT_WITH_PRICE=basePath+"flight/info/getAvailableFlightWithPrice";
		public final static String GET_POLICY=basePath+"flight/policy/getPolicy/{page}";
		public final static String SYNC_POLICY=basePath+"flight/policy/syncPolic/{suppPolicyNo}/{lastUpdateTime}";
		public final static String GET_POLICY_BY_ID=basePath+"flight/policy/getPolicyById/{suppPolicyNo}";
		public final static String GET_TICKET_RULE=basePath+"flight/ticketrule/all";
		public final static String GET_TICKET_RULE_BY_CONDITION=basePath+"flight/ticketrule/searchByCond";
		public final static String CREATE_ORDER=basePath+"flight/booking/createOrder";
		public final static String GET_SUPPORDER_BY_ORDER_NO=basePath+"flight/order/info/getSuppOrderByOrderNo/{suppOrderNo}";
		public final static String CANCELORDER=basePath+"flight/order/cancelOrder/{suppOrderNo}/{cancelPNR}";
		public final static String PAY=basePath+"pay/{suppOrderLvNo}/{suppOrderNo}";
		public final static String APPLY_POLICY_ORDER_REFUND=basePath+"flight/ticket/applyPolicyOrderRefund";
		public final static String GET_REFUND_DETAIL=basePath+"ticket/getRefundDetail";
		public final static String GET_DAILY_LOWEST_PRICE = basePath+"flightDailyLowestPrice/getDailyLowestPrice";
		public final static String APPLY_INSURANCE_SINGLE_INSURING = basePath+"insurance/unionLife/singleInsuring";
		public final static String APPLY_INSURANCE_HESITATE_CANCEL = basePath+"insurance/unionLife/hesitateCancel";
		public final static String QUERY_INSURANCE_SUPP = basePath+"insurance/unionLife/getSuppInsurance{insuranceOrderNo}";
		public final static String GET_BOOKING_RESULT = basePath+"flight/booking/getBookingResult";
		public final static String CTRIP_ORDER_PAY = basePath+"ctripPay";
		public final static String APPLY_CHANGE =basePath+"flight/ticket/applyChange";
		public final static String FIVE17NA_VERIFY_SEAT_AND_PRICE = basePath+"five17Na/verifySeatAndPrice";
		public final static String FIVE17NA_CANCEL_PNR = basePath+"five17Na/cancelPnr";
		public final static String FIVE17NA_SYNC_POLICY_PUSH_FULL = basePath + "five17Na/syncPolicyPushFull";
		public final static String FIVE17NA_SYNC_POLICY_PUSH_ADD = basePath + "five17Na/syncPolicyPushAdd"; 
		public final static String ABE_CREATE_PNR_BY_SUPPORDER = basePath+"abe/createpnr";
		/** Adapter路由Resource路径(以ROUTE开头)START **/
		public final static String ROUTE_QUERY_FLIGHT_INFO = basePath + routePath + "queryFlightInfo/{suppCode}";
		public final static String ROUTE_VERIFY_SEAT_AND_PRICE = basePath + routePath + "verifySeatAndPrice/{suppCode}";
		public final static String ROUTE_CREATE_ORDER = basePath + routePath + "createOrder/{suppCode}";
		public final static String ROUTE_FLIGHT_SUPP_ORDER_PAY = basePath + routePath + "pay/{suppCode}";
		public final static String ROUTE_GET_FLIGHT_TICKET_RULE = basePath + routePath + "getFlightTicketRule";
        public final static String ROUTE_CANCEL_ORDER = basePath + routePath + "cancelOrder";
        public final static String ROUTE_GET_SUPPORDER_BY_ORDER_NO = basePath + routePath +"flight/order/info/getSuppOrderByOrderNo";
        public final static String ROUTE_APPLY_SUPP_ORDER_REFUND = basePath + routePath + "flight/ticket/applySuppOrderRefund/{suppCode}";
        public final static String ROUTE_GET_REFUND_DETAIL = basePath + routePath + "ticket/getRefundDetail/{suppCode}";
        public final static String ROUTE_FLIGHT_REVISE_CONDITION = basePath + routePath + "flightReviseCondition/{suppOrderNo}";
        public final static String ROUTE_RESCHEDULE_SEARCH = basePath + routePath + "rescheduleSearch";
        public final static String ROUTE_AUTO_CHANGE_APPLY = basePath + routePath+"flight/ticket/autoApplyChange";
        public final static String ROUTE_CREATE_PNR = basePath + routePath + "createPnr";
        public final static String ROUTE_XE_PNR = basePath + routePath + "xePnr/{suppCode}";
        public final static String ROUTE_AVH = basePath + routePath + "avh";
        public final static String ROUTE_AVETIME = basePath + routePath + "avetime";
        public final static String ROUTE_NFD = basePath + routePath + "nfd";
        public final static String ROUTE_NFDBATCH = basePath + routePath + "nfdbatch";
        public final static String ROUTE_PATA = basePath + routePath + "pata";
        public final static String ROUTE_FD = basePath + routePath + "fd";
        public final static String ROUTE_FDBATCH = basePath + routePath + "fdbatch";
		public final static String ROUTE_RT_PNR = basePath + routePath + "rtPnr/{suppCode}";
		public final static String ROUTE_RT_PNR_BATCH = basePath + routePath + "rtPnrBatch/{suppCode}";

		/** Adapter路由Resource路径(以ROUTE开头)END **/
	}

	private AdapterClientPath(String path, String cnName) {
		this.path = path;
		this.cnName = cnName;
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
