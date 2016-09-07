package com.lvmama.lvf.common.dto.request;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import com.lvmama.lvf.common.dto.BaseQueryDto;
import com.lvmama.lvf.common.dto.Pagination;
import com.lvmama.lvf.common.dto.order.FlightOrderQueryDto;

@XmlRootElement
public class FlightOrderQueryRequest extends BaseQueryDto<FlightOrderQueryDto> implements Serializable {

	private static final long serialVersionUID = -318893671939342016L;
	
	/** 订单id */
	private String orderId;
	/** 订单号 */
	private String orderNo;
	/** PNR编码 */
	private String pnr;
	/** 订单联系人姓名 */
	private String contacterName;
	/** 订单联系人电话 */
	private String contactPhone;
	/** 票号 */
	private String ticketNo;
	/** 乘客名称 */
	private String passengerName;
	/** 下单时间 */
	private String orderDate;
	/** 订单状态 */
	private String orderStatus;
	/** 始发地 */
	private String depName;
	/** 目的地 */
	private String arrName;
	/** 起飞时间 */
	private String depTime;
	/** 航空公司 */
	private String carrierName;
	/** 航班号 */
	private String flightNo;
	
	private Pagination pagination;
	
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
	public String getPnr() {
		return pnr;
	}
	public void setPnr(String pnr) {
		this.pnr = pnr;
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
	public String getPassengerName() {
		return passengerName;
	}
	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public String getDepName() {
		return depName;
	}
	public void setDepName(String depName) {
		this.depName = depName;
	}
	public String getArrName() {
		return arrName;
	}
	public void setArrName(String arrName) {
		this.arrName = arrName;
	}
	public String getDepTime() {
		return depTime;
	}
	public void setDepTime(String depTime) {
		this.depTime = depTime;
	}
	public String getCarrierName() {
		return carrierName;
	}
	public void setCarrierName(String carrierName) {
		this.carrierName = carrierName;
	}
	public String getFlightNo() {
		return flightNo;
	}
	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}
	public Pagination getPagination() {
		return pagination;
	}
	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}
	
	
	
}
