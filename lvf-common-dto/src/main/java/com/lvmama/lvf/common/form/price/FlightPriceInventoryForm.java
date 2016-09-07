package com.lvmama.lvf.common.form.price;

import java.io.Serializable;
import java.util.List;

import com.lvmama.lvf.common.dto.Pagination;
import com.lvmama.lvf.common.dto.enums.InventoryStatus;
import com.lvmama.lvf.common.dto.request.FlightPriceInventoryRequest;
import com.lvmama.lvf.common.form.Form;

/**
 * 运价库存 Form
 * @author zhangzongshuang
 * @date 2015年8月4日
 */
public class FlightPriceInventoryForm implements Serializable, Form {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1327574208048917667L;
	
	private FlightPriceInventoryRequest flightPriceInventoryRequest=new FlightPriceInventoryRequest();
	
	private Pagination pagination = new Pagination();

	public FlightPriceInventoryRequest getFlightPriceInventoryRequest() {
		return flightPriceInventoryRequest;
	}

	public void setFlightPriceInventoryRequest(FlightPriceInventoryRequest flightPriceInventoryRequest) {
		this.flightPriceInventoryRequest = flightPriceInventoryRequest;
	}

	public Pagination getPagination() {
		return pagination;
	}

	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}

	public String getFlightNo() {
		return flightPriceInventoryRequest.getFlightNo();
	}

	public void setFlightNo(String flightNo) {
		flightPriceInventoryRequest.setFlightNo(flightNo);
	}

	public String getSeatClassCode() {
		return flightPriceInventoryRequest.getSeatClassCode();
	}

	public void setSeatClassCode(String seatClassCode) {
		flightPriceInventoryRequest.setSeatClassCode(seatClassCode);
	}

	public String getArrivalTime() {
		return flightPriceInventoryRequest.getArrivalTime();
	}

	public void setArrivalTime(String arrivalTime) {
		flightPriceInventoryRequest.setArrivalTime(arrivalTime);
	}

	public String getDepartureCityCode() {
		return flightPriceInventoryRequest.getDepartureCityCode();
	}

	public void setDepartureCityCode(String departureCityCode) {
		flightPriceInventoryRequest.setDepartureCityCode(departureCityCode);
	}

	public String getArrivalCityCode() {
		return flightPriceInventoryRequest.getArrivalCityCode();
	}

	public void setArrivalCityCode(String arrivalCityCode) {
		flightPriceInventoryRequest.setArrivalCityCode(arrivalCityCode);
	}

	public Long getId() {
		return flightPriceInventoryRequest.getId();
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

	public Long getPolicyId() {
		return flightPriceInventoryRequest.getPolicyId();
	}

	public void setPolicyId(Long policyId) {
		flightPriceInventoryRequest.setPolicyId(policyId);
	}

	public Long getPricePolicyId() {
		return flightPriceInventoryRequest.getPricePolicyId();
	}

	public void setPricePolicyId(Long pricePolicyId) {
		flightPriceInventoryRequest.setPricePolicyId(pricePolicyId);
	}

	public String getSuppCode() {
		return flightPriceInventoryRequest.getSuppCode();
	}

	public void setSuppCode(String suppCode) {
		flightPriceInventoryRequest.setSuppCode(suppCode);
	}

	public InventoryStatus getInventoryStatus() {
		return flightPriceInventoryRequest.getInventoryStatus();
	}

	public void setInventoryStatus(InventoryStatus inventoryStatus) {
		flightPriceInventoryRequest.setInventoryStatus(inventoryStatus);
	}

	public String getSuppPolicyNo() {
		return flightPriceInventoryRequest.getSuppPolicyNo();
	}

	public void setSuppPolicyNo(String suppPolicyNo) {
		flightPriceInventoryRequest.setSuppPolicyNo(suppPolicyNo);
	}

	public String getDepartureTime() {
		return flightPriceInventoryRequest.getDepartureTime();
	}

	public Long getDepartureDate() {
		return flightPriceInventoryRequest.getDepartureDate();
	}

	public void setDepartureDate(Long departureDate) {
		flightPriceInventoryRequest.setDepartureDate(departureDate);
	}

	public void setDepartureTime(String departureTime) {
		flightPriceInventoryRequest.setDepartureTime(departureTime);
	}

	public String getDepartureDateTime() {
		return flightPriceInventoryRequest.getDepartureDateTime();
	}

	public void setDepartureDateTime(String departureDateTime) {
		flightPriceInventoryRequest.setDepartureDateTime(departureDateTime);
	}

	public List<Long> getFlightPriceInventoryList() {
		return flightPriceInventoryRequest.getFlightPriceInventoryList();
	}

	public void setFlightPriceInventoryList(List<Long> flightPriceInventoryList) {
		flightPriceInventoryRequest.setFlightPriceInventoryList(flightPriceInventoryList);
	}
	
}
