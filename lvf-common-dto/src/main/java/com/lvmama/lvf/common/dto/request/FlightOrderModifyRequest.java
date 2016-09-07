package com.lvmama.lvf.common.dto.request;

import java.io.Serializable;

import com.lvmama.lvf.common.dto.order.FlightOrderContacterDto;
import com.lvmama.lvf.common.dto.order.FlightOrderExpressDto;
import com.lvmama.lvf.common.dto.order.FlightOrderRemarkDto;

/**
 * 订单修改请求对象
 * 
 * @author lven
 * @date 2015-2-3
 * 
 */
public class FlightOrderModifyRequest implements Serializable {

	private static final long serialVersionUID = -3654777119738790708L;

	/** 订单id */
	private Long orderMainId;
	/** 订单号 */
	private String orderNo;
	/** 订单快递信息 */
	private FlightOrderExpressDto flightOrderExpressDto;
	/** 订单联系人信息 */
	private FlightOrderContacterDto flightOrderContacterDto;
	/** 订单备注信息 */
	private FlightOrderRemarkDto flightOrderRemark;

	/**
	 * @return the flightOrderExpressDto
	 */
	public FlightOrderExpressDto getFlightOrderExpressDto() {
		return flightOrderExpressDto;
	}
	/**
	 * @param flightOrderExpressDto the flightOrderExpressDto to set
	 */
	public void setFlightOrderExpressDto(FlightOrderExpressDto flightOrderExpressDto) {
		this.flightOrderExpressDto = flightOrderExpressDto;
	}
	/**
	 * @return the flightOrderContacterDto
	 */
	public FlightOrderContacterDto getFlightOrderContacterDto() {
		return flightOrderContacterDto;
	}
	/**
	 * @param flightOrderContacterDto the flightOrderContacterDto to set
	 */
	public void setFlightOrderContacterDto(
			FlightOrderContacterDto flightOrderContacterDto) {
		this.flightOrderContacterDto = flightOrderContacterDto;
	}
	/**
	 * @return the flightOrderRemark
	 */
	public FlightOrderRemarkDto getFlightOrderRemark() {
		return flightOrderRemark;
	}
	/**
	 * @param flightOrderRemark the flightOrderRemark to set
	 */
	public void setFlightOrderRemark(FlightOrderRemarkDto flightOrderRemark) {
		this.flightOrderRemark = flightOrderRemark;
	}
	/**
	 * @return the orderNo
	 */
	public String getOrderNo() {
		return orderNo;
	}
	/**
	 * @param orderNo the orderNo to set
	 */
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	/**
	 * @return the orderId
	 */
	public Long getOrderMainId() {
		return orderMainId;
	}
	/**
	 * @param orderId the orderId to set
	 */
	public void setOrderMainId(Long orderMainId) {
		this.orderMainId = orderMainId;
	}
	
}
