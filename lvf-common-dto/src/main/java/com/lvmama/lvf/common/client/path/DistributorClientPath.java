package com.lvmama.lvf.common.client.path;

import com.lvmama.lvf.common.utils.CustomizedPropertyPlaceholderConfigurer;

/**
 * 机票分销相关
 * @author XuJunhui
 * @Date 2016年6月29日
 */
public enum DistributorClientPath {
	/**创建分销订单 */
	DIST_ORDER_BOOKING(Path.DIST_ORDER_BOOKING,"创建分销订单"),
	/**创建分销退票单*/
	DIST_ORDER_RTVTAPPLY(Path.DIST_ORDER_RTVTSYNC,"创建分销退票单"),
	/**创建分销改期单*/
	DIST_ORDER_CTMTAPPLY(Path.DIST_ORDER_CTMTSYNC, "创建分销改期单"),
	/**出票完成*/
	DIST_TICKET_DONE(Path.DIST_TICKET_DONE, "出票完成通知分销"),
	/**机票退款完成通知分销*/
	DIST_REFUND_DONE(Path.DIST_REFUND_DONE, "机票退款完成通知分销"),
	/**机票支付回调通知分销*/
	DIST_PAY_DONE(Path.DIST_PAY_DONE, "机票支付回调通知分销"),
	/**机票取消所有正常子订单后通知分销*/
	DIST_CANCEL_DONE(Path.DIST_CANCEL_DONE, "机票取消所有正常子订单后通知分销");
	
	
	public String path;
	public String cnName;
	
	public static class Path{
		public final static String basePath="distributor/";
		public final static String orderPath="order/";
		
		public final static String DIST_ORDER_BOOKING = basePath + orderPath + "booking";
		public final static String DIST_ORDER_RTVTSYNC = basePath + orderPath + "rtvtSync";
		public final static String DIST_ORDER_CTMTSYNC = basePath + orderPath + "ctmtSync";
		
		public final static String DIST_TICKET_DONE = basePath + "ticket/done";
		public final static String DIST_REFUND_DONE = basePath + "refund/done";
		public final static String DIST_PAY_DONE = basePath + "pay/done";
		public final static String DIST_CANCEL_DONE = basePath + "cancel/done";
		
	}

	private DistributorClientPath(String path, String cnName) {
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

