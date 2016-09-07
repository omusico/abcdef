package com.lvmama.lvf.common.dto.supp;

import java.io.Serializable;
import java.util.List;

import com.lvmama.lvf.common.dto.Entity;
import com.lvmama.lvf.common.dto.order.FlightOrderFlightCombinationDto;

/**
 * 供应商主订单信息
 * @author majun
 * @date 2015-7-8
 */
public class FlightOrderSuppOrderMainDto extends Entity implements Serializable
{
	private static final long serialVersionUID = -4230971697209198303L;
	
	/** 供应商主单号 */
	private String suppOrderMainNo;
	
	/** 驴妈妈主单号 */
	private String lvOrderMainNo;
	
	/** 订单支付交易号 */
	private String externalNo;
	
	/** 供应商编码 */
	private String suppCode;
	
	/** 供应商订单列表*/
	private List<FlightOrderSuppOrderDto> flightOrderSuppOrderDtos;
	
	/** 订单航线组合信息 */
	private FlightOrderFlightCombinationDto flightOrderFlightCombinationDto;

	public String getSuppOrderMainNo() {
		return suppOrderMainNo;
	}

	public void setSuppOrderMainNo(String suppOrderMainNo) {
		this.suppOrderMainNo = suppOrderMainNo;
	}

	public String getExternalNo() {
		return externalNo;
	}

	public void setExternalNo(String externalNo) {
		this.externalNo = externalNo;
	}

	public List<FlightOrderSuppOrderDto> getFlightOrderSuppOrderDtos() {
		return flightOrderSuppOrderDtos;
	}

	public void setFlightOrderSuppOrderDtos(
			List<FlightOrderSuppOrderDto> flightOrderSuppOrderDtos) {
		this.flightOrderSuppOrderDtos = flightOrderSuppOrderDtos;
	}

	public String getSuppCode() {
		return suppCode;
	}

	public void setSuppCode(String suppCode) {
		this.suppCode = suppCode;
	}

	public String getLvOrderMainNo() {
		return lvOrderMainNo;
	}

	public void setLvOrderMainNo(String lvOrderMainNo) {
		this.lvOrderMainNo = lvOrderMainNo;
	}

	public FlightOrderFlightCombinationDto getFlightOrderFlightCombinationDto() {
		return flightOrderFlightCombinationDto;
	}

	public void setFlightOrderFlightCombinationDto(
			FlightOrderFlightCombinationDto flightOrderFlightCombinationDto) {
		this.flightOrderFlightCombinationDto = flightOrderFlightCombinationDto;
	}
}
