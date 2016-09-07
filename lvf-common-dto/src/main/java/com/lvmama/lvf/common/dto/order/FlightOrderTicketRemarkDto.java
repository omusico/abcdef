package com.lvmama.lvf.common.dto.order;

import java.io.Serializable;

import com.lvmama.lvf.common.domain.FkId;
import com.lvmama.lvf.common.dto.AEEntity;

public class FlightOrderTicketRemarkDto extends AEEntity implements Serializable {

	
	private static final long serialVersionUID = 8787351769867191745L;
	private String backRemak;
	private String customerRemark;
	
	@FkId
	private Long orderTicketRuleId;
	
	public Long getOrderTicketRuleId() {
		return orderTicketRuleId;
	}
	public void setOrderTicketRuleId(Long orderTicketRuleId) {
		this.orderTicketRuleId = orderTicketRuleId;
	}
	public String getBackRemak() {
		return backRemak;
	}
	public void setBackRemak(String backRemak) {
		this.backRemak = backRemak;
	}
	public String getCustomerRemark() {
		return customerRemark;
	}
	public void setCustomerRemark(String customerRemark) {
		this.customerRemark = customerRemark;
	}

}
