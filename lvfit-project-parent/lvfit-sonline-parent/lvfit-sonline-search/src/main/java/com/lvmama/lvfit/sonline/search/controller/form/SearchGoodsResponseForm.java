package com.lvmama.lvfit.sonline.search.controller.form;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lvmama.lvf.common.form.Form;
import com.lvmama.lvf.common.solr.json.base.select.SolrFacetField;
import com.lvmama.lvf.common.solr.json.base.select.SolrFacetFields;
import com.lvmama.lvf.common.utils.DateUtils;
import com.lvmama.lvfit.common.dto.enums.JudgeType;
import com.lvmama.lvfit.common.dto.sdp.goods.FitSdpAdditonalDto;
import com.lvmama.lvfit.common.dto.sdp.goods.FitSdpGoodsDto;
import com.lvmama.lvfit.common.dto.sdp.goods.FitSdpHotelComboGoodsDto;
import com.lvmama.lvfit.common.dto.sdp.goods.FitSdpHotelDto;
import com.lvmama.lvfit.common.dto.sdp.goods.FitSdpHotelGroupDto;
import com.lvmama.lvfit.common.dto.sdp.goods.FitSdpHotelRoomtypeDto;
import com.lvmama.lvfit.common.dto.sdp.goods.FitSdpInsuranceDto;
import com.lvmama.lvfit.common.dto.sdp.goods.FitSdpLocalTripProductDto;
import com.lvmama.lvfit.common.dto.sdp.goods.FitSdpOtherTicketDto;
import com.lvmama.lvfit.common.dto.sdp.goods.FitSdpRoomDiff;
import com.lvmama.lvfit.common.dto.search.flight.result.FlightSearchFlightInfoDto;

public class SearchGoodsResponseForm implements Serializable, Form {

    private static final long serialVersionUID = 4186966150188890007L;

    private FitSdpGoodsDto fitSdpGoodsDto;
    
    Map<String, List<FitSdpOtherTicketDto>> otherTicketMaps;
    
    private static final Logger logger = LoggerFactory.getLogger(SearchGoodsResponseForm.class);
	    
    public SearchGoodsResponseForm() {
        fitSdpGoodsDto = new FitSdpGoodsDto();
    }
    
    //报含了包机+以前默认的普通往返程中去程航班的总和。按照价格顺序排列
    private List<FlightSearchFlightInfoDto> sumDepFlightInfos;
    //报含了包机+以前默认的普通往返程中返程航班的总和。按照价格顺序排列
    private List<FlightSearchFlightInfoDto> sumArvFlightInfos; 
    
    public SearchGoodsResponseForm(FitSdpGoodsDto fitSdpGoodsDto) {
        this.fitSdpGoodsDto = fitSdpGoodsDto;
//        if (CollectionUtils.isNotEmpty(getOtherTicketDto())) {
//            otherTicketMaps = genTicketProduct(getOtherTicketDto());
//        }
//        if (CollectionUtils.isNotEmpty(getHotelCombo())) {
//            setDiffPriceOfHotelCombo(getHotelCombo());
//        }
//        if (CollectionUtils.isNotEmpty(getHotelGroups())) {
//        	setDiffPriceOfHotelGroup(getHotelGroups());
//        }
    }

    public FitSdpGoodsDto getFitSdpGoodsDto() {
        return fitSdpGoodsDto;
    }

    public void setFitSdpGoodsDto(FitSdpGoodsDto fitSdpGoodsDto) {
        this.fitSdpGoodsDto = fitSdpGoodsDto;
    }

    public List<FitSdpHotelComboGoodsDto> getHotelCombo() {
        return fitSdpGoodsDto.getHotelCombo();
    }

    public List<FitSdpHotelGroupDto> getHotelGroups() {
    	return fitSdpGoodsDto.getHotelInfos();
    }
    
    /**
     * 返回包机信息.
     * @return
     */
    public List<FlightSearchFlightInfoDto> getCharterFlightInfos() {
    	 List<FlightSearchFlightInfoDto> flightInfos = fitSdpGoodsDto.getCharterFlightInfos();
         if (flightInfos != null) {
             for (FlightSearchFlightInfoDto flightInfo : flightInfos) {
                 String weekOfDate = DateUtils.getWeekOfDate(DateUtils.parseDate(flightInfo.getDepartureDate(), "yyyy-MM-dd"));
                 flightInfo.setWeekOfDate(weekOfDate);
             }
         }
         return flightInfos; 
	}
    
    public void setHotelCombo(List<FitSdpHotelComboGoodsDto> hotelCombo) {
        fitSdpGoodsDto.setHotelCombo(hotelCombo);
    }

