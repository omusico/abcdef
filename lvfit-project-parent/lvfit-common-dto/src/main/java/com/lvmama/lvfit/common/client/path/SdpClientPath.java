package com.lvmama.lvfit.common.client.path;

import com.lvmama.lvf.common.utils.CustomizedPropertyPlaceholderConfigurer;
import com.lvmama.lvfit.common.client.path.SdpAppClientPath.Path;



public enum SdpClientPath {
	
    PACKAGE_PRODUCT_BASIC_INFO_SEARCH(Path.PACKAGE_PRODUCT_BASIC_INFO_SEARCH, "获取打包产品基本信息"),
    PACKAGE_PRODUCT_BASIC_INFO_SEARCH_PREVIEW(Path.PACKAGE_PRODUCT_BASIC_INFO_SEARCH_PREVIEW, "获取预览打包产品基本信息"),
    PACKAGE_PRODUCT_INFO_ONLY_SEARCH(Path.PACKAGE_PRODUCT_INFO_ONLY_SEARCH, "仅仅获取打包产品信息不含附加信息"),
    PACKAGE_GOODS_INFO_SEARCH(Path.PACKAGE_GOODS_INFO_SEARCH, "获取打包商品信息"),
    TRAFFIC_FLIGHTS_SEARCH(Path.TRAFFIC_FLIGHTS_SEARCH,"获取交通规则过滤后的去返程航班列表"),
    PRODUCT_CLENDAR_SEARCH(Path.PRODUCT_CLENDAR_SEARCH,"获取被打包产品的价格日历信息"),
    CALCULAT_SHOPPING_AMOUNT(Path.CALCULAT_SHOPPING_AMOUNT,"计算购物车总金额"),
    CALCULAT_SHOPPING_AMOUNT_BY_DETAIL(Path.CALCULAT_SHOPPING_AMOUNT_BY_DETAIL,"根据明细计算商品总金额"),
    CHANGE_HOTEL_COMBO(Path.CHANGE_HOTEL_COMBO, "更换酒店套餐"),
    CHANGE_HOTEL_GROUP(Path.CHANGE_HOTEL_GROUP, "更换酒店"),
    CHANGE_FLIGHT(Path.CHANGE_FLIGHT, "更换航班"),
    GET_SHOPPING_BY_UUID(Path.GET_SHOPPING_BY_UUID,"从缓存中加载数据"),
    BOOKING(Path.BOOKING, "预定"),
    BOOKING_BY_DETAIL(Path.BOOKING_BY_DETAIL, "预定"),
    SAVE_GOODS_TO_CACHE(Path.SAVE_GOODS_TO_CACHE, "保存选择的商品信息"),
    CONTRACTS(Path.CONTRACTS,"获取合同信息"),
    SEARCH_CALENDAR_INFO_BY_PRODUCT_ID(Path.SEARCH_CALENDAR_INFO_BY_PRODUCT_ID,"根据产品Id获取每个出发地对应的低价信息"),
    APP_UPDATE_GOODS_TO_CACHE(Path.APP_UPDATE_GOODS_TO_CACHE,"更新商品缓存数据");
    
	public String path;
	
	public String cnName;

	private SdpClientPath(String path, String cnName) {
		this.path = path;
		this.cnName = cnName;
	}


	public static class Path{
		
		public final static String basePath = "sdp/";
		public final static String shoppingPath = "shopping/";
		 /** 打包产品的产品信息 */
        public static final String PACKAGE_PRODUCT_BASIC_INFO_SEARCH = basePath + "packageProductSearch/{productId}";
        /** 打包产品的产品信息 */
        public static final String PACKAGE_PRODUCT_BASIC_INFO_SEARCH_PREVIEW = basePath + "packageProductSearchPreview/{productId}";
        /** 仅仅获取打包产品的基本信息 */
        public static final String PACKAGE_PRODUCT_INFO_ONLY_SEARCH = basePath + "packageProductOnlySearch/{productId}";
        /** 打包产品的商品信息 */
        public static final String PACKAGE_GOODS_INFO_SEARCH = basePath + "packageGoodsSearch";
        /** 打包产品的可选航班列表信息 */
        public static final String TRAFFIC_FLIGHTS_SEARCH = basePath + "flights/search";
        /** 主站获取被打包产品的价格信息*/
        public static final String PRODUCT_CLENDAR_SEARCH = basePath + "productCalendar/search";
        /** 计算购物车总价格*/
        public static final String CALCULAT_SHOPPING_AMOUNT = basePath + shoppingPath +"calculateAmount";
        /** 计算App商品总金额*/
        public static final String CALCULAT_SHOPPING_AMOUNT_BY_DETAIL = basePath + shoppingPath +"calculateAmountByDetail";
        /** 更换酒店套餐 */
        public static final String CHANGE_HOTEL_COMBO = basePath + "changeHotelCombo";
        /** 更换酒店 */
        public static final String CHANGE_HOTEL_GROUP = basePath + "changeHotelGroup";
        /** 更换航班 */
        public static final String CHANGE_FLIGHT = basePath + "changeFlight";
        /** 从缓存中获取数据*/
        public static final String GET_SHOPPING_BY_UUID = basePath + shoppingPath + "getShoppingByUUID";
        /** 预定*/
        public static final String BOOKING = basePath + "booking";
        /** 预定for App*/
        public static final String BOOKING_BY_DETAIL = basePath + "bookingByDetail";
        /** 保存选择的商品信息到缓存 */
        public static final String SAVE_GOODS_TO_CACHE = basePath + "saveGoodsToCache";
        /** 获取合同信息*/
        public static final String CONTRACTS = basePath + "getContracts";
        
   	    /** 打包产品的产品信息 */
        public static final String SEARCH_CALENDAR_INFO_BY_PRODUCT_ID = basePath + "searchCalendarInfoByProductId/{productId}";
        
        /** 更新商品缓存数据 */
        public static final String  APP_UPDATE_GOODS_TO_CACHE = basePath + "updateGoodsToCache";
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
