package com.lvmama.lvf.common.form.booking;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.lvmama.lvf.common.dto.enums.DirectType;
import com.lvmama.lvf.common.dto.enums.MealType;
import com.lvmama.lvf.common.dto.enums.PassengerType;
import com.lvmama.lvf.common.dto.flight.FlightAirportLineDto;
import com.lvmama.lvf.common.dto.md.Airplane;
import com.lvmama.lvf.common.dto.request.ToSuppBookingRequest;
import com.lvmama.lvf.common.dto.search.result.FlightSearchFlightInfoDto;
import com.lvmama.lvf.common.dto.search.result.FlightSearchSeatDto;
import com.lvmama.lvf.common.form.Form;


/**
 * 供应商下单预定填写页请求FORM
 * 
 * @author leizhengwei 2015年12月17日
 */
public class ToSuppBookingInputForm implements Form {
    ToSuppBookingRequest request = new ToSuppBookingRequest();

    public ToSuppBookingRequest getRequest() {
        return request;
    }

    public void setRequest(ToSuppBookingRequest request) {
        this.request = request;
    }

    public FlightSearchFlightInfoDto getFlightSearchFlightInfoDto() {
        return request.getFlightSearchFlightInfoDto();
    }

    public void setFlightSearchFlightInfoDto(FlightSearchFlightInfoDto flightSearchFlightInfoDto) {
        request.setFlightSearchFlightInfoDto(flightSearchFlightInfoDto);
    }

    public String getCarrierName() {
        return request.getCarrierName();
    }

    public void setCarrierName(String carrierName) {
        request.setCarrierName(carrierName);
    }

    public String getCarrierCode() {
        return request.getCarrierCode();
    }

    public void setCarrierCode(String carrierCode) {
        request.setCarrierCode(carrierCode);
    }

    public Long getFlightId() {
        return request.getFlightId();
    }

    public void setFlightId(Long flightId) {
        request.setFlightId(flightId);
    }

    public String getFlightNo() {
        return request.getFlightNo();
    }

    public void setFlightNo(String flightNo) {
        request.setFlightNo(flightNo);
    }

    public Airplane getAirplane() {
        return request.getAirplane();
    }

    public void setAirplane(Airplane airplane) {
        request.setAirplane(airplane);
    }

    public String getDepartureTime() {
        return request.getDepartureTime();
    }

    public void setDepartureTime(String departureTime) {
        request.setDepartureTime(departureTime);
    }

    public String getArrivalTime() {
        return request.getArrivalTime();
    }

    public void setArrivalTime(String arrivalTime) {
        request.setArrivalTime(arrivalTime);
    }

    public Integer getFlyTimeMins() {
        return request.getFlyTimeMins();
    }

    public void setFlyTimeMins(Integer flyTimeMins) {
        request.setFlyTimeMins(flyTimeMins);
    }

    public Integer getStopCount() {
        return request.getStopCount();
    }

    public void setStopCount(Integer stopCount) {
        request.setStopCount(stopCount);
    }

    public DirectType getDirectType() {
        return request.getDirectType();
    }

    public void setDirectType(DirectType directType) {
        request.setDirectType(directType);
    }

    public String getStopCity() {
        return request.getStopCity();
    }

    public void setStopCity(String stopCity) {
        request.setStopCity(stopCity);
    }

    public String getStopAirport() {
        return request.getStopAirport();
    }

    public void setStopAirport(String stopAirport) {
        request.setStopAirport(stopAirport);
    }

    public Integer getStopTimeMins() {
        return request.getStopTimeMins();
    }

    public void setStopTimeMins(Integer stopTimeMins) {
        request.setStopTimeMins(stopTimeMins);
    }

    public String getDepartureAirportName() {
        return request.getDepartureAirportName();
    }

    public void setDepartureAirportName(String departureAirportName) {
        request.setDepartureAirportName(departureAirportName);
    }

    public String getDepartureAirportCode() {
        return request.getDepartureAirportCode();
    }

    public void setDepartureAirportCode(String departureAirportCode) {
        request.setDepartureAirportCode(departureAirportCode);
    }

    public String getDepartureTermainalBuilding() {
        return request.getDepartureTermainalBuilding();
    }

    public void setDepartureTermainalBuilding(String departureTermainalBuilding) {
        request.setDepartureTermainalBuilding(departureTermainalBuilding);
    }

    public String getDepartureCityName() {
        return request.getDepartureCityName();
    }

    public void setDepartureCityName(String departureCityName) {
        request.setDepartureCityName(departureCityName);
    }

    public String getArrivalAirportName() {
        return request.getArrivalAirportName();
    }

    public void setArrivalAirportName(String arrivalAirportName) {
        request.setArrivalAirportName(arrivalAirportName);
    }

    public String getArrivalAirportCode() {
        return request.getArrivalAirportCode();
    }

    public void setArrivalAirportCode(String arrivalAirportCode) {
        request.setArrivalAirportCode(arrivalAirportCode);
    }

    public String getArrivalTerminalBuilding() {
        return request.getArrivalTerminalBuilding();
    }

    public void setArrivalTerminalBuilding(String arrivalTerminalBuilding) {
        request.setArrivalTerminalBuilding(arrivalTerminalBuilding);
    }

    public String getArrivalCityName() {
        return request.getArrivalCityName();
    }

    public void setArrivalCityName(String arrivalCityName) {
        request.setArrivalCityName(arrivalCityName);
    }

    public MealType getMealType() {
        return request.getMealType();
    }

    public void setMealType(MealType mealType) {
        request.setMealType(mealType);
    }

    public String getDepartureDate() {
        return request.getDepartureDate();
    }

    public void setDepartureDate(String departureDate) {
        request.setDepartureDate(departureDate);
    }

    public BigDecimal getyParPrice() {
        return request.getyParPrice();
    }

    public void setyParPrice(BigDecimal yParPrice) {
        request.setyParPrice(yParPrice);
    }

    public Map<PassengerType, BigDecimal> getFuelsurTaxs() {
        return request.getFuelsurTaxs();
    }

    public void setFuelsurTaxs(Map<PassengerType, BigDecimal> fuelsurTaxs) {
        request.setFuelsurTaxs(fuelsurTaxs);
    }

    public Map<PassengerType, BigDecimal> getAirportFees() {
        return request.getAirportFees();
    }

    public void setAirportFees(Map<PassengerType, BigDecimal> airportFees) {
        request.setAirportFees(airportFees);
    }

    public List<FlightSearchSeatDto> getSeats() {
        return request.getSeats();
    }

    public void setSeats(List<FlightSearchSeatDto> seats) {
        request.setSeats(seats);
    }

    public Map<String, FlightSearchSeatDto> getLowSeats() {
        return request.getLowSeats();
    }

    public void setLowSeats(Map<String, FlightSearchSeatDto> lowSeats) {
        request.setLowSeats(lowSeats);
    }

    public String getFlyTime() {
        return request.getFlyTime();
    }

    public void setFlyTime(String flyTime) {
        request.setFlyTime(flyTime);
    }

    public FlightAirportLineDto getFlightAirportLineDto() {
        return request.getFlightAirportLineDto();
    }

    public void setFlightAirportLineDto(FlightAirportLineDto flightAirportLineDto) {
        request.setFlightAirportLineDto(flightAirportLineDto);
    }

    public Map<String, FlightSearchSeatDto> getChildrenSeats() {
        return request.getChildrenSeats();
    }

    public void setChildrenSeats(Map<String, FlightSearchSeatDto> childrenSeats) {
        request.setChildrenSeats(childrenSeats);
    }

}