    public FitSdpLocalTripProductDto getLocalTrip() {
        return fitSdpGoodsDto.getLocalTrip();
    }

    public void setLocalTrip(FitSdpLocalTripProductDto localTrip) {
        fitSdpGoodsDto.setLocalTrip(localTrip);
    }

    public FitSdpAdditonalDto getAdditional() {
        return fitSdpGoodsDto.getAdditional();
    }

    public void setAdditional(FitSdpAdditonalDto additional) {
        fitSdpGoodsDto.setAdditional(additional);
    }
    
    public List<FitSdpInsuranceDto> getInsuranceDto() {
        if (getAdditional() == null) {
            return null;
        }
        return getAdditional().getInsuranceDto();
    }

    public void setInsuranceDto(List<FitSdpInsuranceDto> insuranceDto) {
        if (getAdditional() != null) {
            getAdditional().setInsuranceDto(insuranceDto);
        }
    }

    public List<FitSdpOtherTicketDto> getOtherTicketDto() {
        if (getAdditional() == null) {
            return null;
        }
        return getAdditional().getOtherTicketDto();
    }

    public void setOtherTicketDto(List<FitSdpOtherTicketDto> otherTicketDto) {
        if (getAdditional() != null) {
            getAdditional().setOtherTicketDto(otherTicketDto);
        }
    }

    public FitSdpRoomDiff getRoomDiff() {
        if (getAdditional() == null) {
            return null;
        }
        return getAdditional().getRoomDiff();
    }

    public void setRoomDiffPrice(FitSdpRoomDiff roomDiff) {
        if (getAdditional() != null) {
            getAdditional().setRoomDiff(roomDiff);
        }
    }
    
    public Map<String, List<FitSdpOtherTicketDto>> getOtherTicketMaps() {
        return otherTicketMaps;
    } 

    public List<FlightSearchFlightInfoDto> getSumDepFlightInfos() {
		return sumDepFlightInfos;
	}

	public void setSumDepFlightInfos(
			List<FlightSearchFlightInfoDto> sumDepFlightInfos) {
		this.sumDepFlightInfos = sumDepFlightInfos;
	}

	public List<FlightSearchFlightInfoDto> getSumArvFlightInfos() {
		return sumArvFlightInfos;
	}

	public void setSumArvFlightInfos(
			List<FlightSearchFlightInfoDto> sumArvFlightInfos) {
		this.sumArvFlightInfos = sumArvFlightInfos;
	}

	public List<FlightSearchFlightInfoDto> getDepFlightInfos() {
        List<FlightSearchFlightInfoDto> flightInfos = fitSdpGoodsDto.getDepFlightInfos();
        if (flightInfos != null) {
            for (FlightSearchFlightInfoDto flightInfo : flightInfos) {
                String weekOfDate = DateUtils.getWeekOfDate(DateUtils.parseDate(flightInfo.getDepartureDate(), "yyyy-MM-dd"));
                flightInfo.setWeekOfDate(weekOfDate);
            }
        }
        return flightInfos;
    }

    public void setDepFlightInfos(List<FlightSearchFlightInfoDto> depFlightInfos) {
        fitSdpGoodsDto.setDepFlightInfos(depFlightInfos);
    }

    public List<FlightSearchFlightInfoDto> getArvFlightInfos() {
        List<FlightSearchFlightInfoDto> flightInfos = fitSdpGoodsDto.getArvFlightInfos();
        if (flightInfos != null) {
            for (FlightSearchFlightInfoDto flightInfo : flightInfos) {
                String weekOfDate = DateUtils.getWeekOfDate(DateUtils.parseDate(flightInfo.getDepartureDate(), "yyyy-MM-dd"));
                flightInfo.setWeekOfDate(weekOfDate);
            }
        }
        return flightInfos;
    }

    public void setArvFlightInfos(List<FlightSearchFlightInfoDto> arvFlightInfos) { 
        fitSdpGoodsDto.setArvFlightInfos(arvFlightInfos);
    }
    
