package com.lvmama.lvf.common.dto.md;

import java.io.Serializable;
import java.math.BigDecimal;

import com.lvmama.lvf.common.dto.Entity;
import com.lvmama.lvf.common.dto.enums.DefaultRule;
import com.lvmama.lvf.common.dto.enums.RuleType;
import com.lvmama.lvf.common.dto.enums.StandardPrice;

public class SeatRule extends Entity implements Serializable{

	private static final long serialVersionUID = 8172372990500391454L;
	
	private SeatClass seatClass;
	
	private RuleType ruleType;
	
	
	/**基准价*/
	private StandardPrice standardPrice;
	
	/**最小提前时间*/
	private Integer minDepartureHour;
	/**最大提前时间*/
	private Integer maxDepartureHour;
	
	/**手续费比率*/
	private BigDecimal scale = BigDecimal.ZERO;
	
	/**此退改签规则是否默认*/
	private DefaultRule defaultRule;
	

	public DefaultRule getDefaultRule() {
		return defaultRule;
	}

	public void setDefaultRule(DefaultRule defaultRule) {
		this.defaultRule = defaultRule;
	}

	public StandardPrice getStandardPrice() {
		return standardPrice;
	}

	public void setStandardPrice(StandardPrice standardPrice) {
		this.standardPrice = standardPrice;
	}
	public SeatClass getSeatClass() {
		return seatClass;
	}

	public void setSeatClass(SeatClass seatClass) {
		this.seatClass = seatClass;
	}

	public RuleType getRuleType() {
		return ruleType;
	}

	public void setRuleType(RuleType ruleType) {
		this.ruleType = ruleType;
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

	public BigDecimal getScale() {
		return scale;
	}

	public void setScale(BigDecimal scale) {
		this.scale = scale;
	}
	
	
	
	
}
