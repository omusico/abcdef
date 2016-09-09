package com.lvmama.lvf.common.dto.search;

import java.io.File;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.type.TypeReference;

import com.lvmama.lvf.common.dto.enums.DirectType;
import com.lvmama.lvf.common.dto.enums.InventoryStatus;
import com.lvmama.lvf.common.solr.json.DynamicIndex;
import com.lvmama.lvf.common.solr.json.DynamicIndexConverter;
import com.lvmama.lvf.common.utils.DateUtils;
import com.lvmama.lvf.common.utils.JSONMapper;

public class FlightSearchIndex extends DynamicIndex implements Serializable {

	private Map fields = new HashMap();

	private String carrierName;//
	private String carrierCode;
	private String carrierNameCode;//
	private String carrierType;

	private String airplaneCode;
	private String airplaneName;
	private String airplaneSimpleName;
	private String airplaneType;
	private Integer airplaneMinSeats;
	private Integer airplaneMaxSeats;
	private String airplaneCompany;

	private String flightId;
	private String flightNo;
	private String flightNoNotWithCarrierCode;//
	private Integer mileages;

	private String departureAirportCode;
	private String departureAirportName;
	private String departureAirportNameCode;//
	private String departureTermainalBuilding;
	private String arrivalAirportCode;
	private String arrivalAirportName;
	private String arrivalAirportNameCode;//
	private String arrivalTerminalBuilding;
	
	private BigDecimal departureAirportLongitude;
	private BigDecimal departureAirportLatitude;
	private BigDecimal arrivalAirportLongitude;
	private BigDecimal arrivalAirportLatitude;
	

	private String departureCityCode;
	private String departureCityName;
	private String arrivalCityCode;
	private String arrivalCityName;
	private BigDecimal departureCityLongitude;
	private BigDecimal departureCityLatitude;
	private BigDecimal arrivalCityLongitude;
	private BigDecimal arrivalCityLatitude;
	

	private String departureCountryAreaCode;
	private String departureCountryAreaName;
	private String arrivalCountryAreaCode;
	private String arrivalCountryAreaName;

	private String flightSegmentType;

	private Integer stopCount;
	private String[] stopCityCodes;
	private String[] stopCityNames;
	private String[] stopAirportCodes;
	private String[] stopAirportNames;
	private String stopTime;
	private String directType;//

	private BigDecimal YParPrice;
	private BigDecimal yParPrice;

	private BigDecimal baseParPrice;

	
	private String mealType;

	private String flytime;
	private String departureTimeSegment;
	private String arrivalTimeSegment;
	private BigDecimal flyTimeHours;//

	private Boolean isShare;
	private String shareCarrierName;
	private String shareCarrierCode;
	private String shareCarrierNameCode;//
	private String shareCarrierType;
	private String shareFlightNo;

	private String flightTicketType;

	private String seatId;
	private String seatClass;
	private String seatClassType;
	private String seatLevel;
	private String seatSpecType;
	private BigDecimal discount;
	

	private String date;
	
	private String suppCode;
	
	private String suppType;

	private String selfType;
	
	private String suppPolicyId;
	
	private String policyId;

	private String inventoryType;
	
	private String[] passengerTypes;
	
	private Date departureTime;
	private Date arrivalTime;

	/**
	 * ref dynamic yyyyMMdd dynamic
	 */
	private BigDecimal adultFuelsurTax;
	/**
	 * ref dynamic yyyyMMdd dynamic
	 */
	private BigDecimal childrenFuelsurTax;
	
	/**
	 * ref dynamic yyyyMMdd dynamic
	 */
	private BigDecimal adultAirportFee;
	/**
	 * ref dynamic yyyyMMdd dynamic
	 */
	private BigDecimal childrenAirportFee;
	/**
	 * ref dynamic yyyyMMdd dynamic
	 */
	private BigDecimal inventoryCount;
	
	/**
	 * ref dynamic yyyyMMdd dynamic
	 */
	private BigDecimal parPrice;
	
	
	/**
	 * dynamic
	 */
	private String settlePrice;

	/**
	 * dynamic
	 * 
	 */
	private Long departureTimeDate;

	/**
	 * dynamic
	 */
	private Long arrivalTimeDate;

