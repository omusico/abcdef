package com.lvmama.lvfit.common.dto.search.flight;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang3.StringUtils;

import com.lvmama.lvf.common.dto.enums.SuppSaleType;
import com.lvmama.lvfit.common.dto.enums.BookingSource;
import com.lvmama.lvfit.common.dto.enums.DirectType;
import com.lvmama.lvfit.common.dto.enums.InventoryType;
import com.lvmama.lvfit.common.dto.enums.MealType;
import com.lvmama.lvfit.common.dto.enums.OnlySelfPNR;
import com.lvmama.lvfit.common.dto.enums.PassengerType;
import com.lvmama.lvfit.common.dto.enums.PolicyType;
import com.lvmama.lvfit.common.dto.enums.RouteType;
import com.lvmama.lvfit.common.dto.enums.SeatClassType;
import com.lvmama.lvfit.common.dto.enums.TimeSegment;
import com.lvmama.lvfit.common.dto.md.Carrier;
import com.lvmama.lvfit.common.dto.md.DateRange;
import com.lvmama.lvfit.common.dto.md.FlightOfficeDto;
import com.lvmama.lvfit.common.dto.md.SeatClass;

@XmlRootElement
public class FlightQueryRequest  implements Serializable{
	
	/** serialVersionUID */
	private static final long serialVersionUID = -3921306104310769634L;

	
	/**承运人信息*/
	private Carrier carrier;

	/**PNR配置信息*/
	private FlightOfficeDto flightOffice;
	
	/**飞机代码*/
	private String airplaneCode;
	
	/**飞机型号*/
	private String airplaneType;
	
	/**航班号*/
	private String[] flightNos;
	
	/**适用舱位*/
	private SeatClass[] seatClazz; 
	
	/**舱位类型*/
	private SeatClassType[] seatClassType;
	
	/**乘客类型枚举*/
	private PassengerType[] passengerType;
	
	/**出发日期*/
	private Date departureDate;
	
	/**出发日期日期段*/
	private DateRange departureDateRange;
	
	/**出发日期时间段*/
	private TimeSegment departureTimeSegment;
	
	/**到达日期*/
	private Date arrivalDate;
	
	/**到达日期时间段*/
	private TimeSegment arrivalTimeSegment;
	
	/**直飞或经停*/
	private DirectType direct;
	
	/**出发机场三字码*/
	private String departureAirportCode;
	
	/**抵达机场三字码*/
	private String arrivalAirportCode;
	
	/** 出发城市代码 */
	private String departureCityCode;
	
	/** 到达城市代码 */
	private String arrivalCityCode;
    
	/**库存信息*/
	private InventoryType inventoryType;
	
	/**最小库存*/
	private BigDecimal minInventory;
	
	/**PNR出票状态信息*/
	private OnlySelfPNR onlySelfPNR;
	
	/**是否在工作时间内*/
	private Boolean needSuppOnWorking;
	
	private Boolean stillShowSeatIfNoPolicy;

	/**政策类型信息*/
	private PolicyType[] policyTypes;

	/**配餐信息*/
	private MealType[] mealTypes;
	
	/**航程类型信息*/
	private RouteType routeType;
	
	/**是否共享*/
	private Boolean isShare;
	
	/**返程日期*/
	private String returnDate;
	
	/**政策适用的航班舱位*/
	private String suppPolicyId;
	
	/**政策ID*/
	private String policyId;
	
	/**运价政策ID*/
	private Long pricePolicyId;
	
	private SuppFlightProductDto suppFlightProductDto;

	private Boolean facet=false;
	private Boolean group=false;
    private String sortByDepartureTimeDate="ASC";
    private String sortByParPrice;
	private String sortBySettlePrice;
	private String sortByFlyTimeHours;
	/**是否开启即时查询*/
	private Boolean instantaneity=true;
	
	private BookingSource bookingSource  = BookingSource.DEFAULT;
	
	private String suppCode;
	
	//销售类型.直接使用lvf.common.dto下面的类型.
	private SuppSaleType[] saleType;
	
