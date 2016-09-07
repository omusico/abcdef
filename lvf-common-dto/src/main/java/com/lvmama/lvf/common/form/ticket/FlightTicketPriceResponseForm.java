package com.lvmama.lvf.common.form.ticket;

import java.math.BigDecimal;
import java.util.Map;

import com.lvmama.lvf.common.dto.enums.PassengerType;
import com.lvmama.lvf.common.form.Form;

/**
 * @author chengyang 
 * 该类主要用于去核对页上的舱位的价格信息(单程、往返)
 * 
 */
public class FlightTicketPriceResponseForm implements Form{
	private BigDecimal parPrice;
	private BigDecimal salePrice;
	private Map<PassengerType,BigDecimal> fuelsurTaxMap;
	private Map<PassengerType,BigDecimal> airportFeeMap;
	public BigDecimal getParPrice() {
		return parPrice;
	}
	public void setParPrice(BigDecimal parPrice) {
		this.parPrice = parPrice;
	}
	public BigDecimal getSalePrice() {
		return salePrice;
	}
	public void setSalePrice(BigDecimal salePrice) {
		this.salePrice = salePrice;
	}
	public Map<PassengerType, BigDecimal> getFuelsurTaxMap() {
		return fuelsurTaxMap;
	}
	public void setFuelsurTaxMap(Map<PassengerType, BigDecimal> fuelsurTaxMap) {
		this.fuelsurTaxMap = fuelsurTaxMap;
	}
	public Map<PassengerType, BigDecimal> getAirportFeeMap() {
		return airportFeeMap;
	}
	public void setAirportFeeMap(Map<PassengerType, BigDecimal> airportFeeMap) {
		this.airportFeeMap = airportFeeMap;
	}
}
