package com.lvmama.lvfit.adapter.service.resource;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.type.TypeReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lvmama.lvf.common.utils.JSONMapper;
import com.lvmama.lvfit.adapter.search.adapter.VstProductCalendarSearchAdapter;
import com.lvmama.lvfit.common.client.path.SearchClientPath;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpInstalmentDto;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpProductCalendarDto;
import com.lvmama.lvfit.common.dto.sdp.product.request.FitSdpProductGroupQueryRequest;
import com.lvmama.lvfit.common.dto.sdp.product.result.FitSdpGroupCalendarSearchResult;

@Component
@Path("")
public class FitSdpProductCalendarResource {
	
	private static final Logger logger = LoggerFactory.getLogger(FitSdpProductCalendarResource.class);
	
	
	@Autowired
	private VstProductCalendarSearchAdapter vstProductCalendarSearchAdapter;
	
	
	/**
	 * 调用主站接口查询低价日历信息
	 * @param fitProductGroupQueryRequest
	 * @return
	 */
	@POST
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path(SearchClientPath.Path.PRODUCT_GROUP_SEARCH)
	public Response findProdGroupDateByParam(FitSdpProductGroupQueryRequest fitProductGroupQueryRequest) {
		FitSdpGroupCalendarSearchResult<FitSdpProductCalendarDto> searchResult = vstProductCalendarSearchAdapter.findProdGroupDateByParam(fitProductGroupQueryRequest);
		return Response.ok(searchResult).build();
	}

	/**
	 * 调用主站接口查询分期价信息
	 * @param productId
	 * @param  categoryCode
	 * @return
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path(SearchClientPath.Path.PRODUCT_INSTALMENT_INFO_SEARCH)
	public Response getInstalmentInfo(@PathParam("productId")String productId, @PathParam("categoryCode")String categoryCode) {
		// 获取分期价格规则
		List<FitSdpInstalmentDto> instalmentInfo = vstProductCalendarSearchAdapter.getInstalmentInfo(productId, categoryCode);
		return Response.ok(instalmentInfo).build();
	}
}
