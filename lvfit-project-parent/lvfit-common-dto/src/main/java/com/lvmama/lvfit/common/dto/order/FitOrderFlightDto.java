package com.lvmama.lvfit.common.dto.order;

import java.math.BigDecimal;

import com.lvmama.lvf.common.dto.Entity;
import com.lvmama.lvfit.common.dto.enums.FlightTripType;
import com.lvmama.lvfit.common.dto.enums.ProductResource;
import com.lvmama.lvfit.common.dto.md.Airplane;

public class FitOrderFlightDto extends Entity {

    private static final long serialVersionUID = -993333274047804494L;

    /** 航班号 */
    private String flightNo;

    /** 出发机场Code */
    private String departureAirportCode;

    /** 出发机场名称 */
    private String departureAirportName;

    /** 去程城市code*/
    private String departureCityCode;

    /** 出发城市名称 */
    private String departureCityName;

    /** 出发机场航站楼 */
    private String departureTermainalBuilding;

    /** 出发日期 */
    private String departureDate;

    /** 出发时间 */
    private String departureTime;

    /** 到达机场Code */
    private String arrivalAirportCode;

    /** 到达机场名称 */
    private String arrivalAirportName;

    /** 返程城市code */
    private String arrivalCityCode;

    /** 到达城市名称 */
    private String arrivalCityName;

    /** 到达机场航站楼 */
    private String arrivalTerminalBuilding;

    private String arrivalDate;

    //销售类型.包机切位.
    private String saleType;
    
    /** 到达时间 */
    private String arrivalTime;

    /**飞行时长（单位：分钟数） */
    private String flyTimeMins;

    /**舱位Code */
    private String seatClassCode;

    /**舱位类型 */
    private String seatClassType;

    /**舱位类型 */
    private String seatClassTypeName;

    /** 销售价 */
    private BigDecimal salesPrice;

    /** 票面价 */
    private BigDecimal parPrice;

    /** 机场建设费 */
    private BigDecimal airportFee;

    /** 燃油税 */
    private BigDecimal fuelsurTax;

    /** 价格政策ID */
    private Long pricePolicyId;

    /** 供应商 */
    private String suppCode;

    /** 供应商政策ID */
    private String suppPolicyNo;

    private FlightTripType tripType;


    private ProductResource productResource;

    /** 成人单价 */
    private BigDecimal adultPrice;

    /** 儿童单价 */
    private BigDecimal childPrice;

    /** 经停次数 */
    private Integer stopCount;

    /** 航空公司名称 */
    private String carrierName;

    /**机型信息 */
    private Airplane airplane;

    public String createProductName() {
        return this.getDepartureCityName() + this.getDepartureAirportName() + " - " +
                this.getArrivalCityName() + this.getArrivalAirportName() + " " + this.getFlightNo() + " " + this.getSeatClassTypeName() + " " + this.getSeatClassCode() + "舱";
    }

    public String getFlightNo() {
        return flightNo;
    }

