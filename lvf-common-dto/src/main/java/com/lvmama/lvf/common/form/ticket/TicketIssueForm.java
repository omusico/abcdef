package com.lvmama.lvf.common.form.ticket;

import java.io.Serializable;
import java.util.List;

import com.lvmama.lvf.common.dto.order.FlightOrderDetailDto;
import com.lvmama.lvf.common.dto.request.FlightOrderTicketIssueRequest;
import com.lvmama.lvf.common.form.Form;

/**
 * 出票信息From
 * 
 * @author yuanweihong
 * @date 2015-4-8
 */
public class TicketIssueForm implements Serializable, Form {

	private static final long serialVersionUID = -1203174980639605583L;

	private FlightOrderTicketIssueRequest request = new FlightOrderTicketIssueRequest();
	
	/** 供应商订单号 */
	private List<String> suppOrderNos;

	public FlightOrderTicketIssueRequest getRequest() {
		return request;
	}

	public void setRequest(FlightOrderTicketIssueRequest request) {
		this.request = request;
	}

	public Long getAuditOpId() {
		return request.getAuditOpId();
	}

	public void setAuditOpId(Long auditOpId) {
		request.setAuditOpId(auditOpId);
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

	public boolean isAudit() {
		return request.isAudit();
	}

	public void setAudit(boolean isAudit) {
		request.setAudit(isAudit);
	}

	public List<FlightOrderDetailDto> getFlightOrderDetails() {
		return request.getFlightOrderDetails();
	}

	public void setFlightOrderDetails(
			List<FlightOrderDetailDto> flightOrderDetails) {
		request.setFlightOrderDetails(flightOrderDetails);
	}

    public List<String> getSuppOrderNos() {
        return suppOrderNos;
    }

    public void setSuppOrderNos(List<String> suppOrderNos) {
        this.suppOrderNos = suppOrderNos;
    }

	public String getSuppOrderNo() {
		return request.getSuppOrderNo();
	}

	public void setSuppOrderNo(String suppOrderNo) {
		request.setSuppOrderNo(suppOrderNo);
	}
}
