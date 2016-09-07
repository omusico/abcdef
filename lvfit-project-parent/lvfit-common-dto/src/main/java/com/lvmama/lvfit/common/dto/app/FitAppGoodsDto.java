package com.lvmama.lvfit.common.dto.app;

import com.lvmama.lvf.common.solr.json.base.select.SolrFacetFields;
import com.lvmama.lvfit.common.dto.insurance.InsuranceInfoDto;
import com.lvmama.lvfit.common.dto.search.flight.FlightFacetType;
import com.lvmama.lvfit.common.dto.search.flight.result.FlightSearchFlightInfoDto;
import com.lvmama.lvfit.common.dto.search.hotel.result.HotelSearchHotelDto;
import com.lvmama.lvfit.common.dto.search.spot.result.SpotSearchSpotDto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class FitAppGoodsDto implements Serializable {


    private static final long serialVersionUID = 628340819596872403L;

    /**缓存uuid */
    private String shoppingUuid;

    /************************航班信息 start **********************************/

    /***************************适合交通+地接 ****************************************/
    // 去程机票信息
    private List<FlightSearchFlightInfoDto> depFlightInfos;
    // 返程机票信息
    private List<FlightSearchFlightInfoDto> arvFlightInfos;
    // 去程机票头信息（更换航班时的筛选条件）
    private Map<FlightFacetType, SolrFacetFields> depfacetMap;
    // 返程机票头信息（更换航班时的筛选条件）
    private Map<FlightFacetType, SolrFacetFields> arvfacetMap;

    /***************************适合交通+地接 ****************************************/


    /***************************适合机酒 ****************************************/

    /** key: TrafficTripeType value：航班信息，仅返回默认推荐的航班信息 */
    private Map<String,FlightSearchFlightInfoDto> searchFlightInfoDtoMap;

    /*************************** 适合机酒 ****************************************/

    /************************航班信息 end **********************************/

    /************************机酒商品项 start **********************************/

    /**默认推荐的酒店 */
    private HotelSearchHotelDto searchHotelDto;

    /**符合条件的所有景点门票 */
    private List<SpotSearchSpotDto> spotDtos;

    /**符合条件的国内游保险信息 */
    private List<FitAppInsuranceDto> insuranceDtos;

    /**符合条件的航意险信息 */
    private List<InsuranceInfoDto> flightInsuranceInfos;

    /************************机酒商品项 end **********************************/

    public String getShoppingUuid() {
        return shoppingUuid;
    }

    public void setShoppingUuid(String shoppingUuid) {
        this.shoppingUuid = shoppingUuid;
    }

    public List<FlightSearchFlightInfoDto> getDepFlightInfos() {
        return depFlightInfos;
    }

    public void setDepFlightInfos(List<FlightSearchFlightInfoDto> depFlightInfos) {
        this.depFlightInfos = depFlightInfos;
    }

    public List<FlightSearchFlightInfoDto> getArvFlightInfos() {
        return arvFlightInfos;
    }

    public void setArvFlightInfos(List<FlightSearchFlightInfoDto> arvFlightInfos) {
        this.arvFlightInfos = arvFlightInfos;
    }

    public Map<FlightFacetType, SolrFacetFields> getDepfacetMap() {
        return depfacetMap;
    }

    public void setDepfacetMap(Map<FlightFacetType, SolrFacetFields> depfacetMap) {
        this.depfacetMap = depfacetMap;
    }

    public Map<FlightFacetType, SolrFacetFields> getArvfacetMap() {
        return arvfacetMap;
    }

    public void setArvfacetMap(Map<FlightFacetType, SolrFacetFields> arvfacetMap) {
        this.arvfacetMap = arvfacetMap;
    }

    public Map<String, FlightSearchFlightInfoDto> getSearchFlightInfoDtoMap() {
        return searchFlightInfoDtoMap;
    }

    public void setSearchFlightInfoDtoMap(Map<String, FlightSearchFlightInfoDto> searchFlightInfoDtoMap) {
        this.searchFlightInfoDtoMap = searchFlightInfoDtoMap;
    }

    public HotelSearchHotelDto getSearchHotelDto() {
        return searchHotelDto;
    }

    public void setSearchHotelDto(HotelSearchHotelDto searchHotelDto) {
        this.searchHotelDto = searchHotelDto;
    }

    public List<SpotSearchSpotDto> getSpotDtos() {
        return spotDtos;
    }

    public void setSpotDtos(List<SpotSearchSpotDto> spotDtos) {
        this.spotDtos = spotDtos;
    }

    public List<FitAppInsuranceDto> getInsuranceDtos() {
        return insuranceDtos;
    }

    public void setInsuranceDtos(List<FitAppInsuranceDto> insuranceDtos) {
        this.insuranceDtos = insuranceDtos;
    }

    public List<InsuranceInfoDto> getFlightInsuranceInfos() {
        return flightInsuranceInfos;
    }

    public void setFlightInsuranceInfos(List<InsuranceInfoDto> flightInsuranceInfos) {
        this.flightInsuranceInfos = flightInsuranceInfos;
    }
}
