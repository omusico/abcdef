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

import com.lvmama.lvf.common.utils.JSONMapper;
import com.lvmama.lvfit.adapter.search.adapter.HotelServiceAdapter;
import com.lvmama.lvfit.common.client.path.SearchClientPath;
import com.lvmama.lvfit.common.dto.search.hotel.HotelQueryRequest;
import com.lvmama.lvfit.common.dto.search.hotel.HotelSearchResult;
import com.lvmama.lvfit.common.dto.search.hotel.result.HotelSearchHotelDto;



@Component
@Path("")
public class HotelResource {
	private static final Logger logger = LoggerFactory.getLogger(HotelResource.class);
	
	@Autowired
	private HotelServiceAdapter hotelServiceAdapter;
	
	/**
	 * 调用主站接口查询酒店数据
	 * @param productRequest
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path(SearchClientPath.Path.HOTEL_LIST_SEARCH)
	public Response searchHotel(HotelQueryRequest hotelQueryRequest) {
		try {
			if(logger.isInfoEnabled()){
				logger.info("spinach测试adapter hotelQueryRequest:"+JSONMapper.getInstance().writeValueAsString(hotelQueryRequest));
			}
			String paramStr = "U"+hotelQueryRequest.getCityDistrictId()+"C"+hotelQueryRequest.getDepartureDate().replace("-", "")+"O"+hotelQueryRequest.getReturnDate().replace("-", "");
			logger.info("spinach测试paramStr="+paramStr);
			//更换酒店时，选择的筛选、排序、分页等条件
			if(hotelQueryRequest.getParams()!=null){
				paramStr = paramStr + hotelQueryRequest.getParams();
			}
			//过滤预付酒店
			paramStr = paramStr + "A1";
			
			HotelSearchResult<HotelSearchHotelDto> searchHotel = hotelServiceAdapter.searchHotel(paramStr, hotelQueryRequest.getQueryId()==null?"1111111":hotelQueryRequest.getQueryId(), hotelQueryRequest.getKeywords(),hotelQueryRequest);
			return Response.ok(searchHotel).build();
		} catch (Exception e) {
			logger.error("调用查询酒店接口失败-------", e);
			throw new RuntimeException(e);
		}
	}
	
	/**
	 *
	 * 调用主站接口查询酒店主图url地址.
	 * @param
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path(SearchClientPath.Path.HOTEL_IMAGE_SEARCH)
	public Response searchHotelImage(HotelQueryRequest hotelQueryRequest) {
		try {
			logger.info("searchHotelImage:查询酒店主图片..."+hotelQueryRequest.getQueryId());
			String url = hotelServiceAdapter.findHotelImageUrl(Long.parseLong(hotelQueryRequest.getQueryId()));
			
			return Response.ok(url).build();
		} catch (Exception e) {
			logger.error("调用查询酒店图片失败-------", e);
			throw new RuntimeException(e);
		}
	}
	
}
