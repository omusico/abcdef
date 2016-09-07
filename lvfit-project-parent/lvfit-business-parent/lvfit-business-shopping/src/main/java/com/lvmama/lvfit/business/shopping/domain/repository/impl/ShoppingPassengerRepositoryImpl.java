package com.lvmama.lvfit.business.shopping.domain.repository.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lvmama.lvfit.business.shopping.domain.ShoppingPassenger;
import com.lvmama.lvfit.business.shopping.domain.repository.ShoppingPassengerRepository;
import com.lvmama.lvfit.common.dto.shopping.ShoppingPassengerDto;
import com.lvmama.lvfit.persistence.mybatis.mapper.ShopingPassengerMapper;

@Repository
public class ShoppingPassengerRepositoryImpl implements ShoppingPassengerRepository{

	@Autowired
	private ShopingPassengerMapper  shopingPassengerMapper;

	@Override
	public int deletesUpdate(List<ShoppingPassengerDto> list) {
		if(list!=null && list.size()>0){
			shopingPassengerMapper.deleteByCode(list.get(0).getShoppingUuid());
		}
		for (ShoppingPassengerDto dto : list) {
			dto.setCreateTime(new Date());
			dto.setUpdateTime(new Date());
			shopingPassengerMapper.insert(dto);      
		}		
		return 0;
	}
	@Override
	public ShoppingPassengerDto load(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ShoppingPassenger load(ShoppingPassengerDto r) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int delete(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public ShoppingPassengerDto save(ShoppingPassengerDto r) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<ShoppingPassengerDto> getListByCode(String code) {
		return shopingPassengerMapper.getListByCode(code);
	}
	@Override
	public List<ShoppingPassengerDto> getAllByShoppinguuid(String shoppingUuId) {
		return shopingPassengerMapper.getAllByShoppinguuid(shoppingUuId);
	}
	

	

}
