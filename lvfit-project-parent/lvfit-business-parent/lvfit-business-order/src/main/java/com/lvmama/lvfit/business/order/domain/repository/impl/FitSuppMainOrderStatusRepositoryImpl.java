package com.lvmama.lvfit.business.order.domain.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lvmama.lvfit.business.order.domain.FitSuppMainOrderStatus;
import com.lvmama.lvfit.business.order.domain.repository.FitSuppMainOrderStatusRepository;
import com.lvmama.lvfit.common.dto.order.FitSuppMainOrderStatusDto;
import com.lvmama.lvfit.persistence.mybatis.mapper.FitSuppMainOrderStatusMapper;


/**
 * 供应商主订单Repository实现
 * @author leizhengwei
 *
 */
@Repository
public class FitSuppMainOrderStatusRepositoryImpl implements FitSuppMainOrderStatusRepository {

	
	@Autowired
	private FitSuppMainOrderStatusMapper fitSuppMainOrderStatusMapper;
	
	@Override
	public FitSuppMainOrderStatusDto load(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FitSuppMainOrderStatus load(FitSuppMainOrderStatusDto r) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public FitSuppMainOrderStatusDto save(FitSuppMainOrderStatusDto r) {
		if (null == r.getId()) {
			fitSuppMainOrderStatusMapper.insert(r);
        }else {
        	fitSuppMainOrderStatusMapper.updateById(r.getId(), r);
        }
		return r;
	}

	@Override
	public List<FitSuppMainOrderStatusDto> queryByFkId(Long fkId) {
		return fitSuppMainOrderStatusMapper.queryByFkId(fkId);
	}

	@Override
	public int deleteByFkId(Long fkId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public FitSuppMainOrderStatusDto updateByVstMainOrderNo(FitSuppMainOrderStatusDto r) {
		 fitSuppMainOrderStatusMapper.updateByVstOrderMainNo(r.getVstMainOrderNo(),r);
		 return r;
	}

	@Override
	public List<FitSuppMainOrderStatusDto> queryNeedToSync() {
		return fitSuppMainOrderStatusMapper.queryNeedToSync();
	}

}
