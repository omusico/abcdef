package com.lvmama.lvf.common.form.order;

import com.lvmama.lvf.common.dto.enums.RemarkType;
import com.lvmama.lvf.common.dto.order.FlightOrderNoDto;
import com.lvmama.lvf.common.dto.order.FlightOrderRemarkDto;
import com.lvmama.lvf.common.form.Form;

/**
 * 取消ResponseForm
 * @author zzs
 *
 */
public class FlightOrderCancelResponseForm implements Form {
	
	private FlightOrderRemarkDto flightOrderRemarkDto;
	
	public Long getOrderMainId() {
		return flightOrderRemarkDto.getOrderMainId();
	}

	public void setOrderMainId(Long orderMainId) {
		flightOrderRemarkDto.setOrderMainId(orderMainId);
	}

	public Long getOrderId() {
		return flightOrderRemarkDto.getOrderId();
	}

	public void setOrderId(Long orderId) {
		flightOrderRemarkDto.setOrderId(orderId);
	}

	public FlightOrderNoDto getFlightOrderNo() {
		return flightOrderRemarkDto.getFlightOrderNo();
	}

	public void setFlightOrderNo(FlightOrderNoDto flightOrderNo) {
		flightOrderRemarkDto.setFlightOrderNo(flightOrderNo);
	}

	public RemarkType getRemarkType() {
		return flightOrderRemarkDto.getRemarkType();
	}

	public void setRemarkType(RemarkType remarkType) {
		flightOrderRemarkDto.setRemarkType(remarkType);
	}

	public String getRemark() {
		return flightOrderRemarkDto.getRemark();
	}

	public void setRemark(String remark) {
		flightOrderRemarkDto.setRemark(remark);
	}

}
