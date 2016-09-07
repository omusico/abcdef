package com.lvmama.lvfit.business.order.domain.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lvmama.lvfit.business.order.domain.FitOrderFlightInsurance;
import com.lvmama.lvfit.business.order.domain.repository.FitOrderFlightInsuranceRepository;
import com.lvmama.lvfit.common.dto.order.FitOrderFliInsuranceDto;
import com.lvmama.lvfit.persistence.mybatis.mapper.FitOrderFliInsuranceMapper;

@Repository
public class FitOrderFlightInsuranceRepositoryImpl implements FitOrderFlightInsuranceRepository{

	@Autowired
	private FitOrderFliInsuranceMapper fitOrderFliInsuranceMapper;
	
	@Override
	public int delete(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public FitOrderFliInsuranceDto load(Long id) {
		return fitOrderFliInsuranceMapper.getById(id);
	}

	@Override
	public FitOrderFlightInsurance load(FitOrderFliInsuranceDto dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FitOrderFliInsuranceDto save(FitOrderFliInsuranceDto dto) {
		if(null == dto.getId()){
			fitOrderFliInsuranceMapper.insert(dto);
		} else {
			fitOrderFliInsuranceMapper.updateById(dto.getId(), dto);
		}
		return dto;
	}

	@Override
	public List<FitOrderFliInsuranceDto> getByOrderMainId(Long id) {
		return fitOrderFliInsuranceMapper.getByOrderMainId(id);
	}

}
