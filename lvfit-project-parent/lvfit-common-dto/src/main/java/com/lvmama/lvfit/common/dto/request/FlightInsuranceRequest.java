package com.lvmama.lvfit.common.dto.request;

import java.io.Serializable;

import com.lvmama.lvf.common.dto.enums.Status;

public class FlightInsuranceRequest implements Serializable {

    private static final long serialVersionUID = 6469340273231268214L;
    
    Status status;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
