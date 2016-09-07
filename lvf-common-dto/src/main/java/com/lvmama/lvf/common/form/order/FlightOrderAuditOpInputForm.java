package com.lvmama.lvf.common.form.order;

import java.io.Serializable;

import com.lvmama.lvf.common.dto.Pagination;
import com.lvmama.lvf.common.dto.enums.AuditStatus;
import com.lvmama.lvf.common.dto.enums.AuditType;
import com.lvmama.lvf.common.dto.enums.OrderAuditOpType;
import com.lvmama.lvf.common.dto.enums.OrderFlag;
import com.lvmama.lvf.common.dto.request.FlightOrderAuditOpRequest;
import com.lvmama.lvf.common.form.Form;

/**
 * 出票改签退票审核/处理列表Form
 * 
 * @author yuanweihong
 * @date 2015-3-11
 */
public class FlightOrderAuditOpInputForm implements Serializable, Form {

    private static final long serialVersionUID = -7435039970946469244L;

    private FlightOrderAuditOpRequest request = new FlightOrderAuditOpRequest();

    private Pagination pagination = new Pagination();

    /** 订单类型 */
    private String orderNoType;

    private String excOrderNo;

    /** 操作时间类型 */
    private String opTimeType;

    private String opBegTime;

    private String opEndTime;

    /** 操作人类型 */
    private String opPersonType;

    private String opPerson;

    /** 订单类型(前端) */
    private OrderAuditOpType orderAuditOpType;

    public FlightOrderAuditOpRequest getRequest() {
        // 设置各类型订单号
        if ("ORDERMAINNO".equals(this.orderNoType)) {
            this.request.setOrderMainNo(excOrderNo);
        } else if ("ORDERNO".equals(this.orderNoType)) {
            this.request.setOrderNo(excOrderNo);
        } else if ("SUPPORDERNO".equals(this.orderNoType)) {
            this.request.setSuppOrderNo(excOrderNo);
        } else if ("PURORDERNO".equals(this.orderNoType)) {
            this.request.setOfficeNo(excOrderNo);
        }

        // 设置各类型时间参数
        if ("CREATETIEM".equals(this.opTimeType)) {
            this.request.setBookingQueryBegTime(opBegTime);
            this.request.setBookingQueryEndTime(opEndTime);
        } else if ("FLYTIME".equals(this.opTimeType)) {
            this.request.setFlightQueryBegTime(opBegTime);
            this.request.setFlightQueryEndTime(opEndTime);
        } else if ("SUBMITTMIE".equals(this.opTimeType)) {
            this.request.setCommitBegTime(opBegTime);
            this.request.setCommitBegTime(opEndTime);
        } else if ("ISSUETIME".equals(this.opTimeType)) {
            this.request.setIssueBegTime(opBegTime);
            this.request.setIssueEndTime(opEndTime);
        } else if ("UPDATETIEM".equals(this.opTimeType)) {
            this.request.setUpdateBegTime(opBegTime);
            this.request.setUpdateEndTime(opEndTime);
        } else if ("GATHERTIME".equals(this.opTimeType)) {
            this.request.setGatherBegTime(opBegTime);
            this.request.setGatherEndTime(opEndTime);
        }

        // 设置订单主审核类型
        if (this.getOrderAuditOpType() == OrderAuditOpType.ISSUEAUDIT) {
            this.request.setAuditStatus(AuditStatus.AUDIT);
            this.request.setAuditType(AuditType.TICKET_ISSUE);
        } else if (this.getOrderAuditOpType() == OrderAuditOpType.ISSUEOP) {
            this.request.setAuditStatus(AuditStatus.OP);
            this.request.setAuditType(AuditType.TICKET_ISSUE);
        } else if (this.getOrderAuditOpType() == OrderAuditOpType.RTVTAUDIT) {
            this.request.setAuditStatus(AuditStatus.AUDIT);
            this.request.setAuditType(AuditType.TICKET_RTVT);
        } else if (this.getOrderAuditOpType() == OrderAuditOpType.RTVTOP) {
            this.request.setAuditStatus(AuditStatus.OP);
            this.request.setAuditType(AuditType.TICKET_RTVT);
        } else if (this.getOrderAuditOpType() == OrderAuditOpType.CTMTAUDIT) {
            this.request.setAuditStatus(AuditStatus.AUDIT);
            this.request.setAuditType(AuditType.TICKET_CTMT);
        } else if (this.getOrderAuditOpType() == OrderAuditOpType.CTMTOP) {
            this.request.setAuditStatus(AuditStatus.OP);
            this.request.setAuditType(AuditType.TICKET_CTMT);
        }

        // 设置操作人类型
        if ("CREATEPER".equals(this.opPersonType)) {
            this.request.setCreatePer(opPerson);
        } else if ("PAYPER".equals(this.opPersonType)) {
            this.request.setPayer(opPerson);
        } else if ("AUDITPER".equals(this.opPersonType)) {
            this.request.setAuditPer(opPerson);
        } else if ("ISSUEPER".equals(this.opPersonType)) {
            this.request.setIssuePer(opPerson);
        } else if ("GATHERPER".equals(this.opPersonType)) {
            this.request.setGatherPer(opPerson);
        }

        return request;
    }

