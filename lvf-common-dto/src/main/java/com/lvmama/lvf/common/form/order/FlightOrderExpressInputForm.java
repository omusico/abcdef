package com.lvmama.lvf.common.form.order;

import java.io.Serializable;
import java.util.Date;

import com.lvmama.lvf.common.dto.Pagination;
import com.lvmama.lvf.common.dto.RequestResponse;
import com.lvmama.lvf.common.dto.enums.InterfaceKey;
import com.lvmama.lvf.common.dto.md.ExpressWay;
import com.lvmama.lvf.common.dto.order.FlightOrderExpressDto;
import com.lvmama.lvf.common.dto.order.status.ExpressStatus;
import com.lvmama.lvf.common.dto.request.ApiFlowQueryRequest;
import com.lvmama.lvf.common.dto.request.FlightOrderExpressQueryRequest;
import com.lvmama.lvf.common.dto.request.TaskConfigQueryRequest;
import com.lvmama.lvf.common.form.Form;


public class FlightOrderExpressInputForm implements Serializable, Form {



    /**
	 * 
	 */
	private static long serialVersionUID = -1000619518461594589L;

	private FlightOrderExpressQueryRequest request= new FlightOrderExpressQueryRequest();
    
	private Pagination pagination = new Pagination();

	public FlightOrderExpressQueryRequest getRequest() {
		return request;
	}

	
	
	
	public String getStartTime() {
		return request.getStartTime();
	}




	public void setStartTime(String startTime) {
		request.setStartTime(startTime);
	}




	public String getEndTime() {
		return request.getEndTime();
	}




	public void setEndTime(String endTime) {
		request.setEndTime(endTime);
	}




	public Long getOrderMainId() {
		return request.getOrderMainId();
	}

	public void setOrderMainId(Long orderMainId) {
		request.setOrderMainId(orderMainId);
	}

	public Long getOrderId() {
		return request.getOrderId();
	}

	public void setOrderId(Long orderId) {
		request.setOrderId(orderId);
	}

	public void setId(Long id) {
		request.setId(id);
	}

	public void setRequest(FlightOrderExpressQueryRequest request) {
		this.request = request;
	}

	public Pagination getPagination() {
		return pagination;
	}

	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}



	public String getOrderNo() {
		return request.getOrderNo();
	}

	public void setOrderNo(String orderNo) {
		request.setOrderNo(orderNo);
	}

	public String getDepTime() {
		return request.getDepTime();
	}

	public void setDepTime(String depTime) {
		request.setDepTime(depTime);
	}

	public String getRecipient() {
		return request.getRecipient();
	}

	public void setRecipient(String recipient) {
		request.setRecipient(recipient);
	}

	public String getCellphone() {
		return request.getCellphone();
	}

	public void setCellphone(String cellphone) {
		request.setCellphone(cellphone);
	}

	public ExpressStatus getExpressStatus() {
		return request.getExpressStatus();
	}

	public void setExpressStatus(ExpressStatus expressStatus) {
		request.setExpressStatus(expressStatus);
	}



	public Long getId() {
		return request.getId();
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

	public void setSearch(boolean search) {
		pagination.setSearch(search);
	}

	public String getRemark() {
		return request.getRemark();
	}

	public void setRemark(String remark) {
		request.setRemark(remark);
	}

	public String getExpressFileNo() {
		return request.getExpressFileNo();
	}

	public void setExpressFileNo(String expressFileNo) {
		request.setExpressFileNo(expressFileNo);
	}

	public ExpressWay getExpressWay() {
		return request.getExpressWay();
	}

	public void setExpressWay(ExpressWay expressWay) {
		request.setExpressWay(expressWay);
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public static void setSerialversionuid(long serialversionuid) {
		serialVersionUID = serialversionuid;
	}

	public String getExpressTime() {
		return request.getExpressTime();
	}

	public void setExpressTime(String expressTime) {
		request.setExpressTime(expressTime);
	}



	

	
	
}