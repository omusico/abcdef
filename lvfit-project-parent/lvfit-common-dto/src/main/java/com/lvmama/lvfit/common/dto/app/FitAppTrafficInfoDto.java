package com.lvmama.lvfit.common.dto.app;

import java.io.Serializable;

import com.lvmama.lvfit.common.dto.search.flight.result.FlightSearchFlightInfoDto;


/**
 * Created by leizhengwei
 * 2016/7/14
 * 0:37
 */
public class FitAppTrafficInfoDto implements Serializable {

    private static final long serialVersionUID = -227806541321117683L;

    /**选中的航班号 */
    private String flightNo;

    /**选中的舱位 */
    private String seatCode;

    /**出发日期 */
    private String depDate;
    /**机+酒 航班信息对象*/
    private FlightSearchFlightInfoDto searchFlightInfoDto;

    public String getFlightNo() {
        return flightNo;
    }

    public void setFlightNo(String flightNo) {
        this.flightNo = flightNo;
    }

    public String getSeatCode() {
        return seatCode;
    }

    public void setSeatCode(String seatCode) {
        this.seatCode = seatCode;
    }

    public String getDepDate() {
        return depDate;
    }

    public void setDepDate(String depDate) {
        this.depDate = depDate;
    }

	public FlightSearchFlightInfoDto getSearchFlightInfoDto() {
		return searchFlightInfoDto;
	}

	public void setSearchFlightInfoDto(FlightSearchFlightInfoDto searchFlightInfoDto) {
		this.searchFlightInfoDto = searchFlightInfoDto;
	}
}
