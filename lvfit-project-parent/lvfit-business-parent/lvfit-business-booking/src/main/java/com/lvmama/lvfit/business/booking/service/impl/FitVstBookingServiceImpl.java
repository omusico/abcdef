package com.lvmama.lvfit.business.booking.service.impl;

import com.lvmama.lvfit.common.dto.enums.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lvmama.lvf.common.dto.BaseSingleResultDto;
import com.lvmama.lvf.common.dto.BusinessType;
import com.lvmama.lvf.common.dto.OperType;
import com.lvmama.lvf.common.event.Event;
import com.lvmama.lvf.common.event.EventPoint;
import com.lvmama.lvf.common.exception.ExceptionWrapper;
import com.lvmama.lvf.common.trace.TraceContext;
import com.lvmama.lvf.common.utils.JSONMapper;
import com.lvmama.lvfit.business.booking.service.FitVstBookingService;
import com.lvmama.lvfit.business.order.domain.repository.FitOrderOpLogRepository;
import com.lvmama.lvfit.business.order.domain.repository.FitOrderStatusRepository;
import com.lvmama.lvfit.common.client.FitVstClient;
import com.lvmama.lvfit.common.dto.adapter.request.VstBookingRequest;
import com.lvmama.lvfit.common.dto.order.FitOrderAmountDto;
import com.lvmama.lvfit.common.dto.order.FitOrderDto;
import com.lvmama.lvfit.common.dto.order.FitOrderMainDto;
import com.lvmama.lvfit.common.dto.order.FitOrderOpLogDto;
import com.lvmama.lvfit.common.dto.order.FitOrderStatusDto;
import com.lvmama.lvfit.common.dto.order.FitSuppMainOrderDto;
import com.lvmama.lvfit.common.dto.request.FitOrderBookingRequest;
import com.lvmama.lvfit.common.dto.status.order.OrderBookingStatus;
import com.lvmama.lvfit.common.dto.trace.FitOpLogTraceContext;

/**
 * VST预定
 * @author qihuisong
 */
@Service
public class FitVstBookingServiceImpl implements FitVstBookingService{

    private static final Logger logger = LoggerFactory.getLogger(FitVstBookingServiceImpl.class);

    @Autowired
    private FitVstClient fitVstClient;
    
    @Autowired
    private FitOrderStatusRepository fitOrderStatusRepository;
    
    @Autowired
    private FitOrderOpLogRepository fitOrderOpLogRepository;

