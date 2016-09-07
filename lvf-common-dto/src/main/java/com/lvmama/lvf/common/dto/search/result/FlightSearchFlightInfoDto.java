package com.lvmama.lvf.common.dto.search.result;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.lvmama.lvf.common.dto.enums.DirectType;
import com.lvmama.lvf.common.dto.enums.MealType;
import com.lvmama.lvf.common.dto.enums.PassengerType;
import com.lvmama.lvf.common.dto.flight.FlightAirportLineDto;
import com.lvmama.lvf.common.dto.md.Airplane;

/**
 * 航班搜索信息
 * @author majun
 * @date   2015-1-24
 */
public class FlightSearchFlightInfoDto implements Serializable 
{
	private static final long serialVersionUID = 1002866015784952694L;

	/**航空公司名称 */
	private String carrierName;
	
	/**航空公司名称 */
	private String carrierCode;
	
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
	
	/**飞行时长（HH:mm）  */
	private String flyTime;
	
	/**飞行时长（单位：分钟数） */
	private Integer flyTimeMins;
	
	/**经停次数 */
	private Integer stopCount;
	
	/**是否是直飞 */
	private DirectType directType;
	
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
	
	/**出发城市名称 */
	private String departureCityName; 
	
	/**出发城市code */
	private String departureCityCode; 
	
	/**到达机场名称 */
	private String arrivalAirportName;

	/**到达机场Code */
	private String arrivalAirportCode;
	
	/**到达机场航站楼 */
	private String arrivalTerminalBuilding;
	
	/**到达城市名称 */
	private String arrivalCityName;
	
	/**到达城市code */
	private String arrivalCityCode;
	
	/**餐食类型 */
	private MealType mealType;
	
	/** Y舱票面价 */
	private BigDecimal yParPrice;
	
	private FlightAirportLineDto flightAirportLineDto;
	
	/**燃油费 */
	private Map<PassengerType, BigDecimal> fuelsurTaxs;

	/**机建费 */
	private Map<PassengerType, BigDecimal> airportFees;
	
	/**舱位信息*/
	private List<FlightSearchSeatDto> seats;
	
	/**有效舱位最低价*/
	private Map<String,FlightSearchSeatDto> lowSeats;
	
	/**航班儿童价**/
	private Map<String,FlightSearchSeatDto> childrenSeats;
	
	private boolean isCodeShare;
	
	private String shareFlightNo;
	
	private List<FlightSearchFlightInfoDto> returnFlightInfoDto; //真往返对应的查询返程航班信息
	
	private String saleType; //政策类型，用于标识该条报价是来自普通政策还是包机政策
	
	private Map<String, Map<String, List<FlightSearchSeatDto>>> returnFlightMap; //包机切位真往返的返程航班及其舱位组合
	
	public String getCarrierName() {
		return carrierName;
	}

	public void setCarrierName(String carrierName) {
		this.carrierName = carrierName;
	}
	
	public String getCarrierCode() {
		return carrierCode;
	}

	public void setCarrierCode(String carrierCode) {
		this.carrierCode = carrierCode;
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
	
	public DirectType getDirectType() {
		return directType;
	}

	public void setDirectType(DirectType directType) {
		this.directType = directType;
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
	
	public String getDepartureCityName() {
		return departureCityName;
	}

	public void setDepartureCityName(String departureCityName) {
		this.departureCityName = departureCityName;
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
	
	public String getArrivalCityName() {
		return arrivalCityName;
	}

	public void setArrivalCityName(String arrivalCityName) {
		this.arrivalCityName = arrivalCityName;
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

	public List<FlightSearchSeatDto> getSeats() {
		return seats;
	}

	public void setSeats(List<FlightSearchSeatDto> seats) {
		this.seats = seats;
	}

	public Map<String, FlightSearchSeatDto> getLowSeats() {
		return lowSeats;
	}

	public void setLowSeats(Map<String, FlightSearchSeatDto> lowSeats) {
		this.lowSeats = lowSeats;
	}

	public String getFlyTime() {
		return flyTime;
	}

	public void setFlyTime(String flyTime) {
		this.flyTime = flyTime;
	}

	public FlightAirportLineDto getFlightAirportLineDto() {
		return flightAirportLineDto;
	}

	public void setFlightAirportLineDto(FlightAirportLineDto flightAirportLineDto) {
		this.flightAirportLineDto = flightAirportLineDto;
	}

	public Map<String, FlightSearchSeatDto> getChildrenSeats() {
		return childrenSeats;
	}

	public void setChildrenSeats(Map<String, FlightSearchSeatDto> childrenSeats) {
		this.childrenSeats = childrenSeats;
	}

	public String getDepartureCityCode() {
		return departureCityCode;
	}

	public void setDepartureCityCode(String departureCityCode) {
		this.departureCityCode = departureCityCode;
	}

	public String getArrivalCityCode() {
		return arrivalCityCode;
	}

	public void setArrivalCityCode(String arrivalCityCode) {
		this.arrivalCityCode = arrivalCityCode;
	}

	public boolean isCodeShare() {
		return isCodeShare;
	}

	public void setCodeShare(boolean isCodeShare) {
		this.isCodeShare = isCodeShare;
	}

	public String getShareFlightNo() {
		return shareFlightNo;
	}

	public void setShareFlightNo(String shareFlightNo) {
		this.shareFlightNo = shareFlightNo;
	}

	public String getSaleType() {
		return saleType;
	}

	public void setSaleType(String saleType) {
		this.saleType = saleType;
	}

	public List<FlightSearchFlightInfoDto> getReturnFlightInfoDto() {
		return returnFlightInfoDto;
	}

	public void setReturnFlightInfoDto(List<FlightSearchFlightInfoDto> returnFlightInfoDto) {
		this.returnFlightInfoDto = returnFlightInfoDto;
	}

	public Map<String, Map<String, List<FlightSearchSeatDto>>> getReturnFlightMap() {
		return returnFlightMap;
	}

	public void setReturnFlightMap(Map<String, Map<String, List<FlightSearchSeatDto>>> returnFlightMap) {
		this.returnFlightMap = returnFlightMap;
	}

}
