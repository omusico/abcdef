package com.lvmama.lvf.common.client.path;

import com.lvmama.lvf.common.utils.CustomizedPropertyPlaceholderConfigurer;

/**
 * 
 * @author lutianyu
 * @date   2015-2-14
 */
public enum VstClientPath {
	/**VST查看乘机人信息  -------Start */
	GET_ORDER_PASSENGERINFO_BY_USER_ID(Path.GET_ORDER_PASSENGERINFO_BY_USER_ID,"根据用户id查找相关联系人"),
	SAVE_ORDER_PASSENGERINFO(Path.SAVE_ORDER_PASSENGERINFO,"根据用户id添加修改相关联系人"),
	GET_USER_RECEIVERS_BY_USER_ID(Path.GET_USER_RECEIVERS_BY_USER_ID,"根据用户id查找相关联系人"),
	SAVE_USER_EXPRESS_ADDRESS(Path.SAVE_USER_EXPRESS_ADDRESS,"保存常用快递地址"),
	/**VST查看乘机人信息  -------end */
	
	/** 登录用户信息  */
	GET_USER_BY_LVSESSION_ID(Path.GET_USER_BY_LVSESSION_ID,"根据lvSessionId获取登录用户信息"),
	SAVE_ORDER_PASSENGER_INFO(Path.SAVE_ORDER_PASSENGER_INFO,"保存用户联系人信息"),
	
	/** 获取ip信息 */
	GET_COM_IPS(Path.GET_COM_IPS,"获取ip信息"),
	/** 获取头信息 */
	GET_COMM_HEADER(Path.GET_COMM_HEADER, "获取公用头信息"),
	ORDER_SUCCESS_AUDIT(Path.ORDER_SUCCESS_AUDIT,"下单成功审核"),
	/** 登录用户的收货地址  */
	QUERY_ADDRESS_BY_USERNO(Path.QUERY_ADDRESS_BY_USERNO, "获取登录用户下的收货地址信息"),
	SAVE_OR_UPDATE_ADDRESS(Path.SAVE_OR_UPDATE_ADDRESS,"保存登录用户的收货地址信息"),
	
	/**VST查看会员信息  -------Start */
	GET_USER_PROXY_LIST(Path.GET_USER_PROXY_LIST,"根据用户名称查询会员列表"),
	GET_REGIST_USER_INFO(Path.GET_REGIST_USER_INFO,"根据电话号码查询注册用户"),
	GET_USER_BY_USER_NO(Path.GET_USER_BY_USER_NO,"根据用户NO取用户信息"),
	GET_USER_BY_PK_USER_ID(Path.GET_USER_BY_PK_USER_ID,"根据用户id查询用户信息"),
	/**VST查看会员信息  -------End */
	
	/**VST产品 */
	SAVE_UPDATE_PRODUCT(Path.SAVE_UPDATE_PRODUCT,"vst端，新增或更新vst产品"),
	ADD_PRODUCT(Path.ADD_PRODUCT,"增加VST产品"),
	UPDATE_PRODUCT(Path.UPDATE_PRODUCT,"修改VST产品"),
	UPDATE_PRODUCT_STATUS(Path.UPDATE_PRODUCT_STATUS,"更新VST产品状态"),
	
	/**VST商品 */
	SAVE_UPDATE_GOODS(Path.SAVE_UPDATE_GOODS,"保存或更新VST商品"),
	ADD_GOODS(Path.ADD_GOODS,"增加VST商品"),
	UPDATE_GOODS(Path.UPDATE_GOODS,"修改VST商品"),
	UPDATE_GOODS_STATUS(Path.UPDATE_GOODS_STATUS,"更新VST商品状态"),
	
	/**VST基础航班*/
	ADD_BIZ_FLIGHT(Path.ADD_BIZ_FLIGHT,"增加VST基础航班"),
	UPDATE_BIZ_FLIGHT(Path.UPDATE_BIZ_FLIGHT,"修改VST基础航班"),
	ADD_ONE_BIZ_FLIGHT(Path.ADD_ONE_BIZ_FLIGHT,"增加一个VST基础航班"),
	UPDATE_ONE_BIZ_FLIGHT(Path.UPDATE_ONE_BIZ_FLIGHT,"修改一个VST基础航班"),
	
