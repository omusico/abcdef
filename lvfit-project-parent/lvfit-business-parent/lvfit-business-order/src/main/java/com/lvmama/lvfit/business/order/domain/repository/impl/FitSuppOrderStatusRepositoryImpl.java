package com.lvmama.lvfit.business.order.domain.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lvmama.lvfit.business.order.domain.FitSuppOrderStatus;
import com.lvmama.lvfit.business.order.domain.repository.FitSuppOrderStatusRepository;
import com.lvmama.lvfit.common.dto.order.FitSuppOrderStatusDto;
import com.lvmama.lvfit.persistence.mybatis.mapper.FitSuppOrderStatusMapper;


/**
 * 供应商订单Repository实现
 * @author leizhengwei
 *
 */
@Repository
public class FitSuppOrderStatusRepositoryImpl implements FitSuppOrderStatusRepository {

	
	@Autowired
	private FitSuppOrderStatusMapper fitSuppOrderStatusMapper;

	@Override
	public FitSuppOrderStatusDto load(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FitSuppOrderStatus load(FitSuppOrderStatusDto r) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public FitSuppOrderStatusDto save(FitSuppOrderStatusDto r) {
		if (null == r.getId()) {
			fitSuppOrderStatusMapper.insert(r);
        }else {
        	fitSuppOrderStatusMapper.updateById(r.getId(), r);
        }
		return r;
	}

	@Override
	public List<FitSuppOrderStatusDto> queryByFkId(Long fkId) {
		return fitSuppOrderStatusMapper.queryByFkId(fkId);
	}

	@Override
	public int deleteByFkId(Long fkId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public FitSuppOrderStatusDto updateByVstOrderNo(FitSuppOrderStatusDto r) {

		fitSuppOrderStatusMapper.updateByVstOrderNo(r.getVstOrderNo(), r);
		return r;
	}

	@Override
	public FitSuppOrderStatusDto getByVstOrderNo(Long vstOrderNo) {
		
		return fitSuppOrderStatusMapper.getByVstOrderNo(vstOrderNo);
	}
	
 

}
