package com.lvmama.lvf.common.form.ticket;

import java.util.List;

import com.lvmama.lvf.common.dto.enums.ApplyRefundType;
import com.lvmama.lvf.common.dto.order.FlightOrderDetailDto;
import com.lvmama.lvf.common.dto.order.FlightOrderRemarkDto;
import com.lvmama.lvf.common.dto.request.FlightOrderTicketRTVTRequest;
import com.lvmama.lvf.common.form.Form;

/**
 * 退废票申请
 * @author lujingzhong
 *
 */
public class TicketRTVTApplyForm implements Form 
{
	private FlightOrderTicketRTVTRequest request = new FlightOrderTicketRTVTRequest();

	public FlightOrderTicketRTVTRequest getRequest() {
		return request;
	}

	public void setRequest(FlightOrderTicketRTVTRequest request) {
		this.request = request;
	}

	public Long getAuditOpId() {
		return request.getAuditOpId();
	}

	public void setAuditOpId(Long auditOpId) {
		request.setAuditOpId(auditOpId);
	}

	public Long getOrderId() {
		return request.getOrderId();
	}

	public void setOrderId(Long orderId) {
		request.setOrderId(orderId);
	}

	public List<FlightOrderDetailDto> getFlightOrderDetails() {
		return request.getFlightOrderDetails();
	}

	public void setFlightOrderDetails(
			List<FlightOrderDetailDto> flightOrderDetails) {
		request.setFlightOrderDetails(flightOrderDetails);
	}

	public ApplyRefundType getApplyRefundType() {
		return request.getApplyRefundType();
	}

	public void setApplyRefundType(ApplyRefundType applyRefundType) {
		request.setApplyRefundType(applyRefundType);
	}

	public boolean getCancelPNR() {
		return request.getCancelPNR();
	}

	public void setCancelPNR(boolean cancelPNR) {
		request.setCancelPNR(cancelPNR);
	}

	public String getRefundReason() {
		return request.getRefundReason();
	}

	public void setRefundReason(String refundReason) {
		request.setRefundReason(refundReason);
	}

	public List<Long> getAttachmentIds() {
		return request.getAttachmentIds();
	}

	public void setAttachmentIds(List<Long> attachmentIds) {
		request.setAttachmentIds(attachmentIds);
	}

	public FlightOrderRemarkDto getFlightOrderRemark() {
		return request.getFlightOrderRemark();
	}

	public void setFlightOrderRemark(FlightOrderRemarkDto flightOrderRemark) {
		request.setFlightOrderRemark(flightOrderRemark);
	}

	public boolean getPassFlag() {
		return request.getPassFlag();
	}

	public void setPassFlag(boolean passFlag) {
		request.setPassFlag(passFlag);
	}

	public List<Long> getOrderInsuranceIds() {
		return request.getOrderInsuranceIds();
	}

	public void setOrderInsuranceIds(List<Long> orderInsuranceIds) {
		request.setOrderInsuranceIds(orderInsuranceIds);
	}
}