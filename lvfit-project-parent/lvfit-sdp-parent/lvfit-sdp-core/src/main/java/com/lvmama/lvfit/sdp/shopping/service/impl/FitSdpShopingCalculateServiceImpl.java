package com.lvmama.lvfit.sdp.shopping.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.lvmama.lvfit.common.dto.sdp.goods.*;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.codehaus.jackson.type.TypeReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lvmama.lvf.common.dto.BaseSingleResultDto;
import com.lvmama.lvf.common.dto.enums.SuppSaleType;
import com.lvmama.lvf.common.exception.ExceptionCode;
import com.lvmama.lvf.common.exception.ExceptionWrapper;
import com.lvmama.lvf.common.task.Task;
import com.lvmama.lvf.common.task.TaskContext;
import com.lvmama.lvf.common.task.TaskMainGroup;
import com.lvmama.lvf.common.trace.TraceContext;
import com.lvmama.lvf.common.utils.JSONMapper;
import com.lvmama.lvfit.common.client.FitBusinessClient;
import com.lvmama.lvfit.common.client.FitFlightClient;
import com.lvmama.lvfit.common.dto.RequestWithException;
import com.lvmama.lvfit.common.dto.calculator.AmountCalculatorDto;
import com.lvmama.lvfit.common.dto.calculator.AmountCalculatorRequest;
import com.lvmama.lvfit.common.dto.calculator.CalculateRuleDto;
import com.lvmama.lvfit.common.dto.enums.FitBusinessExceptionType;
import com.lvmama.lvfit.common.dto.enums.FitBusinessType;
import com.lvmama.lvfit.common.dto.sdp.calculator.FitSdpShoppingAmountDto;
import com.lvmama.lvfit.common.dto.sdp.calculator.request.FitSdpCalculateAmountDetailRequest;
import com.lvmama.lvfit.common.dto.sdp.calculator.request.FitSdpCalculateAmountRequest;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpProductFeeRulesDto;
import com.lvmama.lvfit.common.dto.sdp.shopping.FitSdpSelectInsuranceDto;
import com.lvmama.lvfit.common.dto.sdp.shopping.FitSdpSelectOtherTicketDto;
import com.lvmama.lvfit.common.dto.sdp.shopping.FitSdpShoppingDto;
import com.lvmama.lvfit.common.dto.sdp.shopping.request.FitSdpShoppingRequest;
import com.lvmama.lvfit.common.dto.search.FitPassengerRequest;
import com.lvmama.lvfit.common.dto.search.flight.result.MockUtil;
import com.lvmama.lvfit.common.dto.shopping.FitFlightAmountDto;
import com.lvmama.lvfit.common.dto.trace.FitOpLogTraceContext;
import com.lvmama.lvfit.sdp.shopping.FitSdpShopingCalculateService;
import com.lvmama.lvfit.sdp.shopping.FitSdpShoppingService;

@Service
public class FitSdpShopingCalculateServiceImpl implements FitSdpShopingCalculateService {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private FitSdpShoppingService fitSdpShoppingService;
	
	@Autowired
	private FitFlightClient fitFlightClient;
	
