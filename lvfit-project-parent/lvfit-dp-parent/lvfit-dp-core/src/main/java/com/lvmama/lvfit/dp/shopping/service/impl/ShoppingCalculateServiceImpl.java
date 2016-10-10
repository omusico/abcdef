/**
	 * Project Name:lvfit-dp-core
 * File Name:ShoppingCalculateServiceImpl.java
 * Package Name:com.lvmama.lvfit.dp.shopping.service.impl
 * Date:2015-12-11下午2:40:01
 * Copyright (c) 2015, www.lvmama.com All Rights Reserved.
 *
 */

package com.lvmama.lvfit.dp.shopping.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.lvmama.lvf.common.exception.FitExceptionCode;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lvmama.lvf.common.dto.BaseSingleResultDto;
import com.lvmama.lvf.common.exception.ExceptionCode;
import com.lvmama.lvf.common.exception.ExceptionWrapper;
import com.lvmama.lvf.common.task.Task;
import com.lvmama.lvf.common.task.TaskContext;
import com.lvmama.lvf.common.task.TaskMainGroup;
import com.lvmama.lvf.common.trace.TraceContext;
import com.lvmama.lvf.common.utils.JSONMapper;
import com.lvmama.lvfit.common.client.FitFlightClient;
import com.lvmama.lvfit.common.client.FitVstClient;
import com.lvmama.lvfit.common.dto.RequestWithException;
import com.lvmama.lvfit.common.dto.calculator.AmountCalculatorDto;
import com.lvmama.lvfit.common.dto.calculator.AmountCalculatorRequest;
import com.lvmama.lvfit.common.dto.calculator.request.CalculateAmountDetailRequest;
import com.lvmama.lvfit.common.dto.enums.BookingSource;
import com.lvmama.lvfit.common.dto.enums.FitBusinessExceptionType;
import com.lvmama.lvfit.common.dto.enums.FitBusinessType;
import com.lvmama.lvfit.common.dto.hotel.FitHotelTimePrice;
import com.lvmama.lvfit.common.dto.price.FitHotelPlanPriceDto;
import com.lvmama.lvfit.common.dto.request.CalculateAmountRequest;
import com.lvmama.lvfit.common.dto.request.FitHotelPriceRequest;
import com.lvmama.lvfit.common.dto.request.FitInsurancePriceRequest;
import com.lvmama.lvfit.common.dto.request.FitSpotTicketPriceRequest; 
import com.lvmama.lvfit.common.dto.shopping.FitFlightAmountDto;
import com.lvmama.lvfit.common.dto.shopping.FitFlightPriceDto;
import com.lvmama.lvfit.common.dto.shopping.FitHotelAmountDto;
import com.lvmama.lvfit.common.dto.shopping.FitInsuranceAmountDto;
import com.lvmama.lvfit.common.dto.shopping.FitShoppingAmountDto;
import com.lvmama.lvfit.common.dto.shopping.FitShoppingDto;
import com.lvmama.lvfit.common.dto.shopping.FitShoppingSelectedInsuranceDto;
import com.lvmama.lvfit.common.dto.shopping.FitShoppingSelectedTicketDto;
import com.lvmama.lvfit.common.dto.shopping.FitSpotTicketAmountDto;
import com.lvmama.lvfit.common.dto.shopping.FlightInsuranceDto;
import com.lvmama.lvfit.common.dto.trace.FitOpLogTraceContext;
import com.lvmama.lvfit.dp.shopping.service.ShopingCalculateService;
import com.lvmama.lvfit.dp.shopping.service.ShoppingService;

/**
 * ClassName:ShoppingCalculateServiceImpl <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Date: 2015-12-11 下午2:40:01 <br/>
 * 
 * @author liuweiguo
 * @version
 * @since JDK 1.6
 * @see
 */
@Service
public class ShoppingCalculateServiceImpl implements ShopingCalculateService {
	
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private ShoppingService shoppingService;

