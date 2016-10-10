package com.lvmama.lvfit.openapi.app.search;

import com.lvmama.lvf.common.exception.ExceptionCode;
import com.lvmama.lvf.common.exception.ExceptionWrapper;
import com.lvmama.lvf.common.exception.FitExceptionCode;
import com.lvmama.lvf.common.utils.BeanUtils;
import com.lvmama.lvf.common.utils.CustomizedPropertyPlaceholderConfigurer;
import com.lvmama.lvf.common.utils.DateUtils;
import com.lvmama.lvfit.common.client.FitAggregateClient;
import com.lvmama.lvfit.common.client.FitDpClient;
import com.lvmama.lvfit.common.dto.app.FitAppFlightCityDto;
import com.lvmama.lvfit.common.dto.app.FitAppFlightRequest;
import com.lvmama.lvfit.common.dto.app.FitAppGoodsDto;
import com.lvmama.lvfit.common.dto.app.FitAppHotelRequest;
import com.lvmama.lvfit.common.dto.app.FitAppInsuranceDto;
import com.lvmama.lvfit.common.dto.app.FitAppSearchRequest;
import com.lvmama.lvfit.common.dto.enums.FlightTripType;
import com.lvmama.lvfit.common.dto.enums.TripeType;
import com.lvmama.lvfit.common.dto.enums.VSTDistrictCityEnum;
import com.lvmama.lvfit.common.dto.request.FitBaseSearchRequest;
import com.lvmama.lvfit.common.dto.search.flight.FlightQueryRequest;
import com.lvmama.lvfit.common.dto.search.flight.FlightSearchResult;
import com.lvmama.lvfit.common.dto.search.flight.result.FlightSearchFlightInfoDto;
import com.lvmama.lvfit.common.dto.search.hotel.HotelSearchResult;
import com.lvmama.lvfit.common.dto.search.hotel.result.HotelSearchHotelDto;
import com.lvmama.lvfit.common.dto.search.insurance.result.InsuranceDto;
import com.lvmama.lvfit.common.dto.shopping.FitShoppingDto;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * Created by leizhengwei
 * 2016/8/12
 * 16:21
 */
@Service
public class FitAppDpSearchServiceImpl implements FitAppDpSearchService {

    @Value("getHotelFromRecommended")
    private String hotelFromRecommended;

    @Autowired
    private FitDpClient fitDpClient;

    @Autowired
    private FitAggregateClient fitAggregateClient;

    @Override
    public FitAppFlightCityDto searchFlightCityInfo() {

        return null;
    }

    @Override
    public FitAppGoodsDto searchGoodsInfo(FitAppSearchRequest request) {
        this.validateSearchRequest(request);
        FitBaseSearchRequest fitSearchRequest = this.genRequestParam(request);
        FitShoppingDto shoppingResult = fitDpClient.getShoppingResult(fitSearchRequest);
        return convertToAppGoods(shoppingResult);
    }

    private FitAppGoodsDto convertToAppGoods(FitShoppingDto shoppingDto) {
        FitAppGoodsDto fitAppGoodsDto = new FitAppGoodsDto();

        // 机票信息
        List<FlightSearchFlightInfoDto> flightInfos = shoppingDto.getFlightInfos();
        if (CollectionUtils.isEmpty(flightInfos)) {
            throw new ExceptionWrapper(ExceptionCode.GET_NO_RESULT);
        }
        Map<String, FlightSearchFlightInfoDto> flightMap = new HashMap<String, FlightSearchFlightInfoDto>();
        flightMap.put(FlightTripType.DEPARTURE.name(), flightInfos.get(0));
        if (flightInfos.size() == 2) {
            flightMap.put(FlightTripType.RETURN.name(), flightInfos.get(1));
        }
        fitAppGoodsDto.setSearchFlightInfoDtoMap(flightMap);
        // 酒店信息
        if (shoppingDto.getHotels() != null && CollectionUtils.isNotEmpty(shoppingDto.getHotels().getResults())) {
            fitAppGoodsDto.setSearchHotelDto(shoppingDto.getHotels().getResults().get(0));
        }
        // 门票信息
        fitAppGoodsDto.setSpotDtos(shoppingDto.getSpots());
        // 保险信息
        List<InsuranceDto> insurances = shoppingDto.getInsurances();
        if (CollectionUtils.isNotEmpty(insurances)) {
            List<FitAppInsuranceDto> appInsurances = new ArrayList<FitAppInsuranceDto>();
            for (InsuranceDto insurance : insurances) {
                FitAppInsuranceDto appInsDto = new FitAppInsuranceDto();
                appInsDto.setProductId(insurance.getProductId());
                appInsDto.setProductType(insurance.getProductType());
                appInsDto.setProductName(insurance.getProductName());
                appInsDto.setBranchId(insurance.getProductBranchId());
                appInsDto.setBranchName(insurance.getBranchName());
                appInsDto.setSuppGoodsId(insurance.getSuppGoodsId().toString());
                appInsDto.setSuppGoodsName(insurance.getGoodsName());
                appInsDto.setInsuranceDetail(insurance.getBranchDesc());
                appInsDto.setPrice(insurance.getPrice());

                appInsurances.add(appInsDto);
            }
            fitAppGoodsDto.setInsuranceDtos(appInsurances);
        }
        // 航意险信息
        fitAppGoodsDto.setFlightInsuranceInfos(shoppingDto.getFlightInsuranceInfos());

        return fitAppGoodsDto;
    }

