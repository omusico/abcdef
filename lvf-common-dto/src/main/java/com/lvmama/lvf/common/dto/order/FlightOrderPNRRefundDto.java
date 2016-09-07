package com.lvmama.lvf.common.dto.order;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnore;

import com.lvmama.lvf.common.domain.FkId;
import com.lvmama.lvf.common.dto.Entity;

/**
 * 订单PNR退票信息
 * 
 * @author majun
 * @date 2015-2-4
 */
public class FlightOrderPNRRefundDto extends Entity implements Serializable 
{
	private static final long serialVersionUID = 8456035406644775338L;
	
	/** 订单主键*/
	private Long orderId;
	
	/** 订单PNR信息 */
	@FkId
	private FlightOrderPNRInfoDto flightOrderPNRInfo;

	/** 退票申请时间 */
	private Date applyRefundTime;

	/** 实际退票时间 */
	private Date factRefundTime;

	/** 退票金额 */
	private BigDecimal refundAmount;

	/** 退票变动利润 */
	private BigDecimal refundChangeProfit;

	/** 订单退票票号信息 */
	private List<FlightOrderTicketRefundDto> flightOrderTicketRefunds;

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public FlightOrderPNRInfoDto getFlightOrderPNRInfo() {
		return flightOrderPNRInfo;
	}

	public void setFlightOrderPNRInfo(FlightOrderPNRInfoDto flightOrderPNRInfo) {
		this.flightOrderPNRInfo = flightOrderPNRInfo;
	}

	public Date getApplyRefundTime() {
		return applyRefundTime;
	}

	public void setApplyRefundTime(Date applyRefundTime) {
		this.applyRefundTime = applyRefundTime;
	}

	public Date getFactRefundTime() {
		return factRefundTime;
	}

	public void setFactRefundTime(Date factRefundTime) {
		this.factRefundTime = factRefundTime;
	}

	public BigDecimal getRefundAmount() {
		return refundAmount;
	}

	public void setRefundAmount(BigDecimal refundAmount) {
		this.refundAmount = refundAmount;
	}

	public BigDecimal getRefundChangeProfit() {
		return refundChangeProfit;
	}

	public void setRefundChangeProfit(BigDecimal refundChangeProfit) {
		this.refundChangeProfit = refundChangeProfit;
	}

	public List<FlightOrderTicketRefundDto> getFlightOrderTicketRefunds() {
		return flightOrderTicketRefunds;
	}

	public void setFlightOrderTicketRefunds(
			List<FlightOrderTicketRefundDto> flightOrderTicketRefunds) {
		this.flightOrderTicketRefunds = flightOrderTicketRefunds;
	}
	
	@Override
	@JsonIgnore
	public String getSequence() {
		return "S_FORD_PNR_REFUND";
	}

}
