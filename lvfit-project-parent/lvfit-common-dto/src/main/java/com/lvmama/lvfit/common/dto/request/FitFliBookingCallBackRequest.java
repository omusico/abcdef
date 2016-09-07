package com.lvmama.lvfit.common.dto.request;

import java.io.Serializable;


/**
 * 机+X，vst侧回调机票下单接口
 * @author leizhengwei
 *
 */
public class FitFliBookingCallBackRequest implements Serializable{

	private static final long serialVersionUID = -4171984346676480271L;

	/**vst主单号 */
	private Long vstOrderMainNo;
	
	/**vst子单号 */
	private Long vstOrderNo;

	public Long getVstOrderMainNo() {
		return vstOrderMainNo;
	}

	public void setVstOrderMainNo(Long vstOrderMainNo) {
		this.vstOrderMainNo = vstOrderMainNo;
	}

	public Long getVstOrderNo() {
		return vstOrderNo;
	}

	public void setVstOrderNo(Long vstOrderNo) {
		this.vstOrderNo = vstOrderNo;
	}
}
