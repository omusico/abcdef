package com.lvmama.lvfit.common.dto.order;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.codehaus.jackson.annotate.JsonIgnore;

import com.lvmama.lvf.common.dto.Entity;
import com.lvmama.lvf.common.dto.order.FlightOrderInsuranceDto;
import com.lvmama.lvfit.common.dto.enums.BindingStatus;
import com.lvmama.lvfit.common.dto.enums.FlightTripType;
import com.lvmama.lvfit.common.dto.enums.Paytarget;

public class FitSuppMainOrderDto extends Entity {

	private static final long serialVersionUID = 5456720422848237937L;

	/** 交通+X 主单Id */
	private Long fitMainOrderId;

	/** 交通+X 主单号 */
	private String fitMainOrderNo;
	
	/** vst主单Id */
	private Long vstMainOrderNo;

	/** 是否绑定 */
	private BindingStatus bindingStatus;
	
	/** 订单金额信息 */
	private FitOrderAmountDto orderAmount;
	
	/** 出游日期 */
	private Date visitTime;

	/**供应商订单支付方式   */
	private Paytarget paymentTarget;
	
	/**供应商状态信息  */
	private FitSuppMainOrderStatusDto fitSuppMainOrderStatus;

	/** 子单关联信息 */
	private List<FitSuppOrderDto> fitSuppOrderDtos = new ArrayList<FitSuppOrderDto>();
	
	/** 航意险信息 */
	private List<FlightOrderInsuranceDto> flightInsDtos = new ArrayList<FlightOrderInsuranceDto>();

	/** (真往返)子单关联信息 */
	private List<FitSuppFlightOrderDto> suppFlightOrderDtos = new ArrayList<FitSuppFlightOrderDto>();

	/**
	 * 真往返下时，存储全部的乘客信息.
	 */
	private List<FitOrderPassengerDto> allPassengerDtos = new ArrayList<FitOrderPassengerDto>();

	public Long getFitMainOrderId() {
		return fitMainOrderId;
	}

	public List<FitOrderPassengerDto> getAllPassengerDtos() {
		return allPassengerDtos;
	}

	public void setAllPassengerDtos(List<FitOrderPassengerDto> allPassengerDtos) {
		this.allPassengerDtos = allPassengerDtos;
	}

	public void setFitMainOrderId(Long fitMainOrderId) {
		this.fitMainOrderId = fitMainOrderId;
	}
	 
	public String getFitMainOrderNo() {
		return fitMainOrderNo;
	}

	public void setFitMainOrderNo(String fitMainOrderNo) {
		this.fitMainOrderNo = fitMainOrderNo;
	}

	public Long getVstMainOrderNo() {
		return vstMainOrderNo;
	}

	public void setVstMainOrderNo(Long vstMainOrderNo) {
		this.vstMainOrderNo = vstMainOrderNo;
	}

	public BindingStatus getBindingStatus() {
		return bindingStatus;
	}

	public void setBindingStatus(BindingStatus bindingStatus) {
		this.bindingStatus = bindingStatus;
	}
	
	public FitOrderAmountDto getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(FitOrderAmountDto orderAmount) {
		this.orderAmount = orderAmount;
	}
	
	public Date getVisitTime() {
		return visitTime;
	}

	public void setVisitTime(Date visitTime) {
		this.visitTime = visitTime;
	}

	public Paytarget getPaymentTarget() {
		return paymentTarget;
	}

	public void setPaymentTarget(Paytarget paymentTarget) {
		this.paymentTarget = paymentTarget;
	}

	public FitSuppMainOrderStatusDto getFitSuppMainOrderStatus() {
		return fitSuppMainOrderStatus;
	}

	public void setFitSuppMainOrderStatus(
			FitSuppMainOrderStatusDto fitSuppMainOrderStatus) {
		this.fitSuppMainOrderStatus = fitSuppMainOrderStatus;
	}

	public List<FitSuppOrderDto> getFitSuppOrderDtos() {
		return fitSuppOrderDtos;
	}

	public void setFitSuppOrderDtos(List<FitSuppOrderDto> fitSuppOrderDtos) {
		this.fitSuppOrderDtos = fitSuppOrderDtos;
	}

	@JsonIgnore
	public FitSuppOrderDto getByFlightTripType(FlightTripType  tripType){
		if(CollectionUtils.isNotEmpty(this.getFitSuppOrderDtos())){
			for (FitSuppOrderDto fitSuppOrderDto : this.getFitSuppOrderDtos()) {
				if(fitSuppOrderDto.getTripType()==tripType){
					return fitSuppOrderDto;
				}
			}
		}
		return null;
	}
	
	@Override
	public String getSequence() {
	    return "S_FITORD_SUPP_ORDER_MAIN";
	}

    public List<FlightOrderInsuranceDto> getFlightInsDtos() {
        return flightInsDtos;
    }

    public void setFlightInsDtos(List<FlightOrderInsuranceDto> flightInsDtos) {
        this.flightInsDtos = flightInsDtos;
    }

	public List<FitSuppFlightOrderDto> getSuppFlightOrderDtos() {
		return suppFlightOrderDtos;
	}

	public void setSuppFlightOrderDtos(List<FitSuppFlightOrderDto> suppFlightOrderDtos) {
		this.suppFlightOrderDtos = suppFlightOrderDtos;
	}
}
