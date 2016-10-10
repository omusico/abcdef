package com.lvmama.lvfit.common.calculate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.lvmama.lvfit.common.cache.CacheBoxConvert;
import com.lvmama.lvfit.common.cache.CacheKey;
import com.lvmama.lvfit.common.cache.CachePoint;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lvmama.lvf.common.dto.flight.FlightLowPriceDayCacheDto;
import com.lvmama.lvf.common.exception.ExceptionWrapper;
import com.lvmama.lvf.common.exception.FitExceptionCode;
import com.lvmama.lvf.common.utils.DateUtils;
import com.lvmama.lvf.common.utils.JSONMapper;
import com.lvmama.lvfit.common.client.FitAggregateClient;
import com.lvmama.lvfit.common.dto.enums.BizEnum;
import com.lvmama.lvfit.common.dto.enums.TrafficTripeType;
import com.lvmama.lvfit.common.dto.request.FitSdpCalculateProductRequest;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpCityGroupDto;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpProductBasicInfoDto;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpProductCalendarDto;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpProductFeeRulesDto;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpProductTrafficRulesDto;
import com.lvmama.lvfit.common.dto.sdp.product.request.FitSdpProductGroupQueryRequest;
import com.lvmama.lvfit.common.dto.sdp.product.result.FitSdpGroupCalendarSearchResult;
import com.lvmama.lvfit.common.utils.FliMemcachedUtil;
import com.lvmama.lvfit.persistence.mybatis.mapper.FitSdpCityGroupMapper;
import com.lvmama.lvfit.persistence.mybatis.mapper.FitSdpProductBasicInfoMapper;
import com.lvmama.lvfit.persistence.mybatis.mapper.FitSdpProductFeeRulesMapper;
import com.lvmama.lvfit.persistence.mybatis.mapper.FitSdpProductTrafficRulesMapper;

/**
 * 一键打包算价工具类
 */
@Component
public class FitSdpCalculateUtils {

    private static final Logger logger = LoggerFactory.getLogger(FitSdpCalculateUtils.class);

    @Autowired
    private FitAggregateClient fitAggregateClient;

    @Autowired
    private FitSdpProductTrafficRulesMapper fitSdpProductTrafficRulesMapper;

    @Autowired
    private FitSdpProductFeeRulesMapper fitSdpProductFeeRulesMapper;

    @Autowired
    private FitSdpCityGroupMapper fitSdpCityGroupMapper;

    @Autowired
    private FitSdpProductBasicInfoMapper productBasicInfoMapper;

    /**
     * 获取产品所有出发城市的低价日历信息
     *
     * @param productId 打包产品ID
     * @return Map<出发城市ID, 低价日历Dto>
     */
    public Map<Long, List<FitSdpProductCalendarDto>> getAllCityCalendarInfo(Long productId) {
        Map<Long, List<FitSdpProductCalendarDto>> calendarInfoMap = new HashMap<Long, List<FitSdpProductCalendarDto>>();

        List<FitSdpCityGroupDto> cityGroupDtos = getCityGroup(productId);
        if (CollectionUtils.isEmpty(cityGroupDtos)) {
            throw new ExceptionWrapper(FitExceptionCode.GET_NO_CITY_GROUPS, productId);
        }
        FitSdpProductBasicInfoDto dbBasicInfoDto = this.getProductBasicInfo(productId);
        FitSdpProductGroupQueryRequest groupQueryRequest = new FitSdpProductGroupQueryRequest();
        groupQueryRequest.setPackagedProductId(dbBasicInfoDto.getPackagedProductId()); 
        groupQueryRequest.setCategoryCode(dbBasicInfoDto.getCategoryCode());
        // 从获取vst被打包产品低价日历信息
        FitSdpGroupCalendarSearchResult<FitSdpProductCalendarDto> calendarSearchResult = fitAggregateClient.searchProductGroupFromVst(groupQueryRequest);

        Integer goRouteDayNum = getRouteDayNum(productId, TrafficTripeType.GO_WAY);
        Integer backRouteDayNum = getRouteDayNum(productId, TrafficTripeType.BACK_WAY);

        String categoryCode = dbBasicInfoDto.getCategoryCode();
        Long adultQuantity = dbBasicInfoDto.getAdultQuantity();
        Long childQuantity = dbBasicInfoDto.getChildQuantity();
        BigDecimal peopleCount = BigDecimal.ZERO;
        if (categoryCode.equals(BizEnum.BIZ_CATEGORY_TYPE.category_route_group.name())) {
            peopleCount = BigDecimal.ONE;//跟团游起价默认按一成人算
        }
        if (categoryCode.equals(BizEnum.BIZ_CATEGORY_TYPE.category_route_freedom.name())) {
            if (dbBasicInfoDto.getPackagedCategoryId()!=null && dbBasicInfoDto.getPackagedCategoryId().equals(BizEnum.BIZ_CATEGORY_TYPE.category_route_hotelcomb.getCategoryId())) {
                peopleCount = new BigDecimal(adultQuantity + childQuantity);
            } else {
                peopleCount = BigDecimal.ONE;
            }
        }
        BigDecimal increasedPrice = getIncreasedPrice(productId, peopleCount);

        for (FitSdpCityGroupDto cityGroupDto : cityGroupDtos) {
            if (cityGroupDto.getDepartureCityDistrictId() == null) {
                continue;
            }
            FitSdpCalculateProductRequest request = new FitSdpCalculateProductRequest();
            request.setProductId(productId);
            request.setDepartureCityCode(cityGroupDto.getDepartureCityCode());
            request.setArrivalCityCode(cityGroupDto.getArrivalCityCode());
            request.setGoRouteDayNum(goRouteDayNum);
            request.setBackRouteDayNum(backRouteDayNum);
            request.setIncreasedPrice(increasedPrice);
            request.setPeopleCount(peopleCount);
            List<FitSdpProductCalendarDto> curSdpProductCalendarDtos = getProductCalendarInfo(request, calendarSearchResult.getResults());
            if(CollectionUtils.isEmpty(curSdpProductCalendarDtos)){
                continue;
            }
            calendarInfoMap.put(cityGroupDto.getDepartureCityDistrictId(), curSdpProductCalendarDtos);
        }
        return calendarInfoMap;
    }

