package com.lvmama.lvfit.common.client.path;

import com.lvmama.lvf.common.utils.CustomizedPropertyPlaceholderConfigurer;
import com.lvmama.lvfit.common.client.path.BussinessClientPath.Path;

public enum VstClientPath {
	/** VST产品 */
	GET_VST_PRODUCT_DETAIL(Path.GET_VST_PRODUCT_DETAIL, "VST产品详情"), 
	QUERY_VST_PRODUCT_LIST(Path.QUERY_VST_PRODUCT_LIST, "VST产品列表"),

	/** VST商品 */
	GET_VST_GOODS_DETAIL(Path.GET_VST_GOODS_DETAIL,"根据商品Id获取商品详情"),QUERY_VST_GOODS_PRICE_LIST(Path.QUERY_VST_GOODS_PRICE_LIST,"根据商品id获取价格列表"),QUERY_VST_GOODS_BRANCH_LIST(Path.QUERY_VST_GOODS_BRANCH_LIST,"根据产品id查询产品规格及商品信息"),
	/** VST点评 */
	QUERY_VST_COMMENT_LIST(Path.QUERY_VST_COMMENT_LIST,"VST酒店点评分页查询"),
	
	QUERY_VST_COMMENT_STATISTICS_BYPROUCTID(Path.QUERY_VST_COMMENT_STATISTICS_BYPROUCTID,"根据产品ID点评数据统计"),QUERY_VST_COMMENT_STATISTICS_BYPLACEID(Path.QUERY_VST_COMMENT_STATISTICS_BYPLACEID,"根据目的地ID点评数据统计"),

	/**VST订单**/
	VST_ORDER_CREATE(Path.VST_ORDER_CREATE,"VST创建订单"),
	VST_ORDER_CANCEL(Path.VST_ORDER_CANCEL,"VST取消订单"),
	VST_ORDER_COUNT_PRICE(Path.VST_ORDER_COUNT_PRICE,"VST计算价格"),
	QUERY_VST_ORDER(Path.QUERY_VST_ORDER,"查询VST订单"),
	/**
	 * VST联系人
	 */
	SAVE_ORDER_PASSENGER_INFO(Path.SAVE_ORDER_PASSENGER_INFO,"保存联系人"),
	GET_USER_RECEIVERS_BY_USER_ID(Path.GET_USER_RECEIVERS_BY_USER_ID,"根据userId查找常用联系人"),
	GET_USER_BY_LVSESSION_ID(Path.GET_USER_BY_LVSESSION_ID,"根据lvSessionId获取登陆用户信息"),
	GET_USER_RECEIVERS_BY_LVSESSION_ID(Path.GET_USER_RECEIVERS_BY_LVSESSION_ID,"根据lvSessionId获取常用联系人"),

	/** 机票单品 */
	FLIGHT_BOOKING(Path.FLIGHT_BOOKING, "机票单品预定"),
	/**根据VST主单号获取vst主单状态  */
	GET_VST_ORDER_STATUS_BY_VST_ORDER_MAIN_NO(Path.GET_VST_ORDER_STATUS_BY_VST_ORDER_MAIN_NO, "vst订单详情"),
	/** 查询机票单品订单票号 */
	COMPLETE_SUPP_FLIGHT_INFO(Path.COMPLETE_SUPP_FLIGHT_INFO, "补全机票订单号以及票号信息"),

	/** 下单之后： 审核 */
	ORDER_SUCCESS_AUDIT(Path.ORDER_SUCCESS_AUDIT, "下单成功审核"),
	
	/**  保险相关  **/
	INSURANCE_SEARCH(Path.INSURANCE_SEARCH, "交通+x保险相关信息查询"),
	
	/** 获取头信息 */
	GET_COMM_HEADER(Path.GET_COMM_HEADER, "获取公用头信息"),
	
	/** 获取ip信息 */
	GET_COM_IPS(Path.GET_COM_IPS, "获取IP信息"),
	
