/**
 * Project Name:lvfit-adapter-vst
 * File Name:OrderQueryServiceAdapterImpl.java
 * Package Name:com.lvmama.lvfit.adapter.vst.adapter.impl
 * Date:2015-11-12下午3:28:07
 * Copyright (c) 2015, www.lvmama.com All Rights Reserved.
 *
 */

package com.lvmama.lvfit.adapter.vst.adapter.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lvmama.lvf.common.utils.DateUtils;
import com.lvmama.lvf.common.utils.JSONMapper;
import com.lvmama.lvf.common.utils.PkIdGenerator;
import com.lvmama.lvfit.adapter.vst.adapter.OrderQueryServiceAdapter;
import com.lvmama.lvfit.common.dto.enums.BindingStatus;
import com.lvmama.lvfit.common.dto.enums.FlightTripType;
import com.lvmama.lvfit.common.dto.enums.Paytarget;
import com.lvmama.lvfit.common.dto.enums.SuppVstAuditStatus;
import com.lvmama.lvfit.common.dto.enums.SuppVstInfoAuditStatus;
import com.lvmama.lvfit.common.dto.enums.SuppVstOrderStatus;
import com.lvmama.lvfit.common.dto.enums.SuppVstOrderViewStatus;
import com.lvmama.lvfit.common.dto.enums.SuppVstPaymentStatus;
import com.lvmama.lvfit.common.dto.enums.SuppVstResAuditStatus;
import com.lvmama.lvfit.common.dto.order.FitOrderAmountDto;
import com.lvmama.lvfit.common.dto.order.FitOrderDetail;
import com.lvmama.lvfit.common.dto.order.FitOrderHotelDto;
import com.lvmama.lvfit.common.dto.order.FitSuppMainOrderStatusDto;
import com.lvmama.lvfit.common.dto.order.FitSuppOrderDto;
import com.lvmama.lvfit.common.dto.order.FitSuppOrderStatusDto;
import com.lvmama.vst.back.biz.po.BizEnum;
import com.lvmama.vst.back.client.ord.service.OrderService;
import com.lvmama.vst.back.order.po.OrdOrder;
import com.lvmama.vst.back.order.po.OrdOrderItem;


/**
 * ClassName:OrderQueryServiceAdapterImpl <br/>
 * Function: vst订单查询适配器. <br/>
 * Date: 2015-11-12 下午3:28:07 <br/>
 * 
 * @author liuweiguo
 * @version
 * @since JDK 1.6
 * @see
 */
@Service
public class OrderQueryServiceAdapterImpl implements OrderQueryServiceAdapter{
	
	private static final Logger logger = LoggerFactory.getLogger(OrderQueryServiceAdapterImpl.class);
    @Autowired
    private OrderService orderService;

    @Override
    public OrdOrder queryVstOrderByVstOrderMainNo(Long vstOrderMainNo) {
    	OrdOrder ordOrder = orderService.queryOrdorderByOrderId(vstOrderMainNo);
    	return ordOrder;
    }
    
    @Override
    public FitOrderDetail getOrderMainByVstOrderMainNo(Long vstOrderMainNo) {
        OrdOrder ordOrder = this.queryVstOrderByVstOrderMainNo(vstOrderMainNo);
        try {
        	if(logger.isInfoEnabled()){
        		logger.info("VST订单请求结果：ordOrder~~~~~~:" + JSONMapper.getInstance().writeValueAsString(ordOrder));
        	}
        } catch (Exception e) {
        	logger.error(e.getMessage());
        }
        return this.genFitOrderDetail(ordOrder);
    }
    
