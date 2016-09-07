package com.lvmama.lvf.common.form.ticket;

import java.io.Serializable;
import com.lvmama.lvf.common.dto.Pagination;
import com.lvmama.lvf.common.dto.enums.BSPInventoryStatus;
import com.lvmama.lvf.common.dto.request.FlightTicketBSPStoreSearchRequest;
import com.lvmama.lvf.common.form.Form;

/**
 * 行程单查询 RequestForm
 * @author zzs
 *
 */
public class TicketBSPStoreSearchForm implements Serializable,Form {

	private static final long serialVersionUID = 1426880815494264364L;

	private Pagination pagination=new Pagination();
	
    private FlightTicketBSPStoreSearchRequest ticketBSPStoreRequest=new FlightTicketBSPStoreSearchRequest();

    private String invetoryBspStatus;//入库状态
    
    public FlightTicketBSPStoreSearchRequest getTicketBSPStoreRequest() {
    	if(null!=this.getInvetoryBspStatus()){
    		if (this.getInvetoryBspStatus().equals("STORAGE")) {
    			this.ticketBSPStoreRequest.setInvetoryStatus(BSPInventoryStatus.STORAGE);
            }if (this.getInvetoryBspStatus().equals("CANCELLED")) {
    			this.ticketBSPStoreRequest.setInvetoryStatus(BSPInventoryStatus.CANCELLED);
            }
		  }
		return ticketBSPStoreRequest;
	}

    public Pagination getPagination() {
		return pagination;
	}

	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}

	public String getInvetoryBspStatus() {
		return invetoryBspStatus;
	}

	public void setInvetoryBspStatus(String invetoryBspStatus) {
		this.invetoryBspStatus = invetoryBspStatus;
	}

	public void setTicketBSPStoreRequest(
			FlightTicketBSPStoreSearchRequest ticketBSPStoreRequest) {
		this.ticketBSPStoreRequest = ticketBSPStoreRequest;
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

	public String getBspStartNo() {
		return ticketBSPStoreRequest.getBspStartNo();
	}

	public void setBspStartNo(String bspStartNo) {
		ticketBSPStoreRequest.setBspStartNo(bspStartNo);
	}

	public String getBspEndNo() {
		return ticketBSPStoreRequest.getBspEndNo();
	}

	public void setBspEndNo(String bspEndNo) {
		ticketBSPStoreRequest.setBspEndNo(bspEndNo);
	}

	public String getBspId() {
		return ticketBSPStoreRequest.getBspId();
	}

	public void setBspId(String bspId) {
		ticketBSPStoreRequest.setBspId(bspId);
	}

	public BSPInventoryStatus getInvetoryStatus() {
		return ticketBSPStoreRequest.getInvetoryStatus();
	}

	public void setInvetoryStatus(BSPInventoryStatus invetoryStatus) {
		ticketBSPStoreRequest.setInvetoryStatus(invetoryStatus);
	}

	public String getOperName() {
		return ticketBSPStoreRequest.getOperName();
	}

	public void setOperName(String operName) {
		ticketBSPStoreRequest.setOperName(operName);
	}

	public String getStartStorageDate() {
		return ticketBSPStoreRequest.getStartStorageDate();
	}

	public void setStartStorageDate(String startStorageDate) {
		ticketBSPStoreRequest.setStartStorageDate(startStorageDate);
	}

	public String getEndStorageDate() {
		return ticketBSPStoreRequest.getEndStorageDate();
	}

	public void setEndStorageDate(String endStorageDate) {
		ticketBSPStoreRequest.setEndStorageDate(endStorageDate);
	}

	public Long getId() {
		return ticketBSPStoreRequest.getId();
	}

}
