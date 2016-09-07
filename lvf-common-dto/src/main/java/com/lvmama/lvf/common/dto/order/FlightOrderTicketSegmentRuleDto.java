package com.lvmama.lvf.common.dto.order;

import java.io.Serializable;

import com.lvmama.lvf.common.dto.AEEntity;
import com.lvmama.lvf.common.dto.enums.RuleType;
import com.lvmama.lvf.common.dto.md.PriceFormula;

public class FlightOrderTicketSegmentRuleDto extends AEEntity implements Serializable {

	
	private static final long serialVersionUID = -3604909282794288584L;
	private Integer minDepartureHour;
	private Integer maxDepartureHour;
	private PriceFormula feeFormula;
	private Boolean allow;
	
	
	private RuleType ruleType;
	
	private Long ruleId;
	
	
	
	
	public RuleType getRuleType() {
		return ruleType;
	}
	public void setRuleType(RuleType ruleType) {
		this.ruleType = ruleType;
	}
	public Long getRuleId() {
		return ruleId;
	}
	public void setRuleId(Long ruleId) {
		this.ruleId = ruleId;
	}

	public Integer getMinDepartureHour() {
		return minDepartureHour;
	}
	public void setMinDepartureHour(Integer minDepartureHour) {
		this.minDepartureHour = minDepartureHour;
	}
	public Integer getMaxDepartureHour() {
		return maxDepartureHour;
	}
	public void setMaxDepartureHour(Integer maxDepartureHour) {
		this.maxDepartureHour = maxDepartureHour;
	}
	public PriceFormula getFeeFormula() {
		return feeFormula;
	}
	public void setFeeFormula(PriceFormula feeFormula) {
		this.feeFormula = feeFormula;
	}
	public Boolean getAllow() {
		return allow;
	}
	public void setAllow(Boolean allow) {
		this.allow = allow;
	}

	
	
	
}
