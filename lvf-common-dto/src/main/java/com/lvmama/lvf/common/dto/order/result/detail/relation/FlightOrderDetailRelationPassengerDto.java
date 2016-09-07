package com.lvmama.lvf.common.dto.order.result.detail.relation;

import java.util.List;

/**
 * 订单详情关联,包含详细的乘客信息
 * Created by qinwen on 2015/10/23.
 */
public class FlightOrderDetailRelationPassengerDto extends FlightOrderDetailRelationDto {
    /** 订单关联明细信息包含详细乘客信息 */
    private List<FlightOrderDetailRelationPassengerDetailDto> flightOrderRelationPassengerDetails;

    public List<FlightOrderDetailRelationPassengerDetailDto> getFlightOrderRelationPassengerDetails() {
        return flightOrderRelationPassengerDetails;
    }

    public void setFlightOrderRelationPassengerDetails(List<FlightOrderDetailRelationPassengerDetailDto> flightOrderRelationPassengerDetails) {
        this.flightOrderRelationPassengerDetails = flightOrderRelationPassengerDetails;
    }
}
