package com.lvmama.lvf.common.dto.flight;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlRootElement;

import com.lvmama.lvf.common.dto.AEEntity;
import com.lvmama.lvf.common.dto.enums.PassengerType;

@XmlRootElement
public class FlightFuelsurTaxDto extends AEEntity implements Serializable {

	/**开始英里数，默认为0 */
	private Integer startMileage = 0;

	/**结束英里数 */
	private Integer endMileage;

	/**燃油费 */
	private BigDecimal taxAmount;
    
	/**乘客类型 */
	private PassengerType passengerType;

	/**描述信息 */
	private String desc;
	
	/**航班号*/
	private String flightNo;

	public Integer getStartMileage() {
		return startMileage;
	}

	public void setStartMileage(Integer startMileage) {
		this.startMileage = startMileage;
	}

	public Integer getEndMileage() {
		return endMileage;
	}

	public void setEndMileage(Integer endMileage) {
		this.endMileage = endMileage;
	}

	public BigDecimal getTaxAmount() {
		return taxAmount;
	}

	public void setTaxAmount(BigDecimal taxAmount) {
		this.taxAmount = taxAmount;
	}

	public PassengerType getPassengerType() {
		return passengerType;
	}

	public void setPassengerType(PassengerType passengerType) {
		this.passengerType = passengerType;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getFlightNo() {
		return flightNo;
	}

	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}

	
	

}
