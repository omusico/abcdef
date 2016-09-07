package com.lvmama.lvfit.common.dto.sdp.goods;

import java.io.Serializable;
import java.util.List;

public class FitSdpAdditonalDto implements Serializable {

    private static final long serialVersionUID = -8695066821783628818L;
    
    private FitSdpRoomDiff roomDiff;

    private List<FitSdpInsuranceDto> insuranceDto;
    
    private List<FitSdpOtherTicketDto> otherTicketDto;

    public List<FitSdpInsuranceDto> getInsuranceDto() {
        return insuranceDto;
    }

    public void setInsuranceDto(List<FitSdpInsuranceDto> insuranceDto) {
        this.insuranceDto = insuranceDto;
    }

    public List<FitSdpOtherTicketDto> getOtherTicketDto() {
        return otherTicketDto;
    }

    public void setOtherTicketDto(List<FitSdpOtherTicketDto> otherTicketDto) {
        this.otherTicketDto = otherTicketDto;
    }

    public FitSdpRoomDiff getRoomDiff() {
        return roomDiff;
    }

    public void setRoomDiff(FitSdpRoomDiff roomDiff) {
        this.roomDiff = roomDiff;
    }
}
