package com.lvmama.lvf.common.domain;

import java.util.List;

import com.lvmama.lvf.common.dto.Dto;

public interface DomainByFkIdListRepository<R extends Dto> {

	public List<R> queryByFkIdList(List<Long> fkIds);
	
	public int deleteByFkIdList(List<Long> fkIds);

}
