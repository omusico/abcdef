package com.lvmama.lvfit.adapter.service.resource;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.type.TypeReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lvmama.lvf.common.client.BusinessClient;
import com.lvmama.lvf.common.dto.BaseResultDto;
import com.lvmama.lvf.common.dto.flight.FlightStopInfoDto;
import com.lvmama.lvf.common.dto.order.FlightOrderFlightInfoDto;
import com.lvmama.lvf.common.dto.order.FlightOrderSalesOrderRelationDto;
import com.lvmama.lvf.common.dto.order.FlightOrderTicketInfoDto;
import com.lvmama.lvf.common.dto.order.result.detail.FlightOrderDetailViewDto;
import com.lvmama.lvf.common.utils.DateUtils;
import com.lvmama.lvf.common.utils.JSONMapper;
import com.lvmama.lvf.openapi.vstclient.request.FitFliBookingCallBackRequest;
import com.lvmama.lvf.openapi.vstclient.service.fit.FitFlightBookingCallBackService;
import com.lvmama.lvfit.adapter.vst.adapter.OrderQueryServiceAdapter;
import com.lvmama.lvfit.adapter.vst.adapter.OrderServiceAdapter;
import com.lvmama.lvfit.common.client.path.VstClientPath;
import com.lvmama.lvfit.common.dto.adapter.request.VstBookingRequest;
import com.lvmama.lvfit.common.dto.enums.FlightTripType;
import com.lvmama.lvfit.common.dto.enums.ProductResource;
import com.lvmama.lvfit.common.dto.md.Airplane;
import com.lvmama.lvfit.common.dto.order.FitOrderDetail;
import com.lvmama.lvfit.common.dto.order.FitOrderFlightDto;
import com.lvmama.lvfit.common.dto.order.FitSuppMainOrderStatusDto;
import com.lvmama.lvfit.common.dto.order.FitSuppOrderDto;
import com.lvmama.lvfit.common.dto.order.FitSuppOrderTicketInfoDto;

@Component
@Path("")
public class VstOrderResource {

	@Autowired
	private OrderServiceAdapter orderServiceAdapter;

	@Autowired
	private OrderQueryServiceAdapter orderQueryServiceAdapter;
	
	@Autowired
	private FitFlightBookingCallBackService fitFlightBookingCallBackService;
	
	@Autowired
	private BusinessClient businessClient;
	
	private static final Logger logger = LoggerFactory.getLogger(VstOrderResource.class);

