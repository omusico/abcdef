package com.lvmama.lvf.common.dto.search;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang3.StringUtils;

import com.lvmama.lvf.common.dto.enums.MealType;
import com.lvmama.lvf.common.dto.enums.TimeSegment;
import com.lvmama.lvf.common.dto.request.FlightQueryRequest;
import com.lvmama.lvf.common.solr.json.base.criteria.annotation.SolrField;
import com.lvmama.lvf.common.solr.json.base.criteria.annotation.SolrIgnore;
import com.lvmama.lvf.common.solr.json.base.criteria.annotation.SolrOrder;
import com.lvmama.lvf.common.solr.json.base.criteria.enums.SolrQueryTYPE;
import com.lvmama.lvf.common.solr.json.ext.dynamic.criteria.annotation.SolrDynamicBase;
import com.lvmama.lvf.common.utils.DateUtils;
import com.lvmama.lvf.common.utils.EnumAndNameCodeUtils;

@XmlRootElement
public class FlightSearchRequest implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 859720050070032921L;
	private FlightQueryRequest flightQueryRequest;

	public FlightSearchRequest() {
		super();
	}
	
	public FlightSearchRequest(FlightQueryRequest flightQueryRequest) {
		super();
		this.flightQueryRequest = flightQueryRequest;
	}

	@SolrIgnore
	public Boolean getFacet() {
		return flightQueryRequest.getFacet();
	}

	@SolrField(name="carrierCode",type=SolrQueryTYPE.LIKE)
	public String getCarrierCode() {
		return EnumAndNameCodeUtils.getCode(flightQueryRequest.getCarrier());
	}
	
	@SolrField(name="carrierName",type=SolrQueryTYPE.LIKE)
	public String getCarrierName() {
		return EnumAndNameCodeUtils.getName(flightQueryRequest.getCarrier());
	}
	
	@SolrField(name="airplaneCode",type=SolrQueryTYPE.LIKE)
	public String getAirplaneCode() {
		return flightQueryRequest.getAirplaneCode();
	}

	@SolrField(name="airplaneType",type=SolrQueryTYPE.EQ)
	public String getAirplaneType() {
		return flightQueryRequest.getAirplaneType();
	}

	@SolrField(name="flightNo",type=SolrQueryTYPE.IN)
	public String[] getFlightNos() {
		return flightQueryRequest.getFlightNos();
	}

	@SolrField(name="seatClass",type=SolrQueryTYPE.IN)
	public String[] getSeatClazz() {
		return EnumAndNameCodeUtils.getCodes(flightQueryRequest.getSeatClazz());
	}

	@SolrField(name="seatClassType",type=SolrQueryTYPE.IN)
	public String[] getSeatClassType() {
		return EnumAndNameCodeUtils.getNames(flightQueryRequest.getSeatClassType());
	}

	@SolrOrder(name="(day)_departureTimeDate",sortfield="sortByDepartureTimeDate")
	public String getSortByDepartureTimeDate() {
		return flightQueryRequest.getSortByDepartureTimeDate();
	}

	@SolrOrder(name="(day)_parPrice",sortfield="sortByParPrice")
	public String getSortByParPrice() {
		return flightQueryRequest.getSortByParPrice();
	}

	@SolrOrder(name="(day)_settlePrice",sortfield="sortBySettlePrice")
	public String getSortBySettlePrice() {
		return flightQueryRequest.getSortBySettlePrice();
	}
	
	@SolrOrder(name="flyTimeHours",sortfield="sortByFlyTimeHours")
	public String getSortByFlyTimeHours() {
		return flightQueryRequest.getSortByFlyTimeHours();
	}


	@SolrField(name="suppPolicyId",type=SolrQueryTYPE.EQ)
	public String getSuppPolicyId() {
		return flightQueryRequest.getSuppPolicyId();
	}

	@SolrField(name="policyId",type=SolrQueryTYPE.EQ)
	public String getPolicyId() {
		return flightQueryRequest.getPolicyId();
	}
	
	@SolrDynamicBase(name="(day)")
	public String getDynamicBaseDepartureDate() {
		return DateUtils.formatDate(flightQueryRequest.getDepartureDate(),DateUtils.YYYYMMDD);
	}
	
	
	@SolrField(name="(day)_departureDate",type=SolrQueryTYPE.EQ)
	public String getDepartureDate() {
		return DateUtils.formatDate(flightQueryRequest.getDepartureDate(),DateUtils.YYYYMMDD);
	}

	@SolrField(name="departureTimeSegment",type=SolrQueryTYPE.IN)
	public String getDepartureTimeSegment() {
		return EnumAndNameCodeUtils.getName(flightQueryRequest.getDepartureTimeSegment());
	}
	
	@SolrField(name="(day)_arrivalDate",type=SolrQueryTYPE.EQ)
	public String getArrivalDate() {
		return DateUtils.formatDate(flightQueryRequest.getArrivalDate(),DateUtils.YYYYMMDD);
	}

	@SolrField(name="arrivalTimeSegment",type=SolrQueryTYPE.IN)
	public String getArrivalTimeSegment() {
		return EnumAndNameCodeUtils.getName(flightQueryRequest.getArrivalTimeSegment());
	}

	@SolrField(name="directType",type=SolrQueryTYPE.EQ)
	public String getDirect() {
		return EnumAndNameCodeUtils.getName(flightQueryRequest.getDirect());
	}

	@SolrField(name="departureCityCode",type=SolrQueryTYPE.EQ)
	public String getDepartureCityCode() {
		return StringUtils.isNotBlank(flightQueryRequest.getDepartureAirportCode())?
				flightQueryRequest.getDepartureAirportCode()
				:flightQueryRequest.getDepartureCityCode();
	}

	@SolrField(name="arrivalCityCode",type=SolrQueryTYPE.EQ)
	public String getArrivalCityCode() {
		return StringUtils.isNotBlank(flightQueryRequest.getArrivalAirportCode())?
				flightQueryRequest.getArrivalAirportCode()
				:flightQueryRequest.getArrivalCityCode();
	}

	@SolrField(name="(day)_inventoryCount",type=SolrQueryTYPE.GREAT_THAN)
	public BigDecimal getMinInventory(){
		return flightQueryRequest.getMinInventory();
	}
	
	@SolrField(name="isShare",type=SolrQueryTYPE.EQ)
	public Boolean getIsShare() {
		return flightQueryRequest.getIsShare();
	}
	
	@SolrField(name="mealType",type=SolrQueryTYPE.IN)
	public MealType[] getMealTypes() {
		return flightQueryRequest.getMealTypes();
	}
	
	@SolrField(name = "(day)_departureTimeHour", type = SolrQueryTYPE.BETWEEN)
	public String getDepartureTimeHourBeg() {
		
		return TimeSegment.getTimeSegmentBegTime(flightQueryRequest.getDepartureTimeSegment());
	}

	@SolrField(name = "(day)_departureTimeHour", type = SolrQueryTYPE.BETWEEN)
	public String getDepartureTimeHourEnd() {
		return TimeSegment.getTimeSegmentEndTime(flightQueryRequest.getDepartureTimeSegment());
	}
	
	@SolrField(name = "(day)_arrivalTimeHour", type = SolrQueryTYPE.BETWEEN)
	public String getArrivalTimeHourBeg() {
		
		return TimeSegment.getTimeSegmentBegTime(flightQueryRequest.getArrivalTimeSegment());
	}

	@SolrField(name = "(day)_arrivalTimeHour", type = SolrQueryTYPE.BETWEEN)
	public String getArrivalTimeHourEnd() {
		return TimeSegment.getTimeSegmentEndTime(flightQueryRequest.getArrivalTimeSegment());
	}

	@SolrField(name="suppCode",type=SolrQueryTYPE.EQ)
	public String getSuppCode() {
		return flightQueryRequest.getSuppCode();
	}
	
	@SolrField(name="suppCode",type=SolrQueryTYPE.IN)
	public String[] getSuppCodes() {
		return flightQueryRequest.getSuppCodes();
	}
	
	@SolrField(name="carrierCode",type=SolrQueryTYPE.NOT_IN)
	public String[] getCarrierCodesInvisible() {
		return flightQueryRequest.getCarrierCodesInvisible();
	}
	
}
