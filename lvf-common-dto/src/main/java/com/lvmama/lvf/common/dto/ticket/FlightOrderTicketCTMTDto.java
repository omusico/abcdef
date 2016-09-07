package com.lvmama.lvf.common.dto.ticket;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import org.codehaus.jackson.annotate.JsonIgnore;
import com.lvmama.lvf.common.dto.Entity;
import com.lvmama.lvf.common.dto.status.detail.DetailAuditStatus;
import com.lvmama.lvf.common.dto.status.detail.DetailSuppAuditStatus;
import com.lvmama.lvf.common.dto.status.detail.DetailTicketStatus;

/**
 * CTMT改期改签申请审核处理信息
 * 
 * @author yuanweihong
 * @date 2015-2-9
 */
public class FlightOrderTicketCTMTDto extends Entity implements Serializable {

    private static final long serialVersionUID = 515696853711461318L;

    /** 订单明细主键 */
    private Long orderDetailId;
    
    /** 航班号 */
    private String ctmtOrderFlightNo;

    /** 出发日期 */
    private Date ctmtDepartureDate;

    /** 舱位 */
    private String ctmtSeatClassCode;

    /** 改期改签原因 */
    private String ctmtReason;

    /** PNR */
    private String ctmtPnr;

    /** 票号 */
    private String ctmtTicketNo;

    /** CTMT改期改签金额信息代理 */
    private FlightOrderTicketCTMTAmountDto flightOrderTicketCTMTAmountDto = new FlightOrderTicketCTMTAmountDto();

    /** 供应商政策NO */
    private String suppPolicyNo;

    /** 供应商(订单预订来源) */
    private String bookingSource;

    /** 审核操作ID */
    private Long auditOpId;

    /** 订单审核状态 */
    private DetailAuditStatus detailAuditStatus;

    /** 明细供应商审核状态 */
    private DetailSuppAuditStatus detailSuppAuditStatus;

    /** 订单出退改状态枚举 */
    private DetailTicketStatus detailTicketStatus;
    
    ///////////Ctrip///////////////
    /** 原航班号 */
    private String oldFlightNo;
    
    /** 供应商订单号 */
    private String suppOrderNo;
    
    /** 改签出发时间 */
    private String ctmtDepartureTime;
    
    /** 改签到达时间 */
    private String ctmtArrivalTime;

    public DetailTicketStatus getDetailTicketStatus() {
        return detailTicketStatus;
    }

    public void setDetailTicketStatus(DetailTicketStatus detailTicketStatus) {
        this.detailTicketStatus = detailTicketStatus;
    }

    public DetailAuditStatus getDetailAuditStatus() {
        return detailAuditStatus;
    }

    public void setDetailAuditStatus(DetailAuditStatus detailAuditStatus) {
        this.detailAuditStatus = detailAuditStatus;
    }

