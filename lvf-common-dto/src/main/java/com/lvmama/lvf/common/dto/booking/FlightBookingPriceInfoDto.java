package com.lvmama.lvf.common.dto.booking;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import com.lvmama.lvf.common.dto.calculator.FlightTicketPriceDto;
import com.lvmama.lvf.common.dto.enums.PassengerType;

/**
 * 预订验价返回的价格信息
 * @author majun
 * @date   2015-2-10
 */
public class FlightBookingPriceInfoDto implements Serializable 
{
	private static final long serialVersionUID = -1023367481226870960L;
	
	/** 航班号 */
	private String flightNo;
	
	/** 舱位代码 */
	private String seatClassCode;
	
	/** 政策主键 */
	private Long policyId;
	
	/**票价信息 */
	private List<FlightTicketPriceDto> flightTicketPrices; 
	
	/**库存数量 */
	private Integer inventoryCount;

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

	public Long getPolicyId() {
		return policyId;
	}

	public void setPolicyId(Long policyId) {
		this.policyId = policyId;
	}

	public List<FlightTicketPriceDto> getFlightTicketPrices() {
		return flightTicketPrices;
	}

	public void setFlightTicketPrices(List<FlightTicketPriceDto> flightTicketPrices) {
		this.flightTicketPrices = flightTicketPrices;
	}

	public BigDecimal getLatestAdultParPrice(){
		if(CollectionUtils.isNotEmpty(this.getFlightTicketPrices())){
			for (FlightTicketPriceDto flightTicketPriceDto : flightTicketPrices) {
				if(flightTicketPriceDto.getPassengerType()==PassengerType.ADULT){
					return flightTicketPriceDto.getParPrice();
				}
			}
		}
		return null;
	}

	public Integer getInventoryCount() {
		return inventoryCount;
	}

	public void setInventoryCount(Integer inventoryCount) {
		this.inventoryCount = inventoryCount;
	}
	
	
}
