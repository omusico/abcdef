package com.lvmama.lvf.common.dto.order;

import java.io.Serializable;

import com.lvmama.lvf.common.dto.Entity;

/**
 * 订单losc记录
 * @author zengzhimin
 * @date   2016-06-12
 */
public class FlightOrderLoscDto extends Entity implements Serializable{
    
    private static final long serialVersionUID = -5399616593411555L;

    /** 订单主键*/
	private Long orderId;
	
	/**losc记录**/
	private String loscId;
	
	/**订单号*/
	private String orderNo;

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getLoscId() {
		return loscId;
	}

	public void setLoscId(String loscId) {
		this.loscId = loscId;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
}