	@Autowired
	private FitBusinessClient fitBusinessClient;
	
	 
	@Override
	public BaseSingleResultDto<FitSdpShoppingAmountDto> calculateAmount(FitSdpCalculateAmountRequest request) {
		
		try{
			FitSdpCalculateAmountDetailRequest calculateAmountDetailRequest = new FitSdpCalculateAmountDetailRequest();

			String shoppingUuid = request.getShoppingUUID();
			FitSdpShoppingDto fitSdpShoppingDto = fitSdpShoppingService.getFitSdpShoppingDto(shoppingUuid); 
			
			if(fitSdpShoppingDto==null||CollectionUtils.isEmpty(fitSdpShoppingDto.getSelectedFlightInfos())||fitSdpShoppingDto.getSelectedFlightInfos().size()!=2){
				throw new ExceptionWrapper(ExceptionCode.GET_NO_CACHE_SHOPPING);
			}

			FitSdpShoppingRequest fitSdpShoppingRequest = fitSdpShoppingDto.getFitSdpShoppingRequest();
			calculateAmountDetailRequest.setProductId(fitSdpShoppingRequest.getProductId());
			//人数和份数信息
			FitPassengerRequest fitPassengerRequest = fitSdpShoppingRequest.getFitPassengerRequest();
			int peopleCount = fitPassengerRequest.getAdultCount()+fitPassengerRequest.getChildCount();
			calculateAmountDetailRequest.setPeopleCount(peopleCount);
			calculateAmountDetailRequest.setQuantity(fitSdpShoppingRequest.getQuantity().intValue());
			
			//机票请求信息
			final Map<String, Object> requestMap = request.getRequestMap(fitSdpShoppingDto,request.getBookingSource());
			final TaskContext context  = new TaskContext();
			context.put("taskMap", requestMap);
			context.put("traceId", TraceContext.getTraceId());
			calculateAmountDetailRequest.setFlightRequestMap(requestMap);
			
			//选中的酒店信息
			List<FitSdpHotelRoomtypeDto> fitSdpHotelRoomtypeDtos = fitSdpShoppingDto.getSelectedRoomtypes();
			calculateAmountDetailRequest.setSelectedFitSdpHotelRooms(fitSdpHotelRoomtypeDtos);
			
            //选中的酒店套餐
			FitSdpHotelComboGoodsDto selectedHotelComboGoods = fitSdpShoppingDto.getSelectedHotelComboGoods();
			calculateAmountDetailRequest.setSelectedHotelComboGoods(selectedHotelComboGoods);

			// 选中的当地游和房差(只有打包的是当地游的时候才可能有房差)
			FitSdpLocalTripProductDto selectLocalTripPrduct = fitSdpShoppingDto.getSelectLocalTripPrduct();
			calculateAmountDetailRequest.setSelectLocalTripPrduct(selectLocalTripPrduct);

			if(null != selectLocalTripPrduct){
				FitSdpRoomDiff selectRoomDiff = fitSdpShoppingDto.getSelectRoomDiffs();
				calculateAmountDetailRequest.setSelectRoomDiff(selectRoomDiff);
			}
			

			//4.3 选中的其他票
			if(CollectionUtils.isNotEmpty(fitSdpShoppingDto.getSelectOtherTickets())){
				List<FitSdpSelectOtherTicketDto> selectOtherTickets = fitSdpShoppingDto.getSelectOtherTickets();
				calculateAmountDetailRequest.setSelectOtherTickets(selectOtherTickets);
			}
			
			//4.4 选中的保险
			if(CollectionUtils.isNotEmpty(fitSdpShoppingDto.getSelectInsurances())){
				List<FitSdpSelectInsuranceDto> selectInsurances = fitSdpShoppingDto.getSelectInsurances();
				calculateAmountDetailRequest.setSelectInsurances(selectInsurances);
			}
			logger.info("calculateAmountDetailRequest="+JSONMapper.getInstance().writeValueAsString(calculateAmountDetailRequest)); 
			 
			return this.calculateAmountByDetail(calculateAmountDetailRequest);
			
		}catch (Exception e) {
			logger.error(ExceptionUtils.getFullStackTrace(e));
			if(e instanceof ExceptionWrapper){
				ExceptionWrapper exceptionWrapper = (ExceptionWrapper)e;
				throw exceptionWrapper;
			}else{
				throw new RuntimeException(e);
			}
		}
	}