    @EventPoint(Event.SUPPORDER_BOOKING)
    @Override
    public FitOrderMainDto vstBooking(FitOrderMainDto orderMainDto) {
    	
    	VstBookingRequest vst = null;
        try {
            vst =  this.buildVstBookingRequest(orderMainDto);
            if(logger.isInfoEnabled()){
            	logger.info("fit_vst酒店下单之前orderMainDto:"+JSONMapper.getInstance().writeValueAsString(orderMainDto));
            }
            FitSuppMainOrderDto suppMainOrderDto = fitVstClient.createOrder(vst);
            if(logger.isInfoEnabled()){
            	logger.info("fit_vst酒店下单结果suppMainOrderDto:"+JSONMapper.getInstance().writeValueAsString(suppMainOrderDto));
            }
            suppMainOrderDto.setFitMainOrderId(orderMainDto.getId());
            suppMainOrderDto.setFitMainOrderNo(orderMainDto.getFitOrderNo().getOrderNo());
            orderMainDto.setFitSuppMainOrderDto(suppMainOrderDto);
            this.saveVstStatus(orderMainDto, Boolean.TRUE, "");
            return orderMainDto;
        } catch (Exception e) {
            logger.error("VST下单异常，请查看Adapter错误日志：", e);
            FitBusinessExceptionType businessExceptionType = orderMainDto.getBookingSource().getBookingBusinessType()== BookingBusinessType.FIT?FitBusinessExceptionType.BOOKING_E:FitBusinessExceptionType.FIT_SDP_BOOKING_E;
            FitOpLogTraceContext.setFitOpLog(vst,e, TraceContext.getTraceId(), businessExceptionType);
            if(e instanceof ExceptionWrapper){
                ExceptionWrapper ew = (ExceptionWrapper)e;
                this.saveVstStatus(orderMainDto, Boolean.FALSE, ew.getErrMessage());
                throw ew;
            }else{
                this.saveVstStatus(orderMainDto, Boolean.FALSE, e.getMessage());
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public BaseSingleResultDto<FitOrderDto> auditCallBack(FitOrderBookingRequest fitOrderBookingRequest) {
        return null;
    }

    private VstBookingRequest buildVstBookingRequest(FitOrderMainDto fit) {
        VstBookingRequest vst = new VstBookingRequest();
        FitOrderAmountDto orderAmount = fit.getOrderAmount();
        vst.setAdultAmount(orderAmount.getAdultAmount());//机票成人总价（必须项）
        vst.setChildAmount(orderAmount.getChildAmount());//机票儿童总价（必须项）
        vst.setVisitTime(fit.getFitOrderBasicInfoDto().getVisitTime());
        vst.setAdultQuantity(fit.getFitOrderBasicInfoDto().getAdultQuantity());//成人总数（必须项）
        vst.setChildQuantity(fit.getFitOrderBasicInfoDto().getChildQuantity());//儿童总数（必须项）
        vst.setFitOrderPassengerDtoList(fit.getFitOrderPassengers());
        vst.setFitOrderContacterDto(fit.getFitOrderContacter());
        vst.setFitOrderCustomerDto(fit.getFitOrderCustomer());
        vst.setFitOrderHotelDtoList(fit.getFitOrderHotelDtos());
        vst.setFitOrderFlightDtoList(fit.getFitOrderFlightDtos());
        vst.setFitOrderSpotTicketDtos(fit.getFitOrderSpotTicketDtos());
        vst.setFitOrderInsuranceDtos(fit.getFitOrderInsuranceDtos());
        vst.setFitOrderDtos(fit.getFitOrders());
        vst.setProductName(fit.getProductName());
        vst.setBookingSource(fit.getBookingSource());
        vst.setProductId(fit.getProductId());
        vst.setCategoryId(fit.getCategoryId());
        vst.setLineRouteId(fit.getLineRouteId());
        vst.setFitOrderHotelComboDto(fit.getFitOrderHotelComboDto());
        vst.setFitOrderLocalTripProductDto(fit.getFitOrderLocalTripProductDto());
        vst.setFitOrderOtherTicketDtos(fit.getFitOrderOtherTicketDtos());
        vst.setFlightFeeAmount(fit.getFlightFeeAmount());
        vst.setFitOrderRoomDiffDto(fit.getFitOrderRoomDiffDto());
        vst.setDistributorCode(fit.getDistributorCode());
        vst.setDistributionChannel(fit.getDistributionChannel());
        return vst;
    }

    private void saveVstStatus(FitOrderMainDto orderMainDto, Boolean isBookingSuccess, String exceptionMessage) {
        for (FitOrderDto orderDto : orderMainDto.getFitOrders()) {
            if (Product.I_HOTEL.equals(orderDto.getProduct())) {
                //更新订单状态
                FitOrderStatusDto orderStatus = orderDto.getOrderStatus();
                orderStatus.setOrderBookingStatus(isBookingSuccess ? OrderBookingStatus.BOOKING_SUCC : OrderBookingStatus.BOOKING_FAIL);
                fitOrderStatusRepository.save(orderStatus);
                //记录操作日志
                try {
					FitOrderOpLogDto orderOpLog = new FitOrderOpLogDto();
					orderOpLog.setOrderMainId(orderMainDto.getId());
					orderOpLog.setOrderId(orderDto.getId());
					orderOpLog.setBusinessType(BusinessType.ORDER);
					orderOpLog.setOperType(OperType.SYSTEM);
					orderOpLog.setRemark(OrderOpType.BOOKING_HOTEL.getCnName() + "-" + orderStatus.getOrderBookingStatus().getCnName());
					orderOpLog.setDesc(exceptionMessage);
					fitOrderOpLogRepository.save(orderOpLog);
				} catch (Exception e) {
					 logger.error("更新操作日志异常：", e);
				}
            }
        }
    }
    
}
