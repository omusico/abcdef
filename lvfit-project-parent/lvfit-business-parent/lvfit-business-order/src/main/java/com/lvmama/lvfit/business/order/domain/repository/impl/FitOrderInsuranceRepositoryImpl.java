package com.lvmama.lvfit.business.order.domain.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lvmama.lvfit.business.order.domain.FitOrderInsurance;
import com.lvmama.lvfit.business.order.domain.repository.FitOrderInsuranceRepository;
import com.lvmama.lvfit.common.dto.order.FitOrderInsuranceDto;
import com.lvmama.lvfit.persistence.mybatis.mapper.FitOrderInsuranceMapper;

/**
 * @author qihuisong
 */
@Repository
public class FitOrderInsuranceRepositoryImpl implements FitOrderInsuranceRepository {

	@Autowired
	private FitOrderInsuranceMapper fitOrderInsuranceMapper;
	
	@Override
	public FitOrderInsuranceDto load(Long id) {
		return fitOrderInsuranceMapper.getById(id);
	}

	@Override
	public FitOrderInsurance load(FitOrderInsuranceDto r) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public FitOrderInsuranceDto save(FitOrderInsuranceDto r) {
		if(null == r.getId()){
			fitOrderInsuranceMapper.insert(r);
		} else {
			fitOrderInsuranceMapper.updateById(r.getId(), r);
		}
		return r;
	}

   
}
