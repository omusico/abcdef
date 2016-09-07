package com.lvmama.lvf.common.dto.search;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

import com.lvmama.lvf.common.dto.enums.InventoryStatus;
import com.lvmama.lvf.common.solr.json.DynamicIndex;

public class FlightSearchIndexRelateSolr extends DynamicIndex implements Serializable {

	private FlightSearchIndex searchIndex = new FlightSearchIndex();
	
    private String pricePolicyId;
	
	private String lvSeatClassCode; 
	
	/**
	 * 重置航班索引Id
	 * @return
	 */
	public String resetIndexId(){
		this.searchIndex.setIndexId(this.getFlightNo() + "_"+this.getDepartureCityCode()+ "_"+this.getArrivalCityCode()+ "_" + this.getLvSeatClassCode() + "_"
				+ this.getPricePolicyId()+ "_" +this.getSplitKey());
		return this.searchIndex.getIndexId(); 
	}


	public String getSplitKey() {
		return searchIndex.getSplitKey();
	}

	public void setSplitKey(String splitKey) {
		searchIndex.setSplitKey(splitKey);
	}

	public String getSuppCode() {
		return searchIndex.getSuppCode();
	}

	public void setSuppCode(String suppCode) {
		searchIndex.setSuppCode(suppCode);
	}

	public String getSelfType() {
		return searchIndex.getSelfType();
	}

	public void setSelfType(String selfType) {
		searchIndex.setSelfType(selfType);
	}
	
	public String getSaleType() {
		return searchIndex.getSaleType();
	}

	public void setSaleType(String saleType) {
		searchIndex.setSaleType(saleType);
	}

	public BigDecimal getBaseParPrice() {
		return searchIndex.getBaseParPrice();
	}

	public void setBaseParPrice(BigDecimal baseParPrice) {
		searchIndex.setBaseParPrice(baseParPrice);
	}

	public Date getDepartureTime() {
		return searchIndex.getDepartureTime();
	}

	public void setDepartureTime(Date departureTime) {
		searchIndex.setDepartureTime(departureTime);
	}

	public Date getArrivalTime() {
		return searchIndex.getArrivalTime();
	}

	public void setArrivalTime(Date arrivalTime) {
		searchIndex.setArrivalTime(arrivalTime);
	}

	public void setIndexId(String indexId) {
		searchIndex.setIndexId(indexId);
	}

	public String getIndexId() {
		return searchIndex.getIndexId();
	}

	public Map getFields() {
		return searchIndex.getFields();
	}

	public String getCarrierNameCode() {
		return searchIndex.getCarrierNameCode();
	}

	public void setCarrierNameCode(String carrierNameCode) {
		searchIndex.setCarrierNameCode(carrierNameCode);
	}

	public String getShareCarrierNameCode() {
		return searchIndex.getShareCarrierNameCode();
	}

	public void setShareCarrierNameCode(String shareCarrierNameCode) {
		searchIndex.setShareCarrierNameCode(shareCarrierNameCode);
	}

	public String getPolicyId() {
		return searchIndex.getPolicyId();
	}

	public void setPolicyId(String policyId) {
		searchIndex.setPolicyId(policyId);
	}

	public String getCarrierName() {
		return searchIndex.getCarrierName();
	}

	public void setCarrierName(String carrierName) {
		searchIndex.setCarrierName(carrierName);
	}

	public String getCarrierCode() {
		return searchIndex.getCarrierCode();
	}

	public void setCarrierCode(String carrierCode) {
		searchIndex.setCarrierCode(carrierCode);
	}

	public String getCarrierType() {
		return searchIndex.getCarrierType();
	}

	public void setCarrierType(String carrierType) {
		searchIndex.setCarrierType(carrierType);
	}

	public String getAirplaneCode() {
		return searchIndex.getAirplaneCode();
	}

	public void setAirplaneCode(String airplaneCode) {
		searchIndex.setAirplaneCode(airplaneCode);
	}

