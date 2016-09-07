package com.lvmama.lvf.common.dto.request;

import com.lvmama.lvf.common.dto.Pagination;
import com.lvmama.lvf.common.dto.md.DateRange;
import com.lvmama.lvf.common.form.Form;


public class FlightOrderTicketPrintRequest implements Form {

    /** 分页参数 */
    private Pagination pagination;

    /** PNR编码 */
    private String pnr;

    /** 票号 */
    private String ticketNo;

    /** 乘客姓名 */
    private String passengerName;

    /** 出票时间范围 */
    private DateRange issueDateRange;

    /** 乘机时间范围 */
    private DateRange departureDateRange;

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

    public String getPnr() {
        return pnr;
    }

    public void setPnr(String pnr) {
        this.pnr = pnr;
    }

    public String getTicketNo() {
        return ticketNo;
    }

    public void setTicketNo(String ticketNo) {
        this.ticketNo = ticketNo;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public DateRange getIssueDateRange() {
        return issueDateRange;
    }

    public void setIssueDateRange(DateRange issueDateRange) {
        this.issueDateRange = issueDateRange;
    }

    public DateRange getDepartureDateRange() {
        return departureDateRange;
    }

    public void setDepartureDateRange(DateRange departureDateRange) {
        this.departureDateRange = departureDateRange;
    }
}
