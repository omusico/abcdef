package com.lvmama.lvfit.common.client;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.lvmama.lvfit.common.dto.sdp.goods.FitSdpInsuranceDto;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpInstalmentDto;
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
import com.lvmama.lvfit.common.client.path.SearchClientPath;
import com.lvmama.lvfit.common.dto.enums.JudgeType;
import com.lvmama.lvfit.common.dto.recommend.FitRecommendInfo;
import com.lvmama.lvfit.common.dto.request.FitOrderBookingRequest;
import com.lvmama.lvfit.common.dto.sdp.goods.FitSdpGoodsDto;
import com.lvmama.lvfit.common.dto.sdp.goods.request.FitSdpGoodsRequest;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpProductBasicInfoDto;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpProductCalendarDto;
import com.lvmama.lvfit.common.dto.sdp.product.request.FitSdpProductGroupQueryRequest;
import com.lvmama.lvfit.common.dto.sdp.product.result.FitSdpGroupCalendarSearchResult;
import com.lvmama.lvfit.common.dto.search.hotel.HotelQueryRequest;
import com.lvmama.lvfit.common.dto.search.hotel.HotelSearchResult;
import com.lvmama.lvfit.common.dto.search.hotel.result.HotelSearchHotelDto;
import com.lvmama.lvfit.common.dto.search.insurance.InsuranceQueryRequest;
import com.lvmama.lvfit.common.dto.search.insurance.InsuranceSearchResult;
import com.lvmama.lvfit.common.dto.search.insurance.result.InsuranceDto;
import com.lvmama.lvfit.common.dto.search.spot.SpotQueryRequest;
import com.lvmama.lvfit.common.dto.search.spot.SpotSearchResult;
import com.lvmama.lvfit.common.dto.search.spot.result.SpotSearchSpotDto;

@Component
public class FitSearchClient {
	
	@Value("lvfit.adapter.baseurl")
	private String adapterbaseurl;
	
	@Autowired
	private RestClient restClient;
	
