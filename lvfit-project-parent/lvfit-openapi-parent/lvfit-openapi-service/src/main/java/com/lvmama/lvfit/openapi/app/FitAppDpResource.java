package com.lvmama.lvfit.openapi.app;

import com.lvmama.lvf.common.dto.BaseSingleResultDto;
import com.lvmama.lvf.common.dto.enums.InterfaceKey;
import com.lvmama.lvf.common.dto.status.ResultStatus;
import com.lvmama.lvf.common.exception.ExceptionWrapper;
import com.lvmama.lvf.common.exception.FitExceptionCode;
import com.lvmama.lvfit.common.aspect.suppinterface.SuppInterfacePoint;
import com.lvmama.lvfit.common.client.path.DpAppClientPath;
import com.lvmama.lvfit.common.dto.app.*;
import com.lvmama.lvfit.common.dto.search.flight.FlightSearchResult;
import com.lvmama.lvfit.common.dto.search.flight.result.FlightSearchFlightInfoDto;
import com.lvmama.lvfit.common.dto.search.hotel.HotelSearchResult;
import com.lvmama.lvfit.common.dto.search.hotel.result.HotelSearchHotelDto;
import com.lvmama.lvfit.common.dto.shopping.FitShoppingAmountDto;
import com.lvmama.lvfit.openapi.app.booking.FitAppDpBookingService;
import com.lvmama.lvfit.openapi.app.calculate.FitAppDpCalculateService;
import com.lvmama.lvfit.openapi.app.search.FitAppDpSearchService;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Map;

@Component
@Path("")
public class FitAppDpResource {

	private static final Logger logger = LoggerFactory.getLogger(FitAppDpResource.class);

	@Autowired
	private FitAppDpCalculateService fitAppDpCalculateService;

	@Autowired
	private FitAppDpBookingService fitAppDpBookingService;