    /**
     * 得到产品的低价日历信息
     * @param request 请求参数
     * @Param oldCalendarList vst低价日历信息
     * @return
     */
    public List<FitSdpProductCalendarDto> getProductCalendarInfo(FitSdpCalculateProductRequest request, List<FitSdpProductCalendarDto> oldCalendarList) {
        Long productId = request.getProductId();
        String departureCityCode = request.getDepartureCityCode();
        String arrivalCityCode = request.getArrivalCityCode();

        Integer goRouteDayNum = request.getGoRouteDayNum() == null ? getRouteDayNum(productId, TrafficTripeType.GO_WAY) : request.getGoRouteDayNum();
        Integer backRouteDayNum = request.getBackRouteDayNum() == null ? getRouteDayNum(productId, TrafficTripeType.BACK_WAY) :request.getBackRouteDayNum();
        String categoryCode = request.getCategoryCode();
        Long adultQuantity = request.getAdultQuantity();
        Long childQuantity = request.getChildQuantity();
        BigDecimal increasedPrice = request.getIncreasedPrice();
        BigDecimal peopleCount = request.getPeopleCount();
        if (StringUtils.isEmpty(categoryCode)) {
            FitSdpProductBasicInfoDto dbBasicInfoDto = this.getProductBasicInfo(productId);
            categoryCode = dbBasicInfoDto.getCategoryCode();
            if (adultQuantity == null) {
                adultQuantity = dbBasicInfoDto.getAdultQuantity();
            }
            if (childQuantity == null) {
                childQuantity = dbBasicInfoDto.getChildQuantity();
            }
            if (categoryCode.equals(BizEnum.BIZ_CATEGORY_TYPE.category_route_group.name())) {
                peopleCount = BigDecimal.ONE;//跟团游起价默认按一成人算
            }
            if (categoryCode.equals(BizEnum.BIZ_CATEGORY_TYPE.category_route_freedom.name())) {
                if (dbBasicInfoDto.getPackagedCategoryId()!=null && dbBasicInfoDto.getPackagedCategoryId().equals(BizEnum.BIZ_CATEGORY_TYPE.category_route_hotelcomb.getCategoryId())) {
                    peopleCount = new BigDecimal(adultQuantity + childQuantity);
                } else {
                    peopleCount = BigDecimal.ONE;
                }
            }
        }
        adultQuantity = adultQuantity == 0 ? 1L : adultQuantity;

        if (CollectionUtils.isEmpty(oldCalendarList)) {
            FitSdpProductBasicInfoDto basicInfo = getProductBasicInfo(productId);
            FitSdpProductGroupQueryRequest groupQueryRequest = new FitSdpProductGroupQueryRequest();
            groupQueryRequest.setPackagedProductId(basicInfo.getPackagedProductId());
            oldCalendarList = fitAggregateClient.searchProductGroupFromVst(groupQueryRequest).getResults();
        }


        List<FitSdpProductCalendarDto> returnCalendarList = new ArrayList<FitSdpProductCalendarDto>();

        int startMonth = DateUtils.getMonth(new Date()) + 1;
        int endMonth = DateUtils.getMonth(DateUtils.getDateAfterDateDays(new Date(), 90)) + 1;
        List<String> calendarCacheKeys = new ArrayList<String>();
        String goCityKey = departureCityCode + "_" + arrivalCityCode;
        String backCityKey = arrivalCityCode + "_" + departureCityCode;
        if(endMonth>startMonth){
	        for (int i = startMonth; i <= endMonth; i++) {
	            calendarCacheKeys.add(goCityKey + "_" + i);
	            calendarCacheKeys.add(backCityKey + "_" + i);
	        }
        }else{
        	endMonth = endMonth+12;
        	for (int i = startMonth; i <= endMonth; i++) {
	            calendarCacheKeys.add(goCityKey + "_" + i%12);
	            calendarCacheKeys.add(backCityKey + "_" + i%12);
	        }
        }


        // 根据交通规则所设置的往返程时间匹配两边对应的低价日历数据，计算自主打包产品每日最低价
        Map<String, BigDecimal> flightCalendarMap = new HashMap<String, BigDecimal>();
        List<FlightLowPriceDayCacheDto> flightCalendarInfos = this.getFlightCalendarInfo(calendarCacheKeys);
        if (CollectionUtils.isEmpty(flightCalendarInfos)) {
            logger.error(new ExceptionWrapper(FitExceptionCode.GET_NO_FLIGHT_CALENDAR, productId, departureCityCode, arrivalCityCode).getErrMessage());
            return null;
        }

        for (FlightLowPriceDayCacheDto flightCalendarDto : flightCalendarInfos) {
            flightCalendarMap.put(flightCalendarDto.getMatchKey(), flightCalendarDto.getLowPrice());
        }

        for (FitSdpProductCalendarDto productCalendarDto : oldCalendarList) {
            String matchGoKey = goCityKey + "_" + DateUtils.formatDate(DateUtils.getDateAfterDateDays(DateUtils.parseDate(productCalendarDto.getDepartureDate()), goRouteDayNum - 1));
            String matchBackKey = backCityKey + "_" + DateUtils.formatDate(DateUtils.getDateAfterDateDays(DateUtils.parseDate(productCalendarDto.getDepartureDate()), backRouteDayNum - 1));
            if (flightCalendarMap.containsKey(matchGoKey) && flightCalendarMap.containsKey(matchBackKey)) {
                FitSdpProductCalendarDto calendarCopy = new FitSdpProductCalendarDto();
                // 利用JSON实现类的深复制
                try {
                    calendarCopy = JSONMapper.getInstance().readValue(JSONMapper.getInstance().writeValueAsString(productCalendarDto), FitSdpProductCalendarDto.class);
                } catch (Exception e) {}
                BigDecimal goFlightLowestSaledPrice = flightCalendarMap.get(matchGoKey).multiply(peopleCount);
                BigDecimal backFlightLowestSaledPrice = flightCalendarMap.get(matchBackKey).multiply(peopleCount);
                BigDecimal count = adultQuantity.longValue() > peopleCount.longValue() ? peopleCount : BigDecimal.valueOf(adultQuantity);
                BigDecimal airportFees = new BigDecimal(50).multiply(new BigDecimal(2)).multiply(count);
                calendarCopy.setLowestSaledPrice(calendarCopy.getLowestSaledPrice().add(goFlightLowestSaledPrice).add(backFlightLowestSaledPrice).add(airportFees));

                BigDecimal finalPrice = increasedPrice == null ? getIncreasedPrice(productId, peopleCount) : increasedPrice;
                calendarCopy.setLowestSaledPrice(calendarCopy.getLowestSaledPrice().add(finalPrice));

                returnCalendarList.add(calendarCopy);
            }
        }
        return returnCalendarList;
    }
    /**
     * 得到产品的低价日历信息
     * @param request 请求参数
     * @return
     */
    public List<FitSdpProductCalendarDto> getProductCalendarInfo(FitSdpCalculateProductRequest request) {
        return getProductCalendarInfo(request, null);
    }

