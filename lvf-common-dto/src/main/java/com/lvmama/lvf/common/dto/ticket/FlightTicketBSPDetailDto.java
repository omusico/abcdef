package com.lvmama.lvf.common.dto.ticket;

import com.lvmama.lvf.common.dto.Entity;
import com.lvmama.lvf.common.dto.enums.BSPRecycleStatus;
import com.lvmama.lvf.common.dto.enums.BSPStatus;
import com.lvmama.lvf.common.dto.request.FlightTicketBSPDetailRequest;

/**
 * 行程单明细DTO
 */
public class FlightTicketBSPDetailDto extends Entity {
	
	private static final long serialVersionUID = 6865987884921257096L;
	/** 行程单号 */
	private String ticketBSPNo;
	/** 使用状态 */
	private BSPStatus bspStatus;
	/** 回收状态 */
	private BSPRecycleStatus bspRecycleStatus;
	/** 操作者 */
	public String operName;
	/** 操作者 */
	public String bspRemark;

	/** 订单主键 */
	private Long orderId;
	
	/** 订单对应票的主键 */
	private Long ticketId;
	
	/** 行程单入库主键 */
	private Long bspStorageId;
	

	public String getTicketBSPNo() {
		return ticketBSPNo;
	}

	public void setTicketBSPNo(String ticketBSPNo) {
		this.ticketBSPNo = ticketBSPNo;
	}

	public BSPStatus getBspStatus() {
		return bspStatus;
	}

	public void setBspStatus(BSPStatus bspStatus) {
		this.bspStatus = bspStatus;
	}

	public BSPRecycleStatus getBspRecycleStatus() {
		return bspRecycleStatus;
	}

	public void setBspRecycleStatus(BSPRecycleStatus bspRecycleStatus) {
		this.bspRecycleStatus = bspRecycleStatus;
	}

	public String getOperName() {
		return operName;
	}

	public void setOperName(String operName) {
		this.operName = operName;
	}

	public String getBspRemark() {
		return bspRemark;
	}

	public void setBspRemark(String bspRemark) {
		this.bspRemark = bspRemark;
	}
	
	public void copyFromRequest(FlightTicketBSPDetailRequest request) {
		if(request.getTicketId()!=null && !("".equals(request.getOrderId()))){
			this.setTicketId(Long.parseLong(request.getTicketId()));
		}

		if(null!=request.getOrderId() && !("".equals(request.getOrderId()))){
			this.setOrderId(Long.parseLong(request.getOrderId()));
		}
		this.setBspRemark(request.getBspRemark());
		this.setOperName(request.getOperName());
		this.setBspRecycleStatus(request.getBspRecycleStatus());
		this.setBspStatus(request.getBspStatus());
		this.setId(request.getId());
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getTicketId() {
		return ticketId;
	}

	public void setTicketId(Long ticketId) {
		this.ticketId = ticketId;
	}

	public Long getBspStorageId() {
		return bspStorageId;
	}

	public void setBspStorageId(Long bspStorageId) {
		this.bspStorageId = bspStorageId;
	}
	
	
}
