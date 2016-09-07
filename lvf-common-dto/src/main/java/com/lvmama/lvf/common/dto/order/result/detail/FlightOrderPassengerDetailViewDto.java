package com.lvmama.lvf.common.dto.order.result.detail;

import com.lvmama.lvf.common.dto.order.result.detail.relation.FlightOrderDetailRelationDto;
import com.lvmama.lvf.common.dto.order.result.detail.relation.FlightOrderDetailRelationPassengerDto;

import java.util.List;

/**
 * Created by qinwen on 2015/10/23.
 */
public class FlightOrderPassengerDetailViewDto {

    private FlightOrderDetailViewDto flightOrderDetailViewDto;

    /**
     * 同主单订单列表,包含乘客详细信息
     */
    private List<FlightOrderDetailRelationPassengerDto> sameOrderPassengerDetailRelations;

    /**
     * 关联订单列表,包含乘客详细信息
     */
    private List<FlightOrderDetailRelationPassengerDto> flightOrderPassengerDetailRelations;

    public FlightOrderPassengerDetailViewDto(FlightOrderDetailViewDto flightOrderDetailViewDto) {
        this.flightOrderDetailViewDto = flightOrderDetailViewDto;
    }

    public FlightOrderDetailViewDto getFlightOrderDetailViewDto() {
        return flightOrderDetailViewDto;
    }

    public void setFlightOrderDetailViewDto(FlightOrderDetailViewDto flightOrderDetailViewDto) {
        this.flightOrderDetailViewDto = flightOrderDetailViewDto;
    }

    public List<FlightOrderDetailRelationPassengerDto> getSameOrderPassengerDetailRelations() {
        return sameOrderPassengerDetailRelations;
    }

    public void setSameOrderPassengerDetailRelations(List<FlightOrderDetailRelationPassengerDto> sameOrderPassengerDetailRelations) {
        this.sameOrderPassengerDetailRelations = sameOrderPassengerDetailRelations;
    }

    public List<FlightOrderDetailRelationPassengerDto> getFlightOrderPassengerDetailRelations() {
        return flightOrderPassengerDetailRelations;
    }

    public void setFlightOrderPassengerDetailRelations(List<FlightOrderDetailRelationPassengerDto> flightOrderPassengerDetailRelations) {
        this.flightOrderPassengerDetailRelations = flightOrderPassengerDetailRelations;
    }

    public FlightOrderDetailBaseDto getFlightOrderDetailBase() {
        return flightOrderDetailViewDto.getFlightOrderDetailBase();
    }

    public void setFlightOrderDetailBase(FlightOrderDetailBaseDto flightOrderDetailBase) {
        flightOrderDetailViewDto.setFlightOrderDetailBase(flightOrderDetailBase);
    }

    public List<FlightOrderDetailRelationDto> getSameOrderDetailRelations() {
        return flightOrderDetailViewDto.getSameOrderDetailRelations();
    }

    public void setSameOrderDetailRelations(List<FlightOrderDetailRelationDto> sameOrderDetailRelations) {
        flightOrderDetailViewDto.setSameOrderDetailRelations(sameOrderDetailRelations);
    }

    public List<FlightOrderDetailRelationDto> getFlightOrderDetailRelations() {
        return flightOrderDetailViewDto.getFlightOrderDetailRelations();
    }

    public void setFlightOrderDetailRelations(List<FlightOrderDetailRelationDto> flightOrderDetailRelations) {
        flightOrderDetailViewDto.setFlightOrderDetailRelations(flightOrderDetailRelations);
    }

    public FlightOrderDetailInfoDto getFlightOrderDetailInfo() {
        return flightOrderDetailViewDto.getFlightOrderDetailInfo();
    }

    public void setFlightOrderDetailInfo(FlightOrderDetailInfoDto flightOrderDetailInfo) {
        flightOrderDetailViewDto.setFlightOrderDetailInfo(flightOrderDetailInfo);
    }

    public void generateRelationOrdersBySameOrders(Long orderId) {
        flightOrderDetailViewDto.generateRelationOrdersBySameOrders(orderId);
    }
}