    /**
     * 如果缓存中存在低价日历信息，从缓存中获取；否则，实时查询
     * @param productId
     * @return
     */
    @CachePoint(value = CacheBoxConvert.FitSdpCalendarInfoMap, cacheExpireTimeKey = "lvfit.calendar.cacheTime")
    public Map<Long, List<FitSdpProductCalendarDto>> getAllCityCalendarInfoFromCache(@CacheKey Long productId) {
        return this.getAllCityCalendarInfo(productId);
    }

    /**
     * 如果缓存中存在低价日历信息，从缓存中获取；否则，实时查询
     * @param productId
     * @return
     */
    @CachePoint(value = CacheBoxConvert.FitSdpCalendarInfoMap, cacheExpireTimeKey = "lvfit.calendar.cacheTime", isCacheEnable = false)
    public Map<Long, List<FitSdpProductCalendarDto>> getAllCityCalendarInfoAndUpdCache(@CacheKey Long productId) {
        return this.getAllCityCalendarInfo(productId);
    }

    /**
     * 根据产品ID得到产品的基本信息
     */
    private FitSdpProductBasicInfoDto getProductBasicInfo(Long productId) {
        return productBasicInfoMapper.getByProductId(productId);
    }

    /**
     * 得到低价日历的最低价，作为起价
     */
    public BigDecimal getStartingPrice(List<FitSdpProductCalendarDto> calendarList) {
        if (CollectionUtils.isEmpty(calendarList)) {
            return null;
        }
        BigDecimal minPrice = calendarList.get(0).getLowestSaledPrice();
        for (FitSdpProductCalendarDto calendar : calendarList) {
            if (calendar.getLowestSaledPrice().compareTo(minPrice) < 0) {
                minPrice = calendar.getLowestSaledPrice();
            }
        }
        return minPrice;
    }