	public BaseSingleResultDto<FitSdpShoppingAmountDto> calculateAmountByDetail(FitSdpCalculateAmountDetailRequest request) { 
		BaseSingleResultDto<FitSdpShoppingAmountDto> result = new BaseSingleResultDto<FitSdpShoppingAmountDto>();
		try{
			final Map<String, Object> requestMap = request.getFlightRequestMap();
			if(!(requestMap.get(FitBusinessType.FIT_SDP_CALCULATE_FLI_PRICE.name())instanceof AmountCalculatorRequest)){
				AmountCalculatorRequest flightRequest =  JSONMapper.getInstance().readValue(
						JSONMapper.getInstance().writeValueAsString(requestMap.get(FitBusinessType.FIT_SDP_CALCULATE_FLI_PRICE.name())), new TypeReference<AmountCalculatorRequest>() {});
				requestMap.put(FitBusinessType.FIT_SDP_CALCULATE_FLI_PRICE.name(), flightRequest);
			}
			final TaskContext context  = new TaskContext();
			context.put("taskMap", requestMap);
			context.put("traceId", TraceContext.getTraceId());

			//2. 生成算价任务组
			TaskMainGroup<FitSdpShoppingAmountDto> taskMainGroup =this.generatorCalculateTaskGroup(context);

			//3. 并发执行算价任务组(此处现只有机票)
			FitSdpShoppingAmountDto  fitSdpShoppingAmountDto =  taskMainGroup.getResult(requestMap.keySet().size());

			//5. 处理异常信息
			this.handleException(context);

			//必选产品的价格
			BigDecimal comboSalesAmount = new BigDecimal(0);
			BigDecimal comboPromotionAmount = new BigDecimal(0);

			//4. 选中的其它的商品信息，结合机票的价格进行汇总
			BigDecimal totalAmount = new BigDecimal(0);
			FitFlightAmountDto flightAmount = (FitFlightAmountDto) context.get(FitBusinessType.FIT_SDP_CALCULATE_FLI_PRICE.name());
			fitSdpShoppingAmountDto.setFlightAmount(flightAmount.getTotalSalesAmount());
			//4.0获取交通加价规则
			BigDecimal feeRulesAmount = getProductFeeRulesByProductId(request.getProductId(),new BigDecimal(0));
			//4.0.1 加价规则针对每一个人往返程的价格,现在算价-----人数*份数*加价规则+机票价格
			//FitPassengerRequest fitPassengerRequest = fitSdpShoppingDto.getFitSdpShoppingRequest().getFitPassengerRequest();
			int peopleCount = request.getPeopleCount();
			feeRulesAmount = feeRulesAmount.multiply(new BigDecimal(peopleCount*request.getQuantity()));

			fitSdpShoppingAmountDto.setFlightAmount(feeRulesAmount.add(fitSdpShoppingAmountDto.getFlightAmount()));;
			comboSalesAmount = comboSalesAmount.add(fitSdpShoppingAmountDto.getFlightAmount());
			comboPromotionAmount = comboPromotionAmount.add(flightAmount.getPromotionAmount());
			
			//选中的酒店信息
			List<FitSdpHotelRoomtypeDto> fitSdpHotelRoomtypeDtos = request.getSelectedFitSdpHotelRooms();
			if(CollectionUtils.isNotEmpty(fitSdpHotelRoomtypeDtos)){
				BigDecimal hotelAmount = new BigDecimal(0);
				for(FitSdpHotelRoomtypeDto fitSdpHotelRoomtypeDto:fitSdpHotelRoomtypeDtos){
					List<FitSdpHotelTimePriceDto> timePrices = fitSdpHotelRoomtypeDto.getTimePrice();
					BigDecimal singleHotelAmount = BigDecimal.ZERO;
					for(FitSdpHotelTimePriceDto timePrice : timePrices){
						singleHotelAmount = singleHotelAmount.add(timePrice.getPrice());
					}
					Integer roomCount = fitSdpHotelRoomtypeDto.getRoomCount();
					hotelAmount = hotelAmount.add(singleHotelAmount.multiply(new BigDecimal(roomCount)));
				}
				fitSdpShoppingAmountDto.setHotelAmount(hotelAmount);
				comboSalesAmount = comboSalesAmount.add(hotelAmount);
			}
			//4.1 选中的酒店套餐
			FitSdpHotelComboGoodsDto selectedHotelComboGoods = request.getSelectedHotelComboGoods();
			if (selectedHotelComboGoods != null) {
				BigDecimal hotelPriceAmount = (null == selectedHotelComboGoods.getPrice()?new BigDecimal(0):selectedHotelComboGoods.getPrice());
				fitSdpShoppingAmountDto.setHotelComboAmount(hotelPriceAmount);
				comboSalesAmount = comboSalesAmount.add(hotelPriceAmount);
			}
			//酒店套餐现没有优惠金额
			//comboPromotionAmount = comboPromotionAmount.add((null == selectedHotelComboGoods.getPrice()?new BigDecimal(0):selectedHotelComboGoods.getPrice()));

			BigDecimal localTripAmount = new BigDecimal(0);
			BigDecimal roomDiffPriceAmount = new BigDecimal(0);
			//4.2   选中的当地游和房差(只有打包的是当地游的时候才可能有房差)
			FitSdpLocalTripProductDto selectLocalTripPrduct = request.getSelectLocalTripPrduct();
			if(null != selectLocalTripPrduct){
				//当地游的价格
				localTripAmount = selectLocalTripPrduct.getPrice();
				fitSdpShoppingAmountDto.setLocalTripAmount(localTripAmount);
				comboSalesAmount = comboSalesAmount.add(localTripAmount);
				//现当地游也没有设置优惠金额
				//comboPromotionAmount = comboPromotionAmount.add(localTripAmount);
				//房差
				FitSdpRoomDiff selectRoomDiff = request.getSelectRoomDiff();
				if(selectRoomDiff != null && selectRoomDiff.getRoomDiffPrice() != null){
					roomDiffPriceAmount = new BigDecimal(0);
					roomDiffPriceAmount = roomDiffPriceAmount.add(selectRoomDiff.getRoomDiffPrice().multiply(new BigDecimal(selectRoomDiff.getCount())));
					fitSdpShoppingAmountDto.setRoomDiffAmount(roomDiffPriceAmount);
					comboSalesAmount = comboSalesAmount.add(roomDiffPriceAmount);
				}
			}

			//必选产品总价汇总
			//BigDecimal comboTotalAmount = comboSalesAmount.add(comboPromotionAmount);
			fitSdpShoppingAmountDto.setComboSalesAmount(comboSalesAmount);
			fitSdpShoppingAmountDto.setComboPromotionAmount(comboPromotionAmount);
			fitSdpShoppingAmountDto.setComboTotalAmount(comboSalesAmount);

			//可选产品的销售价及优惠金额
			BigDecimal choosableSalesAmount = new BigDecimal(0);
			BigDecimal choosablePromotionAmount = new BigDecimal(0);

			//4.3 选中的其他票
			if(CollectionUtils.isNotEmpty(request.getSelectOtherTickets())){
				List<FitSdpSelectOtherTicketDto> selectOtherTickets = request.getSelectOtherTickets();
				BigDecimal otherPriceAmount = new BigDecimal(0);
				BigDecimal otherPromotionAmount = new BigDecimal(0);
				for (FitSdpSelectOtherTicketDto fitSdpOtherTicketDto : selectOtherTickets) {
					otherPriceAmount = otherPriceAmount.add(fitSdpOtherTicketDto.getSelectPrice().multiply(new BigDecimal(fitSdpOtherTicketDto.getSelectCount())));
					otherPromotionAmount = otherPromotionAmount .add(fitSdpOtherTicketDto.getSelectPrice().multiply(new BigDecimal(fitSdpOtherTicketDto.getSelectCount())));
				}
				fitSdpShoppingAmountDto.setOtherTicketAmount(otherPriceAmount);
				choosableSalesAmount = choosableSalesAmount.add(otherPriceAmount);
			}

			//4.4 选中的保险
			if(CollectionUtils.isNotEmpty(request.getSelectInsurances())){
				List<FitSdpSelectInsuranceDto> selectInsurances = request.getSelectInsurances();
				BigDecimal insuranceAmount = new BigDecimal(0);
				BigDecimal insurancePromotionAmount = new BigDecimal(0);
				for (FitSdpSelectInsuranceDto fitSdpInsuranceDto : selectInsurances) {
					insuranceAmount = insuranceAmount.add(fitSdpInsuranceDto.getPrice().multiply(new BigDecimal(fitSdpInsuranceDto.getSelectCount())));
					insurancePromotionAmount = insurancePromotionAmount.add(fitSdpInsuranceDto.getPrice().multiply(new BigDecimal(fitSdpInsuranceDto.getSelectCount())));
				}
				fitSdpShoppingAmountDto.setInsuranceAmount(insuranceAmount);
				choosableSalesAmount = choosableSalesAmount.add(insuranceAmount);
			}
			
			//4.6汇总价格
			fitSdpShoppingAmountDto.setChoosablePromotionAmount(choosablePromotionAmount);
			fitSdpShoppingAmountDto.setChoosableSalesAmount(choosableSalesAmount);
			fitSdpShoppingAmountDto.setChoosableTotalAmount(choosablePromotionAmount.add(choosableSalesAmount));
			totalAmount = fitSdpShoppingAmountDto.getComboTotalAmount().add(fitSdpShoppingAmountDto.getChoosableTotalAmount());
			fitSdpShoppingAmountDto.setTotalAmount(totalAmount);
			result.setResult(fitSdpShoppingAmountDto);

			return result;

		}catch (Exception e) {
			logger.error(ExceptionUtils.getFullStackTrace(e));
			if(e instanceof ExceptionWrapper){
				ExceptionWrapper exceptionWrapper = (ExceptionWrapper)e;
				throw exceptionWrapper;
			}else{
				throw new RuntimeException(e);
			}
		}
	}


