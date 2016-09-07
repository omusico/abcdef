package com.lvmama.lvf.common.form.order;

import com.lvmama.lvf.common.dto.calculator.ExpressInfoRequest;
import com.lvmama.lvf.common.form.Form;

public class FlightOrderCalculateIForm implements Form{

	private ExpressInfoRequest request;

	public ExpressInfoRequest getRequest() {
		return request;
	}

	public void setRequest(ExpressInfoRequest request) {
		this.request = request;
	}

	public String getOrderId() {
		return request.getOrderMainId();
	}

	public void setOrderId(String orderId) {
		request.setOrderMainId(orderId);
	}

	public String getExpressCode() {
		return request.getExpressCode();
	}

	public void setExpressCode(String expressCode) {
		request.setExpressCode(expressCode);
	}
    
	
	
	
}
