package com.lvmama.lvfit.sdp.service.resource;

import com.lvmama.lvf.common.dto.BaseSingleResultDto;
import com.lvmama.lvfit.common.client.path.SdpClientPath;
import com.lvmama.lvfit.common.dto.sdp.calculator.FitSdpShoppingAmountDto;
import com.lvmama.lvfit.common.dto.sdp.calculator.request.FitSdpCalculateAmountDetailRequest;
import com.lvmama.lvfit.common.dto.sdp.calculator.request.FitSdpCalculateAmountRequest;
import com.lvmama.lvfit.common.dto.sdp.shopping.FitSdpShoppingDto;
import com.lvmama.lvfit.common.dto.search.flight.result.MockUtil;
import com.lvmama.lvfit.sdp.shopping.FitSdpShopingCalculateService;
import com.lvmama.lvfit.sdp.shopping.FitSdpShoppingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Component
@Path("")
public class FitSdpShoppingResource {
	
	@Autowired
	private FitSdpShopingCalculateService fitSdpShoppingCalculateService;
	
	@Autowired
	private FitSdpShoppingService fitSdpShoppingService;
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path(SdpClientPath.Path.CALCULAT_SHOPPING_AMOUNT)
	public Response calculatAmount(FitSdpCalculateAmountRequest request) {
		BaseSingleResultDto<FitSdpShoppingAmountDto> result = fitSdpShoppingCalculateService.calculateAmount(request);
		return Response.ok(result).build();
	}
	
	/**
	 * 
	 * getShoppingByShoppingUUID:加载购物车数据. <br/>
	 * 
	 * @param shoppingUUID
	 * @return
	 * @since JDK 1.6
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path(SdpClientPath.Path.GET_SHOPPING_BY_UUID)
	public Response getShoppingByShoppingUUID(String shoppingUUID) {
		FitSdpShoppingDto result = fitSdpShoppingService.getFitSdpShoppingDto(shoppingUUID);
		return Response.ok(result).build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path(SdpClientPath.Path.CALCULAT_SHOPPING_AMOUNT_BY_DETAIL)
	public Response calculateAmountByDetail(FitSdpCalculateAmountDetailRequest request) {
		BaseSingleResultDto<FitSdpShoppingAmountDto> result = fitSdpShoppingCalculateService.calculateAmountByDetail(request);
		return Response.ok(result).build();
	}
}
