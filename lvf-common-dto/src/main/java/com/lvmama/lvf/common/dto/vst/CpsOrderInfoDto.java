package com.lvmama.lvf.common.dto.vst;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
/**
 * Cps 需要的订单信息
 */
public class CpsOrderInfoDto implements Serializable{
	/*cpsId*/
	private String cpsId; 
	/*机票子订单单号*/
	private String orderNo;
	/*出发日期*/
	private Long departureDate;
	/*机票舱位*/
	private String flightSeatClassType;
	/*航班号*/
	private String flightNo;
	/*用户Id*/
	private String userId;
	/*用户No*/
	private String userNo;
	/*订位状态*/
	private String bookStatus;
	/*支付状态*/
	private String payStatus;
	/*取消状态*/
	private String cancelStatus;
	/*出票状态*/
	private String issueStatus;
	/*建单时间*/
	private Date createTime;
	/*支付时间*/
	private Date payTime;
	/*乘客人数*/
	private Integer passengerCount;
	/*机票成本结算价*/
	private BigDecimal planeTicketSettlePrice;
	/*保险结算价*/
	private BigDecimal insuranceSettlePrice;
	/*快递结算价*/
	private BigDecimal expressSettlePrice;
	/*应收款*/
	private BigDecimal prepaidAmount;
	/*应付款*/
	private BigDecimal payableAmount;
	
	public String getCpsId() {
		return cpsId;
	}
	public void setCpsId(String cpsId) {
		this.cpsId = cpsId;
	}
	public String getFlightSeatClassType() {
		return flightSeatClassType;
	}
	public void setFlightSeatClassType(String flightSeatClassType) {
		this.flightSeatClassType = flightSeatClassType;
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
	public String getBookStatus() {
		return bookStatus;
	}
	public void setBookStatus(String bookStatus) {
		this.bookStatus = bookStatus;
	}
	public String getPayStatus() {
		return payStatus;
	}
	public void setPayStatus(String payStatus) {
		this.payStatus = payStatus;
	}
	public String getCancelStatus() {
		return cancelStatus;
	}
	public void setCancelStatus(String cancelStatus) {
		this.cancelStatus = cancelStatus;
	}
	public String getIssueStatus() {
		return issueStatus;
	}
	public void setIssueStatus(String issueStatus) {
		this.issueStatus = issueStatus;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getPayTime() {
		return payTime;
	}
	public void setPayTime(Date payTime) {
		this.payTime = payTime;
	}
	public Integer getPassengerCount() {
		return passengerCount;
	}
	public void setPassengerCount(Integer passengerCount) {
		this.passengerCount = passengerCount;
	}
	public BigDecimal getPlaneTicketSettlePrice() {
		return planeTicketSettlePrice;
	}
	public void setPlaneTicketSettlePrice(BigDecimal planeTicketSettlePrice) {
		this.planeTicketSettlePrice = planeTicketSettlePrice;
	}
	public BigDecimal getInsuranceSettlePrice() {
		return insuranceSettlePrice;
	}
	public void setInsuranceSettlePrice(BigDecimal insuranceSettlePrice) {
		this.insuranceSettlePrice = insuranceSettlePrice;
	}
	public BigDecimal getExpressSettlePrice() {
		return expressSettlePrice;
	}
	public void setExpressSettlePrice(BigDecimal expressSettlePrice) {
		this.expressSettlePrice = expressSettlePrice;
	}
	public BigDecimal getPrepaidAmount() {
		return prepaidAmount;
	}
	public void setPrepaidAmount(BigDecimal prepaidAmount) {
		this.prepaidAmount = prepaidAmount;
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
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public BigDecimal getPayableAmount() {
		return payableAmount;
	}
	public void setPayableAmount(BigDecimal payableAmount) {
		this.payableAmount = payableAmount;
	}
}
