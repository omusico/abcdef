package com.lvmama.lvf.common.form.booking;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.lvmama.lvf.common.dto.enums.FlightTripType;
import com.lvmama.lvf.common.dto.enums.MealType;
import com.lvmama.lvf.common.dto.enums.PassengerType;
import com.lvmama.lvf.common.dto.enums.RouteType;
import com.lvmama.lvf.common.dto.md.Airplane;
import com.lvmama.lvf.common.dto.search.result.FlightSearchFlightInfoDto;
import com.lvmama.lvf.common.dto.search.result.FlightSearchSeatDto;
import com.lvmama.lvf.common.dto.search.result.FlightSearchTicketRuleSimpleDto;
import com.lvmama.lvf.common.form.search.BookingFirstDto;
import com.lvmama.lvf.common.form.ticket.FlightTicketRuleForm;

/**
 * @author lutianyu
 * @date   2015-2-10
 */
public class ToBookingSegmentForm{
	private FlightSearchFlightInfoDto flightSearchFlightInfoDto;
	
	private String departCityCode;
	
	private String arriveCityCode;
	
	private RouteType routeType;
	
	private String routeTypeName;
	
	/**航程类型：去程/回程*/
	private FlightTripType flightTripType;
	
	private String flightTripTypeName;
	
	private BigDecimal airportFee;
	
	private String departCityName;
	
	private String arriveCityName;
	
	private BigDecimal fuelsurTax;
	
	private BookingFirstDto bookingFirstDto;
	
	/**航段序号*/
	private Integer segNo;
	
	/**到达时间——跨天信息，如：+1天 */
	private String crossDayInfo;
	
	/**得到商品价格信息 */
	private List<ToBookingProductPriceForm> productPrices;
	
	/** 客规信息 */
	private List<FlightTicketRuleForm> ticketRuleForms;
	
	/** 简单客规信息 */
	private List<FlightSearchTicketRuleSimpleDto> ticketRuleSimples;
	
	//日期对应的星期
	private String weekForDate;
	
	public String getWeekForDate() {
		return weekForDate;
	}

	public void setWeekForDate(String weekForDate) {
		this.weekForDate = weekForDate;
	}

	public FlightSearchFlightInfoDto getFlightSearchFlightInfoDto() {
		return flightSearchFlightInfoDto;
	}

	public String getDepartCityCode() {
		return departCityCode;
	}

	public void setDepartCityCode(String departCityCode) {
		this.departCityCode = departCityCode;
	}

	public String getArriveCityCode() {
		return arriveCityCode;
	}

	public void setArriveCityCode(String arriveCityCode) {
		this.arriveCityCode = arriveCityCode;
	}

	public void setFlightSearchFlightInfoDto(
			FlightSearchFlightInfoDto flightSearchFlightInfoDto) {
		this.flightSearchFlightInfoDto = flightSearchFlightInfoDto;
	}

	public FlightTripType getFlightTripType() {
		return flightTripType;
	}

	public String getFlightTripTypeName() {
		return flightTripTypeName;
	}

	public void setFlightTripTypeName(String flightTripTypeName) {
		this.flightTripTypeName = flightTripTypeName;
	}

	public void setFlightTripType(FlightTripType flightTripType) {
		this.flightTripType = flightTripType;
	}

	public Integer getSegNo() {
		return segNo;
	}

	public void setSegNo(Integer segNo) {
		this.segNo = segNo;
	}

	public String getCrossDayInfo() {
		return crossDayInfo;
	}

	public void setCrossDayInfo(String crossDayInfo) {
		this.crossDayInfo = crossDayInfo;
	}

	public String getCarrierName() {
		return flightSearchFlightInfoDto.getCarrierName();
	}

	public void setCarrierName(String carrierName) {
		flightSearchFlightInfoDto.setCarrierName(carrierName);
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
		flightSearchFlightInfoDto
				.setDepartureTermainalBuilding(departureTermainalBuilding);
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
		flightSearchFlightInfoDto
				.setArrivalTerminalBuilding(arrivalTerminalBuilding);
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

	public List<ToBookingProductPriceForm> getProductPrices() {
		return productPrices;
	}

	public void setProductPrices(List<ToBookingProductPriceForm> productPrices) {
		this.productPrices = productPrices;
	}

	public List<FlightTicketRuleForm> getTicketRuleForms() {
		return ticketRuleForms;
	}

	public void setTicketRuleForms(List<FlightTicketRuleForm> ticketRuleForms) {
		this.ticketRuleForms = ticketRuleForms;
	}

	public BigDecimal getAirportFee() {
		return airportFee;
	}

	public void setAirportFee(BigDecimal airportFee) {
		this.airportFee = airportFee;
	}

	public BigDecimal getFuelsurTax() {
		return fuelsurTax;
	}

	public void setFuelsurTax(BigDecimal fuelsurTax) {
		this.fuelsurTax = fuelsurTax;
	}

	public List<FlightSearchTicketRuleSimpleDto> getTicketRuleSimples() {
		return ticketRuleSimples;
	}

	public void setTicketRuleSimples(List<FlightSearchTicketRuleSimpleDto> ticketRuleSimples) {
		this.ticketRuleSimples = ticketRuleSimples;
	}

	public String getDepartCityName() {
		return departCityName;
	}

	public void setDepartCityName(String departCityName) {
		this.departCityName = departCityName;
	}

	public String getArriveCityName() {
		return arriveCityName;
	}

	public void setArriveCityName(String arriveCityName) {
		this.arriveCityName = arriveCityName;
	}

	public RouteType getRouteType() {
		return routeType;
	}

	public void setRouteType(RouteType routeType) {
		this.routeType = routeType;
	}

	public String getRouteTypeName() {
		return routeTypeName;
	}

	public void setRouteTypeName(String routeTypeName) {
		this.routeTypeName = routeTypeName;
	}

	public BookingFirstDto getBookingFirstDto() {
		return bookingFirstDto;
	}

	public void setBookingFirstDto(BookingFirstDto bookingFirstDto) {
		this.bookingFirstDto = bookingFirstDto;
	}
}
