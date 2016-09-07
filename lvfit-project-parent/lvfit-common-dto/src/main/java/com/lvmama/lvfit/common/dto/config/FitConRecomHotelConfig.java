package com.lvmama.lvfit.common.dto.config;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import com.lvmama.lvfit.common.dto.hotel.FitConRecomHotelDto;

/**
 * @author lutianyu
 * @date   2016年1月5日
 */
public class FitConRecomHotelConfig {
	/**用于存放来自数据库的转化后的数据*/
    public static LinkedHashMap<Long, List<FitConRecomHotelDto>> dbMaps = new LinkedHashMap<Long, List<FitConRecomHotelDto>>();
    
    public static void putDbMaps(List<FitConRecomHotelDto> fitConRecomHotelDtos){
    	if(!dbMaps.isEmpty()){
    		dbMaps.clear();
    	}
    	if(CollectionUtils.isNotEmpty(fitConRecomHotelDtos)){
    		for (FitConRecomHotelDto fitConRecomHotelDto : fitConRecomHotelDtos) {
    			
    			if(FitConRecomHotelConfig.dbMaps.get(fitConRecomHotelDto.getDistrictCityId()) == null 
    					|| FitConRecomHotelConfig.dbMaps.get(fitConRecomHotelDto.getDistrictCityId()).size() == 0){
    				List<FitConRecomHotelDto> hotelList = new ArrayList<FitConRecomHotelDto>();
        			hotelList.add(fitConRecomHotelDto);
        			FitConRecomHotelConfig.dbMaps.put(fitConRecomHotelDto.getDistrictCityId(), hotelList);
    			}else{
    				List<FitConRecomHotelDto> hotelList = FitConRecomHotelConfig.dbMaps.get(fitConRecomHotelDto.getDistrictCityId());
    				hotelList.add(fitConRecomHotelDto);
    			}
			}
    	}
    }

}
