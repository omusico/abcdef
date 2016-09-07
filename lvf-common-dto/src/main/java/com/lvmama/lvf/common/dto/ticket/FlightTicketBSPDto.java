package com.lvmama.lvf.common.dto.ticket;

import java.io.Serializable;

import com.lvmama.lvf.common.dto.Dto;
import com.lvmama.lvf.common.dto.md.DateRange;
import com.lvmama.lvf.common.dto.order.FlightOrderCustomerDto;
import com.lvmama.lvf.common.dto.order.FlightOrderDto;
import com.lvmama.lvf.common.dto.order.FlightOrderOperDto;
import com.lvmama.lvf.common.dto.order.FlightOrderPNRInfoDto;
import com.lvmama.lvf.common.dto.order.FlightOrderPassengerDto;
import com.lvmama.lvf.common.dto.order.FlightOrderTicketInfoDto;
import com.lvmama.lvf.common.dto.request.FlightOrderTicketPrintRequest;

public class FlightTicketBSPDto implements Serializable, Dto {

    private static final long serialVersionUID = 1245999727243261072L;

    /**
     * 行程单号
     */
    private String ticketBSPNo;

    /**
     * 订单信息
     */
    private FlightOrderDto flightOrderDto;

    /**
     * 订单对应客户信息
     */
    private FlightOrderCustomerDto flightOrderCustomer;

    /**
     * 订单对应机票信息
     */
    private FlightOrderTicketInfoDto flightOrderTicketInfo;

    /**
     * 出票时间范围
     */
    private DateRange issueDateRange;

    /**
     * 乘机时间范围
     */
    private DateRange departureDateRange;

//    /**
//     * 打印状态
//     */
//    private FlightOrderOpStatusDto flightOrderOpStatus;

    /**
     * 操作员
     */
    private FlightOrderOperDto flightOrderOperDto;

    public String getTicketBSPNo() {
        return ticketBSPNo;
    }

    public void setTicketBSPNo(String ticketBSPNo) {
        this.ticketBSPNo = ticketBSPNo;
    }

    public FlightOrderDto getFlightOrderDto() {
        return flightOrderDto;
    }

    public void setFlightOrderDto(FlightOrderDto flightOrderDto) {
        this.flightOrderDto = flightOrderDto;
    }

    public FlightOrderCustomerDto getFlightOrderCustomer() {
        return flightOrderCustomer;
    }

    public void setFlightOrderCustomer(FlightOrderCustomerDto flightOrderCustomer) {
        this.flightOrderCustomer = flightOrderCustomer;
    }

    public FlightOrderTicketInfoDto getFlightOrderTicketInfo() {
        return flightOrderTicketInfo;
    }

    public void setFlightOrderTicketInfo(FlightOrderTicketInfoDto flightOrderTicketInfo) {
        this.flightOrderTicketInfo = flightOrderTicketInfo;
    }

    public DateRange getIssueDateRange() {
        return issueDateRange;
    }

    public void setIssueDateRange(DateRange issueDateRange) {
        this.issueDateRange = issueDateRange;
    }

    public DateRange getDepartureDateRange() {
        return departureDateRange;
    }

    public void setDepartureDateRange(DateRange departureDateRange) {
        this.departureDateRange = departureDateRange;
    }

//    public FlightOrderOpStatusDto getFlightOrderOpStatus() {
//        return flightOrderOpStatus;
//    }
//
//    public void setFlightOrderOpStatus(FlightOrderOpStatusDto flightOrderOpStatus) {
//        this.flightOrderOpStatus = flightOrderOpStatus;
//    }

    public FlightOrderOperDto getFlightOrderOperDto() {
        return flightOrderOperDto;
    }

    public void setFlightOrderOperDto(FlightOrderOperDto flightOrderOperDto) {
        this.flightOrderOperDto = flightOrderOperDto;
    }

    public void copyFromRequest(FlightOrderTicketPrintRequest request) {
        this.setDepartureDateRange(request.getDepartureDateRange());
        this.setIssueDateRange(request.getIssueDateRange());

        FlightOrderPassengerDto flightOrderPassenger = new FlightOrderPassengerDto();
        flightOrderPassenger.setPassengerName(request.getPassengerName());
        FlightOrderPNRInfoDto flightOrderPNRInfo = new FlightOrderPNRInfoDto();
        flightOrderPNRInfo.setPnr(request.getPnr());

        FlightOrderTicketInfoDto orderTicketInfoDto = new FlightOrderTicketInfoDto();
        orderTicketInfoDto.setTicketNo(request.getTicketNo());
        orderTicketInfoDto.setFlightOrderPassenger(flightOrderPassenger);
        orderTicketInfoDto.setFlightOrderPNRInfo(flightOrderPNRInfo);
        this.setFlightOrderTicketInfo(orderTicketInfoDto);
    }

	@Override
	public Long getId() {
		return flightOrderTicketInfo.getId();
	}
}
