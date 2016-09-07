package com.lvmama.lvf.common.dto.ticket;

import java.io.Serializable;
import java.util.Date;

import com.lvmama.lvf.common.dto.enums.BSPRecycleStatus;
import com.lvmama.lvf.common.dto.enums.BSPStatus;
import com.lvmama.lvf.common.dto.request.FlightTicketBSPDetailRequest;

/**   
 * @Title: FlightTikectBSPDetailDelegate.java 
 * @Package com.lvmama.lvf.common.dto.ticket 
 * @Description: TODO(..) 
 * @author Chase_lv
 * @date 2015年4月30日 下午9:34:53 
 */
public class FlightTicketBSPDetailDelegate implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1979805338964167232L;

	private FlightTicketBSPDetailDto flightTicketBSPDetailDto = new FlightTicketBSPDetailDto();
	
	/** 票号*/
	private String ticketNo;
	
	/**入库单号*/
	private String officeNo;
	
	/**PNR*/
	private String pnr;
	
	/**乘机人姓名*/
	private String customerName;

	public void setId(Long id) {
		flightTicketBSPDetailDto.setId(id);
	}

	public String getTicketBSPNo() {
		return flightTicketBSPDetailDto.getTicketBSPNo();
	}

	public void setTicketBSPNo(String ticketBSPNo) {
		flightTicketBSPDetailDto.setTicketBSPNo(ticketBSPNo);
	}

	public BSPStatus getBspStatus() {
		return flightTicketBSPDetailDto.getBspStatus();
	}

	public void setBspStatus(BSPStatus bspStatus) {
		flightTicketBSPDetailDto.setBspStatus(bspStatus);
	}

	public void setCreateTime(Date createTime) {
		flightTicketBSPDetailDto.setCreateTime(createTime);
	}

	public BSPRecycleStatus getBspRecycleStatus() {
		return flightTicketBSPDetailDto.getBspRecycleStatus();
	}

	public Date getUpdateTime() {
		return flightTicketBSPDetailDto.getUpdateTime();
	}

	public void setUpdateTime(Date updateTime) {
		flightTicketBSPDetailDto.setUpdateTime(updateTime);
	}

	public void setBspRecycleStatus(BSPRecycleStatus bspRecycleStatus) {
		flightTicketBSPDetailDto.setBspRecycleStatus(bspRecycleStatus);
	}

	public String getOperName() {
		return flightTicketBSPDetailDto.getOperName();
	}

	public void setOperName(String operName) {
		flightTicketBSPDetailDto.setOperName(operName);
	}

	public String getBspRemark() {
		return flightTicketBSPDetailDto.getBspRemark();
	}

	public void setBspRemark(String bspRemark) {
		flightTicketBSPDetailDto.setBspRemark(bspRemark);
	}

	public Long getOrderId() {
		return flightTicketBSPDetailDto.getOrderId();
	}

	public void setOrderId(Long orderId) {
		flightTicketBSPDetailDto.setOrderId(orderId);
	}

	public Long getTicketId() {
		return flightTicketBSPDetailDto.getTicketId();
	}

	public void setTicketId(Long ticketId) {
		flightTicketBSPDetailDto.setTicketId(ticketId);
	}

	public Long getBspStorageId() {
		return flightTicketBSPDetailDto.getBspStorageId();
	}

	public void setBspStorageId(Long bspStorageId) {
		flightTicketBSPDetailDto.setBspStorageId(bspStorageId);
	}

	public FlightTicketBSPDetailDto getFlightTicketBSPDetailDto() {
		return flightTicketBSPDetailDto;
	}

	public void setFlightTicketBSPDetailDto(FlightTicketBSPDetailDto flightTicketBSPDetailDto) {
		this.flightTicketBSPDetailDto = flightTicketBSPDetailDto;
	}

	public String getTicketNo() {
		return ticketNo;
	}

	public void setTicketNo(String ticketNo) {
		this.ticketNo = ticketNo;
	}

	public String getOfficeNo() {
		return officeNo;
	}

	public void setOfficeNo(String officeNo) {
		this.officeNo = officeNo;
	}

	public String getPnr() {
		return pnr;
	}

	public void setPnr(String pnr) {
		this.pnr = pnr;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Long getId() {
		return flightTicketBSPDetailDto.getId();
	}

	public Date getCreateTime() {
		return flightTicketBSPDetailDto.getCreateTime();
	}

	public void copyFromRequest(FlightTicketBSPDetailRequest request) {
		flightTicketBSPDetailDto.copyFromRequest(request);
	}

	
}
