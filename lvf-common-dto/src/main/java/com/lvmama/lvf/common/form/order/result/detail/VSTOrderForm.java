/**
 * 
 */
package com.lvmama.lvf.common.form.order.result.detail;

import java.io.Serializable;

import com.lvmama.lvf.common.dto.enums.BindingStatus;
import com.lvmama.lvf.common.dto.order.FlightOrderVstDto;
import com.lvmama.lvf.common.dto.request.VSTOrderRequest;
import com.lvmama.lvf.common.form.Form;

/**
 * @author lven
 *
 */
public class VSTOrderForm implements Serializable, Form {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4437805554034359904L;

	VSTOrderRequest vstOrderRequest = new VSTOrderRequest();

	public Long getVstFlightOrderId() {
		return vstOrderRequest.getVstFlightOrderId();
	}

	public void setVstFlightOrderId(Long vstFlightOrderId) {
		vstOrderRequest.setVstFlightOrderId(vstFlightOrderId);
	}

	public Long getId() {
		return vstOrderRequest.getId();
	}

	public void setId(Long id) {
		vstOrderRequest.setId(id);
	}

	public Long getVstMainOrderId() {
		return vstOrderRequest.getVstMainOrderId();
	}

	public void setVstMainOrderId(Long vstMainOrderId) {
		vstOrderRequest.setVstMainOrderId(vstMainOrderId);
	}

	public Long getLvfMainOrderId() {
		return vstOrderRequest.getLvfMainOrderId();
	}

	public void setLvfMainOrderId(Long lvfMainOrderId) {
		vstOrderRequest.setLvfMainOrderId(lvfMainOrderId);
	}

	public String getLvfMainOrderNo() {
		return vstOrderRequest.getLvfMainOrderNo();
	}

	public void setLvfMainOrderNo(String lvfMainOrderNo) {
		vstOrderRequest.setLvfMainOrderNo(lvfMainOrderNo);
	}

	public FlightOrderVstDto getFlightOrderVstDto() {
		return vstOrderRequest.getFlightOrderVstDto();
	}

	public void setFlightOrderVstDto(FlightOrderVstDto flightOrderVstDto) {
		vstOrderRequest.setFlightOrderVstDto(flightOrderVstDto);
	}

	public BindingStatus getBindingStatus() {
		return vstOrderRequest.getBindingStatus();
	}

	public void setBindingStatus(BindingStatus bindingStatus) {
		vstOrderRequest.setBindingStatus(bindingStatus);
	}

	public VSTOrderRequest getVstOrderRequest() {
		return vstOrderRequest;
	}

	public void setVstOrderRequest(VSTOrderRequest vstOrderRequest) {
		this.vstOrderRequest = vstOrderRequest;
	}
}
