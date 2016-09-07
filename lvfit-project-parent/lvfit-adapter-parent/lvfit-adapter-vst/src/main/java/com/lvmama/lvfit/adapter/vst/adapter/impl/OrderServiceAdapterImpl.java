/**

 * Project Name:lvfit-adapter-vst
 * File Name:OrderServiceAdapterImpl.java
 * Package Name:com.lvmama.lvfit.adapter.vst.adapter.impl
 * Date:2015-11-12下午3:29:10
 * Copyright (c) 2015, www.lvmama.com All Rights Reserved.
 *
*/

package com.lvmama.lvfit.adapter.vst.adapter.impl;

import java.math.BigDecimal;
import java.util.*;
import java.util.Map.Entry;

import com.lvmama.lvfit.common.dto.enums.*;
import com.lvmama.lvfit.common.dto.search.flight.result.FlightSearchFlightInfoDto;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.lvmama.lvf.common.dto.enums.InterfaceKey;
import com.lvmama.lvf.common.exception.ExceptionCode;
import com.lvmama.lvf.common.exception.ExceptionWrapper;
import com.lvmama.lvf.common.utils.CustomizedPropertyPlaceholderConfigurer;
import com.lvmama.lvf.common.utils.DateUtils;
import com.lvmama.lvf.common.utils.JSONMapper;
import com.lvmama.lvf.common.utils.StringUtil;
import com.lvmama.lvfit.adapter.vst.adapter.OrderServiceAdapter;
import com.lvmama.lvfit.adapter.vst.adapter.VstInterfaceAdapterWrapper;
import com.lvmama.lvfit.common.aspect.suppinterface.SuppInterfacePoint;
import com.lvmama.lvfit.common.dto.adapter.request.VstBookingRequest;
import com.lvmama.lvfit.common.dto.order.FitOrderAmountDto;
import com.lvmama.lvfit.common.dto.order.FitOrderContacterDto;
import com.lvmama.lvfit.common.dto.order.FitOrderCustomerDto;
import com.lvmama.lvfit.common.dto.order.FitOrderDto;
import com.lvmama.lvfit.common.dto.order.FitOrderFlightDto;
import com.lvmama.lvfit.common.dto.order.FitOrderHotelComboDto;
import com.lvmama.lvfit.common.dto.order.FitOrderHotelDto;
import com.lvmama.lvfit.common.dto.order.FitOrderInsuranceDto;
import com.lvmama.lvfit.common.dto.order.FitOrderLocalTripProductDto;
import com.lvmama.lvfit.common.dto.order.FitOrderOtherTicketDto;
import com.lvmama.lvfit.common.dto.order.FitOrderPassengerDto;
import com.lvmama.lvfit.common.dto.order.FitOrderRoomDiffDto;
import com.lvmama.lvfit.common.dto.order.FitOrderSpotTicketDto;
import com.lvmama.lvfit.common.dto.order.FitSuppFlightOrderDetailDto;
import com.lvmama.lvfit.common.dto.order.FitSuppFlightOrderDto;
import com.lvmama.lvfit.common.dto.order.FitSuppMainOrderDto;
import com.lvmama.lvfit.common.dto.order.FitSuppMainOrderStatusDto;
import com.lvmama.lvfit.common.dto.order.FitSuppOrderDto;
import com.lvmama.lvfit.common.dto.order.FitSuppOrderStatusDto;
import com.lvmama.lvfit.common.dto.shopping.FlightInsuranceDto;
import com.lvmama.vst.back.biz.po.BizEnum;
import com.lvmama.vst.back.order.po.OrdOrder;
import com.lvmama.vst.back.order.po.OrdOrderItem;
import com.lvmama.vst.comm.vo.Constant;
import com.lvmama.vst.comm.vo.ResultHandleT;
import com.lvmama.vst.comm.vo.order.BuyInfo;
import com.lvmama.vst.comm.vo.order.BuyInfo.Item;
import com.lvmama.vst.comm.vo.order.BuyInfo.ItemRelation;
import com.lvmama.vst.comm.vo.order.Person;
import com.lvmama.vst.flight.client.goods.vo.FlightNoVo;

/**
 * ClassName:OrderServiceAdapterImpl <br/>
 * Function: vst订单适配器. <br/>
 * Date:     2015-11-12 下午3:29:10 <br/>
 *
 * @author liuweiguo
 * @see
 * @since JDK 1.6
 */
@Service
public class OrderServiceAdapterImpl implements OrderServiceAdapter {

    private static final Logger logger = LoggerFactory.getLogger(OrderServiceAdapterImpl.class);

    @Value("fit.product.id")
    private String fitProductId;

    @Value("fit.goods.id")
    private String fitGoodsId;

