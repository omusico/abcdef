package com.lvmama.lvf.common.dto.supp;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.lvmama.lvf.common.dto.enums.PaymentType;
import com.lvmama.lvf.common.dto.order.result.list.FlightOrderListDto;
import com.lvmama.lvf.common.dto.order.result.list.FlightOrderListFlightInfoDto;

/**
 * 供应商订单列表DTO
 * @author xumeng
 *
 */
@XmlRootElement
public class FlightSupOrderDto extends FlightOrderSuppOrderDto{
    /** 支付方式 */
    private List<PaymentType> paymentTypes;
    /** 订单列表航班信息列表 */
    private List<FlightOrderListFlightInfoDto> flightOrderListFlightInfos;
	public List<PaymentType> getPaymentTypes() {
		return paymentTypes;
	}
	public void setPaymentTypes(List<PaymentType> paymentTypes) {
		this.paymentTypes = paymentTypes;
	}
	public List<FlightOrderListFlightInfoDto> getFlightOrderListFlightInfos() {
		return flightOrderListFlightInfos;
	}
	public void setFlightOrderListFlightInfos(
			List<FlightOrderListFlightInfoDto> flightOrderListFlightInfos) {
		this.flightOrderListFlightInfos = flightOrderListFlightInfos;
	}
}
