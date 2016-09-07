package com.lvmama.lvfit.common.dto.search.flight.result;

import java.util.List;
import java.util.Map;

import com.lvmama.lvfit.common.dto.enums.PassengerType;

public class FlightSearchTicketRuleDto {
	
	/**乘客类型 */
	private PassengerType passenger;
	
	/**退规描述 */
    private String ticketRuleDesc;
	
	/** key detailTimeDesc like： Single类型/起飞前2小时前/起飞前2小时候/起飞前/起飞后 ...*/
	private Map<String, List<FlightSearchTicketRuleDetailDto>> details; 
	
	/**备注 */
	private String remark;
	
	/**附件备注 */
	private String additionalRemark;

	public PassengerType getPassenger() {
		return passenger;
	}

	public void setPassenger(PassengerType passenger) {
		this.passenger = passenger;
	}

	public String getTicketRuleDesc() {
		return ticketRuleDesc;
	}

	public void setTicketRuleDesc(String ticketRuleDesc) {
		this.ticketRuleDesc = ticketRuleDesc;
	}

	public Map<String, List<FlightSearchTicketRuleDetailDto>> getDetails() {
		return details;
	}

	public void setDetails(Map<String, List<FlightSearchTicketRuleDetailDto>> details) {
		this.details = details;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getAdditionalRemark() {
		return additionalRemark;
	}

	public void setAdditionalRemark(String additionalRemark) {
		this.additionalRemark = additionalRemark;
	}

}
