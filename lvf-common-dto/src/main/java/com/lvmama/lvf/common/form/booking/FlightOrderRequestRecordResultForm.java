package com.lvmama.lvf.common.form.booking;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

import com.lvmama.lvf.common.dto.booking.FlightOrderRequestRecordDto;
import com.lvmama.lvf.common.dto.enums.OrderFlag;
import com.lvmama.lvf.common.dto.enums.PassengerType;
import com.lvmama.lvf.common.dto.status.order.OrderStatus;
import com.lvmama.lvf.common.form.Form;
import com.lvmama.lvf.common.utils.DateUtils;

public class FlightOrderRequestRecordResultForm implements Serializable, Form {
	private static final long serialVersionUID = -9113296868107325697L;
	private FlightOrderRequestRecordDto flightOrderRequestRecordDto = new FlightOrderRequestRecordDto();
	/**处理后的乘机时间*/
	private String depTime_af = StringUtils.EMPTY;
	private String createTime_af = StringUtils.EMPTY;
	/**处理后的耗时*/
	private String consumeTime_af = StringUtils.EMPTY;
	/**处理后的乘客类型*/
	private String passengerType_af = StringUtils.EMPTY;
	/**处理后的乘客人数*/
	private String totalPassenger_af = StringUtils.EMPTY;
	public FlightOrderRequestRecordResultForm(
			FlightOrderRequestRecordDto flightOrderRequestRecordDto) {
		this.flightOrderRequestRecordDto = flightOrderRequestRecordDto;
		//乘机时间
		if(flightOrderRequestRecordDto.getDepTime() != null)
		{
			this.depTime_af += DateUtils.formatDate(flightOrderRequestRecordDto.getDepTime(), DateUtils.YYYY_MM_DD_HH_MM);
		}
		//请求时间
		if(flightOrderRequestRecordDto.getCreateTime()!=null){
			this.createTime_af = DateUtils.formatDate(flightOrderRequestRecordDto.getCreateTime(), DateUtils.YYYY_MM_DD_HH_MM_SS);
		}
		//乘客类型
		if(flightOrderRequestRecordDto.getPassengerTypeStr()!=null){
			String[] passengerTypeArr = flightOrderRequestRecordDto.getPassengerTypeStr().split("，");
			for(String passengerType:passengerTypeArr){
				passengerType_af += PassengerType.valueOf(passengerType).getCnName()+"，";
			}
			if(passengerType_af.endsWith("，")){//去除逗号
				passengerType_af=passengerType_af.substring(0, passengerType_af.lastIndexOf("，"));
			}
			passengerType_af="("+passengerType_af+")";
		}
		//处理后的乘客人数
		this.totalPassenger_af = flightOrderRequestRecordDto.getTotalPassenger()+passengerType_af;
		//耗时
		this.consumeTime_af = flightOrderRequestRecordDto.getConsumeTime();
	}
	public Long getId() {
		return flightOrderRequestRecordDto.getId();
	}
	public Date getCreateTime() {
		return flightOrderRequestRecordDto.getCreateTime();
	}
	public Date getUpdateTime() {
		return flightOrderRequestRecordDto.getUpdateTime();
	}
	public String getTraceNo() {
		return flightOrderRequestRecordDto.getTraceNo();
	}
	public String getDepAirportCityCode() {
		return flightOrderRequestRecordDto.getDepAirportCityCode();
	}
	public String getArrAirportCityCode() {
		return flightOrderRequestRecordDto.getArrAirportCityCode();
	}
	public String getDepCode() {
		return flightOrderRequestRecordDto.getDepCode();
	}
	public String getDepName() {
		return flightOrderRequestRecordDto.getDepName();
	}
	public String getArrCode() {
		return flightOrderRequestRecordDto.getArrCode();
	}
	public String getArrName() {
		return flightOrderRequestRecordDto.getArrName();
	}
	public Date getDepTime() {
		return flightOrderRequestRecordDto.getDepTime();
	}
	public String getAirplaneCompanyCode() {
		return flightOrderRequestRecordDto.getAirplaneCompanyCode();
	}
	public String getFlightNo() {
		return flightOrderRequestRecordDto.getFlightNo();
	}
	public String getSeatClassCode() {
		return flightOrderRequestRecordDto.getSeatClassCode();
	}
	public String getSeatClassType() {
		return flightOrderRequestRecordDto.getSeatClassType();
	}
	public String getSuppCode() {
		return flightOrderRequestRecordDto.getSuppCode();
	}
	public String getSuppPolicyNo() {
		return flightOrderRequestRecordDto.getSuppPolicyNo();
	}
	public BigDecimal getParPrice() {
		return flightOrderRequestRecordDto.getParPrice();
	}
	public BigDecimal getSettlePrice() {
		return flightOrderRequestRecordDto.getSettlePrice();
	}
	public BigDecimal getFuelsurTax() {
		return flightOrderRequestRecordDto.getFuelsurTax();
	}
	public BigDecimal getAirportFee() {
		return flightOrderRequestRecordDto.getAirportFee();
	}
	public Long getTotalPassenger() {
		return flightOrderRequestRecordDto.getTotalPassenger();
	}
	public BigDecimal getSumSalesPrice() {
		return flightOrderRequestRecordDto.getSumSalesPrice();
	}
	public String getLvmamaAccount() {
		return flightOrderRequestRecordDto.getLvmamaAccount();
	}
	public String getContactName() {
		return flightOrderRequestRecordDto.getContactName();
	}
	public String getContactCellphone() {
		return flightOrderRequestRecordDto.getContactCellphone();
	}
	public String getBookingSource() {
		if(flightOrderRequestRecordDto.getBookingSource()!=null){
			return flightOrderRequestRecordDto.getBookingSource().getCnName();
		}
		return "";
	}
	public String getOrderStatus() {
		OrderStatus orderStatus = flightOrderRequestRecordDto.getOrderStatus();
		if(orderStatus!=null){
			return orderStatus.getCnName();
		}
		return "";
	}
	public String getConsumeTime_af() {
		return consumeTime_af;
	}
	public String getOrderNo() {
		return flightOrderRequestRecordDto.getOrderNo();
	}
	public String getFailDesc() {
		return flightOrderRequestRecordDto.getFailDesc();
	}
	public String getJsonStr() {
		return flightOrderRequestRecordDto.getJsonStr();
	}
	public String getConsumeTime() {
		return flightOrderRequestRecordDto.getConsumeTime();
	}
	public String getDepTime_af() {
		return depTime_af;
	}
	public String getCreateTime_af() {
		return createTime_af;
	}
	public Long getOrderId() {
		return flightOrderRequestRecordDto.getOrderId();
	}
	public Long getOrderMainId() {
		return flightOrderRequestRecordDto.getOrderMainId();
	}
	public String getPassengerType_af() {
		return passengerType_af;
	}
	public String getTotalPassenger_af() {
		return totalPassenger_af;
	}
	public String getOrderFlag() {
		OrderFlag orderFlag = flightOrderRequestRecordDto.getOrderFlag();
		if(orderFlag==null){
			return "";
		}
		return orderFlag.getCnName();
	}

	public String getOriginSuppCode() {
		return flightOrderRequestRecordDto.getOriginSuppCode();
	}

	public String getOriginFailDesc() {
		return flightOrderRequestRecordDto.getOriginFailDesc();
	}
	
	
//	public String getIp() {
//		return flightOrderRequestRecordDto.getIp();
//	}
//	public void setIp(String ip) {
//		flightOrderRequestRecordDto.setIp(ip);
//	}
//	public String getEquipmentNo() {
//		return flightOrderRequestRecordDto.getEquipmentNo();
//	}
//	public void setEquipmentNo(String equipmentNo) {
//		flightOrderRequestRecordDto.setEquipmentNo(equipmentNo);
//	}
//	
	
	
}
