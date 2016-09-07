package com.lvmama.lvf.common.dto.risk;

import java.io.Serializable;
import java.util.Date;

import com.lvmama.lvf.common.dto.Entity;
import com.lvmama.lvf.common.dto.enums.Status;
import com.lvmama.lvf.common.dto.status.order.OrderCancelStatus;

/**
 * 风控信息
 * 
 * @author yuanweihong
 * @date 2015-9-1
 */
public class OrderRiskInfoDto extends Entity implements Serializable {

    private static final long serialVersionUID = 1776009940411630509L;

    /** 订单ID */
    private String orderId;
    
    /** 客户ID */
    private String customerId;
    
    /** 客户Code(仅用于查询时) */
    private String customerCode;
    
    private String orderMainId;
    
    private String equipmentNo;
    
    private String signId;

    private String ip;
    
    /** 客户姓名 */
    private String customerName;
    
    /** 客户手机号码 */
    private String customerCellphone;
    
    /** 航班号 */
    private String flightNo;
    
    /** 政策ID */
    private Long policyId;
    
    /** 运价政策ID */
    private Long pricePolicyId;
    
    /** 供应商政策NO */
    private String suppPolicyNo;
    
    /** 供应商编号 */
    private String suppCode;
    
    /** 预定日期 */
    private Date bookingDate;
    
    /** 出发日期long */
    private Long departureDate;
    
    /** 乘客数量 */
    private Integer passengerCount;

    /** 有效无效标志 **/
    private Status status;
    
    private OrderCancelStatus orderCancelStatus;
    
    public String getSignId() {
		return signId;
	}

	public void setSignId(String signId) {
		this.signId = signId;
	}

	public String getOrderMainId() {
		return orderMainId;
	}

	public void setOrderMainId(String orderMainId) {
		this.orderMainId = orderMainId;
	}

	public String getEquipmentNo() {
		return equipmentNo;
	}

	public void setEquipmentNo(String equipmentNo) {
		this.equipmentNo = equipmentNo;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}
	
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
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

    public String getSuppCode() {
        return suppCode;
    }

    public void setSuppCode(String suppCode) {
        this.suppCode = suppCode;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public Long getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Long departureDate) {
        this.departureDate = departureDate;
    }

    public Integer getPassengerCount() {
        return passengerCount;
    }

    public void setPassengerCount(Integer passengerCount) {
        this.passengerCount = passengerCount;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
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

    public Long getPricePolicyId() {
        return pricePolicyId;
    }

    public void setPricePolicyId(Long pricePolicyId) {
        this.pricePolicyId = pricePolicyId;
    }

	public String getCustomerCode() {
		return customerCode;
	}

	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}

	public OrderCancelStatus getOrderCancelStatus() {
		return orderCancelStatus;
	}

	public void setOrderCancelStatus(OrderCancelStatus orderCancelStatus) {
		this.orderCancelStatus = orderCancelStatus;
	}

    
}