	public String getAirplaneName() {
		return searchIndex.getAirplaneName();
	}

	public void setAirplaneName(String airplaneSimpleName) {
		searchIndex.setAirplaneName(airplaneSimpleName);
	}
	public String getAirplaneSimpleName() {
		return searchIndex.getAirplaneSimpleName();
	}

	public void setAirplaneSimpleName(String airplaneSimpleName) {
		searchIndex.setAirplaneSimpleName(airplaneSimpleName);
	}
	public String getAirplaneType() {
		return searchIndex.getAirplaneType();
	}

	public void setAirplaneType(String airplaneType) {
		searchIndex.setAirplaneType(airplaneType);
	}

	public Integer getAirplaneMinSeats() {
		return searchIndex.getAirplaneMinSeats();
	}

	public void setAirplaneMinSeats(Integer airplaneMinSeats) {
		searchIndex.setAirplaneMinSeats(airplaneMinSeats);
	}

	public Integer getAirplaneMaxSeats() {
		return searchIndex.getAirplaneMaxSeats();
	}

	public void setAirplaneMaxSeats(Integer airplaneMaxSeats) {
		searchIndex.setAirplaneMaxSeats(airplaneMaxSeats);
	}

	public String getAirplaneCompany() {
		return searchIndex.getAirplaneCompany();
	}

	public void setAirplaneCompany(String airplaneCompany) {
		searchIndex.setAirplaneCompany(airplaneCompany);
	}

	public String getFlightNo() {
		return searchIndex.getFlightNo();
	}

	public void setFlightNo(String flightNo) {
		searchIndex.setFlightNo(flightNo);
	}

	public String getFlightNoNotWithCarrierCode() {
		return searchIndex.getFlightNoNotWithCarrierCode();
	}

	public void setFlightNoNotWithCarrierCode(String flightNoNotWithCarrierCode) {
		searchIndex.setFlightNoNotWithCarrierCode(flightNoNotWithCarrierCode);
	}

	public Integer getMileages() {
		return searchIndex.getMileages();
	}

	public void setMileages(Integer mileages) {
		searchIndex.setMileages(mileages);
	}

	public String getDepartureAirportCode() {
		return searchIndex.getDepartureAirportCode();
	}

	public void setDepartureAirportCode(String departureAirportCode) {
		searchIndex.setDepartureAirportCode(departureAirportCode);
	}

	public String getDepartureAirportName() {
		return searchIndex.getDepartureAirportName();
	}

	public void setDepartureAirportName(String departureAirportName) {
		searchIndex.setDepartureAirportName(departureAirportName);
	}

	public String getArrivalAirportCode() {
		return searchIndex.getArrivalAirportCode();
	}

	public void setArrivalAirportCode(String arrivalAirportCode) {
		searchIndex.setArrivalAirportCode(arrivalAirportCode);
	}

	public String getArrivalAirportName() {
		return searchIndex.getArrivalAirportName();
	}

	public void setArrivalAirportName(String arrivalAirportName) {
		searchIndex.setArrivalAirportName(arrivalAirportName);
	}

	public BigDecimal getDepartureAirportLongitude() {
		return searchIndex.getDepartureAirportLongitude();
	}

	public void setDepartureAirportLongitude(
			BigDecimal departureAirportLongitude) {
		searchIndex.setDepartureAirportLongitude(departureAirportLongitude);
	}

	public BigDecimal getDepartureAirportLatitude() {
		return searchIndex.getDepartureAirportLatitude();
	}

	public void setDepartureAirportLatitude(BigDecimal departureAirportLatitude) {
		searchIndex.setDepartureAirportLatitude(departureAirportLatitude);
	}

	public BigDecimal getArrivalAirportLongitude() {
		return searchIndex.getArrivalAirportLongitude();
	}

	public void setArrivalAirportLongitude(BigDecimal arrivalAirportLongitude) {
		searchIndex.setArrivalAirportLongitude(arrivalAirportLongitude);
	}

