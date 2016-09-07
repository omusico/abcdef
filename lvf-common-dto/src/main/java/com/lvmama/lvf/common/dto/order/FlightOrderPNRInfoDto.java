package com.lvmama.lvf.common.dto.order;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnore;

import com.lvmama.lvf.common.domain.FkId;
import com.lvmama.lvf.common.dto.Entity;
import com.lvmama.lvf.common.dto.enums.SelfType;
import com.lvmama.lvf.common.dto.status.order.OrderBookingStatus;
import com.lvmama.lvf.common.dto.supp.FlightOrderSuppOrderPNRInfoDto;

/**
 * 订单对应PNR相关信息
 * @author majun
 * @date 2015-1-13
 */
public class FlightOrderPNRInfoDto extends Entity implements Serializable 
{
	private static final long serialVersionUID = 2283091511450191147L;
	
	/** 主订单主键 */
	private Long orderMainId;
	
	/** 订单政策信息 */
	@FkId
	private FlightOrderFlightPolicyDto flightOrderFlightPolicy;

	/** 订单资源采购类型 */
	private SelfType selfType;

	/** PNR编码 */
	private String pnr;

	/** oldPNR(新加) */
	private String oldPnr;

	/** 订位状态*/
	private OrderBookingStatus orderBookingStatus;
	
	/** PNR文本 */
	private String pnrTxt;
	
	/** PATA文本 */
	private String pataTxt;
	
	 /** 订单对应的票号信息 */
    private List<FlightOrderTicketInfoDto> flightOrderTicketInfos = new ArrayList<FlightOrderTicketInfoDto>();
    
    /** 订单PNR退票信息 */
    private List<FlightOrderPNRRefundDto> flightOrderPNRRefunds = new ArrayList<FlightOrderPNRRefundDto>();

	public OrderBookingStatus getOrderBookingStatus() {
		return orderBookingStatus;
	}

	public void setOrderBookingStatus(OrderBookingStatus orderBookingStatus) {
		this.orderBookingStatus = orderBookingStatus;
	}

	public Long getOrderMainId() {
		return orderMainId;
	}

	public void setOrderMainId(Long orderMainId) {
		this.orderMainId = orderMainId;
	}

	public FlightOrderFlightPolicyDto getFlightOrderFlightPolicy() {
		return flightOrderFlightPolicy;
	}

	public void setFlightOrderFlightPolicy(
			FlightOrderFlightPolicyDto flightOrderFlightPolicy) {
		this.flightOrderFlightPolicy = flightOrderFlightPolicy;
	}

	public SelfType getSelfType() {
		return selfType;
	}

	public void setSelfType(SelfType selfType) {
		this.selfType = selfType;
	}

	public String getPnr() {
		return pnr;
	}

	public void setPnr(String pnr) {
		this.pnr = pnr;
	}

	public String getOldPnr() {
		return oldPnr;
	}

	public void setOldPnr(String oldPnr) {
		this.oldPnr = oldPnr;
	}

	public String getPnrTxt() {
		return pnrTxt;
	}

	public void setPnrTxt(String pnrTxt) {
		this.pnrTxt = pnrTxt;
	}

	public String getPataTxt() {
		return pataTxt;
	}

	public void setPataTxt(String pataTxt) {
		this.pataTxt = pataTxt;
	}

	public List<FlightOrderTicketInfoDto> getFlightOrderTicketInfos() {
		return flightOrderTicketInfos;
	}

	public void setFlightOrderTicketInfos(
			List<FlightOrderTicketInfoDto> flightOrderTicketInfos) {
		this.flightOrderTicketInfos = flightOrderTicketInfos;
	}

	public List<FlightOrderPNRRefundDto> getFlightOrderPNRRefunds() {
		return flightOrderPNRRefunds;
	}

	public void setFlightOrderPNRRefunds(
			List<FlightOrderPNRRefundDto> flightOrderPNRRefunds) {
		this.flightOrderPNRRefunds = flightOrderPNRRefunds;
	}

	@Override
	@JsonIgnore
	public String getSequence() {
		return "S_FORD_PNR_INFO";
	}

    /**
     * 同步供应商订单PNR信息(xslt)
     * 
     * @param newSuppPnrDto
     *            供应商订单PNR信息
     * @return void
     */
    public void copyFromDto(FlightOrderSuppOrderPNRInfoDto newSuppPnrDto) {
        this.setOldPnr(newSuppPnrDto.getOldPnr());
        this.setPataTxt(newSuppPnrDto.getPataTxt());
        this.setPnr(newSuppPnrDto.getPnr());
        this.setPnrTxt(newSuppPnrDto.getPnrTxt());
        this.setUpdateTime(new Date());
    }
}
