package com.lvmama.lvf.common.dto.flight;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.lvmama.lvf.common.dto.Entity;
import com.lvmama.lvf.common.dto.enums.PassengerType;


public class FlightRefundEndorseRuleDto extends Entity implements Serializable {

    private static final long serialVersionUID = 7968518518054739888L;
    
    private String rId;
    private String cId; 
    private PassengerType passengerType;
 
    private List<FlightTicketRulePriceDto> flightTicketRulePrices = new ArrayList<FlightTicketRulePriceDto>();
   
	public String getrId() {
		return rId;
	}
	public void setrId(String rId) {
		this.rId = rId;
	}
	public String getcId() {
		return cId;
	}
	public void setcId(String cId) {
		this.cId = cId;
	}
	
	public PassengerType getPassengerType() {
		return passengerType;
	}
	public void setPassengerType(PassengerType passengerType) {
		this.passengerType = passengerType;
	}
	public List<FlightTicketRulePriceDto> getFlightTicketRulePrices() {
		return flightTicketRulePrices;
	}
	public void setFlightTicketRulePrices(
			List<FlightTicketRulePriceDto> flightTicketRulePrices) {
		this.flightTicketRulePrices = flightTicketRulePrices;
	}
	
	
	
    
}
