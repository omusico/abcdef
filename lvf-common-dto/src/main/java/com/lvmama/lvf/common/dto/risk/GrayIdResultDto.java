package com.lvmama.lvf.common.dto.risk;

import java.io.Serializable;

import com.lvmama.lvf.common.dto.Entity;

public class GrayIdResultDto extends Entity implements Serializable {

    private static final long serialVersionUID = 8866455203629919931L;

    /** 订单Count */
    private Integer orderCount;

    /** 乘客数量 */
    private Integer passengerCount;

    /** 客户ID */
    private String customerId;

    /** 客户姓名 */
    private String customerName;

    /** 客户手机号码 */
    private String customerCellphone;

    /** 出发日期long */
    private Long departureDate;

    /** 航班号 */
    private String flightNo;

    /** 政策ID */
    private Long policyId;

    /** 供应商政策NO */
    private String suppPolicyNo;

    public Integer getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(Integer orderCount) {
        this.orderCount = orderCount;
    }

    public Integer getPassengerCount() {
        return passengerCount;
    }

    public void setPassengerCount(Integer passengerCount) {
        this.passengerCount = passengerCount;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerCellphone() {
        return customerCellphone;
    }

    public void setCustomerCellphone(String customerCellphone) {
        this.customerCellphone = customerCellphone;
    }

    public Long getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Long departureDate) {
        this.departureDate = departureDate;
    }

    public String getFlightNo() {
        return flightNo;
    }

    public void setFlightNo(String flightNo) {
        this.flightNo = flightNo;
    }

    public Long getPolicyId() {
        return policyId;
    }

    public void setPolicyId(Long policyId) {
        this.policyId = policyId;
    }

    public String getSuppPolicyNo() {
        return suppPolicyNo;
    }

    public void setSuppPolicyNo(String suppPolicyNo) {
        this.suppPolicyNo = suppPolicyNo;
    }

}