    public OrderAuditOpType getOrderAuditOpType() {
        return orderAuditOpType;
    }

    public void setOrderAuditOpType(OrderAuditOpType orderAuditOpType) {
        this.orderAuditOpType = orderAuditOpType;
    }

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

    public String getOrderNoType() {
        return orderNoType;
    }

    public void setOrderNoType(String orderNoType) {
        this.orderNoType = orderNoType;
    }

    public String getExcOrderNo() {
        return excOrderNo;
    }

    public void setExcOrderNo(String excOrderNo) {
        this.excOrderNo = excOrderNo;
    }

    public String getOpTimeType() {
        return opTimeType;
    }

    public void setOpTimeType(String opTimeType) {
        this.opTimeType = opTimeType;
    }

    public String getOpBegTime() {
        return opBegTime;
    }

    public void setOpBegTime(String opBegTime) {
        this.opBegTime = opBegTime;
    }

    public String getOpEndTime() {
        return opEndTime;
    }

    public void setOpEndTime(String opEndTime) {
        this.opEndTime = opEndTime;
    }

    public String getOpPersonType() {
        return opPersonType;
    }

    public void setOpPersonType(String opPersonType) {
        this.opPersonType = opPersonType;
    }

    public String getOpPerson() {
        return opPerson;
    }

    public void setOpPerson(String opPerson) {
        this.opPerson = opPerson;
    }

