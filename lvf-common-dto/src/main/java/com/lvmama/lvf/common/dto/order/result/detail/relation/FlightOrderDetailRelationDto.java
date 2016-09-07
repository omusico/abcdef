package com.lvmama.lvf.common.dto.order.result.detail.relation;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.lvmama.lvf.common.dto.enums.OrderType;
import com.lvmama.lvf.common.dto.order.FlightOrderAmountDto;
import com.lvmama.lvf.common.dto.order.status.FlightOrderStatusDto;

/**
 * 订单详情关联
 * @author majun
 * @date   2015-3-17
 */
public class FlightOrderDetailRelationDto implements Serializable
{
	private static final long serialVersionUID = 2797542715457011213L;
	
	/** 订单号 */
	private String orderNo;
	
	/** 订单主键 */
	private Long orderId;
	
	/** 订单ROOT主键 */
	private Long orderRootId;
	
	/** 前一个订单主键 */
    private Long orderPreId;
	
	/** 订单排序编码 */
	private String orderSortCode;
	
	/** 订单类型 */
	private OrderType orderType;
	
	/** 订单关联明细信息 */
	private List<FlightOrderDetailRelationDetailDto> flightOrderRelationDetails;
	
	/** 订单金额信息*/
	private FlightOrderAmountDto flightOrderAmount;
	
	/** 订单状态信息  */
	private FlightOrderStatusDto flightOrderStatusDto;
	
	/** 更新时间 */
	private Date updateTime;
	
	/** 支付等待时间 */
	private Date limitTime;

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getOrderRootId() {
		return orderRootId;
	}

	public void setOrderRootId(Long orderRootId) {
		this.orderRootId = orderRootId;
	}

	public String getOrderSortCode() {
		return orderSortCode;
	}

	public void setOrderSortCode(String orderSortCode) {
		this.orderSortCode = orderSortCode;
	}

	public OrderType getOrderType() {
		return orderType;
	}

	public void setOrderType(OrderType orderType) {
		this.orderType = orderType;
	}

	public List<FlightOrderDetailRelationDetailDto> getFlightOrderRelationDetails() {
		return flightOrderRelationDetails;
	}

	public void setFlightOrderRelationDetails(
			List<FlightOrderDetailRelationDetailDto> flightOrderRelationDetails) {
		this.flightOrderRelationDetails = flightOrderRelationDetails;
	}

	public FlightOrderAmountDto getFlightOrderAmount() {
		return flightOrderAmount;
	}

	public void setFlightOrderAmount(FlightOrderAmountDto flightOrderAmount) {
		this.flightOrderAmount = flightOrderAmount;
	}

	public FlightOrderStatusDto getFlightOrderStatusDto() {
		return flightOrderStatusDto;
	}

	public void setFlightOrderStatusDto(FlightOrderStatusDto flightOrderStatusDto) {
		this.flightOrderStatusDto = flightOrderStatusDto;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Long getOrderPreId() {
		return orderPreId;
	}

	public void setOrderPreId(Long orderPreId) {
		this.orderPreId = orderPreId;
	}

	public Date getLimitTime() {
		return limitTime;
	}

	public void setLimitTime(Date limitTime) {
		this.limitTime = limitTime;
	}
}
