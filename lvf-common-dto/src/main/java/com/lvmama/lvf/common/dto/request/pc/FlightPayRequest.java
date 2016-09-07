package com.lvmama.lvf.common.dto.request.pc;

import java.io.Serializable;

import com.lvmama.lvf.common.dto.order.pay.FlightPaymentUrlDto;

/**
 * PC机票支付请求VST的 Request
 */
public class FlightPayRequest implements Serializable {

	private static final long serialVersionUID = -2052602152896571667L;
	/** 支付url	 */
	private FlightPaymentUrlDto paymentUrlDto;
	
	public FlightPaymentUrlDto getPaymentUrlDto() {
		return paymentUrlDto;
	}
	public void setPaymentUrlDto(FlightPaymentUrlDto paymentUrlDto) {
		this.paymentUrlDto = paymentUrlDto;
	}

}
