package com.lvmama.lvf.common.dto.flight.price.index;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.codehaus.jackson.annotate.JsonIgnore;

import com.lvmama.lvf.common.solr.json.DynamicIndex;

/**
 * 每日舱位索引
 * @author ludongrui
 * @version 2016年5月26日
 */
public class LowestPriceDailyIndex extends  DynamicIndex  implements Serializable{

	private static final long serialVersionUID = 3969973768670312869L;

	private Map fields = new HashMap();
	
	private String indexId;
	
	private String departureCityCode;
	
	private String arrivalCityCode;
	
	private String departureDate;
	
	private int lowestPrice;
	
	private String priceSource;
	
	private String createTime;
	
	private String updateTime;
	
	private String departureAirportCode;
	
	private String arrivalAirportCode;
	
	private String carrierCode;
	
	private String seatClassCode;
	
	private String seatClassType;
	
	private String flightNo;
	
	private boolean isLowestPriceAvailable = true;
	
	public void setIndexId(String indexId) {
		this.indexId = indexId;
	}
	
	@Override
	@JsonIgnore
	public Map getFields() {
		if(null != indexId){
			fields.put("indexId", indexId);
		}
		return fields;
	}

	@Override
	public void setFields(Map map) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void initDynamicBase(String dynamicBase) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getIndexId() {
		return this.departureCityCode+"_"+this.arrivalCityCode+"_"+this.departureDate;
	}

	public String getDepartureCityCode() {
		return departureCityCode;
	}

	public void setDepartureCityCode(String departureCityCode) {
		fields.put("departureCityCode", departureCityCode);
		this.departureCityCode = departureCityCode;
	}

	public String getArrivalCityCode() {
		return arrivalCityCode;
	}

	public void setArrivalCityCode(String arrivalCityCode) {
		fields.put("arrivalCityCode", arrivalCityCode);
		this.arrivalCityCode = arrivalCityCode;
	}

	public String getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(String departureDate) {
		fields.put("departureDate", departureDate);
		this.departureDate = departureDate;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		fields.put("createTime", createTime);
		this.createTime = createTime;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		fields.put("updateTime", updateTime);
		this.updateTime = updateTime;
	}

	public int getLowestPrice() {
		return lowestPrice;
	}

	public void setLowestPrice(int lowestPrice) {
		fields.put("lowestPrice", lowestPrice);
		this.lowestPrice = lowestPrice;
	}

	public String getPriceSource() {
		return priceSource;
	}

	public void setPriceSource(String priceSource) {
		fields.put("priceSource", priceSource);
		this.priceSource = priceSource;
	}

	public String getDepartureAirportCode() {
		return departureAirportCode;
	}

	public void setDepartureAirportCode(String departureAirportCode) {
		fields.put("departureAirportCode", departureAirportCode);
		this.departureAirportCode = departureAirportCode;
	}

	public String getArrivalAirportCode() {
		return arrivalAirportCode;
	}

	public void setArrivalAirportCode(String arrivalAirportCode) {
		fields.put("arrivalAirportCode", arrivalAirportCode);
		this.arrivalAirportCode = arrivalAirportCode;
	}

	public String getCarrierCode() {
		return carrierCode;
	}

	public void setCarrierCode(String carrierCode) {
		fields.put("carrierCode", carrierCode);
		this.carrierCode = carrierCode;
	}

	public String getSeatClassCode() {
		return seatClassCode;
	}

	public void setSeatClassCode(String seatClassCode) {
		fields.put("seatClassCode", seatClassCode);
		this.seatClassCode = seatClassCode;
	}

	public String getSeatClassType() {
		return seatClassType;
	}

	public void setSeatClassType(String seatClassType) {
		fields.put("seatClassType", seatClassType);
		this.seatClassType = seatClassType;
	}

	public String getFlightNo() {
		return flightNo;
	}

	public void setFlightNo(String flightNo) {
		fields.put("flightNo", flightNo);
		this.flightNo = flightNo;
	}

	public boolean isLowestPriceAvailable() {
		return isLowestPriceAvailable;
	}

	public void setIsLowestPriceAvailable(boolean isLowestPriceAvailable) {
		fields.put("isLowestPriceAvailable", isLowestPriceAvailable);
		this.isLowestPriceAvailable = isLowestPriceAvailable;
	}

}
