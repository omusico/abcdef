/**
 * 
 */
package com.lvmama.lvf.common.form.order.result.detail;

import java.io.Serializable;

import com.lvmama.lvf.common.dto.Pagination;
import com.lvmama.lvf.common.dto.enums.RemarkType;
import com.lvmama.lvf.common.dto.order.FlightOrderNoDto;
import com.lvmama.lvf.common.dto.order.FlightOrderRemarkDto;
import com.lvmama.lvf.common.form.Form;

/**
 * 订单备注Form
 * @author leizhengwei
 * @date 2015-3-18
 */
public class FlightOrderRemarkRequestForm implements Serializable, Form {

	private static final long serialVersionUID = -8042218491480250319L;

	private FlightOrderRemarkDto flightOrderRemarkDto = new FlightOrderRemarkDto();
	
	private Pagination pagination = new Pagination();
	
	public void setFlightOrderRemarkDto(FlightOrderRemarkDto flightOrderRemarkDto) {
		this.flightOrderRemarkDto = flightOrderRemarkDto;
	}
	
	public FlightOrderRemarkDto getFlightOrderRemarkDto() {
		return flightOrderRemarkDto;
	}
	
	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}
	
	public Pagination getPagination() {
		return pagination;
	}

	public Long getOrderMainId() {
		return flightOrderRemarkDto.getOrderMainId();
	}

	public void setOrderMainId(Long orderMainId) {
		flightOrderRemarkDto.setOrderMainId(orderMainId);
	}

	public Long getOrderId() {
		return flightOrderRemarkDto.getOrderId();
	}

	public void setOrderId(Long orderId) {
		flightOrderRemarkDto.setOrderId(orderId);
	}

	public FlightOrderNoDto getFlightOrderNo() {
		return flightOrderRemarkDto.getFlightOrderNo();
	}

	public void setFlightOrderNo(FlightOrderNoDto flightOrderNo) {
		flightOrderRemarkDto.setFlightOrderNo(flightOrderNo);
	}

	public String getRemark() {
		return flightOrderRemarkDto.getRemark();
	}

	public void setRemark(String remark) {
		flightOrderRemarkDto.setRemark(remark);
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

	public RemarkType getRemarkType() {
		return flightOrderRemarkDto.getRemarkType();
	}

	public void setRemarkType(RemarkType remarkType) {
		flightOrderRemarkDto.setRemarkType(remarkType);
	}
	
	

}
