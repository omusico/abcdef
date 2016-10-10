package com.lvmama.lvfit.business.booking.service.impl;

import java.io.IOException;
import java.util.List;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lvmama.lvf.common.utils.JSONMapper;
import com.lvmama.lvfit.business.booking.service.FitBookingFinService;
import com.lvmama.lvfit.business.order.domain.repository.FitOrderStatusRepository;
import com.lvmama.lvfit.business.order.domain.repository.FitSuppMainOrderRepository;
import com.lvmama.lvfit.common.dto.order.FitOrderDto;
import com.lvmama.lvfit.common.dto.order.FitOrderMainDto;
import com.lvmama.lvfit.common.dto.order.FitOrderStatusDto;
import com.lvmama.lvfit.common.dto.order.FitSuppMainOrderDto;
import com.lvmama.lvfit.common.dto.order.FitSuppOrderDto;
import com.lvmama.lvfit.common.dto.status.order.OrderAuditStatus;
import com.lvmama.lvfit.common.dto.status.order.OrderBookingStatus;

/**
 * @author qihuisong
 */
@Service
public class FitBookingFinServiceImpl implements FitBookingFinService{

	 private static final Logger logger = LoggerFactory.getLogger(FitBookingFinServiceImpl.class);
	
    @Autowired
    private FitOrderStatusRepository fitOrderStatusRepository;

    @Autowired
    private FitSuppMainOrderRepository fitSuppMainOrderRepository;

    @Override
    public FitOrderMainDto finishBooking(FitOrderMainDto orderMainDto) {
    	
    	try {
    		 //保存订单关联关系
            this.saveOrderRelation(orderMainDto);
            //下单成功后，更新订单状态
            this.saveOrderStatus(orderMainDto);
          
		} catch (Exception e) {
			logger.error("供应商子单号【"+orderMainDto.getFitSuppMainOrderDto().getFitMainOrderNo() +"】finishBooking 保存数据失败:" + ExceptionUtils.getFullStackTrace(e));
		}
    	return orderMainDto;
    }

    private void saveOrderStatus(FitOrderMainDto orderMainDto) {
        List<FitOrderDto> fitOrders = orderMainDto.getFitOrders();
        for (FitOrderDto orderDto : fitOrders) {
            FitOrderStatusDto orderStatus = orderDto.getOrderStatus();
            orderStatus.setOrderBookingStatus(OrderBookingStatus.BOOKING_SUCC);
            orderStatus.setOrderAuditStatus(OrderAuditStatus.AUDIT_PASS);
            fitOrderStatusRepository.save(orderStatus);
        }
    }

    public FitOrderMainDto saveOrderRelation(FitOrderMainDto orderMainDto) {
        FitSuppMainOrderDto suppMainOrderDto = orderMainDto.getFitSuppMainOrderDto();
        try {
        	if(logger.isInfoEnabled()){
        		logger.info("suppMainOrderDto【"+suppMainOrderDto.getVstMainOrderNo()+"】供应商信息【"+JSONMapper.getInstance().writeValueAsString(suppMainOrderDto)+"】");
        	}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
        fitSuppMainOrderRepository.save(suppMainOrderDto);
    	logger.info("suppMainOrderDto【"+suppMainOrderDto.getVstMainOrderNo()+"】供应商信息保存成功！");
        return orderMainDto;
    }
}
