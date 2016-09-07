package com.lvmama.lvfit.common.dto.order;

import java.math.BigDecimal;

import com.lvmama.lvf.common.dto.Entity;
import com.lvmama.lvfit.common.dto.enums.IDCardType;
import com.lvmama.lvfit.common.dto.enums.Status;

public class FitOrderFliInsuranceDto extends Entity {

    private static final long serialVersionUID = 6682048703090205235L;
    /**主单号*/
    private Long orderMainId;
    /**乘客ID*/
    private Long orderPassengerId;
    /**保险ID*/
    private String insuranceId;
    /**保险供应商名称*/
    private String insuranceSuppName;
    /**保险名称*/
    private String insuranceName;
    /**保险价格*/
    private BigDecimal insurancePrice;
    /**保险份数*/
    private Integer insuranceCount;
    /**保单号*/
    private String insuranceOrderNo;
    /**保险状态*/
    private Status status;
    /**航班号*/
    private String flightNo;
    /**保险详情*/
    private String insuranceDesc;
    /**投/被保人姓名*/
    private String insuredName;
    /**证件类型*/
    private IDCardType idCardType;
    /**证件号码*/
    private String idCardNo;
    
    public Long getOrderMainId() {
        return orderMainId;
    }
    public void setOrderMainId(Long orderMainId) {
        this.orderMainId = orderMainId;
    }
    public Long getOrderPassengerId() {
        return orderPassengerId;
    }
    public void setOrderPassengerId(Long orderPassengerId) {
        this.orderPassengerId = orderPassengerId;
    }
    public String getInsuranceId() {
        return insuranceId;
    }
    public void setInsuranceId(String insuranceId) {
        this.insuranceId = insuranceId;
    }
    public String getInsuranceSuppName() {
        return insuranceSuppName;
    }
    public void setInsuranceSuppName(String insuranceSuppName) {
        this.insuranceSuppName = insuranceSuppName;
    }
    public String getInsuranceName() {
        return insuranceName;
    }
    public void setInsuranceName(String insuranceName) {
        this.insuranceName = insuranceName;
    }
    public BigDecimal getInsurancePrice() {
        return insurancePrice;
    }
    public void setInsurancePrice(BigDecimal insurancePrice) {
        this.insurancePrice = insurancePrice;
    }
    public Integer getInsuranceCount() {
        return insuranceCount;
    }
    public void setInsuranceCount(Integer insuranceCount) {
        this.insuranceCount = insuranceCount;
    }
    public String getInsuranceOrderNo() {
        return insuranceOrderNo;
    }
    public void setInsuranceOrderNo(String insuranceOrderNo) {
        this.insuranceOrderNo = insuranceOrderNo;
    }
    public Status getStatus() {
        return status;
    }
    public void setStatus(Status status) {
        this.status = status;
    }
    public String getFlightNo() {
        return flightNo;
    }
    public void setFlightNo(String flightNo) {
        this.flightNo = flightNo;
    }
    public String getInsuranceDesc() {
        return insuranceDesc;
    }
    public void setInsuranceDesc(String insuranceDesc) {
        this.insuranceDesc = insuranceDesc;
    }
    public String getInsuredName() {
        return insuredName;
    }
    public void setInsuredName(String insuredName) {
        this.insuredName = insuredName;
    }
    public IDCardType getIdCardType() {
        return idCardType;
    }
    public void setIdCardType(IDCardType idCardType) {
        this.idCardType = idCardType;
    }
    public String getIdCardNo() {
        return idCardNo;
    }
    public void setIdCardNo(String idCardNo) {
        this.idCardNo = idCardNo;
    }
}
