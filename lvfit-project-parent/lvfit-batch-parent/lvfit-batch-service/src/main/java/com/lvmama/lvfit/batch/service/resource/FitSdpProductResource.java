package com.lvmama.lvfit.batch.service.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lvmama.lvf.common.dto.status.ResultStatus;
import com.lvmama.lvf.common.utils.MemcachedUtil;
import com.lvmama.lvfit.batch.product.service.FitSdpProductBasicInfoSyncService;
import com.lvmama.lvfit.common.client.path.BatchClientPath;
import com.lvmama.lvfit.common.dto.enums.JudgeType;

@Component
@Path("")
public class FitSdpProductResource {
	
	private static final Logger logger = LoggerFactory.getLogger(FitSdpProductResource.class);
	
	@Autowired
	private FitSdpProductBasicInfoSyncService productBasicInfoSyncService;

	@GET
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path(BatchClientPath.Path.SYNC_SDP_PRODUCT_BASIC_INFO)
	public Response syncSdpProductBasicInfo(@PathParam("productId")Long productId){
		
		try
		{
			ResultStatus resultStatus = productBasicInfoSyncService.syncSdpProductBasicInfo(productId);
			return Response.ok(resultStatus).build();
		}
		catch(Exception e)
		{
			logger.error("缓存异常:", e);
			//缓存异常则先屏蔽1天
			//MemcachedUtil.getInstance().set("fit_"+productId, MemcachedUtil.ONE_HOUR*24, JudgeType.N.name());
		}
		return Response.ok(ResultStatus.FAIL).build();
		
	}	
	
}
