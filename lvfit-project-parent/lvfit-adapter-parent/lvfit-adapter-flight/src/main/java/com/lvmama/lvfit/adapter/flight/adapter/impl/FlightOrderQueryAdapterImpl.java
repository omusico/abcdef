package com.lvmama.lvfit.adapter.flight.adapter.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lvmama.lvf.common.client.BusinessClient;
import com.lvmama.lvf.common.dto.BaseResultDto;
import com.lvmama.lvf.common.dto.enums.FlightTripType;
import com.lvmama.lvf.common.dto.order.FlightOrderAmountDto;
import com.lvmama.lvf.common.dto.order.FlightOrderDetailDto;
import com.lvmama.lvf.common.dto.order.FlightOrderInsuranceDto;
import com.lvmama.lvf.common.dto.order.FlightOrderPassengerDto;
import com.lvmama.lvf.common.dto.order.FlightOrderSalesOrderRelationDto;
import com.lvmama.lvf.common.dto.order.FlightOrderTicketInfoDto;
import com.lvmama.lvf.common.dto.order.result.detail.FlightOrderDetailViewDto;
import com.lvmama.lvf.common.utils.JSONMapper;
import com.lvmama.lvfit.adapter.flight.adapter.FlightOrderQueryAdapter;
import com.lvmama.lvfit.common.dto.adapter.request.FlightOrderQueryRequest;
import com.lvmama.lvfit.common.dto.enums.BizEnum;
import com.lvmama.lvfit.common.dto.enums.PassengerType;
import com.lvmama.lvfit.common.dto.order.FitOrderAmountDto;
import com.lvmama.lvfit.common.dto.order.FitSuppFlightOrderDetailDto;
import com.lvmama.lvfit.common.dto.order.FitSuppFlightOrderDto;
import com.lvmama.lvfit.common.dto.order.FitSuppMainOrderDto;
import com.lvmama.lvfit.common.dto.order.FitSuppOrderDto;
import com.lvmama.lvfit.common.dto.order.FitSuppOrderTicketInfoDto;
import com.lvmama.lvfit.common.dto.status.order.OrderBookingStatus;

/**
 * 机票单品订单查询
 * @author qihuisong
 */
@Service
public class FlightOrderQueryAdapterImpl implements FlightOrderQueryAdapter{

    private static final Logger logger = LoggerFactory.getLogger(FlightOrderQueryAdapterImpl.class);

    @Autowired
    private BusinessClient businessClient;

