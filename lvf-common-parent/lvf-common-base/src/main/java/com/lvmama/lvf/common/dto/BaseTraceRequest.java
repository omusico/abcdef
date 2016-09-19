package com.lvmama.lvf.common.dto;

import com.lvmama.lvf.common.trace.BaseTraceInfo;

public class BaseTraceRequest  implements BaseTraceInfo {

	private String ip;
	private String customer;
	private String equipmentNo;
	
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
	
	@Override
	public String getEquipmentNo() {
		return equipmentNo;
	}

	public void setEquipmentNo(String equipmentNo) {
		this.equipmentNo = equipmentNo;
	}
	
	
	

}
