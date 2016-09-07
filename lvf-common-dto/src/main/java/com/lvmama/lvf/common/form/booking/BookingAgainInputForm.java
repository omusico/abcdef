package com.lvmama.lvf.common.form.booking;

import java.io.Serializable;
import java.util.List;

import com.lvmama.lvf.common.dto.order.FlightOrderDetailDto;
import com.lvmama.lvf.common.dto.request.FlightOrderBookingAgainRequest;
import com.lvmama.lvf.common.form.Form;

/**
 * 重新下单请求对象FORM
 * 
 * @author yuanweihong
 * @date 2015-7-27
 */
public class BookingAgainInputForm implements Serializable, Form {

    private static final long serialVersionUID = 1846216450794351411L;

    private FlightOrderBookingAgainRequest request = new FlightOrderBookingAgainRequest();

    public FlightOrderBookingAgainRequest getRequest() {
        return request;
    }

    public void setRequest(FlightOrderBookingAgainRequest request) {
        this.request = request;
    }

    public Long getAuditOpId() {
        return request.getAuditOpId();
    }

    public void setAuditOpId(Long auditOpId) {
        request.setAuditOpId(auditOpId);
    }

    public List<FlightOrderDetailDto> getFlightOrderDetails() {
        return request.getFlightOrderDetails();
    }

    public Long getOrderMainId() {
        return request.getOrderMainId();
    }

    public void setFlightOrderDetails(List<FlightOrderDetailDto> flightOrderDetails) {
        request.setFlightOrderDetails(flightOrderDetails);
    }

    public void setOrderMainId(Long orderMainId) {
        request.setOrderMainId(orderMainId);
    }

    public Long getOrderId() {
        return request.getOrderId();
    }

    public void setOrderId(Long orderId) {
        request.setOrderId(orderId);
    }

}
