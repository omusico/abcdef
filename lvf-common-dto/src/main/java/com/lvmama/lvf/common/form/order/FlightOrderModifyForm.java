/**
 * 
 */
package com.lvmama.lvf.common.form.order;

import java.io.Serializable;

import com.lvmama.lvf.common.dto.order.FlightOrderContacterDto;
import com.lvmama.lvf.common.dto.order.FlightOrderExpressDto;
import com.lvmama.lvf.common.dto.order.FlightOrderRemarkDto;
import com.lvmama.lvf.common.dto.request.FlightOrderModifyRequest;
import com.lvmama.lvf.common.form.Form;

/**
 * 
 * @author lven
 * @date 2015-2-5
 * 
 */
public class FlightOrderModifyForm implements Serializable, Form {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3707864759401955405L;

	private FlightOrderModifyRequest flightOrderModifyRequest = new FlightOrderModifyRequest();

	/**
	 * 
	 */
	public FlightOrderModifyForm() {
	}

	/**
	 * @return
	 * @see com.lvmama.lvf.common.dto.request.FlightOrderModifyRequest#getFlightOrderExpressDto()
	 */
	public FlightOrderExpressDto getFlightOrderExpressDto() {
		return flightOrderModifyRequest.getFlightOrderExpressDto();
	}

	/**
	 * @param flightOrderExpressDto
	 * @see com.lvmama.lvf.common.dto.request.FlightOrderModifyRequest#setFlightOrderExpressDto(com.lvmama.lvf.common.dto.order.FlightOrderExpressDto)
	 */
	public void setFlightOrderExpressDto(
			FlightOrderExpressDto flightOrderExpressDto) {
		flightOrderModifyRequest
				.setFlightOrderExpressDto(flightOrderExpressDto);
	}

	/**
	 * @return
	 * @see com.lvmama.lvf.common.dto.request.FlightOrderModifyRequest#getFlightOrderContacterDto()
	 */
	public FlightOrderContacterDto getFlightOrderContacterDto() {
		return flightOrderModifyRequest.getFlightOrderContacterDto();
	}

	/**
	 * @param flightOrderContacterDto
	 * @see com.lvmama.lvf.common.dto.request.FlightOrderModifyRequest#setFlightOrderContacterDto(com.lvmama.lvf.common.dto.order.FlightOrderContacterDto)
	 */
	public void setFlightOrderContacterDto(
			FlightOrderContacterDto flightOrderContacterDto) {
		flightOrderModifyRequest
				.setFlightOrderContacterDto(flightOrderContacterDto);
	}

	/**
	 * @return
	 * @see com.lvmama.lvf.common.dto.request.FlightOrderModifyRequest#getFlightOrderRemark()
	 */
	public FlightOrderRemarkDto getFlightOrderRemark() {
		return flightOrderModifyRequest.getFlightOrderRemark();
	}

	/**
	 * @return
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return flightOrderModifyRequest.hashCode();
	}

	/**
	 * @param flightOrderRemark
	 * @see com.lvmama.lvf.common.dto.request.FlightOrderModifyRequest#setFlightOrderRemark(com.lvmama.lvf.common.dto.order.FlightOrderRemarkDto)
	 */
	public void setFlightOrderRemark(FlightOrderRemarkDto flightOrderRemark) {
		flightOrderModifyRequest.setFlightOrderRemark(flightOrderRemark);
	}

	/**
	 * @return
	 * @see com.lvmama.lvf.common.dto.request.FlightOrderModifyRequest#getOrderNo()
	 */
	public String getOrderNo() {
		return flightOrderModifyRequest.getOrderNo();
	}

	/**
	 * @param orderNo
	 * @see com.lvmama.lvf.common.dto.request.FlightOrderModifyRequest#setOrderNo(java.lang.String)
	 */
	public void setOrderNo(String orderNo) {
		flightOrderModifyRequest.setOrderNo(orderNo);
	}

	/**
	 * @return
	 */
	public Long getOrderMainId() {
		return flightOrderModifyRequest.getOrderMainId();
	}

	/**
	 * @param orderId
	 */
	public void setOrderMainId(Long orderId) {
		flightOrderModifyRequest.setOrderMainId(orderId);
	}

	/**
	 * @param obj
	 * @return
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object obj) {
		return flightOrderModifyRequest.equals(obj);
	}

	/**
	 * @return
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return flightOrderModifyRequest.toString();
	}

	/**
	 * @return the flightOrderModifyRequest
	 */
	public FlightOrderModifyRequest getFlightOrderModifyRequest() {
		return flightOrderModifyRequest;
	}

}
