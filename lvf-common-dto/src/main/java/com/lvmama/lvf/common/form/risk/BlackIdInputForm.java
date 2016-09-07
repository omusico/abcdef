package com.lvmama.lvf.common.form.risk;

import java.io.Serializable;

import com.lvmama.lvf.common.dto.Pagination;
import com.lvmama.lvf.common.dto.enums.RiskLevelType;
import com.lvmama.lvf.common.dto.enums.Status;
import com.lvmama.lvf.common.dto.request.BlackIdRequest;
import com.lvmama.lvf.common.form.Form;

/**
 * 风控黑名单请求信息Form
 * 
 * @author yuanweihong
 * @date 2015-9-1
 */
public class BlackIdInputForm implements Serializable, Form {

    private static final long serialVersionUID = 97114544517607479L;

    private BlackIdRequest request = new BlackIdRequest();

    private Pagination pagination = new Pagination();
    
    private Integer blackDay;

    public BlackIdRequest getRequest() {
        return request;
    }

    public void setRequest(BlackIdRequest request) {
        this.request = request;
    }

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

    public void setId(Long id) {
        request.setId(id);
    }

    public String getCustomerName() {
        return request.getCustomerName();
    }

    public void setCustomerName(String customerName) {
        request.setCustomerName(customerName);
    }

    public String getCustomerCellphone() {
        return request.getCustomerCellphone();
    }

    public void setCustomerCellphone(String customerCellphone) {
        request.setCustomerCellphone(customerCellphone);
    }

    public String getBlackStartBegTime() {
        return request.getBlackStartBegTime();
    }

    public void setBlackStartBegTime(String blackStartBegTime) {
        request.setBlackStartBegTime(blackStartBegTime);
    }

    public String getBlackStartEndTime() {
        return request.getBlackStartEndTime();
    }

    public void setBlackStartEndTime(String blackStartEndTime) {
        request.setBlackStartEndTime(blackStartEndTime);
    }

    public String getBlackEndTime() {
        return request.getBlackEndTime();
    }

    public void setBlackEndTime(String blackEndTime) {
        request.setBlackEndTime(blackEndTime);
    }

    public String getCustomerId() {
        return request.getCustomerId();
    }

    public void setCustomerId(String customerId) {
        request.setCustomerId(customerId);
    }

    public RiskLevelType getRiskLevelType() {
        return request.getRiskLevelType();
    }

    public void setRiskLevelType(RiskLevelType riskLevelType) {
        request.setRiskLevelType(riskLevelType);
    }

    public Status getStatus() {
        return request.getStatus();
    }

    public void setStatus(Status status) {
        request.setStatus(status);
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

    public void setSearch(boolean search) {
        pagination.setSearch(search);
    }

	public String getBlackStartTime() {
		return request.getBlackStartTime();
	}

	public void setBlackStartTime(String blackStartTime) {
		request.setBlackStartTime(blackStartTime);
	}

	public Integer getBlackDay() {
		return blackDay;
	}

	public void setBlackDay(Integer blackDay) {
		this.blackDay = blackDay;
	}

}
