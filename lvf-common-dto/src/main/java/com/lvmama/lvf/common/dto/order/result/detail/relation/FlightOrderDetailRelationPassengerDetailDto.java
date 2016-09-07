package com.lvmama.lvf.common.dto.order.result.detail.relation;

import com.lvmama.lvf.common.dto.order.FlightOrderPassengerDto;

import java.util.List;

/**
 * 订单详情关联详细信息,包括了乘客的详细信息.
 * Created by qinwen on 2015/10/22.
 */
public class FlightOrderDetailRelationPassengerDetailDto extends FlightOrderDetailRelationDetailDto{
    private List<FlightOrderPassengerDto> flightOrderPassengerDtos;

    public List<FlightOrderPassengerDto> getFlightOrderPassengerDtos() {
        return flightOrderPassengerDtos;
    }

    public void setFlightOrderPassengerDtos(List<FlightOrderPassengerDto> flightOrderPassengerDtos) {
        this.flightOrderPassengerDtos = flightOrderPassengerDtos;
    }
}