    private Long getFitProductId() {
        return Long.valueOf((String) CustomizedPropertyPlaceholderConfigurer.getContextProperty(fitProductId));
    }

    private Long getFitGoodsId() {
        return Long.valueOf((String) CustomizedPropertyPlaceholderConfigurer.getContextProperty(fitGoodsId));
    }

   @Autowired
   private VstInterfaceAdapterWrapper   vstInterfaceAdapterWrapper;

    @Override
    public FitSuppMainOrderDto createOrder(VstBookingRequest vstBookingRequest){
    	
        ResultHandleT<OrdOrder> resultHandleT;
		try {
			logger.info("[vstBookingRequest]"+ JSONMapper.getInstance().writeValueAsString(vstBookingRequest));
			BuyInfo buyInfo = this.generateBuyInfo(vstBookingRequest);
			
			resultHandleT = vstInterfaceAdapterWrapper.createOrder(buyInfo, buyInfo.getUserId());
			if (resultHandleT.isFail()) {
			    throw new ExceptionWrapper(ExceptionCode.BOOKING_FAIL_FOR_CUSTOMER);
			}
			Map<String,FitOrderDto> fitOrderMap =vstBookingRequest.getFitOrderMap();
			Map<String,List<FitOrderPassengerDto>> fitOrderPassengerMap = vstBookingRequest.getFitOrderPassengerMap();
			return this.generateSuppOrder(resultHandleT,fitOrderMap,fitOrderPassengerMap);
			
		} catch (Exception e) {
			logger.error("调用orderService.createOrder出现异常："+ExceptionUtils.getStackTrace(e));
			if(e instanceof ExceptionWrapper){
				ExceptionWrapper ew = (ExceptionWrapper)e;
				throw ew;
			}else{
				throw new RuntimeException(e);
			}
		}
    }

    private FitSuppMainOrderDto generateSuppOrder(ResultHandleT<OrdOrder> resultHandleT,Map<String,FitOrderDto> fitOrderMap,
    		Map<String,List<FitOrderPassengerDto>> fitOrderPassengerMap) {
    	
        FitSuppMainOrderDto suppMainOrderDto = new FitSuppMainOrderDto();
        OrdOrder ordOrder = resultHandleT.getReturnContent();
    	try {
			logger.info("[adapter-vst-booking]预定接口fitOrderMap：" + JSONMapper.getInstance().writeValueAsString(fitOrderMap));
		} catch (Exception e1) {
			logger.error(ExceptionUtils.getStackTrace(e1));
		}
        suppMainOrderDto.setBindingStatus(BindingStatus.BINDING);
        suppMainOrderDto.setVisitTime(ordOrder.getVisitTime());
        suppMainOrderDto.setVstMainOrderNo(ordOrder.getOrderId());
        suppMainOrderDto.setPaymentTarget(Paytarget.valueOf(ordOrder.getPaymentTarget()));
        FitOrderAmountDto mainOrderAmount = new FitOrderAmountDto();
        mainOrderAmount.setTotalAmount(new BigDecimal(ordOrder.getOughtAmountYuan()).setScale(2, BigDecimal.ROUND_UP));
        suppMainOrderDto.setOrderAmount(mainOrderAmount);
        
        //订单状态信息
        FitSuppMainOrderStatusDto fitSuppMainOrderStatus = this.setSuppMainOrderStatus(ordOrder);
        suppMainOrderDto.setFitSuppMainOrderStatus(fitSuppMainOrderStatus);
        
        for (OrdOrderItem item : ordOrder.getOrderItemList()) {
        	FitOrderDto fitOrderDto = new FitOrderDto();
        	FitSuppOrderDto suppOrderDto = new FitSuppOrderDto();
        	if (0 == BizEnum.BIZ_CATEGORY_TYPE.category_traffic_aero_other.getCategoryId().compareTo(item.getCategoryId())){
        		
        		//当订单未机票类型的子单时，需构造供应商订单航班信息
        		logger.error("创建供应商订单航班信息，供应商对应的机票子订单号【"+item.getOrderItemId()+"】");
        		fitOrderDto = fitOrderMap.get(String.valueOf(item.getVisitTime().getTime()));
        		List<FitSuppFlightOrderDto> suppFlightOrderDtos = new ArrayList<FitSuppFlightOrderDto>();
        		try {
					logger.error("创建供应商订单航班信息，供应商对应的机票子订单号【"+item.getOrderItemId()+"】,供应商对应的乘客Map【"+JSONMapper.getInstance().writeValueAsString(fitOrderPassengerMap)+"】");
				} catch (Exception e) {
					e.printStackTrace();
				} 
        		for (Entry<String, List<FitOrderPassengerDto>> entry : fitOrderPassengerMap.entrySet()) {
        			FitSuppFlightOrderDto suppFlightOrderDto = new FitSuppFlightOrderDto();
        			List<FitSuppFlightOrderDetailDto> suppFlightOrderDetailDtos = new ArrayList<FitSuppFlightOrderDetailDto>();
                	for (FitOrderPassengerDto fitOrderPassengerDto : entry.getValue()) {
                		FitSuppFlightOrderDetailDto suppDetailOrderDto = new FitSuppFlightOrderDetailDto();
                		suppDetailOrderDto.setFitOrderPassenger(fitOrderPassengerDto);
                		suppFlightOrderDetailDtos.add(suppDetailOrderDto);
    				}
                	suppFlightOrderDto.setTripType(fitOrderDto.getTripType());
                	suppFlightOrderDto.setPassengerType(PassengerType.valueOf(entry.getKey()));
                	suppFlightOrderDto.setSuppFlightOrderDetailDtos(suppFlightOrderDetailDtos);
                	suppFlightOrderDtos.add(suppFlightOrderDto);
				}
        		try {
					logger.error("创建供应商订单航班信息，供应商对应的机票子订单号【"+item.getOrderItemId()+"】,供应商对应的suppFlightOrderDtos【"+JSONMapper.getInstance().writeValueAsString(suppFlightOrderDtos)+"】");
				} catch (Exception e) {
					e.printStackTrace();
				} 
        		suppOrderDto.setSuppFlightOrderDtos(suppFlightOrderDtos);
        	 	suppOrderDto.setTripType(fitOrderDto.getTripType());
        	}else{
        		fitOrderDto = fitOrderMap.get(String.valueOf(item.getSuppGoodsId()));
        	}
        	suppOrderDto.setFitOrderId(fitOrderDto.getId());
        	suppOrderDto.setBindingStatus(BindingStatus.BINDING);
        	suppOrderDto.setVstOrderNo(item.getOrderItemId());
        	suppOrderDto.setCategoryId(item.getCategoryId());
        	if(StringUtil.isNotEmptyString(item.getTotalPriceYuan())){
        		FitOrderAmountDto orderAmount = new FitOrderAmountDto();
        		orderAmount.setTotalAmount(new BigDecimal(item.getTotalPriceYuan()).setScale(2, BigDecimal.ROUND_UP));
        		suppOrderDto.setOrderAmount(orderAmount);
        	}
    	   FitSuppOrderStatusDto fitSuppOrderStatus = this.setSuppOrderStatus(item);
    	   suppOrderDto.setFitSuppOrderStatusDto(fitSuppOrderStatus);
           suppMainOrderDto.getFitSuppOrderDtos().add(suppOrderDto);
        }
     	try {
			logger.info("[adapter-vst-booking]预定接口suppMainOrderDto：" + JSONMapper.getInstance().writeValueAsString(suppMainOrderDto));
		} catch (Exception e) {
			e.printStackTrace();
		} 
        return suppMainOrderDto;
    }
    
