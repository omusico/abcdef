package com.lvmama.lvfit.sdp.booking.domain;

import com.lvmama.lvf.common.domain.Domain;
import com.lvmama.lvfit.common.dto.enums.FlightTripType;
import com.lvmama.lvfit.common.dto.enums.ProductResource;
import com.lvmama.lvfit.common.dto.order.FitOrderFlightDto;
import com.lvmama.lvfit.common.dto.search.flight.result.FlightSearchFlightInfoDto;
import com.lvmama.lvfit.common.dto.search.flight.result.FlightSearchSeatDto;

public class FitOrderFlight implements Domain<FitOrderFlightDto> {

    private FitOrderFlightDto self = new FitOrderFlightDto();

    public FitOrderFlight() {
    }

    @Override
    public FitOrderFlightDto self() {
        return this.self;
    }

    public FitOrderFlight(FitOrderFlightDto self) {
        super();
        this.self = self;
    }

    public FitOrderFlightDto buildFitOrderFlightDto(FlightSearchFlightInfoDto searchFlight,FlightSearchSeatDto searchSeat) {
    	
           this.self.setFlightNo(searchFlight.getFlightNo());
           this.self.setDepartureAirportCode(searchFlight.getDepartureAirportCode());
           this.self.setDepartureAirportName(searchFlight.getDepartureAirportName());
           this.self.setDepartureCityCode(searchFlight.getDepartureCityCode());
           this.self.setDepartureCityName(searchFlight.getDepartureCityName());
           this.self.setDepartureTermainalBuilding(searchFlight.getDepartureTermainalBuilding());
           this.self.setDepartureDate(searchFlight.getDepartureDate());
           this.self.setDepartureTime(searchFlight.getDepartureTime());
           this.self.setArrivalAirportCode(searchFlight.getArrivalAirportCode());
           this.self.setArrivalAirportName(searchFlight.getArrivalAirportName());
           this.self.setArrivalCityCode(searchFlight.getArrivalCityCode());
           this.self.setArrivalCityName(searchFlight.getArrivalCityName());
           this.self.setArrivalTerminalBuilding(searchFlight.getArrivalTerminalBuilding());
           this.self.setArrivalTime(searchFlight.getArrivalTime());
           this.self.setFlyTimeMins(searchFlight.getFlyTimeMins() + "");
           this.self.setSeatClassCode(searchSeat.getSeatClassCode());
           this.self.setSeatClassType(searchSeat.getSeatClassType());
           this.self.setSeatClassTypeName(searchSeat.getSeatClassTypeName());
           this.self.setSuppCode(searchSeat.getSuppCode());
           this.self.setSuppPolicyNo(searchSeat.getSuppPolicyId() + "");
           this.self.setPricePolicyId(searchSeat.getPricePolicyId());
           this.self.setSalesPrice(searchSeat.getSalesPrice());
           this.self.setParPrice(searchSeat.getParPrice());
           this.self.setAirportFee(searchSeat.getAirportFee());
           this.self.setFuelsurTax(searchSeat.getFuelsurTax());
           this.self.setProductResource(ProductResource.FLIGHT);
           this.self.setTripType(FlightTripType.getFlightTripTypeByName(searchFlight.getBackOrTo()));
           this.self.setStopCount(searchFlight.getStopCount());
           this.self.setCarrierName(searchFlight.getCarrierName());
           this.self.setAirplane(searchFlight.getAirplane());
           return this.self;
    }


}
