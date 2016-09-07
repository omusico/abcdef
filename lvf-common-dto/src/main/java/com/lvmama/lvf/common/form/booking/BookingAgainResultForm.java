package com.lvmama.lvf.common.form.booking;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.lvmama.lvf.common.dto.PersistenceType;
import com.lvmama.lvf.common.dto.enums.BookingSource;
import com.lvmama.lvf.common.dto.order.FlightOrderAgreementDto;
import com.lvmama.lvf.common.dto.order.FlightOrderContacterDto;
import com.lvmama.lvf.common.dto.order.FlightOrderCustomerDto;
import com.lvmama.lvf.common.dto.order.FlightOrderDto;
import com.lvmama.lvf.common.dto.order.FlightOrderExpressDto;
import com.lvmama.lvf.common.dto.order.FlightOrderFlightCombinationDto;
import com.lvmama.lvf.common.dto.order.FlightOrderNoDto;
import com.lvmama.lvf.common.dto.order.FlightOrderPNRInfoDto;
import com.lvmama.lvf.common.dto.order.FlightOrderPassengerDto;
import com.lvmama.lvf.common.dto.order.FlightOrderRemarkDto;
import com.lvmama.lvf.common.dto.order.OrderMainDto;
import com.lvmama.lvf.common.dto.order.OrderOpLogDto;
import com.lvmama.lvf.common.dto.order.pay.FlightOrderPaymentDto;
import com.lvmama.lvf.common.dto.order.pay.FlightOrderRefundDto;
import com.lvmama.lvf.common.form.Form;

/**
 * 重新下单请求对象FORM
 * 
 * @author yuanweihong
 * @date 2015-7-27
 */
public class BookingAgainResultForm implements Serializable, Form {
    
    private static final long serialVersionUID = -537465253697221725L;
    
    /** 主订单信息 */
    private OrderMainDto orderMainDto;
    
    public BookingAgainResultForm() {
        super();
    }

    public BookingAgainResultForm(OrderMainDto orderMainDto) {
        super();
        this.orderMainDto = orderMainDto;
    }

    public OrderMainDto getOrderMainDto() {
        return orderMainDto;
    }

    public void setOrderMainDto(OrderMainDto orderMainDto) {
        this.orderMainDto = orderMainDto;
    }

    public PersistenceType getPtype() {
        return orderMainDto.getPtype();
    }

    public void setPtype(PersistenceType ptype) {
        orderMainDto.setPtype(ptype);
    }

    public String getSequence() {
        return orderMainDto.getSequence();
    }

    public Long getId() {
        return orderMainDto.getId();
    }

    public void setId(Long id) {
        orderMainDto.setId(id);
    }

    public String getUuid() {
        return orderMainDto.getUuid();
    }

    public void setUuid(String uuid) {
        orderMainDto.setUuid(uuid);
    }

    public Date getCreateTime() {
        return orderMainDto.getCreateTime();
    }

    public void setCreateTime(Date createTime) {
        orderMainDto.setCreateTime(createTime);
    }

    public Date getUpdateTime() {
        return orderMainDto.getUpdateTime();
    }

    public void setUpdateTime(Date updateTime) {
        orderMainDto.setUpdateTime(updateTime);
    }

    public FlightOrderNoDto getFlightOrderNo() {
        return orderMainDto.getFlightOrderNo();
    }

    public void setFlightOrderNo(FlightOrderNoDto flightOrderNo) {
        orderMainDto.setFlightOrderNo(flightOrderNo);
    }

    public FlightOrderCustomerDto getFlightOrderCustomer() {
        return orderMainDto.getFlightOrderCustomer();
    }

    public void setFlightOrderCustomer(FlightOrderCustomerDto flightOrderCustomer) {
        orderMainDto.setFlightOrderCustomer(flightOrderCustomer);
    }

    public FlightOrderContacterDto getFlightOrderContacter() {
        return orderMainDto.getFlightOrderContacter();
    }

    public void setFlightOrderContacter(FlightOrderContacterDto flightOrderContacter) {
        orderMainDto.setFlightOrderContacter(flightOrderContacter);
    }

    public BookingSource getBookingSource() {
        return orderMainDto.getBookingSource();
    }

    public void setBookingSource(BookingSource bookingSource) {
        orderMainDto.setBookingSource(bookingSource);
    }

    public FlightOrderAgreementDto getFlightOrderAgreement() {
        return orderMainDto.getFlightOrderAgreement();
    }

    public void setFlightOrderAgreement(FlightOrderAgreementDto flightOrderAgreement) {
        orderMainDto.setFlightOrderAgreement(flightOrderAgreement);
    }

    public FlightOrderExpressDto getFlightOrderExpress() {
        return orderMainDto.getFlightOrderExpress();
    }

    public void setFlightOrderExpress(FlightOrderExpressDto flightOrderExpress) {
        orderMainDto.setFlightOrderExpress(flightOrderExpress);
    }

    public List<FlightOrderPassengerDto> getFlightOrderPassengers() {
        return orderMainDto.getFlightOrderPassengers();
    }

    public void setFlightOrderPassengers(List<FlightOrderPassengerDto> flightOrderPassengers) {
        orderMainDto.setFlightOrderPassengers(flightOrderPassengers);
    }

    public FlightOrderFlightCombinationDto getFlightOrderFlightCombination() {
        return orderMainDto.getFlightOrderFlightCombination();
    }

    public void setFlightOrderFlightCombination(
            FlightOrderFlightCombinationDto flightOrderFlightCombination) {
        orderMainDto.setFlightOrderFlightCombination(flightOrderFlightCombination);
    }

    public List<FlightOrderPNRInfoDto> getFlightOrderPNRInfos() {
        return orderMainDto.getFlightOrderPNRInfos();
    }

    public void setFlightOrderPNRInfos(List<FlightOrderPNRInfoDto> flightOrderPNRInfos) {
        orderMainDto.setFlightOrderPNRInfos(flightOrderPNRInfos);
    }

    public List<OrderOpLogDto> getOrdeOpLogs() {
        return orderMainDto.getOrdeOpLogs();
    }

    public void setOrdeOpLogs(List<OrderOpLogDto> ordeOpLogs) {
        orderMainDto.setOrdeOpLogs(ordeOpLogs);
    }

    public List<FlightOrderDto> getFlightOrders() {
        return orderMainDto.getFlightOrders();
    }

    public void setFlightOrders(List<FlightOrderDto> flightOrders) {
        orderMainDto.setFlightOrders(flightOrders);
    }

    public List<FlightOrderRemarkDto> getFlightOrderRemarks() {
        return orderMainDto.getFlightOrderRemarks();
    }

    public void setFlightOrderRemarks(List<FlightOrderRemarkDto> flightOrderRemarks) {
        orderMainDto.setFlightOrderRemarks(flightOrderRemarks);
    }

    public List<FlightOrderPaymentDto> getFlightOrderPayment() {
        return orderMainDto.getFlightOrderPayment();
    }

    public void setFlightOrderPayment(List<FlightOrderPaymentDto> flightOrderPayment) {
        orderMainDto.setFlightOrderPayment(flightOrderPayment);
    }

    public List<FlightOrderRefundDto> getFlightOrderRefund() {
        return orderMainDto.getFlightOrderRefund();
    }

    public void setFlightOrderRefund(List<FlightOrderRefundDto> flightOrderRefund) {
        orderMainDto.setFlightOrderRefund(flightOrderRefund);
    }

    
}
