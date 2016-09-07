package com.lvmama.lvf.common.dto.order;

import java.io.Serializable;

/**
 * 订单号信息
 * @author majun
 * @date   2015-1-13
 */
public class FlightOrderNoDto implements Serializable 
{
	private static final long serialVersionUID = 3192957906981914031L;

	/** 订单号 */
	private String orderNo;

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
}
