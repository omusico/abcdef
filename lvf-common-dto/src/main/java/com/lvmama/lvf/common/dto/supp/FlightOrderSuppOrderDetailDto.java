package com.lvmama.lvf.common.dto.supp;

import java.io.Serializable;
import java.util.Date;

import com.lvmama.lvf.common.domain.FkId;
import com.lvmama.lvf.common.dto.Entity;
import com.lvmama.lvf.common.dto.enums.Status;
import com.lvmama.lvf.common.dto.order.FlightOrderDetailDto;
import com.lvmama.lvf.common.dto.order.FlightOrderFlightCombinationDetailDto;
import com.lvmama.lvf.common.dto.order.FlightOrderTicketPriceDto;
import com.lvmama.lvf.common.dto.status.detail.DetailBookingStatus;
import com.lvmama.lvf.common.dto.status.detail.DetailTicketStatus;
import com.lvmama.lvf.common.dto.status.order.OrderBookingStatus;
import com.lvmama.lvf.common.dto.status.order.OrderPayStatus;
import com.lvmama.lvf.common.dto.status.order.OrderTicketStatus;

/**
 * 供应商订单明细信息
 * 
 * @author majun
 * @date 2015-2-7
 */
public class FlightOrderSuppOrderDetailDto extends Entity implements Serializable {
    private static final long serialVersionUID = 766024924740029178L;

    /** 供应商订单主键 */
    private Long suppOrderId;

    /** 订单明细信息 */
    @FkId
    private FlightOrderDetailDto flightOrderDetail;

    /** 供应商订单PNR信息 */
    @FkId
    private FlightOrderSuppOrderPNRInfoDto flightOrderSuppOrderPNRInfo;
    
    /** 订位状态 */
    private DetailBookingStatus detailBookingStatus;

    /** 供应商订单乘机人信息 */
    @FkId
    private FlightOrderSuppOrderPassengerDto flightOrderSuppOrderPassenger;

    /** 供应商订单票号信息 */
    @FkId
    private FlightOrderSuppOrderTicketInfoDto flightOrderSuppOrderTicketInfo;

    /** 票价信息 */
    private FlightOrderTicketPriceDto flightOrderTicketPrice;
    
    /** 票号状态 */
    private DetailTicketStatus detailTicketStatus;

    /** 状态 */
    private Status status = Status.VALID;
    
    /** 订单航班组合明细信息 */
    @FkId
	private FlightOrderFlightCombinationDetailDto combinationDetail;

    public Long getSuppOrderId() {
        return suppOrderId;
    }

    public void setSuppOrderId(Long suppOrderId) {
        this.suppOrderId = suppOrderId;
    }

    public FlightOrderDetailDto getFlightOrderDetail() {
        return flightOrderDetail;
    }

    public void setFlightOrderDetail(FlightOrderDetailDto flightOrderDetail) {
        this.flightOrderDetail = flightOrderDetail;
    }

    public FlightOrderSuppOrderPNRInfoDto getFlightOrderSuppOrderPNRInfo() {
        return flightOrderSuppOrderPNRInfo;
    }

    public void setFlightOrderSuppOrderPNRInfo(
            FlightOrderSuppOrderPNRInfoDto flightOrderSuppOrderPNRInfo) {
        this.flightOrderSuppOrderPNRInfo = flightOrderSuppOrderPNRInfo;
    }

    public FlightOrderSuppOrderPassengerDto getFlightOrderSuppOrderPassenger() {
        return flightOrderSuppOrderPassenger;
    }

    public void setFlightOrderSuppOrderPassenger(
            FlightOrderSuppOrderPassengerDto flightOrderSuppOrderPassenger) {
        this.flightOrderSuppOrderPassenger = flightOrderSuppOrderPassenger;
    }

    public FlightOrderSuppOrderTicketInfoDto getFlightOrderSuppOrderTicketInfo() {
        return flightOrderSuppOrderTicketInfo;
    }

    public void setFlightOrderSuppOrderTicketInfo(
            FlightOrderSuppOrderTicketInfoDto flightOrderSuppOrderTicketInfo) {
        this.flightOrderSuppOrderTicketInfo = flightOrderSuppOrderTicketInfo;
    }

    public FlightOrderTicketPriceDto getFlightOrderTicketPrice() {
        return flightOrderTicketPrice;
    }

    public void setFlightOrderTicketPrice(FlightOrderTicketPriceDto flightOrderTicketPrice) {
        this.flightOrderTicketPrice = flightOrderTicketPrice;
    }

	public DetailBookingStatus getDetailBookingStatus() {
		return detailBookingStatus;
	}

	public void setDetailBookingStatus(DetailBookingStatus detailBookingStatus) {
		this.detailBookingStatus = detailBookingStatus;
	}

	public DetailTicketStatus getDetailTicketStatus() {
		return detailTicketStatus;
	}

	public void setDetailTicketStatus(DetailTicketStatus detailTicketStatus) {
		this.detailTicketStatus = detailTicketStatus;
	}

	public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    /**
     * 同步供应商订单明细信息(xslt)
     * 
     * @param newSuppTicketDto
     *            供应商订单票号信息
     * @param oldSuppOrderDto
     *            供应商订单信息
     * @param oldSuppTicketDto
     *            供应商订单票号信息
     * @return void
     */
    public void copyFromDto(FlightOrderSuppOrderTicketInfoDto newSuppTicketDto, FlightOrderSuppOrderDto oldSuppOrderDto,
            FlightOrderSuppOrderTicketInfoDto oldSuppTicketDto) {
        FlightOrderSuppOrderStatusDto suppOrderStatus = oldSuppOrderDto.getFlightOrderSuppOrderStatus();
        if (suppOrderStatus.getOrderBookingStatus().equals(OrderBookingStatus.BOOKING_FAIL)) {
        	this.setDetailBookingStatus(DetailBookingStatus.BOOKING_FAIL);
        }
        if (OrderPayStatus.PAY_SUCC.equals(suppOrderStatus.getOrderPayStatus())) {
        	this.setDetailBookingStatus(DetailBookingStatus.BOOKING_SUCC);
        }
        if (suppOrderStatus.getOrderTicketStatus().equals(OrderTicketStatus.ISSUE_SUCC)) {
        	this.setDetailTicketStatus(DetailTicketStatus.ISSUE_SUCC);
        }
        if (suppOrderStatus.getOrderTicketStatus().equals(OrderTicketStatus.ISSUE_FAIL)) {
            this.setDetailTicketStatus(DetailTicketStatus.ISSUE_FAIL);
        }
        this.setFlightOrderSuppOrderTicketInfo(oldSuppTicketDto);
        this.setFlightOrderTicketPrice(newSuppTicketDto.getFlightOrderTicketPrice());
        this.setUpdateTime(new Date());

    }

	public FlightOrderFlightCombinationDetailDto getCombinationDetail() {
		return combinationDetail;
	}

	public void setCombinationDetail(
			FlightOrderFlightCombinationDetailDto combinationDetail) {
		this.combinationDetail = combinationDetail;
	}

}
