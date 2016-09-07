package com.lvmama.lvf.common.form.ticket;

import java.io.Serializable;

import com.lvmama.lvf.common.dto.Pagination;
import com.lvmama.lvf.common.dto.enums.BSPRecycleStatus;
import com.lvmama.lvf.common.dto.enums.BSPStatus;
import com.lvmama.lvf.common.dto.request.FlightTicketBSPDetailRequest;
import com.lvmama.lvf.common.form.Form;

/**
 * 行程单查询明细 requestForm
 * 
 * @author zzs
 */
public class TicketBSPDetailForm implements Serializable, Form {

	private static final long serialVersionUID = -951651250922938991L;

	private FlightTicketBSPDetailRequest bspDetailRequest = new FlightTicketBSPDetailRequest();

	private Pagination pagination = new Pagination();
	/** 使用状态 */
	private String bspStatusRequest;// 入库状态
	/** 回收状态 */
	private String bspRecycleStatusRequest;// 入库状态

	private String pnr;// pnr

	public FlightTicketBSPDetailRequest getBspDetailRequest() {
		if (null != this.getBspStatusRequest()
				&& this.getBspStatusRequest() != "") {
			if (this.getBspStatusRequest().equals("UNUSED")) {
				this.bspDetailRequest.setBspStatus(BSPStatus.UNUSED);
			}
			if (this.getBspStatusRequest().equals("USED")) {
				this.bspDetailRequest.setBspStatus(BSPStatus.USED);
			}
			if (this.getBspStatusRequest().equals("INVALID")) {
				this.bspDetailRequest.setBspStatus(BSPStatus.INVALID);
			}
			if (this.getBspStatusRequest().equals("PRINTED")) {
				this.bspDetailRequest.setBspStatus(BSPStatus.PRINTED);
			}
		} else {
			this.bspDetailRequest.setBspStatus(BSPStatus.UNUSED);
		}
		
		
		if (null != this.getBspRecycleStatusRequest()&& this.getBspRecycleStatusRequest() != "") {
			if (this.getBspRecycleStatusRequest().equals("RECYCLED")) {
				this.bspDetailRequest.setBspRecycleStatus(BSPRecycleStatus.RECYCLED);
			}if (this.getBspRecycleStatusRequest().equals("UNRECYCLED")) {
				this.bspDetailRequest.setBspRecycleStatus(BSPRecycleStatus.UNRECYCLED);
			}
		} else {
			this.bspDetailRequest.setBspRecycleStatus(BSPRecycleStatus.UNRECYCLED);
		}
		return bspDetailRequest;
	}

	public void setBspDetailRequest(
			FlightTicketBSPDetailRequest bspDetailRequest) {
		this.bspDetailRequest = bspDetailRequest;
	}

	public Long getId() {
		return bspDetailRequest.getId();
	}

	public void setId(Long id) {
		bspDetailRequest.setId(id);
	}

	public String getBspStartNo() {
		return bspDetailRequest.getBspStartNo();
	}

	public void setBspStartNo(String bspStartNo) {
		bspDetailRequest.setBspStartNo(bspStartNo);
	}

	public String getBspEndNo() {
		return bspDetailRequest.getBspEndNo();
	}

	public void setBspEndNo(String bspEndNo) {
		bspDetailRequest.setBspEndNo(bspEndNo);
	}

	public BSPStatus getBspStatus() {
		return bspDetailRequest.getBspStatus();
	}

	public void setBspStatus(BSPStatus bspStatus) {
		bspDetailRequest.setBspStatus(bspStatus);
	}

	public BSPRecycleStatus getBspRecycleStatus() {
		return bspDetailRequest.getBspRecycleStatus();
	}

	public void setBspRecycleStatus(BSPRecycleStatus bspRecycleStatus) {
		bspDetailRequest.setBspRecycleStatus(bspRecycleStatus);
	}

	public String getOperName() {
		return bspDetailRequest.getOperName();
	}

	public void setOperName(String operName) {
		bspDetailRequest.setOperName(operName);
	}

	public String getStartDetailDate() {
		return bspDetailRequest.getStartDetailDate();
	}

	public void setStartDetailDate(String startDetailDate) {
		bspDetailRequest.setStartDetailDate(startDetailDate);
	}

	public String getEndDetailDate() {
		return bspDetailRequest.getEndDetailDate();
	}

	public void setEndDetailDate(String endDetailDate) {
		bspDetailRequest.setEndDetailDate(endDetailDate);
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

	public String getBspStatusRequest() {
		return bspStatusRequest;
	}

	public void setBspStatusRequest(String bspStatusRequest) {
		this.bspStatusRequest = bspStatusRequest;
	}

	public String getBspRecycleStatusRequest() {
		return bspRecycleStatusRequest;
	}

	public void setBspRecycleStatusRequest(String bspRecycleStatusRequest) {
		this.bspRecycleStatusRequest = bspRecycleStatusRequest;
	}

	public String getPnr() {
		return pnr;
	}

	public void setPnr(String pnr) {
		this.pnr = pnr;
	}

	public String getTicketNo() {
		return bspDetailRequest.getTicketNo();
	}

	public void setTicketNo(String ticketNo) {
		bspDetailRequest.setTicketNo(ticketNo);
	}

	public String getBspRemark() {
		return bspDetailRequest.getBspRemark();
	}

	public void setBspRemark(String bspRemark) {
		bspDetailRequest.setBspRemark(bspRemark);
	}

	public String getTicketId() {
		return bspDetailRequest.getTicketId();
	}

	public void setTicketId(String ticketId) {
		bspDetailRequest.setTicketId(ticketId);
	}

	public String getOrderId() {
		return bspDetailRequest.getOrderId();
	}

	public void setOrderId(String orderId) {
		bspDetailRequest.setOrderId(orderId);
	}

	public String getOrderNo() {
		return bspDetailRequest.getOrderNo();
	}

	public void setOrderNo(String orderNo) {
		bspDetailRequest.setOrderNo(orderNo);
	}
	
	

}