	/**
	 * 获取加价规则
	 * @param productId
	 * @param flightAmount 
	 * @return
	 */
	private BigDecimal getProductFeeRulesByProductId(String productId, BigDecimal flightAmount) {
		List<FitSdpProductFeeRulesDto> productFeeRules = fitBusinessClient.getProductFeeRulesByProductId(Long.valueOf(productId));
		if(CollectionUtils.isNotEmpty(productFeeRules)){
			FitSdpProductFeeRulesDto productFeeRulesDto = productFeeRules.get(0);
			CalculateRuleDto calculateRuleDto = new CalculateRuleDto();
			calculateRuleDto.setSalesPrice(flightAmount);
			calculateRuleDto.setOperateValue(productFeeRulesDto.getOprationValue());
			return  productFeeRulesDto.getFeeRuleType().calculate(calculateRuleDto);
		}
		return flightAmount;
	}

	@Override
	public FitFlightAmountDto calculateFlightAmount(AmountCalculatorRequest request) {
		FitFlightAmountDto flightAmountDto = null;
		try {
			MockUtil.writeJsonToFile("d:\\log_test\\计算单价"+System.currentTimeMillis()+".txt", request);
			AmountCalculatorDto amountCalculatorDto = fitFlightClient.amountCalculate(request);
			BigDecimal flightPrice = BigDecimal.ZERO;
			BigDecimal flightPromotion = BigDecimal.ZERO;
			flightPrice = flightPrice.add(amountCalculatorDto.getOrderTotalSalesAmount());
			flightPromotion = flightPromotion.add(amountCalculatorDto.getOrderDiscountTotalAmount());
			flightAmountDto = new FitFlightAmountDto();
			flightAmountDto.setTotalAmount(flightPrice.add(flightPromotion).setScale(0, BigDecimal.ROUND_UP));
			flightAmountDto.setTotalSalesAmount(flightPrice.setScale(0, BigDecimal.ROUND_UP));
			flightAmountDto.setPromotionAmount(flightPromotion.setScale(0, BigDecimal.ROUND_UP));
		} catch (Exception e) {
			if(e instanceof ExceptionWrapper){
				ExceptionWrapper ew = (ExceptionWrapper)e;
				if(ew.getExceptionCode()==ExceptionCode.REMOTE_INVOKE){
					throw ew;
				}
				throw new ExceptionWrapper(ExceptionCode.GET_FLIGHT_PRICE_FAIL);
			}
		} 
	    return flightAmountDto;
	}

	/**
     * 生成算价任务组
     * @param context
     * @return
     */
	private TaskMainGroup<FitSdpShoppingAmountDto> generatorCalculateTaskGroup(final TaskContext context) {
		TaskMainGroup<FitSdpShoppingAmountDto> taskMainGroup = new TaskMainGroup<FitSdpShoppingAmountDto>();
		
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
					}
					return true;
				}
			});
		}
		
		//汇总各产品价格
		taskMainGroup.putContext(context).putGetResult(new Task<FitSdpShoppingAmountDto>() {
				
			@Override
			public FitSdpShoppingAmountDto execute(TaskContext context) {
				
			    FitFlightAmountDto flightAmount = (FitFlightAmountDto) context.get(FitBusinessType.FIT_SDP_CALCULATE_FLI_PRICE.name());
			   
			    FitSdpShoppingAmountDto shoppingAmount = new FitSdpShoppingAmountDto();

			    //机票价格
				if (flightAmount != null) {
				    shoppingAmount.setFlightAmount(flightAmount.getTotalSalesAmount());
				}
				return shoppingAmount;
			}
		});
		
		return taskMainGroup;
	}
	
	/**
	 * 处理算价异常
	 * @param context
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


	
	
}
