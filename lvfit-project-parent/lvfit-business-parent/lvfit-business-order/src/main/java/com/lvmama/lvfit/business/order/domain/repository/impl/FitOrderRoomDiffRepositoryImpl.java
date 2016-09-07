package com.lvmama.lvfit.business.order.domain.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lvmama.lvfit.business.order.domain.FitOrderRoomDiff;
import com.lvmama.lvfit.business.order.domain.repository.FitOrderRoomDiffRepository;
import com.lvmama.lvfit.common.dto.order.FitOrderRoomDiffDto;
import com.lvmama.lvfit.persistence.mybatis.mapper.FitOrderRoomDiffMapper;

@Repository
public class FitOrderRoomDiffRepositoryImpl implements FitOrderRoomDiffRepository{
	
	@Autowired
	private FitOrderRoomDiffMapper fitOrderRoomDiffMapper;

	@Override
	public FitOrderRoomDiffDto load(Long id) {
		return fitOrderRoomDiffMapper.getById(id);
	}

	@Override
	public FitOrderRoomDiff load(FitOrderRoomDiffDto r) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public FitOrderRoomDiffDto save(FitOrderRoomDiffDto r) {
		if (null == r.getId()) {
			fitOrderRoomDiffMapper.insert(r);
	        }else {
	        	fitOrderRoomDiffMapper.updateById(r.getId(), r);
	        }
	        return r;
	}

	@Override
	public List<FitOrderRoomDiffDto> getByOrderMainId(Long fkId) {
		return fitOrderRoomDiffMapper.queryByFkId(fkId);
	}

}
