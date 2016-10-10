package com.lvmama.lvfit.business.service.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lvmama.lvf.common.utils.JSONMapper;
import com.lvmama.lvfit.business.order.service.OrderSyncService;
import com.lvmama.lvfit.common.client.path.BussinessClientPath;
import com.lvmama.lvfit.common.dto.order.FitSuppMainOrderStatusDto;

@Component
@Path("")
public class FitOrderResource {

	private static final Logger logger = LoggerFactory.getLogger(FitOrderResource.class);
	
	@Autowired
	private OrderSyncService  orderSyncService; 
	

    
	@POST
	@GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path(BussinessClientPath.Path.AUTO_SYNC_SUPPMAINORDER_STATUS)
	public void autoSyncSuppMainOrderStatus()  {
		logger.info("-------------------------------autoSyncSuppMainOrderStatus--start-------------------------------------------");
    	List<FitSuppMainOrderStatusDto>  suppMainOrderStatusDtos = orderSyncService.queryNeedToSyncSuppMainOrderStatus();
    	if(CollectionUtils.isNotEmpty(suppMainOrderStatusDtos)){
    		try {
    			if(logger.isInfoEnabled()){
    				logger.info("-------------------------------autoSyncSuppMainOrderStatus--start-------------------------------------------:【"+JSONMapper.getInstance().writeValueAsString(suppMainOrderStatusDtos)+"】");
    			}
			} catch (Exception e) {
				logger.error(e.getMessage(),e);
			}
    		for (FitSuppMainOrderStatusDto suppMainOrderStatusDto : suppMainOrderStatusDtos) {
    			try {
					orderSyncService.syncSuppMainOrderStatus(suppMainOrderStatusDto.getVstMainOrderNo());
				} catch (Exception e) {
					logger.error(e.getMessage(),e);
				}
			}
    		logger.info("-------------------------------autoSyncSuppMainOrderStatus--end-------------------------------------------");
    	}
	}
}

	