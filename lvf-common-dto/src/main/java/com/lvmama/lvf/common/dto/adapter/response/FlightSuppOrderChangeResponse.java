package com.lvmama.lvf.common.dto.adapter.response;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 国内机票可改航班查询信息返回对象
 * 
 * @author yuanweihong
 * @date 2015-9-23
 */
@XmlRootElement
public class FlightSuppOrderChangeResponse implements Serializable {

    private static final long serialVersionUID = -2352311345252403591L;

    /** 国内机票可改航班查询信息列表 */
    private List<FlightSuppOrderChangeInfoDto> flightSuppOrderChangeInfoDtos;

    public List<FlightSuppOrderChangeInfoDto> getFlightSuppOrderChangeInfoDtos() {
        return flightSuppOrderChangeInfoDtos;
    }

    public void setFlightSuppOrderChangeInfoDtos(
            List<FlightSuppOrderChangeInfoDto> flightSuppOrderChangeInfoDtos) {
        this.flightSuppOrderChangeInfoDtos = flightSuppOrderChangeInfoDtos;
    }

}
