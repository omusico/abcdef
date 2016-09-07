package com.lvmama.lvfit.common.form.order;

import java.io.Serializable;
import java.math.BigDecimal;

import com.lvmama.lvf.common.form.Form;
import com.lvmama.lvfit.common.dto.enums.FlightTripType;
import com.lvmama.lvfit.common.dto.enums.PassengerType;
import com.lvmama.lvfit.common.dto.enums.BizEnum.BIZ_CATEGORY_TYPE;
import com.lvmama.lvfit.common.dto.order.FitOrderFlightDto;
import com.lvmama.lvfit.common.dto.order.FitOrderHotelDto;
import com.lvmama.lvfit.common.dto.order.FitOrderQueryListDto;
import com.lvmama.lvfit.common.dto.order.FitSuppMainOrderStatusDto;
import com.lvmama.lvfit.common.dto.status.order.OrderBookingStatus;

public class FitOrderQueryListForm implements Serializable, Form {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1006908489549469308L;
	
	private FitOrderQueryListDto fitOrderQueryListDto;
	public FitOrderQueryListDto getFitOrderQueryListDto() {
		return fitOrderQueryListDto;
	}

	public void setFitOrderQueryListDto(FitOrderQueryListDto fitOrderQueryListDto) {
		this.fitOrderQueryListDto = fitOrderQueryListDto;
	}
	
public final Long getOrderMainId() {
	return fitOrderQueryListDto.getOrderMainId();
}
public final void setOrderMainId(Long orderMainId) {
	fitOrderQueryListDto.setOrderMainId(orderMainId);
}
public final Long getDetailCount() {
	return fitOrderQueryListDto.getDetailCount();
}
public final void setDetailCount(Long detailCount) {
	fitOrderQueryListDto.setDetailCount(detailCount);
}
public final FitOrderFlightDto getFitOrderFlightDto() {
	return fitOrderQueryListDto.getFitOrderFlightDto();
}
public final void setFitOrderFlightDto(FitOrderFlightDto fitOrderFlightDto) {
	fitOrderQueryListDto.setFitOrderFlightDto(fitOrderFlightDto);
}
public final FitOrderHotelDto getFitOrderHotelDto() {
	return fitOrderQueryListDto.getFitOrderHotelDto();
}
public final void setFitOrderHotelDto(FitOrderHotelDto fitOrderHotelDto) {
	fitOrderQueryListDto.setFitOrderHotelDto(fitOrderHotelDto);
}
public final String getBookingSource() {
	return fitOrderQueryListDto.getBookingSource();
}
public final void setBookingSource(String bookingSource) {
	fitOrderQueryListDto.setBookingSource(bookingSource);
}
public final Long getVstMainOrderNo() {
	return fitOrderQueryListDto.getVstMainOrderNo();
}
public final void setVstMainOrderNo(Long vstMainOrderNo) {
	fitOrderQueryListDto.setVstMainOrderNo(vstMainOrderNo);
}
public final Long getMainId() {
	return fitOrderQueryListDto.getMainId();
}
public final void setMainId(Long mainId) {
	fitOrderQueryListDto.setMainId(mainId);
}
public final String getMainOrderNo() {
	return fitOrderQueryListDto.getMainOrderNo();
}
public final void setMainOrderNo(String mainOrderNo) {
	fitOrderQueryListDto.setMainOrderNo(mainOrderNo);
}
public final String getVstOrderNo() {
	return fitOrderQueryListDto.getVstOrderNo();
}
public final void setVstOrderNo(String vstOrderNo) {
	fitOrderQueryListDto.setVstOrderNo(vstOrderNo);
}
public final String getContactName() {
	return fitOrderQueryListDto.getContactName();
}
public final void setContactName(String contactName) {
	fitOrderQueryListDto.setContactName(contactName);
}
public final String getOrderNo() {
	return fitOrderQueryListDto.getOrderNo();
}
public final void setOrderNo(String orderNo) {
	fitOrderQueryListDto.setOrderNo(orderNo);
}
public final String getDepartureDate() {
	return fitOrderQueryListDto.getDepartureDate();
}
public final void setDepartureDate(String departureDate) {
	fitOrderQueryListDto.setDepartureDate(departureDate);
}
public final Long getAdultQuantity() {
	return fitOrderQueryListDto.getAdultQuantity();
}
public final void setAdultQuantity(Long adultQuantity) {
	fitOrderQueryListDto.setAdultQuantity(adultQuantity);
}
public final Long getChildQuantity() {
	return fitOrderQueryListDto.getChildQuantity();
}
public final FitSuppMainOrderStatusDto getFitSuppMainOrderStatusDto() {
	return fitOrderQueryListDto.getFitSuppMainOrderStatusDto();
}
public final void setFitSuppMainOrderStatusDto(
		FitSuppMainOrderStatusDto fitSuppMainOrderStatusDto) {
	fitOrderQueryListDto.setFitSuppMainOrderStatusDto(fitSuppMainOrderStatusDto);
}
public final void setChildQuantity(Long childQuantity) {
	fitOrderQueryListDto.setChildQuantity(childQuantity);
}
public final String getAllStatus() {
	return fitOrderQueryListDto.getAllStatus();
}
public final void setAllStatus(String allStatus) {
	fitOrderQueryListDto.setAllStatus(allStatus);
}
public final String getProductName() {
	return fitOrderQueryListDto.getProductName();
}
public final void setProductName(String productName) {
	fitOrderQueryListDto.setProductName(productName);
}
public final String getBelongDept() {
	return fitOrderQueryListDto.getBelongDept();
}
public final void setBelongDept(String belongDept) {
	fitOrderQueryListDto.setBelongDept(belongDept);
}
public final String getPayType() {
	return fitOrderQueryListDto.getPayType();
}
public final void setPayType(String payType) {
	fitOrderQueryListDto.setPayType(payType);
}
public final String getCreateDate() {
	return fitOrderQueryListDto.getCreateDate();
}
public final void setCreateDate(String createDate) {
	fitOrderQueryListDto.setCreateDate(createDate);
}
public final BigDecimal getOrderTotalAmount() {
	return fitOrderQueryListDto.getOrderTotalAmount();
}
public final void setOrderTotalAmount(BigDecimal orderTotalAmount) {
	fitOrderQueryListDto.setOrderTotalAmount(orderTotalAmount);
}
public final String getFlightInfo() {
	return fitOrderQueryListDto.getFlightInfo();
}
public final void setFlightInfo(String flightInfo) {
	fitOrderQueryListDto.setFlightInfo(flightInfo);
}
public final OrderBookingStatus getOrderBookingStatus() {
	return fitOrderQueryListDto.getOrderBookingStatus();
}
public final void setOrderBookingStatus(OrderBookingStatus orderBookingStatus) {
	fitOrderQueryListDto.setOrderBookingStatus(orderBookingStatus);
}
public final FlightTripType getTripType() {
	return fitOrderQueryListDto.getTripType();
}
public final void setTripType(FlightTripType tripType) {
	fitOrderQueryListDto.setTripType(tripType);
}
public final PassengerType getPassengerType() {
	return fitOrderQueryListDto.getPassengerType();
}
public final void setPassengerType(PassengerType passengerType) {
	fitOrderQueryListDto.setPassengerType(passengerType);
}
public String getCategoryId() {
	String categoryName = BIZ_CATEGORY_TYPE.getCnName(fitOrderQueryListDto.getCategoryId());
	if(categoryName == null || "null".equals(categoryName)){
		categoryName = "";
	}
	return categoryName;
}
public void setCategoryId(Long categoryId) {
	fitOrderQueryListDto.setCategoryId(categoryId);
}
}
