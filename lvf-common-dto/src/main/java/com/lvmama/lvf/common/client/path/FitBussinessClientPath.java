package com.lvmama.lvf.common.client.path;

import com.lvmama.lvf.common.utils.CustomizedPropertyPlaceholderConfigurer;

public enum FitBussinessClientPath {


	FLIGHT_CALLBACK_BOOKING(Path.FLIGHT_CALLBACK_BOOKING, " VST测回调机票下单"),
	GET_FLIGHT_BOOKING_ORDER(Path.GET_FLIGHT_BOOKING_ORDER,"根据fit主单号号获取订单航班信息");
	public String path;
	public String cnName;
	
	public static class Path{
		
		public final static String basePath="bussiness/";
		
		public final static String FLIGHT_CALLBACK_BOOKING = basePath + "flightCallBackBooking";
		
		public final static String GET_FLIGHT_BOOKING_ORDER = basePath + "order/queryFlightOrderByVstOrderMainNo";
		
		
	}
	
	private FitBussinessClientPath(String path, String cnName) {
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
