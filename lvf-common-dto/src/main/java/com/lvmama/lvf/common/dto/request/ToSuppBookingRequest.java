package com.lvmama.lvf.common.dto.request;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.lvmama.lvf.common.dto.enums.DirectType;
import com.lvmama.lvf.common.dto.enums.MealType;
import com.lvmama.lvf.common.dto.enums.PassengerType;
import com.lvmama.lvf.common.dto.flight.FlightAirportLineDto;
import com.lvmama.lvf.common.dto.md.Airplane;
import com.lvmama.lvf.common.dto.search.result.FlightSearchFlightInfoDto;
import com.lvmama.lvf.common.dto.search.result.FlightSearchSeatDto;

public class ToSuppBookingRequest implements Serializable {
    
    private static final long serialVersionUID = 5859790516178639460L;
    // 航班信息
    private FlightSearchFlightInfoDto flightSearchFlightInfoDto = new FlightSearchFlightInfoDto();
    // 出发城市码
    private String arrivalCityCode;
    // 到达城市码
    private String departureCityCode;
    
    public FlightSearchFlightInfoDto getFlightSearchFlightInfoDto() {
        return flightSearchFlightInfoDto;
    }

    public void setFlightSearchFlightInfoDto(FlightSearchFlightInfoDto flightSearchFlightInfoDto) {
        this.flightSearchFlightInfoDto = flightSearchFlightInfoDto;
    }

    public String getCarrierName() {
        return flightSearchFlightInfoDto.getCarrierName();
    }

    public void setCarrierName(String carrierName) {
        flightSearchFlightInfoDto.setCarrierName(carrierName);
    }

    public String getCarrierCode() {
        return flightSearchFlightInfoDto.getCarrierCode();
    }

    public void setCarrierCode(String carrierCode) {
        flightSearchFlightInfoDto.setCarrierCode(carrierCode);
    }

    public Long getFlightId() {
        return flightSearchFlightInfoDto.getFlightId();
    }

    public void setFlightId(Long flightId) {
        flightSearchFlightInfoDto.setFlightId(flightId);
    }

    public String getFlightNo() {
        return flightSearchFlightInfoDto.getFlightNo();
    }

    public void setFlightNo(String flightNo) {
        flightSearchFlightInfoDto.setFlightNo(flightNo);
    }

    public Airplane getAirplane() {
        return flightSearchFlightInfoDto.getAirplane();
    }

    public void setAirplane(Airplane airplane) {
        flightSearchFlightInfoDto.setAirplane(airplane);
    }

    public String getDepartureTime() {
        return flightSearchFlightInfoDto.getDepartureTime();
    }

    public void setDepartureTime(String departureTime) {
        flightSearchFlightInfoDto.setDepartureTime(departureTime);
    }

    public String getArrivalTime() {
        return flightSearchFlightInfoDto.getArrivalTime();
    }

    public void setArrivalTime(String arrivalTime) {
        flightSearchFlightInfoDto.setArrivalTime(arrivalTime);
    }

    public Integer getFlyTimeMins() {
        return flightSearchFlightInfoDto.getFlyTimeMins();
    }

    public void setFlyTimeMins(Integer flyTimeMins) {
        flightSearchFlightInfoDto.setFlyTimeMins(flyTimeMins);
    }

    public Integer getStopCount() {
        return flightSearchFlightInfoDto.getStopCount();
    }

    public void setStopCount(Integer stopCount) {
        flightSearchFlightInfoDto.setStopCount(stopCount);
    }

    public DirectType getDirectType() {
        return flightSearchFlightInfoDto.getDirectType();
    }

    public void setDirectType(DirectType directType) {
        flightSearchFlightInfoDto.setDirectType(directType);
    }

    public String getStopCity() {
        return flightSearchFlightInfoDto.getStopCity();
    }

    public void setStopCity(String stopCity) {
        flightSearchFlightInfoDto.setStopCity(stopCity);
    }

    public String getStopAirport() {
        return flightSearchFlightInfoDto.getStopAirport();
    }

    public void setStopAirport(String stopAirport) {
        flightSearchFlightInfoDto.setStopAirport(stopAirport);
    }

    public Integer getStopTimeMins() {
        return flightSearchFlightInfoDto.getStopTimeMins();
    }

    public void setStopTimeMins(Integer stopTimeMins) {
        flightSearchFlightInfoDto.setStopTimeMins(stopTimeMins);
    }

    public String getDepartureAirportName() {
        return flightSearchFlightInfoDto.getDepartureAirportName();
    }

    public void setDepartureAirportName(String departureAirportName) {
        flightSearchFlightInfoDto.setDepartureAirportName(departureAirportName);
    }

    public String getDepartureAirportCode() {
        return flightSearchFlightInfoDto.getDepartureAirportCode();
    }

    public void setDepartureAirportCode(String departureAirportCode) {
        flightSearchFlightInfoDto.setDepartureAirportCode(departureAirportCode);
    }