	/**
	 * VST下单
	 * @return
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path(VstClientPath.Path.VST_ORDER_CREATE)
	public Response createOrder(VstBookingRequest vstBookingRequest) {
		return Response.ok(orderServiceAdapter.createOrder(vstBookingRequest)).build();
	}
	
	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
		
		FitFliBookingCallBackRequest backRequest = new FitFliBookingCallBackRequest();
		backRequest.setVstOrderMainNo(20040139l);
		backRequest.setVstOrderNo(2000053430l);
		List<FitFliBookingCallBackRequest> callBackRequests = new ArrayList<FitFliBookingCallBackRequest>();
		callBackRequests.add(backRequest);
		System.out.println(JSONMapper.getInstance().writeValueAsString(callBackRequests));
		
	}
	
	
	/**
	 * VST下单
	 * @return
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("bussiness/flightCallBackBooking")
	public Response createOrder(String requestStr) {
		
		  List<FitFliBookingCallBackRequest> callBackRequests = null;
		  try {
				callBackRequests = JSONMapper.getInstance().readValue(requestStr, new TypeReference<List<FitFliBookingCallBackRequest>>() {});
		  } catch (Exception e1) {
			  logger.error(e1.getMessage());
		  }
		  return Response.ok(fitFlightBookingCallBackService.flightBookingCallBack(callBackRequests)).build();
	}
	
	
	/**
	 * VST下单
	 * @return
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path(VstClientPath.Path.GET_VST_ORDER_STATUS_BY_VST_ORDER_MAIN_NO)
	public Response getVstOrderStatusByVstOrderMainNo(@PathParam("vstOrderMainNo") Long vstOrderMainNo) {
		
		FitSuppMainOrderStatusDto suppMainOrderStatusDto  = orderQueryServiceAdapter.getVstOrderStatusByVstOrderMainNo(vstOrderMainNo);
		return Response.ok(suppMainOrderStatusDto).build();
	}

	/**
	 * VST订单详情
	 * @return
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path(VstClientPath.Path.GET_FIT_ORDER_MAIN_BY_ORDER_MAIN_NO)
	public Response queryVstOrderByVstOrderMainNo(@PathParam("vstOrderMainNo") Long vstOrderMainNo) throws Exception {
	    FitOrderDetail fitOrderDetail = orderQueryServiceAdapter.getOrderMainByVstOrderMainNo(vstOrderMainNo);
	    String s =JSONMapper.getInstance().writeValueAsString(fitOrderDetail);
	    logger.error("fitOrderDetail-" + vstOrderMainNo + "-----:" + s);
		return Response.ok(this.setFlightInfoOfOrderMainDto(fitOrderDetail)).build();
	}
	
	/**
	 * 根据机票订单得到乘客和机票信息
	 * @return
	 */
	private FitOrderDetail setFlightInfoOfOrderMainDto(FitOrderDetail fitOrderDetail) {
	    if (fitOrderDetail == null) {
	        return null;
	    }
	    FitOrderDetail result = fitOrderDetail;
	    List<FitOrderFlightDto> returnFlights = new ArrayList<FitOrderFlightDto>();
	    for (FitSuppOrderDto suppOrder : result.getSuppOrders()) {
            if (suppOrder.getCategoryId().equals(21L)) {
                FlightOrderSalesOrderRelationDto salesOrderRelation = new FlightOrderSalesOrderRelationDto();
                salesOrderRelation.setSalesMainOrderId(Long.valueOf(result.getVstOrderMainNo()));
                salesOrderRelation.setSalesOrderId(Long.valueOf(suppOrder.getVstOrderNo()));
                BaseResultDto<FlightOrderDetailViewDto> lvfResultDto = businessClient.queryDetailViewListBySalesOrderRelation(salesOrderRelation);
                
                if (CollectionUtils.isNotEmpty(lvfResultDto.getResults()) && !lvfResultDto.getResults().isEmpty()) {
                    // 设置子单机票信息
                    FitOrderFlightDto flightDto = this.getFlightInfos(lvfResultDto);
                    returnFlights.add(flightDto);
                    suppOrder.setTripType(flightDto.getTripType());
                    // 设置票号
                    result.setTicketNosMap(this.getTicketNos(result, lvfResultDto));
                }
            }
        }
        result.setFlights(returnFlights);
	    return result;
	}
	
