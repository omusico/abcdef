package com.lvmama.lvf.common.dto.request;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.lvmama.lvf.common.dto.BaseAuditRequest;
import com.lvmama.lvf.common.dto.enums.ApplyRefundType;
import com.lvmama.lvf.common.dto.enums.BookingSource;
import com.lvmama.lvf.common.dto.order.FlightOrderDetailDto;
import com.lvmama.lvf.common.dto.order.FlightOrderRemarkDto;

/**
 * 订单退废票请求对象
 * @author majun
 * @date   2015-3-28
 */
public class FlightOrderTicketRTVTRequest extends BaseAuditRequest  implements Serializable
{
	private static final long serialVersionUID = -7462056893978771083L;

	/** 订单主键 */
	private Long orderId;
	
	/** 审核操作主键 */
	private Long auditOpId;
	
	/** 订单退废票明细信息列表*/
	private List<FlightOrderDetailDto> flightOrderDetails = new ArrayList<FlightOrderDetailDto>();
	
	/** 退票类型 */
	private ApplyRefundType applyRefundType;
	
	/** 是否取消PNR */
	private boolean cancelPNR;
	
	/** 退票原因 */
	private String refundReason;
	
	/** 附件主键列表 */
	private List<Long> attachmentIds = new ArrayList<Long>();
	
	/** 备注信息 */
	private FlightOrderRemarkDto flightOrderRemark;
	
	/** 审核通过或者处理通过 */
	private boolean passFlag;
	
	/** 需要退款的订单保险主键 */
	private List<Long> orderInsuranceIds;
	
	/** 退票操作渠道 */
	private BookingSource bookingSource;
	
	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getAuditOpId() {
		return auditOpId;
	}

	public void setAuditOpId(Long auditOpId) {
		this.auditOpId = auditOpId;
	}

	public List<FlightOrderDetailDto> getFlightOrderDetails() {
		return flightOrderDetails;
	}

	public void setFlightOrderDetails(List<FlightOrderDetailDto> flightOrderDetails) {
		this.flightOrderDetails = flightOrderDetails;
	}

	public ApplyRefundType getApplyRefundType() {
		return applyRefundType;
	}

	public void setApplyRefundType(ApplyRefundType applyRefundType) {
		this.applyRefundType = applyRefundType;
	}

	public boolean getCancelPNR() {
		return cancelPNR;
	}

	public void setCancelPNR(boolean cancelPNR) {
		this.cancelPNR = cancelPNR;
	}

	public String getRefundReason() {
		return refundReason;
	}

	public void setRefundReason(String refundReason) {
		this.refundReason = refundReason;
	}

	public List<Long> getAttachmentIds() {
		return attachmentIds;
	}

	public void setAttachmentIds(List<Long> attachmentIds) {
		this.attachmentIds = attachmentIds;
	}

	public FlightOrderRemarkDto getFlightOrderRemark() {
		return flightOrderRemark;
	}

	public void setFlightOrderRemark(FlightOrderRemarkDto flightOrderRemark) {
		this.flightOrderRemark = flightOrderRemark;
	}
	
	public boolean getPassFlag()
	{
		return passFlag;
	}
	
	public void setPassFlag(boolean passFlag) {
		this.passFlag = passFlag;
	}

	public List<Long> getOrderInsuranceIds() {
		return orderInsuranceIds;
	}

	public void setOrderInsuranceIds(List<Long> orderInsuranceIds) {
		this.orderInsuranceIds = orderInsuranceIds;
	}

	public BookingSource getBookingSource() {
		return bookingSource;
	}

	public void setBookingSource(BookingSource bookingSource) {
		this.bookingSource = bookingSource;
	}
	
}
