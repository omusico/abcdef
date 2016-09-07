package com.lvmama.lvfit.adapter.search.adapter.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.lvmama.lvfit.common.dto.adapter.request.VstBookingRequest;
import com.lvmama.lvfit.common.dto.enums.BookingBusinessType;
import com.lvmama.lvfit.common.dto.order.*;
import com.lvmama.vst.back.biz.po.BizEnum;
import com.lvmama.vst.comm.vo.order.BuyInfo;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.lvmama.lvf.common.dto.BaseSingleResultDto;
import com.lvmama.lvf.common.utils.CustomizedPropertyPlaceholderConfigurer;
import com.lvmama.lvf.common.utils.DateUtils;
import com.lvmama.lvf.common.utils.JSONMapper;
import com.lvmama.lvfit.adapter.search.adapter.ContractsSearchAdapter;
import com.lvmama.lvfit.common.dto.request.FitOrderBookingRequest;
import com.lvmama.vst.api.order.service.VstCommOrderQueryService;
import com.lvmama.vst.api.route.prod.vo.ApiFlightNoVo;
import com.lvmama.vst.api.vo.ResultHandleT;
import com.lvmama.vst.api.vo.order.OrderInfoBaseVo;
import com.lvmama.vst.api.vo.order.OrderInfoBaseVo.ItemInfo;

@Service
public class ContractsSearchAdapterImpl implements ContractsSearchAdapter{
	private static final Logger logger = LoggerFactory.getLogger(ContractsSearchAdapterImpl.class);

	@Autowired
	private VstCommOrderQueryService vstCommOrderQueryService;
	
	@Value("fit.goods.id")
    private String fitGoodsId;
	
