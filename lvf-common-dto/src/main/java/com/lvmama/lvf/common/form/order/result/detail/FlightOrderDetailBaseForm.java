/**
 * 
 */
package com.lvmama.lvf.common.form.order.result.detail;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.lvmama.lvf.common.dto.enums.BookingSource;
import com.lvmama.lvf.common.dto.enums.OrderType;
import com.lvmama.lvf.common.dto.enums.PayType;
import com.lvmama.lvf.common.dto.enums.Product;
import com.lvmama.lvf.common.dto.order.FlightOrderAmountDto;
import com.lvmama.lvf.common.dto.order.FlightOrderContacterDto;
import com.lvmama.lvf.common.dto.order.FlightOrderCustomerDto;
import com.lvmama.lvf.common.dto.order.pay.FlightOrderPaymentDto;
import com.lvmama.lvf.common.dto.order.pay.FlightOrderRefundDto;
import com.lvmama.lvf.common.dto.order.result.detail.FlightOrderDetailBaseDto;
import com.lvmama.lvf.common.dto.order.status.FlightOrderStatusDto;
import com.lvmama.lvf.common.dto.status.Op;
import com.lvmama.lvf.common.form.Form;

/**
 *  订单详情基本信息表单
 * @author lven
 * @date 2015-2-5
 * 
 */
public class FlightOrderDetailBaseForm implements Serializable, Form 
{
	private static final long serialVersionUID = -1986499631258029527L;

	private FlightOrderDetailBaseDto flightOrderDetailBase = new FlightOrderDetailBaseDto();


	public Date getFinishBookingTime() {
		return flightOrderDetailBase.getFinishBookingTime();
	}

	public void setFinishBookingTime(Date finishBookingTime) {
		flightOrderDetailBase.setFinishBookingTime(finishBookingTime);
	}

	public Date getLimitTime() {
		return flightOrderDetailBase.getLimitTime();
	}

	public void setLimitTime(Date limitTime) {
		flightOrderDetailBase.setLimitTime(limitTime);
	}

	public FlightOrderStatusDto getFlightOrderStatus() {
		return flightOrderDetailBase.getFlightOrderStatus();
	}

	public void setFlightOrderStatus(FlightOrderStatusDto flightOrderStatus) {
		flightOrderDetailBase.setFlightOrderStatus(flightOrderStatus);
	}

	public List<Op> getOps() {
		return flightOrderDetailBase.getOps();
	}

	public void setOps(List<Op> ops) {
		flightOrderDetailBase.setOps(ops);
	}

	public FlightOrderDetailBaseDto getFlightOrderDetailBase() {
		return flightOrderDetailBase;
	}

	public void setFlightOrderDetailBase(
			FlightOrderDetailBaseDto flightOrderDetailBase) {
		this.flightOrderDetailBase = flightOrderDetailBase;
	}

	public Long getOrderMainId() {
		return flightOrderDetailBase.getOrderMainId();
	}

	public void setOrderMainId(Long orderMainId) {
		flightOrderDetailBase.setOrderMainId(orderMainId);
	}

	public Long getOrderId() {
		return flightOrderDetailBase.getOrderId();
	}

	public void setOrderId(Long orderId) {
		flightOrderDetailBase.setOrderId(orderId);
	}

	public Long getAuditOpId() {
		return flightOrderDetailBase.getAuditOpId();
	}

	public void setAuditOpId(Long auditOpId) {
		flightOrderDetailBase.setAuditOpId(auditOpId);
	}

	public String getOrderNo() {
		return flightOrderDetailBase.getOrderNo();
	}

	public String getOrderMainNo() {
		return flightOrderDetailBase.getOrderMainNo();
	}

	public void setOrderMainNo(String orderMainNo) {
		flightOrderDetailBase.setOrderMainNo(orderMainNo);
	}

	public List<String> getSuppOrderNos() {
		return flightOrderDetailBase.getSuppOrderNos();
	}

	public void setSuppOrderNos(List<String> suppOrderNos) {
		flightOrderDetailBase.setSuppOrderNos(suppOrderNos);
	}

