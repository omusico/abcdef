package com.lvmama.lvf.common.dto.vst;

import java.math.BigDecimal;

import org.apache.commons.collections.CollectionUtils;

import com.lvmama.lvf.common.dto.order.FlightOrderDetailDto;
import com.lvmama.lvf.common.dto.order.FlightOrderDto;
import com.lvmama.lvf.common.dto.order.FlightOrderFlightCombinationDetailDto;
import com.lvmama.lvf.common.dto.order.FlightOrderFlightInfoDto;

/**
 * 提供给分销的机票订单信息
 * @author XuJunhui
 * @Date 2016年6月29日
 */
public class DistFlightOrderDto {
	
	private Long subOrderId;
	private String flightOrderNumber;
	private Long sourceSubOrderId;
	private Long sourceTntFlightOrderId;
	private BigDecimal orderAmount;
	private BigDecimal refundAmount;
	private String orderStatus;
	private String orderType;
	private String fromCity;
	private String fromAirPort;
	private String fromTermainalBuilding;
	private String toCity;
	private String toAirPort;
	private String toTermainalBuilding;
	private String airLine;
	private String flightNo;
	private String passengerType;
	private String passengerName;
	private String flightTripType;
	private Long takeOffTime;
	
	public DistFlightOrderDto() {}
	
	public DistFlightOrderDto(FlightOrderDto flightOrderDto) {
		this.subOrderId = flightOrderDto.getId();
		this.flightOrderNumber = flightOrderDto.getFlightOrderNo().getOrderNo();
		if(null != flightOrderDto.getOrderType()){
			this.orderType = flightOrderDto.getOrderType().name();
			switch(flightOrderDto.getOrderType()){
			case NORMAL:
				this.orderAmount = flightOrderDto.getFlightOrderAmount().getOrderPrepaidAmount();
				break;
				
			case CTMT:
				this.orderAmount = flightOrderDto.getFlightOrderAmount().getOrderCTMTAmount().getCtmtPrepaidAmount();
				break;
				
			case RTVT:
				this.refundAmount = flightOrderDto.getFlightOrderAmount().getOrderRTVTAmount().getRtvtAmount();
				break;
				
			default:
				break;
			}
		}
		
		this.sourceSubOrderId = flightOrderDto.getOrderPreId();
		
		if(CollectionUtils.isNotEmpty(flightOrderDto.getFlightOrderDetails())){
			FlightOrderFlightCombinationDetailDto comDetail = flightOrderDto.getFlightOrderDetails().get(0).getCombinationDetail();
			
			this.addCombine(comDetail);
			
			for(FlightOrderDetailDto detail: flightOrderDto.getFlightOrderDetails()){
				if(null != detail.getFlightOrderPassenger()){
					this.appendPassengerName(detail.getFlightOrderPassenger().getPassengerName());
				}
			}
			
		}
		
	}
	
	public void addCombine(FlightOrderFlightCombinationDetailDto comDetail ){
		if(null != comDetail){
			this.passengerType = comDetail.getPassengerType() == null? null: comDetail.getPassengerType().name();
			this.flightTripType = comDetail.getFlightTripType() == null? null: comDetail.getFlightTripType().name();
			FlightOrderFlightInfoDto flightInfo = comDetail.getFlightOrderFlightInfo();
			if(null != flightInfo){
				this.fromCity = flightInfo.getFlightAirportLine().getDepartureAirport().getCity().getName();
				this.fromAirPort = flightInfo.getFlightAirportLine().getDepartureAirport().getName();
				this.fromTermainalBuilding = flightInfo.getFlightAirportLine().getDepartureTermainalBuilding().getCode();
				this.toCity = flightInfo.getFlightAirportLine().getArrivalAirport().getCity().getName();
				this.toAirPort = flightInfo.getFlightAirportLine().getArrivalAirport().getName();
				this.toTermainalBuilding = flightInfo.getFlightAirportLine().getArrivalTerminalBuilding().getCode();
				this.airLine = flightInfo.getCarrier().getName();
				this.flightNo = flightInfo.getFlightNo();
				this.takeOffTime = flightInfo.getTimeSegmentRange().getDepartureTime().getTime();
			}
		}
	}
	
	
	public Long getSubOrderId(){
		return this.subOrderId;
	}
	
	public BigDecimal getOrderAmount(){
		return this.orderAmount;
	}
	
	public String getOrderStatus(){
		return this.orderStatus;
	}
	
	public String getFromCity(){
		return this.fromCity;
	}
	
	public String getFromAirPort(){
		return this.fromAirPort;
	}
	
	public String getFromTermainalBuilding(){
		return this.fromTermainalBuilding;
	}
	
	public String getToCity(){
		return this.toCity;
	}
	
	public String getToAirPort(){
		return this.toAirPort;
	}
	
	public String getToTermainalBuilding(){
		return this.toTermainalBuilding;
	}
	
	public String getAirLine(){
		return this.airLine;
	}
	
	public String getFlightNo(){
		return this.flightNo;
	}
	
	public String getPassengerType(){
		return this.passengerType;
	}
	
	public String getFlightTripType(){
		return this.flightTripType;
	}
	
	public Long getTakeOffTime(){
		return this.takeOffTime;
	}


	public void setSubOrderId(Long subOrderId) {
		this.subOrderId = subOrderId;
	}


	public void setOrderAmount(BigDecimal orderAmount) {
		this.orderAmount = orderAmount;
	}


	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}


	public void setFromCity(String fromCity) {
		this.fromCity = fromCity;
	}


	public void setFromAirPort(String fromAirPort) {
		this.fromAirPort = fromAirPort;
	}


	public void setFromTermainalBuilding(String fromTermainalBuilding) {
		this.fromTermainalBuilding = fromTermainalBuilding;
	}


	public void setToCity(String toCity) {
		this.toCity = toCity;
	}


	public void setToAirPort(String toAirPort) {
		this.toAirPort = toAirPort;
	}


	public void setToTermainalBuilding(String toTermainalBuilding) {
		this.toTermainalBuilding = toTermainalBuilding;
	}


	public void setAirLine(String airLine) {
		this.airLine = airLine;
	}


	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}


	public void setPassengerType(String passengerType) {
		this.passengerType = passengerType;
	}


	public void setFlightTripType(String flightTripType) {
		this.flightTripType = flightTripType;
	}


	public void setTakeOffTime(Long takeOffTime) {
		this.takeOffTime = takeOffTime;
	}

	public Long getSourceSubOrderId() {
		return sourceSubOrderId;
	}

	public void setSourceSubOrderId(Long sourceSubOrderId) {
		this.sourceSubOrderId = sourceSubOrderId;
	}

	public Long getSourceTntFlightOrderId() {
		return sourceTntFlightOrderId;
	}

	public void setSourceTntFlightOrderId(Long sourceTntFlightOrderId) {
		this.sourceTntFlightOrderId = sourceTntFlightOrderId;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public BigDecimal getRefundAmount() {
		return refundAmount;
	}

	public void setRefundAmount(BigDecimal refundAmount) {
		this.refundAmount = refundAmount;
	}

	public String getPassengerName() {
		return passengerName;
	}

	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}
	
	public void appendPassengerName(String name){
		if(this.passengerName == null || this.passengerName.length() == 0){
			this.passengerName = name;
		}else{
			this.passengerName += "," + name;
		}
	}

	public String getFlightOrderNumber() {
		return flightOrderNumber;
	}

	public void setFlightOrderNumber(String flightOrderNumber) {
		this.flightOrderNumber = flightOrderNumber;
	}
	
}
