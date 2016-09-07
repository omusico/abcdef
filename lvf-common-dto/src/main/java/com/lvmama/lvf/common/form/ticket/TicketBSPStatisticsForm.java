package com.lvmama.lvf.common.form.ticket;

import java.io.Serializable;
import com.lvmama.lvf.common.dto.Pagination;
import com.lvmama.lvf.common.dto.enums.BSPRecycleStatus;
import com.lvmama.lvf.common.dto.enums.BSPStatus;
import com.lvmama.lvf.common.dto.request.FlightTicketBSPStatisticsRequest;
import com.lvmama.lvf.common.form.Form;

/**
 * 行程单统计requestForm
 *
 */
public class TicketBSPStatisticsForm implements Serializable, Form {
	
	private static final long serialVersionUID = -5521937171639080637L;
	
	private FlightTicketBSPStatisticsRequest bspStatisticsRequest=new FlightTicketBSPStatisticsRequest();
    
	private Pagination pagination = new Pagination();
	
	public FlightTicketBSPStatisticsRequest getBspStatisticsRequest() {
		return bspStatisticsRequest;
	}
	
	public Long getId() {
		return bspStatisticsRequest.getId();
	}

	public void setId(Long id) {
		bspStatisticsRequest.setId(id);
	}

	public String getBspStartNo() {
		return bspStatisticsRequest.getBspStartNo();
	}

	public void setBspStartNo(String bspStartNo) {
		bspStatisticsRequest.setBspStartNo(bspStartNo);
	}

	public String getBspEndNo() {
		return bspStatisticsRequest.getBspEndNo();
	}

	public void setBspEndNo(String bspEndNo) {
		bspStatisticsRequest.setBspEndNo(bspEndNo);
	}

	public BSPStatus getBspStatus() {
		return bspStatisticsRequest.getBspStatus();
	}

	public void setBspStatus(BSPStatus bspStatus) {
		bspStatisticsRequest.setBspStatus(bspStatus);
	}

	public BSPRecycleStatus getBspRecycleStatus() {
		return bspStatisticsRequest.getBspRecycleStatus();
	}

	public void setBspRecycleStatus(BSPRecycleStatus bspRecycleStatus) {
		bspStatisticsRequest.setBspRecycleStatus(bspRecycleStatus);
	}

	public String getOperName() {
		return bspStatisticsRequest.getOperName();
	}

	public void setOperName(String operName) {
		bspStatisticsRequest.setOperName(operName);
	}

	public String getStartDetailDate() {
		return bspStatisticsRequest.getStartDetailDate();
	}

	public void setStartDetailDate(String startDetailDate) {
		bspStatisticsRequest.setStartDetailDate(startDetailDate);
	}

	public String getEndDetailDate() {
		return bspStatisticsRequest.getEndDetailDate();
	}

	public void setEndDetailDate(String endDetailDate) {
		bspStatisticsRequest.setEndDetailDate(endDetailDate);
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

	public Pagination getPagination() {
		return pagination;
	}

	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}
	
	public void setBspStatisticsRequest(
			FlightTicketBSPStatisticsRequest bspStatisticsRequest) {
		this.bspStatisticsRequest = bspStatisticsRequest;
	}
	
	
	
}
