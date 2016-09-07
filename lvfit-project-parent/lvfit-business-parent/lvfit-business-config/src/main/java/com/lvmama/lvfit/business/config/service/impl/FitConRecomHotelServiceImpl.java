package com.lvmama.lvfit.business.config.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.PathParam;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lvmama.lvf.common.dto.BaseQueryDto;
import com.lvmama.lvf.common.dto.BaseSingleResultDto;
import com.lvmama.lvf.common.utils.DateUtils;
import com.lvmama.lvfit.business.config.service.FitConRecomHotelService;
import com.lvmama.lvfit.common.dto.enums.SymbolType;
import com.lvmama.lvfit.common.dto.enums.VSTDistrictCityEnum;
import com.lvmama.lvfit.common.dto.hotel.FitConRecomHotelDto;
import com.lvmama.lvfit.common.dto.hotel.FitConRecomHotelRequestForm;
import com.lvmama.lvfit.persistence.mybatis.mapper.FitConRecomHotelMapper;

/**
 * @author lutianyu
 * @date   2016年1月6日
 */
@Service
@Transactional
public class FitConRecomHotelServiceImpl implements FitConRecomHotelService{
	
	private static Logger logger = Logger.getLogger(FitConRecomHotelServiceImpl.class);
//	@Autowired
//	FitConRecomHotelRepository fitConRecomHotelRepository;
	
	@Autowired
	private FitConRecomHotelMapper fitConRecomHotelMapper;
	
	@Override
	public List<FitConRecomHotelDto> getFitConRecomHotels(BaseQueryDto<FitConRecomHotelDto> baseQueryDto) {
		FitConRecomHotelDto recomHotelDto = new FitConRecomHotelDto();
		//BaseQueryDto<FitConRecomHotelDto> baseQueryDto = new BaseQueryDto<FitConRecomHotelDto>(recomHotelDto);
		List<FitConRecomHotelDto> recomHotels =fitConRecomHotelMapper.query(baseQueryDto);
		logger.info("数据库加载到推荐酒店的数量："+recomHotels.size());
		return recomHotels;
	}

	@Override
	public void importAllRecomHotel(FitConRecomHotelRequestForm fitConRecomHotelRequestForm) {
		List<FitConRecomHotelDto> fitConRecomHotelDtos = fitConRecomHotelRequestForm.getFitConRecomHotelDtos();
		for (FitConRecomHotelDto fchd : fitConRecomHotelDtos) {
			
			FitConRecomHotelDto recomHotelDto = new FitConRecomHotelDto();
			recomHotelDto.setProductId(fchd.getProductId());
			BaseQueryDto<FitConRecomHotelDto> baseQueryDto = new BaseQueryDto<FitConRecomHotelDto>(recomHotelDto);
			List<FitConRecomHotelDto> query = fitConRecomHotelMapper.query(baseQueryDto);
			if(CollectionUtils.isEmpty(query)){
				Long districtCityId = VSTDistrictCityEnum.getDistrictIdByCnName(fchd.getCityName());
				fchd.setDistrictCityId(districtCityId);
				fchd.setIsDefault(SymbolType.N);
				fchd.setCreateTime(new Date(System.currentTimeMillis()));
				fchd.setUpdateTime(fchd.getCreateTime());
				fitConRecomHotelMapper.insert(fchd);
			}
		}
		//fitConRecomHotelMapper.insertBatch(fitConRecomHotelRequestForm.getFitConRecomHotelDtos());
	}

	@Override
	public Integer count(BaseQueryDto<FitConRecomHotelDto> baseQueryDto) {
		int count = fitConRecomHotelMapper.count(baseQueryDto);
		return count;
	}

	@Override
	public Boolean saveRecomHotel(FitConRecomHotelDto dto) {
		Boolean flag = false;
		if(dto != null){
			int insert = 0;
			if(StringUtils.isNotBlank(dto.getProductId())){
				FitConRecomHotelDto recomHotelDto = new FitConRecomHotelDto();
				recomHotelDto.setProductId(dto.getProductId());
				BaseQueryDto<FitConRecomHotelDto> baseQueryDto = new BaseQueryDto<FitConRecomHotelDto>(recomHotelDto);
				List<FitConRecomHotelDto> query = fitConRecomHotelMapper.query(baseQueryDto);
				if(CollectionUtils.isEmpty(query)){
					flag = true;
					Long districtCityId = VSTDistrictCityEnum.getDistrictIdByCnName(dto.getCityName());
					dto.setDistrictCityId(districtCityId);
					dto.setIsDefault(SymbolType.N);
					dto.setCreateTime(new Date(System.currentTimeMillis()));
					dto.setUpdateTime(dto.getCreateTime());
					insert = fitConRecomHotelMapper.insert(dto);
					logger.info("数据库新增的推荐酒店数量："+insert);
				}
			}
			
		}
		return flag;
	}
	@Override
	public Boolean updateRecomHotel(FitConRecomHotelDto dto) {
		Boolean flag = false;
	
		FitConRecomHotelDto recomHotelDto = new FitConRecomHotelDto();
		recomHotelDto.setProductId(dto.getProductId());
		BaseQueryDto<FitConRecomHotelDto> baseQueryDto = new BaseQueryDto<FitConRecomHotelDto>(recomHotelDto);
		List<FitConRecomHotelDto> query = fitConRecomHotelMapper.query(baseQueryDto);
	
		if(CollectionUtils.isEmpty(query) || dto.getId().equals(query.get(0).getId())){
			flag = true;
			dto.setUpdateTime(new Date(System.currentTimeMillis()));
			fitConRecomHotelMapper.updateById(dto.getId(), dto);
		}
//		else{
//			if(dto.getId().equals(query.get(0).getId())){
//				flag = true;
//				dto.setUpdateTime(new Date(System.currentTimeMillis()));
//				fitConRecomHotelMapper.updateById(dto.getId(), dto);
//			}
//		}
	
		return flag;
	}


	@Override
	public FitConRecomHotelDto getRecomHotel(Long id) {
		return fitConRecomHotelMapper.getById(id);
	}

	@Override
	public Boolean deleteRecomHotel(Long id) {
		Boolean flag = false;
		try {
			fitConRecomHotelMapper.deleteById(id);
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	@Override
	public List<FitConRecomHotelDto> getAllRecomHotel(){
		FitConRecomHotelDto fitConRecomHotelDto = new FitConRecomHotelDto();
		BaseQueryDto<FitConRecomHotelDto> q = new BaseQueryDto<FitConRecomHotelDto>(fitConRecomHotelDto);
		List<FitConRecomHotelDto> list = fitConRecomHotelMapper.query(q);
		return list;
	}

	@Override
	public BaseSingleResultDto<Integer> setDefaultHotel(Long id,Long districtCityId) {
		BaseSingleResultDto<Integer> baseSingleResult = new BaseSingleResultDto<Integer>();
		//将选中的酒店设置为默认推荐的酒店
		Date updateTime = new Date(System.currentTimeMillis());
		Map<String,Object> updateMap = new HashMap<String,Object>();
		updateMap.put("id", id);
		updateMap.put("districtCityId", districtCityId);
		updateMap.put("updateTime", updateTime);
		fitConRecomHotelMapper.setDefaultHotel(updateMap);
		//并将其它和选中酒店一样城市行政id的酒店设为非默认推荐的酒店
		fitConRecomHotelMapper.setOtherNotDefault(updateMap);
		baseSingleResult.setMessage("设置默认配置酒店成功");
		return baseSingleResult;
	}
}
