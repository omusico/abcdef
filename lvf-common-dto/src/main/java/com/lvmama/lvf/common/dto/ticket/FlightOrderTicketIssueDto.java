package com.lvmama.lvf.common.dto.ticket;

import java.io.Serializable;
import java.math.BigDecimal;
import org.codehaus.jackson.annotate.JsonIgnore;
import com.lvmama.lvf.common.dto.Entity;
import com.lvmama.lvf.common.dto.enums.AutoPrintTicket;
import com.lvmama.lvf.common.dto.status.detail.DetailAuditStatus;
import com.lvmama.lvf.common.dto.status.detail.DetailSuppAuditStatus;
import com.lvmama.lvf.common.dto.status.detail.DetailTicketStatus;

/**
 * 出票信息
 * 
 * @author chengyang
 * 
 */
public class FlightOrderTicketIssueDto extends Entity implements Serializable {

    private static final long serialVersionUID = -432337450764083008L;

    /** 订单明细主键 */
    private Long orderDetailId;

    /** PNR */
    private String issuePnr;

    /** 票号 */
    private String issueTicketNo;

    /** 出票金额信息代理 */
    private FlightOrderTicketIssueAmountDto flightOrderTicketIssueAmountDto = new FlightOrderTicketIssueAmountDto();

    /** 供应商(订单预订来源) */
    private String bookingSource;

    /** 供应商政策NO */
    private String suppPolicyNo;

    /** 审核操作ID */
    private Long auditOpId;

    /** 订单审核状态 */
    private DetailAuditStatus detailAuditStatus;

    /** 明细供应商审核状态 */
    private DetailSuppAuditStatus detailSuppAuditStatus;

    /** 订单出退改状态枚举 */
    private DetailTicketStatus detailTicketStatus;

    /** 出票模式 */
    private AutoPrintTicket autoPrintTicket = AutoPrintTicket.CC_PRINT_TICKET;

    public Long getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(Long orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public String getIssuePnr() {
        return issuePnr;
    }

    public void setIssuePnr(String issuePnr) {
        this.issuePnr = issuePnr;
    }

    public String getIssueTicketNo() {
        return issueTicketNo;
    }

    public void setIssueTicketNo(String issueTicketNo) {
        this.issueTicketNo = issueTicketNo;
    }

    public String getBookingSource() {
        return bookingSource;
    }

    public void setBookingSource(String bookingSource) {
        this.bookingSource = bookingSource;
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

    public DetailAuditStatus getDetailAuditStatus() {
        return detailAuditStatus;
    }

    public void setDetailAuditStatus(DetailAuditStatus detailAuditStatus) {
        this.detailAuditStatus = detailAuditStatus;
    }

    public DetailTicketStatus getDetailTicketStatus() {
        return detailTicketStatus;
    }

    public void setDetailTicketStatus(DetailTicketStatus detailTicketStatus) {
        this.detailTicketStatus = detailTicketStatus;
    }

    public AutoPrintTicket getAutoPrintTicket() {
        return autoPrintTicket;
    }

    public void setAutoPrintTicket(AutoPrintTicket autoPrintTicket) {
        this.autoPrintTicket = autoPrintTicket;
    }

    public DetailSuppAuditStatus getDetailSuppAuditStatus() {
        return detailSuppAuditStatus;
    }

    public void setDetailSuppAuditStatus(DetailSuppAuditStatus detailSuppAuditStatus) {
        this.detailSuppAuditStatus = detailSuppAuditStatus;
    }

    public FlightOrderTicketIssueAmountDto getFlightOrderTicketIssueAmountDto() {
        return flightOrderTicketIssueAmountDto;
    }

    public void setFlightOrderTicketIssueAmountDto(
            FlightOrderTicketIssueAmountDto flightOrderTicketIssueAmountDto) {
        this.flightOrderTicketIssueAmountDto = flightOrderTicketIssueAmountDto;
    }

    public BigDecimal getFee() {
        return flightOrderTicketIssueAmountDto.getFee();
    }

    public void setFee(BigDecimal fee) {
        flightOrderTicketIssueAmountDto.setFee(fee);
    }

    public BigDecimal getSurcharge() {
        return flightOrderTicketIssueAmountDto.getSurcharge();
    }

    public void setSurcharge(BigDecimal surcharge) {
        flightOrderTicketIssueAmountDto.setSurcharge(surcharge);
    }

    public BigDecimal getPaiclupAmount() {
        return flightOrderTicketIssueAmountDto.getPaiclupAmount();
    }

    public void setPaiclupAmount(BigDecimal paiclupAmount) {
        flightOrderTicketIssueAmountDto.setPaiclupAmount(paiclupAmount);
    }

    public BigDecimal getPayedAmount() {
        return flightOrderTicketIssueAmountDto.getPayedAmount();
    }

    public void setPayedAmount(BigDecimal payedAmount) {
        flightOrderTicketIssueAmountDto.setPayedAmount(payedAmount);
    }

    @Override
    @JsonIgnore
    public String getSequence() {
        return "T_FORD_ORDER_DETAIL_ISSUE";
    }
}
