package com.lvmama.lvf.common.dto.md;

import java.util.List;

import com.lvmama.lvf.common.dto.NameCode;
import com.lvmama.lvf.common.dto.calculator.FlightTicketPriceDto;
import com.lvmama.lvf.common.dto.enums.SeatClassType;

/**
 * 舱位信息
 * @author jiacheng
 * @date   2015-7-10
 */
public class SeatClassCarrier extends NameCode  
{

	private static final long serialVersionUID = -2250507178885179478L;
	
	/**舱位类型*/
	private SeatClassType seatClassType;
	/**承运人机场code*/
	private String carrierCode;
	/**票规*/
	private String ticketRule;
	/**舱位备注*/
	private String seatRemark;
	
	/**热度*/
	private Integer hot;
	
	/**退改规则*/
	private List<SeatRule> seatRules;
	
	/**政策有效期*/
	private String policyExpDate;
	
	/**旅行有效期*/
	private String travelExpDate;
	
	public List<SeatRule> getSeatRules() {
		return seatRules;
	}

	public void setSeatRules(List<SeatRule> seatRules) {
		this.seatRules = seatRules;
	}

	public Integer getHot() {
		return hot;
	}

	public void setHot(Integer hot) {
		this.hot = hot;
	}

	private  FlightTicketPriceDto flightTicketPriceDto=new FlightTicketPriceDto();

	public SeatClassType getSeatClassType() {
		return seatClassType;
	}

	public void setSeatClassType(SeatClassType seatClassType) {
		this.seatClassType = seatClassType;
	}

	public String getCarrierCode() {
		return carrierCode;
	}

	public void setCarrierCode(String carrierCode) {
		this.carrierCode = carrierCode;
	}

	public String getTicketRule() {
		return ticketRule;
	}

	public void setTicketRule(String ticketRule) {
		this.ticketRule = ticketRule;
	}

	public String getSeatRemark() {
		return seatRemark;
	}

	public void setSeatRemark(String seatRemark) {
		this.seatRemark = seatRemark;
	}

	public FlightTicketPriceDto getFlightTicketPriceDto() {
		return flightTicketPriceDto;
	}

	public void setFlightTicketPriceDto(FlightTicketPriceDto flightTicketPriceDto) {
		this.flightTicketPriceDto = flightTicketPriceDto;
	}

	public String getPolicyExpDate() {
		return policyExpDate;
	}

	public void setPolicyExpDate(String policyExpDate) {
		this.policyExpDate = policyExpDate;
	}

	public String getTravelExpDate() {
		return travelExpDate;
	}

	public void setTravelExpDate(String travelExpDate) {
		this.travelExpDate = travelExpDate;
	}
	
}
