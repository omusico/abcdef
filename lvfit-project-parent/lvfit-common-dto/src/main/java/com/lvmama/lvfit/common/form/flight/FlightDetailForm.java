package com.lvmama.lvfit.common.form.flight;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.lvmama.lvfit.common.dto.enums.DirectType;
import com.lvmama.lvfit.common.dto.enums.MealType;
import com.lvmama.lvfit.common.dto.enums.PassengerType;
import com.lvmama.lvfit.common.dto.md.Airplane;
import com.lvmama.lvfit.common.dto.search.flight.result.FlightAirportLineDto;
import com.lvmama.lvfit.common.dto.search.flight.result.FlightSearchFlightInfoDto;
import com.lvmama.lvfit.common.dto.search.flight.result.FlightSearchSeatDto;

public class FlightDetailForm implements Serializable {
	private FlightSearchFlightInfoDto FlightSearchFlightInfoDto = new FlightSearchFlightInfoDto();

	@Override
	public int hashCode() {
		return FlightSearchFlightInfoDto.hashCode();
	}

	public boolean getHighLightFlag() {
		return FlightSearchFlightInfoDto.getHighLightFlag();
	}

	public void setHighLightFlag(boolean highLightFlag) {
		FlightSearchFlightInfoDto.setHighLightFlag(highLightFlag);
	}

	public String getCarrierName() {
		return FlightSearchFlightInfoDto.getCarrierName();
	}

	public void setCarrierName(String carrierName) {
		FlightSearchFlightInfoDto.setCarrierName(carrierName);
	}

	public String getCarrierCode() {
		return FlightSearchFlightInfoDto.getCarrierCode();
	}

	public void setCarrierCode(String carrierCode) {
		FlightSearchFlightInfoDto.setCarrierCode(carrierCode);
	}

	public Long getFlightId() {
		return FlightSearchFlightInfoDto.getFlightId();
	}

	public void setFlightId(Long flightId) {
		FlightSearchFlightInfoDto.setFlightId(flightId);
	}

	public String getFlightNo() {
		return FlightSearchFlightInfoDto.getFlightNo();
	}

	public void setFlightNo(String flightNo) {
		FlightSearchFlightInfoDto.setFlightNo(flightNo);
	}

	public Airplane getAirplane() {
		return FlightSearchFlightInfoDto.getAirplane();
	}

	public void setAirplane(Airplane airplane) {
		FlightSearchFlightInfoDto.setAirplane(airplane);
	}

	public String getDepartureTime() {
		return FlightSearchFlightInfoDto.getDepartureTime();
	}

	public void setDepartureTime(String departureTime) {
		FlightSearchFlightInfoDto.setDepartureTime(departureTime);
	}

	public String getArrivalTime() {
		return FlightSearchFlightInfoDto.getArrivalTime();
	}

	public void setArrivalTime(String arrivalTime) {
		FlightSearchFlightInfoDto.setArrivalTime(arrivalTime);
	}

	@Override
	public boolean equals(Object obj) {
		return FlightSearchFlightInfoDto.equals(obj);
	}

	public Integer getFlyTimeMins() {
		return FlightSearchFlightInfoDto.getFlyTimeMins();
	}

	public void setFlyTimeMins(Integer flyTimeMins) {
		FlightSearchFlightInfoDto.setFlyTimeMins(flyTimeMins);
	}

	public Integer getStopCount() {
		return FlightSearchFlightInfoDto.getStopCount();
	}

	public void setStopCount(Integer stopCount) {
		FlightSearchFlightInfoDto.setStopCount(stopCount);
	}

	public DirectType getDirectType() {
		return FlightSearchFlightInfoDto.getDirectType();
	}

	public void setDirectType(DirectType directType) {
		FlightSearchFlightInfoDto.setDirectType(directType);
	}

	public String getStopCity() {
		return FlightSearchFlightInfoDto.getStopCity();
	}

	public void setStopCity(String stopCity) {
		FlightSearchFlightInfoDto.setStopCity(stopCity);
	}

	public String getStopAirport() {
		return FlightSearchFlightInfoDto.getStopAirport();
	}

	public void setStopAirport(String stopAirport) {
		FlightSearchFlightInfoDto.setStopAirport(stopAirport);
	}

	public Integer getStopTimeMins() {
		return FlightSearchFlightInfoDto.getStopTimeMins();
	}

	public void setStopTimeMins(Integer stopTimeMins) {
		FlightSearchFlightInfoDto.setStopTimeMins(stopTimeMins);
	}

	public String getDepartureAirportName() {
		return FlightSearchFlightInfoDto.getDepartureAirportName();
	}

	public void setDepartureAirportName(String departureAirportName) {
		FlightSearchFlightInfoDto.setDepartureAirportName(departureAirportName);
	}

	public String getDepartureAirportCode() {
		return FlightSearchFlightInfoDto.getDepartureAirportCode();
	}

