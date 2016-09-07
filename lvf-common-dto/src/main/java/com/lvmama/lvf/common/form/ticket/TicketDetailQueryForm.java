package com.lvmama.lvf.common.form.ticket;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.lvmama.lvf.common.dto.Pagination;
import com.lvmama.lvf.common.dto.enums.BookingSource;
import com.lvmama.lvf.common.dto.enums.OrderNoType;
import com.lvmama.lvf.common.dto.enums.OrderType;
import com.lvmama.lvf.common.dto.order.FlightOrderContacterDto;
import com.lvmama.lvf.common.dto.order.FlightOrderCustomerDto;
import com.lvmama.lvf.common.dto.order.FlightOrderPassengerDto;
import com.lvmama.lvf.common.dto.order.status.FlightOrderStatusDto;
import com.lvmama.lvf.common.dto.request.FlightCommonQueryRequest;
import com.lvmama.lvf.common.dto.status.OpSource;
import com.lvmama.lvf.common.form.Form;
/**
 * 客票明细列表From
 * @author zzs
 *
 */
public class TicketDetailQueryForm implements Serializable,Form {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 462879012037052641L;

	private String bookingSourceStr;
	
    private FlightCommonQueryRequest flightTicketListQueryRequest = new FlightCommonQueryRequest();
    
    private FlightOrderStatusDto orderStatus;
    
	private Pagination pagination = new Pagination();
	
	public String getBookingSourceStr() {
		return bookingSourceStr;
	}

	public void setBookingSourceStr(String bookingSourceStr) {
		this.bookingSourceStr = bookingSourceStr;
	}

	public void setFlightOrderListQueryRequest(FlightCommonQueryRequest flightOrderListQueryRequest) {
		this.flightTicketListQueryRequest = flightOrderListQueryRequest;
	}
    
    public FlightCommonQueryRequest getFlightOrderListQueryRequest() {
    	if(StringUtils.isNotBlank(this.getBookingSourceStr()))
    	{
    		String[] bookingSourceAry = this.getBookingSourceStr().split(",");
    		List<BookingSource> bookingSourceList = new ArrayList<BookingSource>();
    		for(String bookingSource : bookingSourceAry)
    			bookingSourceList.add(BookingSource.valueOf(bookingSource));
    		flightTicketListQueryRequest.setBookingSources(bookingSourceList);
		}
    	FlightOrderStatusDto flightOrderStatusDto = this.getOrderStatus();
    	flightTicketListQueryRequest.setFlightOrderStatus(flightOrderStatusDto);
		return flightTicketListQueryRequest;
	}
    
