package com.lvmama.lvfit.common.dto.search.flight.result;

import java.math.BigDecimal;

import com.lvmama.lvfit.common.dto.enums.UnitType;

public class FlightSearchTicketRuleDetailDto {

	/** detailFeeType like VT("废票"),RT("退票"),MT("签转"),CT("改期");*/
	private String detailFeeType;
	
	/**详细费用描述 */
	private String detailFeeDesc;
	
	/** 退改金额*/
	private BigDecimal feeAmount;
	
	/**费用单位 */
	private UnitType feeUnit;

	public String getDetailFeeType() {
		return detailFeeType;
	}

	public void setDetailFeeType(String detailFeeType) {
		this.detailFeeType = detailFeeType;
	}

	public String getDetailFeeDesc() {
		return detailFeeDesc;
	}

	public void setDetailFeeDesc(String detailFeeDesc) {
		this.detailFeeDesc = detailFeeDesc;
	}

	public BigDecimal getFeeAmount() {
		return feeAmount;
	}

	public void setFeeAmount(BigDecimal feeAmount) {
		this.feeAmount = feeAmount;
	}

	public UnitType getFeeUnit() {
		return feeUnit;
	}

	public void setFeeUnit(UnitType feeUnit) {
		this.feeUnit = feeUnit;
	}
	
	
	
}
