package com.lvmama.lvf.common.form.ticket;

import java.util.Date;

import com.lvmama.lvf.common.dto.PersistenceType;
import com.lvmama.lvf.common.dto.order.FlightOrderDetailDto;
import com.lvmama.lvf.common.dto.order.FlightOrderDetailRTVTDto;
import com.lvmama.lvf.common.dto.order.FlightOrderFlightCombinationDetailDto;
import com.lvmama.lvf.common.dto.order.FlightOrderPNRInfoDto;
import com.lvmama.lvf.common.dto.order.FlightOrderPassengerDto;
import com.lvmama.lvf.common.dto.order.FlightOrderTicketInfoDto;
import com.lvmama.lvf.common.dto.order.FlightOrderTicketPriceDto;
import com.lvmama.lvf.common.dto.status.detail.DetailBookingStatus;
import com.lvmama.lvf.common.dto.status.detail.DetailTicketStatus;
import com.lvmama.lvf.common.dto.ticket.FlightOrderTicketCTMTDto;
import com.lvmama.lvf.common.dto.ticket.FlightOrderTicketIssueDto;
import com.lvmama.lvf.common.form.Form;

/**
 * 退废票处理
 * 
 */
public class TicketRTVTOpResponseForm implements Form {

	private FlightOrderDetailDto flightOrderDetail;

	public FlightOrderDetailDto getFlightOrderDetail() {
		return flightOrderDetail;
	}

	public void setFlightOrderDetail(FlightOrderDetailDto flightOrderDetail) {
		this.flightOrderDetail = flightOrderDetail;
	}

	public PersistenceType getPtype() {
		return flightOrderDetail.getPtype();
	}

	public void setPtype(PersistenceType ptype) {
		flightOrderDetail.setPtype(ptype);
	}

	public Long getId() {
		return flightOrderDetail.getId();
	}

	public void setId(Long id) {
		flightOrderDetail.setId(id);
	}

	public String getUuid() {
		return flightOrderDetail.getUuid();
	}

	public void setUuid(String uuid) {
		flightOrderDetail.setUuid(uuid);
	}

	public Date getCreateTime() {
		return flightOrderDetail.getCreateTime();
	}

	public void setCreateTime(Date createTime) {
		flightOrderDetail.setCreateTime(createTime);
	}

	public Date getUpdateTime() {
		return flightOrderDetail.getUpdateTime();
	}

	public void setUpdateTime(Date updateTime) {
		flightOrderDetail.setUpdateTime(updateTime);
	}

	public Long getOrderId() {
		return flightOrderDetail.getOrderId();
	}

	public void setOrderId(Long orderId) {
		flightOrderDetail.setOrderId(orderId);
	}

	public Long getOrderDetailPreId() {
		return flightOrderDetail.getOrderDetailPreId();
	}

	public void setOrderDetailPreId(Long orderDetailPreId) {
		flightOrderDetail.setOrderDetailPreId(orderDetailPreId);
	}

	public FlightOrderFlightCombinationDetailDto getCombinationDetail() {
		return flightOrderDetail.getCombinationDetail();
	}

	public void setCombinationDetail(
			FlightOrderFlightCombinationDetailDto combinationDetail) {
		flightOrderDetail.setCombinationDetail(combinationDetail);
	}

	public FlightOrderPNRInfoDto getFlightOrderPNRInfo() {
		return flightOrderDetail.getFlightOrderPNRInfo();
	}

	public void setFlightOrderPNRInfo(FlightOrderPNRInfoDto flightOrderPNRInfo) {
		flightOrderDetail.setFlightOrderPNRInfo(flightOrderPNRInfo);
	}

	public FlightOrderPassengerDto getFlightOrderPassenger() {
		return flightOrderDetail.getFlightOrderPassenger();
	}

	public void setFlightOrderPassenger(
			FlightOrderPassengerDto flightOrderPassenger) {
		flightOrderDetail.setFlightOrderPassenger(flightOrderPassenger);
	}

	public FlightOrderTicketInfoDto getFlightOrderTicketInfo() {
		return flightOrderDetail.getFlightOrderTicketInfo();
	}

	public void setFlightOrderTicketInfo(
			FlightOrderTicketInfoDto flightOrderTicketInfo) {
		flightOrderDetail.setFlightOrderTicketInfo(flightOrderTicketInfo);
	}

	public FlightOrderTicketPriceDto getFlightOrderTicketPrice() {
		return flightOrderDetail.getFlightOrderTicketPrice();
	}

	public void setFlightOrderTicketPrice(
			FlightOrderTicketPriceDto flightOrderTicketPrice) {
		flightOrderDetail.setFlightOrderTicketPrice(flightOrderTicketPrice);
	}

	public String getSequence() {
		return flightOrderDetail.getSequence();
	}

public FlightOrderDetailRTVTDto getFlightOrderDetailRTVT() {
	return flightOrderDetail.getFlightOrderDetailRTVT();
}

public void setFlightOrderDetailRTVT(
		FlightOrderDetailRTVTDto flightOrderDetailRTVT) {
	flightOrderDetail.setFlightOrderDetailRTVT(flightOrderDetailRTVT);
}

public FlightOrderTicketCTMTDto getFlightOrderTicketCTMT() {
	return flightOrderDetail.getFlightOrderTicketCTMT();
}

public void setFlightOrderTicketCTMT(
		FlightOrderTicketCTMTDto flightOrderTicketCTMT) {
	flightOrderDetail.setFlightOrderTicketCTMT(flightOrderTicketCTMT);
}

public FlightOrderTicketIssueDto getFlightOrderTicketIssue() {
	return flightOrderDetail.getFlightOrderTicketIssue();
}

public void setFlightOrderTicketIssue(
		FlightOrderTicketIssueDto flightOrderTicketIssue) {
	flightOrderDetail.setFlightOrderTicketIssue(flightOrderTicketIssue);
}

public DetailBookingStatus getDetailBookingStatus() {
	return flightOrderDetail.getDetailBookingStatus();
}

public void setDetailBookingStatus(DetailBookingStatus detailBookingStatus) {
	flightOrderDetail.setDetailBookingStatus(detailBookingStatus);
}

public DetailTicketStatus getDetailTicketStatus() {
	return flightOrderDetail.getDetailTicketStatus();
}

public void setDetailTicketStatus(DetailTicketStatus detailTicketStatus) {
	flightOrderDetail.setDetailTicketStatus(detailTicketStatus);
}
	
	

}