	@Autowired
	private FitAppDpSearchService fitAppDpSearchService;



	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path(DpAppClientPath.Path.APP_SEARCH_FLIGHT_CITY_INFO)
	@SuppInterfacePoint(InterfaceKey.APP_FIT_SEARCHFLIGHTCITYINFO)
	public Response searchFlightCityInfo(FitAppShoppingRequest request) {

		if(null==request.getBookingSource()){
			throw new ExceptionWrapper(FitExceptionCode.APP_NO_BOOKING_SOURCE);
		}
		FitAppFlightCityDto fitAppFlightCityDto = null;
		ResultStatus resultStatus = ResultStatus.SUCCESS;
		String errMsg = null;
		try {
			fitAppFlightCityDto = fitAppDpSearchService.searchFlightCityInfo();
		} catch (Exception e) {
			resultStatus = ResultStatus.FAIL;
			if(e instanceof ExceptionWrapper){
				ExceptionWrapper ew = (ExceptionWrapper)e;
				errMsg = ew.getErrMessage();
			}else{
				errMsg = ExceptionUtils.getFullStackTrace(e);
			}
		}
		BaseSingleResultDto<FitAppFlightCityDto> resultDto = new BaseSingleResultDto<FitAppFlightCityDto>(fitAppFlightCityDto);
		resultDto.setStatus(resultStatus);
		resultDto.setMessage(errMsg);
		return Response.ok(resultDto).build();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path(DpAppClientPath.Path.APP_SEARCH_GOODS_INFO)
	@SuppInterfacePoint(InterfaceKey.APP_FIT_SEARCHGOODSINFO)
	public Response searchGoodsInfo(FitAppSearchRequest request) {

		FitAppGoodsDto fitAppGoodsDto = null;
		ResultStatus resultStatus = ResultStatus.SUCCESS;
		String errMsg = null;
		try {
			fitAppGoodsDto = fitAppDpSearchService.searchGoodsInfo(request);
		} catch (Exception e) {
			resultStatus = ResultStatus.FAIL;
			if(e instanceof ExceptionWrapper){
				ExceptionWrapper ew = (ExceptionWrapper)e;
				errMsg = ew.getErrMessage();
			}else{
				errMsg = ExceptionUtils.getFullStackTrace(e);
			}
		}
		BaseSingleResultDto<FitAppGoodsDto> resultDto = new BaseSingleResultDto<FitAppGoodsDto>(fitAppGoodsDto);
		resultDto.setStatus(resultStatus);
		resultDto.setMessage(errMsg);
		return Response.ok(resultDto).build();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path(DpAppClientPath.Path.APP_CHANGE_FLIGHT_INFO)
	@SuppInterfacePoint(InterfaceKey.APP_FIT_CHANGEFLIGHTINFO)
	public Response changeFlightInfo(FitAppFlightRequest request) {

		if(null==request.getBookingSource()){
			throw new ExceptionWrapper(FitExceptionCode.APP_NO_BOOKING_SOURCE);
		}
		Map<String,FlightSearchResult<FlightSearchFlightInfoDto>> searchResultMap = null;
		ResultStatus resultStatus = ResultStatus.SUCCESS;
		String errMsg = null;
		try {
			searchResultMap = fitAppDpSearchService.getAllFlightInfos(request);
		} catch (Exception e) {
			resultStatus = ResultStatus.FAIL;
			if(e instanceof ExceptionWrapper){
				ExceptionWrapper ew = (ExceptionWrapper)e;
				errMsg = ew.getErrMessage();
			}else{
				errMsg = ExceptionUtils.getFullStackTrace(e);
			}
		}
		BaseSingleResultDto<Map<String,FlightSearchResult<FlightSearchFlightInfoDto>>> resultDto = new BaseSingleResultDto<Map<String,FlightSearchResult<FlightSearchFlightInfoDto>>>(searchResultMap);
		resultDto.setStatus(resultStatus);
		resultDto.setMessage(errMsg);
		return Response.ok(resultDto).build();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path(DpAppClientPath.Path.APP_CHANGE_HOTEL_INFO)
	@SuppInterfacePoint(InterfaceKey.APP_FIT_CHANGEHOTELINFO)
	public Response changeHotelInfo(FitAppHotelRequest request) {
		HotelSearchResult<HotelSearchHotelDto> searchResult = null;
		ResultStatus resultStatus = ResultStatus.SUCCESS;
		String errMsg = null;
		try {
			searchResult = fitAppDpSearchService.changeHotelInfo(request);
		} catch (Exception e) {
			resultStatus = ResultStatus.FAIL;
			if(e instanceof ExceptionWrapper){
				ExceptionWrapper ew = (ExceptionWrapper)e;
				errMsg = ew.getErrMessage();
			}else{
				errMsg = ExceptionUtils.getFullStackTrace(e);
			}
		}
		BaseSingleResultDto<HotelSearchResult<HotelSearchHotelDto>> resultDto = new BaseSingleResultDto<HotelSearchResult<HotelSearchHotelDto>>(searchResult);
		resultDto.setStatus(resultStatus);
		resultDto.setMessage(errMsg);
		return Response.ok(resultDto).build();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path(DpAppClientPath.Path.APP_CALCULAT_AMOUNT)
	@SuppInterfacePoint(InterfaceKey.APP_FIT_CALCULATAMOUNT)
	public Response calculatAmount(FitAppShoppingRequest request) {

		if (StringUtils.isBlank(request.getShoppingUuid())){
			throw new ExceptionWrapper(FitExceptionCode.APP_NO_SHOPPING_UUID);
		}
		if(null==request.getBookingSource()){
			throw new ExceptionWrapper(FitExceptionCode.APP_NO_BOOKING_SOURCE);
		}
		BaseSingleResultDto<FitShoppingAmountDto> shoppingAmountRestlt = new BaseSingleResultDto<FitShoppingAmountDto>();
		ResultStatus resultStatus = ResultStatus.SUCCESS;
		String errMsg = null;
		try {
			shoppingAmountRestlt = fitAppDpCalculateService.calculateAmount(request);
		} catch (Exception e) {
			resultStatus = ResultStatus.FAIL;
			if(e instanceof ExceptionWrapper){
				ExceptionWrapper ew = (ExceptionWrapper)e;
				errMsg = ew.getErrMessage();
			}else{
				errMsg = ExceptionUtils.getFullStackTrace(e);
			}
		}
		BaseSingleResultDto<FitShoppingAmountDto> resultDto = new BaseSingleResultDto<FitShoppingAmountDto>(shoppingAmountRestlt.getResult());
		resultDto.setStatus(resultStatus);
		resultDto.setMessage(errMsg);
		return Response.ok(resultDto).build();
	}


	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path(DpAppClientPath.Path.APP_BOOKING)
	@SuppInterfacePoint(InterfaceKey.APP_FIT_BOOKING)
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
			appOrderDto = fitAppDpBookingService.booking(appBookingRequest);
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

}
