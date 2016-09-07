package com.lvmama.lvf.common.form.booking;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

import com.lvmama.lvf.common.dto.booking.FlightOrderIntentionRecordDto;
import com.lvmama.lvf.common.dto.enums.BookingSource;
import com.lvmama.lvf.common.dto.enums.FlightTripType;
import com.lvmama.lvf.common.dto.enums.SeatClassType;
import com.lvmama.lvf.common.form.Form;
import com.lvmama.lvf.common.utils.DateUtils;

public class FlightOrderIntentionRecordResultForm  implements Serializable, Form {
	
	FlightOrderIntentionRecordDto flightOrderIntentionRecordDto = new FlightOrderIntentionRecordDto();
	
	/**处理后的乘机时间*/
	private String depTime_af = StringUtils.EMPTY;
	private String createTime_af = StringUtils.EMPTY;
	
	public FlightOrderIntentionRecordResultForm(
			FlightOrderIntentionRecordDto flightOrderIntentionRecordDto) {
		this.flightOrderIntentionRecordDto = flightOrderIntentionRecordDto;
		//乘机时间
		if(flightOrderIntentionRecordDto.getDepTime() != null)
		{
			this.depTime_af += DateUtils.formatDate(flightOrderIntentionRecordDto.getDepTime(), DateUtils.YYYY_MM_DD_HH_MM);
		}
		//请求时间
		if(flightOrderIntentionRecordDto.getCreateTime()!=null){
			this.createTime_af = DateUtils.formatDate(flightOrderIntentionRecordDto.getCreateTime(), DateUtils.YYYY_MM_DD_HH_MM_SS);
		}
	}

	public FlightOrderIntentionRecordDto getFlightOrderIntentionRecordDto() {
		return flightOrderIntentionRecordDto;
	}

	public void setFlightOrderIntentionRecordDto(
			FlightOrderIntentionRecordDto flightOrderIntentionRecordDto) {
		this.flightOrderIntentionRecordDto = flightOrderIntentionRecordDto;
	}

	public Long getId() {
		return flightOrderIntentionRecordDto.getId();
	}

	public Date getCreateTime() {
		return flightOrderIntentionRecordDto.getCreateTime();
	}

	public String getLvmamaAccount() {
		return flightOrderIntentionRecordDto.getLvmamaAccount();
	}

	public String getBookingSource() {
		BookingSource bookingSource = flightOrderIntentionRecordDto.getBookingSource();
		if(bookingSource==null){
			return "";
		}
		return flightOrderIntentionRecordDto.getBookingSource().getCnName();
	}

	public String getFlightTripType() {
		FlightTripType flightTripType = flightOrderIntentionRecordDto.getFlightTripType();
		if(flightTripType==null){
			return "";
		}
		return flightOrderIntentionRecordDto.getFlightTripType().getCnName();
	}

	public String getDepAirportCityCode() {
		return flightOrderIntentionRecordDto.getDepAirportCityCode();
	}

	public String getArrAirportCityCode() {
		return flightOrderIntentionRecordDto.getArrAirportCityCode();
	}

	public String getDepCode() {
		return flightOrderIntentionRecordDto.getDepCode();
	}

	public String getArrCode() {
		return flightOrderIntentionRecordDto.getArrCode();
	}

	public String getCarrierCode() {
		return flightOrderIntentionRecordDto.getCarrierCode();
	}

	public String getFlightNo() {
		return flightOrderIntentionRecordDto.getFlightNo();
	}

	public String getSeatClassCode() {
		return flightOrderIntentionRecordDto.getSeatClassCode();
	}

	public String getSeatClassType() {
		SeatClassType seatClassType = flightOrderIntentionRecordDto.getSeatClassType();
		if(seatClassType==null){
			return "";
		}
		return flightOrderIntentionRecordDto.getSeatClassType().getCnName();
	}

	public Date getDepTime() {
		return flightOrderIntentionRecordDto.getDepTime();
	}

	public String getDepTime_af() {
		return depTime_af;
	}

	public String getCreateTime_af() {
		return createTime_af;
	}

	public String getDepAirportCityCodeName() {
		return flightOrderIntentionRecordDto.getDepAirportCityCodeName();
	}

	public String getArrAirportCityCodeName() {
		return flightOrderIntentionRecordDto.getArrAirportCityCodeName();
	}

	public String getDepCodeName() {
		return flightOrderIntentionRecordDto.getDepCodeName();
	}

	public String getArrCodeName() {
		return flightOrderIntentionRecordDto.getArrCodeName();
	}

	public String getCarrierCodeName() {
		return flightOrderIntentionRecordDto.getCarrierCodeName();
	}
	
}