    public String getDepartureTermainalBuilding() {
        return flightSearchFlightInfoDto.getDepartureTermainalBuilding();
    }

    public void setDepartureTermainalBuilding(String departureTermainalBuilding) {
        flightSearchFlightInfoDto.setDepartureTermainalBuilding(departureTermainalBuilding);
    }

    public String getDepartureCityName() {
        return flightSearchFlightInfoDto.getDepartureCityName();
    }

    public void setDepartureCityName(String departureCityName) {
        flightSearchFlightInfoDto.setDepartureCityName(departureCityName);
    }

    public String getArrivalAirportName() {
        return flightSearchFlightInfoDto.getArrivalAirportName();
    }

    public void setArrivalAirportName(String arrivalAirportName) {
        flightSearchFlightInfoDto.setArrivalAirportName(arrivalAirportName);
    }

    public String getArrivalAirportCode() {
        return flightSearchFlightInfoDto.getArrivalAirportCode();
    }

    public void setArrivalAirportCode(String arrivalAirportCode) {
        flightSearchFlightInfoDto.setArrivalAirportCode(arrivalAirportCode);
    }

    public String getArrivalTerminalBuilding() {
        return flightSearchFlightInfoDto.getArrivalTerminalBuilding();
    }

    public void setArrivalTerminalBuilding(String arrivalTerminalBuilding) {
        flightSearchFlightInfoDto.setArrivalTerminalBuilding(arrivalTerminalBuilding);
    }

    public String getArrivalCityName() {
        return flightSearchFlightInfoDto.getArrivalCityName();
    }

    public void setArrivalCityName(String arrivalCityName) {
        flightSearchFlightInfoDto.setArrivalCityName(arrivalCityName);
    }

    public MealType getMealType() {
        return flightSearchFlightInfoDto.getMealType();
    }

    public void setMealType(MealType mealType) {
        flightSearchFlightInfoDto.setMealType(mealType);
    }

    public String getDepartureDate() {
        return flightSearchFlightInfoDto.getDepartureDate();
    }

    public void setDepartureDate(String departureDate) {
        flightSearchFlightInfoDto.setDepartureDate(departureDate);
    }

    public BigDecimal getyParPrice() {
        return flightSearchFlightInfoDto.getyParPrice();
    }

    public void setyParPrice(BigDecimal yParPrice) {
        flightSearchFlightInfoDto.setyParPrice(yParPrice);
    }

    public Map<PassengerType, BigDecimal> getFuelsurTaxs() {
        return flightSearchFlightInfoDto.getFuelsurTaxs();
    }

    public void setFuelsurTaxs(Map<PassengerType, BigDecimal> fuelsurTaxs) {
        flightSearchFlightInfoDto.setFuelsurTaxs(fuelsurTaxs);
    }

    public Map<PassengerType, BigDecimal> getAirportFees() {
        return flightSearchFlightInfoDto.getAirportFees();
    }

    public void setAirportFees(Map<PassengerType, BigDecimal> airportFees) {
        flightSearchFlightInfoDto.setAirportFees(airportFees);
    }

    public List<FlightSearchSeatDto> getSeats() {
        return flightSearchFlightInfoDto.getSeats();
    }

    public void setSeats(List<FlightSearchSeatDto> seats) {
        flightSearchFlightInfoDto.setSeats(seats);
    }

    public Map<String, FlightSearchSeatDto> getLowSeats() {
        return flightSearchFlightInfoDto.getLowSeats();
    }

    public void setLowSeats(Map<String, FlightSearchSeatDto> lowSeats) {
        flightSearchFlightInfoDto.setLowSeats(lowSeats);
    }

    public String getFlyTime() {
        return flightSearchFlightInfoDto.getFlyTime();
    }

    public void setFlyTime(String flyTime) {
        flightSearchFlightInfoDto.setFlyTime(flyTime);
    }

    public FlightAirportLineDto getFlightAirportLineDto() {
        return flightSearchFlightInfoDto.getFlightAirportLineDto();
    }

    public void setFlightAirportLineDto(FlightAirportLineDto flightAirportLineDto) {
        flightSearchFlightInfoDto.setFlightAirportLineDto(flightAirportLineDto);
    }

    public Map<String, FlightSearchSeatDto> getChildrenSeats() {
        return flightSearchFlightInfoDto.getChildrenSeats();
    }

    public void setChildrenSeats(Map<String, FlightSearchSeatDto> childrenSeats) {
        flightSearchFlightInfoDto.setChildrenSeats(childrenSeats);
    }

    public String getArrivalCityCode() {
        return arrivalCityCode;
    }

    public void setArrivalCityCode(String arrivalCityCode) {
        this.arrivalCityCode = arrivalCityCode;
    }

    public String getDepartureCityCode() {
        return departureCityCode;
    }

    public void setDepartureCityCode(String departureCityCode) {
        this.departureCityCode = departureCityCode;
    }
    
}
