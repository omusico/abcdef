package com.lvmama.lvf.common.client.path;

import com.lvmama.lvf.common.utils.CustomizedPropertyPlaceholderConfigurer;


/**
 * @author lutianyu
 * @date   2016年1月20日
 */
public enum TravelClientPath {
	QUERY_COMPANYS(Path.QUERY_COMPANYS,"查找公司信息"),
	SAVE_COMPANYS(Path.SAVE_COMPANYS,"保存公司信息"),
	SELECT_BASE_INFO(Path.SELECT_BASE_INFO,"查询基础公司信息"),
	GET_COMPANY_BY_ID(Path.GET_COMPANY_BY_ID,"根据id获取公司信息"),
	GET_COMPANY_BY_CODE(Path.GET_COMPANY_BY_CODE,"根据code获取公司信息"),
	GET_PASSENGER_BY_NAME(Path.GET_PASSENGER_BY_NAME,"根据姓名获取乘客信息"),
	
	GET_ACCOUNT_BY_NAME(Path.GET_ACCOUNT_BY_NAME,"根据姓名获取登录信息"),
	QUERY_ACCOUNTS(Path.QUERY_ACCOUNTS,"查找账号信息"),
	SAVE_ACCOUNT(Path.SAVE_ACCOUNT,"保存账号信息"),
	GET_ACCOUNT_BY_ID(Path.GET_ACCOUNT_BY_ID,"根据id获取账号信息"),
	
	QUERY_PASSENGERS(Path.QUERY_PASSENGERS,"查询乘客信息"),
	GET_PASSENGER_BY_ID(Path.GET_PASSENGER_BY_ID,"根据id查询乘客信息"),
	SAVE_PASSENGERS(Path.SAVE_PASSENGERS,"保存乘客信息"),
	BATCH_SAVE_PASSENGERS(Path.BATCH_SAVE_PASSENGERS,"批量导入乘客信息"), 
	DELETE_PASSENGER_BY_ID(Path.DELETE_PASSENGER_BY_ID,"根据id删除乘客信息");
	
	
	public String path;
	public String cnName;
	
	public static class Path{
		public final static String basePath="travel/";
		public final static String QUERY_COMPANYS = basePath + "queryCompanys/";
		public final static String SAVE_COMPANYS = basePath + "saveCompanys/";
		public final static String SELECT_BASE_INFO = basePath + "selectCompanyBaseInfo/";
		public final static String GET_COMPANY_BY_ID = basePath + "getCompanyById/{id}";
		
		public final static String GET_ACCOUNT_BY_NAME = basePath + "getAccountByName/";
		public final static String GET_COMPANY_BY_CODE = basePath + "getCompanyByCode/";
		public final static String GET_PASSENGER_BY_NAME = basePath + "getPassengerByName/";
		public final static String QUERY_ACCOUNTS = basePath + "queryAccounts/";
		public final static String SAVE_ACCOUNT = basePath + "saveAccount/";
		public final static String GET_ACCOUNT_BY_ID = basePath + "getAccountById/{id}";
		
		public final static String QUERY_PASSENGERS = basePath + "queryPassengers/";
		public final static String GET_PASSENGER_BY_ID = basePath + "getPassengerById/{id}";
		public final static String SAVE_PASSENGERS = basePath + "savePassengers/";
		public final static String BATCH_SAVE_PASSENGERS = basePath + "batchImportPassengers/";
		public final static String DELETE_PASSENGER_BY_ID = basePath + "deletePassengerById/";
	}
	
	private TravelClientPath(String path, String cnName) {
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
