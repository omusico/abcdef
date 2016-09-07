package com.lvmama.lvfit.common.dto.app;

import com.lvmama.lvfit.common.dto.md.FlightCityDto;

import java.io.Serializable;
import java.util.List;

/**
 * Created by leizhengwei
 * 2016/8/11
 * 16:19
 */
public class FitAppFlightCityDto implements Serializable {

    private static final long serialVersionUID = 8753435952033729392L;

    private List<FlightCityDto> allFlightCityDtos;

    private List<FlightCityDto> hotFlightCityDtos;

    public List<FlightCityDto> getAllFlightCityDtos() {
        return allFlightCityDtos;
    }

    public void setAllFlightCityDtos(List<FlightCityDto> allFlightCityDtos) {
        this.allFlightCityDtos = allFlightCityDtos;
    }

    public List<FlightCityDto> getHotFlightCityDtos() {
        return hotFlightCityDtos;
    }

    public void setHotFlightCityDtos(List<FlightCityDto> hotFlightCityDtos) {
        this.hotFlightCityDtos = hotFlightCityDtos;
    }
}
