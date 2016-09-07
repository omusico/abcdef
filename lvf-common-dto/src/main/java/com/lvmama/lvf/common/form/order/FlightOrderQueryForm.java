package com.lvmama.lvf.common.form.order;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.lvmama.lvf.common.dto.Pagination;
import com.lvmama.lvf.common.dto.enums.FlightTripType;
import com.lvmama.lvf.common.dto.enums.IDCardType;
import com.lvmama.lvf.common.dto.enums.PassengerType;
import com.lvmama.lvf.common.dto.order.FlightOrderQueryDto;
import com.lvmama.lvf.common.dto.status.order.OrderBookingStatus;
import com.lvmama.lvf.common.dto.status.order.OrderCancelStatus;
import com.lvmama.lvf.common.dto.status.order.OrderPayStatus;
import com.lvmama.lvf.common.form.Form;

public class FlightOrderQueryForm implements Serializable,Form {
	
	private static final long serialVersionUID = -4258647786324722097L;
	/** 订单主键 */
	private Long orderId;
	/** 订单号 */
	private String orderNo;
	/** 关联子订单订单号 */
	private String linkOrderNo;
	/** 供应商订单编号 */
	private String suppOrderNo;
	/** 供应商OFFICE号 */
	private String suppOfficeNo;
	/** 票号 */
	private String ticketNo;
	
	/** 客户姓名 */
	private String customerName;
	/** 联系人姓名 */
	private String contactName;
	/** 手机号码 */
	private String contactNCellphone;
	
	/** 乘客姓名 */
	private String passengerName;
	/** 乘客类型*/
	private PassengerType passengerType;
	/** 乘客人数*/
	private String passengerNum;
	
	/** 证件类型 */
	private IDCardType passengerIDCardType;
	/** 证件号码 */
	private String passengerIDCardNo;
	
	/** PNR编码 */
	private String pnr;
	/** oldPNR(新加) */
	private String oldPnr;
	
	/** 始发地城市名，如：上海 */
	private String deptCityName;
	/** 终到地城市名，如：北京 */
	private String arrvCityName;
	/** 始发地城市名，如：SH*/
	private String deptCityCode;
	/** 终到地城市名，如：BJ*/
	private String arrvCityCode;
	
	  /**出票时间 */
    private Date issueDate;
    /** 创建订单时间 */
    private Date createOrderDate;
    /** 修改订单时间 */
    private Date updateOrderDate;
    /** 起飞时间 */
    private Date departureTime;
    /** 支付时间 */
    private Date payOrderTime;
    
	/** 航程类型 */
	private FlightTripType flightTripType;
	/** 航空公司 */
	private String airplaneCompanyNmae;
	/** 航班号 */
	private String flightNo;
	/** 订单总金额 */
	private BigDecimal orderTotalAmount;
	/** 订单总票面价 */
	private BigDecimal orderTicketAmount;
	
	/** 订单确认状态 **/
	private OrderBookingStatus orderBookingStatus;
	/** 订单支付状态 */
	private OrderPayStatus orderPayStatus;
	/** 订单取消状态 **/
	private OrderCancelStatus orderCancelStatus;
	/** 订单退订状态 */
	private OrderPayStatus orderRefundStatus;
	
	/** 分页对象 */
	private Pagination pagination;
	
