package com.lvmama.lvf.common.form.search;

import java.math.BigDecimal;

import com.lvmama.lvf.common.dto.enums.FlightTripType;
import com.lvmama.lvf.common.dto.md.Airplane;

public class BookingFirstDto {
	private String departCity; //出发城市
	private String arriveCity;  //到达城市
	private String flightNo;  // 航班号
	private String departedDate; //出发日期
	private String arriveDate;
	private String departTime;//出发时间
	private String arriveTime;//到达时间
	private String departAirportCode; //出发机场三字码
	private String arriveAirportCode; //  到达机场三字码
	private String seatClassCode; // 舱位代码
	private BigDecimal parPrice; // 票面价
	private Long policyId; // 政策ID
	private Long pricePolicyId; // 运价政策ID
	private String suppCode;
	private String carrierName; //航空公司
	private String carrierCode;//航空公司code
	private String departureTermainalBuilding; //  出发机场航站楼
	private String arrivalTerminalBuilding;//  到达机场航站楼
	private String arrivalAirportName;// 到达机场名称
	private String departureAirportName;// 出发机场名称
	private int stopCount;//  是否经停  >0经停
	private String seatClassName;// 舱位名称
	private String seatClassDesc;//  舱位描述
	private String stopCity;// 经停城市
	private String flightCode;//计划机型
	private BigDecimal airportFee;
	private BigDecimal fuelsurTax;
	private BigDecimal salePrice;
	private Airplane airplaneModel;
	private String flyTime;
	private Boolean highLightFlag;
	private Boolean isChildrenAvailable;
	private String mealType;
	/**
	 * 票面销售价 即 销售价--燃油--基建
	 */
	private BigDecimal salesParPrice;
	
	private FlightTripType tripType;
	
	/**政策类型**/
	private String saleType;
	
	public String getDepartCity() {
		return departCity;
	}
	public void setDepartCity(String departCity) {
		this.departCity = departCity;
	}
	public String getArriveCity() {
		return arriveCity;
	}
	public void setArriveCity(String arriveCity) {
		this.arriveCity = arriveCity;
	}
	public String getFlightCode() {
		return flightCode;
	}
	public void setFlightCode(String flightCode) {
		this.flightCode = flightCode;
	}
	public String getFlightNo() {
		return flightNo;
	}
	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}
	
	public String getDepartedDate() {
		return departedDate;
	}
	public void setDepartedDate(String departedDate) {
		this.departedDate = departedDate;
	}
	public String getDepartAirportCode() {
		return departAirportCode;
	}
	public void setDepartAirportCode(String departAirportCode) {
		this.departAirportCode = departAirportCode;
	}
	public String getArriveAirportCode() {
		return arriveAirportCode;
	}
	public void setArriveAirportCode(String arriveAirportCode) {
		this.arriveAirportCode = arriveAirportCode;
	}
	public String getSeatClassCode() {
		return seatClassCode;
	}
	public void setSeatClassCode(String seatClassCode) {
		this.seatClassCode = seatClassCode;
	}
	
	public BigDecimal getParPrice() {
		return parPrice;
	}
	public void setParPrice(BigDecimal parPrice) {
		this.parPrice = parPrice;
	}
	public Long getPolicyId() {
		return policyId;
	}
	public void setPolicyId(Long policyId) {
		this.policyId = policyId;
	}
	public Long getPricePolicyId() {
		return pricePolicyId;
	}
	public void setPricePolicyId(Long pricePolicyId) {
		this.pricePolicyId = pricePolicyId;
	}
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
	public String getDepartureTermainalBuilding() {
		return departureTermainalBuilding;
	}
	public void setDepartureTermainalBuilding(String departureTermainalBuilding) {
		this.departureTermainalBuilding = departureTermainalBuilding;
	}
	public String getArrivalTerminalBuilding() {
		return arrivalTerminalBuilding;
	}
	public void setArrivalTerminalBuilding(String arrivalTerminalBuilding) {
		this.arrivalTerminalBuilding = arrivalTerminalBuilding;
	}
	public String getArrivalAirportName() {
		return arrivalAirportName;
	}
	public void setArrivalAirportName(String arrivalAirportName) {
		this.arrivalAirportName = arrivalAirportName;
	}
	public String getDepartureAirportName() {
		return departureAirportName;
	}
	public void setDepartureAirportName(String departureAirportName) {
		this.departureAirportName = departureAirportName;
	}
	public int getStopCount() {
		return stopCount;
	}
	public void setStopCount(int stopCount) {
		this.stopCount = stopCount;
	}
	public String getSeatClassName() {
		return seatClassName;
	}
	public void setSeatClassName(String seatClassName) {
		this.seatClassName = seatClassName;
	}
	public String getSeatClassDesc() {
		return seatClassDesc;
	}
	public void setSeatClassDesc(String seatClassDesc) {
		this.seatClassDesc = seatClassDesc;
	}
	public String getStopCity() {
		return stopCity;
	}
	public void setStopCity(String stopCity) {
		this.stopCity = stopCity;
	}
	public String getDepartTime() {
		return departTime;
	}
	public void setDepartTime(String departTime) {
		this.departTime = departTime;
	}
	public String getArriveTime() {
		return arriveTime;
	}
	public void setArriveTime(String arriveTime) {
		this.arriveTime = arriveTime;
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
	public BigDecimal getSalePrice() {
		return salePrice;
	}
	public void setSalePrice(BigDecimal salePrice) {
		this.salePrice = salePrice;
	}
	public String getArriveDate() {
		return arriveDate;
	}
	public void setArriveDate(String arriveDate) {
		this.arriveDate = arriveDate;
	}
	public Airplane getAirplaneModel() {
		return airplaneModel;
	}
	public void setAirplaneModel(Airplane airplaneModel) {
		this.airplaneModel = airplaneModel;
	}
	public FlightTripType getTripType() {
		return tripType;
	}
	public void setTripType(FlightTripType tripType) {
		this.tripType = tripType;
	}
	public String getSuppCode() {
		return suppCode;
	}
	public void setSuppCode(String suppCode) {
		this.suppCode = suppCode;
	}
	public String getFlyTime() {
		return flyTime;
	}
	public void setFlyTime(String flyTime) {
		this.flyTime = flyTime;
	}
	public Boolean getHighLightFlag() {
		return highLightFlag;
	}
	public void setHighLightFlag(Boolean highLightFlag) {
		this.highLightFlag = highLightFlag;
	}
	public BigDecimal getSalesParPrice() {
		return salesParPrice;
	}
	public void setSalesParPrice(BigDecimal salesParPrice) {
		this.salesParPrice = salesParPrice;
	}
	public Boolean getIsChildrenAvailable() {
		return isChildrenAvailable;
	}
	public void setIsChildrenAvailable(Boolean isChildrenAvailable) {
		this.isChildrenAvailable = isChildrenAvailable;
	}
	public String getMealType() {
		return mealType;
	}
	public void setMealType(String mealType) {
		this.mealType = mealType;
	}
	public String getSaleType() {
		return saleType;
	}
	public void setSaleType(String saleType) {
		this.saleType = saleType;
	}
	
}
