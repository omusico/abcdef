package com.lvmama.lvf.common.domain;

import java.util.List;

import com.lvmama.lvf.common.dto.Dto;

public interface DomainByFkIdRepository<R extends Dto>  {

	public List<R> queryByFkId(Long fkId);
	
	public int deleteByFkId(Long fkId);

}