	private FitOrderFlightDto getFlightInfos(BaseResultDto<FlightOrderDetailViewDto> lvfResultDto) {
        List<FlightOrderDetailViewDto> detailViewDtos = lvfResultDto.getResults();
        FlightOrderDetailViewDto detailViewDto = detailViewDtos.get(0);
        FlightOrderFlightInfoDto flightInfo = detailViewDto.getFlightOrderDetailInfo().getFlightOrderDetails().get(0).getCombinationDetail().getFlightOrderFlightInfo();
        FlightTripType flightTripeType = FlightTripType.valueOf(detailViewDto.getFlightOrderDetailInfo().getFlightOrderDetails().get(0).getCombinationDetail().getFlightTripType().name());
        FitOrderFlightDto fitOrderFlightDto = new FitOrderFlightDto();
        // 设置机票信息
        fitOrderFlightDto.setTripType(FlightTripType.valueOf(flightTripeType.name()));
        
        fitOrderFlightDto.setFlightNo(flightInfo.getFlightNo());
        fitOrderFlightDto.setDepartureAirportCode(flightInfo.getFlightAirportLine().getDepartureAirport().getCode());
        fitOrderFlightDto.setDepartureAirportName(flightInfo.getFlightAirportLine().getDepartureAirport().getName());
        fitOrderFlightDto.setDepartureCityName(flightInfo.getFlightAirportLine().getDepartureAirport().getCity().getName());
        fitOrderFlightDto.setDepartureTermainalBuilding(flightInfo.getFlightAirportLine().getDepartureTermainalBuilding().getCode());
        fitOrderFlightDto.setDepartureDate(DateUtils.parseDate(flightInfo.getTimeSegmentRange().getDepartureDate(), DateUtils.YYYY_MM_DD));
        fitOrderFlightDto.setDepartureTime(DateUtils.formatDate(flightInfo.getTimeSegmentRange().getDepartureTime(), DateUtils.YYYY_MM_DD_HH_MM_SS));
           
        fitOrderFlightDto.setArrivalAirportCode(flightInfo.getFlightAirportLine().getArrivalAirport().getCode());
        fitOrderFlightDto.setArrivalAirportName(flightInfo.getFlightAirportLine().getArrivalAirport().getName());
        fitOrderFlightDto.setArrivalCityName(flightInfo.getFlightAirportLine().getArrivalAirport().getCity().getName());
        fitOrderFlightDto.setArrivalTerminalBuilding(flightInfo.getFlightAirportLine().getArrivalTerminalBuilding().getCode());
        Date arrvTime = flightInfo.getTimeSegmentRange().getArrivalTime();
        fitOrderFlightDto.setArrivalDate(DateUtils.parseDate(arrvTime.getTime(), DateUtils.YYYY_MM_DD));
        fitOrderFlightDto.setArrivalTime(DateUtils.formatDate(flightInfo.getTimeSegmentRange().getArrivalTime(), DateUtils.YYYY_MM_DD_HH_MM_SS));
           
        fitOrderFlightDto.setSeatClassType(flightInfo.getFlightSeat().getSeatClassType().name());
        fitOrderFlightDto.setSeatClassTypeName(flightInfo.getFlightSeat().getSeatClassType().getCnName());
        fitOrderFlightDto.setSeatClassCode(flightInfo.getFlightSeat().getSeatClass().getCode());
        
        fitOrderFlightDto.setTripType(flightTripeType);
        
        Date depTime = flightInfo.getTimeSegmentRange().getDepartureTime();
        Date arvTime = flightInfo.getTimeSegmentRange().getArrivalTime();
        Long Difftime = arvTime.getTime() - depTime.getTime();
        Long DiffMin = Difftime / (60 * 1000);
        fitOrderFlightDto.setFlyTimeMins(DiffMin.toString());
           
        fitOrderFlightDto.setProductResource(ProductResource.FLIGHT);
           
        FlightStopInfoDto flightStopInfoDto = flightInfo.getFlightStopInfo();
        fitOrderFlightDto.setStopCount(flightStopInfoDto.getStopCount());
           
        fitOrderFlightDto.setCarrierName(flightInfo.getCarrier().getName());
           
        Airplane airplane = new Airplane();
        airplane.setAirplaneType(flightInfo.getAirplane().getAirplaneType());
        airplane.setCode(flightInfo.getAirplane().getCode());
        airplane.setName(flightInfo.getAirplane().getName());
        airplane.setMaxSeats(flightInfo.getAirplane().getMaxSeats());
        airplane.setMinSeats(flightInfo.getAirplane().getMinSeats());
           
        fitOrderFlightDto.setAirplane(airplane);
        return fitOrderFlightDto;
    }
	
