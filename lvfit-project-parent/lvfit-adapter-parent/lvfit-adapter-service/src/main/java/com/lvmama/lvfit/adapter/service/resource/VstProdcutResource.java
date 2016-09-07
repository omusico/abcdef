/**
 * Project Name:lvfit-adapter-service
 * File Name:VstProdcutResource.java
 * Package Name:com.lvmama.lvfit.adapter.service.resource
 * Date:2015-11-26下午2:47:56
 * Copyright (c) 2015, www.lvmama.com All Rights Reserved.
 *
*/

package com.lvmama.lvfit.adapter.service.resource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
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

import com.lvmama.lvf.common.dto.BaseResultDto;
import com.lvmama.lvf.common.dto.Pagination;
import com.lvmama.lvfit.adapter.vst.adapter.CommentStatServiceAdapter;
import com.lvmama.lvfit.adapter.vst.adapter.ProductServiceAdapter;
import com.lvmama.lvfit.adapter.vst.service.HotelDetailService;
import com.lvmama.lvfit.common.client.path.VstClientPath;
import com.lvmama.lvfit.common.dto.hotel.FitHotelDto;
import com.lvmama.lvfit.common.dto.request.FitHotelRequest;
import com.lvmama.lvfit.common.dto.vst.VstProduct;

/**
 * ClassName:VstProdcutResource <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Date:     2015-11-26 下午2:47:56 <br/>
 * @author   liuweiguo
 * @version  
 * @since    JDK 1.6
 * @see 	 
 */
@Component
@Path("")
public class VstProdcutResource {
	private static final Logger logger = LoggerFactory.getLogger(VstProdcutResource.class);
	@Autowired
	ProductServiceAdapter productServiceAdapter;
	@Autowired
	private CommentStatServiceAdapter commentStatServiceAdapter;
	@Autowired
	private HotelDetailService hotelDetailService;
	/**
	 * 
	 * getVstGoodsDetail:查询商品详情. <br/>
	 *
	 * @author liuweiguo
	 * @param goodsRequest
	 * @return
	 * @since JDK 1.6
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path(VstClientPath.Path.GET_VST_PRODUCT_DETAIL)
	public Response getVstProductDetail(FitHotelRequest request) {
		try {
			FitHotelDto product = hotelDetailService.getHotelDetailByHotelId(request);
			return Response.ok(product).build();
		} catch (Exception e) {
			logger.error("查询商品详情失败-------", e);
		}
		return null;
	}
	
	/**
	 * 
	 * queryVstGoodsList:查询商品列表. <br/>
	 *
	 * @author liuweiguo
	 * @param productId
	 * @return
	 * @since JDK 1.6
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path(VstClientPath.Path.QUERY_VST_PRODUCT_LIST)
	public Response queryVstProdcutList(@PathParam("productId") Long productId) {
		try {
			Map<String,Object> params = new HashMap<String,Object>();
			params.put("productId", productId);
			List<VstProduct> list = productServiceAdapter.queryHotelProdProductList(params);
			Integer count = list.size();
			BaseResultDto<VstProduct> baseResult =new BaseResultDto<VstProduct>();
			Pagination pagination = new Pagination();
			baseResult.setResults(list);
			pagination.setRecords(count);
			pagination.countRecords(count);
			baseResult.setPagination(pagination);
			return Response.ok(baseResult).build();
			
		} catch (Exception e) {
			logger.error("查询商品列表失败-------", e);
		}
		return null;
	}
}

