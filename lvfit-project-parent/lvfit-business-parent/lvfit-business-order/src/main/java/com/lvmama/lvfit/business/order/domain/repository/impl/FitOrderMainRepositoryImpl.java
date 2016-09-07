package com.lvmama.lvfit.business.order.domain.repository.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lvmama.lvfit.business.order.domain.FitOrderMain;
import com.lvmama.lvfit.business.order.domain.repository.FitOrderBasicInfoRepository;
import com.lvmama.lvfit.business.order.domain.repository.FitOrderFlightInsuranceRepository;
import com.lvmama.lvfit.business.order.domain.repository.FitOrderFlightRepository;
import com.lvmama.lvfit.business.order.domain.repository.FitOrderHotelComboRepository;
import com.lvmama.lvfit.business.order.domain.repository.FitOrderHotelRepository;
import com.lvmama.lvfit.business.order.domain.repository.FitOrderInsuranceRepository;
import com.lvmama.lvfit.business.order.domain.repository.FitOrderLocalTripProductRepository;
import com.lvmama.lvfit.business.order.domain.repository.FitOrderMainRepository;
import com.lvmama.lvfit.business.order.domain.repository.FitOrderOtherTicketRepository;
import com.lvmama.lvfit.business.order.domain.repository.FitOrderPassengerRepository;
import com.lvmama.lvfit.business.order.domain.repository.FitOrderRepository;
import com.lvmama.lvfit.business.order.domain.repository.FitOrderRoomDiffRepository;
import com.lvmama.lvfit.business.order.domain.repository.FitOrderSpotTicketRepository;
import com.lvmama.lvfit.business.order.domain.repository.FitOrderStatusRepository;
import com.lvmama.lvfit.business.order.domain.repository.FitSuppMainOrderRepository;
import com.lvmama.lvfit.business.order.domain.repository.FitSuppOrderRepository;
import com.lvmama.lvfit.common.dto.enums.FlightTripType;
import com.lvmama.lvfit.common.dto.enums.Product;
import com.lvmama.lvfit.common.dto.order.FitOrderAmountDto;
import com.lvmama.lvfit.common.dto.order.FitOrderBasicInfoDto;
import com.lvmama.lvfit.common.dto.order.FitOrderDto;
import com.lvmama.lvfit.common.dto.order.FitOrderFliInsuranceDto;
import com.lvmama.lvfit.common.dto.order.FitOrderFlightDto;
import com.lvmama.lvfit.common.dto.order.FitOrderHotelComboDto;
import com.lvmama.lvfit.common.dto.order.FitOrderHotelDto;
import com.lvmama.lvfit.common.dto.order.FitOrderInsuranceDto;
import com.lvmama.lvfit.common.dto.order.FitOrderLocalTripProductDto;
import com.lvmama.lvfit.common.dto.order.FitOrderMainDto;
import com.lvmama.lvfit.common.dto.order.FitOrderOtherTicketDto;
import com.lvmama.lvfit.common.dto.order.FitOrderPassengerDto;
import com.lvmama.lvfit.common.dto.order.FitOrderRoomDiffDto;
import com.lvmama.lvfit.common.dto.order.FitOrderSpotTicketDto;
import com.lvmama.lvfit.common.dto.order.FitSuppMainOrderDto;
import com.lvmama.lvfit.persistence.mybatis.mapper.FitOldSuppMainOrderMapper;
import com.lvmama.lvfit.persistence.mybatis.mapper.FitOrderMainMapper;
import com.lvmama.lvfit.persistence.mybatis.mapper.FitOrderMapper;

/**
 * @author qihuisong
 */
@Repository
public class FitOrderMainRepositoryImpl implements FitOrderMainRepository {
	
    
	@Autowired
    private FitOrderMainMapper fitOrderMainMapper;
    
    @Autowired
    private FitOrderRepository fitOrderRepository;

    @Autowired
    private FitOrderFlightRepository fitOrderFlightRepository;

    @Autowired
    private FitOrderHotelRepository fitOrderHotelRepository;

    @Autowired
    private FitOrderStatusRepository fitOrderStatusRepository;

    @Autowired
    private FitOrderPassengerRepository fitOrderPassengerRepository;

