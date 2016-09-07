package com.lvmama.lvf.common.form.booking;

import java.util.List;

import com.lvmama.lvf.common.dto.enums.FlightTripType;
import com.lvmama.lvf.common.dto.enums.RouteType;
import com.lvmama.lvf.common.dto.flight.FlightInfoDto;
import com.lvmama.lvf.common.dto.order.FlightOrderFlightInfoDto;
import com.lvmama.lvf.common.dto.search.result.FlightSearchTicketRuleSimpleDto;
import com.lvmama.lvf.common.form.Form;
import com.lvmama.lvf.common.form.ticket.FlightTicketRuleForm;

public class BookingCheckFlightInfoForm implements Form{

	private FlightOrderFlightInfoDto flightInfo = new FlightOrderFlightInfoDto();
	
	/**是否经停*/
	private int days; 
	
	/**经停城市*/
	private List<String> stopCitys;
	
	/**去回程*/
	private FlightTripType flightTripType;
	
	private String flightTripName;
	
	private RouteType routeType;
	
	private String routeTypeName;
	
	/**乘客机建燃油票价信息*/
    private FlightInfoOrderDetailForm departureOrderDetailVo=new FlightInfoOrderDetailForm();
    
    /**回程客机建燃油票价信息*/
    private FlightInfoOrderDetailForm returnOrderDetailVo=new FlightInfoOrderDetailForm();
    
    private List<FlightTicketRuleForm> ticketRuleForms;
    
    /** 简单客规信息 */
	private List<FlightSearchTicketRuleSimpleDto> ticketRuleSimples;
    
	public List<String> getStopCitys() {
		return stopCitys;
	}

	public void setStopCitys(List<String> stopCitys) {
		this.stopCitys = stopCitys;
	}

	public FlightTripType getFlightTripType() {
		return flightTripType;
	}

	public void setFlightTripType(FlightTripType flightTripType) {
		this.flightTripType = flightTripType;
	}

	public FlightInfoOrderDetailForm getDepartureOrderDetailVo() {
		return departureOrderDetailVo;
	}

	public void setDepartureOrderDetailVo(
			FlightInfoOrderDetailForm departureOrderDetailVo) {
		this.departureOrderDetailVo = departureOrderDetailVo;
	}

	public FlightInfoOrderDetailForm getReturnOrderDetailVo() {
		return returnOrderDetailVo;
	}

	public void setReturnOrderDetailVo(FlightInfoOrderDetailForm returnOrderDetailVo) {
		this.returnOrderDetailVo = returnOrderDetailVo;
	}

	public String getFlightTripName() {
		return flightTripName;
	}

	public void setFlightTripName(String flightTripName) {
		this.flightTripName = flightTripName;
	}

	public String getRouteTypeName() {
		return routeTypeName;
	}

	public void setRouteTypeName(String routeTypeName) {
		this.routeTypeName = routeTypeName;
	}

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}

	public FlightOrderFlightInfoDto getFlightInfo() {
		return flightInfo;
	}

	public void setFlightInfo(FlightOrderFlightInfoDto flightInfo) {
		this.flightInfo = flightInfo;
	}

	public List<FlightTicketRuleForm> getTicketRuleForms() {
		return ticketRuleForms;
	}

	public void setTicketRuleForms(List<FlightTicketRuleForm> ticketRuleForms) {
		this.ticketRuleForms = ticketRuleForms;
	}

	public List<FlightSearchTicketRuleSimpleDto> getTicketRuleSimples() {
		return ticketRuleSimples;
	}

	public void setTicketRuleSimples(
			List<FlightSearchTicketRuleSimpleDto> ticketRuleSimples) {
		this.ticketRuleSimples = ticketRuleSimples;
	}

	public RouteType getRouteType() {
		return routeType;
	}

	public void setRouteType(RouteType routeType) {
		this.routeType = routeType;
	}
	

}
