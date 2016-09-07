package com.lvmama.lvf.common.dto.order.result.list;

import com.lvmama.lvf.common.dto.enums.FlightTripType;
import com.lvmama.lvf.common.dto.enums.RouteType;
import com.lvmama.lvf.common.dto.md.Carrier;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单列表航班信息
 * @author majun
 * @date   2015-3-17
 */
public class FlightOrderListFlightInfoDto implements Serializable 
{
	private static final long serialVersionUID = -6372275104969780724L;

	
   
	/** 出发机场三字代码 */
    private String depCode;

    /** 出发机场名称 */
    private String depName;
    
    /** 到达机场三字代码 */
    private String arrCode;

    /** 到达机场名称 */
    private String arrName;
    
    /** 出发机场城市代码 */
    private String depAirportCityCode;
    
    /** 出发机场城市名称 */
    private String depAirportCityName;
    
    /** 到达机场城市代码 */
    private String arrAirportCityCode;
    
    /** 到达机场城市名称 */
    private String arrAirportCityName;
    
    /** 航班号 */
    private String flightNo;
    
    /** 线路类型 */
    private RouteType routeType;
    
    /** 航程类型*/
    private FlightTripType flightTripType;
    
    /**舱位代码 */
    private String seatClassCode;

    /** 起飞时间 */
    private Date depTime;

    /** 到达时间 */
    private Date arrTime;
    
    /** 经济舱票面价 */
    private BigDecimal yParPrice;
    
    private BigDecimal parPrice;
    
    /** 承运人信息 */
    private Carrier carrier;
    
    /**返程相关航班信息*/
    private String returnFlightNo;
    private String returnDepAirportCode;
    private String returnDepAirportName;
    private String returnArrAirportCode;
    private String returnArrAirportName;
    private String returnDepCityCode;
    private String returnDepCityName;
    private String returnArrCityCode;
    private String returnArrCityName;
    private Date returnDepTime;
    private Date returnArrTime;
    private String returnSeatClassCode;
    
	public BigDecimal getParPrice() {
		return parPrice;
	}

	public void setParPrice(BigDecimal parPrice) {
		this.parPrice = parPrice;
	}

	public String getDepCode() {
		return depCode;
	}

	public void setDepCode(String depCode) {
		this.depCode = depCode;
	}

	public String getArrCode() {
		return arrCode;
	}

	public void setArrCode(String arrCode) {
		this.arrCode = arrCode;
	}

	public String getFlightNo() {
		return flightNo;
	}

	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}

	public RouteType getRouteType() {
		return routeType;
	}

	public void setRouteType(RouteType routeType) {
		this.routeType = routeType;
	}

	public FlightTripType getFlightTripType() {
		return flightTripType;
	}

	public void setFlightTripType(FlightTripType flightTripType) {
		this.flightTripType = flightTripType;
	}

	public String getSeatClassCode() {
		return seatClassCode;
	}

	public void setSeatClassCode(String seatClassCode) {
		this.seatClassCode = seatClassCode;
	}

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    public String getArrName() {
        return arrName;
    }

    public void setArrName(String arrName) {
        this.arrName = arrName;
    }

    public String getDepAirportCityCode() {
		return depAirportCityCode;
	}

	public void setDepAirportCityCode(String depAirportCityCode) {
		this.depAirportCityCode = depAirportCityCode;
	}

	public String getDepAirportCityName() {
		return depAirportCityName;
	}

	public void setDepAirportCityName(String depAirportCityName) {
		this.depAirportCityName = depAirportCityName;
	}

	public String getArrAirportCityCode() {
		return arrAirportCityCode;
	}

	public void setArrAirportCityCode(String arrAirportCityCode) {
		this.arrAirportCityCode = arrAirportCityCode;
	}

	public String getArrAirportCityName() {
		return arrAirportCityName;
	}

	public void setArrAirportCityName(String arrAirportCityName) {
		this.arrAirportCityName = arrAirportCityName;
	}

	public Date getDepTime() {
        return depTime;
    }

    public void setDepTime(Date depTime) {
        this.depTime = depTime;
    }

    public Date getArrTime() {
        return arrTime;
    }

    public void setArrTime(Date arrTime) {
        this.arrTime = arrTime;
    }

	public BigDecimal getyParPrice() {
		return yParPrice;
	}

	public void setyParPrice(BigDecimal yParPrice) {
		this.yParPrice = yParPrice;
	}

	public Carrier getCarrier() {
		return carrier;
	}

	public void setCarrier(Carrier carrier) {
		this.carrier = carrier;
	}

	public String getReturnFlightNo() {
		return returnFlightNo;
	}

	public void setReturnFlightNo(String returnFlightNo) {
		this.returnFlightNo = returnFlightNo;
	}

	public String getReturnDepAirportCode() {
		return returnDepAirportCode;
	}

	public void setReturnDepAirportCode(String returnDepAirportCode) {
		this.returnDepAirportCode = returnDepAirportCode;
	}

	public String getReturnDepAirportName() {
		return returnDepAirportName;
	}

	public void setReturnDepAirportName(String returnDepAirportName) {
		this.returnDepAirportName = returnDepAirportName;
	}

	public String getReturnArrAirportCode() {
		return returnArrAirportCode;
	}

	public void setReturnArrAirportCode(String returnArrAirportCode) {
		this.returnArrAirportCode = returnArrAirportCode;
	}

	public String getReturnArrAirportName() {
		return returnArrAirportName;
	}

	public void setReturnArrAirportName(String returnArrAirportName) {
		this.returnArrAirportName = returnArrAirportName;
	}

	public String getReturnDepCityCode() {
		return returnDepCityCode;
	}

	public void setReturnDepCityCode(String returnDepCityCode) {
		this.returnDepCityCode = returnDepCityCode;
	}

	public String getReturnDepCityName() {
		return returnDepCityName;
	}

	public void setReturnDepCityName(String returnDepCityName) {
		this.returnDepCityName = returnDepCityName;
	}

	public String getReturnArrCityCode() {
		return returnArrCityCode;
	}

	public void setReturnArrCityCode(String returnArrCityCode) {
		this.returnArrCityCode = returnArrCityCode;
	}

	public String getReturnArrCityName() {
		return returnArrCityName;
	}

	public void setReturnArrCityName(String returnArrCityName) {
		this.returnArrCityName = returnArrCityName;
	}

	public Date getReturnDepTime() {
		return returnDepTime;
	}

	public void setReturnDepTime(Date returnDepTime) {
		this.returnDepTime = returnDepTime;
	}

	public Date getReturnArrTime() {
		return returnArrTime;
	}

	public void setReturnArrTime(Date returnArrTime) {
		this.returnArrTime = returnArrTime;
	}

	public String getReturnSeatClassCode() {
		return returnSeatClassCode;
	}

	public void setReturnSeatClassCode(String returnSeatClassCode) {
		this.returnSeatClassCode = returnSeatClassCode;
	}
	
	
}
