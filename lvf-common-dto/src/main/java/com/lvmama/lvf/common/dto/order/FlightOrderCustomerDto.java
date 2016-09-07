package com.lvmama.lvf.common.dto.order;

import java.io.Serializable;

/**
 * 订单客户信息
 * @author majun
 * @date   2015-1-19
 */
public class FlightOrderCustomerDto implements Serializable 
{	
	private static final long serialVersionUID = -8213284010030963856L;
	
	/** 客户ID */
	private String customerId;
	
	/** 客户编码 */
	private String customerCode;
	
	/** 客户姓名 */
	private String customerName;
	
	/** 客户级别 */
	private String customerLevel;
	
	/** 客户手机号码 */
	private String customerCellphone;

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCustomerCode() {
		return customerCode;
	}

	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerLevel() {
		return customerLevel;
	}

	public void setCustomerLevel(String customerLevel) {
		this.customerLevel = customerLevel;
	}

	public String getCustomerCellphone() {
		return customerCellphone;
	}

	public void setCustomerCellphone(String customerCellphone) {
		this.customerCellphone = customerCellphone;
	}
	
	
}