    private FitSuppOrderStatusDto setSuppOrderStatus(OrdOrderItem item) {
		
    	FitSuppOrderStatusDto suppOrderStatus = new FitSuppOrderStatusDto();
    	suppOrderStatus.setVstOrderNo(item.getOrderItemId());
		if(StringUtils.isNotEmpty(item.getOrderStatus())){
			suppOrderStatus.setOrderStatus(SuppVstOrderStatus.valueOf(item.getOrderStatus()));
		}
		if(StringUtils.isNotEmpty(item.getResourceStatus())){
			suppOrderStatus.setResAuditStatus(SuppVstResAuditStatus.valueOf(item.getResourceStatus()));
		}
		if(StringUtils.isNotEmpty(item.getInfoStatus())){
			suppOrderStatus.setInfoAuditStatus(SuppVstInfoAuditStatus.valueOf(item.getInfoStatus()));
		}
		if(StringUtils.isNotEmpty(item.getPaymentStatus())){
			suppOrderStatus.setPaymentStatus(SuppVstPaymentStatus.valueOf(item.getPaymentStatus()));
		}
		return suppOrderStatus;
	}

	/**
     * 设置状态信息
     * @param ordOrder
     * @return
     */
    public FitSuppMainOrderStatusDto setSuppMainOrderStatus(OrdOrder ordOrder){
    	
    	FitSuppMainOrderStatusDto suppMainOrderStatus = new FitSuppMainOrderStatusDto();
    	suppMainOrderStatus.setVstMainOrderNo(ordOrder.getOrderId());
    	if(StringUtils.isNotEmpty(ordOrder.getViewOrderStatus())){
    		suppMainOrderStatus.setOrderViewStatus(SuppVstOrderViewStatus.valueOf(ordOrder.getViewOrderStatus()));
		}
		if(StringUtils.isNotEmpty(ordOrder.getOrderStatus())){
			suppMainOrderStatus.setOrderStatus(SuppVstOrderStatus.valueOf(ordOrder.getOrderStatus()));
		}
		if(StringUtils.isNotEmpty(ordOrder.getResourceStatus())){
			suppMainOrderStatus.setAuditStatus(SuppVstAuditStatus.valueOf(ordOrder.getInfoStatus()));
		}
		if(StringUtils.isNotEmpty(ordOrder.getPaymentStatus())){
			suppMainOrderStatus.setPaymentStatus(SuppVstPaymentStatus.valueOf(ordOrder.getPaymentStatus()));
		}
		long wait = ordOrder.getWaitPaymentSec();
		if(wait>0){
			suppMainOrderStatus.setWaitPayTime(wait/60);
		}
		return suppMainOrderStatus;
		
    }


