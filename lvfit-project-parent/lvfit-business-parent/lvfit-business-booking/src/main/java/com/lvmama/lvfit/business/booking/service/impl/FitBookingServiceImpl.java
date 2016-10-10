
package com.lvmama.lvfit.business.booking.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lvmama.lvf.common.dto.BusinessType;
import com.lvmama.lvf.common.dto.OperType;
import com.lvmama.lvf.common.dto.status.ResultStatus;
import com.lvmama.lvf.common.event.Event;
import com.lvmama.lvf.common.event.EventPoint;
import com.lvmama.lvf.common.exception.ExceptionWrapper;
import com.lvmama.lvf.common.exception.FitExceptionCode;
import com.lvmama.lvf.common.utils.DateUtils;
import com.lvmama.lvf.common.utils.JSONMapper;
import com.lvmama.lvf.common.utils.StringUtil;
import com.lvmama.lvfit.business.booking.service.FitBookingService;
import com.lvmama.lvfit.business.order.domain.FitOrderMain;
import com.lvmama.lvfit.business.order.domain.repository.FitOrderBasicInfoRepository;
import com.lvmama.lvfit.business.order.domain.repository.FitOrderFlightInsuranceRepository;
import com.lvmama.lvfit.business.order.domain.repository.FitOrderFlightRepository;
import com.lvmama.lvfit.business.order.domain.repository.FitOrderHotelComboRepository;
import com.lvmama.lvfit.business.order.domain.repository.FitOrderHotelRepository;
import com.lvmama.lvfit.business.order.domain.repository.FitOrderInsuranceRepository;
import com.lvmama.lvfit.business.order.domain.repository.FitOrderLocalTripProductRepository;
import com.lvmama.lvfit.business.order.domain.repository.FitOrderMainRepository;
import com.lvmama.lvfit.business.order.domain.repository.FitOrderOpLogRepository;
import com.lvmama.lvfit.business.order.domain.repository.FitOrderOtherTicketRepository;
import com.lvmama.lvfit.business.order.domain.repository.FitOrderPassengerRepository;
import com.lvmama.lvfit.business.order.domain.repository.FitOrderRepository;
import com.lvmama.lvfit.business.order.domain.repository.FitOrderRoomDiffRepository;
import com.lvmama.lvfit.business.order.domain.repository.FitOrderSpotTicketRepository;
import com.lvmama.lvfit.business.order.domain.repository.FitOrderStatusRepository;
import com.lvmama.lvfit.common.dto.enums.IDCardType;
import com.lvmama.lvfit.common.dto.enums.OrderOpType;
import com.lvmama.lvfit.common.dto.enums.OrderType;
import com.lvmama.lvfit.common.dto.enums.PassengerType;
import com.lvmama.lvfit.common.dto.enums.Product;
import com.lvmama.lvfit.common.dto.order.FitOrderBasicInfoDto;
import com.lvmama.lvfit.common.dto.order.FitOrderDto;
import com.lvmama.lvfit.common.dto.order.FitOrderFliInsuranceDto;
import com.lvmama.lvfit.common.dto.order.FitOrderFlightDto;
import com.lvmama.lvfit.common.dto.order.FitOrderHotelComboDto;
import com.lvmama.lvfit.common.dto.order.FitOrderHotelDto;
import com.lvmama.lvfit.common.dto.order.FitOrderInsuranceDto;
import com.lvmama.lvfit.common.dto.order.FitOrderLocalTripProductDto;
import com.lvmama.lvfit.common.dto.order.FitOrderMainDto;
import com.lvmama.lvfit.common.dto.order.FitOrderNoDto;
import com.lvmama.lvfit.common.dto.order.FitOrderOpLogDto;
import com.lvmama.lvfit.common.dto.order.FitOrderOtherTicketDto;
import com.lvmama.lvfit.common.dto.order.FitOrderPassengerDto;
import com.lvmama.lvfit.common.dto.order.FitOrderRoomDiffDto;
import com.lvmama.lvfit.common.dto.order.FitOrderSpotTicketDto;
import com.lvmama.lvfit.common.dto.order.FitOrderStatusDto;
import com.lvmama.lvfit.common.dto.request.FitOrderBookingRequest;
import com.lvmama.lvfit.common.dto.shopping.FlightInsuranceDto;
import com.lvmama.lvfit.common.dto.status.order.OrderBookingStatus;
import com.lvmama.lvfit.common.form.booking.BookingInputForm;
import com.lvmama.lvfit.common.utils.FitGeneratorOrderNo;


