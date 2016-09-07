package com.lvmama.lvfit.common.dto.calculator;

import java.io.Serializable;

public class InsuranceCalculatRequest implements Serializable{

	private static final long serialVersionUID = -2999362853568447522L;
	
	private Long insuranceId;
	
	private int insuranceCount;

	public Long getInsuranceId() {
		return insuranceId;
	}

	public void setInsuranceId(Long insuranceId) {
		this.insuranceId = insuranceId;
	}

	public int getInsuranceCount() {
		return insuranceCount;
	}

	public void setInsuranceCount(int insuranceCount) {
		this.insuranceCount = insuranceCount;
	}
	
	

}