    public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}
    
    public Pagination getPagination() {
		return pagination;
	}

	public String getOrderNo() {
		return flightTicketListQueryRequest.getOrderNo();
	}

	public void setOrderNo(String orderNo) {
		flightTicketListQueryRequest.setOrderNo(orderNo);
	}

	public String getBookingManualNo() {
		return flightTicketListQueryRequest.getBookingManualNo();
	}

	public void setBookingManualNo(String bookingManualNo) {
		flightTicketListQueryRequest.setBookingManualNo(bookingManualNo);
	}

	public String getOrderBookingQueryBegTime() {
		return flightTicketListQueryRequest.getOrderBookingQueryBegTime();
	}

	public void setOrderBookingQueryBegTime(String orderBookingQueryBegTime) {
		flightTicketListQueryRequest.setOrderBookingQueryBegTime(orderBookingQueryBegTime);
	}

	public String getOrderBookingQueryEndTime() {
		return flightTicketListQueryRequest.getOrderBookingQueryEndTime();
	}

	public void setOrderBookingQueryEndTime(String orderBookingQueryEndTime) {
		flightTicketListQueryRequest.setOrderBookingQueryEndTime(orderBookingQueryEndTime);
	}

	public OrderType getOrderType() {
		return flightTicketListQueryRequest.getOrderType();
	}

	public void setOrderType(OrderType orderType) {
		flightTicketListQueryRequest.setOrderType(orderType);
	}

	public FlightOrderStatusDto getFlightOrderStatus() {
		return flightTicketListQueryRequest.getFlightOrderStatus();
	}

	public void setFlightOrderStatus(FlightOrderStatusDto flightOrderStatus) {
		flightTicketListQueryRequest.setFlightOrderStatus(flightOrderStatus);
	}

	public String getPayQueryBegTime() {
		return flightTicketListQueryRequest.getPayQueryBegTime();
	}

	public void setPayQueryBegTime(String payQueryBegTime) {
		flightTicketListQueryRequest.setPayQueryBegTime(payQueryBegTime);
	}

	public String getPayQueryEndTime() {
		return flightTicketListQueryRequest.getPayQueryEndTime();
	}

	public void setPayQueryEndTime(String payQueryEndTime) {
		flightTicketListQueryRequest.setPayQueryEndTime(payQueryEndTime);
	}

	public List<BookingSource> getBookingSources() {
		return flightTicketListQueryRequest.getBookingSources();
	}

	public void setBookingSources(List<BookingSource> bookingSources) {
		flightTicketListQueryRequest.setBookingSources(bookingSources);
	}

	public String getPnr() {
		return flightTicketListQueryRequest.getPnr();
	}

	public void setPnr(String pnr) {
		flightTicketListQueryRequest.setPnr(pnr);
	}

	public String getTicketNo() {
		return flightTicketListQueryRequest.getTicketNo();
	}

	public void setTicketNo(String ticketNo) {
		flightTicketListQueryRequest.setTicketNo(ticketNo);
	}

	public String getFlightNo() {
		return flightTicketListQueryRequest.getFlightNo();
	}

	public void setFlightNo(String flightNo) {
		flightTicketListQueryRequest.setFlightNo(flightNo);
	}

	public String getSuppName() {
		return flightTicketListQueryRequest.getSuppName();
	}

	public void setSuppName(String suppName) {
		flightTicketListQueryRequest.setSuppName(suppName);
	}

	public String getDepartureCity() {
		return flightTicketListQueryRequest.getDepartureCity();
	}

	public void setDepartureCity(String departureCity) {
		flightTicketListQueryRequest.setDepartureCity(departureCity);
	}

	public String getArriveCity() {
		return flightTicketListQueryRequest.getArriveCity();
	}

	public void setArriveCity(String arriveCity) {
		flightTicketListQueryRequest.setArriveCity(arriveCity);
	}

	public String getFlightQueryBegTime() {
		return flightTicketListQueryRequest.getFlightQueryBegTime();
	}

	public void setFlightQueryBegTime(String flightQueryBegTime) {
		flightTicketListQueryRequest.setFlightQueryBegTime(flightQueryBegTime);
	}

	public String getFlightQueryEndTime() {
		return flightTicketListQueryRequest.getFlightQueryEndTime();
	}

	public void setFlightQueryEndTime(String flightQueryEndTime) {
		flightTicketListQueryRequest.setFlightQueryEndTime(flightQueryEndTime);
	}



	public Long getOrderMainId() {
		return flightTicketListQueryRequest.getOrderMainId();
	}

	public void setOrderMainId(Long orderMainId) {
		flightTicketListQueryRequest.setOrderMainId(orderMainId);
	}

	public Long getOrderId() {
		return flightTicketListQueryRequest.getOrderId();
	}

	public void setOrderId(Long orderId) {
		flightTicketListQueryRequest.setOrderId(orderId);
	}

	public OrderNoType getOrderNoType() {
		return flightTicketListQueryRequest.getOrderNoType();
	}

	public void setOrderNoType(OrderNoType orderNoType) {
		flightTicketListQueryRequest.setOrderNoType(orderNoType);
	}

	public FlightOrderCustomerDto getFlightOrderCustomer() {
		return flightTicketListQueryRequest.getFlightOrderCustomer();
	}

	public void setFlightOrderCustomer(
			FlightOrderCustomerDto flightOrderCustomer) {
		flightTicketListQueryRequest
				.setFlightOrderCustomer(flightOrderCustomer);
	}

	public OpSource getOpSource() {
		return flightTicketListQueryRequest.getOpSource();
	}

	public void setOpSource(OpSource opSource) {
		flightTicketListQueryRequest.setOpSource(opSource);
	}

	public FlightOrderPassengerDto getFlightOrderPassenger() {
		return flightTicketListQueryRequest.getFlightOrderPassenger();
	}

	public void setFlightOrderPassenger(
			FlightOrderPassengerDto flightOrderPassenger) {
		flightTicketListQueryRequest
				.setFlightOrderPassenger(flightOrderPassenger);
	}

	public FlightOrderContacterDto getFlightOrderContacter() {
		return flightTicketListQueryRequest.getFlightOrderContacter();
	}

	public void setFlightOrderContacter(
			FlightOrderContacterDto flightOrderContacter) {
		flightTicketListQueryRequest
				.setFlightOrderContacter(flightOrderContacter);
	}

	public Long getId() {
		return flightTicketListQueryRequest.getId();
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
	public FlightOrderStatusDto getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(FlightOrderStatusDto orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getSaleType() {
		return flightTicketListQueryRequest.getSaleType();
	}

	public void setSaleType(String saleType) {
		flightTicketListQueryRequest.setSaleType(saleType);
	}
}
