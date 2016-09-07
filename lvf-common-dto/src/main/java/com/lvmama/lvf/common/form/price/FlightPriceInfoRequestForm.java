package com.lvmama.lvf.common.form.price;

import java.io.Serializable;
import java.util.List;

import com.lvmama.lvf.common.dto.Pagination;
import com.lvmama.lvf.common.dto.request.FlightPriceInfoRequest;
import com.lvmama.lvf.common.form.Form;

/**
 * 运价 基本信息管理RequestForm
 * @author yangyongni
 * @date 2015年8月10日
 */
public class FlightPriceInfoRequestForm implements Serializable,Form{
	
	private static final long serialVersionUID = -1327574208048917667L;
	
    private FlightPriceInfoRequest flightPriceInfoRequest=new FlightPriceInfoRequest();
    
	private Pagination pagination = new Pagination();
	
	public FlightPriceInfoRequest getFlightPriceInfoRequest() {
		return flightPriceInfoRequest;
	}
	
	public void setFlightPriceInfoRequest(
			FlightPriceInfoRequest flightPriceInfoRequest) {
		this.flightPriceInfoRequest = flightPriceInfoRequest;
	}
	public Pagination getPagination() {
		return pagination;
	}
	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}
	
	public String getFlightNo() {
		return flightPriceInfoRequest.getFlightNo();
	}

	public void setFlightNo(String flightNo) {
		flightPriceInfoRequest.setFlightNo(flightNo);
	}

	public String getSeatClassCode() {
		return flightPriceInfoRequest.getSeatClassCode();
	}

	public void setSeatClassCode(String seatClassCode) {
		flightPriceInfoRequest.setSeatClassCode(seatClassCode);
	}

	public Long getDepartureDate() {
		return flightPriceInfoRequest.getDepartureDate();
	}

	public void setDepartureDate(Long departureDate) {
		flightPriceInfoRequest.setDepartureDate(departureDate);
	}

	public String getDepartureDateTime() {
		return flightPriceInfoRequest.getDepartureDateTime();
	}

	public void setDepartureDateTime(String departureDateTime) {
		flightPriceInfoRequest.setDepartureDateTime(departureDateTime);
	}
	
	public String getDepartureTime() {
		return flightPriceInfoRequest.getDepartureTime();
	}

	public void setDepartureTime(String departureTime) {
		flightPriceInfoRequest.setDepartureTime(departureTime);
	}
	
	public String getDepartureAirportCode() {
		return flightPriceInfoRequest.getDepartureAirportCode();
	}

	public void setDepartureAirportCode(String departureAirportCode) {
		flightPriceInfoRequest.setDepartureAirportCode(departureAirportCode);
	}

	public String getArrivalAirportCode() {
		return flightPriceInfoRequest.getArrivalAirportCode();
	}

	public void setArrivalAirportCode(String arrivalAirportCode) {
		flightPriceInfoRequest.setArrivalAirportCode(arrivalAirportCode);
	}
	
	public String getDepartureCityCode() {
		return flightPriceInfoRequest.getDepartureCityCode();
	}

	public void setDepartureCityCode(String departureCityCode) {
		flightPriceInfoRequest.setDepartureCityCode(departureCityCode);
	}

	public String getArrivalCityCode() {
		return flightPriceInfoRequest.getArrivalCityCode();
	}

	public void setArrivalCityCode(String arrivalCityCode) {
		flightPriceInfoRequest.setArrivalCityCode(arrivalCityCode);
	}
	
	public List<Long> getFlightPriceInfoList() {
		return flightPriceInfoRequest.getFlightPriceInfoList();
	}

	public void setFlightPriceInfoList(List<Long> flightPriceInfoList) {
		flightPriceInfoRequest.setFlightPriceInfoList(flightPriceInfoList);
	}
	
	public String getLvSeatClassCode() {
		return flightPriceInfoRequest.getLvSeatClassCode();
	}

	public void setLvSeatClassCode(String lvSeatClassCode) {
		flightPriceInfoRequest.setLvSeatClassCode(lvSeatClassCode);
	}
	public Long getId() {
		return flightPriceInfoRequest.getId();
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
	
}
