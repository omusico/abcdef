package com.lvmama.lvfit.common.client;

import com.lvmama.lvf.common.client.RestClient;
import com.lvmama.lvf.common.dto.BaseQueryDto;
import com.lvmama.lvf.common.dto.BaseResponseDto;
import com.lvmama.lvf.common.dto.BaseSingleResultDto;
import com.lvmama.lvf.common.exception.ExceptionCode;
import com.lvmama.lvf.common.exception.ExceptionWrapper;
import com.lvmama.lvf.common.trace.profile.Profile;
import com.lvmama.lvf.common.trace.profile.ProfilePoint;
import com.lvmama.lvf.common.utils.JSONMapper;
import com.lvmama.lvfit.common.cache.CacheKey;
import com.lvmama.lvfit.common.client.path.DpClientPath;
import com.lvmama.lvfit.common.dto.app.FitAppFlightRequest;
import com.lvmama.lvfit.common.dto.app.FitAppHotelRequest;
import com.lvmama.lvfit.common.dto.calculator.request.CalculateAmountDetailRequest;
import com.lvmama.lvfit.common.dto.hotel.FitCommentDto;
import com.lvmama.lvfit.common.dto.hotel.FitConRecomHotelDto;
import com.lvmama.lvfit.common.dto.hotel.FitHotelDto;
import com.lvmama.lvfit.common.dto.order.FitOrderMainDto;
import com.lvmama.lvfit.common.dto.request.CalculateAmountRequest;
import com.lvmama.lvfit.common.dto.request.ChangeFlightRequest;
import com.lvmama.lvfit.common.dto.request.ChangeHotelRequest;
import com.lvmama.lvfit.common.dto.request.FitCommentRequest;
import com.lvmama.lvfit.common.dto.request.FitDpUpdateShoppingRequest;
import com.lvmama.lvfit.common.dto.request.FitHotelRequest;
import com.lvmama.lvfit.common.dto.request.FitOrderBookingRequest;
import com.lvmama.lvfit.common.dto.request.FitRecordSearchRequest;
import com.lvmama.lvfit.common.dto.request.FitShoppingFliInsRequest;
import com.lvmama.lvfit.common.dto.request.FitShoppingInsuranceRequest;
import com.lvmama.lvfit.common.dto.request.FitShoppingTicketRequest;
import com.lvmama.lvfit.common.dto.search.FitRecordSearchIndex;
import com.lvmama.lvfit.common.dto.search.FitSearchRequest;
import com.lvmama.lvfit.common.dto.search.FitSearchResult;
import com.lvmama.lvfit.common.dto.search.flight.FlightSearchResult;
import com.lvmama.lvfit.common.dto.search.flight.result.FlightSearchFlightInfoDto;
import com.lvmama.lvfit.common.dto.search.hotel.HotelSearchResult;
import com.lvmama.lvfit.common.dto.search.hotel.result.HotelSearchHotelDto;
import com.lvmama.lvfit.common.dto.shopping.FitShoppingAmountDto;
import com.lvmama.lvfit.common.dto.shopping.FitShoppingDto;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.Map;

//import com.lvmama.lvfit.common.dto.request.FitRecordSearchRequest;

@Component
public class FitDpClient {

	@Value("lvfit.dp.baseurl")
	private String baseUrl;

	@Autowired
	private RestClient restClient;

	private static Logger logger = LoggerFactory.getLogger(FitDpClient.class);

