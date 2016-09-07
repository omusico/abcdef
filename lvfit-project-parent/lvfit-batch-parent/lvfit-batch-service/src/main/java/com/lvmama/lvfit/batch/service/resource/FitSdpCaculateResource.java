package com.lvmama.lvfit.batch.service.resource;

import com.lvmama.lvf.common.dto.status.ResultStatus;
import com.lvmama.lvfit.batch.caculate.service.FitSdpCaculateService;
import com.lvmama.lvfit.common.client.path.BatchClientPath;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Component
@Path("")
public class FitSdpCaculateResource {

	private static final Logger logger = LoggerFactory.getLogger(FitSdpCaculateResource.class);
	
	@Autowired
	private FitSdpCaculateService fitSdpCaculateService;



	@GET
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path(BatchClientPath.Path.SYNC_SDP_PRODUCT_SEARCH_INDEX)
	public Response syncSdpProductSearchIndex(@PathParam("productId")Long productId){
		
		try
		{
			logger.error("同步产品Id【"+productId+"】的索引开始！");
			fitSdpCaculateService.syncSdpProductSearchIndex(productId,true);
			logger.error("同步产品Id【"+productId+"】的索引结束！");
			return Response.ok(ResultStatus.SUCCESS).build();
		}
		catch(Exception e)
		{
			logger.error("同步产品Id【"+productId+"】的索引失败！");
			logger.error("同步单条索引异常:", e);
		}
		return Response.ok(ResultStatus.FAIL).build();
		
	}
	
	@GET
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path(BatchClientPath.Path.SYNC_ALL_USEFUL_SDP_PRODUCT_SEARCH_INDEX)
	public Response syncAllUsefulSdpProductSearchIndex(@PathParam("modValue")Integer modValue){

		logger.error("同步产品Id其modeValue值为"+modValue+"的索引结束！");
		try {
			fitSdpCaculateService.syncSdpProductIndexsByModValue(modValue);
			return Response.ok(ResultStatus.SUCCESS).build();
		} catch (Exception e) {
			return Response.ok(ResultStatus.FAIL).build();
		}
	}

	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path(BatchClientPath.Path.SYNC_UNFINISHED_PRODUCT_SEARCH_INDEX)
	public Response syncUnFinishedProductSearchIndex() {
		try {
			fitSdpCaculateService.syncUnfinishedProductsToIndex();
			return Response.ok(ResultStatus.SUCCESS).build();
		} catch (Exception e) {
			return Response.ok(ResultStatus.FAIL).build();
		}
	}
}
