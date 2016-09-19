package com.lvmama.lvf.common.dto.request;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang3.StringUtils;

import com.lvmama.lvf.common.dto.enums.BookingSource;
import com.lvmama.lvf.common.dto.enums.DirectType;
import com.lvmama.lvf.common.dto.enums.InventoryType;
import com.lvmama.lvf.common.dto.enums.MealType;
import com.lvmama.lvf.common.dto.enums.OnlySelfPNR;
import com.lvmama.lvf.common.dto.enums.PassengerType;
import com.lvmama.lvf.common.dto.enums.PolicyType;
import com.lvmama.lvf.common.dto.enums.RouteType;
import com.lvmama.lvf.common.dto.enums.SeatClassType;
import com.lvmama.lvf.common.dto.enums.TimeSegment;
import com.lvmama.lvf.common.dto.md.Carrier;
import com.lvmama.lvf.common.dto.md.DateRange;
import com.lvmama.lvf.common.dto.md.FlightOfficeDto;
import com.lvmama.lvf.common.dto.md.SeatClass;
import com.lvmama.lvf.common.dto.supp.SuppFlightProductDto;

@XmlRootElement
public class FlightInfoDailyQueryRequest implements Serializable {

	/** serialVersionUID */
	private static final long serialVersionUID = -3921306104310769634L;

	private String departureCity;
	
	private String arrivalCity;
	
	private String departureDate;
	
	private String flightNo;
	
	private String carrierCode;

	public String getDepartureCity() {
		return departureCity;
	}

	public void setDepartureCity(String departureCity) {
		this.departureCity = departureCity;
	}

	public String getArrivalCity() {
		return arrivalCity;
	}

	public void setArrivalCity(String arrivalCity) {
		this.arrivalCity = arrivalCity;
	}

	public String getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}

	public String getFlightNo() {
		return flightNo;
	}

	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}

	public String getCarrierCode() {
		return carrierCode;
	}

	public void setCarrierCode(String carrierCode) {
		this.carrierCode = carrierCode;
	}
	
	
}
