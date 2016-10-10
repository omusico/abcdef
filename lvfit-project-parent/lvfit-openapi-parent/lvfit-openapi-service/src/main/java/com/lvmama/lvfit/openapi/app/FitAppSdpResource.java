package com.lvmama.lvfit.openapi.app;

import java.util.List;

import com.lvmama.lvf.common.dto.BaseSingleResultDto;
import com.lvmama.lvf.common.dto.enums.InterfaceKey;
import com.lvmama.lvf.common.dto.status.ResultStatus;
import com.lvmama.lvf.common.exception.ExceptionWrapper;
import com.lvmama.lvf.common.exception.FitExceptionCode;
import com.lvmama.lvfit.common.aspect.suppinterface.SuppInterfacePoint;
import com.lvmama.lvfit.common.client.path.SdpAppClientPath;
import com.lvmama.lvfit.common.dto.app.FitAppBookingRequest;
import com.lvmama.lvfit.common.dto.app.FitAppOrderDto;
import com.lvmama.lvfit.common.dto.app.FitAppGoodsDto;
import com.lvmama.lvfit.common.dto.app.FitAppSdpCityDepartInfo;
import com.lvmama.lvfit.common.dto.app.FitAppSdpCityStartDistrict;
import com.lvmama.lvfit.common.dto.app.FitAppShoppingRequest;
import com.lvmama.lvfit.common.dto.sdp.calculator.FitSdpShoppingAmountDto;
import com.lvmama.lvfit.common.dto.sdp.goods.request.FitSdpGoodsRequest;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpProductCalendarDto;
import com.lvmama.lvfit.common.dto.sdp.product.request.FitSdpProductCalendarRequest;
import com.lvmama.lvfit.common.dto.sdp.product.result.FitSdpGroupCalendarSearchResult;
import com.lvmama.lvfit.openapi.app.booking.FitAppDpBookingService;
import com.lvmama.lvfit.openapi.app.booking.FitAppSdpBookingService;
import com.lvmama.lvfit.openapi.app.calculate.FitAppSdpCalculateService;
import com.lvmama.lvfit.openapi.app.search.FitAppSdpSearchService;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Component
@Path("")
public class FitAppSdpResource {

	private static final Logger logger = LoggerFactory.getLogger(FitAppDpBookingService.class);
	
	@Autowired
	private FitAppSdpCalculateService fitAppSdpCalculateService;

	@Autowired
	private FitAppSdpSearchService fitAppSdpSearchService;

