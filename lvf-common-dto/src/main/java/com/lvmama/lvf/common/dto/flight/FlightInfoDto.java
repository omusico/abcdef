
package com.lvmama.lvf.common.dto.flight;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.collections.CollectionUtils;

import com.lvmama.lvf.common.dto.AEEntity;
import com.lvmama.lvf.common.dto.enums.FlightSegmentType;
import com.lvmama.lvf.common.dto.enums.FlightTicketType;
import com.lvmama.lvf.common.dto.enums.MealType;
import com.lvmama.lvf.common.dto.enums.PassengerType;
import com.lvmama.lvf.common.dto.md.Airplane;
import com.lvmama.lvf.common.dto.md.Carrier;
import com.lvmama.lvf.common.dto.md.TimeSegmentRange;

@XmlRootElement
public class FlightInfoDto extends AEEntity implements Serializable {

	private static final long serialVersionUID = 8516795269142070760L;
	
    /**承运人POJO */
	private Carrier carrier;
	
	/**飞机详细信息POJO */
	private Airplane airplane;
	
	/**航班号 */
	private String flightNo;
	
	/**行程数 */
	private Integer mileages;
	
	/**机场线路信息 */
	private FlightAirportLineDto flightAirportLine;
	
	/**航段类型*/
	private FlightSegmentType flightSegmentType;

	/**航班停靠信息*/
	private FlightStopInfoDto flightStopInfo;
	
	/**经济舱票面价*/
	private BigDecimal YParPrice;

	/**餐食类型*/
	private MealType mealType;//

	/**航段所属时间范围 */
	private TimeSegmentRange timeSegmentRange;
	
	/**是否共享航班 */
	private Boolean isShare;
	
	/**共享承运人 */
	private Carrier shareCarrier;
	
	/**共享航班号 */
	private String shareFlightNo;

	/**机场费信息*/
	private List<FlightAirportFeeDto> fees = new ArrayList<FlightAirportFeeDto>();
	
	/**燃油费信息 */
	private List<FlightFuelsurTaxDto> taxs = new ArrayList<FlightFuelsurTaxDto>();

	/**每日航班信息 */
	private List<FlightInfoDailyDto> dailys = new ArrayList<FlightInfoDailyDto>();

	/** 舱位信息 */
	private List<FlightSeatDto> seats = new ArrayList<FlightSeatDto>();
	
	/**联接协议级别 */
	private String link;
	
	/**是否电子客票 */
	private FlightTicketType flightTicketType;
	
	/**
	 * 将燃油费按照乘客类型分组
	 * @return	Map<PassengerType, FlightFuelsurTaxDto>		燃油费Map	
	 */
	public Map<PassengerType, FlightFuelsurTaxDto> groupFuelsurTaxByPassengerType()
	{
		Map<PassengerType, FlightFuelsurTaxDto> fuelsurTaxMap = new HashMap<PassengerType, FlightFuelsurTaxDto>();
		List<FlightFuelsurTaxDto> flightFuelsurTaxDtos = this.getTaxs();
		if(CollectionUtils.isNotEmpty(flightFuelsurTaxDtos))
		{
			for (FlightFuelsurTaxDto flightFuelsurTaxDto : flightFuelsurTaxDtos) 
				fuelsurTaxMap.put(flightFuelsurTaxDto.getPassengerType(), flightFuelsurTaxDto);
		}
		return fuelsurTaxMap;
	}
	
	/**
	 * 将机建费按照乘客类型分组
	 * @return	Map<PassengerType, FlightAirportFeeDto>		机建费Map
	 */
	public Map<PassengerType, FlightAirportFeeDto> groupAirportFeeByPassengerType()
	{
		Map<PassengerType, FlightAirportFeeDto> airportFeeMap = new HashMap<PassengerType, FlightAirportFeeDto>();
		List<FlightAirportFeeDto> flightAirportFeeDtos = this.getFees();
		if(CollectionUtils.isNotEmpty(flightAirportFeeDtos))
		{
			for (FlightAirportFeeDto flightAirportFeeDto : flightAirportFeeDtos) 
				airportFeeMap.put(flightAirportFeeDto.getPassengerType(), flightAirportFeeDto);
		}
		
		return airportFeeMap;
	}
	
	public void vaildTaxs(){
//		List<FlightFuelsurTaxDto> nTaxs = new ArrayList<FlightFuelsurTaxDto>();
//		for(FlightFuelsurTaxDto tax:taxs){
//			if((null==tax.getStartMileage()?0:tax.getStartMileage())<this.getMileages()){
//				if(this.getMileages()<(null==tax.getEndMileage()?99999:tax.getEndMileage())){
//					nTaxs.add(tax);
//				}
//			}
//		}
//		this.setTaxs(nTaxs);
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
        if (this.flightNo != null) {
            return flightNo.trim();
        }
        return null;
    }

	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}

	public Integer getMileages() {
		return mileages;
	}

	public void setMileages(Integer mileages) {
		this.mileages = mileages;
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

	public BigDecimal getYParPrice() {
		return YParPrice;
	}

	public void setYParPrice(BigDecimal yParPrice) {
		YParPrice = yParPrice;
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

	public List<FlightAirportFeeDto> getFees() {
		return fees;
	}

	public void setFees(List<FlightAirportFeeDto> fees) {
		this.fees = fees;
	}

	public List<FlightFuelsurTaxDto> getTaxs() {
		return taxs;
	}

	public void setTaxs(List<FlightFuelsurTaxDto> taxs) {
		this.taxs = taxs;
	}

	public List<FlightInfoDailyDto> getDailys() {
		return dailys;
	}

	public void setDailys(List<FlightInfoDailyDto> dailys) {
		this.dailys = dailys;
	}

	public List<FlightSeatDto> getSeats() {
		return seats;
	}

	public void setSeats(List<FlightSeatDto> seats) {
		this.seats = seats;
	}

	public FlightAirportLineDto getFlightAirportLine() {
		return flightAirportLine;
	}

	public void setFlightAirportLine(FlightAirportLineDto flightAirportLine) {
		this.flightAirportLine = flightAirportLine;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public FlightTicketType getFlightTicketType() {
		return flightTicketType;
	}

	public void setFlightTicketType(FlightTicketType flightTicketType) {
		this.flightTicketType = flightTicketType;
	}

	
}
