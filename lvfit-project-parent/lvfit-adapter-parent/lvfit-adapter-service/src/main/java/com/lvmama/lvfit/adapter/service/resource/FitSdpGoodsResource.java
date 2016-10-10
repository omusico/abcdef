package com.lvmama.lvfit.adapter.service.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.lvmama.lvf.common.utils.JSONMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lvmama.lvf.common.dto.BaseSingleResultDto;
import com.lvmama.lvfit.adapter.search.adapter.PackageGoodsAdapter;
import com.lvmama.lvfit.common.client.path.SearchClientPath;
import com.lvmama.lvfit.common.dto.sdp.goods.FitSdpGoodsDto;
import com.lvmama.lvfit.common.dto.sdp.goods.request.FitSdpGoodsRequest;

import java.io.IOException;

@Component
@Path("")
public class FitSdpGoodsResource {
    
    private static final Logger logger = LoggerFactory.getLogger(FitSdpGoodsResource.class);
	
    @Autowired
    private PackageGoodsAdapter packageGoodsAdapter; 
    
    /**
     * 从VST获取对应产品下的所有商品
     * @return
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path(SearchClientPath.Path.PACKAGE_GOODS_INFO_SEARCH)
    public Response search(FitSdpGoodsRequest req) {
    	
    	logger.info("productId:【"+req.getProductId()+"】从vst获取商品信息数据！");
    	FitSdpGoodsDto vstPackageGoodsInfo = packageGoodsAdapter.getVstPackageGoodsInfo(req);
        try {
        	if(logger.isInfoEnabled()){
        		logger.info("从VST得到商品信息:" + JSONMapper.getInstance().writeValueAsString(vstPackageGoodsInfo));
        	}
        } catch (Exception e) {
            logger.error("转换JSON失败", e);
        }
        BaseSingleResultDto<FitSdpGoodsDto> resultDto = new BaseSingleResultDto<FitSdpGoodsDto>();
        resultDto.setResult(vstPackageGoodsInfo);
        return Response.ok(resultDto).build();
        
    }
}
