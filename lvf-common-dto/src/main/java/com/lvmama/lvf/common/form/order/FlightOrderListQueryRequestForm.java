package com.lvmama.lvf.common.form.order;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.lvmama.lvf.common.dto.Pagination;
import com.lvmama.lvf.common.dto.enums.BookingSource;
import com.lvmama.lvf.common.dto.enums.OrderNoType;
import com.lvmama.lvf.common.dto.enums.OrderType;
import com.lvmama.lvf.common.dto.enums.PaymentType;
import com.lvmama.lvf.common.dto.order.FlightOrderContacterDto;
import com.lvmama.lvf.common.dto.order.FlightOrderCustomerDto;
import com.lvmama.lvf.common.dto.order.FlightOrderPassengerDto;
import com.lvmama.lvf.common.dto.order.status.FlightOrderStatusDto;
import com.lvmama.lvf.common.dto.request.FlightCommonQueryRequest;
import com.lvmama.lvf.common.dto.status.OpSource;
import com.lvmama.lvf.common.form.Form;

public class FlightOrderListQueryRequestForm implements Serializable,Form {

	private static final long serialVersionUID = -8212381557892320514L;
	
	private String bookingSourceStr;
	
	private FlightOrderStatusDto orderStatus;
	
    private FlightCommonQueryRequest flightOrderListQueryRequest = new FlightCommonQueryRequest();
    
	private Pagination pagination = new Pagination();
	
	public String getBookingSourceStr() {
		return bookingSourceStr;
	}

	public void setBookingSourceStr(String bookingSourceStr) {
		this.bookingSourceStr = bookingSourceStr;
	}

	public FlightOrderStatusDto getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(FlightOrderStatusDto orderStatus) {
		this.orderStatus = orderStatus;
	}


	public void setFlightOrderListQueryRequest(FlightCommonQueryRequest flightOrderListQueryRequest) {
		this.flightOrderListQueryRequest = flightOrderListQueryRequest;
	}
    
    public FlightCommonQueryRequest getFlightOrderListQueryRequest() {
    	if(StringUtils.isNotBlank(this.getBookingSourceStr()))
    	{
    		String[] bookingSourceAry = this.getBookingSourceStr().split(",");
    		List<BookingSource> bookingSourceList = new ArrayList<BookingSource>();
    		for(String bookingSource : bookingSourceAry)
    			bookingSourceList.add(BookingSource.valueOf(bookingSource));
    		flightOrderListQueryRequest.setBookingSources(bookingSourceList);
		}
    	
    	 FlightOrderStatusDto flightOrderStatusDto = this.getOrderStatus();
		 flightOrderListQueryRequest.setFlightOrderStatus(flightOrderStatusDto);
		return flightOrderListQueryRequest;
	}
    
