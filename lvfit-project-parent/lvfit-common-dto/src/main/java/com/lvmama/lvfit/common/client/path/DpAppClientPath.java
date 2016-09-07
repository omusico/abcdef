package com.lvmama.lvfit.common.client.path;

import com.lvmama.lvf.common.utils.CustomizedPropertyPlaceholderConfigurer;

public enum DpAppClientPath {


	APP_SEARCH_FLIGHT_CITY_INFO(Path.APP_SEARCH_FLIGHT_CITY_INFO,"查询城市信息及热门城市信息"),
	APP_SEARCH_GOODS_INFO(Path.APP_SEARCH_GOODS_INFO,"查询详情页商品信息"),
	APP_CHANGE_FLIGHT_INFO(Path.APP_CHANGE_FLIGHT_INFO,"更换航班信息"),
	APP_CHANGE_HOTEL_INFO(Path.APP_CHANGE_HOTEL_INFO,"更换酒店信息"),
	APP_CALCULAT_AMOUNT(Path.APP_CALCULAT_AMOUNT,"计算商品总金额"),
	APP_BOOKING(Path.APP_BOOKING, "预定");

	public String path;

	public String cnName;

	private DpAppClientPath(String path, String cnName) {
		this.path = path;
		this.cnName = cnName;
	}
	
	
	public static class Path{

		public final static String basePath = "dp/app/";

		/** 查询城市信息及热门城市信息*/
		public static final String APP_SEARCH_FLIGHT_CITY_INFO = basePath +"searchFlightCityInfo";

		/** 查询详情页商品信息*/
		public static final String APP_SEARCH_GOODS_INFO = basePath + "searchGoodsInfo";

		/** 更换航班信息 */
		public static final String APP_CHANGE_FLIGHT_INFO = basePath +"changeFlightInfo";

		/** 更换酒店信息*/
		public static final String APP_CHANGE_HOTEL_INFO = basePath + "changeHotelInfo";

		/** APP计算购物车总价格*/

		public static final String APP_CALCULAT_AMOUNT = basePath +"calculateAmount";
		/** 预定*/
		public static final String APP_BOOKING = basePath + "booking";

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
