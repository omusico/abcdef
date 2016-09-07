package com.lvmama.lvfit.common.client.path;

import com.lvmama.lvf.common.utils.CustomizedPropertyPlaceholderConfigurer;



public enum SearchClientPath {
	HOTEL_LIST_SEARCH(Path.HOTEL_LIST_SEARCH,"获取酒店信息"),
	HOTEL_IMAGE_SEARCH(Path.HOTEL_IMAGE_SEARCH,"获取酒店主图片信息"),
	INSURANCE_INFO_SEARCH(Path.INSURANCE_INFO_SEARCH,"获取保险信息"),
	SPOT_LIST_SEARCH(Path.SPOT_LIST_SEARCH,"获取景点信息"),
	PACKAGE_PRODUCT_BASIC_INFO_SEARCH(Path.PACKAGE_PRODUCT_BASIC_INFO_SEARCH, "获取打包产品基本信息"),
	PACKAGE_PRODUCT_INFO_ONLY_SEARCH(Path.PACKAGE_PRODUCT_INFO_ONLY_SEARCH, "仅仅获取打包产品基本信息"),
	PACKAGE_GOODS_INFO_SEARCH(Path.PACKAGE_GOODS_INFO_SEARCH, "获取打包商品信息"),
    PRODUCT_GROUP_SEARCH(Path.PRODUCT_GROUP_SEARCH,"获取被打包产品的价格日历信息"),
    CONTRACTS(Path.CONTRACTS,"获取合同信息"),
    RECOMMEND_INFO_SEARCH(Path.RECOMMEND_INFO_SEARCH, "获取频道页推荐信息"),
    PACKAGE_PRODUCT_PROP_SEARCH(Path.PACKAGE_PRODUCT_PROP_SEARCH, "获取产品属性"),
	PRODUCT_INSTALMENT_INFO_SEARCH(Path.PRODUCT_INSTALMENT_INFO_SEARCH, "获取分期价信息");
	
	
	public String path;
	
	public String cnName;

	private SearchClientPath(String path, String cnName) {
		this.path = path;
		this.cnName = cnName;
	}


	public static class Path{
	    public final static String basePath="vst/";
	    public final static String hotelPath="hotel/";
	    public final static String spotPath="spot/";
	    public final static String productGroupPath = "productGroup/";
	   
        /** 主站中获取酒店信息*/
        public static final String HOTEL_LIST_SEARCH = hotelPath+"search";
       
        /** 主站中获取酒店主图片信息*/
        public static final String HOTEL_IMAGE_SEARCH = hotelPath+"searchimage";
       
        /** 主站中获取保险信息*/
        public static final String INSURANCE_INFO_SEARCH = basePath+"insuranceSearch";
        
        /**主站获取景点信息*/
        public static final String SPOT_LIST_SEARCH = spotPath+"search";
        /** 从主站获取打包产品基本信息 */
        public static final String PACKAGE_PRODUCT_BASIC_INFO_SEARCH = basePath + "packageProductSearch/{productId}";
        /** 从主站获取打包产品基本信息--只查询最基础的产品基本信息 */
        public static final String PACKAGE_PRODUCT_INFO_ONLY_SEARCH = basePath + "packageProductOnlySearch/{productId}";
        /** 主站获取被打包产品的价格信息*/
        public static final String PRODUCT_GROUP_SEARCH = productGroupPath + "search";
        /** 打包产品的商品信息 */
        public static final String PACKAGE_GOODS_INFO_SEARCH = basePath + "packageGoodsSearch";
        /** 获取合同信息*/
        public static final String CONTRACTS = basePath + "getContracts";
        /** 获取频道页推荐信息*/
        public static final String RECOMMEND_INFO_SEARCH = basePath + "searchRecommendInfo/{fromPlaceId}";
        /** 获取产品属性 */
        public static final String PACKAGE_PRODUCT_PROP_SEARCH = basePath + "productProp/{productId}";
		/** 主站获取被打包产品的价格信息*/
		public static final String PRODUCT_INSTALMENT_INFO_SEARCH = basePath + "getInstalmentInfo/{productId}/{categoryCode}";
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
