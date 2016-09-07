package com.lvmama.lvf.common.dto.order;

import java.io.Serializable;

import com.lvmama.lvf.common.dto.Entity;
import com.lvmama.lvf.common.dto.enums.BindingStatus;

public class FlightOrderVstDto extends Entity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4082313676711786225L;
	
	/**
	 * vst机票子订单Id
	 */
	private Long vstFlightOrderId;
	
	/**
	 * vst主订单id
	 */
	private Long vstMainOrderId;
	
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

	public Long getVstFlightOrderId() {
		return vstFlightOrderId;
	}

	public void setVstFlightOrderId(Long vstFlightOrderId) {
		this.vstFlightOrderId = vstFlightOrderId;
	}

	public Long getVstMainOrderId() {
		return vstMainOrderId;
	}

	public void setVstMainOrderId(Long vstMainOrderId) {
		this.vstMainOrderId = vstMainOrderId;
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


}
