package com.lvmama.lvf.common.dto.order;

import java.io.Serializable;

import com.lvmama.lvf.common.dto.Entity;
import com.lvmama.lvf.common.dto.enums.BindingStatus;
import com.lvmama.lvf.common.dto.enums.BindingType;
import com.lvmama.lvf.common.dto.enums.BookingSourceType;

/**
 * 机票订单与外部订单关系
 * @author xieshuai
 *
 */
public class FlightOrderSalesOrderRelationDto extends Entity implements Serializable {

	private static final long serialVersionUID = -2757864129823545227L;
	
	/**
	 * 外部机票子订单Id
	 */
	private Long salesOrderId;
	
	/**
	 * 外部主订单id
	 */
	private Long salesMainOrderId;
	
	/**
	 * 机票系统机票主订单id
	 */
	private Long lvfMainOrderId;
	
	/**
	 * 机票系统机票主订单编号
	 */
	private String lvfMainOrderNo;
	
	/**
	 * 是否绑定
	 */
	private BindingStatus bindingStatus;
	
	/**
	 * 机票子订单id
	 */
	private Long lvfOrderId;
	
	/**
	 * 机票子订单编号
	 */
	private String lvfOrderNo;

	/**
	 * 绑定类型
	 */
	private BindingType bindingType;
	
	/**
	 * 订单来源类型
	 */
	private BookingSourceType bookingSourceType;
	
	/**
	 * 外部机票子订单号集合
	 */
	private String lockSeatOrderId;

	public Long getSalesOrderId() {
		return salesOrderId;
	}

	public void setSalesOrderId(Long salesOrderId) {
		this.salesOrderId = salesOrderId;
	}

	public Long getSalesMainOrderId() {
		return salesMainOrderId;
	}

	public void setSalesMainOrderId(Long salesMainOrderId) {
		this.salesMainOrderId = salesMainOrderId;
	}

	public Long getLvfMainOrderId() {
		return lvfMainOrderId;
	}

	public void setLvfMainOrderId(Long lvfMainOrderId) {
		this.lvfMainOrderId = lvfMainOrderId;
	}

	public String getLvfMainOrderNo() {
		return lvfMainOrderNo;
	}

	public void setLvfMainOrderNo(String lvfMainOrderNo) {
		this.lvfMainOrderNo = lvfMainOrderNo;
	}

	public BindingStatus getBindingStatus() {
		return bindingStatus;
	}

	public void setBindingStatus(BindingStatus bindingStatus) {
		this.bindingStatus = bindingStatus;
	}

	public Long getLvfOrderId() {
		return lvfOrderId;
	}

	public void setLvfOrderId(Long lvfOrderId) {
		this.lvfOrderId = lvfOrderId;
	}

	public String getLvfOrderNo() {
		return lvfOrderNo;
	}

	public void setLvfOrderNo(String lvfOrderNo) {
		this.lvfOrderNo = lvfOrderNo;
	}

	public BindingType getBindingType() {
		return bindingType;
	}

	public void setBindingType(BindingType bindingType) {
		this.bindingType = bindingType;
	}

	public BookingSourceType getBookingSourceType() {
		return bookingSourceType;
	}

	public void setBookingSourceType(BookingSourceType bookingSourceType) {
		this.bookingSourceType = bookingSourceType;
	}

	public String getLockSeatOrderId() {
		return lockSeatOrderId;
	}

	public void setLockSeatOrderId(String lockSeatOrderId) {
		this.lockSeatOrderId = lockSeatOrderId;
	}

}
