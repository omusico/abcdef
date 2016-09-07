package com.lvmama.lvfit.business.shopping.domain.repository.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lvmama.lvfit.business.shopping.domain.ShoppingInsurance;
import com.lvmama.lvfit.business.shopping.domain.ShoppingSpotTicket;
import com.lvmama.lvfit.business.shopping.domain.repository.ShoppingInsuranceRepository;
import com.lvmama.lvfit.business.shopping.domain.repository.ShoppingSpotRepository;
import com.lvmama.lvfit.common.dto.shopping.ShoppingInsuranceDto;
import com.lvmama.lvfit.common.dto.shopping.ShoppingSpotTicketDto;
import com.lvmama.lvfit.persistence.mybatis.mapper.ShoppingInsuranceMapper;
import com.lvmama.lvfit.persistence.mybatis.mapper.ShoppingSpotTicketMapper;

@Repository
public class ShoppingInsuranceRepositoryImpl implements ShoppingInsuranceRepository{

	@Autowired
	private ShoppingInsuranceMapper   shoppingInsuranceMapper;
	
	@Override
	public ShoppingInsuranceDto load(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ShoppingInsurance load(ShoppingInsuranceDto r) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int delete(Long id) {
		// TODO Auto-generated method stub
		shoppingInsuranceMapper.deleteById(id);
		return 0;
	}
	@Override
	public ShoppingInsuranceDto save(ShoppingInsuranceDto dto) {
		shoppingInsuranceMapper.insert(dto);
		return dto;
	}
	@Override
	public List<ShoppingInsuranceDto> getListByCode(String code) {
		return shoppingInsuranceMapper.getListByCode(code);
	}
	@Override
	public List<ShoppingInsuranceDto> getLatestListByCode(String code) {
		// TODO Auto-generated method stub
		return shoppingInsuranceMapper.getLatestListByCode(code);
	}
	
	
}