	/**
	 * 获取航班及机票信息
	 * 
	 * @param request
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@ProfilePoint(Profile.FIT_SELECT_FLIGHT_AND_HOTEL)
	public String getFlightAndHotel(@CacheKey FitSearchRequest request){

		// 1、根据useAggregate设置不同的Url
		DpClientPath command = DpClientPath.GET_FLIGHT_AND_HOTEL;
		String url = StringUtils.EMPTY;
		url = command.url(baseUrl);

		// 2、调用航班搜索
		try {
			String result = restClient.post(url, String.class, request);
			if (StringUtils.isNotBlank(result)) {
				return result;
			}
			return null;
		} catch (ExceptionWrapper ew) {
			throw ew;
		}
	}

	public FitShoppingDto getShoppingResult(@CacheKey FitSearchRequest request) {

		
		DpClientPath command = DpClientPath.GET_SHOPPING_RESULT;
		String url = StringUtils.EMPTY;
		url = command.url(baseUrl);

		try {
			String result = restClient.post(url, String.class, request);
			if (StringUtils.isNotBlank(result)) {
				ObjectMapper objectMapper = JSONMapper.getInstance();
				FitShoppingDto dto;
				try {
					dto = objectMapper.readValue(result, new TypeReference<FitShoppingDto>() {
					});
					return dto;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return null;
		} catch (ExceptionWrapper ew) {
			if(ew.getExceptionCode().equals(ExceptionCode.UNDEF_REMOTE_INVOKE)
			  ||ew.getExceptionCode().equals(ExceptionCode.REMOTE_INVOKE)){
				throw new ExceptionWrapper(ExceptionCode.UNDEF_ERROR);
			}
			throw ew;
		}
	}
	
	/**
	 * 点评查询
	 * 
	 * @throws IOException
	 * @throws JsonMappingException
	 * @throws JsonParseException
	 * 
	 * **/

	public FitCommentDto getCommentPage(FitCommentRequest request) throws JsonParseException, JsonMappingException, IOException {
		DpClientPath command = DpClientPath.QUERY_COMMENT_PAGE;
		String url = StringUtils.EMPTY;
		url = command.url(baseUrl);
		try {
			String result = restClient.post(url, String.class, request);
			if (StringUtils.isNotBlank(result)) {
				ObjectMapper objectMapper = JSONMapper.getInstance();
				FitCommentDto dto = objectMapper.readValue(result, new TypeReference<FitCommentDto>() {
				});
				return dto;
			}
			return null;
		} catch (ExceptionWrapper ew) {
			logger.error("调用点评信息异常" + url);
			throw ew;
		}

	}

	/**
	 * 订单详情
	 * 
	 * @author wanghuihui
	 * @date:2015年12月16日 上午10:31:54
	 * @param request
	 * @return
	 */
	public FitHotelDto getHotelDetail(FitHotelRequest request) throws JsonParseException, JsonMappingException, IOException {
		DpClientPath command = DpClientPath.GET_HOTEL_DETAIL;
		String url = StringUtils.EMPTY;
		url = command.url(baseUrl);
		try {
			String result = restClient.post(url, String.class, request);
			if (StringUtils.isNotBlank(result)) {
				ObjectMapper objectMapper = JSONMapper.getInstance();
				FitHotelDto dto = objectMapper.readValue(result, new TypeReference<FitHotelDto>() {
				});
				return dto;
			}
			return null;
		} catch (ExceptionWrapper ew) {
			logger.error("调用酒店详情信息异常" + url);
			throw ew;
		}

	}

	/**
	 * 获取酒店列表信息
	 * 
	 * @param request
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public FitSearchResult queryHotels(FitSearchRequest request) throws Exception {

		FitSearchResult fitSearchResult = new FitSearchResult();

		DpClientPath command = DpClientPath.GET_HOTEL_LIST;
		String url = StringUtils.EMPTY;
		url = command.url(baseUrl);

		try {
			String result = restClient.post(url, String.class, request);
			if (StringUtils.isNotBlank(result)) {
				ObjectMapper objectMapper = JSONMapper.getInstance();
				FitSearchResult fitsearchResult = objectMapper.readValue(result, new TypeReference<FitSearchResult>() {
				});
				fitSearchResult.setHotelSearchResult(fitsearchResult.getHotelSearchResult());
				return fitSearchResult;
			}
		} catch (ExceptionWrapper ew) {
			throw ew;
		}
		return null;
	}
	
	/**
	 * 获取酒店列表信息fromCache
	 * @return
	 * @throws Exception
	 */
	public List<HotelSearchHotelDto> getHotelsFromCache(String uuid) throws Exception {

		DpClientPath command = DpClientPath.GET_HOTEL_LIST_CACHE;
		String url = StringUtils.EMPTY;
		url = command.url(baseUrl);

		try {
			String result = restClient.post(url, String.class,uuid);
			if (StringUtils.isNotBlank(result)) {
				ObjectMapper objectMapper = JSONMapper.getInstance();
				List<HotelSearchHotelDto> hotels = objectMapper.readValue(result, new TypeReference<List<HotelSearchHotelDto>>() {
				});
				return hotels;
			}
		} catch (ExceptionWrapper ew) {
			throw ew;
		}
		return null;
	}