    @Autowired
    private FitSuppMainOrderRepository fitSuppMainOrderRepository;
    
    @Autowired
    private FitSuppOrderRepository fitSuppOrderRepository;
    
    @Autowired
    private FitOrderSpotTicketRepository fitOrderSpotTicketRepository;
    
    @Autowired
    private FitOrderMapper fitOrderMapper;
    
    @Autowired
    private FitOldSuppMainOrderMapper fitOldSuppMainOrderMapper;
    
    @Autowired
    private FitOrderInsuranceRepository  fitOrderInsuranceRepository; 
    
    @Autowired
    private FitOrderFlightInsuranceRepository fitOrderFlightInsuranceRepository;
    
    @Autowired
    private FitOrderHotelComboRepository fitOrderHotelComboRepository;
    @Autowired
    private FitOrderLocalTripProductRepository fitOrderLocalTripProductRepository;
    @Autowired
    FitOrderOtherTicketRepository fitOrderOtherTicketRepository;
    
    @Autowired
    FitOrderBasicInfoRepository fitOrderBasicInfoRepository;
    
    @Autowired
    FitOrderRoomDiffRepository fitOrderRoomDiffRepository;
    
    @Override
    public FitOrderMainDto load(Long id) {
    	
    	//1.主单
        FitOrderMainDto orderMainDto = fitOrderMainMapper.getById(id);

        this.completeOrderMain(orderMainDto);
        
        return orderMainDto;
        
    }

	private void completeOrderMain(FitOrderMainDto orderMainDto) {
	    
	    if(orderMainDto!=null){
	        //2.订单
	        List<FitOrderDto> orderDtoList = fitOrderRepository.queryByFkId(orderMainDto.getId());
	        orderMainDto.setFitOrders(orderDtoList);

	        //3.订单关联关系
	        List<FitSuppMainOrderDto> suppMainOrderDtos = fitSuppMainOrderRepository.queryByFkId(orderMainDto.getId());
	        if(CollectionUtils.isNotEmpty(suppMainOrderDtos)){
	            orderMainDto.setFitSuppMainOrderDto(suppMainOrderDtos.get(0));
	        }
	        //订单基本信息
	        List<FitOrderBasicInfoDto> fitOrderBasicInfoDtos =  fitOrderBasicInfoRepository.getByOrderMainId(orderMainDto.getId());
	        if(CollectionUtils.isNotEmpty(fitOrderBasicInfoDtos)){
	        	orderMainDto.setFitOrderBasicInfoDto(fitOrderBasicInfoDtos.get(0));
	        }
	        
	        List<FitOrderRoomDiffDto> fitOrderRoomDiffDtos = fitOrderRoomDiffRepository.getByOrderMainId(orderMainDto.getId());
	        if(CollectionUtils.isNotEmpty(fitOrderRoomDiffDtos)){
	        	orderMainDto.setFitOrderRoomDiffDto(fitOrderRoomDiffDtos.get(0));
	        }
	        
	        //6.游客
	        List<FitOrderPassengerDto> passengerDtoList = fitOrderPassengerRepository.queryByFkId(orderMainDto.getId());
	        orderMainDto.setFitOrderPassengers(passengerDtoList);

	        //7.航班、酒店、订单详情、订单状态
	        for (FitOrderDto order : orderDtoList) {
	            //航班
	            if (Product.I_FLIGHT.equals(order.getProduct())) {
	                FitOrderFlightDto flightDto = fitOrderFlightRepository.load(order.getOrderProductId());
	                orderMainDto.getFitOrderFlightDtos().add(flightDto);
	            }
	            //酒店
	            if (Product.I_HOTEL.equals(order.getProduct())) {
	                FitOrderHotelDto hotelDto = fitOrderHotelRepository.load(order.getOrderProductId());
	                orderMainDto.getFitOrderHotelDtos().add(hotelDto);
	            }
	            //门票
	            if (Product.I_TICKET.equals(order.getProduct())) {
	                FitOrderSpotTicketDto spotDto = fitOrderSpotTicketRepository.load(order.getOrderProductId());
	                orderMainDto.getFitOrderSpotTicketDtos().add(spotDto);
	            }
	            
	            //保险
	            if (Product.INSURANCE.equals(order.getProduct())) {
	                FitOrderInsuranceDto insuranceDto = fitOrderInsuranceRepository.load(order.getOrderProductId());
	                orderMainDto.getFitOrderInsuranceDtos().add(insuranceDto);
	            }
	            
	            //酒店组合套餐
	            if(Product.I_HOTEL_COMBO.equals(order.getProduct())){
	            	FitOrderHotelComboDto orderHotelComboDto = fitOrderHotelComboRepository.load(order.getOrderProductId());
	            	orderMainDto.setFitOrderHotelComboDto(orderHotelComboDto);
	            }
		        //当地游信息
	            if(Product.I_LOCAL_TRIP.equals(order.getProduct())){
	            	FitOrderLocalTripProductDto localTripProductDto = fitOrderLocalTripProductRepository.load(order.getOrderProductId());
	            	orderMainDto.setFitOrderLocalTripProductDto(localTripProductDto);
	            }
		        //其他票
	            if(Product.I_OTHER_TICKET.equals(order.getProduct())){
	            	FitOrderOtherTicketDto orderOtherTicketDto = fitOrderOtherTicketRepository.load(order.getOrderProductId());
	            	orderMainDto.getFitOrderOtherTicketDtos().add(orderOtherTicketDto);
	            }
	        }
	        
	        //8.航空意外险
	        List<FitOrderFliInsuranceDto> flightInsuranceDtos = fitOrderFlightInsuranceRepository.getByOrderMainId(orderMainDto.getId());
	        for (FitOrderFliInsuranceDto orderFliInsDto : flightInsuranceDtos) {
	            Long passengerId = orderFliInsDto.getOrderPassengerId();
	            for (FitOrderPassengerDto passenger : orderMainDto.getFitOrderPassengers()) {
	                if (passenger.getId().equals(passengerId)) {
	                    orderFliInsDto.setIdCardType(passenger.getPassengerIDCardType());
	                    orderFliInsDto.setIdCardNo(passenger.getPassengerIDCardNo());
	                    orderFliInsDto.setInsuredName(passenger.getPassengerName());
	                    break;
	                }
	            }
	        }
	        orderMainDto.setFlightInsuranceDtos(flightInsuranceDtos);
	    }
	}
	
