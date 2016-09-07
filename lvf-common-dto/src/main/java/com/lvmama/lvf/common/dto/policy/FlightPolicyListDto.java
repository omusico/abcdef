package com.lvmama.lvf.common.dto.policy;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import com.lvmama.lvf.common.dto.Entity;
import com.lvmama.lvf.common.dto.md.Carrier;
import com.lvmama.lvf.common.dto.md.DateRange;
import com.lvmama.lvf.common.dto.supp.Supp;

@XmlRootElement
public class FlightPolicyListDto extends Entity implements Serializable {

	private static final long serialVersionUID = -7356094852522298988L;
	
	/** 承运人*/
	private Carrier carrier;
	
	/** 出发机场*/
	private String includeDepartureAirports;
	
	/** 到达机场*/
	private String includeArrivalAirports;
	
	/** 供应商*/
	private Supp supp;
	
	/** 航程*/
	private String routeType;
	
	/** 去程舱位*/
	private String departureSeats; 
	
	/** 回程舱位*/
	private String arrivalSeats;
	
	/** 政策有效期 */
    private DateRange departureDateRange;
    
    /** 最后更新时间 */
    private Date updateTime;
	
	public Carrier getCarrier() {
		return carrier;
	}

	public void setCarrier(Carrier carrier) {
		this.carrier = carrier;
	}

	public String getIncludeDepartureAirports() {
		return includeDepartureAirports;
	}

	public void setIncludeDepartureAirports(String includeDepartureAirports) {
		this.includeDepartureAirports = includeDepartureAirports;
	}

	public String getIncludeArrivalAirports() {
		return includeArrivalAirports;
	}

	public void setIncludeArrivalAirports(String includeArrivalAirports) {
		this.includeArrivalAirports = includeArrivalAirports;
	}

	public Supp getSupp() {
		return supp;
	}

	public void setSupp(Supp supp) {
		this.supp = supp;
	}

	public String getRouteType() {
		return routeType;
	}

	public void setRouteType(String routeType) {
		this.routeType = routeType;
	}

	public String getDepartureSeats() {
		return departureSeats;
	}

	public void setDepartureSeats(String departureSeats) {
		this.departureSeats = departureSeats;
	}

	public String getArrivalSeats() {
		return arrivalSeats;
	}

	public void setArrivalSeats(String arrivalSeats) {
		this.arrivalSeats = arrivalSeats;
	}

	public DateRange getDepartureDateRange() {
		return departureDateRange;
	}

	public void setDepartureDateRange(DateRange departureDateRange) {
		this.departureDateRange = departureDateRange;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
}