	/**
	 * 获取航班列表信息
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public FitSearchResult queryFlights(String uuid,String method) throws Exception {

		DpClientPath command = DpClientPath.GET_FLIGHT_LIST;
		String url = StringUtils.EMPTY;
		url = command.url(baseUrl,uuid,method);
		try {
			FitSearchResult result = restClient.get(url,FitSearchResult.class);
			return result;
		} catch (ExceptionWrapper ew) {
			throw ew;
		}

	}
	
	
	
	/**
	 * 获取往返航班列表信息
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public FitSearchResult queryToBackFlights(FitSearchRequest request) throws Exception {

		DpClientPath command = DpClientPath.GET_FLIGHT_LIST_TO_BACK;
		String url = StringUtils.EMPTY;
		url = command.url(baseUrl);

		try {
			String result = restClient.post(url, String.class, request);
			if (StringUtils.isNotBlank(result)) {
				ObjectMapper objectMapper = JSONMapper.getInstance();
				FitSearchResult fitsearchResult = objectMapper.readValue(result, new TypeReference<FitSearchResult>() {
				});

				return fitsearchResult;
			}
			return null;
		} catch (ExceptionWrapper ew) {
			throw ew;
		}

	}
	
	/**
	 * 获取航班列表信息
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public FitSearchResult getFlightsFromCache(String uuid) throws Exception {

		DpClientPath command = DpClientPath.GET_FLIGHT_LIST_CACHE;
		String url = StringUtils.EMPTY;
		url = command.url(baseUrl);

		try {
			FitSearchResult result = restClient.post(url, FitSearchResult.class,uuid);
			return result;
		} catch (ExceptionWrapper ew) {
			throw ew;
		}

	}

	/**
	 * 更换机票刷新缓存
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public BaseSingleResultDto<FitShoppingDto> changeFlight(ChangeFlightRequest request) {

		DpClientPath command = DpClientPath.CHANGE_SHOPPING_FLIGHT;
		String url = command.url(baseUrl);
		try {
		    String result = restClient.post(url, String.class, request);
			ObjectMapper objectMapper = JSONMapper.getInstance();
			return  objectMapper.readValue(result, new TypeReference<BaseSingleResultDto<FitShoppingDto>>() {
			});
		}catch (ExceptionWrapper ew) {
			throw ew;
		}catch (Exception e) {
			ExceptionWrapper ew = new ExceptionWrapper();
			ew.setExceptionCode(ExceptionCode.REMOTE_INVOKE);
			ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url) + ExceptionUtils.getFullStackTrace(e));
			logger.error(ew.getErrMessage(), ew);
			throw ew;
		}

	}

	/**
	 * 更换刷新缓存
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public BaseSingleResultDto<FitShoppingDto> changeHotel(ChangeHotelRequest request){

		DpClientPath command = DpClientPath.CHANGE_SHOPPING_HOTEL;
		String url = StringUtils.EMPTY;
		url = command.url(baseUrl);
		try {
		    String result = restClient.post(url, String.class, request);
			ObjectMapper objectMapper = JSONMapper.getInstance();
			return  objectMapper.readValue(result, new TypeReference<BaseSingleResultDto<FitShoppingDto>>() {
			});
		}catch (ExceptionWrapper ew) {
			throw ew;
		}catch (Exception e) {
			ExceptionWrapper ew = new ExceptionWrapper();
			ew.setExceptionCode(ExceptionCode.REMOTE_INVOKE);
			ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url) + ExceptionUtils.getFullStackTrace(e));
			logger.error(ew.getErrMessage(), ew);
			throw ew;
		}
	}

	/**
	 * 拼装预定填写页信息
	 * 
	 * @param fitOrderBookingRequest
	 */
	public FitOrderBookingRequest toBooking(FitOrderBookingRequest fitOrderBookingRequest) throws Exception {
		try {
			String result = restClient.post(DpClientPath.TO_BOOKING.url(baseUrl), String.class, fitOrderBookingRequest);
			ObjectMapper objectMapper = JSONMapper.getInstance();
			return objectMapper.readValue(result, new TypeReference<FitOrderBookingRequest>() {
			});
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * 下单
	 * 
	 * @param fitOrderBookingRequest
	 * @return
	 */
	@ProfilePoint(Profile.FIT_BOOKING)
	public BaseSingleResultDto<FitOrderMainDto> booking(FitOrderBookingRequest fitOrderBookingRequest){
		
		DpClientPath command = DpClientPath.BOOKING;
        String url = command.url(baseUrl);
		try {
			String result = restClient.post(DpClientPath.BOOKING.url(baseUrl), String.class, fitOrderBookingRequest);
			ObjectMapper objectMapper = JSONMapper.getInstance();
			return objectMapper.readValue(result, new TypeReference<BaseSingleResultDto<FitOrderMainDto>>() {
			});
		} catch (ExceptionWrapper ew) {
			throw ew;
		}catch (Exception e) {
			ExceptionWrapper ew = new ExceptionWrapper();
			ew.setExceptionCode(ExceptionCode.REMOTE_INVOKE);
			ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url) + ExceptionUtils.getFullStackTrace(e));
			logger.error(ew.getErrMessage(), ew);
			throw ew;
		}
	}

