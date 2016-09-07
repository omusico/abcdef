package com.lvmama.lvfit.common.dto.order;

import java.io.Serializable;

public class FitOrderQueryDto  implements Serializable{

	private static final long serialVersionUID = -4842341566960811989L;
	/** 订单操作类型  */
	private String operType;
	/** 订单编号ID */
	private Long orderMainId;
	/** 订单编号 */
	private String orderMainNo;
	/** 订单编号 */
	private String VSTMainNo;
	/** 子订单编号 */
    private String orderNo;
	
	/** 下单人ID */
	private String customerName;
	
	/** 下单开始时间 */
	private String mainStartTime;
	
	/** 下单结束时间 */
	private String mainEndTime;
	
	/** 订单预订来源 */
	private String bookingSources;

	public final String getOperType() {
		return operType;
	}

	public final void setOperType(String operType) {
		this.operType = operType;
	}

	public final Long getOrderMainId() {
		return orderMainId;
	}

	public final void setOrderMainId(Long orderMainId) {
		this.orderMainId = orderMainId;
	}

	public final String getVSTMainNo() {
		return VSTMainNo;
	}

	public final void setVSTMainNo(String vSTMainNo) {
		VSTMainNo = vSTMainNo;
	}

	public final String getOrderMainNo() {
		return orderMainNo;
	}

	public final void setOrderMainNo(String orderMainNo) {
		this.orderMainNo = orderMainNo;
	}

	public final String getOrderNo() {
		return orderNo;
	}

	public final void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public final String getCustomerName() {
		return customerName;
	}

	public final void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public final String getMainStartTime() {
		return mainStartTime;
	}

	public final void setMainStartTime(String mainStartTime) {
		this.mainStartTime = mainStartTime;
	}

	public final String getMainEndTime() {
		return mainEndTime;
	}

	public final void setMainEndTime(String mainEndTime) {
		this.mainEndTime = mainEndTime;
	}

	public final String getBookingSources() {
		return bookingSources;
	}

	public final void setBookingSources(String bookingSources) {
		this.bookingSources = bookingSources;
	}

	
}
