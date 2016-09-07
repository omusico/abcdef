/**
 * 
 */
package com.lvmama.lvf.common.form.order.result.detail;

import java.io.Serializable;

import com.lvmama.lvf.common.dto.enums.BindingStatus;
import com.lvmama.lvf.common.dto.request.FlightOrderSalesOrderRelationRequest;
import com.lvmama.lvf.common.form.Form;

/**
 * @date 2015-06-16
 *
 */
public class FlightOrderSalesOrderRelationForm implements Serializable, Form {


	/**
	 * 
	 */
	private static final long serialVersionUID = -2559620242248512444L;
	
	FlightOrderSalesOrderRelationRequest orderRelationRequest = new FlightOrderSalesOrderRelationRequest();

	public Long getSalesOrderId() {
		return orderRelationRequest.getSalesOrderId();
	}

	public void setSalesOrderId(Long salesOrderId) {
		orderRelationRequest.setSalesOrderId(salesOrderId);
	}

	public Long getId() {
		return orderRelationRequest.getId();
	}

	public void setId(Long id) {
		orderRelationRequest.setId(id);
	}

	public Long getSalesMainOrderId() {
		return orderRelationRequest.getSalesMainOrderId();
	}

	public void setSalesMainOrderId(Long salesMainOrderId) {
		orderRelationRequest.setSalesMainOrderId(salesMainOrderId);
	}

	public Long getLvfMainOrderId() {
		return orderRelationRequest.getLvfMainOrderId();
	}

	public void setLvfMainOrderId(Long lvfMainOrderId) {
		orderRelationRequest.setLvfMainOrderId(lvfMainOrderId);
	}

	public String getLvfMainOrderNo() {
		return orderRelationRequest.getLvfMainOrderNo();
	}

	public void setLvfMainOrderNo(String lvfMainOrderNo) {
		orderRelationRequest.setLvfMainOrderNo(lvfMainOrderNo);
	}

	public FlightOrderSalesOrderRelationRequest getOrderRelationRequest() {
		return orderRelationRequest;
	}

	public void setOrderRelationRequest(
			FlightOrderSalesOrderRelationRequest orderRelationRequest) {
		this.orderRelationRequest = orderRelationRequest;
	}

	public BindingStatus getBindingStatus() {
		return orderRelationRequest.getBindingStatus();
	}	

	public void setBindingStatus(BindingStatus bindingStatus) {
		orderRelationRequest.setBindingStatus(bindingStatus);
	}

	
}