    private FitBaseSearchRequest genRequestParam(FitAppSearchRequest request) {
        FitBaseSearchRequest searchRequest = new FitBaseSearchRequest();
        searchRequest.setTripType(request.getTripType());
        searchRequest.setShoppingUUID(request.getShoppingUuid());
        searchRequest.setDepartureCityCode(request.getDepartureCityCode());
        searchRequest.setDepartureTime(request.getDepartureTime());
        searchRequest.setArrivalCityCode(request.getArrivalCityCode());
        searchRequest.setReturnTime(request.getReturnTime());
        searchRequest.setCityCode(request.getCityCode());
        searchRequest.setCheckInTime(request.getCheckInTime());
        searchRequest.setCheckOutTime(request.getCheckOutTime());
        searchRequest.setAdultsCount(request.getAdultsCount());
        searchRequest.setChildCount(request.getChildCount());

        return searchRequest;
    }

    private FlightQueryRequest genFlightSearchRequest(FitAppSearchRequest request, FlightTripType flightTripType) {
        FlightQueryRequest flightQuery = new FlightQueryRequest();
        if (flightTripType.equals(FlightTripType.DEPARTURE)) {
            flightQuery.setDepartureDate(DateUtils.parseDate(request.getDepartureTime()));
            flightQuery.setReturnDate(request.getReturnTime());
            flightQuery.setDepartureCityCode(request.getDepartureCityCode());
            flightQuery.setArrivalCityCode(request.getArrivalCityCode());
            flightQuery.setDepartureAirportCode(request.getDepartureCityCode());
            flightQuery.setArrivalAirportCode(request.getArrivalCityCode());
        }
        if (flightTripType.equals(FlightTripType.RETURN)) {
            flightQuery.setDepartureDate(DateUtils.parseDate(request.getReturnTime()));
            flightQuery.setReturnDate(request.getDepartureTime());
            flightQuery.setDepartureCityCode(request.getArrivalCityCode());
            flightQuery.setArrivalCityCode(request.getDepartureCityCode());
            flightQuery.setDepartureAirportCode(request.getArrivalCityCode());
            flightQuery.setArrivalAirportCode(request.getDepartureCityCode());
        }
        flightQuery.setBookingSource(request.getBookingSource());
        flightQuery.setFacet(true);
        return flightQuery;
    }

    private void validateSearchRequest(FitAppSearchRequest request) {
        if (StringUtils.isBlank(request.getShoppingUuid())){
            throw new ExceptionWrapper(FitExceptionCode.APP_NO_SHOPPING_UUID);
        }
        if (null == request.getBookingSource()) {
            throw new ExceptionWrapper(FitExceptionCode.APP_NO_BOOKING_SOURCE);
        }
        String tripeType = request.getTripType();
        if (!tripeType.equals(TripeType.DC.name()) && !tripeType.equals(TripeType.WF.name())) {
            throw new ExceptionWrapper(FitExceptionCode.FIT_PARAM_ERROR, "tripType", tripeType);
        }
        String departureCityCode = request.getDepartureCityCode();
        try {
            VSTDistrictCityEnum.valueOf(departureCityCode);
        } catch (Exception e) {
            throw new ExceptionWrapper(FitExceptionCode.FIT_PARAM_ERROR, "departureCityCode", departureCityCode);
        }
        String arrivalCityCode = request.getArrivalCityCode();
        try {
            VSTDistrictCityEnum.valueOf(arrivalCityCode);
        } catch (Exception e) {
            throw new ExceptionWrapper(FitExceptionCode.FIT_PARAM_ERROR, "arrivalCityCode", arrivalCityCode);
        }
        String cityCode = request.getCityCode();
        try {
            VSTDistrictCityEnum.valueOf(cityCode);
        } catch (Exception e) {
            throw new ExceptionWrapper(FitExceptionCode.FIT_PARAM_ERROR, "cityCode", cityCode);
        }
        String departureTime = request.getDepartureTime();
        String returnTime = request.getReturnTime();
        String checkInTime = request.getCheckInTime();
        String checkOutTime = request.getCheckOutTime();

        String eL = "[1-9][0-9]{3}-[0-9]{2}-[0-9]{2}";
        Pattern p = Pattern.compile(eL);
        if (!p.matcher(departureTime).matches()) {
            throw new ExceptionWrapper(FitExceptionCode.FIT_PARAM_ERROR, "departureTime", departureTime);
        }
        if (tripeType.equals(TripeType.WF.name()) && !p.matcher(returnTime).matches()) {
            throw new ExceptionWrapper(FitExceptionCode.FIT_PARAM_ERROR, "returnTime", returnTime);
        }
        if (!p.matcher(checkInTime).matches()) {
            throw new ExceptionWrapper(FitExceptionCode.FIT_PARAM_ERROR, "checkInTime", checkInTime);
        }
        if (!p.matcher(checkOutTime).matches()) {
            throw new ExceptionWrapper(FitExceptionCode.FIT_PARAM_ERROR, "checkOutTime", checkOutTime);
        }

        int adultCount = request.getAdultsCount();
        int childCount = request.getChildCount();
        if (adultCount + childCount > 9) {
            throw new ExceptionWrapper(FitExceptionCode.FIT_PERSON_PARAM_ERROR_1);
        }
        if (adultCount * 2 < childCount) {
            throw new ExceptionWrapper(FitExceptionCode.FIT_PERSON_PARAM_ERROR_2);
        }
    }

