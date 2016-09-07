package com.lvmama.lvf.common.form.price;

import java.io.Serializable;
import java.util.List;

import com.lvmama.lvf.common.dto.Pagination;
import com.lvmama.lvf.common.dto.request.FlightPricePolicyRequest;
import com.lvmama.lvf.common.form.Form;

/**
 * 运价政策 From
 * @author zhangzongshuang
 * @date 2015年8月4日
 */
public class FlightPricePolicyForm implements Serializable, Form {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4417765218995608601L;
	
	private FlightPricePolicyRequest flightPricePolicyRequest=new FlightPricePolicyRequest();
    
	private Pagination pagination = new Pagination();

	public FlightPricePolicyRequest getFlightPricePolicyRequest() {
		return flightPricePolicyRequest;
	}

	public void setFlightPricePolicyRequest(FlightPricePolicyRequest flightPricePolicyRequest) {
		this.flightPricePolicyRequest = flightPricePolicyRequest;
	}

	public Pagination getPagination() {
		return pagination;
	}

	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}

	public String getFlightNo() {
		return flightPricePolicyRequest.getFlightNo();
	}

	public void setFlightNo(String flightNo) {
		flightPricePolicyRequest.setFlightNo(flightNo);
	}

	public String getSeatClassCode() {
		return flightPricePolicyRequest.getSeatClassCode();
	}

	public void setSeatClassCode(String seatClassCode) {
		flightPricePolicyRequest.setSeatClassCode(seatClassCode);
	}

	public String getSuppCode() {
		return flightPricePolicyRequest.getSuppCode();
	}

	public void setSuppCode(String suppCode) {
		flightPricePolicyRequest.setSuppCode(suppCode);
	}

	public String getDepartureCityCode() {
		return flightPricePolicyRequest.getDepartureCityCode();
	}

	public void setDepartureCityCode(String departureCityCode) {
		flightPricePolicyRequest.setDepartureCityCode(departureCityCode);
	}

	public String getArrivalCityCode() {
		return flightPricePolicyRequest.getArrivalCityCode();
	}

	public void setArrivalCityCode(String arrivalCityCode) {
		flightPricePolicyRequest.setArrivalCityCode(arrivalCityCode);
	}

	public String getSuppPolicyNo() {
		return flightPricePolicyRequest.getSuppPolicyNo();
	}

	public void setSuppPolicyNo(String suppPolicyNo) {
		flightPricePolicyRequest.setSuppPolicyNo(suppPolicyNo);
	}

	public String getMd5Sign() {
		return flightPricePolicyRequest.getMd5Sign();
	}

	public void setMd5Sign(String md5Sign) {
		flightPricePolicyRequest.setMd5Sign(md5Sign);
	}
	
	public List<Long> getFlightPricePolicyList() {
		return flightPricePolicyRequest.getFlightPricePolicyList();
	}

	public void setFlightPricePolicyList(List<Long> flightPricePolicyList) {
		flightPricePolicyRequest.setFlightPricePolicyList(flightPricePolicyList);
	}

	public Long getId() {
		return flightPricePolicyRequest.getId();
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

	public String getDepartureTime() {
		return flightPricePolicyRequest.getDepartureTime();
	}

	public void setDepartureTime(String departureTime) {
		flightPricePolicyRequest.setDepartureTime(departureTime);
	}

	public void setDepartureDate(Long departureDate) {
		flightPricePolicyRequest.setDepartureDate(departureDate);
	}

	public Long getDepartureDate() {
		return flightPricePolicyRequest.getDepartureDate();
	}

	public void setSearch(boolean search) {
		pagination.setSearch(search);
	}

	public List<Long> getFlightPriceInventoryList() {
		return flightPricePolicyRequest.getFlightPriceInventoryList();
	}

	public void setFlightPriceInventoryList(List<Long> flightPriceInventoryList) {
		flightPricePolicyRequest.setFlightPriceInventoryList(flightPriceInventoryList);
	}
    
	
}
