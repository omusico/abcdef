package com.lvmama.lvf.common.dto.order.result.detail;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonIgnore;

import com.lvmama.lvf.common.dto.enums.RouteType;
import com.lvmama.lvf.common.dto.order.FlightOrderAmountDto;
import com.lvmama.lvf.common.dto.order.FlightOrderDetailDto;
import com.lvmama.lvf.common.dto.order.FlightOrderExpressDto;
import com.lvmama.lvf.common.dto.order.FlightOrderFlightCombinationDetailDto;
import com.lvmama.lvf.common.dto.order.FlightOrderFlightInfoDto;
import com.lvmama.lvf.common.dto.order.FlightOrderRemarkDto;
import com.lvmama.lvf.common.utils.DateUtils;

/**
 * 订单详情明细信息
 * @author majun
 * @date   2015-3-17
 */
public class FlightOrderDetailInfoDto implements Serializable
{
	private static final long serialVersionUID = -4109979716647943963L;
	
	  /** 订单号 */
	private String orderNo;
	
	  /** 订单金额信息 */
    private FlightOrderAmountDto flightOrderAmount;
	
	/** 线路信息 */
	private RouteType routeType;
	
	/** 订单航班信息 */
	private List<FlightOrderFlightInfoDto> flightOrderFlightInfos;
	
	/** 订单明细信息 */
	private List<FlightOrderDetailDto> flightOrderDetails;
	
	/** 订单备注信息 */
	private List<FlightOrderRemarkDto> flightOrderRemarks;
	
	/** 订单快递信息 */
	private FlightOrderExpressDto flightOrderExpress;
	
    /** 订单对应的订单航班明细信息--获取退改签规定 */
    private List<FlightOrderFlightCombinationDetailDto> combinationDetails;
    
    /** 行程单号Map(key：票号主键，value：行程单号) */
    private Map<String, String> bspNoMap;	
    
    /** 前一个订单主键 */
    private Long orderPreId;
    
    /** 供应商订单号 */
    private String suppOrderNo;
    
    private Date finishBookingTime;
    private Date limitTime;

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public FlightOrderAmountDto getFlightOrderAmount() {
		return flightOrderAmount;
	}

	public void setFlightOrderAmount(FlightOrderAmountDto flightOrderAmount) {
		this.flightOrderAmount = flightOrderAmount;
	}

	public RouteType getRouteType() {
		return routeType;
	}

	public void setRouteType(RouteType routeType) {
		this.routeType = routeType;
	}

	public List<FlightOrderFlightInfoDto> getFlightOrderFlightInfos() {
		return flightOrderFlightInfos;
	}

	public void setFlightOrderFlightInfos(
			List<FlightOrderFlightInfoDto> flightOrderFlightInfos) {
		this.flightOrderFlightInfos = flightOrderFlightInfos;
	}

	public List<FlightOrderDetailDto> getFlightOrderDetails() {
		return flightOrderDetails;
	}

	public void setFlightOrderDetails(List<FlightOrderDetailDto> flightOrderDetails) {
		this.flightOrderDetails = flightOrderDetails;
	}

	public List<FlightOrderRemarkDto> getFlightOrderRemarks() {
		return flightOrderRemarks;
	}

	public void setFlightOrderRemarks(List<FlightOrderRemarkDto> flightOrderRemarks) {
		this.flightOrderRemarks = flightOrderRemarks;
	}

	public FlightOrderExpressDto getFlightOrderExpress() {
		return flightOrderExpress;
	}

	public void setFlightOrderExpress(FlightOrderExpressDto flightOrderExpress) {
		this.flightOrderExpress = flightOrderExpress;
	}

    public List<FlightOrderFlightCombinationDetailDto> getCombinationDetails() {
        return combinationDetails;
    }

    public void setCombinationDetails(List<FlightOrderFlightCombinationDetailDto> combinationDetails) {
        this.combinationDetails = combinationDetails;
    }

	public Map<String, String> getBspNoMap() {
		return bspNoMap;
	}

	public void setBspNoMap(Map<String, String> bspNoMap) {
		this.bspNoMap = bspNoMap;
	}

    public Long getOrderPreId() {
        return orderPreId;
    }

    public void setOrderPreId(Long orderPreId) {
        this.orderPreId = orderPreId;
    }

    public String getSuppOrderNo() {
        return suppOrderNo;
    }

    public void setSuppOrderNo(String suppOrderNo) {
        this.suppOrderNo = suppOrderNo;
    }

	public Date getFinishBookingTime() {
		return finishBookingTime;
	}

	public void setFinishBookingTime(Date finishBookingTime) {
		this.finishBookingTime = finishBookingTime;
	}

	public Date getLimitTime() {
		return limitTime;
	}

	public void setLimitTime(Date limitTime) {
		this.limitTime = limitTime;
	}

	@JsonIgnore
	public Long getLeftTime() {
		
		if(null==this.getLimitTime()
				||null==this.getFinishBookingTime()){
			return 0L;
		}
		return (this.getLimitTime().getTime()-this.getFinishBookingTime().getTime())/60000;
	}

    
    
    
}