	@Autowired
	private FitFlightClient fitFlightClient;

	@Autowired
	private FitVstClient fitVstClient;
	
	@Override
	public BaseSingleResultDto<FitShoppingAmountDto> calculateAmount(CalculateAmountRequest amountRequest) {
		
		//初始化算价上下文
		String shoppingUUID = amountRequest.getShoppingUUID();
		FitShoppingDto fitShopppingDto = shoppingService.getFitShopping(shoppingUUID);
		if(fitShopppingDto==null){
			throw new ExceptionWrapper(ExceptionCode.GET_NO_CACHE_SHOPPING);
		}
		CalculateAmountDetailRequest amountDetailRequest = new CalculateAmountDetailRequest();
		amountDetailRequest.setBookingSource(amountRequest.getBookingSource());
		amountDetailRequest.setFitShoppingDto(fitShopppingDto);

		return this.calculateAmountByDetail(amountDetailRequest);
			
	}

	@Override
	public BaseSingleResultDto<FitShoppingAmountDto> calculateAmountByDetail(CalculateAmountDetailRequest amountDetailRequest) {
		 BaseSingleResultDto<FitShoppingAmountDto>  result = new  BaseSingleResultDto<FitShoppingAmountDto>();
		try{
			FitShoppingDto fitShopppingDto = amountDetailRequest.getFitShoppingDto();
			CalculateAmountRequest 	amountRequest = new CalculateAmountRequest();
			final Map<String, Object> requestMap = amountRequest.getRequestMap(fitShopppingDto,amountDetailRequest.getBookingSource());
			final TaskContext context  = new TaskContext();
			context.put("taskMap", requestMap);
			context.put("traceId", TraceContext.getTraceId());
			
			//2. 生成算价任务组
			TaskMainGroup<FitShoppingAmountDto> taskMainGroup =this.generatorCalculateTaskGroup(context);
		    
	        //3. 并发执行算价任务组
	        FitShoppingAmountDto  fitShoppingAmountDto =  taskMainGroup.getResult(requestMap.keySet().size());
	        
	        if(fitShoppingAmountDto==null || fitShoppingAmountDto.getFlightAmount() == null){
	        	throw new ExceptionWrapper(FitExceptionCode.GET_FLIGHT_PRICE_FAIL);
	        }
	        List<FlightInsuranceDto> selectFlightInsInfo = fitShopppingDto.getSelectFlightInsInfo();
	        if (CollectionUtils.isNotEmpty(selectFlightInsInfo)) {
	            for (FlightInsuranceDto fliIns : selectFlightInsInfo) {
	                BigDecimal insuranceCount = BigDecimal.valueOf(fliIns.getInsuranceCount());
	                BigDecimal insurancePrice = fliIns.getInsurancePrice();
	                BigDecimal fliInsurancePrice = insuranceCount.multiply(insurancePrice);
	                fitShoppingAmountDto.setFliInsuranceAmount(fliInsurancePrice);
	                fitShoppingAmountDto.setChoosableSalesAmount(fitShoppingAmountDto.getChoosableSalesAmount().add(fliInsurancePrice));
	                fitShoppingAmountDto.setChoosableTotalAmount(fitShoppingAmountDto.getChoosableTotalAmount().add(fliInsurancePrice));
	                fitShoppingAmountDto.setTotalSalesAmount(fitShoppingAmountDto.getTotalSalesAmount().add(fliInsurancePrice));
	                fitShoppingAmountDto.setTotalAmount(fitShoppingAmountDto.getTotalAmount().add(fliInsurancePrice));
	            }
	        }
	        result.setResult(fitShoppingAmountDto);
		        
		    //4. 处理异常信息
			this.handleException(context);
			return result;
		} catch (Exception e) {
			if(e instanceof ExceptionWrapper){
				ExceptionWrapper exceptionWrapper = (ExceptionWrapper)e;
				throw exceptionWrapper;
			}else{
				logger.error("购物车价格计算异常",e);
				throw new ExceptionWrapper(ExceptionCode.UNDEF_ERROR);
			}
		}
	}
	
