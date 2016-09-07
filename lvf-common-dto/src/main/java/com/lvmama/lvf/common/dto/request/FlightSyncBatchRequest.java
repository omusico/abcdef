package com.lvmama.lvf.common.dto.request;

import java.io.Serializable;
import java.util.List;

import com.lvmama.lvf.common.dto.flight.FlightInfoDto;

/**
 * 航班同步Batch请求对象
 * @author majun
 * @date 2015-7-28
 */
public class FlightSyncBatchRequest implements Serializable
{
	private static final long serialVersionUID = 5364516481331701514L;

	/** 航班查询请求对象 */
	private FlightQueryRequest flightQueryRequest;
	
	/** 航班信息 */
	private List<FlightInfoDto> flightInfoDtos;

	public FlightSyncBatchRequest() {
	}

	public FlightSyncBatchRequest(FlightQueryRequest flightQueryRequest) {
		this.flightQueryRequest = flightQueryRequest;
	}

	public FlightQueryRequest getFlightQueryRequest() {
		return flightQueryRequest;
	}

	public void setFlightQueryRequest(FlightQueryRequest flightQueryRequest) {
		this.flightQueryRequest = flightQueryRequest;
	}

	public List<FlightInfoDto> getFlightInfoDtos() {
		return flightInfoDtos;
	}

	public void setFlightInfoDtos(List<FlightInfoDto> flightInfoDtos) {
		this.flightInfoDtos = flightInfoDtos;
	}
}
