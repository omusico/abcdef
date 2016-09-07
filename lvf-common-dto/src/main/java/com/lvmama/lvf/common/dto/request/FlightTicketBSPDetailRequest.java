package com.lvmama.lvf.common.dto.request;

import java.io.Serializable;

import com.lvmama.lvf.common.dto.Dto;
import com.lvmama.lvf.common.dto.enums.BSPRecycleStatus;
import com.lvmama.lvf.common.dto.enums.BSPStatus;

/**
 * 行程单明细Request
 * 
 */
public class FlightTicketBSPDetailRequest implements Dto, Serializable {
	private static final long serialVersionUID = 2475351683116112846L;
	/** 请求修改入库id */
	private Long id;
	/** 号段开始 */
	private String bspStartNo;
	/** 号段结束 */
	private String bspEndNo;
	/** 更改的行程单状态 */
	private BSPStatus bspStatus;
	/** 回收行程单状态 */
	private BSPRecycleStatus bspRecycleStatus;
	/** 操作者 */
	public String operName;
	/** 开始日期 */
	private String startDetailDate;
	/** 结束日期 */
	private String endDetailDate;
	/** 票号 */
	private String ticketNo;
	/** 操作备注 */
	public String bspRemark;
	/** 票面id */
	private String ticketId;
	
	/** 子订单id */
	private String orderId;
	/** 订单号 */
	private String orderNo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBspStartNo() {
		return bspStartNo;
	}

	public void setBspStartNo(String bspStartNo) {
		this.bspStartNo = bspStartNo;
	}

	public String getBspEndNo() {
		return bspEndNo;
	}

	public void setBspEndNo(String bspEndNo) {
		this.bspEndNo = bspEndNo;
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

	public String getStartDetailDate() {
		return startDetailDate;
	}

	public void setStartDetailDate(String startDetailDate) {
		this.startDetailDate = startDetailDate;
	}

	public String getEndDetailDate() {
		return endDetailDate;
	}

	public void setEndDetailDate(String endDetailDate) {
		this.endDetailDate = endDetailDate;
	}

	public String getTicketNo() {
		return ticketNo;
	}

	public void setTicketNo(String ticketNo) {
		this.ticketNo = ticketNo;
	}

	public String getBspRemark() {
		return bspRemark;
	}

	public void setBspRemark(String bspRemark) {
		this.bspRemark = bspRemark;
	}

	public String getTicketId() {
		return ticketId;
	}

	public void setTicketId(String ticketId) {
		this.ticketId = ticketId;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

}
