package com.lvmama.lvf.common.dto.request;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.lvmama.lvf.common.dto.BaseAuditRequest;
import com.lvmama.lvf.common.dto.enums.BookingSource;
import com.lvmama.lvf.common.dto.order.FlightOrderDetailDto;
import com.lvmama.lvf.common.dto.order.FlightOrderRemarkDto;

/**
 * CTMT改期改签信息请求对象
 * 
 * @author yuanweihong
 * @date 2015-2-9
 */
public class FlightOrderTicketCTMTRequest extends BaseAuditRequest implements Serializable {

    private static final long serialVersionUID = 2625711936178334302L;

    /** 是否申请审核 */
    private boolean isAudit;

    /** 订单明细信息 */
    private List<FlightOrderDetailDto> flightOrderDetails = new ArrayList<FlightOrderDetailDto>();

    /** 订单备注信息 */
    private FlightOrderRemarkDto flightOrderRemark;
    
    /** 供应商订单号 */
    private String suppOrderNo;
    
    /** 改签操作渠道 */
	private BookingSource bookingSource;

    public boolean isAudit() {
        return isAudit;
    }

    public void setAudit(boolean isAudit) {
        this.isAudit = isAudit;
    }

    public List<FlightOrderDetailDto> getFlightOrderDetails() {
        return flightOrderDetails;
    }

    public void setFlightOrderDetails(List<FlightOrderDetailDto> flightOrderDetails) {
        this.flightOrderDetails = flightOrderDetails;
    }

    public FlightOrderRemarkDto getFlightOrderRemark() {
        return flightOrderRemark;
    }

    public void setFlightOrderRemark(FlightOrderRemarkDto flightOrderRemark) {
        this.flightOrderRemark = flightOrderRemark;
    }

    public String getSuppOrderNo() {
        return suppOrderNo;
    }

    public void setSuppOrderNo(String suppOrderNo) {
        this.suppOrderNo = suppOrderNo;
    }

	public BookingSource getBookingSource() {
		return bookingSource;
	}

	public void setBookingSource(BookingSource bookingSource) {
		this.bookingSource = bookingSource;
	}

}