	/**
	 * 处理算价异常信息
	 */
	private void handleException(final TaskContext context) {
		String traceId = (String)context.get("traceId");
		Set<String> exceptionKeys = context.keySet();
		List<Exception> exceptions = new ArrayList<Exception>();
		for (String key : exceptionKeys) {
			if(key.endsWith(FitBusinessExceptionType._E.name())){
				  RequestWithException requestWithException = (RequestWithException) context.get(FitBusinessExceptionType.valueOf(key).name());
				  Object  request = requestWithException.getRequest();
				  Exception curException =requestWithException.getE();
				  if (curException != null) {
				        FitOpLogTraceContext.setFitOpLog(request,curException, traceId, FitBusinessExceptionType.valueOf(key));
				          exceptions.add(curException); 
				  }
			}
		}
		if(CollectionUtils.isNotEmpty(exceptions)){
			for (Exception exception : exceptions) {
				if(exception instanceof ExceptionWrapper){
		    		ExceptionWrapper ew = (ExceptionWrapper)exception;
		    		throw ew;
		    	}else{
		    		new RuntimeException(exception);
		    	}
			}
       }
	}

    /**
     * 生成算价任务组
     * @param context
     * @return
     */
	private TaskMainGroup<FitShoppingAmountDto> generatorCalculateTaskGroup(final TaskContext context) {
		TaskMainGroup<FitShoppingAmountDto> taskMainGroup = new TaskMainGroup<FitShoppingAmountDto>();
		
		//生成算价任务
		@SuppressWarnings("unchecked")
		final Map<String, Object> taskMap = (Map<String, Object>) context.get("taskMap");
		for (Entry<String, Object>  entry : taskMap.entrySet()) {
			final String taskName = entry.getKey();
			final Object request= entry.getValue();
			taskMainGroup.addTask(new Task<Boolean>() 
		   {
				@Override
				public Boolean execute(TaskContext context) 
				{
					if(request instanceof AmountCalculatorRequest){
						//机票算价
						FitFlightAmountDto  flightAmountDto = null;
						AmountCalculatorRequest flightPriceRequest = (AmountCalculatorRequest)request;
						try {
							flightAmountDto = calculateFlightAmount(flightPriceRequest); 						
						} catch (Exception e) {
							RequestWithException requestWithException = new RequestWithException(e, request);
						    context.put(FitBusinessType.valueOf(taskName).getBusinessExceptionType().name(), requestWithException);
						}
						context.put(taskName,flightAmountDto);
					}else if(request instanceof FitHotelPriceRequest){
						//酒店算价
						FitHotelAmountDto  hotelAmountDto = null;
						FitHotelPriceRequest hotelPriceRequest = (FitHotelPriceRequest)request;
						try {
							hotelAmountDto = calculateHotelAmount(hotelPriceRequest); 
						} catch (Exception e) {
							RequestWithException requestWithException = new RequestWithException(e, request);
						    context.put(FitBusinessType.valueOf(taskName).getBusinessExceptionType().name(), requestWithException);
						}
						context.put(taskName,hotelAmountDto);
					}else if(request instanceof FitSpotTicketPriceRequest){
						//门票算价
						FitSpotTicketAmountDto  spotTicketAmountDto = null;
						FitSpotTicketPriceRequest spotTicketPriceRequest = (FitSpotTicketPriceRequest)request;
						try {
							spotTicketAmountDto = calculateSpotTicketAmount(spotTicketPriceRequest); 
						} catch (Exception e) {
							RequestWithException requestWithException = new RequestWithException(e, request);
						    context.put(FitBusinessType.valueOf(taskName).getBusinessExceptionType().name(), requestWithException);
						}
						context.put(taskName,spotTicketAmountDto);
					}else if(request instanceof FitInsurancePriceRequest){
						//保险算价
						FitInsuranceAmountDto insuranceAmountDto = null;
						FitInsurancePriceRequest insurancePriceRequest = (FitInsurancePriceRequest)request;
						try {
							insuranceAmountDto = calculateInsuranceAmount(insurancePriceRequest); 
						} catch (Exception e) {
							RequestWithException requestWithException = new RequestWithException(e, request);
						    context.put(FitBusinessType.valueOf(taskName).getBusinessExceptionType().name(), requestWithException);
						}
						context.put(taskName,insuranceAmountDto);
					}
					return true;
				}
			});
		}
		
		//汇总各产品价格
		taskMainGroup.putContext(context).putGetResult(new Task<FitShoppingAmountDto>() {
				
			@Override
			public FitShoppingAmountDto execute(TaskContext context) {
				
			    FitFlightAmountDto flightAmount = (FitFlightAmountDto) context.get(FitBusinessType.CALCULATE_FLI_PRICE.name());
			    FitHotelAmountDto hotelAmount = (FitHotelAmountDto) context.get(FitBusinessType.CALCULATE_HOTEL_PRICE.name());
			    FitSpotTicketAmountDto spotTicketAmount = (FitSpotTicketAmountDto) context.get(FitBusinessType.CALCULATE_SPOT_TICKET_PRICE.name());
				FitInsuranceAmountDto insuranceAmount = (FitInsuranceAmountDto) context.get(FitBusinessType.CALCULATE_INSURANCE_PRICE.name());
			    
			    FitShoppingAmountDto shoppingAmount = new FitShoppingAmountDto();

			    //------组合套餐产品价格--------
			    Double comboSalesAmount = 0D;
			    Double comboPromotionAmount = 0D;
			    //机票价格
				if (flightAmount != null) {
				    shoppingAmount.setFlightAmount(flightAmount.getTotalSalesAmount());
                    comboSalesAmount += flightAmount.getTotalSalesAmount().doubleValue();
                    comboPromotionAmount += flightAmount.getPromotionAmount().doubleValue();
				}

				//酒店价格
				if (hotelAmount != null) {
				    shoppingAmount.setHotelAmount(hotelAmount.getTotalSalesAmount());
				    comboSalesAmount += hotelAmount.getTotalSalesAmount().doubleValue();
		            comboPromotionAmount += hotelAmount.getPromotionAmount().doubleValue();
				}
				Double comboTotalAmount = comboSalesAmount + comboPromotionAmount;
				shoppingAmount.setComboSalesAmount(BigDecimal.valueOf(comboSalesAmount));
				shoppingAmount.setComboPromotionAmount(BigDecimal.valueOf(comboPromotionAmount));
				shoppingAmount.setComboTotalAmount(BigDecimal.valueOf(comboTotalAmount));
				
				//--------可选产品价格--------
				Double choosableSalesAmount = 0D;
				Double choosablePromotionAmount = 0D;
				//门票价格
				if(spotTicketAmount!= null){
				    shoppingAmount.setTicketAmount(spotTicketAmount.getTotalSalesAmount());
				    choosableSalesAmount += spotTicketAmount.getTotalSalesAmount().doubleValue();
				    choosablePromotionAmount += spotTicketAmount.getPromotionAmount().doubleValue();
				}
				//保险价格
				if(null != insuranceAmount){
					shoppingAmount.setInsuranceAmount(insuranceAmount.getTotalSalesAmount());
					choosableSalesAmount += insuranceAmount.getTotalSalesAmount().doubleValue();
				    choosablePromotionAmount += insuranceAmount.getPromotionAmount().doubleValue();
				}
				Double choosableTotalAmount = choosableSalesAmount + choosablePromotionAmount;
				shoppingAmount.setChoosableTotalAmount(BigDecimal.valueOf(choosableTotalAmount));
				shoppingAmount.setChoosableSalesAmount(BigDecimal.valueOf(choosableSalesAmount));
				shoppingAmount.setChoosablePromotionAmount(BigDecimal.valueOf(choosablePromotionAmount));
				
				//---------总价-----------
				shoppingAmount.setTotalSalesAmount(BigDecimal.valueOf(comboSalesAmount + choosableSalesAmount));
				shoppingAmount.setPromotionAmount(BigDecimal.valueOf(comboPromotionAmount + choosablePromotionAmount));
				shoppingAmount.setTotalAmount(BigDecimal.valueOf(comboTotalAmount + choosableTotalAmount));
				
				return shoppingAmount;
			}
		});
		
		return taskMainGroup;
	}
	
