package com.lvmama.lvf.common.form.booking;

import java.util.ArrayList;
import java.util.List;

import com.lvmama.lvf.common.dto.order.FlightOrderDetailDto;
import com.lvmama.lvf.common.form.Form;


/***
 * 去程乘客机建燃油票价信息
 *
 */
public class FlightInfoOrderDetailForm implements Form{

	/** 航班号 */
	private String flightNo;
	
	/** 航班订单详情信息 */
	private List<FlightOrderDetailDto> flightOrderDetailDtos = new ArrayList<FlightOrderDetailDto>();
	
	/** 机建费 */
	private String airportFee;
	
	/** 燃油费 */
	private String fuelsurTax;

	public String getFlightNo() {
		return flightNo;
	}

	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}

	public List<FlightOrderDetailDto> getFlightOrderDetailDtos() {
		return flightOrderDetailDtos;
	}

	public void setFlightOrderDetailDtos(
			List<FlightOrderDetailDto> flightOrderDetailDtos) {
		this.flightOrderDetailDtos = flightOrderDetailDtos;
	}

	public String getAirportFee() {
		return airportFee;
	}

	public void setAirportFee(String airportFee) {
		this.airportFee = airportFee;
	}

	public String getFuelsurTax() {
		return fuelsurTax;
	}

	public void setFuelsurTax(String fuelsurTax) {
		this.fuelsurTax = fuelsurTax;
	}
	
}