	public BigDecimal getArrivalAirportLatitude() {
		return searchIndex.getArrivalAirportLatitude();
	}

	public void setArrivalAirportLatitude(BigDecimal arrivalAirportLatitude) {
		searchIndex.setArrivalAirportLatitude(arrivalAirportLatitude);
	}

	public String getDepartureCityCode() {
		return searchIndex.getDepartureCityCode();
	}

	public void setDepartureCityCode(String departureCityCode) {
		searchIndex.setDepartureCityCode(departureCityCode);
	}

	public String getDepartureCityName() {
		return searchIndex.getDepartureCityName();
	}

	public void setDepartureCityName(String departureCityName) {
		searchIndex.setDepartureCityName(departureCityName);
	}

	public String getArrivalCityCode() {
		return searchIndex.getArrivalCityCode();
	}

	public void setArrivalCityCode(String arrivalCityCode) {
		searchIndex.setArrivalCityCode(arrivalCityCode);
	}

	public String getArrivalCityName() {
		return searchIndex.getArrivalCityName();
	}

	public void setArrivalCityName(String arrivalCityName) {
		searchIndex.setArrivalCityName(arrivalCityName);
	}

	public BigDecimal getDepartureCityLongitude() {
		return searchIndex.getDepartureCityLongitude();
	}

	public void setDepartureCityLongitude(BigDecimal departureCityLongitude) {
		searchIndex.setDepartureCityLongitude(departureCityLongitude);
	}

	public BigDecimal getDepartureCityLatitude() {
		return searchIndex.getDepartureCityLatitude();
	}

	public void setDepartureCityLatitude(BigDecimal departureCityLatitude) {
		searchIndex.setDepartureCityLatitude(departureCityLatitude);
	}

	public BigDecimal getArrivalCityLongitude() {
		return searchIndex.getArrivalCityLongitude();
	}

	public void setArrivalCityLongitude(BigDecimal arrivalCityLongitude) {
		searchIndex.setArrivalCityLongitude(arrivalCityLongitude);
	}

	public BigDecimal getArrivalCityLatitude() {
		return searchIndex.getArrivalCityLatitude();
	}

	public void setArrivalCityLatitude(BigDecimal arrivalCityLatitude) {
		searchIndex.setArrivalCityLatitude(arrivalCityLatitude);
	}

	public String getDepartureCountryAreaCode() {
		return searchIndex.getDepartureCountryAreaCode();
	}

	public void setDepartureCountryAreaCode(String departureCountryAreaCode) {
		searchIndex.setDepartureCountryAreaCode(departureCountryAreaCode);
	}

	public String getDepartureCountryAreaName() {
		return searchIndex.getDepartureCountryAreaName();
	}

	public void setDepartureCountryAreaName(String departureCountryAreaName) {
		searchIndex.setDepartureCountryAreaName(departureCountryAreaName);
	}

	public String getArrivalCountryAreaCode() {
		return searchIndex.getArrivalCountryAreaCode();
	}

	public void setArrivalCountryAreaCode(String arrivalCountryAreaCode) {
		searchIndex.setArrivalCountryAreaCode(arrivalCountryAreaCode);
	}

	public String getArrivalCountryAreaName() {
		return searchIndex.getArrivalCountryAreaName();
	}

	public void setArrivalCountryAreaName(String arrivalCountryAreaName) {
		searchIndex.setArrivalCountryAreaName(arrivalCountryAreaName);
	}

	public String getFlightSegmentType() {
		return searchIndex.getFlightSegmentType();
	}

	public void setFlightSegmentType(String flightSegmentType) {
		searchIndex.setFlightSegmentType(flightSegmentType);
	}

	public Integer getStopCount() {
		return searchIndex.getStopCount();
	}

	public void setStopCount(Integer stopCount) {
		searchIndex.setStopCount(stopCount);
	}

	public String[] getStopAirportCodes() {
		return searchIndex.getStopAirportCodes();
	}

