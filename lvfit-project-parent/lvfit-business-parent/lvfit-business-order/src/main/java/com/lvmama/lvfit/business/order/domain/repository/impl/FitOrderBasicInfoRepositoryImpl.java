package com.lvmama.lvfit.business.order.domain.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lvmama.lvfit.business.order.domain.FitOrderBasicInfo;
import com.lvmama.lvfit.business.order.domain.repository.FitOrderBasicInfoRepository;
import com.lvmama.lvfit.common.dto.order.FitOrderBasicInfoDto;
import com.lvmama.lvfit.persistence.mybatis.mapper.FitOrderBasicInfoMapper;

@Repository
public class FitOrderBasicInfoRepositoryImpl implements FitOrderBasicInfoRepository{

	@Autowired
	private FitOrderBasicInfoMapper  fitOrderBasicInfoMapper;
	
	@Override
	public FitOrderBasicInfoDto load(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FitOrderBasicInfo load(FitOrderBasicInfoDto r) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public FitOrderBasicInfoDto save(FitOrderBasicInfoDto r) {
		 if (null == r.getId()) {
			 fitOrderBasicInfoMapper.insert(r);
	        }else {
	        	fitOrderBasicInfoMapper.updateById(r.getId(), r);
	        }
	        return r;
	}

	@Override
	public List<FitOrderBasicInfoDto> getByOrderMainId(Long id) {
		return fitOrderBasicInfoMapper.getByOrderMainId(id);
	}

}
