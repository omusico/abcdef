package com.lvmama.lvf.common.dto.adapter.request.supp;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import com.lvmama.lvf.common.dto.adapter.request.supp.base.SuppRequest;
import com.lvmama.lvf.common.dto.supp.FlightOrderSuppOrderDto;

/**
 * 供应商创建订单请求对象
 * @author majun
 * @date   2015-1-13
 * 注：该对象为实际和供应商的请求对象进行转换对象
 */
@XmlRootElement
public class FlightSuppBookingRequest extends SuppRequest implements Serializable 
{
	private static final long serialVersionUID = 800319762060806163L;
	
	/** 调用供应商创建订单接口的业务对象 */
	private FlightOrderSuppOrderDto flightOrderSuppOrder;
	
	/** 被通知的url地址 */
	private String notifiedUrl;
	
	/** 付完成后返回的url地址 */
	private String paymentReturnUrl;
	
	/** 允许帮选政策 */
	private String allowSwitchPolicy;
	
	/** 是否包括特殊政策 */
	private String needSpeRulePolicy;

	public FlightOrderSuppOrderDto getFlightOrderSuppOrder() {
		return flightOrderSuppOrder;
	}

	public void setFlightOrderSuppOrder(FlightOrderSuppOrderDto flightOrderSuppOrder) {
		this.flightOrderSuppOrder = flightOrderSuppOrder;
	}

	public String getNotifiedUrl() {
		return notifiedUrl;
	}

	public void setNotifiedUrl(String notifiedUrl) {
		this.notifiedUrl = notifiedUrl;
	}

	public String getPaymentReturnUrl() {
		return paymentReturnUrl;
	}

	public void setPaymentReturnUrl(String paymentReturnUrl) {
		this.paymentReturnUrl = paymentReturnUrl;
	}

	public String getAllowSwitchPolicy() {
		return allowSwitchPolicy;
	}

	public void setAllowSwitchPolicy(String allowSwitchPolicy) {
		this.allowSwitchPolicy = allowSwitchPolicy;
	}

	public String getNeedSpeRulePolicy() {
		return needSpeRulePolicy;
	}

	public void setNeedSpeRulePolicy(String needSpeRulePolicy) {
		this.needSpeRulePolicy = needSpeRulePolicy;
	}
	
}
