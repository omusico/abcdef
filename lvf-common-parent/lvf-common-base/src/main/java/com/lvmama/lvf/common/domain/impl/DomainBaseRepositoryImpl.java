package com.lvmama.lvf.common.domain.impl;

import com.lvmama.lvf.common.domain.Domain;
import com.lvmama.lvf.common.domain.DomainBaseRepository;
import com.lvmama.lvf.common.domain.DomainEntityBaseMapper;
import com.lvmama.lvf.common.dto.BaseQueryDto;
import com.lvmama.lvf.common.dto.Dto;

/**
 * 持久层共通Repository
 * 
 * @author mashengwen
 * @date 2015-2-3
 */
public abstract class DomainBaseRepositoryImpl<D extends Domain<R>, R extends Dto>
		implements DomainBaseRepository<D, R> {

	protected abstract DomainEntityBaseMapper<R, BaseQueryDto<? extends Dto>> getBaseMapper();

	@Override
	public R load(Long id) {
		if(null==getBaseMapper()||null==id){
			return null;
		}
		R r = getBaseMapper().getById(id);
		return r;
	}

	@Override
	public int delete(Long id) {
		if(null==getBaseMapper()||null==id){
			return 0;
		}
		return getBaseMapper().deleteById(id);
	}

	@Override
	public R save(R r) {
		if (null == r || null==getBaseMapper()) {
			return null;
		}
		Long id = r.getId();
		if (null == id) {
			getBaseMapper().insert(r);
		} else {
			getBaseMapper().updateById(id, r);
		}
		return r;
	}

}
