package com.lvmama.lvfit.common.dto.shopping;

import java.math.BigDecimal;

import com.lvmama.lvf.common.dto.Entity;

public class FlightInsuranceDto extends Entity {
    private static final long serialVersionUID = 553468490206851247L;

    private String shoppingUuid;
    private Long versionNo;
    private Long insuranceId;
    private String insuranceName;
    private String suppName;
    private BigDecimal insurancePrice;
    private int insuranceCount;
    private String insuranceDesc;
    private String flightNo;
    private String insuranceClassCode;

    public Long getInsuranceId() {
        return insuranceId;
    }

    public void setInsuranceId(Long insuranceId) {
        this.insuranceId = insuranceId;
    }

    public String getInsuranceName() {
        return insuranceName;
    }

    public void setInsuranceName(String insuranceName) {
        this.insuranceName = insuranceName;
    }

    public String getSuppName() {
        return suppName;
    }

    public void setSuppName(String suppName) {
        this.suppName = suppName;
    }

    public BigDecimal getInsurancePrice() {
        return insurancePrice;
    }

    public void setInsurancePrice(BigDecimal insurancePrice) {
        this.insurancePrice = insurancePrice;
    }

    public int getInsuranceCount() {
        return insuranceCount;
    }

    public void setInsuranceCount(int insuranceCount) {
        this.insuranceCount = insuranceCount;
    }

    public String getInsuranceDesc() {
        return insuranceDesc;
    }

    public void setInsuranceDesc(String insuranceDesc) {
        this.insuranceDesc = insuranceDesc;
    }

	public final String getShoppingUuid() {
		return shoppingUuid;
	}

	public final void setShoppingUuid(String shoppingUuid) {
		this.shoppingUuid = shoppingUuid;
	}

	public final Long getVersionNo() {
		return versionNo;
	}

	public final void setVersionNo(Long versionNo) {
		this.versionNo = versionNo;
	}

    public String getFlightNo() {
        return flightNo;
    }

    public void setFlightNo(String flightNo) {
        this.flightNo = flightNo;
    }

    public String getInsuranceClassCode() {
        return insuranceClassCode;
    }

    public void setInsuranceClassCode(String insuranceClassCode) {
        this.insuranceClassCode = insuranceClassCode;
    }
}
