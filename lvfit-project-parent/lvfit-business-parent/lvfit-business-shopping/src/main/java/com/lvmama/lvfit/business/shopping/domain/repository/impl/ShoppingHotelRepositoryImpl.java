package com.lvmama.lvfit.business.shopping.domain.repository.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import com.lvmama.lvfit.business.shopping.domain.ShoppingHotel;
import com.lvmama.lvfit.business.shopping.domain.repository.ShoppingHotelRepository;
import com.lvmama.lvfit.common.dto.shopping.ShoppingHotelDto;
import com.lvmama.lvfit.persistence.mybatis.mapper.ShopingHotelMapper;

@Repository
public class ShoppingHotelRepositoryImpl implements ShoppingHotelRepository{

	@Autowired
	private ShopingHotelMapper  ShopingHotelMapper;
	
	@Override
	public ShoppingHotelDto load(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ShoppingHotel load(ShoppingHotelDto r) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int delete(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public ShoppingHotelDto save(ShoppingHotelDto dto) {
		/*List<ShoppingHotelDto> beans = ShopingHotelMapper.getListByCode(dto.getShoppingUuid());
		if (!CollectionUtils.isEmpty(beans)) {
			Boolean updateFlag = false;
			for (ShoppingHotelDto shoppingHotelDto : beans) {
				if (shoppingHotelDto.getHotelId().equals(dto.getHotelId())) {
					updateFlag = true;
					dto.setUpdateTime(new Date());
					ShopingHotelMapper.updateByCode(dto.getShoppingUuid(), dto);
				}
			}
			if (!updateFlag) {
				dto.setCreateTime(new Date());
				ShopingHotelMapper.insert(dto);
			}
		} else {
			dto.setCreateTime(new Date());
			ShopingHotelMapper.insert(dto);
		}*/
		
		dto.setCreateTime(new Date());
		ShopingHotelMapper.insert(dto);
		return dto;
	}
	@Override
	public List<ShoppingHotelDto> getListByCode(String code) {
		return ShopingHotelMapper.getListByCode(code);
	}
	@Override
	public List<ShoppingHotelDto> getAllByShoppinguuid(String shoppingUuId) {
		return ShopingHotelMapper.getAllByShoppinguuid(shoppingUuId);
	}
	
	
}
