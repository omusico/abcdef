package com.lvmama.lvf.common.dto.calculator;

import java.io.Serializable;
import java.math.BigDecimal;

import com.lvmama.lvf.common.dto.md.InsuranceClass;

public class InsurancesAmountDto implements Serializable{

	private static final long serialVersionUID = 3110157354345159923L;
	
	private InsuranceClass insuranceClass;  
	
	private BigDecimal amount;
	
	private int insuranceCount;
	
	

	public int getInsuranceCount() {
		return insuranceCount;
	}

	public void setInsuranceCount(int insuranceCount) {
		this.insuranceCount = insuranceCount;
	}

	public InsuranceClass getInsuranceClass() {
		return insuranceClass;
	}

	public void setInsuranceClass(InsuranceClass insuranceClass) {
		this.insuranceClass = insuranceClass;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}


	
	
	
	

}