	@Override
	public BaseSingleResultDto<String> getContractHtml(FitOrderBookingRequest bookingRequest) {
		logger.info("[adapter-search-contracts]调用主站合同模板code接口参数bookingRequest：" + bookingRequest);
		ResultHandleT<ArrayList<String>> resultHandle = null;
		BaseSingleResultDto<String> contractHtml = new BaseSingleResultDto<String>();
		
		OrderInfoBaseVo orderInfoBaseVo = new OrderInfoBaseVo();
		orderInfoBaseVo = buildOrderInfo(bookingRequest,orderInfoBaseVo);
		
		try {
			logger.error("[adapter-search-contracts]调用主站合同请求参数"+JSONMapper.getInstance().writeValueAsString(orderInfoBaseVo));
			resultHandle = vstCommOrderQueryService.getContracts(orderInfoBaseVo);
			logger.error("[adapter-search-contracts]调用主站合同获取code"+JSONMapper.getInstance().writeValueAsString(resultHandle));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
		if(null == resultHandle || CollectionUtils.isEmpty(resultHandle.getReturnContent())){
			return null;
		}
		ArrayList<String> returnContent = resultHandle.getReturnContent();
		if(CollectionUtils.isNotEmpty(returnContent)){
			String code = returnContent.get(0);
			contractHtml = this.getContractTemplateHtml(code);
		}
		return contractHtml;
	}

	/**
	 * 构造合同模板查询条件
	 * @param bookingRequest
	 * @param orderInfoBaseVo
	 * @return
	 */
	private OrderInfoBaseVo buildOrderInfo(FitOrderBookingRequest bookingRequest,OrderInfoBaseVo orderInfoBaseVo) {
		//产品信息
		List<OrderInfoBaseVo.Product> productList = new ArrayList<OrderInfoBaseVo.Product>();
		//商品信息
		List<OrderInfoBaseVo.ItemInfo> itemList = new ArrayList<OrderInfoBaseVo.ItemInfo>();
		
		//其他票和保险信息
		List<ItemInfo> itemLists = new ArrayList<OrderInfoBaseVo.ItemInfo>(); 
		
		//机票信息
        this.flightInfoToItem(bookingRequest, itemList);

        //门票信息
        this.insuranceInfoToItem(bookingRequest, itemLists);
        
        //酒店套餐信息
        this.hotelComboInfoToItem(bookingRequest,itemList);

		//酒店信息
		this.hotelInfoToItem(bookingRequest,itemList);
        
        //当地游信息
        this.localTripInfoToItem(bookingRequest,itemList);
        
        //其他票信息
        this.otherTicketInfoToTtem(bookingRequest,itemLists);
        
        OrderInfoBaseVo.Product product = new OrderInfoBaseVo.Product();
        product.setItemList(itemList);
        product.setAdultQuantity(bookingRequest.getAdultQuantity());
        product.setChildQuantity(bookingRequest.getChildQuantity());
        product.setProductId(bookingRequest.getProductId());
        product.setVisitTime(bookingRequest.getVisitTime());
        
        productList.add(product);
        
        OrderInfoBaseVo orderInfo = new OrderInfoBaseVo();
        orderInfo.setProductList(productList);
        orderInfo.setCategoryId(bookingRequest.getCategoryId());
        orderInfo.setProductId(bookingRequest.getProductId());
        orderInfo.setLineRouteId(bookingRequest.getLineRouteId());
        orderInfo.setVisitTime(bookingRequest.getVisitTime());
        orderInfo.setItemList(itemLists);
		return orderInfo;
	}

	private void otherTicketInfoToTtem(FitOrderBookingRequest bookingRequest,List<ItemInfo> itemList) {
		List<FitOrderOtherTicketDto> otherTickets = bookingRequest.getFitOrderOtherTicketDtos();
		if(CollectionUtils.isNotEmpty(otherTickets)){
			for (FitOrderOtherTicketDto fitOrderOtherTicketDto : otherTickets) {
				ItemInfo ticketItem = new ItemInfo();
				ticketItem.setGoodsId(Long.valueOf(fitOrderOtherTicketDto.getGoodsId()));//必填项：门票Id
	            ticketItem.setQuantity(fitOrderOtherTicketDto.getSelectCount().intValue());//必填项：门票数
	            ticketItem.setVisitTime(DateUtils.formatDate(fitOrderOtherTicketDto.getSelectDate(), DateUtils.YYYY_MM_DD));
	            itemList.add(ticketItem);
			}
			
		}
	}

	private void localTripInfoToItem(FitOrderBookingRequest bookingRequest,List<ItemInfo> itemList) {
		FitOrderLocalTripProductDto localTrip = bookingRequest.getFitOrderLocalTripProductDto();
		if(null != localTrip){
			ItemInfo localTripItem = new ItemInfo();
			localTripItem.setGoodsId(localTrip.getGoodsId());
			localTripItem.setChildQuantity(bookingRequest.getChildQuantity());
			localTripItem.setAdultQuantity(bookingRequest.getAdultQuantity());
			localTripItem.setVisitTime(DateUtils.formatDate(localTrip.getVisitDate()));
			localTripItem.setDetailId(localTrip.getDetailId());
			localTripItem.setRouteRelationVo(OrderInfoBaseVo.ItemRelationVo.PACK);
			itemList.add(localTripItem);
		}
	}

	private void hotelComboInfoToItem(FitOrderBookingRequest bookingRequest,List<ItemInfo> itemList) {
		FitOrderHotelComboDto hotelComboDto = bookingRequest.getFitOrderHotelComboDto();
		if(null != hotelComboDto){
			ItemInfo hotelComboItem = new ItemInfo();
    	    hotelComboItem.setGoodsId(hotelComboDto.getGoodsId());
    	    hotelComboItem.setQuantity(hotelComboDto.getQuantity().intValue());
    	    hotelComboItem.setAdultQuantity(bookingRequest.getAdultQuantity());
    	    hotelComboItem.setChildQuantity(bookingRequest.getChildQuantity());
    	    hotelComboItem.setVisitTime(DateUtils.formatDate(hotelComboDto.getCheckIn()));
			hotelComboItem.setRouteRelationVo(OrderInfoBaseVo.ItemRelationVo.PACK);
			hotelComboItem.setDetailId(hotelComboDto.getDetailId());
            itemList.add(hotelComboItem);
		}
	}


	private void hotelInfoToItem(FitOrderBookingRequest bookingRequest, List<ItemInfo> itemList) {
		//酒店信息
		for (FitOrderHotelDto hotel : bookingRequest.getFitOrderHotelDtos()) {
			ItemInfo hotelItem = new ItemInfo();
			hotelItem.setGoodsId(Long.valueOf(hotel.getPlanId()));//必填项：planID
			hotelItem.setQuantity(hotel.getRoomCount());//必填项：房间间数
			hotelItem.setAdultQuantity(bookingRequest.getAdultQuantity());
			hotelItem.setChildQuantity(bookingRequest.getChildQuantity());
			hotelItem.setVisitTime(DateUtils.formatDate(hotel.getCheckin(), DateUtils.YYYY_MM_DD));
			hotelItem.setDetailId(Long.valueOf(hotel.getDetailId()));
			hotelItem.setMainItem("MAIN");
			hotelItem.setRouteRelationVo(OrderInfoBaseVo.ItemRelationVo.PACK);
			itemList.add(hotelItem);
		}
	}

	private void insuranceInfoToItem(FitOrderBookingRequest bookingRequest,List<ItemInfo> itemList) {
		List<FitOrderInsuranceDto> fitOrderInsuranceDtos = bookingRequest.getFitOrderInsuranceDtos();
		if(CollectionUtils.isNotEmpty(fitOrderInsuranceDtos)){
			for (FitOrderInsuranceDto insuranceDto : fitOrderInsuranceDtos) {
				ItemInfo insuranceItem = new ItemInfo();
				insuranceItem.setGoodsId(Long.valueOf(insuranceDto.getInsuranceSuppGoodsId()));//必填项：保险商品Id
				insuranceItem.setQuantity(insuranceDto.getInsuranceCount());//必填项：保险份数
				insuranceItem.setVisitTime(DateUtils.formatDate(insuranceDto.getVisitDate()));
	            itemList.add(insuranceItem);
			}
		}
	}

	private void flightInfoToItem(FitOrderBookingRequest bookingRequest,List<ItemInfo> itemList) {
		BigDecimal adultInsTotalPrice = BigDecimal.valueOf(0);
	    BigDecimal chdInsTotalPrice = BigDecimal.valueOf(0);
	    
	    //机票虚拟商品
        for (FitOrderFlightDto flight : bookingRequest.getFitOrderFlightDtos()) {
        	ItemInfo flightItem = new ItemInfo();
            flightItem.setGoodsId(getFitGoodsId());//必填项：固定机票虚拟商品ID：1628417
            //flightItem.setGoodsId(1628417l);//必填项：固定机票虚拟商品ID：1628417
            flightItem.setAdultQuantity(bookingRequest.getAdultQuantity());//成人数
            flightItem.setChildQuantity(bookingRequest.getChildQuantity());//儿童数
            
            if (bookingRequest.getAdultQuantity() > 0) {
                BigDecimal adultInsPrice = (null==flight.getAdultPrice()?new BigDecimal(0):flight.getAdultPrice()).add(adultInsTotalPrice);
                flightItem.setAdultAmt(adultInsPrice.multiply(new BigDecimal(100)).longValue());//必填项：机票成人单价
            }
            if (bookingRequest.getChildQuantity() > 0) {
                BigDecimal chdInsPrice = (null==flight.getChildPrice()?new BigDecimal(0):flight.getChildPrice()).add(chdInsTotalPrice);
                flightItem.setChildAmt(chdInsPrice.multiply(new BigDecimal(100)).longValue());//必填项：机票儿童单价
            }
            /*flightItem.setAdultAmt(fit.getAdultAmount().multiply(new BigDecimal(100)).longValue());//必填项：机票成人总金额
            flightItem.setChildAmt(fit.getChildAmount().multiply(new BigDecimal(100)).longValue());//必填项：机票儿童总金额*/
            flightItem.setVisitTime(flight.getDepartureDate());
            ApiFlightNoVo flightNoVo = new ApiFlightNoVo();
            flightNoVo.setPlaneCode(flight.createProductName());
			
			//起飞机场、到达机场，航站楼，航班号，起飞时间
            flightNoVo.setFromAirPort(flight.getDepartureAirportName());//起飞机场
            flightNoVo.setToAirPort(flight.getArrivalAirportName());//到达机场
            flightNoVo.setFromCityName(flight.getDepartureCityName());
            flightNoVo.setToCityName(flight.getArrivalCityName());
           /* flightNoVo.setStartTerminal(flight.getDepartureTermainalBuilding());//起飞航站楼
            flightNoVo.setArriveTerminal(flight.getArrivalTerminalBuilding());//到达航站楼*/ 
           flightNoVo.setFlightNo(flight.getFlightNo());//航班号
            flightNoVo.setGoTime(DateUtils.parseCnHmDate(flight.getDepartureTime()));//起飞时间
            List<ApiFlightNoVo> additionalApiFlightNoVoList = new ArrayList<ApiFlightNoVo>();
            additionalApiFlightNoVoList.add(flightNoVo);
            flightItem.setAdditionalApiFlightNoVoList(additionalApiFlightNoVoList);
            itemList.add(flightItem);
        }
	}
		
	private Long getFitGoodsId() {
        return Long.valueOf((String) CustomizedPropertyPlaceholderConfigurer.getContextProperty(fitGoodsId));
    }

	@Override
	public BaseSingleResultDto<String> getContractTemplateHtml(String templateCode) {
		BaseSingleResultDto<String> result = new BaseSingleResultDto<String>();
		try{
			logger.error("[adapter-search-contracts]调用主站合同版本code"+JSONMapper.getInstance().writeValueAsString(templateCode));
			ResultHandleT<String> contractTemplateHtml = vstCommOrderQueryService.getContractTemplateHtml(templateCode);
			logger.error("[adapter-search-contracts]contractTemplateHtml"+JSONMapper.getInstance().writeValueAsString(contractTemplateHtml));
			result.setResult(contractTemplateHtml.getReturnContent());
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
		
		return result;
	}
}
