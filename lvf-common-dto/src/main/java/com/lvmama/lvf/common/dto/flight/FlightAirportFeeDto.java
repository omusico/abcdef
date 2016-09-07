package com.lvmama.lvf.common.dto.flight;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlRootElement;

import com.lvmama.lvf.common.dto.AEEntity;
import com.lvmama.lvf.common.dto.enums.FlightSegmentType;
import com.lvmama.lvf.common.dto.enums.PassengerType;

@XmlRootElement
public class FlightAirportFeeDto extends AEEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1204319595630571475L;
	
//	/**飞机所属公司 */
//	private String airplaneCompany;
//	
//	/**飞机代码 */
//	private String airplaneCode;
//	
//	/**飞机名称*/
//	private String airplaneName;
//	
//	/**飞机类型*/
//	private String airplaneType;
	
	/**航段类型 */
	private FlightSegmentType flightSegmentType;
	
	/**机建费*/
	private BigDecimal feeAmount;
	
	/**描述信息*/
	private String desc;
	
	/**乘客类型 */
	private PassengerType passengerType;
	
	private String flightNo;
	
//	public String getAirplaneType() {
//		return airplaneType;
//	}
//	public void setAirplaneType(String airplaneType) {
//		this.airplaneType = airplaneType;
//	}
//	public String getAirplaneCompany() {
//		return airplaneCompany;
//	}
//	public void setAirplaneCompany(String airplaneCompany) {
//		this.airplaneCompany = airplaneCompany;
//	}
//	public String getAirplaneCode() {
//		return airplaneCode;
//	}
//	public void setAirplaneCode(String airplaneCode) {
//		this.airplaneCode = airplaneCode;
//	}
//	public String getAirplaneName() {
//		return airplaneName;
//	}
//	public void setAirplaneName(String airplaneName) {
//		this.airplaneName = airplaneName;
//	}
	public FlightSegmentType getFlightSegmentType() {
		return flightSegmentType;
	}
	public void setFlightSegmentType(FlightSegmentType flightSegmentType) {
		this.flightSegmentType = flightSegmentType;
	}
	public BigDecimal getFeeAmount() {
		return feeAmount;
	}
	public void setFeeAmount(BigDecimal feeAmount) {
		this.feeAmount = feeAmount;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public PassengerType getPassengerType() {
		return passengerType;
	}
	public void setPassengerType(PassengerType passengerType) {
		this.passengerType = passengerType;
	}
	public String getFlightNo() {
		return flightNo;
	}
	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}
	

}