	/**
	 * dynamic 1970-1-1 HH:mm:ss to Long
	 */
	private Long departureTimeHour;

	/**
	 * dynamic 1970-1-1 HH:mm:ss to Long
	 */
	private Long arrivalTimeHour;

	/**
	 * dynamic
	 */
	private String departureTimeStr;

	/**
	 * dynamic
	 */
	private String arrivalTimeStr;

	/**
	 * dynamic
	 */
	private BigDecimal scale;
	/**
	 * dynamic
	 */
	private BigDecimal fixed;
	/**
	 * dynamic
	 */
	private InventoryStatus inventoryStatus;
	
	private String splitKey;
	
	private String indexId;
	
	private String saleType;
	
	public String getSplitKey() {
		return splitKey;
	}

	public void setSplitKey(String splitKey) {
		this.splitKey = splitKey;
	}

	public String getSuppCode() {
		return suppCode;
	}
	
	public void setSuppCode(String suppCode) {
		this.suppCode = suppCode;
		fields.put("suppCode", suppCode);
	}

	public String getSelfType() {
		return selfType;
	}

	public void setSelfType(String selfType) {
		this.selfType = selfType;
	}

	public BigDecimal getBaseParPrice() {
		return baseParPrice;
	}

	public void setBaseParPrice(BigDecimal baseParPrice) {
		this.baseParPrice = baseParPrice;
		fields.put(date + "_baseParPrice", baseParPrice);
	}

	@JsonIgnore
	public Date getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(Date departureTime) {
		this.departureTime = departureTime;
		setDepartureTimeDate(departureTime.getTime());
		setDepartureTimeHour(getTimeHour(departureTime));
		setDepartureTimeStr(DateUtils.formatDate(departureTime, DateUtils.YYYY_MM_DD_HH_MM_SS));
	}

	@JsonIgnore
	public Date getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(Date arrivalTime) {
		this.arrivalTime = arrivalTime;
		setArrivalTimeDate(arrivalTime.getTime());
		setArrivalTimeHour(getTimeHour(arrivalTime));
		setArrivalTimeStr(DateUtils.formatDate(arrivalTime, DateUtils.YYYY_MM_DD_HH_MM_SS));
	}
	
	public void setIndexId(String indexId) {
		this.indexId = indexId;
	}

	@Override
	public String getIndexId() {
		if(null!=this.indexId){
			return this.indexId;
		}
		return this.getFlightNo() + "_"+this.getDepartureCityCode()+ "_"+this.getArrivalCityCode()+ "_" + this.getSeatClass() + "_"
				+ this.getPolicyId()+ "_" +this.getSplitKey();
	}

	@Override
	@JsonIgnore
	public Map getFields() {
		fields.put("indexId",getIndexId());
		fields.put("splitKey",getSplitKey());
		return fields;
	}

	public String getCarrierNameCode() {
		return carrierNameCode;
	}

	public void setCarrierNameCode(String carrierNameCode) {
		this.carrierNameCode = carrierNameCode;
		fields.put("carrierNameCode",carrierNameCode);
	}

	public String getShareCarrierNameCode() {
		return shareCarrierNameCode;
	}

	public void setShareCarrierNameCode(String shareCarrierNameCode) {
		this.shareCarrierNameCode = shareCarrierNameCode;
		fields.put("shareCarrierNameCode",shareCarrierNameCode);
	}

	public String getPolicyId() {
		return policyId;
	}

	public void setPolicyId(String policyId) {
		this.policyId = policyId;
        fields.put("policyId", policyId);
	}

	public String getCarrierName() {
		return carrierName;
	}

	public void setCarrierName(String carrierName) {
		this.carrierName = carrierName;
		fields.put("carrierName", carrierName);
	}

	public String getCarrierCode() {
		return carrierCode;
	}

	public void setCarrierCode(String carrierCode) {
		this.carrierCode = carrierCode;
		fields.put("carrierCode", carrierCode);
	}

	public String getCarrierType() {
		return carrierType;
	}

	public void setCarrierType(String carrierType) {
		this.carrierType = carrierType;
		fields.put("carrierType", carrierType);
	}

	public String getAirplaneCode() {
		return airplaneCode;
	}

