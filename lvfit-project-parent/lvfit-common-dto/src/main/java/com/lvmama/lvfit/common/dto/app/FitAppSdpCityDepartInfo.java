package com.lvmama.lvfit.common.dto.app;

import com.lvmama.lvfit.common.dto.enums.JudgeType;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpCityGroupDto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class FitAppSdpCityDepartInfo implements Serializable {


    private FitSdpCityGroupDto sdpCityGroupDto = new FitSdpCityGroupDto();

    private BigDecimal startPrice;

    public FitSdpCityGroupDto getSdpCityGroupDto() {
        return sdpCityGroupDto;
    }

    public void setSdpCityGroupDto(FitSdpCityGroupDto sdpCityGroupDto) {
        this.sdpCityGroupDto = sdpCityGroupDto;
    }

    public BigDecimal getStartPrice() {
        return startPrice;
    }

    public void setStartPrice(BigDecimal startPrice) {
        this.startPrice = startPrice;
    }

    public Long getProductId() {
        return sdpCityGroupDto.getProductId();
    }

    public void setArrivalCityCode(String arrivalCityCode) {
        sdpCityGroupDto.setArrivalCityCode(arrivalCityCode);
    }

    public void setCreateTime(Date createTime) {
        sdpCityGroupDto.setCreateTime(createTime);
    }

    public void setDepartureCityCode(String departureCityCode) {
        sdpCityGroupDto.setDepartureCityCode(departureCityCode);
    }

    public void setDepartureCityShortPinYin(String departureCityShortPinYin) {
        sdpCityGroupDto.setDepartureCityShortPinYin(departureCityShortPinYin);
    }

    public void setArrivalCityName(String arrivalCityName) {
        sdpCityGroupDto.setArrivalCityName(arrivalCityName);
    }

    public void setArrivalCityDistrictId(Long arrivalCityDistrictId) {
        sdpCityGroupDto.setArrivalCityDistrictId(arrivalCityDistrictId);
    }

    public JudgeType getIsSelectedDeparture() {
        return sdpCityGroupDto.getIsSelectedDeparture();
    }

    public Date getUpdateTime() {
        return sdpCityGroupDto.getUpdateTime();
    }


    public String getArrivalCityShortPinYin() {
        return sdpCityGroupDto.getArrivalCityShortPinYin();
    }

    public String getArrivalCityName() {
        return sdpCityGroupDto.getArrivalCityName();
    }

    public void setArrivalCityShortPinYin(String arrivalCityShortPinYin) {
        sdpCityGroupDto.setArrivalCityShortPinYin(arrivalCityShortPinYin);
    }

    public String getDepartureCityName() {
        return sdpCityGroupDto.getDepartureCityName();
    }


    public void setDepartureCityName(String departureCityName) {
        sdpCityGroupDto.setDepartureCityName(departureCityName);
    }


    public void setIsSelectedDeparture(JudgeType isSelectedDeparture) {
        sdpCityGroupDto.setIsSelectedDeparture(isSelectedDeparture);
    }


    public String getArrivalCityCode() {
        return sdpCityGroupDto.getArrivalCityCode();
    }


    public void setDepartureCityDistrictId(Long departureCityDistrictId) {
        sdpCityGroupDto.setDepartureCityDistrictId(departureCityDistrictId);
    }

    public Long getArrivalCityDistrictId() {
        return sdpCityGroupDto.getArrivalCityDistrictId();
    }

    public String getDepartureCityShortPinYin() {
        return sdpCityGroupDto.getDepartureCityShortPinYin();
    }


    public String getDepartureCityCode() {
        return sdpCityGroupDto.getDepartureCityCode();
    }

    public Long getDepartureCityDistrictId() {
        return sdpCityGroupDto.getDepartureCityDistrictId();
    }

    public void setProductId(Long productId) {
        sdpCityGroupDto.setProductId(productId);
    }

}