	/**
	 * 根据shoppingUUID加载购物车缓存
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public BaseSingleResultDto<FitShoppingDto> getShoppingByUUID(String shoppingUUID){

		DpClientPath command = DpClientPath.GET_SHOPPING_BY_UUID;
		String url = StringUtils.EMPTY;
		url = command.url(baseUrl);
		try {
			String result = restClient.post(url, String.class, shoppingUUID);
			if (StringUtils.isNotBlank(result)) {
				ObjectMapper objectMapper = JSONMapper.getInstance();
				BaseSingleResultDto<FitShoppingDto> dto = objectMapper.readValue(result, new TypeReference<BaseSingleResultDto<FitShoppingDto>>() {
				});
				return dto;
			}else{
				throw new ExceptionWrapper(ExceptionCode.GET_NO_CACHE_SHOPPING);
			}
		} catch (ExceptionWrapper ew) {
			throw ew;
		}catch (Exception e) {
			ExceptionWrapper ew = new ExceptionWrapper();
			ew.setExceptionCode(ExceptionCode.REMOTE_INVOKE);
			ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url) + ExceptionUtils.getFullStackTrace(e));
			logger.error(ew.getErrMessage(), ew);
			throw ew;
		}
	}

	/**
	 * 计算购物车金额
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@ProfilePoint(Profile.FIT_CALCULAT_SHOPPING_AMOUNT)
	public BaseSingleResultDto<FitShoppingAmountDto> calculateAmount(CalculateAmountRequest request){
		DpClientPath command = DpClientPath.CALCULAT_SHOPPING_AMOUNT;
		String url = command.url(baseUrl);
		try {
		    String result = restClient.post(url, String.class, request);
			ObjectMapper objectMapper = JSONMapper.getInstance();
			return objectMapper.readValue(result, new TypeReference<BaseSingleResultDto<FitShoppingAmountDto>>() {});
		}catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(), ew);
			throw ew;
		} catch (Exception e) {
			ExceptionWrapper ew = new ExceptionWrapper();
			ew.setExceptionCode(ExceptionCode.REMOTE_INVOKE);
			ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url) + ExceptionUtils.getFullStackTrace(e));
			logger.error(ew.getErrMessage(), ew);
			throw ew;
		}
	}
	
	/**
	 * APP计算购物车金额
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@ProfilePoint(Profile.FIT_CALCULAT_SHOPPING_AMOUNT)
	public BaseSingleResultDto<FitShoppingAmountDto> calculateAmountByDetail(CalculateAmountDetailRequest request){
		DpClientPath command = DpClientPath.CALCULAT_SHOPPING_AMOUNT_BY_DETAIL;
		String url = command.url(baseUrl);
		try {
		    String result = restClient.post(url, String.class, request);
			ObjectMapper objectMapper = JSONMapper.getInstance();
			return objectMapper.readValue(result, new TypeReference<BaseSingleResultDto<FitShoppingAmountDto>>() {});
		}catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(), ew);
			throw ew;
		} catch (Exception e) {
			ExceptionWrapper ew = new ExceptionWrapper();
			ew.setExceptionCode(ExceptionCode.REMOTE_INVOKE);
			ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url) + ExceptionUtils.getFullStackTrace(e));
			logger.error(ew.getErrMessage(), ew);
			throw ew;
		}
	}
	/**
	
	/**
	 * 重新load购物车信息
	 * @param shoppingUUID
	 * @return
	 * @throws Exception
	 */
	public BaseSingleResultDto putShoppingInfo(
			String shoppingUUID) throws Exception {
		
		DpClientPath command = DpClientPath.REDUCTION_SHOPPINGINFO;
		String url = StringUtils.EMPTY;
		url = command.url(baseUrl);
		try {
			String result = restClient.post(url, String.class, shoppingUUID);
			if (StringUtils.isNotBlank(result)) {
				ObjectMapper objectMapper = JSONMapper.getInstance();
				BaseSingleResultDto dto = objectMapper.readValue(result, new TypeReference<BaseSingleResultDto>() {
				});
				return dto;
			}
			return null;
		} catch (ExceptionWrapper ew) {
			throw ew;
		}
	}
	
	
	
