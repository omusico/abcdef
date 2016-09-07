package com.lvmama.lvf.common.form.order;

import com.lvmama.lvf.common.dto.order.FlightOrderRemarkDto;
import com.lvmama.lvf.common.dto.request.FlightOrderCancelRequest;
import com.lvmama.lvf.common.form.Form;

/**
 * 订单取消 RequestForm
 * 
 * @author zzs
 * 
 */
public class FlightOrderCancelForm implements Form {

    private FlightOrderCancelRequest flightOrderCancelRequest = new FlightOrderCancelRequest();

    public FlightOrderCancelRequest getFlightOrderCancelRequest() {
        return flightOrderCancelRequest;
    }

    public void setFlightOrderCancelRequest(FlightOrderCancelRequest flightOrderCancelRequest) {
        this.flightOrderCancelRequest = flightOrderCancelRequest;
    }

    public Long getOrderMainId() {
        return flightOrderCancelRequest.getOrderMainId();
    }

    public void setOrderMainId(Long orderMainId) {
        flightOrderCancelRequest.setOrderMainId(orderMainId);
    }

    public Long getOrderId() {
        return flightOrderCancelRequest.getOrderId();
    }

    public void setOrderId(Long orderId) {
        flightOrderCancelRequest.setOrderId(orderId);
    }

    public FlightOrderRemarkDto getFlightOrderRemarkDto() {
        return flightOrderCancelRequest.getFlightOrderRemarkDto();
    }

    public void setFlightOrderRemarkDto(FlightOrderRemarkDto flightOrderRemarkDto) {
        flightOrderCancelRequest.setFlightOrderRemarkDto(flightOrderRemarkDto);
    }

	public String getLimitTime() {
		return flightOrderCancelRequest.getLimitTime();
	}

	public void setLimitTime(String limitTime) {
		flightOrderCancelRequest.setLimitTime(limitTime);
	}
    
    

}