	public List<String> getSuppRefundNos() {
		return flightOrderDetailBase.getSuppRefundNos();
	}

	public void setSuppRefundNos(List<String> suppRefundNos) {
		flightOrderDetailBase.setSuppRefundNos(suppRefundNos);
	}

	public void setOrderNo(String orderNo) {
		flightOrderDetailBase.setOrderNo(orderNo);
	}

	public BookingSource getBookingSource() {
		return flightOrderDetailBase.getBookingSource();
	}

	public void setBookingSource(BookingSource bookingSource) {
		flightOrderDetailBase.setBookingSource(bookingSource);
	}

	public PayType getPayType() {
		return flightOrderDetailBase.getPayType();
	}

	public void setPayType(PayType payType) {
		flightOrderDetailBase.setPayType(payType);
	}

	public FlightOrderContacterDto getFlightOrderContacter() {
		return flightOrderDetailBase.getFlightOrderContacter();
	}

	public void setFlightOrderContacter(
			FlightOrderContacterDto flightOrderContacter) {
		flightOrderDetailBase.setFlightOrderContacter(flightOrderContacter);
	}

	public String getCustomerRemark() {
		return flightOrderDetailBase.getCustomerRemark();
	}

	public void setCustomerRemark(String customerRemark) {
		flightOrderDetailBase.setCustomerRemark(customerRemark);
	}

	public Date getCreateTime() {
		return flightOrderDetailBase.getCreateTime();
	}

	public void setCreateTime(Date createTime) {
		flightOrderDetailBase.setCreateTime(createTime);
	}

	public Product getProduct() {
		return flightOrderDetailBase.getProduct();
	}

	public void setProduct(Product product) {
		flightOrderDetailBase.setProduct(product);
	}

	public FlightOrderAmountDto getFlightOrderAmountDto() {
		return flightOrderDetailBase.getFlightOrderAmountDto();
	}

	public void setFlightOrderAmountDto(
			FlightOrderAmountDto flightOrderAmountDto) {
		flightOrderDetailBase.setFlightOrderAmountDto(flightOrderAmountDto);
	}

	public OrderType getOrderType() {
		return flightOrderDetailBase.getOrderType();
	}

	public void setOrderType(OrderType orderType) {
		flightOrderDetailBase.setOrderType(orderType);
	}

	public FlightOrderCustomerDto getFlightOrderCustomer() {
		return flightOrderDetailBase.getFlightOrderCustomer();
	}

	public void setFlightOrderCustomer(
			FlightOrderCustomerDto flightOrderCustomer) {
		flightOrderDetailBase.setFlightOrderCustomer(flightOrderCustomer);
	}

	public List<FlightOrderPaymentDto> getFlightOrderPayments() {
		return flightOrderDetailBase.getFlightOrderPayments();
	}

	public void setFlightOrderPayments(
			List<FlightOrderPaymentDto> flightOrderPayments) {
		flightOrderDetailBase.setFlightOrderPayments(flightOrderPayments);
	}

	public List<FlightOrderRefundDto> getFlightOrderRefunds() {
		return flightOrderDetailBase.getFlightOrderRefunds();
	}

	public void setFlightOrderRefunds(
			List<FlightOrderRefundDto> flightOrderRefunds) {
		flightOrderDetailBase.setFlightOrderRefunds(flightOrderRefunds);
	}

	public Long getSalesOrderId() {
		return flightOrderDetailBase.getSalesOrderId();
	}

	public Long getSalesMainOrderId() {
		return flightOrderDetailBase.getSalesMainOrderId();
	}

	public void setSalesOrderId(Long salesOrderId) {
		flightOrderDetailBase.setSalesOrderId(salesOrderId);
	}

	public void setSalesMainOrderId(Long salesMainOrderId) {
		flightOrderDetailBase.setSalesMainOrderId(salesMainOrderId);
	}

	public List<String> getSuppCodes() {
		return flightOrderDetailBase.getSuppCodes();
	}

	public void setSuppCodes(List<String> suppCodes) {
		flightOrderDetailBase.setSuppCodes(suppCodes);
	}
	
}