	private Map<String, List<FitSuppOrderTicketInfoDto>> getTicketNos(FitOrderDetail detail, BaseResultDto<FlightOrderDetailViewDto> lvfResultDto) {
	    Map<String, List<FitSuppOrderTicketInfoDto>> ticketNosMap = detail.getTicketNosMap();
	    
	    List<FlightOrderDetailViewDto> detailViewDtos = lvfResultDto.getResults();
        for (FlightOrderDetailViewDto detailViewDto :  detailViewDtos) {
            FitSuppOrderTicketInfoDto ticketInfoDto = new FitSuppOrderTicketInfoDto();
            
            FlightTripType flightTripeType = FlightTripType.valueOf(detailViewDto.getFlightOrderDetailInfo().getFlightOrderDetails().get(0).getCombinationDetail().getFlightTripType().name());
            FlightOrderTicketInfoDto flightTicketInfoDto = detailViewDto.getFlightOrderDetailInfo().getFlightOrderDetails().get(0).getFlightOrderTicketInfo();
            if (flightTicketInfoDto != null) {
                ticketInfoDto.setName(flightTicketInfoDto.getFlightOrderPassenger().getPassengerName());
                ticketInfoDto.setTicketNo(flightTicketInfoDto.getTicketNo());
                
                List<FitSuppOrderTicketInfoDto> ticketInfoDtos = null;
                if (ticketNosMap.containsKey(flightTripeType.name())) {
                    ticketInfoDtos = ticketNosMap.get(flightTripeType.name());
                } else {
                    ticketInfoDtos = new ArrayList<FitSuppOrderTicketInfoDto>();
                }
                ticketInfoDtos.add(ticketInfoDto);
                
                ticketNosMap.put(flightTripeType.name(), ticketInfoDtos);
            }
        }
        return ticketNosMap;
	}

//    private void setFlightInfoOfOrderMainDto(Long vstOrderMainNo, FitOrderMainDto fitOrderMainDto,
//            List<FitOrderFlightDto> fitOrderFlightDtos) {
//        for (FitOrderDto fitOrderDto : fitOrderMainDto.getFitOrders()) {
//			FlightOrderSalesOrderRelationDto salesOrderRelation = new FlightOrderSalesOrderRelationDto();
//			FitOrderFlightDto fitOrderFlightDto = new FitOrderFlightDto();
//			salesOrderRelation.setSalesMainOrderId(vstOrderMainNo);
//			salesOrderRelation.setSalesOrderId(Long.valueOf(fitOrderDto.getFitOrderNo().toString()));
//			BaseResultDto<FlightOrderDetailViewDto> lvfResultDto = businessClient.queryDetailViewListBySalesOrderRelation(salesOrderRelation);
//			
//			if (lvfResultDto.getResults().get(0) != null) {
//				FlightOrderDetailInfoDto flightOrderDetailInfoDto = lvfResultDto.getResults().get(0).getFlightOrderDetailInfo();
//				FlightOrderFlightInfoDto flightOrderFlightInfoDto = flightOrderDetailInfoDto.getFlightOrderFlightInfos().get(0);
//				
//				fitOrderFlightDto.setFlightNo(flightOrderFlightInfoDto.getFlightNo());
//				fitOrderFlightDto.setDepartureAirportCode(flightOrderFlightInfoDto.getFlightAirportLine().getDepartureAirport().getCode());
//				fitOrderFlightDto.setDepartureAirportName(flightOrderFlightInfoDto.getFlightAirportLine().getDepartureAirport().getName());
//				fitOrderFlightDto.setDepartureCityName(flightOrderFlightInfoDto.getFlightAirportLine().getDepartureAirport().getCity().getName());
//				fitOrderFlightDto.setDepartureTermainalBuilding(flightOrderFlightInfoDto.getFlightAirportLine().getDepartureTermainalBuilding().getCode());
//				fitOrderFlightDto.setDepartureDate(DateUtils.parseDate(flightOrderFlightInfoDto.getTimeSegmentRange().getDepartureDate(), DateUtils.YYYY_MM_DD));
//				fitOrderFlightDto.setDepartureTime(flightOrderFlightInfoDto.getTimeSegmentRange().getDepartureTime().toString());
//				
//				
//				fitOrderFlightDto.setArrivalAirportCode(flightOrderFlightInfoDto.getFlightAirportLine().getArrivalAirport().getCode());
//				fitOrderFlightDto.setArrivalAirportName(flightOrderFlightInfoDto.getFlightAirportLine().getArrivalAirport().getName());
//				fitOrderFlightDto.setArrivalCityName(flightOrderFlightInfoDto.getFlightAirportLine().getArrivalAirport().getCity().getName());
//				fitOrderFlightDto.setArrivalTerminalBuilding(flightOrderFlightInfoDto.getFlightAirportLine().getArrivalTerminalBuilding().getCode());
//				String arrvTime = flightOrderFlightInfoDto.getTimeSegmentRange().getArrivalTime().toString();
//				Date arrvDate = DateUtils.parseDate(arrvTime, DateUtils.YYYY_M_D);
//				fitOrderFlightDto.setArrivalDate(arrvDate.toString());
//				fitOrderFlightDto.setArrivalTime(flightOrderFlightInfoDto.getTimeSegmentRange().getArrivalTime().toString());
//				
//				fitOrderFlightDto.setSeatClassType(flightOrderFlightInfoDto.getFlightSeat().getSeatClassType().name());
//				fitOrderFlightDto.setSeatClassTypeName(flightOrderFlightInfoDto.getFlightSeat().getSeatClassType().getCnName());
//				fitOrderFlightDto.setSeatClassCode(flightOrderFlightInfoDto.getFlightSeat().getSeatClass().getCode());
//				
//				FlightOrderFlightCombinationDetailDto combination = flightOrderDetailInfoDto.getCombinationDetails().get(0);
//				FlightOrderFlightPolicyDto flightOrderPolicy = combination.getFlightOrderFlightPolicy();
//				fitOrderFlightDto.setSuppPolicyNo(flightOrderPolicy.getSuppPolicyNo());
//				fitOrderFlightDto.setSuppCode(flightOrderPolicy.getSupp().getCode());
//				fitOrderFlightDto.setPricePolicyId(flightOrderPolicy.getFlightPricePolicy().getId());
//				
//				Date depTime = flightOrderFlightInfoDto.getTimeSegmentRange().getDepartureTime();
//				Date arvTime = flightOrderFlightInfoDto.getTimeSegmentRange().getArrivalTime();
//				Long Difftime = arvTime.getTime() - depTime.getTime();
//				Long DiffMin = Difftime / (60 * 1000);
//				fitOrderFlightDto.setFlyTimeMins(DiffMin.toString());
//				
//				String tripeType = combination.getFlightTripType().name();
//				fitOrderFlightDto.setTripType(FlightTripType.valueOf(tripeType));
//				
//				fitOrderFlightDto.setProductResource(ProductResource.FLIGHT);
//				
//				FlightStopInfoDto flightStopInfoDto = flightOrderFlightInfoDto.getFlightStopInfo();
//				fitOrderFlightDto.setStopCount(flightStopInfoDto.getStopCount());
//				
//				fitOrderFlightDto.setCarrierName(flightOrderFlightInfoDto.getCarrier().getName());
//				
//				Airplane airplane = new Airplane();
//				airplane.setAirplaneType(flightOrderFlightInfoDto.getAirplane().getAirplaneType());
//				airplane.setCode(flightOrderFlightInfoDto.getAirplane().getCode());
//				airplane.setName(flightOrderFlightInfoDto.getAirplane().getName());
//				airplane.setMaxSeats(flightOrderFlightInfoDto.getAirplane().getMaxSeats());
//				airplane.setMinSeats(flightOrderFlightInfoDto.getAirplane().getMinSeats());
//				
//				fitOrderFlightDto.setAirplane(airplane);
//				fitOrderFlightDtos.add(fitOrderFlightDto);
//			}
//			
//		}
//    }
}

