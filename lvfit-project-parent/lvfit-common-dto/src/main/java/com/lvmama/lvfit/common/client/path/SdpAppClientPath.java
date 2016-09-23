package com.lvmama.lvfit.common.client.path;

import com.lvmama.lvf.common.utils.CustomizedPropertyPlaceholderConfigurer;

public enum SdpAppClientPath{

	APP_PRODUCT_CLENDAR_SEARCH(Path.APP_PRODUCT_CLENDAR_SEARCH,"获取被打包产品的价格日历信息"),
	APP_GOODS_INFO_SEARCH(Path.APP_GOODS_INFO_SEARCH, "获取打包商品信息"),
	APP_CALCULAT_AMOUNT(Path.APP_CALCULAT_AMOUNT,"计算商品总金额"),
	APP_PRODUCT_DEPARTCITY_GROUP_INFO(Path.APP_PRODUCT_DEPARTCITY_GROUP_INFO,"出发城市信息"),
	APP_BOOKING(Path.APP_BOOKING, "预定");

	public String path;
	
	public String cnName;

	private SdpAppClientPath(String path, String cnName) {
		this.path = path;
		this.cnName = cnName;
	}
	
	
	public static class Path{

		public final static String basePath = "sdp/app/";
		/** APP获取价格日历信息 */
		public static final String APP_PRODUCT_CLENDAR_SEARCH = basePath + "productCalendar/search";
		/** 打包产品的商品信息 */
		public static final String APP_GOODS_INFO_SEARCH = basePath + "sdpGoodsSearch";
		/** APP计算购物车总价格*/
		public static final String APP_CALCULAT_AMOUNT = basePath +"calculateAmount";
		/** 预定*/
		public static final String APP_BOOKING = basePath + "booking";
		/**出发城市信息*/
		public static final String APP_PRODUCT_DEPARTCITY_GROUP_INFO = basePath + "getSelectDepartCityGroupInfo/{productId}";

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
