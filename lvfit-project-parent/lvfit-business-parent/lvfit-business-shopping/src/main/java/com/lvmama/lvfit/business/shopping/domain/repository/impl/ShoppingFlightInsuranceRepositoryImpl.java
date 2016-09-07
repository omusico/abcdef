package com.lvmama.lvfit.business.shopping.domain.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lvmama.lvfit.business.shopping.domain.ShoppingFlightInsurance;
import com.lvmama.lvfit.business.shopping.domain.repository.ShoppingFlightInsuranceRepository;
import com.lvmama.lvfit.common.dto.shopping.FlightInsuranceDto;
import com.lvmama.lvfit.persistence.mybatis.mapper.ShoppingFlightInsuranceMapper;
@Repository
public class ShoppingFlightInsuranceRepositoryImpl implements ShoppingFlightInsuranceRepository{

	@Autowired
	private ShoppingFlightInsuranceMapper shoppingFlightInsuranceMapper;
	@Override
	public int delete(Long id) {
		shoppingFlightInsuranceMapper.deleteById(id);
		return 0;
	}

	@Override
	public FlightInsuranceDto load(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ShoppingFlightInsurance load(FlightInsuranceDto flightInsuranceDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FlightInsuranceDto save(FlightInsuranceDto flightInsuranceDto) {
		shoppingFlightInsuranceMapper.insert(flightInsuranceDto);
		return flightInsuranceDto;
	}

	@Override
	public List<FlightInsuranceDto> getListByCode(String code) {
		return shoppingFlightInsuranceMapper.getListByCode(code);
	}

	@Override
	public List<FlightInsuranceDto> getLatestListByCode(String code) {
		return shoppingFlightInsuranceMapper.getLatestListByCode(code);
	}

}
