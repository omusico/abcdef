package com.lvmama.lvf.common.client.path;

import com.lvmama.lvf.common.utils.CustomizedPropertyPlaceholderConfigurer;

public enum MaindataClientPath {

	QUERY_AIRPLANE_LIST(Path.QUERY_AIRPLANE_LIST,"查询机型列表信息"),
	SAVEORUPDATE_AIRPLANE(Path.SAVEORUPDATE_AIRPLANE,"保存机型信息"),
	QUERY_AIRPLANES_BY_CODE(Path.QUERY_AIRPLANES_BY_CODE,"根据航空公司code获取航空公司列表"),
	GET_BYID_AIRPLANE(Path.GET_BYID_AIRPLANE,"根据ID或等机型信息"),
	QUERY_SEAT_LIST(Path.QUERY_SEAT_LIST,"查找舱位列表"),
	SAVEORUPDATE_SEAT(Path.SAVEORUPDATE_SEAT,"保存舱位信息"),
	GET_BYID_SEAT(Path.GET_BYID_SEAT,"通过ID获得舱位"),
	AIRPORT_CITY_QUERY_LIST(Path.AIRPORT_CITY_QUERY_LIST,"机场城市列表"),
	AIRPORT_CITY_ADD(Path.AIRPORT_CITY_ADD,"添加或修改机场城市"),
	AIRPORT_CITY_DELETE(Path.AIRPORT_CITY_DELETE,"删除机场城市"),
	AIRPORT_GET_BY_ID(Path.AIRPORT_GET_BY_ID,"根据id查询"),
	CARRIER_QUERY_LIST(Path.CARRIER_QUERY_LIST,"航空公司里列表"),
	CARRIER_ADD(Path.CARRIER_ADD,"航空公司添加或更新"),
	QUERY_CARRIERS_BY_CODE(Path.QUERY_CARRIERS_BY_CODE,"根据航空公司code获取航空公司列表"),
	CARRIER_DELETE(Path.CARRIER_DELETE,"航空公司删除"),
	DELETE_SEAT(Path.DELETE_SEAT,"删除仓位"),
	QUERY_SEATS_BY_CARRIER_CODE(Path.QUERY_SEATS_BY_CARRIER_CODE,"根据航空公司code获取舱位列表"),
	QUERY_SEATS_BY_CARRIER_WITH_SEAT_CODE(Path.QUERY_SEATS_BY_CARRIER_WITH_SEAT_CODE,"根据航空公司和舱位code获取舱位列表"),
	DELETE_AIRPLANE(Path.DELETE_AIRPLANE,"删除航线"),
	CARRIER_GET_BY_ID(Path.CARRIER_GET_BY_ID,"根据id查询"),
	QUERY_AIRPLANE_COMPANIES(Path.QUERY_AIRPLANE_COMPANIES,"获取航空公司列表"),
	QUERY_AIRLINES_BY_CITY(Path.QUERY_AIRLINES_BY_CITY,"根据城市查询航线信息");
	public String path;
	
	public String cnName;
	
	private MaindataClientPath(String path, String cnName) {
		this.path = path;
		this.cnName = cnName;
	}
	
	
	public static class Path{
		public static final String maindataPath = "maindata/";
		public static final String AIRPORT_CITY_QUERY_LIST = maindataPath + "queryAirportCitys";
		public static final String AIRPORT_CITY_ADD = maindataPath + "addAirport";
		public static final String AIRPORT_CITY_DELETE = maindataPath + "deleteAirportCity/{airportId}";
		public static final String AIRPORT_GET_BY_ID = maindataPath + "getByIdAirport/{airportId}";
		public static final String CARRIER_QUERY_LIST = maindataPath + "queryCarriers";
		public static final String CARRIER_ADD = maindataPath + "addCarrier";
		public static final String CARRIER_DELETE = maindataPath + "deleteCarrier/{carrierId}";
		public static final String CARRIER_GET_BY_ID = maindataPath + "getByIdCarrier/{carrierId}";
		/**根据航空公司CODE获取航空公司列表*/
		public static final String QUERY_CARRIERS_BY_CODE = maindataPath+"queryCarriersByCode/{code}";
		/**查询机型列表 信息*/
		public final static String QUERY_AIRPLANE_LIST= maindataPath+"queryAirPlaneList";
		/**机型类型保存*/
		public final static String SAVEORUPDATE_AIRPLANE=maindataPath+"saveAirPlane"; 
		/**根据机型CODE获取机型列表*/
		public static final String QUERY_AIRPLANES_BY_CODE = maindataPath+"queryAirplanesByCode/{code}";
		/**根据ID或等机型信息*/
		public final static String GET_BYID_AIRPLANE=maindataPath+"getByIdAirPlane/{airPlanId}";
		/**查找舱位列表*/
		public static final String QUERY_SEAT_LIST = maindataPath + "querySeatList";
		/**保存舱位*/
		public static final String SAVEORUPDATE_SEAT = maindataPath+"saveSeatClassCarrier";
		/**通过ID获得舱位*/
		public static final String GET_BYID_SEAT = maindataPath+"getByIdSeat/{seatId}";
		/**根据ID删除舱位*/
		public static final String DELETE_SEAT = maindataPath+"deleteSeat/{seatId}";
		/**根据ID删除机型信息*/
		public static final String DELETE_AIRPLANE = maindataPath+"deleteAirplane/{airPlanId}";
		/**根据航空公司CODE获取舱位列表*/
		public static final String QUERY_SEATS_BY_CARRIER_CODE = maindataPath+"querySeatsByCarrierCode/{carrierCode}";
		/**根据航空公司和舱位CODE获取舱位列表*/
		public static final String QUERY_SEATS_BY_CARRIER_WITH_SEAT_CODE = maindataPath+"querySeatsByCarrierWithSeatCode/{carrierCode}/{code}";
		/**获取航空公司列表*/
		public static final String QUERY_AIRPLANE_COMPANIES = maindataPath+"queryAirplaneCompanies";
		/**根据城市查询航线信息*/
		public static final String QUERY_AIRLINES_BY_CITY = maindataPath+"queryAirLinesByCity";
		
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getCnName() {
		return cnName;
	}

	public void setCnName(String cnName) {
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
