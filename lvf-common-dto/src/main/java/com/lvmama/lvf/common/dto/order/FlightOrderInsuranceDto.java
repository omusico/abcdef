package com.lvmama.lvf.common.dto.order;

import java.io.Serializable;
import java.math.BigDecimal;

import org.codehaus.jackson.annotate.JsonIgnore;

import com.lvmama.lvf.common.domain.FkId;
import com.lvmama.lvf.common.dto.Entity;
import com.lvmama.lvf.common.dto.enums.Status;
import com.lvmama.lvf.common.dto.insurance.InsuranceOrderDto;
import com.lvmama.lvf.common.dto.md.InsuranceClass;

/**
 * 订单保险信息
 * @author majun
 * @date   2015-1-19
 */
public class FlightOrderInsuranceDto extends Entity implements Serializable 
{	
	private static final long serialVersionUID = -2578637167712547375L;
	
	/** 主订单信息主键 */
	private Long orderMainId;

	/** 订单乘机人主键 */
	private Long orderPassengerId;
	
	/** 可售保险主键 */
	private Long insuranceInfoId;
	
	/** 保险订单信息 */
	private InsuranceOrderDto insuranceOrderDto;
	
	/** 保险类型 */
	private InsuranceClass insuranceClass;
	
	/** 保险价格 */
	private BigDecimal insurancePrice;
	
	/**航班号+id*/
	private String flightNo;
	
	/** 邮箱 */
	private String email;
	
	/** 订单航班信息 */
	@FkId
	private FlightOrderFlightInfoDto flightOrderFlightInfo;
	
	/** 保险成本价*/
	private BigDecimal costPrice;
    
	/** 订单是否有效 */
	private Status status;
	
	/** 是否退款 */
	private Boolean isRefund;

	public String getFlightNo() {
		return flightNo;
	}

	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}
    
	public Long getInsuranceInfoId() {
		return insuranceInfoId;
	}

	public void setInsuranceInfoId(Long insuranceInfoId) {
		this.insuranceInfoId = insuranceInfoId;
	}

	public Long getOrderMainId() {
		return orderMainId;
	}

	public void setOrderMainId(Long orderMainId) {
		this.orderMainId = orderMainId;
	}

	public Long getOrderPassengerId() {
		return orderPassengerId;
	}

	public void setOrderPassengerId(Long orderPassengerId) {
		this.orderPassengerId = orderPassengerId;
	}


	public InsuranceClass getInsuranceClass() {
		return insuranceClass;
	}

	public void setInsuranceClass(InsuranceClass insuranceClass) {
		this.insuranceClass = insuranceClass;
	}

	public BigDecimal getInsurancePrice() {
		return insurancePrice;
	}

	public void setInsurancePrice(BigDecimal insurancePrice) {
		this.insurancePrice = insurancePrice;
	}

	public InsuranceOrderDto getInsuranceOrderDto() {
		return insuranceOrderDto;
	}

	public void setInsuranceOrderDto(InsuranceOrderDto insuranceOrderDto) {
		this.insuranceOrderDto = insuranceOrderDto;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public FlightOrderFlightInfoDto getFlightOrderFlightInfo() {
		return flightOrderFlightInfo;
	}
	
	public void setFlightOrderFlightInfo(
			FlightOrderFlightInfoDto flightOrderFlightInfo) {
		this.flightOrderFlightInfo = flightOrderFlightInfo;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Boolean getIsRefund() {
		return isRefund;
	}

	public void setIsRefund(Boolean isRefund) {
		this.isRefund = isRefund;
	}

	@Override
	@JsonIgnore
	public String getSequence() {
		return "S_FORD_INSURANCE";
	}

	public BigDecimal getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(BigDecimal costPrice) {
		this.costPrice = costPrice;
	}

	
}