/**
 * sdp 预订 serviceImpl
 * @author leizhengwei
 *
 */
@Service
public class FitBookingServiceImpl implements FitBookingService {

	private static final Logger logger = LoggerFactory.getLogger(FitBookingServiceImpl.class);

	@Autowired
	private FitOrderMainRepository fitOrderMainRepository;
	
	@Autowired
    private FitOrderBasicInfoRepository fitOrderBasicInfoRepository;

	@Autowired
	private FitOrderRepository fitOrderRepository;

	@Autowired
	private FitOrderPassengerRepository fitOrderPassengerRepository;

	@Autowired
	private FitOrderStatusRepository fitOrderStatusRepository;

	@Autowired
	private FitOrderHotelRepository fitOrderHotelRepository;

	@Autowired
	private FitOrderFlightRepository fitOrderFlightRepository;

	@Autowired
	private FitOrderOpLogRepository fitOrderOpLogRepository;

	@Autowired
	private FitGeneratorOrderNo generatorOrderNo;
	
	@Autowired
	private FitOrderSpotTicketRepository fitOrderSpotTicketRepository;
	
	@Autowired
	private FitOrderInsuranceRepository fitOrderInsuranceRepository;
	
	@Autowired
	private FitOrderFlightInsuranceRepository fitOrderFlightInsuranceRepository;
	
	@Autowired
	private FitOrderHotelComboRepository  fitOrderHotelComboRepository;
	
	@Autowired
	private FitOrderLocalTripProductRepository fitOrderLocalTripProductRepository;
	
	@Autowired
	private FitOrderOtherTicketRepository fitOrderOtherTicketRepository;
	
	@Autowired
	private FitOrderRoomDiffRepository fitOrderRoomDiffRepository;
	
