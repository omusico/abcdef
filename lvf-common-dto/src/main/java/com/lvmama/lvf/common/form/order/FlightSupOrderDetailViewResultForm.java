package com.lvmama.lvf.common.form.order;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import com.lvmama.lvf.common.dto.enums.RouteType;
import com.lvmama.lvf.common.dto.md.TimeSegmentRange;
import com.lvmama.lvf.common.dto.order.FlightOrderFlightCombinationDetailDto;
import com.lvmama.lvf.common.dto.order.FlightOrderFlightInfoDto;
import com.lvmama.lvf.common.dto.supp.FlightOrderSuppOrderPassengerDto;
import com.lvmama.lvf.common.dto.supp.FlightOrderSuppOrderStatusDto;
import com.lvmama.lvf.common.dto.supp.FlightOrderSuppOrderTicketInfoDto;
import com.lvmama.lvf.common.dto.supp.FlightSupOrderDetailViewDto;
import com.lvmama.lvf.common.form.Form;
import com.lvmama.lvf.common.utils.DateUtils;
/**
 * 
 * @author xumeng
 * 供应商订单详情Form
 */
public class FlightSupOrderDetailViewResultForm implements Serializable,Form  {
	private FlightSupOrderDetailViewDto flightSupOrderDetailViewDto = new FlightSupOrderDetailViewDto();

	public FlightSupOrderDetailViewResultForm(
			FlightSupOrderDetailViewDto flightSupOrderDetailViewDto) {
		this.flightSupOrderDetailViewDto = flightSupOrderDetailViewDto;
	}

	/** 供应商订单主键 */
	public Long getOrderId() {
		return flightSupOrderDetailViewDto.getOrderId();
	}
	
	/** 供应商Code */
	public String getSuppCode() {
		if(flightSupOrderDetailViewDto.getSupp()==null) return "";
		return flightSupOrderDetailViewDto.getSupp().getCode();
	}

	/**订单PNR信息*/
	public String getPnr() {
		if(flightSupOrderDetailViewDto.getFlightOrderPNRInfo()==null) return "";
		return flightSupOrderDetailViewDto.getFlightOrderPNRInfo().getPnr();
	}

	/** 供应商订单编号 */
	public String getSuppOrderNo() {
		return flightSupOrderDetailViewDto.getSuppOrderNo();
	}

	/**下单时间*/
	public String getCreateTime() {
		if(flightSupOrderDetailViewDto.getCreateTime()!=null){
			return DateUtils.formatCnHmDate(this.flightSupOrderDetailViewDto.getCreateTime());
		}
		return "";
	}
	/** 供应商OFFICE号 */
	public String getSuppOfficeNo() {
		return flightSupOrderDetailViewDto.getSuppOfficeNo();
	}

	/** 供应商订单对应的驴妈妈编号 */
	public String getSuppOrderLvNo() {
		return flightSupOrderDetailViewDto.getSuppOrderLvNo();
	}
	
	/** 供应商票面总价 */
	public String getSuppTotalParPrice() {
		if(flightSupOrderDetailViewDto.getFlightOrderSuppOrderAmount()==null
				||flightSupOrderDetailViewDto.getFlightOrderSuppOrderAmount().getSuppTotalParPrice()==null){
			return "";
		}
		return String.valueOf(flightSupOrderDetailViewDto.getFlightOrderSuppOrderAmount().getSuppTotalParPrice());
	}

	/** 供应商燃油总价 */
	public String getSuppTotalFuelTax() {
		if(flightSupOrderDetailViewDto.getFlightOrderSuppOrderAmount()==null
				||flightSupOrderDetailViewDto.getFlightOrderSuppOrderAmount().getSuppTotalFuelTax()==null){
			return "";
		}
		return String.valueOf(flightSupOrderDetailViewDto.getFlightOrderSuppOrderAmount().getSuppTotalFuelTax());
	}

