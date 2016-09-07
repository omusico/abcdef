package com.lvmama.lvfit.openapi.app.search;

import com.lvmama.lvf.common.exception.ExceptionCode;
import com.lvmama.lvf.common.exception.ExceptionWrapper;
import com.lvmama.lvf.common.exception.FitExceptionCode;
import com.lvmama.lvf.common.task.Task;
import com.lvmama.lvf.common.task.TaskContext;
import com.lvmama.lvf.common.task.TaskMainGroup;
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
import com.lvmama.lvfit.common.dto.enums.BookingSource;
import com.lvmama.lvfit.common.dto.enums.FlightTripType;
import com.lvmama.lvfit.common.dto.enums.TripeType;
import com.lvmama.lvfit.common.dto.enums.VSTDistrictCityEnum;
import com.lvmama.lvfit.common.dto.sdp.goods.request.FitSdpGoodsRequest;
import com.lvmama.lvfit.common.dto.search.FitPassengerRequest;
import com.lvmama.lvfit.common.dto.search.FitSearchRequest;
import com.lvmama.lvfit.common.dto.search.FitSearchResult;
import com.lvmama.lvfit.common.dto.search.flight.FlightQueryRequest;
import com.lvmama.lvfit.common.dto.search.flight.FlightSearchResult;
import com.lvmama.lvfit.common.dto.search.flight.result.FlightSearchFlightInfoDto;
import com.lvmama.lvfit.common.dto.search.hotel.HotelQueryRequest;
import com.lvmama.lvfit.common.dto.search.hotel.HotelSearchResult;
import com.lvmama.lvfit.common.dto.search.hotel.result.HotelSearchHotelDto;
import com.lvmama.lvfit.common.dto.search.insurance.InsuranceQueryRequest;
import com.lvmama.lvfit.common.dto.search.insurance.result.InsuranceDto;
import com.lvmama.lvfit.common.dto.search.insurance.result.InsuranceProdProduct;
import com.lvmama.lvfit.common.dto.search.insurance.result.InsuranceProdProductBranch;
import com.lvmama.lvfit.common.dto.search.insurance.result.InsuranceSuppGoods;
import com.lvmama.lvfit.common.dto.search.spot.SpotQueryRequest;
import com.lvmama.lvfit.common.dto.shopping.FitShoppingDto;
import com.lvmama.lvfit.common.utils.HotelUtils;
import com.thoughtworks.xstream.converters.basic.UUIDConverter;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
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
        FitSearchRequest fitSearchRequest = this.genRequestParam(request);
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
        if (CollectionUtils.isNotEmpty(shoppingDto.getHotels())) {
            fitAppGoodsDto.setSearchHotelDto(shoppingDto.getHotels().get(0));
        }
        // 门票信息
        fitAppGoodsDto.setSpotDtos(shoppingDto.getSpots());
        // 保险信息
        List<InsuranceDto> insurances = shoppingDto.getInsurances();
        if (CollectionUtils.isNotEmpty(insurances)) {
            List<FitAppInsuranceDto> appInsurances = new ArrayList<FitAppInsuranceDto>();
            for (InsuranceDto insurance : insurances) {
                FitAppInsuranceDto appInsDto = new FitAppInsuranceDto();
                for (InsuranceProdProduct insuranceProduct : insurance.getInsuranceProductList()) {
                    appInsDto.setProductId(insuranceProduct.getProductId());
                    appInsDto.setProductType(insuranceProduct.getInsuranceType().toString());
                    appInsDto.setProductName(insuranceProduct.getProductName());
                    for (InsuranceProdProductBranch branch : insuranceProduct.getInsuranceProductBranchList()) {
                        appInsDto.setBranchId(branch.getProductBranchId());
                        appInsDto.setBranchName(branch.getBranchName());
                        for (InsuranceSuppGoods suppGoods : branch.getInsuranceSuppGoodList()) {
                            appInsDto.setSuppGoodsId(suppGoods.getSuppGoodsId().toString());
                            appInsDto.setSuppGoodsName(suppGoods.getGoodsName());
                            appInsDto.setInsuranceDetail(suppGoods.getInsuranceGoodBranch().getInsuranceDesc());
                        }
                    }
                }
                appInsurances.add(appInsDto);
            }
            fitAppGoodsDto.setInsuranceDtos(appInsurances);
        }
        // 航意险信息
        fitAppGoodsDto.setFlightInsuranceInfos(shoppingDto.getFlightInsuranceInfos());

        return fitAppGoodsDto;
    }

    private FitSearchRequest genRequestParam(FitAppSearchRequest request) {

        FitSearchRequest fitSearchRequest = new FitSearchRequest();
        fitSearchRequest.setShoppingId(request.getShoppingUuid());
        fitSearchRequest.setTripType(request.getTripType());
        /** 构造机票请求参数 */

        List<FlightQueryRequest> flightSearchRequests = new ArrayList<FlightQueryRequest>();
        flightSearchRequests.add(genFlightSearchRequest(request, FlightTripType.DEPARTURE));
        if (request.getTripType().equals(TripeType.WF.name())) {
            flightSearchRequests.add(genFlightSearchRequest(request, FlightTripType.RETURN));
        }
        fitSearchRequest.setFlightSearchRequests(flightSearchRequests);

        /** 构造酒店请求参数 */
        HotelQueryRequest hotelQueryRequest = new HotelQueryRequest();
        VSTDistrictCityEnum checkInCity = VSTDistrictCityEnum.valueOf(request.getCityCode());
        hotelQueryRequest.setCityDistrictId(String.valueOf(checkInCity.getDistrictId()));
        hotelQueryRequest.setCityCode(request.getCityCode());
        hotelQueryRequest.setCityName(checkInCity.getCnName());
        hotelQueryRequest.setDepartureDate(request.getCheckInTime());
        hotelQueryRequest.setReturnDate(request.getCheckOutTime());
        hotelQueryRequest.setHotelFromRecommendedOnly(getHotelFromRecommended());
        hotelQueryRequest.setAdultCount(request.getAdultsCount());

        List<HotelQueryRequest> hotelSearchRequests = new ArrayList<HotelQueryRequest>();
        hotelSearchRequests.add(hotelQueryRequest);
        /** 构造乘客信息 */
        FitPassengerRequest passengerRequest = new FitPassengerRequest();
        passengerRequest.setAdultCount(request.getAdultsCount());
        passengerRequest.setChildCount(request.getChildCount());
        fitSearchRequest.setHotelSearchRequests(hotelSearchRequests);
        fitSearchRequest.setFitPassengerRequest(passengerRequest);

        /** 景点门票参数封装 */
        SpotQueryRequest spotQueryRequest = new SpotQueryRequest();
        String cityCode = hotelQueryRequest.getCityCode();
        Long districtId = VSTDistrictCityEnum.getDestId(cityCode);

        spotQueryRequest.setDestinationId(districtId.toString());
        spotQueryRequest.setVisitorNum(passengerRequest.getAdultCount()+passengerRequest.getChildCount());
        //景点的游玩日期为入驻日期的后一天
        Date startDate = DateUtils.parseDate(hotelQueryRequest.getDepartureDate());
        spotQueryRequest.setStartDate(DateUtils.getDateAfterDateDays(startDate, 1));
        spotQueryRequest.setEndDate(DateUtils.parseDate(hotelQueryRequest.getReturnDate()));
        List<SpotQueryRequest> spotQueryRequests = new ArrayList<SpotQueryRequest>();
        spotQueryRequests.add(spotQueryRequest);
        fitSearchRequest.setSpotQueryRequests(spotQueryRequests);

        /** 保险参数封装 **/
        InsuranceQueryRequest insuranceQueryRequest = new InsuranceQueryRequest();
        insuranceQueryRequest.setCurrentProductId(636165L);
        insuranceQueryRequest.setDistributorId(3L);
        if (TripeType.WF.name().equals(request.getTripType())) {
            int insuranceDays = DateUtils.getDateDiffByDay(DateUtils.parseDate(request.getReturnTime()), DateUtils.parseDate(request.getDepartureTime())) + 1;
            insuranceQueryRequest.setInsuranceDays((long)insuranceDays);
        } else { //单程的被保天数
            insuranceQueryRequest.setInsuranceDays(1L);
        }
        insuranceQueryRequest.setVistorDate(DateUtils.parseDate(request.getDepartureTime()));
        insuranceQueryRequest.setPersonNum(passengerRequest.getAdultCount() + passengerRequest.getChildCount());
        fitSearchRequest.setInsuranceQueryRequest(insuranceQueryRequest);

        return fitSearchRequest;
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
