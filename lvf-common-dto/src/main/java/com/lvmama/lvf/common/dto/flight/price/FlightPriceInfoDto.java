package com.lvmama.lvf.common.dto.flight.price;

import java.io.Serializable;
import java.math.BigDecimal;

import org.codehaus.jackson.annotate.JsonIgnore;

import com.lvmama.lvf.common.dto.Entity;
import com.lvmama.lvf.common.dto.enums.InventoryStatus;
import com.lvmama.lvf.common.dto.md.TimeSegmentRange;

/**
 * 航班运价基本信息
 * @author majun
 * @date 2015-7-13
 */
public class FlightPriceInfoDto extends Entity implements Serializable
{
	private static final long serialVersionUID = 6907223852986466904L;
	
	/** 航班运价基类 */
	private FlightPriceBase flightPriceBase = new FlightPriceBase();
	
	/**航段所属时间范围 */
	private TimeSegmentRange timeSegmentRange;
	
	/** 库存状态 */
	private InventoryStatus inventoryStatus;
	
	/** 库存数量 */
	private Integer inventoryCount;
	
	/** 票面价 */
	private BigDecimal parPrice;
	
	/** Y舱票面价 */
	private BigDecimal yParPrice;
	
	/** 折扣 */
	private BigDecimal discount;
	
	/** 供应商编码 */
	private String suppCode;
	
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

	public BigDecimal getParPrice() {
		return parPrice;
	}

	public void setParPrice(BigDecimal parPrice) {
		this.parPrice = parPrice;
	}

	public BigDecimal getyParPrice() {
		return yParPrice;
	}

	public void setyParPrice(BigDecimal yParPrice) {
		this.yParPrice = yParPrice;
	}

	public BigDecimal getDiscount() {
		return discount;
	}

	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}

	@Override
    @JsonIgnore
    public String getSequence() {
        return "S_FFLI_PRICE_INFO";
    }

	public String getSuppCode() {
		return suppCode;
	}

	public void setSuppCode(String suppCode) {
		this.suppCode = suppCode;
	}
}
