package com.lvmama.lvf.common.dto.order;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnore;

import com.lvmama.lvf.common.domain.FkId;
import com.lvmama.lvf.common.dto.Entity;
import com.lvmama.lvf.common.dto.status.detail.DetailBookingStatus;
import com.lvmama.lvf.common.dto.status.detail.DetailLockStatus;
import com.lvmama.lvf.common.dto.status.detail.DetailTicketStatus;
import com.lvmama.lvf.common.dto.ticket.FlightOrderTicketCTMTDto;
import com.lvmama.lvf.common.dto.ticket.FlightOrderTicketIssueDto;

/**
 * 订单明细信息
 * @author majun
 * @date   2015-2-5
 */
public class FlightOrderDetailDto extends Entity implements Serializable{
	
	private static final long serialVersionUID = 3240024573248122399L;

	/** 订单主键 */
	private Long orderId;
	
	/** 前一个订单明细信息主键 */
	private Long orderDetailPreId;
	
	/** 订单航班组合明细信息 */
	@FkId
	private FlightOrderFlightCombinationDetailDto combinationDetail;
	
	/** 订单PNR信息 */
	@FkId
	private FlightOrderPNRInfoDto flightOrderPNRInfo;
	
	/** 订单乘机人信息 */
	@FkId
	private FlightOrderPassengerDto flightOrderPassenger;
	
	/** 订单票号信息 */
	@FkId
	private FlightOrderTicketInfoDto flightOrderTicketInfo;
	
	/** 票价信息 */
	private FlightOrderTicketPriceDto flightOrderTicketPrice;
	
	/** 订位状态 */
	private DetailBookingStatus detailBookingStatus;
	
	/** 票号状态 */
	private DetailTicketStatus detailTicketStatus;
	
	/** 订单明细退废票申请 */
	private FlightOrderDetailRTVTDto flightOrderDetailRTVT;
	
	/** CTMT改期改签信息 */
	private FlightOrderTicketCTMTDto flightOrderTicketCTMT;
	
	/** 人工出票信息  */
	private FlightOrderTicketIssueDto flightOrderTicketIssue;
	
	/** 明细锁定状态 */
	private DetailLockStatus detailLockStatus;
	
	public FlightOrderDetailRTVTDto getFlightOrderDetailRTVT() {
		return flightOrderDetailRTVT;
	}

	public void setFlightOrderDetailRTVT(
			FlightOrderDetailRTVTDto flightOrderDetailRTVT) {
		this.flightOrderDetailRTVT = flightOrderDetailRTVT;
	}

	public FlightOrderTicketCTMTDto getFlightOrderTicketCTMT() {
		return flightOrderTicketCTMT;
	}

	public void setFlightOrderTicketCTMT(
			FlightOrderTicketCTMTDto flightOrderTicketCTMT) {
		this.flightOrderTicketCTMT = flightOrderTicketCTMT;
	}

	public FlightOrderTicketIssueDto getFlightOrderTicketIssue() {
		return flightOrderTicketIssue;
	}

	public void setFlightOrderTicketIssue(
			FlightOrderTicketIssueDto flightOrderTicketIssue) {
		this.flightOrderTicketIssue = flightOrderTicketIssue;
	}

	public DetailBookingStatus getDetailBookingStatus() {
		return detailBookingStatus;
	}

	public void setDetailBookingStatus(DetailBookingStatus detailBookingStatus) {
		this.detailBookingStatus = detailBookingStatus;
	}

	public DetailTicketStatus getDetailTicketStatus() {
		return detailTicketStatus;
	}

	public void setDetailTicketStatus(DetailTicketStatus detailTicketStatus) {
		this.detailTicketStatus = detailTicketStatus;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getOrderDetailPreId() {
		return orderDetailPreId;
	}

	public void setOrderDetailPreId(Long orderDetailPreId) {
		this.orderDetailPreId = orderDetailPreId;
	}

	public FlightOrderFlightCombinationDetailDto getCombinationDetail() {
		return combinationDetail;
	}

	public void setCombinationDetail(
			FlightOrderFlightCombinationDetailDto combinationDetail) {
		this.combinationDetail = combinationDetail;
	}

	public FlightOrderPNRInfoDto getFlightOrderPNRInfo() {
		return flightOrderPNRInfo;
	}

	public void setFlightOrderPNRInfo(FlightOrderPNRInfoDto flightOrderPNRInfo) {
		this.flightOrderPNRInfo = flightOrderPNRInfo;
	}

	public FlightOrderPassengerDto getFlightOrderPassenger() {
		return flightOrderPassenger;
	}

	public void setFlightOrderPassenger(FlightOrderPassengerDto flightOrderPassenger) {
		this.flightOrderPassenger = flightOrderPassenger;
	}

	public FlightOrderTicketInfoDto getFlightOrderTicketInfo() {
		return flightOrderTicketInfo;
	}

	public void setFlightOrderTicketInfo(
			FlightOrderTicketInfoDto flightOrderTicketInfo) {
		this.flightOrderTicketInfo = flightOrderTicketInfo;
	}

	public FlightOrderTicketPriceDto getFlightOrderTicketPrice() {
		return flightOrderTicketPrice;
	}

	public void setFlightOrderTicketPrice(
			FlightOrderTicketPriceDto flightOrderTicketPrice) {
		this.flightOrderTicketPrice = flightOrderTicketPrice;
	}
	
	public DetailLockStatus getDetailLockStatus() {
		return detailLockStatus;
	}

	public void setDetailLockStatus(DetailLockStatus detailLockStatus) {
		this.detailLockStatus = detailLockStatus;
	}

	public void setIsCanIssue(boolean isCanIssue){}
	
	/**
	 * 可否进行出票
	 * @return
	 */
	public boolean getIsCanIssue()
	{
		if(this.detailTicketStatus == DetailTicketStatus.NOT_ISSUE || 
			this.detailTicketStatus == DetailTicketStatus.ISSUE_FAIL)
		{
			return true;
		}
		return false;
	}
	
	public void setIsCanRTVT(boolean isCanRTVT){}
	
	/**
	 * 可否进行退废票
	 * @return
	 */
	public boolean getIsCanRTVT()
	{
		if(this.detailLockStatus == null)
		{
			return true;
		}
		else if(this.detailLockStatus == DetailLockStatus.UN_LOCK && (this.detailTicketStatus == DetailTicketStatus.ISSUE_SUCC || 
			this.detailTicketStatus == DetailTicketStatus.RTVT_FAIL || this.detailTicketStatus == DetailTicketStatus.CTMT_SUCC ||
			this.detailTicketStatus == DetailTicketStatus.CTMT_FAIL))
		{
			return true;
		}
		return false;
	}
	
	public void setIsCanCTMT(boolean isCanCTMT){}
	
	/**
	 * 可否进行改签
	 * @return
	 */
	public boolean getIsCanCTMT()
	{
		if(this.detailLockStatus == null)
		{
			return true;
		}
		else if(this.detailLockStatus == DetailLockStatus.UN_LOCK && (this.detailTicketStatus == DetailTicketStatus.ISSUE_SUCC || 
				this.detailTicketStatus == DetailTicketStatus.RTVT_FAIL || this.detailTicketStatus == DetailTicketStatus.CTMT_SUCC ||
				this.detailTicketStatus == DetailTicketStatus.CTMT_FAIL))
		{
			return true;
		}
		return false;
	}
	
	@Override
	@JsonIgnore
	public String getSequence() {
		return "S_FORD_ORDER_DETAIL";
	}

}