    private FitOrderDetail genFitOrderDetail(OrdOrder ordOrder) {
        if (ordOrder == null) {
            return null;
        }
        FitOrderDetail result = new FitOrderDetail();
        // 设置游客信息
        if (ordOrder.getContactPerson() != null) {
            result.getFitOrderContacterDto().setName(ordOrder.getContactPerson().getFullName());
            result.getFitOrderContacterDto().setMobile(ordOrder.getContactPerson().getMobile());
        }
        
        // 订单信息
        result.setVstOrderMainNo(ordOrder.getOrderId().toString());
        result.setOrderViewStatus(SuppVstOrderViewStatus.valueOf(ordOrder.getViewOrderStatus()));
        result.setTotalAmount(BigDecimal.valueOf(Double.valueOf(ordOrder.getOughtAmountYuan())));
        result.setCreateTime(ordOrder.getCreateTime());
        result.setPaytarget(Paytarget.valueOf(ordOrder.getPaymentTarget()));
        result.setProductName(ordOrder.getProductName());
        result.setVisitTime(ordOrder.getVisitTime());
        //注：机票信息由机票订单获取
        // 酒店信息
        List<FitOrderHotelDto> hotels = result.getHotels();
        FitOrderHotelDto hotel = new FitOrderHotelDto();
        List<String> vstFlightNos = result.getVstFlightOrderNo();
        for (OrdOrderItem item : ordOrder.getOrderItemList()) {
            if (item.getCategoryId().equals(BizEnum.BIZ_CATEGORY_TYPE.category_hotel.getCategoryId())) {
                hotel.setPlanId(item.getSuppGoodsId().toString());
                hotel.setHotelName(item.getProductName());
                hotel.setRoomName(item.getSuppGoodsName());
                hotel.setPlanName(item.getSuppGoodsName());
                hotel.setCheckin(item.getVisitTime());
                hotel.setRoomCount((int)item.getQuantity().longValue());
            }
            if (item.getCategoryId().equals(BizEnum.BIZ_CATEGORY_TYPE.category_traffic_aero_other.getCategoryId())) {
                vstFlightNos.add(item.getOrderItemId().toString());
            }
        }
        result.setVstFlightOrderNo(vstFlightNos);
        hotels.add(hotel);
        // 设置VST子单信息
        List<FitSuppOrderDto> suppOrders = new ArrayList<FitSuppOrderDto>();
        Map<String, String> map = new HashMap<String, String>();
        Date maxDate = null;
        int flightCount = 0;
        for (OrdOrderItem item : ordOrder.getOrderItemList()) {
            FitSuppOrderDto fitSuppOrderDto = new FitSuppOrderDto();
            fitSuppOrderDto.setCategoryId(item.getCategoryId());
            fitSuppOrderDto.setVstOrderNo(item.getOrderItemId());
            fitSuppOrderDto.setBindingStatus(BindingStatus.BINDING);
            FitOrderAmountDto fitOrderAmountDto = new FitOrderAmountDto();
            fitOrderAmountDto.setTotalAmount(new BigDecimal(item.getTotalPriceYuan()).setScale(0, BigDecimal.ROUND_UP));
            fitSuppOrderDto.setOrderAmount(fitOrderAmountDto);
            suppOrders.add(fitSuppOrderDto);
            
            if (item.getCategoryId().equals(BizEnum.BIZ_CATEGORY_TYPE.category_traffic_aero_other.getCategoryId())) {
                flightCount++;
                String depTimeStr = item.getContentStringByKey("departureTime");
                Date depDate = DateUtils.parseDate(depTimeStr);
                if (maxDate == null || maxDate.compareTo(depDate) < 0) {
                    maxDate = depDate;
                }
                map.put(fitSuppOrderDto.getVstOrderNo().toString(), depTimeStr);
            }
        }
        
        for (FitSuppOrderDto fitSuppOrderDto : suppOrders) {
            if (fitSuppOrderDto.getCategoryId().equals(BizEnum.BIZ_CATEGORY_TYPE.category_traffic_aero_other.getCategoryId())) {
                if (flightCount == 1) {
                    fitSuppOrderDto.setTripType(FlightTripType.DEPARTURE);
                }
                if (flightCount == 2) {
                    String depTime = map.get(fitSuppOrderDto.getVstOrderNo().toString());
                    Date depDate = DateUtils.parseDate(depTime);
                    if (depDate.compareTo(maxDate) < 0) {
                        fitSuppOrderDto.setTripType(FlightTripType.DEPARTURE);
                    }
                    if (depDate.compareTo(maxDate) == 0) {
                        fitSuppOrderDto.setTripType(FlightTripType.RETURN);
                    }
                }
            }
        }
        result.setSuppOrders(suppOrders);
        return result;
    }