	/**
	 * 完善查询机票订单信息.
	 * @param orderMainDto
	 */
	private void completeFlightOrderMain(FitOrderMainDto orderMainDto) { 
	    
	    if(orderMainDto!=null){
	        //2.订单
	        List<FitOrderDto> orderDtoList = fitOrderRepository.queryByFkId(orderMainDto.getId());
	        orderMainDto.setFitOrders(orderDtoList);

	        //3.订单关联关系
	        List<FitSuppMainOrderDto> suppMainOrderDtos = fitSuppMainOrderRepository.queryByFkId(orderMainDto.getId());
	        if(CollectionUtils.isNotEmpty(suppMainOrderDtos)){
	            orderMainDto.setFitSuppMainOrderDto(suppMainOrderDtos.get(0));
	        }
	        //订单基本信息
	        List<FitOrderBasicInfoDto> fitOrderBasicInfoDtos =  fitOrderBasicInfoRepository.getByOrderMainId(orderMainDto.getId());
	        if(CollectionUtils.isNotEmpty(fitOrderBasicInfoDtos)){
	        	orderMainDto.setFitOrderBasicInfoDto(fitOrderBasicInfoDtos.get(0));
	        }
	        
	        List<FitOrderRoomDiffDto> fitOrderRoomDiffDtos = fitOrderRoomDiffRepository.getByOrderMainId(orderMainDto.getId());
	        if(CollectionUtils.isNotEmpty(fitOrderRoomDiffDtos)){
	        	orderMainDto.setFitOrderRoomDiffDto(fitOrderRoomDiffDtos.get(0));
	        }
	        
	        //6.游客
	        List<FitOrderPassengerDto> passengerDtoList = fitOrderPassengerRepository.queryByFkId(orderMainDto.getId());
	        orderMainDto.setFitOrderPassengers(passengerDtoList);

	        //7.航班、酒店、订单详情、订单状态
	        for (FitOrderDto order : orderDtoList) {
	            //航班
	            if (Product.I_FLIGHT.equals(order.getProduct())) {
	                FitOrderFlightDto flightDto = fitOrderFlightRepository.load(order.getOrderProductId());
	                orderMainDto.getFitOrderFlightDtos().add(flightDto);
	            } 
	        } 
	    }
	}

