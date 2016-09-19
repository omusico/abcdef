package com.lvmama.lvf.common.dto.flight.price;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.lvmama.lvf.common.dto.Dto;
import com.lvmama.lvf.common.dto.Entity;
import com.lvmama.lvf.common.dto.calculator.FlightTicketPriceDto;
import com.lvmama.lvf.common.dto.enums.InventoryStatus;
import com.lvmama.lvf.common.dto.md.TimeSegmentRange;

/**
 * 运价库存信息
 * @author majun
 * @date 2015-7-20
 */
public class FlightPriceInventoryDto extends Entity implements Dto, Serializable
{
	private static final long serialVersionUID = 6714695259910384783L;
	
	/** 航班运价基类 */
	private FlightPriceBase flightPriceBase = new FlightPriceBase();
	
	/**航段所属时间范围 */
	private TimeSegmentRange timeSegmentRange;
	
	/** 库存状态 */
	private InventoryStatus inventoryStatus;
	
	/** 库存数量 */
	private Integer inventoryCount;
	
	/** 票价相关信息 */
	private FlightTicketPriceDto flightTicketPriceDto;
	
	/** 供应商编码 */
    private String suppCode;

    /** 供应商政策编号 */
    private String suppPolicyNo;
    
    /** 政策主键 */
    private Long policyId;
    
    /** 运价政策主键 */
    private Long pricePolicyId;
    
    /** 用于包机切位政策*/
    private String saleType;
    
    /** 供应商编码列表，用于查询 */
    private List<String> suppCodes = new ArrayList<String>();

	private FlightPriceTicketRuleDto flightPriceTicketRuleDto;

	public String getFlightNo() {
		return flightPriceBase.getFlightNo();
	}

	public void setFlightNo(String flightNo) {
		flightPriceBase.setFlightNo(flightNo);
	}

	public String getSeatClassCode() {
		return flightPriceBase.getSeatClassCode();
	}

	public void setSeatClassCode(String seatClassCode) {
		flightPriceBase.setSeatClassCode(seatClassCode);
	}

	public String getDepartureAirportCode() {
		return flightPriceBase.getDepartureAirportCode();
	}

	public void setDepartureAirportCode(String departureAirportCode) {
		flightPriceBase.setDepartureAirportCode(departureAirportCode);
	}

	public String getArrivalAirportCode() {
		return flightPriceBase.getArrivalAirportCode();
	}

	public void setArrivalAirportCode(String arrivalAirportCode) {
		flightPriceBase.setArrivalAirportCode(arrivalAirportCode);
	}

	public String getDepartureCityCode() {
		return flightPriceBase.getDepartureCityCode();
	}

	public void setDepartureCityCode(String departureCityCode) {
		flightPriceBase.setDepartureCityCode(departureCityCode);
	}

	public String getArrivalCityCode() {
		return flightPriceBase.getArrivalCityCode();
	}

	public void setArrivalCityCode(String arrivalCityCode) {
		flightPriceBase.setArrivalCityCode(arrivalCityCode);
	}

	public Long getDepartureDate() {
		return flightPriceBase.getDepartureDate();
	}

	public void setDepartureDate(Long departureDate) {
		flightPriceBase.setDepartureDate(departureDate);
	}

	public String getLvSeatClassCode() {
		return flightPriceBase.getLvSeatClassCode();
	}

	public void setLvSeatClassCode(String lvSeatClassCode) {
		flightPriceBase.setLvSeatClassCode(lvSeatClassCode);
	}

	public TimeSegmentRange getTimeSegmentRange() {
		return timeSegmentRange;
	}

	public void setTimeSegmentRange(TimeSegmentRange timeSegmentRange) {
		this.timeSegmentRange = timeSegmentRange;
	}

	public InventoryStatus getInventoryStatus() {
		return inventoryStatus;
	}

	public void setInventoryStatus(InventoryStatus inventoryStatus) {
		this.inventoryStatus = inventoryStatus;
	}

	public Integer getInventoryCount() {
		return inventoryCount;
	}

	public void setInventoryCount(Integer inventoryCount) {
		this.inventoryCount = inventoryCount;
	}

	public FlightTicketPriceDto getFlightTicketPriceDto() {
		return flightTicketPriceDto;
	}

	public void setFlightTicketPriceDto(FlightTicketPriceDto flightTicketPriceDto) {
		this.flightTicketPriceDto = flightTicketPriceDto;
	}

	public String getSuppCode() {
		return suppCode;
	}

	public void setSuppCode(String suppCode) {
		this.suppCode = suppCode;
	}

	public String getSuppPolicyNo() {
		return suppPolicyNo;
	}

	public void setSuppPolicyNo(String suppPolicyNo) {
		this.suppPolicyNo = suppPolicyNo;
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

	public Long getVersionNo() {
		return flightPriceBase.getVersionNo();
	}

	public void setVersionNo(Long versionNo) {
		flightPriceBase.setVersionNo(versionNo);
	}

	public String getMd5Sign() {
		return flightPriceBase.getMd5Sign();
	}

	public void setMd5Sign(String md5Sign) {
		flightPriceBase.setMd5Sign(md5Sign);
	}

	public String getSaleType() {
		return saleType;
	}

	public void setSaleType(String saleType) {
		this.saleType = saleType;
	}

	public List<String> getSuppCodes() {
		return suppCodes;
	}

	public void setSuppCodes(List<String> suppCodes) {
		this.suppCodes = suppCodes;
	}

	public FlightPriceBase getFlightPriceBase() {
		return flightPriceBase;
	}

	public void setFlightPriceBase(FlightPriceBase flightPriceBase) {
		this.flightPriceBase = flightPriceBase;
	}

	public FlightPriceTicketRuleDto getFlightPriceTicketRuleDto() {
		return flightPriceTicketRuleDto;
	}

	public void setFlightPriceTicketRuleDto(FlightPriceTicketRuleDto flightPriceTicketRuleDto) {
		this.flightPriceTicketRuleDto = flightPriceTicketRuleDto;
	}
}
