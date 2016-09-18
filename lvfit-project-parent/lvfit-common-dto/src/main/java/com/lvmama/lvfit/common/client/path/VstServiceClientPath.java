package com.lvmama.lvfit.common.client.path;

import com.lvmama.lvf.common.utils.CustomizedPropertyPlaceholderConfigurer;



public enum VstServiceClientPath {
	
	
	/**
	 * 推送com_push数据
	 */
	PUSH_COM_PUSH(Path.PUSH_COM_PUSH, "VST产品详情"),
	
	QUERY_COM_PUSH(Path.QUERY_COM_PUSH,"查询推送记录列表");
	
	public String path;
	public String cnName;

	public static class Path {
		
		public final static String basePath = "vst/service";
		
        public static final String PUSH_COM_PUSH = basePath + "/pushComPush}";
        
        public static final String QUERY_COM_PUSH = basePath + "/queryPushList";
	}

	private VstServiceClientPath(String path, String cnName) {
		this.path = path;
		this.cnName = cnName;
	}

	public String getPath() {
		return path;
	}

	public String getCnName() {
		return cnName;
	}

	public String url(String baseUrl) {
		if (!baseUrl.contains("http")) {
			baseUrl = CustomizedPropertyPlaceholderConfigurer.getContextProperty(baseUrl);
		}
		if (baseUrl.endsWith("/")) {
			return baseUrl + this.path;
		}
		return baseUrl + "/" + this.path;
	}

	public String url(String baseUrl, Object... args) {
		String url = url(baseUrl);
		String pat = "\\{\\w*\\}";
		return String.format(url.replaceAll(pat, "%s"), args);
	}
}
