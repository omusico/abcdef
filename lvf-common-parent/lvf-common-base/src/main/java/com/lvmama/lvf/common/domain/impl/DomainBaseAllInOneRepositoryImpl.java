package com.lvmama.lvf.common.domain.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.lvmama.lvf.common.domain.Domain;
import com.lvmama.lvf.common.domain.DomainBatchRepository;
import com.lvmama.lvf.common.domain.DomainByCodeRepository;
import com.lvmama.lvf.common.domain.DomainByFkIdRepository;
import com.lvmama.lvf.common.domain.DomainByFkIdsRepository;
import com.lvmama.lvf.common.domain.DomainByNoRepository;
import com.lvmama.lvf.common.domain.DomainEntityBatchMapper;
import com.lvmama.lvf.common.domain.DomainEntityByCodeMapper;
import com.lvmama.lvf.common.domain.DomainEntityByFkIdMapper;
import com.lvmama.lvf.common.domain.DomainEntityByFkIdsMapper;
import com.lvmama.lvf.common.domain.DomainEntityByNoMapper;
import com.lvmama.lvf.common.domain.DomainQueryRepository;
import com.lvmama.lvf.common.dto.BaseQueryDto;
import com.lvmama.lvf.common.dto.Dto;

/**
 * 持久层共通Repository
 * 
 * @author mashengwen
 * @date 2015-2-3
 */
public abstract class DomainBaseAllInOneRepositoryImpl<D extends Domain<R>, R extends Dto, Q extends BaseQueryDto<? extends Dto>>
		extends DomainBaseRepositoryImpl<D, R> implements
		DomainByCodeRepository<R>, DomainByNoRepository<R>,
		DomainByFkIdRepository<R>, DomainByFkIdsRepository<R>,
		DomainQueryRepository<R, Q>, DomainBatchRepository<R,Q> {

	protected abstract DomainEntityByNoMapper<R> getByNoMapper();

	protected abstract DomainEntityByCodeMapper<R> getByCodeMapper();

	protected abstract DomainEntityByFkIdsMapper<R> getByFkIdsMapper();

	protected abstract DomainEntityByFkIdMapper<R> getByFkIdMapper();

	protected abstract DomainEntityBatchMapper<R, Q> getBatchMapper();

	@Override
	public int insertBatch(List<R> i) {
		if (null == getBatchMapper() || null == i || i.size() == 0) {
			return 0;
		}
		return getBatchMapper().insertBatch(i);
	}

	@Override
	public int deleteBatchByQuery(Q q) {
		if (null == getBatchMapper() || null == q) {
			return 0;
		}
		return getBatchMapper().deleteBatchByQuery(q);
	}

	@Override
	public int updateBatchByQuery(Q q, R i) {
		if (null == getBatchMapper() || null == q || null == i) {
			return 0;
		}
		return getBatchMapper().updateBatchByQuery(q,i);
	}

	@Override
	public List<R> query(Q q) {
		if (null == getBaseMapper() || null == q) {
			return new ArrayList<R>();
		}
		return getBaseMapper().query(q);
	}

	@Override
	public int count(Q q) {
		if (null == getBaseMapper() || null == q) {
			return 0;
		}
		return getBaseMapper().count(q);
	}

	@Override
	public List<R> queryByFkIds(Long... fkId) {
		return queryByFkIds(false, fkId);
	}

	public List<R> queryByFkIds(Boolean load, Long... fkId) {
		if (null == getByFkIdsMapper() || null == fkId) {
			return new ArrayList<R>();
		}
		List<R> rs = getByFkIdsMapper().queryByFkIds(fkId);
		List<R> rss = load(load, rs);
		return rss;
	}

	private List<R> load(Boolean load, List<R> rs) {
		if (null == load || null == rs || rs.size() == 0 || !load) {
			return rs;
		}
		List<R> rss = new ArrayList<R>();
		for (R r : rs) {
			R rLoad = load(load, r);
			rss.add(rLoad);
		}
		return rss;
	}

	@Override
	public int deleteByFkIds(Long... fkId) {
		if (null == getByFkIdsMapper() || null == fkId) {
			return 0;
		}
		return getByFkIdsMapper().deleteByFkIds(fkId);
	}

	@Override
	public List<R> queryByFkId(Long fkId) {
		return queryByFkId(false, fkId);
	}

	public List<R> queryByFkId(boolean load, Long fkId) {
		if (null == getByFkIdMapper() || null == fkId) {
			return new ArrayList<R>();
		}
		List<R> rs = getByFkIdMapper().queryByFkId(fkId);
		List<R> rss = load(load, rs);
		return rss;
	}

	@Override
	public int deleteByFkId(Long fkId) {
		if (null == getByFkIdMapper() || null == fkId) {
			return 0;
		}
		return getByFkIdMapper().deleteByFkId(fkId);
	}

	@Override
	public R loadByNo(String no) {
		return loadByNo(false, no);
	}

	public R loadByNo(Boolean load, String no) {
		if (null == getByNoMapper() || StringUtils.isEmpty(no)) {
			return null;
		}
		R r = getByNoMapper().getByNo(no);
		return load(load, r);
	}

	@Override
	public R loadByCode(String code) {
		return loadByCode(false, code);
	}

	public R loadByCode(Boolean load, String code) {
		if (null == getByCodeMapper() || StringUtils.isEmpty(code)) {
			return null;
		}
		R r = getByCodeMapper().getByCode(code);
		return load(load, r);
	}

	private R load(Boolean load, R r) {
		if (null == r || !load) {
			return r;
		}
		return load(r.getId());
	}

}