	private static Logger logger = LoggerFactory.getLogger(FitSearchClient.class);
	
	
	/**
     * 查询酒店
     * @param hotelQueryRequest
     * @param sessionID
     * @param keywords
     * @return
     */
	@ProfilePoint(Profile.FIT_SELECT_HOTEL_FROM_VST)
    public HotelSearchResult<HotelSearchHotelDto> searchHotel(HotelQueryRequest hotelQueryRequest,String sessionID){
    	SearchClientPath command = SearchClientPath.HOTEL_LIST_SEARCH;
    	String url = command.url(adapterbaseurl);
		try {
			ObjectMapper objectMapper = JSONMapper.getInstance();
			String jsonRequest = objectMapper.writeValueAsString(hotelQueryRequest);
			String jsonResult = restClient.post(url, String.class, jsonRequest);
			return objectMapper.readValue(jsonResult, new TypeReference<HotelSearchResult<HotelSearchHotelDto>>() {});
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
	 * 查询酒店图片
	 * @param hotelQueryRequest
	 * @param sessionID
	 * @return
	 */
    public String searchHotelImage(HotelQueryRequest hotelQueryRequest,String sessionID){
    	SearchClientPath command = SearchClientPath.HOTEL_IMAGE_SEARCH;
    	String url = command.url(adapterbaseurl);
		try {
			ObjectMapper objectMapper = JSONMapper.getInstance();
			String jsonRequest = objectMapper.writeValueAsString(hotelQueryRequest);
			String jsonResult = restClient.post(url, String.class, jsonRequest);
			System.out.println("searchHotelImage==="+jsonResult);
			return jsonResult;
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
     * 查询景点
     * @param spotQueryRequest
     * @return
     */
	@ProfilePoint(Profile.FIT_SELECT_SPOT_FROM_VST)
    public SpotSearchResult<SpotSearchSpotDto> searchSpot(SpotQueryRequest spotQueryRequest){
    	SearchClientPath command = SearchClientPath.SPOT_LIST_SEARCH;
    	String url = command.url(adapterbaseurl);
		try {
			ObjectMapper objectMapper = JSONMapper.getInstance();
			String jsonRequest = objectMapper.writeValueAsString(spotQueryRequest);
			String jsonResult = restClient.post(url, String.class, jsonRequest);
			if (StringUtils.isBlank(jsonResult)) {
			    return new SpotSearchResult<SpotSearchSpotDto>();
			}
			return objectMapper.readValue(jsonResult, new TypeReference<SpotSearchResult<SpotSearchSpotDto>>() {});
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
	 *  获得VST动态打包保险相关信息
	 * @author wanghuihui
	 * @date:2016年3月22日 下午5:50:13
	 * @param insuranceQueryRequest
	 * @return
	 */
	public List<InsuranceDto> searchInsuranceFromVst(InsuranceQueryRequest insuranceQueryRequest) {
		SearchClientPath command = SearchClientPath.INSURANCE_INFO_SEARCH;
    	String url = command.url(adapterbaseurl);
		try {
			ObjectMapper objectMapper = JSONMapper.getInstance();
			String jsonRequest = objectMapper.writeValueAsString(insuranceQueryRequest);
			String jsonResult = restClient.post(url, String.class, jsonRequest);
			if (StringUtils.isBlank(jsonResult)) {
			    return new ArrayList<InsuranceDto>();
			}
			return objectMapper.readValue(jsonResult, new TypeReference<List<InsuranceDto>>() {});
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
	 * 获取被打包产品价格日历
	 * @param fitProductGroupQueryRequest
	 * @return
	 */
	public FitSdpGroupCalendarSearchResult<FitSdpProductCalendarDto> searchProductGroupFromVst(FitSdpProductGroupQueryRequest fitProductGroupQueryRequest) {
		SearchClientPath command = SearchClientPath.PRODUCT_GROUP_SEARCH;
    	String url = command.url(adapterbaseurl);
		try {
			ObjectMapper objectMapper = JSONMapper.getInstance();
			String jsonRequest = objectMapper.writeValueAsString(fitProductGroupQueryRequest);
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
			ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url) + ExceptionUtils.getFullStackTrace(e));
			logger.error(ew.getErrMessage(), ew);
			throw ew;
		}
	}
    
	/**
     * 获取被打包产品基本信息
     */
    public FitSdpProductBasicInfoDto searchProductBasicInfo(Long productId) {
        SearchClientPath command = SearchClientPath.PACKAGE_PRODUCT_BASIC_INFO_SEARCH;
        String url = command.url(adapterbaseurl, productId);
        try {
            ObjectMapper objectMapper = JSONMapper.getInstance();
            String jsonResult = restClient.post(url, String.class);
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
     * 仅仅获取被打包产品基本信息，不含城市信息，附加信息等等.
     */
    public FitSdpProductBasicInfoDto searchProductInfoOnly(Long productId) {
        SearchClientPath command = SearchClientPath.PACKAGE_PRODUCT_INFO_ONLY_SEARCH;
        String url = command.url(adapterbaseurl, productId);
        try {
            ObjectMapper objectMapper = JSONMapper.getInstance();
            String jsonResult = restClient.post(url, String.class);
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
    public BaseSingleResultDto<FitSdpGoodsDto> searchProductGoodsInfo(FitSdpGoodsRequest req) {
        SearchClientPath command = SearchClientPath.PACKAGE_GOODS_INFO_SEARCH;
        String url = command.url(adapterbaseurl);
        try {
            ObjectMapper objectMapper = JSONMapper.getInstance();
            String jsonRequest = objectMapper.writeValueAsString(req);
            String jsonResult = restClient.post(url, String.class, jsonRequest);
            return objectMapper.readValue(jsonResult, new TypeReference<BaseSingleResultDto<FitSdpGoodsDto>>() {});
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
     * 获取合同
     */
    public BaseSingleResultDto<String> getContracts(FitOrderBookingRequest req) {
        SearchClientPath command = SearchClientPath.CONTRACTS;
        String url = command.url(adapterbaseurl);
        try {
            ObjectMapper objectMapper = JSONMapper.getInstance();
            String jsonRequest = objectMapper.writeValueAsString(req);
            String jsonResult = restClient.post(url, String.class, jsonRequest);
            if (StringUtils.isBlank(jsonResult)) {
                return null;
            }
            return objectMapper.readValue(jsonResult, new TypeReference<BaseSingleResultDto<String>>() {});
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
     * 获取频道页推荐信息
     */
    public Map<String, List<FitRecommendInfo>> getRecommendInfo(Long fromPlaceId) {
        SearchClientPath command = SearchClientPath.RECOMMEND_INFO_SEARCH;
        String url = command.url(adapterbaseurl, fromPlaceId);
        try {
            ObjectMapper objectMapper = JSONMapper.getInstance();
            String jsonResult = restClient.post(url, String.class);
            if (StringUtils.isBlank(jsonResult)) {
                return null;
            }
            return objectMapper.readValue(jsonResult, new TypeReference<Map<String, List<FitRecommendInfo>>>() {});
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
     * 获取打包产品属性
     */
    public JudgeType searchProductProp(Long productId) {
        SearchClientPath command = SearchClientPath.PACKAGE_PRODUCT_PROP_SEARCH;
        String url = command.url(adapterbaseurl, productId);
        try {
            JudgeType judgeType = restClient.post(url, JudgeType.class);
            return judgeType;
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
     * 获取打包产品属性
     */
    public List<FitSdpInstalmentDto> getInstalmentInfo(String productId, String categoryCode) {
        SearchClientPath command = SearchClientPath.PRODUCT_INSTALMENT_INFO_SEARCH;
        String url = command.url(adapterbaseurl, productId, categoryCode);
        try {
            String jsonStr = restClient.post(url, String.class);
            if (StringUtils.isBlank(jsonStr)) {
                return null;
            }
            return JSONMapper.getInstance().readValue(jsonStr, new TypeReference<List<FitSdpInstalmentDto>>() {});
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
}
