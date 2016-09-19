package com.lvmama.lvf.common.form.order;

import java.io.Serializable;

import com.lvmama.lvf.common.dto.Pagination;
import com.lvmama.lvf.common.dto.request.FlightOrderImportAuditRequest;
import com.lvmama.lvf.common.form.Form;

public class FlightOrderImportAuditInputForm  implements Serializable, Form {
	
	private static final long serialVersionUID = 415312577296272459L;

	private FlightOrderImportAuditRequest request = new FlightOrderImportAuditRequest();
	
	private Pagination pagination = new Pagination();
	
	public FlightOrderImportAuditRequest getRequest(){
		return request;
	}
	
	public void setRequest(FlightOrderImportAuditRequest request){
		this.request = request;
	}
	
	public String getCompanyName() {
		return request.getCompanyName();
	}

	public void setCompanyName(String companyName) {
		request.setCompanyName(companyName);
	}

	public String getPnr() {
		return request.getPnr();
	}

	public void setPnr(String pnr) {
		request.setPnr(pnr);
	}

	public String getProductType() {
		return request.getProductType();
	}

	public void setProductType(String productType) {
		request.setProductType(productType);
	}

	public String getOrderMainNo() {
		return request.getOrderMainNo();
	}

	public void setOrderMainNo(String orderMainNo) {
		request.setOrderMainNo(orderMainNo);
	}

	public String getBegTime() {
		return request.getBegTime();
	}

	public void setBegTime(String begTime) {
		request.setBegTime(begTime);
	}

	public String getEndTime() {
		return request.getEndTime();
	}

	public void setEndTime(String endTime) {
		request.setEndTime(endTime);
	}
	
    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
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
}
