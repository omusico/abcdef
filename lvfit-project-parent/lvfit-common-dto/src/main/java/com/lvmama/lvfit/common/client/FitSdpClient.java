package com.lvmama.lvfit.common.client;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.lvmama.lvf.common.client.RestClient;
import com.lvmama.lvf.common.dto.BaseSingleResultDto;
import com.lvmama.lvf.common.exception.ExceptionCode;
import com.lvmama.lvf.common.exception.ExceptionWrapper;
import com.lvmama.lvf.common.trace.profile.Profile;
import com.lvmama.lvf.common.trace.profile.ProfilePoint;
import com.lvmama.lvf.common.utils.JSONMapper;
import com.lvmama.lvfit.common.cache.CacheBoxConvert;
import com.lvmama.lvfit.common.cache.CacheKey;
import com.lvmama.lvfit.common.cache.CachePoint;
import com.lvmama.lvfit.common.client.path.SdpClientPath;
import com.lvmama.lvfit.common.dto.enums.BizEnum;
import com.lvmama.lvfit.common.dto.order.FitOrderMainDto;
import com.lvmama.lvfit.common.dto.request.FitOrderBookingRequest;
import com.lvmama.lvfit.common.dto.sdp.calculator.FitSdpShoppingAmountDto;
import com.lvmama.lvfit.common.dto.sdp.calculator.request.FitSdpCalculateAmountDetailRequest;
import com.lvmama.lvfit.common.dto.sdp.calculator.request.FitSdpCalculateAmountRequest;
import com.lvmama.lvfit.common.dto.sdp.goods.FitSdpGoodsDto;
import com.lvmama.lvfit.common.dto.sdp.goods.FitSdpHotelComboGoodsDto;
import com.lvmama.lvfit.common.dto.sdp.goods.FitSdpHotelGroupDto;
import com.lvmama.lvfit.common.dto.sdp.goods.request.FitChangeFlightRequest;
import com.lvmama.lvfit.common.dto.sdp.goods.request.FitChangeHotelComboRequest;
import com.lvmama.lvfit.common.dto.sdp.goods.request.FitChangeHotelGroupRequest;
import com.lvmama.lvfit.common.dto.sdp.goods.request.FitSdpAppSearchFlightRequest;
import com.lvmama.lvfit.common.dto.sdp.goods.request.FitSdpGoodsRequest;
import com.lvmama.lvfit.common.dto.sdp.goods.request.FitSdpUpdShoppingRequest;
import com.lvmama.lvfit.common.dto.sdp.goods.request.FitSdpUpdateShoppingRequest;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpProductBasicInfoDto;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpProductCalendarDto;
import com.lvmama.lvfit.common.dto.sdp.product.request.FitSdpProductCalendarRequest;
import com.lvmama.lvfit.common.dto.sdp.product.result.FitSdpGroupCalendarSearchResult;
import com.lvmama.lvfit.common.dto.sdp.shopping.FitSdpShoppingDto;
import com.lvmama.lvfit.common.dto.search.flight.result.FlightSearchFlightInfoDto;
import com.lvmama.lvfit.common.dto.search.flight.result.MockUtil;

//import com.lvmama.lvfit.common.dto.request.FitRecordSearchRequest;

@Component
public class FitSdpClient {

	@Value("lvfit.sdp.baseurl")
	private String baseUrl;

	@Autowired
	private RestClient restClient;

	private static Logger logger = LoggerFactory.getLogger(FitSdpClient.class);

