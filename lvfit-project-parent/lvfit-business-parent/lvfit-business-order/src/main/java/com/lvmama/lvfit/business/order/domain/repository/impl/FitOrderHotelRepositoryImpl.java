package com.lvmama.lvfit.business.order.domain.repository.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lvmama.lvfit.business.order.domain.FitOrderHotel;
import com.lvmama.lvfit.business.order.domain.repository.FitOrderHotelRepository;
import com.lvmama.lvfit.common.dto.order.FitOrderHotelDto;
import com.lvmama.lvfit.persistence.mybatis.mapper.FitOrderHotelMapper;

@Repository
public class FitOrderHotelRepositoryImpl implements FitOrderHotelRepository {

    @Autowired
    private FitOrderHotelMapper fitOrderHotelMapper;

    @Override
    public FitOrderHotelDto load(Long id) {
        return fitOrderHotelMapper.getById(id);
    }

    @Override
    public FitOrderHotel load(FitOrderHotelDto fitOrderHotelDto) {
        return null;
    }

    @Override
    public int delete(Long id) {
        return 0;
    }

    @Override
    public FitOrderHotelDto save(FitOrderHotelDto fitOrderHotelDto) {
        if (null == fitOrderHotelDto.getId()) {
            fitOrderHotelMapper.insert(fitOrderHotelDto);
        }else {
            fitOrderHotelMapper.updateById(fitOrderHotelDto.getId(), fitOrderHotelDto);
        }
        return fitOrderHotelDto;
    }

	@Override
	public List<FitOrderHotelDto> getByPlanIdAndCheckIn(String planId, Date checkin) {
		return fitOrderHotelMapper.getByPlanIdAndCheckIn(planId, checkin);
	}

}
