package com.lvmama.lvf.common.dto.request;

import java.io.Serializable;

import com.lvmama.lvf.common.dto.OperType;
import com.lvmama.lvf.common.dto.enums.SmsType;

/***
 * 
 * 短信发送内容请求
 * 
 */
public class SmsSendRequest implements Serializable {
	
	private static final long serialVersionUID = -3235961669153809302L;
	
	/**订单id，用于记录日志*/
	private Long orderId;


	//发送类型
	private SmsType smsType;
	
	//发送内容
	private String smsContent;
	
	//发送手机号
	private String mobile;
	
	
	//操作类型
	private OperType operType;
	
	

	public OperType getOperType() {
		return operType;
	}

	public void setOperType(OperType operType) {
		this.operType = operType;
	}

	public SmsType getSmsType() {
		return smsType;
	}

	public void setSmsType(SmsType smsType) {
		this.smsType = smsType;
	}


	public String getSmsContent() {
		return smsContent;
	}

	public void setSmsContent(String smsContent) {
		this.smsContent = smsContent;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	
	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	
	
	
}
