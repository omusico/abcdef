package com.lvmama.lvfit.common.client.path;

import com.lvmama.lvf.common.utils.CustomizedPropertyPlaceholderConfigurer;



public enum BatchClientPath {
	
	SYNC_SDP_PRODUCT_BASIC_INFO(Path.SYNC_SDP_PRODUCT_BASIC_INFO, "同步自主打包产品基本信息"),
	SYNC_SDP_PRODUCT_SEARCH_INDEX(Path.SYNC_SDP_PRODUCT_SEARCH_INDEX, "同步单条索引信息 "),
	SYNC_ALL_USEFUL_SDP_PRODUCT_SEARCH_INDEX(Path.SYNC_ALL_USEFUL_SDP_PRODUCT_SEARCH_INDEX,"批量同步索引信息"),
	SYNC_UNFINISHED_PRODUCT_SEARCH_INDEX(Path.SYNC_UNFINISHED_PRODUCT_SEARCH_INDEX, "同步未完成的索引信息"),
	SAVE_SYN_TIME_INFO(Path.SAVE_SYN_TIME_INFO,"存储同步时间信息");
    
	public String path;
	
	public String cnName;

	private BatchClientPath(String path, String cnName) {
		this.path = path;
		this.cnName = cnName;
	}


	public static class Path{
		
		public final static String basePath = "batch/";
		 /** 同步自主打包产品基本信息 */
        public static final String SYNC_SDP_PRODUCT_BASIC_INFO = basePath + "syncSdpProductBasicInfo/{productId}";
        /** 同步单条索引信息 */
        public static final String SYNC_SDP_PRODUCT_SEARCH_INDEX = basePath + "syncSdpProductSearchIndex/{productId}";
        /** 批量同步索引信息 */
        public static final String SYNC_ALL_USEFUL_SDP_PRODUCT_SEARCH_INDEX = basePath + "syncAllUsefulSdpProductSearchIndex/{modValue}";
		/** 同步未完成的索引信息 */
		public static final String SYNC_UNFINISHED_PRODUCT_SEARCH_INDEX = basePath + "syncUnFinishedProductSearchIndex";
		/** 存储同步时间信息 */
		public final static String SAVE_SYN_TIME_INFO = basePath +"synTimeInfo";
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