	/**发送退款请求到VST支付中心*/
	REFUND_TO_VST(Path.REFUND_TO_VST,"发送退款请求到VST支付中心"),
	GET_PAYMENT_URL(Path.GET_PAYMENT_URL,"获取订单支付的url"),
	
	/** 保存或更新商品时间价格*/
	SAVE_OR_UPDATE_GOODS_TIME_PRICE(Path.SAVE_OR_UPDATE_GOODS_TIME_PRICE,"保存或更新商品时间价格"),
	
	/**VST端，新增或更新vst产品规格*/
	SAVE_UPDATE_PRODUCT_BRANCH(Path.SAVE_UPDATE_PRODUCT_BRANCH,"vst端，新增或更新vst产品规格"),
	/**更新产品规格 */
	UPDATE_PRODUCT_BRANCH(Path.UPDATE_PRODUCT_BRANCH,"更新产品规格"),
	/**更新产品规格有效性*/
	UPDATE_PRODUCT_BRANCH_ACTIVE_STATUS(Path.UPDATE_PRODUCT_BRANCH_ACTIVE_STATUS,"更新产品规格有效性"),
	/**增加一个产品规格 */
	ADD_ONE_PRODUCT_BRANCH(Path.ADD_ONE_PRODUCT_BRANCH,"增加一个产品规格"),
	/**增加产品规格 */
	ADD_PRODUCT_BRANCH(Path.ADD_PRODUCT_BRANCH,"增加产品规格"),
	
	/**更新产品航班信息*/
	UPDATE_TRAFFIC_FLIGHT_PRODUCT(Path.UPDATE_TRAFFIC_FLIGHT_PRODUCT,"更新产品航班信息"),
	/** 更新产品航班信息的有效性*/
	UPDATE_TRAFFIC_FLIGHT_PRODUCT_ACTIVE_STATUS(Path.UPDATE_TRAFFIC_FLIGHT_PRODUCT_ACTIVE_STATUS,"更新产品航班信息的有效性"),
	/**增加产品航班信息*/
	ADD_TRAFFIC_FLIGHT_PRODUCT(Path.ADD_TRAFFIC_FLIGHT_PRODUCT,"增加产品航班信息"),
	/**增加产品航班信息*/
	ADD_PRODUCT_FLIGHT(Path.ADD_PRODUCT_FLIGHT,"增加产品航班信息"),
	/**更新产品航班信息*/
	UPDATE_PRODUCT_FLIGHT(Path.UPDATE_PRODUCT_FLIGHT,"更新产品航班信息"),
	
	/**vst出票通知*/
	FLIGHT_ORDER_TICKET_ISSUE_CALLBACK(Path.FLIGHT_ORDER_TICKET_ISSUE_CALLBACK,"vst出票通知"),
	
	/**调用vst退款接口*/
	ORDER_ONLINE_REFUND_CLIENT(Path.ORDER_ONLINE_REFUND_CLIENT,"调用vst退款接口，返回结果"),
	
	/**vst退款接口，返回结果*/
	FLIGHT_ORDER_REFUND_VST(Path.FLIGHT_ORDER_REFUND_VST,"vst退款接口，返回结果"),
	
