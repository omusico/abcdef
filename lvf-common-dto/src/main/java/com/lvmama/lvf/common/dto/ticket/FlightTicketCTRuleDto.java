package com.lvmama.lvf.common.dto.ticket;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import com.lvmama.lvf.common.domain.FkId;
import com.lvmama.lvf.common.dto.AEEntity;
import com.lvmama.lvf.common.dto.enums.CTType;

public class FlightTicketCTRuleDto extends AEEntity implements Serializable {

	
	private static final long serialVersionUID = 5331060311753486687L;
	
	/** 更改规定 */
	private CTType ctType;
	private String cTDesc;
	private BigDecimal minCTFee;
	private Boolean autoCT;
	
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
	
	public CTType getCtType() {
		return ctType;
	}
	public void setCtType(CTType ctType) {
		this.ctType = ctType;
	}
	public String getcTDesc() {
		return cTDesc;
	}
	public void setcTDesc(String cTDesc) {
		this.cTDesc = cTDesc;
	}
	public BigDecimal getMinCTFee() {
		return minCTFee;
	}
	public void setMinCTFee(BigDecimal minCTFee) {
		this.minCTFee = minCTFee;
	}
	public Boolean getAutoCT() {
		return autoCT;
	}
	public void setAutoCT(Boolean autoCT) {
		this.autoCT = autoCT;
	}
	public List<FlightTicketSegmentRuleDto> getFlightTicketSegmentRules() {
		return flightTicketSegmentRules;
	}
	public void setFlightTicketSegmentRules(
			List<FlightTicketSegmentRuleDto> flightTicketSegmentRules) {
		this.flightTicketSegmentRules = flightTicketSegmentRules;
	}
	
	
	
	
}