    public void setRequest(FlightOrderAuditOpRequest request) {
        this.request = request;
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

    public String getOrderMainId() {
        return request.getOrderMainId();
    }

    public void setOrderMainId(String orderMainId) {
        request.setOrderMainId(orderMainId);
    }

    public String getOrderMainNo() {
        return request.getOrderMainNo();
    }

    public void setOrderMainNo(String orderMainNo) {
        request.setOrderMainNo(orderMainNo);
    }

    public String getOrderId() {
        return request.getOrderId();
    }

    public void setOrderId(String orderId) {
        request.setOrderId(orderId);
    }

    public String getOrderNo() {
        return request.getOrderNo();
    }

    public void setOrderNo(String orderNo) {
        request.setOrderNo(orderNo);
    }

    public String getSuppOrderNo() {
        return request.getSuppOrderNo();
    }

    public void setSuppOrderNo(String suppOrderNo) {
        request.setSuppOrderNo(suppOrderNo);
    }

    public String getOfficeNo() {
        return request.getOfficeNo();
    }

    public void setOfficeNo(String officeNo) {
        request.setOfficeNo(officeNo);
    }

    public String getLvmamaAccount() {
        return request.getLvmamaAccount();
    }

    public void setLvmamaAccount(String lvmamaAccount) {
        request.setLvmamaAccount(lvmamaAccount);
    }

    public String getPnr() {
        return request.getPnr();
    }

    public void setPnr(String pnr) {
        request.setPnr(pnr);
    }

    public String getCustomerName() {
        return request.getCustomerName();
    }

    public void setCustomerName(String customerName) {
        request.setCustomerName(customerName);
    }

    public String getPassenger() {
        return request.getPassenger();
    }

    public void setPassenger(String passenger) {
        request.setPassenger(passenger);
    }

    public String getPassengerIDCardNo() {
        return request.getPassengerIDCardNo();
    }

    public void setPassengerIDCardNo(String passengerIDCardNo) {
        request.setPassengerIDCardNo(passengerIDCardNo);
    }

    public String getPassengerCellphone() {
        return request.getPassengerCellphone();
    }

    public void setPassengerCellphone(String passengerCellphone) {
        request.setPassengerCellphone(passengerCellphone);
    }

    public String getContacterName() {
        return request.getContacterName();
    }

    public void setContacterName(String contacterName) {
        request.setContacterName(contacterName);
    }

    public String getContactPhone() {
        return request.getContactPhone();
    }

    public void setContactPhone(String contactPhone) {
        request.setContactPhone(contactPhone);
    }

    public String getTicketNo() {
        return request.getTicketNo();
    }

    public void setTicketNo(String ticketNo) {
        request.setTicketNo(ticketNo);
    }

    public String getFlightNo() {
        return request.getFlightNo();
    }

    public void setFlightNo(String flightNo) {
        request.setFlightNo(flightNo);
    }

    public String getOrderStatus() {
        return request.getOrderStatus();
    }

    public void setOrderStatus(String orderStatus) {
        request.setOrderStatus(orderStatus);
    }

    public AuditType getAuditType() {
        return request.getAuditType();
    }

    public void setAuditType(AuditType auditType) {
        request.setAuditType(auditType);
    }

    public String getDepartureCity() {
        return request.getDepartureCity();
    }

    public void setDepartureCity(String departureCity) {
        request.setDepartureCity(departureCity);
    }

    public String getArriveCity() {
        return request.getArriveCity();
    }

    public void setArriveCity(String arriveCity) {
        request.setArriveCity(arriveCity);
    }

    public String getBookingQueryBegTime() {
        return request.getBookingQueryBegTime();
    }

    public void setBookingQueryBegTime(String bookingQueryBegTime) {
        request.setBookingQueryBegTime(bookingQueryBegTime);
    }

    public String getBookingQueryEndTime() {
        return request.getBookingQueryEndTime();
    }

    public void setBookingQueryEndTime(String bookingQueryEndTime) {
        request.setBookingQueryEndTime(bookingQueryEndTime);
    }

    public String getFlightQueryBegTime() {
        return request.getFlightQueryBegTime();
    }

    public void setFlightQueryBegTime(String flightQueryBegTime) {
        request.setFlightQueryBegTime(flightQueryBegTime);
    }

    public String getFlightQueryEndTime() {
        return request.getFlightQueryEndTime();
    }

    public void setFlightQueryEndTime(String flightQueryEndTime) {
        request.setFlightQueryEndTime(flightQueryEndTime);
    }

    public String getIssueBegTime() {
        return request.getIssueBegTime();
    }

    public void setIssueBegTime(String issueBegTime) {
        request.setIssueBegTime(issueBegTime);
    }

    public String getIssueEndTime() {
        return request.getIssueEndTime();
    }

    public void setIssueEndTime(String issueEndTime) {
        request.setIssueEndTime(issueEndTime);
    }

    public String getUpdateBegTime() {
        return request.getUpdateBegTime();
    }

    public void setUpdateBegTime(String updateBegTime) {
        request.setUpdateBegTime(updateBegTime);
    }

    public String getUpdateEndTime() {
        return request.getUpdateEndTime();
    }

    public void setUpdateEndTime(String updateEndTime) {
        request.setUpdateEndTime(updateEndTime);
    }

    public String getCommitBegTime() {
        return request.getCommitBegTime();
    }

    public void setCommitBegTime(String commitBegTime) {
        request.setCommitBegTime(commitBegTime);
    }

    public String getCommitEndTime() {
        return request.getCommitEndTime();
    }

    public void setCommitEndTime(String commitEndTime) {
        request.setCommitEndTime(commitEndTime);
    }

    public String getGatherBegTime() {
        return request.getGatherBegTime();
    }

    public void setGatherBegTime(String gatherBegTime) {
        request.setGatherBegTime(gatherBegTime);
    }

    public String getGatherEndTime() {
        return request.getGatherEndTime();
    }

    public void setGatherEndTime(String gatherEndTime) {
        request.setGatherEndTime(gatherEndTime);
    }

    public String getCreatePer() {
        return request.getCreatePer();
    }

    public void setCreatePer(String createPer) {
        request.setCreatePer(createPer);
    }

    public String getPayer() {
        return request.getPayer();
    }

    public void setPayer(String payer) {
        request.setPayer(payer);
    }

    public String getAuditPer() {
        return request.getAuditPer();
    }

    public void setAuditPer(String auditPer) {
        request.setAuditPer(auditPer);
    }

    public String getIssuePer() {
        return request.getIssuePer();
    }

    public void setIssuePer(String issuePer) {
        request.setIssuePer(issuePer);
    }

    public String getGatherPer() {
        return request.getGatherPer();
    }

    public void setGatherPer(String gatherPer) {
        request.setGatherPer(gatherPer);
    }

    public Long getId() {
        return request.getId();
    }

    public AuditStatus getAuditStatus() {
        return request.getAuditStatus();
    }

    public void setAuditStatus(AuditStatus auditStatus) {
        request.setAuditStatus(auditStatus);
    }
	/** 订单账户类型*/
	public OrderFlag getOrderFlag() {
		return request.getOrderFlag();
	}

	public void setOrderFlag(OrderFlag orderFlag) {
		request.setOrderFlag(orderFlag);
	}
	
	public String getSuppCode() {
		return request.getSuppCode();
	}

	public void setSuppCode(String suppCode) {
		request.setSuppCode(suppCode);
	}

    public String getSaleType() {
        return request.getSaleType();
    }

    public void setSaleType(String saleType) {
        request.setSaleType(saleType);
    }
}