    @Override
    public FitOrderMain load(FitOrderMainDto fitOrderMainDto) {
        return null;
    }

    @Override
    public int delete(Long id) {
        return 0;
    }

    @Override
    public FitOrderMainDto save(FitOrderMainDto fitOrderMainDto) {
    	
        if (null == fitOrderMainDto.getId()) {
            fitOrderMainMapper.insert(fitOrderMainDto);
        }else {
            fitOrderMainMapper.updateById(fitOrderMainDto.getId(), fitOrderMainDto);
        }
        return fitOrderMainDto;
    }

	@Override
	public FitOrderMainDto getByVstOrderMainNo(Long vstOrderMainNo) {

		FitOrderMainDto orderMainDto = fitOrderMainMapper.getByVstOrderMainNo(vstOrderMainNo);
		this.completeOrderMain(orderMainDto);
		return orderMainDto;
	}

    @Override
    public FitOrderMainDto getOldByVstOrderMainNo(Long vstOrderMainNo) {
        FitOrderMainDto fitOrderMainDto = fitOrderMainMapper.getOldByVstOrderMainNo(vstOrderMainNo);
        if (fitOrderMainDto != null) {
            List<FitOrderDto> flightOrders = fitOrderMapper.getFlightByOrderMainId(fitOrderMainDto.getId());
            // TODO对子单进行筛选
            Map<String, FitOrderDto> ordersMap = new HashMap<String, FitOrderDto>();
            List<FitOrderDto> fitOrdersList = new ArrayList<FitOrderDto>();
            FitOrderAmountDto fitOrderAmountDto = new FitOrderAmountDto();
            for (FitOrderDto fitOrderDto : flightOrders) {
                fitOrderDto.setId(null);
                fitOrderDto.setOrderAmount(fitOrderAmountDto);
                if (fitOrderDto.getProduct().equals(Product.I_FLIGHT)) {
                    if (!ordersMap.containsKey(FlightTripType.DEPARTURE.name()) && fitOrderDto.getTripType().equals(FlightTripType.DEPARTURE)) {
                        ordersMap.put(FlightTripType.DEPARTURE.name(), fitOrderDto);
                        continue;
                    }
                    if (!ordersMap.containsKey(FlightTripType.RETURN.name()) && fitOrderDto.getTripType().equals(FlightTripType.RETURN)) {
                        ordersMap.put(FlightTripType.RETURN.name(), fitOrderDto);
                        continue;
                    }
                }
            }
            
            if (ordersMap.get(FlightTripType.DEPARTURE.name()) != null) {
                fitOrdersList.add(ordersMap.get(FlightTripType.DEPARTURE.name()));
            }
            if (ordersMap.get(FlightTripType.RETURN.name()) != null) {
                fitOrdersList.add(ordersMap.get(FlightTripType.RETURN.name()));
            }
            
            List<FitOrderDto> hotelOrders = fitOrderMapper.getHotelByOrderMainId(fitOrderMainDto.getId());
            for (FitOrderDto fitOrderDto : hotelOrders) {
                fitOrderDto.setId(null);
                fitOrderDto.setOrderAmount(fitOrderAmountDto);
                fitOrdersList.add(fitOrderDto);
            }
            fitOrderMainDto.setFitOrders(fitOrdersList);
        }
        return fitOrderMainDto;
    }
    
    @Override
    public List<FitSuppMainOrderDto> getAllOldOrderMainDto() {
        return fitOldSuppMainOrderMapper.getAllOldOrderMainData();
    }
    
    @Override
    public void updateSucOldOrderMainDto(Long vstOrderMainNo) {
        fitOldSuppMainOrderMapper.updateBindingStatus(vstOrderMainNo);
    }

	@Override
	public FitOrderMainDto getFlightOrderByVstOrderMainNo(Long vstOrderMainNo) {
		FitOrderMainDto orderMainDto = fitOrderMainMapper.getByVstOrderMainNo(vstOrderMainNo);
		this.completeFlightOrderMain(orderMainDto);
		return orderMainDto;	
	}
}
