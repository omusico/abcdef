package com.lvmama.lvf.common.domain;

import java.util.List;

import com.lvmama.lvf.common.dto.Dto;

public interface DomainByFkIdsRepository<R extends Dto> {

	public List<R> queryByFkIds(Long... fkId);
	
	public int deleteByFkIds(Long... fkId);

}
