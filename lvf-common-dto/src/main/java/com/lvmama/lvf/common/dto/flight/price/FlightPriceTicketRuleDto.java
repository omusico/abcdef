package com.lvmama.lvf.common.dto.flight.price;

import java.io.Serializable;

import com.lvmama.lvf.common.dto.Entity;
import com.lvmama.lvf.common.dto.enums.PassengerType;

/**
 * 航班运价客规信息
 * @author majun
 * @date 2015-7-13
 */
public class FlightPriceTicketRuleDto extends Entity implements Serializable 
{
	private static final long serialVersionUID = 2770884391436805445L;
	
	/** 航班运价基类 */
	private FlightPriceBase flightPriceBase = new FlightPriceBase();
	
	/** 供应商编码 */
	private String suppCode;
	
	/** 供应商政策编号 */
	private String suppPolicyNo;
	
	/** 乘客类型 */
	private PassengerType passengerType;
	
	/** 客规描述(退) */
	private String rtRuleDesc;
	
	/** 客规描述(改) */
	private String mtRuleDesc;
	
	/** 客规描述(签) */
	private String ctRuleDesc;
	
    /** 改签ID */
    private String suppChangeNo;

    /** 退票ID */
    private String suppRefundNo;
    
    /** 产品来源 */
    private String productSourceNum;
    
    /** 是否能退 */
    private String nonRef;
    
    /** 是否能改 */
    private String nonRer;
	
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

	public PassengerType getPassengerType() {
		return passengerType;
	}

	public void setPassengerType(PassengerType passengerType) {
		this.passengerType = passengerType;
	}

	public String getRtRuleDesc() {
		return rtRuleDesc;
	}

	public void setRtRuleDesc(String rtRuleDesc) {
		this.rtRuleDesc = rtRuleDesc;
	}

	public String getMtRuleDesc() {
		return mtRuleDesc;
	}

	public void setMtRuleDesc(String mtRuleDesc) {
		this.mtRuleDesc = mtRuleDesc;
	}

	public String getCtRuleDesc() {
		return ctRuleDesc;
	}

	public void setCtRuleDesc(String ctRuleDesc) {
		this.ctRuleDesc = ctRuleDesc;
	}

    public String getSuppChangeNo() {
        return suppChangeNo;
    }

    public void setSuppChangeNo(String suppChangeNo) {
        this.suppChangeNo = suppChangeNo;
    }

    public String getSuppRefundNo() {
        return suppRefundNo;
    }

    public void setSuppRefundNo(String suppRefundNo) {
        this.suppRefundNo = suppRefundNo;
    }

    public FlightPriceBase getFlightPriceBase() {
        return flightPriceBase;
    }

    public void setFlightPriceBase(FlightPriceBase flightPriceBase) {
        this.flightPriceBase = flightPriceBase;
    }

	public String getProductSourceNum() {
		return productSourceNum;
	}

	public void setProductSourceNum(String productSourceNum) {
		this.productSourceNum = productSourceNum;
	}

	public String getNonRef() {
		return nonRef;
	}

	public void setNonRef(String nonRef) {
		this.nonRef = nonRef;
	}

	public String getNonRer() {
		return nonRer;
	}

	public void setNonRer(String nonRer) {
		this.nonRer = nonRer;
	}

}
