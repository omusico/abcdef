package com.lvmama.lvf.common.dto.flight.price;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnore;

import com.lvmama.lvf.common.dto.Entity;
import com.lvmama.lvf.common.dto.calculator.FlightTicketPriceDto;

/**
 * 航班运价政策信息
 * 
 * @author majun
 * @date 2015-7-13
 */
public class FlightPricePolicyDto extends Entity implements Serializable {
    
    private static final long serialVersionUID = -4679746685196076686L;
    
    /** 航班运价基类 */
	private FlightPriceBase flightPriceBase = new FlightPriceBase();

    /** 供应商编码 */
    private String suppCode;

    /** 供应商政策编号 */
    private String suppPolicyNo;

    /** 票价信息 */
    private FlightTicketPriceDto flightTicketPriceDto;
    
    /** 销售类型(暂Ctrip使用) */
    private String saleType;
    
    /** 传入指定查询返回唯一Productid(暂Ctrip使用) */
    private String pid;
    
    public FlightPriceBase getFlightPriceBase() {
		return flightPriceBase;
	}

	public void setFlightPriceBase(FlightPriceBase flightPriceBase) {
		this.flightPriceBase = flightPriceBase;
	}

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

    public FlightTicketPriceDto getFlightTicketPriceDto() {
		return flightTicketPriceDto;
	}

	public void setFlightTicketPriceDto(FlightTicketPriceDto flightTicketPriceDto) {
		this.flightTicketPriceDto = flightTicketPriceDto;
	}

	public String getSaleType() {
        return saleType;
    }

    public void setSaleType(String saleType) {
        this.saleType = saleType;
    }

    public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}
	
	@Override
    @JsonIgnore
    public String getSequence() {
        return "S_FFLI_PRICE_POLICY";
    }

}
