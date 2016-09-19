package com.lvmama.lvf.common.dto.vst;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import com.lvmama.lvf.common.dto.order.FlightOrderDto;
import com.lvmama.lvf.common.dto.order.FlightOrderPassengerDto;
import com.lvmama.lvf.common.dto.order.OrderMainDto;
/**
 * 提供给分销的机票主订单
 * @author XuJunhui
 * @Date 2016年6月29日
 */
public class DistFlightMainOrderDto {

	private String customerName;
	private String customerId;
	private Long mainOrderId;
	private String flightOrderNumber;
	private BigDecimal totalOrderAmount;
	private String routeType;
	private String passengerName;
	
	List<DistFlightOrderDto> subOrder;
	
	public DistFlightMainOrderDto(OrderMainDto mainOrderDto) {
		this.mainOrderId = mainOrderDto.getId();
		this.flightOrderNumber = mainOrderDto.getFlightOrderNo().getOrderNo();
		this.totalOrderAmount = BigDecimal.ZERO;
		if(null != mainOrderDto.getFlightOrderFlightCombination() && null != mainOrderDto.getFlightOrderFlightCombination().getRouteType()){
			this.routeType = mainOrderDto.getFlightOrderFlightCombination().getRouteType().name();
		}
		if(null != mainOrderDto.getFlightOrders() && mainOrderDto.getFlightOrders().size() > 0){
			this.subOrder = new ArrayList<DistFlightOrderDto>(mainOrderDto.getFlightOrders().size());
			for(FlightOrderDto fod: mainOrderDto.getFlightOrders()){
				DistFlightOrderDto sub = new DistFlightOrderDto(fod);
				this.subOrder.add(sub);
				this.totalOrderAmount = this.totalOrderAmount.add(sub.getOrderAmount());
			}
		}
		
		if(CollectionUtils.isNotEmpty(mainOrderDto.getFlightOrderPassengers())){
			for(FlightOrderPassengerDto psg: mainOrderDto.getFlightOrderPassengers()){
				this.appendPassengerName(psg.getPassengerName());
			}
		}
	}
	
	public DistFlightMainOrderDto(){
		
	}

	public Long getMainOrderId() {
		return mainOrderId;
	}

	public BigDecimal getTotalOrderAmount() {
		return totalOrderAmount;
	}

	public String getRouteType() {
		return routeType;
	}

	public List<DistFlightOrderDto> getSubOrder() {
		return subOrder;
	}

	public void setSubOrder(List<DistFlightOrderDto> subOrder) {
		this.subOrder = subOrder;
	}

	public void setMainOrderId(Long mainOrderId) {
		this.mainOrderId = mainOrderId;
	}

	public void setTotalOrderAmount(BigDecimal totalOrderAmount) {
		this.totalOrderAmount = totalOrderAmount;
	}

	public void setRouteType(String routeType) {
		this.routeType = routeType;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
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

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	
}
