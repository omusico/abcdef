package com.lvmama.lvf.common.dto.flight;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.lvmama.lvf.common.domain.FkId;
import com.lvmama.lvf.common.dto.AEEntity;
import com.lvmama.lvf.common.dto.md.TimeSegmentRange;

/**
 * 每日航班信息
 * @author majun
 * @date 2015-7-10
 */
@XmlRootElement
public class FlightInfoDailyDto extends AEEntity implements Serializable 
{
	private static final long serialVersionUID = -5320348268646443957L;
	
	/** 航班信息 */
	@FkId
	private FlightInfoDto flightInfo;

	/**航段所属时间范围 */
	private TimeSegmentRange timeSegmentRange;
	
	/**座位库存信息 */
	private List<FlightSeatInventoryDto> dailyInventorys = new ArrayList<FlightSeatInventoryDto>();

	public FlightInfoDto getFlightInfo() {
		return flightInfo;
	}

	public void setFlightInfo(FlightInfoDto flightInfo) {
		this.flightInfo = flightInfo;
	}

	public TimeSegmentRange getTimeSegmentRange() {
		return timeSegmentRange;
	}

	public void setTimeSegmentRange(TimeSegmentRange timeSegmentRange) {
		this.timeSegmentRange = timeSegmentRange;
	}

	public List<FlightSeatInventoryDto> getDailyInventorys() {
		return dailyInventorys;
	}

	public void setDailyInventorys(List<FlightSeatInventoryDto> dailyInventorys) {
		this.dailyInventorys = dailyInventorys;
	}

}