	@Override
	public FitSuppMainOrderStatusDto getVstOrderStatusByVstOrderMainNo(Long vstOrderMainNo) {
		
		OrdOrder ordOrder = this.queryVstOrderByVstOrderMainNo(vstOrderMainNo);
		if(ordOrder!=null){
			FitSuppMainOrderStatusDto suppMainOrderStatusDto = new FitSuppMainOrderStatusDto();
			suppMainOrderStatusDto.setVstMainOrderNo(vstOrderMainNo);
	    	if(StringUtils.isNotEmpty(ordOrder.getViewOrderStatus())){
	    		suppMainOrderStatusDto.setOrderViewStatus(SuppVstOrderViewStatus.valueOf(ordOrder.getViewOrderStatus()));
			}
			if(StringUtils.isNotEmpty(ordOrder.getOrderStatus())){
				suppMainOrderStatusDto.setOrderStatus(SuppVstOrderStatus.valueOf(ordOrder.getOrderStatus()));
			}
			if(StringUtils.isNotEmpty(ordOrder.getResourceStatus())){
				suppMainOrderStatusDto.setAuditStatus(SuppVstAuditStatus.valueOf(ordOrder.getInfoStatus()));
			}
			if(StringUtils.isNotEmpty(ordOrder.getPaymentStatus())){
				suppMainOrderStatusDto.setPaymentStatus(SuppVstPaymentStatus.valueOf(ordOrder.getPaymentStatus()));
			}
			try {
				long wait = ordOrder.getWaitPaymentSec();
				if(wait>0){
					suppMainOrderStatusDto.setWaitPayTime(wait/60);
				}
			} catch (Exception e) {
				logger.error(e.getMessage());
			}
			List<OrdOrderItem>  ordOrderItems = ordOrder.getOrderItemList();
			if(CollectionUtils.isNotEmpty(ordOrderItems)){
				for (OrdOrderItem item : ordOrderItems) {
				 		FitSuppOrderStatusDto suppOrderStatusDto = new FitSuppOrderStatusDto(); 
				 		suppOrderStatusDto.setVstOrderNo(item.getOrderItemId());
				 		if(StringUtils.isNotEmpty(item.getOrderStatus())){
				 			suppOrderStatusDto.setOrderStatus(SuppVstOrderStatus.valueOf(item.getOrderStatus()));
						}
						if(StringUtils.isNotEmpty(item.getResourceStatus())){
							suppOrderStatusDto.setResAuditStatus(SuppVstResAuditStatus.valueOf(item.getResourceStatus()));
						}
						if(StringUtils.isNotEmpty(item.getInfoStatus())){
							suppOrderStatusDto.setInfoAuditStatus(SuppVstInfoAuditStatus.valueOf(item.getInfoStatus()));
						}
						if(StringUtils.isNotEmpty(item.getPaymentStatus())){
							suppOrderStatusDto.setPaymentStatus(SuppVstPaymentStatus.valueOf(item.getPaymentStatus()));
						}
						suppMainOrderStatusDto.getSuppOrderStatusDtos().add(suppOrderStatusDto);
				}
			}
			return suppMainOrderStatusDto;
		}
		return null;
	}

    //TODO 接口还存在问题，之后修改
//	private void genFitOrderMainDtoByVSTOrder(Long vstOrderMainNo, OrdOrder ordOrder, FitOrderMainDto fitOrderMainDto) {
//		// 设置主单号
//		fitOrderMainDto.setFitOrderNo(new FitOrderNoDto(ordOrder.getOrderId().toString()));
//		// 设置产品名称
//		fitOrderMainDto.setProductName(ordOrder.getProductName());
//		// 设置订单信息
//		List<FitOrderDto> fitOrders = new ArrayList<FitOrderDto>();
//		for (OrdOrderItem item : ordOrder.getOrderItemList()) {
//			FitOrderDto flightOrderDto = new FitOrderDto();
//			flightOrderDto.setFitOrderNo(new FitOrderNoDto(item.getOrderId().toString()));
//			flightOrderDto.setOrderMainId(vstOrderMainNo);
//
//			flightOrderDto.setOrderProductId(item.getSuppGoodsId());
//
//			FitOrderAmountDto fitOrderAmountDto = new FitOrderAmountDto();
//			fitOrderAmountDto.setTotalAmount(BigDecimal.valueOf(item.getTotalAmount()));
//			flightOrderDto.setOrderAmount(fitOrderAmountDto);
//			fitOrders.add(flightOrderDto);
//			if (item.getCategoryId().equals(BizEnum.BIZ_CATEGORY_TYPE.category_traffic_aero_other.getCategoryId())) {
//				flightOrderDto.setProduct(Product.I_FLIGHT);
//			}
//			if (item.getCategoryId().equals(BizEnum.BIZ_CATEGORY_TYPE.category_hotel.getCategoryId())) {
//				flightOrderDto.setProduct(Product.I_HOTEL);
//			}
//		}
//		fitOrderMainDto.setFitOrders(fitOrders);
//	}
}