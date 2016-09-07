package com.lvmama.lvfit.business.shopping.domain.repository.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import com.lvmama.lvfit.business.shopping.domain.ShoppingFlight;
import com.lvmama.lvfit.business.shopping.domain.repository.ShoppingFlightRepository;
import com.lvmama.lvfit.common.dto.shopping.ShoppingFlightDto;
import com.lvmama.lvfit.persistence.mybatis.mapper.ShopingFlightMapper;

@Repository
public class ShoppingFlightRepositoryImpl implements ShoppingFlightRepository{

	@Autowired
	private ShopingFlightMapper  shopingFlightMapper;
	@Override
	public ShoppingFlightDto load(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ShoppingFlight load(ShoppingFlightDto r) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int delete(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public ShoppingFlightDto save(ShoppingFlightDto dto) {
		/*List<ShoppingFlightDto> beans =shopingFlightMapper.getListByCode(dto.getShoppingUuid());
		if(!CollectionUtils.isEmpty(beans)){
			Boolean updateFlag = false;
			for(ShoppingFlightDto shoppingFlightDto:beans){
				if(shoppingFlightDto.getFlightNo().equals(dto.getFlightNo())){
					updateFlag = true;
					dto.setUpdateTime(new Date());
					shopingFlightMapper.updateByCode(dto.getShoppingUuid(), dto);
				}
			}
			if(!updateFlag){
				dto.setCreateTime(new Date());
				shopingFlightMapper.insert(dto);
			}		
		}else{
			dto.setCreateTime(new Date());
			shopingFlightMapper.insert(dto);
		}*/
		dto.setCreateTime(new Date());
		shopingFlightMapper.insert(dto);
		return dto;
	}
	@Override
	public List<ShoppingFlightDto> getListByCode(String code) {
		return shopingFlightMapper.getListByCode(code);
	}
	@Override
	public List<ShoppingFlightDto> getAllByShoppinguuid(String shoppingUuId) {
		return shopingFlightMapper.getAllByShoppinguuid(shoppingUuId);
	}
	

	

	

}
