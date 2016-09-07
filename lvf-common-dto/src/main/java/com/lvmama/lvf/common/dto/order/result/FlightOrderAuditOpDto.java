package com.lvmama.lvf.common.dto.order.result;

import java.io.Serializable;
import java.util.Date;

import com.lvmama.lvf.common.dto.Entity;
import com.lvmama.lvf.common.dto.enums.AuditStatus;
import com.lvmama.lvf.common.dto.enums.AuditType;
import com.lvmama.lvf.common.dto.enums.OrderType;
import com.lvmama.lvf.common.dto.order.FlightOrderContacterDto;
import com.lvmama.lvf.common.dto.order.FlightOrderCustomerDto;
import com.lvmama.lvf.common.dto.order.FlightOrderNoDto;
import com.lvmama.lvf.common.dto.order.FlightOrderPNRInfoDto;
import com.lvmama.lvf.common.dto.order.FlightOrderPassengerDto;
import com.lvmama.lvf.common.dto.order.FlightOrderTicketInfoDto;
import com.lvmama.lvf.common.dto.status.order.OrderAuditStatus;
import com.lvmama.lvf.common.dto.status.order.OrderTicketStatus;
import com.lvmama.lvf.common.dto.status.order.SuppOrderAuditStatus;

/**
 * 出票改签退票审核/处理列表
 * 
 * @author yuanweihong
 * @date 2015-3-11
 */
public class FlightOrderAuditOpDto extends Entity implements Serializable {

    private static final long serialVersionUID = -8792440122471810037L;

    /** 主订单id */
    private Long orderMainId;

    /** 订单id */
    private Long orderId;

    /** 订单号信息 */
    private FlightOrderNoDto flightOrderNo;
    
    /** 原订单号 */
    private String preOrderNo;

    /** PNR信息 */
    private FlightOrderPNRInfoDto flightOrderPNRInfo;

    /** 航班号 */
    private String flightNo;

    /** 出发机场三字代码 */
    private String depCode;

    /** 到达机场三字代码 */
    private String arrCode;

    /** 舱位代码 */
    private String seatClassCode;

    /** 起飞时间 */
    private String flightTime;
    
    /** 订单类型 */
    private OrderType orderType;

    /** 订单审核类型(后台) */
    private AuditStatus auditStatus;

    /** 订单审核类型 */
    private AuditType auditType;

    /** 订单审核状态 */
    private OrderAuditStatus orderAuditStatus;

    /** 订单机票出票状态 */
    private OrderTicketStatus orderTicketStatus;
    
    /** 订单供应商审核状态 */
    private SuppOrderAuditStatus suppOrderAuditStatus;

    /** 订单对应客户信息 */
    private FlightOrderCustomerDto flightOrderCustomer;

    /** 订单联系人信息 */
    private FlightOrderContacterDto flightOrderContacter;

    /** 乘客信息 */
    private FlightOrderPassengerDto flightOrderPassenger;

    /** 订单对应票价、乘机人相关信息 */
    private FlightOrderTicketInfoDto flightOrderTicketInfoDto;

    /** 预订时间 */
    private String bookingTime;

    /** 自进入审核流程开始计时，截止审核通过/退回时间 （效率） */
    private Date orderUpdateTime;

    /** 业务员 */
    public String oper;

    /** 备注 */
    private String remark;
    
    /** 供应商 */
    private String suppCode;
    
    private Long orderRootId;

    private String saleType;

    public Long getOrderMainId() {
        return orderMainId;
    }

