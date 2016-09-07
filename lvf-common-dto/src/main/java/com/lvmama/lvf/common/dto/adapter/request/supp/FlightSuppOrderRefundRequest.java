package com.lvmama.lvf.common.dto.adapter.request.supp;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.lvmama.lvf.common.dto.adapter.request.supp.base.SuppRequest;
import com.lvmama.lvf.common.dto.enums.ApplyRefundActionType;
import com.lvmama.lvf.common.dto.enums.ApplyRefundType;
import com.lvmama.lvf.common.dto.enums.PnrCancelType;
import com.lvmama.lvf.common.dto.order.FlightOrderFlightInfoDto;

/**
 * 
 * @author mashengwen
 * RC1
 */
@XmlRootElement
public class FlightSuppOrderRefundRequest extends SuppRequest implements
		Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 348611870169253887L;
	private String orderNo;
	private String orderRefundNo;
	private String suppOrderNo;
	private String suppCode;
	private BigDecimal refundFee;
	
	private ApplyRefundType applyRefundType; 
	private ApplyRefundActionType applyRefundActionType;
	private List<FlightSuppOrderRefundRequestDetail> refundDetails;
	
	private PnrCancelType pnrCancelType;
	private String refundReason;
	private String refundAttachPath;
	private String refundRemark;
	private String refundNotifiedUrl;
	//517na添加
	private FlightOrderFlightInfoDto flightOrderFlightInfoDto;
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getOrderRefundNo() {
		return orderRefundNo;
	}
	public void setOrderRefundNo(String orderRefundNo) {
		this.orderRefundNo = orderRefundNo;
	}
	public String getSuppOrderNo() {
		return suppOrderNo;
	}
	public void setSuppOrderNo(String suppOrderNo) {
		this.suppOrderNo = suppOrderNo;
	}
	public ApplyRefundType getApplyRefundType() {
		return applyRefundType;
	}
	public void setApplyRefundType(ApplyRefundType applyRefundType) {
		this.applyRefundType = applyRefundType;
	}
	public ApplyRefundActionType getApplyRefundActionType() {
		return applyRefundActionType;
	}
	public void setApplyRefundActionType(ApplyRefundActionType applyRefundActionType) {
		this.applyRefundActionType = applyRefundActionType;
	}
	public List<FlightSuppOrderRefundRequestDetail> getRefundDetails() {
		return refundDetails;
	}
	public void setRefundDetails(
			List<FlightSuppOrderRefundRequestDetail> refundDetails) {
		this.refundDetails = refundDetails;
	}
	public PnrCancelType getPnrCancelType() {
		return pnrCancelType;
	}
	public void setPnrCancelType(PnrCancelType pnrCancelType) {
		this.pnrCancelType = pnrCancelType;
	}
	public String getRefundReason() {
		return refundReason;
	}
	public void setRefundReason(String refundReason) {
		this.refundReason = refundReason;
	}
	public String getRefundAttachPath() {
		return refundAttachPath;
	}
	public void setRefundAttachPath(String refundAttachPath) {
		this.refundAttachPath = refundAttachPath;
	}
	public String getRefundRemark() {
		return refundRemark;
	}
	public void setRefundRemark(String refundRemark) {
		this.refundRemark = refundRemark;
	}
	public String getRefundNotifiedUrl() {
		return refundNotifiedUrl;
	}
	public void setRefundNotifiedUrl(String refundNotifiedUrl) {
		this.refundNotifiedUrl = refundNotifiedUrl;
	}
	public String getSuppCode() {
		return suppCode;
	}
	public void setSuppCode(String suppCode) {
		this.suppCode = suppCode;
	}
	public BigDecimal getRefundFee() {
		return refundFee;
	}
	public void setRefundFee(BigDecimal refundFee) {
		this.refundFee = refundFee;
	}
	public FlightOrderFlightInfoDto getFlightOrderFlightInfoDto() {
		return flightOrderFlightInfoDto;
	}
	public void setFlightOrderFlightInfoDto(
			FlightOrderFlightInfoDto flightOrderFlightInfoDto) {
		this.flightOrderFlightInfoDto = flightOrderFlightInfoDto;
	}
	
}
