package com.lvmama.lvf.common.form.booking;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.lvmama.lvf.common.dto.Pagination;
import com.lvmama.lvf.common.dto.enums.BookingSource;
import com.lvmama.lvf.common.dto.enums.SeatClassType;
import com.lvmama.lvf.common.dto.request.FlightOrderIntentionRecordRequest;
import com.lvmama.lvf.common.form.Form;

public class FlightOrderIntentionRecordInputForm  implements Serializable, Form {
	
	private String bookingSourceStr;
	
	private Pagination pagination = new Pagination();
	
	private FlightOrderIntentionRecordRequest flightOrderIntentionRecordRequest = new FlightOrderIntentionRecordRequest();
	
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
	/**起飞开始时间*/
	public String getDepTimeBeginTime() {
		return flightOrderIntentionRecordRequest.getDepTimeBeginTime();
	}

	public void setDepTimeBeginTime(String depTimeBeginTime) {
		flightOrderIntentionRecordRequest.setDepTimeBeginTime(depTimeBeginTime);
	}
	/**起飞结束时间*/
	public String getDepTimeEndTime() {
		return flightOrderIntentionRecordRequest.getDepTimeEndTime();
	}

	public void setDepTimeEndTime(String depTimeEndTime) {
		flightOrderIntentionRecordRequest.setDepTimeEndTime(depTimeEndTime);
	}
	/**预订开始时间*/
	public String getOrderBeginTime() {
		return flightOrderIntentionRecordRequest.getOrderBeginTime();
	}

	public void setOrderBeginTime(String orderBeginTime) {
		flightOrderIntentionRecordRequest.setOrderBeginTime(orderBeginTime);
	}
	/**预订结束时间*/
	public String getOrderEndTime() {
		return flightOrderIntentionRecordRequest.getOrderEndTime();
	}

	public void setOrderEndTime(String orderEndTime) {
		flightOrderIntentionRecordRequest.setOrderEndTime(orderEndTime);
	}
	/**预定来源集合*/
	public List<BookingSource> getBookingSources() {
		return flightOrderIntentionRecordRequest.getBookingSources();
	}

	public void setBookingSources(List<BookingSource> bookingSources) {
		flightOrderIntentionRecordRequest.setBookingSources(bookingSources);
	}
	/**出发城市*/
	public String getDepAirportCityCode() {
		return flightOrderIntentionRecordRequest.getDepAirportCityCode();
	}

	public void setDepAirportCityCode(String depAirportCityCode) {
		flightOrderIntentionRecordRequest
				.setDepAirportCityCode(depAirportCityCode);
	}
	/**到达城市*/
	public String getArrAirportCityCode() {
		return flightOrderIntentionRecordRequest.getArrAirportCityCode();
	}

	public void setArrAirportCityCode(String arrAirportCityCode) {
		flightOrderIntentionRecordRequest
				.setArrAirportCityCode(arrAirportCityCode);
	}
	/**承运人*/
	public String getCarrierCode() {
		return flightOrderIntentionRecordRequest.getCarrierCode();
	}

	public void setCarrierCode(String carrierCode) {
		flightOrderIntentionRecordRequest.setCarrierCode(carrierCode);
	}
	/**客户账号*/
	public String getLvmamaAccount() {
		return flightOrderIntentionRecordRequest.getLvmamaAccount();
	}

	public void setLvmamaAccount(String lvmamaAccount) {
		flightOrderIntentionRecordRequest.setLvmamaAccount(lvmamaAccount);
	}
	/**舱位类型*/
	public SeatClassType getSeatClassType() {
		return flightOrderIntentionRecordRequest.getSeatClassType();
	}

	public void setSeatClassType(SeatClassType seatClassType) {
		flightOrderIntentionRecordRequest.setSeatClassType(seatClassType);
	}
	/**预定来源字符串*/
	public String getBookingSourceStr() {
		return bookingSourceStr;
	}

	public void setBookingSourceStr(String bookingSourceStr) {
		this.bookingSourceStr = bookingSourceStr;
	}
	
	public FlightOrderIntentionRecordRequest getFlightOrderIntentionRecordRequest() {

		List<BookingSource> bookingSourceList = new ArrayList<BookingSource>();
    	if(StringUtils.isNotBlank(this.getBookingSourceStr()))
    	{
    		String[] bookingSourceAry = this.getBookingSourceStr().split(",");
    		for(String bookingSource : bookingSourceAry)
    		{
    			bookingSourceList.add(BookingSource.valueOf(bookingSource));
    		}
    		flightOrderIntentionRecordRequest.setBookingSources(bookingSourceList);
		}
		return flightOrderIntentionRecordRequest;
	}

	public void setFlightOrderIntentionRecordRequest(
			FlightOrderIntentionRecordRequest flightOrderIntentionRecordRequest) {
		this.flightOrderIntentionRecordRequest = flightOrderIntentionRecordRequest;
	}
	
}
