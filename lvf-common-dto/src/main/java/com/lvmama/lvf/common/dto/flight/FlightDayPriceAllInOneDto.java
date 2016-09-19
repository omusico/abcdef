package com.lvmama.lvf.common.dto.flight;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

import com.lvmama.lvf.common.dto.AEEntity;
import com.lvmama.lvf.common.dto.enums.SeatSpecType;

/**
 * 航班每日价格
 *
 */
@XmlRootElement
public class FlightDayPriceAllInOneDto extends AEEntity implements Serializable {
	private static final long serialVersionUID = 876373722215210193L;
	
	/** 出发机场三字码 */
	private String deptAirportCode;
	
	/** 出发机场中文名 */
	private String deptAirportName;
	
	/** 到达机场三字码 */
	private String arrvAirportCode;
	
	/** 到达机场中文名 */
	private String arrvAirportName;
	
	/** 出发日期 */
	private String deptDate;
	
	/** 航班号 */
	private String flightNO;
	
	/** 舱位编码 */
	private String seatCode;
	
	/** 舱位类型 */
	private SeatSpecType seatSpecType;
	
	/** 票面价 */
	private BigDecimal parPrice;

	/** 最后修改时间(接口返回) */
	private String lastModifiedTime;
	
	/**日期对应的星期*/
	private String week;
	
	/**只有M-D格式的日期*/
	private String mDay;
	
	private boolean lowestFlag;
	
	/** 最低价是否有效*/
	private boolean isLowestPriceAvailable;

	public String getDeptAirportCode() {
		return deptAirportCode;
	}

	public void setDeptAirportCode(String deptAirportCode) {
		this.deptAirportCode = deptAirportCode;
	}

	public String getDeptAirportName() {
		return deptAirportName;
	}

	public void setDeptAirportName(String deptAirportName) {
		this.deptAirportName = deptAirportName;
	}

	public String getArrvAirportCode() {
		return arrvAirportCode;
	}

	public void setArrvAirportCode(String arrvAirportCode) {
		this.arrvAirportCode = arrvAirportCode;
	}

	public String getArrvAirportName() {
		return arrvAirportName;
	}

	public void setArrvAirportName(String arrvAirportName) {
		this.arrvAirportName = arrvAirportName;
	}

	public String getDeptDate() {
		return deptDate;
	}

	public void setDeptDate(String deptDate) {
		this.deptDate = deptDate;
	}

	public String getFlightNO() {
		return flightNO;
	}

	public void setFlightNO(String flightNO) {
		this.flightNO = flightNO;
	}

	public String getSeatCode() {
		return seatCode;
	}

	public void setSeatCode(String seatCode) {
		this.seatCode = seatCode;
	}

	public SeatSpecType getSeatSpecType() {
		return seatSpecType;
	}

	public void setSeatSpecType(SeatSpecType seatSpecType) {
		this.seatSpecType = seatSpecType;
	}

	public BigDecimal getParPrice() {
		if(parPrice!=null){
			return parPrice.setScale(0,BigDecimal.ROUND_UP);
		}
		return parPrice;
	}

	public void setParPrice(BigDecimal parPrice) {
		this.parPrice = parPrice;
	}

	public String getLastModifiedTime() {
		return lastModifiedTime;
	}

	public void setLastModifiedTime(String lastModifiedTime) {
		this.lastModifiedTime = lastModifiedTime;
	}

	public String getWeek() {
		return week;
	}

	public void setWeek(String week) {
		this.week = week;
	}

	public String getmDay() {
		return mDay;
	}

	public void setmDay(String mDay) {
		this.mDay = mDay;
	}

	public boolean isLowestFlag() {
		return lowestFlag;
	}

	public void setLowestFlag(boolean lowestFlag) {
		this.lowestFlag = lowestFlag;
	}

	public boolean isLowestPriceAvailable() {
		return isLowestPriceAvailable;
	}

	public void setLowestPriceAvailable(boolean isLowestPriceAvailable) {
		this.isLowestPriceAvailable = isLowestPriceAvailable;
	}
	
	
}