	/**短信发送*/
	SEND_SMS(Path.SEND_SMS,"短信发送"),
	SMS_GROUP_SEND(Path.SMS_GROUP_SEND,"短信发送"),
	/**vst订单同步*/
	ORDER_SYNC(Path.ORDER_SYNC,"vst订单同步"),
	DELETE_VST_ORDER(Path.DELETE_VST_ORDER,"删除vst订单"),
	GET_VST_ORDER(Path.GET_VST_ORDER,"获取vst订单"),
	QUERY_CITY_ADDRESS_LIST(Path.QUERY_CITY_ADDRESS_LIST,"获取城市列表(省-市-区)"),
	FIND_DICT_PROP_LIST(Path.FIND_DICT_PROP_LIST,"根据条件查询VST字典属性列表"),
	ADD_PRODUCT_BY_AIRLINE(Path.ADD_PRODUCT_BY_AIRLINE,"根据航线增加VST产品"),
	UPDATE_PRODUCT_BY_AIRLINE(Path.UPDATE_PRODUCT_BY_AIRLINE,"根据航线更新VST产品"),
	SAVE_PRODUCT_BRANCH_BY_AIRLINE(Path.SAVE_PRODUCT_BRANCH_BY_AIRLINE,"根据航线增加或更新航线"),
	SAVE_TRAFFIC_FLIGHT_BY_AIRLINE(Path.SAVE_TRAFFIC_FLIGHT_BY_AIRLINE,"根据航线新增或更新VST产品航班"),

	/**根据登录用户名查询vst登录用户信息*/
	QUERY_VST_PERMUSER_BY_USERNAME(Path.QUERY_VST_PERMUSER_BY_USERNAME,"根据登录用户名查询vst登录用户信息"),
	
	FLIGHT_ORDER_BOOKING_ORDER_RESULT_CALLBACK(Path.FLIGHT_ORDER_BOOKING_ORDER_RESULT_CALLBACK,"VST异步预订回调通知（单个结果）"),
	FLIGHT_ORDER_BOOKING_ORDER_RESULTS_CALLBACK(Path.FLIGHT_ORDER_BOOKING_ORDER_RESULTS_CALLBACK,"VST异步预订回调通知（多个结果）"),
	
	SEND_SETTLEMENT_TO_VST(Path.SEND_SETTLEMENT_TO_VST,"结算推送"),
	
	GET_REFUNDMENT_SERIALNO(Path.GET_REFUNDMENT_SERIALNO,"获取退款流水号"),
	/**根据vst主单号和子单号获取vst订单(子单号可选)，再转为锁舱请求对象*/
	GET_VST_ORDER_INFO(Path.GET_VST_ORDER_INFO, "获取vst订单"),
	ONE_STEP_BOOKING(Path.ONE_STEP_BOOKING, "Vst一键打包补单"),
	QUERY_BOOKING_SOURCE(Path.QUERY_BOOKING_SOURCE, "获取订单来源"),
	
	/**优惠券*/
	GET_NOTUSED_USERCOUPONS(Path.GET_NOTUSED_USERCOUPONS,"获取未使用优惠券"),
	GET_ORDER_USERCOUPONS(Path.GET_ORDER_USERCOUPONS,"获取用户下所有满足该笔订单优惠券"),
	GET_ORDERCOUPONS(Path.GET_ORDERCOUPONS,"获取用户下所有满足该笔订单优惠券(需要优惠券码)"),
	USERCOUPONS(Path.USERCOUPONS,"使用优惠券"),
	ROLLBACK_COUPONS(Path.ROLLBACK_COUPONS,"回滚优惠券"),
	COUPON_BINDUSER(Path.COUPON_BINDUSER,"优惠券绑定用户");

	
	public String path;
	public String cnName;
	
	public static class Path{
		public final static String basePath="vst";
		public final static String payPath="/pay/";
		
		/**Vst查询常用联系人信息*/
		public final static String GET_ORDER_PASSENGERINFO_BY_USER_ID = basePath + "/getOrderPassengersByUserId/{userId}";
		/**Vst添加，修改常用联系人信息*/
		public final static String SAVE_ORDER_PASSENGERINFO = basePath + "/saveOrderPassengerInfo";
		public final static String GET_USER_RECEIVERS_BY_USER_ID=basePath+"/userReceivers/{userId}/{searchType}";
		/**Vst会员信息操作*/
		public final static String SAVE_USER_EXPRESS_ADDRESS = basePath+"/userReceivers/saveExpressAddress";
		public final static String GET_USER_PROXY_LIST=basePath+"/getUserProxyList";
		public final static String GET_REGIST_USER_INFO = basePath+"/getRegistUserInfo";
		public final static String GET_USER_BY_USER_NO=basePath+"/getUserByUserNo/{userNo}";
		public final static String GET_USER_BY_PK_USER_ID = basePath+"/getUserByPkUserId/{userId}";
		