	public void setAirplaneCode(String airplaneCode) {
		this.airplaneCode = airplaneCode;
		fields.put("airplaneCode", airplaneCode);
	}

	public String getAirplaneName() {
		return airplaneName;
	}

	public void setAirplaneName(String airplaneName) {
		this.airplaneName = airplaneName;
		fields.put("airplaneName", airplaneName);
	}
	public String getAirplaneSimpleName() {
		return airplaneSimpleName;
	}

	public void setAirplaneSimpleName(String airplaneSimpleName) {
		this.airplaneSimpleName = airplaneSimpleName;
		fields.put("airplaneSimpleName", airplaneSimpleName);
	}
	public String getAirplaneType() {
		return airplaneType;
	}

	public void setAirplaneType(String airplaneType) {
		this.airplaneType = airplaneType;
		fields.put("airplaneType", airplaneType);
	}

	public Integer getAirplaneMinSeats() {
		return airplaneMinSeats;
	}

	public void setAirplaneMinSeats(Integer airplaneMinSeats) {
		this.airplaneMinSeats = airplaneMinSeats;
		fields.put("airplaneMinSeats", airplaneMinSeats);
	}

	public Integer getAirplaneMaxSeats() {
		return airplaneMaxSeats;
	}

	public void setAirplaneMaxSeats(Integer airplaneMaxSeats) {
		this.airplaneMaxSeats = airplaneMaxSeats;
		fields.put("airplaneMaxSeats", airplaneMaxSeats);
	}

	public String getAirplaneCompany() {
		return airplaneCompany;
	}

	public void setAirplaneCompany(String airplaneCompany) {
		this.airplaneCompany = airplaneCompany;
		fields.put("airplaneCompany", airplaneCompany);
	}

