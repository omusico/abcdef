package com.lvmama.lvf.common.form.ticket;

import com.lvmama.lvf.common.dto.request.FlightOrderTicketPrintRequest;
import com.lvmama.lvf.common.form.Form;


public class TicketPrintInputForm implements Form {

    private FlightOrderTicketPrintRequest request;

    public FlightOrderTicketPrintRequest getRequest() {
        return request;
    }

    public void setRequest(FlightOrderTicketPrintRequest request) {
        this.request = request;
    }
}