	public void setStopAirportCodes(String[] stopAirportCodes) {
		searchIndex.setStopAirportCodes(stopAirportCodes);
	}

	public String[] getStopAirportNames() {
		return searchIndex.getStopAirportNames();
	}

	public void setStopAirportNames(String[] stopAirportNames) {
		searchIndex.setStopAirportNames(stopAirportNames);
	}

	public String getStopTime() {
		return searchIndex.getStopTime();
	}

	public void setStopTime(String stopTime) {
		searchIndex.setStopTime(stopTime);
	}

	public String getDirectType() {
		return searchIndex.getDirectType();
	}

	public void setDirectType(String directType) {
		searchIndex.setDirectType(directType);
	}

	public BigDecimal getYParPrice() {
		return searchIndex.getYParPrice();
	}

	public void setYParPrice(BigDecimal yParPrice) {
		searchIndex.setYParPrice(yParPrice);
	}

	public BigDecimal getyParPrice() {
		return searchIndex.getyParPrice();
	}

	public void setyParPrice(BigDecimal yParPrice) {
		searchIndex.setyParPrice(yParPrice);
	}

	public String getMealType() {
		return searchIndex.getMealType();
	}

	public void setMealType(String mealType) {
		searchIndex.setMealType(mealType);
	}

	public String getFlytime() {
		return searchIndex.getFlytime();
	}

	public void setFlytime(String flytime) {
		searchIndex.setFlytime(flytime);
	}

	public String getDepartureTimeSegment() {
		return searchIndex.getDepartureTimeSegment();
	}

	public void setDepartureTimeSegment(String departureTimeSegment) {
		searchIndex.setDepartureTimeSegment(departureTimeSegment);
	}

	public String getArrivalTimeSegment() {
		return searchIndex.getArrivalTimeSegment();
	}

	public void setArrivalTimeSegment(String arrivalTimeSegment) {
		searchIndex.setArrivalTimeSegment(arrivalTimeSegment);
	}

	public BigDecimal getFlyTimeHours() {
		return searchIndex.getFlyTimeHours();
	}

	public void setFlyTimeHours(BigDecimal flyTimeHours) {
		searchIndex.setFlyTimeHours(flyTimeHours);
	}

	public Boolean getIsShare() {
		return searchIndex.getIsShare();
	}

	public void setIsShare(Boolean isShare) {
		searchIndex.setIsShare(isShare);
	}

	public String getShareCarrierName() {
		return searchIndex.getShareCarrierName();
	}

	public void setShareCarrierName(String shareCarrierName) {
		searchIndex.setShareCarrierName(shareCarrierName);
	}

	public String getShareCarrierCode() {
		return searchIndex.getShareCarrierCode();
	}

	public void setShareCarrierCode(String shareCarrierCode) {
		searchIndex.setShareCarrierCode(shareCarrierCode);
	}

	public String getShareCarrierType() {
		return searchIndex.getShareCarrierType();
	}

	public void setShareCarrierType(String shareCarrierType) {
		searchIndex.setShareCarrierType(shareCarrierType);
	}

	public String getShareFlightNo() {
		return searchIndex.getShareFlightNo();
	}

	public void setShareFlightNo(String shareFlightNo) {
		searchIndex.setShareFlightNo(shareFlightNo);
	}

	public String getFlightTicketType() {
		return searchIndex.getFlightTicketType();
	}

	public void setFlightTicketType(String flightTicketType) {
		searchIndex.setFlightTicketType(flightTicketType);
	}

	public String getSeatClass() {
		return searchIndex.getSeatClass();
	}

	public void setSeatClass(String seatClass) {
		searchIndex.setSeatClass(seatClass);
	}

	public String getSeatClassType() {
		return searchIndex.getSeatClassType();
	}

	public void setSeatClassType(String seatClassType) {
		searchIndex.setSeatClassType(seatClassType);
	}

	public String getSeatLevel() {
		return searchIndex.getSeatLevel();
	}

	public void setSeatLevel(String seatLevel) {
		searchIndex.setSeatLevel(seatLevel);
	}

