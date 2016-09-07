package com.lvmama.lvfit.common.form.booking;

import com.lvmama.lvf.common.form.Form;
import com.lvmama.lvfit.common.dto.enums.BookingSource;
import com.lvmama.lvfit.common.dto.enums.RouteType;
import com.lvmama.lvfit.common.dto.order.*;

import java.util.Date;
import java.util.List;

/**
 * @author qihuisong
 */
public class BookingResultForm implements Form {
	
	private FitOrderMainDto orderMainDto;
	

	public BookingResultForm(FitOrderMainDto orderMainDto) {
		super();
		this.orderMainDto = orderMainDto;
	}

	public void setFitOrderRemarks(List<FitOrderRemarkDto> fitOrderRemarks) {
		orderMainDto.setFitOrderRemarks(fitOrderRemarks);
	}

	public FitOrderNoDto getFitOrderNo() {
		return orderMainDto.getFitOrderNo();
	}

	public void setFitOrderNo(FitOrderNoDto fitOrderNo) {
		orderMainDto.setFitOrderNo(fitOrderNo);
	}

	public FitOrderAmountDto getOrderAmount() {
		return orderMainDto.getOrderAmount();
	}

	public void setOrderAmount(FitOrderAmountDto orderAmount) {
		orderMainDto.setOrderAmount(orderAmount);
	}

	public FitOrderCustomerDto getFitOrderCustomer() {
		return orderMainDto.getFitOrderCustomer();
	}

	public void setFitOrderCustomer(FitOrderCustomerDto fitOrderCustomer) {
		orderMainDto.setFitOrderCustomer(fitOrderCustomer);
	}

	public FitOrderContacterDto getFitOrderContacter() {
		return orderMainDto.getFitOrderContacter();
	}

	public void setFitOrderContacter(FitOrderContacterDto fitOrderContacter) {
		orderMainDto.setFitOrderContacter(fitOrderContacter);
	}

	public BookingSource getBookingSource() {
		return orderMainDto.getBookingSource();
	}

	public void setBookingSource(BookingSource bookingSource) {
		orderMainDto.setBookingSource(bookingSource);
	}

	public FitOrderAgreementDto getFitOrderAgreement() {
		return orderMainDto.getFitOrderAgreement();
	}

	public void setFitOrderAgreement(FitOrderAgreementDto fitOrderAgreement) {
		orderMainDto.setFitOrderAgreement(fitOrderAgreement);
	}

	public FitOrderExpressDto getFitOrderExpress() {
		return orderMainDto.getFitOrderExpress();
	}

	public void setFitOrderExpress(FitOrderExpressDto fitOrderExpress) {
		orderMainDto.setFitOrderExpress(fitOrderExpress);
	}

	public List<FitOrderPassengerDto> getFitOrderPassengers() {
		return orderMainDto.getFitOrderPassengers();
	}

	public void setFitOrderPassengers(List<FitOrderPassengerDto> fitOrderPassengers) {
		orderMainDto.setFitOrderPassengers(fitOrderPassengers);
	}

	public List<FitOrderOpLogDto> getOrdeOpLogs() {
		return orderMainDto.getOrdeOpLogs();
	}

	public void setOrdeOpLogs(List<FitOrderOpLogDto> ordeOpLogs) {
		orderMainDto.setOrdeOpLogs(ordeOpLogs);
	}

	public List<FitOrderDto> getFitOrders() {
		return orderMainDto.getFitOrders();
	}

	public void setFitOrders(List<FitOrderDto> fitOrders) {
		orderMainDto.setFitOrders(fitOrders);
	}

	public List<FitOrderRemarkDto> getFitOrderRemarks() {
		return orderMainDto.getFitOrderRemarks();
	}
}