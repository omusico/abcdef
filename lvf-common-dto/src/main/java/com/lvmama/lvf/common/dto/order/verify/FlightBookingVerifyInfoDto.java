package com.lvmama.lvf.common.dto.order.verify;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.lvmama.lvf.common.dto.AEEntity;
import com.lvmama.lvf.common.dto.flight.FlightAirportFeeDto;
import com.lvmama.lvf.common.dto.flight.FlightFuelsurTaxDto;

@XmlRootElement
public class FlightBookingVerifyInfoDto extends AEEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2293413644332539757L;

	/**航班号 */
	private String flightNo;
	
	/**机场费信息*/
	private List<FlightAirportFeeDto> fees = new ArrayList<FlightAirportFeeDto>();
	
	/**燃油费信息 */
	private List<FlightFuelsurTaxDto> taxs = new ArrayList<FlightFuelsurTaxDto>();
	
	/**政策及运价信息 */
	private List<FlightBookingVerifyDeatilDto> bookingVerifyDeatils = new ArrayList<FlightBookingVerifyDeatilDto>();

	public String getFlightNo() {
		return flightNo;
	}

	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}

	public List<FlightAirportFeeDto> getFees() {
		return fees;
	}

	public void setFees(List<FlightAirportFeeDto> fees) {
		this.fees = fees;
	}

	public List<FlightFuelsurTaxDto> getTaxs() {
		return taxs;
	}

	public void setTaxs(List<FlightFuelsurTaxDto> taxs) {
		this.taxs = taxs;
	}

	public List<FlightBookingVerifyDeatilDto> getBookingVerifyDeatils() {
		return bookingVerifyDeatils;
	}

	public void setBookingVerifyDeatils(
			List<FlightBookingVerifyDeatilDto> bookingVerifyDeatils) {
		this.bookingVerifyDeatils = bookingVerifyDeatils;
	}

	
	

	
}