	public String getSeatSpecType() {
		return searchIndex.getSeatSpecType();
	}

	public void setSeatSpecType(String seatSpecType) {
		searchIndex.setSeatSpecType(seatSpecType);
	}

	public BigDecimal getDiscount() {
		return searchIndex.getDiscount();
	}

	public void setDiscount(BigDecimal discount) {
		searchIndex.setDiscount(discount);
	}

	public BigDecimal getParPrice() {
		return searchIndex.getParPrice();
	}

	public void setParPrice(BigDecimal parPrice) {
		searchIndex.setParPrice(parPrice);
	}

	public String getSettlePrice() {
		return searchIndex.getSettlePrice();
	}

	public void setSettlePrice(String settlePrice) {
		searchIndex.setSettlePrice(settlePrice);
	}

	public String getDate() {
		return searchIndex.getDate();
	}

	public void setDate(String date) {
		searchIndex.setDate(date);
	}

	public Long getDepartureTimeDate() {
		return searchIndex.getDepartureTimeDate();
	}

	public void setDepartureTimeDate(Long departureTimeDate) {
		searchIndex.setDepartureTimeDate(departureTimeDate);
	}

	public Long getArrivalTimeDate() {
		return searchIndex.getArrivalTimeDate();
	}

	public void setArrivalTimeDate(Long arrivalTimeDate) {
		searchIndex.setArrivalTimeDate(arrivalTimeDate);
	}

	public Long getDepartureTimeHour() {
		return searchIndex.getDepartureTimeHour();
	}

	public void setDepartureTimeHour(Long departureTimeHour) {
		searchIndex.setDepartureTimeHour(departureTimeHour);
	}

	public Long getArrivalTimeHour() {
		return searchIndex.getArrivalTimeHour();
	}

	public void setArrivalTimeHour(Long arrivalTimeHour) {
		searchIndex.setArrivalTimeHour(arrivalTimeHour);
	}

	public String getDepartureTimeStr() {
		return searchIndex.getDepartureTimeStr();
	}

	public void setDepartureTimeStr(String departureTimeStr) {
		searchIndex.setDepartureTimeStr(departureTimeStr);
	}

	public String getArrivalTimeStr() {
		return searchIndex.getArrivalTimeStr();
	}

	public void setArrivalTimeStr(String arrivalTimeStr) {
		searchIndex.setArrivalTimeStr(arrivalTimeStr);
	}

	public String getSuppType() {
		return searchIndex.getSuppType();
	}

	public void setSuppType(String suppType) {
		searchIndex.setSuppType(suppType);
	}

	public String getSuppPolicyId() {
		return searchIndex.getSuppPolicyId();
	}

	public void setSuppPolicyId(String suppPolicyId) {
		searchIndex.setSuppPolicyId(suppPolicyId);
	}

	public String getInventoryType() {
		return searchIndex.getInventoryType();
	}

	public void setInventoryType(String inventoryType) {
		searchIndex.setInventoryType(inventoryType);
	}

	public InventoryStatus getInventoryStatus() {
		return searchIndex.getInventoryStatus();
	}

	public void setInventoryStatus(InventoryStatus inventoryStatus) {
		searchIndex.setInventoryStatus(inventoryStatus);
	}

	public BigDecimal getInventoryCount() {
		return searchIndex.getInventoryCount();
	}

	public void setInventoryCount(BigDecimal inventoryCount) {
		searchIndex.setInventoryCount(inventoryCount);
	}

	public String[] getPassengerTypes() {
		return searchIndex.getPassengerTypes();
	}

	public void setPassengerTypes(String[] passengerTypes) {
		searchIndex.setPassengerTypes(passengerTypes);
	}

	public String getFlightId() {
		return searchIndex.getFlightId();
	}

	public void setFlightId(String flightId) {
		searchIndex.setFlightId(flightId);
	}

	public String getDepartureTermainalBuilding() {
		return searchIndex.getDepartureTermainalBuilding();
	}

