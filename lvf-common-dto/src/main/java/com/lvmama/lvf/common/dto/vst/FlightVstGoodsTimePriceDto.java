/**
 * 
 */
package com.lvmama.lvf.common.dto.vst;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.lvmama.lvf.common.dto.VSTEntity;
import com.lvmama.lvf.common.dto.enums.SeatClassType;

/**
 * VST商品时间价格
 * @author lven
 *
 */
public class FlightVstGoodsTimePriceDto extends VSTEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long vstGoodsId;
	
	private Long departureDate;//出发日期，yyyy-MM-dd
	
	private String flightNo;
	
	private String flightSeatCode;

	private String md5Sign;
	
	/** 起飞时间 */
	private Date departureTime;
	
	/** 成人的票面价 */
	private BigDecimal parPrice;
	
	private SeatClassType seatClassType;//F,C,Y
	
	private Long flightInfoId;
	
	private BigDecimal fuelSurTax;
	
	private BigDecimal airportFee;

	private BigDecimal childrenFuelsurTax;
	
	private BigDecimal childrenAirportFee;
	
	private String departureCityCode;
	private String arrivalCityCode;
	
	private Long productBranchId;
	
	public Long getProductBranchId() {
		return productBranchId;
	}

	public void setProductBranchId(Long productBranchId) {
		this.productBranchId = productBranchId;
	}

	public Long getVstGoodsId() {
		return vstGoodsId;
	}

	public void setVstGoodsId(Long vstGoodsId) {
		this.vstGoodsId = vstGoodsId;
	}

	public Long getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(Long departureDate) {
		this.departureDate = departureDate;
	}

	public String getFlightNo() {
		return flightNo;
	}

	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}

	public String getFlightSeatCode() {
		return flightSeatCode;
	}

	public void setFlightSeatCode(String flightSeatCode) {
		this.flightSeatCode = flightSeatCode;
	}

	public String getMd5Sign() {
		return md5Sign;
	}

	public void setMd5Sign(String md5Sign) {
		this.md5Sign = md5Sign;
	}

	public Date getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(Date departureTime) {
		this.departureTime = departureTime;
	}

	public BigDecimal getParPrice() {
		return parPrice;
	}

	public void setParPrice(BigDecimal parPrice) {
		this.parPrice = parPrice;
	}

	public SeatClassType getSeatClassType() {
		return seatClassType;
	}

	public void setSeatClassType(SeatClassType seatClassType) {
		this.seatClassType = seatClassType;
	}

	public Long getFlightInfoId() {
		return flightInfoId;
	}

	public void setFlightInfoId(Long flightInfoId) {
		this.flightInfoId = flightInfoId;
	}

	public BigDecimal getFuelSurTax() {
		return fuelSurTax;
	}

	public void setFuelSurTax(BigDecimal fuelSurTax) {
		this.fuelSurTax = fuelSurTax;
	}

	public BigDecimal getAirportFee() {
		return airportFee;
	}

	public void setAirportFee(BigDecimal airportFee) {
		this.airportFee = airportFee;
	}

	public BigDecimal getChildrenFuelsurTax() {
		return childrenFuelsurTax;
	}

	public void setChildrenFuelsurTax(BigDecimal childrenFuelsurTax) {
		this.childrenFuelsurTax = childrenFuelsurTax;
	}

	public BigDecimal getChildrenAirportFee() {
		return childrenAirportFee;
	}

	public void setChildrenAirportFee(BigDecimal childrenAirportFee) {
		this.childrenAirportFee = childrenAirportFee;
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
	
}