	/**
	 * 计算机票价格
	 * @param flightPriceRequest
	 * @return
	 */
	public FitFlightAmountDto calculateFlightAmount(AmountCalculatorRequest flightPriceRequest){
		
		FitFlightAmountDto flightAmountDto = null;

		AmountCalculatorDto amountCalculatorDto = fitFlightClient.amountCalculate(flightPriceRequest);
		BigDecimal flightPrice = BigDecimal.ZERO;
		BigDecimal flightPromotion = BigDecimal.ZERO;
		flightPrice = flightPrice.add(amountCalculatorDto.getOrderTotalSalesAmount());
		flightPromotion = flightPromotion.add(amountCalculatorDto.getOrderDiscountTotalAmount());
		flightAmountDto = new FitFlightAmountDto();
		flightAmountDto.setTotalAmount(flightPrice.add(flightPromotion).setScale(0, BigDecimal.ROUND_UP));
		flightAmountDto.setTotalSalesAmount(flightPrice.setScale(0, BigDecimal.ROUND_UP));
		flightAmountDto.setPromotionAmount(flightPromotion.setScale(0, BigDecimal.ROUND_UP));

	    return flightAmountDto;
	}
	
	/**
	 * 计算酒店价格
	 * @param hotelPriceRequest
	 * @return
	 */
	private FitHotelAmountDto calculateHotelAmount(FitHotelPriceRequest hotelPriceRequest){
		
		FitHotelTimePrice hotelTimePrice = fitVstClient.findTimePriceBySpecDate(hotelPriceRequest); 
		//酒店价格
		BigDecimal hotelPrice = BigDecimal.ZERO;
		//酒店优惠价
		BigDecimal hotelPromotion = BigDecimal.ZERO;
		BigDecimal roomCount = hotelPriceRequest.getRoomCount();
		if (hotelTimePrice.getSalesPrice() != null) {
			//酒店结算价
			BigDecimal settlePrice = hotelTimePrice.getSettlePrice().multiply(roomCount);
			//销售价
			hotelPrice = hotelPrice.add(settlePrice.multiply(FitHotelPlanPriceDto.SALE_RATE));
			//折扣价
			hotelPromotion = hotelPromotion.add(settlePrice.multiply(FitHotelPlanPriceDto.DISCOUNT_RATE));
			FitHotelAmountDto hotelAmount = new FitHotelAmountDto();
			//酒店总价
			hotelAmount.setTotalAmount(hotelPrice.add(hotelPromotion).setScale(0, BigDecimal.ROUND_UP));
			hotelAmount.setTotalSalesAmount(hotelPrice.setScale(0, BigDecimal.ROUND_UP));
			hotelAmount.setPromotionAmount(hotelPromotion.setScale(0, BigDecimal.ROUND_UP)); 
			return hotelAmount;
		} else {
			logger.error("没有查询到酒店的相关价格信息");
			throw new ExceptionWrapper(ExceptionCode.GET_HOTEL_PRICE_FAIL);
		}
		
	}
	