	@EventPoint(Event.ORDER_BOOKING)
	@Override
	public FitOrderMainDto booking(FitOrderBookingRequest bookingRequest) {
		
		try {
			if(logger.isInfoEnabled()){
				logger.info("[Business-booking]预定接口请求报文：" + JSONMapper.getInstance().writeValueAsString(bookingRequest));
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		//构建订单
		FitOrderMainDto orderMainDto = null;
		try {
			orderMainDto = this.buildFitOrderMainDto(bookingRequest);
			//订单存储
			this.storeOrder(orderMainDto);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			throw new RuntimeException(e);
		}
		return orderMainDto;
	}

	/**
	 * 构建主单
	 * @param bookingRequest
	 * @return FitOrderMainDto
	 */
	private FitOrderMainDto buildFitOrderMainDto(FitOrderBookingRequest bookingRequest) {
		FitOrderMain orderMain = new FitOrderMain();
		FitOrderMainDto orderMainDto = orderMain.buildOrderMainDto(bookingRequest);
		orderMainDto.setFitOrders(this.buildFitOrderDtos(orderMain));
		orderMainDto.setFitOrderNo(new FitOrderNoDto(generatorOrderNo.generateFitOrderNo(orderMainDto.getBookingSource(), Product.F_FIT, OrderType.NORMAL)));
		return orderMainDto;
	}

	/**
	 * 构建订单
	 * @param orderMain
	 * @return List<FitOrderDto>
	 */
	private List<FitOrderDto> buildFitOrderDtos(FitOrderMain orderMain) {
		
		//订单集合
		List<FitOrderDto> orderDtoList = new ArrayList<FitOrderDto>();
		//机票快照入库
	    this.saveOrderFlight(orderMain);
		//机票订单拆分：航段*乘客类型
		this.splitFlightOrder(orderMain, orderDtoList);
		//酒店快照入库
		this.saveOrderHotel(orderMain);
		//酒店订单拆分：酒店数
		this.splitHotelOrder(orderMain, orderDtoList);
		//门票快照入库
		this.saveOrderSpotTicket(orderMain);
		//门票订单拆分：票的种类
		this.splitSpotTicketOrder(orderMain, orderDtoList);
		//保险快照入库
		this.saveOrderInsurance(orderMain);
		//保险订单拆分：保险的种类
		this.splitInsuranceOrder(orderMain, orderDtoList);
		
		/////////////////////////////////////SDP/////////////////////////////////////////////////
		
		if(null!=orderMain.self().getFitOrderHotelComboDto()){
			//酒店套餐入库
			this.saveOrderHotelCombo(orderMain);
			//酒店套餐订单拆分（仅一个套餐）
			this.splitHotelComboOrder(orderMain, orderDtoList);
		}
		
		if(null!=orderMain.self().getFitOrderLocalTripProductDto()){
			//当地游快照入库
			this.saveOrderLocalTripProduct(orderMain);
			//当地游订单拆分
			this.splitLocalTripProductOrder(orderMain, orderDtoList);
		}
		//其他票快照入库
		this.saveOrderOtherTicket(orderMain);
		//其他票订单拆分
		this.splitOtherTicketOrder(orderMain, orderDtoList);
		
		return orderDtoList;
		
	}

	private void splitInsuranceOrder(FitOrderMain orderMain,List<FitOrderDto> orderDtoList) {
		// TODO Auto-generated method stub
		//保险无特殊信息无需构造订单详情
		for (FitOrderInsuranceDto insuranceDto : orderMain.self().getFitOrderInsuranceDtos()) {
			FitOrderDto orderDto = new FitOrderDto();
			orderDto.setOrderProductId(insuranceDto.getId());
			orderDto.setProduct(Product.INSURANCE);
			orderDto.setFitOrderNo(new FitOrderNoDto(generatorOrderNo.generateFitOrderNo(orderMain.self().getBookingSource(), Product.I_FIT, OrderType.NORMAL)));
			int insuranceCount = insuranceDto.getInsuranceCount();
			orderDto.setDetailCount(insuranceCount);
			orderDto.setOrderKey(insuranceDto.getInsuranceSuppGoodsId());
			orderDtoList.add(orderDto);
		}
	}

	private void splitFlightOrder(FitOrderMain orderMain, List<FitOrderDto> orderDtoList) {
		//此处拆单规则同Vst，一个航段一个单
		for (FitOrderFlightDto flightDto : orderMain.self().getFitOrderFlightDtos()) {
				FitOrderDto orderDto = new FitOrderDto();
				orderDto.setOrderProductId(flightDto.getId());
				orderDto.setProduct(Product.I_FLIGHT);
				orderDto.setFitOrderNo(new FitOrderNoDto(generatorOrderNo.generateFitOrderNo(orderMain.self().getBookingSource(), Product.I_FIT, OrderType.NORMAL)));
				orderDto.setDetailCount(orderMain.self().getFitOrderPassengers().size());
				orderDto.setOrderKey(String.valueOf(DateUtils.parseDate(flightDto.getDepartureDate()).getTime()));
				orderDto.setTripType(flightDto.getTripType());
				orderDtoList.add(orderDto);
		 }
	}

	private void splitHotelOrder(FitOrderMain orderMain, List<FitOrderDto> orderDtoList) {
		
		//酒店无特殊信息无需构造订单详情
		for (FitOrderHotelDto hotelDto : orderMain.self().getFitOrderHotelDtos()) {
			FitOrderDto orderDto = new FitOrderDto();
			orderDto.setOrderProductId(hotelDto.getId());
			orderDto.setProduct(Product.I_HOTEL);
			orderDto.setFitOrderNo(new FitOrderNoDto(generatorOrderNo.generateFitOrderNo(orderMain.self().getBookingSource(), Product.I_FIT, OrderType.NORMAL)));
			int roomCount = hotelDto.getRoomCount();
			orderDto.setDetailCount(roomCount);
			orderDto.setOrderKey(hotelDto.getPlanId());
			orderDtoList.add(orderDto);
		}
	}

	
	
	
	private void splitSpotTicketOrder(FitOrderMain orderMain, List<FitOrderDto> orderDtoList) {
	
		//门票无特殊信息无需构造订单详情
		for (FitOrderSpotTicketDto spotTicketDto : orderMain.self().getFitOrderSpotTicketDtos()) {
			FitOrderDto orderDto = new FitOrderDto();
			orderDto.setOrderProductId(spotTicketDto.getId());
			orderDto.setProduct(Product.I_TICKET);
			orderDto.setFitOrderNo(new FitOrderNoDto(generatorOrderNo.generateFitOrderNo(orderMain.self().getBookingSource(), Product.I_FIT, OrderType.NORMAL)));
			int ticketCount = spotTicketDto.getTicketCount();
			orderDto.setDetailCount(ticketCount);
			orderDto.setOrderKey(spotTicketDto.getTicketId());
			orderDtoList.add(orderDto);
		}
	}
	
	private void splitOtherTicketOrder(FitOrderMain orderMain,List<FitOrderDto> orderDtoList) {
		for (FitOrderOtherTicketDto otherTicketDto : orderMain.self().getFitOrderOtherTicketDtos()) {
			FitOrderDto orderDto = new FitOrderDto();
			orderDto.setOrderProductId(otherTicketDto.getId());
			orderDto.setProduct(Product.I_OTHER_TICKET);
			orderDto.setFitOrderNo(new FitOrderNoDto(generatorOrderNo.generateFitOrderNo(orderMain.self().getBookingSource(), Product.I_FIT, OrderType.NORMAL)));
			orderDto.setDetailCount(otherTicketDto.getSelectCount().intValue());
			orderDto.setOrderKey(otherTicketDto.getGoodsId().toString());
			orderDtoList.add(orderDto);
		}
	}


	private void splitLocalTripProductOrder(FitOrderMain orderMain,List<FitOrderDto> orderDtoList) {
		FitOrderLocalTripProductDto  localTripProductDto = orderMain.self().getFitOrderLocalTripProductDto();
		FitOrderDto orderDto = new FitOrderDto();
		orderDto.setOrderProductId(localTripProductDto.getId());
		orderDto.setProduct(Product.I_LOCAL_TRIP);
		orderDto.setFitOrderNo(new FitOrderNoDto(generatorOrderNo.generateFitOrderNo(orderMain.self().getBookingSource(), Product.I_FIT, OrderType.NORMAL)));
		orderDto.setDetailCount(1);
		orderDto.setOrderKey(localTripProductDto.getGoodsId().toString());
		orderDtoList.add(orderDto);
	}

	private void splitHotelComboOrder(FitOrderMain orderMain,List<FitOrderDto> orderDtoList) {
		FitOrderHotelComboDto  hotelComboDto  =  orderMain.self().getFitOrderHotelComboDto();
		FitOrderDto orderDto = new FitOrderDto();
		orderDto.setOrderProductId(hotelComboDto.getId());
		orderDto.setProduct(Product.I_HOTEL_COMBO);
		orderDto.setFitOrderNo(new FitOrderNoDto(generatorOrderNo.generateFitOrderNo(orderMain.self().getBookingSource(), Product.I_FIT, OrderType.NORMAL)));
		orderDto.setDetailCount(hotelComboDto.getQuantity().intValue());
		orderDto.setOrderKey(hotelComboDto.getGoodsId().toString());
		orderDtoList.add(orderDto);
	}
	

	
	/**
	 * 存储订单
	 */
	public void storeOrder(FitOrderMainDto orderMainDto) {

		//主订单
		fitOrderMainRepository.save(orderMainDto);

		
        FitOrderBasicInfoDto orderBasicInfoDto = orderMainDto.getFitOrderBasicInfoDto();
        if(null!=orderBasicInfoDto){
        	 orderBasicInfoDto.setFitOrderMainId(orderMainDto.getId());
        	 fitOrderBasicInfoRepository.save(orderBasicInfoDto);
        }
		
		//订单乘机人
		List<FitOrderPassengerDto> passengerDtos = orderMainDto.getFitOrderPassengers();
		for (FitOrderPassengerDto passengerDto : passengerDtos) {
			passengerDto.setOrderMainId(orderMainDto.getId());
			fitOrderPassengerRepository.save(passengerDto);
		}

		//订单房差
		FitOrderRoomDiffDto fitOrderRoomDiffDto = orderMainDto.getFitOrderRoomDiffDto();
		if(null!=fitOrderRoomDiffDto&&null!=fitOrderRoomDiffDto.getSelectPrice()){
			fitOrderRoomDiffDto.setOrderMainId(orderMainDto.getId());
			fitOrderRoomDiffRepository.save(fitOrderRoomDiffDto);
		}
		
		List<FitOrderDto> fitOrders = orderMainDto.getFitOrders();
		for (FitOrderDto orderDto : fitOrders) {
			//订单
			orderDto.setOrderMainId(orderMainDto.getId());
			try {
				if(logger.isInfoEnabled()){
					logger.info("单个订单入库orderDto="+JSONMapper.getInstance().writeValueAsString(orderDto));
				}
			} catch (Exception e) {
				logger.error(e.getMessage());
			}
			fitOrderRepository.save(orderDto);

			//订单状态
			FitOrderStatusDto orderStatusDto = orderDto.getOrderStatus();
			orderStatusDto.setOrderId(orderDto.getId());
			orderStatusDto.setOrderBookingStatus(OrderBookingStatus.NOT_BOOKING);
			fitOrderStatusRepository.save(orderStatusDto);
		
		}
		//订单log
		try {
			FitOrderOpLogDto orderOpLog = new FitOrderOpLogDto();
			orderOpLog.setOrderMainId(orderMainDto.getId());
			orderOpLog.setBusinessType(BusinessType.ORDER_MAIN);
			orderOpLog.setOper(orderMainDto.getFitOrderContacter().getName());
			orderOpLog.setOperType(OperType.SYSTEM);
			orderOpLog.setRemark(OrderOpType.CREATE_ORDER.getCnName());
			fitOrderOpLogRepository.save(orderOpLog);
		} catch (Exception e) {
		    logger.error("更新状态、记录操作日志异常：", e);
		}

		// 机票航意险
		try {
    		for (FitOrderPassengerDto passengerDto : passengerDtos) {
    		    List<FlightInsuranceDto> flightInsuranceDtos = passengerDto.getFlightInsuranceDto();
    		    if(CollectionUtils.isNotEmpty(flightInsuranceDtos)){
    		    	for (FlightInsuranceDto fliInsuranceDto : flightInsuranceDtos) {
        		        FitOrderFliInsuranceDto orderFliInsuranceDto = new FitOrderFliInsuranceDto();
        		        orderFliInsuranceDto.setOrderMainId(orderMainDto.getId());
        		        orderFliInsuranceDto.setOrderPassengerId(passengerDto.getId());
        		        orderFliInsuranceDto.setInsuranceId(fliInsuranceDto.getInsuranceId().toString());
        		        orderFliInsuranceDto.setInsuranceSuppName(fliInsuranceDto.getSuppName());
        		        orderFliInsuranceDto.setInsuranceName(fliInsuranceDto.getInsuranceName());
        		        orderFliInsuranceDto.setInsurancePrice(fliInsuranceDto.getInsurancePrice());
        		        orderFliInsuranceDto.setInsuranceCount(fliInsuranceDto.getInsuranceCount());
        		        orderFliInsuranceDto.setFlightNo(fliInsuranceDto.getFlightNo());
        		        orderFliInsuranceDto.setInsuranceDesc(fliInsuranceDto.getInsuranceDesc());
        		        fitOrderFlightInsuranceRepository.save(orderFliInsuranceDto);
        		    }
    		    }
    		}
		} catch (Exception e) {
            logger.error("机票航意险保存异常:", e);
        }
	}
	
	

	private void saveOrderHotel(FitOrderMain orderMain) {
		for (FitOrderHotelDto hotelDto : orderMain.self().getFitOrderHotelDtos()) {
			fitOrderHotelRepository.save(hotelDto);
		}
	}
	
	//门票信息入库
	private void saveOrderSpotTicket(FitOrderMain orderMain){
		for (FitOrderSpotTicketDto spotDto : orderMain.self().getFitOrderSpotTicketDtos()) {
			fitOrderSpotTicketRepository.save(spotDto);
		}
	}
	
	private void saveOrderFlight(FitOrderMain orderMain) {
		for (FitOrderFlightDto flightDto : orderMain.self().getFitOrderFlightDtos()) {
				fitOrderFlightRepository.save(flightDto);
		}
	}
	
	private void saveOrderInsurance(FitOrderMain orderMain) {
		for (FitOrderInsuranceDto insuranceDto : orderMain.self().getFitOrderInsuranceDtos()) {
			fitOrderInsuranceRepository.save(insuranceDto);
		}
	}
	
	private void saveOrderHotelCombo(FitOrderMain orderMain) {
		fitOrderHotelComboRepository.save(orderMain.self().getFitOrderHotelComboDto());
	}
	
	private void saveOrderLocalTripProduct(FitOrderMain orderMain){
		fitOrderLocalTripProductRepository.save(orderMain.self().getFitOrderLocalTripProductDto());
	}
	
	private void saveOrderOtherTicket(FitOrderMain orderMain) {
		for (FitOrderOtherTicketDto otherTicketDto : orderMain.self().getFitOrderOtherTicketDtos()) {
			fitOrderOtherTicketRepository.save(otherTicketDto);
		}
	}

	@Override
	public ResultStatus validatePassengers(FitOrderBookingRequest fitOrderBookingRequest) {
		List<FitOrderPassengerDto>  passengers = fitOrderBookingRequest.getFitOrderPassengerDtos();
		if(passengers!=null){
			for(FitOrderPassengerDto passenger:passengers){
				boolean flag = true;
				/*if(passenger.getPassengerId()==null || "".equals(passenger.getPassengerId())){
					flag = false;
				}*/
				if(StringUtils.isBlank(passenger.getPassengerName())){
					flag  = false;
				}
				if(passenger.getPassengerType()==null || !(passenger.getPassengerType() instanceof PassengerType)){
					flag  = false;
				}
				if(passenger.getPassengerIDCardType()==null || !(passenger.getPassengerIDCardType() instanceof IDCardType)){
					flag  = false;
				}
				if(StringUtils.isBlank(passenger.getPassengerIDCardNo())){
					flag  = false;
				}
				/*if(passenger.getMobile()==null || "".equals(passenger.getMobile().trim())){
					flag  = false;
				}*/
				if(StringUtils.isBlank(passenger.getPassengerBirthday())){
					flag = false;
				}
				if(!flag){
					throw new ExceptionWrapper(FitExceptionCode.FIT_PASSENGER_NOT_FULL);
				}
			}
		}else{
			throw new ExceptionWrapper(FitExceptionCode.FIT_PASSENGER_NOT_FOUND);
		}
		
		return ResultStatus.SUCCESS;
	}
}
