package com.lvmama.lvf.common.dto.order;

import java.io.Serializable;

import com.lvmama.lvf.common.dto.enums.InvoiceType;
import com.lvmama.lvf.common.dto.order.status.InvoiceStatus;

/**
 * 发票信息
 * @author majun
 * @date   2015-1-13
 */
public class FlightOrderInvoiceDto implements Serializable 
{
	private static final long serialVersionUID = -8795493120973966706L;
	
	/** 票号 */
	private String flightTicketNo;
	
	/** 发票号 */
	private String invoiceNo;
	
	/** 发票类型 */
	private InvoiceType invoiceType;
	
	/** 发票状态 */
	private InvoiceStatus invoiceStatus;

	public String getFlightTicketNo() {
		return flightTicketNo;
	}

	public void setFlightTicketNo(String flightTicketNo) {
		this.flightTicketNo = flightTicketNo;
	}

	public String getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public InvoiceType getInvoiceType() {
		return invoiceType;
	}

	public void setInvoiceType(InvoiceType invoiceType) {
		this.invoiceType = invoiceType;
	}

	public InvoiceStatus getInvoiceStatus() {
		return invoiceStatus;
	}

	public void setInvoiceStatus(InvoiceStatus invoiceStatus) {
		this.invoiceStatus = invoiceStatus;
	}
}
