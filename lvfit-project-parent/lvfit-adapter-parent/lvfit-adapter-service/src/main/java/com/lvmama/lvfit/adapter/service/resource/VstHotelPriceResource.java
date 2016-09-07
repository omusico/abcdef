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

import com.lvmama.lvfit.adapter.vst.service.HotelPriceService;
import com.lvmama.lvfit.common.client.path.VstClientPath;
import com.lvmama.lvfit.common.dto.hotel.FitHotelTimePrice;
import com.lvmama.lvfit.common.dto.request.FitHotelPriceRequest;

/**
 * ClassName:VstHotelPriceResource <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Date:     2015-12-15 下午8:20:05 <br/>
 * @author   zengzhimin
 * @version  
 * @since    JDK 1.6
 * @see 	 
 */
@Component
@Path("")
public class VstHotelPriceResource {
	private static final Logger logger = LoggerFactory.getLogger(VstHotelPriceResource.class);
	
	@Autowired
	private HotelPriceService hotelPriceService;	
	
	/**
	 * VST查询酒店价格
	 * @param findTimePriceBySpecDate
	 * @return
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path(VstClientPath.Path.QUERY_VST_GOODS_PRICE_LIST)
	public Response findTimePriceBySpecDate(FitHotelPriceRequest request) {
		FitHotelTimePrice fitHotelTimePrice = null;
		try {
			fitHotelTimePrice = hotelPriceService.findTimePriceBySpecDate(request);
		} catch (Exception e) {
			logger.error("查询酒店价格异常：", e);
			throw new RuntimeException(e);
		}
		return Response.ok(fitHotelTimePrice).build();
	}

}