    private BuyInfo generateBuyInfo(VstBookingRequest fit) {
        BuyInfo buyInfo = new BuyInfo();
        buyInfo.setDistributionId(Constant.DIST_FRONT_END);//必填项：默认：驴妈妈前台

        if(fit.getBookingSource().getSourceType().name().equals(BookingSourceType.APP.name())
          ||fit.getBookingSource().getSourceType().name().equals(BookingSourceType.WAP.name())){
            buyInfo.setDistributionId(Constant.DIST_BRANCH_SELL);
            buyInfo.setDistributionChannel(fit.getDistributionChannel());
            buyInfo.setDistributorCode(fit.getDistributorCode());
            Collections.sort(fit.getFitOrderFlightDtoList(), new Comparator<FitOrderFlightDto>() {
                @Override
                public int compare(FitOrderFlightDto o1, FitOrderFlightDto o2) {
                    return DateUtils.parseDate(o1.getDepartureDate()).compareTo(DateUtils.parseDate(o2.getDepartureDate()));
                }
            });
            buyInfo.setStartDistrictId(VSTDistrictCityEnum.getDistrictId(fit.getFitOrderFlightDtoList().get(0).getDepartureCityCode()));
        }

        if(fit.getBookingSource().getBookingBusinessType().name().equals(BookingBusinessType.FIT.name())){
        	  buyInfo.setCategoryId(BizEnum.BIZ_CATEGORY_TYPE.category_route_aero_hotel.getCategoryId());//必填项：交通+X 品类的 ID
              buyInfo.setProductId(getFitProductId());//必填项：固定机+酒产品ID：414694
        }
        if(fit.getBookingSource().getBookingBusinessType().name().equals(BookingBusinessType.FIT_SDP.name())){
      	    buyInfo.setCategoryId(fit.getCategoryId());//必填项：交通+X 品类的 ID
            buyInfo.setProductId(fit.getProductId());//必填项：固定机+酒产品ID：414694
            buyInfo.setLineRouteId(fit.getLineRouteId());
        }
        buyInfo.setVisitTime(fit.getVisitTime());
        buyInfo.setAdultQuantity(fit.getAdultQuantity());//成人数
        buyInfo.setChildQuantity(fit.getChildQuantity());//儿童数

        this.peopleInfoToBuyInfo(fit, buyInfo);

        //商品信息
        List<BuyInfo.Item> itemList = new ArrayList<BuyInfo.Item>();
        
        //自由行下单时---保险和其他票---不和机票、酒店一个结构
        List<Item> itemAddtionList = new ArrayList<BuyInfo.Item>();

        //机票信息
        this.flightInfoToItem(fit, itemList);

        //酒店信息
        this.hotelInfoToItem(fit, itemList);

        //门票信息
        this.ticketInfoToItem(fit, itemList);
        
        //门票信息
        if(fit.getBookingSource().getBookingBusinessType().name().equals(BookingBusinessType.FIT_SDP.name())){
        	this.insuranceInfoToItem(fit, itemAddtionList);
        }else{
        	this.insuranceInfoToItem(fit, itemList);
        }
        
        //酒店套餐信息
        this.hotelComboInfoToItem(fit,itemList);
        
        //当地游信息
        this.localTripInfoToItem(fit,itemList);
        
        //其他票信息
        if(fit.getBookingSource().getBookingBusinessType().name().equals(BookingBusinessType.FIT_SDP.name())){
        	this.otherTicketInfoToTtem(fit, itemAddtionList);
        }else{
        	this.otherTicketInfoToTtem(fit,itemList);
        }
        
        
        
        //组装产品名称
        String productName = fit.getProductName();
        //交通+X产品信息
        List<BuyInfo.Product> productList = new ArrayList<BuyInfo.Product>();
        BuyInfo.Product product = new BuyInfo.Product();
        if(fit.getBookingSource().getBookingBusinessType().name().equals(BookingBusinessType.FIT.name())){
            product.setProductId(getFitProductId());//必填项：固定机+酒产品ID：414694
       }
        if(fit.getBookingSource().getBookingBusinessType().name().equals(BookingBusinessType.FIT_SDP.name())){
    	   product.setProductId(fit.getProductId());
       }
        product.setAdultQuantity(fit.getAdultQuantity());
        product.setChildQuantity(fit.getChildQuantity());
        product.setVisitTime(fit.getVisitTime());
        product.setProductName(productName);
        product.setItemList(itemList);
        productList.add(product);
        buyInfo.setProductList(productList);
        buyInfo.setItemList(itemAddtionList);
        
        //房差
        FitOrderRoomDiffDto fitOrderRoomDiffDto = fit.getFitOrderRoomDiffDto();
        if(null != fitOrderRoomDiffDto){
            buyInfo.setSpreadQuantity(fitOrderRoomDiffDto.getSelectCount().intValue());
        }
        return buyInfo;
    }

