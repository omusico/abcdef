package com.lvmama.lvfit.business.order.domain.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lvmama.lvfit.business.order.domain.FitOrderLocalTripProduct;
import com.lvmama.lvfit.business.order.domain.repository.FitOrderLocalTripProductRepository;
import com.lvmama.lvfit.common.dto.order.FitOrderLocalTripProductDto;
import com.lvmama.lvfit.persistence.mybatis.mapper.FitOrderLocalTripProductMapper;

@Repository
public class FitOrderLocalTripProductRepositoryImpl implements FitOrderLocalTripProductRepository{
	
	@Autowired
	private FitOrderLocalTripProductMapper fitOrderLocalTripProductMapper;

	@Override
	public FitOrderLocalTripProductDto load(Long id) {
		return fitOrderLocalTripProductMapper.getById(id);
	}

	@Override
	public FitOrderLocalTripProduct load(FitOrderLocalTripProductDto r) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public FitOrderLocalTripProductDto save(FitOrderLocalTripProductDto r) {
		    if (null == r.getId()) {
			  fitOrderLocalTripProductMapper.insert(r);
	        }else {
	        	fitOrderLocalTripProductMapper.updateById(r.getId(), r);
	        }
	        return r;
	}

	
}
