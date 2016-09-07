package com.lvmama.lvf.common.form.booking;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.lvmama.lvf.common.dto.Pagination;
import com.lvmama.lvf.common.dto.enums.BookingSource;
import com.lvmama.lvf.common.dto.enums.OrderFlag;
import com.lvmama.lvf.common.dto.request.FlightOrderRequestRecordRequest;
import com.lvmama.lvf.common.dto.status.order.OrderStatus;
import com.lvmama.lvf.common.form.Form;

public class FlightOrderRequestRecordInputForm implements Serializable, Form {
	
	private static final long serialVersionUID = 2208367582474983575L;

	private String bookingSourceStr;
	
	private Pagination pagination = new Pagination();
	
	private FlightOrderRequestRecordRequest flightOrderRequestRecordRequest = new FlightOrderRequestRecordRequest();
	
	public Pagination getPagination() {
		return pagination;
	}

	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}
	public void countRecords(int records) {
		pagination.countRecords(records);
	}

	public boolean equals(Object obj) {
		return pagination.equals(obj);
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

	public void setRowsByCustom(int customRows) {
		pagination.setRowsByCustom(customRows);
	}

	public int getRecords() {
		return pagination.getRecords();
	}

	public void setRecords(int records) {
		pagination.setRecords(records);
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

	/**traceNo*/
	public String getTraceNo() {
		return flightOrderRequestRecordRequest.getTraceNo();
	}

	public void setTraceNo(String traceNo) {
		flightOrderRequestRecordRequest.setTraceNo(traceNo);
	}
	/**航空公司*/
	public String getAirplaneCompanyCode() {
		return flightOrderRequestRecordRequest.getAirplaneCompanyCode();
	}

	public void setAirplaneCompanyCode(String airplaneCompanyCode) {
		flightOrderRequestRecordRequest
				.setAirplaneCompanyCode(airplaneCompanyCode);
	}
	/**航班号*/
	public String getFlightNo() {
		return flightOrderRequestRecordRequest.getFlightNo();
	}

	public void setFlightNo(String flightNo) {
		flightOrderRequestRecordRequest.setFlightNo(flightNo);
	}
	/**预定状态*/
	public OrderStatus getOrderStatus() {
		return flightOrderRequestRecordRequest.getOrderStatus();
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		flightOrderRequestRecordRequest.setOrderStatus(orderStatus);
	}
	/**出发城市*/
	public String getDepAirportCityCode() {
		return flightOrderRequestRecordRequest.getDepAirportCityCode();
	}

	public void setDepAirportCityCode(String depAirportCityCode) {
		flightOrderRequestRecordRequest
				.setDepAirportCityCode(depAirportCityCode);
	}
	/**到达城市*/
	public String getArrAirportCityCode() {
		return flightOrderRequestRecordRequest.getArrAirportCityCode();
	}

	public void setArrAirportCityCode(String arrAirportCityCode) {
		flightOrderRequestRecordRequest
				.setArrAirportCityCode(arrAirportCityCode);
	}
	/**乘机开始时间*/
	public String getDepTimeBeginTime() {
		return flightOrderRequestRecordRequest.getDepTimeBeginTime();
	}

	public void setDepTimeBeginTime(String depTimeBeginTime) {
		flightOrderRequestRecordRequest.setDepTimeBeginTime(depTimeBeginTime);
	}
	/**乘机结束时间*/
	public String getDepTimeEndTime() {
		return flightOrderRequestRecordRequest.getDepTimeEndTime();
	}

	public void setDepTimeEndTime(String depTimeEndTime) {
		flightOrderRequestRecordRequest.setDepTimeEndTime(depTimeEndTime);
	}
	/**请求开始时间*/
	public String getOrderReqBeginTime() {
		return flightOrderRequestRecordRequest.getOrderReqBeginTime();
	}

	public void setOrderReqBeginTime(String orderReqBeginTime) {
		flightOrderRequestRecordRequest.setOrderReqBeginTime(orderReqBeginTime);
	}
	/**请求结束时间*/
	public String getOrderReqEndTime() {
		return flightOrderRequestRecordRequest.getOrderReqEndTime();
	}

	public void setOrderReqEndTime(String orderReqEndTime) {
		flightOrderRequestRecordRequest.setOrderReqEndTime(orderReqEndTime);
	}
	
	/**预定来源字符串*/
	public String getBookingSourceStr() {
		return bookingSourceStr;
	}

	public void setBookingSourceStr(String bookingSourceStr) {
		this.bookingSourceStr = bookingSourceStr;
	}
	
	/**预定来源集合*/
	public List<BookingSource> getBookingSources() {
    	return flightOrderRequestRecordRequest.getBookingSources();
	}

	public void setBookingSources(List<BookingSource> bookingSources) {
		flightOrderRequestRecordRequest.setBookingSources(bookingSources);
	}

	public FlightOrderRequestRecordRequest getFlightOrderRequestRecordRequest() {
		List<BookingSource> bookingSourceList = new ArrayList<BookingSource>();
    	if(StringUtils.isNotBlank(this.getBookingSourceStr()))
    	{
    		String[] bookingSourceAry = this.getBookingSourceStr().split(",");
    		for(String bookingSource : bookingSourceAry)
    		{
    			bookingSourceList.add(BookingSource.valueOf(bookingSource));
    		}
    		flightOrderRequestRecordRequest.setBookingSources(bookingSourceList);
		}	
		return flightOrderRequestRecordRequest;
	}

	public void setFlightOrderRequestRecordRequest(
			FlightOrderRequestRecordRequest flightOrderRequestRecordRequest) {
		this.flightOrderRequestRecordRequest = flightOrderRequestRecordRequest;
	}
	/**订单号*/
	public String getOrderNo() {
		return flightOrderRequestRecordRequest.getOrderNo();
	}

	public void setOrderNo(String orderNo) {
		flightOrderRequestRecordRequest.setOrderNo(orderNo);
	}
	/**账号类型*/
	public OrderFlag getOrderFlag() {
		return flightOrderRequestRecordRequest.getOrderFlag();
	}

	public void setOrderFlag(OrderFlag orderFlag) {
		flightOrderRequestRecordRequest.setOrderFlag(orderFlag);
	}
}
