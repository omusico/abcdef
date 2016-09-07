package com.lvmama.lvf.common.dto.request;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnore;

import com.lvmama.lvf.common.dto.Dto;
import com.lvmama.lvf.common.dto.enums.AuditStatus;
import com.lvmama.lvf.common.dto.enums.AuditType;
import com.lvmama.lvf.common.dto.enums.OrderFlag;
import com.lvmama.lvf.common.dto.status.order.OrderCancelStatus;

/**
 * 出票改签退票审核/处理列表请求对象
 * 
 * @author yuanweihong
 * @date 2015-3-11
 */
@XmlRootElement
public class FlightOrderAuditOpRequest implements Serializable, Dto {

    private static final long serialVersionUID = 5594726466953444184L;

    /** 主订单id */
    private String orderMainId;

    /** 主订单号 */
    private String orderMainNo;

    /** 子订单id */
    private String orderId;

    /** 子订单号 */
    private String orderNo;

    /** 供应商订单号 */
    private String suppOrderNo;

    /** 采购订单号 */
    private String officeNo;

    /** 驴妈妈账号 */
    private String lvmamaAccount;

    /** PNR编码 */
    private String pnr;

    /** 客户 */
    private String customerName;

    /** 乘客名称 */
    private String passenger;

    /** 乘机人证件号 */
    private String passengerIDCardNo;

    /** 乘客手机 */
    private String passengerCellphone;

    /** 订单联系人姓名 */
    private String contacterName;

    /** 订单联系人电话 */
    private String contactPhone;

    /** 票号 */
    private String ticketNo;

    /** 航班号 */
    private String flightNo;

    /** 订单状态 */
    private String orderStatus;

    /** 订单审核类型(后台) */
    private AuditStatus auditStatus;

    /** 订单类型(后台) */
    private AuditType auditType;

    /** 出发城市 */
    private String departureCity;

    /** 到达城市 */
    private String arriveCity;

    /** 建单开始时间 */
    private String bookingQueryBegTime;

    /** 建单截止时间 */
    private String bookingQueryEndTime;

    /** 起飞开始时间 */
    private String flightQueryBegTime;

    /** 起飞截止时间 */
    private String flightQueryEndTime;

    /** 出票开始时间 */
    private String issueBegTime;

    /** 出票截止时间 */
    private String issueEndTime;

    /** 修改开始时间 */
    private String updateBegTime;

    /** 修改截止时间 */
    private String updateEndTime;

    /** 提交开始时间 */
    private String commitBegTime;

    /** 提交截止时间 */
    private String commitEndTime;

    /** 收款开始时间 */
    private String gatherBegTime;

    /** 收款截止时间 */
    private String gatherEndTime;

    /** 创建人 */
    private String createPer;

    /** 付款人 */
    private String payer;

    /** 审核员 */
    private String auditPer;

    /** 出票员 */
    private String issuePer;

    /** 收款员 */
    private String gatherPer;
    
	/** 订单账户类型*/
	private OrderFlag orderFlag;
	
	/** 供应商 */
	private String suppCode;
	
	/**政策类型*/
	private String saleType;
	
	/** 订单取消状态*/
	private OrderCancelStatus orderCancelStatus;

    public String getOrderMainId() {
        return orderMainId;
    }

    public void setOrderMainId(String orderMainId) {
        this.orderMainId = orderMainId;
    }

    public String getOrderMainNo() {
        return orderMainNo;
    }

