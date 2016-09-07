package com.lvmama.lvf.common.dto.request;

import java.io.Serializable;

public class CityQueryRequest implements Serializable{

	private static final long serialVersionUID = -2779854387563368333L;

	private String param;

	public String getParam() {
		return param;
	}

	public void setParam(String param) {
		this.param = param;
	}
	
}