	/**
	 * 计算门票价格
	 * @param spotTicketPriceRequest
	 * @return
	 */
	private FitSpotTicketAmountDto calculateSpotTicketAmount(FitSpotTicketPriceRequest spotTicketPriceRequest){
		
		List<FitShoppingSelectedTicketDto> selectTicketInfos = spotTicketPriceRequest.getSelectTicketInfos();
		FitSpotTicketAmountDto spotTicketAmount = new FitSpotTicketAmountDto();
		BigDecimal spotTicketPromotion = BigDecimal.ZERO;//景点门票优惠，暂定为0
		BigDecimal totalAmount =  BigDecimal.ZERO;
        BigDecimal totalSalesAmount = BigDecimal.ZERO;
        BigDecimal promotionAmount = BigDecimal.ZERO;
		
		if(CollectionUtils.isNotEmpty(selectTicketInfos)){
			for (FitShoppingSelectedTicketDto selectedTicketDto : selectTicketInfos) {
				totalSalesAmount = totalSalesAmount.add(selectedTicketDto.getTicketPrice().multiply(new BigDecimal(selectedTicketDto.getTicketCount())));
				promotionAmount = promotionAmount.add(spotTicketPromotion.multiply(new BigDecimal(selectedTicketDto.getTicketCount())));
			}
			totalAmount = totalSalesAmount.add(promotionAmount);
			spotTicketAmount.setPromotionAmount(promotionAmount);
			spotTicketAmount.setTotalSalesAmount(totalSalesAmount);
			spotTicketAmount.setTotalAmount(totalAmount);
			return spotTicketAmount;
		}
		return null;
	}
	
	
	
