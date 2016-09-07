package com.lvmama.lvf.common.dto.order;

import java.io.Serializable;
import java.math.BigDecimal;

import org.codehaus.jackson.annotate.JsonIgnore;

import com.lvmama.lvf.common.domain.FkId;
import com.lvmama.lvf.common.dto.Entity;
import com.lvmama.lvf.common.dto.enums.FlightSegmentType;
import com.lvmama.lvf.common.dto.enums.FlightTripType;
import com.lvmama.lvf.common.dto.enums.MealType;
import com.lvmama.lvf.common.dto.flight.FlightAirportLineDto;
import com.lvmama.lvf.common.dto.flight.FlightInfoDailyDto;
import com.lvmama.lvf.common.dto.flight.FlightInfoDto;
import com.lvmama.lvf.common.dto.flight.FlightSeatDto;
import com.lvmama.lvf.common.dto.flight.FlightStopInfoDto;
import com.lvmama.lvf.common.dto.md.Airplane;
import com.lvmama.lvf.common.dto.md.Carrier;
import com.lvmama.lvf.common.dto.md.TimeSegmentRange;

/**
 * 订单航班信息
 * @author majun
 * @date   2015-1-13
 */
public class FlightOrderFlightInfoDto extends Entity implements Serializable
{
	private static final long serialVersionUID = -4391510738079340014L;
	
	/** 航班信息 */
	@FkId
	private FlightInfoDto flightInfo;
	
	private FlightInfoDailyDto flightInfoDaily;
	
	/** 订单航班组合明细主键*/
	private Long combinationDetailId;
	
	/** 航班承运人信息 */
	private Carrier carrier;
	
	/** 飞机型号相关信息 */
	private Airplane airplane;
	
	/** 航班号 */
	private String flightNo;
	
	/** 航程类型 */
	private FlightTripType flightTripType;
	
	/** 公里数 */
	private Integer mileages;
	
	/** 机场信息 */
	private FlightAirportLineDto flightAirportLine;
	
	/** 航程类型*/
	private FlightSegmentType flightSegmentType;
	
	/** 经停主信息 */
	private FlightStopInfoDto flightStopInfo;
	
	/** 经济舱票面价 */
	private BigDecimal yParPrice;
	
	/** 餐食信息 */
	private MealType mealType;
	
	/** 航段时间范围信息 */
	private TimeSegmentRange timeSegmentRange;
	
	/** 是否是共享航班 */
	private Boolean isShare;
	
	/** 共享航班承运人信息 */
	private Carrier shareCarrier;
	
	/** 共享航班号 */
	private String shareFlightNo;
	
	/** 舱位信息*/
	private FlightSeatDto flightSeat;
	
	public FlightInfoDto getFlightInfo() {
		return flightInfo;
	}

	public void setFlightInfo(FlightInfoDto flightInfo) {
		this.flightInfo = flightInfo;
	}
	
	public FlightInfoDailyDto getFlightInfoDaily() {
		return flightInfoDaily;
	}

	public void setFlightInfoDaily(FlightInfoDailyDto flightInfoDaily) {
		this.flightInfoDaily = flightInfoDaily;
	}

	public Long getCombinationDetailId() {
		return combinationDetailId;
	}

	public void setCombinationDetailId(Long combinationDetailId) {
		this.combinationDetailId = combinationDetailId;
	}

	public Carrier getCarrier() {
		return carrier;
	}

	public void setCarrier(Carrier carrier) {
		this.carrier = carrier;
	}

	public Airplane getAirplane() {
		return airplane;
	}

	public void setAirplane(Airplane airplane) {
		this.airplane = airplane;
	}

	public String getFlightNo() {
		return flightNo;
	}

	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}

	public FlightTripType getFlightTripType() {
		return flightTripType;
	}

	public void setFlightTripType(FlightTripType flightTripType) {
		this.flightTripType = flightTripType;
	}

	public Integer getMileages() {
		return mileages;
	}

	public void setMileages(Integer mileages) {
		this.mileages = mileages;
	}

	public FlightAirportLineDto getFlightAirportLine() {
		return flightAirportLine;
	}

	public void setFlightAirportLine(FlightAirportLineDto flightAirportLine) {
		this.flightAirportLine = flightAirportLine;
	}

	public FlightSegmentType getFlightSegmentType() {
		return flightSegmentType;
	}

	public void setFlightSegmentType(FlightSegmentType flightSegmentType) {
		this.flightSegmentType = flightSegmentType;
	}

	public FlightStopInfoDto getFlightStopInfo() {
		return flightStopInfo;
	}

	public void setFlightStopInfo(FlightStopInfoDto flightStopInfo) {
		this.flightStopInfo = flightStopInfo;
	}

	public BigDecimal getyParPrice() {
		return yParPrice;
	}

	public void setyParPrice(BigDecimal yParPrice) {
		this.yParPrice = yParPrice;
	}

	public MealType getMealType() {
		return mealType;
	}

	public void setMealType(MealType mealType) {
		this.mealType = mealType;
	}

	public TimeSegmentRange getTimeSegmentRange() {
		return timeSegmentRange;
	}

	public void setTimeSegmentRange(TimeSegmentRange timeSegmentRange) {
		this.timeSegmentRange = timeSegmentRange;
	}

	public Boolean getIsShare() {
		return isShare;
	}

	public void setIsShare(Boolean isShare) {
		this.isShare = isShare;
	}

	public Carrier getShareCarrier() {
		return shareCarrier;
	}

	public void setShareCarrier(Carrier shareCarrier) {
		this.shareCarrier = shareCarrier;
	}

	public String getShareFlightNo() {
		return shareFlightNo;
	}

	public void setShareFlightNo(String shareFlightNo) {
		this.shareFlightNo = shareFlightNo;
	}

	public FlightSeatDto getFlightSeat() {
		return flightSeat;
	}

	public void setFlightSeat(FlightSeatDto flightSeat) {
		this.flightSeat = flightSeat;
	}

	@Override
	@JsonIgnore
	public String getSequence() {
		return "S_FORD_FLIGHT_INFO";
	}
}
