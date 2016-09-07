package com.lvmama.lvf.common.dto.request;

import java.io.Serializable;

import com.lvmama.lvf.common.dto.enums.SmsType;

/***
 * 
 * 短信发送请求：用于load roder：组装发送内容
 * 
 */
public class SmsRequest implements Serializable {

	private static final long serialVersionUID = -8547737673698406125L;


	private Long orderId;

	private SmsType smsType;



	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public SmsType getSmsType() {
		return smsType;
	}

	public void setSmsType(SmsType smsType) {
		this.smsType = smsType;
	}

}
