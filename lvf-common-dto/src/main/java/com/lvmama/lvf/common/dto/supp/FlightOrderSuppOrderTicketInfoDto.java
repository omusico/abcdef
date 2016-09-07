package com.lvmama.lvf.common.dto.supp;

import java.io.Serializable;
import java.util.Date;

import org.codehaus.jackson.annotate.JsonIgnore;

import com.lvmama.lvf.common.domain.FkId;
import com.lvmama.lvf.common.dto.Entity;
import com.lvmama.lvf.common.dto.enums.SuppTicketRefundStatus;
import com.lvmama.lvf.common.dto.order.FlightOrderTicketPriceDto;
import com.lvmama.lvf.common.dto.status.detail.DetailTicketStatus;

/**
 * 供应商订单票号信息
 * @author majun
 * @date   2015-2-4
 */
public class FlightOrderSuppOrderTicketInfoDto extends Entity implements Serializable 
{
	private static final long serialVersionUID = -2548282137532759910L;

	/** 供应商订单政策主键 */
	private Long suppOrderId;
	
	/** 供应商订单PNR信息 */
	@FkId
	private FlightOrderSuppOrderPNRInfoDto flightOrderSuppOrderPNRInfo;
	
	/** 供应商订单乘机人信息 */
	@FkId
	private FlightOrderSuppOrderPassengerDto flightOrderSuppOrderPassenger;
	
	/** 票号 */
	private String ticketNo;
	
	/** 票价信息 */
	private FlightOrderTicketPriceDto flightOrderTicketPrice;
	
	/** 票号状态 */
	private DetailTicketStatus detailTicketStatus;
	
	/** 有无退费票标志*/
    private SuppTicketRefundStatus suppTicketRefundStatus;
    
    /** 出票时间*/
    private Date issueTime;

	public DetailTicketStatus getDetailTicketStatus() {
		return detailTicketStatus;
	}

	public void setDetailTicketStatus(DetailTicketStatus detailTicketStatus) {
		this.detailTicketStatus = detailTicketStatus;
	}

	public Long getSuppOrderId() {
		return suppOrderId;
	}

	public void setSuppOrderId(Long suppOrderId) {
		this.suppOrderId = suppOrderId;
	}

	public FlightOrderSuppOrderPNRInfoDto getFlightOrderSuppOrderPNRInfo() {
		return flightOrderSuppOrderPNRInfo;
	}

	public void setFlightOrderSuppOrderPNRInfo(
			FlightOrderSuppOrderPNRInfoDto flightOrderSuppOrderPNRInfo) {
		this.flightOrderSuppOrderPNRInfo = flightOrderSuppOrderPNRInfo;
	}

	public FlightOrderSuppOrderPassengerDto getFlightOrderSuppOrderPassenger() {
		return flightOrderSuppOrderPassenger;
	}

	public void setFlightOrderSuppOrderPassenger(
			FlightOrderSuppOrderPassengerDto flightOrderSuppOrderPassenger) {
		this.flightOrderSuppOrderPassenger = flightOrderSuppOrderPassenger;
	}

	public String getTicketNo() {
		return ticketNo;
	}

	public void setTicketNo(String ticketNo) {
		this.ticketNo = ticketNo;
	}

	public FlightOrderTicketPriceDto getFlightOrderTicketPrice() {
		return flightOrderTicketPrice;
	}

	public void setFlightOrderTicketPrice(
			FlightOrderTicketPriceDto flightOrderTicketPrice) {
		this.flightOrderTicketPrice = flightOrderTicketPrice;
	}

    public SuppTicketRefundStatus getSuppTicketRefundStatus() {
        return suppTicketRefundStatus;
    }

    public void setSuppTicketRefundStatus(SuppTicketRefundStatus suppTicketRefundStatus) {
        this.suppTicketRefundStatus = suppTicketRefundStatus;
    }

    
    public Date getIssueTime() {
        return issueTime;
    }

    public void setIssueTime(Date issueTime) {
        this.issueTime = issueTime;
    }

    @Override
    @JsonIgnore
    public String getSequence() {
        return "S_FORD_SUPP_TICKET_INFO";
    }
    
    /**
     * 同步供应商订单票号信息(xslt)
     * 
     * @param newRequest
     *            供应商订单票号信息
     * @return void
     */
    public void copyFromDto(FlightOrderSuppOrderTicketInfoDto newRequest){
        this.setTicketNo(newRequest.getTicketNo());
        this.setFlightOrderTicketPrice(newRequest.getFlightOrderTicketPrice());
        this.setUpdateTime(new Date());
    }
	
}
