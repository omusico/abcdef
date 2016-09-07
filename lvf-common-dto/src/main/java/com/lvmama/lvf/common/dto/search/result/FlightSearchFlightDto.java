package com.lvmama.lvf.common.dto.search.result;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.lvmama.lvf.common.dto.enums.MealType;
import com.lvmama.lvf.common.dto.enums.PassengerType;
import com.lvmama.lvf.common.dto.enums.SeatClassType;
import com.lvmama.lvf.common.dto.md.Airplane;

/**
 * 航班搜索列表
 * @author suihaonan
 *
 */
public class FlightSearchFlightDto implements Serializable 
{
	private static final long serialVersionUID = 1002866015784952694L;

	/**航空公司名称 */
	private String carrierName;
	
	/**航班号Id */
	private Long flightId;
	
	/**航班号 */
	private String flightNo;
	
	/**机型信息 */
	private Airplane airplane;
	
	/** 出发日期 */
	private String departureDate;
	
	/**出发时间 */
	private String departureTime;
	
	/**到达时间 */
	private String arrivalTime;
	
	/**飞行时长（单位：分钟数） */
	private Integer flyTimeMins;
	
	/**经停次数 */
	private Integer stopCount;
	
	/**经停城市 */
	private String stopCity;
	
	/**经停机场 */
	private String stopAirport;
	
	/**经停时长（单位：分钟数） */
	private Integer stopTimeMins;
	
	/**出发机场名称 */
	private String departureAirportName;
	
	/**出发机场Code */
	private String departureAirportCode;
	
	/**出发机场航站楼 */
	private String departureTermainalBuilding;
	
	/**到达机场名称 */
	private String arrivalAirportName;

	/**到达机场Code */
	private String arrivalAirportCode;
	
	/**到达机场航站楼 */
	private String arrivalTerminalBuilding;
	
	/**餐食类型 */
	private MealType mealType;
	
	/** Y舱票面价 */
	private BigDecimal yParPrice;
	
	/**燃油费 */
	private Map<PassengerType, BigDecimal> fuelsurTaxs;

	/**机建费 */
	private Map<PassengerType, BigDecimal> airportFees;
	
	/**有效舱位最低价*/
	private Map<SeatClassType,FlightSearchSeatDto> seats;

	public String getCarrierName() {
		return carrierName;
	}

	public void setCarrierName(String carrierName) {
		this.carrierName = carrierName;
	}

	public Long getFlightId() {
		return flightId;
	}

	public void setFlightId(Long flightId) {
		this.flightId = flightId;
	}

	public String getFlightNo() {
		return flightNo;
	}

	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}

	public Airplane getAirplane() {
		return airplane;
	}

	public void setAirplane(Airplane airplane) {
		this.airplane = airplane;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public Integer getFlyTimeMins() {
		return flyTimeMins;
	}

	public void setFlyTimeMins(Integer flyTimeMins) {
		this.flyTimeMins = flyTimeMins;
	}

	public Integer getStopCount() {
		return stopCount;
	}

	public void setStopCount(Integer stopCount) {
		this.stopCount = stopCount;
	}

	public String getStopCity() {
		return stopCity;
	}

	public void setStopCity(String stopCity) {
		this.stopCity = stopCity;
	}

	public String getStopAirport() {
		return stopAirport;
	}

	public void setStopAirport(String stopAirport) {
		this.stopAirport = stopAirport;
	}

	public Integer getStopTimeMins() {
		return stopTimeMins;
	}

	public void setStopTimeMins(Integer stopTimeMins) {
		this.stopTimeMins = stopTimeMins;
	}

	public String getDepartureAirportName() {
		return departureAirportName;
	}

	public void setDepartureAirportName(String departureAirportName) {
		this.departureAirportName = departureAirportName;
	}

	public String getDepartureAirportCode() {
		return departureAirportCode;
	}

	public void setDepartureAirportCode(String departureAirportCode) {
		this.departureAirportCode = departureAirportCode;
	}

	public String getDepartureTermainalBuilding() {
		return departureTermainalBuilding;
	}

	public void setDepartureTermainalBuilding(String departureTermainalBuilding) {
		this.departureTermainalBuilding = departureTermainalBuilding;
	}

	public String getArrivalAirportName() {
		return arrivalAirportName;
	}

	public void setArrivalAirportName(String arrivalAirportName) {
		this.arrivalAirportName = arrivalAirportName;
	}

	public String getArrivalAirportCode() {
		return arrivalAirportCode;
	}

	public void setArrivalAirportCode(String arrivalAirportCode) {
		this.arrivalAirportCode = arrivalAirportCode;
	}

	public String getArrivalTerminalBuilding() {
		return arrivalTerminalBuilding;
	}

	public void setArrivalTerminalBuilding(String arrivalTerminalBuilding) {
		this.arrivalTerminalBuilding = arrivalTerminalBuilding;
	}

	public MealType getMealType() {
		return mealType;
	}

	public void setMealType(MealType mealType) {
		this.mealType = mealType;
	}

	public String getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}

	public BigDecimal getyParPrice() {
		return yParPrice;
	}

	public void setyParPrice(BigDecimal yParPrice) {
		this.yParPrice = yParPrice;
	}

	public Map<PassengerType, BigDecimal> getFuelsurTaxs() {
		return fuelsurTaxs;
	}

	public void setFuelsurTaxs(Map<PassengerType, BigDecimal> fuelsurTaxs) {
		this.fuelsurTaxs = fuelsurTaxs;
	}

	public Map<PassengerType, BigDecimal> getAirportFees() {
		return airportFees;
	}

	public void setAirportFees(Map<PassengerType, BigDecimal> airportFees) {
		this.airportFees = airportFees;
	}

	public Map<SeatClassType, FlightSearchSeatDto> getSeats() {
		return seats;
	}

	public void setSeats(Map<SeatClassType, FlightSearchSeatDto> seats) {
		this.seats = seats;
	}

}