	/**
	 * 根据shoppingUUID加载购物车缓存
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public BaseSingleResultDto<FitSearchRequest> getShoppingRequestByShoppingUUID(String shoppingUUID){

		DpClientPath command = DpClientPath.REDUCTION_SEARCH_REQUEST;
		String url = StringUtils.EMPTY;
		url = command.url(baseUrl);
		try {
			String result = restClient.post(url, String.class, shoppingUUID);
			if (StringUtils.isNotBlank(result)) {
				ObjectMapper objectMapper = JSONMapper.getInstance();
				BaseSingleResultDto<FitSearchRequest> request = objectMapper.readValue(result, new TypeReference<BaseSingleResultDto<FitSearchRequest>>() {
				});
				return request;
			}
			return null;
		}catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(), ew);
			throw ew;
		} catch (Exception e) {
			ExceptionWrapper ew = new ExceptionWrapper();
			ew.setExceptionCode(ExceptionCode.REMOTE_INVOKE);
			ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url) + ExceptionUtils.getFullStackTrace(e));
			logger.error(ew.getErrMessage(), ew);
			throw ew;
		}
	}
	
	
	/**
	 * 根据shoppingUUID加载购物车缓存，第一次加载不到，调用查询接口，再次查询
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public BaseSingleResultDto<FitShoppingDto> reGetShoppingByShoppingUUID(String shoppingUUID){

		DpClientPath command = DpClientPath.RE_GET_SHOPPING_BY_UUID;
		String url = StringUtils.EMPTY;
		url = command.url(baseUrl);
		try {
			String result = restClient.post(url, String.class, shoppingUUID);
			if (StringUtils.isNotBlank(result)) {
				ObjectMapper objectMapper = JSONMapper.getInstance();
				BaseSingleResultDto<FitShoppingDto> dto;
				try {
					dto = objectMapper.readValue(result, new TypeReference<BaseSingleResultDto<FitShoppingDto>>() {
					});
					return dto;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return null;
		} catch (ExceptionWrapper ew) {
			throw ew;
		}
	}
	
	/**
	 * 需要城市id获取推荐酒店
	 * @param districtId
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public List<FitConRecomHotelDto> getRecommendHotelsByDistrictId(Long districtId) throws JsonParseException, JsonMappingException, IOException{
		DpClientPath command = DpClientPath.GET_RECOM_HOTEL_BY_DISTRICT_ID;
		String url = command.url(baseUrl);
		try{
			String jsonStr = restClient.post(url, String.class, districtId);
			if(StringUtils.isNotBlank(jsonStr)){
				return JSONMapper.getInstance().readValue(jsonStr, new TypeReference<List<FitConRecomHotelDto>>() {});
			}
			return null;
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(), ew);
			throw ew;
		}
	}
	
    /**
     * 查询机票查询记录
     * @param baseQueryDto
     * @return
     * @throws IOException 
     * @throws JsonMappingException 
     * @throws JsonGenerationException 
     */
    public BaseResponseDto<FitRecordSearchIndex> queryFitSearchRecord(BaseQueryDto<FitRecordSearchRequest> baseQueryDto) {
        DpClientPath command = DpClientPath.SEARCH_FIT_RECORD_FROM_SOLR;
        String url = command.url(baseUrl);
        try{
            ObjectMapper objectMapper = JSONMapper.getInstance();
            String jsonRequest = objectMapper.writeValueAsString(baseQueryDto);
            String jsonResult = restClient.post(url, String.class, jsonRequest);
            return objectMapper.readValue(jsonResult, new TypeReference<BaseResponseDto<FitRecordSearchIndex>>(){});
        } catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(), ew);
			throw ew;
		} catch (Exception e) {
			ExceptionWrapper ew = new ExceptionWrapper();
			ew.setExceptionCode(ExceptionCode.REMOTE_INVOKE);
			ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url) + ExceptionUtils.getFullStackTrace(e));
			logger.error(ew.getErrMessage(), ew);
			throw ew;
		}
    }
    /**
     * 更新缓存中的门票信息
     * @param req
     */
    public Boolean updSelectedTicketInfo(FitShoppingTicketRequest req) {
        DpClientPath command = DpClientPath.UPD_SELECT_TICKET_INFO;
        String url = command.url(baseUrl);
        try{
            return restClient.post(url, Boolean.class, req);
        } catch (ExceptionWrapper ew) {
            logger.error(ew.getErrMessage(), ew);
            throw ew;
        } catch (Exception e) {
            ExceptionWrapper ew = new ExceptionWrapper();
            ew.setExceptionCode(ExceptionCode.REMOTE_INVOKE);
            ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url) + ExceptionUtils.getFullStackTrace(e));
            logger.error(ew.getErrMessage(), ew);
            throw ew;
        }
    }
    
    /**
     * 记录点击预订下一步按钮时点击数
     * @param req
     */
    public void recordBookingLogNoLogin(String shopingUUID) {
        DpClientPath command = DpClientPath.RECORD_BOOKING_LOG_NO_LOGIN;
        String url = command.url(baseUrl);
        try{
            restClient.post(url, String.class, shopingUUID);
        } catch (ExceptionWrapper ew) {
            logger.error(ew.getErrMessage(), ew);
            throw ew;
        } catch (Exception e) {
            ExceptionWrapper ew = new ExceptionWrapper();
            ew.setExceptionCode(ExceptionCode.REMOTE_INVOKE);
            ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url) + ExceptionUtils.getFullStackTrace(e));
            logger.error(ew.getErrMessage(), ew);
            throw ew;
        }
    }
    
    /**
     *  保险信息更新缓存
     * @author wanghuihui
     * @date:2016年3月28日 下午5:49:09
     * @param req
     */
	public Boolean updSelectedInsuranceInfo(FitShoppingInsuranceRequest req) {
		DpClientPath command = DpClientPath.UPD_SELECT_INSURANCE_INFO;
        String url = command.url(baseUrl);
        try{
            return restClient.post(url, Boolean.class, req);
        } catch (ExceptionWrapper ew) {
            logger.error(ew.getErrMessage(), ew);
            throw ew;
        } catch (Exception e) {
            ExceptionWrapper ew = new ExceptionWrapper();
            ew.setExceptionCode(ExceptionCode.REMOTE_INVOKE);
            ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url) + ExceptionUtils.getFullStackTrace(e));
            logger.error(ew.getErrMessage(), ew);
            throw ew;
        }
	}
	
	/**
     *  保险信息更新缓存
     * @author wanghuihui
     * @date:2016年3月28日 下午5:49:09
     * @param req
     */
    public Boolean updSelectedFliInsInfo(FitShoppingFliInsRequest req) {
        DpClientPath command = DpClientPath.UPD_SELECT_FLI_INS_INFO;
        String url = command.url(baseUrl);
        try{
            return restClient.post(url, Boolean.class, req);
        } catch (ExceptionWrapper ew) {
            logger.error(ew.getErrMessage(), ew);
            throw ew;
        } catch (Exception e) {
            ExceptionWrapper ew = new ExceptionWrapper();
            ew.setExceptionCode(ExceptionCode.REMOTE_INVOKE);
            ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url) + ExceptionUtils.getFullStackTrace(e));
            logger.error(ew.getErrMessage(), ew);
            throw ew;
        }
    }
    
    public Map<String,Object> getHotelCondition(String shoppingUUID) throws JsonParseException, JsonMappingException, IOException{
		DpClientPath command = DpClientPath.HOTEL_CONDITION;
		String url = command.url(baseUrl);
		try{
			String jsonStr = restClient.post(url, String.class, shoppingUUID);
			if(StringUtils.isNotBlank(jsonStr)){
				return JSONMapper.getInstance().readValue(jsonStr, new TypeReference<Map<String,Object>>() {});
			}
			return null;
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(), ew);
			throw ew;
		}
	}
    
    /**
     * APP保存选择的商品信息
     */
    public Boolean saveShoppingToCache(FitDpUpdateShoppingRequest req){
        
        DpClientPath command = DpClientPath.APP_UPDATE_GOODS_TO_CACHE;
        String url = command.url(baseUrl);
        try {
            String result = restClient.post(url, String.class, req);
            ObjectMapper objectMapper = JSONMapper.getInstance();
            return objectMapper.readValue(result, Boolean.class);
        } catch (ExceptionWrapper ew) {
            throw ew;
        }catch (Exception e) {
            ExceptionWrapper ew = new ExceptionWrapper();
            ew.setExceptionCode(ExceptionCode.REMOTE_INVOKE);
            ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url) + ExceptionUtils.getFullStackTrace(e));
            logger.error(ew.getErrMessage(), ew);
            throw ew;
        }
    }

	/**
	 * 获取航班信息
	 *
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public Map<String, FlightSearchResult<FlightSearchFlightInfoDto>> getAllFlightInfos(FitAppFlightRequest request) throws Exception {

		DpClientPath command = DpClientPath.GET_FLIGHT_INFOS;
		String url;
		url = command.url(baseUrl);

		try {
			String result = restClient.post(url, String.class, request);
			if (StringUtils.isNotBlank(result)) {
				ObjectMapper objectMapper = JSONMapper.getInstance();
				Map<String, FlightSearchResult<FlightSearchFlightInfoDto>> fitsearchResult = objectMapper.readValue(result,
					new TypeReference<Map<String, FlightSearchResult<FlightSearchFlightInfoDto>>>() {});
				return fitsearchResult;
			}
			return null;
		} catch (ExceptionWrapper ew) {
			throw ew;
		}

	}

	/**
	 * 获取酒店列表信息
	 */
	public HotelSearchResult<HotelSearchHotelDto> getHotelInfos(FitAppHotelRequest request) throws Exception {
		DpClientPath command = DpClientPath.GET_HOTEL_INFOS;
		String url;
		url = command.url(baseUrl);

		try {
			String result = restClient.post(url, String.class, request);
			if (StringUtils.isNotBlank(result)) {
				ObjectMapper objectMapper = JSONMapper.getInstance();
				HotelSearchResult<HotelSearchHotelDto> hotelResult = objectMapper.readValue(result, new TypeReference<HotelSearchResult<HotelSearchHotelDto>>() {});
				return hotelResult;
			}
		} catch (ExceptionWrapper ew) {
			throw ew;
		}
		return null;
	}
}