	/**返程日期*/
	private Date backDate;
	
	
	public SuppSaleType[] getSaleType() {
		return saleType;
	}

	public void setSaleType(SuppSaleType[] saleType) {
		this.saleType = saleType;
	}

	public Date getBackDate() {
		return backDate;
	}

	public void setBackDate(Date backDate) {
		this.backDate = backDate;
	}

	/**结束出发日期*/
	private Date departureEndDate;

	public BookingSource getBookingSource() {
		return bookingSource;
	}

	public void setBookingSource(BookingSource bookingSource) {
		this.bookingSource = bookingSource;
	}

	public Boolean getGroup() {
		return group;
	}

	public void setGroup(Boolean group) {
		this.group = group;
	}

	public Boolean getFacet() {
		return facet;
	}

	public void setFacet(Boolean facet) {
		this.facet = facet;
	}

	public String getSortByDepartureTimeDate() {
		return sortByDepartureTimeDate;
	}

	public void setSortByDepartureTimeDate(String sortByDepartureTimeDate) {
		this.sortByDepartureTimeDate = sortByDepartureTimeDate;
	}

	public String getSortByParPrice() {
		return sortByParPrice;
	}

	public void setSortByParPrice(String sortByParPrice) {
		this.sortByParPrice = sortByParPrice;
	}

	public String getSortBySettlePrice() {
		return sortBySettlePrice;
	}

	public void setSortBySettlePrice(String sortBySettlePrice) {
		this.sortBySettlePrice = sortBySettlePrice;
	}	
	
	public String getSortByFlyTimeHours() {
		return sortByFlyTimeHours;
	}

	public void setSortByFlyTimeHours(String sortByFlyTimeHours) {
		this.sortByFlyTimeHours = sortByFlyTimeHours;
	}

	public String getSuppPolicyId() {
		return suppPolicyId;
	}

	public void setSuppPolicyId(String suppPolicyId) {
		this.suppPolicyId = suppPolicyId;
	}

	public String getPolicyId() {
		return policyId;
	}

	public void setPolicyId(String policyId) {
		this.policyId = policyId;
	}

	public Carrier getCarrier() {
		return carrier;
	}

	public void setCarrier(Carrier carrier) {
		this.carrier = carrier;
	}

	public FlightOfficeDto getFlightOffice() {
		return flightOffice;
	}

	public void setFlightOffice(FlightOfficeDto flightOffice) {
		this.flightOffice = flightOffice;
	}

	public String getAirplaneCode() {
		return airplaneCode;
	}

	public void setAirplaneCode(String airplaneCode) {
		this.airplaneCode = airplaneCode;
	}

	public String getAirplaneType() {
		return airplaneType;
	}

	public void setAirplaneType(String airplaneType) {
		this.airplaneType = airplaneType;
	}

	public String[] getFlightNos() {
		return flightNos;
	}

	public void setFlightNos(String[] flightNos) {
		this.flightNos = flightNos;
	}

	public SeatClass[] getSeatClazz() {
		return seatClazz;
	}

	public void setSeatClazz(SeatClass[] seatClazz) {
		this.seatClazz = seatClazz;
	}

	public SeatClassType[] getSeatClassType() {
		return seatClassType;
	}

	public void setSeatClassType(SeatClassType[] seatClassType) {
		this.seatClassType = seatClassType;
	}

