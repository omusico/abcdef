package com.lvmama.lvfit.business.order.domain.repository.impl;

import java.util.Collections;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lvmama.lvfit.business.order.domain.FitSuppFlightOrderDetail;
import com.lvmama.lvfit.business.order.domain.repository.FitOrderPassengerRepository;
import com.lvmama.lvfit.business.order.domain.repository.FitSuppFlightOrderDetailRepository;
import com.lvmama.lvfit.common.dto.order.FitSuppFlightOrderDetailDto;
import com.lvmama.lvfit.common.dto.order.FitSuppMainOrderDto;
import com.lvmama.lvfit.persistence.mybatis.mapper.FitOrderPassengerMapper;
import com.lvmama.lvfit.persistence.mybatis.mapper.FitSuppFlightOrderDetailMapper;

@Repository
public class FitSuppFlightOrderDetailRepositoryImpl implements FitSuppFlightOrderDetailRepository {
	
	@Autowired
	private FitSuppFlightOrderDetailMapper fitSuppFlightOrderDetailMapper;
	

	@Autowired
	private FitOrderPassengerRepository fitOrderPassengerRepository;

	@Override
	public FitSuppFlightOrderDetailDto load(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FitSuppFlightOrderDetail load(FitSuppFlightOrderDetailDto r) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public FitSuppFlightOrderDetailDto save(FitSuppFlightOrderDetailDto r) {
		
	    if (null == r.getId()) {
		    fitSuppFlightOrderDetailMapper.insert(r);
        }else {
        	fitSuppFlightOrderDetailMapper.updateById(r.getId(), r);
        }
        return r;
	}

	@Override
	public List<FitSuppFlightOrderDetailDto> queryByFkId(Long fkId) {
		List<FitSuppFlightOrderDetailDto> fitSuppFlightOrderDetailDtos = fitSuppFlightOrderDetailMapper.queryByFkId(fkId);
		if(CollectionUtils.isNotEmpty(fitSuppFlightOrderDetailDtos)){
			for (FitSuppFlightOrderDetailDto suppFlightOrderDetailDto : fitSuppFlightOrderDetailDtos) {
				if(suppFlightOrderDetailDto.getFitOrderPassenger()!=null){
					suppFlightOrderDetailDto.setFitOrderPassenger(fitOrderPassengerRepository.load(suppFlightOrderDetailDto.getFitOrderPassenger().getId()));
				}
			}
		}
		return fitSuppFlightOrderDetailDtos;
	}

	@Override
	public int deleteByFkId(Long fkId) {
		// TODO Auto-generated method stub
		return 0;
	}

}
