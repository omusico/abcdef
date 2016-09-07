package com.lvmama.lvf.common.dto;

import com.lvmama.lvf.common.trace.BaseTraceInfo;

public class BaseTraceRequest  implements BaseTraceInfo {

	private String ip;
	private String customer;
	
	@Override
	public String getIp() {
		return ip;
	}

	@Override
	public String getCustomer() {
		return customer;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

}
