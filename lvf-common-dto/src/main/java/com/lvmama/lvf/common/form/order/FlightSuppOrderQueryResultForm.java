package com.lvmama.lvf.common.form.order;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;

import com.lvmama.lvf.common.dto.enums.PaymentType;
import com.lvmama.lvf.common.dto.order.FlightOrderFlightInfoDto;
import com.lvmama.lvf.common.dto.order.result.list.FlightOrderListDto;
import com.lvmama.lvf.common.dto.order.result.list.FlightOrderListFlightInfoDto;
import com.lvmama.lvf.common.dto.supp.FlightOrderSuppOrderPassengerDto;
import com.lvmama.lvf.common.dto.supp.FlightOrderSuppOrderStatusDto;
import com.lvmama.lvf.common.dto.supp.FlightSupOrderDto;
import com.lvmama.lvf.common.form.Form;
import com.lvmama.lvf.common.utils.DateUtils;
/**
 * 供应商订单查询
 * @author xumeng
 */
public class FlightSuppOrderQueryResultForm implements Serializable,Form {

	private static final long serialVersionUID = 1L;
	
	/** 航程 */
	private String flightSegments = StringUtils.EMPTY;
	
	/** 航班号 */
	private String flightNos = StringUtils.EMPTY;
	
	/** 支付方式 */
	private String paymentMethod = StringUtils.EMPTY;
	
	private FlightSupOrderDto flightSupOrderDto = new FlightSupOrderDto();
	
	
	public FlightSuppOrderQueryResultForm(
			FlightSupOrderDto flightSupOrderDto) {
		this.flightSupOrderDto = flightSupOrderDto;
		//订单对应航班相关信息 
		List<FlightOrderListFlightInfoDto> flightInfoDtos = flightSupOrderDto.getFlightOrderListFlightInfos();
		if(CollectionUtils.isNotEmpty(flightInfoDtos))
		{
			for(FlightOrderListFlightInfoDto flightInfoDto : flightInfoDtos)
			{
				if(StringUtils.isNotBlank(flightInfoDto.getDepCode()))
				{
					//航程
					this.flightSegments += flightInfoDto.getDepCode() + "-" + flightInfoDto.getArrCode() + ",";
				}	
				
				if(StringUtils.isNotBlank(flightInfoDto.getFlightNo()))
				{
					//航班号
					this.flightNos += flightInfoDto.getFlightNo() + "(" + flightInfoDto.getSeatClassCode() + "),";
				}
				if(StringUtils.isNotBlank(this.flightSegments))
				{
					this.flightSegments = this.flightSegments.substring(0, this.flightSegments.length() - 1);
				}	
				if(StringUtils.isNotBlank(this.flightNos))
				{
					this.flightNos = this.flightNos.substring(0, this.flightNos.length() - 1);
				}	
			}
		}
		//支付方式
		List<PaymentType> paymentTypes = flightSupOrderDto.getPaymentTypes();
		if(CollectionUtils.isNotEmpty(paymentTypes))
		{
			for(PaymentType paymentType : paymentTypes)
			{
				this.paymentMethod += paymentType.getCnName() + ",";
			}
			this.paymentMethod = this.paymentMethod.substring(0, this.paymentMethod.length() - 1);
		}

	}

	/** 供应商订单主键 */
	public Long getOrderId() {
		return flightSupOrderDto.getOrderId();
	}
	
	/** 供应商Code */
	public String getSuppCode() {
		if(flightSupOrderDto.getSupp()==null) return "";
		return flightSupOrderDto.getSupp().getCode();
	}

	/**订单PNR信息*/
	public String getPnr() {
		if(flightSupOrderDto.getFlightOrderPNRInfo()==null) return "";
		return flightSupOrderDto.getFlightOrderPNRInfo().getPnr();
	}

	/** 供应商订单编号 */
	public String getSuppOrderNo() {
		return flightSupOrderDto.getSuppOrderNo();
	}

	/**下单时间*/
	public String getCreateTime() {
		if(flightSupOrderDto.getCreateTime()!=null){
			return DateUtils.formatCnHmDate(this.flightSupOrderDto.getCreateTime());
		}
		return "";
	}
	/** 供应商OFFICE号 */
	public String getSuppOfficeNo() {
		return flightSupOrderDto.getSuppOfficeNo();
	}

	/** 供应商订单对应的驴妈妈编号 */
	public String getSuppOrderLvNo() {
		return flightSupOrderDto.getSuppOrderLvNo();
	}
	
	/** 供应商票面总价 */
	public String getSuppTotalParPrice() {
		if(flightSupOrderDto.getFlightOrderSuppOrderAmount()==null
				||flightSupOrderDto.getFlightOrderSuppOrderAmount().getSuppTotalParPrice()==null){
			return "";
		}
		return String.valueOf(flightSupOrderDto.getFlightOrderSuppOrderAmount().getSuppTotalParPrice());
	}

	/** 供应商燃油总价 */
	public String getSuppTotalFuelTax() {
		if(flightSupOrderDto.getFlightOrderSuppOrderAmount()==null
				||flightSupOrderDto.getFlightOrderSuppOrderAmount().getSuppTotalFuelTax()==null){
			return "";
		}
		return String.valueOf(flightSupOrderDto.getFlightOrderSuppOrderAmount().getSuppTotalFuelTax());
	}

	/** 供应商机建总价 */
	public String getSuppTotalAirportTax() {
		if(flightSupOrderDto.getFlightOrderSuppOrderAmount()==null
				||flightSupOrderDto.getFlightOrderSuppOrderAmount().getSuppTotalAirportTax()==null){
			return "";
		}
		return String.valueOf(flightSupOrderDto.getFlightOrderSuppOrderAmount().getSuppTotalAirportTax());
	}

	/** 供应商总结算价 */
	public String getSuppSettlePrice() {
		if(flightSupOrderDto.getFlightOrderSuppOrderAmount()==null
				||flightSupOrderDto.getFlightOrderSuppOrderAmount().getSuppSettlePrice()==null){
			return "";
		}
		return String.valueOf(flightSupOrderDto.getFlightOrderSuppOrderAmount().getSuppSettlePrice());
	}
	/**	乘客信息 */
	public List<FlightOrderSuppOrderPassengerDto> getFlightOrderSuppOrderPassengers() {
		return flightSupOrderDto.getFlightOrderSuppOrderPassengers();
	}
	
	/** 供应商订单状态 */
	public FlightOrderSuppOrderStatusDto getFlightOrderSuppOrderStatus() {
		return flightSupOrderDto.getFlightOrderSuppOrderStatus();
	}
	
	public String getFlightSegments() {
		return flightSegments;
	}

	public void setFlightSegments(String flightSegments) {
		this.flightSegments = flightSegments;
	}

	public String getFlightNos() {
		return flightNos;
	}

	public void setFlightNos(String flightNos) {
		this.flightNos = flightNos;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public FlightSupOrderDto getFlightSupOrderDto() {
		return flightSupOrderDto;
	}

	public void setFlightSupOrderDto(FlightSupOrderDto flightSupOrderDto) {
		this.flightSupOrderDto = flightSupOrderDto;
	}

}