    public Long getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(Long orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public String getCtmtOrderFlightNo() {
        return ctmtOrderFlightNo;
    }

    public void setCtmtOrderFlightNo(String ctmtOrderFlightNo) {
        this.ctmtOrderFlightNo = ctmtOrderFlightNo;
    }

    public Date getCtmtDepartureDate() {
        return ctmtDepartureDate;
    }

    public void setCtmtDepartureDate(Date ctmtDepartureDate) {
        this.ctmtDepartureDate = ctmtDepartureDate;
    }

    public String getCtmtSeatClassCode() {
        return ctmtSeatClassCode;
    }

    public void setCtmtSeatClassCode(String ctmtSeatClassCode) {
        this.ctmtSeatClassCode = ctmtSeatClassCode;
    }

    public String getCtmtReason() {
        return ctmtReason;
    }

    public void setCtmtReason(String ctmtReason) {
        this.ctmtReason = ctmtReason;
    }

    public String getCtmtPnr() {
        return ctmtPnr;
    }

    public void setCtmtPnr(String ctmtPnr) {
        this.ctmtPnr = ctmtPnr;
    }

    public String getCtmtTicketNo() {
        return ctmtTicketNo;
    }

    public void setCtmtTicketNo(String ctmtTicketNo) {
        this.ctmtTicketNo = ctmtTicketNo;
    }

    public String getSuppPolicyNo() {
        return suppPolicyNo;
    }

    public void setSuppPolicyNo(String suppPolicyNo) {
        this.suppPolicyNo = suppPolicyNo;
    }

    public Long getAuditOpId() {
        return auditOpId;
    }

    public void setAuditOpId(Long auditOpId) {
        this.auditOpId = auditOpId;
    }

    public String getBookingSource() {
        return bookingSource;
    }

    public void setBookingSource(String bookingSource) {
        this.bookingSource = bookingSource;
    }

    public DetailSuppAuditStatus getDetailSuppAuditStatus() {
        return detailSuppAuditStatus;
    }

    public void setDetailSuppAuditStatus(DetailSuppAuditStatus detailSuppAuditStatus) {
        this.detailSuppAuditStatus = detailSuppAuditStatus;
    }

    public FlightOrderTicketCTMTAmountDto getFlightOrderTicketCTMTAmountDto() {
        return flightOrderTicketCTMTAmountDto;
    }

    public void setFlightOrderTicketCTMTAmountDto(
            FlightOrderTicketCTMTAmountDto flightOrderTicketCTMTAmountDto) {
        this.flightOrderTicketCTMTAmountDto = flightOrderTicketCTMTAmountDto;
    }

    public BigDecimal getFee() {
        return flightOrderTicketCTMTAmountDto.getFee();
    }

    public void setFee(BigDecimal fee) {
        flightOrderTicketCTMTAmountDto.setFee(fee);
    }

    public BigDecimal getSurcharge() {
        return flightOrderTicketCTMTAmountDto.getSurcharge();
    }

    public void setSurcharge(BigDecimal surcharge) {
        flightOrderTicketCTMTAmountDto.setSurcharge(surcharge);
    }

    public BigDecimal getPrepaidAmount() {
        return flightOrderTicketCTMTAmountDto.getPrepaidAmount();
    }

    public void setPrepaidAmount(BigDecimal prepaidAmount) {
        flightOrderTicketCTMTAmountDto.setPrepaidAmount(prepaidAmount);
    }

    public BigDecimal getPaiclupAmount() {
        return flightOrderTicketCTMTAmountDto.getPaiclupAmount();
    }

    public void setPaiclupAmount(BigDecimal paiclupAmount) {
        flightOrderTicketCTMTAmountDto.setPaiclupAmount(paiclupAmount);
    }

    public BigDecimal getPayedAmount() {
        return flightOrderTicketCTMTAmountDto.getPayedAmount();
    }

    public void setPayedAmount(BigDecimal payedAmount) {
        flightOrderTicketCTMTAmountDto.setPayedAmount(payedAmount);
    }
    
    public String getOldFlightNo() {
        return oldFlightNo;
    }

    public void setOldFlightNo(String oldFlightNo) {
        this.oldFlightNo = oldFlightNo;
    }

    public String getSuppOrderNo() {
        return suppOrderNo;
    }

    public void setSuppOrderNo(String suppOrderNo) {
        this.suppOrderNo = suppOrderNo;
    }

    public String getCtmtDepartureTime() {
        return ctmtDepartureTime;
    }

    public void setCtmtDepartureTime(String ctmtDepartureTime) {
        this.ctmtDepartureTime = ctmtDepartureTime;
    }
    
    public String getCtmtArrivalTime() {
        return ctmtArrivalTime;
    }

    public void setCtmtArrivalTime(String ctmtArrivalTime) {
        this.ctmtArrivalTime = ctmtArrivalTime;
    }

    @Override
    @JsonIgnore
    public String getSequence() {
        return "S_FORD_ORDER_DETAIL_CTMT";
    }

}