    // 构造其他票产品
    public Map<String, List<FitSdpOtherTicketDto>> genTicketProduct(List<FitSdpOtherTicketDto> otherTickets) {
        Map<String, List<FitSdpOtherTicketDto>> maps = new HashMap<String, List<FitSdpOtherTicketDto>>();
        for (FitSdpOtherTicketDto ticket : otherTickets) {
            String productId = ticket.getProductId().toString();
            if (!maps.containsKey(productId)) {
                maps.put(productId, new ArrayList<FitSdpOtherTicketDto>());
            }
            List<FitSdpOtherTicketDto> list = maps.get(productId);
            list.add(ticket);
        }
        return maps;
    }
    // 构造保险产品
    public Map<String, List<FitSdpInsuranceDto>> genInsuranceProduct(List<FitSdpInsuranceDto> insurances) {
        Map<String, List<FitSdpInsuranceDto>> maps = new HashMap<String, List<FitSdpInsuranceDto>>();
        for (FitSdpInsuranceDto insurance : insurances) {
            String productId = insurance.getProductId().toString();
            if (!maps.containsKey(productId)) {
                maps.put(productId, new ArrayList<FitSdpInsuranceDto>());
            }
            List<FitSdpInsuranceDto> list = maps.get(productId);
            list.add(insurance);
        }
        return maps;
    }
    // 处理酒店差价
    public List<FitSdpHotelComboGoodsDto> setDiffPriceOfHotelCombo(List<FitSdpHotelComboGoodsDto> hotelCombos) {
        BigDecimal iniPrice = null;
        for (FitSdpHotelComboGoodsDto hotelCombo : hotelCombos) {
            if (hotelCombo.getIsBeSelected().equals(JudgeType.Y.name())) {
                iniPrice = hotelCombo.getPrice();
            }
        }
        for (FitSdpHotelComboGoodsDto hotelCombo : hotelCombos) {
            hotelCombo.setDiffPrice(hotelCombo.getPrice().subtract(iniPrice));
        }
        return hotelCombos;
    }
    
    /**
     * 设置一个酒店分组里面的全部的酒店差价.
     * @param group
     */
    private void setDiffPriceInAGroup(FitSdpHotelGroupDto group){
    	BigDecimal iniPrice = null;
    	//得到全部分组下面的酒店
    	LinkedList<FitSdpHotelDto> hotels =group.getHotels();
    	for(FitSdpHotelDto _hotel:hotels){
    		if("Y".equals(_hotel.getIsBeSelected())){
    			LinkedList<FitSdpHotelRoomtypeDto>  rooms = _hotel.getFangXinList();
    			for(FitSdpHotelRoomtypeDto _room:rooms){
    				if("Y".equals(_room.getIsBeSelected())){
    					iniPrice = _room.getPrice().multiply(new BigDecimal(_room.getRoomCount()));
    					break;
    				}
    			}
    		} 
    	}
    	for(FitSdpHotelDto _hotel:hotels){
    		LinkedList<FitSdpHotelRoomtypeDto>  rooms = _hotel.getFangXinList();
    		for(FitSdpHotelRoomtypeDto _room:rooms){
    			_room.setDiffPrice(_room.getPrice().multiply(new BigDecimal(_room.getRoomCount())).subtract(iniPrice));
			}
    	}
    }
    
    // 处理酒店（非套餐）参加
    public List<FitSdpHotelGroupDto> setDiffPriceOfHotelGroup(List<FitSdpHotelGroupDto> hotelGroups) {
    	//按照分组来各个组的处理价差.
        for (FitSdpHotelGroupDto group : hotelGroups) {
        	setDiffPriceInAGroup(group);
        } 
        return hotelGroups;
    }
    
    public SolrFacetFields getTimeSegmentsFilter(SolrFacetFields depTimeSegments) {
        List<SolrFacetField> fields = depTimeSegments.getFields();
        Collections.sort(fields, new Comparator<SolrFacetField>() {
            @Override
            public int compare(SolrFacetField o1, SolrFacetField o2) {
                int temp1 = 0;
                int temp2 = 0;
                if (o1.getFieldValue().equals("NOON")) {
                    temp1 = 1;
                }
                if (o1.getFieldValue().equals("NIGHT")) {
                    temp1 = 2;
                }
                if (o2.getFieldValue().equals("NOON")) {
                    temp2 = 1;
                }
                if (o2.getFieldValue().equals("NIGHT")) {
                    temp2 = 2;
                }
                return temp1 - temp2;
            }});
        return depTimeSegments;
    }
    
    public SolrFacetFields getSeatClassCodeFilter(SolrFacetFields seatClassCodes) {
        List<SolrFacetField> fields = seatClassCodes.getFields();
        Collections.sort(fields, new Comparator<SolrFacetField>() {
            @Override
            public int compare(SolrFacetField o1, SolrFacetField o2) {
                int temp1 = 0;
                int temp2 = 0;
                if(o1==null)
                	return -1;
                if (o1.getFieldValue().equals("C")) {
                    temp1 = 1;
                }
                if (o1.getFieldValue().equals("F")) {
                    temp1 = 2;
                }
                if (o2.getFieldValue().equals("C")) {
                    temp2 = 1;
                }
                if (o2.getFieldValue().equals("F")) {
                    temp2 = 2;
                }
                return temp1 - temp2;
            }});
        return seatClassCodes;
    }
}