	public void setDepartureAirportCode(String departureAirportCode) {
		FlightSearchFlightInfoDto.setDepartureAirportCode(departureAirportCode);
	}

	public String getDepartureTermainalBuilding() {
		return FlightSearchFlightInfoDto.getDepartureTermainalBuilding();
	}

	public void setDepartureTermainalBuilding(String departureTermainalBuilding) {
		FlightSearchFlightInfoDto
				.setDepartureTermainalBuilding(departureTermainalBuilding);
	}

	public String getDepartureCityName() {
		return FlightSearchFlightInfoDto.getDepartureCityName();
	}

	public void setDepartureCityName(String departureCityName) {
		FlightSearchFlightInfoDto.setDepartureCityName(departureCityName);
	}

	public String getArrivalAirportName() {
		return FlightSearchFlightInfoDto.getArrivalAirportName();
	}

	public void setArrivalAirportName(String arrivalAirportName) {
		FlightSearchFlightInfoDto.setArrivalAirportName(arrivalAirportName);
	}

	public String getArrivalAirportCode() {
		return FlightSearchFlightInfoDto.getArrivalAirportCode();
	}

	public void setArrivalAirportCode(String arrivalAirportCode) {
		FlightSearchFlightInfoDto.setArrivalAirportCode(arrivalAirportCode);
	}

	public String getArrivalTerminalBuilding() {
		return FlightSearchFlightInfoDto.getArrivalTerminalBuilding();
	}

	public void setArrivalTerminalBuilding(String arrivalTerminalBuilding) {
		FlightSearchFlightInfoDto
				.setArrivalTerminalBuilding(arrivalTerminalBuilding);
	}

	public String getArrivalCityName() {
		return FlightSearchFlightInfoDto.getArrivalCityName();
	}

	public void setArrivalCityName(String arrivalCityName) {
		FlightSearchFlightInfoDto.setArrivalCityName(arrivalCityName);
	}

	public MealType getMealType() {
		return FlightSearchFlightInfoDto.getMealType();
	}

	public void setMealType(MealType mealType) {
		FlightSearchFlightInfoDto.setMealType(mealType);
	}

	public String getDepartureDate() {
		return FlightSearchFlightInfoDto.getDepartureDate();
	}

	public void setDepartureDate(String departureDate) {
		FlightSearchFlightInfoDto.setDepartureDate(departureDate);
	}

	public BigDecimal getyParPrice() {
		return FlightSearchFlightInfoDto.getyParPrice();
	}

	public void setyParPrice(BigDecimal yParPrice) {
		FlightSearchFlightInfoDto.setyParPrice(yParPrice);
	}

	public Map<PassengerType, BigDecimal> getFuelsurTaxs() {
		return FlightSearchFlightInfoDto.getFuelsurTaxs();
	}

	public void setFuelsurTaxs(Map<PassengerType, BigDecimal> fuelsurTaxs) {
		FlightSearchFlightInfoDto.setFuelsurTaxs(fuelsurTaxs);
	}

	public Map<PassengerType, BigDecimal> getAirportFees() {
		return FlightSearchFlightInfoDto.getAirportFees();
	}

	public void setAirportFees(Map<PassengerType, BigDecimal> airportFees) {
		FlightSearchFlightInfoDto.setAirportFees(airportFees);
	}

	public List<FlightSearchSeatDto> getSeats() {
		return FlightSearchFlightInfoDto.getSeats();
	}

	public void setSeats(List<FlightSearchSeatDto> seats) {
		FlightSearchFlightInfoDto.setSeats(seats);
	}

	public Map<String, FlightSearchSeatDto> getLowSeats() {
		return FlightSearchFlightInfoDto.getLowSeats();
	}

	public void setLowSeats(Map<String, FlightSearchSeatDto> lowSeats) {
		FlightSearchFlightInfoDto.setLowSeats(lowSeats);
	}

	public String getFlyTime() {
		return FlightSearchFlightInfoDto.getFlyTime();
	}

	public void setFlyTime(String flyTime) {
		FlightSearchFlightInfoDto.setFlyTime(flyTime);
	}

	public FlightAirportLineDto getFlightAirportLineDto() {
		return FlightSearchFlightInfoDto.getFlightAirportLineDto();
	}

	public void setFlightAirportLineDto(
			FlightAirportLineDto flightAirportLineDto) {
		FlightSearchFlightInfoDto.setFlightAirportLineDto(flightAirportLineDto);
	}

	public Map<String, FlightSearchSeatDto> getChildrenSeats() {
		return FlightSearchFlightInfoDto.getChildrenSeats();
	}

	public void setChildrenSeats(Map<String, FlightSearchSeatDto> childrenSeats) {
		FlightSearchFlightInfoDto.setChildrenSeats(childrenSeats);
	}

	@Override
	public String toString() {
		return FlightSearchFlightInfoDto.toString();
	}
	
}