		/**登录用户信息 */
		public final static String GET_USER_BY_LVSESSION_ID = basePath+"/getUserByLvSessionId";
		public final static String SAVE_ORDER_PASSENGER_INFO = basePath+"/saveOrderPassengerInfo";
		
		public final static String GET_COM_IPS = basePath+"/getComIps";
		public final static String GET_COMM_HEADER = basePath+"/GetCommHeader";
		public final static String ORDER_SUCCESS_AUDIT = basePath+"/orderSuccessAudit";
		
		/** 登录用户的邮寄地址 */
		public final static String QUERY_ADDRESS_BY_USERNO = basePath+"/getMailAddressByUserNo";
		public final static String SAVE_OR_UPDATE_ADDRESS = basePath+"/saveOrUpdateAddress";
		
		/**VST产品 */
		public final static String SAVE_UPDATE_PRODUCT = basePath + "/product/saveOrUpdateProduct";
		public final static String ADD_PRODUCT = basePath+"/product/addProduct";
		public final static String UPDATE_PRODUCT = basePath+"/product/updateProduct";
		public final static String UPDATE_PRODUCT_STATUS = basePath+"/product/updateProductStatus";
		
		/**VST商品*/
		public final static String SAVE_UPDATE_GOODS = basePath+"/goods/saveOrUpdateGoods";
		public final static String ADD_GOODS = basePath+"/goods/addGoods";
		public final static String UPDATE_GOODS = basePath+"/goods/updateGoods";
		public final static String UPDATE_GOODS_STATUS = basePath+"/goods/updateGoodsStatus";
		
		/**VST基础航班*/
		public final static String ADD_BIZ_FLIGHT = basePath+"/bizFlight/addBizFlight";
		public final static String UPDATE_BIZ_FLIGHT = basePath+"/bizFlight/updateBizFlight";
		public final static String ADD_ONE_BIZ_FLIGHT = basePath+"/bizFlight/addOneBizFlight";
		public final static String UPDATE_ONE_BIZ_FLIGHT = basePath+"/bizFlight/updateOneBizFlight";
		
		/**保存或更新商品时间价格 */
		public final static String SAVE_OR_UPDATE_GOODS_TIME_PRICE = basePath+"/goodsTimePrice/saveOrUpdateGoodsTimePrice";
		
		/**产品规格*/
		public final static String SAVE_UPDATE_PRODUCT_BRANCH= basePath + "/productBranch/saveOrUpdateProductBranch";
		/**增加一个产品规格 */
		public final static String ADD_ONE_PRODUCT_BRANCH = basePath+"/productBranch/addOneProductBranch";
		/**增加产品规格 */
		public final static String ADD_PRODUCT_BRANCH = basePath+"/productBranch/addProductBranch";
		/**更新产品规格*/
		public final static String UPDATE_PRODUCT_BRANCH = basePath+"/productBranch/updateProductBranch";
		/**更新产品规格有效性*/
		public final static String UPDATE_PRODUCT_BRANCH_ACTIVE_STATUS = basePath+"/productBranch/updateActiveStatus";
		
		/**增加产品航班信息 */
		public final static String ADD_TRAFFIC_FLIGHT_PRODUCT = basePath+"/trafficFlight/addTrafficProduct";
		/**更新产品航班信息*/
		public final static String UPDATE_TRAFFIC_FLIGHT_PRODUCT = basePath+"/trafficFlight/updateTrafficProduct";
		/**更新产品航班信息的有效性*/
		public final static String UPDATE_TRAFFIC_FLIGHT_PRODUCT_ACTIVE_STATUS = basePath+"/trafficFlight/updateActiveStatus";
		/**增加产品航班信息 */
		public final static String ADD_PRODUCT_FLIGHT = basePath+"/trafficFlight/addProductFlight";
		/**更新产品航班信息*/		
		public final static String UPDATE_PRODUCT_FLIGHT = basePath+"/trafficFlight/updateProductFlight";
		