	/**
	 * 获取产品低价日历信息
	 * @param calendarRequest
	 * @return
	 */
    public FitSdpGroupCalendarSearchResult<FitSdpProductCalendarDto> searchProductLowPriceCalendar(FitSdpProductCalendarRequest calendarRequest) {
        SdpClientPath command = SdpClientPath.PRODUCT_CLENDAR_SEARCH;
        String url = command.url(baseUrl);
        try {
            ObjectMapper objectMapper = JSONMapper.getInstance();
            String jsonRequest = objectMapper.writeValueAsString(calendarRequest);
            String jsonResult = restClient.post(url, String.class, jsonRequest);
            if (StringUtils.isBlank(jsonResult)) {
                return new FitSdpGroupCalendarSearchResult<FitSdpProductCalendarDto>();
            }
            return objectMapper.readValue(jsonResult, new TypeReference<FitSdpGroupCalendarSearchResult<FitSdpProductCalendarDto>>() {});
        } catch (ExceptionWrapper ew) {
            logger.error(ew.getErrMessage(), ew);
            throw ew;
        } catch (Exception e) {
            ExceptionWrapper ew = new ExceptionWrapper();
            ew.setExceptionCode(ExceptionCode.REMOTE_INVOKE);
            ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url)
                    + ExceptionUtils.getFullStackTrace(e));
            logger.error(ew.getErrMessage(), ew);
            throw ew;
        }
    }
    
	/**
     * 获取被打包产品基本信息
     */
    public FitSdpProductBasicInfoDto searchProductBasicInfo(Long productId) {
        SdpClientPath command = SdpClientPath.PACKAGE_PRODUCT_BASIC_INFO_SEARCH;
        String url = command.url(baseUrl, productId);
        try {
            ObjectMapper objectMapper = JSONMapper.getInstance();
            String jsonResult = restClient.get(url, String.class);
            if (StringUtils.isBlank(jsonResult)) {
                return null;
            }
            return objectMapper.readValue(jsonResult, new TypeReference<FitSdpProductBasicInfoDto>() {});
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
     * 获取被打包产品基本信息
     */
    public FitSdpProductBasicInfoDto searchProductBasicInfoPreview(Long productId) {
        SdpClientPath command = SdpClientPath.PACKAGE_PRODUCT_BASIC_INFO_SEARCH_PREVIEW;
        String url = command.url(baseUrl, productId);
        try {
            ObjectMapper objectMapper = JSONMapper.getInstance();
            String jsonResult = restClient.get(url, String.class);
            if (StringUtils.isBlank(jsonResult)) {
                return null;
            }
            return objectMapper.readValue(jsonResult, new TypeReference<FitSdpProductBasicInfoDto>() {});
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
     * 仅仅获得产品的基本信息，不含有其余的附加产品信息.
     * @param productId
     * @return
     */
    public FitSdpProductBasicInfoDto searchProductInfoOnly(Long productId) {
        SdpClientPath command = SdpClientPath.PACKAGE_PRODUCT_INFO_ONLY_SEARCH;
        String url = command.url(baseUrl, productId);
        try {
            ObjectMapper objectMapper = JSONMapper.getInstance();
            String jsonResult = restClient.get(url, String.class);
            if (StringUtils.isBlank(jsonResult)) {
                return null;
            }
            return objectMapper.readValue(jsonResult, new TypeReference<FitSdpProductBasicInfoDto>() {});
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
     * 获取被打包产品商品信息
     */
    public FitSdpGoodsDto searchProductGoodsInfo(FitSdpGoodsRequest req) {
        SdpClientPath command = SdpClientPath.PACKAGE_GOODS_INFO_SEARCH;
        String url = command.url(baseUrl);
        try {
            ObjectMapper objectMapper = JSONMapper.getInstance();
            String jsonRequest = objectMapper.writeValueAsString(req);
            String jsonResult = restClient.post(url, String.class, jsonRequest);
            if (StringUtils.isBlank(jsonResult)) {
                return null;
            }
            return objectMapper.readValue(jsonResult, new TypeReference<FitSdpGoodsDto>() {});
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
	 * 计算购物车金额
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public BaseSingleResultDto<FitSdpShoppingAmountDto> calculateAmount(FitSdpCalculateAmountRequest request){
		SdpClientPath command = SdpClientPath.CALCULAT_SHOPPING_AMOUNT;
		String url = command.url(baseUrl);
		try {
		    String result = restClient.post(url, String.class, request);
			ObjectMapper objectMapper = JSONMapper.getInstance();
			return objectMapper.readValue(result, new TypeReference<BaseSingleResultDto<FitSdpShoppingAmountDto>>() {});
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
     * 更换酒店套餐
     * 
     * @param request
     * @return
     * @throws Exception
     */
    public List<FitSdpHotelComboGoodsDto> changeHotelCombo(FitChangeHotelComboRequest req) {
        SdpClientPath command = SdpClientPath.CHANGE_HOTEL_COMBO;
        String url = command.url(baseUrl);
        try {
            String result = restClient.post(url, String.class, req);
            ObjectMapper objectMapper = JSONMapper.getInstance();
            return objectMapper.readValue(result, new TypeReference<List<FitSdpHotelComboGoodsDto>>() {});
        } catch (ExceptionWrapper ew) {
            logger.error(ew.getErrMessage(), ew);
            throw ew;
        } catch (Exception e) {
            ExceptionWrapper ew = new ExceptionWrapper();
            ew.setExceptionCode(ExceptionCode.REMOTE_INVOKE);
            ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url)
                    + ExceptionUtils.getFullStackTrace(e));
            logger.error(ew.getErrMessage(), ew);
            throw ew;
        }
    }
    
    /**
     * 更换酒店.
     * @param req
     * @return
     */
    public List<FitSdpHotelGroupDto> changeHotelGroup(FitChangeHotelGroupRequest req) {
        SdpClientPath command = SdpClientPath.CHANGE_HOTEL_GROUP;
        String url = command.url(baseUrl);
        try {
            String result = restClient.post(url, String.class, req);
            ObjectMapper objectMapper = JSONMapper.getInstance();
            return objectMapper.readValue(result, new TypeReference<List<FitSdpHotelGroupDto>>() {});
        } catch (ExceptionWrapper ew) {
            logger.error(ew.getErrMessage(), ew);
            throw ew;
        } catch (Exception e) {
            ExceptionWrapper ew = new ExceptionWrapper();
            ew.setExceptionCode(ExceptionCode.REMOTE_INVOKE);
            ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url)
                    + ExceptionUtils.getFullStackTrace(e));
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
	public FitSdpShoppingDto getShoppingByUUID(String shoppingUUID){
		return MockUtil.morkShoppingDto();
//		SdpClientPath command = SdpClientPath.GET_SHOPPING_BY_UUID;
//		String url = StringUtils.EMPTY;
//		url = command.url(baseUrl);
//		try {
//			String result = restClient.post(url, String.class, shoppingUUID); 
//			if (StringUtils.isNotBlank(result)) {
//				ObjectMapper objectMapper = JSONMapper.getInstance();
//				FitSdpShoppingDto dto = objectMapper.readValue(result, new TypeReference<FitSdpShoppingDto>() {
//				});
//				return dto;
//			}else{
//				throw new ExceptionWrapper(ExceptionCode.GET_NO_CACHE_SHOPPING);
//			}
//		} catch (ExceptionWrapper ew) {
//			throw ew;
//		}catch (Exception e) {
//            ExceptionWrapper ew = new ExceptionWrapper();
//            ew.setExceptionCode(ExceptionCode.REMOTE_INVOKE);
//            ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url)
//                    + ExceptionUtils.getFullStackTrace(e));
//            logger.error(ew.getErrMessage(), ew);
//            throw ew;
//        }
	}
	
	/**
     * 更换酒店套餐
     * 
     * @param request
     * @return
     * @throws Exception
     */
    public List<FlightSearchFlightInfoDto> changeFlight(FitChangeFlightRequest req) {
        SdpClientPath command = SdpClientPath.CHANGE_FLIGHT;
        String url = command.url(baseUrl);
        try {
            String result = restClient.post(url, String.class, req);
            ObjectMapper objectMapper = JSONMapper.getInstance();
            return objectMapper.readValue(result, new TypeReference<List<FlightSearchFlightInfoDto>>() {});
        } catch (ExceptionWrapper ew) {
            logger.error(ew.getErrMessage(), ew);
            throw ew;
        } catch (Exception e) {
            ExceptionWrapper ew = new ExceptionWrapper();
            ew.setExceptionCode(ExceptionCode.REMOTE_INVOKE);
            ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url)
                    + ExceptionUtils.getFullStackTrace(e));
            logger.error(ew.getErrMessage(), ew);
            throw ew;
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
		
		SdpClientPath command = SdpClientPath.BOOKING;
        String url = command.url(baseUrl);
		try {
			String result = restClient.post(SdpClientPath.BOOKING.url(baseUrl), String.class, fitOrderBookingRequest);
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
	 * APP下单
	 * 
	 * @param fitOrderBookingRequest
	 * @return
	 */
	@ProfilePoint(Profile.FIT_BOOKING)
	public BaseSingleResultDto<FitOrderMainDto> bookingByDetail(FitOrderBookingRequest fitOrderBookingRequest){
		
		SdpClientPath command = SdpClientPath.BOOKING_BY_DETAIL;
        String url = command.url(baseUrl);
		try {
			String result = restClient.post(SdpClientPath.BOOKING_BY_DETAIL.url(baseUrl), String.class,fitOrderBookingRequest);
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
     * 保存选择的商品信息
     */
    public Boolean saveGoodsToCache(FitSdpUpdShoppingRequest req){
        
        SdpClientPath command = SdpClientPath.SAVE_GOODS_TO_CACHE;
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
     * APP保存选择的商品信息
     */
    public Boolean saveShoppingToCache(FitSdpUpdateShoppingRequest req){
        
        SdpClientPath command = SdpClientPath.APP_UPDATE_GOODS_TO_CACHE;
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
     * 获取合同
     * @param req
     * @return
     */
    public BaseSingleResultDto<String> getContracts(FitOrderBookingRequest req) {
        SdpClientPath command = SdpClientPath.CONTRACTS;
        String url = command.url(baseUrl);
        try {
            String result = restClient.post(url, String.class, req);
            ObjectMapper objectMapper = JSONMapper.getInstance();
            return objectMapper.readValue(result, new TypeReference<BaseSingleResultDto<String>>() {});
        } catch (ExceptionWrapper ew) {
            logger.error(ew.getErrMessage(), ew);
            throw ew;
        } catch (Exception e) {
            ExceptionWrapper ew = new ExceptionWrapper();
            ew.setExceptionCode(ExceptionCode.REMOTE_INVOKE);
            ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url)
                    + ExceptionUtils.getFullStackTrace(e));
            logger.error(ew.getErrMessage(), ew);
            throw ew;
        }
    }


     /**
      * 根据产品Id获取低价日历信息
      * @param productId
      * @return
      */
    public Map<Long, BigDecimal> searchCalendarInfoByProductId(Long productId) {
    	 SdpClientPath command = SdpClientPath.SEARCH_CALENDAR_INFO_BY_PRODUCT_ID;
         String url = command.url(baseUrl, productId);
         try {
             ObjectMapper objectMapper = JSONMapper.getInstance();
             String jsonResult = restClient.get(url, String.class);
             if (StringUtils.isBlank(jsonResult)) {
                 return null;
             }
             return objectMapper.readValue(jsonResult, new TypeReference<Map<Long, BigDecimal>>() {});
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
     * 获取去返程可选航班列表信息
     */
    public Map<String,List<FlightSearchFlightInfoDto>>  searchFlightInfo(FitSdpAppSearchFlightRequest req) {
    	SdpClientPath command = SdpClientPath.TRAFFIC_FLIGHTS_SEARCH;
        String url = command.url(baseUrl);
        try {
            ObjectMapper objectMapper = JSONMapper.getInstance();
            String jsonRequest = objectMapper.writeValueAsString(req);
            String jsonResult = restClient.post(url, String.class, jsonRequest);
            if (StringUtils.isBlank(jsonResult)) {
                return null;
            }
            return objectMapper.readValue(jsonResult, new TypeReference<Map<String,List<FlightSearchFlightInfoDto>>>() {});
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
	 * 根据明细计算商品总金额(总价)
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public BaseSingleResultDto<FitSdpShoppingAmountDto> calculateAmountByDetail(FitSdpCalculateAmountDetailRequest request){
		SdpClientPath command = SdpClientPath.CALCULAT_SHOPPING_AMOUNT_BY_DETAIL;
		String url = command.url(baseUrl);
		try {
		    String result = restClient.post(url, String.class, request);
			ObjectMapper objectMapper = JSONMapper.getInstance();
			return objectMapper.readValue(result, new TypeReference<BaseSingleResultDto<FitSdpShoppingAmountDto>>() {});
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
     * 获取产品底部信息
     * @return
     */
    @CachePoint(value = CacheBoxConvert.String, cacheExpireTimeKey = "lvfit.product.cacheTime")
    public String getBottomInfo(@CacheKey Long productId, Long bizCategoryId) {
        String url = "http://dujia.lvmama.com/freetour/" + productId;
        if ((BizEnum.BIZ_CATEGORY_TYPE.category_route_group.getCategoryId()).equals(bizCategoryId)) {
            url = "http://dujia.lvmama.com/group/" + productId;
        } else if ((BizEnum.BIZ_CATEGORY_TYPE.category_route_freedom.getCategoryId()).equals(bizCategoryId)) {
            url = "http://dujia.lvmama.com/freetour/" + productId;
        }
        url += "/preview?isOldUrl=Y";
        return restClient.get(url, String.class);
    }

    /**
     * 获取产品底部信息
     * @return
     */
    @CachePoint(value = CacheBoxConvert.String, cacheExpireTimeKey = "lvfit.product.cacheTime", isCacheEnable = false)
    public String getBottomInfoAndUpdCache(@CacheKey Long productId, Long bizCategoryId) {
        return this.getBottomInfo(productId, bizCategoryId);
    }
}
