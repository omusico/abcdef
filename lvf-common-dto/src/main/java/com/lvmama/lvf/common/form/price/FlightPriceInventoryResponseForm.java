package com.lvmama.lvf.common.form.price;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.lvmama.lvf.common.dto.calculator.FlightTicketPriceDto;
import com.lvmama.lvf.common.dto.enums.InventoryStatus;
import com.lvmama.lvf.common.dto.flight.price.FlightPriceInventoryDto;
import com.lvmama.lvf.common.dto.md.TimeSegmentRange;
import com.lvmama.lvf.common.form.Form;
import com.lvmama.lvf.common.utils.DateUtils;
/**
 * 运价库存 ResponseForm
 * @author zhangzongshuang
 * @date 2015年8月4日
 */
public class FlightPriceInventoryResponseForm  implements Serializable, Form {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5032163479741978934L;
	
	private FlightPriceInventoryDto flightPriceInventory=new FlightPriceInventoryDto();

	public FlightPriceInventoryResponseForm(FlightPriceInventoryDto flightPriceInventory) {
		super();
		this.flightPriceInventory = flightPriceInventory;
	}

	public FlightPriceInventoryDto getFlightPriceInventory() {
		return flightPriceInventory;
	}

	public void setFlightPriceInventory(FlightPriceInventoryDto flightPriceInventory) {
		this.flightPriceInventory = flightPriceInventory;
	}

	public String getSequence() {
		return flightPriceInventory.getSequence();
	}

	public Long getId() {
		return flightPriceInventory.getId();
	}

	public void setId(Long id) {
		flightPriceInventory.setId(id);
	}

	public String getUuid() {
		return flightPriceInventory.getUuid();
	}

	public void setUuid(String uuid) {
		flightPriceInventory.setUuid(uuid);
	}

	public Date getCreateTime() {
		return flightPriceInventory.getCreateTime();
	}

	public void setCreateTime(Date createTime) {
		flightPriceInventory.setCreateTime(createTime);
	}

	public Date getUpdateTime() {
		return flightPriceInventory.getUpdateTime();
	}

	public String getFlightNo() {
		return flightPriceInventory.getFlightNo();
	}

	public void setUpdateTime(Date updateTime) {
		flightPriceInventory.setUpdateTime(updateTime);
	}

	public void setFlightNo(String flightNo) {
		flightPriceInventory.setFlightNo(flightNo);
	}

	public String getSeatClassCode() {
		return flightPriceInventory.getSeatClassCode();
	}

	public void setSeatClassCode(String seatClassCode) {
		flightPriceInventory.setSeatClassCode(seatClassCode);
	}

	public String getDepartureAirportCode() {
		return flightPriceInventory.getDepartureAirportCode();
	}

	public void setDepartureAirportCode(String departureAirportCode) {
		flightPriceInventory.setDepartureAirportCode(departureAirportCode);
	}

	public String getArrivalAirportCode() {
		return flightPriceInventory.getArrivalAirportCode();
	}

	public void setArrivalAirportCode(String arrivalAirportCode) {
		flightPriceInventory.setArrivalAirportCode(arrivalAirportCode);
	}

	public String getDepartureCityCode() {
		return flightPriceInventory.getDepartureCityCode();
	}

	public void setDepartureCityCode(String departureCityCode) {
		flightPriceInventory.setDepartureCityCode(departureCityCode);
	}

	public String getArrivalCityCode() {
		return flightPriceInventory.getArrivalCityCode();
	}

	public void setArrivalCityCode(String arrivalCityCode) {
		flightPriceInventory.setArrivalCityCode(arrivalCityCode);
	}
	
	public String getDepartureDate() {
		return  DateUtils.parseDate(flightPriceInventory.getDepartureDate(),"yyyy-MM-dd");
	}

	public void setDepartureDate(Long departureDate) {
		flightPriceInventory.setDepartureDate(departureDate);
	}

