package com.lvmama.lvf.common.dto.flight;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import com.lvmama.lvf.common.domain.FkId;
import com.lvmama.lvf.common.dto.AEEntity;
import com.lvmama.lvf.common.dto.md.City;


@XmlRootElement
public class FlightAirLineDto extends AEEntity implements Serializable {
	
	/** serialVersionUID */
	private static final long serialVersionUID = -4637310332000826725L;
	
	@FkId
	/** 起飞机场城市信息 */
	private City departureCity;
	
	@FkId
	/** 抵达机场城市信息 */
	private City arriveCity;
	
	public City getDepartureCity() {
		return departureCity;
	}

	public void setDepartureCity(City departureCity) {
		this.departureCity = departureCity;
	}

	public City getArriveCity() {
		return arriveCity;
	}

	public void setArriveCity(City arriveCity) {
		this.arriveCity = arriveCity;
	}


}
