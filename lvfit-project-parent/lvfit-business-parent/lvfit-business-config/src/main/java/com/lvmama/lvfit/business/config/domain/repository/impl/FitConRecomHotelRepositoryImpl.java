package com.lvmama.lvfit.business.config.domain.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.lvmama.lvfit.business.config.domain.FitConRecomHotel;
import com.lvmama.lvfit.business.config.repository.FitConRecomHotelRepository;
import com.lvmama.lvfit.common.dto.hotel.FitConRecomHotelDto;
import com.lvmama.lvfit.persistence.mybatis.mapper.FitConRecomHotelMapper;

/**
 * @author lutianyu
 * @date   2016年1月6日
 */
public class FitConRecomHotelRepositoryImpl implements FitConRecomHotelRepository {
	@Autowired
	private FitConRecomHotelMapper fitConRecomHotelMapper;
	
	@Override
	public FitConRecomHotelDto load(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FitConRecomHotel load(FitConRecomHotelDto r) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public FitConRecomHotelDto save(FitConRecomHotelDto r) {
		// TODO Auto-generated method stub
		return null;
	}

}
