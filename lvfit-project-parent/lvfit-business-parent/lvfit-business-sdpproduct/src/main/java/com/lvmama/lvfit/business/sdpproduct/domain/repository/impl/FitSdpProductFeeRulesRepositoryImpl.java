package com.lvmama.lvfit.business.sdpproduct.domain.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lvmama.lvfit.business.sdpproduct.domain.FitSdpProductFeeRules;
import com.lvmama.lvfit.business.sdpproduct.domain.repository.FitSdpProductFeeRulesRepository;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpProductFeeRulesDto;
import com.lvmama.lvfit.persistence.mybatis.mapper.FitSdpProductFeeRulesMapper;

@Repository
public class FitSdpProductFeeRulesRepositoryImpl implements FitSdpProductFeeRulesRepository {
	
	@Autowired
	private FitSdpProductFeeRulesMapper fitSdpProductFeeRulesMapper;
	
	@Override
	public FitSdpProductFeeRulesDto load(Long id) {
		return fitSdpProductFeeRulesMapper.getById(id);
	}

	@Override
	public FitSdpProductFeeRules load(FitSdpProductFeeRulesDto r) {
		return new FitSdpProductFeeRules(r);
	}

	@Override
	public int delete(Long id) {
		return fitSdpProductFeeRulesMapper.deleteById(id);
	}

	@Override
	public FitSdpProductFeeRulesDto save(FitSdpProductFeeRulesDto r) {
		if(r.getId()== null){
			fitSdpProductFeeRulesMapper.insert(r);
		}else{
			fitSdpProductFeeRulesMapper.updateById(r.getId(), r);
		}
		return r;
	}

	@Override
	public List<FitSdpProductFeeRulesDto> queryByFkId(Long fkId) {
		return fitSdpProductFeeRulesMapper.queryByFkId(fkId);
	}

	@Override
	public int deleteByFkId(Long fkId) {
		return fitSdpProductFeeRulesMapper.deleteByFkId(fkId);
	}

}
