package com.lvmama.lvf.common.form.order.result.detail;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;

import com.lvmama.lvf.common.dto.enums.RouteType;
import com.lvmama.lvf.common.dto.md.TimeSegmentRange;
import com.lvmama.lvf.common.dto.order.FlightOrderDetailDto;
import com.lvmama.lvf.common.dto.order.FlightOrderExpressDto;
import com.lvmama.lvf.common.dto.order.FlightOrderFlightInfoDto;
import com.lvmama.lvf.common.dto.order.result.detail.FlightOrderDetailInfoDto;
import com.lvmama.lvf.common.form.Form;
import com.lvmama.lvf.common.utils.DateUtils;

/**
 * 订单详情明细信息表单
 * @author lven
 * @date 2015-2-5
 * 
 */
public class FlightOrderDetailInfoForm implements Serializable, Form 
{
	private static final long serialVersionUID = 3321019845968504313L;
	
	private FlightOrderDetailInfoDto flightOrderDetailInfoDto = new FlightOrderDetailInfoDto();

	public RouteType getRouteType() {
		return flightOrderDetailInfoDto.getRouteType();
	}

	public void setRouteType(RouteType routeType) {
		flightOrderDetailInfoDto.setRouteType(routeType);
	}

	public FlightOrderDetailInfoDto getFlightOrderDetailInfoDto() {
		return flightOrderDetailInfoDto;
	}

	public void setFlightOrderDetailInfoDto(
			FlightOrderDetailInfoDto flightOrderDetailInfoDto) {
		this.flightOrderDetailInfoDto = flightOrderDetailInfoDto;
	}

	public List<FlightOrderFlightInfoDto> getFlightOrderFlightInfos() {
		return flightOrderDetailInfoDto.getFlightOrderFlightInfos();
	}

	public void setFlightOrderFlightInfos(
			List<FlightOrderFlightInfoDto> flightOrderFlightInfos) {
		flightOrderDetailInfoDto
				.setFlightOrderFlightInfos(flightOrderFlightInfos);
	}

	public List<FlightOrderDetailDto> getFlightOrderDetails() {
		return flightOrderDetailInfoDto.getFlightOrderDetails();
	}

	public void setFlightOrderDetails(
			List<FlightOrderDetailDto> flightOrderDetails) {
		flightOrderDetailInfoDto.setFlightOrderDetails(flightOrderDetails);
	}

	public FlightOrderExpressDto getFlightOrderExpress() {
		return flightOrderDetailInfoDto.getFlightOrderExpress();
	}

	public void setFlightOrderExpress(FlightOrderExpressDto flightOrderExpress) {
		flightOrderDetailInfoDto.setFlightOrderExpress(flightOrderExpress);
	}
	
	public Map<String, String> getBspNoMap() {
		return flightOrderDetailInfoDto.getBspNoMap();
	}

	public void setBspNoMap(Map<String, String> bspNoMap) {
		flightOrderDetailInfoDto.setBspNoMap(bspNoMap);
	}
	
	/**
	 * 航班跨天数
	 * @return
	 */
	public List<Integer> getFlightCrossDays()
	{
		List<Integer> crossDays = null;
		
		List<FlightOrderFlightInfoDto> flightOrderFlightInfoDtos = this.getFlightOrderFlightInfos();
		if(CollectionUtils.isNotEmpty(flightOrderFlightInfoDtos))
		{
			crossDays = new ArrayList<Integer>();
			for(FlightOrderFlightInfoDto flightOrderFlightInfoDto : flightOrderFlightInfoDtos)
			{
				Integer crossDay = null;
				TimeSegmentRange timeSegmentRange = flightOrderFlightInfoDto.getTimeSegmentRange();
				Date departureTime = timeSegmentRange.getDepartureTime();
				Date arrivalTime = timeSegmentRange.getArrivalTime();
				String departureTimeStr = DateUtils.formatDate(departureTime, DateUtils.YYYY_MM_DD);
				String arrivalTimeStr = DateUtils.formatDate(arrivalTime, DateUtils.YYYY_MM_DD);
				crossDay = (int) DateUtils.getDateDiffByDay(arrivalTimeStr, departureTimeStr);
				crossDays.add(crossDay);
			}	
		}
		return crossDays;
	}
}