	@Override
	public FitFlightPriceDto calculateSingelFlightPrice(AmountCalculatorRequest request) {
		AmountCalculatorDto calculatorDto = new AmountCalculatorDto();
		try {
			calculatorDto = fitFlightClient.amountCalculate(request);
			FitFlightPriceDto flightPrice=new FitFlightPriceDto();
			flightPrice.setSalesPrice(calculatorDto.getOrderTotalSalesAmount());
			flightPrice.setPromotionPrice(calculatorDto.getOrderDiscountTotalAmount());
			return flightPrice;
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			if(e instanceof ExceptionWrapper){
				ExceptionWrapper ew = (ExceptionWrapper)e;
				if(ew.getExceptionCode() == ExceptionCode.REMOTE_INVOKE){
					throw ew;
				}
				throw new ExceptionWrapper(ExceptionCode.GET_FLIGHT_PRICE_FAIL);
			}else{
				throw new RuntimeException(e);
			}
		}
	}

	/**
	 * 计算保险价格
	 * @param insurancePriceRequest
	 * @return
	 */
	private FitInsuranceAmountDto calculateInsuranceAmount(FitInsurancePriceRequest insurancePriceRequest){
		
		List<FitShoppingSelectedInsuranceDto> selectInsuranceInfos = insurancePriceRequest.getSelectInsuranceInfos();
		FitInsuranceAmountDto insuranceAmount = new FitInsuranceAmountDto();
		BigDecimal insurancePromotion = BigDecimal.ZERO;//保险优惠，暂定为0
		BigDecimal totalAmount =  BigDecimal.ZERO;
        BigDecimal totalSalesAmount = BigDecimal.ZERO;
        BigDecimal promotionAmount = BigDecimal.ZERO;
		
		if(CollectionUtils.isNotEmpty(selectInsuranceInfos)){
			for (FitShoppingSelectedInsuranceDto selectedInsuranceDto : selectInsuranceInfos) {
				totalSalesAmount = totalSalesAmount.add(selectedInsuranceDto.getInsurancePrice().multiply(new BigDecimal(selectedInsuranceDto.getInsuranceCount())));
				promotionAmount = promotionAmount.add(insurancePromotion.multiply(new BigDecimal(selectedInsuranceDto.getInsuranceCount())));
			}
			totalAmount = totalSalesAmount.add(promotionAmount);
			insuranceAmount.setPromotionAmount(promotionAmount);
			insuranceAmount.setTotalSalesAmount(totalSalesAmount);
			insuranceAmount.setTotalAmount(totalAmount);
			return insuranceAmount;
		}
		return null;
	}
}
