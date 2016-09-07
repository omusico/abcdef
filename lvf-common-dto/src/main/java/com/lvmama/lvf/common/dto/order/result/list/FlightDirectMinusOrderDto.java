
package com.lvmama.lvf.common.dto.order.result.list;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.lvmama.lvf.common.dto.enums.PassengerType;
import com.lvmama.lvf.common.dto.order.status.FlightOrderStatusDto;
/***
 * TASK #31510 后台订单自动直减
 */
public class FlightDirectMinusOrderDto  implements Serializable{
	private static final long serialVersionUID = 4527223916960574686L;
	/** 主订单主键 */
	private Long orderMainId;
	/**订单主键 */
    private Long orderId;
	/**订单号 */
    private String orderNo;
    /**乘客类型 */
    private PassengerType passengerType;
    /** 订单状态集合 */
    private FlightOrderStatusDto flightOrderStatus;
    /**直减金额*/
    private BigDecimal orderDirectReductionAmount;
    /** 下单时间 */
    private Date orderCreateTime;
    /** 起飞时间 */
    private Date depTime;
    
	public Long getOrderMainId() {
		return orderMainId;
	}

	public void setOrderMainId(Long orderMainId) {
		this.orderMainId = orderMainId;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}


	public Date getOrderCreateTime() {
		return orderCreateTime;
	}

	public void setOrderCreateTime(Date orderCreateTime) {
		this.orderCreateTime = orderCreateTime;
	}

	public FlightOrderStatusDto getFlightOrderStatus() {
		return flightOrderStatus;
	}

	public void setFlightOrderStatus(FlightOrderStatusDto flightOrderStatus) {
		this.flightOrderStatus = flightOrderStatus;
	}

	public BigDecimal getOrderDirectReductionAmount() {
		return orderDirectReductionAmount;
	}

	public void setOrderDirectReductionAmount(BigDecimal orderDirectReductionAmount) {
		this.orderDirectReductionAmount = orderDirectReductionAmount;
	}

	public PassengerType getPassengerType() {
		return passengerType;
	}

	public void setPassengerType(PassengerType passengerType) {
		this.passengerType = passengerType;
	}

	public Date getDepTime() {
		return depTime;
	}

	public void setDepTime(Date depTime) {
		this.depTime = depTime;
	}
}
