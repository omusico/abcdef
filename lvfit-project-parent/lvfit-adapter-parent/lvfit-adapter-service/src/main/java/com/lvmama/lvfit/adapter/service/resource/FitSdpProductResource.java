package com.lvmama.lvfit.adapter.service.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.lvmama.lvfit.common.dto.enums.JudgeType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lvmama.lvfit.adapter.search.adapter.PackageProductAdapter;
import com.lvmama.lvfit.adapter.search.adapter.PackageProductAdditionalAdapter;
import com.lvmama.lvfit.common.client.path.SearchClientPath;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpProductAdditionalInfoDto;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpProductBasicInfoDto;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpProductPropDto;
import com.lvmama.lvfit.common.dto.sdp.product.request.FitSdpProductAdditionalInfoRequest;

@Component
@Path("")
public class FitSdpProductResource {

    private static final Logger logger = LoggerFactory.getLogger(FitSdpProductResource.class);

    @Autowired
    private PackageProductAdapter packageProductAdapter;
    
    @Autowired
    private PackageProductAdditionalAdapter packageProductAdditionalAdapter;
    
    /**
     * 调用主站接口查询打包产品数据
     * @param productRequest
     * @return
     */
    @POST
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path(SearchClientPath.Path.PACKAGE_PRODUCT_BASIC_INFO_SEARCH)
    public Response searchBasicInfo(@PathParam("productId") Long productId) {
    	
    	logger.info("productId:【"+productId+"】从vst获取产品信息数据！");
    	// 查找产品基本信息
        FitSdpProductBasicInfoDto basicInfo = packageProductAdapter.getPackageProductBasicInfo(productId);
        // 查找产品额外信息
        FitSdpProductAdditionalInfoRequest additionalReq = new FitSdpProductAdditionalInfoRequest();
        additionalReq.setProductId(productId);
        additionalReq.setCategoryCode(basicInfo.getCategoryCode());
        additionalReq.setManagerId(basicInfo.getManagerId());
        additionalReq.setStartDistrictId(null);
        FitSdpProductAdditionalInfoDto additionalInfo = packageProductAdditionalAdapter.searchPackageProductAdditionalInfo(additionalReq, basicInfo.getAdditionalInfoDto());
        basicInfo.setAdditionalInfoDto(additionalInfo);
        if (additionalInfo != null) {
            basicInfo.setManagerName(additionalInfo.getPmUserName());
        }
        return Response.ok(basicInfo).build();
    }
    
    @POST
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path(SearchClientPath.Path.PACKAGE_PRODUCT_INFO_ONLY_SEARCH)
    public Response searchBasicInfoOnly(@PathParam("productId") Long productId) { 
    	logger.info("productId:【"+productId+"】从vst获取产品信息数据！");
    	// 查找最简单的产品基本信息
        FitSdpProductBasicInfoDto basicInfo = packageProductAdapter.getPackageProductSimpleInfo(productId); 
        return Response.ok(basicInfo).build();
    }
    
    @GET
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path(SearchClientPath.Path.PACKAGE_PRODUCT_PROP_SEARCH)
    public Response getProdProductProp(@PathParam("productId") Long productId) {
        JudgeType isAutoPackageProduct = packageProductAdapter.getProdProductProp(productId);
        return Response.ok(isAutoPackageProduct).build();
    }
}
