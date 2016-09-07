package com.lvmama.lvf.common.form.ticket;

import java.io.Serializable;
import java.util.Date;

import com.lvmama.lvf.common.dto.enums.BSPRecycleStatus;
import com.lvmama.lvf.common.dto.enums.BSPStatus;
import com.lvmama.lvf.common.dto.request.FlightTicketBSPDetailRequest;
import com.lvmama.lvf.common.dto.ticket.FlightTicketBSPDetailDelegate;
import com.lvmama.lvf.common.dto.ticket.FlightTicketBSPDetailDto;
import com.lvmama.lvf.common.form.Form;
import com.lvmama.lvf.common.utils.DateUtils;

/**
 * 行程单明细 responseForm
 * 
 * @author zzs
 * 
 */
public class TicketBSPDetailResponseForm implements Serializable, Form {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8917890807919953118L;
	
	FlightTicketBSPDetailDelegate flightTicketBSPDetailDelegate = new FlightTicketBSPDetailDelegate();
	
	
	public TicketBSPDetailResponseForm() {
	}
	
	public TicketBSPDetailResponseForm(FlightTicketBSPDetailDelegate flightTicketBSPDetailDelegate) {
		this.flightTicketBSPDetailDelegate = flightTicketBSPDetailDelegate; 
			
	}

	public FlightTicketBSPDetailDelegate getFlightTicketBSPDetailDelegate() {
		return flightTicketBSPDetailDelegate;
	}

	public void setFlightTicketBSPDetailDelegate(FlightTicketBSPDetailDelegate flightTicketBSPDetailDelegate) {
		this.flightTicketBSPDetailDelegate = flightTicketBSPDetailDelegate;
	}

	public void setId(Long id) {
		flightTicketBSPDetailDelegate.setId(id);
	}

	public String getTicketBSPNo() {
		return flightTicketBSPDetailDelegate.getTicketBSPNo();
	}

	public void setTicketBSPNo(String ticketBSPNo) {
		flightTicketBSPDetailDelegate.setTicketBSPNo(ticketBSPNo);
	}

	public String getBspStatus() {
		return flightTicketBSPDetailDelegate.getBspStatus().getCnName();
	}

	public void setBspStatus(BSPStatus bspStatus) {
		flightTicketBSPDetailDelegate.setBspStatus(bspStatus);
	}

	public void setCreateTime(Date createTime) {
		flightTicketBSPDetailDelegate.setCreateTime(createTime);
	}

	public String getBspRecycleStatus() {
		return flightTicketBSPDetailDelegate.getBspRecycleStatus().getCnName();
	}

	public Date getUpdateTime() {
		return flightTicketBSPDetailDelegate.getUpdateTime();
	}

	public void setUpdateTime(Date updateTime) {
		flightTicketBSPDetailDelegate.setUpdateTime(updateTime);
	}

	public void setBspRecycleStatus(BSPRecycleStatus bspRecycleStatus) {
		flightTicketBSPDetailDelegate.setBspRecycleStatus(bspRecycleStatus);
	}

	public String getOperName() {
		return flightTicketBSPDetailDelegate.getOperName();
	}

	public void setOperName(String operName) {
		flightTicketBSPDetailDelegate.setOperName(operName);
	}

	public String getBspRemark() {
		return flightTicketBSPDetailDelegate.getBspRemark();
	}

	public void setBspRemark(String bspRemark) {
		flightTicketBSPDetailDelegate.setBspRemark(bspRemark);
	}

	public Long getOrderId() {
		return flightTicketBSPDetailDelegate.getOrderId();
	}

	public void setOrderId(Long orderId) {
		flightTicketBSPDetailDelegate.setOrderId(orderId);
	}

	public Long getTicketId() {
		return flightTicketBSPDetailDelegate.getTicketId();
	}

	public void setTicketId(Long ticketId) {
		flightTicketBSPDetailDelegate.setTicketId(ticketId);
	}

	public Long getBspStorageId() {
		return flightTicketBSPDetailDelegate.getBspStorageId();
	}

	public void setBspStorageId(Long bspStorageId) {
		flightTicketBSPDetailDelegate.setBspStorageId(bspStorageId);
	}

	public FlightTicketBSPDetailDto getFlightTicketBSPDetailDto() {
		return flightTicketBSPDetailDelegate.getFlightTicketBSPDetailDto();
	}

	public void setFlightTicketBSPDetailDto(FlightTicketBSPDetailDto flightTicketBSPDetailDto) {
		flightTicketBSPDetailDelegate.setFlightTicketBSPDetailDto(flightTicketBSPDetailDto);
	}

	public String getTicketNo() {
		return flightTicketBSPDetailDelegate.getTicketNo();
	}

	public void setTicketNo(String ticketNo) {
		flightTicketBSPDetailDelegate.setTicketNo(ticketNo);
	}

	public String getOfficeNo() {
		return flightTicketBSPDetailDelegate.getOfficeNo();
	}

	public void setOfficeNo(String officeNo) {
		flightTicketBSPDetailDelegate.setOfficeNo(officeNo);
	}

	public String getPnr() {
		return flightTicketBSPDetailDelegate.getPnr();
	}

	public void setPnr(String pnr) {
		flightTicketBSPDetailDelegate.setPnr(pnr);
	}

	public String getCustomerName() {
		return flightTicketBSPDetailDelegate.getCustomerName();
	}

	public void setCustomerName(String customerName) {
		flightTicketBSPDetailDelegate.setCustomerName(customerName);
	}

	public Long getId() {
		return flightTicketBSPDetailDelegate.getId();
	}

	public String getCreateTime() {
		return DateUtils.formatCnHmDate(flightTicketBSPDetailDelegate.getCreateTime());
	}

	public void copyFromRequest(FlightTicketBSPDetailRequest request) {
		flightTicketBSPDetailDelegate.copyFromRequest(request);
	}
}
