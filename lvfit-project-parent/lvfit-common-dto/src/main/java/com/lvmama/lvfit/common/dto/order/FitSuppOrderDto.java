package com.lvmama.lvfit.common.dto.order;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.codehaus.jackson.annotate.JsonIgnore;

import com.lvmama.lvf.common.dto.Entity;
import com.lvmama.lvfit.common.dto.enums.BindingStatus;
import com.lvmama.lvfit.common.dto.enums.FlightTripType;
import com.lvmama.lvfit.common.dto.enums.PassengerType;

public class FitSuppOrderDto extends Entity {

	private static final long serialVersionUID = -7927865732112553163L;

	/**驴妈妈订单Id  */
	private Long fitOrderId;
	
	/** 类型Id */
	private Long categoryId;
	
	/** 主单绑定关系表Id */
	private Long suppMainOrderId;

	/** vst机票订单号 */
	private Long vstOrderNo;
	
	/** 是否绑定 */
	private BindingStatus bindingStatus;

	/** 子单关联信息 */
	private List<FitSuppFlightOrderDto> suppFlightOrderDtos = new ArrayList<FitSuppFlightOrderDto>();
	
	/** 订单金额信息 */
	private FitOrderAmountDto orderAmount;
	
	/** 航程类型(仅针对于机票) */
	private FlightTripType tripType;
	
	/** 供应商子单状态 */
	private FitSuppOrderStatusDto fitSuppOrderStatusDto;
	
	/**供应商订单待回调机票下单留库信息 */
	private FitSuppOrderForFlightCallBackDto flightCallBackDto; 
	
	 /**
     * 供应商商品ID
     */
    private Long suppGoodsId;
	
    /**
     * 标明是包机航班的子单.
     */
    private Boolean isCharterFlightSub;
     
	public Boolean getIsCharterFlightSub() {
		return isCharterFlightSub;
	}

	public void setIsCharterFlightSub(Boolean isCharterFlightSub) {
		this.isCharterFlightSub = isCharterFlightSub;
	}

	public Long getFitOrderId() {
		return fitOrderId;
	}

	public void setFitOrderId(Long fitOrderId) {
		this.fitOrderId = fitOrderId;
	}

	public final Long getCategoryId() {
		return categoryId;
	}

	public final FitOrderAmountDto getOrderAmount() {
		return orderAmount;
	}

	public final void setOrderAmount(FitOrderAmountDto orderAmount) {
		this.orderAmount = orderAmount;
	}

	public final void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public BindingStatus getBindingStatus() {
		return bindingStatus;
	}

	public void setBindingStatus(BindingStatus bindingStatus) {
		this.bindingStatus = bindingStatus;
	}

	public Long getSuppMainOrderId() {
		return suppMainOrderId;
	}

	public void setSuppMainOrderId(Long suppMainOrderId) {
		this.suppMainOrderId = suppMainOrderId;
	}
	
	public Long getVstOrderNo() {
		return vstOrderNo;
	}

	public void setVstOrderNo(Long vstOrderNo) {
		this.vstOrderNo = vstOrderNo;
	}

	public List<FitSuppFlightOrderDto> getSuppFlightOrderDtos() {
		return suppFlightOrderDtos;
	}

	public void setSuppFlightOrderDtos(List<FitSuppFlightOrderDto> suppFlightOrderDtos) {
		this.suppFlightOrderDtos = suppFlightOrderDtos;
	}

	public FlightTripType getTripType() {
		return tripType;
	}

	public void setTripType(FlightTripType tripType) {
		this.tripType = tripType;
	}
	
	@JsonIgnore
	public FitSuppFlightOrderDto getByPassengerType(PassengerType  passengerType){
		if(CollectionUtils.isNotEmpty(this.getSuppFlightOrderDtos())){
			for (FitSuppFlightOrderDto suppFlightOrderDto : this.getSuppFlightOrderDtos()) {
				if(suppFlightOrderDto.getPassengerType()==passengerType){
					return suppFlightOrderDto;
				}
			}
		}
		return null;
	}

	public FitSuppOrderStatusDto getFitSuppOrderStatusDto() {
		return fitSuppOrderStatusDto;
	}

	public void setFitSuppOrderStatusDto(FitSuppOrderStatusDto fitSuppOrderStatusDto) {
		this.fitSuppOrderStatusDto = fitSuppOrderStatusDto;
	}
	
	public FitSuppOrderForFlightCallBackDto getFlightCallBackDto() {
		return flightCallBackDto;
	}

	public void setFlightCallBackDto(
			FitSuppOrderForFlightCallBackDto flightCallBackDto) {
		this.flightCallBackDto = flightCallBackDto;
	}
	

	public Long getSuppGoodsId() {
		return suppGoodsId;
	}

	public void setSuppGoodsId(Long suppGoodsId) {
		this.suppGoodsId = suppGoodsId;
	}

	@Override
	public String getSequence() {
	    return "S_FITORD_SUPP_ORDER_NEW";
	}
}