    @Override
    public FitSuppMainOrderDto completeSuppFlightInfo(FlightOrderQueryRequest queryRequest) {

        FitSuppMainOrderDto suppMainOrderDto = queryRequest.getFitSuppMainOrderDto();
        List<FlightOrderInsuranceDto> flightInsDtos = new ArrayList<FlightOrderInsuranceDto>();
        try {
            logger.info("查询机票单品请求参数：" + JSONMapper.getInstance().writeValueAsString(queryRequest));
            Map<String,String> tickeNoMap = new HashMap<String, String>();
            List<FitSuppFlightOrderDetailDto> suppFlightOrderDetailDtos = new ArrayList<FitSuppFlightOrderDetailDto>();
            //获取乘客key对应的票号信息
            for (FitSuppOrderDto suppOrder : suppMainOrderDto.getFitSuppOrderDtos()) {
            	if (0 == BizEnum.BIZ_CATEGORY_TYPE.category_traffic_aero_other.getCategoryId().compareTo(suppOrder.getCategoryId())){
            		//1. 获取乘客key对应的票号信息
            		FlightOrderSalesOrderRelationDto salesOrderRelation = new FlightOrderSalesOrderRelationDto();
                    salesOrderRelation.setSalesMainOrderId(Long.valueOf(suppMainOrderDto.getVstMainOrderNo()));
                    salesOrderRelation.setSalesOrderId(Long.valueOf(suppOrder.getVstOrderNo()));  
                    BaseResultDto<FlightOrderDetailViewDto> lvfResultDto = businessClient.queryDetailViewListBySalesOrderRelation(salesOrderRelation);
                       
                    for (FlightOrderDetailViewDto viewDto : lvfResultDto.getResults()) {
                	    FitSuppFlightOrderDto suppFlightOrderDto = suppOrder.getByPassengerType(PassengerType.valueOf(
                	    viewDto.getFlightOrderDetailInfo().getFlightOrderDetails().get(0).getFlightOrderPassenger().getPassengerType().name()));
                	    suppFlightOrderDto.setFlightOrderNo(viewDto.getFlightOrderDetailInfo().getOrderNo());
                	    suppFlightOrderDto.setBookingStatus(OrderBookingStatus.valueOf(viewDto.getFlightOrderDetailInfo().getFlightOrderDetails().get(0).getDetailBookingStatus().name()));
                	    suppFlightOrderDto.setOrderAmount(this.getFitOrderAmount(viewDto.getFlightOrderDetailInfo().getFlightOrderAmount()));
                        for (FlightOrderDetailDto flightOrderDetail : viewDto.getFlightOrderDetailInfo().getFlightOrderDetails()) {
                            FlightOrderTicketInfoDto flightTicket = flightOrderDetail.getFlightOrderTicketInfo();
                            if(null != flightTicket && StringUtils.isNotBlank(flightTicket.getTicketNo())){
                        	    tickeNoMap.put(this.passengerKey(flightOrderDetail.getFlightOrderPassenger(),flightOrderDetail.getCombinationDetail().getFlightTripType()), flightTicket.getTicketNo());
                            }
                            // 取得保险保单号信息
                            FlightOrderPassengerDto passenger = flightOrderDetail.getFlightOrderPassenger();
                            flightInsDtos.addAll(passenger.getFlightOrderInsurances());
                        }
                    }
                    //2.  获取供应商订单航班信息详情信息
                    List<FitSuppFlightOrderDto> suppFlightOrderDtos = suppOrder.getSuppFlightOrderDtos();
                    for (FitSuppFlightOrderDto suppFlightOrderDto : suppFlightOrderDtos) {
                        if(CollectionUtils.isNotEmpty(suppFlightOrderDto.getSuppFlightOrderDetailDtos())){
                            for (FitSuppFlightOrderDetailDto suppFlightOrderDetailDto : suppFlightOrderDto.getSuppFlightOrderDetailDtos()) {
                                suppFlightOrderDetailDto.setTripType(suppFlightOrderDto.getTripType());
							}
                    		suppFlightOrderDetailDtos.addAll(suppFlightOrderDto.getSuppFlightOrderDetailDtos());
                    	}	
					}
                    
            	}
            }
            
            //补全供应商订单航班信息详情信息中的票号信息
            for (FitSuppFlightOrderDetailDto suppFlightOrderDetailDto : suppFlightOrderDetailDtos) {
            	FitSuppOrderTicketInfoDto suppOrderTicketInfoDto = new FitSuppOrderTicketInfoDto(); 
            	String passengerKey = suppFlightOrderDetailDto.getFitOrderPassenger().passengerKey(suppFlightOrderDetailDto.getTripType());
            	suppOrderTicketInfoDto.setTicketNo(tickeNoMap.get(passengerKey));
            	suppFlightOrderDetailDto.setFitSuppOrderTicketInfoDto(suppOrderTicketInfoDto);
			}
        } catch (Exception e) {
            logger.error("查询机票单品详情异常：", e);
        }
       
        suppMainOrderDto.setFlightInsDtos(flightInsDtos);
        return suppMainOrderDto;
    }
    
    /**
	 * 获取乘机人key
	 * @param flightOrderPassengerDto
	 * @return
	 */
	public String passengerKey(FlightOrderPassengerDto flightOrderPassengerDto,FlightTripType flightTripType){
		  StringBuffer passengerStr = new StringBuffer();
    	  passengerStr.append(flightOrderPassengerDto.getPassengerName());
    	  passengerStr.append(flightOrderPassengerDto.getPassengerType().name());
    	  passengerStr.append(flightOrderPassengerDto.getPassengerIDCardType().name());
    	  passengerStr.append(flightOrderPassengerDto.getPassengerIDCardNo());
    	  passengerStr.append(flightTripType.name());
          return passengerStr.toString();
	}
	
	/**
	 * 订单金额转换
	 * @param flightOrderAmount
	 * @return
	 */
	private FitOrderAmountDto getFitOrderAmount(
			FlightOrderAmountDto flightOrderAmount) {
    	FitOrderAmountDto fitOrderAmount = new FitOrderAmountDto();
    	fitOrderAmount.setPayedAmount(flightOrderAmount.getOrderPayedAmount());
    	fitOrderAmount.setPrepaidAmount(flightOrderAmount.getOrderPrepaidAmount());
    	fitOrderAmount.setProfitAmount(flightOrderAmount.getOrderProfitAmount());
    	fitOrderAmount.setTotalAmount(flightOrderAmount.getOrderTotalAmount());
    	fitOrderAmount.setTotalDiscountAmount(flightOrderAmount.getOrderDiscountTotalAmount());
    	fitOrderAmount.setTotalSalesAmount(flightOrderAmount.getOrderTotalSalesAmount());
		return fitOrderAmount;
	}
    
}
