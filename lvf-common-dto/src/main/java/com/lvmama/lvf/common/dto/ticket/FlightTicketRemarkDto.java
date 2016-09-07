package com.lvmama.lvf.common.dto.ticket;

import java.io.Serializable;

import com.lvmama.lvf.common.domain.FkId;
import com.lvmama.lvf.common.dto.AEEntity;

public class FlightTicketRemarkDto extends AEEntity implements Serializable {

	
	private static final long serialVersionUID = 8787351769867191745L;
	private String backRemak;
	private String customerRemark;
	
	@FkId
	private FlightTicketRuleDto flightTicketRule;
	
	public FlightTicketRuleDto getFlightTicketRule() {
		return flightTicketRule;
	}
	public void setFlightTicketRule(FlightTicketRuleDto flightTicketRule) {
		this.flightTicketRule = flightTicketRule;
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