    public void setOrderMainId(Long orderMainId) {
        this.orderMainId = orderMainId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public FlightOrderNoDto getFlightOrderNo() {
        return flightOrderNo;
    }

    public void setFlightOrderNo(FlightOrderNoDto flightOrderNo) {
        this.flightOrderNo = flightOrderNo;
    }

    public FlightOrderPNRInfoDto getFlightOrderPNRInfo() {
        return flightOrderPNRInfo;
    }

    public void setFlightOrderPNRInfo(FlightOrderPNRInfoDto flightOrderPNRInfo) {
        this.flightOrderPNRInfo = flightOrderPNRInfo;
    }

    public String getFlightNo() {
        return flightNo;
    }

    public void setFlightNo(String flightNo) {
        this.flightNo = flightNo;
    }

    public String getDepCode() {
        return depCode;
    }

    public void setDepCode(String depCode) {
        this.depCode = depCode;
    }

    public String getArrCode() {
        return arrCode;
    }

    public void setArrCode(String arrCode) {
        this.arrCode = arrCode;
    }

    public String getSeatClassCode() {
        return seatClassCode;
    }

    public void setSeatClassCode(String seatClassCode) {
        this.seatClassCode = seatClassCode;
    }

    public String getFlightTime() {
        return flightTime;
    }

    public void setFlightTime(String flightTime) {
        this.flightTime = flightTime;
    }

    public AuditType getAuditType() {
        return auditType;
    }

    public void setAuditType(AuditType auditType) {
        this.auditType = auditType;
    }

    public OrderAuditStatus getOrderAuditStatus() {
        return orderAuditStatus;
    }

    public void setOrderAuditStatus(OrderAuditStatus orderAuditStatus) {
        this.orderAuditStatus = orderAuditStatus;
    }

    public OrderTicketStatus getOrderTicketStatus() {
        return orderTicketStatus;
    }

    public void setOrderTicketStatus(OrderTicketStatus orderTicketStatus) {
        this.orderTicketStatus = orderTicketStatus;
    }

    public FlightOrderCustomerDto getFlightOrderCustomer() {
        return flightOrderCustomer;
    }

    public void setFlightOrderCustomer(FlightOrderCustomerDto flightOrderCustomer) {
        this.flightOrderCustomer = flightOrderCustomer;
    }

    public FlightOrderContacterDto getFlightOrderContacter() {
        return flightOrderContacter;
    }

    public void setFlightOrderContacter(FlightOrderContacterDto flightOrderContacter) {
        this.flightOrderContacter = flightOrderContacter;
    }

    public FlightOrderPassengerDto getFlightOrderPassenger() {
        return flightOrderPassenger;
    }

    public void setFlightOrderPassenger(FlightOrderPassengerDto flightOrderPassenger) {
        this.flightOrderPassenger = flightOrderPassenger;
    }

    public FlightOrderTicketInfoDto getFlightOrderTicketInfoDto() {
        return flightOrderTicketInfoDto;
    }

    public void setFlightOrderTicketInfoDto(FlightOrderTicketInfoDto flightOrderTicketInfoDto) {
        this.flightOrderTicketInfoDto = flightOrderTicketInfoDto;
    }

    public String getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(String bookingTime) {
        this.bookingTime = bookingTime;
    }

    public Date getOrderUpdateTime() {
        return orderUpdateTime;
    }

    public void setOrderUpdateTime(Date orderUpdateTime) {
        this.orderUpdateTime = orderUpdateTime;
    }

    public String getOper() {
        return oper;
    }

    public void setOper(String oper) {
        this.oper = oper;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public AuditStatus getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(AuditStatus auditStatus) {
        this.auditStatus = auditStatus;
    }

    public String getPreOrderNo() {
        return preOrderNo;
    }

    public void setPreOrderNo(String preOrderNo) {
        this.preOrderNo = preOrderNo;
    }

    public SuppOrderAuditStatus getSuppOrderAuditStatus() {
        return suppOrderAuditStatus;
    }

    public void setSuppOrderAuditStatus(SuppOrderAuditStatus suppOrderAuditStatus) {
        this.suppOrderAuditStatus = suppOrderAuditStatus;
    }

	public OrderType getOrderType() {
		return orderType;
	}

	public void setOrderType(OrderType orderType) {
		this.orderType = orderType;
	}

	public String getSuppCode() {
		return suppCode;
	}

	public void setSuppCode(String suppCode) {
		this.suppCode = suppCode;
	}

	public Long getOrderRootId() {
		return orderRootId;
	}

	public void setOrderRootId(Long orderRootId) {
		this.orderRootId = orderRootId;
	}

    public String getSaleType() {
        return saleType;
    }

    public void setSaleType(String saleType) {
        this.saleType = saleType;
    }
}
