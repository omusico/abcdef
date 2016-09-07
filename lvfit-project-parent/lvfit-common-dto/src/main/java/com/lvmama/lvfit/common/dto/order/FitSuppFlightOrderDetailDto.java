package com.lvmama.lvfit.common.dto.order;

import com.lvmama.lvf.common.domain.FkId;
import com.lvmama.lvf.common.dto.Entity;
import com.lvmama.lvfit.common.dto.enums.FlightTripType;

/**
 * 供应商航班订单详情
 * @author leizhengwei
 *
 */
public class FitSuppFlightOrderDetailDto extends Entity {

	private static final long serialVersionUID = -8792018799242928055L;

	/** 订单绑定关系表Id */
	private Long suppFlightOrderId;

	@FkId
	private FitOrderPassengerDto fitOrderPassenger = new FitOrderPassengerDto();
	
	/** 订单票号信息 */
	@FkId
	private FitSuppOrderTicketInfoDto fitSuppOrderTicketInfoDto = new FitSuppOrderTicketInfoDto();
	
	/** 订单航班信息航程类型*/
	private 	FlightTripType tripType;
	
	public Long getSuppFlightOrderId() {
		return suppFlightOrderId;
	}

	public void setSuppFlightOrderId(Long suppFlightOrderId) {
		this.suppFlightOrderId = suppFlightOrderId;
	}

	public FitOrderPassengerDto getFitOrderPassenger() {
		return fitOrderPassenger;
	}

	public void setFitOrderPassenger(FitOrderPassengerDto fitOrderPassenger) {
		this.fitOrderPassenger = fitOrderPassenger;
	}

	public FitSuppOrderTicketInfoDto getFitSuppOrderTicketInfoDto() {
		return fitSuppOrderTicketInfoDto;
	}

	public void setFitSuppOrderTicketInfoDto(
			FitSuppOrderTicketInfoDto fitSuppOrderTicketInfoDto) {
		this.fitSuppOrderTicketInfoDto = fitSuppOrderTicketInfoDto;
	}

	public FlightTripType getTripType() {
		return tripType;
	}

	public void setTripType(FlightTripType tripType) {
		this.tripType = tripType;
	}
	
}
