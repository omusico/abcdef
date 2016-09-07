package com.lvmama.lvfit.common.dto.shopping;

import java.math.BigDecimal;

import com.lvmama.lvf.common.dto.Entity;

public class FitShoppingSelectedFlightInsuranceDto extends Entity {

    private static final long serialVersionUID = -8736133652122564035L;
    private Long insuranceId;
    private String insuranceName;
    private String suppName;
    private BigDecimal insurancePrice;
    private int insuranceCount;
    private String insuranceDesc;

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
}