    /**
     * 构造其他票下单信息
     * @param fit
     * @param itemList
     */
    private void otherTicketInfoToTtem(VstBookingRequest fit,List<Item> itemList) {
    	for (FitOrderOtherTicketDto otherTicketDto : fit.getFitOrderOtherTicketDtos()) {
            BuyInfo.Item ticketItem = new BuyInfo.Item();
            ticketItem.setGoodsId(otherTicketDto.getGoodsId());//必填项：门票Id
            ticketItem.setQuantity(otherTicketDto.getSelectCount().intValue());//必填项：门票数
            ticketItem.setVisitTime(DateUtils.formatDate(otherTicketDto.getSelectDate(), DateUtils.YYYY_MM_DD));
            ticketItem.setProductCategoryId(fit.getCategoryId());
            ticketItem.setTotalAmount(otherTicketDto.getSelectPrice().multiply(new BigDecimal(otherTicketDto.getSelectCount())).multiply(new BigDecimal(100)).longValue());
            ticketItem.setTotalSettlementPrice(otherTicketDto.getSelectPrice().multiply(new BigDecimal(otherTicketDto.getSelectCount())).multiply(new BigDecimal(100)).longValue());
            itemList.add(ticketItem);
        }		
	}

    /**
     * 构造当地游下单信息
     * @param fit
     * @param itemList
     */
	private void localTripInfoToItem(VstBookingRequest fit, List<Item> itemList) {
      
    	FitOrderLocalTripProductDto localTripProductDto =  fit.getFitOrderLocalTripProductDto();
    	if(null!=localTripProductDto){
    	    BuyInfo.Item localTripItem = new BuyInfo.Item();
    	    localTripItem.setGoodsId(localTripProductDto.getGoodsId());
    	    localTripItem.setVisitTime(DateUtils.formatDate(localTripProductDto.getVisitDate()));
    	    localTripItem.setAdultQuantity(fit.getAdultQuantity());
    	    localTripItem.setChildQuantity(fit.getChildQuantity());
    	    localTripItem.setProductCategoryId(fit.getCategoryId());
    	    localTripItem.setTotalAmount(localTripProductDto.getPrice().multiply(new BigDecimal(100)).longValue());
    	    localTripItem.setTotalSettlementPrice(localTripProductDto.getPrice().multiply(new BigDecimal(100)).longValue());
    	    localTripItem.setDetailId(localTripProductDto.getDetailId());
    	    localTripItem.setRouteRelation(BuyInfo.ItemRelation.PACK);
    	    itemList.add(localTripItem);
    	}
    	
	}

	/**
     * 构造酒店套餐下单信息
     * @param fit
     * @param itemList
     */
    private void hotelComboInfoToItem(VstBookingRequest fit, List<Item> itemList) {
    	 
    	FitOrderHotelComboDto hotelComboDto =  fit.getFitOrderHotelComboDto();
    	if(null!=hotelComboDto){
    	    BuyInfo.Item hotelComboItem = new BuyInfo.Item();
    	    hotelComboItem.setGoodsId(hotelComboDto.getGoodsId());
    	    hotelComboItem.setQuantity(hotelComboDto.getQuantity().intValue());
    	    hotelComboItem.setAdultQuantity(fit.getAdultQuantity());
    	    hotelComboItem.setChildQuantity(fit.getChildQuantity());
    	    hotelComboItem.setProductCategoryId(fit.getCategoryId());
    	    hotelComboItem.setVisitTime(DateUtils.formatDate(hotelComboDto.getCheckIn(), DateUtils.YYYY_MM_DD));
    	    hotelComboItem.setTotalAmount(hotelComboDto.getPrice().multiply(new BigDecimal(100)).longValue());
    	    hotelComboItem.setTotalSettlementPrice(hotelComboDto.getPrice().multiply(new BigDecimal(100)).longValue());
    	    hotelComboItem.setDetailId(hotelComboDto.getDetailId());
    	    hotelComboItem.setRouteRelation(BuyInfo.ItemRelation.PACK);
    	    itemList.add(hotelComboItem);
    	}
	}

