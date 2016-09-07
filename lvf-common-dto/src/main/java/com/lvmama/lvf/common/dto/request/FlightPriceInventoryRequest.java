package com.lvmama.lvf.common.dto.request;

import java.io.Serializable;
import java.util.List;

import com.lvmama.lvf.common.dto.Dto;
import com.lvmama.lvf.common.dto.enums.InventoryStatus;
import com.lvmama.lvf.common.dto.md.TimeSegmentRange;
import com.lvmama.lvf.common.utils.DateUtils;
import com.lvmama.lvf.common.utils.StringUtil;
/**
 * 运价库存管理 request
 * @author zhangzongshuang
 * @date 2015年8月3日
 */
public class FlightPriceInventoryRequest implements Serializable,Dto{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7742199282937676893L;
	
	 /** 航班号*/
	 private String flightNo;
	 /** 舱位代码*/
	 private String seatClassCode; 
	 /** 出发日期*/
	 private String departureTime; 
	 /** 到达日期*/
	 private String arrivalTime;
	 private TimeSegmentRange timeSegmentRange;  
	 /** 出发城市*/
	 private String departureCityCode; 
	 /** 到达城市*/
	 private String arrivalCityCode ;
	 /** 政策主键 */
	 private Long policyId;
	 /** 运价政策主键 */
	 private Long pricePolicyId;
	 /** 供应商编码 */
	 private String suppCode;
	 /** 库存状态 */
     private InventoryStatus inventoryStatus;
     /** 供应商政策编号 */
     private String suppPolicyNo;
     /** 航班日期/毫秒数*/
	 private Long departureDate;
	 /** 航班日期/毫秒数*/
	 private String departureDateTime;
     /** 运价库存list*/
	 private List<Long> flightPriceInventoryList;
	 /** 版本号*/
	 private Long versionNo;
   
	public String getFlightNo() {
		return flightNo;
	}

	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}

	public String getSeatClassCode() {
		return seatClassCode;
	}

	public void setSeatClassCode(String seatClassCode) {
		this.seatClassCode = seatClassCode;
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

	public String getSuppCode() {
		return suppCode;
	}

	public void setSuppCode(String suppCode) {
		this.suppCode = suppCode;
	}

	public InventoryStatus getInventoryStatus() {
		return inventoryStatus;
	}

	public void setInventoryStatus(InventoryStatus inventoryStatus) {
		this.inventoryStatus = inventoryStatus;
	}

	public String getSuppPolicyNo() {
		return suppPolicyNo;
	}

	public void setSuppPolicyNo(String suppPolicyNo) {
		this.suppPolicyNo = suppPolicyNo;
	}

	public Long getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(Long departureDate) {
		this.departureDate = departureDate;
	}

	public String getDepartureDateTime() {
		return departureDateTime;
	}

	public void setDepartureDateTime(String departureDateTime) {
		this.departureDateTime = departureDateTime;
		if(StringUtil.isNotEmptyString(departureDateTime)){
			Long departureTimeLong = DateUtils.parseCnHmDate(departureDateTime+ " 00:00:00").getTime();
			this.setDepartureDate(departureTimeLong);
		}
	}

	public List<Long> getFlightPriceInventoryList() {
		return flightPriceInventoryList;
	}

	public void setFlightPriceInventoryList(List<Long> flightPriceInventoryList) {
		this.flightPriceInventoryList = flightPriceInventoryList;
	}

	@Override
	public Long getId() {
		return null;
	}

	public TimeSegmentRange getTimeSegmentRange() {
		return timeSegmentRange;
	}

	public void setTimeSegmentRange(TimeSegmentRange timeSegmentRange) {
		this.timeSegmentRange = timeSegmentRange;
	}

	public Long getVersionNo() {
		return versionNo;
	}

	public void setVersionNo(Long versionNo) {
		this.versionNo = versionNo;
	}

}
