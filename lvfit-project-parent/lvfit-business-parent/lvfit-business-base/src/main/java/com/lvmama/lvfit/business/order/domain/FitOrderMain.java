package com.lvmama.lvfit.business.order.domain;

import com.lvmama.lvf.common.domain.Domain;
import com.lvmama.lvfit.common.dto.order.FitOrderMainDto;
import com.lvmama.lvfit.common.dto.request.FitOrderBookingRequest;

public class FitOrderMain implements Domain<FitOrderMainDto> {

    private FitOrderMainDto self = new FitOrderMainDto();

    public FitOrderMain() {
    }

    @Override
    public FitOrderMainDto self() {
        return this.self;
    }

    public FitOrderMain(FitOrderMainDto self) {
        super();
        this.self = self;
    }

    public FitOrderMainDto buildOrderMainDto(FitOrderBookingRequest bookingRequest) {
        this.self .setOrderAmount(bookingRequest.getFitOrderAmountDto());
        this.self .setFitOrderCustomer(bookingRequest.getFitOrderCustomerDto());
        this.self .setFitOrderContacter(bookingRequest.getFitOrderContacterDto());
        this.self .setFitOrderPassengers(bookingRequest.getFitOrderPassengerDtos());
        this.self .setFitOrderRemarks(bookingRequest.getFitOrderRemarkDtos());
        this.self .setBookingSource(bookingRequest.getBookingSource());
        this.self .setFitOrderFlightDtos(bookingRequest.getFitOrderFlightDtos());
        this.self .setFitOrderHotelDtos(bookingRequest.getFitOrderHotelDtos());
        this.self .setFitOrderSpotTicketDtos(bookingRequest.getFitOrderSpotTicketDtos());
        this.self .setProductName(bookingRequest.getProductName());
        this.self.setFitOrderBasicInfoDto(bookingRequest.getFitOrderBasicInfoDto());
        this.self.setFitOrderInsuranceDtos(bookingRequest.getFitOrderInsuranceDtos());
        this.self.setFitOrderHotelComboDto(bookingRequest.getFitOrderHotelComboDto());
        this.self.setFitOrderLocalTripProductDto(bookingRequest.getFitOrderLocalTripProductDto());
        this.self.setFitOrderOtherTicketDtos(bookingRequest.getFitOrderOtherTicketDtos());
        this.self.setProductId(bookingRequest.getProductId());
        this.self.setCategoryId(bookingRequest.getCategoryId());
        this.self.setLineRouteId(bookingRequest.getLineRouteId());
        this.self.setFlightFeeAmount(bookingRequest.getFlightFeeAmount());
        this.self.setFitOrderRoomDiffDto(bookingRequest.getFitOrderRoomDiffDto());
        this.self.setDistributionChannel(bookingRequest.getDistributionChannel());
        this.self.setDistributorCode(bookingRequest.getDistributorCode());
        return this.self;
    }

}
