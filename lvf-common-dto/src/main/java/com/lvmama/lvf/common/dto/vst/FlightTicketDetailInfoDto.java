package com.lvmama.lvf.common.dto.vst;

import java.io.Serializable;

import com.lvmama.lvf.common.dto.enums.CallbackType;

public class FlightTicketDetailInfoDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1617124918893510383L;
	
	/**
	 * 商品ID
	 */
	private Long goodsId;
	
	/**
	 * 乘客姓名
	 */
	private String passengerName;
	
	/**
	 * 票号
	 */
	private String ticketNo;
	
	/**
	 * VST出票回调类型（成功：CallbackType.SUCCESS,失败：CallbackType.FAIL,超时：CallbackType.TIMEOUT）
	 */
	private CallbackType callbackType;

	public Long getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}

	public String getPassengerName() {
		return passengerName;
	}

	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}

	public String getTicketNo() {
		return ticketNo;
	}

	public void setTicketNo(String ticketNo) {
		this.ticketNo = ticketNo;
	}

	public CallbackType getCallbackType() {
		return callbackType;
	}

	public void setCallbackType(CallbackType callbackType) {
		this.callbackType = callbackType;
	}

}