	public String getFlightNo() {
		return flightNo;
	}

	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
		fields.put("flightNo", flightNo);
		if(StringUtils.isNotEmpty(flightNo)){
			this.setFlightNoNotWithCarrierCode(flightNo.substring(0,2));
		}
	}

	public String getFlightNoNotWithCarrierCode() {
		return flightNoNotWithCarrierCode;
	}

	public void setFlightNoNotWithCarrierCode(String flightNoNotWithCarrierCode) {
		this.flightNoNotWithCarrierCode = flightNoNotWithCarrierCode;
		fields.put("flightNoNotWithCarrierCode", flightNoNotWithCarrierCode);
	}

	public Integer getMileages() {
		return mileages;
	}

	public void setMileages(Integer mileages) {
		this.mileages = mileages;
		fields.put("mileages", mileages);
	}

	public String getDepartureAirportCode() {
		return departureAirportCode;
	}

	public void setDepartureAirportCode(String departureAirportCode) {
		this.departureAirportCode = departureAirportCode;
		fields.put("departureAirportCode", departureAirportCode);
	}

	public String getDepartureAirportName() {
		return departureAirportName;
	}

	public void setDepartureAirportName(String departureAirportName) {
		this.departureAirportName = departureAirportName;
		fields.put("departureAirportName", departureAirportName);
	}
	
	public String getDepartureAirportNameCode() {
		return departureAirportNameCode;
	}

	public void setDepartureAirportNameCode(String departureAirportNameCode) {
		this.departureAirportNameCode = departureAirportNameCode;
		fields.put("departureAirportNameCode", departureAirportNameCode);
	}

	public String getArrivalAirportCode() {
		return arrivalAirportCode;
	}

	public void setArrivalAirportCode(String arrivalAirportCode) {
		this.arrivalAirportCode = arrivalAirportCode;
		fields.put("arrivalAirportCode", arrivalAirportCode);
	}

	public String getArrivalAirportName() {
		return arrivalAirportName;
	}

	public void setArrivalAirportName(String arrivalAirportName) {
		this.arrivalAirportName = arrivalAirportName;
		fields.put("arrivalAirportName", arrivalAirportName);
	}


	public String getArrivalAirportNameCode() {
		return arrivalAirportNameCode;
	}

	public void setArrivalAirportNameCode(String arrivalAirportNameCode) {
		this.arrivalAirportNameCode = arrivalAirportNameCode;
		fields.put("arrivalAirportNameCode", arrivalAirportNameCode);
	}

	public BigDecimal getDepartureAirportLongitude() {
		return departureAirportLongitude;
	}

	public void setDepartureAirportLongitude(BigDecimal departureAirportLongitude) {
		this.departureAirportLongitude = departureAirportLongitude;
		fields.put("departureAirportLongitude", departureAirportLongitude);
	}

	public BigDecimal getDepartureAirportLatitude() {
		return departureAirportLatitude;
	}

	public void setDepartureAirportLatitude(BigDecimal departureAirportLatitude) {
		this.departureAirportLatitude = departureAirportLatitude;
		fields.put("departureAirportLatitude", departureAirportLatitude);
	}

	public BigDecimal getArrivalAirportLongitude() {
		return arrivalAirportLongitude;
	}

	public void setArrivalAirportLongitude(BigDecimal arrivalAirportLongitude) {
		this.arrivalAirportLongitude = arrivalAirportLongitude;
		fields.put("arrivalAirportLongitude", arrivalAirportLongitude);
	}

	public BigDecimal getArrivalAirportLatitude() {
		return arrivalAirportLatitude;
	}

	public void setArrivalAirportLatitude(BigDecimal arrivalAirportLatitude) {
		this.arrivalAirportLatitude = arrivalAirportLatitude;
		fields.put("arrivalAirportLatitude", arrivalAirportLatitude);
	}

	public String getDepartureCityCode() {
		return departureCityCode;
	}

	public void setDepartureCityCode(String departureCityCode) {
		this.departureCityCode = departureCityCode;
		fields.put("departureCityCode", departureCityCode);
	}

	public String getDepartureCityName() {
		return departureCityName;
	}

	public void setDepartureCityName(String departureCityName) {
		this.departureCityName = departureCityName;
		fields.put("departureCityName", departureCityName);
	}

	public String getArrivalCityCode() {
		return arrivalCityCode;
	}

	public void setArrivalCityCode(String arrivalCityCode) {
		this.arrivalCityCode = arrivalCityCode;
		fields.put("arrivalCityCode", arrivalCityCode);
	}

	public String getArrivalCityName() {
		return arrivalCityName;
	}

	public void setArrivalCityName(String arrivalCityName) {
		this.arrivalCityName = arrivalCityName;
		fields.put("arrivalCityName", arrivalCityName);
	}

	
	public BigDecimal getDepartureCityLongitude() {
		return departureCityLongitude;
	}

	public void setDepartureCityLongitude(BigDecimal departureCityLongitude) {
		this.departureCityLongitude = departureCityLongitude;
		fields.put("departureCityLongitude", departureCityLongitude);
	}

	public BigDecimal getDepartureCityLatitude() {
		return departureCityLatitude;
	}

	public void setDepartureCityLatitude(BigDecimal departureCityLatitude) {
		this.departureCityLatitude = departureCityLatitude;
		fields.put("departureCityLatitude", departureCityLatitude);
	}

	public BigDecimal getArrivalCityLongitude() {
		return arrivalCityLongitude;
	}

	public void setArrivalCityLongitude(BigDecimal arrivalCityLongitude) {
		this.arrivalCityLongitude = arrivalCityLongitude;
		fields.put("arrivalCityLongitude", arrivalCityLongitude);
	}

	public BigDecimal getArrivalCityLatitude() {
		return arrivalCityLatitude;
	}

	public void setArrivalCityLatitude(BigDecimal arrivalCityLatitude) {
		this.arrivalCityLatitude = arrivalCityLatitude;
		fields.put("arrivalCityLatitude", arrivalCityLatitude);
	}

	public String getDepartureCountryAreaCode() {
		return departureCountryAreaCode;
	}

	public void setDepartureCountryAreaCode(String departureCountryAreaCode) {
		this.departureCountryAreaCode = departureCountryAreaCode;
		fields.put("departureCountryAreaCode", departureCountryAreaCode);
	}

	public String getDepartureCountryAreaName() {
		return departureCountryAreaName;
	}

	public void setDepartureCountryAreaName(String departureCountryAreaName) {
		this.departureCountryAreaName = departureCountryAreaName;
		fields.put("departureCountryAreaName", departureCountryAreaName);
	}

	public String getArrivalCountryAreaCode() {
		return arrivalCountryAreaCode;
	}

	public void setArrivalCountryAreaCode(String arrivalCountryAreaCode) {
		this.arrivalCountryAreaCode = arrivalCountryAreaCode;
		fields.put("arrivalCountryAreaCode", arrivalCountryAreaCode);
	}

	public String getArrivalCountryAreaName() {
		return arrivalCountryAreaName;
	}

	public void setArrivalCountryAreaName(String arrivalCountryAreaName) {
		this.arrivalCountryAreaName = arrivalCountryAreaName;
		fields.put("arrivalCountryAreaName", arrivalCountryAreaName);
	}

	public String getFlightSegmentType() {
		return flightSegmentType;
	}

	public void setFlightSegmentType(String flightSegmentType) {
		this.flightSegmentType = flightSegmentType;
		fields.put("flightSegmentType", flightSegmentType);
	}

	public Integer getStopCount() {
		return stopCount;
	}

	public void setStopCount(Integer stopCount) {
		this.stopCount = (null==stopCount?0:stopCount);
		fields.put("stopCount", stopCount);
		setDirectType(this.stopCount>0?DirectType.NOT_DIRECT.name():DirectType.DIRECT.name());
	}

	public String[] getStopAirportCodes() {
		return stopAirportCodes;
	}

	public void setStopAirportCodes(String[] stopAirportCodes) {
		this.stopAirportCodes = stopAirportCodes;
		fields.put("stopAirportCodes", stopAirportCodes);
	}

	public String[] getStopAirportNames() {
		return stopAirportNames;
	}

	public void setStopAirportNames(String[] stopAirportNames) {
		this.stopAirportNames = stopAirportNames;
		fields.put("stopAirportNames", stopAirportNames);
	}

	public String getStopTime() {
		return stopTime;
	}

	public void setStopTime(String stopTime) {
		this.stopTime = stopTime;
		fields.put("stopTime", stopTime);
	}

	public String getDirectType() {
		return directType;
	}

	public void setDirectType(String directType) {
		this.directType = directType;
		fields.put("directType", directType);
	}

	public BigDecimal getYParPrice() {
		this.YParPrice = this.getyParPrice();
		return YParPrice;
	}

	public void setYParPrice(BigDecimal yParPrice) {
		YParPrice = yParPrice;
		fields.put("yParPrice", YParPrice);
	}
	
	public BigDecimal getyParPrice() {
		return yParPrice;
	}

	public void setyParPrice(BigDecimal yParPrice) {
		this.yParPrice = yParPrice;
	}

	public String getMealType() {
		return mealType;
	}

	public void setMealType(String mealType) {
		this.mealType = mealType;
		fields.put("mealType", mealType);
	}

	public String getFlytime() {
		return flytime;
	}

	public void setFlytime(String flytime) {
		this.flytime = flytime;
		fields.put("flytime", flytime);
	}

	public String getDepartureTimeSegment() {
		return departureTimeSegment;
	}

	public void setDepartureTimeSegment(String departureTimeSegment) {
		this.departureTimeSegment = departureTimeSegment;
		fields.put("departureTimeSegment", departureTimeSegment);
	}

	public String getArrivalTimeSegment() {
		return arrivalTimeSegment;
	}

	public void setArrivalTimeSegment(String arrivalTimeSegment) {
		this.arrivalTimeSegment = arrivalTimeSegment;
		fields.put("arrivalTimeSegment", arrivalTimeSegment);
	}

	public BigDecimal getFlyTimeHours() {
		return flyTimeHours;
	}

	public void setFlyTimeHours(BigDecimal flyTimeHours) {
		this.flyTimeHours = flyTimeHours;
		fields.put("flyTimeHours", flyTimeHours);
	}

	public Boolean getIsShare() {
		return isShare;
	}

	public void setIsShare(Boolean isShare) {
		this.isShare = isShare;
		fields.put("isShare", isShare);
	}

	public String getShareCarrierName() {
		return shareCarrierName;
	}

	public void setShareCarrierName(String shareCarrierName) {
		this.shareCarrierName = shareCarrierName;
		fields.put("shareCarrierName", shareCarrierName);
	}

	public String getShareCarrierCode() {
		return shareCarrierCode;
	}

	public void setShareCarrierCode(String shareCarrierCode) {
		this.shareCarrierCode = shareCarrierCode;
		fields.put("shareCarrierCode", shareCarrierCode);
	}

	public String getShareCarrierType() {
		return shareCarrierType;
	}

	public void setShareCarrierType(String shareCarrierType) {
		this.shareCarrierType = shareCarrierType;
		fields.put("shareCarrierType", shareCarrierType);
	}

	public String getShareFlightNo() {
		return shareFlightNo;
	}

	public void setShareFlightNo(String shareFlightNo) {
		this.shareFlightNo = shareFlightNo;
		fields.put("shareFlightNo", shareFlightNo);
	}

	public String getFlightTicketType() {
		return flightTicketType;
	}

	public void setFlightTicketType(String flightTicketType) {
		this.flightTicketType = flightTicketType;
		fields.put("flightTicketType", flightTicketType);
	}

	public String getSeatClass() {
		return seatClass;
	}

	public void setSeatClass(String seatClass) {
		this.seatClass = seatClass;
		fields.put("seatClass", seatClass);
	}

	public String getSeatClassType() {
		return seatClassType;
	}

	public void setSeatClassType(String seatClassType) {
		this.seatClassType = seatClassType;
		fields.put("seatClassType", seatClassType);
	}

	public String getSeatLevel() {
		return seatLevel;
	}

	public void setSeatLevel(String seatLevel) {
		this.seatLevel = seatLevel;
		fields.put("seatLevel", seatLevel);
	}

	public String getSeatSpecType() {
		return seatSpecType;
	}

	public void setSeatSpecType(String seatSpecType) {
		this.seatSpecType = seatSpecType;
		fields.put("seatSpecType", seatSpecType);
	}

	public BigDecimal getDiscount() {
		return discount;
	}

	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
		fields.put("discount", discount);
	}

	public BigDecimal getParPrice() {
		return parPrice;
	}

	public void setParPrice(BigDecimal parPrice) {
		this.parPrice = parPrice;
		fields.put(date + "_parPrice", parPrice);
	}

	public String getSettlePrice() {
		return settlePrice;
	}

	public void setSettlePrice(String settlePrice) {
		this.settlePrice = settlePrice;
		fields.put(date + "_settlePrice", settlePrice);
	}

	@JsonIgnore
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Long getDepartureTimeDate() {
		return departureTimeDate;
	}

	/**
	 */
	public void setDepartureTimeDate(Long departureTimeDate) {
		this.departureTimeDate = departureTimeDate;
		this.date = DateUtils.formatDate(new Date(departureTimeDate),
				"yyyyMMdd");
		fields.put("date", date);
		fields.put(date + "_departureDate", date);
		fields.put(date + "_departureTimeDate", departureTimeDate);
	}

	public Long getArrivalTimeDate() {
		return arrivalTimeDate;
	}

	public void setArrivalTimeDate(Long arrivalTimeDate) {
		this.arrivalTimeDate = arrivalTimeDate;
		fields.put(date + "_arrivalTimeDate", arrivalTimeDate);
	}

	public Long getDepartureTimeHour() {
		return departureTimeHour;
	}

	public void setDepartureTimeHour(Long departureTimeHour) {
		this.departureTimeHour = departureTimeHour;
		fields.put(date + "_departureTimeHour", departureTimeHour);
	}

	public Long getArrivalTimeHour() {
		return arrivalTimeHour;
	}

	public void setArrivalTimeHour(Long arrivalTimeHour) {
		this.arrivalTimeHour = arrivalTimeHour;
		fields.put(date + "_arrivalTimeHour", arrivalTimeHour);
	}

	public String getDepartureTimeStr() {
		return departureTimeStr;
	}

	public void setDepartureTimeStr(String departureTimeStr) {
		this.departureTimeStr = departureTimeStr;
		fields.put(date + "_departureTimeStr", departureTimeStr);
	}

	public String getArrivalTimeStr() {
		return arrivalTimeStr;
	}

	public void setArrivalTimeStr(String arrivalTimeStr) {
		this.arrivalTimeStr = arrivalTimeStr;
		fields.put(date + "_arrivalTimeStr", arrivalTimeStr);
	}

	public String getSuppType() {
		return suppType;
	}

	public void setSuppType(String suppType) {
		this.suppType = suppType;
		fields.put("suppType", suppType);
	}

	public String getSuppPolicyId() {
		return suppPolicyId;
	}

	public void setSuppPolicyId(String suppPolicyId) {
		this.suppPolicyId = suppPolicyId;
		fields.put("suppPolicyId", suppPolicyId);
	}

	public String getInventoryType() {
		return inventoryType;
	}

	public void setInventoryType(String inventoryType) {
		this.inventoryType = inventoryType;
		fields.put("inventoryType", inventoryType);
	}

	public InventoryStatus getInventoryStatus() {
		return inventoryStatus;
	}

	public void setInventoryStatus(InventoryStatus inventoryStatus) {
		this.inventoryStatus = inventoryStatus;
		fields.put(date + "_inventoryStatus", inventoryStatus);
	}

	public BigDecimal getInventoryCount() {
		return inventoryCount;
	}

	public void setInventoryCount(BigDecimal inventoryCount) {
		this.inventoryCount = inventoryCount;
		fields.put(date + "_inventoryCount", inventoryCount);
	}

	public String[] getPassengerTypes() {
		return passengerTypes;
	}

	public void setPassengerTypes(String[] passengerTypes) {
		this.passengerTypes = passengerTypes;
		fields.put("passengerTypes", passengerTypes);
	}
	
	public String getFlightId() {
		return flightId;
	}

	public void setFlightId(String flightId) {
		this.flightId = flightId;
		fields.put("flightId", flightId);
	}

	public String getDepartureTermainalBuilding() {
		return departureTermainalBuilding;
	}

	public void setDepartureTermainalBuilding(String departureTermainalBuilding) {
		this.departureTermainalBuilding = departureTermainalBuilding;
		fields.put("departureTermainalBuilding", departureTermainalBuilding);
	}

	public String getArrivalTerminalBuilding() {
		return arrivalTerminalBuilding;
	}

	public void setArrivalTerminalBuilding(String arrivalTerminalBuilding) {
		this.arrivalTerminalBuilding = arrivalTerminalBuilding;
		fields.put("arrivalTerminalBuilding", arrivalTerminalBuilding);
	}

	public String[] getStopCityCodes() {
		return stopCityCodes;
	}

	public void setStopCityCodes(String[] stopCityCodes) {
		this.stopCityCodes = stopCityCodes;
		fields.put("stopCityCodes", stopCityCodes);
	}

	public String[] getStopCityNames() {
		return stopCityNames;
	}

	public void setStopCityNames(String[] stopCityNames) {
		this.stopCityNames = stopCityNames;
		fields.put("stopCityNames", stopCityCodes);
	}

	public String getSeatId() {
		return seatId;
	}

	public void setSeatId(String seatId) {
		this.seatId = seatId;
		fields.put("seatId", seatId);
	}

	public BigDecimal getAdultFuelsurTax() {
		return adultFuelsurTax;
	}

	public void setAdultFuelsurTax(BigDecimal adultFuelsurTax) {
		this.adultFuelsurTax = adultFuelsurTax;
		fields.put(date + "_adultFuelsurTax", adultFuelsurTax);
	}

	public BigDecimal getChildrenFuelsurTax() {
		return childrenFuelsurTax;
	}

	public void setChildrenFuelsurTax(BigDecimal childrenFuelsurTax) {
		this.childrenFuelsurTax = childrenFuelsurTax;
		fields.put(date + "_childrenFuelsurTax", childrenFuelsurTax);
	}

	public BigDecimal getAdultAirportFee() {
		return adultAirportFee;
	}

	public void setAdultAirportFee(BigDecimal adultAirportFee) {
		this.adultAirportFee = adultAirportFee;
		fields.put(date + "_adultAirportFee", adultAirportFee);
	}

	public BigDecimal getChildrenAirportFee() {
		return childrenAirportFee;
	}

	public void setChildrenAirportFee(BigDecimal childrenAirportFee) {
		this.childrenAirportFee = childrenAirportFee;
		fields.put(date + "_childrenAirportFee", childrenAirportFee);
	}

	public BigDecimal getScale() {
		return scale;
	}

	public void setScale(BigDecimal scale) {
		this.scale = scale;
		fields.put(date+"_scale", scale);
	}

	public BigDecimal getFixed() {
		return fixed;
	}

	public void setFixed(BigDecimal fixed) {
		this.fixed = fixed;
		fields.put(date+"_fixed", fixed);
	}

	public void setFields(Map fields) {
		this.fields = fields;
		resetDynamicField();
	}
	
	public void copyFields(Map fields) {
		this.fields = fields;
	}

	public FlightSearchIndex(Long departureTimeDate) {
		super();
		setDepartureTimeDate(departureTimeDate);
	}

	public FlightSearchIndex() {
		super();
	}
	
	public void resetDynamicField(){
		
		//TODO 根据date重设动态字段
		if(StringUtils.isNotEmpty(this.getDate())){
			this.setParPrice(getBigDecimal(this.getFields().get(this.getDate()+"_parPrice")));
			this.setSettlePrice((String)this.getFields().get(this.getDate()+"_settlePrice"));
			this.setBaseParPrice(getBigDecimal(this.getFields().get(this.getDate()+"_baseParPrice")));
			this.setAdultFuelsurTax(getBigDecimal(this.getFields().get(this.getDate()+"_adultFuelsurTax")));
			this.setChildrenFuelsurTax(getBigDecimal(this.getFields().get(this.getDate()+"_childrenFuelsurTax")));
			this.setAdultAirportFee(getBigDecimal(this.getFields().get(this.getDate()+"_adultAirportFee")));
			this.setChildrenAirportFee(getBigDecimal(this.getFields().get(this.getDate()+"_childrenAirportFee")));
			this.setInventoryCount(getBigDecimal(this.getFields().get(this.getDate()+"_inventoryCount")));
			
			this.setDepartureTimeDate((Long)this.getFields().get(this.getDate()+"_departureTimeDate"));
	        this.setArrivalTimeDate((Long)this.getFields().get(this.getDate()+"_arrivalTimeDate"));
	        this.setDepartureTimeHour(Long.parseLong(this.getFields().get(this.getDate()+"_departureTimeHour").toString()));
	        this.setArrivalTimeHour(Long.parseLong(this.getFields().get(this.getDate()+"_arrivalTimeHour").toString()));
	        this.setDepartureTimeStr((String)this.getFields().get(this.getDate()+"_departureTimeStr"));
	        this.setArrivalTimeStr((String)this.getFields().get(this.getDate()+"_arrivalTimeStr"));
			this.setScale(getBigDecimal(this.getFields().get(this.getDate()+"_scale")));
	        this.setFixed(getBigDecimal(this.getFields().get(this.getDate()+"_fixed")));
	        this.setInventoryStatus(null!=this.getFields().get(this.getDate()+"_inventoryStatus")?
	        	InventoryStatus.valueOf(this.getFields().get(this.getDate()+"_inventoryStatus").toString())
	        	:null);
		}

	}
	
	public static BigDecimal getBigDecimal( Object value ) {  
        BigDecimal ret = null;  
        if( value != null ) {  
            if( value instanceof BigDecimal ) {  
                ret = (BigDecimal) value;  
            } else if( value instanceof String ) {  
                ret = new BigDecimal( (String) value );  
            } else {
            	try{
            		ret = new BigDecimal(value+"");  
            	}catch(Exception ex){
                    throw new ClassCastException("Not possible to coerce ["+value+"] from class "+value.getClass()+" into a BigDecimal.");  
            	}
            }  
        }  
        return ret;  
    }  
	

	/**
	 * 获取时分秒时间Long时间
	 * @param date
	 * @return
	 */
	private static Long getTimeHour(Date date){
		String HHmmssStr = DateUtils.formatDate(date, DateUtils.HH_mm_ss);
		return DateUtils.parseDate(DateUtils.INIT_DATE+" "+HHmmssStr, DateUtils.YYYY_MM_DD_HH_MM_SS).getTime();
	} 

	@Override
	public void initDynamicBase(String dynamicBase) {
		this.date=dynamicBase;
	}

	public String getSaleType() {
		return saleType;
	}

	public void setSaleType(String saleType) {
		this.saleType = saleType;
		fields.put("saleType", saleType);
	}
	
	
    
}
