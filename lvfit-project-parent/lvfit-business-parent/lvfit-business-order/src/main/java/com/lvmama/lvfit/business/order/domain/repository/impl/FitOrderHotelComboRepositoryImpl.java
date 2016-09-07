package com.lvmama.lvfit.business.order.domain.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lvmama.lvfit.business.order.domain.FitOrderHotelCombo;
import com.lvmama.lvfit.business.order.domain.repository.FitOrderHotelComboRepository;
import com.lvmama.lvfit.common.dto.order.FitOrderHotelComboDto;
import com.lvmama.lvfit.persistence.mybatis.mapper.FitOrderHotelComboMapper;

@Repository
public class FitOrderHotelComboRepositoryImpl implements FitOrderHotelComboRepository{
	
	@Autowired
	private FitOrderHotelComboMapper  fitOrderHotelComboMapper;

	@Override
	public FitOrderHotelComboDto load(Long id) {
		return fitOrderHotelComboMapper.getById(id);
	}

	@Override
	public FitOrderHotelCombo load(FitOrderHotelComboDto r) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public FitOrderHotelComboDto save(FitOrderHotelComboDto r) {
		
	   if (null == r.getId()) {
		    fitOrderHotelComboMapper.insert(r);
        }else {
        	fitOrderHotelComboMapper.updateById(r.getId(), r);
        }
        return r;
        
	}

	
}
