package com.lvmama.lvfit.common.client;

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
import com.lvmama.lvfit.common.client.path.SdpAppClientPath;
import com.lvmama.lvfit.common.dto.order.FitOrderMainDto;
import com.lvmama.lvfit.common.dto.request.FitOrderBookingRequest;
import com.lvmama.lvfit.common.dto.app.FitAppGoodsDto;
import com.lvmama.lvfit.common.dto.app.FitAppShoppingRequest;
import com.lvmama.lvfit.common.dto.sdp.calculator.FitSdpShoppingAmountDto;
import com.lvmama.lvfit.common.dto.sdp.goods.request.FitSdpGoodsRequest;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpProductCalendarDto;
import com.lvmama.lvfit.common.dto.sdp.product.request.FitSdpProductCalendarRequest;
import com.lvmama.lvfit.common.dto.sdp.product.result.FitSdpGroupCalendarSearchResult;

@Component
public class FitSdpAppClient {
	@Value("lvfit.openapi.baseurl")
	private String baseUrl;

	@Autowired
	private RestClient restClient;
	
	private static Logger logger = LoggerFactory.getLogger(FitSdpAppClient.class);
	
	/**
	 * 获取产品低价日历信息
	 * @param fitSdpProductGroupQueryRequest
	 * @return
	 */
    public FitSdpGroupCalendarSearchResult<FitSdpProductCalendarDto> searchProductLowPriceCalendar(FitSdpProductCalendarRequest calendarRequest) {
    	SdpAppClientPath command = SdpAppClientPath.APP_PRODUCT_CLENDAR_SEARCH;
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
     * 获取被打包产品商品信息
     */
    public FitAppGoodsDto searchProductGoodsInfo(FitSdpGoodsRequest req) {
    	SdpAppClientPath command = SdpAppClientPath.APP_GOODS_INFO_SEARCH;
        String url = command.url(baseUrl);
        try {
            ObjectMapper objectMapper = JSONMapper.getInstance();
            String jsonRequest = objectMapper.writeValueAsString(req);
            String jsonResult = restClient.post(url, String.class, jsonRequest);
            if (StringUtils.isBlank(jsonResult)) {
                return null;
            }
            return objectMapper.readValue(jsonResult, new TypeReference<FitAppGoodsDto>() {});
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
	 * 计算商品总金额(总价)
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public BaseSingleResultDto<FitSdpShoppingAmountDto> calculateAmount(FitAppShoppingRequest request){
		SdpAppClientPath command = SdpAppClientPath.APP_CALCULAT_AMOUNT;
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
	 * 下单
	 * 
	 * @param fitOrderBookingRequest
	 * @return
	 */
	@ProfilePoint(Profile.FIT_BOOKING)
	public BaseSingleResultDto<FitOrderMainDto> booking(FitOrderBookingRequest fitOrderBookingRequest){
		
		SdpAppClientPath command = SdpAppClientPath.APP_BOOKING;
       String url = command.url(baseUrl);
		try {
			String result = restClient.post(SdpAppClientPath.APP_BOOKING.url(baseUrl), String.class, fitOrderBookingRequest);
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
	

}
