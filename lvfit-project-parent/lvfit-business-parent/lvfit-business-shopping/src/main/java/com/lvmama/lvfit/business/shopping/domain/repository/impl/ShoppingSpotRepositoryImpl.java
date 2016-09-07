package com.lvmama.lvfit.business.shopping.domain.repository.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lvmama.lvfit.business.shopping.domain.ShoppingSpotTicket;
import com.lvmama.lvfit.business.shopping.domain.repository.ShoppingSpotRepository;
import com.lvmama.lvfit.common.dto.shopping.ShoppingSpotTicketDto;
import com.lvmama.lvfit.persistence.mybatis.mapper.ShoppingSpotTicketMapper;

@Repository
public class ShoppingSpotRepositoryImpl implements ShoppingSpotRepository{

	@Autowired
	private ShoppingSpotTicketMapper   shoppingSpotMapper;
	
	@Override
	public ShoppingSpotTicketDto load(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ShoppingSpotTicket load(ShoppingSpotTicketDto r) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int delete(Long id) {
		// TODO Auto-generated method stub
		shoppingSpotMapper.deleteById(id);
		return 0;
	}
	@Override
	public ShoppingSpotTicketDto save(ShoppingSpotTicketDto dto) {
		shoppingSpotMapper.insert(dto);
		return dto;
	}
	@Override
	public List<ShoppingSpotTicketDto> getListByCode(String code) {
		return shoppingSpotMapper.getListByCode(code);
	}
	@Override
	public List<ShoppingSpotTicketDto> getLatestListByCode(String code) {
		// TODO Auto-generated method stub
		return shoppingSpotMapper.getLatestListByCode(code);
	}
	
	
}
