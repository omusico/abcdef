package com.lvmama.lvf.common.dto.config;

public enum ConfigKey {

	URL("接口地址"),
	SERVICE("接口方法"), 
	USER("用户名"), 
	PASSWORD("密码"), 
	IPLIST("白名单"),
	BLACKLIST("黑名单"),
	COMMON_KEY("配置项");

	private final String cnName;

	private ConfigKey(String cnName) {
		this.cnName = cnName;
	}

	public String getCnName() {
		return cnName;
	}

	
}