	@Autowired
	private FitAppSdpBookingService fitAppSdpBookingService;


	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path(SdpAppClientPath.Path.APP_PRODUCT_CLENDAR_SEARCH)
	@SuppInterfacePoint(InterfaceKey.APP_FIT_SDP_SEARCHCALENDARINFO)
	public Response searchCalendarInfo(FitSdpProductCalendarRequest calendarRequest){

		FitSdpGroupCalendarSearchResult<FitSdpProductCalendarDto> searchResult = null;
		ResultStatus resultStatus = ResultStatus.SUCCESS;
		String errMsg = null;
		try {
			searchResult = fitAppSdpSearchService.searchCalendarInfo(calendarRequest);
		} catch (Exception e) {
			resultStatus = ResultStatus.FAIL;
			if(e instanceof ExceptionWrapper){
				ExceptionWrapper ew = (ExceptionWrapper)e;
				errMsg = ew.getErrMessage();
			}else{
				errMsg = ExceptionUtils.getFullStackTrace(e);
			}
		}
		BaseSingleResultDto<FitSdpGroupCalendarSearchResult<FitSdpProductCalendarDto>> resultDto = new BaseSingleResultDto<FitSdpGroupCalendarSearchResult<FitSdpProductCalendarDto>>(searchResult);
		resultDto.setStatus(resultStatus);
		resultDto.setMessage(errMsg);
		return Response.ok(resultDto).build();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path(SdpAppClientPath.Path.APP_GOODS_INFO_SEARCH)
	@SuppInterfacePoint(InterfaceKey.APP_FIT_SDP_GETGOODSINFO)
	public Response getGoodsInfo(FitSdpGoodsRequest goodsRequest) {
		
		String shoppingUuid = null;
		if (StringUtils.isBlank(goodsRequest.getShoppingUuid())){
			throw new ExceptionWrapper(FitExceptionCode.APP_NO_SHOPPING_UUID);
		}
		if(null==goodsRequest.getBookingSource()){
			throw new ExceptionWrapper(FitExceptionCode.APP_NO_BOOKING_SOURCE);
		}
		FitAppGoodsDto fitAppSdpGoodsDto = null;
		ResultStatus resultStatus = ResultStatus.SUCCESS;
		String errMsg = null;
		try {
			fitAppSdpGoodsDto = fitAppSdpSearchService.searchGoodsInfo(goodsRequest);
			fitAppSdpGoodsDto.setShoppingUuid(shoppingUuid);
		} catch (Exception e) {
			resultStatus = ResultStatus.FAIL;
			if(e instanceof ExceptionWrapper){
				ExceptionWrapper ew = (ExceptionWrapper)e;
				errMsg = ew.getErrMessage();
			}else{
				errMsg = ExceptionUtils.getFullStackTrace(e);
			}
		}
		BaseSingleResultDto<FitAppGoodsDto> resultDto = new BaseSingleResultDto<FitAppGoodsDto>(fitAppSdpGoodsDto);
		resultDto.setStatus(resultStatus);
		resultDto.setMessage(errMsg);
		return Response.ok(resultDto).build();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path(SdpAppClientPath.Path.APP_CALCULAT_AMOUNT)
	@SuppInterfacePoint(InterfaceKey.APP_FIT_SDP_CALCULATAMOUNT)
	public Response calculatAmount(FitAppShoppingRequest request) {

		if (StringUtils.isBlank(request.getShoppingUuid())){
			throw new ExceptionWrapper(FitExceptionCode.APP_NO_SHOPPING_UUID);
		}
		if(null==request.getBookingSource()){
			throw new ExceptionWrapper(FitExceptionCode.APP_NO_BOOKING_SOURCE);
		}
		BaseSingleResultDto<FitSdpShoppingAmountDto> shoppingAmountRestlt = new BaseSingleResultDto<FitSdpShoppingAmountDto>();
		ResultStatus resultStatus = ResultStatus.SUCCESS;
		String errMsg = null;
		try {
			shoppingAmountRestlt = fitAppSdpCalculateService.calculateAmount(request);
		} catch (Exception e) {
			resultStatus = ResultStatus.FAIL;
			if(e instanceof ExceptionWrapper){
				ExceptionWrapper ew = (ExceptionWrapper)e;
				errMsg = ew.getErrMessage();
			}else{
				errMsg = ExceptionUtils.getFullStackTrace(e);
			}
		}
		BaseSingleResultDto<FitSdpShoppingAmountDto> resultDto = new BaseSingleResultDto<FitSdpShoppingAmountDto>(shoppingAmountRestlt.getResult());
		resultDto.setStatus(resultStatus);
		resultDto.setMessage(errMsg);
		return Response.ok(resultDto).build();
	}
	

     @POST
	 @Consumes(MediaType.APPLICATION_JSON)
	 @Produces(MediaType.APPLICATION_JSON)
	 @Path(SdpAppClientPath.Path.APP_BOOKING)
	 @SuppInterfacePoint(InterfaceKey.APP_FIT_SDP_BOOKING)
	 public Response booking(FitAppBookingRequest appBookingRequest) {

	    if (StringUtils.isBlank(appBookingRequest.getAppShoppingRequest().getShoppingUuid())){
		     throw new ExceptionWrapper(FitExceptionCode.APP_NO_SHOPPING_UUID);
	    }
	    if(null==appBookingRequest.getAppShoppingRequest().getBookingSource()){
			throw new ExceptionWrapper(FitExceptionCode.APP_NO_BOOKING_SOURCE);
		}
    	FitAppOrderDto appOrderDto = null;
		ResultStatus resultStatus = ResultStatus.SUCCESS;
		String errMsg = null;
		try {
			appOrderDto = fitAppSdpBookingService.booking(appBookingRequest);
		} catch (Exception e) {
			logger.error("app.booking.error:",e);
			resultStatus = ResultStatus.FAIL;
			if(e instanceof ExceptionWrapper){
				ExceptionWrapper ew = (ExceptionWrapper)e;
				errMsg = ew.getErrMessage();
			}else{
				errMsg = ExceptionUtils.getFullStackTrace(e);
			}
		}
		BaseSingleResultDto<FitAppOrderDto> resultDto = new BaseSingleResultDto<FitAppOrderDto>(appOrderDto);
		resultDto.setStatus(resultStatus);
		resultDto.setMessage(errMsg);
		return Response.ok(resultDto).build();
	 }
     
     @POST
     @GET
	 @Consumes(MediaType.APPLICATION_JSON)
	 @Produces(MediaType.APPLICATION_JSON)
	 @Path(SdpAppClientPath.Path.APP_PRODUCT_DEPARTCITY_GROUP_INFO)
	 public Response getSelectedDepartCityGroupInfo(@PathParam("productId")Long productId) {
	 		ResultStatus resultStatus = ResultStatus.SUCCESS;
	 		String errMsg = null;
	 		List<FitAppSdpCityStartDistrict> cityDepartInfoList = null;
	 		try {
	 			cityDepartInfoList = fitAppSdpSearchService.searchSdpCityDepartInfo(productId);
	 		} catch (Exception e) {
	 			logger.error("app.booking.error:",e);
	 			resultStatus = ResultStatus.FAIL;
	 			if(e instanceof ExceptionWrapper){
	 				ExceptionWrapper ew = (ExceptionWrapper)e;
	 				errMsg = ew.getErrMessage();
	 			}else{
	 				errMsg = ExceptionUtils.getFullStackTrace(e);
	 			}
	 		}
	
	 		BaseSingleResultDto<List<FitAppSdpCityStartDistrict>> resultDto = new BaseSingleResultDto<List<FitAppSdpCityStartDistrict>>(cityDepartInfoList);
	 		resultDto.setStatus(resultStatus);
	 		resultDto.setMessage(errMsg);
	 		return Response.ok(resultDto).build();
	 }

}