	/**
     * 构造下单人员方面信息
     * @param fit
     * @param buyInfo
     */
	private void peopleInfoToBuyInfo(VstBookingRequest fit, BuyInfo buyInfo) {
		//联系人
        FitOrderContacterDto fitContacter = fit.getFitOrderContacterDto();
        Person contact = new Person();
        contact.setFullName(fitContacter.getName());
        contact.setEmail(fitContacter.getEmail());
        contact.setMobile(fitContacter.getMobile());
        buyInfo.setContact(contact);

        //下单人信息
        FitOrderCustomerDto fitCustomer = fit.getFitOrderCustomerDto();
        buyInfo.setIp(fitCustomer.getCustomerIP());
        buyInfo.setUserId(fitCustomer.getCustomerId());
        buyInfo.setUserNo(Long.valueOf(fitCustomer.getCustomerCode()));
        Person booker = new Person();
        booker.setFullName(fitCustomer.getCustomerName());
        booker.setMobile(fitContacter.getMobile());
        buyInfo.setBooker(booker);

        //游客信息
        List<Person> travellers = new ArrayList<Person>();
        for (FitOrderPassengerDto psg : fit.getFitOrderPassengerDtoList()) {
            Person traveller = new Person();
            traveller.setFullName(psg.getPassengerName());
            traveller.setMobile(psg.getMobile());
            switch (psg.getPassengerType()) {
                case ADULT:
                    traveller.setPeopleType("PEOPLE_TYPE_ADULT");
                    break;
                case CHILDREN:
                    traveller.setPeopleType("PEOPLE_TYPE_CHILD");
                    break;
                default:
                    traveller.setPeopleType("");
                    break;
            }
            switch (psg.getPassengerIDCardType()) {
                case ID:
                    traveller.setIdType("ID_CARD");
                    break;
                case PASSPORT:
                    traveller.setIdType("HUZHAO");
                    break;
                case OFFICER:
                    traveller.setIdType("JUNGUAN");
                    break;
                case SOLDIER:
                    traveller.setIdType("SHIBING");
                    break;
                case TAIBAO:
                    traveller.setIdType("TAIBAOZHENG");
                    break;
                default:
                    traveller.setIdType("");
                    break;
            }
            traveller.setIdNo(psg.getPassengerIDCardNo());
            traveller.setBirthday(psg.getPassengerBirthday());
            travellers.add(traveller);
        }
        buyInfo.setTravellers(travellers);
	}

	private void insuranceInfoToItem(VstBookingRequest fit, List<Item> itemList) {
		for (FitOrderInsuranceDto insuranceDto : fit.getFitOrderInsuranceDtos()) {
            BuyInfo.Item ticketItem = new BuyInfo.Item();
            ticketItem.setGoodsId(Long.valueOf(insuranceDto.getInsuranceSuppGoodsId()));//必填项：保险商品Id
            ticketItem.setQuantity(insuranceDto.getInsuranceCount());//必填项：保险份数
            ticketItem.setVisitTime(fit.getVisitTime());
            ticketItem.setProductCategoryId(BizEnum.BIZ_CATEGORY_TYPE.category_route_freedom.getCategoryId());//自由行
            itemList.add(ticketItem);
        }
	}

	private void ticketInfoToItem(VstBookingRequest fit,List<BuyInfo.Item> itemList) {
		for (FitOrderSpotTicketDto spotTicketDto : fit.getFitOrderSpotTicketDtos()) {
            BuyInfo.Item ticketItem = new BuyInfo.Item();
            ticketItem.setGoodsId(Long.valueOf(spotTicketDto.getTicketId()));//必填项：门票Id
            ticketItem.setQuantity(spotTicketDto.getTicketCount());//必填项：门票数
            ticketItem.setVisitTime(DateUtils.formatDate(spotTicketDto.getVisitDate(),DateUtils.YYYY_MM_DD));
            ticketItem.setProductCategoryId(BizEnum.BIZ_CATEGORY_TYPE.category_route_freedom.getCategoryId());//自由行
            itemList.add(ticketItem);
        }
	}