	public Date getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}
	
	public TimeSegment getDepartureTimeSegment() {
		return departureTimeSegment;
	}

	public void setDepartureTimeSegment(TimeSegment departureTimeSegment) {
		this.departureTimeSegment = departureTimeSegment;
	}

	public Date getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public TimeSegment getArrivalTimeSegment() {
		return arrivalTimeSegment;
	}

	public void setArrivalTimeSegment(TimeSegment arrivalTimeSegment) {
		this.arrivalTimeSegment = arrivalTimeSegment;
	}

	public DirectType getDirect() {
		return direct;
	}

	public void setDirect(DirectType direct) {
		this.direct = direct;
	}

	public String getDepartureAirportCode() {
		return departureAirportCode;
	}

	public void setDepartureAirportCode(String departureAirportCode) {
		this.departureAirportCode = departureAirportCode;
	}

	public String getArrivalAirportCode() {
		return arrivalAirportCode;
	}

	public void setArrivalAirportCode(String arrivalAirportCode) {
		this.arrivalAirportCode = arrivalAirportCode;
	}
	public String getDepartureCityCode() {
		if(StringUtils.isNotBlank(this.departureAirportCode))
			return this.departureAirportCode;
		return departureCityCode;
	}

	public void setDepartureCityCode(String departureCityCode) {
		this.departureCityCode = departureCityCode;
	}

	public String getArrivalCityCode() {
		if(StringUtils.isNotBlank(this.arrivalAirportCode))
			return this.arrivalAirportCode;
		return arrivalCityCode;
	}

	public void setArrivalCityCode(String arrivalCityCode) {
		this.arrivalCityCode = arrivalCityCode;
	}

	public InventoryType getInventoryType() {
		return inventoryType;
	}

	public void setInventoryType(InventoryType inventoryType) {
		this.inventoryType = inventoryType;
	}

	public BigDecimal getMinInventory() {
		return minInventory;
	}

	public void setMinInventory(BigDecimal minInventory) {
		this.minInventory = minInventory;
	}

	public OnlySelfPNR getOnlySelfPNR() {
		return onlySelfPNR;
	}

	public void setOnlySelfPNR(OnlySelfPNR onlySelfPNR) {
		this.onlySelfPNR = onlySelfPNR;
	}

	public Boolean getNeedSuppOnWorking() {
		return needSuppOnWorking;
	}

	public void setNeedSuppOnWorking(Boolean needSuppOnWorking) {
		this.needSuppOnWorking = needSuppOnWorking;
	}

	public Boolean getStillShowSeatIfNoPolicy() {
		return stillShowSeatIfNoPolicy;
	}

	public void setStillShowSeatIfNoPolicy(Boolean stillShowSeatIfNoPolicy) {
		this.stillShowSeatIfNoPolicy = stillShowSeatIfNoPolicy;
	}

	public PolicyType[] getPolicyTypes() {
		return policyTypes;
	}

	public void setPolicyTypes(PolicyType[] policyTypes) {
		this.policyTypes = policyTypes;
	}

	public MealType[] getMealTypes() {
		return mealTypes;
	}

	public void setMealTypes(MealType[] mealTypes) {
		this.mealTypes = mealTypes;
	}

	public RouteType getRouteType() {
		return routeType;
	}

	public void setRouteType(RouteType routeType) {
		this.routeType = routeType;
	}

	public Boolean getIsShare() {
		return isShare;
	}

	public void setIsShare(Boolean isShare) {
		this.isShare = isShare;
	}

	public String getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}

	public DateRange getDepartureDateRange() {
		return departureDateRange;
	}

	public void setDepartureDateRange(DateRange departureDateRange) {
		this.departureDateRange = departureDateRange;
	}

	public PassengerType[] getPassengerType() {
		return passengerType;
	}

	public void setPassengerType(PassengerType[] passengerType) {
		this.passengerType = passengerType;
	}

	public Boolean getInstantaneity() {
		return instantaneity;
	}

	public void setInstantaneity(Boolean instantaneity) {
		this.instantaneity = instantaneity;
	}

	public SuppFlightProductDto getSuppFlightProductDto() {
		return suppFlightProductDto;
	}

	public void setSuppFlightProductDto(SuppFlightProductDto suppFlightProductDto) {
		this.suppFlightProductDto = suppFlightProductDto;
	}

	public Long getPricePolicyId() {
		return pricePolicyId;
	}

	public void setPricePolicyId(Long pricePolicyId) {
		this.pricePolicyId = pricePolicyId;
	}

	public String getSuppCode() {
		return suppCode;
	}

	public void setSuppCode(String suppCode) {
		this.suppCode = suppCode;
	}

	public Date getDepartureEndDate() {
		return departureEndDate;
	}

	public void setDepartureEndDate(Date departureEndDate) {
		this.departureEndDate = departureEndDate;
	}

	
	
}
