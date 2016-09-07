package com.lvmama.lvfit.business.sdpproduct.domain.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lvmama.lvfit.business.sdpproduct.domain.FitSdpProductSearchIndexDomain;
import com.lvmama.lvfit.business.sdpproduct.domain.repository.FitSdpProductSearchIndexRepository;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpProductSearchIndex;
import com.lvmama.lvfit.persistence.mybatis.mapper.FitSdpProductSearchIndexMapper;

@Repository
public class FitSdpProductSearchIndexRepositoryImpl implements FitSdpProductSearchIndexRepository {
	
	@Autowired
	private FitSdpProductSearchIndexMapper fitSdpProductSearchIndexMapper;
	
	@Override
	public FitSdpProductSearchIndex load(Long id) {
		return fitSdpProductSearchIndexMapper.getById(id);
	}

	@Override
	public FitSdpProductSearchIndexDomain load(FitSdpProductSearchIndex r) {
		return new FitSdpProductSearchIndexDomain(r);
	}

	@Override
	public int delete(Long id) {
		return fitSdpProductSearchIndexMapper.deleteById(id);
	}

	@Override
	public FitSdpProductSearchIndex save(FitSdpProductSearchIndex r) {
		if(r.getId()== null){
			fitSdpProductSearchIndexMapper.insert(r);
		}else{
			fitSdpProductSearchIndexMapper.updateById(r.getId(), r);
		}
		return r;
	}

	@Override
	public List<FitSdpProductSearchIndex> queryByFkId(Long fkId) {
		return fitSdpProductSearchIndexMapper.queryByFkId(fkId);
	}

	@Override
	public int deleteByFkId(Long fkId) {
		return fitSdpProductSearchIndexMapper.deleteByFkId(fkId);
	}

	@Override
	public List<FitSdpProductSearchIndex> queryIndexInfoList(Long productId) {
		return fitSdpProductSearchIndexMapper.getInfoList(productId);
	}

}
