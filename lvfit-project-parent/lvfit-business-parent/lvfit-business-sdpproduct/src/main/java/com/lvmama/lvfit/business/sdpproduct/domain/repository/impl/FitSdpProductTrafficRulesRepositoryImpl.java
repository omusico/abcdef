package com.lvmama.lvfit.business.sdpproduct.domain.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lvmama.lvfit.business.sdpproduct.domain.FitSdpProductTrafficRules;
import com.lvmama.lvfit.business.sdpproduct.domain.repository.FitSdpProductTrafficRulesRepository;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpProductTrafficRulesDto;
import com.lvmama.lvfit.persistence.mybatis.mapper.FitSdpProductTrafficRulesMapper;

@Repository
public class FitSdpProductTrafficRulesRepositoryImpl implements FitSdpProductTrafficRulesRepository {
	
	@Autowired
	private FitSdpProductTrafficRulesMapper fitSdpProductTrafficRulesMapper;
	
	@Override
	public FitSdpProductTrafficRulesDto load(Long id) {
		return fitSdpProductTrafficRulesMapper.getById(id);
	}

	@Override
	public FitSdpProductTrafficRules load(FitSdpProductTrafficRulesDto r) {
		return new FitSdpProductTrafficRules(r);
	}

	@Override
	public int delete(Long id) {
		return fitSdpProductTrafficRulesMapper.deleteById(id);
	}

	@Override
	public FitSdpProductTrafficRulesDto save(FitSdpProductTrafficRulesDto r) {
		if(r.getId()== null){
			fitSdpProductTrafficRulesMapper.insert(r);
		}else{
			fitSdpProductTrafficRulesMapper.updateById(r.getId(), r);
		}
		return r;
	}

	@Override
	public List<FitSdpProductTrafficRulesDto> queryByFkId(Long fkId) {
		return fitSdpProductTrafficRulesMapper.queryByFkId(fkId);
	}

	@Override
	public int deleteByFkId(Long fkId) {
		return fitSdpProductTrafficRulesMapper.deleteByFkId(fkId);
	}

}