	public void setDepartureTermainalBuilding(String departureTermainalBuilding) {
		searchIndex.setDepartureTermainalBuilding(departureTermainalBuilding);
	}

	public String getArrivalTerminalBuilding() {
		return searchIndex.getArrivalTerminalBuilding();
	}

	public void setArrivalTerminalBuilding(String arrivalTerminalBuilding) {
		searchIndex.setArrivalTerminalBuilding(arrivalTerminalBuilding);
	}

	public String[] getStopCityCodes() {
		return searchIndex.getStopCityCodes();
	}

	public void setStopCityCodes(String[] stopCityCodes) {
		searchIndex.setStopCityCodes(stopCityCodes);
	}

	public String[] getStopCityNames() {
		return searchIndex.getStopCityNames();
	}

	public void setStopCityNames(String[] stopCityNames) {
		searchIndex.setStopCityNames(stopCityNames);
	}

	public String getSeatId() {
		return searchIndex.getSeatId();
	}

	public void setSeatId(String seatId) {
		searchIndex.setSeatId(seatId);
	}

	public BigDecimal getAdultFuelsurTax() {
		return searchIndex.getAdultFuelsurTax();
	}

	public void setAdultFuelsurTax(BigDecimal adultFuelsurTax) {
		searchIndex.setAdultFuelsurTax(adultFuelsurTax);
	}

	public BigDecimal getChildrenFuelsurTax() {
		return searchIndex.getChildrenFuelsurTax();
	}

	public void setChildrenFuelsurTax(BigDecimal childrenFuelsurTax) {
		searchIndex.setChildrenFuelsurTax(childrenFuelsurTax);
	}

	public BigDecimal getAdultAirportFee() {
		return searchIndex.getAdultAirportFee();
	}

	public void setAdultAirportFee(BigDecimal adultAirportFee) {
		searchIndex.setAdultAirportFee(adultAirportFee);
	}

	public BigDecimal getChildrenAirportFee() {
		return searchIndex.getChildrenAirportFee();
	}

	public void setChildrenAirportFee(BigDecimal childrenAirportFee) {
		searchIndex.setChildrenAirportFee(childrenAirportFee);
	}

	public BigDecimal getScale() {
		return searchIndex.getScale();
	}

	public void setScale(BigDecimal scale) {
		searchIndex.setScale(scale);
	}

	public BigDecimal getFixed() {
		return searchIndex.getFixed();
	}

	public void setFixed(BigDecimal fixed) {
		searchIndex.setFixed(fixed);
	}
	
	public String getDepartureAirportNameCode() {
		return searchIndex.getDepartureAirportNameCode();
	}


	public void setDepartureAirportNameCode(String departureAirportNameCode) {
		searchIndex.setDepartureAirportNameCode(departureAirportNameCode);
	}


	public String getArrivalAirportNameCode() {
		return searchIndex.getArrivalAirportNameCode();
	}

	public void setArrivalAirportNameCode(String arrivalAirportNameCode) {
		searchIndex.setArrivalAirportNameCode(arrivalAirportNameCode);
	}

	public void setFields(Map fields) {
		searchIndex.setFields(fields);
	}

	public void resetDynamicField() {
		searchIndex.resetDynamicField();
	}

	public void initDynamicBase(String dynamicBase) {
		searchIndex.initDynamicBase(dynamicBase);
	}

	public String getPricePolicyId() {
		return pricePolicyId;
	}

	public void setPricePolicyId(String pricePolicyId) {
		this.pricePolicyId = pricePolicyId;
		searchIndex.getFields().put("pricePolicyId", pricePolicyId);
	}

	public String getLvSeatClassCode() {
		return lvSeatClassCode;
	}

	public void setLvSeatClassCode(String lvSeatClassCode) {
		this.lvSeatClassCode = lvSeatClassCode;
		searchIndex.getFields().put("lvSeatClassCode", lvSeatClassCode);
	}

}