	GET_FIT_ORDER_MAIN_BY_ORDER_MAIN_NO(Path.GET_FIT_ORDER_MAIN_BY_ORDER_MAIN_NO, "根据VST主单号得到VST主单信息"),
	
	GET_VST_TOTAL_SALES_AMOUNT(Path.GET_VST_TOTAL_SALES_AMOUNT, "根据VST主单号得到VST主单价格");
	
	public String path;
	public String cnName;

	public static class Path {
		public final static String basePath = "vst";
		
		/** Vst 订单成功返回审核页面  */
		public final static String ORDER_SUCCESS_AUDIT = basePath + "/orderSuccessAudit";

		/** Vst添加，修改常用联系人信息 */
		public final static String SAVE_ORDER_PASSENGER_INFO = basePath + "/saveOrderPassengerInfo";
		public final static String GET_USER_RECEIVERS_BY_USER_ID = basePath + "/userReceivers";
		public final static String GET_USER_BY_LVSESSION_ID= basePath + "/getUserByLvSessionId";
		public final static String GET_USER_RECEIVERS_BY_LVSESSION_ID= basePath + "/getUserReceiversLvSessionId";

		/**
		 * VST产品
		 */
		// 产品详情
		public final static String GET_VST_PRODUCT_DETAIL = basePath + "/product/detail";
		// 产品列表
		public final static String QUERY_VST_PRODUCT_LIST = basePath + "/product/list";

		/**
		 * VST商品
		 */
		// 商品详情
		public final static String GET_VST_GOODS_DETAIL = basePath + "/goods/detail";
		// 商品价格
		public final static String QUERY_VST_GOODS_PRICE_LIST = basePath + "/goods/pricelist";
		// 根据产品id去查询商品列表及产品规格
		public final static String QUERY_VST_GOODS_BRANCH_LIST = basePath + "/goods/branchlist";
		
		/**
		 * 点评
		 */
		// 点评分页查询
		public final static String QUERY_VST_COMMENT_LIST = basePath + "/comment/list";
		//根据产品ID点评数据统计
		public final static String QUERY_VST_COMMENT_STATISTICS_BYPROUCTID = basePath + "/comment/statistics/byProductId";
		//根据目的地ID点评数据统计
		public final static String QUERY_VST_COMMENT_STATISTICS_BYPLACEID = basePath + "/comment/statistics/byPriceId";

		/**
		 * VST订单
		 */
		public static final String VST_ORDER_CREATE = basePath + "/order/create";
		public static final String VST_ORDER_CANCEL = basePath + "/order/cancel";
		public static final String VST_ORDER_COUNT_PRICE = basePath + "/order/countPrice";
//		public static final String QUERY_VST_ORDER_BY_ORDER_ID = basePath + "/order/countPrice";
		public static final String QUERY_VST_ORDER = basePath + "/order/query";

		/** 机票单品 */
		public static final String FLIGHT_BOOKING = basePath + "/flight/booking";
		
		/** vst 订单详情 和 状态详情 */
		public static final String GET_VST_ORDER_STATUS_BY_VST_ORDER_MAIN_NO = basePath + "/order/getVstOrderStatusByVstOrderMainNo/{vstOrderMainNo}";
		
		/** 获取头信息 */
		public static final String GET_COMM_HEADER = basePath + "/getCommHeader";
		public static final String GET_COM_IPS = basePath + "/getComIps";

		/** 查询机票单品订单票号 */
		public static final String COMPLETE_SUPP_FLIGHT_INFO = basePath + "/order/completeSuppFlightInfo";
		
		/** 保险相关 */
		public static final String INSURANCE_SEARCH = basePath + "/insurance/insuranceSearch";
		
		public static final String GET_FIT_ORDER_MAIN_BY_ORDER_MAIN_NO = basePath + "/order/getVstMainOrderByOrderMainNo/{vstOrderMainNo}";
		
        public static final String GET_VST_TOTAL_SALES_AMOUNT = basePath + "/getTotalSalesAmount/{vstOrderMainNo}";
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
