package com.lvmama.lvf.common.dto.search.result;

import java.util.List;

import com.lvmama.lvf.common.dto.enums.PassengerType;

public class FlightSearchTicketRuleSimpleDto {
	
	/**乘客类型 */
	private PassengerType passengerType;
	
   private List<FlightSearchTicketRuleSimpleDetailDto> simpleDetails;
	
	/**备注 */
	private String remark;
	
	/**附件备注 */
	private String additionalRemark;
	

	/**乘客类型名称 */
	private String passengerTypeName;

  
	public PassengerType getPassengerType() {
		return passengerType;
	}

	public void setPassengerType(PassengerType passengerType) {
		this.passengerType = passengerType;
	}

	public List<FlightSearchTicketRuleSimpleDetailDto> getSimpleDetails() {
		return simpleDetails;
	}

	public void setSimpleDetails(List<FlightSearchTicketRuleSimpleDetailDto> simpleDetails) {
		this.simpleDetails = simpleDetails;
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

	public String getPassengerTypeName() {
		if(null!=this.getPassengerType()){
			return this.getPassengerType().getCnName();
		}
		return passengerTypeName;
	}

	public void setPassengerTypeName(String passengerTypeName) {
		this.passengerTypeName = passengerTypeName;
	}


}
