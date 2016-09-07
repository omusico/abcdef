package com.lvmama.lvf.common.dto.adapter.request.supp;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import com.lvmama.lvf.common.dto.adapter.request.supp.base.SuppRequest;
import com.lvmama.lvf.common.dto.supp.FlightOrderSuppOrderMainDto;
import com.lvmama.lvf.common.dto.supp.SuppFlightProductDto;

/**
 * 供应商创建订单请求对象(针对携程)
 * 
 * @date   2015-07-09
 * 注：该对象为实际和供应商的请求对象进行转换对象
 */
@XmlRootElement
public class FlightSuppBookingRequests extends SuppRequest implements Serializable {

	private static final long serialVersionUID = 1692724272657884298L;
	
	private FlightOrderSuppOrderMainDto flightOrderSuppOrderMainDto;

	private SuppFlightProductDto suppFlightProductDto;
	
	public FlightOrderSuppOrderMainDto getFlightOrderSuppOrderMainDto() {
		return flightOrderSuppOrderMainDto;
	}

	public void setFlightOrderSuppOrderMainDto(
			FlightOrderSuppOrderMainDto flightOrderSuppOrderMainDto) {
		this.flightOrderSuppOrderMainDto = flightOrderSuppOrderMainDto;
	}

	public SuppFlightProductDto getSuppFlightProductDto() {
		return suppFlightProductDto;
	}

	public void setSuppFlightProductDto(SuppFlightProductDto suppFlightProductDto) {
		this.suppFlightProductDto = suppFlightProductDto;
	}

}