    public void setFlightNo(String flightNo) {
        this.flightNo = flightNo;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(String arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getDepartureCityName() {
        return departureCityName;
    }

    public void setDepartureCityName(String departureCityName) {
        this.departureCityName = departureCityName;
    }

    public String getDepartureAirportCode() {
        return departureAirportCode;
    }

    public void setDepartureAirportCode(String departureAirportCode) {
        this.departureAirportCode = departureAirportCode;
    }

    public String getArrivalCityName() {
        return arrivalCityName;
    }

    public void setArrivalCityName(String arrivalCityName) {
        this.arrivalCityName = arrivalCityName;
    }

    public String getArrivalAirportCode() {
        return arrivalAirportCode;
    }

    
    public String getSaleType() {
		return saleType;
	}

	public void setSaleType(String saleType) {
		this.saleType = saleType;
	}

	public void setArrivalAirportCode(String arrivalAirportCode) {
        this.arrivalAirportCode = arrivalAirportCode;
    }

    public String getFlyTimeMins() {
        return flyTimeMins;
    }

    public void setFlyTimeMins(String flyTimeMins) {
        this.flyTimeMins = flyTimeMins;
    }

    public String getSeatClassType() {
        return seatClassType;
    }

    public void setSeatClassType(String seatClassType) {
        this.seatClassType = seatClassType;
    }

    public String getSeatClassTypeName() {
        return seatClassTypeName;
    }

    public void setSeatClassTypeName(String seatClassTypeName) {
        this.seatClassTypeName = seatClassTypeName;
    }

    public BigDecimal getSalesPrice() {
        return salesPrice;
    }

    public void setSalesPrice(BigDecimal salesPrice) {
        this.salesPrice = salesPrice;
    }

    public BigDecimal getParPrice() {
        return parPrice;
    }

    public void setParPrice(BigDecimal parPrice) {
        this.parPrice = parPrice;
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

    public String getSuppPolicyNo() {
        return suppPolicyNo;
    }

    public void setSuppPolicyNo(String suppPolicyNo) {
        this.suppPolicyNo = suppPolicyNo;
    }

    public FlightTripType getTripType() {
        return tripType;
    }

    public void setTripType(FlightTripType tripType) {
        this.tripType = tripType;
    }

    public ProductResource getProductResource() {
        return productResource;
    }

    public void setProductResource(ProductResource productResource) {
        this.productResource = productResource;
    }

    public String getSeatClassCode() {
        return seatClassCode;
    }

    public void setSeatClassCode(String seatClassCode) {
        this.seatClassCode = seatClassCode;
    }

    public String getDepartureAirportName() {
        return departureAirportName;
    }

    public void setDepartureAirportName(String departureAirportName) {
        this.departureAirportName = departureAirportName;
    }

    public String getDepartureCityCode() {
        return departureCityCode;
    }

    public void setDepartureCityCode(String departureCityCode) {
        this.departureCityCode = departureCityCode;
    }

    public String getDepartureTermainalBuilding() {
        return departureTermainalBuilding;
    }

    public void setDepartureTermainalBuilding(String departureTermainalBuilding) {
        this.departureTermainalBuilding = departureTermainalBuilding;
    }

    public String getArrivalAirportName() {
        return arrivalAirportName;
    }

    public void setArrivalAirportName(String arrivalAirportName) {
        this.arrivalAirportName = arrivalAirportName;
    }

    public String getArrivalCityCode() {
        return arrivalCityCode;
    }

    public void setArrivalCityCode(String arrivalCityCode) {
        this.arrivalCityCode = arrivalCityCode;
    }

    public String getArrivalTerminalBuilding() {
        return arrivalTerminalBuilding;
    }

    public void setArrivalTerminalBuilding(String arrivalTerminalBuilding) {
        this.arrivalTerminalBuilding = arrivalTerminalBuilding;
    }

    public BigDecimal getAdultPrice() {
        return adultPrice;
    }

    public void setAdultPrice(BigDecimal adultPrice) {
        this.adultPrice = adultPrice;
    }

    public BigDecimal getChildPrice() {
        return childPrice;
    }

    public void setChildPrice(BigDecimal childPrice) {
        this.childPrice = childPrice;
    }

    public Integer getStopCount() {
        return stopCount;
    }

    public void setStopCount(Integer stopCount) {
        this.stopCount = stopCount;
    }

    public String getCarrierName() {
        return carrierName;
    }

    public void setCarrierName(String carrierName) {
        this.carrierName = carrierName;
    }

    public Airplane getAirplane() {
        return airplane;
    }

    public void setAirplane(Airplane airplane) {
        this.airplane = airplane;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((flightNo == null) ? 0 : flightNo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FitOrderFlightDto other = (FitOrderFlightDto) obj;
		if (flightNo == null) {
			if (other.flightNo != null)
				return false;
		} else if (!flightNo.equals(other.flightNo))
			return false;
		return true;
	}
}