	/** 供应商机建总价 */
	public String getSuppTotalAirportTax() {
		if(flightSupOrderDetailViewDto.getFlightOrderSuppOrderAmount()==null
				||flightSupOrderDetailViewDto.getFlightOrderSuppOrderAmount().getSuppTotalAirportTax()==null){
			return "";
		}
		return String.valueOf(flightSupOrderDetailViewDto.getFlightOrderSuppOrderAmount().getSuppTotalAirportTax());
	}

	/** 供应商总结算价 */
	public String getSuppSettlePrice() {
		if(flightSupOrderDetailViewDto.getFlightOrderSuppOrderAmount()==null
				||flightSupOrderDetailViewDto.getFlightOrderSuppOrderAmount().getSuppSettlePrice()==null){
			return "";
		}
		return String.valueOf(flightSupOrderDetailViewDto.getFlightOrderSuppOrderAmount().getSuppSettlePrice());
	}
	/**	乘客信息 */
	public List<FlightOrderSuppOrderPassengerDto> getFlightOrderSuppOrderPassengers() {
		return flightSupOrderDetailViewDto.getFlightOrderSuppOrderPassengers();
	}
	
	/** 供应商订单状态 */
	public FlightOrderSuppOrderStatusDto getFlightOrderSuppOrderStatus() {
		return flightSupOrderDetailViewDto.getFlightOrderSuppOrderStatus();
	}
	/**供应商订单客规明细相关*/
	public List<FlightOrderFlightCombinationDetailDto> getOrderFlightCombinationDetails() {
		return flightSupOrderDetailViewDto.getOrderFlightCombinationDetails();
	}
	/**供应商订单票号相应信息*/
	public List<FlightOrderSuppOrderTicketInfoDto> getFlightOrderSuppOrderTicketInfoDtos() {
		return flightSupOrderDetailViewDto
				.getFlightOrderSuppOrderTicketInfoDtos();
	}
	/**供应商航班相关信息*/
	public List<FlightOrderFlightInfoDto> getFlightOrderFlightInfos() {
		return flightSupOrderDetailViewDto.getFlightOrderFlightInfos();
	}
	/**线路信息*/
	public RouteType getRouteType() {
		return flightSupOrderDetailViewDto.getRouteType();
	}
	/**
	 * 航班跨天数
	 * @return
	 */
	public List<Integer> getFlightCrossDays()
	{
		List<Integer> crossDays = null;
		
		List<FlightOrderFlightInfoDto> flightOrderFlightInfoDtos = this.getFlightOrderFlightInfos();
		if(CollectionUtils.isNotEmpty(flightOrderFlightInfoDtos))
		{
			crossDays = new ArrayList<Integer>();
			for(FlightOrderFlightInfoDto flightOrderFlightInfoDto : flightOrderFlightInfoDtos)
			{
				Integer crossDay = null;
				TimeSegmentRange timeSegmentRange = flightOrderFlightInfoDto.getTimeSegmentRange();
				Date departureTime = timeSegmentRange.getDepartureTime();
				Date arrivalTime = timeSegmentRange.getArrivalTime();
				String departureTimeStr = DateUtils.formatDate(departureTime, DateUtils.YYYY_MM_DD);
				String arrivalTimeStr = DateUtils.formatDate(arrivalTime, DateUtils.YYYY_MM_DD);
				crossDay = (int) DateUtils.getDateDiffByDay(arrivalTimeStr, departureTimeStr);
				crossDays.add(crossDay);
			}	
		}
		return crossDays;
	}
	public FlightSupOrderDetailViewDto getFlightSupOrderDetailViewDto() {
		return flightSupOrderDetailViewDto;
	}

	public void setFlightSupOrderDetailViewDto(
			FlightSupOrderDetailViewDto flightSupOrderDetailViewDto) {
		this.flightSupOrderDetailViewDto = flightSupOrderDetailViewDto;
	}
}
