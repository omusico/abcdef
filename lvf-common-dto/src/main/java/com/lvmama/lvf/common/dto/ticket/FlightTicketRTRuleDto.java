package com.lvmama.lvf.common.dto.ticket;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import com.lvmama.lvf.common.domain.FkId;
import com.lvmama.lvf.common.dto.AEEntity;
import com.lvmama.lvf.common.dto.enums.RTType;

public class FlightTicketRTRuleDto extends AEEntity implements Serializable {

	private static final long serialVersionUID = -2851635307564658597L;
	private RTType rtType;

	/** 退票规定 */
	private String rTDesc;
	private BigDecimal minRTFee;
	private Boolean autoRT;
	
	/** 规定具体信息 */
	private List<FlightTicketSegmentRuleDto> flightTicketSegmentRules;

	@FkId
	private FlightTicketRuleDto flightTicketRule;

	public FlightTicketRuleDto getFlightTicketRule() {
		return flightTicketRule;
	}

	public void setFlightTicketRule(FlightTicketRuleDto flightTicketRule) {
		this.flightTicketRule = flightTicketRule;
	}

	public RTType getRtType() {
		return rtType;
	}

	public void setRtType(RTType rtType) {
		this.rtType = rtType;
	}

	public String getrTDesc() {
		return rTDesc;
	}

	public void setrTDesc(String rTDesc) {
		this.rTDesc = rTDesc;
	}

	public BigDecimal getMinRTFee() {
		return minRTFee;
	}

	public void setMinRTFee(BigDecimal minRTFee) {
		this.minRTFee = minRTFee;
	}

	public Boolean getAutoRT() {
		return autoRT;
	}

	public void setAutoRT(Boolean autoRT) {
		this.autoRT = autoRT;
	}

	public List<FlightTicketSegmentRuleDto> getFlightTicketSegmentRules() {
		return flightTicketSegmentRules;
	}

	public void setFlightTicketSegmentRules(
			List<FlightTicketSegmentRuleDto> flightTicketSegmentRules) {
		this.flightTicketSegmentRules = flightTicketSegmentRules;
	}

}