    public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}
    
    public Pagination getPagination() {
    	if(!StringUtils.isEmpty(flightOrderListQueryRequest.getOrderNo())|| !StringUtils.isEmpty(flightOrderListQueryRequest.getOrderMainNo())){
    		return new Pagination();
    	}
    	else{
    		return pagination;
    	}
	}

	public OrderNoType getOrderNoType() {
		return flightOrderListQueryRequest.getOrderNoType();
	}

	public void setOrderNoType(OrderNoType orderNoType) {
		flightOrderListQueryRequest.setOrderNoType(orderNoType);
	}

	public OpSource getOpSource() {
		return flightOrderListQueryRequest.getOpSource();
	}

	public void setOpSource(OpSource opSource) {
		flightOrderListQueryRequest.setOpSource(opSource);
	}

	public String getOrderNo() {
		return flightOrderListQueryRequest.getOrderNo();
	}

	public void setOrderNo(String orderNo) {
		flightOrderListQueryRequest.setOrderNo(orderNo);
	}

	public String getBookingManualNo() {
		return flightOrderListQueryRequest.getBookingManualNo();
	}

	public void setBookingManualNo(String bookingManualNo) {
		flightOrderListQueryRequest.setBookingManualNo(bookingManualNo);
	}

	public String getOrderBookingQueryBegTime() {
		return flightOrderListQueryRequest.getOrderBookingQueryBegTime();
	}

	public void setOrderBookingQueryBegTime(String orderBookingQueryBegTime) {
		flightOrderListQueryRequest
				.setOrderBookingQueryBegTime(orderBookingQueryBegTime);
	}

	public String getOrderBookingQueryEndTime() {
		return flightOrderListQueryRequest.getOrderBookingQueryEndTime();
	}

	public void setOrderBookingQueryEndTime(String orderBookingQueryEndTime) {
		flightOrderListQueryRequest
				.setOrderBookingQueryEndTime(orderBookingQueryEndTime);
	}

	public OrderType getOrderType() {
		return flightOrderListQueryRequest.getOrderType();
	}

	public void setOrderType(OrderType orderType) {
		flightOrderListQueryRequest.setOrderType(orderType);
	}

	public String getPayQueryBegTime() {
		return flightOrderListQueryRequest.getPayQueryBegTime();
	}

	public void setPayQueryBegTime(String payQueryBegTime) {
		flightOrderListQueryRequest.setPayQueryBegTime(payQueryBegTime);
	}

	public String getPayQueryEndTime() {
		return flightOrderListQueryRequest.getPayQueryEndTime();
	}

	public void setPayQueryEndTime(String payQueryEndTime) {
		flightOrderListQueryRequest.setPayQueryEndTime(payQueryEndTime);
	}

	public List<BookingSource> getBookingSources() {
		return flightOrderListQueryRequest.getBookingSources();
	}

	public void setBookingSources(List<BookingSource> bookingSources) {
		flightOrderListQueryRequest.setBookingSources(bookingSources);
	}

	public String getPnr() {
		return flightOrderListQueryRequest.getPnr();
	}

	public void setPnr(String pnr) {
		flightOrderListQueryRequest.setPnr(pnr);
	}

	public String getTicketNo() {
		return flightOrderListQueryRequest.getTicketNo();
	}

	public void setTicketNo(String ticketNo) {
		flightOrderListQueryRequest.setTicketNo(ticketNo);
	}

	public String getFlightNo() {
		return flightOrderListQueryRequest.getFlightNo();
	}

	public void setFlightNo(String flightNo) {
		flightOrderListQueryRequest.setFlightNo(flightNo);
	}

	public String getSuppName() {
		return flightOrderListQueryRequest.getSuppName();
	}

	public void setSuppName(String suppName) {
		flightOrderListQueryRequest.setSuppName(suppName);
	}

	public String getDepartureCity() {
		return flightOrderListQueryRequest.getDepartureCity();
	}

	public void setDepartureCity(String departureCity) {
		flightOrderListQueryRequest.setDepartureCity(departureCity);
	}

	public String getArriveCity() {
		return flightOrderListQueryRequest.getArriveCity();
	}

	public void setArriveCity(String arriveCity) {
		flightOrderListQueryRequest.setArriveCity(arriveCity);
	}

	public String getFlightQueryBegTime() {
		return flightOrderListQueryRequest.getFlightQueryBegTime();
	}

	public void setFlightQueryBegTime(String flightQueryBegTime) {
		flightOrderListQueryRequest.setFlightQueryBegTime(flightQueryBegTime);
	}

	public String getFlightQueryEndTime() {
		return flightOrderListQueryRequest.getFlightQueryEndTime();
	}

	public void setFlightQueryEndTime(String flightQueryEndTime) {
		flightOrderListQueryRequest.setFlightQueryEndTime(flightQueryEndTime);
	}



	public Long getOrderMainId() {
		return flightOrderListQueryRequest.getOrderMainId();
	}

	public void setOrderMainId(Long orderMainId) {
		flightOrderListQueryRequest.setOrderMainId(orderMainId);
	}

	public Long getOrderId() {
		return flightOrderListQueryRequest.getOrderId();
	}

	public void setOrderId(Long orderId) {
		flightOrderListQueryRequest.setOrderId(orderId);
	}

	public FlightOrderStatusDto getFlightOrderStatus() {
		return flightOrderListQueryRequest.getFlightOrderStatus();
	}

	public void setFlightOrderStatus(FlightOrderStatusDto flightOrderStatus) {
		flightOrderListQueryRequest.setFlightOrderStatus(flightOrderStatus);
	}

	public FlightOrderCustomerDto getFlightOrderCustomer() {
		return flightOrderListQueryRequest.getFlightOrderCustomer();
	}

	public void setFlightOrderCustomer(
			FlightOrderCustomerDto flightOrderCustomer) {
		flightOrderListQueryRequest.setFlightOrderCustomer(flightOrderCustomer);
	}

	public FlightOrderPassengerDto getFlightOrderPassenger() {
		return flightOrderListQueryRequest.getFlightOrderPassenger();
	}

	public void setFlightOrderPassenger(
			FlightOrderPassengerDto flightOrderPassenger) {
		flightOrderListQueryRequest
				.setFlightOrderPassenger(flightOrderPassenger);
	}

	public FlightOrderContacterDto getFlightOrderContacter() {
		return flightOrderListQueryRequest.getFlightOrderContacter();
	}

	public void setFlightOrderContacter(
			FlightOrderContacterDto flightOrderContacter) {
		flightOrderListQueryRequest
				.setFlightOrderContacter(flightOrderContacter);
	}

	public Long getId() {
		return flightOrderListQueryRequest.getId();
	}

	public int getPage() {
		return pagination.getPage();
	}

	public void setPage(int page) {
		pagination.setPage(page);
	}

	public int getRows() {
		return pagination.getRows();
	}

	public void setRows(int rows) {
		pagination.setRows(rows);
	}

	public int getRecords() {
		return pagination.getRecords();
	}

	public void setRecords(int records) {
		pagination.setRecords(records);
	}

	public void countRecords(int records) {
		pagination.countRecords(records);
	}

	public int getTotal() {
		return pagination.getTotal();
	}

	public void setTotal(int total) {
		pagination.setTotal(total);
	}

	public String getSidx() {
		return pagination.getSidx();
	}

	public void setSidx(String sidx) {
		pagination.setSidx(sidx);
	}

	public String getSord() {
		return pagination.getSord();
	}

	public void setSord(String sord) {
		pagination.setSord(sord);
	}

	public int getStartRow() {
		return pagination.getStartRow();
	}

	public int getEndRow() {
		return pagination.getEndRow();
	}

	public boolean isSearch() {
		return pagination.isSearch();
	}

	public void setSearch(boolean search) {
		pagination.setSearch(search);
	}

	public String getCarrierName() {
		return flightOrderListQueryRequest.getCarrierName();
	}

	public void setCarrierName(String carrierName) {
		flightOrderListQueryRequest.setCarrierName(carrierName);
	}

	public List<PaymentType> getPaymentType() {
		return flightOrderListQueryRequest.getPaymentType();
	}

	public void setPaymentType(List<PaymentType> paymentType) {
		flightOrderListQueryRequest.setPaymentType(paymentType);
	}

	public String getOrderMainNo() {
		return flightOrderListQueryRequest.getOrderMainNo();
	}

	public void setOrderMainNo(String orderMainNo) {
		flightOrderListQueryRequest.setOrderMainNo(orderMainNo);
	}

	public String getPurOrderNo() {
		return flightOrderListQueryRequest.getPurOrderNo();
	}

	public void setPurOrderNo(String purOrderNo) {
		flightOrderListQueryRequest.setPurOrderNo(purOrderNo);
	}

	public String getSuppOrderNo() {
		return flightOrderListQueryRequest.getSuppOrderNo();
	}

	public void setSuppOrderNo(String suppOrderNo) {
		flightOrderListQueryRequest.setSuppOrderNo(suppOrderNo);
	}

	public String getPaymentNo() {
		return flightOrderListQueryRequest.getPaymentNo();
	}

	public void setPaymentNo(String paymentNo) {
		flightOrderListQueryRequest.setPaymentNo(paymentNo);
	}

	public final String getIsDirectReduct() {
		return flightOrderListQueryRequest.getIsDirectReduct();
	}

	public final void setIsDirectReduct(String isDirectReduct) {
		flightOrderListQueryRequest.setIsDirectReduct(isDirectReduct);
	}

	public String getSaleType() {
		return flightOrderListQueryRequest.getSaleType();
	}

	public void setSaleType(String saleType) {
		flightOrderListQueryRequest.setSaleType(saleType);
	}
}
