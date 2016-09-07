package com.lvmama.lvf.common.form.ticket;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.util.StringUtils;

import com.lvmama.lvf.common.dto.enums.FlightTripType;
import com.lvmama.lvf.common.dto.enums.PassengerType;
import com.lvmama.lvf.common.dto.order.FlightOrderDetailDto;
import com.lvmama.lvf.common.dto.order.FlightOrderRemarkDto;
import com.lvmama.lvf.common.dto.request.FlightOrderTicketCTMTRequest;
import com.lvmama.lvf.common.dto.ticket.FlightOrderTicketCTMTDto;
import com.lvmama.lvf.common.form.Form;
import com.lvmama.lvf.common.utils.DateUtils;
import com.lvmama.lvf.common.utils.StringUtil;

/**
 * CTMT改期改签审核处理信息From
 * 
 * @author yuanweihong
 * @date 2015-4-8
 */
public class TicketCTMTForm implements Serializable, Form {

    private static final long serialVersionUID = -946862050634698329L;

    private FlightOrderTicketCTMTRequest request = new FlightOrderTicketCTMTRequest();

    /** 航班号 */
    private String flightNo;

    /** 出发日期 */
    private Date departDate;
    
    private String departTime;

    /** 舱位 */
    private String seatClassCode;
    
    private String returnFlightNo;
    private Date returnDate;
    private String returnTime;
    private String returnSeatClassCode;
    
    /**乘客类型 */
    private PassengerType passengerType;

    public FlightOrderTicketCTMTRequest getRequest() {
        if (this.request != null) {
            // 设置改签航班信息
            for (FlightOrderDetailDto detailDto : this.request.getFlightOrderDetails()) {
                FlightOrderTicketCTMTDto ctmtDto = detailDto.getFlightOrderTicketCTMT();
                if(null != detailDto.getCombinationDetail() && FlightTripType.RETURN.equals(detailDto.getCombinationDetail().getFlightTripType())){
                	ctmtDto.setCtmtOrderFlightNo(this.getReturnFlightNo());
                	ctmtDto.setCtmtDepartureDate(this.getReturnDate());
                	if(StringUtil.isNotEmptyString(this.getReturnTime()))
                	{
                		ctmtDto.setCtmtDepartureDate(DateUtils.parseDate(DateUtils.formatDate(this.getReturnDate()) + " " + this.getReturnTime(), DateUtils.YYYY_MM_DD_HH_MM));
                	}
                	ctmtDto.setCtmtSeatClassCode(this.getReturnSeatClassCode());
                }else{
                	ctmtDto.setCtmtOrderFlightNo(this.getFlightNo());
                	ctmtDto.setCtmtDepartureDate(this.getDepartDate());
                	if(StringUtil.isNotEmptyString(this.getDepartTime()))
                	{
                		ctmtDto.setCtmtDepartureDate(DateUtils.parseDate(DateUtils.formatDate(this.getDepartDate()) + " " + this.getDepartTime(), DateUtils.YYYY_MM_DD_HH_MM));
                	}
                	ctmtDto.setCtmtSeatClassCode(this.getSeatClassCode());
                }
            }
        }
        return request;
    }

    public void setRequest(FlightOrderTicketCTMTRequest request) {
        this.request = request;
    }

    public Long getAuditOpId() {
        return request.getAuditOpId();
    }

    public void setAuditOpId(Long auditOpId) {
        request.setAuditOpId(auditOpId);
    }

    public Long getOrderMainId() {
        return request.getOrderMainId();
    }

    public void setOrderMainId(Long orderMainId) {
        request.setOrderMainId(orderMainId);
    }

    public Long getOrderId() {
        return request.getOrderId();
    }

    public void setOrderId(Long orderId) {
        request.setOrderId(orderId);
    }

    public boolean isAudit() {
        return request.isAudit();
    }

    public void setAudit(boolean isAudit) {
        request.setAudit(isAudit);
    }

    public List<FlightOrderDetailDto> getFlightOrderDetails() {
        return request.getFlightOrderDetails();
    }

    public void setFlightOrderDetails(List<FlightOrderDetailDto> flightOrderDetails) {
        request.setFlightOrderDetails(flightOrderDetails);
    }

    public FlightOrderRemarkDto getFlightOrderRemark() {
        return request.getFlightOrderRemark();
    }

    public void setFlightOrderRemark(FlightOrderRemarkDto flightOrderRemark) {
        request.setFlightOrderRemark(flightOrderRemark);
    }
    /**供应商订单号*/
    public String getSuppOrderNo() {
		return request.getSuppOrderNo();
	}

	public void setSuppOrderNo(String suppOrderNo) {
		request.setSuppOrderNo(suppOrderNo);
	}

	public String getFlightNo() {
        return flightNo;
    }

    public void setFlightNo(String flightNo) {
        this.flightNo = flightNo;
    }

    public Date getDepartDate() {
        return departDate;
    }

    public void setDepartDate(Date departDate) {
        this.departDate = departDate;
    }

    public String getSeatClassCode() {
        return seatClassCode;
    }

    public void setSeatClassCode(String seatClassCode) {
        this.seatClassCode = seatClassCode;
    }

    public PassengerType getPassengerType() {
        return passengerType;
    }

    public void setPassengerType(PassengerType passengerType) {
        this.passengerType = passengerType;
    }

	public String getDepartTime() {
		return departTime;
	}

	public void setDepartTime(String departTime) {
		this.departTime = departTime;
	}

	public String getReturnFlightNo() {
		return returnFlightNo;
	}

	public void setReturnFlightNo(String returnFlightNo) {
		this.returnFlightNo = returnFlightNo;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public String getReturnTime() {
		return returnTime;
	}

	public void setReturnTime(String returnTime) {
		this.returnTime = returnTime;
	}

	public String getReturnSeatClassCode() {
		return returnSeatClassCode;
	}

	public void setReturnSeatClassCode(String returnSeatClassCode) {
		this.returnSeatClassCode = returnSeatClassCode;
	}

    
}
