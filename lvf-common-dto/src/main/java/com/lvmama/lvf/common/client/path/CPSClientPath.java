package com.lvmama.lvf.common.client.path;

import com.lvmama.lvf.common.utils.CustomizedPropertyPlaceholderConfigurer;

/**
 * CPS分销相关
 */
public enum CPSClientPath {
	CPS_NOTIFY_ORDER_STATUS(Path.CPS_NOTIFY_ORDER_STATUS,"CPS消息通知订单状态变更");
	
	public String path;
	public String cnName;
	
	public static class Path{
		public final static String basePath="cps/";
		public final static String cpsPath="order/";
		public final static String CPS_NOTIFY_ORDER_STATUS = basePath + cpsPath+ "notifyOrderStatus";
	}

	private CPSClientPath(String path, String cnName) {
		this.path = path;
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
