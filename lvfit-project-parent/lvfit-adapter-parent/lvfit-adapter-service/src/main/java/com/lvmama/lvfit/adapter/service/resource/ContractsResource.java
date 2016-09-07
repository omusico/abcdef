package com.lvmama.lvfit.adapter.service.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lvmama.lvf.common.dto.BaseSingleResultDto;
import com.lvmama.lvf.common.utils.JSONMapper;
import com.lvmama.lvfit.adapter.search.adapter.ContractsSearchAdapter;
import com.lvmama.lvfit.common.client.path.SearchClientPath;
import com.lvmama.lvfit.common.dto.request.FitOrderBookingRequest;
import com.lvmama.lvfit.common.dto.search.hotel.HotelSearchResult;
import com.lvmama.lvfit.common.dto.search.hotel.result.HotelSearchHotelDto;



@Component
@Path("")
public class ContractsResource {
	private static final Logger logger = LoggerFactory.getLogger(ContractsResource.class);
	
	@Autowired
	private ContractsSearchAdapter contractsSearchAdapter;
	
	/**
	 * 调用主站接口查询合同
	 * @param productRequest
	 * @return
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path(SearchClientPath.Path.CONTRACTS)
	public Response getContracts(FitOrderBookingRequest bookingRequest) {
		try {
			BaseSingleResultDto<String> contractHtml = new BaseSingleResultDto<String>();
			contractHtml = contractsSearchAdapter.getContractHtml(bookingRequest);
			return Response.ok(contractHtml).build();
		} catch (Exception e) {
			logger.error("调用查询合同接口失败-------", e);
			throw new RuntimeException(e);
		}
	}
	
}