	private List<FlightOrderQueryDto> flightOrderQueryList=new ArrayList<FlightOrderQueryDto>();
	
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getLinkOrderNo() {
		return linkOrderNo;
	}
	public void setLinkOrderNo(String linkOrderNo) {
		this.linkOrderNo = linkOrderNo;
	}
	public String getSuppOrderNo() {
		return suppOrderNo;
	}
	public void setSuppOrderNo(String suppOrderNo) {
		this.suppOrderNo = suppOrderNo;
	}
	public String getSuppOfficeNo() {
		return suppOfficeNo;
	}
	public void setSuppOfficeNo(String suppOfficeNo) {
		this.suppOfficeNo = suppOfficeNo;
	}
	public String getTicketNo() {
		return ticketNo;
	}
	public void setTicketNo(String ticketNo) {
		this.ticketNo = ticketNo;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	public String getContactNCellphone() {
		return contactNCellphone;
	}
	public void setContactNCellphone(String contactNCellphone) {
		this.contactNCellphone = contactNCellphone;
	}
	public String getPassengerName() {
		return passengerName;
	}
	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}
	public PassengerType getPassengerType() {
		return passengerType;
	}
	public void setPassengerType(PassengerType passengerType) {
		this.passengerType = passengerType;
	}
	public String getPassengerNum() {
		return passengerNum;
	}
	public void setPassengerNum(String passengerNum) {
		this.passengerNum = passengerNum;
	}
	public IDCardType getPassengerIDCardType() {
		return passengerIDCardType;
	}
	public void setPassengerIDCardType(IDCardType passengerIDCardType) {
		this.passengerIDCardType = passengerIDCardType;
	}
	public String getPassengerIDCardNo() {
		return passengerIDCardNo;
	}
	public void setPassengerIDCardNo(String passengerIDCardNo) {
		this.passengerIDCardNo = passengerIDCardNo;
	}
	public String getPnr() {
		return pnr;
	}
	public void setPnr(String pnr) {
		this.pnr = pnr;
	}
	public String getOldPnr() {
		return oldPnr;
	}
	public void setOldPnr(String oldPnr) {
		this.oldPnr = oldPnr;
	}
	public String getDeptCityName() {
		return deptCityName;
	}
	public void setDeptCityName(String deptCityName) {
		this.deptCityName = deptCityName;
	}
	public String getArrvCityName() {
		return arrvCityName;
	}
	public void setArrvCityName(String arrvCityName) {
		this.arrvCityName = arrvCityName;
	}
	public String getDeptCityCode() {
		return deptCityCode;
	}
	public void setDeptCityCode(String deptCityCode) {
		this.deptCityCode = deptCityCode;
	}
	public String getArrvCityCode() {
		return arrvCityCode;
	}
	public void setArrvCityCode(String arrvCityCode) {
		this.arrvCityCode = arrvCityCode;
	}
	public Date getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}
	public Date getCreateOrderDate() {
		return createOrderDate;
	}
	public void setCreateOrderDate(Date createOrderDate) {
		this.createOrderDate = createOrderDate;
	}
	public Date getUpdateOrderDate() {
		return updateOrderDate;
	}
	public void setUpdateOrderDate(Date updateOrderDate) {
		this.updateOrderDate = updateOrderDate;
	}
	public Date getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(Date departureTime) {
		this.departureTime = departureTime;
	}
	public Date getPayOrderTime() {
		return payOrderTime;
	}
	public void setPayOrderTime(Date payOrderTime) {
		this.payOrderTime = payOrderTime;
	}
	public FlightTripType getFlightTripType() {
		return flightTripType;
	}
	public void setFlightTripType(FlightTripType flightTripType) {
		this.flightTripType = flightTripType;
	}
	public String getAirplaneCompanyNmae() {
		return airplaneCompanyNmae;
	}
	public void setAirplaneCompanyNmae(String airplaneCompanyNmae) {
		this.airplaneCompanyNmae = airplaneCompanyNmae;
	}
	public String getFlightNo() {
		return flightNo;
	}
	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}
	public BigDecimal getOrderTotalAmount() {
		return orderTotalAmount;
	}
	public void setOrderTotalAmount(BigDecimal orderTotalAmount) {
		this.orderTotalAmount = orderTotalAmount;
	}
	public BigDecimal getOrderTicketAmount() {
		return orderTicketAmount;
	}
	public void setOrderTicketAmount(BigDecimal orderTicketAmount) {
		this.orderTicketAmount = orderTicketAmount;
	}
	public OrderBookingStatus getOrderBookingStatus() {
		return orderBookingStatus;
	}
	public void setOrderBookingStatus(OrderBookingStatus orderBookingStatus) {
		this.orderBookingStatus = orderBookingStatus;
	}
	public OrderPayStatus getOrderPayStatus() {
		return orderPayStatus;
	}
	public void setOrderPayStatus(OrderPayStatus orderPayStatus) {
		this.orderPayStatus = orderPayStatus;
	}
	public OrderCancelStatus getOrderCancelStatus() {
		return orderCancelStatus;
	}
	public void setOrderCancelStatus(OrderCancelStatus orderCancelStatus) {
		this.orderCancelStatus = orderCancelStatus;
	}
	public OrderPayStatus getOrderRefundStatus() {
		return orderRefundStatus;
	}
	public void setOrderRefundStatus(OrderPayStatus orderRefundStatus) {
		this.orderRefundStatus = orderRefundStatus;
	}

	public Pagination getPagination() {
		return pagination;
	}
	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}
	
	public List<FlightOrderQueryDto> getFlightOrderQueryList() {
		return flightOrderQueryList;
	}
	public void setFlightOrderQueryList(
			List<FlightOrderQueryDto> flightOrderQueryList) {
		this.flightOrderQueryList = flightOrderQueryList;
	}
	
}