	private void hotelInfoToItem(VstBookingRequest fit,List<BuyInfo.Item> itemList) {
		//酒店信息
        for (FitOrderHotelDto hotel : fit.getFitOrderHotelDtoList()) {
            BuyInfo.Item hotelItem = new BuyInfo.Item();
            hotelItem.setGoodsId(Long.valueOf(hotel.getPlanId()));//必填项：planID
            hotelItem.setQuantity(hotel.getRoomCount());//必填项：房间间数
            hotelItem.setAdultQuantity(fit.getAdultQuantity());
            hotelItem.setChildQuantity(fit.getChildQuantity());
            hotelItem.setVisitTime(DateUtils.formatDate(hotel.getCheckin(), DateUtils.YYYY_MM_DD));
            hotelItem.setProductCategoryId(BizEnum.BIZ_CATEGORY_TYPE.category_route_freedom.getCategoryId());//自由行
            
            if(fit.getBookingSource().getBookingBusinessType().name().equals(BookingBusinessType.FIT_SDP.name())){
            	hotelItem.setDetailId(Long.valueOf(hotel.getDetailId()));
            	hotelItem.setMainItem("MAIN");
            	hotelItem.setRouteRelation(ItemRelation.PACK);
            }
            
            BuyInfo.HotelAdditation hotelAdditation = new BuyInfo.HotelAdditation();
            hotelAdditation.setArrivalTime("14:00");//必填项：入住时间
            hotelAdditation.setLeaveTime(DateUtils.formatDate(hotel.getCheckout(), DateUtils.YYYY_MM_DD));//必填项：离店时间
            hotelItem.setHotelAdditation(hotelAdditation);
            itemList.add(hotelItem);
        }
	}

