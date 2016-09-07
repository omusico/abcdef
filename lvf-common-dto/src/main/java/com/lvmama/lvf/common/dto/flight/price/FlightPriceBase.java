package com.lvmama.lvf.common.dto.flight.price;

import java.io.Serializable;
import java.math.BigDecimal;

import org.apache.commons.lang3.StringUtils;

import com.lvmama.lvf.common.utils.MD5Utils;

/**
 * 航班运价基类
 * @author majun
 * @date 2015-7-29
 */
public class FlightPriceBase implements Serializable
{
	private static final long serialVersionUID = -1032049546008855213L;

	/** 航班号 */
	private String flightNo;
	
	/** 舱位代码*/
	private String seatClassCode;
	
	/** 出发机场代码 */
	private String departureAirportCode;

	/** 到达机场代码 */
	private String arrivalAirportCode;
	
	/** 出发城市代码 */
	private String departureCityCode;
	
	/** 到达城市代码 */
	private String arrivalCityCode;
	
	/** 出发日期毫秒数 */
	private Long departureDate;
	
	/** LV舱位代码(舱位代码+票面价) */
	private String lvSeatClassCode;
	
	/** 版本号(当前时间毫秒数) */
	private Long versionNo;
	
	/** MD5签名串 */
	private String md5Sign;
	
	/**
	 * 生成LV舱位代码(舱位代码+整型票面价)
	 * @param 	seatClassCode		舱位代码
	 * @param 	parPrice			票面价
	 * @return	String				LV舱位代码
	 */
	public static String generatorLvSeatClassCode(String seatClassCode, BigDecimal parPrice)
	{
		if(StringUtils.isBlank(seatClassCode))
			throw new IllegalArgumentException("seatClassCode cannot be empty!");
		if(parPrice == null)
			throw new IllegalArgumentException("parPrice cannot be empty!");
		
		return seatClassCode + parPrice.intValue();
	}
	
	/**
	 * 生成MD5Sign
	 * @param 	flightNo						航班号
	 * @param 	departureAirportCode			出发机场编码
	 * @param 	arrivalAirportCode				到达机场编码	
	 * @param 	departureDate					出发日期毫秒数
	 * @param 	lvSeatClassCode					LV舱位代码
	 * @return	String							MD5签名串
	 */
	public static String generatorMD5Sign(String flightNo, String departureAirportCode, String arrivalAirportCode, 
		Long departureDate, String lvSeatClassCode)
	{
		StringBuffer sb = new StringBuffer(100);
		sb.append(flightNo)
		.append(departureAirportCode)
		.append(arrivalAirportCode)
		.append(departureDate)
		.append(lvSeatClassCode);
		
		return MD5Utils.generatePassword(sb.toString());
	}
	
	public String getFlightNo() {
		return flightNo;
	}

	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}

	public String getSeatClassCode() {
		return seatClassCode;
	}

	public void setSeatClassCode(String seatClassCode) {
		this.seatClassCode = seatClassCode;
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
		return departureCityCode;
	}

	public void setDepartureCityCode(String departureCityCode) {
		this.departureCityCode = departureCityCode;
	}

	public String getArrivalCityCode() {
		return arrivalCityCode;
	}

	public void setArrivalCityCode(String arrivalCityCode) {
		this.arrivalCityCode = arrivalCityCode;
	}

	public Long getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(Long departureDate) {
		this.departureDate = departureDate;
	}

	public String getLvSeatClassCode() {
		return lvSeatClassCode;
	}

	public void setLvSeatClassCode(String lvSeatClassCode) {
		this.lvSeatClassCode = lvSeatClassCode;
	}

	public Long getVersionNo() {
		return versionNo;
	}

	public void setVersionNo(Long versionNo) {
		this.versionNo = versionNo;
	}

	public String getMd5Sign() {
		return md5Sign;
	}

	public void setMd5Sign(String md5Sign) {
		this.md5Sign = md5Sign;
	}
}
