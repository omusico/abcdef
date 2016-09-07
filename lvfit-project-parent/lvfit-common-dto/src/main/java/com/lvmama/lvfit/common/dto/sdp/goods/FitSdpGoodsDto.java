package com.lvmama.lvfit.common.dto.sdp.goods;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.lvmama.lvf.common.solr.json.base.select.SolrFacetFields; 
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpProductTrafficRulesDto;
import com.lvmama.lvfit.common.dto.search.flight.FlightFacetType;
import com.lvmama.lvfit.common.dto.search.flight.result.FlightSearchFlightInfoDto;

public class FitSdpGoodsDto implements Serializable {

    private static final long serialVersionUID = 3631987524999556420L;
    // 包机信息
    private List<FlightSearchFlightInfoDto> charterFlightInfos;
    // 去程机票信息
    private List<FlightSearchFlightInfoDto> depFlightInfos;
    // 返程机票信息
    private List<FlightSearchFlightInfoDto> arvFlightInfos;
    // 去程机票头信息（更换航班时的筛选条件）
    private Map<FlightFacetType, SolrFacetFields> depfacetMap;
    // 返程机票头信息（更换航班时的筛选条件）
    private Map<FlightFacetType, SolrFacetFields> arvfacetMap;
    // 酒店套餐
    private List<FitSdpHotelComboGoodsDto> hotelCombo;
    // 酒店信息（非套餐）
    private List<FitSdpHotelGroupDto> hotelInfos;  
     
	public List<FitSdpHotelGroupDto> getHotelInfos() {
		return hotelInfos;
	}
	public void setHotelInfos(List<FitSdpHotelGroupDto> hotelInfos) {
		this.hotelInfos = hotelInfos;
	}
	
	public List<FlightSearchFlightInfoDto> getCharterFlightInfos() {
		return charterFlightInfos;
	}
	public void setCharterFlightInfos(
			List<FlightSearchFlightInfoDto> charterFlightInfos) {
		this.charterFlightInfos = charterFlightInfos;
	}

	// 当地游
    private FitSdpLocalTripProductDto localTrip;
    // 附加
    private FitSdpAdditonalDto additional;
    // 排序后的保险产品
    List<FitSdpInsuranceProductDto> insProducts = new ArrayList<FitSdpInsuranceProductDto>();
    // 机票排序规则
    Map<String,FitSdpProductTrafficRulesDto> trafficRuleMap = new HashMap<String, FitSdpProductTrafficRulesDto>();

    public List<FitSdpHotelComboGoodsDto> getHotelCombo() {
        return hotelCombo;
    }
    public void setHotelCombo(List<FitSdpHotelComboGoodsDto> hotelCombo) {
        this.hotelCombo = hotelCombo;
    }
    
    public FitSdpLocalTripProductDto getLocalTrip() {
		return localTrip;
	}
	public void setLocalTrip(FitSdpLocalTripProductDto localTrip) {
		this.localTrip = localTrip;
	}
	public FitSdpAdditonalDto getAdditional() {
        return additional;
    }
    public void setAdditional(FitSdpAdditonalDto additional) {
        this.additional = additional;
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
    public List<FitSdpInsuranceProductDto> getInsProducts() {
        return insProducts;
    }
    public void setInsProducts(List<FitSdpInsuranceProductDto> insProducts) {
        this.insProducts = insProducts;
    }
    public Map<String, FitSdpProductTrafficRulesDto> getTrafficRuleMap() {
        return trafficRuleMap;
    }
    public void setTrafficRuleMap(Map<String, FitSdpProductTrafficRulesDto> trafficRuleMap) {
        this.trafficRuleMap = trafficRuleMap;
    }
}
