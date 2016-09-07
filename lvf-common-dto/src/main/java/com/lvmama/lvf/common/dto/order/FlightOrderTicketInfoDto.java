package com.lvmama.lvf.common.dto.order;

import java.io.Serializable;
import java.util.Date;

import org.codehaus.jackson.annotate.JsonIgnore;

import com.lvmama.lvf.common.domain.FkId;
import com.lvmama.lvf.common.dto.Entity;
import com.lvmama.lvf.common.dto.enums.FlightTripType;
import com.lvmama.lvf.common.dto.status.detail.DetailTicketStatus;

/**
 * 订单对应票价、乘机人相关信息
 * @author majun
 * @date   2015-1-13
 */
public class FlightOrderTicketInfoDto extends Entity implements Serializable 
{
	private static final long serialVersionUID = 1245999727243261072L;
	
	/** PNR信息 */
	@FkId
	private FlightOrderPNRInfoDto flightOrderPNRInfo;
	
	/** 乘客信息 */
	@FkId
	private FlightOrderPassengerDto flightOrderPassenger;
	
	/** 票号 */
	private String ticketNo;
	
	/** 航程类型 */
	private FlightTripType flightTripType;
	
	/** 订单航班信息 */
	@FkId
	private FlightOrderFlightInfoDto flightOrderFlightInfo;
	
	/** 票价信息 */
	private FlightOrderTicketPriceDto flightOrderTicketPrice;
	
	/** 发票信息 */
	private FlightOrderInvoiceDto flightOrderInvoices;

    /** 出票时间 */
    private Date issueDate;

    /** officeNO */
    private String officeNo;
    
    /** 票号状态 */
    private DetailTicketStatus detailTicketStatus;

	public DetailTicketStatus getDetailTicketStatus() {
		return detailTicketStatus;
	}

	public void setDetailTicketStatus(DetailTicketStatus detailTicketStatus) {
		this.detailTicketStatus = detailTicketStatus;
	}

	public FlightOrderPNRInfoDto getFlightOrderPNRInfo() {
		return flightOrderPNRInfo;
	}

	public void setFlightOrderPNRInfo(FlightOrderPNRInfoDto flightOrderPNRInfo) {
		this.flightOrderPNRInfo = flightOrderPNRInfo;
	}

	public String getTicketNo() {
		return ticketNo;
	}

	public void setTicketNo(String ticketNo) {
		this.ticketNo = ticketNo;
	}

	public FlightTripType getFlightTripType() {
		return flightTripType;
	}

	public void setFlightTripType(FlightTripType flightTripType) {
		this.flightTripType = flightTripType;
	}

	public FlightOrderFlightInfoDto getFlightOrderFlightInfo() {
		return flightOrderFlightInfo;
	}

	public void setFlightOrderFlightInfo(
			FlightOrderFlightInfoDto flightOrderFlightInfo) {
		this.flightOrderFlightInfo = flightOrderFlightInfo;
	}

	public FlightOrderTicketPriceDto getFlightOrderTicketPrice() {
		return flightOrderTicketPrice;
	}

	public void setFlightOrderTicketPrice(
			FlightOrderTicketPriceDto flightOrderTicketPrice) {
		this.flightOrderTicketPrice = flightOrderTicketPrice;
	}

	public FlightOrderPassengerDto getFlightOrderPassenger() {
		return flightOrderPassenger;
	}

	public void setFlightOrderPassenger(FlightOrderPassengerDto flightOrderPassenger) {
		this.flightOrderPassenger = flightOrderPassenger;
	}

	public FlightOrderInvoiceDto getFlightOrderInvoices() {
		return flightOrderInvoices;
	}

	public void setFlightOrderInvoices(FlightOrderInvoiceDto flightOrderInvoices) {
		this.flightOrderInvoices = flightOrderInvoices;
	}

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public String getOfficeNo() {
        return officeNo;
    }

    public void setOfficeNo(String officeNo) {
        this.officeNo = officeNo;
    }
    
    @Override
    @JsonIgnore
    public String getSequence() {
    	return "S_FORD_TICKET_INFO";
    }
}
