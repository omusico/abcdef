package com.lvmama.lvfit.common.dto.request;

import java.io.Serializable;
import java.math.BigDecimal;

import com.lvmama.lvfit.common.dto.shopping.FlightInsuranceDto;

public class FitShoppingFliInsRequest implements Serializable{

    private static final long serialVersionUID = 5948555275159386102L;

    private String shoppingUuid;
    
    private FlightInsuranceDto flightInsuranceDto;
    
    public FitShoppingFliInsRequest() {
        flightInsuranceDto = new FlightInsuranceDto();
    }

    public FlightInsuranceDto getFlightInsuranceDto() {
        return flightInsuranceDto;
    }

    public void setFlightInsuranceDto(FlightInsuranceDto flightInsuranceDto) {
        this.flightInsuranceDto = flightInsuranceDto;
    }

    public Long getInsuranceId() {
        return flightInsuranceDto.getInsuranceId();
    }

    public void setInsuranceId(Long insuranceId) {
        flightInsuranceDto.setInsuranceId(insuranceId);
    }

    public String getInsuranceName() {
        return flightInsuranceDto.getInsuranceName();
    }

    public void setInsuranceName(String insuranceName) {
        flightInsuranceDto.setInsuranceName(insuranceName);
    }

    public String getSuppName() {
        return flightInsuranceDto.getSuppName();
    }

    public void setSuppName(String suppName) {
        flightInsuranceDto.setSuppName(suppName);
    }

    public BigDecimal getInsurancePrice() {
        return flightInsuranceDto.getInsurancePrice();
    }

    public void setInsurancePrice(BigDecimal insurancePrice) {
        flightInsuranceDto.setInsurancePrice(insurancePrice);
    }

    public int getInsuranceCount() {
        return flightInsuranceDto.getInsuranceCount();
    }

    public void setInsuranceCount(int insuranceCount) {
        flightInsuranceDto.setInsuranceCount(insuranceCount);
    }

    public String getInsuranceDesc() {
        return flightInsuranceDto.getInsuranceDesc();
    }

    public void setInsuranceDesc(String insuranceDesc) {
        flightInsuranceDto.setInsuranceDesc(insuranceDesc);
    }

    public String getShoppingUuid() {
        return shoppingUuid;
    }

    public void setShoppingUuid(String shoppingUuid) {
        this.shoppingUuid = shoppingUuid;
    }

    public String getInsuranceClassCode() {
        return flightInsuranceDto.getInsuranceClassCode();
    }

    public void setInsuranceClassCode(String insuranceClassCode) {
        flightInsuranceDto.setInsuranceClassCode(insuranceClassCode);
    }
}
