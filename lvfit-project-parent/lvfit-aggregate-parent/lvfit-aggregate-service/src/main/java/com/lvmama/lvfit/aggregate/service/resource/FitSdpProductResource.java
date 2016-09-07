package com.lvmama.lvfit.aggregate.service.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lvmama.lvf.common.dto.BaseSingleResultDto;
import com.lvmama.lvfit.aggregate.sdp.service.FitSdpGoodsService;
import com.lvmama.lvfit.aggregate.sdp.service.FitSdpProductService;
import com.lvmama.lvfit.common.client.path.AggregateClientPath;
import com.lvmama.lvfit.common.dto.sdp.goods.FitSdpGoodsDto;
import com.lvmama.lvfit.common.dto.sdp.goods.request.FitSdpGoodsRequest;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpProductBasicInfoDto;

@Component
@Path("")
public class FitSdpProductResource {
    
    @Autowired
    private FitSdpProductService packageProductService;
    
    @Autowired
    private FitSdpGoodsService packageGoodsService;
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path(AggregateClientPath.Path.PACKAGE_PRODUCT_BASIC_INFO_SEARCH)
    public Response searchBasicInfo(@PathParam(value = "productId") Long productId) {
        FitSdpProductBasicInfoDto basicInfo = packageProductService.searchProductBasicInfo(productId);
        return Response.ok(basicInfo).build();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path(AggregateClientPath.Path.PACKAGE_PRODUCT_INFO_ONLY_SEARCH)
    public Response searchBasicInfoOnly(@PathParam(value = "productId") Long productId) {
        FitSdpProductBasicInfoDto basicInfo = packageProductService.searchProductInfoOnly(productId);
        return Response.ok(basicInfo).build();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path(AggregateClientPath.Path.PACKAGE_GOODS_INFO_SEARCH)
    public Response searchGoodsInfo(FitSdpGoodsRequest req) {
        BaseSingleResultDto<FitSdpGoodsDto> resultDto = packageGoodsService.searchProductGoodsInfo(req);
        return Response.ok(resultDto).build();
    }
}