    private Boolean getHotelFromRecommended() {
        return Boolean.valueOf(
            CustomizedPropertyPlaceholderConfigurer.getContextProperty(hotelFromRecommended).toString());
    }

    @Override
    public Map<String,FlightSearchResult<FlightSearchFlightInfoDto>> getAllFlightInfos(FitAppFlightRequest request) {
        this.validateParam(request);

        Map<String,FlightSearchResult<FlightSearchFlightInfoDto>> map = null;
        try {
            map = fitDpClient.getAllFlightInfos(request);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (MapUtils.isEmpty(map) || (request.getTripeType().equals(TripeType.WF) && map.keySet().size() != 2)) {
            throw new ExceptionWrapper(FitExceptionCode.FIT_NO_FLIGHT_RESULT, request.getDepartureDate(), request.getDepCityCode(), request.getArvCityCode());
        }
        return map;
    }

    private void validateParam(FitAppFlightRequest request) {
        if (request.getBookingSource() == null) {
            throw new ExceptionWrapper(FitExceptionCode.APP_NO_BOOKING_SOURCE);
        }
        this.validateTripType(request.getTripeType());
        this.validateCityCode(request.getDepCityCode());
        this.validateCityCode(request.getArvCityCode());
        this.validateDateStr(request.getDepartureDate());
        this.validateDateStr(request.getReturnDate());
    }

    private void validateTripType(TripeType tripeType) {
        if (tripeType == null ||
            (!tripeType.equals(TripeType.DC) && !tripeType.equals(TripeType.WF))) {
            throw new ExceptionWrapper(FitExceptionCode.FIT_PARAM_ERROR, "tripType", tripeType.name());
        }
    }

    private void validateCityCode(String code) {
        try {
            VSTDistrictCityEnum.valueOf(code);
        } catch (Exception e) {
            throw new ExceptionWrapper(FitExceptionCode.FIT_PARAM_ERROR, "城市CODE", code);
        }
    }

    private void validateDateStr(String str) {
        String eL = "[1-9][0-9]{3}-[0-9]{2}-[0-9]{2}";
        Pattern p = Pattern.compile(eL);
        if (!p.matcher(str).matches()) {
            throw new ExceptionWrapper(FitExceptionCode.FIT_PARAM_ERROR, "日期", str);
        }
    }

    @Override
    public HotelSearchResult<HotelSearchHotelDto> changeHotelInfo(FitAppHotelRequest hotelQueryRequest) {
        this.validateCityCode(hotelQueryRequest.getCityCode());
        this.validateDateStr(hotelQueryRequest.getDepartureDate());
        this.validateDateStr(hotelQueryRequest.getReturnDate());
        try {
            HotelSearchResult<HotelSearchHotelDto> hotelInfos = fitDpClient.getHotelInfos(hotelQueryRequest);
            if (hotelInfos == null || CollectionUtils.isEmpty(hotelInfos.getResults())) {
                throw new ExceptionWrapper(FitExceptionCode.FIT_NO_HOTEL_RESULT);
            }
            return hotelInfos;
        } catch (Exception e) {
        	if(e instanceof ExceptionWrapper){
        		throw (ExceptionWrapper)e;
        	}else{
        		throw new RuntimeException(e);
        	}
        }
    }
}
