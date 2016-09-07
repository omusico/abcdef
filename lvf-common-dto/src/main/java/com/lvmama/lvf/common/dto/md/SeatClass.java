package com.lvmama.lvf.common.dto.md;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.annotate.JsonIgnore;

import com.lvmama.lvf.common.dto.NameCode;
import com.lvmama.lvf.common.dto.calculator.FlightTicketPriceDto;
import com.lvmama.lvf.common.dto.enums.SeatClassStatus;
import com.lvmama.lvf.common.dto.enums.SeatClassType;

/**
 * 舱位信息
 * @author majun
 * @date   2015-1-22
 */
public class SeatClass extends NameCode
{
	private static final long serialVersionUID = 2839273631730858300L;

	/**舱位类型*/
	private SeatClassType seatClassType;
	/**儿童基准仓位码*/
	private String chdSeatClassCode;

	/**承运人机场code*/
	private String carrierCode;
	/**票规*/
	private String ticketRule;
	/**舱位备注*/
	private String seatRemark;
	/**热度*/
	private Integer hot;

	/**政策有效期*/
	private Date policyExpDate;

	/**旅行有效期*/
	private Date travelExpDate;
	
	/**政策有效期*/
	private Date policyValidDate;

	/**旅行有效期*/
	private Date travelValidDate;

	/**舱位信息补全状态 */
	private SeatClassStatus seatClassStatus;

	/**退改规则*/
	private List<SeatRule> seatRules;

	private  FlightTicketPriceDto flightTicketPriceDto=new FlightTicketPriceDto();

	
	
	public SeatClassType getSeatClassType() {
		return seatClassType;
	}

	public void setSeatClassType(SeatClassType seatClassType) {
		this.seatClassType = seatClassType;
	}

	public String getChdSeatClassCode() {
		if(StringUtils.isEmpty(chdSeatClassCode)){
			if(null!=this.getSeatClassType()){
				return this.getSeatClassType().name();
			}
		}
		return chdSeatClassCode;
	}

	public void setChdSeatClassCode(String chdSeatClassCode) {
		this.chdSeatClassCode = chdSeatClassCode;
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

	public Integer getHot() {
		return hot;
	}

	public void setHot(Integer hot) {
		this.hot = hot;
	}

	public SeatClassStatus getSeatClassStatus() {
		return seatClassStatus;
	}

	public void setSeatClassStatus(SeatClassStatus seatClassStatus) {
		this.seatClassStatus = seatClassStatus;
	}

	public List<SeatRule> getSeatRules() {
		return seatRules;
	}

	public void setSeatRules(List<SeatRule> seatRules) {
		this.seatRules = seatRules;
	}

	public FlightTicketPriceDto getFlightTicketPriceDto() {
		return flightTicketPriceDto;
	}

	public void setFlightTicketPriceDto(FlightTicketPriceDto flightTicketPriceDto) {
		this.flightTicketPriceDto = flightTicketPriceDto;
	}


	public Date getPolicyExpDate() {
		return policyExpDate;
	}

	public void setPolicyExpDate(Date policyExpDate) {
		this.policyExpDate = policyExpDate;
	}

	public Date getTravelExpDate() {
		return travelExpDate;
	}

	public void setTravelExpDate(Date travelExpDate) {
		this.travelExpDate = travelExpDate;
	}
	public Date getPolicyValidDate() {
		return policyValidDate;
	}

	public void setPolicyValidDate(Date policyValidDate) {
		this.policyValidDate = policyValidDate;
	}

	public Date getTravelValidDate() {
		return travelValidDate;
	}

	public void setTravelValidDate(Date travelValidDate) {
		this.travelValidDate = travelValidDate;
	}

	@JsonIgnore
	@Override
	public String getSequence()
	{
		return "S_FMAD_SEAT_CLASS";
	}

}
