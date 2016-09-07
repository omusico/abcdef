package com.lvmama.lvf.common.dto.flight;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author lutianyu
 * @date   2015-3-12
 */
@XmlRootElement
public class FlightDayPriceDto implements Serializable{
	private static final long serialVersionUID = -1329505547326363634L;
	
	/** 最低价航班信息 */
	private List<FlightDayPriceAllInOneDto> flightDayPriceAllInOnes;

	public List<FlightDayPriceAllInOneDto> getFlightDayPriceAllInOnes() {
		return flightDayPriceAllInOnes;
	}

	public void setFlightDayPriceAllInOnes(
			List<FlightDayPriceAllInOneDto> flightDayPriceAllInOnes) {
		this.flightDayPriceAllInOnes = flightDayPriceAllInOnes;
	}

}
