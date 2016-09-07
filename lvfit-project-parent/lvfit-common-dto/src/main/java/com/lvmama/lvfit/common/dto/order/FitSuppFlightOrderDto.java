package com.lvmama.lvfit.common.dto.order;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonManagedReference;

import com.lvmama.lvf.common.dto.Entity;
import com.lvmama.lvfit.common.dto.enums.FlightTripType;
import com.lvmama.lvfit.common.dto.enums.PassengerType;
import com.lvmama.lvfit.common.dto.status.order.OrderBookingStatus;

/**
 * 供应商航班订单信息
 * @author leizhengwei
 *
 */
public class FitSuppFlightOrderDto extends Entity {

	private static final long serialVersionUID = 3618756156531316060L;

	/**机酒供应商订单Id  */
	private Long suppOrderId;
	
	/** 机票单品子订单No */
	private String flightOrderNo;
	
	/** 机票订单预订状态 */
	private OrderBookingStatus bookingStatus;
	
	/**机票子订单详情  */
	private List<FitSuppFlightOrderDetailDto> suppFlightOrderDetailDtos = new ArrayList<FitSuppFlightOrderDetailDto>();
	
	/** 订单金额信息 */
	private FitOrderAmountDto orderAmount;
	
	/** 供应商航班订单乘客类型 */
	private PassengerType passengerType;
	
	/** 航程类型(仅针对于机票) */
	private FlightTripType tripType;

	public Long getSuppOrderId() {
		return suppOrderId;
	}

	public void setSuppOrderId(Long suppOrderId) {
		this.suppOrderId = suppOrderId;
	}

	public String getFlightOrderNo() {
		return flightOrderNo;
	}

	public void setFlightOrderNo(String flightOrderNo) {
		this.flightOrderNo = flightOrderNo;
	}

	public OrderBookingStatus getBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(OrderBookingStatus bookingStatus) {
		this.bookingStatus = bookingStatus;
	}

	public List<FitSuppFlightOrderDetailDto> getSuppFlightOrderDetailDtos() {
		return suppFlightOrderDetailDtos;
	}

	public void setSuppFlightOrderDetailDtos(
			List<FitSuppFlightOrderDetailDto> suppFlightOrderDetailDtos) {
		this.suppFlightOrderDetailDtos = suppFlightOrderDetailDtos;
	}

	public FitOrderAmountDto getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(FitOrderAmountDto orderAmount) {
		this.orderAmount = orderAmount;
	}

	public PassengerType getPassengerType() {
		return passengerType;
	}

	public void setPassengerType(PassengerType passengerType) {
		this.passengerType = passengerType;
	}
	
	public FlightTripType getTripType() {
		return tripType;
	}

	public void setTripType(FlightTripType tripType) {
		this.tripType = tripType;
	}

	/*@JsonIgnore
	public boolean  isNeedUpdate(List<FitSuppFlightOrderDetailDto> flightOrderDetailDtos){
		
		boolean isNeedUpdate = true;
		int ticketCount = 0;
		if(CollectionUtils.isNotEmpty(flightOrderDetailDtos)){
			for (FitSuppFlightOrderDetailDto suppFlightOrderDetailDto : flightOrderDetailDtos) {
				if(StringUtils.isNotBlank(suppFlightOrderDetailDto.getFitSuppOrderTicketInfoDto().getTicketNo())){
					ticketCount++;
				}
			}
			if(ticketCount==flightOrderDetailDtos.size()){
				return false;
			}
		}
		return isNeedUpdate;
		
	}*/
	@Override
	public String getSequence() {
	    return "s_fitord_supp_fli_order";
	}

}