	public String getLvSeatClassCode() {
		return flightPriceInventory.getLvSeatClassCode();
	}

	public void setLvSeatClassCode(String lvSeatClassCode) {
		flightPriceInventory.setLvSeatClassCode(lvSeatClassCode);
	}

	public TimeSegmentRange getTimeSegmentRange() {
		return flightPriceInventory.getTimeSegmentRange();
	}

	public void setTimeSegmentRange(TimeSegmentRange timeSegmentRange) {
		flightPriceInventory.setTimeSegmentRange(timeSegmentRange);
	}

	public InventoryStatus getInventoryStatus() {
		return flightPriceInventory.getInventoryStatus();
	}

	public void setInventoryStatus(InventoryStatus inventoryStatus) {
		flightPriceInventory.setInventoryStatus(inventoryStatus);
	}

	public Integer getInventoryCount() {
		return flightPriceInventory.getInventoryCount();
	}

	public void setInventoryCount(Integer inventoryCount) {
		flightPriceInventory.setInventoryCount(inventoryCount);
	}

	public FlightTicketPriceDto getFlightTicketPriceDto() {
		return flightPriceInventory.getFlightTicketPriceDto();
	}

	public void setFlightTicketPriceDto(FlightTicketPriceDto flightTicketPriceDto) {
		flightPriceInventory.setFlightTicketPriceDto(flightTicketPriceDto);
	}

	public String getSuppCode() {
		return flightPriceInventory.getSuppCode();
	}

	public void setSuppCode(String suppCode) {
		flightPriceInventory.setSuppCode(suppCode);
	}

	public String getSuppPolicyNo() {
		return flightPriceInventory.getSuppPolicyNo();
	}

	public void setSuppPolicyNo(String suppPolicyNo) {
		flightPriceInventory.setSuppPolicyNo(suppPolicyNo);
	}

	public Long getPolicyId() {
		return flightPriceInventory.getPolicyId();
	}

	public void setPolicyId(Long policyId) {
		flightPriceInventory.setPolicyId(policyId);
	}

	public Long getPricePolicyId() {
		return flightPriceInventory.getPricePolicyId();
	}

	public void setPricePolicyId(Long pricePolicyId) {
		flightPriceInventory.setPricePolicyId(pricePolicyId);
	}


	public Long getVersionNo() {
		return flightPriceInventory.getVersionNo();
	}

	public void setVersionNo(Long versionNo) {
		flightPriceInventory.setVersionNo(versionNo);
	}

	public String getMd5Sign() {
		return flightPriceInventory.getMd5Sign();
	}

	public void setMd5Sign(String md5Sign) {
		flightPriceInventory.setMd5Sign(md5Sign);
	}

	public String getDepartureTime() {
		if(flightPriceInventory.getTimeSegmentRange()!=null){
			return DateUtils.formatTime(flightPriceInventory.getTimeSegmentRange().getDepartureTime());
		}
		return "";
	}
	
	public String getArrivalTime() {
		if(flightPriceInventory.getTimeSegmentRange()!=null){
			return DateUtils.formatTime(flightPriceInventory.getTimeSegmentRange().getArrivalTime());
		}
		return "";
	}

	public BigDecimal getSettlePrice() {
		if(flightPriceInventory.getFlightTicketPriceDto()!=null){
			return flightPriceInventory.getFlightTicketPriceDto().getSettlePrice();
		}
		return null;
	}
	
	public BigDecimal getParPrice() {
		if(flightPriceInventory.getFlightTicketPriceDto()!=null){
			return flightPriceInventory.getFlightTicketPriceDto().getParPrice();
		}
		return null;
	}
	
	public BigDecimal getYParPrice() {
		if(flightPriceInventory.getFlightTicketPriceDto()!=null){
			return flightPriceInventory.getFlightTicketPriceDto().getYParPrice();
		}
		return null;
	}
	

}
