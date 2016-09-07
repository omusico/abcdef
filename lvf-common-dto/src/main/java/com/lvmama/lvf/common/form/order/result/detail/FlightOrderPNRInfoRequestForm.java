package com.lvmama.lvf.common.form.order.result.detail;


import java.io.Serializable;

import com.lvmama.lvf.common.dto.Pagination;
import com.lvmama.lvf.common.dto.request.FlightOrderPNRInfoRequest;
import com.lvmama.lvf.common.form.Form;
/**
 * 订单PNR信息RequestForm
 * @author yangyongni
 * @date 2015-08-26
 */
public class FlightOrderPNRInfoRequestForm implements Serializable,Form{
	
	private static final long serialVersionUID = -8295610979314929573L;

	private FlightOrderPNRInfoRequest flightOrderPNRInfoRequest = new FlightOrderPNRInfoRequest();
	    
	private Pagination pagination = new Pagination();

	public FlightOrderPNRInfoRequest getFlightOrderPNRInfoRequest() {
		return flightOrderPNRInfoRequest;
	}

	public void setFlightOrderPNRInfoRequest(
			FlightOrderPNRInfoRequest flightOrderPNRInfoRequest) {
		this.flightOrderPNRInfoRequest = flightOrderPNRInfoRequest;
	}

	public Pagination getPagination() {
		return pagination;
	}

	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}
    
	public Long getPnrId() {
		return flightOrderPNRInfoRequest.getPnrId();
	}

	public void setPnrId(Long pnrId) {
		flightOrderPNRInfoRequest.setPnrId(pnrId);
	}

	public String getPnrTxt() {
		return flightOrderPNRInfoRequest.getPnrTxt();
	}

	public void setPnrTxt(String pnrTxt) {
		flightOrderPNRInfoRequest.setPnrTxt(pnrTxt);
	}
		
}