    public void setOrderMainNo(String orderMainNo) {
        this.orderMainNo = orderMainNo;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getSuppOrderNo() {
        return suppOrderNo;
    }

    public void setSuppOrderNo(String suppOrderNo) {
        this.suppOrderNo = suppOrderNo;
    }

    public String getOfficeNo() {
        return officeNo;
    }

    public void setOfficeNo(String officeNo) {
        this.officeNo = officeNo;
    }

    public String getLvmamaAccount() {
        return lvmamaAccount;
    }

    public void setLvmamaAccount(String lvmamaAccount) {
        this.lvmamaAccount = lvmamaAccount;
    }

    public String getPnr() {
        return pnr;
    }

    public void setPnr(String pnr) {
        this.pnr = pnr;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPassenger() {
        return passenger;
    }

    public void setPassenger(String passenger) {
        this.passenger = passenger;
    }

    public String getPassengerIDCardNo() {
        return passengerIDCardNo;
    }

    public void setPassengerIDCardNo(String passengerIDCardNo) {
        this.passengerIDCardNo = passengerIDCardNo;
    }

    public String getPassengerCellphone() {
        return passengerCellphone;
    }

    public void setPassengerCellphone(String passengerCellphone) {
        this.passengerCellphone = passengerCellphone;
    }

    public String getContacterName() {
        return contacterName;
    }

    public void setContacterName(String contacterName) {
        this.contacterName = contacterName;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getTicketNo() {
        return ticketNo;
    }

    public void setTicketNo(String ticketNo) {
        this.ticketNo = ticketNo;
    }

    public String getFlightNo() {
        return flightNo;
    }

    public void setFlightNo(String flightNo) {
        this.flightNo = flightNo;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public AuditType getAuditType() {
        return auditType;
    }

    public void setAuditType(AuditType auditType) {
        this.auditType = auditType;
    }

    public String getDepartureCity() {
        return departureCity;
    }

    public void setDepartureCity(String departureCity) {
        this.departureCity = departureCity;
    }

    public String getArriveCity() {
        return arriveCity;
    }

    public void setArriveCity(String arriveCity) {
        this.arriveCity = arriveCity;
    }

    public String getBookingQueryBegTime() {
        return bookingQueryBegTime;
    }

    public void setBookingQueryBegTime(String bookingQueryBegTime) {
        this.bookingQueryBegTime = bookingQueryBegTime;
    }

    public String getBookingQueryEndTime() {
        return bookingQueryEndTime;
    }

    public void setBookingQueryEndTime(String bookingQueryEndTime) {
        this.bookingQueryEndTime = bookingQueryEndTime;
    }

    public String getFlightQueryBegTime() {
        return flightQueryBegTime;
    }

    public void setFlightQueryBegTime(String flightQueryBegTime) {
        this.flightQueryBegTime = flightQueryBegTime;
    }

    public String getFlightQueryEndTime() {
        return flightQueryEndTime;
    }

    public void setFlightQueryEndTime(String flightQueryEndTime) {
        this.flightQueryEndTime = flightQueryEndTime;
    }

    public String getIssueBegTime() {
        return issueBegTime;
    }

    public void setIssueBegTime(String issueBegTime) {
        this.issueBegTime = issueBegTime;
    }

    public String getIssueEndTime() {
        return issueEndTime;
    }

    public void setIssueEndTime(String issueEndTime) {
        this.issueEndTime = issueEndTime;
    }

    public String getUpdateBegTime() {
        return updateBegTime;
    }

    public void setUpdateBegTime(String updateBegTime) {
        this.updateBegTime = updateBegTime;
    }

    public String getUpdateEndTime() {
        return updateEndTime;
    }

    public void setUpdateEndTime(String updateEndTime) {
        this.updateEndTime = updateEndTime;
    }

    public String getCommitBegTime() {
        return commitBegTime;
    }

    public void setCommitBegTime(String commitBegTime) {
        this.commitBegTime = commitBegTime;
    }

    public String getCommitEndTime() {
        return commitEndTime;
    }

    public void setCommitEndTime(String commitEndTime) {
        this.commitEndTime = commitEndTime;
    }

    public String getGatherBegTime() {
        return gatherBegTime;
    }

    public void setGatherBegTime(String gatherBegTime) {
        this.gatherBegTime = gatherBegTime;
    }

    public String getGatherEndTime() {
        return gatherEndTime;
    }

    public void setGatherEndTime(String gatherEndTime) {
        this.gatherEndTime = gatherEndTime;
    }

    public String getCreatePer() {
        return createPer;
    }

    public void setCreatePer(String createPer) {
        this.createPer = createPer;
    }

    public String getPayer() {
        return payer;
    }

    public void setPayer(String payer) {
        this.payer = payer;
    }

    public String getAuditPer() {
        return auditPer;
    }

    public void setAuditPer(String auditPer) {
        this.auditPer = auditPer;
    }

    public String getIssuePer() {
        return issuePer;
    }

    public void setIssuePer(String issuePer) {
        this.issuePer = issuePer;
    }

    public String getGatherPer() {
        return gatherPer;
    }

    public void setGatherPer(String gatherPer) {
        this.gatherPer = gatherPer;
    }

    public AuditStatus getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(AuditStatus auditStatus) {
        this.auditStatus = auditStatus;
    }

    @JsonIgnore
    @Override
    public Long getId() {
        // TODO Auto-generated method stub
        return null;
    }

	public OrderFlag getOrderFlag() {
		return orderFlag;
	}

	public void setOrderFlag(OrderFlag orderFlag) {
		this.orderFlag = orderFlag;
	}
	
	public String getSuppCode() {
		return suppCode;
	}

	public void setSuppCode(String suppCode) {
		this.suppCode = suppCode;
	}

	/**
	 * @return  the orderCancelStatus
	 */
	public OrderCancelStatus getOrderCancelStatus() {
		return orderCancelStatus;
	}

	/**
	 * @param orderCancelStatus the orderCancelStatus to set
	 */
	public void setOrderCancelStatus(OrderCancelStatus orderCancelStatus) {
		this.orderCancelStatus = orderCancelStatus;
	}

	public String getSaleType() {
		return saleType;
	}

	public void setSaleType(String saleType) {
		this.saleType = saleType;
	}
	

}