	private void flightInfoToItem(VstBookingRequest fit,List<BuyInfo.Item> itemList) {
	    BigDecimal adultInsTotalPrice = BigDecimal.valueOf(0);
	    BigDecimal chdInsTotalPrice = BigDecimal.valueOf(0);
	    
	    FitOrderPassengerDto adultPassenger = null;
	    FitOrderPassengerDto chdPassenger = null;
	    
	    for (FitOrderPassengerDto passenger : fit.getFitOrderPassengerDtoList()) {
	        if (adultPassenger == null && passenger.getPassengerType().equals(PassengerType.ADULT)) {
	            adultPassenger = passenger;
	            continue;
	        }
	        if (chdPassenger == null && passenger.getPassengerType().equals(PassengerType.CHILDREN)) {
	            chdPassenger = passenger;
	        }
	    }
	    
        if (adultPassenger != null && CollectionUtils.isNotEmpty(adultPassenger.getFlightInsuranceDto())) {
	        String flightNo = adultPassenger.getFlightInsuranceDto().get(0).getFlightNo();
            for (FlightInsuranceDto insurance : adultPassenger.getFlightInsuranceDto()) {
                if (insurance.getFlightNo().equals(flightNo)) {
                    adultInsTotalPrice = adultInsTotalPrice.add(insurance.getInsurancePrice());
                }
            }
        }
        if (chdPassenger != null &&CollectionUtils.isNotEmpty(chdPassenger.getFlightInsuranceDto())) {
            String flightNo = chdPassenger.getFlightInsuranceDto().get(0).getFlightNo();
            for (FlightInsuranceDto insurance : chdPassenger.getFlightInsuranceDto()) {
                if (insurance.getFlightNo().equals(flightNo)) {
                    chdInsTotalPrice = chdInsTotalPrice.add(insurance.getInsurancePrice());
                }
            }
        }

        Collections.sort(fit.getFitOrderFlightDtoList(), new Comparator<FitOrderFlightDto>() {
            @Override
            public int compare(FitOrderFlightDto o1, FitOrderFlightDto o2) {
                return DateUtils.parseDate(o1.getDepartureDate()).compareTo(DateUtils.parseDate(o2.getDepartureDate()));
            }
        });
	    //机票虚拟商品
        for (int i = 0; i <fit.getFitOrderFlightDtoList().size() ; i++) {
            FitOrderFlightDto flight = fit.getFitOrderFlightDtoList().get(i);
            BuyInfo.Item flightItem = new BuyInfo.Item();
            flightItem.setGoodsId(getFitGoodsId());//必填项：固定机票虚拟商品ID：1628417
            //flightItem.setGoodsId(1628417l);//必填项：固定机票虚拟商品ID：1628417
            flightItem.setAdultQuantity(fit.getAdultQuantity());//成人数
            flightItem.setChildQuantity(fit.getChildQuantity());//儿童数

            if (fit.getAdultQuantity() > 0) {
                BigDecimal adultInsPrice = flight.getAdultPrice().add(adultInsTotalPrice);
                flightItem.setAdultAmt(adultInsPrice.multiply(new BigDecimal(100)).longValue());//必填项：机票成人单价
            }
            if (fit.getChildQuantity() > 0) {
                BigDecimal chdInsPrice = flight.getChildPrice().add(chdInsTotalPrice);
                flightItem.setChildAmt(chdInsPrice.multiply(new BigDecimal(100)).longValue());//必填项：机票儿童单价
            }
            /*flightItem.setAdultAmt(fit.getAdultAmount().multiply(new BigDecimal(100)).longValue());//必填项：机票成人总金额
            flightItem.setChildAmt(fit.getChildAmount().multiply(new BigDecimal(100)).longValue());//必填项：机票儿童总金额*/
            flightItem.setVisitTime(flight.getDepartureDate());
            FlightNoVo flightNoVo = new FlightNoVo();
            flightNoVo.setPlaneCode(flight.createProductName());
            if(fit.getFitOrderFlightDtoList().size()>1){
                if(i==0){
                    flightItem.setToDate(flight.getDepartureDate());
                }
                if(i==1){
                    flightItem.setBackDate(flight.getDepartureDate());
                }
                flightNoVo.setFlightType(Long.valueOf(i+1));
            }else{
                flightNoVo.setFlightType(3L);
            }
            //起飞机场、到达机场，航站楼，航班号，起飞时间
            flightNoVo.setFromAirPort(flight.getDepartureAirportName());//起飞机场
            flightNoVo.setToAirPort(flight.getArrivalAirportName());//到达机场
            flightNoVo.setFromCityName(flight.getDepartureCityName());
            flightNoVo.setToCityName(flight.getArrivalCityName());
            flightNoVo.setStartTerminal(flight.getDepartureTermainalBuilding());//起飞航站楼
            flightNoVo.setArriveTerminal(flight.getArrivalTerminalBuilding());//到达航站楼
            flightNoVo.setFlightNo(flight.getFlightNo());//航班号
            flightNoVo.setGoTime(DateUtils.parseCnHmDate(flight.getDepartureTime()));//起飞时间
            flightNoVo.setArriveTime(DateUtils.parseCnHmDate(flight.getArrivalTime()));//到达时间
            flightNoVo.setSeatName(flight.getSeatClassTypeName());
            flightNoVo.setCompanyName(flight.getCarrierName());//航空公司

            //此处是针对sdp产品中机票加价的价格做得处理--只针对去程
            if(fit.getBookingSource().getBookingBusinessType().name().equals(BookingBusinessType.FIT_SDP.name())){

                //settleAmount--成人机票后台价*成人数  + 儿童机票后台价*儿童数
                BigDecimal departurSettleAmount = new BigDecimal(0);
                BigDecimal departurAdultSettleAmount = new BigDecimal(flightItem.getAdultAmt()).multiply(new BigDecimal(flightItem.getAdultQuantity()));
                BigDecimal departurChildSettleAmount = null==flightItem.getChildAmt()?new BigDecimal(0):new BigDecimal(flightItem.getChildAmt()).multiply(new BigDecimal(flightItem.getChildQuantity()));
                departurSettleAmount = departurSettleAmount.add(departurChildSettleAmount).add(departurAdultSettleAmount);

                //成人单价--机票后台价格+加价规则
                BigDecimal departurAdultSingleAmount = new BigDecimal(flightItem.getAdultAmt()).add(fit.getFlightFeeAmount().multiply(new BigDecimal(100)));

                //儿童单价--机票后台价格+加价规则
                BigDecimal departurChildSingleAmount = null==flightItem.getChildAmt()?new BigDecimal(0):new BigDecimal(flightItem.getChildAmt()).add(fit.getFlightFeeAmount().multiply(new BigDecimal(100)));

                //totalAmount--成人单价*成人数  + 儿童单价*儿童数
                BigDecimal departurTotalAmount = new BigDecimal(0);
                departurTotalAmount = departurTotalAmount.add(departurChildSingleAmount.multiply(new BigDecimal(flightItem.getChildQuantity()))).add(departurAdultSingleAmount.multiply(new BigDecimal(flightItem.getAdultQuantity())));

                if(flight.getTripType()==FlightTripType.DEPARTURE){
                    flightItem.setTotalAmount(departurTotalAmount.longValue());
                    flightItem.setAdultAmt(departurAdultSingleAmount.longValue());
                    flightItem.setChildAmt(departurChildSingleAmount.longValue());
                    flightNoVo.setFlightType(1l);//航程类型 1、去程  2、返程
                }else{
                    flightItem.setTotalAmount(departurSettleAmount.longValue());
                    flightNoVo.setFlightType(2l);
                }
                flightItem.setTotalSettlementPrice(departurSettleAmount.longValue());
            }


            flightItem.setFlightNoVo(flightNoVo);
            List<FlightNoVo> additionalFlightNoVoList =new ArrayList<FlightNoVo>();
            additionalFlightNoVoList.add(flightNoVo);
            flightItem.setAdditionalFlightNoVoList(additionalFlightNoVoList);
            itemList.add(flightItem);
        }

	}
    
}

