package com.lvmama.lvf.common.dto.ticket;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class FlightTicketRuleInfo implements Serializable{

	private static final long serialVersionUID = -6306591736635318518L;
	private List<FlightTicketRuleDto> flightTicketRules;
	

	


	public List<FlightTicketRuleDto> getFlightTicketRules() {
		return flightTicketRules;
	}

	public void setFlightTicketRules(List<FlightTicketRuleDto> flightTicketRules) {
		this.flightTicketRules = flightTicketRules;
	}

	
	
	

}