		/**调用支付中退款接口*/
        public static final String ORDER_ONLINE_REFUND_CLIENT ="http://pay.lvmama.com/payment/pay/trainRefund.do";
       
        /**调用支付中退款接口*/
        public static final String FLIGHT_ORDER_REFUND_VST =basePath+"/refundOnlineToVst";
        
        /**调用支付中退款接口*/
        public static final String REFUND_TO_VST =basePath+payPath+"refundToVst";
   
   	 	/** 获取调用主站支付的url */
        public static final String GET_PAYMENT_URL = basePath+payPath+"getPaymentUrl";
        
		/**vst出票通知*/
		public final static String FLIGHT_ORDER_TICKET_ISSUE_CALLBACK = basePath + "/flight/ticketIssue/flightOrderTicketIssueCallback";
		
		/**短信发送*/
		public final static String SEND_SMS = basePath + "/flight/sendSms";
		
		public final static String SMS_GROUP_SEND = basePath + "/flight/smsBatchSend";
		
		/**订单同步*/
		public final static String ORDER_SYNC = basePath + "/flight/orderSync";
		public final static String DELETE_VST_ORDER = basePath + "/flight/deleteOrder";
		public final static String GET_VST_ORDER = basePath + "/flight/getOrder";
		
		/**查询获取VST字典属性列表*/
		public final static String FIND_DICT_PROP_LIST = basePath + "/vstBizDictProp/findDictPropList";
		
		public final static String ADD_PRODUCT_BY_AIRLINE = basePath + "/vstProduct/addProductsByAirline";
		
		public final static String UPDATE_PRODUCT_BY_AIRLINE = basePath + "/vstProduct/updateProductsByAirline";
		
		public final static String SAVE_PRODUCT_BRANCH_BY_AIRLINE = basePath + "/vstProduct/saveProductBranchByAirline";
		
		public final static String SAVE_TRAFFIC_FLIGHT_BY_AIRLINE = basePath + "/vstTrafficFlight/saveProductTrafficFlight";

		/**根据登录用户名查询vst登录用户信息*/
		public final static String QUERY_VST_PERMUSER_BY_USERNAME = basePath + "/queryVstPermUserByUserName/{userName}";
		
		public final static String FLIGHT_ORDER_BOOKING_ORDER_RESULT_CALLBACK = basePath + "/flight/bookingResultCallback";
		
		public final static String FLIGHT_ORDER_BOOKING_ORDER_RESULTS_CALLBACK = basePath + "/flight/bookingResultsCallback";
		
		/**结算推送*/
		public final static String SEND_SETTLEMENT_TO_VST = basePath + "/sendSettlementToVst";
		
		public final static String QUERY_CITY_ADDRESS_LIST = basePath  + "/getCityAddressList";
		
		public final static String COUPON_BINDUSER = basePath + "/couponBindUser";
		public final static String GET_NOTUSED_USERCOUPONS = basePath + "/getNotUsedUserCoupons";
		public final static String GET_ORDER_USERCOUPONS = basePath + "/getOrderUserCoupons";
		public final static String GET_ORDERCOUPONS = basePath + "/getOrderCoupons";
		public final static String USERCOUPONS = basePath + "/userCoupons";
		public final static String ROLLBACK_COUPONS = basePath + "/rollbackCoupons";
		
		/**获取退款流水号*/
		public final static String GET_REFUNDMENT_SERIALNO = basePath+payPath+"getRefundmentSerialNo";
		public final static String GET_VST_ORDER_INFO = basePath + "/getVstOrderInfo";
		public final static String ONE_STEP_BOOKING = basePath + "/oneStepBooking";
		public final static String QUERY_BOOKING_SOURCE = basePath + "/queryBookingSource";
	}

	private VstClientPath(String path, String cnName) {
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

