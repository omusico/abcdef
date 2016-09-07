package com.lvmama.lvf.common.dto.request;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.lvmama.lvf.common.dto.BaseAuditRequest;
import com.lvmama.lvf.common.dto.order.FlightOrderDetailDto;
import com.lvmama.lvf.common.dto.supp.FlightOrderSuppOrderDto;


/**
 * 出票信息请求对象
 * 
 * @author chengyang
 */
public class FlightOrderTicketIssueRequest extends BaseAuditRequest implements Serializable {

	private static final long serialVersionUID = -3325846315049786255L;

	/** 是否申请审核 */
	private boolean isAudit;
	
	/** 订单明细信息 */
	private List<FlightOrderDetailDto> flightOrderDetails = new ArrayList<FlightOrderDetailDto>();
	/**供应商订单信息*/
	private FlightOrderSuppOrderDto flightOrderSuppOrderDto = new FlightOrderSuppOrderDto();
	
	public boolean isAudit() {
		return isAudit;
	}

	public void setAudit(boolean isAudit) {
		this.isAudit = isAudit;
	}

	public List<FlightOrderDetailDto> getFlightOrderDetails() {
		return flightOrderDetails;
	}

	public void setFlightOrderDetails(
			List<FlightOrderDetailDto> flightOrderDetails) {
		this.flightOrderDetails = flightOrderDetails;
	}
	/**供应商订单号*/
	public String getSuppOrderNo() {
		return flightOrderSuppOrderDto.getSuppOrderNo();
	}

	public void setSuppOrderNo(String suppOrderNo) {
		flightOrderSuppOrderDto.setSuppOrderNo(suppOrderNo);
	}

}
