package com.lvmama.lvfit.common.dto.adapter.request;

import java.io.Serializable;

import com.lvmama.lvfit.common.dto.order.FitPaymentUrlDto;

/**
 * 请求 机票单品预订成功审核 Request
 */
public class FlightBookingSuccessRequest implements Serializable {

	private static final long serialVersionUID = -2052602152896571667L;
	/** 订单成功之后审核 相关参数	 */
	private FitPaymentUrlDto fitPaymentUrlDto;

	public final FitPaymentUrlDto getFitPaymentUrlDto() {
		return fitPaymentUrlDto;
	}

	public final void setFitPaymentUrlDto(FitPaymentUrlDto fitPaymentUrlDto) {
		this.fitPaymentUrlDto = fitPaymentUrlDto;
	}

}
