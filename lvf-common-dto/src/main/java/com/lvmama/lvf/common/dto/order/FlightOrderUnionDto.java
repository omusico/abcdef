package com.lvmama.lvf.common.dto.order;

import java.math.BigDecimal;
import java.util.Date;

import com.lvmama.lvf.common.dto.Entity;

public class FlightOrderUnionDto extends Entity {
	
	private static final long serialVersionUID = -8516559995903659908L;
	//机票子订单号  OR   关联退票子单号  OR   机票改期子订单号
	private String orderNo;
	//user Id 
	private String userId;
	//UserNo 
	private String userNo;
	//订单类型
	private String orderType;
	//订单状态
	private String orderStatus;
	//机票状态
	private String ticketStatus;
	//支付状态
	private String payStatus;
	//支付、退票或改期日期
	private Date operDate;
	//应付金额
	private BigDecimal payAmount;
	//实付金额
	private BigDecimal ActualPayAmount;
	//改期或退票关联正常出票子单号
	private String preOrderNo;
	//退票金额
	private BigDecimal refundAmount;
	//退款单号
	private String refundNo;
	
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserNo() {
		return userNo;
	}
	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}
	public String getOrderType() {
		return orderType;
	}
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public String getTicketStatus() {
		return ticketStatus;
	}
	public void setTicketStatus(String ticketStatus) {
		this.ticketStatus = ticketStatus;
	}
	public String getPayStatus() {
		return payStatus;
	}
	public void setPayStatus(String payStatus) {
		this.payStatus = payStatus;
	}
	public Date getOperDate() {
		return operDate;
	}
	public void setOperDate(Date operDate) {
		this.operDate = operDate;
	}
	public BigDecimal getPayAmount() {
		return payAmount;
	}
	public void setPayAmount(BigDecimal payAmount) {
		this.payAmount = payAmount;
	}
	public BigDecimal getActualPayAmount() {
		return ActualPayAmount;
	}
	public void setActualPayAmount(BigDecimal actualPayAmount) {
		ActualPayAmount = actualPayAmount;
	}
	/**
	 * @return  the preOrderNo
	 */
	public String getPreOrderNo() {
		return preOrderNo;
	}
	/**
	 * @param preOrderNo the preOrderNo to set
	 */
	public void setPreOrderNo(String preOrderNo) {
		this.preOrderNo = preOrderNo;
	}
	public BigDecimal getRefundAmount() {
		return refundAmount;
	}
	public void setRefundAmount(BigDecimal refundAmount) {
		this.refundAmount = refundAmount;
	}
	/**
	 * @return  the refundNo
	 */
	public String getRefundNo() {
		return refundNo;
	}
	/**
	 * @param refundNo the refundNo to set
	 */
	public void setRefundNo(String refundNo) {
		this.refundNo = refundNo;
	}
	
	
}
