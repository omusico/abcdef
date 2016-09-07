package com.lvmama.lvf.common.dto.request;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import com.lvmama.lvf.common.dto.BaseAuditRequest;
import com.lvmama.lvf.common.dto.order.FlightOrderDetailDto;

/**
 * 重新下单请求对象
 * 
 * @author yuanweihong
 * @date 2015-7-27
 */
public class FlightOrderBookingAgainRequest extends BaseAuditRequest implements Serializable {

    private static final long serialVersionUID = -2225119109460992439L;

    /** 订单明细信息 */
    private List<FlightOrderDetailDto> flightOrderDetails = new ArrayList<FlightOrderDetailDto>();

    public List<FlightOrderDetailDto> getFlightOrderDetails() {
        return flightOrderDetails;
    }

    public void setFlightOrderDetails(List<FlightOrderDetailDto> flightOrderDetails) {
        this.flightOrderDetails = flightOrderDetails;
    }

}
