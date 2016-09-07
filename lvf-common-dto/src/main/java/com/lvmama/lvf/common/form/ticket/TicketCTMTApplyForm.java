package com.lvmama.lvf.common.form.ticket;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.lvmama.lvf.common.dto.Pagination;
import com.lvmama.lvf.common.dto.enums.FlightTripType;
import com.lvmama.lvf.common.dto.order.FlightOrderDetailDto;
import com.lvmama.lvf.common.dto.order.FlightOrderRemarkDto;
import com.lvmama.lvf.common.dto.request.FlightOrderTicketCTMTRequest;
import com.lvmama.lvf.common.dto.ticket.FlightOrderTicketCTMTDto;
import com.lvmama.lvf.common.form.Form;

/**
 * CTMT改期改签信息申请From
 * 
 * @author yuanweihong
 * @date 2015-4-8
 */
public class TicketCTMTApplyForm implements Serializable, Form {

    private static final long serialVersionUID = -946862050634698329L;

    private FlightOrderTicketCTMTRequest request = new FlightOrderTicketCTMTRequest();
    
    private Pagination pagination = new Pagination();

    /** 改签航班号 */
    private String flightNo;

    /** 出发日期 */
    private Date departDate;

    /** 舱位 */
    private String seatClassCode;

    /** 改签原因 */
    private String reason;
    
    /**回程航班号*/
    private String returnFlightNo;
    /**回程起飞日期*/
    private Date returnDate;
    /**回程舱位*/
    private String returnSeatClassCode;
    /**回程改签原因*/
    private String returnReason;
    
    ///////////Ctrip供应商改签申请///////////////
    /** 原航班号 */
    private String oldFlightNo;
    
    /** 出发城市 */
    private String depCityName;
    
    /** 到达城市 */
    private String arrCityName;    
    
    /** 改签出发时间 */
    private String departTime;
    
    /** 改签到达时间 */
    private String arrivalTime;

    public FlightOrderTicketCTMTRequest getRequest() {
        if (this.request != null) {
            // 设置改签航班等信息
            for (FlightOrderDetailDto detailDto : this.request.getFlightOrderDetails()) {
                FlightOrderTicketCTMTDto temCtmtDto = detailDto.getFlightOrderTicketCTMT();
                FlightOrderTicketCTMTDto ctmtDto = new FlightOrderTicketCTMTDto();
                if(FlightTripType.RETURN.equals(detailDto.getCombinationDetail().getFlightTripType())){
                	ctmtDto.setCtmtOrderFlightNo(this.getReturnFlightNo());
                	ctmtDto.setCtmtDepartureDate(this.getReturnDate());
                	ctmtDto.setCtmtSeatClassCode(this.getReturnSeatClassCode());
                	ctmtDto.setCtmtReason(this.getReturnReason());
                }else{
                	ctmtDto.setCtmtOrderFlightNo(this.getFlightNo());
                	ctmtDto.setCtmtDepartureDate(this.getDepartDate());
                	ctmtDto.setCtmtSeatClassCode(this.getSeatClassCode());
                	ctmtDto.setCtmtReason(this.getReason());
                }
                //////////////////Ctrip///////////////////
                ctmtDto.setOldFlightNo(this.getOldFlightNo());
                ctmtDto.setSuppOrderNo(this.getSuppOrderNo());
                ctmtDto.setPayedAmount(temCtmtDto == null ? null : temCtmtDto.getPayedAmount());
                ctmtDto.setCtmtDepartureTime(this.getDepartTime());
                ctmtDto.setCtmtArrivalTime(this.getArrivalTime());
                detailDto.setFlightOrderTicketCTMT(ctmtDto);
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

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

    public int getPage() {
        return pagination.getPage();
    }

    public void setPage(int page) {
        pagination.setPage(page);
    }

    public int getRows() {
        return pagination.getRows();
    }

    public void setRows(int rows) {
        pagination.setRows(rows);
    }

    public void setRowsByCustom(int customRows) {
        pagination.setRowsByCustom(customRows);
    }

    public int getRecords() {
        return pagination.getRecords();
    }

    public void setRecords(int records) {
        pagination.setRecords(records);
    }

    public int getTotal() {
        return pagination.getTotal();
    }

    public void setTotal(int total) {
        pagination.setTotal(total);
    }

    public String getSidx() {
        return pagination.getSidx();
    }

    public void setSidx(String sidx) {
        pagination.setSidx(sidx);
    }

    public String getSord() {
        return pagination.getSord();
    }

    public void setSord(String sord) {
        pagination.setSord(sord);
    }

    public int getStartRow() {
        return pagination.getStartRow();
    }

    public int getEndRow() {
        return pagination.getEndRow();
    }

    public void setSearch(boolean search) {
        pagination.setSearch(search);
    }

    public String getDepCityName() {
        return depCityName;
    }

    public void setDepCityName(String depCityName) {
        this.depCityName = depCityName;
    }

    public String getArrCityName() {
        return arrCityName;
    }

    public void setArrCityName(String arrCityName) {
        this.arrCityName = arrCityName;
    }

    public String getOldFlightNo() {
        return oldFlightNo;
    }

    public void setOldFlightNo(String oldFlightNo) {
        this.oldFlightNo = oldFlightNo;
    }

    public String getSuppOrderNo() {
        return request.getSuppOrderNo();
    }

    public void setSuppOrderNo(String suppOrderNo) {
        request.setSuppOrderNo(suppOrderNo);
    }

    public String getDepartTime() {
        return departTime;
    }

    public void setDepartTime(String departTime) {
        this.departTime = departTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
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

	public String getReturnSeatClassCode() {
		return returnSeatClassCode;
	}

	public void setReturnSeatClassCode(String returnSeatClassCode) {
		this.returnSeatClassCode = returnSeatClassCode;
	}

	public String getReturnReason() {
		return returnReason;
	}

	public void setReturnReason(String returnReason) {
		this.returnReason = returnReason;
	}
    
}
