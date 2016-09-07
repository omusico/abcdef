package com.lvmama.lvfit.business.config.service;

import java.util.List;

import com.lvmama.lvf.common.dto.BaseQueryDto;
import com.lvmama.lvf.common.dto.BaseSingleResultDto;
import com.lvmama.lvfit.common.dto.hotel.FitConRecomHotelDto;
import com.lvmama.lvfit.common.dto.hotel.FitConRecomHotelRequestForm;

/**
 * @author lutianyu
 * @date   2016年1月6日
 */
public interface FitConRecomHotelService {
	/**
	 * 查询所有的推荐酒店数据
	 * @param fitConRecomHotelDto
	 * @return
	 */
	List<FitConRecomHotelDto> getFitConRecomHotels(BaseQueryDto<FitConRecomHotelDto> baseQueryDto);
	
	public void importAllRecomHotel(FitConRecomHotelRequestForm fitConRecomHotelRequestForm);
	
	public Integer count(BaseQueryDto<FitConRecomHotelDto> baseQueryDto);

	public Boolean saveRecomHotel(FitConRecomHotelDto dto);

	public Boolean updateRecomHotel(FitConRecomHotelDto dto);

	public FitConRecomHotelDto getRecomHotel(Long id);

	public Boolean deleteRecomHotel(Long id);

	public List<FitConRecomHotelDto> getAllRecomHotel();

	
	public BaseSingleResultDto<Integer> setDefaultHotel(Long id, Long districtCityId); 
	
}
