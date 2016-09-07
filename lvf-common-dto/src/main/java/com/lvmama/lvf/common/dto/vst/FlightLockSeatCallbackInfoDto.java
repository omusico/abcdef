package com.lvmama.lvf.common.dto.vst;

import java.io.Serializable;

import com.lvmama.lvf.common.dto.enums.VstBookingResultStatus;

public class FlightLockSeatCallbackInfoDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 614155654053280149L;
	
	/**
	 * 主订单ID
	 */
	private Long orderId;
	
	/**
	 * 子订单ID
	 */
	private Long orderItemId;
	
	/**
	 * 机票锁仓结果
	 */
	private VstBookingResultStatus resultStatus;
	
	/**
	 * 锁舱结果备注
	 */
	private String remark;

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(Long orderItemId) {
		this.orderItemId = orderItemId;
	}

	public VstBookingResultStatus getResultStatus() {
		return resultStatus;
	}

	public void setResultStatus(VstBookingResultStatus resultStatus) {
		this.resultStatus = resultStatus;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