    /**
     * 从缓存取得机票低价日历信息
     * @param calendarCacheKeys
     * @return
     */
    private List<FlightLowPriceDayCacheDto> getFlightCalendarInfo(List<String> calendarCacheKeys) {
        List<FlightLowPriceDayCacheDto> curLowPriceDayCacheDtos = new ArrayList<FlightLowPriceDayCacheDto>();
        for (String cacheKey : calendarCacheKeys) {
            List<FlightLowPriceDayCacheDto> lowPriceDayCacheDtos = new ArrayList<FlightLowPriceDayCacheDto>();
            lowPriceDayCacheDtos = FliMemcachedUtil.getInstance().get(cacheKey);
            if (CollectionUtils.isNotEmpty(lowPriceDayCacheDtos)) {
                curLowPriceDayCacheDtos.addAll(lowPriceDayCacheDtos);
            }
        }
        return curLowPriceDayCacheDtos;
    }

    /**
     * 返回产品城市组信息
     * @param productId
     * @return
     */
    private List<FitSdpCityGroupDto> getCityGroup(Long productId) {
        return fitSdpCityGroupMapper.queryByFkId(productId);
    }

    /**
     * 返回交通规则信息
     * @param productId
     * @return
     */
    private List<FitSdpProductTrafficRulesDto> getProductTrafficRules(Long productId) {
        return fitSdpProductTrafficRulesMapper.queryByFkId(productId);
    }

    /**
     * 根据交通规则，取得起始天数
     */
    private int getRouteDayNum(Long productId, TrafficTripeType tripType) {
        if(CollectionUtils.isNotEmpty(getProductTrafficRules(productId))){
            for (FitSdpProductTrafficRulesDto trafficRulesDto : getProductTrafficRules(productId)) {
                if(trafficRulesDto.getTrafficTripeType() == tripType){
                    return trafficRulesDto.getRouteDayNum();
                }
            }
        }
        return 0;
    }

    /**
     * 返回费用规则信息
     * @param productId
     * @return
     */
    private FitSdpProductFeeRulesDto getFeeRules(Long productId) {
        List<FitSdpProductFeeRulesDto> feeRulesDtos =  fitSdpProductFeeRulesMapper.queryByFkId(productId);

        FitSdpProductFeeRulesDto feeRulesDto = null;
        if (CollectionUtils.isNotEmpty(feeRulesDtos)) {
            feeRulesDto = feeRulesDtos.get(0);
        }
        return feeRulesDto;
    }

    /**
     * 根据费用规则得到加价
     */
    private BigDecimal getIncreasedPrice(Long productId, BigDecimal peopleCount) {
        FitSdpProductFeeRulesDto feeRulesDto = this.getFeeRules(productId);
        if (null != feeRulesDto) {
            //交通加价规则-----人数*加价+往返程机票价格
            return feeRulesDto.getOprationValue().multiply(peopleCount);//此处加上基建费
        }
        return BigDecimal.ZERO;
    }
}
